package com.bytedance.crypto.monitor.proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface CryptoSDKInfoOrBuilder extends MessageOrBuilder {
    ErrorTrace getErrorTrace(int r10);

    int getErrorTraceCount();

    List<ErrorTrace> getErrorTraceList();

    ErrorTraceOrBuilder getErrorTraceOrBuilder(int r10);

    List<? extends ErrorTraceOrBuilder> getErrorTraceOrBuilderList();

    NormalTrace getNormalTrace(int r10);

    int getNormalTraceCount();

    List<NormalTrace> getNormalTraceList();

    NormalTraceOrBuilder getNormalTraceOrBuilder(int r10);

    List<? extends NormalTraceOrBuilder> getNormalTraceOrBuilderList();

    long getTimestamp();

    int getTrainNum();

    int getVersion();

    boolean hasTimestamp();

    boolean hasTrainNum();

    boolean hasVersion();
}
