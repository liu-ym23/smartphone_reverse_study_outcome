package hd;

import ai.p;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.bullet.core.e;
import com.bytedance.ies.bullet.core.k;
import com.bytedance.ies.bullet.core.l;
import com.bytedance.ies.bullet.service.base.i;
import com.bytedance.ies.bullet.service.base.x;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback$ErrStage;
import com.google.common.base.u;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.json.JSONObject;
import tc.c;
import x4.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Regex f17301a = null;

    static {
        f17301a = new Regex("\"code\": ...,");
    }

    public static void a(e r10) {
        Intrinsics.checkNotNullParameter(r10, "mContext");
        k r5 = r10.d;
        if (r5.f5326i == true) goto L32;
        r5.f5326i = true;
        j5.b r11 = j5.e.f18241a;
        d r12 = j5.e.a(r10.getSessionId());
        k8.a r13 = r12.f22957c;
        if (r13.f18625b == 99999999) goto L8;
        int r14 = r13.f18626c;
        String r15 = (String) r13.d;
    L9:
        x r16 = new x("bdx_monitor_end_to_end_trace");
        r16.f6027j = r10.f5303q;
        JSONObject r17 = new JSONObject();
        String r18 = r10.f5308w.f5281l;
        if (Intrinsics.areEqual(r18, "update") == false) goto L13;
        String r19 = "success";
    L16:
        r17.put("stage", r10.d.f);
        r17.put(NotificationCompat.CATEGORY_STATUS, r19);
        if (Intrinsics.areEqual("unknown", r10.d.g) == true) goto L20;
        r15 = r10.d.g;
    L20:
        r17.put("error_message", r15);
        r17.put("template_res_type", r10.f5309x.f5347b);
        r17.put("domain_error_code", r14);
        r16.e = r17;
        JSONObject r20 = new JSONObject();
        long r21 = r10.d.d.optLong("entry_start_timestamp");
        if (r21 > 0) goto L24;
        r21 = System.currentTimeMillis();
    L24:
        r20.put("stay_duration", System.currentTimeMillis() - r21);
        r20.put("native_error_count", r12.e);
        r20.put("res_loader_error_count", r12.f22960j);
        r20.put("res_loader_error_template_count", r12.f22960j);
        r20.put("static_error_count", r12.f);
        r20.put("fetch_error_count", r12.g);
        r20.put("jsb_error_count", r12.f22958h);
        r20.put("js_exception_error_count", r12.d);
        r16.f = r20;
        r16.d = r10.getSessionId();
        c r22 = c.f22119c;
        c r23 = c.f22119c;
        String r24 = r10.f;
        if (r24 != null) goto L27;
        r24 = "default_bid";
    L27:
        i r25 = (i) r23.a(i.class, r24);
        if (r25 == null) goto L31;
        ((com.bytedance.ies.bullet.service.monitor.i) r25).d(r16);
        return;
    L31:
        return;
    L13:
        if (Intrinsics.areEqual(r18, "failure") == false) goto L15;
        r19 = "fail";
        goto L16
    L15:
        r19 = "cancel";
        goto L16
    L8:
        k r26 = r10.d;
        r14 = r26.f5325h;
        r15 = r26.g;
        goto L9
    }

    public static void b(e r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "mContext");
        Intrinsics.checkNotNullParameter(r10, "stage");
        x r11 = new x("bdx_monitor_container_load_url");
        r11.f6027j = r5.f5303q;
        JSONObject r12 = new JSONObject();
        r12.put("view_type", r5.f5295i.f5286a);
        r12.put("stage", r10);
        r12.put(NotificationCompat.CATEGORY_STATUS, "success");
        r11.e = r12;
        c(r11, r5);
        com.lynx.tasm.utils.d.l(r11, r5.d);
        c r13 = c.f22119c;
        c r14 = c.f22119c;
        String r15 = r5.f;
        if (r15 != null) goto L5;
        r15 = "default_bid";
    L5:
        i r16 = (i) r14.a(i.class, r15);
        if (r16 == null) goto L9;
        ((com.bytedance.ies.bullet.service.monitor.i) r16).d(r11);
        return;
    }

    public static void c(x r10, e r11) {
        r10.f6027j = r11.f5303q;
        if (((JSONObject) r10.e) != null) goto L5;
        r10.e = new JSONObject();
    L5:
        JSONObject r5 = (JSONObject) r10.e;
        if (r5 == null) goto L40;
        r5.put("view_type", r11.f5295i.f5286a);
        String r12 = "0";
        if (r11.f5309x.e == false) goto L10;
        Object r13 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L11:
        r5.put("res_memory", r13);
        r5.put("res_from", r11.f5309x.f5347b);
        r5.put("template_res_type", r11.f5309x.f5347b);
        r11.f5308w.getClass();
        r5.put("has_error_view", "false");
        if (r11.f5308w.f == null) goto L14;
        boolean r14 = true;
    L15:
        r5.put("fallback", r14);
        u r15 = r11.f5308w.f;
        if (r15 == null) goto L18;
        String r16 = r15.f8670b;
    L19:
        r5.put("fallback_reason", r16);
        r5.put("is_lynx_engine_ready", r11.f5306u.f5319a);
        r5.put("is_first_load", r11.f5308w.d);
        p r17 = r11.f5305t;
        StringBuilder r18 = new StringBuilder();
        List r19 = (List) r17.f288c;
        if (r19 == null) goto L25;
        Iterator r20 = r19.iterator();
    L23:
        if (r20.hasNext() == false) goto L25;
        r18.append((String) r20.next());
        r18.append(',');
    L25:
        r5.put("packages", r18.toString());
        Boolean r21 = r11.f5308w.f5279j.isLoaderTasksReady();
        if (r21 != null) goto L28;
    L32:
        Boolean r22 = r11.f5308w.f5279j.getLoaderResult();
        if (r22 != null) goto L35;
    L38:
        r5.put("res_version", r11.f5309x.d);
        goto L40
    L35:
        if (r22.booleanValue() == false) goto L37;
        r12 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L37:
        r5.put("loaderTasksResult", r12);
        goto L38
    L28:
        if (r21.booleanValue() == false) goto L30;
        Object r23 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L31:
        r5.put("isLoaderTasksReady", r23);
        goto L32
    L30:
        r23 = "0";
        goto L31
    L18:
        r16 = null;
        goto L19
    L14:
        r14 = false;
        goto L15
    L10:
        r13 = "0";
    L40:
        if (((JSONObject) r10.f) != null) goto L42;
        r10.f = new JSONObject();
    L42:
        JSONObject r24 = (JSONObject) r10.f;
        if (r24 == null) goto L49;
        Iterator<Map.Entry<String, Object>> r25 = r11.f5308w.f5279j.getLoaderPerfMetric().entrySet().iterator();
    L46:
        if (r25.hasNext() == false) goto L48;
        Map.Entry<String, Object> r26 = r25.next();
        r24.put(r26.getKey(), r26.getValue());
        goto L46
    L48:
        r24.put("res_size", r11.f5309x.f5348c);
    L49:
        com.lynx.tasm.utils.d.l(r10, r11.d);
    }

    public static void d(x r5, k r10, l r11) {
        if (((JSONObject) r5.e) != null) goto L5;
        r5.e = new JSONObject();
    L5:
        JSONObject r12 = (JSONObject) r5.e;
        if (r12 == null) goto L13;
        r12.put("view_type", "AnnieXCard");
        if (r11.e == false) goto L10;
        String r13 = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L11:
        r12.put("res_memory", r13);
        r12.put("res_from", r11.f5347b);
        r12.put("template_res_type", r11.f5347b);
        r12.put("has_error_view", "false");
        r12.put("fallback_reason", "");
        r12.put("fallback", false);
        r12.put("is_lynx_engine_ready", true);
        r12.put("is_first_load", true);
        r12.put("isLoaderTasksReady", "0");
        r12.put("loaderTasksResult", "0");
        r12.put("res_version", r11.d);
        goto L13
    L10:
        r13 = "0";
    L13:
        if (((JSONObject) r5.f) != null) goto L15;
        r5.f = new JSONObject();
    L15:
        JSONObject r14 = (JSONObject) r5.f;
        if (r14 == null) goto L18;
        r14.put("res_size", r11.f5348c);
    L18:
        com.lynx.tasm.utils.d.l(r5, r10);
    }

    public static void e(x r5, AbsBulletMonitorCallback$ErrStage r10, String r11) {
        if (((JSONObject) r5.e) != null) goto L5;
        r5.e = new JSONObject();
    L5:
        JSONObject r12 = (JSONObject) r5.e;
        if (r12 != null) goto L8;
        return;
    L8:
        if (r10 != AbsBulletMonitorCallback$ErrStage.e) goto L10;
        r12.put("stage", "download_template");
        r12.put(NotificationCompat.CATEGORY_STATUS, "error");
    L11:
        r12.put("has_error_view", "false");
        r12.put("fail_type", r10.f6031a);
        r12.put("fail_reason", r11);
        r12.put("error_stage", r10.f6031a);
        r12.put("error_message", r11);
        String r13 = null;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L17
        if (r11 == null) goto L19;
        MatchResult r15 = Regex.find$default(f17301a, r11, 0, 2, null);     // Catch: Throwable -> L17
        if (r15 == null) goto L19;
        r13 = r15.getValue().subSequence(8, 11).toString();     // Catch: Throwable -> L17
    L25:
    L22:
        if (r13 == null) goto L29;
        r12.put("lynx_error_code", r13);
        return;
    L29:
        return;
    L19:
        Result.m124constructorimpl(null);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L22
    L10:
        r12.put("stage", "end");
        r12.put(NotificationCompat.CATEGORY_STATUS, "fail");
        goto L11
    }
}
