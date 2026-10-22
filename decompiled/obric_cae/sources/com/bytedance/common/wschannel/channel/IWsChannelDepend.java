package com.bytedance.common.wschannel.channel;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public interface IWsChannelDepend {
    int getNetworkType(Context r8);

    void loadLibrary(Context r8, String r10);

    void loggerD(String r8, String r10);

    boolean loggerDebug();

    void setAdapter(IWsChannelDepend r8);
}
