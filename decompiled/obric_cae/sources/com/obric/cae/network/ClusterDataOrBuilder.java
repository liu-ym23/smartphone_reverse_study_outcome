package com.obric.cae.network;

import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes.dex */
public interface ClusterDataOrBuilder extends MessageOrBuilder {
    int getClusterId();

    long getDay7CellDataUsed();

    long getDay7GameCellDataUsed();

    long getDay7GameWifiDataUsed();

    long getDay7NewsCellDataUsed();

    long getDay7NewsWifiDataUsed();

    long getDay7SocialCellDataUsed();

    long getDay7SocialWifiDataUsed();

    long getDay7VideoCellDataUsed();

    long getDay7VideoWifiDataUsed();

    long getDay7WifiDataUsed();

    long getTimestamp();

    boolean hasClusterId();

    boolean hasDay7CellDataUsed();

    boolean hasDay7GameCellDataUsed();

    boolean hasDay7GameWifiDataUsed();

    boolean hasDay7NewsCellDataUsed();

    boolean hasDay7NewsWifiDataUsed();

    boolean hasDay7SocialCellDataUsed();

    boolean hasDay7SocialWifiDataUsed();

    boolean hasDay7VideoCellDataUsed();

    boolean hasDay7VideoWifiDataUsed();

    boolean hasDay7WifiDataUsed();

    boolean hasTimestamp();
}
