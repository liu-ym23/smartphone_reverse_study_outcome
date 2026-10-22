package com.bytedance.bdinstall;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface AppContext extends IAbContext {
    int getAid();

    String getAppName();

    String getChannel();

    Context getContext();

    long getManifestVersionCode();

    String getTweakedChannel();

    long getUpdateVersionCode();

    String getVersion();

    long getVersionCode();

    boolean isMainInstance();
}
