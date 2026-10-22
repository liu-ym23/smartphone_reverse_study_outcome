package ib;

import cj.j;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod$Access;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.utils.f;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class b implements IDLXBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ies.bullet.core.kit.bridge.b f17565a;

    public b(com.bytedance.ies.bullet.core.kit.bridge.b r5) {
        Intrinsics.checkNotNullParameter(r5, "method");
        this.f17565a = r5;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        com.bytedance.ies.bullet.core.kit.bridge.b r5 = this.f17565a;
        if (r5 != null) goto L5;
        return false;
    L5:
        return r5.b();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        IBridgeMethod$Access r5 = this.f17565a.f();
        Intrinsics.checkNotNullParameter(r5, "privilege");
        int r10 = r5.ordinal();
        if (r10 != 0) goto L5;
        IDLXBridgeMethod.Access r11 = IDLXBridgeMethod.Access.f7464b;
    L15:
        if (r11 == null) goto L17;
        return r11;
    L17:
        return IDLXBridgeMethod.Access.d;
    L5:
        if (r10 != 1) goto L7;
        r11 = IDLXBridgeMethod.Access.d;
        goto L15
    L7:
        if (r10 != 2) goto L9;
        r11 = IDLXBridgeMethod.Access.f7465c;
        goto L15
    L9:
        if (r10 == 3) goto L11;
        r11 = null;
        goto L15
    L11:
        r11 = IDLXBridgeMethod.Access.e;
        goto L15
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return IDLXBridgeMethod.Compatibility.f7467b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f17565a.g();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(cj.d r5, Map r10, j r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "callback");
        this.f17565a.a(f.e(0, r10), new a(r11, this));     // Catch: Exception -> L5
        return;
    }
}
