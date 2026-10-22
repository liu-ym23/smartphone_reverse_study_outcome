package nq1;

import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config.ReplayBarrageFilterKeywordSetting;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config.ReplayBarrageSetting;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VideoResolutionItem;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d {
    public static final e<VideoResolutionItem> a = null;
    public static final e<VideoResolutionItem> b = null;
    public static final e<Boolean> c = null;
    public static final e<Boolean> d = null;
    public static final e<Boolean> e = null;
    public static final e<Boolean> f = null;
    public static final e<Boolean> g = null;
    public static final e<Boolean> h = null;
    public static final e<ReplayBarrageSetting> i = null;
    public static final e<ReplayBarrageSetting> j = null;
    public static final e<Boolean> k = null;
    public static final e<Boolean> l = null;
    public static final e<Boolean> m = null;
    public static final e<Boolean> n = null;
    public static final e<Boolean> o = null;
    public static final e<Boolean> p = null;
    public static final e<Boolean> q = null;
    public static final e<Map<String, Number>> r = null;
    public static final e<Boolean> s = null;
    public static final e<Integer> t = null;
    public static final e<Long> u = null;
    public static final e<Integer> v = null;
    public static final e<Integer> w = null;
    public static final e<HashSet<Object>> x = null;
    public static final e<HashMap<String, String>> y = null;
    public static final e<HashMap<String, String>> z = null;

    static {
        a = new e("live_replay_last_selected_resolution", new VideoResolutionItem(null, null, 3, null));
        b = new e("live_replay_selected_resolution", new VideoResolutionItem(null, null, 3, null));
        Boolean r1 = Boolean.FALSE;
        c = new e("replay_float_window_guide_show", r1);
        d = new e("replay_float_window_used", r1);
        e = new e("replay_float_window_open_notified", r1);
        f = new e("replay_cache_cancel_task_has_confirmed", r1);
        g = new e("replay_float_window_open", r1);
        h = new e("replay_landscape_block_enable", r1);
        i = new e("replay_barrage_setting", ReplayBarrageSetting.getDefaultStyleSetting());
        j = new e("replay_barrage_portrait_setting", ReplayBarrageSetting.getDefaultPortraitStyleSetting());
        Boolean r2 = Boolean.TRUE;
        k = new e("replay_over_write_barrage_setting", r2);
        new e("replay_play_barrage_filter_keyword", new ReplayBarrageFilterKeywordSetting());
        l = new e("replay_danmaku_debug_enable", r1);
        new e("replay_danmu_setting_function_reddot_type", new LinkedHashMap());
        new e("replay_color_danmu_filter_reddot_clicked", r1);
        m = new e("replay_first_open_hdr", r2);
        n = new e("replay_player_view_lock_pop_can_show", r2);
        o = new e("replay_toolbar_more_has_clicked_red_dot_portrait", r1);
        p = new e("replay_toolbar_more_has_clicked_red_dot_landscape", r1);
        q = new e("replay_support_realtime_msg_debug", r1);
        r = new e("replay_privilege_clarity_frequency", new LinkedHashMap());
        s = new e("vs_interactive_debug_enable", r1);
        t = new e("vs_bubble_show_count", 0);
        u = new e("vs_bubble_show_last_time", 0L);
        v = new e("live_keyboard_height_portrait_v3", 0);
        w = new e("live_keyboard_height_landscape_v3", 0);
        x = new e("live_vs_board_dress_reddot_clicked", new HashSet());
        y = new e("live_vs_board_last_select_skin", new HashMap());
        z = new e("live_vs_board_last_select_badge", new HashMap());
    }
}
