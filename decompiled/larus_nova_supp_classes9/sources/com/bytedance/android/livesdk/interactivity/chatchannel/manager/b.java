package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements IAssetsManager.b {
    public final /* synthetic */ a a;
    public final /* synthetic */ l62.a b;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
    public final void a() {
        this.a.d.l0(this);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager.b
    public final void b(List<? extends com.bytedance.android.live.core.resources.e> r5) {
        Intrinsics.checkNotNullParameter(r5, "assetsModels");
        a r6 = this.a;
        r6.d.j4(this.b.a, r6.b, 4);
        this.a.d.l0(this);
    }

    public b(a r1, l62.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
