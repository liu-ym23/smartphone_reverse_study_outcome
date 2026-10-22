package com.bytedance.bdinstall.appstate;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class AppLifeCycleListener implements Application.ActivityLifecycleCallbacks, AppStateListener {
    private int mForegroundActivityNum;
    private boolean mIsForeground;
    private AppStateListener.OnActivityResumeListener mOnResumeListener;
    private boolean mResumed;

    public AppLifeCycleListener() {
    }

    private void onEnterBackground() {
        this.mIsForeground = false;
    }

    private void onEnterForeground() {
        this.mIsForeground = true;
    }

    @Override // com.bytedance.bdinstall.appstate.AppStateListener
    public boolean isActive() {
        return this.mResumed;
    }

    @Override // com.bytedance.bdinstall.appstate.AppStateListener
    public boolean isForeground() {
        return this.mIsForeground;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r10) {
        int r11 = this.mForegroundActivityNum - 1;
        this.mForegroundActivityNum = r11;
        if (r11 > 0) goto L6;
        onEnterBackground();
    L6:
        if (this.mForegroundActivityNum >= 0) goto L9;
        this.mForegroundActivityNum = 0;
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r10) {
        if (this.mForegroundActivityNum >= 0) goto L6;
        this.mForegroundActivityNum = 0;
    L6:
        if (this.mForegroundActivityNum != 0) goto L8;
        onEnterForeground();
    L8:
        this.mForegroundActivityNum++;
        this.mResumed = true;
        AppStateListener.OnActivityResumeListener r11 = this.mOnResumeListener;
        if (r11 == null) goto L12;
        r11.onResume();
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r10) {
    }

    @Override // com.bytedance.bdinstall.appstate.AppStateListener
    public void setOnResumeListener(AppStateListener.OnActivityResumeListener r10) {
        this.mOnResumeListener = r10;
    }
}
