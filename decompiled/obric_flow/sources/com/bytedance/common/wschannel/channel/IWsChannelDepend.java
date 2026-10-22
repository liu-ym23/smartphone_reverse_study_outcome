package com.bytedance.common.wschannel.channel;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public interface IWsChannelDepend {
    int getNetworkType(Context r5);

    void loadLibrary(Context r5, String r10);

    void loggerD(String r5, String r10);

    boolean loggerDebug();

    void setAdapter(IWsChannelDepend r5);
}
