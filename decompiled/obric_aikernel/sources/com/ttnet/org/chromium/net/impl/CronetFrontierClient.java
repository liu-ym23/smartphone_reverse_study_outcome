package com.ttnet.org.chromium.net.impl;

import android.text.TextUtils;
import android.util.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
public class CronetFrontierClient {
    private static final int STATE_BUILDING = 1;
    private static final int STATE_CLOSE = 4;
    private static final int STATE_ESTABLISHED = 2;
    private static final int STATE_FAILED = 3;
    private static final int STATE_NONE = 0;
    private static final String TAG = "CronetFrontierClient";
    private int mAppId;
    private String mAppKey;
    private String mAppVersion;
    private IConnectionCallback mCallback;
    private String mDeviceId;
    private String mEnv;
    private int mFpid;
    private long mFrontierClientAdapter;
    private final Object mFrontierClientAdapterLock;
    private Map<String, String> mHeaders;
    private String mHost;
    private TransportMode mMode;
    private String mPath;
    private int mPingInterval;
    private int mPort;
    private boolean mProxy;
    private String mQuery;
    private Map<Integer, TTServiceInfo> mServiceInfoMap;
    private AtomicInteger mState;
    private int mTimeout;
    private List<Integer> mUniqueServiceIdList;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.CronetFrontierClient$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private int appId;
        private String appKey;
        private String appVersion;
        private IConnectionCallback callback;
        private String deviceId;
        private String env;
        private int fpid;
        private Map<String, String> headers;
        private String host;
        private TransportMode mode;
        private String path;
        private int pingInterval;
        private int port;
        private boolean proxy;
        private String query;
        private int timeout;
        private List<Integer> uniqueServiceIdList;

        Builder(int r10, int r11, String r12, int r13, String r14, String r15, String r16) {
            this.mode = TransportMode.UNKNOWN;
            if (r10 <= 0) goto L19;
            if (r11 <= 0) goto L19;
            if (r13 <= 0) goto L19;
            if (TextUtils.isEmpty(r12) == true) goto L17;
            if (TextUtils.isEmpty(r14) == true) goto L17;
            if (TextUtils.isEmpty(r15) == true) goto L17;
            if (TextUtils.isEmpty(r16) == true) goto L17;
            this.appId = r10;
            this.fpid = r11;
            this.port = r13;
            this.host = r12;
            this.appVersion = r14;
            this.deviceId = r15;
            this.appKey = r16;
            return;
        L17:
            throw new IllegalArgumentException("Host, appVersion, appKey and deviceId must not be empty.");
        L19:
            throw new IllegalArgumentException("Appid, fpid and port must be set greater than 0.");
        }

        static /* synthetic */ int access$000(Builder r10) {
            return r10.appId;
        }

        static /* synthetic */ int access$100(Builder r10) {
            return r10.fpid;
        }

        static /* synthetic */ Map access$1000(Builder r10) {
            return r10.headers;
        }

        static /* synthetic */ TransportMode access$1100(Builder r10) {
            return r10.mode;
        }

        static /* synthetic */ IConnectionCallback access$1200(Builder r10) {
            return r10.callback;
        }

        static /* synthetic */ List access$1300(Builder r10) {
            return r10.uniqueServiceIdList;
        }

        static /* synthetic */ String access$1400(Builder r10) {
            return r10.query;
        }

        static /* synthetic */ String access$1500(Builder r10) {
            return r10.path;
        }

        static /* synthetic */ boolean access$1600(Builder r10) {
            return r10.proxy;
        }

        static /* synthetic */ String access$200(Builder r10) {
            return r10.host;
        }

        static /* synthetic */ int access$300(Builder r10) {
            return r10.port;
        }

        static /* synthetic */ String access$400(Builder r10) {
            return r10.appVersion;
        }

        static /* synthetic */ String access$500(Builder r10) {
            return r10.deviceId;
        }

        static /* synthetic */ String access$600(Builder r10) {
            return r10.appKey;
        }

        static /* synthetic */ String access$700(Builder r10) {
            return r10.env;
        }

        static /* synthetic */ int access$800(Builder r10) {
            return r10.pingInterval;
        }

        static /* synthetic */ int access$900(Builder r10) {
            return r10.timeout;
        }

        public static Builder create(int r10, int r11, String r12, int r13, String r14, String r15, String r16) {
            return new Builder(r10, r11, r12, r13, r14, r15, r16);
        }

        public CronetFrontierClient build() {
            return new CronetFrontierClient(this, null);
        }

