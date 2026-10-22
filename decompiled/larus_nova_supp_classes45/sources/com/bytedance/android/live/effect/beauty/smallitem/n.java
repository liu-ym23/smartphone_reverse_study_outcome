package com.bytedance.android.live.effect.beauty.smallitem;

import android.content.DialogInterface;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.base.BeautifyAdjustPercentBar;
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
public final class n implements DialogInterface.OnClickListener {
    public final /* synthetic */ LiveBeautySecondLevelFragment a;

    public n(LiveBeautySecondLevelFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r12, int r13) {
        if (r12 == null) goto L4;
        r12.dismiss();
    L4:
        LiveBeautySecondLevelFragment r14 = this.a;
        int r15 = LiveBeautySecondLevelFragment.C;
        LiveSmallItemBeautyTemplateAdapter r16 = r14.V90();
        boolean r0 = true;
        r16.n = true;
        r16.notifyItemChanged(0);
        List<String> r17 = LiveEffectContext.h;
        List<Sticker> r18 = LiveEffectContext.a.a(r14.k).b().g().e;
        List<Sticker> r2 = LiveEffectContext.a.a(r14.k).b().g().f;
        Iterator r19 = ((ArrayList) r18).iterator();
    L6:
        if (r19.hasNext() == false) goto L34;
        Sticker r3 = (Sticker) r19.next();
        if (r3.isSubItem() == false) goto L15;
        CopyOnWriteArrayList r4 = (CopyOnWriteArrayList) r2;
        if (r4.contains(r3) == false) goto L13;
        List<String> r5 = LiveEffectContext.h;
        LiveEffectContext.a.a(r14.k).a().a(com.bytedance.android.live.effect.api.d0.i, r3, "ttlive_anchor_effect_LiveBeautySecondLevelFragment_reset");
        goto L15
    L13:
        if (r4.contains(r3) == true) goto L15;
        List<String> r6 = LiveEffectContext.h;
        LiveEffectContext.a.a(r14.k).a().O(com.bytedance.android.live.effect.api.d0.i, r3, "ttlive_anchor_effect_LiveBeautySecondLevelFragment_reset");
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
        Sticker r24 = r14.e;
        Object r25 = null;
        if (r24 == null) goto L18;
        String r26 = r24.getEffectId();
    L20:
        if (Intrinsics.areEqual(r23, r26) == true) goto L27;
        String r27 = r3.getResourceId();
        Sticker r28 = r14.e;
        if (r28 == null) goto L24;
        String r29 = r28.getResourceId();
    L26:
        if (Intrinsics.areEqual(r27, r29) == false) goto L6;
    L24:
        r29 = null;
    L27:
        View r31 = r14.Y90();
        if ((r31 instanceof BeautifyAdjustPercentBar) == false) goto L31;
        r25 = r31;
    L31:
        BeautifyAdjustPercentBar r32 = (BeautifyAdjustPercentBar) r25;
        if (r32 == null) goto L6;
        Sticker.ComposerConfig r33 = r3.getSmallItemConfig();
        Intrinsics.checkNotNull(r33);
        r32.setPercent(r33.getDefaultValue());
        goto L6
    L18:
        r26 = null;
        goto L20
    L34:
        LiveSmallItemBeautyTemplateAdapter r110 = r14.V90();
        if (((ArrayList) r110.a).size() <= 0) goto L51;
        Effect r34 = ((Sticker) ListProtector.get(r110.a, 0)).getEffect();
        if (r34 != null) goto L40;
    L44:
        r0 = false;
    L45:
        r110.d = 0;
        if (r0 == false) goto L48;
        r110.f.put(0, Boolean.TRUE);
        ((Sticker) ListProtector.get(r110.a, 0)).getSubStickers();
        goto L51
    L48:
        LiveSmallItemBeautyTemplateAdapter.a r1 = r110.e;
        if (r1 == null) goto L51;
        r1.a((Sticker) ListProtector.get(r110.a, 0));
        goto L51
    L40:
        if (r34.getEffectType() != 1) goto L44;
        if (CollectionUtils.isEmpty(((Sticker) ListProtector.get(r110.a, 0)).getSubStickers()) == true) goto L44;
    L51:
        r14.V90().notifyDataSetChanged();
        RecyclerView r111 = r14.S90(2131386948);
        if (r111 == null) goto L54;
        r111.scrollToPosition(0);
    L54:
        LiveBeautySecLevelSlidingTab r112 = (LiveBeautySecLevelSlidingTab) r14.S90(2131364572);
        if (r112 == null) goto L57;
        r112.b(0);
    L57:
        RotateAnimation r113 = new RotateAnimation(0.0f, -360.0f, 1, 0.5f, 1, 0.5f);
        r113.setDuration(600);
        r113.setInterpolator(new AccelerateDecelerateInterpolator());
        r113.setAnimationListener(new p(r14));
        View r35 = r14.v;
        if (r35 == null) goto L60;
        r35.startAnimation(r113);
    L60:
        int r114 = d.e;
        d.a.a(r14.k);
        r14.ba0("live_beauty_reset_confirm");
    }
}
