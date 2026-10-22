package com.bytedance.ai.lynx;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.permission.AppletAuthorizeHelper;
import com.bytedance.ai.applet.render.core.camera.a0;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AppletLynxViewApi$createLynxView$4$createUI$1$4 implements a0 {
    public final /* synthetic */ OnlineAppletApplication a;

    public AppletLynxViewApi$createLynxView$4$createUI$1$4(OnlineAppletApplication r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ai.applet.render.core.camera.a0
    public final Object a(Continuation<? super Boolean> r10) {
        if ((r10 instanceof AppletLynxViewApi$createLynxView$4$createUI$1$4$authorizeRecord$1) == false) goto L7;
        AppletLynxViewApi$createLynxView$4$createUI$1$4$authorizeRecord$1 r0 = (AppletLynxViewApi$createLynxView$4$createUI$1$4$authorizeRecord$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        AppletLynxViewApi$createLynxView$4$createUI$1$4$authorizeRecord$1 r11 = r0;
        Object r12 = r11.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r11.label;
        if (r14 == 0) goto L14;
        if (r14 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L18:
        return Boxing.boxBoolean(((com.bytedance.ai.applet.permission.f) r12).a);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        AppletAuthorizeHelper r15 = this.a.h().a();
        r11.label = 1;
        r12 = AppletAuthorizeHelper.e(r15, "scope.record", false, null, null, null, r11, 30);
        if (r12 != r13) goto L18;
        return r13;
    L7:
        r0 = new AppletLynxViewApi$createLynxView$4$createUI$1$4$authorizeRecord$1(this, r10);
        goto L8
    }
}
