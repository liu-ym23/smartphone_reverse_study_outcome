package com.obric.cae.userAware.Garage.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes3.dex */
public interface GarageTelemetryChunkOrBuilder extends MessageOrBuilder {
    int getAccelSampleCount();

    int getChunkCount();

    int getChunkIndex();

    int getCompletedScanMask();

    int getCrc32();

    float getEventConfidence();

    int getEventDirection();

    int getFeatureCount();

    int getGyroSampleCount();

    int getLinaccSampleCount();

    ByteString getPayload();

    int getPressureSampleCount();

    int getQualityFlags();

    int getRecordSize();

    int getRequestedScanMask();

    int getScanId();

    int getScanPurpose();

    int getScanResult();

    float getSceneConfidence();

    boolean getSceneIsUg();

    boolean getSceneValid();

    int getSnapshotId();

    int getTotalSize();

    GarageTelemetryType getType();

    int getVersion();

    long getWindowEndMs();

    long getWindowStartMs();

    boolean hasAccelSampleCount();

    boolean hasChunkCount();

    boolean hasChunkIndex();

    boolean hasCompletedScanMask();

    boolean hasCrc32();

    boolean hasEventConfidence();

    boolean hasEventDirection();

    boolean hasFeatureCount();

    boolean hasGyroSampleCount();

    boolean hasLinaccSampleCount();

    boolean hasPayload();

    boolean hasPressureSampleCount();

    boolean hasQualityFlags();

    boolean hasRecordSize();

    boolean hasRequestedScanMask();

    boolean hasScanId();

    boolean hasScanPurpose();

    boolean hasScanResult();

    boolean hasSceneConfidence();

    boolean hasSceneIsUg();

    boolean hasSceneValid();

    boolean hasSnapshotId();

    boolean hasTotalSize();

    boolean hasType();

    boolean hasVersion();

    boolean hasWindowEndMs();

    boolean hasWindowStartMs();
}
