package com.bytedance.bdinstall.callback;

import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.service.IInstallParameters;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface RegisterResultListener {
    boolean onRegisterResult(JSONObject r10, Env r11, IInstallParameters r12);
}
