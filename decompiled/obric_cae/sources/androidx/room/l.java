package androidx.room;

import android.content.Context;
import android.content.Intent;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.LocationUploadCallback;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.google.protobuf.LegacyUnredactedTextFormat;
import com.obric.cae.libs.softap.CaeSoftApManager;
import com.obric.cae.libs.softap.ICaeSoftApManager;
import com.obric.cae.location.geofence.vendor.VendorGeoCallbackBroadcast;
import com.obric.cae.smartBluetooth.btaware.SmartBluetoothInCarAware;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2654b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f2655m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f2656n;

    public /* synthetic */ l(Object r8, Object r10, Object r11, int r12) {
        this.f2653a = r12;
        this.f2654b = r8;
        this.f2655m = r10;
        this.f2656n = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f2653a;
        Object r10 = this.f2656n;
        Object r11 = this.f2655m;
        Object r12 = this.f2654b;
        switch(r8) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L15;
        };
    L5:
        VendorGeoCallbackBroadcast.a((VendorGeoCallbackBroadcast) r12, (Context) r11, (Intent) r10);
        return;
    L7:
        CaeSoftApManager.a.a((CaeSoftApManager.a) r12, (ICaeSoftApManager) r11, (ArrayList) r10);
        return;
    L9:
        LegacyUnredactedTextFormat.b((String[]) r12, (String) r11, (Object[]) r10);
        return;
    L11:
        LocationUtil.b((BDLocation) r12, (LocationUploadExtra) r11, (LocationUploadCallback) r10);
        return;
    L13:
        a1.e r13 = (a1.e) r11;
        he.i.f((n) r12, "this$0");
        he.i.f(r13, "$query");
        he.i.f((o) r10, "$queryInterceptorProgram");
        r13.a();
        throw null;
    L15:
        SmartBluetoothInCarAware.b((SmartBluetoothInCarAware) r12, (String) r11, (String) r10);
    }
}
