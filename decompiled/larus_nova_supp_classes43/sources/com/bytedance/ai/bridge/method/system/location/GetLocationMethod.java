package com.bytedance.ai.bridge.method.system.location;

import android.app.Activity;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import d3.a0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J6\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J$\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00150\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0002J&\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/location/GetLocationMethod;", "Lcom/bytedance/ai/bridge/method/system/location/AbsGetLocationMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/system/location/AbsGetLocationMethodIDL$GetLocationParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/method/system/location/AbsGetLocationMethodIDL$GetLocationResultModel;", "authorize", BdpAwemeConstant.KEY_APP_ID, "", "context", "Landroid/content/Context;", "mapAuthorizeReason", "Lkotlin/Triple;", "", "Lcom/bytedance/ai/bridge/core/AIBridgeApiErr;", "reason", "getLocation", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetLocationMethod extends AbsGetLocationMethodIDL {
    public static final /* synthetic */ int c = 0;

    public static final class a {
    }

    static {
    }

    public GetLocationMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r18, ParamModel r19, f3.h r20) {
        AbsGetLocationMethodIDL.a r10 = (AbsGetLocationMethodIDL.a) r19;
        Intrinsics.checkNotNullParameter(r18, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r20, "callback");
        a0 r0 = r18.getContainerContext();
        com.bytedance.ai.utils.g r1 = com.bytedance.ai.utils.g.a;
        StringBuilder r11 = new StringBuilder("call start, mode: ");
        r11.append(r10.getMode());
        r11.append(", timeoutMs: ");
        r11.append(r10.getTimeoutMs());
        r11.append(", source: ");
        r11.append(r10.getSource());
        r11.append(", maxCacheTimeMs: ");
        r11.append(r10.getMaxCacheTimeMs());
        r11.append(", acceptLightLocation: ");
        r11.append(r10.getAcceptLightLocation());
        r11.append(", appletId=");
        if (r0 == null) goto L5;
        String r12 = r0.getAppletId();
    L6:
        r11.append(r12);
        r11.append(", appId=");
        if (r0 == null) goto L9;
        String r13 = r0.getAppId();
    L10:
        r11.append(r13);
        r11.append(", containerType=");
        if (r0 == null) goto L13;
        ContainerType r14 = r0.getContainerType();
    L14:
        r11.append(r14);
        r11.append(", containerId=");
        if (r0 == null) goto L17;
        String r15 = r0.getContainerId();
    L18:
        r11.append(r15);
        r1.i("AISDK_JSB_GetLocationMethod", r11.toString());
        Activity r16 = r18.getOwnerActivity();
        if (r16 != null) goto L21;
        r16 = f2.k.b();
    L21:
        Activity r17 = r16;
        if (r17 != null) goto L24;
        StringBuilder r21 = new StringBuilder("call failed, errNo=");
        f3.a r22 = f3.a.f;
        r21.append(r22.a);
        r21.append(", msg=context is null");
        r1.e("AISDK_JSB_GetLocationMethod", r21.toString());
        f3.h.a.a(r20, "context is null", r22, null, 10);
        return;
    L24:
        if (r0 == null) goto L26;
        String r110 = r0.getAppletId();
    L27:
        if (r110 != null) goto L29;
        StringBuilder r23 = new StringBuilder("call failed, errNo=");
        f3.a r24 = f3.a.f;
        r23.append(r24.a);
        r23.append(", msg=appId is null");
        r1.e("AISDK_JSB_GetLocationMethod", r23.toString());
        f3.h.a.a(r20, "appId is null", r24, null, 10);
        return;
    L29:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new GetLocationMethod$authorize$1(r110, r20, r18, this, r17, r10, null), 3, null);
        return;
    L26:
        r110 = null;
        goto L27
    L17:
        r15 = null;
        goto L18
    L13:
        r14 = null;
        goto L14
    L9:
        r13 = null;
        goto L10
    L5:
        r12 = null;
        goto L6
    }
}
