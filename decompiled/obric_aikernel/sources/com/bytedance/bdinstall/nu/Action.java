package com.bytedance.bdinstall.nu;

/* JADX INFO: loaded from: classes.dex */
public interface Action {
    Action addCustomParam(String r10, String r11);

    void done();

    Action setAutoMode(boolean r10);

    Action setNUMode(boolean r10);
}
