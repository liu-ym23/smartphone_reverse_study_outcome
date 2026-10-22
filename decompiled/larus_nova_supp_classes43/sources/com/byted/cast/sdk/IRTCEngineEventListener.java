package com.byted.cast.sdk;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IRTCEngineEventListener {

    /* JADX INFO: renamed from: com.byted.cast.sdk.IRTCEngineEventListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onCastPortSet(IRTCEngineEventListener r0, int r1, int r10, int r11, int r12) {
        }

        public static void $default$onCastPortUnSet(IRTCEngineEventListener r0, int r1, int r10, int r11, int r12) {
        }

        public static void $default$onFirstVideoFrame(IRTCEngineEventListener r0, String r1) {
        }

        public static void $default$onInfo(IRTCEngineEventListener r0, int r1, int r10, String r11) {
        }

        public static void $default$onIntoBackground(IRTCEngineEventListener r0, String r1) {
        }

        public static void $default$onIntoForeground(IRTCEngineEventListener r0, String r1) {
        }

        public static void $default$onServerStart(IRTCEngineEventListener r0, int r1) {
        }

        public static void $default$onServerStop(IRTCEngineEventListener r0, int r1) {
        }

        public static void $default$onSinkLatencyStat(IRTCEngineEventListener r0, String r1, String r10) {
        }

        public static void $default$onSinkStuckStat(IRTCEngineEventListener r0, String r1, String r10) {
        }
    }

    void OnVideoSizeChanged(String r1, int r10, int r11, int r12);

    void onAudioSetVolume(String r1, float r10, float r11);

    void onCancelRequest(String r1);

    void onCancelSuccess();

    void onCastControl(int r1, int r10);

    void onCastPortSet(int r1, int r10, int r11, int r12);

    void onCastPortUnSet(int r1, int r10, int r11, int r12);

    boolean onCastRequest(String r1, String r10);

    void onCastSuccess();

    void onConnect(String r1, String r10);

    void onConnectStateChanged(RTCEngine.ConnectState r1);

    void onConnectSuccess(int r1, int r10, int r11);

    void onDisconnect(RTCEngine.ExitReason r1, String r10);

    void onDisconnect(String r1, RTCEngine.ExitReason r10, String r11);

    void onError(int r1, String r10);

    void onFirstVideoFrame(String r1);

    void onInfo(int r1, int r10, String r11);

    void onIntoBackground(String r1);

    void onIntoForeground(String r1);

    void onKilled();

    void onLogMonitor(String r1, String[][] r10);

    void onMonitorEvent(String r1, String r10);

    void onPaused();

    void onRecvMetaData(String r1);

    void onRecvMetaData(String r1, String r10);

    void onResumed();

    void onServerStart(int r1);

    void onServerStop(int r1);

    void onSinkLatencyStat(String r1, String r10);

    void onSinkStuckStat(String r1, String r10);

    void onStat(String r1);

    void onStopped();

    void onStuckStat(String r1);

    void onVideoEncoder(String r1, int r10, int r11, int r12, int r13, boolean r14, int r15);
}
