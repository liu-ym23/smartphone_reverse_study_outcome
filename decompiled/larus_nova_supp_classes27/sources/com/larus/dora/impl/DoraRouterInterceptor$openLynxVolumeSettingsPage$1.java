package com.larus.dora.impl;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.DoraRouterInterceptor$openLynxVolumeSettingsPage$1", f = "DoraRouterInterceptor.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
final class DoraRouterInterceptor$openLynxVolumeSettingsPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ DoraRouterInterceptor this$0;

    public DoraRouterInterceptor$openLynxVolumeSettingsPage$1(Context r1, DoraRouterInterceptor r2, Continuation<? super DoraRouterInterceptor$openLynxVolumeSettingsPage$1> r3) {
        this.$context = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraRouterInterceptor$openLynxVolumeSettingsPage$1(this.$context, this.this$0, r4);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        Context r2 = this.$context;
        i r7 = SmartRouter.buildRoute(r2, (String) r6);
        r7.d = 2130772401;
        r7.e = 2130772399;
        r7.d();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineDispatcher r8 = Dispatchers.getIO();
        DoraRouterInterceptor$openLynxVolumeSettingsPage$1$pageUrl$1 r3 = new DoraRouterInterceptor$openLynxVolumeSettingsPage$1$pageUrl$1(this.this$0, null);
        this.label = 1;
        r6 = BuildersKt.withContext(r8, r3, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
