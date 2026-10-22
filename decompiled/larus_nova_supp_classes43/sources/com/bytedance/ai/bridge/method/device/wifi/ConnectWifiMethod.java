package com.bytedance.ai.bridge.method.device.wifi;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.MacAddress;
import android.net.NetworkRequest;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiNetworkSpecifier;
import android.os.Build;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.device.wifi.AbsConnectWifiMethodIDL;
import com.bytedance.ai.utils.g;
import d3.a0;
import e3.d;
import f3.b;
import f3.h;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import v3.f;
import v3.i;
import v3.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ai/bridge/method/device/wifi/ConnectWifiMethod;", "Lcom/bytedance/ai/bridge/device/wifi/AbsConnectWifiMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/device/wifi/AbsConnectWifiMethodIDL$ConnectWifiParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/device/wifi/AbsConnectWifiMethodIDL$EmptyMessageModel;", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConnectWifiMethod extends AbsConnectWifiMethodIDL {
    public static final /* synthetic */ int b = 0;

    public static final class a {
    }

    static {
    }

    public ConnectWifiMethod() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Runnable, v3.g] */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.lang.Object, v3.a] */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r19, ParamModel r20, final h r21) {
        AbsConnectWifiMethodIDL.a r1 = (AbsConnectWifiMethodIDL.a) r20;
        Intrinsics.checkNotNullParameter(r19, "bridgeContext");
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r21, "callback");
        g r10 = g.a;
        StringBuilder r11 = new StringBuilder("call start, hasSsid=");
        boolean r12 = false;
        if (r1.getSsid().length() <= 0) goto L5;
        boolean r13 = true;
    L6:
        r11.append(r13);
        r11.append(", hasBssid=");
        String r14 = r1.getBssid();
        if (r14 != null) goto L9;
    L12:
        boolean r15 = true;
    L13:
        r11.append(!r15);
        r11.append(", manual=");
        Boolean r16 = r1.getManual();
        Boolean r17 = Boolean.TRUE;
        r11.append(Intrinsics.areEqual(r16, r17));
        r11.append(", appletId=");
        a0 r18 = r19.getContainerContext();
        Object r110 = null;
        if (r18 == null) goto L16;
        String r22 = r18.getAppletId();
    L17:
        r11.append(r22);
        r10.i("AISDK_JSB_ConnectWifiMethod", r11.toString());
        final v3.h r23 = j.a(r19);
        String r24 = r1.getSsid();
        String r25 = r1.getPassword();
        String r26 = r1.getBssid();
        boolean r27 = Intrinsics.areEqual(r1.getManual(), r17);
        final ?? r28 = new v3.a(r21);
        Intrinsics.checkNotNullParameter(r24, "ssid");
        Intrinsics.checkNotNullParameter(r25, "password");
        Intrinsics.checkNotNullParameter(r28, "completion");
        if (r27 == false) goto L32;
        Context r0 = r23.j();
        if (r0 != null) goto L175;
        Object r29 = new WifiError(f3.a.f, "context is null");
    L31:
        r28.invoke(r29);
        return;
    L175:
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L24
        Intent r31 = new Intent("android.settings.WIFI_SETTINGS");     // Catch: Throwable -> L24
        r31.addFlags(268435456);     // Catch: Throwable -> L24
        r0.startActivity(r31);     // Catch: Throwable -> L24
        Object r32 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r33 = Result.exceptionOrNull-impl(r32);
        if (r33 != null) goto L29;
        Unit r34 = (Unit) r32;
    L30:
        r29 = r110;
        goto L31
    L29:
        r110 = new WifiError(f3.a.f, "open wifi settings failed: " + r33.getMessage());
    L24:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L32:
        WifiError r36 = r23.h();
        if (r36 == null) goto L35;
        r28.invoke(r36);
        return;
    L35:
        final Context r111 = r23.j();
        if (r111 != null) goto L39;
        r28.invoke(new WifiError(f3.a.f, "context is null"));
        return;
    L39:
        if (StringsKt.isBlank(r24) == false) goto L42;
        r28.invoke(new WifiError(f3.a.h, "ssid is empty"));
        return;
    L42:
        if (Build.VERSION.SDK_INT < 29) goto L103;
        Object r37 = r111.getSystemService("connectivity");
        if ((r37 instanceof ConnectivityManager) == false) goto L46;
        ConnectivityManager r38 = (ConnectivityManager) r37;
    L47:
        if (r38 != null) goto L173;
        r28.invoke(new WifiError(f3.a.g, "connectivity manager is not available"));
        return;
    L173:
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L63
        WifiNetworkSpecifier.Builder r40 = new WifiNetworkSpecifier.Builder().setSsid(r24);     // Catch: Throwable -> L63
        if (r25.length() <= 0) goto L52;
        r12 = true;
    L52:
        if (r12 == false) goto L54;
        r40.setWpa2Passphrase(r25);     // Catch: Throwable -> L63
    L54:
        if (r26 != null) goto L56;
    L61:
        Object r41 = Result.constructor-impl(new NetworkRequest.Builder().addTransportType(1).setNetworkSpecifier(r40.build()).build());     // Catch: Throwable -> L63
    L65:
        Throwable r42 = Result.exceptionOrNull-impl(r41);
        if (r42 != null) goto L102;
        NetworkRequest r43 = (NetworkRequest) r41;
        final Ref.BooleanRef r44 = new Ref.BooleanRef();
        final Ref.ObjectRef r45 = new Ref.ObjectRef();
        ?? r46 = new v3.g(r23, r28, r45, r44);
        r45.element = new i(r23, r46, r111, r28, r44, r38);
        Object r47 = r23.b;
        monitor-enter(r47);
        r23.b();     // Catch: Throwable -> L99
        r23.f = r38;     // Catch: Throwable -> L99
        Object r48 = r45.element;     // Catch: Throwable -> L99
        if (r48 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("callback");     // Catch: Throwable -> L99
        ConnectivityManager.NetworkCallback r49 = null;
    L73:
        r23.g = r49;     // Catch: Throwable -> L99
        Unit r50 = Unit.INSTANCE;     // Catch: Throwable -> L99
        monitor-exit(r47);
        Object r51 = r45.element;     // Catch: Throwable -> L81
        if (r51 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("callback");     // Catch: Throwable -> L81
        ConnectivityManager.NetworkCallback r52 = null;
    L79:
        r38.requestNetwork(r43, r52);     // Catch: Throwable -> L81
        Object r53 = Result.constructor-impl(Boolean.valueOf(r23.c.postDelayed(r46, 30000)));     // Catch: Throwable -> L81
    L83:
        Throwable r54 = Result.exceptionOrNull-impl(r53);
        if (r54 == null) goto L193;
        Object r55 = r23.b;
        monitor-enter(r55);
        ConnectivityManager.NetworkCallback r56 = r23.g;     // Catch: Throwable -> L96
        Object r57 = r45.element;     // Catch: Throwable -> L96
        if (r57 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("callback");     // Catch: Throwable -> L96
    L91:
        if (r56 != r110) goto L93;
        r23.b();     // Catch: Throwable -> L96
    L93:
        Unit r58 = Unit.INSTANCE;     // Catch: Throwable -> L96
        monitor-exit(r55);
        f3.a.C0156a r59 = f3.a.c;
        f3.a r60 = b.a;
        Intrinsics.checkNotNullParameter(r59, "<this>");
        r28.invoke(new WifiError(b.g, "connect wifi failed: " + r54.getMessage()));
        return;
    L90:
        r110 = (ConnectivityManager.NetworkCallback) r57;     // Catch: Throwable -> L96
    L96:
        th = move-exception;
        throw th;
    L193:
        return;
    L78:
        r52 = (ConnectivityManager.NetworkCallback) r51;     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        Result.Companion r61 = Result.Companion;
        r53 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L83
    L72:
        r49 = (ConnectivityManager.NetworkCallback) r48;     // Catch: Throwable -> L99
    L99:
        th = move-exception;
        throw th;
    L102:
        f3.a.C0156a r62 = f3.a.c;
        f3.a r63 = b.a;
        Intrinsics.checkNotNullParameter(r62, "<this>");
        r28.invoke(new WifiError(b.g, "build wifi request failed: " + r42.getMessage()));
        return;
    L56:
        if ((!StringsKt.isBlank(r26)) == true) goto L59;
        r26 = null;
    L59:
        if (r26 == null) goto L61;
        r40.setBssid(MacAddress.fromString(r26));     // Catch: Throwable -> L63
    L63:
        th = move-exception;
        Result.Companion r64 = Result.Companion;
        r41 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L65
    L46:
        r38 = null;
        goto L47
    L103:
        v3.d.a.getClass();
        WifiManager r65 = v3.d.g(r111);
        if (r65 != null) goto L172;
        WifiError r66 = new WifiError(f3.a.g, "wifi is not available");
    L170:
        r28.invoke(r66);
        return;
    L172:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L163
        if (r65.isWifiEnabled() == true) goto L109;
        r65.setWifiEnabled(true);     // Catch: Throwable -> L163
    L109:
        String r67 = "\"" + r24 + '\"';     // Catch: Throwable -> L163
        List r113 = v3.h.g(r65);     // Catch: Throwable -> L163
        if (r113 == null) goto L131;
        Iterator r114 = r113.iterator();     // Catch: Throwable -> L163
    L113:
        if (r114.hasNext() == false) goto L129;
        Object r115 = r114.next();     // Catch: Throwable -> L163
        WifiConfiguration r116 = (WifiConfiguration) r115;     // Catch: Throwable -> L163
        if (Intrinsics.areEqual(v3.h.e(r116), r67) == false) goto L126;
        if (r26 != null) goto L118;
    L121:
        boolean r117 = true;
    L122:
        if (r117 == false) goto L124;
    L125:
        boolean r118 = true;
    L127:
        if (r118 == false) goto L113;
    L130:
        WifiConfiguration r119 = (WifiConfiguration) r115;     // Catch: Throwable -> L163
    L132:
        if (r119 == null) goto L134;
        int r68 = r119.networkId;     // Catch: Throwable -> L163
    L153:
        if (r68 != (-1)) goto L155;
        f3.a.C0156a r69 = f3.a.c;     // Catch: Throwable -> L163
        f3.a r70 = b.a;     // Catch: Throwable -> L163
        Intrinsics.checkNotNullParameter(r69, "<this>");     // Catch: Throwable -> L163
        r66 = new WifiError(b.g, "add wifi network failed");     // Catch: Throwable -> L163
        goto L170
    L155:
        boolean r71 = r65.enableNetwork(r68, true);     // Catch: Throwable -> L163
        boolean r72 = r65.reconnect();     // Catch: Throwable -> L163
        if (r71 == false) goto L160;
        if (r72 == false) goto L160;
        r23.c.postDelayed(new f(r111), 1500);     // Catch: Throwable -> L163
    L161:
        Object r73 = Result.constructor-impl(r110);     // Catch: Throwable -> L163
    L165:
        Throwable r74 = Result.exceptionOrNull-impl(r73);
        if (r74 == null) goto L169;
        f3.a.C0156a r75 = f3.a.c;
        f3.a r76 = b.a;
        Intrinsics.checkNotNullParameter(r75, "<this>");
        r73 = new WifiError(b.g, "connect wifi failed: " + r74.getMessage());
    L169:
        r66 = (WifiError) r73;
    L160:
        f3.a.C0156a r77 = f3.a.c;     // Catch: Throwable -> L163
        f3.a r78 = b.a;     // Catch: Throwable -> L163
        Intrinsics.checkNotNullParameter(r77, "<this>");     // Catch: Throwable -> L163
        r110 = new WifiError(b.g, "connect wifi failed");     // Catch: Throwable -> L163
        goto L161
    L134:
        WifiConfiguration r120 = new WifiConfiguration();     // Catch: Throwable -> L163
        v3.h.f(r120, r67);     // Catch: Throwable -> L163
        if (r26 != null) goto L137;
    L143:
        r26 = null;
    L144:
        v3.h.d(r120, r26);     // Catch: Throwable -> L163
        if (r25.length() != 0) goto L147;
        boolean r79 = true;
    L148:
        if (r79 == false) goto L150;
        r120.allowedKeyManagement.set(0);     // Catch: Throwable -> L163
    L151:
        r68 = r65.addNetwork(r120);     // Catch: Throwable -> L163
        goto L153
    L150:
        r120.preSharedKey = '\"' + r25 + '\"';     // Catch: Throwable -> L163
        r120.allowedKeyManagement.set(1);     // Catch: Throwable -> L163
        goto L151
    L147:
        r79 = false;
        goto L148
    L137:
        if (StringsKt.isBlank(r26) == true) goto L139;
        boolean r80 = true;
    L141:
        if (Boolean.valueOf(r80).booleanValue() == false) goto L143;
    L139:
        r80 = false;
        goto L141
    L124:
        if (Intrinsics.areEqual(v3.h.c(r116), r26) == false) goto L126;
    L118:
        if (StringsKt.isBlank(r26) == true) goto L121;
        r117 = false;
    L126:
        r118 = false;
        goto L127
    L129:
        r115 = null;
        goto L130
    L131:
        r119 = null;
    L163:
        th = move-exception;
        Result.Companion r81 = Result.Companion;
        r73 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L165
    L16:
        r22 = null;
        goto L17
    L9:
        if (r14.length() == 0) goto L12;
        r15 = false;
        goto L13
    L5:
        r13 = false;
        goto L6
    }
}