        public Builder callback(IConnectionCallback r10) {
            this.callback = r10;
            return this;
        }

        public Builder env(String r10) {
            this.env = r10;
            return this;
        }

        public Builder headers(Map<String, String> r10) {
            this.headers = r10;
            return this;
        }

        public Builder path(String r10) {
            this.path = r10;
            return this;
        }

        public Builder pingInterval(int r10) {
            this.pingInterval = r10;
            return this;
        }

        public Builder proxy(boolean r10) {
            this.proxy = r10;
            return this;
        }

        public Builder query(String r10) {
            this.query = r10;
            return this;
        }

        public Builder timeout(int r10) {
            this.timeout = r10;
            return this;
        }

        public Builder transportMode(TransportMode r10) {
            this.mode = r10;
            return this;
        }

        public Builder uniqueServiceIdList(List<Integer> r10) {
            this.uniqueServiceIdList = r10;
            return this;
        }
    }

    public interface IConnectionCallback {
        void onConnectionError(int r10, String r11, String r12);

        void onConnectionStateChanged(int r10, String r11);

        void onTrafficChanged(String r10, long r11, long r12, boolean r13);
    }

    public interface IServiceMessageReceiver {
        void onError(int r10, int r11, String r12);

        void onReceivedAck(int r10, long r11, String r12, Boolean r13);

        void onReceivedMessage(int r10, Map<String, String> r11, byte[] r12);

        void onServiceReady(int r10, String r11);
    }

    interface Natives {
        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void addHeader(long r10, CronetFrontierClient r11, String r12, String r13);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void addServiceId(long r10, CronetFrontierClient r11, int r12);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void configParams(long r10, CronetFrontierClient r11, int r12, int r13, String r14, int r15, String r16, String r17, String r18, String r19, int r110, int r111, int r112, boolean r113, String r114, String r115);

        long createFrontierClientAdapter(CronetFrontierClient r10);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void destroy(long r10, CronetFrontierClient r11);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        boolean isServiceReady(long r10, CronetFrontierClient r11, int r12);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void registerService(long r10, CronetFrontierClient r11, String[] r12, ByteBuffer r13, int r14, int r15, boolean r16);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void reportAppStateChange(long r10, CronetFrontierClient r11, boolean r12);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void sendMessage(long r10, CronetFrontierClient r11, int r12, String[] r13, ByteBuffer r14);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void unregisterService(long r10, CronetFrontierClient r11, int r12);
    }

    public static final enum TransportMode extends Enum<TransportMode> {
        private static final /* synthetic */ TransportMode[] $VALUES = null;
        public static final TransportMode HTTP2 = null;
        public static final TransportMode QUIC = null;
        public static final TransportMode SPDY = null;
        public static final TransportMode TLS = null;
        public static final TransportMode UNKNOWN = null;
        final int mode;

        static {
            TransportMode r10 = new TransportMode("UNKNOWN", 0, -1);
            UNKNOWN = r10;
            TransportMode r11 = new TransportMode("QUIC", 1, 0);
            QUIC = r11;
            TransportMode r12 = new TransportMode("TLS", 2, 1);
            TLS = r12;
            TransportMode r13 = new TransportMode("HTTP2", 3, 2);
            HTTP2 = r13;
            TransportMode r14 = new TransportMode("SPDY", 4, 3);
            SPDY = r14;
            $VALUES = new TransportMode[]{r10, r11, r12, r13, r14};
        }

        private TransportMode(String r10, int r11, int r12) {
            super(r10, r11);
            this.mode = r12;
        }

        public static TransportMode valueOf(String r10) {
            return (TransportMode) Enum.valueOf(TransportMode.class, r10);
        }

        public static TransportMode[] values() {
            return (TransportMode[]) $VALUES.clone();
        }

        public int getValue() {
            return this.mode;
        }
    }

    static {
    }

    private CronetFrontierClient(Builder r10) {
        this.mMode = TransportMode.UNKNOWN;
        this.mServiceInfoMap = new ConcurrentHashMap();
        this.mFrontierClientAdapterLock = new Object();
        this.mState = new AtomicInteger(0);
        this.mAppId = Builder.access$000(r10);
        this.mFpid = Builder.access$100(r10);
        this.mHost = Builder.access$200(r10);
        this.mPort = Builder.access$300(r10);
        this.mAppVersion = Builder.access$400(r10);
        this.mDeviceId = Builder.access$500(r10);
        this.mAppKey = Builder.access$600(r10);
        this.mEnv = Builder.access$700(r10);
        this.mPingInterval = Builder.access$800(r10);
        this.mTimeout = Builder.access$900(r10);
        this.mHeaders = Builder.access$1000(r10);
        this.mMode = Builder.access$1100(r10);
        this.mCallback = Builder.access$1200(r10);
        this.mUniqueServiceIdList = Builder.access$1300(r10);
        this.mQuery = Builder.access$1400(r10);
        this.mPath = Builder.access$1500(r10);
        this.mProxy = Builder.access$1600(r10);
        createNativeFrontierClient();
    }

    /* synthetic */ CronetFrontierClient(Builder r10, AnonymousClass1 r11) {
        this(r10);
    }

    private void createNativeFrontierClient() {
        Object r15 = this.mFrontierClientAdapterLock;
        monitor-enter(r15);
    L32:
        th = th;
    L30:
        monitor-exit(r20);     // Catch: Throwable -> L32
        throw th;
    L28:
        th = th;
        Object r20 = r15;
        goto L30
    L5:
        if (this.mFrontierClientAdapter != 0) goto L7;
        this.mFrontierClientAdapter = CronetFrontierClientJni.get().createFrontierClientAdapter(this);     // Catch: Throwable -> L28
    L7:
        Map<String, String> r10 = this.mHeaders;     // Catch: Throwable -> L28
        if (r10 == null) goto L13;
        Iterator<Map.Entry<String, String>> r11 = r10.entrySet().iterator();     // Catch: Throwable -> L28
    L11:
        if (r11.hasNext() == false) goto L13;
        Map.Entry<String, String> r12 = r11.next();     // Catch: Throwable -> L28
        CronetFrontierClientJni.get().addHeader(this.mFrontierClientAdapter, this, r12.getKey(), r12.getValue());     // Catch: Throwable -> L28
    L13:
        List<Integer> r13 = this.mUniqueServiceIdList;     // Catch: Throwable -> L28
        if (r13 == null) goto L19;
        Iterator<Integer> r14 = r13.iterator();     // Catch: Throwable -> L28
    L17:
        if (r14.hasNext() == false) goto L19;
        Integer r16 = r14.next();     // Catch: Throwable -> L28
        CronetFrontierClientJni.get().addServiceId(this.mFrontierClientAdapter, this, r16.intValue());     // Catch: Throwable -> L28
    L19:
        CronetFrontierClientJni.get().configParams(this.mFrontierClientAdapter, this, this.mAppId, this.mFpid, this.mHost, this.mPort, this.mAppVersion, this.mDeviceId, this.mAppKey, this.mEnv, this.mPingInterval, this.mTimeout, this.mMode.getValue(), this.mProxy, this.mQuery, this.mPath);     // Catch: Throwable -> L32
        monitor-exit(r15);     // Catch: Throwable -> L32
        return;
    L26:
        th = th;
        r20 = r15;
        goto L30
    }

    @CalledByNative
    private void onConnectionError(int r10, String r11, String r12) {
        Log.e(TAG, "onConnectionError: " + r12);
        this.mState.set(r10);
        this.mCallback.onConnectionError(r10, r11, r12);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Exception in callback: ", e);
    }

    @CalledByNative
    private void onConnectionStateChanged(int r10, String r11) {
        Log.v(TAG, "onConnectionStateChanged: state = " + r10 + ", url = " + r11);
        this.mState.set(r10);
        this.mCallback.onConnectionStateChanged(r10, r11);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Exception in callback: ", e);
    }

    @CalledByNative
    private void onError(int r10, int r11, String r12) {
        TTServiceInfo r13 = this.mServiceInfoMap.get(Integer.valueOf(r10));
        if (r13 != null) goto L5;
        return;
    L5:
        r13.connected = false;
        r13.listener.onError(r10, r11, r12);
    }

    @CalledByNative
    private void onReceivedAck(int r10, long r11, String r12, boolean r13) {
        if (r13 == false) goto L4;
        return;
    L4:
        TTServiceInfo r14 = this.mServiceInfoMap.get(Integer.valueOf(r10));
        if (r14 != null) goto L7;
        return;
    L7:
        r14.listener.onReceivedAck(r10, r11, r12, Boolean.valueOf(r13));
    }

    @CalledByNative
    private void onReceivedMessage(int r10, String[] r11, ByteBuffer r12, boolean r13, int r14) {
        if (r13 == false) goto L4;
        return;
    L4:
        TTServiceInfo r15 = this.mServiceInfoMap.get(Integer.valueOf(r10));
        if (r15 != null) goto L7;
        return;
    L7:
        int r16 = r11.length;
        if ((r16 % 2) == 0) goto L11;
        Log.e(TAG, "length is not even number:" + r16);
        return;
    L11:
        HashMap r17 = new HashMap();
        int r18 = 0;
    L12:
        if (r18 >= r16) goto L19;
        if (TextUtils.isEmpty(r11[r18]) == true) goto L18;
        int r19 = r18 + 1;
        if (TextUtils.isEmpty(r11[r19]) == true) goto L18;
        r17.put(r11[r18], r11[r19]);
    L18:
        r18 = r18 + 2;
        goto L12
    L19:
        byte[] r20 = new byte[r12.capacity()];
        r12.get(r20);
        if (r14 < 0) goto L22;
        r10 = r14;
    L22:
        r15.listener.onReceivedMessage(r10, r17, r20);
    }

    @CalledByNative
    private void onServiceReady(int r10, String r11) {
        TTServiceInfo r12 = this.mServiceInfoMap.get(Integer.valueOf(r10));
        if (r12 != null) goto L5;
        return;
    L5:
        r12.connected = true;
        r12.listener.onServiceReady(r10, r11);
    }

    @CalledByNative
    private void onTrafficChanged(String r10, long r11, long r13, boolean r15) {
        Log.v(TAG, "OnTrafficChanged");
        this.mCallback.onTrafficChanged(r10, r11, r13, r15);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Exception in callback: ", e);
    }

    public void destroy() {
        Object r10 = this.mFrontierClientAdapterLock;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L8:
        CronetFrontierClientJni.get().destroy(this.mFrontierClientAdapter, this);     // Catch: Throwable -> L11
        this.mFrontierClientAdapter = 0;     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
    }

    public TTServiceInfo getServiceInfoById(int r10) {
        return this.mServiceInfoMap.get(Integer.valueOf(r10));
    }

    public boolean isConnected() {
        if (this.mState.get() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isServiceExisted(int r10) {
        return this.mServiceInfoMap.containsKey(Integer.valueOf(r10));
    }

    public boolean isServiceReady(int r10) {
        Object r11 = this.mFrontierClientAdapterLock;
        monitor-enter(r11);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L15
        return false;
    L8:
        TTServiceInfo r12 = this.mServiceInfoMap.get(Integer.valueOf(r10));     // Catch: Throwable -> L15
        if (r12 != null) goto L12;
        monitor-exit(r11);     // Catch: Throwable -> L15
        return false;
    L12:
        boolean r13 = r12.connected;     // Catch: Throwable -> L15
        monitor-exit(r11);     // Catch: Throwable -> L15
        return r13;
    }

    public void registerService(TTServiceInfo r13, ByteBuffer r14, String[] r15) {
        Object r10 = this.mFrontierClientAdapterLock;
        monitor-enter(r10);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L11
        return;
    L8:
        this.mServiceInfoMap.put(Integer.valueOf(r13.identity), r13);     // Catch: Throwable -> L11
        CronetFrontierClientJni.get().registerService(this.mFrontierClientAdapter, this, r15, r14, r13.identity, r13.priority.getValue(), r13.sequence);     // Catch: Throwable -> L11
        monitor-exit(r10);     // Catch: Throwable -> L11
    }

    public void reportAppStateChange(boolean r10) {
        Object r11 = this.mFrontierClientAdapterLock;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L8:
        CronetFrontierClientJni.get().reportAppStateChange(this.mFrontierClientAdapter, this, r10);     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
    }

    public void sendMessage(int r10, String[] r11, ByteBuffer r12) {
        Object r13 = this.mFrontierClientAdapterLock;
        monitor-enter(r13);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r13);     // Catch: Throwable -> L11
        return;
    L8:
        CronetFrontierClientJni.get().sendMessage(this.mFrontierClientAdapter, this, r10, r11, r12);     // Catch: Throwable -> L11
        monitor-exit(r13);     // Catch: Throwable -> L11
    }

    public void setMaxPacketSize(int r10, int r11) {
    }

    public void setMsgCursor(int r10, int r11) {
    }

    public void unregisterService(int r10) {
        Object r11 = this.mFrontierClientAdapterLock;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r11);     // Catch: Throwable -> L11
        return;
    L8:
        this.mServiceInfoMap.remove(Integer.valueOf(r10));     // Catch: Throwable -> L11
        CronetFrontierClientJni.get().unregisterService(this.mFrontierClientAdapter, this, r10);     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
    }
}
