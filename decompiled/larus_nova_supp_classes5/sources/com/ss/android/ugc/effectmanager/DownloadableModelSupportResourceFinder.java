package com.ss.android.ugc.effectmanager;

import com.ss.ugc.effectplatform.algorithm.AlgorithmResourceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class DownloadableModelSupportResourceFinder {
    public DownloadableModelSupportResourceFinder() {
    }

    public long getNativeResourceFinder() {
        return AlgorithmResourceManager.getInstance().getResourceFinder().getNativeResourceFinder();
    }

    public static String findResourceUri(String r2, String r3) {
        return AlgorithmResourceManager.getInstance().getResourceFinder().realFindResourceUri(0, r2, r3);
    }
}
