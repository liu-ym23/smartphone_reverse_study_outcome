package com.bytedance.android.live.effect.beauty.body;

import android.view.View;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.beauty.smallitem.LiveSmallItemBeautyAdapter;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ LiveBodyBeautyAdapter a;
    public final /* synthetic */ LiveSmallItemBeautyAdapter.AbsSmallItemViewHolder b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Function1 d;

    public c(LiveBodyBeautyAdapter r1, LiveSmallItemBeautyAdapter.AbsSmallItemViewHolder r2, boolean r3, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.a.m == true) goto L5;
        return;
    L5:
        int r5 = this.b.getAdapterPosition();
        if (this.a.z2() == false) goto L8;
        r5 = r5 - 1;
    L8:
        if (r5 >= 0) goto L10;
        return;
    L10:
        if (r5 >= ((ArrayList) this.a.a).size()) goto L55;
        List<String> r0 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.a.l).b().r().q((Sticker) ListProtector.get(this.a.a, r5)) == true) goto L18;
        if (this.c == true) goto L18;
        return;
    L18:
        if (this.c == true) goto L24;
        List r1 = ((Sticker) ListProtector.get(this.a.a, r5)).getSubStickers();
        if (r1 != null) goto L22;
    L26:
        int r2 = this.a.c + (this.b.getAdapterPosition() - r5);
        int r3 = this.a.getItemCount();
        if (r2 < 0) goto L31;
        if (r3 <= r2) goto L31;
        this.a.notifyItemChanged(r2);
    L31:
        LiveBodyBeautyAdapter r6 = this.a;
        r6.c = r5;
        if (this.c == false) goto L41;
        r6.e.put(r5, Boolean.TRUE);
        if (((Sticker) ListProtector.get(this.a.a, r5)).getSubStickers() != null) goto L37;
        return;
    L37:
        if (this.a.y2(r5) < 0) goto L44;
        List r7 = ((Sticker) ListProtector.get(this.a.a, r5)).getSubStickers();
        if (r7 == null) goto L44;
        r7.size();
    L44:
        LiveBodyBeautyAdapter r8 = this.a;
        r8.m = true;
        LiveBodyBeautyAdapter.a r9 = r8.d;
        if (r9 == null) goto L47;
        r9.b(true);
    L47:
        LiveBodyBeautyAdapter r11 = this.a;
        if (r11.n == false) goto L52;
        LiveBodyBeautyAdapter.a r12 = r11.d;
        if (r12 == null) goto L52;
        r12.c((Sticker) ListProtector.get(r11.a, r5));
    L52:
        this.a.notifyItemChanged(this.b.getAdapterPosition());
        return;
    L41:
        LiveBodyBeautyAdapter.a r13 = r6.d;
        if (r13 == null) goto L44;
        r13.a((Sticker) ListProtector.get(r6.a, r5));
        goto L44
    L22:
        if ((!r1.isEmpty()) != true) goto L26;
    L24:
        if (((Boolean) this.d.invoke(ListProtector.get(this.a.a, r5))).booleanValue() == false) goto L26;
        return;
    }
}
