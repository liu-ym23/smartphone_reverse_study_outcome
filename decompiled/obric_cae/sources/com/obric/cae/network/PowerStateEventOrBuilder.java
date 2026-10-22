package com.obric.cae.network;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface PowerStateEventOrBuilder extends MessageOrBuilder {
    long getTimestamp();

    PowerStateEventType getType();

    boolean getValue();

    boolean hasTimestamp();

    boolean hasType();

    boolean hasValue();
}
