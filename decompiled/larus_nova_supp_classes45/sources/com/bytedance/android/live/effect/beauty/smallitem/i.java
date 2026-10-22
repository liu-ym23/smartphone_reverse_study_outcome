package com.bytedance.android.live.effect.beauty.smallitem;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.utils.LiveEffectMonitor;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements LiveSmallItemBeautyTemplateAdapter.a {
    public final /* synthetic */ LiveBeautySecondLevelFragment a;
    public final /* synthetic */ LiveSmallItemBeautyTemplateAdapter b;

    @Override // com.bytedance.android.live.effect.beauty.smallitem.LiveSmallItemBeautyTemplateAdapter.a
    public final void a(Sticker r3) {
        LiveBeautySecondLevelFragment r0 = this.a;
        r0.e = r3;
        r0.Z90("ttlive_anchor_effect_LiveBeautySecondLevelFragment_beautyItemChange");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isSubItem() == false) goto L9;
        int r4 = d.e;
        d.a.a(this.a.k);
        return;
    }

    @Override // com.bytedance.android.live.effect.beauty.smallitem.LiveSmallItemBeautyTemplateAdapter.a
    public final void b(boolean r7) {
        Boolean r0 = Boolean.valueOf(r7);
        m90.c<Boolean> r1 = m90.b.a;
        if ((!Intrinsics.areEqual(r0, r1.c(this.a.k))) == false) goto L9;
        List<String> r2 = LiveEffectContext.h;
        com.bytedance.android.live.effect.api.c r3 = LiveEffectContext.a.a(this.a.k).e();
        HashMap<String, String> r4 = new HashMap();
        if (r7 == false) goto L7;
        String r5 = "on";
    L8:
        r4.put("status", r5);
        Unit r6 = Unit.INSTANCE;
        r3.sendLog("livesdk_enable_beautify", r4);
        PthreadHandlerThreadV2 r8 = LiveEffectMonitor.a;
        LiveEffectMonitor.a(r7);
        goto L9
    L7:
        r5 = "off";
    L9:
        r1.e(this.a.k, Boolean.valueOf(r7));
        xs2.b.a().post(new n90.c(r7, com.bytedance.android.live.effect.api.d0.i));
        m90.c<Integer> r9 = m90.b.A;
        Integer r11 = r9.c(this.a.k);
        if (r7 == true) goto L16;
        if (r11 == null) goto L16;
        if (r11.intValue() != 0) goto L16;
        r9.e(this.a.k, 1);
    L22:
        this.a.Z90("ttlive_anchor_effect_LiveBeautySecondLevelFragment_beautyEnableChange");
        if (r7 == true) goto L25;
        f2.c("美颜效果已关闭", 0);
        int r12 = d.e;
        d.a.a(this.a.k);
    L25:
        this.b.notifyDataSetChanged();
        List<String> r13 = LiveEffectContext.h;
        LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).e().d(false);
        return;
    L16:
        if (r7 == false) goto L22;
        if (r11 == null) goto L22;
        if (r11.intValue() != 1) goto L22;
        r9.e(this.a.k, 2);
        goto L22
    }

    @Override // com.bytedance.android.live.effect.beauty.smallitem.LiveSmallItemBeautyTemplateAdapter.a
    public final void c(int r3) {
        if (r3 >= 0) goto L4;
        return;
    L4:
        LinearLayoutManager r0 = this.a.S90(2131386948).getLayoutManager();
        if (r0 == null) goto L9;
        r0.scrollToPositionWithOffset(r3, 0);
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }

    public i(LiveBeautySecondLevelFragment r1, LiveSmallItemBeautyTemplateAdapter r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.effect.beauty.smallitem.LiveSmallItemBeautyTemplateAdapter.a
    public final void d(Sticker r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "sticker");
        int r6 = LiveBeautySecondLevelFragment.T90(this.a, r5);
        LiveBeautySecLevelSlidingTab r0 = (LiveBeautySecLevelSlidingTab) this.a.S90(2131364572);
        if (r0 == null) goto L6;
        List<String> r1 = r0.getDatas();
        if (r1 == null) goto L6;
    L7:
        if (r6 >= 0) goto L9;
        return;
    L9:
        if (r6 >= r1.size()) goto L20;
        Disposable r2 = com.bytedance.android.live.effect.utils.k.a;
        String r7 = (String) ListProtector.get(r1, r6);
        String r3 = "";
        if (r7 != null) goto L13;
        r7 = "";
    L13:
        String r8 = r4.getName();
        if (r8 == null) goto L17;
        r3 = r8;
    L17:
        String r9 = this.a.m;
        Intrinsics.checkNotNullParameter(r7, "tabName");
        Intrinsics.checkNotNullParameter(r3, "effectName");
        Intrinsics.checkNotNullParameter(r9, "eventPage");
        HashMap r11 = new HashMap();
        r11.put("tab_name", r7);
        r11.put("effect_name", r3);
        Unit r12 = Unit.INSTANCE;
        com.bytedance.android.live.effect.utils.c.a("livesdk_beauty_icon_click", r11, r9);
        return;
    L20:
        return;
    L6:
        r1 = CollectionsKt.emptyList();
        goto L7
    }
}
