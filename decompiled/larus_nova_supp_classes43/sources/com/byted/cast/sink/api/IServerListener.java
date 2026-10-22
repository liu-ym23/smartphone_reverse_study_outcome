package com.byted.cast.sink.api;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IServerListener {
    public static final int EXTRA_INVALID_CAST = 100;
    public static final int WHAT_BYTELINK_SINK_ERROR = 1000;
    public static final int WHAT_INVALID_CAST = 1;
    public static final int WHAT_NSD_ERROR = 1001;

    void onCast(int r1, CastInfo r10);

    void onConnect(int r1, ClientInfo r10);

    void onDisconnect(int r1, ClientInfo r10);

    void onError(int r1, int r10, int r11, String r12);

    void onFirstVideoFrame(String r1);

    void onMonitorEvent(String r1, String r10);

    void onRecvMetaData(int r1, ClientInfo r10, String r11);

    void onSinkLatencyStat(int r1, String r10, String r11);

    void onSinkStuckStat(int r1, String r10, String r11);

    void onStart(int r1, ServerInfo r10);

    void onStop(int r1);
}
