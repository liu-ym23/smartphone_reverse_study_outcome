package com.bytedance.android.livesdk.interactivity.api.degrade.model.config;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/config/TapLikeFeatureLevel;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "level", "I", "getLevel", "()I", "LEVEL_DEFAULT", "LEVEL_ONE", "LEVEL_TWO", "LEVEL_THREE", "LEVEL_SMART", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TapLikeFeatureLevel extends Enum<TapLikeFeatureLevel> {
    public static final TapLikeFeatureLevel LEVEL_DEFAULT = null;
    public static final TapLikeFeatureLevel LEVEL_ONE = null;
    public static final TapLikeFeatureLevel LEVEL_SMART = null;
    public static final TapLikeFeatureLevel LEVEL_THREE = null;
    public static final TapLikeFeatureLevel LEVEL_TWO = null;
    public static final /* synthetic */ TapLikeFeatureLevel[] a = null;
    private final int level;

    static {
        TapLikeFeatureLevel r1 = new TapLikeFeatureLevel("LEVEL_DEFAULT", 0, 0);
        LEVEL_DEFAULT = r1;
        TapLikeFeatureLevel r2 = new TapLikeFeatureLevel("LEVEL_ONE", 1, 100);
        LEVEL_ONE = r2;
        TapLikeFeatureLevel r3 = new TapLikeFeatureLevel("LEVEL_TWO", 2, 200);
        LEVEL_TWO = r3;
        TapLikeFeatureLevel r4 = new TapLikeFeatureLevel("LEVEL_THREE", 3, 300);
        LEVEL_THREE = r4;
        TapLikeFeatureLevel r5 = new TapLikeFeatureLevel("LEVEL_SMART", 4, 999);
        LEVEL_SMART = r5;
        a = new TapLikeFeatureLevel[]{r1, r2, r3, r4, r5};
    }

    public static TapLikeFeatureLevel valueOf(String r1) {
        return (TapLikeFeatureLevel) a.a(TapLikeFeatureLevel.class, r1);
    }

    public static TapLikeFeatureLevel[] values() {
        return (TapLikeFeatureLevel[]) a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public TapLikeFeatureLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.level = r3;
    }
}
