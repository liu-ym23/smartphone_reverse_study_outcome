package com.ttnet.org.chromium.net;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.ObserverList;
import com.ttnet.org.chromium.base.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.base.compat.ApiHelperForM;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("net")
public class NetworkChangeNotifier {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @SuppressLint({"StaticFieldLeak"})
    private static NetworkChangeNotifier sInstance;
    private NetworkChangeNotifierAutoDetect mAutoDetector;
    private final ObserverList<ConnectionTypeObserver> mConnectionTypeObservers;
    private final ConnectivityManager mConnectivityManager;
    private int mCurrentConnectionType;
    private final ArrayList<Long> mNativeChangeNotifiers;

    public interface ConnectionTypeObserver {
        void onConnectionTypeChanged(int r8);
    }

    @VisibleForTesting
    public NetworkChangeNotifier() {
        this.mCurrentConnectionType = 0;
        this.mNativeChangeNotifiers = new ArrayList();
        this.mConnectionTypeObservers = new ObserverList();
        this.mConnectivityManager = (ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity");
    }

    public static /* synthetic */ void access$000(NetworkChangeNotifier r8, int r10) {
        r8.updateCurrentConnectionType(r10);
    }

    public static void addConnectionTypeObserver(ConnectionTypeObserver r8) {
        getInstance().addConnectionTypeObserverInternal(r8);
    }

    private void addConnectionTypeObserverInternal(ConnectionTypeObserver r8) {
        this.mConnectionTypeObservers.addObserver(r8);
    }

    private void destroyAutoDetector() {
        NetworkChangeNotifierAutoDetect r8 = this.mAutoDetector;
        if (r8 == null) goto L6;
        r8.destroy();
        this.mAutoDetector = null;
        return;
    }

    @CalledByNative
    public static void fakeConnectionSubtypeChanged(int r8) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionSubtypeChange(r8);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(long r8, int r10) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionTypeChange(r10, r8);
    }

