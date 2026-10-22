package com.bytedance.android.livesdk.interactivity.api.degrade.model.config;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/config/CommentCarnivalFeatureLevel;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "level", "I", "getLevel", "()I", "LEVEL_DEFAULT", "LEVEL_ONE", "LEVEL_SMART", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentCarnivalFeatureLevel extends Enum<CommentCarnivalFeatureLevel> {
    public static final CommentCarnivalFeatureLevel LEVEL_DEFAULT = null;
    public static final CommentCarnivalFeatureLevel LEVEL_ONE = null;
    public static final CommentCarnivalFeatureLevel LEVEL_SMART = null;
    public static final /* synthetic */ CommentCarnivalFeatureLevel[] a = null;
    private final int level;

    static {
        CommentCarnivalFeatureLevel r1 = new CommentCarnivalFeatureLevel("LEVEL_DEFAULT", 0, 0);
        LEVEL_DEFAULT = r1;
        CommentCarnivalFeatureLevel r2 = new CommentCarnivalFeatureLevel("LEVEL_ONE", 1, 100);
        LEVEL_ONE = r2;
        CommentCarnivalFeatureLevel r3 = new CommentCarnivalFeatureLevel("LEVEL_SMART", 2, 999);
        LEVEL_SMART = r3;
        a = new CommentCarnivalFeatureLevel[]{r1, r2, r3};
    }

    public static CommentCarnivalFeatureLevel valueOf(String r1) {
        return (CommentCarnivalFeatureLevel) a.a(CommentCarnivalFeatureLevel.class, r1);
    }

    public static CommentCarnivalFeatureLevel[] values() {
        return (CommentCarnivalFeatureLevel[]) a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public CommentCarnivalFeatureLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.level = r3;
    }
}
