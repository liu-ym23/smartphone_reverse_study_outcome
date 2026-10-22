package j40;

import android.util.SparseArray;
import com.bytedance.android.live.core.cache.LruCache;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface f4 {
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> A = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> B = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> C = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> a = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Integer> b = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> c = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> d = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> e = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> f = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> g = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> h = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> i = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> j = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> k = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> l = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> m = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Map<String, String>> n = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<SparseArray<Pair<Long, Integer>>> o = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Map<String, Pair<Long, Integer>>> p = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> q = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> r = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.model.d0> s = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> t = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<LruCache<String, Integer>> u = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> v = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Long> w = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<com.bytedance.android.livesdk.model.z0> x = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> y = null;
    public static final com.bytedance.android.livesdk.sharedpref.e<Boolean> z = null;

    static {
        Boolean r1 = Boolean.TRUE;
        a = new com.bytedance.android.livesdk.sharedpref.e("live_pk_adjust_gift", r1);
        b = new com.bytedance.android.livesdk.sharedpref.e("slide_click_position", 0);
        Boolean r3 = Boolean.FALSE;
        c = new com.bytedance.android.livesdk.sharedpref.e("live_hamlet_avatar_guide_shown", r3);
        d = new com.bytedance.android.livesdk.sharedpref.e("live_permanent_chat_room_entrance_clicked", r3);
        e = new com.bytedance.android.livesdk.sharedpref.e("live_permanent_guest_entrance_clicked", r3);
        f = new com.bytedance.android.livesdk.sharedpref.e("live_pad_rotate_toast_time", -1L);
        g = new com.bytedance.android.livesdk.sharedpref.e("live_gen_play_show", r3);
        h = new com.bytedance.android.livesdk.sharedpref.e("live_publish_show", r3);
        new com.bytedance.android.livesdk.sharedpref.e("live_gen_play_backup_show", r3);
        new com.bytedance.android.livesdk.sharedpref.e("live_playback_or_highlight", r3);
        new com.bytedance.android.livesdk.sharedpref.e("live_real_time_playback_show", r3);
        i = new com.bytedance.android.livesdk.sharedpref.e("live_gen_play_open", r3);
        new com.bytedance.android.livesdk.sharedpref.e("live_gen_play_open_use_default", r1);
        j = new com.bytedance.android.livesdk.sharedpref.e("live_real_time_playback_is_open", r3);
        k = new com.bytedance.android.livesdk.sharedpref.e("live_play_auto_publish", r3);
        new com.bytedance.android.livesdk.sharedpref.e("live_play_auto_publish_use_default", r1);
        l = new com.bytedance.android.livesdk.sharedpref.e("live_replay_product_exposit_switch", r3);
        m = new com.bytedance.android.livesdk.sharedpref.e("live_replay_product_exposit_switch_enable", r1);
        n = new com.bytedance.android.livesdk.sharedpref.e("live_common_short_touch_animation_record", new HashMap());
        o = new com.bytedance.android.livesdk.sharedpref.e("live_short_touch_animation_show_times", new SparseArray());
        p = new com.bytedance.android.livesdk.sharedpref.e("live_short_touch_bubble_show_times", new HashMap());
        new com.bytedance.android.livesdk.sharedpref.e("cash_exchange_gift_send_shown_number", 0);
        q = new com.bytedance.android.livesdk.sharedpref.e("cash_exchange_gift_send_checked", r3);
        r = new com.bytedance.android.livesdk.sharedpref.e("cash_exchange_toolbar_popup_shown", r3);
        new com.bytedance.android.livesdk.sharedpref.e("income_balance_visible_authority", r3);
        s = new com.bytedance.android.livesdk.sharedpref.e("live_vs_paid_camera_ui_show_config", new com.bytedance.android.livesdk.model.d0(new HashMap(), new HashMap()));
        t = new com.bytedance.android.livesdk.sharedpref.e("match_last_tab_id", 0L);
        u = new com.bytedance.android.livesdk.sharedpref.e("business_configure_show_time", new LruCache(100));
        new com.bytedance.android.livesdk.sharedpref.e("live_fetch_skin_recent_time", 0L);
        v = new com.bytedance.android.livesdk.sharedpref.e("live_log_rankinfo_recent_time", 0L);
        w = new com.bytedance.android.livesdk.sharedpref.e("live_log_rankcount_recent_time", 0L);
        new com.bytedance.android.livesdk.sharedpref.e("live_trial_dialog_show", 0L);
        x = new com.bytedance.android.livesdk.sharedpref.e("live_dynamic_strategy_frequency_info", new com.bytedance.android.livesdk.model.z0());
        y = new com.bytedance.android.livesdk.sharedpref.e("replay_show_enlarge_gesture_guide", r1);
        z = new com.bytedance.android.livesdk.sharedpref.e("replay_show_fast_forward_gesture_guide", r1);
        A = new com.bytedance.android.livesdk.sharedpref.e("calendar_permission_denied", r3);
        B = new com.bytedance.android.livesdk.sharedpref.e("timon_calendar_write_permission_denied", r3);
        C = new com.bytedance.android.livesdk.sharedpref.e("guest_link_open", r3);
        new com.bytedance.android.livesdk.sharedpref.e("live_setting_entr_guide_show_time", 0);
    }
}
