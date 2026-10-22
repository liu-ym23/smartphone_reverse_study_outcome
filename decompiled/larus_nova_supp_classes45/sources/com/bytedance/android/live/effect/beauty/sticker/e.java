package com.bytedance.android.live.effect.beauty.sticker;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.effect.sticker.k;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements k.b {
    public final /* synthetic */ LiveStickerBeautyFragment a;

    public e(LiveStickerBeautyFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.sticker.k.b
    public final void a(List<? extends Effect> r9) {
        Intrinsics.checkNotNullParameter(r9, "effectList");
        LiveStickerBeautyFragment r0 = this.a;
        int r1 = LiveStickerBeautyFragment.o;
        if (r0.isDestroyed() == true) goto L21;
        LiveStickerListAdapter r2 = r0.U90();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r9, NewBroadcastMonitor.STAGE.EFFECT);
        ((ArrayList) r2.m).clear();
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator<T> r11 = r9.iterator();
    L7:
        if (r11.hasNext() == false) goto L9;
        Sticker r4 = com.bytedance.android.live.effect.sticker.d.b((Effect) r11.next());
        r4.setTopTips("主播在用");
        r3.add(r4);
        goto L7
    L9:
        ((ArrayList) r2.m).addAll(r3);
        if (r2.i == false) goto L12;
    L17:
        r0.U90().notifyDataSetChanged();
        return;
    L12:
        if (((ArrayList) r2.b).size() <= 1) goto L17;
        Iterator r12 = ((ArrayList) r2.m).iterator();
        int r5 = 1;
    L15:
        if (r12.hasNext() == false) goto L17;
        Sticker r6 = (Sticker) r12.next();
        ListProtector.add(r2.b, r5, r6);
        ListProtector.add(r2.c, r5, Long.valueOf(r6.getId()));
        r5 = r5 + 1;
        goto L15
    }
}
