package com.bytedance.android.live.initialize;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/initialize/WTOSceneType;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "CURRENT", "PRELOAD", "COMMON", "live-initialize-annotation_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WTOSceneType extends Enum<WTOSceneType> {
    public static final WTOSceneType COMMON = null;
    public static final WTOSceneType CURRENT = null;
    public static final WTOSceneType PRELOAD = null;
    public static final /* synthetic */ WTOSceneType[] a = null;
    private final String tag;

    static {
        WTOSceneType r1 = new WTOSceneType("CURRENT", 0, "CURRENT");
        CURRENT = r1;
        WTOSceneType r2 = new WTOSceneType("PRELOAD", 1, "PRELOAD");
        PRELOAD = r2;
        WTOSceneType r3 = new WTOSceneType("COMMON", 2, "COMMON");
        COMMON = r3;
        a = new WTOSceneType[]{r1, r2, r3};
    }

    public static WTOSceneType valueOf(String r1) {
        return (WTOSceneType) r27.a.a(WTOSceneType.class, r1);
    }

    public static WTOSceneType[] values() {
        return (WTOSceneType[]) a.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    public WTOSceneType(String r1, int r2, String r3) {
        super(r1, r2);
        this.tag = r3;
    }
}
