package ba;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.Choreographer;
import c7.e;
import c7.h;
import com.bytedance.apm.block.b;
import com.bytedance.apm.j;
import com.bytedance.sdk.xbridge.cn.auth.g;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.behavior.d;
import com.lynx.tasm.ui.image.v;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;
import k0.c;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import q0.i;
import u9.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements c {
    public static volatile a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f890c;

    public a(int r5) {
        switch(r5) {
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        this.f890c = new ArrayList();
        new ArrayList();
        this.f888a = false;
        this.f889b = false;
        return;
    L5:
        this.f890c = Collections.newSetFromMap(new WeakHashMap());
        return;
    L7:
        h r10 = new h();
        r10.f1139b = false;
        r10.g = new HashMap();
        r10.f1142i = -1;
        r10.f1143j = -1;
        r10.f1144k = 0;
        r10.f1138a = "bullet_fluency_tracer";
        r10.f1141h = true;
        r10.f = new LinkedList();
        this.f890c = r10;
        r10.f1140c = new g(10);
        r10.d = new d(10);
    }

    public static String d(HttpURLConnection r5, String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L6;
        return "";
    L6:
        String r11 = r5.getHeaderField(r10);
        if (TextUtils.isEmpty(r11) == true) goto L9;
        return r11;
    L9:
        return r5.getHeaderField(r10.toLowerCase());
    }

    public static a f() {
        if (d != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (d != null) goto L11;
        d = new a(0);     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return d;
    }

    public void a(JSONObject r10) {
        int r5 = 0;
        Intrinsics.checkNotNullParameter(r10, "extraCategory");
        if (this.f888a == false) goto L5;
        return;
    L5:
        Log.i("FluencyMonitor", "startFluencyMonitor");
        Intrinsics.checkNotNullParameter(r10, "extraCategory");
        SystemClock.uptimeMillis();
        h r11 = (h) this.f890c;
        if (r11.f1139b == false) goto L9;
    L19:
        this.f888a = true;
        return;
    L9:
        if (r11.f1141h == true) goto L11;
        boolean r12 = j.f3887a;
        goto L19
    L11:
        monitor-enter(r11);
        r11.f.clear();     // Catch: Throwable -> L21
        monitor-exit(r11);     // Catch: Throwable -> L21
        r11.f1142i = -1;
        r11.f1143j = -1;
        r11.f1144k = 0;
        r11.e = new e(r11, r5);
        Choreographer.getInstance().postFrameCallback(r11.e);     // Catch: Exception -> L17
    L18:
        String r13 = r11.f1138a;
        b.f3854c = true;
        b.f3852a.add(r13);
        r11.f1139b = true;
    L17:
        r11.f1139b = false;
        r11.f1142i = -1;
        r11.f1143j = -1;
        r11.f1144k = 0;
        r11.e = null;
    L21:
        th = move-exception;
        throw th;
    }

    public void b(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "extraCategory");
        if (this.f888a == true) goto L5;
        return;
    L5:
        Log.i("FluencyMonitor", "stopFluencyMonitor");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L9;
        ((Handler) com.bytedance.sdk.xbridge.cn.runtime.thread.a.f7478a.getValue()).post(new v(6, this, false, r5));
        return;
    L9:
        Intrinsics.checkNotNullParameter(r5, "extraCategory");
        SystemClock.uptimeMillis();
        h r10 = (h) this.f890c;
        monitor-enter(r10);
        r10.a();     // Catch: Throwable -> L15
        String r11 = r10.f1138a;     // Catch: Throwable -> L15
        b.f3854c = true;     // Catch: Throwable -> L15
        b.f3852a.remove(r11);     // Catch: Throwable -> L15
        monitor-exit(r10);
        this.f888a = false;
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // k0.c
    public void c(k0.d r5) {
        ((Set) this.f890c).add(r5);
        if (this.f889b == false) goto L6;
        r5.onDestroy();
        return;
    L6:
        if (this.f888a == false) goto L8;
        r5.onStart();
        return;
    L8:
        r5.i();
    }

    @Override // k0.c
    public void e(k0.d r5) {
        ((Set) this.f890c).remove(r5);
    }

    public void g() {
        this.f888a = true;
        Iterator r5 = i.d((Set) this.f890c).iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((k0.d) r5.next()).onStart();
        goto L4
    }

    public void h(HttpURLConnection r10, byte[] r11, com.bytedance.ai.resource.core.net.a r12) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.f888a == true) goto L7;
        return;
    L7:
        if (this.f889b == true) goto L64;
        String r5 = r10.getURL().getPath();
        boolean r13 = false;
        if (TextUtils.isEmpty(r5) == true) goto L18;
        Iterator r14 = ((ArrayList) this.f890c).iterator();
    L14:
        if (r14.hasNext() == false) goto L18;
        if (com.bytedance.frameworks.baselib.network.http.util.c.b(r5, (String) r14.next()) == false) goto L14;
        r13 = true;
    L18:
        if (r13 == true) goto L20;
        return;
    L20:
        String r15 = d(r10, "x-tt-store-region");
        String r16 = d(r10, "x-tt-store-region-src");
        if (TextUtils.isEmpty(r15) == false) goto L23;
        return;
    L23:
        if (TextUtils.isEmpty(r16) == false) goto L26;
        return;
    L26:
        if (r16.equals("uid") == false) goto L28;
    L29:
        String r17 = d(r10, "x-tt-store-idc");
        String r18 = d(r10, "x-tt-with-tnc");
        String r19 = d(r10, "x-tt-tnc-attr");
        String r20 = d(r10, "x-ss-etag");
        String r21 = d(r10, "x-tt-tnc-config");
        if (TextUtils.isEmpty(r18) == false) goto L32;
    L39:
        String r22 = "";
    L36:
        String r23 = r22;
        String r24 = r10.getURL().toString();
        String r25 = r10.getHeaderFields().toString();
        JSONObject r110 = new JSONObject();
        r110.put("url", r24);     // Catch: JSONException -> L43
        r110.put("headers", r25);     // Catch: JSONException -> L43
    L53:
        l.n(r17, r15, r16, r19, r20, r21, r23, r110.toString());     // Catch: Exception -> L48
        return;
    L48:
        e = move-exception;
        e.printStackTrace();
        return;
    L43:
        e = move-exception;
        e.printStackTrace();
        goto L53
    L32:
        if (r18.equals(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L39;
        if (TextUtils.isEmpty(r19) == true) goto L39;
        r22 = "{\"data\": " + new JSONObject(new String(r11)).getString("tnc_data") + "}";     // Catch: JSONException -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
        goto L39
    L28:
        if (r16.equals("did") == true) goto L29;
        return;
    }
}
