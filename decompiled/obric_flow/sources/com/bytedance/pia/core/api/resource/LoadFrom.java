package com.bytedance.pia.core.api.resource;

/* JADX INFO: loaded from: classes2.dex */
public final enum LoadFrom extends Enum<LoadFrom> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LoadFrom f6955a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LoadFrom f6956b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LoadFrom f6957c = null;
    public static final /* synthetic */ LoadFrom[] d = null;

    static {
        LoadFrom r5 = new LoadFrom("Offline", 0);
        f6955a = r5;
        LoadFrom r10 = new LoadFrom("Online", 1);
        f6956b = r10;
        LoadFrom r11 = new LoadFrom("Auto", 2);
        f6957c = r11;
        d = new LoadFrom[]{r5, r10, r11};
    }

    public LoadFrom(String r5, int r10) {
        super(r5, r10);
    }

    public static LoadFrom valueOf(String r5) {
        return (LoadFrom) Enum.valueOf(LoadFrom.class, r5);
    }

    public static LoadFrom[] values() {
        return (LoadFrom[]) d.clone();
    }
}
