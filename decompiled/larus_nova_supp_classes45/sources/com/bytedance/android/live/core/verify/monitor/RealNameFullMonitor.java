package com.bytedance.android.live.core.verify.monitor;

import android.app.Activity;
import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.monitor.trace.c;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.live.core.verify.responbean.CertificationQuery;
import com.bytedance.android.live.user.IUserService;
import jc1.k;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class RealNameFullMonitor {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/core/verify/monitor/RealNameFullMonitor$AlipayCategory;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "NORMAL", "DOWNGRADE", "livecore_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum AlipayCategory extends Enum<AlipayCategory> {
        public static final AlipayCategory DOWNGRADE = null;
        public static final AlipayCategory NORMAL = null;
        public static final /* synthetic */ AlipayCategory[] a = null;
        private final String value;

        static {
            AlipayCategory r1 = new AlipayCategory("NORMAL", 0, "normal");
            NORMAL = r1;
            AlipayCategory r2 = new AlipayCategory("DOWNGRADE", 1, "downgrade");
            DOWNGRADE = r2;
            a = new AlipayCategory[]{r1, r2};
        }

        public static AlipayCategory valueOf(String r1) {
            return (AlipayCategory) a.a(AlipayCategory.class, r1);
        }

        public static AlipayCategory[] values() {
            return (AlipayCategory[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public AlipayCategory(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/core/verify/monitor/RealNameFullMonitor$CertCategory;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "ZIYAN", "ALIPAY", "ALIYUN", "OTHER", "livecore_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CertCategory extends Enum<CertCategory> {
        public static final CertCategory ALIPAY = null;
        public static final CertCategory ALIYUN = null;
        public static final CertCategory OTHER = null;
        public static final CertCategory ZIYAN = null;
        public static final /* synthetic */ CertCategory[] a = null;
        private final String value;

        static {
            CertCategory r1 = new CertCategory("ZIYAN", 0, "ziyan");
            ZIYAN = r1;
            CertCategory r2 = new CertCategory("ALIPAY", 1, "zhima");
            ALIPAY = r2;
            CertCategory r3 = new CertCategory("ALIYUN", 2, "aliyun");
            ALIYUN = r3;
            CertCategory r4 = new CertCategory("OTHER", 3, "other");
            OTHER = r4;
            a = new CertCategory[]{r1, r2, r3, r4};
        }

        public static CertCategory valueOf(String r1) {
            return (CertCategory) a.a(CertCategory.class, r1);
        }

        public static CertCategory[] values() {
            return (CertCategory[]) a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public CertCategory(String r1, int r2, String r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    static {
    }

    public static JSONObject a(JSONObject r2, JSONObject r3) {
        JSONObject r0 = new JSONObject();
        r0.put("request", r2);
        r0.put("response", r3);
        return r0;
    }

    @JvmStatic
    public static final void d(int r2, String r3) {
        e("ttlive_cert_minor_intercept", r2, r3, new JSONObject());
    }

    public static void e(String r7, int r8, String r9, JSONObject r11) {
        if (c.a() == false) goto L16;
        int r0 = e.m;
        e.a r12 = e.b.a(r7, LiveTracingMonitor.EventModule.REAL_NAME.getName());
        r12.c = "webcast_client_community";
        r12.h = Integer.valueOf(r8);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl(k.n(IUserService.class).user().n());     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r2) == false) goto L12;
        r2 = "";
    L12:
        r12.g = (String) r2;
        e r13 = r12.a();
        JSONObject r3 = new JSONObject();
        if (r9 == null) goto L15;
        r3.put("category_1", r9);
    L15:
        r3.put("status_code", r8);
        Intrinsics.checkNotNullParameter(r13, "traceMeta");
        TraceMonitor.i(r13, r3, null, r11);
        return;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L16:
        r11.put("status_code", String.valueOf(r8));
        LiveTracingMonitor.EventModule r5 = LiveTracingMonitor.EventModule.REAL_NAME;
        JSONObject r6 = new JSONObject();
        r6.put("status_code", r8);     // Catch: JSONException -> L19
    L20:
        if (r9 != null) goto L25;
    L22:
        LiveMonitor r14 = new LiveMonitor();
        r14.mCategory = r6;
        r14.mEventModule = r5;
        r14.mServiceName = r7;
        r14.mExtraLog = r11;
        r14.mMetrics = null;
        LiveMonitor.access$002(r14, false);
        LiveMonitor.access$102(r14, false);
        LiveMonitor.access$202(r14, true);
        LiveMonitor.access$302(r14, false);
        LiveMonitor.access$402(r14, false);
        r14.report();
        return;
    L25:
        r6.put("category_1", r9);     // Catch: JSONException -> L24
        goto L22
    }

    @JvmStatic
    public static final void f(int r2, Activity r3, String r4, w80.a r5, String r6) {
        JSONObject r0 = new JSONObject();
        r0.put("activity", r3);
        r0.put("enterFrom", r4);
        JSONObject r7 = new JSONObject();
        if (r5 == null) goto L5;
        r7.put("certType", r5.certType);
        r7.put("message", r5.message);
        r7.put("statusCode", r5.statusCode);
        r7.put(LiveSlardarConstants.EXTRA_KEY_URL, r5.url);
        r7.put("transactionId", r5.transactionId);
        r7.put("merchantId", r5.merchantId);
        r7.put("msg", r6);
    L5:
        e("ttlive_cert_server_common_submit", r2, null, a(r0, r7));
    }

    @JvmStatic
    public static final void b(String r2, boolean r3, boolean r4, int r5, String r6, int r7, w80.a r8) {
        JSONObject r0 = new JSONObject();
        r0.put("enterFrom", r2);
        r0.put("alipayType", r7);
        if (r8 == null) goto L5;
        Integer r9 = Integer.valueOf(r8.certType);
    L6:
        r0.put("certType", r9);
        JSONObject r11 = new JSONObject();
        r11.put("statusCode", r5);
        r11.put("msg", r6);
        if (r3 == false) goto L9;
        r5 = 0;
    L9:
        if (r7 != 0) goto L11;
        JSONObject r12 = a(r0, r11);
        if (r4 == false) goto L17;
        String r13 = AlipayCategory.DOWNGRADE.getValue();
    L18:
        e("ttlive_cert_alipay_sdk_app", r5, r13, r12);
        return;
    L17:
        r13 = AlipayCategory.NORMAL.getValue();
        goto L18
    L11:
        if (r7 != 3) goto L21;
        e("ttlive_cert_aliyun_face", r5, null, a(r0, r11));
        return;
    L21:
        return;
    L5:
        r9 = null;
        goto L6
    }

    @JvmStatic
    public static final void c(boolean r3, int r4, int r5, boolean r6, Activity r7, CertificationQuery r8, String r9) {
        if (r5 == 3) goto L5;
        String r11 = CertCategory.OTHER.getValue();
    L6:
        JSONObject r0 = new JSONObject();
        if (r7 == null) goto L9;
        String r12 = r7.toString();
    L10:
        r0.put("activity", r12);
        r0.put("isSkipRecordVerify", r6);
        JSONObject r13 = new JSONObject();
        if (r8 == null) goto L13;
        r13.put("result", r8.toString());
        r13.put("msg", r9);
    L13:
        if (r3 == false) goto L15;
        e("ttlive_cert_server_query", r4, r11, a(r0, r13));
        return;
    L15:
        e("ttlive_cert_server_common_query", r4, null, a(r0, r13));
        return;
    L9:
        r12 = null;
        goto L10
    L5:
        r11 = CertCategory.ALIYUN.getValue();
        goto L6
    }
}
