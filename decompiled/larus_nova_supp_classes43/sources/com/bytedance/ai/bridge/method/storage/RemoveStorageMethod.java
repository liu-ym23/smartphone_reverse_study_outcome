package com.bytedance.ai.bridge.method.storage;

import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.app.base.ApplicationStorage;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.storage.AbsRemoveStorageMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.b;
import f3.h;
import k3.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0012H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ai/bridge/method/storage/RemoveStorageMethod;", "Lcom/bytedance/ai/bridge/storage/AbsRemoveStorageMethodIDL;", "<init>", "()V", "supportSyncCall", "", "getSupportSyncCall", "()Z", "handleSync", "Lcom/bytedance/ai/bridge/core/BridgeMethodResult;", "Lcom/bytedance/ai/bridge/storage/AbsRemoveStorageMethodIDL$EmptyMessageModel;", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/storage/AbsRemoveStorageMethodIDL$RemoveStorageParamModel;", "handle", "", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoveStorageMethod extends AbsRemoveStorageMethodIDL {
    public final boolean b;

    public static final class a {
    }

    static {
    }

    public RemoveStorageMethod() {
        this.b = true;
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod, com.bytedance.ai.bridge.core.AIBridgeMethod
    public final boolean getSupportSyncCall() {
        return this.b;
    }

    public static com.bytedance.ai.bridge.core.a b(d r11, AbsRemoveStorageMethodIDL.b r12) {
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "params");
        g r0 = g.a;
        r0.i("AISDK_JSB_RemoveStorageMethod", "call start, key=" + r12.getKey());
        if (r12.getKey().length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L11;
        StringBuilder r13 = new StringBuilder("call failed, errNo=");
        f3.a.C0156a r14 = f3.a.c;
        f3.a r10 = b.a;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        f3.a r15 = b.c;
        r13.append(r15.a);
        r13.append(", msg=key is empty");
        r0.e("AISDK_JSB_RemoveStorageMethod", r13.toString());
        Intrinsics.checkNotNullParameter(r14, "<this>");
        return new com.bytedance.ai.bridge.core.a.b(0, "key is empty", null, r15, 21);
    L11:
        if (r12.getKey().length() <= 1024) goto L14;
        StringBuilder r16 = new StringBuilder("call failed, errNo=");
        f3.a.C0156a r17 = f3.a.c;
        f3.a r18 = b.a;
        Intrinsics.checkNotNullParameter(r17, "<this>");
        f3.a r19 = b.d;
        r16.append(r19.a);
        r16.append(", msg=key exceeds max length");
        r0.e("AISDK_JSB_RemoveStorageMethod", r16.toString());
        Intrinsics.checkNotNullParameter(r17, "<this>");
        return new com.bytedance.ai.bridge.core.a.b(0, "key exceeds max length", null, r19, 21);
    L14:
        a0 r110 = r11.getContainerContext();
        if (r110 == null) goto L25;
        String r111 = r110.getAppletId();
        if (r111 == null) goto L25;
        AppletAppManagerService.INSTANCE.getClass();
        OnlineAppletApplication r20 = AppletAppManagerService.b(r111);
        if (r20 != null) goto L23;
        StringBuilder r112 = new StringBuilder("call failed, errNo=");
        f3.a r21 = f3.a.f;
        r112.append(r21.a);
        r112.append(", msg=app ");
        r112.append(r111);
        r112.append(" not found");
        r0.e("AISDK_JSB_RemoveStorageMethod", r112.toString());
        return new com.bytedance.ai.bridge.core.a.b(0, "app " + r111 + " not found", null, r21, 21);
    L23:
        ((ApplicationStorage) r20.h().d.getValue()).remove(r12.getKey());
        r0.i("AISDK_JSB_RemoveStorageMethod", "call success, key=" + r12.getKey());
        Intrinsics.checkNotNullParameter(AbsRemoveStorageMethodIDL.a.class, "<this>");
        return new com.bytedance.ai.bridge.core.a.c(c.a(AbsRemoveStorageMethodIDL.a.class));
    L25:
        StringBuilder r113 = new StringBuilder("call failed, errNo=");
        f3.a r22 = f3.a.f;
        r113.append(r22.a);
        r113.append(", msg=appId is null");
        r0.e("AISDK_JSB_RemoveStorageMethod", r113.toString());
        return new com.bytedance.ai.bridge.core.a.b(0, "appId is null", null, r22, 21);
    L5:
        r1 = false;
        goto L7
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final /* bridge */ /* synthetic */ com.bytedance.ai.bridge.core.a handleSync(d r1, ParamModel r10) {
        return b(r1, (AbsRemoveStorageMethodIDL.b) r10);
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r10, ParamModel r11, h r12) {
        AbsRemoveStorageMethodIDL.b r13 = (AbsRemoveStorageMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        com.bytedance.ai.bridge.core.b.a(b(r10, r13), r12);
    }
}
