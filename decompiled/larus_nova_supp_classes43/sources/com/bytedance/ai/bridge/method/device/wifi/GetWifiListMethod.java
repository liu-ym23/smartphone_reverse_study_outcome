package com.bytedance.ai.bridge.method.device.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.device.wifi.AbsGetWifiListMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.h;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import k3.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v3.e;
import v3.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/wifi/GetWifiListMethod;", "Lcom/bytedance/ai/bridge/device/wifi/AbsGetWifiListMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/wifi/AbsGetWifiListMethodIDL$GetWifiListParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/wifi/AbsGetWifiListMethodIDL$GetWifiListResultModel;", "toModel", "Lcom/bytedance/ai/bridge/device/wifi/AbsGetWifiListMethodIDL$WifiInfo;", "Lcom/bytedance/ai/bridge/method/device/wifi/WifiInfoSnapshot;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetWifiListMethod extends AbsGetWifiListMethodIDL {

    public static final class a {
    }

    static {
    }

    public GetWifiListMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r18, ParamModel r19, h r20) {
        Intrinsics.checkNotNullParameter(r18, "bridgeContext");
        Intrinsics.checkNotNullParameter((AbsGetWifiListMethodIDL.a) r19, "params");
        Intrinsics.checkNotNullParameter(r20, "callback");
        g r0 = g.a;
        StringBuilder r10 = new StringBuilder("call start, appletId=");
        a0 r11 = r18.getContainerContext();
        if (r11 == null) goto L5;
        String r12 = r11.getAppletId();
    L6:
        r10.append(r12);
        r0.i("AISDK_JSB_GetWifiListMethod", r10.toString());
        v3.h r1 = j.a(r18);
        WifiError r13 = r1.h();
        if (r13 == null) goto L9;
        Result.Companion r14 = Result.Companion;
        Object r15 = Result.constructor-impl(ResultKt.createFailure(r13));
    L69:
        if (Result.isSuccess-impl(r15) == false) goto L75;
        List r16 = (List) r15;
        g.a.i("AISDK_JSB_GetWifiListMethod", "call success, count=" + r16.size());
        Intrinsics.checkNotNullParameter(AbsGetWifiListMethodIDL.b.class, "<this>");
        BaseModel r17 = c.a(AbsGetWifiListMethodIDL.b.class);
        AbsGetWifiListMethodIDL.b r21 = (AbsGetWifiListMethodIDL.b) r17;
        List r22 = r16;
        ArrayList r23 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator r24 = r22.iterator();
    L72:
        if (r24.hasNext() == false) goto L74;
        e r25 = (e) r24.next();
        r23.add(new AbsGetWifiListMethodIDL.WifiInfo(r25.a, r25.b, r25.c, r25.d, r25.e));
        goto L72
    L74:
        r21.setWifiList(new ArrayList(r23));
        r20.b((ResultModel) r17, "");
    L75:
        Throwable r26 = Result.exceptionOrNull-impl(r15);
        if (r26 != null) goto L78;
        return;
    L78:
        if ((r26 instanceof WifiError) == false) goto L80;
        WifiError r27 = (WifiError) r26;
    L81:
        if (r27 == null) goto L84;
        f3.a r28 = r27.getErrNo();
        if (r28 == null) goto L84;
    L85:
        String r29 = r26.getMessage();
        if (r29 != null) goto L88;
        r29 = "get wifi list failed";
    L88:
        g.a.e("AISDK_JSB_GetWifiListMethod", "call failed, errNo=" + r28.a + ", msg=" + r29);
        h.a.a(r20, r29, r28, null, 10);
        return;
    L84:
        r28 = f3.a.f;
        goto L85
    L80:
        r27 = null;
        goto L81
    L9:
        Context r30 = r1.j();
        if (r30 != null) goto L12;
        Result.Companion r31 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(new WifiError(f3.a.f, "context is null")));
        goto L69
    L12:
        LinkedHashMap r32 = new LinkedHashMap();
        v3.d.a.getClass();
        e r33 = v3.d.f(r30, false);
        if (r33 == null) goto L15;
        r32.put(v3.h.i(r33), r33);
    L15:
        Intrinsics.checkNotNullParameter(r30, "context");
        WifiManager r34 = v3.d.g(r30);
        if (r34 != null) goto L90;
        List r35 = CollectionsKt.emptyList();
    L63:
        Iterator r36 = r35.iterator();
    L65:
        if (r36.hasNext() == false) goto L67;
        e r37 = (e) r36.next();
        r32.put(v3.h.i(r37), r37);
        goto L65
    L67:
        Result.Companion r38 = Result.Companion;
        r15 = Result.constructor-impl(CollectionsKt.toList(r32.values()));
        goto L69
    L90:
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L20
        Result.constructor-impl(Boolean.valueOf(v3.d.c(r34)));     // Catch: Throwable -> L20
    L92:
        Object r40 = Result.constructor-impl(v3.d.b(r34));     // Catch: Throwable -> L24
    L26:
        List r41 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r40) == false) goto L29;
        r40 = r41;
    L29:
        List r42 = (List) r40;
        Intrinsics.checkNotNull(r42);
        ArrayList r43 = new ArrayList();
        Iterator r44 = r42.iterator();
    L30:
        boolean r45 = true;
        if (r44.hasNext() == false) goto L56;
        ScanResult r46 = (ScanResult) r44.next();
        v3.d r47 = v3.d.a;
        Intrinsics.checkNotNull(r46);
        r47.getClass();
        String r48 = r46.SSID;
        Intrinsics.checkNotNull(r48);
        if ((!StringsKt.isBlank(r48)) == false) goto L35;
        String r110 = r48;
    L36:
        if (r110 != null) goto L38;
        e r49 = null;
    L54:
        if (r49 == null) goto L30;
        r43.add(r49);
        goto L30
    L38:
        String r111 = v3.d.e(r46.BSSID);
        Boolean r112 = Boolean.valueOf(v3.d.d(r46));
        int r50 = r46.level;
        if ((-126) > r50) goto L42;
        if (r50 >= 0) goto L42;
        boolean r113 = true;
    L43:
        if (r113 == true) goto L45;
        Double r114 = null;
    L46:
        Integer r51 = Integer.valueOf(r46.frequency);
        if (r51.intValue() > 0) goto L50;
        r45 = false;
    L50:
        if (r45 == false) goto L52;
        Integer r115 = r51;
    L53:
        r49 = new e(r110, r111, r112, r114, r115);
        goto L54
    L52:
        r115 = null;
        goto L53
    L45:
        r114 = Double.valueOf(WifiManager.calculateSignalLevel(r50, 101));
    L42:
        r113 = false;
        goto L43
    L35:
        r110 = null;
        goto L36
    L56:
        HashSet r52 = new HashSet();
        ArrayList r53 = new ArrayList();
        Iterator r54 = r43.iterator();
    L58:
        if (r54.hasNext() == false) goto L62;
        Object r55 = r54.next();
        e r116 = (e) r55;
        if (r52.add(CollectionsKt.listOf(new String[]{r116.a, r116.b})) == false) goto L58;
        r53.add(r55);
        goto L58
    L62:
        r35 = CollectionsKt.sortedWith(r53, new v3.c());
    L24:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        r40 = Result.constructor-impl(ResultKt.createFailure(th));
    L20:
        th = move-exception;
        Result.Companion r57 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L92
    L5:
        r12 = null;
        goto L6
    }
}
