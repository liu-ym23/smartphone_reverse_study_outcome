package xka;

import android.content.ContentValues;
import android.database.Cursor;
import com.obric.miniapp.alarm.AccountType;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g implements vka.b<Boolean> {
    public static final /* synthetic */ int d = 0;
    public final String a;
    public final Long b;
    public final Long c;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r0 = vka.f.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        Long r2 = this.b;
        if (r2 == null) goto L6;
        long r3 = r2.longValue();
    L5:
        long r14 = r3;
        Long r4 = this.c;
        if (r4 == null) goto L30;
        long r5 = r4.longValue();
        int r9 = 1;
    L51:
        ContentValues r6 = new ContentValues();
        r6.put("calendar_id", Long.valueOf(r5));
        ala.b r7 = new ala.b(null, "anonymous");
        String[] r8 = new String[r9];
        r8[0] = String.valueOf(r14);
        int r10 = r0.update(r7, r6, "calendar_id = ?", r8);
        com.bytedance.ai.utils.g r11 = com.bytedance.ai.utils.g.a;
        r11.d("MergeCalendarOp", "merge events: affected " + r10 + " rows");
        r11.d("MergeCalendarOp", "delete calendar: affected " + r0.delete(new ala.a(Long.valueOf(r14), "anonymous"), null, null) + " rows");
        return Boolean.TRUE;
    L30:
        r9 = 1;
        Cursor r12 = r0.query(new ala.a(null, 3), new String[]{"_id"}, "name = ? AND account_type = ?", new String[]{this.a, AccountType.LOCAL}, null);
        if (r12 == null) goto L48;
        Cursor r13 = r12;
        Cursor r15 = r13;     // Catch: Throwable -> L42
        if (r15.moveToFirst() == true) goto L36;
    L40:
        Long r16 = null;
    L41:
        CloseableKt.closeFinally(r13, null);
    L49:
        if (r16 == null) goto L64;
        r5 = r16.longValue();
        goto L51
    L64:
        return Boolean.FALSE;
    L36:
        if (r15.isNull(0) == true) goto L40;
        r16 = Long.valueOf(r15.getLong(0));     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    L48:
        r16 = null;
        goto L49
    L6:
        Cursor r17 = r0.query(new ala.a(null, 3), new String[]{"_id"}, "name = ? AND account_name = ? AND account_type = ?", new String[]{"anonymous", "anonymous", AccountType.LOCAL}, null);
        if (r17 == null) goto L24;
        Cursor r18 = r17;
        Cursor r19 = r18;     // Catch: Throwable -> L18
        if (r19.moveToFirst() == true) goto L12;
    L16:
        Long r20 = null;
    L17:
        CloseableKt.closeFinally(r18, null);
    L25:
        if (r20 == null) goto L54;
        r3 = r20.longValue();
        goto L5
    L54:
        return Boolean.FALSE;
    L12:
        if (r19.isNull(0) == true) goto L16;
        r20 = Long.valueOf(r19.getLong(0));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r18, th);
        throw th;
    L24:
        r20 = null;
        goto L25
    }

    public g(String r2, Long r3, Long r4) {
        Intrinsics.checkNotNullParameter(r2, "accountName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
