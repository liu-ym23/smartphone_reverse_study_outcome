package com.obric.cae.location.city;

import com.obric.cae.location.geosdk.bytedance.BdLocationManager;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements PoiSearchCollector.CandidateKeyProvider {
    @Override // com.obric.cae.location.city.PoiSearchCollector.CandidateKeyProvider
    public final String getCandidateKey(BdLocationManager.CommonPOIInfo r8) {
        return TrafficGeoManager.a(r8);
    }
}
