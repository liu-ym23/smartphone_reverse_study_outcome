package com.bytedance.bdinstall.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Utils;
import com.bytedance.common.utility.NetworkUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class NetLoader extends BaseLoader {
    private final Context mApp;

    NetLoader(Context r10) {
        super(true, true);
        this.mApp = r10;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    @SuppressLint({"MissingPermission"})
    protected boolean doLoad(JSONObject r10) {
        Utils.putStringIfNotEmpty(r10, Api.KEY_ACCESS, NetworkUtils.c(this.mApp));
        return true;
    }
}
