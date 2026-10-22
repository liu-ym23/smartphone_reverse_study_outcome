package com.ss.android.lark.gadget.preload.listener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface MiniAppPreloadStateListener {
    void onPreloadCancel(String r1);

    void onPreloadFail(String r1);

    void onPreloadFinish(String r1, boolean r2, long r3);

    void onPreloadProgress(String r1, int r2);

    void onPreloadResume(String r1);

    void onPreloadStart(String r1);

    void onPreloadStop(String r1);
}
