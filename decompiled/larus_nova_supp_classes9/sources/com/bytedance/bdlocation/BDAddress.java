package com.bytedance.bdlocation;

import android.location.Address;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.d;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class BDAddress extends Address {
    private float accuracy;
    private double altitude;
    private float horizontalAccuracy;
    private float speed;
    private float verticalAccuracy;

    @Override // android.location.Address
    public String toString() {
        return "BDAddress{speed=" + this.speed + ", accuracy=" + this.accuracy + ", altitude=" + this.altitude + ", verticalAccuracy=" + this.verticalAccuracy + ", horizontalAccuracy=" + this.horizontalAccuracy + ", addr= " + super.toString() + '}';
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public float getHorizontalAccuracy() {
        return this.horizontalAccuracy;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getVerticalAccuracy() {
        return this.verticalAccuracy;
    }

    public BDAddress(Address r3) {
        super(r3.getLocale());
        setFeatureName(r3.getFeatureName());
        int r0 = 0;
    L4:
        if (r0 > r3.getMaxAddressLineIndex()) goto L6;
        setAddressLine(r0, r3.getAddressLine(r0));
        r0 = r0 + 1;
        goto L4
    L6:
        setAdminArea(r3.getAdminArea());
        setSubAdminArea(r3.getSubAdminArea());
        setLocality(r3.getLocality());
        setSubLocality(r3.getSubLocality());
        setThoroughfare(r3.getThoroughfare());
        setSubThoroughfare(r3.getSubThoroughfare());
        setPremises(r3.getPremises());
        setPostalCode(r3.getPostalCode());
        setCountryCode(r3.getCountryCode());
        setCountryName(r3.getCountryName());
        setLatitude(com_bytedance_bdlocation_BDAddress_android_location_Address_getLatitude(r3));
        setLongitude(com_bytedance_bdlocation_BDAddress_android_location_Address_getLongitude(r3));
        setUrl(r3.getUrl());
        setExtras(r3.getExtras());
    }

    private static double com_bytedance_bdlocation_BDAddress_android_location_Address_getLatitude(Address r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100045);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(100045, "android/location/Address", "getLatitude", r18, r10, "double", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Double) r4.b).doubleValue();
    L21:
        return r18.getLatitude();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private static double com_bytedance_bdlocation_BDAddress_android_location_Address_getLongitude(Address r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(100046);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        d r4 = r7.preInvoke(100046, "android/location/Address", "getLongitude", r18, r10, "double", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Double) r4.b).doubleValue();
    L21:
        return r18.getLongitude();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public void setAccuracy(float r1) {
        this.accuracy = r1;
    }

    public void setAltitude(double r1) {
        this.altitude = r1;
    }

    public void setHorizontalAccuracy(float r1) {
        this.horizontalAccuracy = r1;
    }

    public void setSpeed(float r1) {
        this.speed = r1;
    }

    public void setVerticalAccuracy(float r1) {
        this.verticalAccuracy = r1;
    }

    public BDAddress(Locale r1) {
        super(r1);
    }
}
