package com.byted.cast.sink.api;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class ClientInfo {
    public static final int TYPE_SINK = 102;
    public static final int TYPE_SOURCE = 101;
    public String clientID;
    public String icon;
    public String ip;
    public int mirrorSourceType;
    public String name;
    public int sourceType;

    public ClientInfo() {
        this.mirrorSourceType = 101;
    }

    public String toString() {
        return "ClientInfo{clientID='" + this.clientID + "', name='" + this.name + "', ip=" + this.ip + "', icon='" + this.icon + "', sourceType=" + this.sourceType + ", mirrorSourceType=" + this.mirrorSourceType + '}';
    }
}
