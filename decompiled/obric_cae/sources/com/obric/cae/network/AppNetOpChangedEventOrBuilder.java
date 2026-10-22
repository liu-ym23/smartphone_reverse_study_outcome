package com.obric.cae.network;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface AppNetOpChangedEventOrBuilder extends MessageOrBuilder {
    int getMode();

    int getOpCode();

    String getPkgName();

    ByteString getPkgNameBytes();

    long getTimestamp();

    int getUid();

    boolean hasMode();

    boolean hasOpCode();

    boolean hasPkgName();

    boolean hasTimestamp();

    boolean hasUid();
}
