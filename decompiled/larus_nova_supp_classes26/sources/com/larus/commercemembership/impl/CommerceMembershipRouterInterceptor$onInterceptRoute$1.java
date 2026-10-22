package com.larus.commercemembership.impl;

import android.net.Uri;
import com.larus.chat.search.impl.chat.ChatSearchViewModel;
import com.larus.commercemembership.impl.utils.f;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercemembership.impl.CommerceMembershipRouterInterceptor$onInterceptRoute$1", f = "CommerceMembershipRouterInterceptor.kt", i = {}, l = {ChatSearchViewModel.INIT_CONVERSATION_SHOW_COUNT_NO_MESSAGE, 23}, m = "invokeSuspend", n = {}, s = {})
public final class CommerceMembershipRouterInterceptor$onInterceptRoute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.bytedance.router.c $routeIntent;
    int label;

    /* JADX INFO: renamed from: com.larus.commercemembership.impl.CommerceMembershipRouterInterceptor$onInterceptRoute$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.commercemembership.impl.CommerceMembershipRouterInterceptor$onInterceptRoute$1$1", f = "CommerceMembershipRouterInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.bytedance.router.c $routeIntent;
        int label;

        public AnonymousClass1(com.bytedance.router.c r1, Continuation<? super AnonymousClass1> r2) {
            this.$routeIntent = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$routeIntent, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            int r3 = f.a;
            com.bytedance.router.c r4 = this.$routeIntent;
            if (r4 == null) goto L7;
            Uri r5 = r4.d;
        L8:
            f.a(r5);
            return Unit.INSTANCE;
        L7:
            r5 = null;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CommerceMembershipRouterInterceptor$onInterceptRoute$1(com.bytedance.router.c r1, Continuation<? super CommerceMembershipRouterInterceptor$onInterceptRoute$1> r2) {
        this.$routeIntent = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CommerceMembershipRouterInterceptor$onInterceptRoute$1(this.$routeIntent, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L13:
        MainCoroutineDispatcher r7 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(this.$routeIntent, null);
        this.label = 2;
        if (BuildersKt.withContext(r7, r2, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L13;
        return r0;
    }
}
