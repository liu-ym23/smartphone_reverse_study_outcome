package com.obric.cae.connectivity;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface GpsMeasurementReportOrBuilder extends MessageOrBuilder {
    double getAccumulatedDeltaRangeMeters();

    int getAccumulatedDeltaRangeState();

    double getAccumulatedDeltaRangeUncertaintyMeters();

    float getAzimuthDegrees();

    double getBasebandCn0Dbhz();

    double getCarrierFrequencyHz();

    double getCn0Dbhz();

    int getConstellationType();

    float getElevationDegrees();

    int getMultipathIndicator();

    double getPseudorange();

    long getReceivedSvTimeNanos();

    long getReceivedSvTimeUncertaintyNanos();

    int getState();

    int getSvid();

    double getTimeOffsetNanos();

    boolean getUsedInFix();

    boolean hasAccumulatedDeltaRangeMeters();

    boolean hasAccumulatedDeltaRangeState();

    boolean hasAccumulatedDeltaRangeUncertaintyMeters();

    boolean hasAzimuthDegrees();

    boolean hasBasebandCn0Dbhz();

    boolean hasCarrierFrequencyHz();

    boolean hasCn0Dbhz();

    boolean hasConstellationType();

    boolean hasElevationDegrees();

    boolean hasMultipathIndicator();

    boolean hasPseudorange();

    boolean hasReceivedSvTimeNanos();

    boolean hasReceivedSvTimeUncertaintyNanos();

    boolean hasState();

    boolean hasSvid();

    boolean hasTimeOffsetNanos();

    boolean hasUsedInFix();
}
