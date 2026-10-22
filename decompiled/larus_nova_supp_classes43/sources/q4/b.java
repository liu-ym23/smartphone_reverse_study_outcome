package q4;

import com.bytedance.ai.bridge.security.AppletJSBBridgeChannel;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.bytedance.ai.settings.d;
import com.bytedance.ai.utils.g;
import java.util.List;
import java.util.Set;
import k5.j;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final Set<String> a = null;
    public static final Set<String> b = null;

    public static final class a implements j {
        public final /* synthetic */ String a;
        public final /* synthetic */ Integer b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ AppletJSBBridgeChannel e;

        @Override // k5.j
        public final void a(AppletMonitorableEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            r10.f = this.a;
            Integer r0 = this.b;
            if (r0 == null) goto L5;
            int r1 = r0.intValue();
        L6:
            r10.d("app_source_type", r1);
            r10.f("bridge_name", this.c);
            r10.f("container_type", this.d);
            r10.f("bridge_channel", this.e.getValue());
            r10.f("decision", "blocked");
            r10.f("reason", "not_allowed");
            return;
        L5:
            r1 = -1;
            goto L6
        }

        public a(String r1, Integer r10, String r11, String r12, AppletJSBBridgeChannel r13) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
        }
    }

    static {
        a = SetsKt.setOf(new String[]{"applet.getPhoneNumber", "applet.agreePrivacyAuthorization", "applet.closePrivacyLoginCard", "applet.openLoginPage", "applet.reportAppLog", "applet.subscribeEvent", "applet.reportPerformanceEntries", "applet.setAdditionalContext"});
        b = SetsKt.setOf(new String[]{"com.flow.music.auth", "com.flow.calendar", "ability.intent.card"});
    }

    public static boolean a(String r10, Integer r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        boolean r1 = true;
        if (r11 != null) goto L6;
    L39:
        g r13 = g.a;
        StringBuilder r14 = new StringBuilder("isAllowed: methodName=");
        r14.append(r10);
        r14.append(", appletId=");
        r14.append(r12);
        r14.append(", appSourceType=");
        Object r15 = r11;
        if (r11 != null) goto L42;
        r15 = "unknown";
    L42:
        r14.append(r15);
        r14.append(", allowed=");
        r14.append(r1);
        r13.i("AppletJSBAccessControl", r14.toString());
        return r1;
    L6:
        if (r11.intValue() != 2) goto L39;
        if (StringsKt.startsWith$default(r10, "doubao.", false, 2, null) == false) goto L12;
        if (r10.length() > 7) goto L39;
    L12:
        if (a.contains(r10) == false) goto L14;
        g.a.i("AppletJSBAccessControl", "additional allowlist matched: methodName=" + r10 + ", source=default");
        boolean r16 = true;
    L20:
        if (r16 == true) goto L39;
        if (r12.length() != 0) goto L24;
        boolean r17 = true;
    L25:
        if (r17 == false) goto L28;
        boolean r18 = false;
    L36:
        if (r18 == true) goto L39;
        r1 = false;
        goto L39
    L28:
        if (b.contains(r12) == false) goto L30;
        g.a.i("AppletJSBAccessControl", "additional applet allowlist matched: appletId=" + r12 + ", source=default");
        r18 = true;
        goto L36
    L30:
        d.a.getClass();
        List<String> r19 = d.a().aiBridgeConfig().a();
        if (r19 != null) goto L33;
        r19 = CollectionsKt.emptyList();
    L33:
        r18 = r19.contains(r12);
        if (r18 == false) goto L36;
        g.a.i("AppletJSBAccessControl", "additional applet allowlist matched: appletId=" + r12 + ", source=settings");
        goto L36
    L24:
        r17 = false;
        goto L25
    L14:
        d.a.getClass();
        List<String> r20 = d.a().aiBridgeConfig().b();
        if (r20 != null) goto L17;
        r20 = CollectionsKt.emptyList();
    L17:
        r16 = r20.contains(r10);
        if (r16 == false) goto L20;
        g.a.i("AppletJSBAccessControl", "additional allowlist matched: methodName=" + r10 + ", source=settings");
        goto L20
    }

    public static void b(String r10, String r11, Integer r12, String r13, AppletJSBBridgeChannel r14) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Intrinsics.checkNotNullParameter(r13, "containerType");
        Intrinsics.checkNotNullParameter(r14, "channel");
        com.bytedance.ai.monitor.b.d("applet_jsb_access_control", new a(r11, r12, r10, r13, r14));
    }
}
