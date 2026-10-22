package z;

import android.view.View;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.obric.cae.smartNetwork.networkHandoverRL.feature.MobileTrafficQuery;
import com.obric.cae.smartNfc.ReverseChargingNfcController;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14155b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f14156m;

    public /* synthetic */ g(int r8, int r10, Object r11) {
        this.f14154a = r10;
        this.f14156m = r11;
        this.f14155b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f14154a;
        int r10 = this.f14155b;
        Object r11 = this.f14156m;
        switch(r8) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L15;
        };
    L5:
        MobileTrafficQuery.a((MobileTrafficQuery) r11, r10);
        return;
    L7:
        SideSheetBehavior r12 = (SideSheetBehavior) r11;
        View r13 = (View) r12.f4931p.get();
        if (r13 == null) goto L17;
        r12.A(r13, r10, false);
        return;
    L17:
        return;
    L11:
        BDLocationConfig.a(r10, (BDLocation) r11);
        return;
    L13:
        ((f.e) r11).c(r10);
        return;
    L15:
        ReverseChargingNfcController.b((ReverseChargingNfcController) r11, r10);
    }

    public /* synthetic */ g(int r8, BDLocation r10) {
        this.f14154a = 1;
        this.f14155b = r8;
        this.f14156m = r10;
    }
}
