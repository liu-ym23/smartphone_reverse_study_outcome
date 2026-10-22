package com.bytedance.android.anniex.scene.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/anniex/scene/core/SceneOrigin;", "", "HYBRID", "NA_PAGE", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum SceneOrigin extends Enum<SceneOrigin> {
    public static final SceneOrigin HYBRID = null;
    public static final SceneOrigin NA_PAGE = null;
    public static final /* synthetic */ SceneOrigin[] a = null;

    public static SceneOrigin valueOf(String r1) {
        return (SceneOrigin) r27.a.a(SceneOrigin.class, r1);
    }

    public static SceneOrigin[] values() {
        return (SceneOrigin[]) a.clone();
    }

    static {
        SceneOrigin r0 = new SceneOrigin("HYBRID", 0);
        HYBRID = r0;
        SceneOrigin r1 = new SceneOrigin("NA_PAGE", 1);
        NA_PAGE = r1;
        a = new SceneOrigin[]{r0, r1};
    }

    public SceneOrigin(String r1, int r10) {
        super(r1, r10);
    }
}
