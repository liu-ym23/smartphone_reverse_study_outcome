package c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.zte.miboard.cards.travel.TravelFlightUtils;
import com.zte.miboard.cards.travel.net.data.Device;
import com.zte.miboard.cards.travel.net.data.FlightNetInfoRequest;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static t f1087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Device f1088b;

    public static void a(Context r5, ArrayList r10, mt.u r11) {
        FlightNetInfoRequest r12 = new FlightNetInfoRequest();
        r12.flights = r10;
        if (f1088b != null) goto L12;
        Device r13 = new Device();
        r13.app_id = "";
        String r14 = k0.f1060a;
        r13.apk_version = "16.0.000.000.2606301031-964f71b";
        r13.apk_version_code = 160000L;
        r13.platform = IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
        r13.androidId = k0.a(r5);
        r13.miboard = "n_cards";
        r13.pkgName = r5.getPackageName();
        r13.product = k0.c();
        String r15 = k0.f1062c;
        if (r15 != null) goto L11;
        r15 = k0.b("ro.build.sw_internal_version", null);
        if (r15 != null) goto L10;
        r15 = "";
    L10:
        k0.f1062c = r15;
    L11:
        r13.internal_version = r15;
        f1088b = r13;
    L12:
        r12.device = f1088b;
        r12.miboardAndroidId = TravelFlightUtils.e(r5);
        m.i("FlightNetHelper", "requestFlightNetInfo miboardAndroidId=" + r12.miboardAndroidId);
        monitor-enter(v.class);
    L17:
        th = move-exception;
        throw th;
    L15:
        if (f1087a != null) goto L19;
        f1087a = (t) j0.a(r5, "https://travel-api.ztems.com/travel/client/").create(t.class);     // Catch: Throwable -> L17
    L19:
        t r16 = f1087a;     // Catch: Throwable -> L17
        monitor-exit(v.class);
        j0.b(r16.a(r12, s.d()), r11);
    }

    public static boolean b(Context r5) {
        if (r5 == null) goto L7;
        NetworkInfo r10 = ((ConnectivityManager) r5.getSystemService("connectivity")).getActiveNetworkInfo();
        if (r10 != null) goto L6;
        return false;
    L6:
        return r10.isAvailable();
    L7:
        return false;
    }
}
