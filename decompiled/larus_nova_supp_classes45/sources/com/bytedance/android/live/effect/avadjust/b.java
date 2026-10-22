package com.bytedance.android.live.effect.avadjust;

import android.view.View;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ LiveColorAdjustAdapter a;
    public final /* synthetic */ LiveColorAdjustAdapter.AbsSmallItemViewHolder b;
    public final /* synthetic */ Function1 c;

    public b(LiveColorAdjustAdapter r1, LiveColorAdjustAdapter.AbsSmallItemViewHolder r2, Function1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        if (this.a.i == true) goto L5;
        return;
    L5:
        int r6 = this.b.getAdapterPosition() - 1;
        if (r6 >= 0) goto L8;
        return;
    L8:
        if (r6 >= ((ArrayList) this.a.a).size()) goto L37;
        List<String> r1 = LiveEffectContext.h;
        if (LiveEffectContext.a.a(this.a.k).b().r().q((Sticker) ListProtector.get(this.a.a, r6)) == true) goto L13;
        return;
    L13:
        List r2 = ((Sticker) ListProtector.get(this.a.a, r6)).getSubStickers();
        if (r2 != null) goto L16;
    L20:
        int r3 = this.a.c + (this.b.getAdapterPosition() - r6);
        int r4 = this.a.getItemCount();
        if (r3 < 0) goto L25;
        if (r4 <= r3) goto L25;
        this.a.notifyItemChanged(r3);
    L25:
        LiveColorAdjustAdapter r7 = this.a;
        if (r7.c == r6) goto L28;
        Sticker r8 = (Sticker) ListProtector.get(r7.a, r6);
        int r9 = s.a;
        s.a(this.a.j, r6, r8, "click");
    L28:
        LiveColorAdjustAdapter r11 = this.a;
        r11.c = r6;
        LiveColorAdjustAdapter.a r12 = r11.d;
        if (r12 == null) goto L31;
        r12.a((Sticker) ListProtector.get(r11.a, r6));
    L31:
        LiveColorAdjustAdapter r13 = this.a;
        r13.i = true;
        LiveColorAdjustAdapter.a r14 = r13.d;
        if (r14 == null) goto L34;
        r14.b(true);
    L34:
        this.a.notifyItemChanged(this.b.getAdapterPosition());
        return;
    L16:
        if ((!r2.isEmpty()) != true) goto L20;
        if (((Boolean) this.c.invoke(ListProtector.get(this.a.a, r6))).booleanValue() == false) goto L20;
        return;
    }
}
