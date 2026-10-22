package com.bytedance.android.ec.core.monitor;

import android.util.Log;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a<V> implements Callable {
        public final /* synthetic */ HashMap a;
        public final /* synthetic */ String b;

        public a(HashMap r1, String r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            this.a.put(com.bytedance.android.ec.core.event.a.KEY_DATA_TYPE, com.bytedance.android.ec.core.event.a.VALUE_DATA_TYPE);     // Catch: Throwable -> L9
            this.a.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);     // Catch: Throwable -> L9
            com.bytedance.android.ec.sdk.helper.g r0 = com.bytedance.android.ec.sdk.helper.g.a;     // Catch: Throwable -> L9
            String r1 = this.b;     // Catch: Throwable -> L9
            Map r10 = this.a;     // Catch: Throwable -> L9
            if ((r10 instanceof Map) == true) goto L5;
            r10 = null;
        L5:
            if (r10 != null) goto L7;
            r10 = MapsKt.emptyMap();     // Catch: Throwable -> L9
        L7:
            r0.logV3(r1, new JSONObject(r10));     // Catch: Throwable -> L9
            return Unit.INSTANCE;
        L9:
            th = move-exception;
            return Integer.valueOf(Log.w("ECBusinessMonitor", "post event failed: " + this.b, th));
        }
    }

    public d() {
    }

    static {
    }

    public static void f(String r10) {
        ECAppInfoService r0 = ECAppInfoService.e;
        if (r0.isDebug() == false) goto L5;
    L6:
        com.bytedance.android.ec.sdk.helper.j.c("EC_BUSINESS_MONITOR_TOAST", r10);
        return;
    L5:
        if (r0.isLocalTest() == true) goto L6;
    }

    public static void b(String r10, HashMap r11) {
        Intrinsics.checkNotNullParameter(r10, "errorKeyName");
        Intrinsics.checkNotNullParameter("presence", "checkRule");
        Intrinsics.checkNotNullParameter("ec_similar_product_page", "scene");
        if (com.bytedance.android.ec.core.opt.ab.t.a() == 1) goto L5;
        return;
    L5:
        f("ec_similar_product_page 的schema中的" + r10 + " 字段缺失，请排查一下问题，若误报或有任何问题可联系lizheng.222");
        HashMap r0 = new HashMap();
        r0.put("error_key_name", r10);
        r0.put("validation_rule", "presence");
        r0.put("error_desc", "缺失");
        if (r11 == null) goto L8;
        r0.putAll(r11);
    L8:
        e("iesec_schema_error_event", r0);
    }

    public static void e(String r10, HashMap r11) {
        ECAppInfoService r0 = ECAppInfoService.e;
        if (r0.isDebug() == false) goto L5;
        return;
    L5:
        if (r0.isLocalTest() == true) goto L9;
        Single.fromCallable(new a(r11, r10)).subscribeOn(Schedulers.io()).subscribe();
        return;
    }

    public static void a(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "path");
        Intrinsics.checkNotNullParameter(r11, "logId");
        Intrinsics.checkNotNullParameter(r12, "errorKeyName");
        Intrinsics.checkNotNullParameter("presence", "checkRule");
        if (com.bytedance.android.ec.core.opt.ab.t.a() != 1) goto L7;
        f(r10 + " 接口中的" + r12 + " 字段缺失，请排查一下问题，若误报或有任何问题可联系相应的研发同学");
        HashMap r0 = new HashMap();
        r0.put("api_path", r10);
        r0.put(com.bytedance.android.ec.core.event.a.KEY_LOG_ID, r11);
        r0.put("error_key_name", r12);
        r0.put("validation_rule", "presence");
        r0.put("error_desc", "");
        e("iesec_api_response_error_event", r0);
        return;
    }

    public static void d(String r10, String r11, String r12, String r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r10, "errorKeyName");
        Intrinsics.checkNotNullParameter(r11, "checkRule");
        Intrinsics.checkNotNullParameter(r13, "scene");
        Intrinsics.checkNotNullParameter(r14, "context");
        if (com.bytedance.android.ec.core.opt.ab.t.a() == 1) goto L6;
        return;
    L6:
        if (r12 != null) goto L25;
        int r15 = r11.hashCode();
        if (r15 == (-1276666629)) goto L21;
        if (r15 == (-907987551)) goto L18;
        if (r15 == 96757556) goto L15;
    L23:
        String r16 = "不符合校验规则";
    L24:
        String r17 = r13 + " 的schema中" + r10 + " 字段" + r16;
    L26:
        f(r17 + "，请保留现场，排查一下问题，有任何问题可联系zhaojunjie.passaway");
        HashMap r18 = new HashMap();
        r18.put("error_key_name", r10);
        r18.put("validation_rule", r11);
        r18.put("error_desc", r17);
        r18.put("scene", r13);
        r18.put("context", r14.toString());
        e("iesec_schema_error_event", r18);
        return;
    L15:
        if (r11.equals("equal") == false) goto L23;
        r16 = "传值不一致";
        goto L24
    L18:
        if (r11.equals(com.bytedance.android.ec.core.event.a.KEY_SCHEMA) == false) goto L23;
        r16 = "协议错误";
        goto L24
    L21:
        if (r11.equals("presence") == false) goto L23;
        r16 = "缺失";
        goto L24
    L25:
        r17 = r13 + " 的schema中" + r12;
        goto L26
    }

    public static void c(String r10, String r11, String r12, String r13, String r14, String r15, int r16) {
        if ((r16 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r16 & 32) == 0) goto L8;
        r15 = null;
    L8:
        Intrinsics.checkNotNullParameter(r11, "destPage");
        Intrinsics.checkNotNullParameter(r12, com.bytedance.android.ec.core.event.a.KEY_SCHEMA);
        Intrinsics.checkNotNullParameter(r13, "errorKeyName");
        Intrinsics.checkNotNullParameter(r14, "checkRule");
        if (com.bytedance.android.ec.core.opt.ab.t.a() != 1) goto L40;
        int r0 = r14.hashCode();
        if (r0 == (-1276666629)) goto L25;
        if (r0 == (-907987551)) goto L22;
        if (r0 == 96757556) goto L19;
    L27:
        String r1 = "不符合校验规则";
    L29:
        if (r15 == null) goto L31;
        f(r11 + " 的schema中" + r15 + "，请排查一下问题，若误报或有任何问题可联系相应的研发同学");
    L32:
        HashMap r17 = new HashMap();
        if (r10 != null) goto L35;
        r10 = "";
    L35:
        r17.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_PAGE, r10);
        r17.put("dest_page", r11);
        r17.put(com.bytedance.android.ec.core.event.a.KEY_SCHEMA, r12);
        r17.put("error_key_name", r13);
        r17.put("validation_rule", r14);
        if (r15 != null) goto L38;
        r15 = "";
    L38:
        r17.put("error_desc", r15);
        e("iesec_schema_error_event", r17);
        return;
    L31:
        f(r11 + " 的schema中的" + r13 + " 字段" + r1 + "，请排查一下问题，若误报或有任何问题可联系相应的研发同学");
        goto L32
    L19:
        if (r14.equals("equal") == false) goto L27;
        r1 = "传值不一致";
        goto L29
    L22:
        if (r14.equals(com.bytedance.android.ec.core.event.a.KEY_SCHEMA) == false) goto L27;
        r1 = "协议错误";
        goto L29
    L25:
        if (r14.equals("presence") == false) goto L27;
        r1 = "缺失";
        goto L29
    }
}
