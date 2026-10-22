package com.bytedance.ai.bridge.method.net;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.network.AbsGetNetworkTypeMethodIDL;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import d3.a0;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0002¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/GetNetworkTypeMethod;", "Lcom/bytedance/ai/bridge/network/AbsGetNetworkTypeMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/network/AbsGetNetworkTypeMethodIDL$EmptyMessageModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/network/AbsGetNetworkTypeMethodIDL$GetNetworkTypeResultModel;", "resolveWifiRssi", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Integer;", "hasSystemProxy", "", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetNetworkTypeMethod extends AbsGetNetworkTypeMethodIDL {

    public static final class a {
    }

    static {
    }

    public GetNetworkTypeMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r26, ParamModel r27, f3.h r28) {
        Intrinsics.checkNotNullParameter(r26, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetNetworkTypeMethodIDL.a) r27, "params");
        Intrinsics.checkNotNullParameter(r28, "callback");
        a0 r1 = r26.getContainerContext();
        com.bytedance.ai.utils.g r10 = com.bytedance.ai.utils.g.a;
        StringBuilder r11 = new StringBuilder("call start, appletId=");
        Boolean r12 = null;
        if (r1 == null) goto L5;
        String r13 = r1.getAppletId();
    L6:
        r11.append(r13);
        r11.append(", containerId=");
        if (r1 == null) goto L9;
        String r14 = r1.getContainerId();
    L10:
        r11.append(r14);
        r10.i("AISDK_JSB_GetNetworkTypeMethod", r11.toString());
        Context r15 = e3.e.b(r26);
        if (r15 != null) goto L13;
        StringBuilder r16 = new StringBuilder("call failed, errNo=");
        f3.a r17 = f3.a.f;
        r16.append(r17.a);
        r16.append(", msg=context is null");
        r10.e("AISDK_JSB_GetNetworkTypeMethod", r16.toString());
        f3.h.a.a(r28, "context is null", r17, null, 10);
        return;
    L13:
        int r18 = s4.b.a;
        Intrinsics.checkNotNullParameter(r15, "context");
        String r19 = s4.b.a(NetworkUtils.getNetworkTypeFast(r15));
        if (Intrinsics.areEqual(r19, "wifi") == false) goto L47;
        Object r20 = r15.getApplicationContext().getSystemService("wifi");
        if ((r20 instanceof WifiManager) == false) goto L18;
        WifiManager r21 = (WifiManager) r20;
    L19:
        if (r21 == null) goto L47;
        ArrayList r22 = new ArrayList();
        Object[] r110 = new Object[0];
        f06.b r111 = new f06.b();
        g06.a r23 = (g06.a) ApiHookConfig.b.get(102301);
        if (r23 == null) goto L24;
        f06.a[] r24 = r23.i;
    L25:
        f06.a[] r112 = r24;
        int r113 = r112.length;
        int r114 = 0;
    L27:
        if (r114 >= r113) goto L34;
        f06.a r115 = r112[r114];
        int r25 = r114;
        int r29 = r113;
        f06.a[] r210 = r112;
        Object[] r211 = r110;
        f06.d r30 = r115.preInvoke(102301, "android/net/wifi/WifiManager", "getConnectionInfo", r21, r110, "android.net.wifi.WifiInfo", r111);     // Catch: Exception -> L76
        if (r30.a == true) goto L36;
        r22.add(r115);     // Catch: Exception -> L76
    L36:
        if (r30.a == false) goto L38;
        WifiInfo r31 = (WifiInfo) r30.b;
    L39:
        if (r31 == null) goto L47;
        Integer r32 = Integer.valueOf(r31.getRssi());
        int r33 = r32.intValue();
        if ((-126) > r33) goto L44;
        if (r33 >= 0) goto L44;
        boolean r34 = true;
    L45:
        if (r34 == false) goto L47;
    L48:
        boolean r35 = NetworkUtils.isNetworkAvailable(r15);
        com.bytedance.ai.utils.g.a.i("AISDK_JSB_GetNetworkTypeMethod", "call success, networkType=" + r19 + ", networkAvailable=" + r35);
        Intrinsics.checkNotNullParameter(AbsGetNetworkTypeMethodIDL.b.class, "<this>");
        BaseModel r36 = k3.c.a(AbsGetNetworkTypeMethodIDL.b.class);
        AbsGetNetworkTypeMethodIDL.b r37 = (AbsGetNetworkTypeMethodIDL.b) r36;
        r37.setNetworkType(r19);
        r37.setNetworkAvailable(r35);
        r37.setSignalStrength(r32);
        String r38 = System.getProperty("http.proxyHost");
        if (r38 != null) goto L51;
    L54:
        boolean r39 = true;
    L55:
        if (r39 == false) goto L66;
        String r40 = System.getProperty("https.proxyHost");
        if (r40 != null) goto L59;
    L62:
        boolean r41 = true;
    L63:
        if (r41 == false) goto L66;
        boolean r42 = false;
    L67:
        r37.setHasSystemProxy(Boolean.valueOf(r42));
        if (r32 != null) goto L70;
    L74:
        r37.setWeakNet(r12);
        r28.b((ResultModel) r36, "");
        return;
    L70:
        if (r32.intValue() > (-80)) goto L72;
        boolean r43 = true;
    L73:
        r12 = Boolean.valueOf(r43);
        goto L74
    L72:
        r43 = false;
        goto L73
    L59:
        if (StringsKt.isBlank(r40) == true) goto L62;
        r41 = false;
    L66:
        r42 = true;
        goto L67
    L51:
        if (StringsKt.isBlank(r38) == true) goto L54;
        r39 = false;
    L44:
        r34 = false;
        goto L45
    L38:
        r31 = r21.getConnectionInfo();
    L33:
        r114 = r25 + 1;
        r113 = r29;
        r112 = r210;
        r110 = r211;
        goto L27
    L34:
        r30 = new f06.d(false, null);
        goto L36
    L24:
        r24 = ApiHookConfig.d;
        goto L25
    L18:
        r21 = null;
    L47:
        r32 = null;
        goto L48
    L9:
        r14 = null;
        goto L10
    L5:
        r13 = null;
        goto L6
    }
}
