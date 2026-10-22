package com.obric.cae.p001useraware;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface UserAwarePrecisionDataOrBuilder extends MessageOrBuilder {
    int getStateChange();

    int getStateCode();

    long getTimeStamp();

    int getUserChoice();

    boolean hasStateChange();

    boolean hasStateCode();

    boolean hasTimeStamp();

    boolean hasUserChoice();
}
