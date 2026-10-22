package a7;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.bytedance.android.monitorV2.webview.k;
import com.bytedance.apm.j;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.salamander.anniex.b0;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.w;
import com.lynx.tasm.r;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x4.e;
import zm.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f138c;
    public final /* synthetic */ Object d;

    public /* synthetic */ a(Object r5, int r10, Serializable r11, int r12) {
        this.f136a = r12;
        this.d = r5;
        this.f137b = r10;
        this.f138c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f136a) {
            case 0: goto L21;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            default: goto L4;
        };
    L4:
        xk.c r5 = (xk.c) this.d;
        WebView r10 = (WebView) r5.f23157a.get();
        if (r10 == null) goto L107;
        String r11 = (String) this.f138c;
        if (TextUtils.isEmpty(r11) == true) goto L108;
        e r12 = new e();
        r12.f22965a = r11;
        int r13 = this.f137b;
        r12.f22966b = xk.c.e(r5, r13);
        r12.f = 0;
        k r14 = k.d;
        r14.m(r10, r12);
        b0 r15 = new b0(10, (byte) 0);
        r15.d = r11;
        r15.f7246b = xk.c.e(r5, r13);
        r14.i(r10, r15);
        return;
    L108:
        return;
    L107:
        return;
    L11:
        ((jg.k) ((com.lynx.animax.player.b) this.d).f9657b).g(this.f137b, (Throwable) this.f138c);
        return;
    L13:
        LynxLog.b(2, LynxMonitorService.DEFAULT_PID, "load font success");
        ((f0) this.f138c).b((Typeface) this.d, this.f137b);
        return;
    L15:
        on.b r16 = new on.b(this.f137b, "intersection", (JavaOnlyMap) this.f138c);
        LynxContext r17 = (LynxContext) ((w) this.d).f10806w.get();
        if (r17 == null) goto L109;
        r r18 = r17.g;
        if (r18 == null) goto L110;
        r18.b(r16);
        return;
    L110:
        return;
    L109:
        return;
    L21:
        c r19 = (c) this.d;
        boolean r20 = r19.f();
        q7.a r21 = o6.a.f20411a;
        if (r20 == false) goto L24;
        r21.l().getClass();
    L24:
        String r22 = (String) this.f138c;
        long r23 = r19.f143b;
        String r24 = (String) r19.e;
        ConcurrentHashMap r110 = (ConcurrentHashMap) r19.f144c;
        JSONArray r111 = new JSONArray();
    L28:
        e = e;
        q7.a r112 = r21;
    L30:
        String r25 = r22;
    L59:
        e.printStackTrace();
    L60:
        if (r110 == null) goto L62;
        r110.clear();
    L62:
        JSONObject r26 = new JSONObject();
        r26.put("name", r24);     // Catch: JSONException -> L88
        r26.put("page_type", r24);     // Catch: JSONException -> L88
        r26.put("start", r19.f142a);     // Catch: JSONException -> L88
        r26.put("end", r23);     // Catch: JSONException -> L88
        r26.put("spans", r111);     // Catch: JSONException -> L88
        r26.put("collect_from", 2);     // Catch: JSONException -> L88
        r26.put("page_name", r25);     // Catch: JSONException -> L88
        int r27 = this.f137b;
        if (r27 == (-1)) goto L68;
        r26.put("launch_mode", r27);     // Catch: JSONException -> L88
    L68:
        if (r19.f() == false) goto L70;
        r112.i().getClass();
    L70:
        JSONObject r28 = new JSONObject();
        r28.put("trace", r26);     // Catch: JSONException -> L89
    L72:
        j6.e r29 = new j6.e((String) r19.d, "", null, null, r28);
        r29.d = q7.a.k().m(false);
        if (j.f3887a == false) goto L86;
        String r30 = "reportAsync: " + r28;
        if (r30 == null) goto L86;
        if (r30.length() == 0) goto L86;
        if (r30.length() > 3072) goto L83;
        Log.d("AppStartStats", r30);
    L83:
        if (r30.length() <= 3072) goto L85;
        String r31 = r30.substring(0, 3072);
        r30 = r30.replace(r31, "");
        Log.d("AppStartStats", r31);
        goto L83
    L85:
        Log.d("AppStartStats", r30);
    L86:
        i6.a.i().b(r29);
        return;
    L26:
        if (TextUtils.equals(r22, sk.a.f21949p) == false) goto L31;
        r111 = sk.a.e();     // Catch: JSONException -> L28
    L31:
        if (r110 != null) goto L33;
    L58:
        r112 = r21;
        r25 = r22;
        goto L60
    L33:
        if (r110.isEmpty() == true) goto L58;
        Iterator r32 = r110.entrySet().iterator();     // Catch: JSONException -> L28
    L35:
        if (r32.hasNext() == false) goto L58;
        Map.Entry r113 = (Map.Entry) r32.next();     // Catch: JSONException -> L28
        String r114 = (String) r113.getKey();     // Catch: JSONException -> L28
        m6.b r115 = (m6.b) r113.getValue();     // Catch: JSONException -> L28
        if (r115.f20017b == 0) goto L35;
        JSONObject r116 = new JSONObject();     // Catch: JSONException -> L28
        Iterator r117 = r32;
        String[] r33 = r114.split("#");     // Catch: JSONException -> L28
        r112 = r21;
        if (r33.length == 2) goto L98;
        r25 = r22;
        if (r33.length != 1) goto L92;
        r116.put("span_name", r33[0]);     // Catch: JSONException -> L51
    L92:
        r116.put("start", r115.f20016a);     // Catch: JSONException -> L51
        r116.put("end", r115.f20017b);     // Catch: JSONException -> L51
        r116.put("thread", r115.f20018c);     // Catch: JSONException -> L51
        r111.put(r116);     // Catch: JSONException -> L51
        r21 = r112;
        r32 = r117;
        r22 = r25;
    L51:
        e = e;
        goto L59
    L98:
    L46:
        e = e;
        goto L30
    L44:
        if ("page_load_trace".equals((String) r19.d) == false) goto L49;
        r116.put("name", r33[1]);     // Catch: JSONException -> L46
        r25 = r22;
        goto L92
    L49:
        r25 = r22;
        r116.put("module_name", r33[0]);     // Catch: JSONException -> L51
        r116.put("span_name", r33[1]);     // Catch: JSONException -> L51
        goto L92
    }

    public a(xk.c r5, String r10, int r11) {
        this.f136a = 4;
        this.d = r5;
        this.f138c = r10;
        this.f137b = r11;
    }

    public a(f0 r5, Typeface r10, int r11) {
        this.f136a = 2;
        this.f138c = r5;
        this.d = r10;
        this.f137b = r11;
    }
}
