package com.obric.cae.network;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface NetworkFastSwitchDataOrBuilder extends MessageOrBuilder {
    int getBoostTime();

    int getScene();

    long getTimestamp();

    boolean hasBoostTime();

    boolean hasScene();

    boolean hasTimestamp();
}
