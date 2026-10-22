package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.animation;

import com.bytedance.android.livesdk.gift.model.o3;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.NormalGiftCombViewV2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k {
    public int a;
    public final List<o3> b;
    public final l c;

    public final void a() {
        if (this.a < this.b.size()) goto L5;
        return;
    L5:
        o3 r0 = (o3) ListProtector.get(this.b, this.a);
        boolean r2 = true;
        int r1 = this.a + 1;
        this.a = r1;
        l r3 = this.c;
        if ((r1 - 1) == 0) goto L9;
        r2 = false;
    L9:
        r3.a(r0, r2);
    }

    public k(List r2, NormalGiftCombViewV2.o r3) {
        Intrinsics.checkNotNullParameter(r2, "seriesTrayList");
        Intrinsics.checkNotNullParameter(r3, "seriesTrayCallback");
        this.b = r2;
        this.c = r3;
    }
}
