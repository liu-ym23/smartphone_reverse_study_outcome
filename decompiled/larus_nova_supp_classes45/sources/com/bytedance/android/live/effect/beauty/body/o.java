package com.bytedance.android.live.effect.beauty.body;

import android.content.DialogInterface;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.base.AdjustPercentBar;
import com.bytedance.android.live.effect.base.BeautifyAdjustPercentBar;
import com.bytedance.android.live.effect.utils.LivePresetsLogger;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o implements DialogInterface.OnClickListener {
    public final /* synthetic */ LiveBodyBeautyListFragment a;

    public o(LiveBodyBeautyListFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r11, int r12) {
        if (r11 == null) goto L4;
        r11.dismiss();
    L4:
        LiveBodyBeautyListFragment r13 = this.a;
        int r14 = LiveBodyBeautyListFragment.y;
        LiveBodyBeautyAdapter r15 = r13.U90();
        boolean r0 = true;
        r15.m = true;
        r15.notifyItemChanged(0);
        List<String> r16 = LiveEffectContext.h;
        Iterator r17 = CollectionsKt.toList(LiveEffectContext.a.a(r13.l).b().p().a).iterator();
    L6:
        if (r17.hasNext() == false) goto L31;
        Sticker r2 = (Sticker) r17.next();
        List<String> r3 = LiveEffectContext.h;
        ILiveEffectComposerManager r4 = LiveEffectContext.a.a(r13.l).a();
        Sticker.ComposerConfig r5 = r2.getSmallItemConfig();
        Intrinsics.checkNotNull(r5);
        String r6 = r5.getTag();
        Sticker.ComposerConfig r7 = r2.getSmallItemConfig();
        Intrinsics.checkNotNull(r7);
        ILiveEffectComposerManager.f.d(r4, "livebody", r2, r6, com.bytedance.android.live.effect.q.d(r2, r7.getDefaultValue()), null, 48);
        String r8 = r2.getEffectId();
        Sticker r9 = r13.f;
        Object r18 = null;
        if (r9 == null) goto L10;
        String r19 = r9.getEffectId();
    L12:
        if (Intrinsics.areEqual(r8, r19) == false) goto L6;
        if ((r13.W90() instanceof BeautifyAdjustPercentBar) == true) goto L15;
        if ((r13.W90() instanceof AdjustPercentBar) == false) goto L6;
        View r21 = r13.W90();
        if ((r21 instanceof AdjustPercentBar) == false) goto L28;
        r18 = r21;
    L28:
        AdjustPercentBar r22 = (AdjustPercentBar) r18;
        if (r22 == null) goto L6;
        Sticker.ComposerConfig r23 = r2.getSmallItemConfig();
        Intrinsics.checkNotNull(r23);
        r22.setPercent(r23.getDefaultValue());
        goto L6
    L15:
        View r24 = r13.W90();
        if ((r24 instanceof BeautifyAdjustPercentBar) == false) goto L19;
        r18 = r24;
    L19:
        BeautifyAdjustPercentBar r25 = (BeautifyAdjustPercentBar) r18;
        if (r25 == null) goto L6;
        Sticker.ComposerConfig r26 = r2.getSmallItemConfig();
        Intrinsics.checkNotNull(r26);
        r25.setPercent(r26.getDefaultValue());
        goto L6
    L10:
        r19 = null;
        goto L12
    L31:
        LiveBodyBeautyAdapter r110 = r13.U90();
        if (((ArrayList) r110.a).size() <= 0) goto L48;
        Effect r27 = ((Sticker) ListProtector.get(r110.a, 0)).getEffect();
        if (r27 != null) goto L37;
    L41:
        r0 = false;
    L42:
        r110.c = 0;
        if (r0 == false) goto L45;
        r110.e.put(0, Boolean.TRUE);
        ((Sticker) ListProtector.get(r110.a, 0)).getSubStickers();
        goto L48
    L45:
        LiveBodyBeautyAdapter.a r1 = r110.d;
        if (r1 == null) goto L48;
        r1.a((Sticker) ListProtector.get(r110.a, 0));
        goto L48
    L37:
        if (r27.getEffectType() != 1) goto L41;
        if (CollectionUtils.isEmpty(((Sticker) ListProtector.get(r110.a, 0)).getSubStickers()) == true) goto L41;
    L48:
        r13.U90().notifyDataSetChanged();
        RecyclerView r111 = r13.S90(2131386948);
        if (r111 == null) goto L51;
        r111.scrollToPosition(0);
    L51:
        RotateAnimation r112 = new RotateAnimation(0.0f, -360.0f, 1, 0.5f, 1, 0.5f);
        r112.setDuration(600);
        r112.setInterpolator(new AccelerateDecelerateInterpolator());
        r112.setAnimationListener(new q(r13));
        View r113 = r13.w;
        if (r113 == null) goto L54;
        r113.startAnimation(r112);
    L54:
        int r114 = com.bytedance.android.live.effect.utils.a.a;
        HashMap r115 = new HashMap();
        r115.put("is_reset", GamePromoteDataContext.GAME_TYPE_MOBILE);
        com.bytedance.android.live.effect.utils.c.a("livesdk_anchor_beautybody_reset_confirm", r115, "");
        Long r116 = LivePresetsLogger.a;
        LivePresetsLogger.b("beautybody", LivePresetsLogger.BtnType.CONFIRM);
    }
}
