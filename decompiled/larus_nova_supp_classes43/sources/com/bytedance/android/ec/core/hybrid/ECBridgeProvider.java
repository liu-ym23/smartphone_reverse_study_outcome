package com.bytedance.android.ec.core.hybrid;

import com.bytedance.android.ec.core.hybrid.bridges.ECBroadcastMethod;
import com.bytedance.android.ec.core.hybrid.bridges.ECGetCjInfoMethod;
import com.bytedance.android.ec.core.hybrid.bridges.ECGetMegaObjectMethod;
import com.bytedance.android.ec.core.hybrid.bridges.ECNavigationBarColorMethod;
import com.bytedance.android.ec.core.hybrid.bridges.ECOpenQRCodeScanner;
import com.bytedance.android.ec.core.hybrid.bridges.ECOpenSchemaMethod;
import com.bytedance.android.ec.core.hybrid.bridges.ECOpenShopMethod;
import com.bytedance.android.ec.core.hybrid.bridges.ECSafeDynamicEventMethod;
import com.bytedance.android.ec.core.hybrid.bridges.ECSchemaMonitor;
import com.bytedance.android.ec.core.hybrid.bridges.ECSetMegaObjectMethod;
import com.bytedance.android.ec.core.hybrid.bridges.ECSharePanelMethod;
import com.bytedance.android.ec.core.hybrid.bridges.ECShopSettingMethod;
import com.bytedance.android.ec.core.hybrid.bridges.ECVerifyReport;
import com.bytedance.android.ec.core.hybrid.bridges.GetCurrentGCJLocationMethod;
import com.bytedance.android.ec.core.hybrid.bridges.HeightChangedMethod;
import com.bytedance.android.ec.core.hybrid.bridges.OpenSystemSettingsMethod;
import com.bytedance.android.ec.core.hybrid.bridges.StopShowFloatAllMethod;
import com.bytedance.android.ec.core.hybrid.bridges.StopShowFloatNextMethod;
import com.bytedance.android.ec.core.hybrid.bridges.StopShowFloatNowMethod;
import com.bytedance.android.ec.model.hybrid.IECBridgeMethod;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import ti.h;
import ti.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECBridgeProvider implements h {
    public static final Lazy a = null;

    public static final class a {
    }

    public ECBridgeProvider() {
    }

    static {
        a = LazyKt.lazy(ECBridgeProvider$Companion$INSTANCE$2.INSTANCE);
    }

    public final List<IECBridgeMethod> a() {
        ArrayList r0 = new ArrayList();
        Lazy r1 = ECBridgeProviderInjector.b;
        ECBridgeProviderInjector r10 = ECBridgeProviderInjector.a.a();
        r10.getClass();
        ArrayList r11 = new ArrayList();
        Iterator r12 = ((CopyOnWriteArrayList) r10.a).iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.addAll((Collection) ((i) r12.next()).c().invoke());
        goto L4
    L6:
        r0.addAll(r11);
        r0.add(new ECSetMegaObjectMethod());
        r0.add(new ECGetMegaObjectMethod());
        r0.add(new ECOpenShopMethod());
        r0.add(new ECGetCjInfoMethod());
        r0.add(new StopShowFloatNowMethod());
        r0.add(new StopShowFloatNextMethod());
        r0.add(new StopShowFloatAllMethod());
        r0.add(new ECOpenQRCodeScanner());
        r0.add(new ECBroadcastMethod());
        r0.add(new HeightChangedMethod());
        r0.add(new OpenSystemSettingsMethod());
        r0.add(new GetCurrentGCJLocationMethod());
        r0.add(new ECSharePanelMethod());
        r0.add(new ECShopSettingMethod());
        r0.add(new ECVerifyReport());
        r0.add(new ECSchemaMonitor());
        r0.add(new ECOpenSchemaMethod());
        r0.add(new ECNavigationBarColorMethod());
        r0.add(new ECSafeDynamicEventMethod());
        return r0;
    }
}
