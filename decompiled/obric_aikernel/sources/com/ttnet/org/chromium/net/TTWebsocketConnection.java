package com.ttnet.org.chromium.net;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TTWebsocketConnection {

    public static abstract class Builder {
        public Builder() {
        }

        public abstract TTWebsocketConnection build();

        public abstract Builder setAppId(int r10);

        public abstract Builder setAppKey(String r10);

        public abstract Builder setAppToken(String r10);

        public abstract Builder setAppVersion(int r10);

        public abstract Builder setCustomizedHeaders(Map<String, String> r10);

        public abstract Builder setCustomizedParams(Map<String, String> r10);

        public abstract Builder setDeviceId(long r10);

        public abstract Builder setFpid(int r10);

        public abstract Builder setInstallId(long r10);

        public abstract Builder setSessionId(String r10);

        public abstract Builder setSharedConnection(boolean r10);

        public abstract Builder setUrlList(List<String> r10);

        public abstract Builder useFrontierProtocol(boolean r10);
    }

    public static abstract class Callback {
        public Callback() {
        }

        public abstract void onConnectionError(TTWebsocketConnection r10, int r11, String r12, String r13);

        public abstract void onConnectionStateChanged(TTWebsocketConnection r10, int r11, String r12);

        public void onFeedbackLog(TTWebsocketConnection r10, String r11) {
        }

        public abstract void onMessageReceived(TTWebsocketConnection r10, ByteBuffer r11, int r12);

        public void onTrafficChanged(TTWebsocketConnection r10, String r11, long r12, long r13, boolean r14) {
        }
    }

    public static class Status {
        public static final int ConnectClosed = 3;
        public static final int ConnectFailed = 2;
        public static final int ConnectUnknown = -1;
        public static final int Connected = 4;
        public static final int Connecting = 0;
        public static final int Disconnecting = 1;

        private Status() {
        }
    }

    public TTWebsocketConnection() {
    }

    public abstract void asyncSendBinary(ByteBuffer r10);

    public abstract void asyncSendText(String r10);

    public abstract void destroyConnection();

    public abstract boolean isConnected();

    public abstract void startConnection();

    public abstract void stopConnection();
}
