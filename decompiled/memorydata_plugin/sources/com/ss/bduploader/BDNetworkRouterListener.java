package com.ss.bduploader;

/* JADX INFO: loaded from: classes6.dex */
public interface BDNetworkRouterListener {
    public static final int ContextTypeRoutALL = 1;
    public static final int ContextTypeRoutError = 2;
    public static final int ContextTypeRoutFirst = 0;

    int networkRouteCheckNetState(int r1, int r2);

    void onRouteContext(int r1, int r2, String r3);
}
