package com.bytedance.forest.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/forest/model/PreloadType;", "", "forest_release"}, k = 1, mv = {1, 4, 0})
public final enum PreloadType extends Enum<PreloadType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PreloadType f4333a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PreloadType f4334b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ PreloadType[] f4335c = null;

    static {
        PreloadType r5 = new PreloadType("LYNX", 0);
        f4333a = r5;
        PreloadType r10 = new PreloadType("WEB", 1);
        f4334b = r10;
        f4335c = new PreloadType[]{r5, r10};
    }

    public PreloadType(String r5, int r10) {
        super(r5, r10);
    }

    public static PreloadType valueOf(String r5) {
        return (PreloadType) Enum.valueOf(PreloadType.class, r5);
    }

    public static PreloadType[] values() {
        return (PreloadType[]) f4335c.clone();
    }
}
