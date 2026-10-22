package com.obric.cae.wifi;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface LinkStatsOrBuilder extends MessageOrBuilder {
    int getCcaLevel();

    int getCenterFreq();

    int getContentionAtimeBe();

    int getContentionAtimeBk();

    int getContentionAtimeVi();

    int getContentionAtimeVo();

    int getDeltaCcaBusyTime();

    int getDeltaRadioOnTime();

    int getDeltaRxSuccess();

    long getDeltaTxBad();

    long getDeltaTxRetries();

    long getDeltaTxSuccess();

    int getLinkId();

    int getOnTimeScan();

    int getPer();

    float getPowerPredMw();

    int getRadioId();

    int getRlCcaBusyRate();

    int getRlRxLinkSpeed();

    int getRlTxLinkSpeed();

    int getRssiAck();

    int getRssiData();

    int getRssiMgmt();

    int getRxSpeedKbps();

    int getTxBadLevel();

    long getTxMpduBe();

    long getTxMpduVi();

    long getTxMpduVo();

    int getTxRetranLevelBe();

    int getTxRetranLevelVi();

    int getTxRetranLevelVo();

    int getTxRetrayLevel();

    long getTxRetriesBe();

    long getTxRetriesVi();

    long getTxRetriesVo();

    int getTxSpeedKbps();

    int getWidth();

    boolean hasCcaLevel();

    boolean hasCenterFreq();

    boolean hasContentionAtimeBe();

    boolean hasContentionAtimeBk();

    boolean hasContentionAtimeVi();

    boolean hasContentionAtimeVo();

    boolean hasDeltaCcaBusyTime();

    boolean hasDeltaRadioOnTime();

    boolean hasDeltaRxSuccess();

    boolean hasDeltaTxBad();

    boolean hasDeltaTxRetries();

    boolean hasDeltaTxSuccess();

    boolean hasLinkId();

    boolean hasOnTimeScan();

    boolean hasPer();

    boolean hasPowerPredMw();

    boolean hasRadioId();

    boolean hasRlCcaBusyRate();

    boolean hasRlRxLinkSpeed();

    boolean hasRlTxLinkSpeed();

    boolean hasRssiAck();

    boolean hasRssiData();

    boolean hasRssiMgmt();

    boolean hasRxSpeedKbps();

    boolean hasTxBadLevel();

    boolean hasTxMpduBe();

    boolean hasTxMpduVi();

    boolean hasTxMpduVo();

    boolean hasTxRetranLevelBe();

    boolean hasTxRetranLevelVi();

    boolean hasTxRetranLevelVo();

    boolean hasTxRetrayLevel();

    boolean hasTxRetriesBe();

    boolean hasTxRetriesVi();

    boolean hasTxRetriesVo();

    boolean hasTxSpeedKbps();

    boolean hasWidth();
}
