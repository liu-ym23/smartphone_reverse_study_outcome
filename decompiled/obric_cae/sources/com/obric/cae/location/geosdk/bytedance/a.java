package com.obric.cae.location.geosdk.bytedance;

import com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppInfo;
import com.obric.cae.smartBluetooth.storage.carkey.CarkeyAppRepository;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f5659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5660c;

    public /* synthetic */ a(int r8, Object r10, Object r11) {
        this.f5658a = r8;
        this.f5659b = r10;
        this.f5660c = r11;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int r8 = this.f5658a;
        Object r10 = this.f5660c;
        Object r11 = this.f5659b;
        switch(r8) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L12;
        };
    L6:
        return CarkeyAppRepository.c((CarkeyAppRepository) r11, (CarkeyAppInfo) r10);
    L8:
        return BdLocationManager.c((BdLocationManager) r11, (List) r10);
    L10:
        return BdLocationManager.l((BdLocationManager) r11, (BdLocationManager.BmapWalkingDirectionRequest) r10);
    L12:
        return CarkeyAppRepository.b((CarkeyAppRepository) r11, (String) r10);
    }
}
