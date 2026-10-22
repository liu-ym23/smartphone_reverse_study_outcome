package vw0;

import com.bytedance.android.live.recharge.panel.aio.IPanelProperties;
import com.bytedance.android.live.recharge.panel.aio.PanelMode;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final IPanelProperties a() {
        Class r0 = IPanelProperties.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r1 = vh7.b.a;
        Object r2 = r1.get(r0);
        if (r2 != null) goto L12;
        r2 = r0.getConstructor(new Class[0]);
        if (r2 == null) goto L11;
        Object r3 = r1.putIfAbsent(r0, r2);
        if (r3 == null) goto L12;
        r2 = r3;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r4 = ((SerializableObjectJsonAdapterBase) ((Constructor) r2).newInstance(new Object[0])).createInstance();
        if (r4 == null) goto L17;
        IPanelProperties r5 = (IPanelProperties) r4;
        r5.setRechargeAgreementAccepted(null);
        r5.setCombinedPaySelected(null);
        r5.setCustomPrice(null);
        r5.setShowCenterLoading(null);
        r5.setHidePanel(null);
        r5.setPanelMode(PanelMode.NORMAL_MODE.getMode());
        return r5;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.panel.aio.IPanelProperties");
    }
}
