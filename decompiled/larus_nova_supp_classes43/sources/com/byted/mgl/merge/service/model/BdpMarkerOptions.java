package com.byted.mgl.merge.service.model;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BdpMarkerOptions {
    public Bitmap icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f7id;
    public BdpLatLng position;
    public String title;

    public BdpMarkerOptions() {
    }

    public BdpMarkerOptions icon(Bitmap r1) {
        this.icon = r1;
        return this;
    }

    public BdpMarkerOptions id(String r1) {
        this.f7id = r1;
        return this;
    }

    public BdpMarkerOptions position(BdpLatLng r1) {
        this.position = r1;
        return this;
    }

    public BdpMarkerOptions title(String r1) {
        this.title = r1;
        return this;
    }
}
