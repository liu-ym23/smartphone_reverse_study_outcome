package com.obric.cae.location.city;

import android.content.Context;
import android.location.Address;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.obric.cae.libs.location.IStarLocationCityCallback;
import com.obric.cae.location.database.StarLocationDbManager;
import com.obric.cae.location.geosdk.poi.StarAoiBoardManager;
import com.obric.cae.log.CommSenseLog;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class StarCityManager {
    private static final String TAG = "StarLocation-city";
    private static volatile StarCityManager sInstance;
    private final Context mAppContext;
    private final ConcurrentHashMap<Integer, CityCallbackRecord> mCityCallbackMap;
    private final AtomicLong mLastAddressResolvedTime;

    public static final class CityCallbackRecord {
        final IStarLocationCityCallback callback;
        final IBinder.DeathRecipient deathRecipient;
        volatile String lastAdminArea;
        volatile String lastLocality;
        volatile String lastSubAdminArea;
        volatile String lastSubLocality;
        final int level;

        public CityCallbackRecord(int r8, IStarLocationCityCallback r10, IBinder.DeathRecipient r11) {
            this.level = r8;
            this.callback = r10;
            this.deathRecipient = r11;
        }
    }

    private StarCityManager(Context r8) {
        this.mCityCallbackMap = new ConcurrentHashMap();
        this.mLastAddressResolvedTime = new AtomicLong(0);
        this.mAppContext = r8.getApplicationContext();
    }

    public static /* synthetic */ void a(StarCityManager r8, int r10) {
        r8.lambda$registerCityCallback$0(r10);
    }

    private static Address buildAddressFromCityInfo(StarLocationDbManager.CityInfo r8) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r8.adminArea) == true) goto L6;
    L12:
        Address r10 = new Address(Locale.getDefault());
        r10.setAdminArea(r8.adminArea);
        r10.setSubAdminArea(r8.subAdminArea);
        r10.setLocality(r8.locality);
        r10.setSubLocality(r8.subLocality);
        return r10;
    L6:
        if (TextUtils.isEmpty(r8.subAdminArea) == false) goto L12;
        if (TextUtils.isEmpty(r8.locality) == false) goto L12;
        if (TextUtils.isEmpty(r8.subLocality) == false) goto L12;
        return null;
    }

    private static boolean equalsNullable(String r8, String r10) {
        if (r8 != null) goto L8;
        if (r10 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return r8.equals(r10);
    }

    public static synchronized StarCityManager getInstance(Context r8) {
        monitor-enter(StarCityManager.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new StarCityManager(r8);     // Catch: Throwable -> L10
    L7:
        StarCityManager r10 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(StarCityManager.class);
        return r10;
    }

    private /* synthetic */ void lambda$registerCityCallback$0(int r8) {
        this.mCityCallbackMap.remove(Integer.valueOf(r8));
    }

    private void notifyCityIfNeeded(int r8, CityCallbackRecord r10, Address r11, String r12, String r13, String r14, String r15) {
        monitor-enter(r10);
        boolean r16 = shouldNotifyByLevel(r10.level, r10, r12, r13, r14, r15);     // Catch: Throwable -> L17
        if (r16 == false) goto L7;
        r10.lastAdminArea = r12;     // Catch: Throwable -> L17
        r10.lastSubAdminArea = r13;     // Catch: Throwable -> L17
        r10.lastLocality = r14;     // Catch: Throwable -> L17
        r10.lastSubLocality = r15;     // Catch: Throwable -> L17
    L7:
        monitor-exit(r10);     // Catch: Throwable -> L17
        if (r16 == true) goto L25;
        return;
    L25:
        r10.callback.onCityChanged(r11);     // Catch: Throwable -> L12 RemoteException -> L14
        CommSenseLog.dWithMethodName(TAG, "notifyCityChanged: pid=" + r8 + ", address=" + r11);     // Catch: Throwable -> L12 RemoteException -> L14
    L28:
        return;
    L14:
        this.mCityCallbackMap.remove(Integer.valueOf(r8));
        r10.callback.asBinder().unlinkToDeath(r10.deathRecipient, 0);     // Catch: Throwable -> L20
        return;
    L29:
        return;
    L12:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "failed for pid=" + r8, th);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    private void notifyCurrentCity(CityCallbackRecord r10, int r11) {
        Address r8 = buildAddressFromCityInfo(StarLocationDbManager.getInstance(this.mAppContext, 0).getCityInfo());
        if (r8 != null) goto L6;
        CommSenseLog.dWithMethodName(TAG, "skip current city notify for pid=" + r11 + ": no cached city");
        return;
    L6:
        notifyCityIfNeeded(r11, r10, r8, r8.getAdminArea(), r8.getSubAdminArea(), r8.getLocality(), r8.getSubLocality());
    }

    private static boolean shouldNotifyByLevel(int r8, CityCallbackRecord r10, String r11, String r12, String r13, String r14) {
        if (r8 == 1) goto L15;
        if (r8 == 2) goto L13;
        if (r8 == 3) goto L11;
        return !equalsNullable(r10.lastSubLocality, r14);
    L11:
        return !equalsNullable(r10.lastLocality, r13);
    L13:
        return !equalsNullable(r10.lastSubAdminArea, r12);
    L15:
        return !equalsNullable(r10.lastAdminArea, r11);
    }

    public void destroy() {
        TrafficGeoManager.getInstance(this.mAppContext).destroy();
        MallGeoManager.getInstance(this.mAppContext).destroy();
    }

    public Address getCurCityInfo() {
        return buildAddressFromCityInfo(StarLocationDbManager.getInstance(this.mAppContext, 0).getCityInfo());
    }

    public void notifyCityChanged(Address r14) {
        if (r14 != null) goto L4;
        return;
    L4:
        String r8 = r14.getAdminArea();
        String r10 = r14.getSubAdminArea();
        String r11 = r14.getLocality();
        String r12 = r14.getSubLocality();
        Iterator<Map.Entry<Integer, CityCallbackRecord>> r13 = this.mCityCallbackMap.entrySet().iterator();
    L6:
        if (r13.hasNext() == false) goto L14;
        Map.Entry<Integer, CityCallbackRecord> r15 = r13.next();
        Integer r16 = r15.getKey();
        CityCallbackRecord r17 = r15.getValue();
        if (r16 == null) goto L6;
        if (r17 == null) goto L6;
        if (r17.callback == null) goto L6;
        notifyCityIfNeeded(r16.intValue(), r17, r14, r8, r10, r11, r12);
        goto L6
    }

    public void onAddressResolved(Address r10, long r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r8 = r10.getAdminArea();
        String r12 = r10.getSubAdminArea();
        String r13 = r10.getLocality();
        String r14 = r10.getSubLocality();
        if (TextUtils.isEmpty(r8) == false) goto L42;
        if (TextUtils.isEmpty(r12) == false) goto L42;
        if (TextUtils.isEmpty(r13) == false) goto L42;
        if (TextUtils.isEmpty(r14) == false) goto L42;
        CommSenseLog.dWithMethodName(TAG, "skip: city fields are empty");
        return;
    L42:
        StarLocationDbManager.CityStorageSwitchResult r15 = StarLocationDbManager.getInstance(this.mAppContext, 0).switchCityStorageForResolvedAddress(r8, r12, r13, r14, r11);     // Catch: Throwable -> L37
        if (r15.success == true) goto L21;
        CommSenseLog.eWithMethodName(TAG, "switch city storage returned failed");
        return;
    L21:
        if (r15.cityChanged == true) goto L23;
    L29:
        MallGeoManager.getInstance(this.mAppContext).onAddressResolved(r10);
        long r16 = this.mLastAddressResolvedTime.getAndSet(r11);
        if (r15.cityChanged == false) goto L32;
    L35:
        notifyCityChanged(r10);
        TrafficGeoManager.getInstance(this.mAppContext).onAddressResolved(r10);
        return;
    L32:
        if ((r11 - r16) >= 5000) goto L35;
        CommSenseLog.vWithMethodName(TAG, "debounce: skip due to consecutive calls within 5s");
        return;
    L23:
        if (TextUtils.isEmpty(r15.targetCityKey) == true) goto L29;
        StarAoiBoardManager.getInstance(this.mAppContext, 0).reloadAoiBoardsFromDbAfterCitySwitch();     // Catch: Throwable -> L26
        MallGeoManager.getInstance(this.mAppContext).onCityStorageChanged(r15.targetCityKey, r15.restoredFromArchive);
        TrafficGeoManager.getInstance(this.mAppContext).onCityStorageChanged(r15.targetCityKey, r15.restoredFromArchive);
    L26:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "reload aoi boards after city switch failed", th);
        return;
    L37:
        th = move-exception;
        CommSenseLog.eWithMethodName(TAG, "switch city storage failed", th);
    }

    public void onServiceStarted() {
        TrafficGeoManager.getInstance(this.mAppContext).onServiceStarted();
        MallGeoManager.getInstance(this.mAppContext).onServiceStarted();
    }

    public void registerCityCallback(final int r8, int r10, IStarLocationCityCallback r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        IBinder r12 = r11.asBinder();
        CityCallbackRecord r13 = this.mCityCallbackMap.remove(Integer.valueOf(r8));
        if (r13 != null) goto L14;
    L7:
        IBinder.DeathRecipient r14 = new d(this, r8);
        r12.linkToDeath(r14, 0);     // Catch: RemoteException -> L10
        CityCallbackRecord r15 = new CityCallbackRecord(r10, r11, r14);     // Catch: RemoteException -> L10
        this.mCityCallbackMap.put(Integer.valueOf(r8), r15);     // Catch: RemoteException -> L10
        notifyCurrentCity(r15, r8);     // Catch: RemoteException -> L10
        return;
    L10:
        e = move-exception;
        CommSenseLog.eWithMethodName(TAG, "registerCityCallback linkToDeath failed: " + e.getMessage());
        return;
    L14:
        r13.callback.asBinder().unlinkToDeath(r13.deathRecipient, 0);     // Catch: Throwable -> L13
        goto L7
    }

    public void unregisterCityCallback(int r8) {
        CityCallbackRecord r10 = this.mCityCallbackMap.remove(Integer.valueOf(r8));
        if (r10 == null) goto L9;
        r10.callback.asBinder().unlinkToDeath(r10.deathRecipient, 0);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }
}
