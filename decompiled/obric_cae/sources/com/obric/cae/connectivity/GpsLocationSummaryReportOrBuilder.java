package com.obric.cae.connectivity;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface GpsLocationSummaryReportOrBuilder extends MessageOrBuilder {
    float getAccuracy();

    double getAltitude();

    float getAvgCn0Dbhz();

    float getBearing();

    float getBearingAccuracy();

    boolean getHasAlmanac();

    boolean getHasEphemeris();

    float getHdop();

    double getLatitude();

    long getLocationTime();

    double getLongitude();

    float getMaxCn0Dbhz();

    float getPdop();

    String getProvider();

    ByteString getProviderBytes();

    int getSatelliteCount();

    float getSpeed();

    float getSpeedAccuracy();

    int getUsedInFixCount();

    float getVdop();

    float getVerticalAccuracy();

    boolean hasAccuracy();

    boolean hasAltitude();

    boolean hasAvgCn0Dbhz();

    boolean hasBearing();

    boolean hasBearingAccuracy();

    boolean hasHasAlmanac();

    boolean hasHasEphemeris();

    boolean hasHdop();

    boolean hasLatitude();

    boolean hasLocationTime();

    boolean hasLongitude();

    boolean hasMaxCn0Dbhz();

    boolean hasPdop();

    boolean hasProvider();

    boolean hasSatelliteCount();

    boolean hasSpeed();

    boolean hasSpeedAccuracy();

    boolean hasUsedInFixCount();

    boolean hasVdop();

    boolean hasVerticalAccuracy();
}
