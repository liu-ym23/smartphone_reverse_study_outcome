package com.obric.cae.location.city;

import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements CityAoiSyncRunner.SyncAction, CityAoiSyncRunner.ExecutorProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f5629a;

    public /* synthetic */ c(Object r8) {
        this.f5629a = r8;
    }

    @Override // com.obric.cae.location.city.CityAoiSyncRunner.ExecutorProvider
    public final ExecutorService getExecutor() {
        return TrafficGeoManager.i((TrafficGeoManager) this.f5629a);
    }

    @Override // com.obric.cae.location.city.CityAoiSyncRunner.SyncAction
    public final void run(String r8) {
        MallGeoManager.a((MallGeoManager) this.f5629a, r8);
    }
}
