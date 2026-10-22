package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/effect/assets/CleanDataSource;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "source", "I", "getSource", "()I", "DEFAULT", "LOCAL", "NET", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CleanDataSource extends Enum<CleanDataSource> {
    public static final CleanDataSource DEFAULT = null;
    public static final CleanDataSource LOCAL = null;
    public static final CleanDataSource NET = null;
    public static final /* synthetic */ CleanDataSource[] a = null;
    private final int source;

    static {
        CleanDataSource r1 = new CleanDataSource("DEFAULT", 0, 0);
        DEFAULT = r1;
        CleanDataSource r2 = new CleanDataSource("LOCAL", 1, 1);
        LOCAL = r2;
        CleanDataSource r3 = new CleanDataSource("NET", 2, 2);
        NET = r3;
        a = new CleanDataSource[]{r1, r2, r3};
    }

    public static CleanDataSource valueOf(String r1) {
        return (CleanDataSource) r27.a.a(CleanDataSource.class, r1);
    }

    public static CleanDataSource[] values() {
        return (CleanDataSource[]) a.clone();
    }

    public final int getSource() {
        return this.source;
    }

    public CleanDataSource(String r1, int r2, int r3) {
        super(r1, r2);
        this.source = r3;
    }
}
