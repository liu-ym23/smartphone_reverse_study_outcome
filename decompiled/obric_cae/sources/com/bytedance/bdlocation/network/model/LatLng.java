package com.bytedance.bdlocation.network.model;

import com.obric.cae.location.database.StarCellDbManager;
import ia.b;

/* JADX INFO: loaded from: classes.dex */
public class LatLng {

    @b("latitude")
    public double latitude;

    @b(StarCellDbManager.CellInfoEntry.LONGITUDE)
    public double longitude;

    public LatLng() {
    }
}
