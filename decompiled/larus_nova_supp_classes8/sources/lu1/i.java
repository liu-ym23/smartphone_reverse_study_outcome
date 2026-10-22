package lu1;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i extends n<List<? extends Boolean>> {
    public final /* synthetic */ String b;
    public final /* synthetic */ com.bytedance.android.livesdk.dynamicstrategy.api.entity.n c;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Object b() {
        return this.c.booleanArrayVal;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return this.b;
    }

    public i(String r1, com.bytedance.android.livesdk.dynamicstrategy.api.entity.n r2) {
        this.b = r1;
        this.c = r2;
    }
}
