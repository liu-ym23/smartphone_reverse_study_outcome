package androidx.core.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface LocationListenerCompat extends LocationListener {
    @Override // android.location.LocationListener
    default void onFlushComplete(int r5) {
    }

    @Override // android.location.LocationListener
    default void onLocationChanged(@NonNull List<Location> r5) {
        int r10 = r5.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        onLocationChanged(r5.get(r11));
        r11 = r11 + 1;
        goto L3
    }

    @Override // android.location.LocationListener
    default void onProviderDisabled(@NonNull String r5) {
    }

    @Override // android.location.LocationListener
    default void onProviderEnabled(@NonNull String r5) {
    }

    @Override // android.location.LocationListener
    default void onStatusChanged(@NonNull String r5, int r10, @Nullable Bundle r11) {
    }
}
