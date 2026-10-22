package com.bytedance.bdinstall.callback.event;

import com.bytedance.bdinstall.InstallInfo;

/* JADX INFO: loaded from: classes.dex */
public class InstallFinishEvent {
    private InstallInfo info;

    public InstallFinishEvent(InstallInfo r10) {
        this.info = r10;
    }

    public InstallInfo getInfo() {
        return this.info;
    }
}
