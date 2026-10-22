package com.obric.cae.network;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface SwitchFeedbackDataOrBuilder extends MessageOrBuilder {
    int getFeedbackType();

    FeatureDataPb getNoSwitchInterveneFeature();

    FeatureDataPbOrBuilder getNoSwitchInterveneFeatureOrBuilder();

    long getNoSwitchInterveneTimestamp();

    int getSolutionType();

    FeatureDataPb getSwitchFeature();

    FeatureDataPbOrBuilder getSwitchFeatureOrBuilder();

    FeatureDataPb getSwitchInterveneFeature();

    FeatureDataPbOrBuilder getSwitchInterveneFeatureOrBuilder();

    long getSwitchInterveneTimestamp();

    long getSwitchTimestamp();

    boolean hasFeedbackType();

    boolean hasNoSwitchInterveneFeature();

    boolean hasNoSwitchInterveneTimestamp();

    boolean hasSolutionType();

    boolean hasSwitchFeature();

    boolean hasSwitchInterveneFeature();

    boolean hasSwitchInterveneTimestamp();

    boolean hasSwitchTimestamp();
}
