package com.bytedance.ai.bridge.method.storage;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.base.ApplicationStorage;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.storage.AbsGetStorageMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.b;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/storage/GetStorageMethod;", "Lcom/bytedance/ai/bridge/storage/AbsGetStorageMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/storage/AbsGetStorageMethodIDL$GetStorageResultModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/storage/AbsGetStorageMethodIDL$GetStorageParamModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetStorageMethod extends AbsGetStorageMethodIDL {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public GetStorageMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(d r13, AbsGetStorageMethodIDL.a r14) {
        Intrinsics.checkNotNullParameter(r13, "bridgeContext");
        Intrinsics.checkNotNullParameter(r14, "params");
        g r0 = g.a;
        r0.i("AISDK_JSB_GetStorageMethod", "call start, key=" + r14.getKey());
        boolean r10 = false;
        if (r14.getKey().length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L11;
        StringBuilder r15 = new StringBuilder("call failed, errNo=");
        f3.a.C0156a r16 = f3.a.c;
        f3.a r11 = b.a;
        Intrinsics.checkNotNullParameter(r16, "<this>");
        f3.a r12 = b.c;
        r15.append(r12.a);
        r15.append(", msg=key is empty");
        r0.e("AISDK_JSB_GetStorageMethod", r15.toString());
        Intrinsics.checkNotNullParameter(r16, "<this>");
        return new com.bytedance.ai.bridge.core.a.b(0, "key is empty", null, r12, 21);
    L11:
        if (r14.getKey().length() <= 1024) goto L14;
        StringBuilder r17 = new StringBuilder("call failed, errNo=");
        f3.a.C0156a r18 = f3.a.c;
        f3.a r19 = b.a;
        Intrinsics.checkNotNullParameter(r18, "<this>");
        f3.a r110 = b.d;
        r17.append(r110.a);
        r17.append(", msg=key exceeds max length");
        r0.e("AISDK_JSB_GetStorageMethod", r17.toString());
        Intrinsics.checkNotNullParameter(r18, "<this>");
        return new com.bytedance.ai.bridge.core.a.b(0, "key exceeds max length", null, r110, 21);
    L14:
        a0 r111 = r13.getContainerContext();
        if (r111 == null) goto L28;
        String r112 = r111.getAppletId();
        if (r112 == null) goto L28;
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r20 = AppletAppManagerService.b(r112);
        if (r20 != null) goto L23;
        StringBuilder r113 = new StringBuilder("call failed, errNo=");
        f3.a r114 = f3.a.f;
        r113.append(r114.a);
        r113.append(", msg=app ");
        r113.append(r112);
        r113.append(" not found");
        r0.e("AISDK_JSB_GetStorageMethod", r113.toString());
        return new com.bytedance.ai.bridge.core.a.b(0, "app " + r112 + " not found", null, r114, 21);
    L23:
        String r115 = ((ApplicationStorage) r20.h().d.getValue()).get(r14.getKey());
        StringBuilder r21 = new StringBuilder("call success, key=");
        r21.append(r14.getKey());
        r21.append(", hasValue=");
        if (r115 == null) goto L26;
        r10 = true;
    L26:
        r21.append(r10);
        r0.i("AISDK_JSB_GetStorageMethod", r21.toString());
        Intrinsics.checkNotNullParameter(AbsGetStorageMethodIDL.b.class, "<this>");
        BaseModel r116 = c.a(AbsGetStorageMethodIDL.b.class);
        ((AbsGetStorageMethodIDL.b) r116).setData(r115);
        return new com.bytedance.ai.bridge.core.a.c(r116);
    L28:
        StringBuilder r117 = new StringBuilder("call failed, errNo=");
        f3.a r118 = f3.a.f;
        r117.append(r118.a);
        r117.append(", msg=appId is null");
        r0.e("AISDK_JSB_GetStorageMethod", r117.toString());
        return new com.bytedance.ai.bridge.core.a.b(0, "appId is null", null, r118, 21);
    L5:
        r1 = false;
        goto L7
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsGetStorageMethodIDL.a) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsGetStorageMethodIDL.a r13 = (AbsGetStorageMethodIDL.a) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        com.bytedance.ai.bridge.core.b.a(b(r10, r13), r12);
    }
}
