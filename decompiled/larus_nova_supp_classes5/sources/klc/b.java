package klc;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.model.Effect;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b {
    public static /* synthetic */ void c(a r6, String r7, EffectConfig r8, Map r9) {
        b(r6, true, r7, r8, r9, "");
    }

    public static final void e(a r4, boolean r5, EffectConfig r6, Map<String, ? extends Object> r7) {
        Pair[] r0 = new Pair[3];
        String r1 = r6.m;
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        r0[0] = TuplesKt.to("app_id", r1);
        String r8 = r6.a;
        if (r8 != null) goto L10;
        r8 = "";
    L10:
        r0[1] = TuplesKt.to(EffectConfiguration.KEY_ACCESS_KEY, r8);
        r0[2] = TuplesKt.to("connect_type", "");
        Map<String, ? extends Object> r9 = MapsKt.mutableMapOf(r0);
        r9.putAll(r7);
        r4.monitorStatusRate("effect_download_info", !r5 ? 1 : 0, r9);
    }

    public static void l(a r4, String r5, String r6, long r7) {
        r4.monitorStatusRate("resource_provider_load", 0, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("local_busi_key_list", r5), TuplesKt.to("resource_key", r6), TuplesKt.to("load_time", 0L), TuplesKt.to("size", Long.valueOf(r7)), TuplesKt.to("load_type", "preload"), TuplesKt.to("synthesize_time", 0L)}));
    }

    public static final void a(a r7, boolean r8, EffectConfig r9, Map<String, ? extends Object> r10, String r11) {
        if (r9.U == false) goto L5;
        b(r7, r8, EffectConfiguration.KEY_CATEGORY, r9, r10, r11);
    L5:
        Pair[] r0 = new Pair[2];
        String r1 = r9.m;
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r0[0] = TuplesKt.to("app_id", r1);
        String r12 = r9.a;
        if (r12 != null) goto L13;
        r12 = "";
    L13:
        r0[1] = TuplesKt.to(EffectConfiguration.KEY_ACCESS_KEY, r12);
        Map<String, ? extends Object> r13 = MapsKt.mutableMapOf(r0);
        r13.putAll(r10);
        if (r8 == true) goto L19;
        if (r11 != null) goto L18;
        r11 = "";
    L18:
        r13.put("error_msg", r11);
    L19:
        r7.monitorStatusRate("category_list_success_rate", !r8 ? 1 : 0, r13);
    }

    public static final void f(a r7, boolean r8, EffectConfig r9, Map<String, ? extends Object> r10, String r11) {
        if (r9.U == false) goto L5;
        b(r7, r8, "all_effect", r9, r10, r11);
    L5:
        Pair[] r0 = new Pair[2];
        String r1 = r9.m;
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r0[0] = TuplesKt.to("app_id", r1);
        String r12 = r9.a;
        if (r12 != null) goto L13;
        r12 = "";
    L13:
        r0[1] = TuplesKt.to(EffectConfiguration.KEY_ACCESS_KEY, r12);
        Map<String, ? extends Object> r13 = MapsKt.mutableMapOf(r0);
        r13.putAll(r10);
        if (r8 == true) goto L19;
        if (r11 != null) goto L18;
        r11 = "";
    L18:
        r13.put("error_msg", r11);
    L19:
        r7.monitorStatusRate("effect_list_success_rate", !r8 ? 1 : 0, r13);
    }

    public static final void g(a r4, boolean r5, EffectConfig r6, Effect r7, String r8) {
        Pair[] r0 = new Pair[4];
        r0[0] = TuplesKt.to("effect_id", r7.getEffect_id());
        r0[1] = TuplesKt.to("effect_name", r7.getName());
        String r9 = r6.m;
        if (r9 != null) goto L6;
        r9 = "";
    L6:
        r0[2] = TuplesKt.to("app_id", r9);
        String r10 = r6.a;
        if (r10 != null) goto L10;
        r10 = "";
    L10:
        r0[3] = TuplesKt.to(EffectConfiguration.KEY_ACCESS_KEY, r10);
        Map<String, ? extends Object> r11 = MapsKt.mutableMapOf(r0);
        if (r5 == true) goto L16;
        if (r8 != null) goto L15;
        r8 = "";
    L15:
        r11.put("error_msg", r8);
    L16:
        r4.monitorStatusRate("effect_resource_unzip_success_rate", !r5 ? 1 : 0, r11);
    }

    public static final void h(a r7, boolean r8, EffectConfig r9, Map<String, ? extends Object> r10, String r11) {
        if (r9.U == false) goto L5;
        b(r7, r8, "hot", r9, r10, r11);
    L5:
        Pair[] r0 = new Pair[2];
        String r1 = r9.m;
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r0[0] = TuplesKt.to("app_id", r1);
        String r12 = r9.a;
        if (r12 != null) goto L13;
        r12 = "";
    L13:
        r0[1] = TuplesKt.to(EffectConfiguration.KEY_ACCESS_KEY, r12);
        Map<String, ? extends Object> r13 = MapsKt.mutableMapOf(r0);
        r13.putAll(r10);
        if (r8 == true) goto L19;
        if (r11 != null) goto L18;
        r11 = "";
    L18:
        r13.put("error_msg", r11);
    L19:
        r7.monitorStatusRate("hot_list_success_rate", !r8 ? 1 : 0, r13);
    }

    public static final void j(a r4, boolean r5, EffectConfig r6, String r7, String r8) {
        Pair[] r0 = new Pair[3];
        String r1 = r6.m;
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        r0[0] = TuplesKt.to("app_id", r1);
        String r9 = r6.a;
        if (r9 != null) goto L10;
        r9 = "";
    L10:
        r0[1] = TuplesKt.to(EffectConfiguration.KEY_ACCESS_KEY, r9);
        r0[2] = TuplesKt.to("model_name", r7);
        Map<String, ? extends Object> r10 = MapsKt.mutableMapOf(r0);
        if (r5 == true) goto L16;
        if (r8 != null) goto L15;
        r8 = "";
    L15:
        r10.put("error_msg", r8);
    L16:
        r4.monitorStatusRate("find_model_success_rate", !r5 ? 1 : 0, r10);
    }

    public static final void k(a r7, boolean r8, EffectConfig r9, Map<String, ? extends Object> r10, String r11) {
        if (r9.U == false) goto L5;
        b(r7, r8, EffectConfiguration.KEY_PANEL, r9, r10, r11);
    L5:
        Pair[] r0 = new Pair[2];
        String r1 = r9.m;
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        r0[0] = TuplesKt.to("app_id", r1);
        String r12 = r9.a;
        if (r12 != null) goto L13;
        r12 = "";
    L13:
        r0[1] = TuplesKt.to(EffectConfiguration.KEY_ACCESS_KEY, r12);
        Map<String, ? extends Object> r13 = MapsKt.mutableMapOf(r0);
        r13.putAll(r10);
        if (r8 == true) goto L19;
        if (r11 != null) goto L18;
        r11 = "";
    L18:
        r13.put("error_msg", r11);
    L19:
        r7.monitorStatusRate("panel_info_success_rate", !r8 ? 1 : 0, r13);
    }

    public static final void b(a r4, boolean r5, String r6, EffectConfig r7, Map<String, ? extends Object> r8, String r9) {
        Pair[] r0 = new Pair[3];
        String r1 = r7.m;
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        r0[0] = TuplesKt.to("app_id", r1);
        String r10 = r7.a;
        if (r10 != null) goto L10;
        r10 = "";
    L10:
        r0[1] = TuplesKt.to(EffectConfiguration.KEY_ACCESS_KEY, r10);
        r0[2] = TuplesKt.to("event_name", r6);
        Map<String, ? extends Object> r11 = MapsKt.mutableMapOf(r0);
        r11.putAll(r8);
        if (r5 == true) goto L16;
        if (r9 != null) goto L15;
        r9 = "";
    L15:
        r11.put("error_msg", r9);
    L16:
        r4.monitorStatusRate("ep_common_event", !r5 ? 1 : 0, r11);
    }

    public static final void d(a r5, boolean r6, EffectConfig r7, Effect r8, Map<String, ? extends Object> r9, String r10) {
        Pair[] r0 = new Pair[7];
        String r1 = r7.m;
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        int r3 = 0;
        r0[0] = TuplesKt.to("app_id", r1);
        String r11 = r7.a;
        if (r11 != null) goto L10;
        r11 = "";
    L10:
        r0[1] = TuplesKt.to(EffectConfiguration.KEY_ACCESS_KEY, r11);
        r0[2] = TuplesKt.to("effect_id", r8.getEffect_id());
        Integer r12 = r8.getFile_url().getUrl_type();
        if (r12 == null) goto L13;
        r3 = r12.intValue();
    L13:
        r0[3] = TuplesKt.to("effect_type", Integer.valueOf(r3));
        r0[4] = TuplesKt.to("source", Integer.valueOf(r8.getSource()));
        r0[5] = TuplesKt.to(EffectConfiguration.KEY_PANEL, r8.getPanel());
        String r13 = com.ss.ugc.effectplatform.model.b.a(r8);
        if (r13 != null) goto L17;
        r13 = "";
    L17:
        r0[6] = TuplesKt.to(DBDefinition.MD5, r13);
        Map<String, ? extends Object> r14 = MapsKt.mutableMapOf(r0);
        r14.putAll(r9);
        if (r6 == true) goto L23;
        if (r10 != null) goto L22;
        r10 = "";
    L22:
        r14.put("error_msg", r10);
    L23:
        r5.monitorStatusRate("effect_download_success_rate", !r6 ? 1 : 0, r14);
    }

    public static void m(a r3, int r4, String r5, String r6, Float r7, Float r8, int r9) {
        if ((r9 & 2) == 0) goto L6;
        r5 = null;
    L6:
        if ((r9 & 4) == 0) goto L9;
        r6 = null;
    L9:
        if ((r9 & 8) == 0) goto L12;
        r7 = null;
    L12:
        if ((r9 & 16) == 0) goto L14;
        r8 = null;
    L14:
        int r10 = 1;
        Map<String, ? extends Object> r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", Integer.valueOf(r4))});
        if (r5 == null) goto L17;
        r0.put("err_msg", r5);
    L17:
        if (r6 == null) goto L19;
        r0.put("log_id", r6);
    L19:
        if (r7 == null) goto L21;
        r0.put("clear_size", Float.valueOf(r7.floatValue()));
    L21:
        if (r8 == null) goto L23;
        r0.put("clear_proportion", Float.valueOf(r8.floatValue()));
    L23:
        if (r4 != 0) goto L25;
        r10 = 0;
    L25:
        r3.monitorStatusRate("ep_strategy_clean_result", r10, r0);
    }

    public static final void i(a r4, boolean r5, EffectConfig r6, Effect r7, String r8, String r9, String r10, Map<String, ? extends Object> r11, String r12) {
        Pair[] r0 = new Pair[7];
        String r1 = r6.m;
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        r0[0] = TuplesKt.to("app_id", r1);
        String r13 = r6.a;
        if (r13 != null) goto L10;
        r13 = "";
    L10:
        r0[1] = TuplesKt.to(EffectConfiguration.KEY_ACCESS_KEY, r13);
        r0[2] = TuplesKt.to("effect_id", r7.getEffect_id());
        r0[3] = TuplesKt.to(EffectConfiguration.KEY_PANEL, r7.getPanel());
        r0[4] = TuplesKt.to("model_name", r8);
        r0[5] = TuplesKt.to("resource_type", r10);
        if (r9 != null) goto L14;
        r9 = "";
    L14:
        r0[6] = TuplesKt.to("model_version", r9);
        Map<String, ? extends Object> r14 = MapsKt.mutableMapOf(r0);
        r14.putAll(r11);
        if (r5 == true) goto L20;
        if (r12 != null) goto L19;
        r12 = "";
    L19:
        r14.put("error_msg", r12);
    L20:
        r4.monitorStatusRate("model_download_success_rate", !r5 ? 1 : 0, r14);
    }
}
