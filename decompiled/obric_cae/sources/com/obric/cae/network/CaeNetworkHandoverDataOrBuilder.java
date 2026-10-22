package com.obric.cae.network;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface CaeNetworkHandoverDataOrBuilder extends MessageOrBuilder {
    ClusterData getClusterEvent();

    ClusterDataOrBuilder getClusterEventOrBuilder();

    NetworkBadQoEData getNetworkBadQoeEvent();

    NetworkBadQoEDataOrBuilder getNetworkBadQoeEventOrBuilder();

    NetworkDetectData getNetworkDetectEvent();

    NetworkDetectDataOrBuilder getNetworkDetectEventOrBuilder();

    NetworkFastSwitchData getNetworkFastSwitchEvent();

    NetworkFastSwitchDataOrBuilder getNetworkFastSwitchEventOrBuilder();

    SwitchFeedbackData getSwitchFeedbackEvent();

    SwitchFeedbackDataOrBuilder getSwitchFeedbackEventOrBuilder();

    SwitchNetworkData getSwitchNetworkEvent();

    SwitchNetworkDataOrBuilder getSwitchNetworkEventOrBuilder();

    SwitchRLData getSwitchRlEvent();

    SwitchRLDataOrBuilder getSwitchRlEventOrBuilder();

    SwitchTrafficData getSwitchTrafficEvent();

    SwitchTrafficDataOrBuilder getSwitchTrafficEventOrBuilder();

    boolean hasClusterEvent();

    boolean hasNetworkBadQoeEvent();

    boolean hasNetworkDetectEvent();

    boolean hasNetworkFastSwitchEvent();

    boolean hasSwitchFeedbackEvent();

    boolean hasSwitchNetworkEvent();

    boolean hasSwitchRlEvent();

    boolean hasSwitchTrafficEvent();
}
