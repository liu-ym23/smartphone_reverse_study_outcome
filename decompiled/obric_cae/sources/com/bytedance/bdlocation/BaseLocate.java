package com.bytedance.bdlocation;

import android.content.Context;
import android.os.Looper;
import com.bytedance.bdlocation.api.ILocate;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.callback.LocateCallback;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseLocate implements ILocate, LocateCallback {
    protected Context mContext;
    protected LocateCallback mLocateCallback;
    private volatile LocationOption mLocationOption;

    public BaseLocate(Context r8) {
        this.mContext = r8;
    }

    public LocationOption getLocationOption() {
        return this.mLocationOption;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateChange(String r8, BDLocation r10) {
        LocateCallback r11 = this.mLocateCallback;
        if (r11 == null) goto L6;
        r11.onLocateChange(r8, r10);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateError(String r8, BDLocationException r10) {
        LocateCallback r11 = this.mLocateCallback;
        if (r11 == null) goto L6;
        r11.onLocateError(r8, r10);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateStart(String r8) {
        LocateCallback r10 = this.mLocateCallback;
        if (r10 == null) goto L6;
        r10.onLocateStart(r8);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateStop(String r8) {
        LocateCallback r10 = this.mLocateCallback;
        if (r10 == null) goto L6;
        r10.onLocateStop(r8);
        return;
    }

    public void setLocateCallback(LocateCallback r8) {
        this.mLocateCallback = r8;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void startLocation(BDLocationCallback r8, LocationOption r10, Looper r11) {
        this.mLocationOption = r10;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void stopLocationForBusiness(String r8) {
    }
}
