package com.bytedance.forest.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/forest/model/GeckoSource;", "", "forest_release"}, k = 1, mv = {1, 4, 0})
public final enum GeckoSource extends Enum<GeckoSource> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GeckoSource f4321a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final GeckoSource f4322b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final GeckoSource f4323c = null;
    public static final GeckoSource d = null;
    public static final GeckoSource e = null;
    public static final /* synthetic */ GeckoSource[] f = null;

    static {
        GeckoSource r5 = new GeckoSource("REMOTE_SETTING", 0);
        f4321a = r5;
        GeckoSource r10 = new GeckoSource("CLIENT_CONFIG", 1);
        f4322b = r10;
        GeckoSource r11 = new GeckoSource("URL_QUERY", 2);
        f4323c = r11;
        GeckoSource r12 = new GeckoSource("QUERIED_PREFIX", 3);
        d = r12;
        GeckoSource r13 = new GeckoSource("INJECTED_PREFIXES", 4);
        e = r13;
        f = new GeckoSource[]{r5, r10, r11, r12, r13};
    }

    public GeckoSource(String r5, int r10) {
        super(r5, r10);
    }

    public static GeckoSource valueOf(String r5) {
        return (GeckoSource) Enum.valueOf(GeckoSource.class, r5);
    }

    public static GeckoSource[] values() {
        return (GeckoSource[]) f.clone();
    }
}
