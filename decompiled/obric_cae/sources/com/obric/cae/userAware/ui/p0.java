package com.obric.cae.userAware.ui;

import com.obric.cae.libs.useraware.GnssSvAwareInfo;
import com.obric.cae.libs.useraware.WifiStandardData;
import com.obric.cae.userAware.datacollection.PoiArrivalFeedbackInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class p0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6019b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f6020m;

    public /* synthetic */ p0(int r8, Object r10, Object r11) {
        this.f6018a = r8;
        this.f6019b = r10;
        this.f6020m = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r8 = this.f6018a;
        Object r10 = this.f6020m;
        Object r11 = this.f6019b;
        switch(r8) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L13;
        };
    L5:
        UserAwareLauncherActivity.LauncherCallback.a((UserAwareLauncherActivity.LauncherCallback) r11, (GnssSvAwareInfo) r10);
        return;
    L7:
        UserAwareLauncherActivity.LauncherCallback.d((UserAwareLauncherActivity.LauncherCallback) r11, (String) r10);
        return;
    L9:
        UserAwareCurrentActivity.CurrentCallback.b((UserAwareCurrentActivity.CurrentCallback) r11, (WifiStandardData) r10);
        return;
    L11:
        PoiArrivalActivity.HistoryLoadTask.b((PoiArrivalActivity.HistoryLoadTask) r11, (ArrayList) r10);
        return;
    L13:
        StoreArrivalEventManager.a((ArrayList) r10, (PoiArrivalFeedbackInfo) r11);
    }

    public /* synthetic */ p0(ArrayList r8, PoiArrivalFeedbackInfo r10) {
        this.f6018a = 4;
        this.f6020m = r8;
        this.f6019b = r10;
    }
}
