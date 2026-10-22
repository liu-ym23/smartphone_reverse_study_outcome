package com.obric.cae.userAware.Garage.proto;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes3.dex */
public interface GarageDetectEventOrBuilder extends MessageOrBuilder {
    int getCompletedScanMask();

    GarageReportReason getReason();

    int getRequestedScanMask();

    boolean getRuntimeEnabled();

    int getRuntimeRequestId();

    int getScanId();

    boolean hasCompletedScanMask();

    boolean hasReason();

    boolean hasRequestedScanMask();

    boolean hasRuntimeEnabled();

    boolean hasRuntimeRequestId();

    boolean hasScanId();
}
