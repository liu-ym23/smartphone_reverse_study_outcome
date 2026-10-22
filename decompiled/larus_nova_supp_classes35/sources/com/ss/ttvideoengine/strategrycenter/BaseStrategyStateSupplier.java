package com.ss.ttvideoengine.strategrycenter;

import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class BaseStrategyStateSupplier implements IStrategyStateSupplier {
    public BaseStrategyStateSupplier() {
    }

    @Override // com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier
    public double getNetworkSpeed() {
        return 0.0d;
    }

    @Override // com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier
    public Map<String, Object> mediaInfo(String r1) {
        return null;
    }

    @Override // com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier
    public Map<String, Integer> selectBitrate(StrategyMediaParam r1) {
        return null;
    }

    @Override // com.ss.ttvideoengine.strategrycenter.IStrategyStateSupplier
    public Map<String, Integer> selectBitrate(String r1, int r2) {
        return null;
    }
}
