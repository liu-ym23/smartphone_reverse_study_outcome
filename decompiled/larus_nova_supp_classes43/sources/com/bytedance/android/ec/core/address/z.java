package com.bytedance.android.ec.core.address;

import com.byted.cast.sink.api.IServerListener;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class z {
    public static final /* synthetic */ int a = 0;

    public static String f() {
        kc.a r0 = BtmSDK.getBcmChainByFinder$default(BtmSDK.INSTANCE, null, 1, false, 4, null);
        if (r0 == null) goto L9;
        List<kc.a.C0174a> r1 = r0.a;
        if (r1 == null) goto L9;
        kc.a.C0174a r10 = (kc.a.C0174a) CollectionsKt.firstOrNull(r1);
        if (r10 == null) goto L9;
        return r10.c;
    L9:
        return null;
    }

    public static long j() {
        return System.currentTimeMillis() / ((long) IServerListener.WHAT_BYTELINK_SINK_ERROR);
    }

    static {
    }

    public static String b(JSONObject r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getAddressId");
        return r1.optString("id");
    }

    public static String c(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$getAddressInfo");
        return b(r10) + '_' + e(r10) + '_' + d(r10);
    }

    public static String d(JSONObject r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$getAddressStrategy");
        JSONObject r10 = r1.optJSONObject("extra");
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.optString("strategy");
    }

    public static Integer e(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$getAddressType");
        Integer r11 = Integer.valueOf(r10.optInt("address_type", -1));
        if (r11.intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return null;
    L10:
        return r11;
    L5:
        r0 = false;
        goto L6
    }

    public static wi.a g(JSONObject r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$getLocation");
        JSONObject r11 = r10.optJSONObject("poi_info");
        if (r11 == null) goto L7;
        JSONObject r12 = r11.optJSONObject("coordinate");
        if (r12 == null) goto L7;
        return new wi.a(r12.optDouble("latitude"), r12.optDouble("longitude"));
    L7:
        return null;
    }

    public static float a(wi.a r14, wi.a r15) {
        if (r14 == null) goto L8;
        if (r15 == null) goto L8;
        double r0 = r14.b;     // Catch: Throwable -> L6
        double r10 = r14.a;     // Catch: Throwable -> L6
        double r1 = r0 * 0.01745329251994329d;     // Catch: Throwable -> L6
        double r11 = r10 * 0.01745329251994329d;     // Catch: Throwable -> L6
        double r12 = r15.b * 0.01745329251994329d;     // Catch: Throwable -> L6
        double r16 = r15.a * 0.01745329251994329d;     // Catch: Throwable -> L6
        double r13 = Math.sin(r1);     // Catch: Throwable -> L6
        double r17 = Math.sin(r11);     // Catch: Throwable -> L6
        double r18 = Math.cos(r1);     // Catch: Throwable -> L6
        double r19 = Math.cos(r11);     // Catch: Throwable -> L6
        double r110 = Math.sin(r12);     // Catch: Throwable -> L6
        double r111 = Math.sin(r16);     // Catch: Throwable -> L6
        double r20 = Math.cos(r12);     // Catch: Throwable -> L6
        double r112 = Math.cos(r16);     // Catch: Throwable -> L6
        double r21 = (r18 * r19) - (r20 * r112);     // Catch: Throwable -> L6
        double r22 = (r19 * r13) - (r112 * r110);     // Catch: Throwable -> L6
        double r23 = r17 - r111;     // Catch: Throwable -> L6
        return (float) (Math.asin(Math.sqrt(((r21 * r21) + (r22 * r22)) + (r23 * r23)) / 2.0d) * 1.27420015798544E7d);
    L6:
        th = move-exception;
        ECExceptionMonitor.e(th);
    L9:
        return 0.0f;
    L8:
        int r24 = AddressSDKLog.a;
        AddressSDKLog.a("坐标异常 first=" + String.valueOf(r14) + " second=" + String.valueOf(r15), false);
        goto L9
    }

    public static boolean i(JSONObject r10, JSONObject r11) {
        Integer r0 = null;
        if (r11 == null) goto L5;
        String r1 = b(r11);
    L6:
        if (r11 == null) goto L9;
        r0 = e(r11);
    L9:
        return h(r10, r1, r0);
    L5:
        r1 = null;
        goto L6
    }

    public static String k(String r1, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_LUBAN_TAG);
        if (r10 != null) goto L6;
        return "";
    L6:
        return r1 + '=' + c(r10);
    }

    public static boolean h(JSONObject r10, String r11, Integer r12) {
        Integer r0 = null;
        if (r10 == null) goto L5;
        String r1 = b(r10);
    L6:
        if (r10 == null) goto L8;
        r0 = e(r10);
    L8:
        if (r1 != null) goto L10;
    L15:
        return false;
    L10:
        if (Intrinsics.areEqual(r1, r11) == false) goto L15;
        if (r0 == null) goto L15;
        if (Intrinsics.areEqual(r0, r12) == false) goto L15;
        return true;
    L5:
        r1 = null;
        goto L6
    }
}
