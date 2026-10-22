package ib;

import android.util.Log;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.protocol.i;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rb.b f17566c;

    public c(rb.b r5) {
        Intrinsics.checkNotNullParameter(r5, "contextProviderFactory");
        this.f17566c = r5;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final String b() {
        return "bullet";
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final IDLXBridgeMethod f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        Class r10 = e(r5);     // Catch: Throwable -> L15
        if (r10 != null) goto L6;
        return null;
    L6:
        Method r11 = r10.getDeclaredMethod("create", new Class[]{rb.b.class});     // Catch: Throwable -> L15
        r11.setAccessible(true);     // Catch: Throwable -> L15
        Object r12 = r11.invoke(null, new Object[]{this.f17566c});     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.bytedance.ies.bullet.core.kit.bridge.BridgeMethod");     // Catch: Throwable -> L15
        com.bytedance.ies.bullet.core.kit.bridge.b r13 = (com.bytedance.ies.bullet.core.kit.bridge.b) r12;     // Catch: Throwable -> L15
        if ((r13 instanceof i) == true) goto L9;
        rb.b r14 = new rb.b();     // Catch: Throwable -> L15
        r13.getClass();     // Catch: Throwable -> L15
        Intrinsics.checkNotNullParameter(r14, "<set-?>");     // Catch: Throwable -> L15
        r13.f5335a = r14;     // Catch: Throwable -> L15
    L9:
        Intrinsics.checkNotNullParameter(r13, "method");     // Catch: Throwable -> L15
        if ((r13 instanceof i) == false) goto L14;
        return new e(r13);
    L14:
        return new b(r13);
    L15:
        Log.e("BDXBridge", "bullet method find failed: " + r5);
        return null;
    }
}
