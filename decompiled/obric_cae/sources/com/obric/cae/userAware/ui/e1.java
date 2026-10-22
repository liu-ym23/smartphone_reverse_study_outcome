package com.obric.cae.userAware.ui;

import android.content.Context;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.userAware.datacollection.PoiArrivalFeedbackInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5946b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f5947m;

    public /* synthetic */ e1(int r8, Object r10, Object r11) {
        this.f5945a = r8;
        this.f5946b = r10;
        this.f5947m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5945a;
        Object r10 = this.f5947m;
        Object r11 = this.f5946b;
        switch(r8) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L11;
        };
    L5:
        StoreArrivalEventManager.HistoryLoadTask.a((StoreArrivalEventManager.HistoryLoadTask) r11, (ArrayList) r10);
        return;
    L7:
        PoiArrivalActivity.g((Context) r11, (PoiArrivalFeedbackInfo) r10);
        return;
    L9:
        UserAwareCurrentActivity.CurrentCallback.a((UserAwareCurrentActivity.CurrentCallback) r11, (StarGeofence) r10);
        return;
    L11:
        SubwayStatusActivity.i((SubwayStatusActivity) r11, (String) r10);
    }
}
