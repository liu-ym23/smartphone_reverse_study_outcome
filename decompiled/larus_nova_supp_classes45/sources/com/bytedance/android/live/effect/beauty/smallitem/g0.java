package com.bytedance.android.live.effect.beauty.smallitem;

import android.view.View;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g0 implements View.OnClickListener {
    public final /* synthetic */ LiveSmallItemBeautyTemplateAdapter a;
    public final /* synthetic */ LiveSmallItemBeautyTemplateAdapter.AbsSmallItemViewHolder b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Function1 d;

    public g0(LiveSmallItemBeautyTemplateAdapter r1, LiveSmallItemBeautyTemplateAdapter.AbsSmallItemViewHolder r2, boolean r3, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.a.n == true) goto L5;
        return;
    L5:
        int r5 = this.b.getAdapterPosition() - 1;
        if (r5 >= 0) goto L8;
        return;
    L8:
        if (r5 >= ((ArrayList) this.a.a).size()) goto L49;
        List<String> r1 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.a.m).b().r().q((Sticker) ListProtector.get(this.a.a, r5)) == true) goto L16;
        if (this.c == true) goto L16;
        return;
    L16:
        if (this.c == true) goto L22;
        List r2 = ((Sticker) ListProtector.get(this.a.a, r5)).getSubStickers();
        if (r2 != null) goto L20;
    L24:
        LiveSmallItemBeautyTemplateAdapter r3 = this.a;
        r3.d = r5;
        if (this.c == false) goto L37;
        r3.f.put(r5, Boolean.TRUE);
        LiveSmallItemBeautyTemplateAdapter r6 = this.a;
        LiveSmallItemBeautyTemplateAdapter.a r7 = r6.e;
        if (r7 == null) goto L30;
        r7.c(r6.d);
    L30:
        if (((Sticker) ListProtector.get(this.a.a, r5)).getSubStickers() != null) goto L33;
        return;
    L33:
        if (this.a.y2(r5) < 0) goto L40;
        List r8 = ((Sticker) ListProtector.get(this.a.a, r5)).getSubStickers();
        if (r8 == null) goto L40;
        r8.size();
    L40:
        LiveSmallItemBeautyTemplateAdapter r9 = this.a;
        r9.n = true;
        LiveSmallItemBeautyTemplateAdapter.a r11 = r9.e;
        if (r11 == null) goto L43;
        r11.b(true);
    L43:
        LiveSmallItemBeautyTemplateAdapter r12 = this.a;
        LiveSmallItemBeautyTemplateAdapter.a r13 = r12.e;
        if (r13 == null) goto L48;
        r13.d((Sticker) ListProtector.get(r12.a, r5), r5 + 1);
        return;
    L48:
        return;
    L37:
        LiveSmallItemBeautyTemplateAdapter.a r14 = r3.e;
        if (r14 == null) goto L40;
        r14.a((Sticker) ListProtector.get(r3.a, r5));
        goto L40
    L20:
        if ((!r2.isEmpty()) != true) goto L24;
    L22:
        if (((Boolean) this.d.invoke(ListProtector.get(this.a.a, r5))).booleanValue() == false) goto L24;
        return;
    }
}
