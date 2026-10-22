package g4;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    static {
    }

    public static boolean a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (Build.VERSION.SDK_INT < 33) goto L12;
        if (r10.getApplicationInfo().targetSdkVersion < 33) goto L12;
        if (ContextCompat.checkSelfPermission(r10, "android.permission.ACCESS_COARSE_LOCATION") == (-1)) goto L9;
    L15:
        return true;
    L9:
        if (ContextCompat.checkSelfPermission(r10, "android.permission.ACCESS_FINE_LOCATION") != (-1)) goto L15;
    L16:
        return false;
    L12:
        if (ContextCompat.checkSelfPermission(r10, "android.permission.ACCESS_COARSE_LOCATION") == (-1)) goto L16;
        if (ContextCompat.checkSelfPermission(r10, "android.permission.ACCESS_FINE_LOCATION") == (-1)) goto L16;
        goto L15
    }

    public static boolean b(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        if (Build.VERSION.SDK_INT < 28) goto L17;
        Object r11 = r10.getSystemService(com.bytedance.android.ec.core.event.a.KEY_LOCATION);
        if ((r11 instanceof LocationManager) == false) goto L7;
        LocationManager r12 = (LocationManager) r11;
    L8:
        if (r12 != null) goto L20;
        return false;
    L20:
        return r12.isLocationEnabled();
    L7:
        r12 = null;
        goto L8
    L17:
        if (Settings.Secure.getInt(r10.getContentResolver(), "location_mode") == 0) goto L21;
        return true;
    L21:
        return false;
    L14:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
