package com.bytedance.android.live.effect.beauty.smallitem;

import android.content.DialogInterface;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.effect.utils.LivePresetsLogger;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ LiveSmallItemBeautyFragment a;

    public c0(LiveSmallItemBeautyFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r12, int r13) {
        if (r12 == null) goto L4;
        r12.dismiss();
    L4:
        LiveSmallItemBeautyFragment r14 = this.a;
        int r15 = LiveSmallItemBeautyFragment.y;
        LiveSmallItemBeautyAdapter r16 = r14.T90();
        boolean r0 = true;
        r16.l = true;
        r16.notifyItemChanged(0);
        List<String> r17 = LiveEffectContext.h;
        List<Sticker> r18 = LiveEffectContext.a.a(r14.k).b().g().b;
        List<Sticker> r2 = LiveEffectContext.a.a(r14.k).b().g().a;
        Iterator r19 = ((CopyOnWriteArrayList) r18).iterator();
    L6:
        if (r19.hasNext() == false) goto L22;
        Sticker r3 = (Sticker) r19.next();
        if (r3.isSubItem() == false) goto L15;
        CopyOnWriteArrayList r4 = (CopyOnWriteArrayList) r2;
        if (r4.contains(r3) == false) goto L13;
        List<String> r5 = LiveEffectContext.h;
        LiveEffectContext.a.a(r14.k).a().a(com.bytedance.android.live.effect.api.d0.i, r3, "ttlive_anchor_effect_LiveSmallItemBeautyFragment_reset");
        goto L15
    L13:
        if (r4.contains(r3) == true) goto L15;
        List<String> r6 = LiveEffectContext.h;
        LiveEffectContext.a.a(r14.k).a().O(com.bytedance.android.live.effect.api.d0.i, r3, "ttlive_anchor_effect_LiveSmallItemBeautyFragment_reset");
    L15:
        List<String> r7 = LiveEffectContext.h;
        ILiveEffectComposerManager r8 = LiveEffectContext.a.a(r14.k).a();
        String r9 = com.bytedance.android.live.effect.api.d0.i;
        Sticker.ComposerConfig r11 = r3.getSmallItemConfig();
        Intrinsics.checkNotNull(r11);
        String r21 = r11.getTag();
        Sticker.ComposerConfig r22 = r3.getSmallItemConfig();
        Intrinsics.checkNotNull(r22);
        ILiveEffectComposerManager.f.d(r8, r9, r3, r21, com.bytedance.android.live.effect.q.d(r3, r22.getDefaultValue()), null, 48);
        String r23 = r3.getEffectId();
        Sticker r24 = r14.f;
        if (r24 == null) goto L18;
        String r25 = r24.getEffectId();
    L20:
        if (Intrinsics.areEqual(r23, r25) == false) goto L6;
        AdjustPercentBar r26 = r14.U90();
        Sticker.ComposerConfig r27 = r3.getSmallItemConfig();
        Intrinsics.checkNotNull(r27);
        r26.setPercent(r27.getDefaultValue());
        goto L6
    L18:
        r25 = null;
        goto L20
    L22:
        LiveSmallItemBeautyAdapter r110 = r14.T90();
        if (((ArrayList) r110.a).size() <= 0) goto L39;
        Effect r28 = ((Sticker) ListProtector.get(r110.a, 0)).getEffect();
        if (r28 != null) goto L28;
    L32:
        r0 = false;
    L33:
        r110.b = 0;
        if (r0 == false) goto L36;
        r110.d.put(0, Boolean.TRUE);
        ((Sticker) ListProtector.get(r110.a, 0)).getSubStickers();
        goto L39
    L36:
        LiveSmallItemBeautyAdapter.a r1 = r110.c;
        if (r1 == null) goto L39;
        r1.a((Sticker) ListProtector.get(r110.a, 0));
        goto L39
    L28:
        if (r28.getEffectType() != 1) goto L32;
        if (CollectionUtils.isEmpty(((Sticker) ListProtector.get(r110.a, 0)).getSubStickers()) == true) goto L32;
    L39:
        r14.T90().notifyDataSetChanged();
        RecyclerView r111 = r14.S90(2131386948);
        if (r111 == null) goto L42;
        r111.scrollToPosition(0);
    L42:
        RotateAnimation r112 = new RotateAnimation(0.0f, -360.0f, 1, 0.5f, 1, 0.5f);
        r112.setDuration(600);
        r112.setInterpolator(new AccelerateDecelerateInterpolator());
        View r29 = r14.v;
        if (r29 == null) goto L45;
        r29.startAnimation(r112);
    L45:
        r14.W90("live_beauty_reset_confirm");
        Long r113 = LivePresetsLogger.a;
        LivePresetsLogger.b(FileUtils.BEAUTY, LivePresetsLogger.BtnType.CONFIRM);
    }
}
