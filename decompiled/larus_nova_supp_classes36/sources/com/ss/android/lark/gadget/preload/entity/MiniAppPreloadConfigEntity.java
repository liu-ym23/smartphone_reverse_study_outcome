package com.ss.android.lark.gadget.preload.entity;

import com.ss.android.lark.gadget.preload.listener.MiniAppPreloadStateListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class MiniAppPreloadConfigEntity {
    private boolean mCancelPreloadWhenNotWifi;
    private MiniAppPreloadStateListener mPreloadStateListener;

    public MiniAppPreloadConfigEntity() {
        this.mCancelPreloadWhenNotWifi = true;
    }

    public MiniAppPreloadStateListener getPreloadStateListener() {
        return this.mPreloadStateListener;
    }

    public boolean isCancelPreloadWhenNotWifi() {
        return this.mCancelPreloadWhenNotWifi;
    }

    public void setCancelPreloadWhenNotWifi(boolean r1) {
        this.mCancelPreloadWhenNotWifi = r1;
    }

    public void setPreloadStateListener(MiniAppPreloadStateListener r1) {
        this.mPreloadStateListener = r1;
    }
}
