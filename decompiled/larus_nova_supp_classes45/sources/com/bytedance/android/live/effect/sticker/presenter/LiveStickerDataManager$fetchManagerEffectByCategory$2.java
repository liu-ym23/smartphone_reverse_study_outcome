package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"handleEffects", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", NewBroadcastMonitor.STAGE.EFFECT, "childs", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveStickerDataManager$fetchManagerEffectByCategory$2 extends Lambda implements Function2<Effect, List<? extends Effect>, Effect> {
    public static final LiveStickerDataManager$fetchManagerEffectByCategory$2 INSTANCE = null;

    static {
        INSTANCE = new LiveStickerDataManager$fetchManagerEffectByCategory$2();
    }

    public LiveStickerDataManager$fetchManagerEffectByCategory$2() {
        super(2);
    }

    public final Effect invoke(Effect r7, List<? extends Effect> r8) {
        Intrinsics.checkNotNullParameter(r7, NewBroadcastMonitor.STAGE.EFFECT);
        Intrinsics.checkNotNullParameter(r8, "childs");
        if (r8.isEmpty() == false) goto L5;
        return r7;
    L5:
        ArrayList r0 = new ArrayList();
        List r1 = r7.getChildren();
        if (r1 == null) goto L20;
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L20;
        String r3 = (String) r2.next();
        Iterator<T> r4 = r8.iterator();
    L12:
        if (r4.hasNext() == false) goto L16;
        Object r5 = r4.next();
        if (Intrinsics.areEqual(((Effect) r5).getEffectId(), r3) == false) goto L12;
    L17:
        Effect r6 = (Effect) r5;
        if (r6 == null) goto L9;
        r0.add(r6);
        goto L9
    L16:
        r5 = null;
    L20:
        r7.setChildEffects(r0);
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Effect) r1, (List) r2);
    }
}
