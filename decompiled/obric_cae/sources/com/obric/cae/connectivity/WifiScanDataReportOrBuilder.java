package com.obric.cae.connectivity;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface WifiScanDataReportOrBuilder extends MessageOrBuilder {
    String getBssid();

    ByteString getBssidBytes();

    String getCapabilities();

    ByteString getCapabilitiesBytes();

    int getChannelWidth();

    int getFrequency();

    boolean getIsPasspointNetwork();

    boolean getIsSupport80211Mc();

    int getLevel();

    long getScanTimestampMs();

    String getSsid();

    ByteString getSsidBytes();

    int getWifiStandard();

    boolean hasBssid();

    boolean hasCapabilities();

    boolean hasChannelWidth();

    boolean hasFrequency();

    boolean hasIsPasspointNetwork();

    boolean hasIsSupport80211Mc();

    boolean hasLevel();

    boolean hasScanTimestampMs();

    boolean hasSsid();

    boolean hasWifiStandard();
}
