package com.obric.cae.cldReport;

import com.obric.cae.location.geosdk.bytedance.BdLocationManager;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5367c;

    public /* synthetic */ b(int r8, Object r10, Object r11) {
        this.f5365a = r8;
        this.f5366b = r10;
        this.f5367c = r11;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int r8 = this.f5365a;
        Object r10 = this.f5367c;
        Object r11 = this.f5366b;
        switch(r8) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L12;
        };
    L6:
        return BdLocationManager.d((BdLocationManager) r11, (BdLocationManager.BmapRidingDirectionRequest) r10);
    L8:
        return BdLocationManager.a((BdLocationManager) r11, (BdLocationManager.BmapTransitDirectionRequest) r10);
    L10:
        return CldReportService.b((CldReportService) r11, (Process) r10);
    L12:
        return BdLocationManager.e((BdLocationManager) r11, (List) r10);
    }
}
