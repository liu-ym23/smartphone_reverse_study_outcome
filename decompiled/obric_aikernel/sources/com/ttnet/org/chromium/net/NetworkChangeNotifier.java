package com.ttnet.org.chromium.net;

import android.annotation.SuppressLint;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.ObserverList;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.build.BuildConfig;
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
    private int mCurrentConnectionCost;
    private int mCurrentConnectionType;
    private final ArrayList<Long> mNativeChangeNotifiers;

    public interface ConnectionTypeObserver {
        void onConnectionTypeChanged(int r10);
    }

    interface Natives {
        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyConnectionCostChanged(long r10, NetworkChangeNotifier r11, int r12);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyConnectionTypeChanged(long r10, NetworkChangeNotifier r11, int r12, long r13);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyMaxBandwidthChanged(long r10, NetworkChangeNotifier r11, int r12);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyOfNetworkConnect(long r10, NetworkChangeNotifier r11, long r12, boolean r13, int r14);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyOfNetworkDisconnect(long r10, NetworkChangeNotifier r11, boolean r12, long r13);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyOfNetworkSoonToDisconnect(long r10, NetworkChangeNotifier r11, long r12);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyPurgeActiveNetworkList(long r10, NetworkChangeNotifier r11, long[] r12);
    }

    static {
    }

    @VisibleForTesting
    protected NetworkChangeNotifier() {
        this.mCurrentConnectionType = 0;
        this.mCurrentConnectionCost = 0;
        this.mNativeChangeNotifiers = new ArrayList();
        this.mConnectionTypeObservers = new ObserverList();
    }

    static /* synthetic */ void access$000(NetworkChangeNotifier r10, int r11) {
        r10.updateCurrentConnectionType(r11);
    }

    static /* synthetic */ int access$100(NetworkChangeNotifier r10) {
        return r10.mCurrentConnectionType;
    }

    public static void addConnectionTypeObserver(ConnectionTypeObserver r10) {
        getInstance().addConnectionTypeObserverInternal(r10);
    }

    private void addConnectionTypeObserverInternal(ConnectionTypeObserver r10) {
        this.mConnectionTypeObservers.addObserver(r10);
    }

    private void destroyAutoDetector() {
        NetworkChangeNotifierAutoDetect r10 = this.mAutoDetector;
        if (r10 == null) goto L6;
        r10.destroy();
        this.mAutoDetector = null;
        return;
    }

    @CalledByNative
    @VisibleForTesting
    public static void fakeConnectionCostChanged(int r10) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionCostChange(r10);
    }

    @CalledByNative
    public static void fakeConnectionSubtypeChanged(int r10) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionSubtypeChange(r10);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(long r10, int r11) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfConnectionTypeChange(r11, r10);
    }

    @CalledByNative
    public static void fakeNetworkConnected(long r10, int r11) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkConnect(r10, r11, false);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(long r10) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkDisconnect(r10, false);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(long r10) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversOfNetworkSoonToDisconnect(r10);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(long[] r10) {
        setAutoDetectConnectivityState(false);
        getInstance().notifyObserversToPurgeActiveNetworkList(r10);
    }

    @CalledByNative
    public static void forceConnectivityState(boolean r10) {
        setAutoDetectConnectivityState(false);
        getInstance().forceConnectivityStateInternal(r10);
    }

    private void forceConnectivityStateInternal(boolean r10) {
        int r11 = 0;
        if (this.mCurrentConnectionType == 6) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == r10) goto L12;
        if (r10 == true) goto L10;
        r11 = 6;
    L10:
        updateCurrentConnectionType(r11);
        notifyObserversOfConnectionSubtypeChange(!r10 ? 1 : 0);
        return;
    L12:
        return;
    L5:
        r12 = false;
        goto L6
    }

    private void forceUpdateNetworkType() {
        NetworkChangeNotifierAutoDetect r10 = this.mAutoDetector;
        if (r10 == null) goto L8;
        NetworkChangeNotifierAutoDetect.NetworkState r11 = r10.getCurrentNetworkState();
        if (this.mCurrentConnectionType == r11.getConnectionType()) goto L9;
        this.mCurrentConnectionType = r11.getConnectionType();
        this.mAutoDetector.runOnThread(new AnonymousClass2(this));
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

    private void notifyObserversOfConnectionTypeChange(int r10, long r11) {
        Iterator<Long> r12 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Long r13 = r12.next();
        NetworkChangeNotifierJni.get().notifyConnectionTypeChanged(r13.longValue(), this, r10, r11);
        goto L4
    L6:
        Iterator<ConnectionTypeObserver> r14 = this.mConnectionTypeObservers.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r14.next().onConnectionTypeChanged(r10);
        goto L8
    }

    public static void registerToReceiveNotificationsAlways() {
        getInstance().setAutoDetectConnectivityStateInternal(true, new RegistrationPolicyAlwaysRegister());
    }

    public static void removeConnectionTypeObserver(ConnectionTypeObserver r10) {
        getInstance().removeConnectionTypeObserverInternal(r10);
    }

    private void removeConnectionTypeObserverInternal(ConnectionTypeObserver r10) {
        this.mConnectionTypeObservers.removeObserver(r10);
    }

    @VisibleForTesting
    public static void resetInstanceForTests(NetworkChangeNotifier r10) {
        sInstance = r10;
    }

    public static void setAutoDetectConnectivityState(NetworkChangeNotifierAutoDetect.RegistrationPolicy r10) {
        getInstance().setAutoDetectConnectivityStateInternal(true, r10);
    }

    @CalledByNative
    public static void setAutoDetectConnectivityState(boolean r10) {
        getInstance().setAutoDetectConnectivityStateInternal(r10, new RegistrationPolicyApplicationStatus());
    }

    private void setAutoDetectConnectivityStateInternal(boolean r10, NetworkChangeNotifierAutoDetect.RegistrationPolicy r11) {
        if (r10 == true) goto L4;
        destroyAutoDetector();
        return;
    L4:
        if (this.mAutoDetector != null) goto L8;
        NetworkChangeNotifierAutoDetect r12 = new NetworkChangeNotifierAutoDetect(new AnonymousClass1(this), r11);
        this.mAutoDetector = r12;
        NetworkChangeNotifierAutoDetect.NetworkState r13 = r12.getCurrentNetworkState();
        updateCurrentConnectionType(r13.getConnectionType());
        updateCurrentConnectionCost(r13.getConnectionCost());
        notifyObserversOfConnectionSubtypeChange(r13.getConnectionSubtype());
        return;
    }

    private void updateCurrentConnectionCost(int r10) {
        this.mCurrentConnectionCost = r10;
        notifyObserversOfConnectionCostChange(r10);
    }

    private void updateCurrentConnectionType(int r10) {
        this.mCurrentConnectionType = r10;
        notifyObserversOfConnectionTypeChange(r10);
    }

    @CalledByNative
    public void addNativeObserver(long r10) {
        this.mNativeChangeNotifiers.add(Long.valueOf(r10));
    }

    @CalledByNative
    public int getCurrentConnectionCost() {
        return this.mCurrentConnectionCost;
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        NetworkChangeNotifierAutoDetect r10 = this.mAutoDetector;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.getCurrentNetworkState().getConnectionSubtype();
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.mCurrentConnectionType;
    }

    @CalledByNative
    public long getCurrentDefaultNetId() {
        NetworkChangeNotifierAutoDetect r10 = this.mAutoDetector;
        if (r10 != null) goto L6;
        return -1;
    L6:
        return r10.getDefaultNetId();
    }

    @CalledByNative
    public long[] getCurrentNetworksAndTypes() {
        NetworkChangeNotifierAutoDetect r10 = this.mAutoDetector;
        if (r10 != null) goto L6;
        return new long[0];
    L6:
        return r10.getNetworksAndTypes();
    }

    @CalledByNative
    public long getCurrentVpnNetId() {
        NetworkChangeNotifierAutoDetect r10 = this.mAutoDetector;
        if (r10 != null) goto L6;
        return -1;
    L6:
        return r10.getVpnNetId();
    }

    public void mockConnectionTypeChangeForTesting(int r10, long r11) {
        if (BuildConfig.DCHECK_IS_ON == false) goto L6;
        notifyObserversOfConnectionTypeChange(r10, r11);
        return;
    }

    void notifyObserversOfConnectionCostChange(int r10) {
        Iterator<Long> r11 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Long r12 = r11.next();
        NetworkChangeNotifierJni.get().notifyConnectionCostChanged(r12.longValue(), this, r10);
        goto L4
    }

    void notifyObserversOfConnectionSubtypeChange(int r10) {
        Iterator<Long> r11 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Long r12 = r11.next();
        NetworkChangeNotifierJni.get().notifyMaxBandwidthChanged(r12.longValue(), this, r10);
        goto L4
    }

    void notifyObserversOfConnectionTypeChange(int r10) {
        notifyObserversOfConnectionTypeChange(r10, getCurrentDefaultNetId());
    }

    void notifyObserversOfNetworkConnect(long r11, int r13, boolean r14) {
        Iterator<Long> r10 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Long r12 = r10.next();
        NetworkChangeNotifierJni.get().notifyOfNetworkConnect(r12.longValue(), this, r11, r14, r13);
        goto L4
    }

    void notifyObserversOfNetworkDisconnect(long r10, boolean r12) {
        Iterator<Long> r11 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Long r13 = r11.next();
        NetworkChangeNotifierJni.get().notifyOfNetworkDisconnect(r13.longValue(), this, r12, r10);
        goto L4
    }

    void notifyObserversOfNetworkSoonToDisconnect(long r10) {
        Iterator<Long> r11 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Long r12 = r11.next();
        NetworkChangeNotifierJni.get().notifyOfNetworkSoonToDisconnect(r12.longValue(), this, r10);
        goto L4
    }

    void notifyObserversToPurgeActiveNetworkList(long[] r10) {
        Iterator<Long> r11 = this.mNativeChangeNotifiers.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Long r12 = r11.next();
        NetworkChangeNotifierJni.get().notifyPurgeActiveNetworkList(r12.longValue(), this, r10);
        goto L4
    }

    @CalledByNative
    public boolean registerNetworkCallbackFailed() {
        NetworkChangeNotifierAutoDetect r10 = this.mAutoDetector;
        if (r10 != null) goto L6;
        return false;
    L6:
        return r10.registerNetworkCallbackFailed();
    }

    @CalledByNative
    public void removeNativeObserver(long r10) {
        this.mNativeChangeNotifiers.remove(Long.valueOf(r10));
    }
}
