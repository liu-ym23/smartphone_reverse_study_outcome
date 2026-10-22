package com.bytedance.ies.bullet.service.base;

import com.bytedance.forest.chain.fetchers.GeckoFetcher;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/LoaderName;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final enum LoaderName extends Enum<LoaderName> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LoaderName f5919a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LoaderName f5920b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ LoaderName[] f5921c = null;

    static {
        LoaderName r5 = new LoaderName("ResourceLoader", 0);
        f5919a = r5;
        LoaderName r10 = new LoaderName(GeckoFetcher.GECKO_SDK_INVOKE_ASYNC_TAG, 1);
        f5920b = r10;
        f5921c = new LoaderName[]{r5, r10};
    }

    public LoaderName(String r5, int r10) {
        super(r5, r10);
    }

    public static LoaderName valueOf(String r5) {
        return (LoaderName) Enum.valueOf(LoaderName.class, r5);
    }

    public static LoaderName[] values() {
        return (LoaderName[]) f5921c.clone();
    }
}
