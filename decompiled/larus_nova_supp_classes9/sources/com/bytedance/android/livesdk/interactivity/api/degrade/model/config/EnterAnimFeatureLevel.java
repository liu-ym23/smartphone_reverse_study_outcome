package com.bytedance.android.livesdk.interactivity.api.degrade.model.config;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/config/EnterAnimFeatureLevel;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "level", "I", "getLevel", "()I", "LEVEL_DEFAULT", "LEVEL_ONE", "LEVEL_TWO", "LEVEL_THREE", "LEVEL_SMART", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EnterAnimFeatureLevel extends Enum<EnterAnimFeatureLevel> {
    public static final EnterAnimFeatureLevel LEVEL_DEFAULT = null;
    public static final EnterAnimFeatureLevel LEVEL_ONE = null;
    public static final EnterAnimFeatureLevel LEVEL_SMART = null;
    public static final EnterAnimFeatureLevel LEVEL_THREE = null;
    public static final EnterAnimFeatureLevel LEVEL_TWO = null;
    public static final /* synthetic */ EnterAnimFeatureLevel[] a = null;
    private final int level;

    static {
        EnterAnimFeatureLevel r1 = new EnterAnimFeatureLevel("LEVEL_DEFAULT", 0, 0);
        LEVEL_DEFAULT = r1;
        EnterAnimFeatureLevel r2 = new EnterAnimFeatureLevel("LEVEL_ONE", 1, 100);
        LEVEL_ONE = r2;
        EnterAnimFeatureLevel r3 = new EnterAnimFeatureLevel("LEVEL_TWO", 2, 200);
        LEVEL_TWO = r3;
        EnterAnimFeatureLevel r4 = new EnterAnimFeatureLevel("LEVEL_THREE", 3, 300);
        LEVEL_THREE = r4;
        EnterAnimFeatureLevel r5 = new EnterAnimFeatureLevel("LEVEL_SMART", 4, 999);
        LEVEL_SMART = r5;
        a = new EnterAnimFeatureLevel[]{r1, r2, r3, r4, r5};
    }

    public static EnterAnimFeatureLevel valueOf(String r1) {
        return (EnterAnimFeatureLevel) a.a(EnterAnimFeatureLevel.class, r1);
    }

    public static EnterAnimFeatureLevel[] values() {
        return (EnterAnimFeatureLevel[]) a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public EnterAnimFeatureLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.level = r3;
    }
}
