package androidx.core.location;

import android.location.Location;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class LocationKt {
    public static final double component1(Location r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getLatitude();
    }

    public static final double component2(Location r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.getLongitude();
    }
}
