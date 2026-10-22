package com.obric.cae.libs.softap;

import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.smartBluetooth.a2dpJitterML.A2dpJitterMlAoiBoardCallbackController;
import com.obric.cae.smartBluetooth.a2dpJitterML.A2dpJitterMlBqrCallbackController;
import com.obric.cae.userAware.ui.StoreArrivalActivity;
import com.obric.cae.userAware.ui.StoreArrivalEventManager;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements CaeSoftApManager.d, A2dpJitterMlAoiBoardCallbackController.AoiBoardCallback, StoreArrivalEventManager.HistoryRecordsCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f5501a;

    public /* synthetic */ j(Object r8) {
        this.f5501a = r8;
    }

    @Override // com.obric.cae.smartBluetooth.a2dpJitterML.A2dpJitterMlAoiBoardCallbackController.AoiBoardCallback
    public final void onAoiBoardInfoChange(AoiBoard r8) {
        A2dpJitterMlBqrCallbackController.b((A2dpJitterMlBqrCallbackController) this.f5501a, r8);
    }

    @Override // com.obric.cae.libs.softap.CaeSoftApManager.d
    public final void onError(int r8, String r10) {
        CaeSoftApManager.c.a((CaeSoftApStatusResultCallback) this.f5501a, r8, r10);
    }

    @Override // com.obric.cae.userAware.ui.StoreArrivalEventManager.HistoryRecordsCallback
    public final void onHistoryRecordsLoaded(ArrayList r8) {
        StoreArrivalActivity.j((StoreArrivalActivity) this.f5501a, r8);
    }
}
