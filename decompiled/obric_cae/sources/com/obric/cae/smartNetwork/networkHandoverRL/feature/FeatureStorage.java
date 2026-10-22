package com.obric.cae.smartNetwork.networkHandoverRL.feature;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class FeatureStorage {
    private static volatile FeatureStorage mFeaturePreference;
    private final Context mContext;
    private FeatureData mLatestFeature;

    private FeatureStorage(Context r8) {
        this.mContext = r8;
    }

    public static FeatureStorage getInstance(Context r8) {
        if (mFeaturePreference != null) goto L15;
        monitor-enter(FeatureStorage.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mFeaturePreference != null) goto L9;
        mFeaturePreference = new FeatureStorage(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(FeatureStorage.class);     // Catch: Throwable -> L11
    L15:
        return mFeaturePreference;
    }

    public FeatureData getLatestFeature() {
        return this.mLatestFeature;
    }

    public void setLatestFeature(FeatureData r8) {
        this.mLatestFeature = r8;
    }
}
