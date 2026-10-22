package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.feature.miniapp.widget.depend.ObricLauncherHostLocationPermissionServiceImpl;
import k5.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o1.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/GetLocationMethod;", "Lcom/bytedance/ai/bridge/method/system/AbsGetLocationMethodIDL;", "<init>", "()V", "Ln1/c;", "bridgeContext", "Lcom/bytedance/ai/bridge/method/system/AbsGetLocationMethodIDL$GetLocationParamModel;", LynxResourceModule.PARAMS_KEY, "Lo1/f;", "Lcom/bytedance/ai/bridge/method/system/AbsGetLocationMethodIDL$GetLocationResultModel;", "callback", "", "handle", "(Ln1/c;Lcom/bytedance/ai/bridge/method/system/AbsGetLocationMethodIDL$GetLocationParamModel;Lo1/f;)V", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GetLocationMethod extends AbsGetLocationMethodIDL {
    public GetLocationMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public /* bridge */ /* synthetic */ void handle(n1.c r5, ParamModel r10, f r11) {
        handle(r5, (AbsGetLocationMethodIDL.GetLocationParamModel) r10, r11);
    }

    public void handle(n1.c r5, AbsGetLocationMethodIDL.GetLocationParamModel r10, f r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        n1.a r12 = (n1.a) r5;
        Activity r13 = r12.d();
        if (r13 != null) goto L8;
        r13 = s0.c.b();
        if (r13 != null) goto L8;
        r11.a("context is null");
        return;
    L8:
        ObricLauncherHostLocationPermissionServiceImpl r14 = d.e;
        if (r14 != null) goto L12;
        r11.a("LocationPermissionDepend is null");
        return;
    L12:
        r14.requestPermission(r13, r12, getName(), new b(r13, r11));
    }
}
