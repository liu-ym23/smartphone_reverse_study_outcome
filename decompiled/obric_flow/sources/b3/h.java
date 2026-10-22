package b3;

import android.os.Handler;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f841a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f842b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f843c = null;

    static {
        f841a = new p();
        f842b = new n();
        f843c = LazyKt.lazy(new a3.f(1));
    }

    public static void a(int r5, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        StringBuilder r13 = androidx.constraintlayout.motion.widget.a.D(r11, "errorMessage", r12, "eventType", "onError: ");
        f8.b.e(r13, r10, ", ", r11, ", ");
        r13.append(r5);
        r13.append(", ");
        r13.append(r12);
        String r14 = r13.toString();
        Intrinsics.checkNotNullParameter("AppletEventMonitorManager", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L6;
        r15.d("AppletEventMonitorManager", r14);
    L6:
        if (Intrinsics.areEqual(r12, "applet_widget_timeline_full") == false) goto L10;
        c(new b(r5, r10, 0, r11));
        return;
    L10:
        if (Intrinsics.areEqual(r12, "applet_page_timeline_full") == false) goto L13;
        c(new b(r5, r10, 1, r11));
        return;
    }

    public static void b(String r10, String r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "pageId");
        Intrinsics.checkNotNullParameter(r12, "pageType");
        Intrinsics.checkNotNullParameter(r13, "from");
        c(new a3.e(r10, r11, r12, r13, System.currentTimeMillis()));
    }

    public static void c(Function0 r5) {
        ((Handler) f843c.getValue()).post(new a3.g(1, r5));
    }

    public static void d(String r5) {
        Intrinsics.checkNotNullParameter(r5, "traceId");
        c(new a3.b(r5, System.currentTimeMillis(), 25));
    }

    public static void e(String r10, String r11, Map r12) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter(r11, "eventType");
        Intrinsics.checkNotNullParameter(r12, "eventInfo");
        long r5 = System.currentTimeMillis();
        String r13 = com.lynx.tasm.utils.b.j("onRunAppletRuntimeEnd: ", r10, ", ", r11);
        Intrinsics.checkNotNullParameter("AppletEventMonitorManager", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L6;
        r14.d("AppletEventMonitorManager", r13);
    L6:
        if (Intrinsics.areEqual(r11, "applet_widget_timeline_full") == false) goto L10;
        c(new a(r10, r5, r12, 7));
        return;
    L10:
        if (Intrinsics.areEqual(r11, "applet_page_timeline_full") == false) goto L13;
        c(new a(r10, r5, r12, 8));
        return;
    }

    public static void f(String r10, Map r11) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter("applet_widget_timeline_full", "eventType");
        Intrinsics.checkNotNullParameter(r11, "eventInfo");
        long r5 = System.currentTimeMillis();
        String r12 = androidx.room.jarjarred.org.antlr.runtime.a.r("onRenderTemplateStart: ", r10, ", applet_widget_timeline_full", "AppletEventMonitorManager", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L6;
        r13.d("AppletEventMonitorManager", r12);
    L6:
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_widget_timeline_full") == false) goto L10;
        c(new a(r10, r5, r11, 4));
        return;
    L10:
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_page_timeline_full") == false) goto L13;
        c(new a(r10, r5, r11, 5));
        return;
    }

    public static void g(String r10) {
        Intrinsics.checkNotNullParameter(r10, "traceId");
        Intrinsics.checkNotNullParameter("applet_widget_timeline_full", "eventType");
        long r5 = System.currentTimeMillis();
        String r11 = androidx.room.jarjarred.org.antlr.runtime.a.r("onRenderTemplateEnd: ", r10, ", applet_widget_timeline_full", "AppletEventMonitorManager", "tag");
        t0.d r12 = com.bytedance.ai.utils.c.f2846a;
        if (r12 == null) goto L6;
        r12.d("AppletEventMonitorManager", r11);
    L6:
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_widget_timeline_full") == false) goto L10;
        c(new a3.b(r10, r5, 15));
        return;
    L10:
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_page_timeline_full") == false) goto L13;
        c(new a3.b(r10, r5, 16));
        return;
    }

    public static void h(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter(r10, "eventType");
        long r11 = System.currentTimeMillis();
        String r12 = com.lynx.tasm.utils.b.j("onRunAppletRuntimeStart: ", r5, ", ", r10);
        Intrinsics.checkNotNullParameter("AppletEventMonitorManager", "tag");
        t0.d r13 = com.bytedance.ai.utils.c.f2846a;
        if (r13 == null) goto L6;
        r13.d("AppletEventMonitorManager", r12);
    L6:
        if (Intrinsics.areEqual(r10, "applet_widget_timeline_full") == false) goto L10;
        c(new a3.b(r5, r11, 12));
        return;
    L10:
        if (Intrinsics.areEqual(r10, "applet_page_timeline_full") == false) goto L13;
        c(new a3.b(r5, r11, 19));
        return;
    }

    public static void i(final String r5, final Map r10) {
        Intrinsics.checkNotNullParameter(r5, "traceId");
        Intrinsics.checkNotNullParameter("applet_widget_timeline_full", "eventType");
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_widget_timeline_full") == false) goto L7;
        final int r11 = 0;
        c(new f(r11, r5, r10));
        return;
    L7:
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_page_timeline_full") == false) goto L10;
        final int r12 = 1;
        c(new f(r12, r5, r10));
        return;
    }
}
