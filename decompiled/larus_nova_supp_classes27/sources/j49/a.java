package j49;

import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public a() {
    }

    public static void a() {
        DoraBuryPointManager.a.L("dora_floating_window_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", "hw_volume_sync_switch_popup"), TuplesKt.to("window_content_action", new String[]{"open_hw_volume_sync", "close_hw_volume_sync"})}));
    }

    public static void b() {
        DoraBuryPointManager.a.L("dora_floating_window_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", "keep_active_float_window"), TuplesKt.to("window_content_action", "open_more_settings")}));
    }

    public static void c() {
        DoraBuryPointManager.a.L("dora_floating_window_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", "keep_active_float_window"), TuplesKt.to("window_content_action", "close_keep_active_window")}));
    }

    public static void d() {
        DoraBuryPointManager.a.L("dora_floating_window_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", "keep_active_float_window"), TuplesKt.to("window_content_action", new String[]{"open_more_settings", "close_keep_active_window"})}));
    }

    public static void e() {
        DoraBuryPointManager.a.L("enter_page", MapsKt.mapOf(new Pair[]{TuplesKt.to("current_page", "proactive_broadcast_add_app"), TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, "proactive_broadcast")}));
    }

    public static void h() {
        DoraBuryPointManager.a.L("dora_floating_window_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", "unbind_popup"), TuplesKt.to("window_content_action", "unbinding")}));
    }

    public static void i() {
        DoraBuryPointManager.a.L("dora_floating_window_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", "unbind_popup"), TuplesKt.to("window_content_action", "unbinding")}));
    }

    public static void j(String r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        DoraBuryPointManager.a.L("dora_floating_window_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", r3), TuplesKt.to("window_content_action", "skip_onboarding")}));
    }

    public static void k(String r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        DoraBuryPointManager.a.L("dora_floating_window_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("window_content_type", r3), TuplesKt.to("window_content_action", "skip_onboarding")}));
    }

    public static void f(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        DoraBuryPointManager r0 = DoraBuryPointManager.a;
        Pair[] r1 = new Pair[3];
        r1[0] = TuplesKt.to("window_content_type", "device_discovery_popup");
        r1[1] = TuplesKt.to("window_content_action", r5);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r1[2] = TuplesKt.to("content_source", r4);
        r0.L("dora_floating_window_click", MapsKt.mapOf(r1));
    }

    public static void g(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "action");
        DoraBuryPointManager r0 = DoraBuryPointManager.a;
        Pair[] r1 = new Pair[3];
        r1[0] = TuplesKt.to("window_content_type", "device_discovery_popup");
        r1[1] = TuplesKt.to("window_content_action", r5);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r1[2] = TuplesKt.to("content_source", r4);
        r0.L("dora_floating_window_show", MapsKt.mapOf(r1));
    }
}
