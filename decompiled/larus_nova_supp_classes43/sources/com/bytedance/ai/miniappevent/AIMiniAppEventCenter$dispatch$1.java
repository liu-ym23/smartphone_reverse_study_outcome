package com.bytedance.ai.miniappevent;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.foundation.v;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.utils.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.miniappevent.AIMiniAppEventCenter$dispatch$1", f = "AIMiniAppEventCenter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AIMiniAppEventCenter$dispatch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AIMiniAppEventCenter.c $eventNotify;
    int label;

    public AIMiniAppEventCenter$dispatch$1(AIMiniAppEventCenter.c r1, Continuation<? super AIMiniAppEventCenter$dispatch$1> r10) {
        this.$eventNotify = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIMiniAppEventCenter$dispatch$1(this.$eventNotify, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r10);
        g r11 = g.a;
        StringBuilder r0 = new StringBuilder("dispatch event, stage=chat, result=collapse_requested, ");
        AIMiniAppEventCenter r1 = AIMiniAppEventCenter.a;
        AIMiniAppEventCenter.c r12 = this.$eventNotify;
        r1.getClass();
        r0.append(AIMiniAppEventCenter.d(r12));
        r11.i("AIMiniAppEventCenter", r0.toString());
        AppletAppManagerService r13 = AppletAppManagerService.INSTANCE;
        String r14 = this.$eventNotify.e;
        r13.getClass();
        OnlineAppletApplication r15 = AppletAppManagerService.b(r14);
        if (r15 == null) goto L12;
        v r16 = r15.h();
        if (r16 == null) goto L12;
        com.bytedance.ai.applet.app.foundation.a r17 = r16.b();
        if (r17 == null) goto L12;
        r17.b();
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
