package j3;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm6.util.UrlUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.crash.constants.Constants;
import com.bytedance.framwork.core.sdklib.apm6.j;
import com.bytedance.framwork.core.sdklib.apm6.safety.ApmSDKInternalException;
import com.bytedance.framwork.core.sdkmonitor.f;
import com.obric.aikernel.request.track.ApiPerfDetails;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicInteger f9752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f9753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f9754c;

    /* JADX INFO: renamed from: j3.a$a, reason: collision with other inner class name */
    static class RunnableC0207a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f9755c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f9756g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Throwable f9757h;

        RunnableC0207a(String r10, String r11, Throwable r12) {
            this.f9755c = r10;
            this.f9756g = r11;
            this.f9757h = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f9755c, this.f9756g, this.f9757h);
        }
    }

    static {
        f9752a = new AtomicInteger(0);
        f9753b = true;
    }

    static /* synthetic */ void a(String r10, String r11, Throwable r12) {
        c(r10, r11, r12);
    }

    private static String b(Throwable r10) {
        StringWriter r11 = new StringWriter();
        PrintWriter r12 = new PrintWriter(r11);
        r10.printStackTrace(r12);
        Throwable r13 = r10.getCause();
        if (r13 == null) goto L7;
        r13.printStackTrace(r12);
        Throwable r14 = r13.getCause();
        if (r14 == null) goto L7;
        r14.printStackTrace(r12);
    L7:
        String r15 = r11.toString();
        r12.close();
        return r15;
    }

    private static void c(String r10, String r11, Throwable r12) {
        ApmSDKInternalException r13 = new ApmSDKInternalException("tag=" + r10 + " message=" + r11, r12);
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L11
        r14.put(Constants.EVENT_TYPE, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);     // Catch: Throwable -> L11
        r14.put("timestamp", System.currentTimeMillis());     // Catch: Throwable -> L11
        r14.put("stack", b(r13));     // Catch: Throwable -> L11
        r14.put(ApiPerfDetails.exceptionType, 1);     // Catch: Throwable -> L11
        r14.put("message", r10 + "_" + r11);     // Catch: Throwable -> L11
        JSONObject r15 = new JSONObject();     // Catch: Throwable -> L11
        r15.put("apm_sdk", "apm6_error");     // Catch: Throwable -> L11
        r14.put("filters", r15);     // Catch: Throwable -> L11
        JSONObject r16 = new JSONObject();     // Catch: Throwable -> L11
        JSONArray r17 = new JSONArray();     // Catch: Throwable -> L11
        r17.put(r14);     // Catch: Throwable -> L11
        r16.put("data", r17);     // Catch: Throwable -> L11
        JSONObject r18 = l3.b.a(j.d());     // Catch: Throwable -> L11
        if (r18 == null) goto L6;
        r18.put("aid", "44444");     // Catch: Throwable -> L11
    L6:
        r16.put("header", r18);     // Catch: Throwable -> L11
        if (j.f() == false) goto L9;
        Log.e("APM-SDK", "tag:" + r10 + " message:" + r11, r13);     // Catch: Throwable -> L11
    L9:
        e(f9754c, r16.toString().getBytes());     // Catch: Throwable -> L11
        return;
    L12:
        if (j.f() == false) goto L17;
        Log.e("APM-SDK", "tag:" + r10 + " message:" + r11, r13);
        return;
    }

    static void d(String r10, String r11, Throwable r12) {
        if (TextUtils.isEmpty(f9754c) == false) goto L6;
        return;
    L6:
        if (f9753b == true) goto L8;
        return;
    L8:
        if (f9752a.get() >= 3) goto L13;
        f9752a.incrementAndGet();
        k3.a.e().f(new RunnableC0207a(r10, r11, r12));
        return;
    }

    private static void e(String r10, byte[] r11) {
        if (NetworkUtils.g(j.c()) == false) goto L5;
        if (r11 != null) goto L10;
        return;
    L10:
        if (r11.length == 0) goto L27;
        HashMap r12 = new HashMap();     // Catch: Throwable -> L17
        byte[] r13 = f.a(r11, r12);     // Catch: Throwable -> L17
        HashMap r14 = new HashMap(j.b());     // Catch: Throwable -> L17
        r14.put("aid", "44444");     // Catch: Throwable -> L17
        String r15 = UrlUtils.addParamsToURL(r10, r14);     // Catch: Throwable -> L17
        if (j.f() == false) goto L15;
        Logger.d("APM-SDK", "http request:url:" + r15);     // Catch: Throwable -> L17
    L15:
        j.a(r15, r12, r13);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        if (j.f() == false) goto L26;
        th.printStackTrace();
        return;
    L26:
        return;
    L27:
        return;
    L5:
        if (j.f() == false) goto L24;
        Logger.d("APM-SDK", "network unreachable");
        return;
    }

    public static void f(String r10) {
        if (TextUtils.isEmpty(r10) == true) goto L6;
        f9754c = r10 + "/monitor/collect/c/exception";
        return;
    }
}
