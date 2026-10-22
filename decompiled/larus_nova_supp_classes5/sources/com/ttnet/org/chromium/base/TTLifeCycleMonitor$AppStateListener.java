package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public interface TTLifeCycleMonitor$AppStateListener {
    void onEnterToBackground();

    void onEnterToForeground();

    void onInstantEnterToBackground();

    void onInstantEnterToForeground();
}
