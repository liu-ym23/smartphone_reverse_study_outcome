package com.obric.cae.wifi;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface MloLinkLayerQualityReportDataOrBuilder extends MessageOrBuilder {
    int getArpNeighbourCount();

    String getBand();

    String getBand1();

    ByteString getBand1Bytes();

    ByteString getBandBytes();

    int getCcaScore();

    int getContentionAtimeBk();

    int getContentionAtimeVi();

    int getCurrentChannelAPCount();

    int getDelaySizeMatrix(int r8);

    int getDelaySizeMatrixCount();

    List<Integer> getDelaySizeMatrixList();

    int getDeltaChannelCcaBusyTime();

    int getDeltaChannelOnTime();

    int getDeltaChannelRxTime();

    int getDeltaChannelTxTime();

    int getDeltaRxBytes();

    int getDeltaRxFcsErr();

    int getDeltaTxBytes();

    String getDeviceDate();

    ByteString getDeviceDateBytes();

    long getDeviceTime();

    String getEventType();

    ByteString getEventTypeBytes();

    int getFreq();

    String getIfName();

    ByteString getIfNameBytes();

    boolean getIsMloIface();

    LinkStats getLinkStats(int r8);

    int getLinkStatsCount();

    List<LinkStats> getLinkStatsList();

    LinkStatsOrBuilder getLinkStatsOrBuilder(int r8);

    List<? extends LinkStatsOrBuilder> getLinkStatsOrBuilderList();

    int getPerScore();

    int getRssiScore();

    int getRxBw();

    int getRxFcsErrLevel();

    int getRxMcs();

    int getRxMode();

    int getRxNss();

    int getRxRealSpeed();

    int getRxTputPred();

    int getRxlinkSpeed();

    int getScenario();

    int getTotalRxBytes();

    int getTotalTxBytes();

    int getTxBw();

    float getTxDelayAvg();

    float getTxDelayP10();

    float getTxDelayP90();

    long getTxDelayPkts();

    int getTxMcs();

    int getTxMode();

    int getTxNss();

    int getTxRealSpeed();

    int getTxTputPred();

    int getTxlinkSpeed();

    String getWifiGeneration();

    ByteString getWifiGenerationBytes();

    int getWifiStandard();

    boolean hasArpNeighbourCount();

    boolean hasBand();

    boolean hasBand1();

    boolean hasCcaScore();

    boolean hasContentionAtimeBk();

    boolean hasContentionAtimeVi();

    boolean hasCurrentChannelAPCount();

    boolean hasDeltaChannelCcaBusyTime();

    boolean hasDeltaChannelOnTime();

    boolean hasDeltaChannelRxTime();

    boolean hasDeltaChannelTxTime();

    boolean hasDeltaRxBytes();

    boolean hasDeltaRxFcsErr();

    boolean hasDeltaTxBytes();

    boolean hasDeviceDate();

    boolean hasDeviceTime();

    boolean hasEventType();

    boolean hasFreq();

    boolean hasIfName();

    boolean hasIsMloIface();

    boolean hasPerScore();

    boolean hasRssiScore();

    boolean hasRxBw();

    boolean hasRxFcsErrLevel();

    boolean hasRxMcs();

    boolean hasRxMode();

    boolean hasRxNss();

    boolean hasRxRealSpeed();

    boolean hasRxTputPred();

    boolean hasRxlinkSpeed();

    boolean hasScenario();

    boolean hasTotalRxBytes();

    boolean hasTotalTxBytes();

    boolean hasTxBw();

    boolean hasTxDelayAvg();

    boolean hasTxDelayP10();

    boolean hasTxDelayP90();

    boolean hasTxDelayPkts();

    boolean hasTxMcs();

    boolean hasTxMode();

    boolean hasTxNss();

    boolean hasTxRealSpeed();

    boolean hasTxTputPred();

    boolean hasTxlinkSpeed();

    boolean hasWifiGeneration();

    boolean hasWifiStandard();
}
