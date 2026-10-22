package com.bytedance.map.api.model;

import androidx.constraintlayout.motion.widget.a;

/* JADX INFO: loaded from: classes2.dex */
public class BDLatLng {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f6917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f6918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f6919c;

    public BDLatLng(double r5, double r10) {
        this.f6917a = r5;
        this.f6918b = r10;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("BDLatLng{mLatitude=");
        r5.append(this.f6917a);
        r5.append(", mLongitude=");
        r5.append(this.f6918b);
        r5.append(", mIsMainPoint");
        return a.w(r5, this.f6919c, '}');
    }

    public BDLatLng(BDLatLng r5, boolean r10) {
        if (r5 != null) goto L5;
        return;
    L5:
        this.f6917a = r5.f6917a;
        this.f6918b = r5.f6918b;
        this.f6919c = r10;
    }
}
