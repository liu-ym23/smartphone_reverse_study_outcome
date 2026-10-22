package r1;

import android.location.Location;
import com.obric.cae.libs.useraware.BtAwareInfo;
import com.obric.cae.libs.useraware.CellAwareInfo;
import com.obric.cae.libs.useraware.ICaeUserAwareCallback;
import com.obric.cae.location.StarLocationManager;
import com.obric.cae.location.StarLocationReplayer;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s implements k.a, StarLocationReplayer.ReplayCallback, UserAwareManager.InnerCallbackAction, UserAwareManager.CallbackAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11336a;

    public /* synthetic */ s(int r8) {
        this.f11336a = r8;
    }

    @Override // k.a
    public final Object apply(Object r8) {
        List r10 = (List) r8;
        if (r10 == null) goto L8;
        ArrayList r11 = new ArrayList(yd.f.f1(r10));
        Iterator r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L11;
        r11.add(((t.b) r12.next()).a());
        goto L6
    L11:
        return r11;
    L8:
        return null;
    }

    @Override // com.obric.cae.userAware.UserAwareManager.CallbackAction
    public final void execute(ICaeUserAwareCallback r8, Object r10) {
        switch(this.f11336a) {
            case 8: goto L5;
            default: goto L7;
        };
    L5:
        r8.onCellNeighbourInfoChange((List) r10);
        return;
    L7:
        r8.onWifiScanInfoChanged((List) r10);
    }

    @Override // com.obric.cae.location.StarLocationReplayer.ReplayCallback
    public final boolean onReplay(StarLocationManager.LocationSource r8) {
        return StarLocationReplayer.a(r8);
    }

    @Override // com.obric.cae.userAware.UserAwareManager.InnerCallbackAction
    public final void execute(InnerAwareInfoCallback r8, Object r10) {
        switch(this.f11336a) {
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L21;
            case 9: goto L9;
            case 10: goto L7;
            case 11: goto L5;
            default: goto L21;
        };
    L5:
        r8.onCellInfoChanged((CellAwareInfo) r10);
        return;
    L7:
        r8.onWifiScanNeighborApChanged((List) r10);
        return;
    L9:
        r8.onWifiNetworkAvailable(((Boolean) r10).booleanValue());
        return;
    L11:
        r8.onDeviceProvisionedChanged(((Integer) r10).intValue());
        return;
    L13:
        r8.onRecordNearbyStatus(((Boolean) r10).booleanValue());
        return;
    L15:
        r8.onBtInfoChanged((BtAwareInfo) r10);
        return;
    L17:
        r8.onLocationChanged((Location) r10);
        return;
    L19:
        r8.onEngineStatusChanged(((Integer) r10).intValue());
        return;
    L21:
        r8.onLocationStateValueChange((String) r10);
    }
}
