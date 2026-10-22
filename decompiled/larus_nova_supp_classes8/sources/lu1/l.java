package lu1;

import com.bytedance.android.livesdk.dynamicstrategy.api.entity.s;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l extends n<Boolean> {
    public boolean b;
    public final String c;
    public final s d;

    @Override // lu1.n, com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // lu1.n, com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Object b() {
        return Boolean.valueOf(this.b);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return this.c;
    }

    public l(String r2, s r3) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r3, "nfaInfo");
        this.c = r2;
        this.d = r3;
    }
}
