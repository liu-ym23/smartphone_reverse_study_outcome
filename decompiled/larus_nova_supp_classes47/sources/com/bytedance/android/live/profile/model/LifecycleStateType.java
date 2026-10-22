package com.bytedance.android.live.profile.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/profile/model/LifecycleStateType;", "", "INIT", "BEFORE_UPDATE", "UPDATE_FINISHED", "BEFORE_COMPONENT_SHOW", "COMPONENT_SHOW_FINISHED", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LifecycleStateType extends Enum<LifecycleStateType> {
    public static final LifecycleStateType BEFORE_COMPONENT_SHOW = null;
    public static final LifecycleStateType BEFORE_UPDATE = null;
    public static final LifecycleStateType COMPONENT_SHOW_FINISHED = null;
    public static final LifecycleStateType INIT = null;
    public static final LifecycleStateType UPDATE_FINISHED = null;
    public static final /* synthetic */ LifecycleStateType[] a = null;

    static {
        LifecycleStateType r1 = new LifecycleStateType("INIT", 0);
        INIT = r1;
        LifecycleStateType r2 = new LifecycleStateType("BEFORE_UPDATE", 1);
        BEFORE_UPDATE = r2;
        LifecycleStateType r3 = new LifecycleStateType("UPDATE_FINISHED", 2);
        UPDATE_FINISHED = r3;
        LifecycleStateType r4 = new LifecycleStateType("BEFORE_COMPONENT_SHOW", 3);
        BEFORE_COMPONENT_SHOW = r4;
        LifecycleStateType r5 = new LifecycleStateType("COMPONENT_SHOW_FINISHED", 4);
        COMPONENT_SHOW_FINISHED = r5;
        a = new LifecycleStateType[]{r1, r2, r3, r4, r5};
    }

    public static LifecycleStateType valueOf(String r1) {
        return (LifecycleStateType) r27.a.a(LifecycleStateType.class, r1);
    }

    public static LifecycleStateType[] values() {
        return (LifecycleStateType[]) a.clone();
    }

    public LifecycleStateType(String r1, int r2) {
        super(r1, r2);
    }
}
