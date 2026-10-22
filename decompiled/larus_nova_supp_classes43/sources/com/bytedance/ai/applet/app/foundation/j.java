package com.bytedance.ai.applet.app.foundation;

import android.content.Context;
import com.bytedance.ai.applet.app.AppletAppActivity;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.components.input.AppletChatInputController;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j implements w {
    public final AppletApplication a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public final ConcurrentHashMap<String, Object> h;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AppletChatInputController.ActionBarItemLocation.values().length];
            r0[AppletChatInputController.ActionBarItemLocation.PRIMARY_BAR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AppletChatInputController.ActionBarItemLocation.DETAIL_PANEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class c implements k5.j {
        public final /* synthetic */ j a;
        public final /* synthetic */ Map<String, Object> b;

        @Override // k5.j
        public final void a(AppletMonitorableEvent r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            r10.g = this.a.a.getAppId();
            r10.h(this.a.h);
            Map<String, ? extends Object> r0 = MapsKt.toMutableMap(this.b);
            r0.putAll(this.a.c());
            r0.put("current_page", "doubao_apps_detail");
            r10.h(r0);
        }

        public c(j r1, Map<String, ? extends Object> r10) {
            this.a = r1;
            this.b = r10;
        }
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void d() {
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void onDestroy() {
    }

    public final Map<String, Object> c() {
        Map r0 = MapsKt.createMapBuilder();
        r0.put("app_key", this.a.getAppId());
        r0.put("app_name", this.a.j().a);
        r0.put("doubao_apps_visit_id", this.g);
        String r1 = this.c;
        String r10 = null;
        boolean r11 = true;
        if (r1 != null) goto L5;
    L13:
        String r12 = this.d;
        if (r12 != null) goto L16;
    L24:
        String r13 = this.e;
        if (r13 != null) goto L27;
    L35:
        String r14 = this.f;
        if (r14 != null) goto L38;
    L46:
        AppletAppActivity r15 = this.a.d;
        if (r15 == null) goto L59;
        String r16 = r15.h;
        if (r16 == null) goto L59;
        if (r16.length() > 0) goto L54;
        r11 = false;
    L54:
        if (r11 == false) goto L56;
        r10 = r16;
    L56:
        if (r10 == null) goto L59;
        r0.put("page_path", r10);
    L59:
        return MapsKt.build(r0);
    L38:
        if (r14.length() <= 0) goto L40;
        boolean r17 = true;
    L41:
        if (r17 == true) goto L44;
        r14 = null;
    L44:
        if (r14 == null) goto L46;
        r0.put("chat_query_message_id", r14);
        goto L46
    L40:
        r17 = false;
        goto L41
    L27:
        if (r13.length() <= 0) goto L29;
        boolean r18 = true;
    L30:
        if (r18 == true) goto L33;
        r13 = null;
    L33:
        if (r13 == null) goto L35;
        r0.put("doubao_apps_section_id", r13);
        goto L35
    L29:
        r18 = false;
        goto L30
    L16:
        if (r12.length() <= 0) goto L18;
        boolean r19 = true;
    L19:
        if (r19 == true) goto L22;
        r12 = null;
    L22:
        if (r12 == null) goto L24;
        r0.put("doubao_apps_conversation_id", r12);
        goto L24
    L18:
        r19 = false;
        goto L19
    L5:
        if (r1.length() <= 0) goto L7;
        boolean r20 = true;
    L8:
        if (r20 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
        r0.put("doubao_apps_message_id", r1);
        goto L13
    L7:
        r20 = false;
        goto L8
    }

    public j(AppletApplication r10) {
        Intrinsics.checkNotNullParameter(r10, "app");
        this.a = r10;
        this.g = UUID.randomUUID().toString();
        this.h = new ConcurrentHashMap();
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    public final void e(List<com.bytedance.ai.applet.app.view.m> r10) {
        Intrinsics.checkNotNullParameter(r10, "items");
        Iterator<com.bytedance.ai.applet.app.view.m> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L34;
        com.bytedance.ai.applet.app.view.m r0 = r11.next();
        int r1 = r0.a;
        if (r1 == 1) goto L18;
        if (r1 == 2) goto L18;
        if (r1 == 3) goto L18;
        if (r1 == 4) goto L18;
        if (r1 == 5) goto L18;
        if (r1 == 6) goto L18;
        int r12 = 0;
    L19:
        String r13 = r0.i;
        if (r13 != null) goto L22;
    L25:
        boolean r14 = true;
    L26:
        if (r14 == true) goto L28;
        String r15 = r0.i;
    L31:
        if (r15 == null) goto L4;
        i("doubao_apps_info_panel_element_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("is_default", Integer.valueOf(r12)), TuplesKt.to("element_name", r15)}));
        goto L4
    L28:
        if (r12 == 0) goto L30;
        r15 = com.bytedance.ai.applet.app.view.p.a(r0.a);
        goto L31
    L30:
        r15 = null;
        goto L31
    L22:
        if (r13.length() == 0) goto L25;
        r14 = false;
    L18:
        r12 = 1;
        goto L19
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void g(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    @Override // com.bytedance.ai.applet.app.foundation.w
    public final void h(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
    }

    public static Map b(String r10, int r11) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("action_bar_key", r10), TuplesKt.to("show_position", Integer.valueOf(r11))});
    }

    public final void i(String r10, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME);
        Intrinsics.checkNotNullParameter(r11, "params");
        com.bytedance.ai.monitor.b.b(r10, new c(this, r11));
    }

    public final void f(String r10, String r11, String r12) {
        this.b = "chat_card";
        this.c = r10;
        this.d = r11;
        this.e = r12;
    }
}
