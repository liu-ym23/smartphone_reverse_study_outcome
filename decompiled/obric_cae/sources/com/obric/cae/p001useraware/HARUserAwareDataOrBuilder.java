package com.obric.cae.p001useraware;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface HARUserAwareDataOrBuilder extends MessageOrBuilder {
    int getStateCode();

    long getTimeStamp();

    int getUserChoice();

    boolean hasStateCode();

    boolean hasTimeStamp();

    boolean hasUserChoice();
}
