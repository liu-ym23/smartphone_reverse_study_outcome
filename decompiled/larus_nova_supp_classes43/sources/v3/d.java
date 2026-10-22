package v3;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    public static WifiInfo a(WifiManager r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r12 = (g06.a) ApiHookConfig.b.get(102301);
        if (r12 == null) goto L5;
        f06.a[] r13 = r12.i;
    L6:
        f06.a[] r15 = r13;
        int r14 = r15.length;
        int r16 = 0;
    L8:
        if (r16 >= r14) goto L15;
        f06.a r17 = r15[r16];
        int r19 = r16;
        int r110 = r14;
        f06.d r20 = r17.preInvoke(102301, "android/net/wifi/WifiManager", "getConnectionInfo", r18, r10, "android.net.wifi.WifiInfo", r11);     // Catch: Exception -> L22
        if (r20.a == true) goto L17;
        r0.add(r17);     // Catch: Exception -> L22
    L17:
        if (r20.a == false) goto L21;
        return (WifiInfo) r20.b;
    L21:
        return r18.getConnectionInfo();
    L14:
        r16 = r19 + 1;
        r14 = r110;
        goto L8
    L15:
        r20 = new f06.d(false, null);
        goto L17
    L5:
        r13 = ApiHookConfig.d;
        goto L6
    }

    public static List b(WifiManager r13) {
        f06.c r10 = new f06.c();
        Object[] r11 = new Object[0];
        f06.b r12 = new f06.b();
        f06.d r14 = r10.b(102300, "android/net/wifi/WifiManager", "getScanResults", r13, r11, "java.util.List", r12);
        if (r14.a == false) goto L6;
        r10.a(102300, "android/net/wifi/WifiManager", "getScanResults", r13, r11, null, r12, false);
        return (List) r14.b;
    L6:
        List<ScanResult> r15 = r13.getScanResults();
        r10.a(102300, "android/net/wifi/WifiManager", "getScanResults", r13, r11, r15, r12, true);
        return r15;
    }

    public static boolean c(WifiManager r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r12 = (g06.a) ApiHookConfig.b.get(102302);
        if (r12 == null) goto L5;
        f06.a[] r13 = r12.i;
    L6:
        f06.a[] r15 = r13;
        int r14 = r15.length;
        int r16 = 0;
    L8:
        if (r16 >= r14) goto L15;
        f06.a r17 = r15[r16];
        int r19 = r16;
        int r110 = r14;
        f06.d r20 = r17.preInvoke(102302, "android/net/wifi/WifiManager", "startScan", r18, r10, "boolean", r11);     // Catch: Exception -> L22
        if (r20.a == true) goto L17;
        r0.add(r17);     // Catch: Exception -> L22
    L17:
        if (r20.a == false) goto L21;
        return ((Boolean) r20.b).booleanValue();
    L21:
        return r18.startScan();
    L14:
        r16 = r19 + 1;
        r14 = r110;
        goto L8
    L15:
        r20 = new f06.d(false, null);
        goto L17
    L5:
        r13 = ApiHookConfig.d;
        goto L6
    }

    public static boolean d(ScanResult r10) {
        String r11 = r10.capabilities;
        if (r11 != null) goto L6;
        r11 = "";
    L6:
        if (StringsKt.contains(r11, "WEP", true) == false) goto L8;
        return true;
    L8:
        if (StringsKt.contains(r11, "WPA", true) == false) goto L10;
        return true;
    L10:
        if (StringsKt.contains(r11, "SAE", true) == false) goto L12;
        return true;
    L12:
        if (StringsKt.contains(r11, "EAP", true) == false) goto L14;
        return true;
    L14:
        if (StringsKt.contains(r11, "OWE", true) == true) goto L22;
        return false;
    L22:
        return true;
    }

    public static String e(String r10) {
        if (r10 == null) goto L20;
        boolean r11 = true;
        if ((!StringsKt.isBlank(r10)) == true) goto L8;
        r10 = null;
    L8:
        if (r10 == null) goto L21;
        String r12 = r10.toLowerCase(Locale.ROOT);
        if (r12 != null) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(r12, "02:00:00:00:00:00") == false) goto L14;
    L16:
        r11 = false;
    L17:
        if (r11 == true) goto L19;
        return null;
    L19:
        return r12;
    L14:
        if (Intrinsics.areEqual(r12, "00:00:00:00:00:00") == true) goto L16;
    L21:
        return null;
    L20:
        return null;
    }

    public static WifiManager g(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Context r0 = r1.getApplicationContext();
        if (r0 == null) goto L6;
        r1 = r0;
    L6:
        Object r10 = r1.getSystemService("wifi");
        if ((r10 instanceof WifiManager) == true) goto L11;
        return null;
    L11:
        return (WifiManager) r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static e f(Context r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r23, "context");
        WifiManager r1 = g(r23);
        if (r1 != null) goto L118;
        return null;
    L118:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r10 = Result.constructor-impl(a(r1));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r10) == false) goto L12;
        r10 = null;
    L12:
        WifiInfo r11 = (WifiInfo) r10;
        if (r11 != null) goto L15;
        return null;
    L15:
        ArrayList r12 = new ArrayList();
        boolean r13 = false;
        Object[] r14 = new Object[0];
        f06.b r15 = new f06.b();
        g06.a r16 = (g06.a) ApiHookConfig.b.get(101000);
        if (r16 == null) goto L18;
        f06.a[] r17 = r16.i;
    L19:
        f06.a[] r18 = r17;
        int r19 = r18.length;
        int r20 = 0;
    L21:
        if (r20 >= r19) goto L28;
        f06.a r21 = r18[r20];
        int r110 = r20;
        int r111 = r19;
        f06.a[] r22 = r18;
        f06.d r25 = r21.preInvoke(101000, "android/net/wifi/WifiInfo", "getSSID", r11, r14, "java.lang.String", r15);     // Catch: Exception -> L113
        if (r25.a == true) goto L30;
        r12.add(r21);     // Catch: Exception -> L113
    L30:
        if (r25.a == false) goto L32;
        String r26 = (String) r25.b;
    L34:
        if (r26 == null) goto L47;
        String r27 = StringsKt.trim(r26).toString();
        if (r27 == null) goto L47;
        String r28 = StringsKt.removeSurrounding(r27, "\"");
        if (r28 == null) goto L47;
        if ((!StringsKt.isBlank(r28)) == true) goto L42;
    L44:
        boolean r29 = false;
    L45:
        if (r29 == false) goto L47;
        String r112 = r28;
    L48:
        if (r112 != null) goto L51;
        return null;
    L51:
        ArrayList r30 = new ArrayList();
        Object[] r113 = new Object[0];
        f06.b r114 = new f06.b();
        g06.a r31 = (g06.a) ApiHookConfig.b.get(101100);
        if (r31 == null) goto L54;
        f06.a[] r32 = r31.i;
    L55:
        f06.a[] r115 = r32;
        int r33 = r115.length;
        int r34 = 0;
    L57:
        if (r34 >= r33) goto L64;
        f06.a r35 = r115[r34];
        int r210 = r34;
        int r211 = r33;
        f06.a[] r212 = r115;
        f06.d r36 = r35.preInvoke(101100, "android/net/wifi/WifiInfo", "getBSSID", r11, r113, "java.lang.String", r114);     // Catch: Exception -> L112
        if (r36.a == true) goto L61;
        r30.add(r35);     // Catch: Exception -> L112
        goto L63
    L61:
        Boolean r37 = null;
    L66:
        if (r36.a == false) goto L68;
        String r38 = (String) r36.b;
    L69:
        String r39 = e(r38);
        if (r24 == true) goto L72;
        Result.Companion r40 = Result.Companion;     // Catch: Throwable -> L75
        Object r41 = Result.constructor-impl(b(r1));     // Catch: Throwable -> L75
    L77:
        List r42 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r41) == false) goto L80;
        r41 = r42;
    L80:
        Iterator r43 = ((List) r41).iterator();
    L82:
        if (r43.hasNext() == false) goto L92;
        Object r44 = r43.next();
        ScanResult r45 = (ScanResult) r44;
        if (Intrinsics.areEqual(r45.SSID, r112) == false) goto L89;
        if (r39 == null) goto L88;
        d r46 = a;
        String r47 = r45.BSSID;
        r46.getClass();
        if (Intrinsics.areEqual(e(r47), r39) == false) goto L89;
    L88:
        boolean r48 = true;
    L90:
        if (r48 == false) goto L82;
    L93:
        ScanResult r49 = (ScanResult) r44;
        int r50 = r11.getRssi();
        if ((-126) > r50) goto L97;
        if (r50 >= 0) goto L97;
        boolean r51 = true;
    L98:
        if (r51 == true) goto L100;
        Double r52 = r37;
    L101:
        Integer r53 = Integer.valueOf(r11.getFrequency());
        if (r53.intValue() <= 0) goto L104;
        r13 = true;
    L104:
        if (r13 == false) goto L106;
        Integer r54 = r53;
    L108:
        if (r49 == null) goto L111;
        r37 = Boolean.valueOf(d(r49));
    L111:
        return new e(r112, r39, r37, r52, r54);
    L106:
        r54 = r37;
        goto L108
    L100:
        r52 = Double.valueOf(WifiManager.calculateSignalLevel(r50, 101));
    L97:
        r51 = false;
    L89:
        r48 = false;
        goto L90
    L92:
        r44 = r37;
    L75:
        th = move-exception;
        Result.Companion r55 = Result.Companion;
        r41 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L77
    L72:
        return new e(r112, r39, null, null, null);
    L68:
        r38 = r11.getBSSID();
    L63:
        r34 = r210 + 1;
        r33 = r211;
        r115 = r212;
        goto L57
    L64:
        r37 = null;
        r36 = new f06.d(false, null);
        goto L66
    L54:
        r32 = ApiHookConfig.d;
        goto L55
    L42:
        if (Intrinsics.areEqual(r28, "<unknown ssid>") == true) goto L44;
        r29 = true;
    L47:
        r112 = null;
        goto L48
    L32:
        r26 = r11.getSSID();
    L27:
        r20 = r110 + 1;
        r19 = r111;
        r18 = r22;
        goto L21
    L28:
        r25 = new f06.d(false, null);
        goto L30
    L18:
        r17 = ApiHookConfig.d;
    L7:
        th = move-exception;
        Result.Companion r56 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }
}
