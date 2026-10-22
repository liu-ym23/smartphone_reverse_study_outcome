package o5;

import com.bytedance.bdlocation.callback.ISceneStatusCallback;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.google.android.material.textfield.TextInputLayout;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.libs.useraware.CellAwareInfo;
import com.obric.cae.libs.useraware.GnssSvAwareInfo;
import com.obric.cae.libs.useraware.ICaeUserAwareCallback;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class o implements ISceneStatusCallback, TextInputLayout.e, UserAwareManager.InnerCallbackAction, UserAwareManager.CallbackAction, UserAwareManager.InnerCallbackAction2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9714a;

    public /* synthetic */ o(int r8) {
        this.f9714a = r8;
    }

    @Override // com.obric.cae.userAware.UserAwareManager.CallbackAction
    public final void execute(ICaeUserAwareCallback r8, Object r10) {
        switch(this.f9714a) {
            case 4: goto L9;
            case 10: goto L7;
            case 11: goto L5;
            default: goto L11;
        };
    L5:
        r8.onWifiConnectInfoChanged((WifiStandardData) r10);
        return;
    L7:
        r8.onWifiNetworkAvailable(((Boolean) r10).booleanValue());
        return;
    L9:
        r8.onWifiScanInfoChanged((List) r10);
        return;
    L11:
        r8.onCellInfoChange((CellAwareInfo) r10);
    }

    @Override // com.bytedance.bdlocation.callback.ISceneStatusCallback
    public final void onChanged() {
        AppExecutors.getInstance().networkIO().execute(new p(0));
    }

    @Override // com.obric.cae.userAware.UserAwareManager.InnerCallbackAction
    public final void execute(InnerAwareInfoCallback r8, Object r10) {
        switch(this.f9714a) {
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L19;
            case 5: goto L19;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L7;
            case 10: goto L19;
            case 11: goto L19;
            case 12: goto L19;
            case 13: goto L5;
            default: goto L19;
        };
    L5:
        r8.onUploadModeChanged(((Integer) r10).intValue());
        return;
    L7:
        r8.onUserFeedbackPredictSwitchValueChange(((Integer) r10).intValue());
        return;
    L9:
        r8.onRecordNearbyStatus(((Boolean) r10).booleanValue());
        return;
    L11:
        r8.onSubwayCellPoiStatusChange((InnerAwareInfoCallback.CellPoiStatus) r10);
        return;
    L13:
        r8.onGnssSvInfoChanged((GnssSvAwareInfo) r10);
        return;
    L15:
        r8.onNetworkValid(((Boolean) r10).booleanValue());
        return;
    L17:
        r8.onAoiBoardEvent((AoiBoard) r10);
        return;
    L19:
        r8.onSubwayFeedbackSwitchValueChange(((Integer) r10).intValue());
    }

    @Override // com.obric.cae.userAware.UserAwareManager.InnerCallbackAction2
    public final void execute(InnerAwareInfoCallback r8, Object r10, Object r11) {
        switch(this.f9714a) {
            case 5: goto L4;
            default: goto L4;
        };
    L4:
        r8.onHARStatusChanged(((Integer) r10).intValue(), ((Long) r11).longValue());
    }
}
