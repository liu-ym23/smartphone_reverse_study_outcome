package com.obric.cae.connectivity;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface BleScanResultDataReportOrBuilder extends MessageOrBuilder {
    String getAddress();

    ByteString getAddressBytes();

    int getAddressType();

    int getAdvertiseFlags();

    int getAdvertisingSid();

    String getDeviceName();

    ByteString getDeviceNameBytes();

    int getEventType();

    String getManufacturerSpecificData();

    ByteString getManufacturerSpecificDataBytes();

    String getOriginalAddress();

    ByteString getOriginalAddressBytes();

    String getPackageName();

    ByteString getPackageNameBytes();

    int getPeriodicAdvInt();

    int getPrimaryPhy();

    int getRssi();

    int getSecondaryPhy();

    String getServiceData();

    ByteString getServiceDataBytes();

    String getServiceSolicitationUuids();

    ByteString getServiceSolicitationUuidsBytes();

    String getServiceUuids();

    ByteString getServiceUuidsBytes();

    long getTimestamp();

    String getTransportDiscoveryData();

    ByteString getTransportDiscoveryDataBytes();

    int getTxPower();

    boolean hasAddress();

    boolean hasAddressType();

    boolean hasAdvertiseFlags();

    boolean hasAdvertisingSid();

    boolean hasDeviceName();

    boolean hasEventType();

    boolean hasManufacturerSpecificData();

    boolean hasOriginalAddress();

    boolean hasPackageName();

    boolean hasPeriodicAdvInt();

    boolean hasPrimaryPhy();

    boolean hasRssi();

    boolean hasSecondaryPhy();

    boolean hasServiceData();

    boolean hasServiceSolicitationUuids();

    boolean hasServiceUuids();

    boolean hasTimestamp();

    boolean hasTransportDiscoveryData();

    boolean hasTxPower();
}
