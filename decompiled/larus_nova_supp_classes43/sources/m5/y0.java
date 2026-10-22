package m5;

import android.os.Handler;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class y0 {
    public static final i1 a = null;
    public static final g1 b = null;
    public static final Lazy c = null;
    public static com.bytedance.ai.widget.l d;

    public static final class a implements k5.j {
        public final /* synthetic */ JSONObject a;

        public a(JSONObject r1) {
            this.a = r1;
        }

        @Override // k5.j
        public final void a(AppletMonitorableEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            JSONObject r0 = this.a.optJSONObject(com.bytedance.android.ec.core.event.a.KEY_LUBAN_CATEGORY);
            if (r0 == null) goto L5;
            r10.i = r0;
        L5:
            JSONObject r1 = this.a.optJSONObject("metric");
            if (r1 == null) goto L9;
            r10.j = r1;
            return;
        }
    }

    public y0() {
    }

    static {
        a = new i1();
        b = new g1();
        c = LazyKt.lazy(new m5.a());
    }

    public static void c(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        final long r0 = System.currentTimeMillis();
        r(new l(r10, r0));
    }

    public static void q(JSONObject r10) {
        if (r10 == null) goto L5;
        String r0 = JSONObjectProtectorUtils.getString(r10, "eventName");
        AtomicBoolean r1 = com.bytedance.ai.monitor.b.a;
        Intrinsics.checkNotNull(r0);
        a r11 = new a(r10);
        Intrinsics.checkNotNullParameter(r0, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "builder");
        com.bytedance.ai.monitor.b.e(new k5.f(r0, r11, System.currentTimeMillis()));
        return;
    }

    public static void r(final Function0 r10) {
        ((Handler) c.getValue()).post(new j0(r10));
    }

    public static void f(final String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventType");
        final long r0 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.a.d("AppletEventMonitorManager", "onPageFinished: " + r10 + ", " + r11);
        if (Intrinsics.areEqual(r11, "applet_widget_timeline_full") == false) goto L6;
        r(new g(r10, r0));
        return;
    L6:
        if (Intrinsics.areEqual(r11, "applet_page_timeline_full") == false) goto L10;
        r(new h(r10, r0));
        return;
    }

    public static void g(final String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventType");
        final long r0 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.a.d("AppletEventMonitorManager", "onPageStart: " + r10 + ", " + r11);
        if (Intrinsics.areEqual(r11, "applet_widget_timeline_full") == false) goto L6;
        r(new q(r10, r0));
        return;
    L6:
        if (Intrinsics.areEqual(r11, "applet_page_timeline_full") == false) goto L10;
        r(new r(r10, r0));
        return;
    }

    public static void h(final String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventType");
        final long r0 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.a.d("AppletEventMonitorManager", "onPrepareComponentEnd: " + r10 + ", " + r11);
        if (Intrinsics.areEqual(r11, "applet_widget_timeline_full") == false) goto L6;
        r(new b0(r10, r0));
        return;
    L6:
        if (Intrinsics.areEqual(r11, "applet_page_timeline_full") == false) goto L10;
        r(new c0(r10, r0));
        return;
    }

    public static void i(final String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventType");
        final long r0 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.a.d("AppletEventMonitorManager", "onPrepareComponentStart: " + r10 + ", " + r11);
        if (Intrinsics.areEqual(r11, "applet_widget_timeline_full") == false) goto L6;
        r(new x0(r10, r0));
        return;
    L6:
        if (Intrinsics.areEqual(r11, "applet_page_timeline_full") == false) goto L10;
        r(new b(r10, r0));
        return;
    }

    public static void j(final String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventType");
        final long r0 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.a.d("AppletEventMonitorManager", "onRenderTemplateEnd: " + r10 + ", " + r11);
        if (Intrinsics.areEqual(r11, "applet_widget_timeline_full") == false) goto L6;
        r(new n(r10, r0));
        return;
    L6:
        if (Intrinsics.areEqual(r11, "applet_page_timeline_full") == false) goto L10;
        r(new o(r10, r0));
        return;
    }

    public static void m(final String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventType");
        final long r0 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.a.d("AppletEventMonitorManager", "onRunAppletRuntimeStart: " + r10 + ", " + r11);
        if (Intrinsics.areEqual(r11, "applet_widget_timeline_full") == false) goto L6;
        r(new k(r10, r0));
        return;
    L6:
        if (Intrinsics.areEqual(r11, "applet_page_timeline_full") == false) goto L10;
        r(new m(r10, r0));
        return;
    }

    public static void o(final String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventType");
        com.bytedance.ai.utils.g.a.d("AppletEventMonitorManager", "removeEvent: " + r10 + ", " + r11);
        r(new t0(r11, r10));
    }

    public static String a(String r1, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r1, "prefix");
        Intrinsics.checkNotNullParameter(r10, "appletId");
        Intrinsics.checkNotNullParameter(r11, "pageId");
        return r1 + '_' + r10 + '_' + r11 + '_' + UUID.randomUUID();
    }

    public static void k(final String r10, String r11, final Map r12) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventType");
        Intrinsics.checkNotNullParameter(r12, "eventInfo");
        final long r0 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.a.d("AppletEventMonitorManager", "onRenderTemplateStart: " + r10 + ", " + r11);
        if (Intrinsics.areEqual(r11, "applet_widget_timeline_full") == false) goto L6;
        r(new g0(r10, r0, r12));
        return;
    L6:
        if (Intrinsics.areEqual(r11, "applet_page_timeline_full") == false) goto L10;
        r(new i0(r10, r0, r12));
        return;
    }

    public static void l(final String r10, String r11, final Map r12) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventType");
        Intrinsics.checkNotNullParameter(r12, "eventInfo");
        final long r0 = System.currentTimeMillis();
        com.bytedance.ai.utils.g.a.d("AppletEventMonitorManager", "onRunAppletRuntimeEnd: " + r10 + ", " + r11);
        if (Intrinsics.areEqual(r11, "applet_widget_timeline_full") == false) goto L6;
        r(new e(r10, r0, r12));
        return;
    L6:
        if (Intrinsics.areEqual(r11, "applet_page_timeline_full") == false) goto L10;
        r(new f(r10, r0, r12));
        return;
    }

    public static void n(final String r1, final Map r10, String r11) {
        Intrinsics.checkNotNullParameter(r1, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventType");
        if (Intrinsics.areEqual(r11, "applet_widget_timeline_full") == false) goto L6;
        r(new c(r1, r10));
        return;
    L6:
        if (Intrinsics.areEqual(r11, "applet_page_timeline_full") == false) goto L10;
        r(new d(r1, r10));
        return;
    }

    public static void p(final String r1, final String r10, final boolean r11) {
        Intrinsics.checkNotNullParameter(r1, "traceId");
        Intrinsics.checkNotNullParameter(r10, "eventType");
        r(new p(r11, r10, r1));
    }

    public static void b(final String r10, final String r11, final int r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "errorMessage");
        Intrinsics.checkNotNullParameter(r13, "eventType");
        com.bytedance.ai.utils.g.a.d("AppletEventMonitorManager", "onError: " + r10 + ", " + r11 + ", " + r12 + ", " + r13);
        if (Intrinsics.areEqual(r13, "applet_widget_timeline_full") == false) goto L6;
        r(new h0(r10, r11, r12));
        return;
    L6:
        if (Intrinsics.areEqual(r13, "applet_page_timeline_full") == false) goto L10;
        r(new s0(r10, r11, r12));
        return;
    }

    public static /* synthetic */ void e(String r10, String r11, String r12, String r13) {
        d(r10, r11, r12, r13, null, "webview");
    }

    public static void d(final String r10, final String r11, final String r12, final String r13, final String r14, final String r15) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "pageId");
        Intrinsics.checkNotNullParameter(r12, "pageType");
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_FROM);
        Intrinsics.checkNotNullParameter(r15, "renderType");
        final long r16 = System.currentTimeMillis();
        r(new u(r10, r11, r12, r13, r16, r14, r15));
    }
}
