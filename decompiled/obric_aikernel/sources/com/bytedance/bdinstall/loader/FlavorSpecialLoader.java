package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.InstallOptions;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FlavorSpecialLoader extends BaseLoader {
    FlavorSpecialLoader(Context r10, InstallOptions r11) {
        super(false, false);
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    protected boolean doLoad(JSONObject r10) {
        return true;
    }
}
