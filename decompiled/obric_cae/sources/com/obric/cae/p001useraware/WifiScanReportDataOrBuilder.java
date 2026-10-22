package com.obric.cae.p001useraware;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface WifiScanReportDataOrBuilder extends MessageOrBuilder {
    int getAuthType();

    String getBssid();

    ByteString getBssidBytes();

    int getFrequency();

    int getRssi();

    String getSsid();

    ByteString getSsidBytes();

    long getTimestamp();

    boolean hasAuthType();

    boolean hasBssid();

    boolean hasFrequency();

    boolean hasRssi();

    boolean hasSsid();

    boolean hasTimestamp();
}
