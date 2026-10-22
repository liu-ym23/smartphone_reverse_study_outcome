package com.bytedance.android.live.effect.avadjust.lens;

import android.view.View;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.k;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ LiveLensAdapter a;
    public final /* synthetic */ LiveLensAdapter.AbsSmallItemViewHolder b;

    public a(LiveLensAdapter r1, LiveLensAdapter.AbsSmallItemViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        int r5 = this.b.getAdapterPosition();
        if (r5 >= 0) goto L5;
        return;
    L5:
        if (r5 < ((ArrayList) this.a.a).size()) goto L8;
        return;
    L8:
        if (((k90.a) ListProtector.get(this.a.a, r5)).getType() != 1) goto L12;
        List<String> r0 = LiveEffectContext.h;
        k r1 = LiveEffectContext.a.a(this.a.h).b().r();
        ((k90.a) ListProtector.get(this.a.a, r5)).getClass();
        if (r1.q(null) == true) goto L12;
        return;
    L12:
        int r2 = this.a.b + (this.b.getAdapterPosition() - r5);
        int r3 = this.a.getItemCount();
        if (r2 < 0) goto L17;
        if (r3 <= r2) goto L17;
        this.a.notifyItemChanged(r2);
    L17:
        LiveLensAdapter r6 = this.a;
        r6.b = r5;
        LiveLensAdapter.a r7 = r6.c;
        if (r7 == null) goto L20;
        r7.a((k90.a) ListProtector.get(r6.a, r5));
    L20:
        this.a.notifyDataSetChanged();
    }
}
