package com.bytedance.android.anniex.scene.connect;

import com.bytedance.android.anniex.scene.core.f;
import com.bytedance.android.anniex.scene.data.b;
import com.bytedance.ies.bullet.service.base.i;
import com.bytedance.ies.bullet.service.base.x;
import com.lynx.tasm.utils.d;
import com.lynx.tasm.utils.g;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tc.c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static LinkedHashMap a(f r10, b r11) {
        LinkedHashMap r5 = new LinkedHashMap();
        String r12 = r10.f3391a;
        Intrinsics.checkNotNullParameter(r12, "base64Input");
        r5.put("path_name", r12);
        r5.put("pv", Integer.valueOf(r11.f3425a));
        JSONArray r13 = new JSONArray();
        Iterator r14 = r11.f3426b.entrySet().iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        Map.Entry r15 = (Map.Entry) r14.next();
        String r16 = (String) r15.getKey();
        Pair r17 = (Pair) r15.getValue();
        JSONObject r18 = d.k("pathname", r16);
        r18.put("pv", ((Number) r17.getFirst()).intValue());
        r18.put("clickRate", ((Number) r17.getSecond()).doubleValue());
        r13.put(r18);
        goto L4
    L6:
        r5.put("next", r13);
        r5.put("attach_scene", "");
        r5.put("view_count", Integer.valueOf(r10.f.intValue()));
        String r19 = r10.e;
        if (r19 == null) goto L9;
        r5.put("client_component", r19);
    L9:
        return r5;
    }

    public static void b(final int r5, final int r10, final int r11) {
        c r12 = c.f22119c;
        i r13 = (i) fj.a.a(c.f22119c, i.class, i.class);
        if (r13 == null) goto L5;
        x r14 = new x("bdx_monitor_next_sqlite_status");
        JSONObject r15 = new JSONObject();
        r15.put("scene_table_size", r5);
        r15.put("trans_table_size", r10);
        r15.put("db_file_size", r11);
        r14.e = r15;
        ((com.bytedance.ies.bullet.service.monitor.i) r13).d(r14);
    L5:
        Function0<String> r16 = new SceneConnectCenter$reportSqliteStatus$2(r5, r10, r11);
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r16, "message");
        g.f(3, r16);
    }

    public static void c(f r5, f r10, b r11) {
        Intrinsics.checkNotNullParameter(r5, "fromScene");
        Intrinsics.checkNotNullParameter(r10, "toScene");
        Intrinsics.checkNotNullParameter(r11, "sceneQueryInfo");
        final LinkedHashMap r12 = new LinkedHashMap();
        String r13 = r5.f3391a;
        Intrinsics.checkNotNullParameter(r13, "base64Input");
        r12.put("pre_pathname", r13);
        String r14 = r10.f3391a;
        Intrinsics.checkNotNullParameter(r14, "base64Input");
        r12.put("pathname", r14);
        r12.put("pv", Integer.valueOf(r11.f3425a));
        Pair r15 = (Pair) r11.f3426b.get(r10.f3391a);
        if (r15 == null) goto L5;
        double r16 = ((Number) r15.getSecond()).doubleValue();
    L6:
        r12.put("clickRate", Double.valueOf(r16));
        r12.put("pre_attach_scene", "");
        r12.put("attach_scene", "");
        r12.put("view_count", Integer.valueOf(r10.f.intValue()));
        String r17 = r10.e;
        if (r17 == null) goto L9;
        r12.put("client_component", r17);
    L9:
        c r18 = c.f22119c;
        i r19 = (i) fj.a.a(c.f22119c, i.class, i.class);
        if (r19 == null) goto L12;
        x r20 = new x("bdx_monitor_annie_next_scene_goto_feature");
        r20.e = new JSONObject(r12);
        ((com.bytedance.ies.bullet.service.monitor.i) r19).d(r20);
    L12:
        Function0<String> r21 = new SceneConnectCenter$sendSceneGotoFeature$2(r12);
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r21, "message");
        g.f(3, r21);
        return;
    L5:
        r16 = 0.0d;
        goto L6
    }

    public static void d(String r5) {
        Intrinsics.checkNotNullParameter(r5, "errorMsg");
        c r10 = c.f22119c;
        i r11 = (i) fj.a.a(c.f22119c, i.class, i.class);
        if (r11 == null) goto L6;
        x r12 = new x("bdx_monitor_next_sqlite_error");
        JSONObject r13 = new JSONObject();
        r13.put("error_msg", r5);
        r13.put("version", "3");
        r12.e = r13;
        ((com.bytedance.ies.bullet.service.monitor.i) r11).d(r12);
        return;
    }

    public static void e(f r5, b r10) {
        Intrinsics.checkNotNullParameter(r5, "currentScene");
        Intrinsics.checkNotNullParameter(r10, "sceneQueryInfo");
        final LinkedHashMap r11 = a(r5, r10);
        c r12 = c.f22119c;
        i r13 = (i) fj.a.a(c.f22119c, i.class, i.class);
        if (r13 == null) goto L5;
        x r14 = new x("bdx_monitor_annie_next_scene_feature");
        r14.e = new JSONObject(r11);
        ((com.bytedance.ies.bullet.service.monitor.i) r13).d(r14);
    L5:
        Function0<String> r15 = new SceneConnectCenter$sendSceneFeature$2(r11);
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r15, "message");
        g.f(3, r15);
    }

    public static void f(f r5, b r10) {
        Intrinsics.checkNotNullParameter(r5, "currentScene");
        Intrinsics.checkNotNullParameter(r10, "sceneQueryInfo");
        final LinkedHashMap r11 = a(r5, r10);
        com.bytedance.ies.xbridge.event.a r12 = new com.bytedance.ies.xbridge.event.a("annie_next_scene_visible", System.currentTimeMillis());
        r12.f6325c = r11;
        com.bytedance.ies.xbridge.event.b.a(r12);
        Function0<String> r13 = new SceneConnectCenter$sendSceneFeatureEvent$2(r11);
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");
        Intrinsics.checkNotNullParameter(r13, "message");
        g.f(3, r13);
    }
}
