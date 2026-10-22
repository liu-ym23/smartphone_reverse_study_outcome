package com.bytedance.android.live.effect.sticker.ui.gestureV3;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.sticker.ui.LiveGestureMagicPageAdapter;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import com.ss.android.ugc.effectmanager.effect.model.EffectCategoryResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements LiveGestureMagicPageAdapter.b {
    public final /* synthetic */ LiveGestureMagicDialogFragmentVCD a;

    public e(LiveGestureMagicDialogFragmentVCD r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.sticker.ui.LiveGestureMagicPageAdapter.b
    public final void a(Boolean r18, Sticker r19) {
        boolean r2 = r18.booleanValue();
        m90.c<Long> r3 = m90.b.g;
        LiveEffectContextFactoryDelegate$Type r4 = this.a.e;
        if (r19 == null) goto L5;
        long r5 = r19.getId();
    L6:
        r3.e(r4, Long.valueOf(r5));
        if (r19 != null) goto L10;
        return;
    L10:
        if (LiveGestureMagicDialogFragmentVCD.T90(this.a) == true) goto L13;
        return;
    L13:
        if (StringUtils.isEmpty(r19.getUnzipPath()) == false) goto L16;
        return;
    L16:
        if (r2 == false) goto L74;
        List<String> r6 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.a.e).b().r().q(r19) == false) goto L92;
        LiveGestureMagicDialogFragmentVCD r7 = this.a;
        List<EffectCategoryResponse> r8 = r7.f;
        if (r8 == null) goto L73;
        Iterator<T> r9 = r8.iterator();
    L22:
        String r11 = null;
        if (r9.hasNext() == false) goto L42;
        Object r12 = r9.next();
        Iterator r13 = ((EffectCategoryResponse) r12).getTotalEffects().iterator();
    L26:
        if (r13.hasNext() == false) goto L36;
        Object r14 = r13.next();
        long r15 = r19.getId();
        Long r16 = CastLongProtector.valueOf(((Effect) r14).getEffectId());
        if (r16 != null) goto L31;
    L33:
        boolean r17 = false;
    L34:
        if (r17 == false) goto L26;
    L37:
        if (r14 == null) goto L39;
        boolean r21 = true;
    L40:
        if (r21 == false) goto L22;
    L43:
        EffectCategoryResponse r22 = (EffectCategoryResponse) r12;
        if (r22 == null) goto L73;
        Map<String, Boolean> r23 = m90.b.f.c(r7.e);
        if (r23.containsKey(r22.getId()) == true) goto L49;
    L50:
        r23.put(r22.getId(), Boolean.TRUE);
        Iterator r24 = r22.getTags().iterator();
    L52:
        if (r24.hasNext() == false) goto L56;
        Object r25 = r24.next();
        if (StringsKt.startsWith$default((String) r25, "tip", false, 2, null) == false) goto L52;
    L57:
        String r110 = (String) r25;
        if (r110 == null) goto L71;
        Iterator r26 = StringsKt.split$default(r110, new String[]{":"}, false, 0, 6, null).iterator();
    L62:
        if (r26.hasNext() == false) goto L66;
        Object r27 = r26.next();
        if ((!StringUtils.equal("tip", (String) r27)) == false) goto L62;
    L67:
        String r28 = (String) r27;
        if (r28 == null) goto L71;
        r11 = r28;
        goto L71
    L66:
        r27 = null;
    L71:
        if (r11 == null) goto L73;
        List<String> r29 = LiveEffectContext.h;
        LiveEffectContext.a.a(r7.e).e().a(r11);
        m90.b.f.e(r7.e, r23);
        goto L73
    L56:
        r25 = null;
        goto L57
    L49:
        if ((!Intrinsics.areEqual(r23.get(r22.getId()), Boolean.TRUE)) == false) goto L73;
    L39:
        r21 = false;
        goto L40
    L31:
        if (r15 != r16.longValue()) goto L33;
        r17 = true;
        goto L34
    L36:
        r14 = null;
        goto L37
    L42:
        r12 = null;
    L73:
        ((ILiveEffectComposerManager) this.a.h.getValue()).a(d0.b, r19, "ttlive_anchor_effect_LiveGestureMagicDialogFragmentNewStyle_initAdapter");
        return;
    L92:
        return;
    L74:
        ((ILiveEffectComposerManager) this.a.h.getValue()).O(d0.b, r19, "ttlive_anchor_effect_LiveGestureMagicDialogFragmentNewStyle_initAdapter");
        return;
    L5:
        r5 = 0;
        goto L6
    }
}
