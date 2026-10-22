package com.byted.mgl.merge.service.api.privacy.location;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface IPrivacyLocation {
    void requestLocationUpdates(LocationManager r1, String r10, long r11, float r12, LocationListener r13, Looper r14, String r15) throws IllegalAccessException;
}
