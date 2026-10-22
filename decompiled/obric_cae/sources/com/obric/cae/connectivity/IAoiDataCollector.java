package com.obric.cae.connectivity;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface IAoiDataCollector {
    public static final int TYPE_BLUETOOTH = 2;
    public static final int TYPE_CELLULAR = 8;
    public static final int TYPE_GPS = 4;
    public static final int TYPE_WIFI = 1;

    void destroy();

    int getCollectorType();

    void init(Context r8);

    void startCollect(String r8, long r10);

    void stopCollect();
}
