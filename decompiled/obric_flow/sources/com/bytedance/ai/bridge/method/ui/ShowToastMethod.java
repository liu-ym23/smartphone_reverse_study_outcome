package com.bytedance.ai.bridge.method.ui;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.ToastBuilder;
import com.bytedance.ai.ex.widget.inittasks.AISdkInitializer$injectAIBridgeBaseRuntime$4$1;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import k5.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m1.j;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/ui/ShowToastMethod;", "Lcom/bytedance/ai/bridge/method/ui/AbsShowToastMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/ui/AbsShowToastMethodIDL$ShowToastParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/ui/AbsShowToastMethodIDL$ShowToastResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/ui/AbsShowToastMethodIDL$ShowToastParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ShowToastMethod extends AbsShowToastMethodIDL {
    public ShowToastMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsShowToastMethodIDL.ShowToastParamModel) r10, r11);
    }

    public void handle(c r10, AbsShowToastMethodIDL.ShowToastParamModel r11, f r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r12, "callback");
        n1.a r13 = (n1.a) r10;
        j r14 = (j) r13.b(j.class);
        Boolean r5 = null;
        if (r14 == null) goto L5;
        ContainerType r15 = r14.d();
    L7:
        if (r15 != ContainerType.d) goto L10;
        Context r16 = s0.c.b();
    L9:
        Context r17 = r16;
    L14:
        if (r17 != null) goto L18;
        r12.a("context not provided in host");
        return;
    L18:
        if (r11.getType() != null) goto L24;
        if (r11.getIcon() != null) goto L24;
        r12.a("either type or icon should have value");
        return;
    L24:
        if (r11.getMessage().length() != 0) goto L27;
        r12.a("message can not be empty");
        return;
    L27:
        Number r18 = r11.getDuration();
        if (r18 == null) goto L30;
        int r19 = r18.intValue();
    L31:
        ToastBuilder r20 = new ToastBuilder(r17, r11.getMessage(), r11.getType(), Integer.valueOf(r19), r11.getIcon(), r11.getCustomIcon());
        AISdkInitializer$injectAIBridgeBaseRuntime$4$1 r21 = d.d;
        if (r21 == null) goto L35;
        r5 = r21.showToast(r20);
    L35:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == true) goto L37;
        Intrinsics.checkNotNullParameter(r20, "toastBuilder");
        Toast.makeText(r20.getContext(), r20.getMessage(), 0).show();
    L37:
        Intrinsics.checkNotNullParameter(AbsShowToastMethodIDL.ShowToastResultModel.class, "<this>");
        r12.b((ResultModel) e.c(AbsShowToastMethodIDL.ShowToastResultModel.class), "");
        return;
    L30:
        r19 = PathInterpolatorCompat.MAX_NUM_POINTS;
        goto L31
    L10:
        View r22 = r13.a();
        if (r22 == null) goto L13;
        r16 = r22.getContext();
        goto L9
    L13:
        r17 = null;
        goto L14
    L5:
        r15 = null;
        goto L7
    }
}
