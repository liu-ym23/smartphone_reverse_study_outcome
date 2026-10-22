package com.bytedance.android.live.effect.beauty.smallitem;

import android.util.SparseArray;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e0 implements LiveSmallSubItemBeautyAdapter.a {
    public final /* synthetic */ LiveSmallItemBeautyTemplateAdapter a;
    public final /* synthetic */ int b;

    @Override // com.bytedance.android.live.effect.beauty.smallitem.LiveSmallSubItemBeautyAdapter.a
    public final void a(Sticker r4) {
        Intrinsics.checkNotNullParameter(r4, "sticker");
        LiveSmallItemBeautyTemplateAdapter.a r0 = this.a.e;
        if (r0 == null) goto L5;
        r0.a(r4);
    L5:
        LiveSmallItemBeautyTemplateAdapter.a r1 = this.a.e;
        if (r1 == null) goto L8;
        r1.d(r4, this.b + 1);
    L8:
        LiveSmallItemBeautyTemplateAdapter r2 = this.a;
        SparseArray<Integer> r3 = r2.g;
        int r5 = this.b;
        List r6 = ((Sticker) ListProtector.get(r2.a, r5)).getSubStickers();
        if (r6 == null) goto L11;
        Integer r7 = Integer.valueOf(r6.indexOf(r4));
    L12:
        r3.put(r5, r7);
        return;
    L11:
        r7 = null;
        goto L12
    }

    public e0(LiveSmallItemBeautyTemplateAdapter r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
