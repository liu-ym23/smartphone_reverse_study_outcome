package n30;

import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.monitorV2.webview.m;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.o0;
import com.bytedance.ies.web.jsbridge2.u;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import py2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements u {
    public final SoftReference<WebView> a;
    public final Map<String, Long> b;
    public final boolean c;

    public final /* synthetic */ void b(c0 r1, int r2) {
    }

    public c(WebView r2) {
        this.b = new ConcurrentHashMap();
        this.c = ((Boolean) AnnieConfigSettingKeys.LIVE_HYBRID_USE_MONITOR_SAMPLE_RATE.a()).booleanValue();
        this.a = new SoftReference(r2);
    }

    public final void d(String r8, String r9) {
        WebView r0 = this.a.get();
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r9) == true) goto L20;
        h r1 = new h();
        r1.a = r9;
        r1.b = 0;
        r1.d = 0;
        if (((ConcurrentHashMap) this.b).containsKey(r9) == false) goto L11;
        r1.d = ((Long) ((ConcurrentHashMap) this.b).get(r9)).longValue();
    L11:
        if (r1.d == 0) goto L14;
        long r2 = System.currentTimeMillis();
        r1.e = r2;
        r1.c = r2 - r1.d;
    L14:
        if (this.c == false) goto L16;
        m r3 = m.f;
        int r4 = i8.h.a;
        r3.p(r0, i8.h.a.a(r1));
    L17:
        ALogger.i("LiveMonitorJSBListener", "methodName:" + r9 + " url = " + r8);
        return;
    L16:
        com.bytedance.android.monitor.webview.h.g.o(r0, r1);
        goto L17
    }

    public final void e(String r11, int r12) {
        WebView r0 = this.a.get();
        if (r0 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L62;
        h r1 = new h();
        r1.a = r11;
        int r2 = 3;
        if (r12 == 1) goto L12;
        if (r12 == 2) goto L11;
        int r5 = 3;
    L13:
        r1.b = r5;
        r1.d = 0;
        if (((ConcurrentHashMap) this.b).containsKey(r11) == false) goto L17;
        r1.d = ((Long) ((ConcurrentHashMap) this.b).get(r11)).longValue();
    L17:
        if (r1.d == 0) goto L20;
        long r6 = System.currentTimeMillis();
        r1.e = r6;
        r1.c = r6 - r1.d;
    L20:
        if (this.c == false) goto L22;
        m r7 = m.f;
        int r8 = i8.h.a;
        r7.p(r0, i8.h.a.a(r1));
    L23:
        py2.g r3 = new py2.g();
        r3.b = r11;
        if (r12 == 1) goto L28;
        if (r12 != 2) goto L29;
        r2 = 2;
    L29:
        r3.a = r2;
        if (this.c == false) goto L32;
        m r13 = m.f;
        int r4 = i8.h.a;
        jz2.h r9 = new jz2.h();
        r9.c = r11;
        r9.a = r2;
        r9.b = null;
        r13.o(r0, r9);
        return;
    L32:
        com.bytedance.android.monitor.webview.h r14 = com.bytedance.android.monitor.webview.h.g;
        r14.getClass();
    L50:
        bz2.c.a();
        return;
    L34:
        if (r14.p() == true) goto L37;
        return;
    L37:
        if (r14.q(r0) == true) goto L39;
        return;
    L39:
        if (r14.f(r0) == false) goto L58;
        com.bytedance.android.monitor.webview.b r15 = r14.k(r0);     // Catch: Exception -> L50
        if (r15 != null) goto L43;
        return;
    L43:
        if (com.bytedance.android.monitor.webview.h.r(r15.j) == false) goto L60;
        com.bytedance.android.monitor.webview.h.m().getClass();     // Catch: Exception -> L50
        com.bytedance.android.monitor.webview.c r16 = r15.b;     // Catch: Exception -> L50
        if (r16 == null) goto L61;
        r16.s(r0, r3);     // Catch: Exception -> L50
        return;
    L61:
        return;
    L60:
        return;
    L58:
        return;
    L28:
        r2 = 1;
        goto L29
    L22:
        com.bytedance.android.monitor.webview.h.g.o(r0, r1);
        goto L23
    L11:
        r5 = 2;
        goto L13
    L12:
        r5 = 1;
        goto L13
    }

    public final void a(String r1, String r2, o0 r3) {
        d(r1, r2);
    }

    public final void c(String r1, String r2, int r3, String r4, o0 r5) {
        e(r2, r3);
    }
}
