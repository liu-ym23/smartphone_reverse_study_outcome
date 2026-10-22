package com.bytedance.ai.bridge.method.pasteboard;

import android.app.Activity;
import android.content.ClipData;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.behavior.ui.utils.e;
import com.obric.feature.miniapp.widget.depend.ObricLauncherHostSystemActionServiceImpl;
import k5.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n1.a;
import n1.c;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/pasteboard/CopyMethod;", "Lcom/bytedance/ai/bridge/method/pasteboard/AbsCopyMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/pasteboard/AbsCopyMethodIDL$CopyParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/pasteboard/AbsCopyMethodIDL$CopyResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/pasteboard/AbsCopyMethodIDL$CopyParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CopyMethod extends AbsCopyMethodIDL {
    public CopyMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(c r5, ParamModel r10, f r11) {
        handle(r5, (AbsCopyMethodIDL.CopyParamModel) r10, r11);
    }

    public void handle(c r5, AbsCopyMethodIDL.CopyParamModel r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        String r12 = r10.getContent();
        if (r12.length() != 0) goto L6;
        r11.a("The content parameter should not be empty.");
        return;
    L6:
        a r13 = (a) r5;
        Activity r14 = r13.d();
        if (r14 != null) goto L12;
        r14 = s0.c.b();
        if (r14 != null) goto L12;
        r11.a("context is null");
        return;
    L12:
        ObricLauncherHostSystemActionServiceImpl r15 = d.g;
        if (r15 != null) goto L16;
        r11.a("system action depend is null");
        return;
    L16:
        r15.setPrimaryClip(r14, r13, getName(), ClipData.newPlainText(r12, r12));
        if (r15.hasPrimaryClip(r14, r13, getName()) == true) goto L20;
        r11.a("no permission to copy");
        return;
    L20:
        Intrinsics.checkNotNullParameter(AbsCopyMethodIDL.CopyResultModel.class, "<this>");
        r11.b((ResultModel) e.c(AbsCopyMethodIDL.CopyResultModel.class), "");
    }
}
