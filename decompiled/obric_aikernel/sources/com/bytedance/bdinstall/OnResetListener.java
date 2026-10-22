package com.bytedance.bdinstall;

import androidx.annotation.UiThread;

/* JADX INFO: loaded from: classes.dex */
public interface OnResetListener {
    @UiThread
    void onDidUpdate(InstallInfo r10);

    @UiThread
    void onTimeout();
}
