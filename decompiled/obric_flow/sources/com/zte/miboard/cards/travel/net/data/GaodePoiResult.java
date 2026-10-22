package com.zte.miboard.cards.travel.net.data;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import c.m;
import com.zte.miboard.cards.travel.data.TravelData;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class GaodePoiResult {
    public String info;
    public ArrayList<Poi> pois;
    public String status;

    public static class Poi {
        public String location;
        public String name;

        private Poi() {
        }
    }

    public GaodePoiResult() {
    }

    @Nullable
    private static TravelData.LngLat parsePoiLocationStr(Poi r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r5.location) == true) goto L19;
        String[] r10 = r5.location.split(",");     // Catch: Throwable -> L11
        if (r10.length != 2) goto L17;
        return new TravelData.LngLat(r10[0], r10[1], TravelData.LngLat.COORD_TYPE_GCJ);
    L17:
        return null;
    L11:
        th = move-exception;
        m.j("GaodePoiResult", "parsePoiLocationStr error, poi.location=" + r5.location, th);
        return null;
    L19:
        return null;
    }

    @Nullable
    public TravelData.LngLat getLngLat() {
        TravelData.LngLat r5 = null;
        if (isAvailable() == true) goto L5;
        return null;
    L5:
        Iterator<Poi> r10 = this.pois.iterator();
    L7:
        if (r10.hasNext() == false) goto L12;
        r5 = parsePoiLocationStr(r10.next());
        if (r5 == null) goto L7;
        if (r5.isAvailable() == false) goto L7;
    L12:
        return r5;
    }

    public boolean isAvailable() {
        ArrayList<Poi> r5 = this.pois;
        if (r5 != null) goto L5;
    L7:
        return false;
    L5:
        if (r5.isEmpty() == true) goto L7;
        return true;
    }
}
