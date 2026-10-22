package com.obric.cae.userAware;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface WifiScanDataOrBuilder extends MessageOrBuilder {
    int getChannelWidth();

    int getFreq();

    int getRssi();

    long getTimestamp();

    boolean hasChannelWidth();

    boolean hasFreq();

    boolean hasRssi();

    boolean hasTimestamp();
}
