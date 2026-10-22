package com.bytedance.android.livesdk.interactivity.api.degrade.model.config;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/config/PortraitDanmakuFeatureLevel;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "level", "I", "getLevel", "()I", "LEVEL_DEFAULT", "LEVEL_ONE", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PortraitDanmakuFeatureLevel extends Enum<PortraitDanmakuFeatureLevel> {
    public static final PortraitDanmakuFeatureLevel LEVEL_DEFAULT = null;
    public static final PortraitDanmakuFeatureLevel LEVEL_ONE = null;
    public static final /* synthetic */ PortraitDanmakuFeatureLevel[] a = null;
    private final int level;

    static {
        PortraitDanmakuFeatureLevel r1 = new PortraitDanmakuFeatureLevel("LEVEL_DEFAULT", 0, 0);
        LEVEL_DEFAULT = r1;
        PortraitDanmakuFeatureLevel r2 = new PortraitDanmakuFeatureLevel("LEVEL_ONE", 1, 100);
        LEVEL_ONE = r2;
        a = new PortraitDanmakuFeatureLevel[]{r1, r2};
    }

    public static PortraitDanmakuFeatureLevel valueOf(String r1) {
        return (PortraitDanmakuFeatureLevel) a.a(PortraitDanmakuFeatureLevel.class, r1);
    }

    public static PortraitDanmakuFeatureLevel[] values() {
        return (PortraitDanmakuFeatureLevel[]) a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public PortraitDanmakuFeatureLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.level = r3;
    }
}
