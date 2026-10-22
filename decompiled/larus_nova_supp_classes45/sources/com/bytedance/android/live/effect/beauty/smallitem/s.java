package com.bytedance.android.live.effect.beauty.smallitem;

import android.util.SparseArray;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s implements LiveSmallSubItemBeautyAdapter.a {
    public final /* synthetic */ LiveSmallItemBeautyAdapter a;
    public final /* synthetic */ int b;

    @Override // com.bytedance.android.live.effect.beauty.smallitem.LiveSmallSubItemBeautyAdapter.a
    public final void a(Sticker r4) {
        Intrinsics.checkNotNullParameter(r4, "sticker");
        LiveSmallItemBeautyAdapter.a r0 = this.a.c;
        if (r0 == null) goto L5;
        r0.a(r4);
    L5:
        LiveSmallItemBeautyAdapter r1 = this.a;
        SparseArray<Integer> r2 = r1.e;
        int r3 = this.b;
        List r5 = ((Sticker) ListProtector.get(r1.a, r3)).getSubStickers();
        if (r5 == null) goto L8;
        Integer r6 = Integer.valueOf(r5.indexOf(r4));
    L9:
        r2.put(r3, r6);
        return;
    L8:
        r6 = null;
        goto L9
    }

    public s(LiveSmallItemBeautyAdapter r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
