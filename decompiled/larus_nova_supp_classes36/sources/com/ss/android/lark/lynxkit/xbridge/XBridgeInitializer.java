package com.ss.android.lark.lynxkit.xbridge;

import android.content.Context;
import com.bytedance.ies.xbridge.XBridge;
import com.bytedance.ies.xbridge.event.bridge.c;
import com.bytedance.ies.xbridge.event.bridge.e;
import com.bytedance.ies.xbridge.event.bridge.f;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.xbridge.depend.XHostContextDependImpl;
import com.ss.android.lark.lynxkit.xbridge.depend.XHostLogDependImpl;
import com.ss.android.lark.lynxkit.xbridge.depend.XHostNetworkDependImpl;
import com.ss.android.lark.lynxkit.xbridge.depend.XHostRouterDependImpl;
import com.ss.android.lark.lynxkit.xbridge.depend.XHostStyleUIDependImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/XBridgeInitializer;", "", "<init>", "()V", "TAG", "", "initialized", "", "ensureInitialized", "", "context", "Landroid/content/Context;", "doInitialize", "appContext", "registerHostDepends", "registerGlobalMethods", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class XBridgeInitializer {
    public static final XBridgeInitializer INSTANCE = null;
    private static final String TAG = "XBridgeInitializer";
    private static volatile boolean initialized;

    static {
        INSTANCE = new XBridgeInitializer();
    }

    private XBridgeInitializer() {
    }

    private final void registerGlobalMethods() {
        XBridge r6 = XBridge.INSTANCE;
        XBridge.registerMethod$default(r6, e.class, null, null, 6, null);
        XBridge.registerMethod$default(r6, f.class, null, null, 6, null);
        XBridge.registerMethod$default(r6, c.class, null, null, 6, null);
    }

    private final void doInitialize(Context r2) {
        registerHostDepends(r2);
        registerGlobalMethods();
        Log.i(TAG, "XBridge initialized (China)");
    }

    @JvmStatic
    public static final void ensureInitialized(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (initialized == false) goto L5;
        return;
    L5:
        XBridgeInitializer r0 = INSTANCE;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (initialized == false) goto L11;
        monitor-exit(r0);
        return;
    L11:
        r0.doInitialize(r2.getApplicationContext());     // Catch: Throwable -> L14
        initialized = true;     // Catch: Throwable -> L14
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
    }

    private final void registerHostDepends(Context r3) {
        r56.c r0 = r56.c.g;
        r56.c r1 = new r56.c();
        XHostContextDependImpl r2 = new XHostContextDependImpl(r3);
        Intrinsics.checkNotNullParameter(r2, "hostContextDepend");
        r1.b = r2;
        XHostRouterDependImpl r4 = new XHostRouterDependImpl();
        Intrinsics.checkNotNullParameter(r4, "hostRouterDepend");
        r1.d = r4;
        XHostStyleUIDependImpl r5 = new XHostStyleUIDependImpl();
        Intrinsics.checkNotNullParameter(r5, "hostStyleUIDepend");
        r1.c = r5;
        XHostLogDependImpl r6 = new XHostLogDependImpl();
        Intrinsics.checkNotNullParameter(r6, "hostLogDepend");
        r1.a = r6;
        XHostNetworkDependImpl r7 = new XHostNetworkDependImpl();
        Intrinsics.checkNotNullParameter(r7, "hostNetworkDepend");
        r1.e = r7;
        r1.a();
    }
}
