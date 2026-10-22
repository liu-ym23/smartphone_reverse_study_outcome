package com.obric.cae.userAware.Garage.proto;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes3.dex */
public interface GarageApScanResultRequestOrBuilder extends MessageOrBuilder {
    GarageApScanStatus getBleStatus();

    int getBleValidUniqueCount();

    float getBtDensityBucket();

    float getBtDevclassMajor0Fraction();

    float getBtDevclassMajor5Fraction();

    float getBtDevicetype2Fraction();

    float getBtDevicetype3Fraction();

    float getBtHasUuidFraction();

    float getBtRssiMean();

    float getBtRssiStd();

    float getBtStrongM80Fraction();

    float getGnssMeanCn0();

    GarageApScanStatus getGnssStatus();

    float getGnssSvCount();

    float getGnssTop4Cn0();

    float getGnssUsedFraction();

    float getGnssUsedSvCount();

    int getScanId();

    boolean hasBleStatus();

    boolean hasBleValidUniqueCount();

    boolean hasBtDensityBucket();

    boolean hasBtDevclassMajor0Fraction();

    boolean hasBtDevclassMajor5Fraction();

    boolean hasBtDevicetype2Fraction();

    boolean hasBtDevicetype3Fraction();

    boolean hasBtHasUuidFraction();

    boolean hasBtRssiMean();

    boolean hasBtRssiStd();

    boolean hasBtStrongM80Fraction();

    boolean hasGnssMeanCn0();

    boolean hasGnssStatus();

    boolean hasGnssSvCount();

    boolean hasGnssTop4Cn0();

    boolean hasGnssUsedFraction();

    boolean hasGnssUsedSvCount();

    boolean hasScanId();
}
