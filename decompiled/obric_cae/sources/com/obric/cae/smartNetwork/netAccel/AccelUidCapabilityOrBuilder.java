package com.obric.cae.smartNetwork.netAccel;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface AccelUidCapabilityOrBuilder extends MessageOrBuilder {
    AccelUidCapability.AppInfo getAppInfo(int r8);

    int getAppInfoCount();

    List<AccelUidCapability.AppInfo> getAppInfoList();

    AccelUidCapability.AppInfoOrBuilder getAppInfoOrBuilder(int r8);

    List<? extends AccelUidCapability.AppInfoOrBuilder> getAppInfoOrBuilderList();

    long getTimestamp();

    boolean hasTimestamp();
}
