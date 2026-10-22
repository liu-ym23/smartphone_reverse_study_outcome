package com.ttnet.org.chromium.net;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.BuildConfig;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.StrictModeContext;
import com.ttnet.org.chromium.base.VisibleForTesting;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver {
    private static final String TAG = "NetworkChangeNotifierAutoDetect";
    private static final int UNKNOWN_LINK_SPEED = -1;
    private ConnectivityManagerDelegate mConnectivityManagerDelegate;
    private DefaultNetworkCallback mDefaultNetworkCallback;
    private final Handler mHandler;
    private boolean mIgnoreNextBroadcast;
    private final NetworkConnectivityIntentFilter mIntentFilter;
    private final Looper mLooper;
    private MyNetworkCallback mNetworkCallback;
    private NetworkRequest mNetworkRequest;
    private NetworkState mNetworkState;
    private final Observer mObserver;
    private boolean mRegisterNetworkCallbackFailed;
    private boolean mRegistered;
    private final RegistrationPolicy mRegistrationPolicy;
    private boolean mShouldSignalObserver;
    private WifiManagerDelegate mWifiManagerDelegate;

    public static class ConnectivityManagerDelegate {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final ConnectivityManager mConnectivityManager;

        public ConnectivityManagerDelegate() {
            this.mConnectivityManager = null;
        }

        private NetworkInfo getNetworkInfo(Network r8) {
            return this.mConnectivityManager.getNetworkInfo(r8);
        L4:
            return this.mConnectivityManager.getNetworkInfo(r8);
        L6:
            return null;
        }

        @TargetApi(21)
        private NetworkInfo processActiveNetworkInfo(NetworkInfo r8) {
            if (r8 != null) goto L6;
            return null;
        L6:
            if (r8.isConnected() == false) goto L9;
            return r8;
        L9:
            if (r8.getDetailedState() == NetworkInfo.DetailedState.BLOCKED) goto L12;
            return null;
        L12:
            if (ApplicationStatus.getStateForApplication() == 1) goto L14;
            return null;
        L14:
            return r8;
        }

        @VisibleForTesting
        @TargetApi(21)
        public Network[] getAllNetworksUnfiltered() {
            Network[] r8 = this.mConnectivityManager.getAllNetworks();     // Catch: Throwable -> L4
        L5:
            if (r8 == null) goto L7;
            return r8;
        L7:
            return new Network[0];
        L4:
            r8 = null;
            goto L5
        }

        @TargetApi(21)
        public int getConnectionType(Network r8) {
            NetworkInfo r10 = getNetworkInfo(r8);
            if (r10 != null) goto L5;
        L9:
            if (r10 != null) goto L11;
            return 6;
        L11:
            if (r10.isConnected() == true) goto L13;
            return 6;
        L13:
            return NetworkChangeNotifierAutoDetect.access$000(r10.getType(), r10.getSubtype());
        L5:
            if (r10.getType() != 17) goto L9;
            r10 = this.mConnectivityManager.getActiveNetworkInfo();     // Catch: Throwable -> L8
        L8:
            r10 = null;
            goto L9
        }

        @TargetApi(21)
        public Network getDefaultNetwork() {
            Network r8 = ApiHelperForM.getActiveNetwork(this.mConnectivityManager);     // Catch: Throwable -> L5
        L6:
            if (r8 == null) goto L25;
            return r8;
        L25:
            NetworkInfo r10 = this.mConnectivityManager.getActiveNetworkInfo();     // Catch: Throwable -> L22
            if (r10 != null) goto L11;
            return null;
        L11:
            Network[] r11 = NetworkChangeNotifierAutoDetect.access$100(this, null);
            int r12 = r11.length;
            int r13 = 0;
        L12:
            if (r13 >= r12) goto L21;
            Network r14 = r11[r13];
            NetworkInfo r15 = getNetworkInfo(r14);
            if (r15 == null) goto L20;
            if (r15.getType() != r10.getType()) goto L18;
        L19:
            r8 = r14;
            goto L20
        L18:
            if (r15.getType() == 17) goto L19;
        L20:
            r13 = r13 + 1;
            goto L12
        L21:
            return r8;
        L22:
            return null;
        L5:
            r8 = null;
            goto L6
        }

        @VisibleForTesting
        @TargetApi(21)
        public NetworkCapabilities getNetworkCapabilities(Network r8) {
            return this.mConnectivityManager.getNetworkCapabilities(r8);
        L4:
            return null;
        }

        public NetworkState getNetworkState(WifiManagerDelegate r18) {
            NetworkInfo r8 = null;
            Network r10 = getDefaultNetwork();     // Catch: Throwable -> L11
            NetworkInfo r11 = ApiHelperForM.getNetworkInfo(this.mConnectivityManager, r10);     // Catch: Throwable -> L38
            if (r11 != null) goto L7;
        L10:
            r8 = r11;
            goto L12
        L7:
            if (r11.getType() != 17) goto L10;
            r8 = this.mConnectivityManager.getActiveNetworkInfo();     // Catch: Throwable -> L38
        L12:
            NetworkInfo r12 = processActiveNetworkInfo(r8);
            if (r12 == null) goto L15;
            boolean r13 = true;
            if (r10 == null) goto L27;
            int r14 = r12.getType();     // Catch: Throwable -> L24
            int r15 = r12.getSubtype();     // Catch: Throwable -> L24
            String r16 = String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(r10));     // Catch: Throwable -> L24
            if (AndroidNetworkLibrary.isPrivateDnsActive(this.mConnectivityManager.getLinkProperties(r10)) == true) goto L22;
            r13 = false;
        L22:
            return new NetworkState(true, r14, r15, r16, r13);
        L25:
            return new NetworkState(false, -1, -1, null, false);
        L27:
            if (r12.getType() != 1) goto L37;
            if (r12.getExtraInfo() == null) goto L35;
            if ("".equals(r12.getExtraInfo()) == true) goto L35;
            return new NetworkState(true, r12.getType(), r12.getSubtype(), r12.getExtraInfo(), false);
        L35:
            return new NetworkState(true, r12.getType(), r12.getSubtype(), r18.getWifiSsid(), false);
        L37:
            return new NetworkState(true, r12.getType(), r12.getSubtype(), null, false);
        L15:
            return new NetworkState(false, -1, -1, null, false);
        L11:
            r10 = null;
            goto L12
        }

        @TargetApi(28)
        public void registerDefaultNetworkCallback(ConnectivityManager.NetworkCallback r8, Handler r10) {
            this.mConnectivityManager.registerDefaultNetworkCallback(r8, r10);     // Catch: Throwable -> L4
            return;
        }

        @TargetApi(21)
        public void registerNetworkCallback(NetworkRequest r8, ConnectivityManager.NetworkCallback r10, Handler r11) {
            this.mConnectivityManager.registerNetworkCallback(r8, r10, r11);     // Catch: Throwable -> L4
            return;
        }

        @TargetApi(21)
        public void unregisterNetworkCallback(ConnectivityManager.NetworkCallback r8) {
            this.mConnectivityManager.unregisterNetworkCallback(r8);     // Catch: Throwable -> L4
            return;
        }

        @VisibleForTesting
        @TargetApi(21)
        public boolean vpnAccessible(Network r8) {
            Socket r10 = new Socket();
            StrictModeContext r11 = StrictModeContext.allowAllVmPolicies();     // Catch: Throwable -> L19 IOException -> L22
            r8.bindSocket(r10);     // Catch: Throwable -> L10
            if (r11 == null) goto L32;
            r11.close();     // Catch: Throwable -> L19 IOException -> L22
        L32:
            r10.close();     // Catch: IOException -> L25
            return true;
        L40:
            return true;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            if (r11 != null) goto L36;
        L18:
            throw th;     // Catch: Throwable -> L19 IOException -> L22
        L36:
            r11.close();     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L19 IOException -> L22
        L22:
            r10.close();     // Catch: IOException -> L27
            return false;
        L19:
            th = move-exception;
            r10.close();     // Catch: IOException -> L26
        L21:
            throw th;
        L41:
            return false;
        }

        public ConnectivityManagerDelegate(Context r8) {
            this.mConnectivityManager = (ConnectivityManager) r8.getSystemService("connectivity");
        }
    }

    @TargetApi(21)
    public class DefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

        private DefaultNetworkCallback(NetworkChangeNotifierAutoDetect r8) {
            this.this$0 = r8;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r8) {
            if (NetworkChangeNotifierAutoDetect.access$200(this.this$0) == false) goto L6;
            NetworkChangeNotifierAutoDetect.access$300(this.this$0);
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network r8, LinkProperties r10) {
            onAvailable(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r8) {
            onAvailable(null);
        }

        public /* synthetic */ DefaultNetworkCallback(NetworkChangeNotifierAutoDetect r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    @TargetApi(21)
    public class MyNetworkCallback extends ConnectivityManager.NetworkCallback {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Network mVpnInPlace;
        final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

        private MyNetworkCallback(NetworkChangeNotifierAutoDetect r8) {
            this.this$0 = r8;
        }

        private boolean ignoreConnectedInaccessibleVpn(Network r8, NetworkCapabilities r10) {
            if (r10 != null) goto L4;
            r10 = NetworkChangeNotifierAutoDetect.access$400(this.this$0).getNetworkCapabilities(r8);
        L4:
            if (r10 != null) goto L6;
        L11:
            return true;
        L6:
            if (r10.hasTransport(4) == true) goto L8;
        L10:
            return false;
        L8:
            if (NetworkChangeNotifierAutoDetect.access$400(this.this$0).vpnAccessible(r8) == true) goto L10;
            goto L10
        }

        private boolean ignoreConnectedNetwork(Network r8, NetworkCapabilities r10) {
            if (ignoreNetworkDueToVpn(r8) == false) goto L5;
        L8:
            return true;
        L5:
            if (ignoreConnectedInaccessibleVpn(r8, r10) == true) goto L8;
            return false;
        }

        private boolean ignoreNetworkDueToVpn(Network r8) {
            Network r10 = this.mVpnInPlace;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.equals(r8) == true) goto L7;
            return true;
        }

        public void initializeVpnInPlace() {
            Network[] r8 = NetworkChangeNotifierAutoDetect.access$100(NetworkChangeNotifierAutoDetect.access$400(this.this$0), null);
            this.mVpnInPlace = null;
            if (r8.length != 1) goto L10;
            NetworkCapabilities r10 = NetworkChangeNotifierAutoDetect.access$400(this.this$0).getNetworkCapabilities(r8[0]);
            if (r10 != null) goto L7;
            return;
        L7:
            if (r10.hasTransport(4) == false) goto L12;
            this.mVpnInPlace = r8[0];
            return;
        L12:
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r10) {
            NetworkCapabilities r8 = NetworkChangeNotifierAutoDetect.access$400(this.this$0).getNetworkCapabilities(r10);     // Catch: Throwable -> L10
            if (ignoreConnectedNetwork(r10, r8) == false) goto L5;
            return;
        L5:
            final boolean r11 = r8.hasTransport(4);     // Catch: Throwable -> L10
            if (r11 == false) goto L8;
            this.mVpnInPlace = r10;     // Catch: Throwable -> L10
        L8:
            final long r12 = NetworkChangeNotifierAutoDetect.networkToNetId(r10);     // Catch: Throwable -> L10
            final int r13 = NetworkChangeNotifierAutoDetect.access$400(this.this$0).getConnectionType(r10);     // Catch: Throwable -> L10
            NetworkChangeNotifierAutoDetect.access$600(this.this$0, new AnonymousClass1(this, r12, r13, r11));     // Catch: Throwable -> L10
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r8, NetworkCapabilities r10) {
            if (ignoreConnectedNetwork(r8, r10) == false) goto L5;
            return;
        L5:
            final long r11 = NetworkChangeNotifierAutoDetect.networkToNetId(r8);     // Catch: Throwable -> L7
            final int r12 = NetworkChangeNotifierAutoDetect.access$400(this.this$0).getConnectionType(r8);     // Catch: Throwable -> L7
            NetworkChangeNotifierAutoDetect.access$600(this.this$0, new AnonymousClass2(this, r11, r12));     // Catch: Throwable -> L7
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network r8, int r10) {
            if (ignoreConnectedNetwork(r8, null) == false) goto L5;
            return;
        L5:
            final long r11 = NetworkChangeNotifierAutoDetect.networkToNetId(r8);
            NetworkChangeNotifierAutoDetect.access$600(this.this$0, new AnonymousClass3(this, r11));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(final Network r8) {
            if (ignoreNetworkDueToVpn(r8) == false) goto L5;
            return;
        L5:
            NetworkChangeNotifierAutoDetect.access$600(this.this$0, new AnonymousClass4(this, r8));
            if (this.mVpnInPlace == null) goto L13;
            this.mVpnInPlace = null;
            Network[] r10 = NetworkChangeNotifierAutoDetect.access$100(NetworkChangeNotifierAutoDetect.access$400(this.this$0), r8);
            int r11 = r10.length;
            int r12 = 0;
        L8:
            if (r12 >= r11) goto L10;
            onAvailable(r10[r12]);
            r12 = r12 + 1;
            goto L8
        L10:
            final int r13 = this.this$0.getCurrentNetworkState().getConnectionType();
            NetworkChangeNotifierAutoDetect.access$600(this.this$0, new AnonymousClass5(this, r13));
            return;
        }

        public /* synthetic */ MyNetworkCallback(NetworkChangeNotifierAutoDetect r8, AnonymousClass1 r10) {
            this(r8);
        }
    }

    public static class NetworkConnectivityIntentFilter extends IntentFilter {
        public NetworkConnectivityIntentFilter() {
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
    }

    public static class NetworkState {
        private final boolean mConnected;
        private final boolean mIsPrivateDnsActive;
        private final String mNetworkIdentifier;
        private final int mSubtype;
        private final int mType;

        public NetworkState(boolean r8, int r10, int r11, String r12, boolean r13) {
            this.mConnected = r8;
            this.mType = r10;
            this.mSubtype = r11;
            if (r12 != null) goto L5;
            r12 = "";
        L5:
            this.mNetworkIdentifier = r12;
            this.mIsPrivateDnsActive = r13;
        }

        public int getConnectionSubtype() {
            if (isConnected() == true) goto L7;
            return 1;
        L7:
            if (getNetworkType() == 0) goto L10;
            return 0;
        L10:
            switch(getNetworkSubType()) {
                case 1: goto L40;
                case 2: goto L38;
                case 3: goto L36;
                case 4: goto L34;
                case 5: goto L32;
                case 6: goto L30;
                case 7: goto L28;
                case 8: goto L26;
                case 9: goto L24;
                case 10: goto L22;
                case 11: goto L20;
                case 12: goto L18;
                case 13: goto L16;
                case 14: goto L14;
                case 15: goto L12;
                default: goto L11;
            };
        L11:
            return 0;
        L12:
            return 17;
        L14:
            return 16;
        L16:
            return 18;
        L18:
            return 13;
        L20:
            return 4;
        L22:
            return 12;
        L24:
            return 15;
        L26:
            return 14;
        L28:
            return 6;
        L30:
            return 11;
        L32:
            return 10;
        L34:
            return 5;
        L36:
            return 9;
        L38:
            return 8;
        L40:
            return 7;
        }

        public int getConnectionType() {
            if (isConnected() == true) goto L7;
            return 6;
        L7:
            return NetworkChangeNotifierAutoDetect.access$000(getNetworkType(), getNetworkSubType());
        }

        public String getNetworkIdentifier() {
            return this.mNetworkIdentifier;
        }

        public int getNetworkSubType() {
            return this.mSubtype;
        }

        public int getNetworkType() {
            return this.mType;
        }

        public boolean isConnected() {
            return this.mConnected;
        }

        public boolean isPrivateDnsActive() {
            return this.mIsPrivateDnsActive;
        }
    }

    public interface Observer {
        void onConnectionSubtypeChanged(int r8);

        void onConnectionTypeChanged(int r8);

        void onNetworkConnect(long r8, int r10);

        void onNetworkDisconnect(long r8);

        void onNetworkSoonToDisconnect(long r8);

        void purgeActiveNetworkList(long[] r8);
    }

    public static abstract class RegistrationPolicy {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private NetworkChangeNotifierAutoDetect mNotifier;

        public RegistrationPolicy() {
        }

        public abstract void destroy();

        public void init(NetworkChangeNotifierAutoDetect r8) {
            this.mNotifier = r8;
        }

        public final void register() {
            this.mNotifier.register();
        }

        public final void unregister() {
            this.mNotifier.unregister();
        }
    }

    public static class WifiManagerDelegate {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Context mContext;

        @GuardedBy("mLock")
        private boolean mHasWifiPermission;

        @GuardedBy("mLock")
        private boolean mHasWifiPermissionComputed;
        private final Object mLock;

        @GuardedBy("mLock")
        private WifiManager mWifiManager;

        public WifiManagerDelegate() {
            this.mLock = new Object();
            this.mContext = null;
        }

        @GuardedBy("mLock")
        private WifiInfo getWifiInfoLocked() {
            return this.mWifiManager.getConnectionInfo();
        L4:
            return this.mWifiManager.getConnectionInfo();
        L6:
            return null;
        }

        @GuardedBy("mLock")
        @SuppressLint({"WifiManagerPotentialLeak"})
        private boolean hasPermissionLocked() {
            if (this.mHasWifiPermissionComputed == false) goto L7;
            return this.mHasWifiPermission;
        L7:
            if (this.mContext.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", this.mContext.getPackageName()) != 0) goto L9;
            boolean r8 = true;
        L10:
            this.mHasWifiPermission = r8;
            if (r8 == false) goto L13;
            WifiManager r10 = (WifiManager) this.mContext.getSystemService("wifi");
        L14:
            this.mWifiManager = r10;
            this.mHasWifiPermissionComputed = true;
            return this.mHasWifiPermission;
        L13:
            r10 = null;
            goto L14
        L9:
            r8 = false;
            goto L10
        }

        public String getWifiSsid() {
            return "";
        }

        public WifiManagerDelegate(Context r8) {
            this.mLock = new Object();
            this.mContext = r8;
        }
    }

    @TargetApi(21)
    public NetworkChangeNotifierAutoDetect(Observer r8, RegistrationPolicy r10) {
        Looper r11 = Looper.myLooper();
        this.mLooper = r11;
        this.mHandler = new Handler(r11);
        this.mObserver = r8;
        this.mConnectivityManagerDelegate = new ConnectivityManagerDelegate(ContextUtils.getApplicationContext());
        AnonymousClass1 r12 = null;
        this.mNetworkCallback = new MyNetworkCallback(this, r12);
        this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
        this.mDefaultNetworkCallback = new DefaultNetworkCallback(this, r12);
        this.mNetworkState = getCurrentNetworkState();
        this.mIntentFilter = new NetworkConnectivityIntentFilter();
        this.mIgnoreNextBroadcast = false;
        this.mShouldSignalObserver = false;
        this.mRegistrationPolicy = r10;
        r10.init(this);
        this.mShouldSignalObserver = true;
    }

    public static /* synthetic */ int access$000(int r8, int r10) {
        return convertToConnectionType(r8, r10);
    }

    public static /* synthetic */ Network[] access$100(ConnectivityManagerDelegate r8, Network r10) {
        return getAllNetworksFiltered(r8, r10);
    }

    public static /* synthetic */ boolean access$200(NetworkChangeNotifierAutoDetect r8) {
        return r8.mRegistered;
    }

    public static /* synthetic */ void access$300(NetworkChangeNotifierAutoDetect r8) {
        r8.connectionTypeChanged();
    }

    public static /* synthetic */ ConnectivityManagerDelegate access$400(NetworkChangeNotifierAutoDetect r8) {
        return r8.mConnectivityManagerDelegate;
    }

    public static /* synthetic */ Observer access$500(NetworkChangeNotifierAutoDetect r8) {
        return r8.mObserver;
    }

    public static /* synthetic */ void access$600(NetworkChangeNotifierAutoDetect r8, Runnable r10) {
        r8.runOnThread(r10);
    }

    public static /* synthetic */ boolean access$900(NetworkChangeNotifierAutoDetect r8) {
        return r8.mIgnoreNextBroadcast;
    }

    public static /* synthetic */ boolean access$902(NetworkChangeNotifierAutoDetect r8, boolean r10) {
        r8.mIgnoreNextBroadcast = r10;
        return r10;
    }

    private void assertOnThread() {
        if (BuildConfig.DCHECK_IS_ON == true) goto L5;
        return;
    L5:
        if (onThread() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
    }

    private void connectionTypeChanged() {
        NetworkState r8 = getCurrentNetworkState();
        if (r8.getConnectionType() == this.mNetworkState.getConnectionType()) goto L5;
    L8:
        this.mObserver.onConnectionTypeChanged(r8.getConnectionType());
    L10:
        if (r8.getConnectionType() == this.mNetworkState.getConnectionType()) goto L12;
    L13:
        this.mObserver.onConnectionSubtypeChanged(r8.getConnectionSubtype());
    L14:
        this.mNetworkState = r8;
        return;
    L12:
        if (r8.getConnectionSubtype() == this.mNetworkState.getConnectionSubtype()) goto L14;
    L5:
        if (r8.getNetworkIdentifier().equals(this.mNetworkState.getNetworkIdentifier()) == false) goto L8;
        if (r8.isPrivateDnsActive() == this.mNetworkState.isPrivateDnsActive()) goto L10;
        goto L8
    }

    private static int convertToConnectionType(int r8, int r10) {
        int r11 = 5;
        if (r8 != 0) goto L5;
        switch(r10) {
            case 1: goto L22;
            case 2: goto L22;
            case 3: goto L20;
            case 4: goto L22;
            case 5: goto L20;
            case 6: goto L20;
            case 7: goto L22;
            case 8: goto L20;
            case 9: goto L20;
            case 10: goto L20;
            case 11: goto L22;
            case 12: goto L20;
            case 13: goto L19;
            case 14: goto L20;
            case 15: goto L20;
            default: goto L18;
        };
    L18:
        return 0;
    L19:
        return 5;
    L20:
        return 4;
    L22:
        return 3;
    L5:
        if (r8 != 1) goto L7;
        return 2;
    L7:
        if (r8 == 6) goto L14;
        r11 = 7;
        if (r8 == 7) goto L14;
        if (r8 == 9) goto L13;
        return 0;
    L13:
        return 1;
    L14:
        return r11;
    }

    @TargetApi(21)
    private static Network[] getAllNetworksFiltered(ConnectivityManagerDelegate r8, Network r10) {
        Network[] r11 = r8.getAllNetworksUnfiltered();
        int r12 = r11.length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L21;
        Network r15 = r11[r13];
        if (r15.equals(r10) == true) goto L19;
        NetworkCapabilities r16 = r8.getNetworkCapabilities(r15);
        if (r16 == null) goto L19;
        if (r16.hasCapability(12) == false) goto L19;
        if (r16.hasTransport(4) == true) goto L15;
        r11[r14] = r15;
        r14 = r14 + 1;
        goto L19
    L15:
        if (r8.vpnAccessible(r15) == false) goto L19;
        return new Network[]{r15};
    L19:
        r13 = r13 + 1;
        goto L3
    L21:
        return (Network[]) Arrays.copyOf(r11, r14);
    }

    @VisibleForTesting
    @TargetApi(21)
    public static long networkToNetId(Network r8) {
        return ApiHelperForM.getNetworkHandle(r8);
    }

    private boolean onThread() {
        if (this.mLooper != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    private void runOnThread(Runnable r8) {
        if (onThread() == false) goto L5;
        r8.run();
        return;
    L5:
        this.mHandler.post(r8);
    }

    public void destroy() {
        assertOnThread();
        this.mRegistrationPolicy.destroy();
        unregister();
    }

    public NetworkState getCurrentNetworkState() {
        return this.mConnectivityManagerDelegate.getNetworkState(this.mWifiManagerDelegate);
    }

    public long getDefaultNetId() {
        Network r8 = this.mConnectivityManagerDelegate.getDefaultNetwork();
        if (r8 != null) goto L6;
        return -1;
    L6:
        return networkToNetId(r8);
    }

    public long[] getNetworksAndTypes() {
        Network[] r8 = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
        long[] r10 = new long[r8.length * 2];
        int r11 = r8.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        Network r14 = r8[r12];
        int r15 = r13 + 1;
        r10[r13] = networkToNetId(r14);
        r13 = r15 + 1;
        r10[r15] = this.mConnectivityManagerDelegate.getConnectionType(r14);
        r12 = r12 + 1;
        goto L3
    L5:
        return r10;
    }

    @VisibleForTesting
    public RegistrationPolicy getRegistrationPolicy() {
        return this.mRegistrationPolicy;
    }

    @VisibleForTesting
    public boolean isReceiverRegisteredForTesting() {
        return this.mRegistered;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r8, Intent r10) {
        runOnThread(new AnonymousClass1(this));
    }

    public void register() {
        assertOnThread();
        if (this.mRegistered == false) goto L6;
        return;
    L6:
        if (this.mShouldSignalObserver == false) goto L8;
        connectionTypeChanged();
    L8:
        DefaultNetworkCallback r8 = this.mDefaultNetworkCallback;
        if (r8 != null) goto L42;
    L13:
        int r10 = 0;
        if (this.mDefaultNetworkCallback == null) goto L38;
    L22:
        this.mRegistered = true;
        MyNetworkCallback r11 = this.mNetworkCallback;
        if (r11 == null) goto L45;
        r11.initializeVpnInPlace();
        this.mConnectivityManagerDelegate.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback, this.mHandler);     // Catch: RuntimeException -> L27
    L29:
        if (this.mRegisterNetworkCallbackFailed == false) goto L31;
        return;
    L31:
        if (this.mShouldSignalObserver == false) goto L47;
        Network[] r12 = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
        long[] r13 = new long[r12.length];
    L34:
        if (r10 >= r12.length) goto L36;
        r13[r10] = networkToNetId(r12[r10]);
        r10 = r10 + 1;
        goto L34
    L36:
        this.mObserver.purgeActiveNetworkList(r13);
        return;
    L47:
        return;
    L27:
        this.mRegisterNetworkCallbackFailed = true;
        this.mNetworkCallback = null;
        goto L29
    L45:
        return;
    L38:
    L21:
        this.mIgnoreNextBroadcast = false;
        goto L22
    L16:
        if (ContextUtils.getApplicationContext().registerReceiver(this, this.mIntentFilter) == null) goto L18;
        boolean r14 = true;
    L19:
        this.mIgnoreNextBroadcast = r14;     // Catch: RuntimeException -> L21
        goto L22
    L18:
        r14 = false;
        goto L19
    L42:
        this.mConnectivityManagerDelegate.registerDefaultNetworkCallback(r8, this.mHandler);     // Catch: RuntimeException -> L12
    L12:
        this.mDefaultNetworkCallback = null;
        goto L13
    }

    public boolean registerNetworkCallbackFailed() {
        return this.mRegisterNetworkCallbackFailed;
    }

    public void setConnectivityManagerDelegateForTests(ConnectivityManagerDelegate r8) {
        this.mConnectivityManagerDelegate = r8;
    }

    public void setWifiManagerDelegateForTests(WifiManagerDelegate r8) {
        this.mWifiManagerDelegate = r8;
    }

    public void unregister() {
        assertOnThread();
        if (this.mRegistered == true) goto L5;
        return;
    L5:
        this.mRegistered = false;
        MyNetworkCallback r8 = this.mNetworkCallback;
        if (r8 == null) goto L8;
        this.mConnectivityManagerDelegate.unregisterNetworkCallback(r8);
    L8:
        DefaultNetworkCallback r10 = this.mDefaultNetworkCallback;
        if (r10 == null) goto L11;
        this.mConnectivityManagerDelegate.unregisterNetworkCallback(r10);
        return;
    L11:
        ContextUtils.getApplicationContext().unregisterReceiver(this);
    }
}
