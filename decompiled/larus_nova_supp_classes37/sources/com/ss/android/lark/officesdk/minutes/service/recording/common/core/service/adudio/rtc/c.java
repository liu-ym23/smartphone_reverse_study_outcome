package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.rtc;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.PackageChannelManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final String a;
    public final boolean b;
    public final MmRtcInitInfo c;
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a d;
    public final JSONObject e;
    public final boolean f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmRtcVendorType.values().length];
            r0[MmRtcVendorType.VENDOR_TYPE_LARKRTC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[MmRtcVendorType.VENDOR_TYPE_RTC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[MmRtcVendorType.VENDOR_TYPE_LARKPRERTC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[MmRtcVendorType.VENDOR_TYPE_TEST_PRE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[MmRtcVendorType.VENDOR_TYPE_TEST_GAUSS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[MmRtcVendorType.VENDOR_TYPE_TEST.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public static String b(Map r7) {
        Set r8 = r7.entrySet();
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r9 = r8.iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r9.next();
        r0.add(TuplesKt.to(r1.getKey(), r1.getValue().toString()));
        goto L4
    L6:
        ArrayList r10 = new ArrayList();
        Iterator r2 = r0.iterator();
    L7:
        int r3 = 0;
        if (r2.hasNext() == false) goto L19;
        Object r4 = r2.next();
        Pair r5 = (Pair) r4;
        if (((CharSequence) r5.getFirst()).length() <= 0) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L15;
    L17:
        if (r3 == 0) goto L7;
        r10.add(r4);
        goto L7
    L15:
        if ((!StringsKt.isBlank((CharSequence) r5.getSecond())) == false) goto L17;
        r3 = 1;
        goto L17
    L12:
        r6 = false;
        goto L13
    L19:
        List r11 = CollectionsKt.toList(r10);
        if (r11.isEmpty() == false) goto L23;
        return "";
    L23:
        StringBuilder r12 = new StringBuilder();
        Iterator r13 = r11.iterator();
    L25:
        if (r13.hasNext() == false) goto L34;
        Object r14 = r13.next();
        int r15 = r3 + 1;
        if (r3 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        Pair r16 = (Pair) r14;
        r12.append((String) r16.getFirst());
        r12.append("=");
        r12.append((String) r16.getSecond());
        if (r3 >= (r11.size() - 1)) goto L32;
        r12.append(fyb.a.COMMA);
    L32:
        r3 = r15;
        goto L25
    L34:
        return r12.toString();
    }

    public c(boolean r3, MmRtcInitInfo r4, com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r5) {
        Intrinsics.checkNotNullParameter("MmRtcWrapper", "logTag");
        Intrinsics.checkNotNullParameter(r4, "rtcData");
        Intrinsics.checkNotNullParameter(r5, "userComponentContext");
        this.a = "MmRtcWrapper";
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = new JSONObject();
        this.f = true;
    }

    public final void a(JSONObject r8, MmRtcVendorType r9, boolean r10) {
        Application r0 = LarkContext.getApplication();
        if (PackageChannelManager.isKABuildPackage(r0) == false) goto L5;
        String r1 = PackageChannelManager.getBuildPackageChannel(r0);
        Intrinsics.checkNotNull(r1);
    L6:
        zub.a r2 = this.d.J();
        switch(a.a[r9.ordinal()]) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L19;
            case 4: goto L16;
            case 5: goto L13;
            case 6: goto L10;
            default: goto L9;
        };
    L10:
        if (r10 == false) goto L12;
        String r3 = "lark_test_rtc";
    L25:
        lvb.a.e(this.a, "[getDomainKey] domainKey:" + r3 + ", vendorType: " + r9 + ", isMediaOversea:" + r10);
        List<String> r11 = r2.f(r3);
        List<String> r4 = this.d.J().g();
        List<String> r5 = this.d.J().e();
        lvb.a.e(this.a, "[getDomainConfig], domain: " + r11 + ", frontier: " + r4 + ", rtcDefaultIps: " + r5);
        if ((!TextUtils.equals("saas", r1)) == true) goto L30;
        r4 = null;
        r5 = null;
    L30:
        if (CollectionUtils.isEmpty(r4) == true) goto L59;
        r11 = r4;
    L59:
        JSONObject r6 = new JSONObject();     // Catch: JSONException -> L56
        int r7 = 0;
        if (r11 == null) goto L41;
        JSONArray r12 = new JSONArray();     // Catch: JSONException -> L56
        if (CollectionUtils.isEmpty(r11) == true) goto L40;
        int r13 = r11.size();     // Catch: JSONException -> L56
        int r14 = 0;
    L38:
        if (r14 >= r13) goto L40;
        r12.put(r14, ListProtector.get(r11, r14));     // Catch: JSONException -> L56
        r14 = r14 + 1;     // Catch: JSONException -> L56
    L40:
        r6.putOpt("dispatch", r12);     // Catch: JSONException -> L56
    L41:
        if (r5 != null) goto L43;
    L48:
        r8.put("rtc.domain_config", r6);     // Catch: JSONException -> L56
        if (r9 != MmRtcVendorType.VENDOR_TYPE_LARKRTC) goto L51;
    L54:
        r8.put("rtc.env", r7);     // Catch: JSONException -> L56
        return;
    L51:
        if (r9 == MmRtcVendorType.VENDOR_TYPE_RTC) goto L54;
        r7 = 2;
        goto L54
    L43:
        if (CollectionUtils.isEmpty(r5) == true) goto L48;
        JSONArray r15 = new JSONArray();     // Catch: JSONException -> L56
        int r16 = r5.size();     // Catch: JSONException -> L56
        int r17 = 0;
    L45:
        if (r17 >= r16) goto L47;
        r15.put(r17, ListProtector.get(r5, r17));     // Catch: JSONException -> L56
        r17 = r17 + 1;     // Catch: JSONException -> L56
        goto L45
    L47:
        r6.putOpt("default_ip", r15);     // Catch: JSONException -> L56
    L56:
        e = move-exception;
        lvb.a.b(this.a, "[getDomainConfig] error: " + e);
        return;
    L12:
        r3 = "feishu_test_rtc";
        goto L25
    L13:
        if (r10 == false) goto L15;
        r3 = "lark_test_gauss_rtc";
        goto L25
    L15:
        r3 = "feishu_test_gauss_rtc";
        goto L25
    L16:
        if (r10 == false) goto L18;
        r3 = "lark_test_pre_rtc";
        goto L25
    L18:
        r3 = "feishu_test_pre_rtc";
        goto L25
    L19:
        if (r10 == false) goto L21;
        r3 = "lark_pre_rtc";
        goto L25
    L21:
        r3 = "feishu_pre_rtc";
        goto L25
    L22:
        if (r10 == false) goto L24;
        r3 = "lark_rtc";
        goto L25
    L24:
        r3 = "feishu_rtc";
        goto L25
    L9:
        throw new NoWhenBranchMatchedException();
    L5:
        r1 = "saas";
        goto L6
    }
}
