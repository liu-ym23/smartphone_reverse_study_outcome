package com.ss.android.lark.lynxkit.xbridge;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeCallContext;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeContextAwareMethod;
import f66.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JD\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f2\u001e\u0010\u0010\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u000f\u0012\u0004\u0012\u00020\u000b0\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/XBridge2To3Adapter;", "", "method", "Lcom/bytedance/ies/xbridge/XBridgeMethod;", "<init>", "(Lcom/bytedance/ies/xbridge/XBridgeMethod;)V", "name", "", "getName", "()Ljava/lang/String;", "handle", "", "callContext", "Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeCallContext;", "params", "", "callback", "Lkotlin/Function1;", "shouldRunOnCallingThread", "", "isMainThread", "release", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class XBridge2To3Adapter {
    private final XBridgeMethod method;

    public final String getName() {
        return this.method.getName();
    }

    public final void release() {
        this.method.release();
    }

    public XBridge2To3Adapter(XBridgeMethod r2) {
        Intrinsics.checkNotNullParameter(r2, "method");
        this.method = r2;
    }

    public final boolean shouldRunOnCallingThread(boolean r3) {
        return XBridgeThreadPolicy.INSTANCE.shouldRunOnCallingThread(this.method, r3);
    }

    public final void handle(LarkLynxBridgeCallContext r4, Map<String, ? extends Object> r5, final Function1<? super Map<String, ? extends Object>, Unit> r6) {
        Intrinsics.checkNotNullParameter(r4, "callContext");
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "callback");
        XBridgeMethod.Callback r0 = new XBridge2To3Adapter$handle$originCallback$1(r6);
        d r7 = new d(new JSONObject(r5));
        LarkLynxBridgeContextAwareMethod r8 = this.method;
        if ((r8 instanceof LarkLynxBridgeContextAwareMethod) == false) goto L5;
        LarkLynxBridgeContextAwareMethod r9 = r8;
    L6:
        if (r9 == null) goto L24;
        r9.setBridgeContext(r4);
    L24:
        this.method.handle(r7, r0, XBridgePlatformType.LYNX);     // Catch: Throwable -> L16
        LarkLynxBridgeContextAwareMethod r10 = this.method;
        if ((r10 instanceof LarkLynxBridgeContextAwareMethod) == false) goto L12;
        LarkLynxBridgeContextAwareMethod r11 = r10;
    L13:
        if (r11 == null) goto L26;
        r11.setBridgeContext(null);
        return;
    L26:
        return;
    L12:
        r11 = null;
    L16:
        th = move-exception;
        LarkLynxBridgeContextAwareMethod r12 = this.method;
        if ((r12 instanceof LarkLynxBridgeContextAwareMethod) == false) goto L20;
        LarkLynxBridgeContextAwareMethod r13 = r12;
    L21:
        if (r13 == null) goto L23;
        r13.setBridgeContext(null);
    L23:
        throw th;
    L20:
        r13 = null;
        goto L21
    L5:
        r9 = null;
        goto L6
    }
}
