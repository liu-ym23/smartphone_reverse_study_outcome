package com.obric.assistant.cocreationreview.modules.searchqa;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.g5;
import com.obric.assistant.cocreationreview.h5;
import com.obric.assistant.cocreationreview.j;
import com.obric.assistant.cocreationreview.s3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q {
    public final j a;
    public final j b;
    public final LinkedHashSet<Function1<List<c0>, Unit>> c;
    public final List<Function0<Unit>> d;
    public boolean e;
    public g5 f;

    public final synchronized void d() {
        monitor-enter(this);
        Iterator r0 = ((ArrayList) this.d).iterator();     // Catch: Throwable -> L10
    L5:
        if (r0.hasNext() == false) goto L7;
        ((Function0) r0.next()).invoke();     // Catch: Throwable -> L10
        goto L5
    L7:
        ((ArrayList) this.d).clear();     // Catch: Throwable -> L10
        this.e = false;     // Catch: Throwable -> L10
        s3.b("search_qa.repository.observe", "stopStoreObservers");     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized void a() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.e == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        if (this.a == null) goto L12;
        Function1 r1 = new o(this);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r1, "listener");     // Catch: Throwable -> L17
        ((ArrayList) this.d).add(j.b.b(r1));     // Catch: Throwable -> L17
    L12:
        if (this.b == null) goto L14;
        Function1 r2 = new p(this);     // Catch: Throwable -> L17
        com.obric.assistant.cocreationreview.g r3 = j.b;     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r2, "listener");     // Catch: Throwable -> L17
        ((ArrayList) this.d).add(j.b.b(r2));     // Catch: Throwable -> L17
    L14:
        this.e = true;     // Catch: Throwable -> L17
        int r4 = s3.a;     // Catch: Throwable -> L17
        s3.b("search_qa.repository.observe", "startStoreObservers subscriptions=" + ((ArrayList) this.d).size());     // Catch: Throwable -> L17
        monitor-exit(this);
    }

    public q(Context r4) {
        j r0 = null;
        if (r4 == null) goto L7;
        Context r1 = r4.getApplicationContext();
        if (r1 == null) goto L7;
        j r2 = new j(r1);
    L8:
        this.a = r2;
        if (r4 == null) goto L13;
        Context r5 = r4.getApplicationContext();
        if (r5 == null) goto L13;
        r0 = new j(r5);
    L13:
        this.b = r0;
        this.c = new LinkedHashSet();
        this.d = new ArrayList();
        int r6 = g5.c;
        this.f = g5.a.a("repository_init");
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void b(String r8) {
        LinkedHashSet<Function1<List<c0>, Unit>> r0 = this.c;
        monitor-enter(r0);
        List r1 = CollectionsKt.toList(this.c);     // Catch: Throwable -> L28
        monitor-exit(r0);
        List<c0> r2 = c(this.f);
        int r3 = s3.a;
        StringBuilder r4 = new StringBuilder("changed reason=");
        r4.append(r8);
        r4.append(", listeners=");
        r4.append(r1.size());
        r4.append(", records=");
        r4.append(r2.size());
        r4.append(", feedback=");
        List<c0> r9 = r2;
        int r5 = 0;
        if ((r9 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r10 = r9.iterator();
        int r6 = 0;
    L13:
        if (r10.hasNext() == false) goto L22;
        if (((c0) r10.next()).l == null) goto L17;
        boolean r7 = true;
    L18:
        if (r7 == false) goto L13;
        r6 = r6 + 1;
        if (r6 >= 0) goto L13;
        CollectionsKt.throwCountOverflow();
        goto L13
    L17:
        r7 = false;
        goto L18
    L22:
        r5 = r6;
    L23:
        r4.append(r5);
        s3.b("search_qa.repository.observe", r4.toString());
        Iterator r11 = r1.iterator();
    L25:
        if (r11.hasNext() == false) goto L27;
        ((Function1) r11.next()).invoke(r2);
        goto L25
    L27:
        return;
    L9:
        if (r9.isEmpty() == false) goto L11;
    L28:
        th = move-exception;
        throw th;
    }

    public final List<c0> c(g5 r22) {
        Intrinsics.checkNotNullParameter(r22, "request");
        j r3 = this.a;
        Map<String, a5> r4 = null;
        if (r3 == null) goto L24;
        Intrinsics.checkNotNullParameter(r22, "request");
        SQLiteDatabase r5 = r3.a.getWritableDatabase();
        ArrayList r6 = new ArrayList();
        h5 r13 = g5.a(r22);
        Cursor r7 = r5.query("search_qa_data", null, "created_at >= ? AND created_at <= ?", new String[]{String.valueOf(r13.a), String.valueOf(r13.b)}, null, null, "created_at DESC, record_id ASC");
        Cursor r8 = r7;     // Catch: Throwable -> L18
    L8:
        if (r8.moveToNext() == false) goto L16;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r8);     // Catch: Throwable -> L11
        r6.add(k.b(r8));     // Catch: Throwable -> L11
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r2 = Result.exceptionOrNull-impl(r1);     // Catch: Throwable -> L18
        if (r2 == null) goto L8;
        int r9 = s3.a;     // Catch: Throwable -> L18
        s3.c("search_qa.database", "skip invalid row error=" + r2.getMessage());     // Catch: Throwable -> L18
        goto L8
    L11:
        th = move-exception;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L18
        r1 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L18
        goto L13
    L16:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r7, null);
        int r12 = s3.a;
        s3.b("search_qa.database", "query count=" + r6.size() + ", earliest=" + r13.a + ", latest=" + r13.b + ", reason=" + r22.b);
        List<c0> r14 = r6;
    L25:
        if (r14 != null) goto L28;
        r14 = CollectionsKt.emptyList();
    L28:
        if (r14.isEmpty() == true) goto L58;
        j r15 = this.b;
        if (r15 == null) goto L37;
        List<c0> r16 = r14;
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r18 = r16.iterator();
    L34:
        if (r18.hasNext() == false) goto L36;
        r17.add(((c0) r18.next()).a);
        goto L34
    L36:
        r4 = r15.a(CollectionsKt.toSet(r17), CollectionsKt.emptyList());
    L37:
        if (r4 != null) goto L39;
        r4 = MapsKt.emptyMap();
    L39:
        List<c0> r19 = r14;
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));
        Iterator r21 = r19.iterator();
    L41:
        if (r21.hasNext() == false) goto L44;
        c0 r23 = (c0) r21.next();
        a5 r110 = r4.get(r23.a);
        String r24 = r23.a;
        ModuleKey r25 = r23.b;
        long r26 = r23.c;
        String r111 = r23.d;
        String r112 = r23.e;
        String r113 = r23.f;
        String r114 = r23.g;
        String r115 = r23.h;
        String r27 = r23.i;
        List<s> r28 = r23.j;
        String r29 = r23.k;
        String r30 = r23.m;
        Intrinsics.checkNotNullParameter(r24, "id");
        Intrinsics.checkNotNullParameter(r25, "module");
        Intrinsics.checkNotNullParameter(r111, "answeredAt");
        Intrinsics.checkNotNullParameter(r112, "searchDomain");
        Intrinsics.checkNotNullParameter(r114, "userQuestion");
        Intrinsics.checkNotNullParameter(r115, "answerSummary");
        Intrinsics.checkNotNullParameter(r27, "answerText");
        Intrinsics.checkNotNullParameter(r28, "localReferences");
        Intrinsics.checkNotNullParameter(r30, "payload");
        r20.add(new c0(r24, r25, r26, r111, r112, r113, r114, r115, r27, r28, r29, r110, r30));
        r21 = r21;
        goto L41
    L44:
        return r20;
    L58:
        return r14;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L24:
        r14 = null;
        goto L25
    }
}
