package com.obric.assistant.router;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.c;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.spi.chat.IObricChatSPIService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.router.ObricRTCPageRouterInterceptor$onInterceptRoute$1", f = "ObricRTCPageRouterInterceptor.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
public final class ObricRTCPageRouterInterceptor$onInterceptRoute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ c $routeIntent;
    int label;
    final /* synthetic */ ObricRTCPageRouterInterceptor this$0;

    public ObricRTCPageRouterInterceptor$onInterceptRoute$1(ObricRTCPageRouterInterceptor r1, Context r2, c r3, Continuation<? super ObricRTCPageRouterInterceptor$onInterceptRoute$1> r4) {
        this.this$0 = r1;
        this.$context = r2;
        this.$routeIntent = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricRTCPageRouterInterceptor$onInterceptRoute$1(this.this$0, this.$context, this.$routeIntent, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L14:
        if (((Boolean) r10).booleanValue() != true) goto L16;
        boolean r11 = true;
    L18:
        if (r11 == false) goto L20;
        FLogger.a.i("ObricRTCPageRouterInterceptor", "onInterceptRoute: clear context succeed");
        Context r12 = this.$context;
        Intrinsics.checkNotNull(r12);
        c r2 = this.$routeIntent;
        r2.b.putExtra("o_is_checked_clear_context", true);
        SmartRouter.open(r12, r2);
    L22:
        return Unit.INSTANCE;
    L20:
        FLogger.a.i("ObricRTCPageRouterInterceptor", "onInterceptRoute: clear context failed");
        t0.e(new g());
    L16:
        r11 = false;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        IObricChatSPIService r3 = (IObricChatSPIService) this.this$0.b.getValue();
        if (r3 == null) goto L16;
        this.label = 1;
        r10 = IObricChatSPIService.a.a(r3, null, true, null, this, 5);
        if (r10 != r0) goto L14;
        return r0;
    }
}
