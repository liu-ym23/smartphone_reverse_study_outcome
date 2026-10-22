package com.byted.cast.sink.api;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class ServerInfo {
    public static final int DEFAULT_SERVICE_ID = 0;
    public static final int ERROR_BIND_SERVICE = 10000;
    public static final int ERROR_INVALID_MAC = 20000;
    public static final int ERROR_PERMISSION_REQUEST_FAILED = -2002;
    public static final int ERROR_PORT_FAILED = 30000;
    public static final int EXTRA_PORT_BYTE_LINK_AUDIO = 800;
    public static final int EXTRA_PORT_BYTE_LINK_FP_AUDIO = 200;
    public static final int EXTRA_PORT_BYTE_LINK_FP_MIRROR = 100;
    public static final int EXTRA_PORT_BYTE_LINK_MIRROR = 400;
    public static final int SERVER_IDLE = 0;
    public static final int SERVER_STARTED = 2;
    public static final int SERVER_STARTING = 1;
    public static final int SERVER_STOPPING = 3;
    public String aliasName;
    public int cloudPreemptModel;
    public String deviceID;
    public String deviceName;
    public int displayMode;
    public int features;
    public int forceResetMirrorPlayer;
    public int fps;
    public int height;
    public int language;
    public int localPreemptModel;
    public int maxFps;
    public long netDelay;
    public String networkName;
    public int playerType;
    public int remotePort;
    public String resolution;
    public int serverPort;
    public int serviceStatus;
    public boolean showFps;
    public int surfaceType;
    public int width;

    public ServerInfo() {
        this.forceResetMirrorPlayer = 0;
        this.netDelay = -1;
    }
}
