package com.obric.cae.userAware.ui;

import com.obric.cae.libs.useraware.LocationAwareInfo;
import com.obric.cae.userAware.datacollection.PoiArrivalFeedbackInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5953b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f5954m;

    public /* synthetic */ f1(int r8, Object r10, Object r11) {
        this.f5952a = r8;
        this.f5953b = r10;
        this.f5954m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f5952a;
        Object r10 = this.f5954m;
        Object r11 = this.f5953b;
        switch(r8) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L15;
        };
    L5:
        StoreArrivalEventManager.b((ArrayList) r11, (PoiArrivalFeedbackInfo) r10);
        return;
    L7:
        HARStatusActivity.t((HARStatusActivity) r11, (List) r10);
        return;
    L9:
        HARStatusActivity.n((HARStatusActivity) r11, (String) r10);
        return;
    L11:
        UserAwareLauncherActivity.LauncherCallback.b((UserAwareLauncherActivity.LauncherCallback) r11, (LocationAwareInfo) r10);
        return;
    L13:
        UserAwareCurrentActivity.CurrentCallback.c((UserAwareCurrentActivity.CurrentCallback) r11, (List) r10);
        return;
    L15:
        SubwayStatusActivity.d((SubwayStatusActivity) r11, (List) r10);
    }
}
