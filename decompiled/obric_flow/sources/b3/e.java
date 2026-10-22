package b3;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f836b;

    public /* synthetic */ e(boolean r5, String r10) {
        this.f835a = r5;
        this.f836b = r10;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        n r5 = h.f842b;
        p r10 = h.f841a;
        String r11 = this.f836b;
        boolean r12 = false;
        JSONObject r13 = null;
        if (this.f835a == true) goto L29;
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_widget_timeline_full") == false) goto L14;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "traceId");
        Object r14 = com.lynx.tasm.base.a.a(r11, r10.e).d.get("render_type");
        if ((r14 instanceof String) == false) goto L9;
        String r15 = (String) r14;
    L10:
        if (r15 == null) goto L22;
        boolean r16 = r10.p(r11, r15);
    L23:
        if (r16 == true) goto L29;
        String r17 = androidx.room.jarjarred.org.antlr.runtime.a.r("invalid report info, traceId: ", r11, ", skip report it", "AppletEventMonitorManager", "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L68;
        r18.w("AppletEventMonitorManager", r17);
    L68:
        return Unit.INSTANCE;
    L22:
        r16 = false;
        goto L23
    L9:
        r15 = null;
        goto L10
    L14:
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_page_timeline_full") == false) goto L22;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r11, "traceId");
        Object r19 = com.lynx.tasm.base.a.a(r11, r5.e).d.get("render_type");
        if ((r19 instanceof String) == false) goto L18;
        String r110 = (String) r19;
    L19:
        if (r110 == null) goto L22;
        r16 = r5.p(r11, r110);
        goto L23
    L18:
        r110 = null;
    L29:
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_widget_timeline_full") == false) goto L37;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "traceId");
        i r111 = com.lynx.tasm.base.a.a(r11, r10.e);
        if (r111.f846c.length() != 0) goto L34;
    L43:
        r12 = true;
    L44:
        if (r12 == false) goto L50;
        String r112 = androidx.room.jarjarred.org.antlr.runtime.a.r("It has been already reported , traceId: ", r11, ", skip report it", "AppletEventMonitorManager", "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L69;
        r20.d("AppletEventMonitorManager", r112);
    L69:
        return Unit.INSTANCE;
    L50:
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_widget_timeline_full") == false) goto L53;
        r13 = r10.o(r11);
    L55:
        if (r13 == null) goto L57;
        String r113 = r13.getString("eventName");
        AtomicBoolean r21 = z2.d.f23373a;
        Intrinsics.checkNotNull(r113);
        z2.d.d(r113, new g(r13));
    L57:
        String r114 = com.lynx.tasm.behavior.utils.d.c("report event , traceId: ", r11, "AppletEventMonitorManager");
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;
        if (r22 == null) goto L61;
        r22.d("AppletEventMonitorManager", r114);
    L61:
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_widget_timeline_full") == false) goto L64;
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "traceId");
        com.lynx.tasm.base.a.a(r11, r10.e).f844a = true;
    L67:
        return Unit.INSTANCE;
    L64:
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_page_timeline_full") == false) goto L67;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r11, "traceId");
        com.lynx.tasm.base.a.a(r11, r5.e).f844a = true;
        goto L67
    L53:
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_page_timeline_full") == false) goto L55;
        r13 = r5.o(r11);
        goto L55
    L34:
        if (r111.f844a == false) goto L44;
    L37:
        if (Intrinsics.areEqual("applet_widget_timeline_full", "applet_page_timeline_full") == false) goto L43;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r11, "traceId");
        i r115 = com.lynx.tasm.base.a.a(r11, r5.e);
        if (r115.f846c.length() == 0) goto L43;
        if (r115.f844a == false) goto L44;
        goto L43
    }
}
