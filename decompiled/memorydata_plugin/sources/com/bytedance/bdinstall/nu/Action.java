package com.bytedance.bdinstall.nu;

/* JADX INFO: loaded from: classes.dex */
public interface Action {
    Action addCustomParam(String r1, String r2);

    void done();

    Action setAutoMode(boolean r1);

    Action setNUMode(boolean r1);
}