    @CalledByNative
    public static void fakeNetworkConnected(long r8, int r10) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkConnect(r8, r10);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(long r8) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkDisconnect(r8);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(long r8) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkSoonToDisconnect(r8);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(long[] r8) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversToPurgeActiveNetworkList(r8);
    }

    @CalledByNative
    public static void forceConnectivityState(boolean r8) {
        setAutoDetectConnectivityState(false);
        getInstance().forceConnectivityStateInternal(r8);
    }

    private void forceConnectivityStateInternal(boolean r8) {
        int r10 = 0;
        if (this.mCurrentConnectionType == 6) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == r8) goto L12;
        if (r8 == true) goto L10;
        r10 = 6;
    L10:
        updateCurrentConnectionType(r10);
        notifyObserversOfConnectionSubtypeChange(!r8 ? 1 : 0);
        return;
    L12:
        return;
    L5:
        r11 = false;
        goto L6
    }

    private void forceUpdateNetworkType() {
        NetworkChangeNotifierAutoDetect r8 = this.mAutoDetector;
        if (r8 == null) goto L8;
        NetworkChangeNotifierAutoDetect.NetworkState r10 = r8.getCurrentNetworkState();
        if (this.mCurrentConnectionType == r10.getConnectionType()) goto L9;
        int r11 = r10.getConnectionType();
        this.mCurrentConnectionType = r11;
        notifyObserversOfConnectionTypeChange(r11);
        return;
    L9:
        return;
    }

    @CalledByNative
    public static void forceUpdateNetworkTypeInfo() {
        getInstance().forceUpdateNetworkType();
    }

    public static NetworkChangeNotifierAutoDetect getAutoDetectorForTest() {
        return getInstance().mAutoDetector;
    }

    public static NetworkChangeNotifier getInstance() {
        return sInstance;
    }

    @CalledByNative
    public static NetworkChangeNotifier init() {
        if (sInstance != null) goto L6;
        sInstance = new NetworkChangeNotifier();
    L6:
        return sInstance;
    }

    public static boolean isInitialized() {
        if (sInstance == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isOnline() {
        if (getInstance().getCurrentConnectionType() == 6) goto L5;
        return true;
    L5:
        return false;
    }

    @CalledByNative
    public static boolean isProcessBoundToNetwork() {
        return getInstance().isProcessBoundToNetworkInternal();
    }

    private boolean isProcessBoundToNetworkInternal() {
        if (ApiHelperForM.getBoundNetworkForProcess(this.mConnectivityManager) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyConnectionTypeChanged(long r8, int r10, long r11);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyMaxBandwidthChanged(long r8, int r10);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyOfNetworkConnect(long r8, long r10, int r11);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyOfNetworkDisconnect(long r8, long r10);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyOfNetworkSoonToDisconnect(long r8, long r10);

    @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
    private native void nativeNotifyPurgeActiveNetworkList(long r8, long[] r10);

    public static void registerToReceiveNotificationsAlways() {
        getInstance().setAutoDetectConnectivityStateInternal(true, new RegistrationPolicyAlwaysRegister());
    }

    public static void removeConnectionTypeObserver(ConnectionTypeObserver r8) {
        getInstance().removeConnectionTypeObserverInternal(r8);
    }

    private void removeConnectionTypeObserverInternal(ConnectionTypeObserver r8) {
        this.mConnectionTypeObservers.removeObserver(r8);
    }

    public static void resetInstanceForTests(NetworkChangeNotifier r8) {
        sInstance = r8;
    }

    public static void setAutoDetectConnectivityState(NetworkChangeNotifierAutoDetect.RegistrationPolicy r8) {
        getInstance().setAutoDetectConnectivityStateInternal(true, r8);
    }

    private void setAutoDetectConnectivityStateInternal(boolean r8, NetworkChangeNotifierAutoDetect.RegistrationPolicy r10) {
        if (r8 == true) goto L4;
        destroyAutoDetector();
        return;
    L4:
        if (this.mAutoDetector != null) goto L8;
        NetworkChangeNotifierAutoDetect r11 = new NetworkChangeNotifierAutoDetect(new AnonymousClass1(this), r10);
        this.mAutoDetector = r11;
        NetworkChangeNotifierAutoDetect.NetworkState r12 = r11.getCurrentNetworkState();
        updateCurrentConnectionType(r12.getConnectionType());
        notifyObserversOfConnectionSubtypeChange(r12.getConnectionSubtype());
        return;
    }

    private void updateCurrentConnectionType(int r8) {
        this.mCurrentConnectionType = r8;
        notifyObserversOfConnectionTypeChange(r8);
    }

    @CalledByNative
    public void addNativeObserver(long r8) {
        this.mNativeChangeNotifiers.add(Long.valueOf(r8));
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        NetworkChangeNotifierAutoDetect r8 = this.mAutoDetector;
        if (r8 != null) goto L6;
        return 0;
    L6:
        return r8.getCurrentNetworkState().getConnectionSubtype();
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.mCurrentConnectionType;
    }

    @CalledByNative
    public long getCurrentDefaultNetId() {
        NetworkChangeNotifierAutoDetect r8 = this.mAutoDetector;
        if (r8 != null) goto L6;
        return -1;
    L6:
        return r8.getDefaultNetId();
    }

    @CalledByNative
    public long[] getCurrentNetworksAndTypes() {
        NetworkChangeNotifierAutoDetect r8 = this.mAutoDetector;
        if (r8 != null) goto L6;
        return new long[0];
    L6:
        return r8.getNetworksAndTypes();
    }

    public void notifyObserversOfConnectionSubtypeChange(int r8) {
        Iterator<Long> r10 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        nativeNotifyMaxBandwidthChanged(r10.next().longValue(), r8);
        goto L4
    }

    public void notifyObserversOfConnectionTypeChange(int r8) {
        notifyObserversOfConnectionTypeChange(r8, getCurrentDefaultNetId());
    }

    public void notifyObserversOfNetworkConnect(long r10, int r11) {
        Iterator<Long> r8 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        nativeNotifyOfNetworkConnect(r8.next().longValue(), r10, r11);
        goto L4
    }

    public void notifyObserversOfNetworkDisconnect(long r8) {
        Iterator<Long> r10 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        nativeNotifyOfNetworkDisconnect(r10.next().longValue(), r8);
        goto L4
    }

    public void notifyObserversOfNetworkSoonToDisconnect(long r8) {
        Iterator<Long> r10 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        nativeNotifyOfNetworkSoonToDisconnect(r10.next().longValue(), r8);
        goto L4
    }

    public void notifyObserversToPurgeActiveNetworkList(long[] r8) {
        Iterator<Long> r10 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        nativeNotifyPurgeActiveNetworkList(r10.next().longValue(), r8);
        goto L4
    }

    @CalledByNative
    public boolean registerNetworkCallbackFailed() {
        NetworkChangeNotifierAutoDetect r8 = this.mAutoDetector;
        if (r8 != null) goto L6;
        return false;
    L6:
        return r8.registerNetworkCallbackFailed();
    }

    @CalledByNative
    public void removeNativeObserver(long r8) {
        this.mNativeChangeNotifiers.remove(Long.valueOf(r8));
    }

    private void notifyObserversOfConnectionTypeChange(int r10, long r11) {
        Iterator<Long> r8 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        nativeNotifyConnectionTypeChanged(r8.next().longValue(), r10, r11);
        goto L4
    L6:
        Iterator<ConnectionTypeObserver> r12 = this.mConnectionTypeObservers.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r12.next().onConnectionTypeChanged(r10);
        goto L8
    }

    public static void setAutoDetectConnectivityState(boolean r8) {
        getInstance().setAutoDetectConnectivityStateInternal(r8, new RegistrationPolicyApplicationStatus());
    }
}
