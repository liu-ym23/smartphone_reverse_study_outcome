package com.bytedance.android.live.effect.beauty.presets;

import android.content.DialogInterface;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.beauty.filter.LiveComposerFilterHelper;
import com.bytedance.android.live.effect.utils.LivePresetsLogger;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k implements DialogInterface.OnClickListener {
    public final /* synthetic */ LiveBeautyPresetsFragment a;

    public k(LiveBeautyPresetsFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r19, int r21) {
        LiveBeautyPresetsFragment r0 = this.a;
        int r2 = LiveBeautyPresetsFragment.C;
        r0.T90().getClass();
        LiveBeautyPresetsHelper.n("onResetClick:click confirm");
        if (r19 == null) goto L5;
        r19.dismiss();
    L5:
        LiveBeautyPresetsFragment r3 = this.a;
        LiveBeautyPresetsHelper r1 = r3.T90();
        String r6 = r3.e;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "eventPage");
    L41:
        e = move-exception;
        ALogger.e("LiveBeautyPresetsTrace", "resetAllEffects failed: " + e.getMessage());
    L43:
        m90.c<Boolean> r4 = m90.b.a;
        if (r3.t == true) goto L46;
        boolean r5 = true;
    L47:
        r3.r = r5;
        Boolean r7 = r4.c(r3.d);
        Boolean r8 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r7, r8)) == false) goto L50;
        r4.e(r3.d, r8);
    L50:
        m90.c<Boolean> r9 = m90.b.j;
        if (r3.u == true) goto L53;
        boolean r11 = true;
    L54:
        r3.s = r11;
        if ((!Intrinsics.areEqual(r9.c(r3.d), r8)) == false) goto L57;
        r9.e(r3.d, r8);
    L57:
        List<String> r12 = LiveEffectContext.h;
        LiveEffectContext.a.a(r3.d).a().T("preset_reset", false);
        r3.q = true;
        r3.p = null;
        r3.T90().p("");
        RotateAnimation r13 = new RotateAnimation(0.0f, -360.0f, 1, 0.5f, 1, 0.5f);
        r13.setDuration(600);
        r13.setInterpolator(new AccelerateDecelerateInterpolator());
        r13.setAnimationListener(new m(r3));
        View r14 = r3.j;
        if (r14 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("resetIcon");
    L60:
        r14.startAnimation(r13);
        Long r15 = LivePresetsLogger.a;
        LivePresetsLogger.b("presets", LivePresetsLogger.BtnType.CONFIRM);
        return;
    L53:
        r11 = false;
        goto L54
    L46:
        r5 = false;
        goto L47
    L8:
        if (r1.d.contains(d0.i) == false) goto L22;
        List<Sticker> r16 = r1.k().g().b;     // Catch: Exception -> L41
        List<Sticker> r17 = r1.k().g().a;     // Catch: Exception -> L41
        Iterator r18 = ((CopyOnWriteArrayList) r16).iterator();     // Catch: Exception -> L41
    L11:
        if (r18.hasNext() == false) goto L22;
        Sticker r110 = (Sticker) r18.next();     // Catch: Exception -> L41
        if (r110.isSubItem() == false) goto L20;
        CopyOnWriteArrayList r22 = (CopyOnWriteArrayList) r17;     // Catch: Exception -> L41
        if (r22.contains(r110) == false) goto L18;
        r1.i().a(d0.i, r110, "LiveBeautyPresetsTrace_PresetReset");     // Catch: Exception -> L41
        goto L20
    L18:
        if (r22.contains(r110) == true) goto L20;
        r1.i().O(d0.i, r110, "LiveBeautyPresetsTrace_PresetReset");     // Catch: Exception -> L41
    L20:
        ILiveEffectComposerManager r111 = r1.i();     // Catch: Exception -> L41
        String r112 = d0.i;     // Catch: Exception -> L41
        Sticker.ComposerConfig r23 = r110.getSmallItemConfig();     // Catch: Exception -> L41
        Intrinsics.checkNotNull(r23);     // Catch: Exception -> L41
        String r113 = r23.getTag();     // Catch: Exception -> L41
        Sticker.ComposerConfig r24 = r110.getSmallItemConfig();     // Catch: Exception -> L41
        Intrinsics.checkNotNull(r24);     // Catch: Exception -> L41
        ILiveEffectComposerManager.f.d(r111, r112, r110, r113, com.bytedance.android.live.effect.q.d(r110, r24.getDefaultValue()), null, 48);     // Catch: Exception -> L41
    L22:
        if (r1.d.contains(d0.k) == false) goto L25;
        com.bytedance.android.live.effect.beauty.makeups.a.C0185a.a(r1.k().f(), null, "LiveBeautyPresetsTrace_PresetReset");     // Catch: Exception -> L41
    L25:
        if (r1.d.contains(d0.a) == false) goto L28;
        LiveComposerFilterHelper.a(r1.k().m(), null, "LiveBeautyPresetsTrace_PresetReset", r6, false, false, 56);     // Catch: Exception -> L41
    L28:
        if (r1.d.contains("livebody") == false) goto L34;
        Iterator r25 = CollectionsKt.toList(r1.k().p().a).iterator();     // Catch: Exception -> L41
    L31:
        if (r25.hasNext() == false) goto L34;
        Sticker r114 = (Sticker) r25.next();     // Catch: Exception -> L41
        ILiveEffectComposerManager r115 = r1.i();     // Catch: Exception -> L41
        Sticker.ComposerConfig r26 = r114.getSmallItemConfig();     // Catch: Exception -> L41
        Intrinsics.checkNotNull(r26);     // Catch: Exception -> L41
        String r116 = r26.getTag();     // Catch: Exception -> L41
        Sticker.ComposerConfig r27 = r114.getSmallItemConfig();     // Catch: Exception -> L41
        Intrinsics.checkNotNull(r27);     // Catch: Exception -> L41
        ILiveEffectComposerManager.f.d(r115, "livebody", r114, r116, com.bytedance.android.live.effect.q.d(r114, r27.getDefaultValue()), null, 48);     // Catch: Exception -> L41
    L34:
        if (r1.d.contains("live_adjustment") == false) goto L39;
        Iterator r28 = ((CopyOnWriteArrayList) r1.k().n().b).iterator();     // Catch: Exception -> L41
    L37:
        if (r28.hasNext() == false) goto L39;
        Sticker r117 = (Sticker) r28.next();     // Catch: Exception -> L41
        ILiveEffectComposerManager r118 = r1.i();     // Catch: Exception -> L41
        Sticker.ComposerConfig r29 = r117.getSmallItemConfig();     // Catch: Exception -> L41
        Intrinsics.checkNotNull(r29);     // Catch: Exception -> L41
        String r119 = r29.getTag();     // Catch: Exception -> L41
        Sticker.ComposerConfig r31 = r117.getSmallItemConfig();     // Catch: Exception -> L41
        Intrinsics.checkNotNull(r31);     // Catch: Exception -> L41
        ILiveEffectComposerManager.f.d(r118, "live_adjustment", r117, r119, com.bytedance.android.live.effect.q.d(r117, r31.getDefaultValue()), null, 48);     // Catch: Exception -> L41
    L39:
        r1.c = null;     // Catch: Exception -> L41
        goto L43
    }
}
