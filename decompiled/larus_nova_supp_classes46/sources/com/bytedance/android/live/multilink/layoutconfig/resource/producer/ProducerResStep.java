package com.bytedance.android.live.multilink.layoutconfig.resource.producer;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/multilink/layoutconfig/resource/producer/ProducerResStep;", "", "LocalCache", "GeckoOffline", "LocalAssets", "lib-layoutconfig_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ProducerResStep extends Enum<ProducerResStep> {
    public static final ProducerResStep GeckoOffline = null;
    public static final ProducerResStep LocalAssets = null;
    public static final ProducerResStep LocalCache = null;
    public static final /* synthetic */ ProducerResStep[] a = null;

    static {
        ProducerResStep r1 = new ProducerResStep("LocalCache", 0);
        LocalCache = r1;
        ProducerResStep r2 = new ProducerResStep("GeckoOffline", 1);
        GeckoOffline = r2;
        ProducerResStep r3 = new ProducerResStep("LocalAssets", 2);
        LocalAssets = r3;
        a = new ProducerResStep[]{r1, r2, r3};
    }

    public static ProducerResStep valueOf(String r1) {
        return (ProducerResStep) a.a(ProducerResStep.class, r1);
    }

    public static ProducerResStep[] values() {
        return (ProducerResStep[]) a.clone();
    }

    public ProducerResStep(String r1, int r2) {
        super(r1, r2);
    }
}
