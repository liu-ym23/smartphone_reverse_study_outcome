package com.bytedance.android.live.effect.beauty.smallitem;

import android.view.View;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u implements View.OnClickListener {
    public final /* synthetic */ LiveSmallItemBeautyAdapter a;
    public final /* synthetic */ LiveSmallItemBeautyAdapter.AbsSmallItemViewHolder b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Function1 d;

    public u(LiveSmallItemBeautyAdapter r1, LiveSmallItemBeautyAdapter.AbsSmallItemViewHolder r2, boolean r3, Function1 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        if (this.a.l == true) goto L5;
        return;
    L5:
        int r5 = this.b.getAdapterPosition();
        if (this.a.z2() == false) goto L8;
        r5 = r5 - 1;
    L8:
        if (r5 >= 0) goto L10;
        return;
    L10:
        if (r5 >= ((ArrayList) this.a.a).size()) goto L50;
        List<String> r0 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.a.k).b().r().q((Sticker) ListProtector.get(this.a.a, r5)) == true) goto L18;
        if (this.c == true) goto L18;
        return;
    L18:
        if (this.c == true) goto L24;
        List r1 = ((Sticker) ListProtector.get(this.a.a, r5)).getSubStickers();
        if (r1 != null) goto L22;
    L26:
        int r2 = this.a.b + (this.b.getAdapterPosition() - r5);
        int r3 = this.a.getItemCount();
        if (r2 < 0) goto L31;
        if (r3 <= r2) goto L31;
        this.a.notifyItemChanged(r2);
    L31:
        LiveSmallItemBeautyAdapter r6 = this.a;
        r6.b = r5;
        if (this.c == false) goto L41;
        r6.d.put(r5, Boolean.TRUE);
        if (((Sticker) ListProtector.get(this.a.a, r5)).getSubStickers() != null) goto L37;
        return;
    L37:
        if (this.a.y2(r5) < 0) goto L44;
        List r7 = ((Sticker) ListProtector.get(this.a.a, r5)).getSubStickers();
        if (r7 == null) goto L44;
        r7.size();
    L44:
        LiveSmallItemBeautyAdapter r8 = this.a;
        r8.l = true;
        LiveSmallItemBeautyAdapter.a r9 = r8.c;
        if (r9 == null) goto L47;
        r9.b(true);
    L47:
        this.a.notifyItemChanged(this.b.getAdapterPosition());
        return;
    L41:
        LiveSmallItemBeautyAdapter.a r11 = r6.c;
        if (r11 == null) goto L44;
        r11.a((Sticker) ListProtector.get(r6.a, r5));
        goto L44
    L22:
        if ((!r1.isEmpty()) != true) goto L26;
    L24:
        if (((Boolean) this.d.invoke(ListProtector.get(this.a.a, r5))).booleanValue() == false) goto L26;
        return;
    }
}
