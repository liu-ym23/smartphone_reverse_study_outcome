package com.obric.matrix.platform.sdk.ones.picolinks;

import com.obric.matrix.proto.StartPicoLinksResponse;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f11903a = null;

    static {
        int[] r5 = new int[StartPicoLinksResponse.Phase.values().length];
        r5[StartPicoLinksResponse.Phase.URL_REDIRECT.ordinal()] = 1;
        r5[StartPicoLinksResponse.Phase.ASYNC_CALLBACK.ordinal()] = 2;
        f11903a = r5;
    }
}
