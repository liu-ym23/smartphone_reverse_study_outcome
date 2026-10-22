package lu1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends n<Boolean> {
    public final /* synthetic */ String b;
    public final /* synthetic */ com.bytedance.android.livesdk.dynamicstrategy.api.entity.n c;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Object b() {
        return Boolean.valueOf(this.c.boolVal);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return this.b;
    }

    public e(String r1, com.bytedance.android.livesdk.dynamicstrategy.api.entity.n r2) {
        this.b = r1;
        this.c = r2;
    }
}
