package z00;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;
import kotlin.Deprecated;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements LocationListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Function1 b;

    @Override // android.location.LocationListener
    public final void onProviderDisabled(String r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
    }

    @Override // android.location.LocationListener
    public final void onProviderEnabled(String r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
    }

    @Override // android.location.LocationListener
    @Deprecated(message = "Deprecated in Java")
    public final void onStatusChanged(String r1, int r2, Bundle r3) {
    }

    @Override // android.location.LocationListener
    public final void onLocationChanged(Location r21) {
        ArrayList r11 = new ArrayList();
        Object[] r12 = {r21};
        f06.b r13 = new f06.b();
        g06.a r0 = (g06.a) ApiHookConfig.b.get(100038);
        if (r0 == null) goto L5;
        f06.a[] r1 = r0.i;
    L6:
        f06.a[] r7 = r1;
        int r6 = r7.length;
        int r5 = 0;
    L8:
        if (r5 >= r6) goto L15;
        f06.a r4 = r7[r5];
        int r17 = r5;
        int r18 = r6;
        f06.a[] r19 = r7;
        f06.d r2 = r4.preInvoke(100038, "com/bytedance/android/live/broadcast/widget/PreviewLocationWidgetHelper$readLocationForSaas$1", "onLocationChanged", this, r12, "void", r13);     // Catch: Exception -> L21
        if (r2.a == true) goto L17;
        r11.add(r4);     // Catch: Exception -> L21
    L17:
        if (r2.a == false) goto L19;
        return;
    L19:
        Intrinsics.checkNotNullParameter(r21, "location");
        int r3 = m.a;
        m.b(this.a, r21, this.b);
        return;
    L14:
        r5 = r17 + 1;
        r6 = r18;
        r7 = r19;
        goto L8
    L15:
        r2 = new f06.d(false, null);
        goto L17
    L5:
        r1 = ApiHookConfig.d;
        goto L6
    }

    public l(Context r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
