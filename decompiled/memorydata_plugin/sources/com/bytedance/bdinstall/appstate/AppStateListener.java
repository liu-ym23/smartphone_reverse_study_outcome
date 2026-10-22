package com.bytedance.bdinstall.appstate;

/* JADX INFO: loaded from: classes.dex */
public interface AppStateListener {

    public interface OnActivityResumeListener {
        void onResume();
    }

    boolean isActive();

    boolean isForeground();

    void setOnResumeListener(OnActivityResumeListener r1);
}
