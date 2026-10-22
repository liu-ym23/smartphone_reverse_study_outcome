package n4;

import android.location.Location;
import com.bytedance.bdlocation.scan.wifi.WifiInfoManager;
import com.obric.cae.libs.softap.CaeSoftApManager;
import com.obric.cae.libs.softap.CaeSoftApStatusResultCallback;
import com.obric.cae.location.geofence.StarGeoCallback;
import com.obric.cae.statusReport.network.NetworkReportUtil;
import com.obric.cae.userAware.WifiScanStateMachine;
import he.i;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9434b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f9435m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f9436n;

    public /* synthetic */ d(StarGeoCallback r8, Location r10, int r11) {
        this.f9433a = 3;
        this.f9435m = r8;
        this.f9436n = r10;
        this.f9434b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f9434b;
        int r10 = this.f9433a;
        Object r11 = this.f9436n;
        Object r12 = this.f9435m;
        switch(r10) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L11;
        };
    L5:
        CaeSoftApManager.a((CaeSoftApStatusResultCallback) r12, r8, (String) r11);
        return;
    L7:
        WifiInfoManager.c((WifiInfoManager.WifiInfoCallback) r12, r8, (String) r11);
        return;
    L9:
        a r13 = (a) r12;
        f2.a r14 = (f2.a) r11;
        i.f(r13, "$db");
        i.f(r14, "this$0");
        xd.d<HashMap<Object, JSONObject>, Boolean> r15 = r13.a(r8, 3145728, NetworkReportUtil.INTERVENTION_REPORT_EVENT_DELAY, WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_WEEK_MS, new e(r14));
        HashMap<Object, JSONObject> r16 = r15.f13867a;
        r15.f13868b.booleanValue();
        r14.getClass();
        throw null;
    L11:
        StarGeoCallback.c((StarGeoCallback) r12, (Location) r11, r8);
    }

    public /* synthetic */ d(Object r8, int r10, int r11, Object r12) {
        this.f9433a = r11;
        this.f9435m = r8;
        this.f9434b = r10;
        this.f9436n = r12;
    }
}
