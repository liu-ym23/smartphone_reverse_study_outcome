package com.bytedance.bdlocation;

import android.content.Context;
import android.os.Looper;
import com.bytedance.bdlocation.api.ILocate;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.callback.LocateCallback;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseLocate implements ILocate, LocateCallback {
    protected Context mContext;
    protected LocateCallback mLocateCallback;
    private volatile LocationOption mLocationOption;

    public BaseLocate(Context r3) {
        this.mContext = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    public LocationOption getLocationOption() {
        return this.mLocationOption;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateChange(String r1, BDLocation r2) {
        LocateCallback r0 = this.mLocateCallback;
        if (r0 == null) goto L6;
        r0.onLocateChange(r1, r2);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateError(String r1, BDLocationException r2) {
        LocateCallback r0 = this.mLocateCallback;
        if (r0 == null) goto L6;
        r0.onLocateError(r1, r2);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateStart(String r1) {
        LocateCallback r0 = this.mLocateCallback;
        if (r0 == null) goto L6;
        r0.onLocateStart(r1);
        return;
    }

    @Override // com.bytedance.bdlocation.callback.LocateCallback
    public void onLocateStop(String r1) {
        LocateCallback r0 = this.mLocateCallback;
        if (r0 == null) goto L6;
        r0.onLocateStop(r1);
        return;
    }

    public void setLocateCallback(LocateCallback r3) {
        this.mLocateCallback = (LocateCallback) ZeusTransformUtils.wrapperContextForParams(r3, LocateCallback.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void startLocation(BDLocationCallback r2, LocationOption r3, Looper r4) {
        BDLocationCallback r5 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r2, BDLocationCallback.class, "com.obric.memorydata.plugin");
        this.mLocationOption = r3;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void stopLocationForBusiness(String r1) {
    }
}
