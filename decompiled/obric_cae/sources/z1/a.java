package z1;

import android.content.Context;
import android.location.LocationManager;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.obric.cae.cloud.CloudServiceConstants;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f14172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a2.b f14173b;

    public a(Context r8) {
        this.f14173b = new a2.b(r8);
    }

    public final void a() {
        Logger.i("ByteLocationClient: startLocation() is executed.");
        a2.b r8 = this.f14173b;
        b r12 = this.f14172a;
        if (PermissionManager.hasLocationPermissions(r8.f29a) == true) goto L5;
        Logger.i("ByteLocationManagerImpl: startLocation() but has no location permission!");
        BDLocationException r13 = new BDLocationException("No Location Permission", LocationInfoConst.BYTE, BDLocationException.ERROR_SDK_NO_PERMISSION);
    L17:
        r8.f30b.d(r13);
        return;
    L5:
        Context r10 = r8.f29a;
        b.a r11 = r12.f14178e;
        if (LocationUtil.isEnableLocationService(r10) == true) goto L12;
        int r14 = r11.ordinal();
        if (r14 == 0) goto L13;
        if (r14 == 1) goto L13;
        if (r14 != 2) goto L12;
    L13:
        boolean r15 = true;
    L15:
        if (r15 == false) goto L18;
        Logger.i("ByteLocationManagerImpl: startLocation() but need GPS location service!");
        r13 = new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", LocationInfoConst.BYTE, BDLocationException.ERROR_DEVICE_LOCATION_DISABLE);
        goto L17
    L18:
        r8.f33e = r12;
        StringBuilder r16 = new StringBuilder("ByteLocationManagerImpl: startLocation() and locationMode:");
        r16.append(r12.f14178e);
        r16.append("geocodeMode:");
        int r17 = r12.f14177d;
        if (r17 == 0) goto L23;
        if (r17 == 1) goto L22;
        String r18 = android.aimedia.a.h(new StringBuilder(), r12.f14177d, "");
    L24:
        r16.append(r18);
        r16.append("intervalMs:");
        r16.append(r12.f14174a);
        Logger.i(r16.toString());
        int r19 = r12.f14178e.ordinal();
        if (r19 == 0) goto L47;
        if (r19 == 1) goto L31;
        if (r19 != 2) goto L58;
        r12.f14176c = 1;
        a2.b.b(r12, new a2.b.f(r8, r12));
        return;
    L58:
        return;
    L31:
        if (PermissionManager.hasAnyPermission(r8.f29a, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L34;
        Logger.i("ByteLocationManagerImpl: startLocationInternalForDeviceSensors() but has no location permission!");
        BDLocationException r110 = new BDLocationException("No Location Permission", LocationInfoConst.BYTE, BDLocationException.ERROR_SDK_NO_PERMISSION);
    L36:
        r8.f30b.d(r110);
        return;
    L34:
        if (LocationUtil.isGpsProviderEnabled(r8.f29a) == true) goto L37;
        Logger.i("ByteLocationManagerImpl: startLocationInternalForDeviceSensors() but need GPS location service!");
        r110 = new BDLocationException("定位服务没有开启，请在设置中打开定位服务开关", LocationInfoConst.BYTE, BDLocationException.ERROR_DEVICE_LOCATION_DISABLE);
        goto L36
    L37:
        r12.f14176c = 2;
        r8.f31c = (LocationManager) r8.f29a.getSystemService(LocationMonitorConst.LOCATION);
        r8.f35g = new a2.b.d(r8, r12.f14185l);
        BDLocationExtrasService.getBPEAManager().registerGnssStatusCallback(r8.f31c, r8.f35g, r12.f14187n);
        r8.f34f = new a2.b.c(r8);
        if (PermissionManager.hasAnyPermission(r8.f29a, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == false) goto L56;
        Logger.i("ByteLocationManagerImpl: startLocationInternalForDeviceSensors() is executed.");
    L45:
        e = move-exception;
        Logger.i("ByteLocationManagerImpl startLocationInternalForDeviceSensors requestUpdate exception" + e.toString() + r12.f14185l);
        return;
    L41:
        if (r12.f14185l == false) goto L43;
        BDLocationExtrasService.getBPEAManager().requestSingleUpdate(r8.f31c, CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, r8.f34f, null, r12.f14187n);     // Catch: Exception -> L45
    L49:
        return;
    L43:
        BDLocationExtrasService.getBPEAManager().requestLocationUpdates(r8.f31c, CloudServiceConstants.OSettings.CAE_CONFIG_MODULE_TYPE_GPS, Math.max(r12.f14174a, 1000), 0.0f, r8.f34f, null, r12.f14187n);     // Catch: Exception -> L45
        goto L49
    L56:
        return;
    L47:
        Logger.i("ByteLocationManagerImpl: startLocationInternalForBatterySaving() is executed.");
        r12.f14176c = 1;
        a2.b.b(r12, new a2.b.C0002b(r8, r12, a2.b.e(null)));
        return;
    L22:
        r18 = "default_accuracy";
        goto L24
    L23:
        r18 = "no";
    L12:
        r15 = false;
        goto L15
    }
}
