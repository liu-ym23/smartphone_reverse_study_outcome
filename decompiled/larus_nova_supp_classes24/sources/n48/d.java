package n48;

import com.larus.api.LocationService;
import com.larus.platform.model.GeoLocationInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d {
    public d() {
    }

    public final String a() {
        GeoLocationInfo r0 = LocationService.a.m();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCityCode();
    }
}
