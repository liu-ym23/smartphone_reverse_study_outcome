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

        public abstract Builder setAppId(int r8);

        public abstract Builder setAppKey(String r8);

        public abstract Builder setAppToken(String r8);

        public abstract Builder setAppVersion(int r8);

        public abstract Builder setCustomizedHeaders(Map<String, String> r8);

        public abstract Builder setCustomizedParams(Map<String, String> r8);

        public abstract Builder setDeviceId(long r8);

        public abstract Builder setFpid(int r8);

        public abstract Builder setInstallId(long r8);

        public abstract Builder setSessionId(String r8);

        public abstract Builder setSharedConnection(boolean r8);

        public abstract Builder setUrlList(List<String> r8);

        public abstract Builder useFrontierProtocol(boolean r8);
    }

    public static abstract class Callback {
        public Callback() {
        }

        public abstract void onConnectionError(TTWebsocketConnection r8, int r10, String r11, String r12);

        public abstract void onConnectionStateChanged(TTWebsocketConnection r8, int r10, String r11);

        public void onFeedbackLog(TTWebsocketConnection r8, String r10) {
        }

        public abstract void onMessageReceived(TTWebsocketConnection r8, ByteBuffer r10, int r11);

        public void onTrafficChanged(TTWebsocketConnection r8, String r10, long r11, long r12, boolean r13) {
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

    public abstract void asyncSendBinary(ByteBuffer r8);

    public abstract void asyncSendText(String r8);

    public abstract void destroyConnection();

    public abstract boolean isConnected();

    public abstract void startConnection();

    public abstract void stopConnection();
}
