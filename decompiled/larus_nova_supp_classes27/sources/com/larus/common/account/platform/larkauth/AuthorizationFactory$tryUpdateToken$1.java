package com.larus.common.account.platform.larkauth;

import com.bytedance.sdk.account.utils.s;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.platform.larkauth.AuthorizationFactory$tryUpdateToken$1", f = "AuthorizationFactory.kt", i = {0, 1, 1}, l = {354, 261}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "cacheKey"}, s = {"L$0", "L$0", "L$1"})
public final class AuthorizationFactory$tryUpdateToken$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromCache;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;

    public AuthorizationFactory$tryUpdateToken$1(boolean r1, Continuation<? super AuthorizationFactory$tryUpdateToken$1> r2) {
        this.$fromCache = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AuthorizationFactory$tryUpdateToken$1(this.$fromCache, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L12;
        String r2 = (String) this.L$1;
        a r3 = (a) this.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L9
    L23:
        a09.a r4 = (a09.a) r7;     // Catch: Throwable -> L9
        if (r4 == null) goto L26;
        AuthorizationFactory.a.getClass();     // Catch: Throwable -> L9
        AuthorizationFactory.h(r4, r2);     // Catch: Throwable -> L9
    L26:
        a09.a r8 = (a09.a) r7;     // Catch: Throwable -> L9
        r3.unlock(null);
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("fetch token completed, hasResponse=");
        if (r8 == null) goto L30;
        boolean r9 = true;
    L31:
        r6.append(r9);
        r6.append(", kind=");
        LarkAuthTokenFetcher r10 = LarkAuthTokenFetcher.a;
        r6.append(LarkAuthTokenFetcher.a().c);
        r5.i("AuthorizationFactory", r6.toString());
        if (r8 == null) goto L37;
        AuthorizationFactory.d = 0;
        s r11 = AuthorizationFactory.e;
        if (r11 == null) goto L43;
        AuthorizationFactory.a.getClass();
        Boxing.boxBoolean(r11.sendEmptyMessageDelayed(1000, AuthorizationFactory.c));
    L43:
        return Unit.INSTANCE;
    L37:
        if (AuthorizationFactory.d >= AuthorizationFactory.b) goto L41;
        AuthorizationFactory.d++;
        s r12 = AuthorizationFactory.e;
        if (r12 == null) goto L43;
        Boxing.boxBoolean(r12.sendEmptyMessageDelayed(1000, 1000));
        goto L43
    L41:
        r5.e("AuthorizationFactory", "max retry");
        goto L43
    L30:
        r9 = false;
    L9:
        th = th;
        a r13 = r3;
    L46:
        r13.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        boolean r14 = this.Z$0;
        r13 = (a) this.L$0;
        ResultKt.throwOnFailure(r7);
    L17:
        if (r14 == true) goto L48;
    L19:
        AuthorizationFactory.a.getClass();     // Catch: Throwable -> L45
        String r15 = AuthorizationFactory.b();     // Catch: Throwable -> L45
        LarkAuthTokenFetcher r16 = LarkAuthTokenFetcher.a;     // Catch: Throwable -> L45
        String r17 = AuthorizationFactory.f();     // Catch: Throwable -> L45
        this.L$0 = r13;     // Catch: Throwable -> L45
        this.L$1 = r15;     // Catch: Throwable -> L45
        this.label = 2;     // Catch: Throwable -> L45
        Object r18 = LarkAuthTokenFetcher.c(r17, null, null, this);     // Catch: Throwable -> L45
        if (r18 != r0) goto L22;
        return r0;
    L22:
        r2 = r15;
        r7 = r18;
        r3 = r13;
    L45:
        th = th;
        goto L46
    L48:
        AuthorizationFactory.a(AuthorizationFactory.a);     // Catch: Throwable -> L45
        goto L19
    L14:
        ResultKt.throwOnFailure(r7);
        r13 = AuthorizationFactory.j;
        r14 = this.$fromCache;
        this.L$0 = r13;
        this.Z$0 = r14;
        this.label = 1;
        if (r13.a(null, this) != r0) goto L17;
        return r0;
    }
}
