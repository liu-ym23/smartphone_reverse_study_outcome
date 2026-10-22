package com.bytedance.android.live.profile.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/profile/monitor/LifecycleType;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "description", "getDescription", "InitView", "BindUserData", "OnComponentShow", "LoadSkin", "OnComponentDestroy", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LifecycleType extends Enum<LifecycleType> {
    public static final LifecycleType BindUserData = null;
    public static final LifecycleType InitView = null;
    public static final LifecycleType LoadSkin = null;
    public static final LifecycleType OnComponentDestroy = null;
    public static final LifecycleType OnComponentShow = null;
    public static final /* synthetic */ LifecycleType[] a = null;
    private final String description;
    private final String key;

    static {
        LifecycleType r1 = new LifecycleType("InitView", 0, "data_init_view_cost", "initView回调");
        InitView = r1;
        LifecycleType r2 = new LifecycleType("BindUserData", 1, "data_bind_user_data_cost", "bindUserData回调");
        BindUserData = r2;
        LifecycleType r3 = new LifecycleType("OnComponentShow", 2, "data_on_component_show_cost", "onComponentShow回调");
        OnComponentShow = r3;
        LifecycleType r4 = new LifecycleType("LoadSkin", 3, "data_load_skin_cost", "loadSkin回调");
        LoadSkin = r4;
        LifecycleType r5 = new LifecycleType("OnComponentDestroy", 4, "data_on_component_destroy_cost", "onComponentDestroy回调");
        OnComponentDestroy = r5;
        a = new LifecycleType[]{r1, r2, r3, r4, r5};
    }

    public static LifecycleType valueOf(String r1) {
        return (LifecycleType) a.a(LifecycleType.class, r1);
    }

    public static LifecycleType[] values() {
        return (LifecycleType[]) a.clone();
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getKey() {
        return this.key;
    }

    public LifecycleType(String r1, int r2, String r3, String r4) {
        super(r1, r2);
        this.key = r3;
        this.description = r4;
    }
}
