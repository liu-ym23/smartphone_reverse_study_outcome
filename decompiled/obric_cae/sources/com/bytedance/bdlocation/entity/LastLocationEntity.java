package com.bytedance.bdlocation.entity;

import android.location.Location;

/* JADX INFO: loaded from: classes.dex */
public class LastLocationEntity {
    public final boolean coordinateSystemSuccess;
    public final Location gpsLocation;
    public final long gpsLocationDuration;
    public final long gpsLocationGap;
    public final Location networkLocation;
    public final long networkLocationDuration;
    public final long networkLocationGap;
    public final long totalLocationDuration;

    public LastLocationEntity(Location r8, Location r10, long r11, long r12, long r13, long r14, long r15, boolean r16) {
        this.networkLocation = r8;
        this.gpsLocation = r10;
        this.networkLocationDuration = r11;
        this.gpsLocationDuration = r12;
        this.totalLocationDuration = r13;
        this.networkLocationGap = r14;
        this.gpsLocationGap = r15;
        this.coordinateSystemSuccess = r16;
    }
}
