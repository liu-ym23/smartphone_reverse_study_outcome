package com.bytedance.android.ec.core.cps;

import android.content.Context;
import android.media.MediaDrm;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.util.Base64;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.bpea.cert.token.TokenCert;
import java.io.File;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Locale;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final boolean a(String r10) {
        if (r10.length() < 2) goto L10;
        String r1 = r10.substring(0, 1);
        String r11 = r10.substring(1);
        if (new Regex("[a-zA-Z]+").matches(r1) == true) goto L7;
        return false;
    L7:
        if (new Regex("[0-9]+").matches(r11) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public static final Object b(String r10, Continuation r11) {
        if ((r11 instanceof CyberProtectionInjectorKt$encodeByBDSword$1) == false) goto L7;
        CyberProtectionInjectorKt$encodeByBDSword$1 r0 = (CyberProtectionInjectorKt$encodeByBDSword$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r14 = r0.label;
        if (r14 == 0) goto L15;
        if (r14 != 1) goto L14;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L21
    L19:
        return (String) r12;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r12);
        CoroutineDispatcher r15 = Dispatchers.getDefault();     // Catch: Throwable -> L21
        CyberProtectionInjectorKt$encodeByBDSword$2 r16 = new CyberProtectionInjectorKt$encodeByBDSword$2(r10, null);     // Catch: Throwable -> L21
        r0.label = 1;     // Catch: Throwable -> L21
        r12 = BuildersKt.withContext(r15, r16, r0);     // Catch: Throwable -> L21
        if (r12 != r13) goto L19;
        return r13;
    L22:
        return null;
    L7:
        r0 = new CyberProtectionInjectorKt$encodeByBDSword$1(r11);
        goto L8
    }

    public static final Object c(String r10, Continuation r11) {
        if ((r11 instanceof CyberProtectionInjectorKt$paramsOfKey$1) == false) goto L7;
        CyberProtectionInjectorKt$paramsOfKey$1 r0 = (CyberProtectionInjectorKt$paramsOfKey$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean r14 = false;
        String r15 = null;
        switch(r0.label) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L19;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            case 10: goto L13;
            case 11: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r12);
    L152:
        r15 = (String) r12;
    L198:
        if (r15 != null) goto L200;
    L201:
        r14 = true;
    L202:
        if (r14 == false) goto L205;
        return "none";
    L205:
        return r15;
    L200:
        if (StringsKt.isBlank(r15) == false) goto L202;
    L13:
        ResultKt.throwOnFailure(r12);
    L184:
        r15 = (String) r12;
        goto L198
    L14:
        ResultKt.throwOnFailure(r12);
    L190:
        r15 = (String) r12;
        goto L198
    L15:
        ResultKt.throwOnFailure(r12);
    L105:
        r15 = (String) r12;
        goto L198
    L16:
        ResultKt.throwOnFailure(r12);
    L117:
        r15 = (String) r12;
        goto L198
    L17:
        ResultKt.throwOnFailure(r12);
    L136:
        Float r16 = (Float) r12;
        if (r16 == null) goto L198;
        r15 = String.valueOf(r16.floatValue());
        goto L198
    L18:
        ResultKt.throwOnFailure(r12);
    L144:
        Integer r17 = (Integer) r12;
        if (r17 == null) goto L198;
        r15 = String.valueOf(r17.intValue());
        goto L198
    L19:
        ResultKt.throwOnFailure(r12);
    L63:
        Long r18 = (Long) r12;
        if (r18 == null) goto L198;
        r15 = String.valueOf(r18.longValue());
        goto L198
    L20:
        ResultKt.throwOnFailure(r12);
    L71:
        Long r19 = (Long) r12;
        if (r19 == null) goto L198;
        r15 = String.valueOf(r19.longValue());
        goto L198
    L21:
        ResultKt.throwOnFailure(r12);
    L36:
        r15 = (String) r12;
        goto L198
    L22:
        ResultKt.throwOnFailure(r12);
    L42:
        Long r110 = (Long) r12;
        if (r110 == null) goto L198;
        r15 = String.valueOf(r110.longValue());
        goto L198
    L23:
        ResultKt.throwOnFailure(r12);
        CyberProtectionCollector r111 = CyberProtectionCollector.a;
        Locale r20 = Locale.getDefault();
        if (r10 == null) goto L207;
        String r21 = r10.toUpperCase(r20);
        int r22 = r21.hashCode();
        switch(r22) {
            case 2064: goto L54;
            case 2065: goto L49;
            case 2066: goto L46;
            case 2067: goto L38;
            case 2068: goto L32;
            default: goto L27;
        };
    L27:
        switch(r22) {
            case 2157: goto L97;
            case 2158: goto L92;
            case 2159: goto L87;
            case 2160: goto L84;
            case 2161: goto L81;
            case 2162: goto L78;
            case 2163: goto L75;
            case 2164: goto L67;
            case 2165: goto L59;
            default: goto L210;
        };
    L210:
        switch(r22) {
            case 66915: goto L140;
            case 66916: goto L132;
            case 66917: goto L125;
            case 66918: goto L123;
            case 66919: goto L119;
            case 66920: goto L113;
            case 66921: goto L110;
            case 66922: goto L107;
            case 66923: goto L101;
            case 66924: goto L99;
            default: goto L29;
        };
    L29:
        switch(r22) {
            case 66946: goto L192;
            case 66947: goto L186;
            case 66948: goto L180;
            case 66949: goto L154;
            case 66950: goto L148;
            default: goto L198;
        };
    L148:
        if (r21.equals("D24") == false) goto L198;
        r0.label = 11;
        r12 = b.h(r0);
        if (r12 != r13) goto L152;
        return r13;
    L154:
        if (r21.equals("D23") == false) goto L198;
        Context r23 = b.m();
        if (r23 == null) goto L198;
        WifiManager r24 = (WifiManager) r23.getApplicationContext().getSystemService("wifi");
        if (r24.isWifiEnabled() == false) goto L164;
        TokenCert r112 = TokenCert.with("bpea-ec_debug_tools_connection_info");
        int r25 = com.bytedance.bpea.entry.api.device.info.h.a;
        WifiInfo r26 = com.bytedance.bpea.entry.api.device.info.h.a.a(r24, r112);
        if (r26 == null) goto L198;
        TokenCert r113 = TokenCert.with("bpea-ec_debug_tools_connection_info");
        int r27 = com.bytedance.bpea.entry.api.device.info.g.a;
        Integer r28 = com.bytedance.bpea.entry.api.device.info.g.a.a(r26, r113);
        if (r28 == null) goto L198;
        int r29 = r28.intValue();
        String r30 = (r29 & 255) + "." + ((r29 >> 8) & 255) + "." + ((r29 >> 16) & 255) + "." + ((r29 >> 24) & 255);
    L52:
        r15 = r30;
        goto L198
    L164:
        TokenCert r31 = TokenCert.with("bpea-ec_debug_tools_connection_info");     // Catch: Exception -> L208
        int r114 = com.bytedance.bpea.entry.api.device.info.c.a;     // Catch: Exception -> L208
        Enumeration r32 = com.bytedance.bpea.entry.api.device.info.c.a.a(r31);     // Catch: Exception -> L208
    L165:
        if (r32 == null) goto L198;
        if (r32.hasMoreElements() == false) goto L198;
        Enumeration<InetAddress> r115 = ((NetworkInterface) r32.nextElement()).getInetAddresses();     // Catch: Exception -> L208
    L170:
        if (r115.hasMoreElements() == false) goto L165;
        InetAddress r33 = r115.nextElement();     // Catch: Exception -> L208
        if (r33.isLoopbackAddress() == true) goto L170;
        if (r33.isLinkLocalAddress() == true) goto L170;
        if ((r33 instanceof Inet4Address) == false) goto L170;
        TokenCert r34 = TokenCert.with("bpea-ec_debug_tools_connection_info");     // Catch: Exception -> L208
        int r116 = com.bytedance.bpea.entry.api.device.info.b.a;     // Catch: Exception -> L208
        r30 = com.bytedance.bpea.entry.api.device.info.b.a.a((Inet4Address) r33, r34);     // Catch: Exception -> L208
    L209:
    L180:
        if (r21.equals("D22") == false) goto L198;
        r0.label = 10;
        r12 = b.j(r0);
        if (r12 != r13) goto L184;
        return r13;
    L186:
        if (r21.equals("D21") == false) goto L198;
        r0.label = 9;
        r12 = b.g(r0);
        if (r12 != r13) goto L190;
        return r13;
    L192:
        if (r21.equals("D20") == false) goto L198;
        Context r35 = b.m();
        if (r35 == null) goto L198;
        File r36 = r35.getExternalFilesDir(null);
        if (r36 == null) goto L198;
        r30 = r36.getAbsolutePath();
        goto L52
    L99:
        r21.equals("D19");
        goto L198
    L123:
        r21.equals("D13");
        goto L198
    L101:
        if (r21.equals("D18") == false) goto L198;
        r0.label = 8;
        r12 = b.f(r0);
        if (r12 != r13) goto L105;
        return r13;
    L107:
        if (r21.equals("D17") == false) goto L198;
        r15 = String.valueOf(SystemClock.uptimeMillis());
        goto L198
    L110:
        if (r21.equals("D16") == false) goto L198;
        r15 = String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        goto L198
    L113:
        if (r21.equals("D15") == false) goto L198;
        r0.label = 7;
        r12 = BuildersKt.withContext(Dispatchers.getIO(), new CyberProtectionCollector$oaid$2(null), r0);
        if (r12 != r13) goto L117;
        return r13;
    L119:
        if (r21.equals("D14") == false) goto L198;
        r30 = Base64.encodeToString(new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L)).getPropertyByteArray("deviceUniqueId"), 2);     // Catch: Exception -> L208
        goto L209
    L125:
        if (r21.equals("D12") == false) goto L198;
        Context r37 = b.m();
        if (r37 == null) goto L130;
        int r117 = com.bytedance.bpea.entry.api.device.info.f.a;
        r30 = com.bytedance.bpea.entry.api.device.info.f.a.a(r37, TokenCert.Companion.with("bpea-track_sdk_get_device_info"));
        if (r30 != null) goto L52;
    L130:
        r30 = "android_id";
        goto L52
    L132:
        if (r21.equals("D11") == false) goto L198;
        r0.label = 6;
        r12 = b.e(r0);
        if (r12 != r13) goto L136;
        return r13;
    L140:
        if (r21.equals("D10") == false) goto L198;
        r0.label = 5;
        r12 = b.d(r0);
        if (r12 != r13) goto L144;
        return r13;
    L59:
        if (r21.equals("D9") == false) goto L198;
        r0.label = 4;
        r12 = b.c(r0);
        if (r12 != r13) goto L63;
        return r13;
    L67:
        if (r21.equals("D8") == false) goto L198;
        r0.label = 3;
        r12 = b.k(r0);
        if (r12 != r13) goto L71;
        return r13;
    L75:
        if (r21.equals("D7") == false) goto L198;
        r15 = String.valueOf(System.currentTimeMillis());
        goto L198
    L78:
        if (r21.equals("D6") == false) goto L198;
        r15 = Build.VERSION.RELEASE;
        goto L198
    L81:
        if (r21.equals("D5") == false) goto L198;
        r15 = "android";
        goto L198
    L84:
        if (r21.equals("D4") == false) goto L198;
        r15 = Build.SUPPORTED_ABIS[0];
        goto L198
    L87:
        if (r21.equals("D3") == false) goto L198;
        r30 = Build.MODEL;
        if (com.bytedance.android.shopping.extensions.k.c(r30) == false) goto L198;
    L92:
        if (r21.equals("D2") == false) goto L198;
        r30 = Build.MANUFACTURER;
        if (com.bytedance.android.shopping.extensions.k.c(r30) == false) goto L198;
    L97:
        if (r21.equals("D1") == false) goto L198;
        r15 = ECAppInfoService.e.getServerDeviceId();
        goto L198
    L32:
        if (r21.equals("A5") == false) goto L198;
        r0.label = 2;
        r12 = r111.a(r0);
        if (r12 != r13) goto L36;
        return r13;
    L38:
        if (r21.equals("A4") == false) goto L198;
        r0.label = 1;
        r12 = b.b(r0);
        if (r12 != r13) goto L42;
        return r13;
    L46:
        if (r21.equals("A3") == false) goto L198;
        r15 = String.valueOf(44700);
        goto L198
    L49:
        if (r21.equals("A2") == false) goto L198;
        r30 = ECAppInfoService.e.getAppVersion();
        if (com.bytedance.android.shopping.extensions.k.c(r30) == false) goto L198;
    L54:
        if (r21.equals("A1") == false) goto L198;
        r30 = ECAppInfoService.e.getAppId();
        if (com.bytedance.android.shopping.extensions.k.c(r30) == false) goto L198;
    L207:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r0 = new CyberProtectionInjectorKt$paramsOfKey$1(r11);
        goto L8
    }
}
