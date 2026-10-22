package com.obric.cae.location.geosdk.bytedance;

import com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppInfo;
import com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppRepository;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5663c;

    public /* synthetic */ b(int r8, Object r10, Object r11) {
        this.f5661a = r8;
        this.f5662b = r10;
        this.f5663c = r11;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int r8 = this.f5661a;
        Object r10 = this.f5663c;
        Object r11 = this.f5662b;
        switch(r8) {
            case 0: goto L8;
            case 1: goto L6;
            default: goto L10;
        };
    L6:
        return BdLocationManager.g((BdLocationManager) r11, (List) r10);
    L8:
        return BdLocationManager.k((BdLocationManager) r11, (BdLocationManager.BmapDrivingDirectionRequest) r10);
    L10:
        return CarkeyAppRepository.e((CarkeyAppRepository) r11, (CarkeyAppInfo) r10);
    }
}
