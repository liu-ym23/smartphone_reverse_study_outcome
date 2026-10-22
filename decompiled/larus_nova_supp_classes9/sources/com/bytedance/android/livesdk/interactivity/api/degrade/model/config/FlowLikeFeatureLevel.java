package com.bytedance.android.livesdk.interactivity.api.degrade.model.config;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/config/FlowLikeFeatureLevel;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "level", "I", "getLevel", "()I", "LEVEL_DEFAULT", "LEVEL_ONE", "LEVEL_TWO", "LEVEL_THREE", "LEVEL_FOUR", "LEVEL_FIVE", "LEVEL_SMART", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FlowLikeFeatureLevel extends Enum<FlowLikeFeatureLevel> {
    public static final FlowLikeFeatureLevel LEVEL_DEFAULT = null;
    public static final FlowLikeFeatureLevel LEVEL_FIVE = null;
    public static final FlowLikeFeatureLevel LEVEL_FOUR = null;
    public static final FlowLikeFeatureLevel LEVEL_ONE = null;
    public static final FlowLikeFeatureLevel LEVEL_SMART = null;
    public static final FlowLikeFeatureLevel LEVEL_THREE = null;
    public static final FlowLikeFeatureLevel LEVEL_TWO = null;
    public static final /* synthetic */ FlowLikeFeatureLevel[] a = null;
    private final int level;

    static {
        FlowLikeFeatureLevel r1 = new FlowLikeFeatureLevel("LEVEL_DEFAULT", 0, 0);
        LEVEL_DEFAULT = r1;
        FlowLikeFeatureLevel r2 = new FlowLikeFeatureLevel("LEVEL_ONE", 1, 100);
        LEVEL_ONE = r2;
        FlowLikeFeatureLevel r3 = new FlowLikeFeatureLevel("LEVEL_TWO", 2, 200);
        LEVEL_TWO = r3;
        FlowLikeFeatureLevel r4 = new FlowLikeFeatureLevel("LEVEL_THREE", 3, 300);
        LEVEL_THREE = r4;
        FlowLikeFeatureLevel r5 = new FlowLikeFeatureLevel("LEVEL_FOUR", 4, 400);
        LEVEL_FOUR = r5;
        FlowLikeFeatureLevel r6 = new FlowLikeFeatureLevel("LEVEL_FIVE", 5, 500);
        LEVEL_FIVE = r6;
        FlowLikeFeatureLevel r7 = new FlowLikeFeatureLevel("LEVEL_SMART", 6, 999);
        LEVEL_SMART = r7;
        a = new FlowLikeFeatureLevel[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static FlowLikeFeatureLevel valueOf(String r1) {
        return (FlowLikeFeatureLevel) a.a(FlowLikeFeatureLevel.class, r1);
    }

    public static FlowLikeFeatureLevel[] values() {
        return (FlowLikeFeatureLevel[]) a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public FlowLikeFeatureLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.level = r3;
    }
}
