package com.bytedance.android.livesdk.gift.grouplive.component.dragger;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/gift/grouplive/component/dragger/RegionId;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "A", "B", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RegionId extends Enum<RegionId> {
    public static final RegionId A = null;
    public static final RegionId B = null;
    public static final /* synthetic */ RegionId[] a = null;
    private final String id;

    static {
        RegionId r1 = new RegionId("A", 0, "A");
        A = r1;
        RegionId r2 = new RegionId("B", 1, "B");
        B = r2;
        a = new RegionId[]{r1, r2};
    }

    public static RegionId valueOf(String r1) {
        return (RegionId) a.a(RegionId.class, r1);
    }

    public static RegionId[] values() {
        return (RegionId[]) a.clone();
    }

    public final String getId() {
        return this.id;
    }

    public RegionId(String r1, int r2, String r3) {
        super(r1, r2);
        this.id = r3;
    }
}
