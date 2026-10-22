package com.larus.bmhome.social.page.datasource;

import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LoadStateHolder<T, Key> {
    public final f<T, Key> a;
    public final a<T, Key> b;
    public final MutexImpl c;
    public volatile com.larus.bmhome.social.page.datasource.event.e d;

    public LoadStateHolder(f<T, Key> r2, a<T, Key> r3) {
        Intrinsics.checkNotNullParameter(r2, "dataSource");
        Intrinsics.checkNotNullParameter(r3, "config");
        this.a = r2;
        this.b = r3;
        r3.getClass();
        this.c = kotlinx.coroutines.sync.b.a();
    }

    public final Object a(com.larus.bmhome.social.page.datasource.event.e.a r6, Continuation<? super g<T, Key>> r7) {
        if ((r7 instanceof LoadStateHolder$checkLoad$1) == false) goto L7;
        LoadStateHolder$checkLoad$1 r0 = (LoadStateHolder$checkLoad$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L40;
        if (r3 != 1) goto L12;
        kotlinx.coroutines.sync.a r9 = (kotlinx.coroutines.sync.a) r0.L$1;
        com.larus.bmhome.social.page.datasource.event.e.a r4 = (com.larus.bmhome.social.page.datasource.event.e.a) r0.L$0;
        ResultKt.throwOnFailure(r8);
        kotlinx.coroutines.sync.a r10 = r9;
        r6 = r4;
    L51:
        Intrinsics.areEqual(r6, com.larus.bmhome.social.page.datasource.event.e.a.C0035a.a);     // Catch: Throwable -> L46
        int r11 = g.b;     // Catch: Throwable -> L46
        g.b r12 = new g.b(null);     // Catch: Throwable -> L46
        r10.unlock(null);
        return r12;
    L46:
        th = move-exception;
        r10.unlock(null);
        throw th;
    L12:
        if (r3 == 2) goto L17;
        if (r3 != 3) goto L16;
        kotlinx.coroutines.sync.a r13 = (kotlinx.coroutines.sync.a) r0.L$2;
        g r5 = (g) r0.L$1;
        com.larus.bmhome.social.page.datasource.event.e.a r14 = (com.larus.bmhome.social.page.datasource.event.e.a) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L49:
    L36:
        th = move-exception;
        r13.unlock(null);
        throw th;
    L22:
        if ((r5 instanceof g.d) == false) goto L31;
        if (Intrinsics.areEqual(r14, com.larus.bmhome.social.page.datasource.event.e.a.C0035a.a) == false) goto L26;
        ((g.d) r5).getClass();     // Catch: Throwable -> L36
    L28:
        if (Intrinsics.areEqual(this.d, r14) == false) goto L33;
        this.d = null;     // Catch: Throwable -> L36
    L33:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L36
        r13.unlock(null);
        return r5;
    L26:
        ((g.d) r5).getClass();     // Catch: Throwable -> L36
        goto L28
    L31:
        if ((r5 instanceof g.c) == false) goto L33;
        this.d = r14;     // Catch: Throwable -> L36
        goto L33
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        com.larus.bmhome.social.page.datasource.event.e.a r16 = (com.larus.bmhome.social.page.datasource.event.e.a) r0.L$0;
        ResultKt.throwOnFailure(r8);
        g r17 = (g) r8;
        kotlinx.coroutines.sync.a r18 = this.c;
        r0.L$0 = r16;
        r0.L$1 = r17;
        r0.L$2 = r18;
        r0.label = 3;
        if (r18.a(null, r0) != r2) goto L20;
        return r2;
    L20:
        r14 = r16;
        r5 = r17;
        r13 = r18;
        goto L49
    L40:
        ResultKt.throwOnFailure(r8);
        r10 = this.c;
        r0.L$0 = r6;
        r0.L$1 = r10;
        r0.label = 1;
        if (r10.a(null, r0) != r2) goto L51;
        return r2;
    L7:
        r0 = new LoadStateHolder$checkLoad$1(this, r7);
        goto L8
    }

    public final Object b(boolean r10, Continuation<? super g<T, Key>> r11) {
        if ((r11 instanceof LoadStateHolder$checkRefresh$1) == false) goto L7;
        LoadStateHolder$checkRefresh$1 r0 = (LoadStateHolder$checkRefresh$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L20;
        if (r3 == 3) goto L19;
        if (r3 == 4) goto L18;
        if (r3 != 5) goto L17;
        kotlinx.coroutines.sync.a r13 = (kotlinx.coroutines.sync.a) r0.L$1;
        g r4 = (g) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L70:
    L61:
        th = move-exception;
        r13.unlock(null);
        throw th;
    L53:
        if ((r4 instanceof g.d) == false) goto L56;
        ((g.d) r4).getClass();     // Catch: Throwable -> L61
        ((g.d) r4).getClass();     // Catch: Throwable -> L61
        this.d = null;     // Catch: Throwable -> L61
    L58:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L61
        r13.unlock(null);
        return r4;
    L56:
        if ((r4 instanceof g.c) == false) goto L58;
        this.d = new com.larus.bmhome.social.page.datasource.event.e.b(true);     // Catch: Throwable -> L61
        goto L58
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r12);
    L48:
        g r15 = (g) r12;
        kotlinx.coroutines.sync.a r16 = this.c;
        r0.L$0 = r15;
        r0.L$1 = r16;
        r0.label = 5;
        if (r16.a(null, r0) != r2) goto L51;
        return r2;
    L51:
        r4 = r15;
        r13 = r16;
        goto L70
    L19:
        kotlinx.coroutines.sync.a r17 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L72:
        this.d = null;     // Catch: Throwable -> L64
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L64
        r17.unlock(null);
        this.b.getClass();
        this.b.getClass();
        e r19 = new e();
        CoroutineDispatcher r110 = Dispatchers.getIO();
        LoadStateHolder$checkRefresh$result$1 r5 = new LoadStateHolder$checkRefresh$result$1(this, r19, null);
        r0.L$0 = null;
        r0.label = 4;
        r12 = BuildersKt.withContext(r110, r5, r0);
        if (r12 != r2) goto L48;
        return r2;
    L64:
        th = move-exception;
        r17.unlock(null);
        throw th;
    L20:
        ResultKt.throwOnFailure(r12);
    L38:
        return r12;
    L21:
        r10 = r0.Z$0;
        kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L74:
        com.larus.bmhome.social.page.datasource.event.e r111 = this.d;     // Catch: Throwable -> L67
        r6.unlock(null);
        if (r10 == false) goto L41;
        if (r111 == null) goto L41;
        r0.L$0 = null;
        r0.label = 2;
        if ((r111 instanceof com.larus.bmhome.social.page.datasource.event.e.b) == false) goto L34;
        Object r112 = b(false, r0);
    L32:
        r12 = r112;
        if (r12 != r2) goto L38;
        return r2;
    L34:
        if ((r111 instanceof com.larus.bmhome.social.page.datasource.event.e.a) == false) goto L40;
        r112 = a((com.larus.bmhome.social.page.datasource.event.e.a) r111, r0);
        goto L32
    L40:
        throw new NoWhenBranchMatchedException();
    L41:
        r17 = this.c;
        r0.L$0 = r17;
        r0.label = 3;
        if (r17.a(null, r0) != r2) goto L72;
        return r2;
    L67:
        th = move-exception;
        r6.unlock(null);
        throw th;
    L22:
        ResultKt.throwOnFailure(r12);
        r6 = this.c;
        r0.L$0 = r6;
        r0.Z$0 = r10;
        r0.label = 1;
        if (r6.a(null, r0) != r2) goto L74;
        return r2;
    L7:
        r0 = new LoadStateHolder$checkRefresh$1(this, r11);
        goto L8
    }
}
