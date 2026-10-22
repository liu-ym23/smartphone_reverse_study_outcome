package com.obric.cae.location.zpp;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface StarZppDataOrBuilder extends MessageOrBuilder {
    float getConfidence(int r8);

    int getConfidenceCount();

    List<Float> getConfidenceList();

    float getEval(int r8);

    int getEvalCount();

    List<Float> getEvalList();

    float getFeatureArray(int r8);

    int getFeatureArrayCount();

    List<Float> getFeatureArrayList();

    String getModelVersion();

    ByteString getModelVersionBytes();

    long getTimestamp(int r8);

    int getTimestampCount();

    List<Long> getTimestampList();

    int getZppStrategy();

    boolean hasModelVersion();

    boolean hasZppStrategy();
}
