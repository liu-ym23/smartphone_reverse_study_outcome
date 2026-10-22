package com.bytedance.bdinstall.callback;

import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.network.TTResponse;
import com.bytedance.bdinstall.service.IInstallParameters;

/* JADX INFO: loaded from: classes.dex */
public interface RegisterResultListener {
    boolean onRegisterResult(TTResponse r1, Env r2, IInstallParameters r3);
}
