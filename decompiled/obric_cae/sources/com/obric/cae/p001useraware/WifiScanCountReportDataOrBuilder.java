package com.obric.cae.p001useraware;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes2.dex */
public interface WifiScanCountReportDataOrBuilder extends MessageOrBuilder {
    int getDateScanCount();

    int getDateScanDropCount();

    int getScanType();

    int getSceneType();

    long getTimeStamp();

    boolean hasDateScanCount();

    boolean hasDateScanDropCount();

    boolean hasScanType();

    boolean hasSceneType();

    boolean hasTimeStamp();
}
