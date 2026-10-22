package com.ss.android.lark.lynxkit.bridge;

import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u0004\u0018\u00010\u0006J!\u0010\n\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r¢\u0006\u0002\u0010\u000eR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/lynxkit/bridge/LarkLynxXBridgeMethod;", "Lcom/bytedance/ies/xbridge/bridgeInterfaces/XCoreBridgeMethod;", "Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeContextAwareMethod;", "<init>", "()V", "bridgeContext", "Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeCallContext;", "setBridgeContext", "", "getBridgeContext", "getBridgeService", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public abstract class LarkLynxXBridgeMethod extends XCoreBridgeMethod implements LarkLynxBridgeContextAwareMethod {
    private LarkLynxBridgeCallContext bridgeContext;

    public LarkLynxXBridgeMethod() {
    }

    public final LarkLynxBridgeCallContext getBridgeContext() {
        return this.bridgeContext;
    }

    public final <T> T getBridgeService(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        LarkLynxBridgeCallContext r0 = this.bridgeContext;
        if (r0 == null) goto L7;
        T r1 = (T) r0.getService(r2);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return (T) provideContext(r2);
    }

    @Override // com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeContextAwareMethod
    public void setBridgeContext(LarkLynxBridgeCallContext r1) {
        this.bridgeContext = r1;
    }
}
