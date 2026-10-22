package com.ss.android.lark.lynxkit.xbridge;

import com.bytedance.ies.xbridge.XBridge;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import g66.c;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/XBridgeLynxKitMethodFinder;", "", "contextProvider", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "namespace", "", "<init>", "(Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;Ljava/lang/String;)V", "xbridge2Methods", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/ies/xbridge/XBridgeMethod;", "methodAdapters", "Lcom/ss/android/lark/lynxkit/xbridge/XBridge2To3Adapter;", "registerLynxMethod", "", "method", "loadMethod", "methodName", "release", "Companion", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class XBridgeLynxKitMethodFinder {
    public static final Companion Companion = null;
    private static final String TAG = "XBridgeLynxKitMethodFinder";
    private final c contextProvider;
    private final ConcurrentHashMap<String, XBridge2To3Adapter> methodAdapters;
    private final String namespace;
    private final ConcurrentHashMap<String, XBridgeMethod> xbridge2Methods;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/XBridgeLynxKitMethodFinder$Companion;", "", "<init>", "()V", "TAG", "", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void release() {
        Iterator<T> r0 = this.methodAdapters.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        XBridge2To3Adapter r1 = (XBridge2To3Adapter) r0.next();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        r1.release();     // Catch: Throwable -> L8
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L4
    L10:
        this.methodAdapters.clear();
        this.xbridge2Methods.clear();
    }

    public final XBridge2To3Adapter loadMethod(String r5) {
        Intrinsics.checkNotNullParameter(r5, "methodName");
        XBridge2To3Adapter r0 = this.methodAdapters.get(r5);
        if (r0 == null) goto L5;
        return r0;
    L5:
        XBridgeMethod r1 = this.xbridge2Methods.get(r5);
        if (r1 == null) goto L9;
        r1.setProviderFactory(this.contextProvider);
        XBridge2To3Adapter r2 = new XBridge2To3Adapter(r1);
        this.methodAdapters.put(r5, r2);
        return r2;
    L9:
        XBridgePlatformType r3 = XBridgePlatformType.LYNX;
        Class r4 = XBridge.findMethodClass(r3, r5, this.namespace);
        if (r4 == null) goto L12;
    L22:
        XBridgeMethod r6 = (XBridgeMethod) r4.newInstance();     // Catch: Throwable -> L19
        r6.setProviderFactory(this.contextProvider);     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L19
        XBridge2To3Adapter r7 = new XBridge2To3Adapter(r6);     // Catch: Throwable -> L19
        this.methodAdapters.put(r5, r7);     // Catch: Throwable -> L19
        return r7;
    L19:
        th = move-exception;
        Log.e(TAG, "Load method by XBridge failed, method name: " + r5, th);
        return null;
    L12:
        if (Intrinsics.areEqual(this.namespace, "DEFAULT") == true) goto L14;
        r4 = XBridge.findMethodClass(r3, r5, "DEFAULT");
    L15:
        if (r4 != null) goto L22;
        return null;
    L14:
        r4 = null;
        goto L15
    }

    public final void registerLynxMethod(XBridgeMethod r3) {
        Intrinsics.checkNotNullParameter(r3, "method");
        this.xbridge2Methods.put(r3.getName(), r3);
        XBridge2To3Adapter r4 = this.methodAdapters.remove(r3.getName());
        if (r4 == null) goto L6;
        r4.release();
        return;
    }

    public XBridgeLynxKitMethodFinder(c r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "contextProvider");
        Intrinsics.checkNotNullParameter(r3, "namespace");
        this.contextProvider = r2;
        this.namespace = r3;
        this.xbridge2Methods = new ConcurrentHashMap();
        this.methodAdapters = new ConcurrentHashMap();
    }
}
