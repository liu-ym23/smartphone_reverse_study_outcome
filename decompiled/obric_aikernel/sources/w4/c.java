package w4;

import android.os.Build;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.TTNetInit;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f13359a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f13360b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f13361c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f13362d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicBoolean f13363e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final AtomicBoolean f13364f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final List<String> f13365g = null;

    static {
        f13359a = new AtomicBoolean(false);
        f13360b = new AtomicBoolean(false);
        f13361c = new AtomicBoolean(false);
        f13362d = new AtomicBoolean(false);
        f13363e = new AtomicBoolean(false);
        f13364f = new AtomicBoolean(true);
        f13365g = new CopyOnWriteArrayList();
    }

    private static void a(JSONArray r10, List<String> r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        r11.clear();
        if (r10 != null) goto L7;
        return;
    L7:
        int r12 = 0;
    L9:
        if (r12 >= r10.length()) goto L15;
        r11.add(r10.getString(r12));     // Catch: JSONException -> L12
        r12 = r12 + 1;
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static boolean b() {
        return f13363e.get();
    }

    public static boolean c() {
        return f13364f.get();
    }

    public static boolean d() {
        return f13359a.get();
    }

    public static boolean e() {
        return f13360b.get();
    }

    public static boolean f() {
        return f13361c.get();
    }

    public static void g(Object r10) {
        JSONObject r11 = null;
    L63:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        if ((r10 instanceof e.b) == false) goto L10;
        JSONObject r12 = ((e.b) r10).b();     // Catch: JSONException -> L63
        if (r12 == null) goto L15;
    L8:
        r11 = r12.optJSONObject("data");     // Catch: JSONException -> L63
    L15:
        if (r11 != null) goto L17;
        return;
    L17:
        AtomicBoolean r13 = f13359a;     // Catch: JSONException -> L63
        boolean r14 = false;
        if (r11.optInt("enable_json_wrapper") <= 0) goto L20;
        boolean r15 = true;
    L21:
        r13.set(r15);     // Catch: JSONException -> L63
        AtomicBoolean r16 = f13360b;     // Catch: JSONException -> L63
        if (r11.optInt("enable_tnc_jsonopt") <= 0) goto L24;
        boolean r17 = true;
    L25:
        r16.set(r17);     // Catch: JSONException -> L63
        JSONObject r18 = r11.optJSONObject("cronet_fallback_config");     // Catch: JSONException -> L63
        if (r18 == null) goto L52;
        AtomicBoolean r19 = f13361c;     // Catch: JSONException -> L63
        if (r18.optInt("enable_with_contain_armabi") <= 0) goto L30;
        boolean r20 = true;
    L31:
        r19.set(r20);     // Catch: JSONException -> L63
        AtomicBoolean r21 = f13362d;     // Catch: JSONException -> L63
        if (r18.optInt("disable_reason_boot") <= 0) goto L34;
        boolean r22 = true;
    L35:
        r21.set(r22);     // Catch: JSONException -> L63
        AtomicBoolean r23 = f13363e;     // Catch: JSONException -> L63
        if (r18.optInt("disable_reason_cronet_exception") <= 0) goto L38;
        boolean r24 = true;
    L39:
        r23.set(r24);     // Catch: JSONException -> L63
        AtomicBoolean r25 = f13364f;     // Catch: JSONException -> L63
        if (r18.optInt("disable_reason_null_appconfig", 1) <= 0) goto L42;
        boolean r26 = true;
    L43:
        r25.set(r26);     // Catch: JSONException -> L63
        JSONArray r27 = r18.optJSONArray("merge_model_black_list");     // Catch: JSONException -> L63
        List<String> r28 = f13365g;     // Catch: JSONException -> L63
        a(r27, r28);     // Catch: JSONException -> L63
        if (r21.get() == false) goto L47;
        a.r(TTNetInit.getTTNetDepend().getContext()).C();     // Catch: JSONException -> L63
    L47:
        if (r28.contains(Build.MODEL) == false) goto L50;
        a.P = true;     // Catch: JSONException -> L63
    L50:
        if (Logger.debug() == false) goto L52;
        Logger.d("ExperimentalSwitches", "sEnableWithContainArmabi is " + r19);     // Catch: JSONException -> L63
        Logger.d("ExperimentalSwitches", "sDisableFallbackReasonCronetException is " + r23);     // Catch: JSONException -> L63
        Logger.d("ExperimentalSwitches", "sDisableFallbackReasonBoot is " + r21);     // Catch: JSONException -> L63
        Logger.d("ExperimentalSwitches", "sDisableFallbackReasonNullAppconfig is " + r25);     // Catch: JSONException -> L63
        goto L52
    L42:
        r26 = false;
        goto L43
    L38:
        r24 = false;
        goto L39
    L34:
        r22 = false;
        goto L35
    L30:
        r20 = false;
    L52:
        JSONObject r29 = r11.optJSONObject("ttnet_okio");     // Catch: JSONException -> L63
        if (r29 != null) goto L55;
        return;
    L55:
        if (r29.optInt("okio_read_enabled", 1) <= 0) goto L57;
        boolean r30 = true;
    L58:
        com.bytedance.frameworks.baselib.network.http.impl.a.O(r30);     // Catch: JSONException -> L63
        if (r29.optInt("zero_copy_enabled", 1) <= 0) goto L61;
        r14 = true;
    L61:
        r2.b.k0(r14);     // Catch: JSONException -> L63
        return;
    L57:
        r30 = false;
        goto L58
    L24:
        r17 = false;
        goto L25
    L20:
        r15 = false;
        goto L21
    L10:
        if ((r10 instanceof JSONObject) == true) goto L12;
    L14:
        r11 = (JSONObject) r10;     // Catch: JSONException -> L63
        goto L15
    L12:
        if (((JSONObject) r10).isNull("data") == true) goto L14;
        r12 = (JSONObject) r10;     // Catch: JSONException -> L63
        goto L8
    }
}
