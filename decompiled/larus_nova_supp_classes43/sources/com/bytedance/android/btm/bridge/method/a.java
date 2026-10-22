package com.bytedance.android.btm.bridge.method;

import android.net.Uri;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g$a;
import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.android.btm.bridge.HybridSchemaHelper;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(name = "btm.pageRoute")
public final class a extends XCoreBridgeMethod implements com.bytedance.sdk.xbridge.cn.protocol.h {
    public final String a;
    public final com.bytedance.ies.xbridge.XBridgeMethod.Access b;

    public a() {
        this.a = "btm.pageRoute";
        this.b = com.bytedance.ies.xbridge.XBridgeMethod.Access.PROTECT;
    }

    public final com.bytedance.ies.xbridge.XBridgeMethod.Access getAccess() {
        return this.b;
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(final XReadableMap r17, final com.bytedance.ies.xbridge.XBridgeMethod.Callback r18, XBridgePlatformType r19) {
        b.a.getClass();
        ALogger.c(ALogger.d, "FE_pageRoute", new BtmPageRouteMethodHelper$handle$1(r17));
        final String r10 = s.f(r17, "btm", "");
        final String r11 = s.f(r17, "route_type", "");
        XReadableMap r0 = s.e(r17, "page_event_params");
        Uri r1 = null;
        if (r0 == null) goto L5;
        final Map r12 = r0.toMap();
    L6:
        final Ref.ObjectRef r13 = new Ref.ObjectRef();
        r13.element = null;
        if (getContextProviderFactory() == null) goto L12;
        Lazy r14 = HybridContainerContextManager.a;
        g66.c r15 = getContextProviderFactory();
        if (r15 != null) goto L11;
        Intrinsics.throwNpe();
    L11:
        r13.element = HybridContainerContextManager.c(r15);
    L12:
        View r16 = (View) r13.element;
        if (r16 == null) goto L22;
        Lazy r20 = HybridContainerContextManager.a;
        final String r21 = HybridContainerContextManager.b(getContextProviderFactory());
        Map<View, String> r22 = HybridSchemaHelper.a;
        View r23 = (View) r13.element;
        if (r21 == null) goto L17;
        r1 = UriProtector.parse(r21);
    L17:
        String r110 = HybridSchemaHelper.b(r23, r1);
        BtmSDK r24 = BtmSDK.INSTANCE;
        if (r24.getService().registerFEBtmPage(r16, r10, r110, Boolean.valueOf(Intrinsics.areEqual(r11, "back")), r12) == false) goto L20;
        j.b(this, r18, new LinkedHashMap());
    L21:
        j.b(this, r18, new LinkedHashMap());
        return;
    L20:
        int r25 = j.a;
        j.a(this, r18, "route btm page failed, route type: " + r11);
        g$a.a(r24.getService().getMonitor(), 2024, null, null, new BtmPageRouteMethodHelper$handle$$inlined$apply$lambda$1(r21, this, r13, r10, r11, r12, r18), 30);
        goto L21
    L22:
        j.a(this, r18, "view is null");
        Unit r26 = Unit.INSTANCE;
        return;
    L5:
        r12 = null;
        goto L6
    }
}
