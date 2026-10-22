package com.obric.cae.wifi;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface LinkLayerQualityReportDataOrBuilder extends MessageOrBuilder {
    int getArpNeighbourCount();

    String getBand();

    ByteString getBandBytes();

    int getCcaLevel();

    int getCcaScore();

    int getContentionAtimeBe();

    int getContentionAtimeBk();

    int getContentionAtimeVi();

    int getContentionAtimeVo();

    int getCurrentChannelAPCount();

    int getDelaySizeMatrix(int r8);

    int getDelaySizeMatrixCount();

    List<Integer> getDelaySizeMatrixList();

    int getDeltaChannelCcaBusyTime();

    int getDeltaChannelOnTime();

    int getDeltaChannelRxTime();

    int getDeltaChannelTxTime();

    int getDeltaRadioOnTime();

    int getDeltaRxBytes();

    long getDeltaRxSuccess();

    int getDeltaTxBytes();

    long getDeltaTxSuccess();

    String getDeviceDate();

    ByteString getDeviceDateBytes();

    long getDeviceTime();

    String getEventType();

    ByteString getEventTypeBytes();

    int getFrequency();

    int getOnTimeScan();

    int getPer();

    int getPerScore();

    float getPowerPredMw();

    int getRlCcaBusyRate();

    int getRlRxLinkSpeed();

    int getRlTxLinkSpeed();

    int getRssiAck();

    int getRssiData();

    int getRssiMgmt();

    int getRssiScore();

    int getRxBw();

    int getRxFcsErrLevel();

    int getRxLinkSpeed();

    int getRxMcs();

    int getRxMode();

    int getRxNss();

    int getRxRealSpeed();

    int getRxSpeedKbps();

    int getRxTputPred();

    int getScenario();

    int getTotalRxBytes();

    int getTotalTxBytes();

    long getTotalTxRetranLevelBe();

    long getTotalTxRetranLevelVo();

    int getTxBw();

    float getTxDelayAvg();

    float getTxDelayP10();

    float getTxDelayP90();

    long getTxDelayPkts();

    int getTxLinkSpeed();

    int getTxMcs();

    int getTxMode();

    int getTxNss();

    int getTxRealSpeed();

    int getTxRetranLevel();

    int getTxSpeedKbps();

    int getTxTputPred();

    int getWidth();

    int getWifiStandard();

    String getWifigeneration();

    ByteString getWifigenerationBytes();

    boolean hasArpNeighbourCount();

    boolean hasBand();

    boolean hasCcaLevel();

    boolean hasCcaScore();

    boolean hasContentionAtimeBe();

    boolean hasContentionAtimeBk();

    boolean hasContentionAtimeVi();

    boolean hasContentionAtimeVo();

    boolean hasCurrentChannelAPCount();

    boolean hasDeltaChannelCcaBusyTime();

    boolean hasDeltaChannelOnTime();

    boolean hasDeltaChannelRxTime();

    boolean hasDeltaChannelTxTime();

    boolean hasDeltaRadioOnTime();

    boolean hasDeltaRxBytes();

    boolean hasDeltaRxSuccess();

    boolean hasDeltaTxBytes();

    boolean hasDeltaTxSuccess();

    boolean hasDeviceDate();

    boolean hasDeviceTime();

    boolean hasEventType();

    boolean hasFrequency();

    boolean hasOnTimeScan();

    boolean hasPer();

    boolean hasPerScore();

    boolean hasPowerPredMw();

    boolean hasRlCcaBusyRate();

    boolean hasRlRxLinkSpeed();

    boolean hasRlTxLinkSpeed();

    boolean hasRssiAck();

    boolean hasRssiData();

    boolean hasRssiMgmt();

    boolean hasRssiScore();

    boolean hasRxBw();

    boolean hasRxFcsErrLevel();

    boolean hasRxLinkSpeed();

    boolean hasRxMcs();

    boolean hasRxMode();

    boolean hasRxNss();

    boolean hasRxRealSpeed();

    boolean hasRxSpeedKbps();

    boolean hasRxTputPred();

    boolean hasScenario();

    boolean hasTotalRxBytes();

    boolean hasTotalTxBytes();

    boolean hasTotalTxRetranLevelBe();

    boolean hasTotalTxRetranLevelVo();

    boolean hasTxBw();

    boolean hasTxDelayAvg();

    boolean hasTxDelayP10();

    boolean hasTxDelayP90();

    boolean hasTxDelayPkts();

    boolean hasTxLinkSpeed();

    boolean hasTxMcs();

    boolean hasTxMode();

    boolean hasTxNss();

    boolean hasTxRealSpeed();

    boolean hasTxRetranLevel();

    boolean hasTxSpeedKbps();

    boolean hasTxTputPred();

    boolean hasWidth();

    boolean hasWifiStandard();

    boolean hasWifigeneration();
}
