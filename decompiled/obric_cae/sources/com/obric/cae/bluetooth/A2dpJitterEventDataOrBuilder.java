package com.obric.cae.bluetooth;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface A2dpJitterEventDataOrBuilder extends MessageOrBuilder {
    float getDeltaRetransSum();

    float getHostBufferMargin();

    int getLabel();

    int getMAclTxQueueLength();

    int getMGlitchCount();

    int getMNakCount();

    int getMNoRxCount();

    int getMOverflowCount();

    String getMPacketType();

    ByteString getMPacketTypeBytes();

    int getMTxPowerLevel();

    float getNoRxRatio();

    float getProb();

    float getSilenceDuration();

    long getTimeToBtRestartMs();

    long getTimeToRevertMs();

    long getTimestamp();

    boolean hasDeltaRetransSum();

    boolean hasHostBufferMargin();

    boolean hasLabel();

    boolean hasMAclTxQueueLength();

    boolean hasMGlitchCount();

    boolean hasMNakCount();

    boolean hasMNoRxCount();

    boolean hasMOverflowCount();

    boolean hasMPacketType();

    boolean hasMTxPowerLevel();

    boolean hasNoRxRatio();

    boolean hasProb();

    boolean hasSilenceDuration();

    boolean hasTimeToBtRestartMs();

    boolean hasTimeToRevertMs();

    boolean hasTimestamp();
}
