package com.obric.cae.smartNetwork.netAccel;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface AutoDualWlanCapabilityOrBuilder extends MessageOrBuilder {
    AutoDualWlanCapability.AppInfo getAppInfo(int r8);

    int getAppInfoCount();

    List<AutoDualWlanCapability.AppInfo> getAppInfoList();

    AutoDualWlanCapability.AppInfoOrBuilder getAppInfoOrBuilder(int r8);

    List<? extends AutoDualWlanCapability.AppInfoOrBuilder> getAppInfoOrBuilderList();

    int getState();

    long getTimestamp();

    boolean hasState();

    boolean hasTimestamp();
}
