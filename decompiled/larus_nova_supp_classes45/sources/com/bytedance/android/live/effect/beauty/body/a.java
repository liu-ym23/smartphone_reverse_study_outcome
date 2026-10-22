package com.bytedance.android.live.effect.beauty.body;

import android.util.SparseArray;
import com.bytedance.android.live.effect.beauty.smallitem.LiveSmallSubItemBeautyAdapter;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements LiveSmallSubItemBeautyAdapter.a {
    public final /* synthetic */ LiveBodyBeautyAdapter a;
    public final /* synthetic */ int b;

    @Override // com.bytedance.android.live.effect.beauty.smallitem.LiveSmallSubItemBeautyAdapter.a
    public final void a(Sticker r4) {
        Intrinsics.checkNotNullParameter(r4, "sticker");
        LiveBodyBeautyAdapter.a r0 = this.a.d;
        if (r0 == null) goto L5;
        r0.a(r4);
    L5:
        LiveBodyBeautyAdapter r1 = this.a;
        if (r1.n == false) goto L10;
        LiveBodyBeautyAdapter.a r2 = r1.d;
        if (r2 == null) goto L10;
        r2.c((Sticker) ListProtector.get(r1.a, this.b));
    L10:
        LiveBodyBeautyAdapter r3 = this.a;
        SparseArray<Integer> r5 = r3.f;
        int r6 = this.b;
        List r7 = ((Sticker) ListProtector.get(r3.a, r6)).getSubStickers();
        if (r7 == null) goto L13;
        Integer r8 = Integer.valueOf(r7.indexOf(r4));
    L14:
        r5.put(r6, r8);
        return;
    L13:
        r8 = null;
        goto L14
    }

    public a(LiveBodyBeautyAdapter r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
