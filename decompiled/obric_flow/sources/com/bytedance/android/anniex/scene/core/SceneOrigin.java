package com.bytedance.android.anniex.scene.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/anniex/scene/core/SceneOrigin;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum SceneOrigin extends Enum<SceneOrigin> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SceneOrigin f3377a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SceneOrigin f3378b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ SceneOrigin[] f3379c = null;

    static {
        SceneOrigin r5 = new SceneOrigin("HYBRID", 0);
        f3377a = r5;
        SceneOrigin r10 = new SceneOrigin("NA_PAGE", 1);
        f3378b = r10;
        f3379c = new SceneOrigin[]{r5, r10};
    }

    public SceneOrigin(String r5, int r10) {
        super(r5, r10);
    }

    public static SceneOrigin valueOf(String r5) {
        return (SceneOrigin) Enum.valueOf(SceneOrigin.class, r5);
    }

    public static SceneOrigin[] values() {
        return (SceneOrigin[]) f3379c.clone();
    }
}
