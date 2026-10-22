package com.obric.cae.smartNetwork.netAccel;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface AppSocketStatsOrBuilder extends MessageOrBuilder {
    AppSocketStats.AppInfo getAppInfo();

    AppSocketStats.AppInfoOrBuilder getAppInfoOrBuilder();

    long getEndTimestamp();

    AppSocketStats.SocketStats getSocketStats(int r8);

    int getSocketStatsCount();

    List<AppSocketStats.SocketStats> getSocketStatsList();

    AppSocketStats.SocketStatsOrBuilder getSocketStatsOrBuilder(int r8);

    List<? extends AppSocketStats.SocketStatsOrBuilder> getSocketStatsOrBuilderList();

    long getStartTimestamp();

    int getState();

    AppSocketStats.WifiStats getWifiStats(int r8);

    int getWifiStatsCount();

    List<AppSocketStats.WifiStats> getWifiStatsList();

    AppSocketStats.WifiStatsOrBuilder getWifiStatsOrBuilder(int r8);

    List<? extends AppSocketStats.WifiStatsOrBuilder> getWifiStatsOrBuilderList();

    boolean hasAppInfo();

    boolean hasEndTimestamp();

    boolean hasStartTimestamp();

    boolean hasState();
}
