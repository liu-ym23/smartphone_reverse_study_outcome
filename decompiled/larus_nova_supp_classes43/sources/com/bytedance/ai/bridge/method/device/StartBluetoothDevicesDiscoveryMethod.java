package com.bytedance.ai.bridge.method.device;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.device.bluetooth.AbsStartBluetoothDevicesDiscoveryMethodIDL;
import e3.d;
import f3.h;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import l4.c;
import t3.e0;
import t3.f0;
import t3.g2;
import t3.h2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/StartBluetoothDevicesDiscoveryMethod;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsStartBluetoothDevicesDiscoveryMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsStartBluetoothDevicesDiscoveryMethodIDL$StartBluetoothDevicesDiscoveryParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/bluetooth/AbsStartBluetoothDevicesDiscoveryMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartBluetoothDevicesDiscoveryMethod extends AbsStartBluetoothDevicesDiscoveryMethodIDL {
    public static final Set<String> b = null;

    public static final class a {
    }

    static {
        b = SetsKt.setOf(new String[]{"low", "medium", "high"});
    }

    public StartBluetoothDevicesDiscoveryMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(final d r10, ParamModel r11, final h r12) {
        final AbsStartBluetoothDevicesDiscoveryMethodIDL.b r13 = (AbsStartBluetoothDevicesDiscoveryMethodIDL.b) r11;
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "callback");
        String r0 = r13.getPowerLevel();
        if (r0 == null) goto L5;
        final String r1 = r0.toLowerCase(Locale.ROOT);
    L6:
        if (r1 != null) goto L8;
    L10:
        String r14 = this.a;
        e0.a.getClass();
        c.b(r10, r14, e0.j(), new g2(r12), new h2(r10, r13, r1, r12));
        return;
    L8:
        if (b.contains(r1) == true) goto L10;
        f0.a(r12, "startBluetoothDevicesDiscovery failed: invalid powerLevel: " + r13.getPowerLevel());
        return;
    L5:
        r1 = null;
        goto L6
    }
}
