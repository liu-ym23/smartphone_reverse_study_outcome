package com.bytedance.android.monitorV2;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.android.monitorV2.event.HybridEvent$EventPhase;
import com.bytedance.android.monitorV2.event.HybridEvent$TerminateType;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.launcher.widget.R$string;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Pattern;
import ko.r;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.h0;
import okhttp3.n0;
import okhttp3.q0;
import okhttp3.z;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a5.c f3713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f3714b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f3715c = null;
    public static final HashMap d = null;

    static {
        f3714b = LazyKt.lazy(ValidationReport$client$2.f3515a);
        f3715c = "/monitor/data/validation";
        Application r5 = h.e().f3581a;
        String r10 = null;
        if (r5 == null) goto L5;
        String r11 = r5.getString(R$string.event_create);
    L6:
        Pair r12 = TuplesKt.to("EVENT_CREATE", r11);
        if (r5 == null) goto L9;
        String r13 = r5.getString(R$string.event_upload);
    L10:
        Pair r14 = TuplesKt.to("EVENT_UPLOAD", r13);
        if (r5 == null) goto L13;
        String r15 = r5.getString(R$string.sample_throw);
    L14:
        Pair r16 = TuplesKt.to("SAMPLE_THROW", r15);
        if (r5 == null) goto L17;
        String r17 = r5.getString(R$string.event_terminated);
    L18:
        Pair r18 = TuplesKt.to("EVENT_TERMINATED", r17);
        if (r5 == null) goto L21;
        String r19 = r5.getString(R$string.switch_off);
    L22:
        Pair r20 = TuplesKt.to("SWITCH_OFF", r19);
        if (r5 == null) goto L25;
        String r21 = r5.getString(R$string.param_exception);
    L26:
        Pair r22 = TuplesKt.to("PARAM_EXCEPTION", r21);
        if (r5 == null) goto L29;
        String r23 = r5.getString(R$string.catch_exception);
    L30:
        Pair r110 = TuplesKt.to("CATCH_EXCEPTION", r23);
        if (r5 == null) goto L33;
        String r24 = r5.getString(R$string.event_repeated);
    L34:
        Pair r111 = TuplesKt.to("EVENT_REPEATED", r24);
        if (r5 == null) goto L37;
        String r25 = r5.getString(R$string.invalid_case);
    L38:
        Pair r112 = TuplesKt.to("INVALID_CASE", r25);
        if (r5 == null) goto L41;
        r10 = r5.getString(R$string.invalid_case);
    L41:
        d = MapsKt.hashMapOf(new Pair[]{r12, r14, r16, r18, r20, r22, r110, r111, r112, TuplesKt.to("BLOCK_LIST", r10)});
        return;
    L37:
        r25 = null;
        goto L38
    L33:
        r24 = null;
        goto L34
    L29:
        r23 = null;
        goto L30
    L25:
        r21 = null;
        goto L26
    L21:
        r19 = null;
        goto L22
    L17:
        r17 = null;
        goto L18
    L13:
        r15 = null;
        goto L14
    L9:
        r13 = null;
        goto L10
    L5:
        r11 = null;
        goto L6
    }

    public static String a(String r5, String r10, JSONObject r11) {
    L11:
        e = move-exception;
        mn.h.g("default_handle", e);
    L28:
        String r12 = "";
    L29:
        if (r12 != null) goto L32;
        return "";
    L32:
        return r12;
    L5:
        if (TextUtils.equals("url", r5) == false) goto L19;
        if (TextUtils.equals("custom", r10) == false) goto L13;
        JSONObject r13 = r11.optJSONObject("extra");     // Catch: JSONException -> L11
        if (r13 == null) goto L26;
        r12 = r13.optString("url");     // Catch: JSONException -> L11
    L26:
        r12 = null;
        goto L29
    L13:
        JSONObject r14 = r11.optJSONObject("extra");     // Catch: JSONException -> L11
        if (r14 == null) goto L26;
        JSONObject r15 = r14.optJSONObject("nativeBase");     // Catch: JSONException -> L11
        if (r15 == null) goto L26;
        r12 = r15.optString(r5);     // Catch: JSONException -> L11
        goto L29
    L19:
        if (TextUtils.equals("container_name", r5) == false) goto L28;
        JSONObject r16 = r11.optJSONObject("extra");     // Catch: JSONException -> L11
        if (r16 == null) goto L26;
        JSONObject r17 = r16.optJSONObject("containerBase");     // Catch: JSONException -> L11
        if (r17 == null) goto L26;
        r12 = r17.optString(r5);     // Catch: JSONException -> L11
        goto L29
    L35:
        r12 = "";
        goto L29
    }

    public static void b(com.bytedance.android.monitorV2.event.d r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        String r5 = null;
        if ((r10 instanceof com.bytedance.android.monitorV2.event.a) == false) goto L6;
        JSONObject r11 = k5.h.c((com.bytedance.android.monitorV2.event.a) r10);
    L9:
        JSONObject r12 = new JSONObject().put("extra", r11);
        JSONObject r13 = new JSONObject();
        qo.a.t("module", "monitor", r13);
        HybridEvent$EventPhase r14 = HybridEvent$EventPhase.d;
        HybridEvent$EventPhase r15 = (HybridEvent$EventPhase) r10.d.f18728b;
        if (r14 != r15) goto L12;
    L15:
        qo.a.j(r12, "body", r13);
    L16:
        qo.a.t("ev_type", r10.f3557a, r13);
        qo.a.k("timestamp", System.currentTimeMillis(), r13);
        HybridEvent$EventPhase r16 = HybridEvent$EventPhase.f3539c;
        r r17 = r10.d;
        int r18 = 0;
        if (r16 == ((HybridEvent$EventPhase) r17.f18728b)) goto L19;
        boolean r19 = true;
    L20:
        qo.a.j(Boolean.valueOf(r19), "hit_sample", r13);
        a5.c r20 = f3713a;
        if (r20 == null) goto L23;
        String r21 = r20.e;
    L24:
        qo.a.t(WsConstants.KEY_DEVICE_ID, r21, r13);
        a5.c r22 = f3713a;
        if (r22 == null) goto L27;
        String r23 = r22.f100c;
    L28:
        qo.a.t("os", r23, r13);
        qo.a.t("container_name", a("container_name", r10.f3557a, r12), r13);
        qo.a.t("container_type", r10.f.f22975c, r13);
        qo.a.t("url", a("url", r10.f3557a, r12), r13);
        qo.a.t("bid", k5.h.a(r10), r13);
        a5.c r24 = f3713a;
        if (r24 == null) goto L31;
        String r25 = r24.f98a;
    L32:
        qo.a.t(WsConstants.KEY_APP_ID, r25, r13);
        qo.a.t(WsConstants.KEY_SDK_VERSION, "9.0.0", r13);
        qo.a.t("sdk_name", "Android Hybrid Monitor", r13);
        qo.a.j(r10.a(), "trace_id", r13);
        HybridEvent$EventPhase r26 = (HybridEvent$EventPhase) r17.f18728b;
        if (r14 != r26) goto L35;
    L36:
        r18 = 1;
    L37:
        qo.a.e(r18, "trace_type", r13);
        HybridEvent$EventPhase r27 = HybridEvent$EventPhase.f3538b;
        HybridEvent$EventPhase r28 = (HybridEvent$EventPhase) r17.f18728b;
        if (r27 != r28) goto L42;
        HybridEvent$TerminateType r29 = (HybridEvent$TerminateType) r17.f18729c;
        if (r29 == null) goto L44;
        r5 = r29.name();
    L44:
        String r30 = (String) d.get(r5);
        if (r30 == null) goto L48;
        r5 = r30;
    L48:
        qo.a.t("trace_content", r5, r13);
        c(r13.toString());
        return;
    L42:
        if (r28 == null) goto L44;
        r5 = r28.name();
        goto L44
    L35:
        if (HybridEvent$EventPhase.f3537a != r26) goto L37;
    L31:
        r25 = null;
        goto L32
    L27:
        r23 = null;
        goto L28
    L23:
        r21 = null;
        goto L24
    L19:
        r19 = false;
        goto L20
    L12:
        if (HybridEvent$EventPhase.f3539c == r15) goto L15;
        qo.a.j(new JSONObject(), "body", r13);
        goto L16
    L6:
        if ((r10 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L8;
        r11 = k5.h.d((com.bytedance.android.monitorV2.event.b) r10);
        goto L9
    L8:
        r11 = null;
        goto L9
    }

    public static void c(String r5) {
        Pattern r10 = h0.e;
        q0 r11 = q0.create(z.j("application/json"), r5);
        n0 r12 = new n0();
        StringBuilder r13 = new StringBuilder();
        a5.c r14 = f3713a;
        if (r14 == null) goto L5;
        String r15 = r14.f99b;
    L6:
        r13.append(r15);
        r13.append(f3715c);
        r12.g(r13.toString());
        r12.d("POST", r11);
        r12.a("Content-Type", "application/json");
        d5.b.c("Validation", "report code " + ((OkHttpClient) f3714b.getValue()).a(r12.b()).execute().e);     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        mn.h.g("default_handle", e);
        return;
    L5:
        r15 = null;
        goto L6
    }
}
