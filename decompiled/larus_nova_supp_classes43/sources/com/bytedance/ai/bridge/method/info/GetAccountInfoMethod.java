package com.bytedance.ai.bridge.method.info;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.clienttool.ClientToolRuntime;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.utils.g;
import com.google.gson.JsonObject;
import d3.a0;
import d3.z;
import e3.d;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import z3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/bridge/method/info/GetAccountInfoMethod;", "Lcom/bytedance/ai/bridge/method/info/AbsGetAccountInfoMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/method/info/AbsGetAccountInfoMethodIDL$GetAccountInfoResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/method/info/AbsGetAccountInfoMethodIDL$GetAccountInfoParamModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "resolveRuntimeSync", "Lcom/bytedance/ai/model/AppletRuntime;", "buildResult", "runtime", "applet", "Lcom/bytedance/ai/model/objects/Applet;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAccountInfoMethod extends AbsGetAccountInfoMethodIDL {
    public static final /* synthetic */ int d = 0;
    public final boolean c;

    public static final class a {
    }

    static {
    }

    public GetAccountInfoMethod() {
        this.c = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.c;
    }

    public static AbsGetAccountInfoMethodIDL.b b(Applet r10) {
        String r0 = r10.K;
        if (r10.A != true) goto L5;
        String r1 = "develop";
    L6:
        String r11 = r10.e;
        if (r11 != null) goto L9;
        r11 = "";
    L9:
        JsonObject r12 = new JsonObject();
        r12.addProperty(BdpAwemeConstant.KEY_APP_ID, r0);
        r12.addProperty("envVersion", r1);
        r12.addProperty("version", r11);
        Intrinsics.checkNotNullParameter(AbsGetAccountInfoMethodIDL.b.class, "<this>");
        AbsGetAccountInfoMethodIDL.b r13 = (AbsGetAccountInfoMethodIDL.b) c.a(AbsGetAccountInfoMethodIDL.b.class);
        r13.setMiniProgram(r12);
        return r13;
    L5:
        r1 = "release";
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final com.bytedance.ai.bridge.core.a handleSync(d r10, ParamModel r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetAccountInfoMethodIDL.a) r11, "params");
        g r12 = g.a;
        StringBuilder r0 = new StringBuilder("call start, appletId=");
        a0 r1 = r10.getContainerContext();
        if (r1 == null) goto L5;
        String r13 = r1.getAppletId();
    L6:
        r0.append(r13);
        r12.i("AISDK_JSB_GetAccountInfoMethod", r0.toString());
        ClientToolRuntime r14 = (ClientToolRuntime) r10.d(ClientToolRuntime.class);
        if (r14 == null) goto L11;
        Applet r15 = r14.e;
        if (r15 == null) goto L11;
        r12.i("AISDK_JSB_GetAccountInfoMethod", "call success");
        return new com.bytedance.ai.bridge.core.a.c(b(r15));
    L11:
        AppletRuntime r16 = (AppletRuntime) r10.d(AppletRuntime.class);
        if (r16 != null) goto L18;
        final Ref.ObjectRef r17 = new Ref.ObjectRef();
        z r18 = (z) r10.d(z.class);
        if (r18 == null) goto L17;
        r18.a(new b(r17));
    L17:
        r16 = (AppletRuntime) r17.element;
    L18:
        if (r16 != null) goto L20;
        StringBuilder r19 = new StringBuilder("call failed, errNo=");
        f3.a r20 = f3.a.f;
        r19.append(r20.a);
        r19.append(", msg=applet runtime is null");
        r12.e("AISDK_JSB_GetAccountInfoMethod", r19.toString());
        return new com.bytedance.ai.bridge.core.a.b(0, "applet runtime is null", null, r20, 21);
    L20:
        r12.i("AISDK_JSB_GetAccountInfoMethod", "call success");
        return new com.bytedance.ai.bridge.core.a.c(b(r16.h));
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, final h r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetAccountInfoMethodIDL.a) r11, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        g r13 = g.a;
        StringBuilder r0 = new StringBuilder("call start, appletId=");
        a0 r1 = r10.getContainerContext();
        if (r1 == null) goto L5;
        String r14 = r1.getAppletId();
    L6:
        r0.append(r14);
        r13.i("AISDK_JSB_GetAccountInfoMethod", r0.toString());
        ClientToolRuntime r15 = (ClientToolRuntime) r10.d(ClientToolRuntime.class);
        if (r15 == null) goto L11;
        Applet r16 = r15.e;
        if (r16 == null) goto L11;
        r13.i("AISDK_JSB_GetAccountInfoMethod", "call success");
        r12.b(b(r16), "");
        return;
    L11:
        AppletRuntime r17 = (AppletRuntime) r10.d(AppletRuntime.class);
        if (r17 == null) goto L14;
        r13.i("AISDK_JSB_GetAccountInfoMethod", "call success");
        r12.b(b(r17.h), "");
        return;
    L14:
        z r18 = (z) r10.d(z.class);
        if (r18 == null) goto L17;
        r18.a(new z3.a(r12, this));
        return;
    L17:
        StringBuilder r19 = new StringBuilder("call failed, errNo=");
        f3.a r20 = f3.a.f;
        r19.append(r20.a);
        r19.append(", msg=applet runtime is null");
        r13.e("AISDK_JSB_GetAccountInfoMethod", r19.toString());
        h.a.a(r12, "applet runtime is null", r20, null, 10);
        return;
    L5:
        r14 = null;
        goto L6
    }
}
