package com.bytedance.android.live.base.abtest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface a {
    public static final ClientABTestKey<String> a = null;
    public static final ClientABTestKey<Boolean> b = null;
    public static final ClientABTestKey<Integer> c = null;
    public static final ClientABTestKey<Boolean> d = null;
    public static final ClientABTestKey<Integer> e = null;

    static {
        a = new ClientABTestKey("live_certification_setting_face_identify", String.class, "ali_cloud", 0);
        Boolean r2 = Boolean.FALSE;
        b = new ClientABTestKey("live_schema_enter_live_opt", Boolean.class, r2, 1);
        c = new ClientABTestKey("live_search_enter_live_opt", Integer.class, 0, 1);
        d = new ClientABTestKey("ttlive_rev_link_enter_opt", Boolean.class, r2, 1);
        e = new ClientABTestKey("live_real_name_opt", Integer.class, 0, 1);
    }
}
