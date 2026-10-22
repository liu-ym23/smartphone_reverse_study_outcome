package ts0;

import android.util.LongSparseArray;
import com.bytedance.android.livesdk.sharedpref.e;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {
    public static final e<us0.a> a = null;
    public static final e<HashMap<String, Boolean>> b = null;
    public static final e<Boolean> c = null;
    public static final e<Boolean> d = null;
    public static final e<Boolean> e = null;
    public static final e<Integer> f = null;

    static {
        a = new e("live_anchor_group_purchase_tip_cache", new us0.a());
        new e("live_anchor_has_vip_cache", new LongSparseArray());
        b = new e("live_anchor_has_vip_cache_v2", new HashMap());
        Boolean r1 = Boolean.FALSE;
        c = new e("gift_exhibition_entry_is_clicked", r1);
        d = new e("live_ec_flash_red_dot_click_ever", r1);
        e = new e("live_clear_screen_optimize", r1);
        f = new e("live_profile_dynamic_sweep_anim_count", 0);
    }
}
