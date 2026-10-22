package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.router.AbsGetCurrentPagesMethodIDL;
import d3.a0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ai/bridge/method/router/GetCurrentPagesMethod;", "Lcom/bytedance/ai/bridge/router/AbsGetCurrentPagesMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/router/AbsGetCurrentPagesMethodIDL$GetCurrentPagesResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/router/AbsGetCurrentPagesMethodIDL$EmptyMessageModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetCurrentPagesMethod extends AbsGetCurrentPagesMethodIDL {
    public final boolean b;

    public GetCurrentPagesMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(e3.d r10, AbsGetCurrentPagesMethodIDL.a r11) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        a0 r12 = r10.getContainerContext();
        if (r12 == null) goto L24;
        String r13 = r12.getAppletId();
        if (r13 == null) goto L24;
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r14 = AppletAppManagerService.b(r13);
        if (r14 == null) goto L10;
        Object r15 = r14.h().d().f();
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 != null) goto L18;
        List r17 = (List) r15;
        Intrinsics.checkNotNullParameter(AbsGetCurrentPagesMethodIDL.b.class, "<this>");
        BaseModel r18 = k3.c.a(AbsGetCurrentPagesMethodIDL.b.class);
        AbsGetCurrentPagesMethodIDL.b r0 = (AbsGetCurrentPagesMethodIDL.b) r18;
        ArrayList r1 = new ArrayList(r17.size());
        Iterator r19 = r17.iterator();
    L15:
        if (r19.hasNext() == false) goto L17;
        r1.add(new AbsGetCurrentPagesMethodIDL.CurrentPage((String) r19.next()));
        goto L15
    L17:
        r0.setPages(r1);
        return new com.bytedance.ai.bridge.core.a.c(r18);
    L18:
        String r20 = r16.getMessage();
        if (r20 != null) goto L22;
        r20 = "getCurrentPages failed";
    L22:
        return new com.bytedance.ai.bridge.core.a.b(0, r20, null, null, 29);
    L10:
        return new com.bytedance.ai.bridge.core.a.b(0, "app " + r13 + " not found", null, null, 29);
    L24:
        return new com.bytedance.ai.bridge.core.a.b(0, "appId is null", null, null, 29);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(e3.d r1, ParamModel r10) {
        return b(r1, (AbsGetCurrentPagesMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r10, ParamModel r11, f3.h r12) {
        AbsGetCurrentPagesMethodIDL.a r13 = (AbsGetCurrentPagesMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        com.bytedance.ai.bridge.core.b.a(b(r10, r13), r12);
    }
}
