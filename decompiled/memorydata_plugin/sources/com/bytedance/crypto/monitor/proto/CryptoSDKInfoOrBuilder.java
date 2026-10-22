package com.bytedance.crypto.monitor.proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface CryptoSDKInfoOrBuilder extends MessageOrBuilder {
    ErrorTrace getErrorTrace(int r1);

    int getErrorTraceCount();

    List<ErrorTrace> getErrorTraceList();

    ErrorTraceOrBuilder getErrorTraceOrBuilder(int r1);

    List<? extends ErrorTraceOrBuilder> getErrorTraceOrBuilderList();

    NormalTrace getNormalTrace(int r1);

    int getNormalTraceCount();

    List<NormalTrace> getNormalTraceList();

    NormalTraceOrBuilder getNormalTraceOrBuilder(int r1);

    List<? extends NormalTraceOrBuilder> getNormalTraceOrBuilderList();

    long getTimestamp();

    int getTrainNum();

    int getVersion();

    boolean hasTimestamp();

    boolean hasTrainNum();

    boolean hasVersion();
}
