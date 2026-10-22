package com.obric.cae.network;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface NetworkQoEOrBuilder extends MessageOrBuilder {
    int getCcaBusyRate();

    int getChannelBusyRate();

    boolean getDefaultNetwork();

    String getForegroundApp();

    ByteString getForegroundAppBytes();

    boolean getL2QoeStateGood();

    boolean getL4QoeStateGood();

    int getNetworkType();

    int getOnTimeRate();

    int getPer();

    int getRecvOooPercent();

    int getRecvPackets();

    int getRecvRate();

    int getRetranRate();

    int getRtt();

    int getRxLinkSpeed();

    int getRxMpdu();

    int getRxSpeedKbps();

    int getRxTput();

    int getSendPackets();

    int getSendRate();

    int getStreamNum();

    long getTimestamp();

    int getTxLinkSpeed();

    int getTxMpdu();

    int getTxRetries();

    int getTxSpeedKbps();

    int getTxTput();

    int getUnacked();

    boolean getValid();

    boolean hasCcaBusyRate();

    boolean hasChannelBusyRate();

    boolean hasDefaultNetwork();

    boolean hasForegroundApp();

    boolean hasL2QoeStateGood();

    boolean hasL4QoeStateGood();

    boolean hasNetworkType();

    boolean hasOnTimeRate();

    boolean hasPer();

    boolean hasRecvOooPercent();

    boolean hasRecvPackets();

    boolean hasRecvRate();

    boolean hasRetranRate();

    boolean hasRtt();

    boolean hasRxLinkSpeed();

    boolean hasRxMpdu();

    boolean hasRxSpeedKbps();

    boolean hasRxTput();

    boolean hasSendPackets();

    boolean hasSendRate();

    boolean hasStreamNum();

    boolean hasTimestamp();

    boolean hasTxLinkSpeed();

    boolean hasTxMpdu();

    boolean hasTxRetries();

    boolean hasTxSpeedKbps();

    boolean hasTxTput();

    boolean hasUnacked();

    boolean hasValid();
}
