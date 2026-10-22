package com.obric.cae.network;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface SwitchTrafficDataOrBuilder extends MessageOrBuilder {
    SwitchTrafficData.AppDataUsageData getAppDataUsage(int r8);

    int getAppDataUsageCount();

    List<SwitchTrafficData.AppDataUsageData> getAppDataUsageList();

    SwitchTrafficData.AppDataUsageDataOrBuilder getAppDataUsageOrBuilder(int r8);

    List<? extends SwitchTrafficData.AppDataUsageDataOrBuilder> getAppDataUsageOrBuilderList();

    long getDataUsage();

    long getDwellTime();

    int getSolutionType();

    long getTimestamp();

    boolean hasDataUsage();

    boolean hasDwellTime();

    boolean hasSolutionType();

    boolean hasTimestamp();
}
