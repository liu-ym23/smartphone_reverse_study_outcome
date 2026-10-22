package com.bytedance.bdinstall.loader;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseLoader {
    private static final String UTF_8 = "UTF-8";
    boolean mOptional;
    boolean mReady;
    boolean mShouldUpdate;
    boolean syncFromSub;

    BaseLoader(boolean r10, boolean r11) {
        this.mOptional = r10;
        this.mShouldUpdate = r11;
        this.syncFromSub = false;
    }

    BaseLoader(boolean r10, boolean r11, boolean r12) {
        this.mOptional = r10;
        this.mShouldUpdate = r11;
        this.syncFromSub = r12;
    }

    protected abstract boolean doLoad(JSONObject r10);

    public void remove(JSONObject r10) {
    }
}
