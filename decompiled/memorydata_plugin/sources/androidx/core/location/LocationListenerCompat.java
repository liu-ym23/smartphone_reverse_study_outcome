package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface LocationListenerCompat extends LocationListener {
    @Override // android.location.LocationListener
    default void onFlushComplete(int r1) {
    }

    @Override // android.location.LocationListener
    default void onLocationChanged(List<Location> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        int r0 = r7.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        onLocationChanged((Location) ZeusTransformUtils.preCheckCast(r7.get(r2), Location.class, "com.obric.memorydata.plugin"));
        r2 = r2 + 1;
        goto L3
    }

    @Override // android.location.LocationListener
    default void onProviderDisabled(String r1) {
    }

    @Override // android.location.LocationListener
    default void onProviderEnabled(String r1) {
    }

    @Override // android.location.LocationListener
    default void onStatusChanged(String r1, int r2, Bundle r3) {
    }
}
