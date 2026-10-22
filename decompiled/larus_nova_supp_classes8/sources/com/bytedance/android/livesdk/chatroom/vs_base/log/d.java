package com.bytedance.android.livesdk.chatroom.vs_base.log;

import am2.a0;
import am2.b0;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate.l;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import fq1.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public static final d b = null;
    public static final Class[] c = null;
    public final Map<Class, o> a;

    static {
        b = new d();
        c = new Class[]{a0.class, b0.class};
    }

    public static HashMap b() {
        if (ir1.b.a(l.class) != null) goto L6;
        return null;
    L6:
        l r0 = (l) ir1.b.a(l.class);
        r0.getClass();
        HashMap r1 = new HashMap();
        if (r0.g() == true) goto L10;
    L42:
        return r1;
    L10:
        if (r0.k() == false) goto L13;
        String r2 = "portrait_half";
    L27:
        r1.put("is_full_screen_mode", r2);
        if (r0.c() == false) goto L31;
    L32:
        String r3 = "0";
    L34:
        r1.put("is_hor", r3);
        if (r0.c() == false) goto L38;
    L39:
        String r4 = "portrait";
    L41:
        r1.put("replay_screen_type", r4);
        goto L42
    L38:
        if (r0.j() == true) goto L39;
        r4 = "landscape";
        goto L41
    L31:
        if (r0.j() == true) goto L32;
        r3 = "1";
        goto L34
    L13:
        if (r0.j() == false) goto L16;
        r2 = "portrait_full";
        goto L27
    L16:
        if (r0.d() == true) goto L18;
    L20:
        boolean r5 = false;
    L21:
        if (r5 == false) goto L24;
        r2 = "landscape_half";
        goto L27
    L24:
        if (r0.e() == false) goto L26;
        r2 = "landscape_full";
        goto L27
    L26:
        r2 = "";
        goto L27
    L18:
        if (r0.c() == false) goto L20;
        r5 = true;
        goto L21
    }

    public d() {
        HashMap r0 = new HashMap();
        this.a = r0;
        r0.put(a0.class, new ar1.b());
        r0.put(b0.class, new ar1.c());
    }

    public static d a(DataCenter r2) {
        if (r2 != null) goto L6;
        return b;
    L6:
        if (r2.has("data_center_data_replay_logger_key_map") == true) goto L9;
        r2.put("data_center_data_replay_logger_key_map", new d());
    L9:
        return (d) r2.get("data_center_data_replay_logger_key_map", new d());
    }

    public final o c(Class r2) {
        return (o) ((HashMap) this.a).get(r2);
    }

    public final void d(String r4, Map<String, String> r5, Object... r6) {
        HashMap r0 = new HashMap();
        if (r5 == null) goto L6;
        r0.putAll(r5);
    L6:
        if (r4.startsWith("livesdk_replay_video_") == true) goto L13;
        if (r4.startsWith("replay_video_") == false) goto L11;
        r4 = "livesdk_".concat(r4);
        goto L13
    L11:
        r4 = "livesdk_replay_video_".concat(r4);
    L13:
        if (b() == null) goto L18;
        Iterator r7 = b().entrySet().iterator();
    L16:
        if (r7.hasNext() == false) goto L18;
        Map.Entry r1 = (Map.Entry) r7.next();
        r0.put((String) r1.getKey(), (String) r1.getValue());
    L18:
        e(r4, r0, r6);
    }

    public final void e(String r8, Map<String, String> r9, Object... r10) {
        HashMap r0 = new HashMap();
        Class[] r1 = c;
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        ((o) ((HashMap) this.a).get(r1[r4])).a(r0);
        r4 = r4 + 1;
        goto L3
    L5:
        int r3 = r10.length;
        int r5 = 0;
    L6:
        if (r5 >= r3) goto L21;
        Object r6 = r10[r5];
        if (r6 == null) goto L20;
        if ((r6 instanceof Class) == false) goto L17;
        if (((HashMap) this.a).containsKey(r6) == false) goto L20;
        ((o) ((HashMap) this.a).get(r6)).a(r0);
        goto L20
    L17:
        if (((HashMap) this.a).containsKey(r6.getClass()) == false) goto L20;
        ((o) ((HashMap) this.a).get(r6.getClass())).u(r0, r6);
    L20:
        r5 = r5 + 1;
        goto L6
    L21:
        if (r9 == null) goto L26;
        if (r9.size() <= 0) goto L26;
        r0.putAll(r9);
    L26:
        if (StringUtils.isEmpty(r8) == true) goto L45;
        IHostLog r11 = k.f(IHostLog.class);
        if (r11 == null) goto L31;
        r11.logV3(r8, r0);
    L31:
        HashMap r12 = new HashMap();
        Iterator r13 = r0.entrySet().iterator();
    L33:
        if (r13.hasNext() == false) goto L35;
        Map.Entry r14 = (Map.Entry) r13.next();
        r12.put((String) r14.getKey(), r14.getValue());
        goto L33
    L35:
        r.a().c("ttlive_eventlog", r12);
        LocalTestManager.a(new Class[]{wy.a.class});
        return;
    }
}
