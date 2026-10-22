package com.ss.android.lark.lynxkit.xbridge;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.lynx.tasm.LynxView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntime;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeCallContext;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeProtocolBuilderContext;
import com.ss.android.lark.lynxkit.bridge.LarkLynxBridgeProtocolContext;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import g66.c;
import g66.d;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p56.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012J'\u0010\u0013\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00162\u0006\u0010\u0017\u001a\u0002H\u0014¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/XBridgeLynxKitRuntime;", "Lcom/ss/android/lark/lynxkit/bridge/ILarkLynxBridgeRuntime;", "namespace", "", "<init>", "(Ljava/lang/String;)V", "finder", "Lcom/ss/android/lark/lynxkit/xbridge/XBridgeLynxKitMethodFinder;", "contextProvider", "Lcom/bytedance/ies/xbridge/model/context/XContextProviderFactory;", "configure", "", "context", "Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeProtocolBuilderContext;", "attach", "Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeProtocolContext;", "registerLynxMethod", "method", "Lcom/bytedance/ies/xbridge/XBridgeMethod;", "registerService", "T", "clazz", "Ljava/lang/Class;", "service", "(Ljava/lang/Class;Ljava/lang/Object;)V", "loadMethod", "Lcom/ss/android/lark/lynxkit/xbridge/XBridge2To3Adapter;", "methodName", "createCallContext", "Lcom/ss/android/lark/lynxkit/bridge/LarkLynxBridgeCallContext;", "detach", "Companion", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class XBridgeLynxKitRuntime implements ILarkLynxBridgeRuntime {
    public static final Companion Companion = null;
    private static final String TAG = "XBridgeLynxKitRuntime";
    private final c contextProvider;
    private XBridgeLynxKitMethodFinder finder;
    private final String namespace;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/XBridgeLynxKitRuntime$Companion;", "", "<init>", "()V", "TAG", "", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
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

    public XBridgeLynxKitRuntime() {
        String r0 = null;
        this(r0, 1, r0);
    }

    public final LarkLynxBridgeCallContext createCallContext() {
        LarkLynxBridgeCallContext.a r0 = LarkLynxBridgeCallContext.Companion;
        String r1 = UUID.randomUUID().toString();
        Function1<Class<?>, Object> r2 = new C04321(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "callId");
        Intrinsics.checkNotNullParameter(r2, "serviceProvider");
        return new rqb.c(r1, r2);
    }

    @Override // com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocolHandle
    public void detach() {
        Throwable r2 = null;
        XBridgeLynxKitMethodFinder r3 = this.finder;     // Catch: Throwable -> L7
        if (r3 == null) goto L6;
        r3.release();     // Catch: Throwable -> L7
    L6:
        this.contextProvider.g();
        this.finder = null;
        Log.i(TAG, "detach");
    L9:
        if (r2 != null) goto L11;
        return;
    L11:
        throw r2;
    L7:
        th = move-exception;
        this.contextProvider.g();
        this.finder = null;
        Log.i(TAG, "detach");
        r2 = th;
        goto L9
    }

    @Override // com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntime
    public void dispose() {
        detach();
    }

    public XBridgeLynxKitRuntime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "namespace");
        this.namespace = r2;
        this.contextProvider = new c();
    }

    public static final /* synthetic */ c access$getContextProvider$p(XBridgeLynxKitRuntime r0) {
        return r0.contextProvider;
    }

    @Override // com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntime
    public void attach(final LarkLynxBridgeProtocolContext r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (this.finder == null) goto L13;
        this.contextProvider.e(LynxView.class, new d(r6.getLynxView()));
        if (this.contextProvider.b(b.class) == true) goto L8;
        this.contextProvider.e(b.class, new g66.b(new AnonymousClass1(r6)));
    L8:
        if (this.contextProvider.b(XBridgeMethod.b.class) == true) goto L10;
        this.contextProvider.e(XBridgeMethod.b.class, new g66.b(new XBridgeLynxJsEventDelegate(new AnonymousClass2(r6))));
    L10:
        Log.i(TAG, "attach: containerId=" + r6.getContainerId());
        return;
    L13:
        throw new IllegalStateException("XBridge method finder is not configured".toString());
    }

    @Override // com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntime
    public void configure(LarkLynxBridgeProtocolBuilderContext r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        XBridgeInitializer.ensureInitialized(r5.getContext());
        this.contextProvider.e(Context.class, new d(r5.getContext()));
        Context r0 = r5.getContext();
        if ((r0 instanceof Activity) == false) goto L5;
        Activity r1 = (Activity) r0;
    L6:
        if (r1 == null) goto L8;
        this.contextProvider.e(Activity.class, new d(r1));
    L8:
        ILynxContainerContext r2 = r5.getContainerContext();
        if (r2 == null) goto L11;
        this.contextProvider.e(ILynxContainerContext.class, new g66.b(r2));
    L11:
        XBridgeLynxKitMethodFinder r3 = new XBridgeLynxKitMethodFinder(this.contextProvider, this.namespace);
        r5.getLynxViewBuilder().registerModule(XBridgeLynxModule.NAME, XBridgeLynxModule.class, this);
        this.finder = r3;
        Log.i(TAG, "configure: containerId=" + r5.getContainerId() + ", namespace=" + this.namespace);
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final XBridge2To3Adapter loadMethod(String r2) {
        Intrinsics.checkNotNullParameter(r2, "methodName");
        XBridgeLynxKitMethodFinder r0 = this.finder;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.loadMethod(r2);
    }

    public final void registerLynxMethod(XBridgeMethod r2) {
        Intrinsics.checkNotNullParameter(r2, "method");
        XBridgeLynxKitMethodFinder r0 = this.finder;
        if (r0 == null) goto L6;
        r0.registerLynxMethod(r2);
        return;
    }

    public final <T> void registerService(Class<T> r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "clazz");
        this.contextProvider.e(r3, new g66.b(r4));
    }

    public /* synthetic */ XBridgeLynxKitRuntime(String r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }
}
