package l42;

import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.VSBarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.w;
import com.bytedance.android.livesdk.sharedpref.e;
import java.util.HashMap;
import java.util.Map;
import p22.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface a {
    public static final e<Boolean> A = null;
    public static final e<Boolean> a = null;
    public static final e<HashMap<String, String>> b = null;
    public static final e<Boolean> c = null;
    public static final e<BarrageSetting> d = null;
    public static final e<VSBarrageSetting> e = null;
    public static final e<Boolean> f = null;
    public static final e<Boolean> g = null;
    public static final e<Boolean> h = null;
    public static final e<Map<String, String>> i = null;
    public static final e<w> j = null;
    public static final e<Integer> k = null;
    public static final e<Integer> l = null;
    public static final e<Integer> m = null;
    public static final e<Integer> n = null;
    public static final e<Boolean> o = null;
    public static final e<Integer> p = null;
    public static final e<Integer> q = null;
    public static final e<b> r = null;
    public static final e<Integer> s = null;
    public static final e<Boolean> t = null;
    public static final e<Boolean> u = null;
    public static final e<Integer> v = null;
    public static final e<m42.a> w = null;
    public static final e<Integer> x = null;
    public static final e<o> y = null;
    public static final e<o> z = null;

    static {
        Boolean r1 = Boolean.FALSE;
        a = new e("public_screen_load_tip_show", r1);
        b = new e("live_watch_duration_month", new HashMap());
        c = new e("live_interactivity_test_log_enable", r1);
        d = new e("live_barrage_setting", new BarrageSetting(false));
        e = new e("vs_barrage_setting", VSBarrageSetting.getDefaultStyleSetting());
        f = new e("vs_support_realtime_msg_debug", r1);
        g = new e("landscape_block_enable", r1);
        h = new e("danmaku_debug_enable", r1);
        i = new e("live_last_selected_danmaku_tab_memory", new HashMap());
        j = new e("live_input_recommend_shortcut_emoji", new w());
        k = new e("live_keyboard_height_portrait", 0);
        l = new e("live_keyboard_height_landscape", 0);
        m = new e("live_keyboard_height_portrait_v3", 0);
        n = new e("live_keyboard_height_landscape_v3", 0);
        Boolean r2 = Boolean.TRUE;
        o = new e("live_screen_tab_send_confirm", r2);
        p = new e("live_input_panel_last_audio", 0);
        q = new e("live_input_panel_fusion_emoji_tips_show_times", 0);
        r = new e("live_landscape_damaku_setting_reddot", new b());
        s = new e("audience_enter_room_count", 0);
        t = new e("live_video_preview_pin_switch", r2);
        u = new e("live_expression_board_show_from_vip_page", r1);
        v = new e("live_expression_last_select", 0);
        w = new e("vs_live_landscape_damaku_setting_reddot", new m42.a());
        x = new e("live_subscribe_emoji_tip_time", 0);
        o.a.getClass();
        y = new e("live_simple_danmaku_setting", new o(false, 3, 1.0f, 1.0f, 80.0f));
        z = new e("live_simple_danmaku_setting", o.class);
        A = new e("live_user_operate_simple_damaku_setting", r1);
    }
}
