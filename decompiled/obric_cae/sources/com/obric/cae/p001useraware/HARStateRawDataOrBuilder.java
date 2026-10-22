package com.obric.cae.p001useraware;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface HARStateRawDataOrBuilder extends MessageOrBuilder {
    int getModelNumber();

    int getStateCode();

    long getTimeStamp();

    boolean hasModelNumber();

    boolean hasStateCode();

    boolean hasTimeStamp();
}
