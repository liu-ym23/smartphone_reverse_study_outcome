package com.bytedance.ies.bullet.service.base.resourceloader.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/resourceloader/config/LoaderType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum LoaderType extends Enum<LoaderType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LoaderType f5993a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LoaderType f5994b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LoaderType f5995c = null;
    public static final /* synthetic */ LoaderType[] d = null;

    static {
        LoaderType r5 = new LoaderType("GECKO", 0);
        f5993a = r5;
        LoaderType r10 = new LoaderType("BUILTIN", 1);
        f5994b = r10;
        LoaderType r11 = new LoaderType("CDN", 2);
        f5995c = r11;
        d = new LoaderType[]{r5, r10, r11};
    }

    public LoaderType(String r5, int r10) {
        super(r5, r10);
    }

    public static LoaderType valueOf(String r5) {
        return (LoaderType) Enum.valueOf(LoaderType.class, r5);
    }

    public static LoaderType[] values() {
        return (LoaderType[]) d.clone();
    }
}
