package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
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
@DebugMetadata(c = "com.bytedance.ai.bridge.method.login.PostLoginResultMethod$returnToChat$2", f = "PostLoginResultMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PostLoginResultMethod$returnToChat$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletId;
    int label;

    public PostLoginResultMethod$returnToChat$2(String r1, Continuation<? super PostLoginResultMethod$returnToChat$2> r10) {
        this.$appletId = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new PostLoginResultMethod$returnToChat$2(this.$appletId, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r10);
        AppletAppManagerService r11 = AppletAppManagerService.INSTANCE;
        String r0 = this.$appletId;
        r11.getClass();
        AppletApplication r12 = AppletAppManagerService.a(r0);
        if (r12 == null) goto L7;
        AppletAppActivity r13 = r12.d;
    L9:
        if (r13 != null) goto L12;
        com.bytedance.ai.utils.g.a.w("AISDK_JSB_PostLoginResultMethod", "returnToChat: appActivity is not available, appletId=" + this.$appletId);
        return Unit.INSTANCE;
    L12:
        com.bytedance.ai.utils.g.a.i("AISDK_JSB_PostLoginResultMethod", "returnToChat: move host task to front, appletId=" + this.$appletId);
        int r1 = AppletAppActivity.j;
        r13.P1(null);
        return Unit.INSTANCE;
    L7:
        r13 = null;
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
