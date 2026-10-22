package com.bytedance.android.live.liveinteract.linkpanel.util;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.livesdk.logger.PanelType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p {
    public static final Map<String, cm2.a> a = null;

    public p() {
    }

    static {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("apply_panel", new cm2.a());
        r0.put("invite_panel", new cm2.a());
        a = r0;
    }

    public static boolean a(@PanelType String r5) {
        Intrinsics.checkNotNullParameter(r5, "panelType");
        cm2.a r6 = (cm2.a) ((LinkedHashMap) a).get(r5);
        if (r6 != null) goto L5;
    L12:
        return true;
    L5:
        if (r6.b == true) goto L12;
        if (r6.h == 0) goto L12;
        if (r6.a == false) goto L12;
        return false;
    }

    public static cm2.a b(@PanelType String r1) {
        return (cm2.a) ((LinkedHashMap) a).get(r1);
    }

    public static void c(@PanelType String r4) {
        Intrinsics.checkNotNullParameter(r4, "panelType");
        cm2.a r5 = b(r4);
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.b == true) goto L9;
        r5.g = System.currentTimeMillis() - r5.c;
        return;
    }

    public static void e(@PanelType String r14) {
        Intrinsics.checkNotNullParameter(r14, "panelType");
        if (a(r14) == true) goto L34;
        cm2.a r0 = (cm2.a) ((LinkedHashMap) a).get(r14);
        if (r0 != null) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(r14, "apply_panel") == false) goto L12;
        cm2.a r1 = b("invite_panel");
        if (r1 == null) goto L16;
        r1.b = true;
    L16:
        r0.b = true;
        long r2 = System.currentTimeMillis();
        long r5 = r0.d;
        r0.f = r2 - r5;
        r0.i = r5 - r0.e;
        r0.j = System.currentTimeMillis() - r0.c;
        ALogger.i("panel_first_frame_opt_tag", r14 + " first frame monitor ;; createDialogDuration == " + r0.g + " ;; fetchListDuration == " + r0.h + " ;; handleListDuration == " + r0.i + " ;; renderDialogDuration == " + r0.f + " ;; totalDuration == " + r0.j);
        Map r3 = MapsKt.mapOf(new Pair[]{TuplesKt.to("create_panel_duration", String.valueOf(r0.g)), TuplesKt.to("fetch_list_duration", String.valueOf(r0.h)), TuplesKt.to("handle_list_duration", String.valueOf(r0.i)), TuplesKt.to("render_panel_duration", String.valueOf(r0.f)), TuplesKt.to("duration", String.valueOf(r0.j)), TuplesKt.to("panel_type", r14)});
        m.p(r3);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "extraParams");
        JSONObject r9 = new JSONObject();
        Iterator r4 = r3.entrySet().iterator();
    L18:
        if (r4.hasNext() == false) goto L20;
        Map.Entry r6 = (Map.Entry) r4.next();
        r9.put((String) r6.getKey(), r6.getValue());
        goto L18
    L20:
        nd0.c.o(nd0.c.a, LinkMonitorData.BusinessFirstFrameTime, r9, 0, null, false, 28);
        if (gh0.a.d() == false) goto L23;
    L26:
        Iterator r15 = ((LinkedHashMap) a).entrySet().iterator();
    L28:
        if (r15.hasNext() == false) goto L30;
        Map.Entry r7 = (Map.Entry) r15.next();
        TalkRoomBusinessFullLinkMonitor r10 = TalkRoomBusinessFullLinkMonitor.a;
        Map r11 = MapsKt.mapOf(TuplesKt.to("panel_type", r7.getKey()));
        r10.getClass();
        TalkRoomBusinessFullLinkMonitor.d0("show_panel", r11, null, null, null);
        TalkRoomBusinessFullLinkMonitor.a0(MapsKt.mapOf(new Pair[]{TuplesKt.to("panel_type", r7.getKey()), TuplesKt.to("panel_status", "show_panel")}));
    L30:
        r0.h = 0;
        return;
    L23:
        if (o.I() == true) goto L26;
        TalkRoomBusinessFullLinkMonitor r8 = TalkRoomBusinessFullLinkMonitor.a;
        Map r12 = MapsKt.mapOf(TuplesKt.to("panel_type", r14));
        r8.getClass();
        TalkRoomBusinessFullLinkMonitor.d0("show_panel", r12, null, null, null);
        TalkRoomBusinessFullLinkMonitor.a0(MapsKt.mapOf(new Pair[]{TuplesKt.to("panel_type", r14), TuplesKt.to("panel_status", "show_panel")}));
        goto L30
    L12:
        if (Intrinsics.areEqual(r14, "invite_panel") == false) goto L16;
        cm2.a r13 = b("apply_panel");
        if (r13 == null) goto L16;
        r13.b = true;
        goto L16
    }

    public static void i(@PanelType String r2) {
        Intrinsics.checkNotNullParameter(r2, "panelType");
        cm2.a r3 = b(r2);
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.b == true) goto L9;
        r3.d = System.currentTimeMillis();
        return;
    }

    public static void d(@PanelType String r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "panelType");
        cm2.a r4 = b(r2);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.b == true) goto L9;
        r4.h = System.currentTimeMillis() - r3;
        r4.e = System.currentTimeMillis();
        return;
    }

    public static void g(@PanelType String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "panelType");
        cm2.a r0 = b(r4);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.b == true) goto L21;
        boolean r2 = true;
        if (Intrinsics.areEqual(r4, "apply_panel") == false) goto L13;
        if (r5 == 0) goto L11;
        r2 = false;
    L11:
        r0.a = r2;
        return;
    L13:
        if (Intrinsics.areEqual(r4, "invite_panel") == false) goto L18;
        if (r5 == 1) goto L17;
        r2 = false;
    L17:
        r0.a = r2;
        return;
    L18:
        r0.a = true;
        return;
    }

    public static void h(@PanelType String r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "panelType");
        cm2.a r0 = b(r5);
        if (r0 == null) goto L19;
        TalkRoomBusinessFullLinkMonitor r1 = TalkRoomBusinessFullLinkMonitor.a;
        Map r3 = MapsKt.mapOf(TuplesKt.to("panel_type", r5));
        r1.getClass();
        TalkRoomBusinessFullLinkMonitor.d0("create_panel", r3, null, null, null);
        boolean r4 = true;
        TalkRoomBusinessFullLinkMonitor.a0(MapsKt.mapOf(new Pair[]{TuplesKt.to("panel_type", r5), TuplesKt.to("panel_status", "create_panel")}));
        if (Intrinsics.areEqual(r5, "apply_panel") == false) goto L11;
        if (r6 == 0) goto L9;
        r4 = false;
    L9:
        r0.a = r4;
    L17:
        r0.b = false;
        r0.c = System.currentTimeMillis();
        return;
    L11:
        if (Intrinsics.areEqual(r5, "invite_panel") == false) goto L16;
        if (r6 == 1) goto L15;
        r4 = false;
    L15:
        r0.a = r4;
        goto L17
    L16:
        r0.a = true;
        goto L17
    }

    public static void f(String r2, Throwable r3, Integer r4, String r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        Intrinsics.checkNotNullParameter(r2, "panelType");
        cm2.a r7 = b(r2);
        if (r7 != null) goto L14;
        return;
    L14:
        if (r7.b == true) goto L18;
        TalkRoomBusinessFullLinkMonitor r8 = TalkRoomBusinessFullLinkMonitor.a;
        Map r9 = MapsKt.mapOf(TuplesKt.to("panel_type", r2));
        r8.getClass();
        TalkRoomBusinessFullLinkMonitor.d0("loading_panel", r9, r3, r4, r5);
        return;
    }
}
