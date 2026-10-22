package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j {
    public static final g b = null;
    public final h a;

    public static final class a {
    }

    static {
        b = new g("cocreation_feedback_data.db", "feedback.database.observe");
    }

    public j(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        h r0 = new h(r6.getApplicationContext());
        this.a = r0;
        long r1 = System.currentTimeMillis() - 172800000;
        int r7 = r0.getWritableDatabase().delete("feedback_data", "created_at < ?", new String[]{String.valueOf(r1)});
        int r2 = s3.a;
        s3.b("feedback.database", "deleteExpired reason=store_init, cutoff=" + r1 + ", deleted=" + r7);
        if (r7 <= 0) goto L6;
        b.a("feedback_expired:" + r7);
        return;
    }

    public final void b(a5 r13) {
        Intrinsics.checkNotNullParameter(r13, "feedback");
        boolean r1 = false;
        if (r13.b != null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        Long r6 = Long.valueOf(r13.f);
        if (r6.longValue() <= 0) goto L11;
        r1 = true;
    L11:
        String r10 = null;
        if (r1 == true) goto L15;
        r6 = null;
    L15:
        if (r6 == null) goto L17;
        long r5 = r6.longValue();
    L18:
        a5 r14 = a5.a(r13, null, null, null, r0, r5, null, SpeechEvent.SERVER_DOWNLINK_EVENT_ASR_INFO);
        this.a.getWritableDatabase().insertWithOnConflict("feedback_data", null, k.b(r14), 5);
        int r2 = s3.a;
        StringBuilder r3 = new StringBuilder("upsert recordId=");
        r3.append(r14.a);
        r3.append(", vote=");
        Vote r4 = r14.b;
        if (r4 == null) goto L21;
        r10 = r4.getRaw();
    L21:
        r3.append(r10);
        r3.append(", reasonCount=");
        r3.append(r14.c.size());
        r3.append(", createdAt=");
        r3.append(r14.f);
        s3.b("feedback.database", r3.toString());
        b.a("feedback_upsert:" + r14.a);
        return;
    L17:
        r5 = System.currentTimeMillis();
        goto L18
    L5:
        if ((!r13.c.isEmpty()) == false) goto L7;
        r0 = true;
        goto L8
    }

    public final Map<String, a5> a(Set<String> r24, List<a5> r25) {
        Intrinsics.checkNotNullParameter(r24, "recordIds");
        Intrinsics.checkNotNullParameter(r25, "seedFeedbacks");
        SQLiteDatabase r4 = this.a.getWritableDatabase();
        Intrinsics.checkNotNull(r4);
        if (r25.isEmpty() == true) goto L22;
        Cursor r3 = r4.rawQuery("SELECT COUNT(*) FROM feedback_data", new String[0]);
        Cursor r6 = r3;     // Catch: Throwable -> L48
        if (r6.moveToFirst() == false) goto L10;
        int r7 = r6.getInt(0);     // Catch: Throwable -> L48
    L11:
        CloseableKt.closeFinally(r3, null);
        if (r7 <= 0) goto L14;
        int r0 = s3.a;
        s3.a("feedback.database", "seed skipped existing=" + r7);
        goto L22
    L14:
        r4.beginTransaction();
        Iterator<T> r5 = r25.iterator();     // Catch: Throwable -> L45
    L17:
        if (r5.hasNext() == false) goto L19;
        r4.insertWithOnConflict("feedback_data", null, k.b((a5) r5.next()), 5);     // Catch: Throwable -> L45
        goto L17
    L19:
        r4.setTransactionSuccessful();     // Catch: Throwable -> L45
        int r8 = s3.a;     // Catch: Throwable -> L45
        s3.b("feedback.database", "seed inserted count=" + r25.size());     // Catch: Throwable -> L45
        r4.endTransaction();
    L45:
        th = move-exception;
        r4.endTransaction();
        throw th;
    L10:
        r7 = 0;
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    L22:
        if (r24.isEmpty() == true) goto L24;
        String r1 = CollectionsKt.joinToString$default(r24, ",", null, null, 0, null, new i(), 30, null);
        LinkedHashMap r9 = new LinkedHashMap();
        Cursor r10 = r4.query("feedback_data", null, "record_id IN (" + r1 + ')', (String[]) r24.toArray(new String[0]), null, null, "created_at DESC, record_id ASC");
        Cursor r11 = r10;     // Catch: Throwable -> L39
    L28:
        if (r11.moveToNext() == false) goto L36;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L31
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L31
        a5 r12 = k.c(r11);     // Catch: Throwable -> L31
        r9.put(r12.a, r12);     // Catch: Throwable -> L31
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r14 = Result.exceptionOrNull-impl(r13);     // Catch: Throwable -> L39
        if (r14 == null) goto L28;
        int r15 = s3.a;     // Catch: Throwable -> L39
        s3.c("feedback.database", "skip invalid row error=" + r14.getMessage());     // Catch: Throwable -> L39
        goto L28
    L31:
        th = move-exception;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L39
        r13 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L39
        goto L33
    L36:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L39
        CloseableKt.closeFinally(r10, null);
        int r18 = s3.a;
        s3.b("feedback.database", "query requested=" + r24.size() + ", hit=" + r9.size());
        return r9;
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        CloseableKt.closeFinally(r10, th);
        throw th;
    L24:
        return MapsKt.emptyMap();
    }
}
