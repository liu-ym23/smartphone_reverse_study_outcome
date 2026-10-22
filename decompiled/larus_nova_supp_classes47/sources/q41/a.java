package q41;

import com.bytedance.android.live.base.abtest.ClientABTestKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a {
    public static final ClientABTestKey<Boolean> a = null;
    public static final ClientABTestKey<Boolean> b = null;
    public static final ClientABTestKey<Boolean> c = null;
    public static final ClientABTestKey<Boolean> d = null;
    public static final ClientABTestKey<Boolean> e = null;
    public static final ClientABTestKey<Boolean> f = null;
    public static final ClientABTestKey<Boolean> g = null;
    public static final ClientABTestKey<Boolean> h = null;

    static {
        Boolean r2 = Boolean.FALSE;
        a = new ClientABTestKey("ttlive_rev_link_feed_multi_enable", Boolean.class, r2, 1);
        b = new ClientABTestKey("ttlive_rev_link_enter_opt", Boolean.class, r2, 1);
        c = new ClientABTestKey("ttlive_rev_link_multi_enter_opt", Boolean.class, r2, 1);
        d = new ClientABTestKey("ttlive_rev_link_feed_half_screen_expose", Boolean.class, r2, 1);
        e = new ClientABTestKey("ttlive_rev_link_feed_opt", Boolean.class, r2, 1);
        f = new ClientABTestKey("live_pre_request_other_anchors_profile", Boolean.class, r2, 1);
        g = new ClientABTestKey("live_default_select_recharge_preview_gift", Boolean.class, r2, 1);
        h = new ClientABTestKey("live_big_gift_combo_click_opt", Boolean.class, r2, 1);
    }
}
