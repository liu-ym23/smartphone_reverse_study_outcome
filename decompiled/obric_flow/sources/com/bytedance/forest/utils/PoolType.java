package com.bytedance.forest.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/forest/utils/PoolType;", "", "forest_release"}, k = 1, mv = {1, 4, 0})
public final enum PoolType extends Enum<PoolType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PoolType f4582a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PoolType f4583b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final PoolType f4584c = null;
    public static final /* synthetic */ PoolType[] d = null;

    static {
        PoolType r5 = new PoolType("Preload", 0);
        f4582a = r5;
        PoolType r10 = new PoolType("Normal", 1);
        f4583b = r10;
        PoolType r11 = new PoolType("Manger", 2);
        f4584c = r11;
        d = new PoolType[]{r5, r10, r11};
    }

    public PoolType(String r5, int r10) {
        super(r5, r10);
    }

    public static PoolType valueOf(String r5) {
        return (PoolType) Enum.valueOf(PoolType.class, r5);
    }

    public static PoolType[] values() {
        return (PoolType[]) d.clone();
    }
}
