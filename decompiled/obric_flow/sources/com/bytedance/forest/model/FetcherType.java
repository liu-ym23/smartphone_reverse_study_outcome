package com.bytedance.forest.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/forest/model/FetcherType;", "", "forest_release"}, k = 1, mv = {1, 4, 0})
public final enum FetcherType extends Enum<FetcherType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FetcherType f4312a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FetcherType f4313b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final FetcherType f4314c = null;
    public static final FetcherType d = null;
    public static final /* synthetic */ FetcherType[] e = null;

    static {
        FetcherType r5 = new FetcherType("GECKO", 0);
        f4312a = r5;
        FetcherType r10 = new FetcherType("BUILTIN", 1);
        f4313b = r10;
        FetcherType r11 = new FetcherType("CDN", 2);
        f4314c = r11;
        FetcherType r12 = new FetcherType("MEMORY", 3);
        d = r12;
        e = new FetcherType[]{r5, r10, r11, r12};
    }

    public FetcherType(String r5, int r10) {
        super(r5, r10);
    }

    public static FetcherType valueOf(String r5) {
        return (FetcherType) Enum.valueOf(FetcherType.class, r5);
    }

    public static FetcherType[] values() {
        return (FetcherType[]) e.clone();
    }
}
