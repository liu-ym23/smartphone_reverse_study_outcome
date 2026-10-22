package com.bytedance.android.live.effect.avadjust;

import android.content.DialogInterface;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import androidx.recyclerview.widget.RecyclerView;
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
public final class i implements DialogInterface.OnClickListener {
    public final /* synthetic */ LiveColorAdjustFragment a;

    public i(LiveColorAdjustFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r11, int r12) {
        if (r11 == null) goto L4;
        r11.dismiss();
    L4:
        LiveColorAdjustFragment r13 = this.a;
        int r14 = LiveColorAdjustFragment.r;
        r13.getClass();
        List<String> r15 = LiveEffectContext.h;
        Iterator r16 = ((CopyOnWriteArrayList) LiveEffectContext.a.a(r13.p).b().n().b).iterator();
    L6:
        if (r16.hasNext() == false) goto L16;
        Sticker r0 = (Sticker) r16.next();
        Sticker.ComposerConfig r1 = r0.getSmallItemConfig();
        if (r1 == null) goto L6;
        List<String> r2 = LiveEffectContext.h;
        ILiveEffectComposerManager.f.d(LiveEffectContext.a.a(r13.p).a(), "live_adjustment", r0, r1.getTag(), com.bytedance.android.live.effect.q.d(r0, r1.getDefaultValue()), null, 48);
        String r3 = r0.getEffectId();
        Sticker r4 = r13.e;
        if (r4 == null) goto L12;
        String r5 = r4.getEffectId();
    L14:
        if (Intrinsics.areEqual(r3, r5) == false) goto L6;
        AdjustPercentBar r6 = (AdjustPercentBar) r13.S90(2131367174);
        Sticker.ComposerConfig r7 = r0.getSmallItemConfig();
        Intrinsics.checkNotNull(r7);
        r6.setPercent(r7.getDefaultValue());
        goto L6
    L12:
        r5 = null;
        goto L14
    L16:
        LiveColorAdjustAdapter r17 = r13.U90();
        if (((ArrayList) r17.a).size() <= 0) goto L33;
        Effect r8 = ((Sticker) ListProtector.get(r17.a, 0)).getEffect();
        if (r8 == null) goto L26;
        boolean r9 = true;
        if (r8.getEffectType() != 1) goto L26;
        if (CollectionUtils.isEmpty(((Sticker) ListProtector.get(r17.a, 0)).getSubStickers()) == true) goto L26;
    L27:
        r17.c = 0;
        if (r9 == false) goto L30;
        r17.e.put(0, Boolean.TRUE);
        ((Sticker) ListProtector.get(r17.a, 0)).getSubStickers();
        goto L33
    L30:
        LiveColorAdjustAdapter.a r18 = r17.d;
        if (r18 == null) goto L33;
        r18.a((Sticker) ListProtector.get(r17.a, 0));
    L26:
        r9 = false;
    L33:
        r13.U90().notifyDataSetChanged();
        RecyclerView r19 = r13.S90(2131386948);
        if (r19 == null) goto L36;
        r19.scrollToPosition(0);
    L36:
        RotateAnimation r110 = new RotateAnimation(0.0f, -360.0f, 1, 0.5f, 1, 0.5f);
        r110.setDuration(600);
        r110.setInterpolator(new AccelerateDecelerateInterpolator());
        r110.setAnimationListener(new k(r13));
        View r111 = r13.j;
        if (r111 == null) goto L39;
        r111.startAnimation(r110);
    L39:
        Long r112 = LivePresetsLogger.a;
        LivePresetsLogger.b("adjust", LivePresetsLogger.BtnType.CONFIRM);
    }
}
