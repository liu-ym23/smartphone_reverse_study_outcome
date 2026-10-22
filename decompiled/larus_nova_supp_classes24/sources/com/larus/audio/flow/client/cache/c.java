package com.larus.audio.flow.client.cache;

import com.larus.audio.utils.o0;
import com.larus.audio.utils.q0;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.OutputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements com.larus.audio.flow.client.cache.a {
    public final int a;
    public final Lazy b;
    public BufferedOutputStream c;
    public OutputStream d;
    public final int e;

    public static final class a {
    }

    static {
    }

    public final void d() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L10
        BufferedOutputStream r1 = this.c;     // Catch: Throwable -> L10
        if (r1 == null) goto L5;
        r1.close();     // Catch: Throwable -> L10
    L5:
        this.c = null;     // Catch: Throwable -> L10
        OutputStream r2 = this.d;     // Catch: Throwable -> L10
        if (r2 == null) goto L8;
        r2.close();     // Catch: Throwable -> L10
    L8:
        this.d = null;     // Catch: Throwable -> L10
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public c(int r1) {
        this.a = r1;
        this.b = LazyKt.lazy(new b(this));
        this.e = 8192;
    }

    @Override // com.larus.audio.flow.client.cache.a
    public final void c(String r6) {
        Intrinsics.checkNotNullParameter(r6, "key");
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        int r1 = c68.b.a;
        c68.b.d("LRUTtsCache", "prepareSave key: ".concat(r6));
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L15
        o0 r3 = (o0) this.b.getValue();     // Catch: Throwable -> L15
        if (r3 == null) goto L12;
        OutputStream r4 = r3.d(r6).b();     // Catch: Throwable -> L15
        this.d = r4;     // Catch: Throwable -> L15
        this.c = new BufferedOutputStream(r4, this.e);     // Catch: Throwable -> L15
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Object r7 = Result.constructor-impl(r5);     // Catch: Throwable -> L15
    L17:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L23;
        delete(r6);
        d();
        int r9 = c68.b.a;
        c68.b.c("LRUTtsCache", "prepareSave key: " + r6 + " error: ", r8);
        return;
    L23:
        return;
    L12:
        r5 = null;
    L15:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.audio.flow.client.cache.a
    public final boolean contains(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L17
        o0 r1 = (o0) this.b.getValue();     // Catch: Throwable -> L17
        boolean r2 = false;
        if (r1 == null) goto L16;
        monitor-enter(r1);     // Catch: Throwable -> L17
        r1.b();     // Catch: Throwable -> L13
        o0.p(r4);     // Catch: Throwable -> L13
        o0.d r5 = r1.k.get(r4);     // Catch: Throwable -> L13
        if (r5 == null) goto L11;
        if (r5.c == false) goto L11;
        r2 = true;
        goto L11
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L17
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L16:
        return r2;
    L17:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Object r6 = Result.constructor-impl(ResultKt.createFailure(th));
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r6) == false) goto L22;
        r6 = r7;
    L22:
        return ((Boolean) r6).booleanValue();
    }

    @Override // com.larus.audio.flow.client.cache.a
    public void delete(String r4) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        o0 r1 = (o0) this.b.getValue();     // Catch: Throwable -> L16
        if (r1 == null) goto L13;
        r1.d(r4).a();     // Catch: Throwable -> L16
        r1.k(r4);     // Catch: Throwable -> L16
        monitor-enter(r1);     // Catch: Throwable -> L16
        r1.b();     // Catch: Throwable -> L10
        r1.n();     // Catch: Throwable -> L10
        r1.m();     // Catch: Throwable -> L10
        r1.j.flush();     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L16
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        Object r3 = Result.constructor-impl(r2);     // Catch: Throwable -> L16
    L18:
        Throwable r5 = Result.exceptionOrNull-impl(r3);
        if (r5 == null) goto L25;
        int r6 = c68.b.a;
        c68.b.c("LRUTtsCache", "deleteByKey key: " + r4 + " error: ", r5);
        return;
    L25:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L13:
        r2 = null;
    L16:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    }

    @Override // com.larus.audio.flow.client.cache.a
    public final void a(String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "key");
        if (r9.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        int r1 = c68.b.a;
        c68.b.d("LRUTtsCache", "endSave key: " + r9 + ", success: " + r10);
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L28
        if (r10 == false) goto L25;
        o0 r3 = (o0) this.b.getValue();     // Catch: Throwable -> L28
        if (r3 == null) goto L24;
        o0.c r6 = r3.d(r9);     // Catch: Throwable -> L28
        if (r6.c == false) goto L16;
        o0.a(r6.d, r6, false);     // Catch: Throwable -> L28
        r6.d.k(r6.a.a);     // Catch: Throwable -> L28
    L17:
        monitor-enter(r3);     // Catch: Throwable -> L28
        r3.b();     // Catch: Throwable -> L21
        r3.n();     // Catch: Throwable -> L21
        r3.m();     // Catch: Throwable -> L21
        r3.j.flush();     // Catch: Throwable -> L21
        monitor-exit(r3);     // Catch: Throwable -> L28
        goto L24
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L16:
        o0.a(r6.d, r6, true);     // Catch: Throwable -> L28
    L24:
        d();     // Catch: Throwable -> L28
    L26:
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L37;
        delete(r9);
        d();
        int r7 = c68.b.a;
        c68.b.c("LRUTtsCache", "endSave key: " + r9 + ", success: " + r10 + " error: ", r5);
        return;
    L37:
        return;
    L25:
        delete(r9);     // Catch: Throwable -> L28
        d();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.larus.audio.flow.client.cache.a
    public final void b(String r7, byte[] r8) {
        Intrinsics.checkNotNullParameter(r7, "key");
        Intrinsics.checkNotNullParameter(r8, "ttsContent");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L24
        boolean r4 = true;
        int r5 = 0;
        if (r7.length() != 0) goto L6;
        boolean r6 = true;
    L7:
        if (r6 == false) goto L9;
        return;
    L9:
        if (r8.length == 0) goto L12;
        r4 = false;
    L12:
        if (r4 == true) goto L35;
        int r9 = c68.b.a;     // Catch: Throwable -> L24
        c68.b.d("LRUTtsCache", "save key: " + r7 + ", ttsContent size: " + r8.length);     // Catch: Throwable -> L24
    L16:
        if (r5 >= r8.length) goto L21;
        int r10 = Math.min(this.e, r8.length - r5);     // Catch: Throwable -> L24
        BufferedOutputStream r11 = this.c;     // Catch: Throwable -> L24
        if (r11 == null) goto L20;
        r11.write(r8, r5, r10);     // Catch: Throwable -> L24
    L20:
        r5 = r5 + r10;     // Catch: Throwable -> L24
        goto L16
    L21:
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L36;
        delete(r7);
        d();
        int r14 = c68.b.a;
        c68.b.c("LRUTtsCache", "save key: " + r7 + ", ttsContent size: " + r8.length + " error: ", r13);
        return;
    L36:
        return;
    L35:
        return;
    L6:
        r6 = false;
    L24:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }

    @Override // com.larus.audio.flow.client.cache.a
    public Flow<byte[]> query(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        o0 r1 = (o0) this.b.getValue();     // Catch: Exception -> L12
        if (r1 == null) goto L14;
        o0.e r2 = r1.e(r4);     // Catch: Exception -> L12
        if (r2 == null) goto L14;
        File r3 = r2.b[0];     // Catch: Exception -> L12
        if (r3 == null) goto L14;
        return q0.a(r3, r5);
    L14:
        return null;
    L12:
        e = move-exception;
        int r6 = c68.b.a;
        c68.b.c("LRUTtsCache", "query key: " + r4 + " error: ", e);
        return null;
    }
}
