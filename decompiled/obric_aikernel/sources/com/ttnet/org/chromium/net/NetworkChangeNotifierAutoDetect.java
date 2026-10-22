package com.ttnet.org.chromium.net;

import android.annotation.SuppressLint;
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
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.StrictModeContext;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import com.ttnet.org.chromium.base.compat.ApiHelperForO;
import com.ttnet.org.chromium.base.compat.ApiHelperForP;
import com.ttnet.org.chromium.build.BuildConfig;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"NewApi"})
public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver {
    private static final String TAG = null;
    private static final int UNKNOWN_LINK_SPEED = -1;
    private ConnectivityManagerDelegate mConnectivityManagerDelegate;
    private ConnectivityManager.NetworkCallback mDefaultNetworkCallback;
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

    @RequiresApi(28)
    private class AndroidRDefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
        LinkProperties mLinkProperties;
        NetworkCapabilities mNetworkCapabilities;
        final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

        private AndroidRDefaultNetworkCallback(NetworkChangeNotifierAutoDetect r10) {
            this.this$0 = r10;
        }

        /* synthetic */ AndroidRDefaultNetworkCallback(NetworkChangeNotifierAutoDetect r10, AnonymousClass1 r11) {
            this(r10);
        }

        private NetworkState getNetworkState(Network r14) {
            int r10 = 0;
            int r11 = -1;
            if (this.mNetworkCapabilities.hasTransport(1) == false) goto L5;
        L27:
            int r12 = 1;
        L28:
            int r13 = r11;
        L30:
            return new NetworkState(true, r12, r13, !this.mNetworkCapabilities.hasCapability(11), String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(r14)), null, ApiHelperForP.isPrivateDnsActive(this.mLinkProperties), ApiHelperForP.getPrivateDnsServerName(this.mLinkProperties));
        L5:
            if (this.mNetworkCapabilities.hasTransport(5) == true) goto L27;
            if (this.mNetworkCapabilities.hasTransport(0) == false) goto L13;
            NetworkInfo r15 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getRawNetworkInfo(r14);
            if (r15 == null) goto L15;
            r11 = r15.getSubtype();
        L15:
            r12 = r10;
            goto L28
        L13:
            if (this.mNetworkCapabilities.hasTransport(3) == false) goto L17;
            r10 = 9;
            goto L15
        L17:
            if (this.mNetworkCapabilities.hasTransport(2) == false) goto L20;
            r10 = 7;
            goto L15
        L20:
            if (this.mNetworkCapabilities.hasTransport(4) == false) goto L26;
            NetworkInfo r16 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getNetworkInfo(r14);
            if (r16 == null) goto L24;
            int r17 = r16.getType();
        L25:
            r10 = r17;
            goto L15
        L24:
            r17 = 17;
            goto L25
        L26:
            r12 = -1;
            r13 = -1;
            goto L30
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r10) {
            this.mLinkProperties = null;
            this.mNetworkCapabilities = null;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r10, NetworkCapabilities r11) {
            this.mNetworkCapabilities = r11;
            if (NetworkChangeNotifierAutoDetect.access$300(this.this$0) == true) goto L5;
            return;
        L5:
            if (this.mLinkProperties != null) goto L7;
            return;
        L7:
            if (this.mNetworkCapabilities == null) goto L12;
            NetworkChangeNotifierAutoDetect.access$500(this.this$0, getNetworkState(r10));
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network r10, LinkProperties r11) {
            this.mLinkProperties = r11;
            if (NetworkChangeNotifierAutoDetect.access$300(this.this$0) == true) goto L5;
            return;
        L5:
            if (this.mLinkProperties != null) goto L7;
            return;
        L7:
            if (this.mNetworkCapabilities == null) goto L12;
            NetworkChangeNotifierAutoDetect.access$500(this.this$0, getNetworkState(r10));
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r10) {
            this.mLinkProperties = null;
            this.mNetworkCapabilities = null;
            if (NetworkChangeNotifierAutoDetect.access$300(this.this$0) == false) goto L6;
            NetworkChangeNotifierAutoDetect.access$500(this.this$0, new NetworkState(false, -1, -1, false, null, null, false, ""));
            return;
        }
    }

    static class ConnectivityManagerDelegate {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final ConnectivityManager mConnectivityManager;

        static {
        }

        ConnectivityManagerDelegate() {
            this.mConnectivityManager = null;
        }

        ConnectivityManagerDelegate(Context r10) {
            this.mConnectivityManager = (ConnectivityManager) r10.getSystemService("connectivity");
        }

        private NetworkInfo processActiveNetworkInfo(NetworkInfo r10) {
            if (r10 != null) goto L6;
            return null;
        L6:
            if (r10.isConnected() == false) goto L9;
            return r10;
        L9:
            if (Build.VERSION.SDK_INT >= 21) goto L12;
            return null;
        L12:
            if (r10.getDetailedState() == NetworkInfo.DetailedState.BLOCKED) goto L15;
            return null;
        L15:
            if (ApplicationStatus.getStateForApplication() == 1) goto L17;
            return null;
        L17:
            return r10;
        }

        @VisibleForTesting
        protected Network[] getAllNetworksUnfiltered() {
            Network[] r10 = this.mConnectivityManager.getAllNetworks();     // Catch: Throwable -> L4
        L5:
            if (r10 == null) goto L7;
            return r10;
        L7:
            return new Network[0];
        L4:
            r10 = null;
            goto L5
        }

        int getConnectionType(Network r10) {
            NetworkInfo r11 = getNetworkInfo(r10);
            if (r11 != null) goto L5;
            return 6;
        L5:
            if (r11.isConnected() == true) goto L7;
            return 6;
        L7:
            return NetworkChangeNotifierAutoDetect.access$000(r11.getType(), r11.getSubtype());
        }

        Network getDefaultNetwork() {
            if (Build.VERSION.SDK_INT >= 23) goto L40;
            Network r10 = null;
        L38:
            NetworkInfo r11 = this.mConnectivityManager.getActiveNetworkInfo();     // Catch: Throwable -> L37
            if (r11 != null) goto L13;
            return null;
        L13:
            Network[] r12 = NetworkChangeNotifierAutoDetect.access$100(this, null);
            int r13 = r12.length;
            int r14 = 0;
        L14:
            if (r14 >= r13) goto L36;
            Network r15 = r12[r14];
            NetworkInfo r16 = getRawNetworkInfo(r15);
            if (r16 == null) goto L35;
            if (r16.getType() != r11.getType()) goto L20;
        L21:
            if (r10 != null) goto L23;
        L32:
            if (r10 == null) goto L34;
            Log.e(NetworkChangeNotifierAutoDetect.access$200(), "defaultNetwork != null", new Object[0]);
        L34:
            r10 = r15;
            goto L35
        L23:
            if (Build.VERSION.SDK_INT < 29) goto L32;
            if (r16.getDetailedState() == NetworkInfo.DetailedState.CONNECTING) goto L35;
            NetworkInfo r17 = getRawNetworkInfo(r10);
            if (r17 == null) goto L32;
            if (r17.getDetailedState() != NetworkInfo.DetailedState.CONNECTING) goto L32;
            r10 = null;
            goto L32
        L20:
            if (r16.getType() == 17) goto L21;
        L35:
            r14 = r14 + 1;
            goto L14
        L36:
            return r10;
        L37:
            return null;
        L40:
            r10 = ApiHelperForM.getActiveNetwork(this.mConnectivityManager);     // Catch: Throwable -> L6
        L7:
            if (r10 == null) goto L38;
            return r10;
        L6:
            r10 = null;
            goto L7
        }

        @VisibleForTesting
        protected NetworkCapabilities getNetworkCapabilities(Network r10) {
            int r11 = 0;
        L4:
            if (r11 >= 2) goto L8;
            return this.mConnectivityManager.getNetworkCapabilities(r10);
        L7:
            r11 = r11 + 1;
            goto L4
        L8:
            return null;
        }

        NetworkInfo getNetworkInfo(Network r10) {
            NetworkInfo r11 = getRawNetworkInfo(r10);
            if (r11 != null) goto L5;
            return r11;
        L5:
            if (r11.getType() != 17) goto L13;
            return this.mConnectivityManager.getActiveNetworkInfo();
        L8:
            return null;
        L13:
            return r11;
        }

        NetworkState getNetworkState(WifiManagerDelegate r23) {
            NetworkInfo r10 = null;
            r10 = null;
            Network r11 = null;
        L15:
            Network r12 = null;
        L16:
            NetworkInfo r13 = processActiveNetworkInfo(r10);
            if (r13 != null) goto L21;
            return new NetworkState(false, -1, -1, false, null, null, false, "");
        L21:
            if (r12 == null) goto L40;
            NetworkCapabilities r14 = getNetworkCapabilities(r12);
            int r15 = 0;
            if (r14 != null) goto L25;
        L27:
            boolean r16 = false;
        L28:
            DnsStatus r17 = AndroidNetworkLibrary.getDnsStatus(r12);
            if (r17 == null) goto L31;
            ArrayList r18 = new ArrayList();
            byte[][] r19 = r17.getDnsServers();     // Catch: UnknownHostException -> L55
            int r20 = r19.length;     // Catch: UnknownHostException -> L55
        L34:
            if (r15 >= r20) goto L38;
            r18.add(InetAddress.getByAddress(r19[r15]));     // Catch: UnknownHostException -> L55
            r15 = r15 + 1;
        L38:
            return new NetworkState(true, r13.getType(), r13.getSubtype(), r16, String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(r12)), r18, r17.getPrivateDnsActive(), r17.getPrivateDnsServerName());
        L31:
            return new NetworkState(true, r13.getType(), r13.getSubtype(), r16, String.valueOf(NetworkChangeNotifierAutoDetect.networkToNetId(r12)), null, false, "");
        L25:
            if (r14.hasCapability(11) == true) goto L27;
            r16 = true;
            goto L28
        L40:
            if (r13.getType() != 1) goto L53;
            if (Build.VERSION.SDK_INT >= 23) goto L53;
            if (r23 == null) goto L53;
            if (r13.getExtraInfo() == null) goto L51;
            if ("".equals(r13.getExtraInfo()) == true) goto L51;
            return new NetworkState(true, r13.getType(), r13.getSubtype(), false, r13.getExtraInfo(), null, false, "");
        L51:
            return new NetworkState(true, r13.getType(), r13.getSubtype(), false, r23.getWifiSsid(), null, false, "");
        L53:
            return new NetworkState(true, r13.getType(), r13.getSubtype(), false, null, null, false, "");
        L4:
            if (Build.VERSION.SDK_INT < 23) goto L13;
            r12 = getDefaultNetwork();     // Catch: Throwable -> L15
            NetworkInfo r21 = getNetworkInfo(r12);     // Catch: Throwable -> L54
            if (r21 != null) goto L9;
        L12:
            r11 = r12;
            NetworkInfo r22 = r21;
        L14:
            NetworkInfo r24 = r22;
            r12 = r11;
            r10 = r24;
            goto L16
        L9:
            if (r21.getType() != 17) goto L12;
            r22 = this.mConnectivityManager.getActiveNetworkInfo();     // Catch: Throwable -> L54
            r11 = r12;
            goto L14
        L13:
            r22 = this.mConnectivityManager.getActiveNetworkInfo();     // Catch: Throwable -> L15
            goto L14
        }

        NetworkInfo getRawNetworkInfo(Network r10) {
            return this.mConnectivityManager.getNetworkInfo(r10);
        L4:
            return this.mConnectivityManager.getNetworkInfo(r10);
        L6:
            return null;
        }

        @RequiresApi(28)
        void registerDefaultNetworkCallback(ConnectivityManager.NetworkCallback r10, Handler r11) {
            ApiHelperForO.registerDefaultNetworkCallback(this.mConnectivityManager, r10, r11);     // Catch: Throwable -> L4
            return;
        }

        void registerNetworkCallback(NetworkRequest r10, ConnectivityManager.NetworkCallback r11, Handler r12) {
            if (Build.VERSION.SDK_INT < 26) goto L5;
            ApiHelperForO.registerNetworkCallback(this.mConnectivityManager, r10, r11, r12);     // Catch: Throwable -> L7
        L8:
            return;
        L5:
            this.mConnectivityManager.registerNetworkCallback(r10, r11);     // Catch: Throwable -> L7
        }

        void unregisterNetworkCallback(ConnectivityManager.NetworkCallback r10) {
            this.mConnectivityManager.unregisterNetworkCallback(r10);     // Catch: Throwable -> L4
            return;
        }

        @VisibleForTesting
        protected boolean vpnAccessible(Network r10) {
            Socket r11 = new Socket();
            StrictModeContext r12 = StrictModeContext.allowAllVmPolicies();     // Catch: Throwable -> L17 IOException -> L20
            r10.bindSocket(r11);     // Catch: Throwable -> L10
            if (r12 == null) goto L30;
            r12.close();     // Catch: Throwable -> L17 IOException -> L20
        L30:
            r11.close();     // Catch: IOException -> L23
            return true;
        L37:
            return true;
        L10:
            th = move-exception;
            if (r12 != null) goto L32;
        L16:
            throw th;     // Catch: Throwable -> L17 IOException -> L20
        L32:
            r12.close();     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L17 IOException -> L20
        L17:
            th = move-exception;
            r11.close();     // Catch: IOException -> L24
        L19:
            throw th;
        L34:
            r11.close();     // Catch: IOException -> L25
        L22:
            return false;
        }
    }

    private class DefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

        private DefaultNetworkCallback(NetworkChangeNotifierAutoDetect r10) {
            this.this$0 = r10;
        }

        /* synthetic */ DefaultNetworkCallback(NetworkChangeNotifierAutoDetect r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r10) {
            if (NetworkChangeNotifierAutoDetect.access$300(this.this$0) == false) goto L6;
            NetworkChangeNotifierAutoDetect.access$400(this.this$0);
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r10, NetworkCapabilities r11) {
            onAvailable(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network r10, LinkProperties r11) {
            onAvailable(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r10) {
            onAvailable(null);
        }
    }

    private class MyNetworkCallback extends ConnectivityManager.NetworkCallback {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Network mVpnInPlace;
        final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

        static {
        }

        private MyNetworkCallback(NetworkChangeNotifierAutoDetect r10) {
            this.this$0 = r10;
        }

        /* synthetic */ MyNetworkCallback(NetworkChangeNotifierAutoDetect r10, AnonymousClass1 r11) {
            this(r10);
        }

        private boolean ignoreConnectedInaccessibleVpn(Network r10, NetworkCapabilities r11) {
            if (r11 != null) goto L4;
            r11 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getNetworkCapabilities(r10);
        L4:
            if (r11 != null) goto L6;
        L11:
            return true;
        L6:
            if (r11.hasTransport(4) == true) goto L8;
        L10:
            return false;
        L8:
            if (NetworkChangeNotifierAutoDetect.access$600(this.this$0).vpnAccessible(r10) == true) goto L10;
            goto L10
        }

        private boolean ignoreConnectedNetwork(Network r10, NetworkCapabilities r11) {
            if (ignoreNetworkDueToVpn(r10) == false) goto L5;
        L8:
            return true;
        L5:
            if (ignoreConnectedInaccessibleVpn(r10, r11) == true) goto L8;
            return false;
        }

        private boolean ignoreNetworkDueToVpn(Network r10) {
            Network r11 = this.mVpnInPlace;
            if (r11 != null) goto L5;
        L7:
            return false;
        L5:
            if (r11.equals(r10) == true) goto L7;
            return true;
        }

        public long getVpnNetId() {
            Network r10 = this.mVpnInPlace;
            if (r10 != null) goto L6;
            return -1;
        L6:
            return NetworkChangeNotifierAutoDetect.networkToNetId(r10);
        }

        void initializeVpnInPlace() {
            Network[] r10 = NetworkChangeNotifierAutoDetect.access$100(NetworkChangeNotifierAutoDetect.access$600(this.this$0), null);
            this.mVpnInPlace = null;
            if (r10.length != 1) goto L10;
            NetworkCapabilities r11 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getNetworkCapabilities(r10[0]);
            if (r11 != null) goto L7;
            return;
        L7:
            if (r11.hasTransport(4) == false) goto L12;
            this.mVpnInPlace = r10[0];
            return;
        L12:
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r10) {
            TraceEvent r11 = TraceEvent.scoped("NetworkChangeNotifierCallback::onAvailable");
            NetworkCapabilities r12 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getNetworkCapabilities(r10);     // Catch: Throwable -> L25
            if (ignoreConnectedNetwork(r10, r12) == false) goto L8;
            if (r11 == null) goto L36;
            r11.close();
            return;
        L36:
            return;
        L8:
            boolean r13 = false;
            if (r12 != null) goto L12;
        L18:
            final boolean r14 = r13;
            if (r14 == false) goto L21;
            this.mVpnInPlace = r10;     // Catch: Throwable -> L25
        L21:
            final long r15 = NetworkChangeNotifierAutoDetect.networkToNetId(r10);     // Catch: Throwable -> L25
            final int r16 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getConnectionType(r10);     // Catch: Throwable -> L25
            this.this$0.runOnThread(new AnonymousClass1(this, r15, r16, r14));     // Catch: Throwable -> L25
            if (r11 == null) goto L37;
            r11.close();
            return;
        L37:
            return;
        L12:
            if (r12.hasTransport(4) == false) goto L18;
            Network r17 = this.mVpnInPlace;     // Catch: Throwable -> L25
            if (r17 != null) goto L16;
        L17:
            r13 = true;
            goto L18
        L16:
            if (r10.equals(r17) == true) goto L18;
        L25:
            th = move-exception;
            if (r11 != null) goto L34;
        L31:
            throw th;
        L34:
            r11.close();     // Catch: Throwable -> L29
        L29:
            th = move-exception;
            th.addSuppressed(th);
            goto L31
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r10, NetworkCapabilities r11) {
            TraceEvent r12 = TraceEvent.scoped("NetworkChangeNotifierCallback::onCapabilitiesChanged");
        L18:
            th = move-exception;
            if (r12 != null) goto L27;
        L24:
            throw th;
        L27:
            r12.close();     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            th.addSuppressed(th);
            goto L24
        L4:
            if (ignoreConnectedNetwork(r10, r11) == false) goto L8;
            if (r12 == null) goto L29;
            r12.close();
            return;
        L29:
            return;
        L8:
            final long r13 = NetworkChangeNotifierAutoDetect.networkToNetId(r10);     // Catch: Throwable -> L18
            final int r14 = NetworkChangeNotifierAutoDetect.access$600(this.this$0).getConnectionType(r10);     // Catch: Throwable -> L18
            Network r15 = this.mVpnInPlace;     // Catch: Throwable -> L18
            if (r15 != null) goto L11;
        L13:
            boolean r16 = false;
        L14:
            final boolean r17 = r16;
            this.this$0.runOnThread(new AnonymousClass2(this, r13, r14, r17));     // Catch: Throwable -> L18
            if (r12 == null) goto L30;
            r12.close();
            return;
        L30:
            return;
        L11:
            if (r15.equals(r10) == false) goto L13;
            r16 = true;
            goto L14
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network r10, int r11) {
            TraceEvent r12 = TraceEvent.scoped("NetworkChangeNotifierCallback::onLosing");
        L12:
            th = move-exception;
            if (r12 != null) goto L21;
        L18:
            throw th;
        L21:
            r12.close();     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            th.addSuppressed(th);
            goto L18
        L4:
            if (ignoreConnectedNetwork(r10, null) == false) goto L8;
            if (r12 == null) goto L23;
            r12.close();
            return;
        L23:
            return;
        L8:
            final long r13 = NetworkChangeNotifierAutoDetect.networkToNetId(r10);     // Catch: Throwable -> L12
            this.this$0.runOnThread(new AnonymousClass3(this, r13));     // Catch: Throwable -> L12
            if (r12 == null) goto L24;
            r12.close();
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(final Network r10) {
            TraceEvent r11 = TraceEvent.scoped("NetworkChangeNotifierCallback::onLost");
        L23:
            th = move-exception;
            if (r11 != null) goto L32;
        L29:
            throw th;
        L32:
            r11.close();     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            th.addSuppressed(th);
            goto L29
        L4:
            if (ignoreNetworkDueToVpn(r10) == false) goto L8;
            if (r11 == null) goto L35;
            r11.close();
            return;
        L35:
            return;
        L8:
            Network r12 = this.mVpnInPlace;     // Catch: Throwable -> L23
            int r13 = 0;
            if (r12 != null) goto L11;
        L13:
            final boolean r14 = false;
        L14:
            this.this$0.runOnThread(new AnonymousClass4(this, r10, r14));     // Catch: Throwable -> L23
            if (this.mVpnInPlace == null) goto L20;
            this.mVpnInPlace = null;     // Catch: Throwable -> L23
            Network[] r15 = NetworkChangeNotifierAutoDetect.access$100(NetworkChangeNotifierAutoDetect.access$600(this.this$0), r10);     // Catch: Throwable -> L23
            int r16 = r15.length;     // Catch: Throwable -> L23
        L17:
            if (r13 >= r16) goto L19;
            onAvailable(r15[r13]);     // Catch: Throwable -> L23
            r13 = r13 + 1;     // Catch: Throwable -> L23
            goto L17
        L19:
            final int r17 = this.this$0.getCurrentNetworkState().getConnectionType();     // Catch: Throwable -> L23
            this.this$0.runOnThread(new AnonymousClass5(this, r17));     // Catch: Throwable -> L23
        L20:
            if (r11 == null) goto L36;
            r11.close();
            return;
        L36:
            return;
        L11:
            if (r12.equals(r10) == false) goto L13;
            r14 = true;
            goto L14
        }
    }

    private static class NetworkConnectivityIntentFilter extends IntentFilter {
        NetworkConnectivityIntentFilter() {
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
    }

    public static class NetworkState {
        private final boolean mConnected;
        private final List<InetAddress> mDnsServers;
        private final boolean mIsMetered;
        private final boolean mIsPrivateDnsActive;
        private final String mNetworkIdentifier;
        private final String mPrivateDnsServerName;
        private final int mSubtype;
        private final int mType;

        public NetworkState(boolean r10, int r11, int r12, boolean r13, String r14, List<InetAddress> r15, boolean r16, String r17) {
            this.mConnected = r10;
            this.mType = r11;
            this.mSubtype = r12;
            this.mIsMetered = r13;
            if (r14 != null) goto L5;
            r14 = "";
        L5:
            this.mNetworkIdentifier = r14;
            if (r15 != null) goto L8;
            r15 = new ArrayList();
        L8:
            this.mDnsServers = r15;
            this.mIsPrivateDnsActive = r16;
            if (r17 != null) goto L11;
            r17 = "";
        L11:
            this.mPrivateDnsServerName = r17;
        }

        public int getConnectionCost() {
            if (isMetered() == false) goto L6;
            return 2;
        L6:
            return 1;
        }

        public int getConnectionSubtype() {
            if (isConnected() == true) goto L6;
            return 1;
        L6:
            int r10 = getNetworkType();
            if (r10 == 0) goto L12;
            if (r10 == 4) goto L12;
            if (r10 == 5) goto L12;
            return 0;
        L12:
            switch(getNetworkSubType()) {
                case 1: goto L40;
                case 2: goto L38;
                case 3: goto L36;
                case 4: goto L35;
                case 5: goto L33;
                case 6: goto L31;
                case 7: goto L29;
                case 8: goto L27;
                case 9: goto L25;
                case 10: goto L23;
                case 11: goto L22;
                case 12: goto L20;
                case 13: goto L18;
                case 14: goto L16;
                case 15: goto L14;
                default: goto L13;
            };
        L13:
            return 0;
        L14:
            return 17;
        L16:
            return 16;
        L18:
            return 18;
        L20:
            return 13;
        L22:
            return 4;
        L23:
            return 12;
        L25:
            return 15;
        L27:
            return 14;
        L29:
            return 6;
        L31:
            return 11;
        L33:
            return 10;
        L35:
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

        public List<InetAddress> getDnsServers() {
            return this.mDnsServers;
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

        public String getPrivateDnsServerName() {
            return this.mPrivateDnsServerName;
        }

        public boolean isConnected() {
            return this.mConnected;
        }

        public boolean isMetered() {
            return this.mIsMetered;
        }

        public boolean isPrivateDnsActive() {
            return this.mIsPrivateDnsActive;
        }
    }

    public interface Observer {
        void onConnectionCostChanged(int r10);

        void onConnectionSubtypeChanged(int r10);

        void onConnectionTypeChanged(int r10);

        void onNetworkConnect(long r10, int r11, boolean r12);

        void onNetworkDisconnect(long r10, boolean r11);

        void onNetworkSoonToDisconnect(long r10);

        void purgeActiveNetworkList(long[] r10);
    }

    public static abstract class RegistrationPolicy {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private NetworkChangeNotifierAutoDetect mNotifier;

        static {
        }

        public RegistrationPolicy() {
        }

        protected abstract void destroy();

        protected void init(NetworkChangeNotifierAutoDetect r10) {
            this.mNotifier = r10;
        }

        protected final void register() {
            this.mNotifier.register();
        }

        protected final void unregister() {
            this.mNotifier.unregister();
        }
    }

    static class WifiManagerDelegate {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final Context mContext;
        private boolean mHasWifiPermission;
        private boolean mHasWifiPermissionComputed;
        private final Object mLock;
        private WifiManager mWifiManager;

        static {
        }

        WifiManagerDelegate() {
            this.mLock = new Object();
            this.mContext = null;
        }

        WifiManagerDelegate(Context r10) {
            this.mLock = new Object();
            this.mContext = r10;
        }

        private WifiInfo getWifiInfoLocked() {
            return this.mWifiManager.getConnectionInfo();
        L4:
            return this.mWifiManager.getConnectionInfo();
        L6:
            return null;
        }

        @SuppressLint({"WifiManagerPotentialLeak"})
        private boolean hasPermissionLocked() {
            if (this.mHasWifiPermissionComputed == false) goto L7;
            return this.mHasWifiPermission;
        L7:
            if (this.mContext.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", this.mContext.getPackageName()) != 0) goto L9;
            boolean r10 = true;
        L10:
            this.mHasWifiPermission = r10;
            if (r10 == false) goto L13;
            WifiManager r11 = (WifiManager) this.mContext.getSystemService("wifi");
        L14:
            this.mWifiManager = r11;
            this.mHasWifiPermissionComputed = true;
            return this.mHasWifiPermission;
        L13:
            r11 = null;
            goto L14
        L9:
            r10 = false;
            goto L10
        }

        String getWifiSsid() {
            return "";
        }
    }

    static {
        TAG = NetworkChangeNotifierAutoDetect.class.getSimpleName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NetworkChangeNotifierAutoDetect(Observer r10, RegistrationPolicy r11) {
        Looper r12 = Looper.myLooper();
        this.mLooper = r12;
        this.mHandler = new Handler(r12);
        this.mObserver = r10;
        this.mConnectivityManagerDelegate = new ConnectivityManagerDelegate(ContextUtils.getApplicationContext());
        int r13 = Build.VERSION.SDK_INT;
        if (r13 >= 23) goto L5;
        this.mWifiManagerDelegate = new WifiManagerDelegate(ContextUtils.getApplicationContext());
    L5:
        DefaultNetworkCallback r14 = null;
        Object[] r15 = 0;
        Object[] r16 = 0;
        Object[] r17 = 0;
        if (r13 < 21) goto L8;
        this.mNetworkCallback = new MyNetworkCallback(this, r17 == true ? 1 : 0);
        this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
    L10:
        if (r13 < 30) goto L13;
        this.mDefaultNetworkCallback = new AndroidRDefaultNetworkCallback(this, r16 == true ? 1 : 0);
    L16:
        this.mNetworkState = getCurrentNetworkState();
        this.mIntentFilter = new NetworkConnectivityIntentFilter();
        this.mIgnoreNextBroadcast = false;
        this.mShouldSignalObserver = false;
        this.mRegistrationPolicy = r11;
        r11.init(this);
        this.mShouldSignalObserver = true;
        return;
    L13:
        if (r13 < 28) goto L15;
        r14 = new DefaultNetworkCallback(this, r15 == true ? 1 : 0);
    L15:
        this.mDefaultNetworkCallback = r14;
        goto L16
    L8:
        this.mNetworkCallback = null;
        this.mNetworkRequest = null;
        goto L10
    }

    public static /* synthetic */ void a(NetworkChangeNotifierAutoDetect r10, Runnable r11) {
        r10.lambda$runOnThread$0(r11);
    }

    static /* synthetic */ int access$000(int r10, int r11) {
        return convertToConnectionType(r10, r11);
    }

    static /* synthetic */ Network[] access$100(ConnectivityManagerDelegate r10, Network r11) {
        return getAllNetworksFiltered(r10, r11);
    }

    static /* synthetic */ boolean access$1100(NetworkChangeNotifierAutoDetect r10) {
        return r10.mIgnoreNextBroadcast;
    }

    static /* synthetic */ boolean access$1102(NetworkChangeNotifierAutoDetect r10, boolean r11) {
        r10.mIgnoreNextBroadcast = r11;
        return r11;
    }

    static /* synthetic */ String access$200() {
        return TAG;
    }

    static /* synthetic */ boolean access$300(NetworkChangeNotifierAutoDetect r10) {
        return r10.mRegistered;
    }

    static /* synthetic */ void access$400(NetworkChangeNotifierAutoDetect r10) {
        r10.connectionTypeChanged();
    }

    static /* synthetic */ void access$500(NetworkChangeNotifierAutoDetect r10, NetworkState r11) {
        r10.connectionTypeChangedTo(r11);
    }

    static /* synthetic */ ConnectivityManagerDelegate access$600(NetworkChangeNotifierAutoDetect r10) {
        return r10.mConnectivityManagerDelegate;
    }

    static /* synthetic */ Observer access$700(NetworkChangeNotifierAutoDetect r10) {
        return r10.mObserver;
    }

    private void assertOnThread() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        if (onThread() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
    }

    private void connectionTypeChanged() {
        connectionTypeChangedTo(getCurrentNetworkState());
    }

    private void connectionTypeChangedTo(NetworkState r10) {
        if (r10.getConnectionType() == this.mNetworkState.getConnectionType()) goto L5;
    L12:
        this.mObserver.onConnectionTypeChanged(r10.getConnectionType());
    L14:
        if (r10.getConnectionType() == this.mNetworkState.getConnectionType()) goto L16;
    L17:
        this.mObserver.onConnectionSubtypeChanged(r10.getConnectionSubtype());
    L19:
        if (r10.getConnectionCost() == this.mNetworkState.getConnectionCost()) goto L21;
        this.mObserver.onConnectionCostChanged(r10.getConnectionCost());
    L21:
        this.mNetworkState = r10;
        return;
    L16:
        if (r10.getConnectionSubtype() == this.mNetworkState.getConnectionSubtype()) goto L19;
    L5:
        if (r10.getNetworkIdentifier().equals(this.mNetworkState.getNetworkIdentifier()) == false) goto L12;
        if (r10.getDnsServers().equals(this.mNetworkState.getDnsServers()) == false) goto L12;
        if (r10.isPrivateDnsActive() != this.mNetworkState.isPrivateDnsActive()) goto L12;
        if (r10.getPrivateDnsServerName().equals(this.mNetworkState.getPrivateDnsServerName()) == true) goto L14;
        goto L12
    }

    private static int convertToConnectionType(int r10, int r11) {
        if (r10 == 0) goto L21;
        if (r10 == 1) goto L18;
        if (r10 == 4) goto L21;
        if (r10 == 5) goto L21;
        if (r10 != 6) goto L11;
        return 5;
    L11:
        if (r10 != 7) goto L13;
        return 7;
    L13:
        if (r10 == 9) goto L15;
        return 0;
    L15:
        return 1;
    L18:
        return 2;
    L21:
        if (r11 == 20) goto L28;
        switch(r11) {
            case 1: goto L26;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L25;
            case 7: goto L26;
            case 8: goto L25;
            case 9: goto L25;
            case 10: goto L25;
            case 11: goto L26;
            case 12: goto L25;
            case 13: goto L24;
            case 14: goto L25;
            case 15: goto L25;
            default: goto L23;
        };
    L23:
        return 0;
    L24:
        return 5;
    L25:
        return 4;
    L26:
        return 3;
    L28:
        return 8;
    }

    private static Network[] getAllNetworksFiltered(ConnectivityManagerDelegate r10, Network r11) {
        Network[] r12 = r10.getAllNetworksUnfiltered();
        int r13 = r12.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L24;
        Network r16 = r12[r14];
        if (r16 == null) goto L22;
        if (r16.equals(r11) == true) goto L22;
        NetworkCapabilities r17 = r10.getNetworkCapabilities(r16);
        if (r17 == null) goto L22;
        if (r17.hasCapability(12) == false) goto L22;
        if (r17.hasTransport(4) == true) goto L18;
        r12[r15] = r16;
        r15 = r15 + 1;
        goto L22
    L18:
        if (r10.vpnAccessible(r16) == false) goto L22;
        return new Network[]{r16};
    L22:
        r14 = r14 + 1;
        goto L3
    L24:
        return (Network[]) Arrays.copyOf(r12, r15);
    }

    private /* synthetic */ void lambda$runOnThread$0(Runnable r10) {
        if (this.mRegistered == false) goto L6;
        r10.run();
        return;
    }

    public static long networkToNetId(Network r10) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return ApiHelperForM.getNetworkHandle(r10);
    L7:
        return Integer.parseInt(r10.toString());
    }

    private boolean onThread() {
        if (this.mLooper != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
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
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return -1;
    L5:
        Network r10 = this.mConnectivityManagerDelegate.getDefaultNetwork();
        if (r10 != null) goto L9;
        return -1;
    L9:
        return networkToNetId(r10);
    }

    public long[] getNetworksAndTypes() {
        int r10 = 0;
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Network[] r11 = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
        long[] r12 = new long[r11.length * 2];
        int r13 = r11.length;
        int r14 = 0;
    L7:
        if (r10 >= r13) goto L9;
        Network r15 = r11[r10];
        int r16 = r14 + 1;
        r12[r14] = networkToNetId(r15);
        r14 = r16 + 1;
        r12[r16] = this.mConnectivityManagerDelegate.getConnectionType(r15);
        r10 = r10 + 1;
        goto L7
    L9:
        return r12;
    L5:
        return new long[0];
    }

    @VisibleForTesting
    RegistrationPolicy getRegistrationPolicy() {
        return this.mRegistrationPolicy;
    }

    public long getVpnNetId() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return -1;
    L5:
        MyNetworkCallback r10 = this.mNetworkCallback;
        if (r10 != null) goto L9;
        return -1;
    L9:
        return r10.getVpnNetId();
    }

    @VisibleForTesting
    boolean isReceiverRegisteredForTesting() {
        return this.mRegistered;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        runOnThread(new AnonymousClass1(this));
    }

    public void register() {
        assertOnThread();
        if (this.mRegistered == false) goto L7;
        connectionTypeChanged();
        return;
    L7:
        if (this.mShouldSignalObserver == false) goto L9;
        connectionTypeChanged();
    L9:
        ConnectivityManager.NetworkCallback r10 = this.mDefaultNetworkCallback;
        if (r10 != null) goto L41;
    L14:
        int r11 = 0;
        if (this.mDefaultNetworkCallback == null) goto L43;
    L23:
        this.mRegistered = true;
        MyNetworkCallback r12 = this.mNetworkCallback;
        if (r12 == null) goto L46;
        r12.initializeVpnInPlace();
        this.mConnectivityManagerDelegate.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback, this.mHandler);     // Catch: RuntimeException -> L28
    L30:
        if (this.mRegisterNetworkCallbackFailed == false) goto L32;
        return;
    L32:
        if (this.mShouldSignalObserver == false) goto L48;
        Network[] r13 = getAllNetworksFiltered(this.mConnectivityManagerDelegate, null);
        long[] r14 = new long[r13.length];
    L35:
        if (r11 >= r13.length) goto L37;
        r14[r11] = networkToNetId(r13[r11]);
        r11 = r11 + 1;
        goto L35
    L37:
        this.mObserver.purgeActiveNetworkList(r14);
        return;
    L48:
        return;
    L28:
        this.mRegisterNetworkCallbackFailed = true;
        this.mNetworkCallback = null;
        goto L30
    L46:
        return;
    L43:
    L22:
        this.mIgnoreNextBroadcast = false;
        goto L23
    L17:
        if (ContextUtils.getApplicationContext().registerReceiver(this, this.mIntentFilter) == null) goto L19;
        boolean r15 = true;
    L20:
        this.mIgnoreNextBroadcast = r15;     // Catch: RuntimeException -> L22
        goto L23
    L19:
        r15 = false;
        goto L20
    L41:
        this.mConnectivityManagerDelegate.registerDefaultNetworkCallback(r10, this.mHandler);     // Catch: RuntimeException -> L13
    L13:
        this.mDefaultNetworkCallback = null;
        goto L14
    }

    public boolean registerNetworkCallbackFailed() {
        return this.mRegisterNetworkCallbackFailed;
    }

    public void runOnThread(final Runnable r10) {
        if (onThread() == false) goto L5;
        r10.run();
        return;
    L5:
        this.mHandler.post(new a(this, r10));
    }

    void setConnectivityManagerDelegateForTests(ConnectivityManagerDelegate r10) {
        this.mConnectivityManagerDelegate = r10;
    }

    void setWifiManagerDelegateForTests(WifiManagerDelegate r10) {
        this.mWifiManagerDelegate = r10;
    }

    public void unregister() {
        assertOnThread();
        if (this.mRegistered == true) goto L5;
        return;
    L5:
        this.mRegistered = false;
        MyNetworkCallback r10 = this.mNetworkCallback;
        if (r10 == null) goto L8;
        this.mConnectivityManagerDelegate.unregisterNetworkCallback(r10);
    L8:
        ConnectivityManager.NetworkCallback r11 = this.mDefaultNetworkCallback;
        if (r11 == null) goto L11;
        this.mConnectivityManagerDelegate.unregisterNetworkCallback(r11);
        return;
    L11:
        ContextUtils.getApplicationContext().unregisterReceiver(this);
    }
}
