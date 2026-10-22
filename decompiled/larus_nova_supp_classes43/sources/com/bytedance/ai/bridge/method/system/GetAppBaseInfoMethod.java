package com.bytedance.ai.bridge.method.system;

import android.content.Context;
import android.view.View;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.service.IHostContextDepend;
import com.bytedance.ai.bridge.system.appBaseInfo.AbsGetAppBaseInfoMethodIDL;
import f2.k;
import f3.h;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016J\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u0014H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/bridge/method/system/GetAppBaseInfoMethod;", "Lcom/bytedance/ai/bridge/system/appBaseInfo/AbsGetAppBaseInfoMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/system/appBaseInfo/AbsGetAppBaseInfoMethodIDL$GetAppBaseInfoResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/system/appBaseInfo/AbsGetAppBaseInfoMethodIDL$EmptyMessageModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "toTheme", "", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetAppBaseInfoMethod extends AbsGetAppBaseInfoMethodIDL {
    public final boolean b;

    public GetAppBaseInfoMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a.c b(e3.d r10, AbsGetAppBaseInfoMethodIDL.a r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        IHostContextDepend r12 = r4.a.a;
        Intrinsics.checkNotNullParameter(AbsGetAppBaseInfoMethodIDL.b.class, "<this>");
        BaseModel r0 = k3.c.a(AbsGetAppBaseInfoMethodIDL.b.class);
        AbsGetAppBaseInfoMethodIDL.b r1 = (AbsGetAppBaseInfoMethodIDL.b) r0;
        r1.setSDKVersion("1.15.0-rc.7");
        r1.setEnableDebug(Boolean.valueOf(k.b));
        AbsGetAppBaseInfoMethodIDL.AppBaseInfoHost r13 = null;
        if (r12 == null) goto L5;
        String r14 = r12.getLanguage();
    L6:
        if (r14 != null) goto L9;
        r14 = "";
    L9:
        if (r14.length() != 0) goto L11;
        boolean r15 = true;
    L12:
        if (r15 == false) goto L14;
        r14 = "zh";
    L14:
        r1.setLanguage(r14);
        if (r12 == null) goto L17;
        String r16 = r12.getVersionName();
    L18:
        r1.setVersion(r16);
        View r17 = r10.getEngineView();
        if (r17 == null) goto L21;
        Context r18 = r17.getContext();
    L22:
        r1.setTheme(t2.a.a(r18));
        if (r12 == null) goto L25;
        r13 = new AbsGetAppBaseInfoMethodIDL.AppBaseInfoHost(String.valueOf(r12.getAppId()));
    L25:
        r1.setHost(r13);
        return new com.bytedance.ai.bridge.core.a.c(r0);
    L21:
        r18 = null;
        goto L22
    L17:
        r16 = null;
        goto L18
    L11:
        r15 = false;
        goto L12
    L5:
        r14 = null;
        goto L6
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(e3.d r1, ParamModel r10) {
        return b(r1, (AbsGetAppBaseInfoMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, h r12) {
        AbsGetAppBaseInfoMethodIDL.a r13 = (AbsGetAppBaseInfoMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        com.bytedance.ai.bridge.core.b.a(b(r10, r13), r12);
    }
}
