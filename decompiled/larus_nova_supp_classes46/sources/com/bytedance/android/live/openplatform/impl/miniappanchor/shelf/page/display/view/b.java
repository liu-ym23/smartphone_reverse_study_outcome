package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.openplatform.api.model.datacontext.MiniAppDataContext;
import com.bytedance.android.livesdk.utils.t6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b extends me.drakeet.multitype.b<com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a, AnchorShelfDisplayItemViewHolder> {
    public final AnchorShelfDisplayItemViewHolder.c b;
    public final AnchorShelfDisplayItemViewHolder.b c;

    public b(AnchorShelfDisplayItemViewHolder.c r2, AnchorShelfDisplayItemViewHolder.b r3) {
        Intrinsics.checkNotNullParameter(r2, "onItemExplainButtonClickListener");
        Intrinsics.checkNotNullParameter(r3, "onItemClickListener");
        this.b = r2;
        this.c = r3;
    }

    public final void b(RecyclerView.ViewHolder r13, Object r14) {
        AnchorShelfDisplayItemViewHolder r15 = (AnchorShelfDisplayItemViewHolder) r13;
        com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r16 = (com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a) r14;
        Intrinsics.checkNotNullParameter(r15, "vh");
        Intrinsics.checkNotNullParameter(r16, "data");
        r15.getClass();
        Intrinsics.checkNotNullParameter(r16, "cardInfo");
        r15.a4(r16);
        if (r16.getStatus() != 1) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        r15.a.setBackgroundResource(2131249558);
    L10:
        r15.a.setOnClickListener(new f(r15, r16));
        Button r1 = r15.f;
        if (((IInteractService) jc1.k.n(IInteractService.class)).isLinkCasting() == false) goto L13;
        int r5 = 8;
    L14:
        r1.setVisibility(r5);
        Button r2 = r15.f;
        MiniAppDataContext.Companion.getClass();
        if (com.bytedance.android.live.openplatform.api.model.shelf.g.c(MiniAppDataContext.a.b()) == false) goto L20;
        if (r16.a.U() == (-1)) goto L20;
        r2.setText(s1.B(2131920458));
        r2.setTextColor(s1.h(2131108464));
        r2.setBackgroundResource(2131249556);
        r2.setOnClickListener(new c(r15, r16));
    L24:
        if (r16.d(-1) == false) goto L27;
        r15.k.setVisibility(0);
        r15.k.setText(s1.B(2131920928));
        r15.k.setTextColor(s1.h(2131107875));
        r15.k.setBackgroundResource(2131252542);
        r15.k.setCompoundDrawablesWithIntrinsicBounds(null, null, s1.m(2131252543), null);
        r15.k.setCompoundDrawablePadding((int) t6.a(((RecyclerView.ViewHolder) r15).itemView.getContext(), 2.0f));
        r15.k.setOnClickListener(new g(r15, r16));
    L31:
        if (r16.b == null) goto L33;
        r15.l.setVisibility(0);
        r15.l.a(r16.b, r15.o);
        return;
    L33:
        r15.l.setVisibility(8);
        return;
    L27:
        if (r16.e(-1) == false) goto L29;
        r15.k.setVisibility(0);
        r15.k.setText(s1.B(2131920929));
        r15.k.setTextColor(s1.h(2131107874));
        r15.k.setBackgroundResource(2131252544);
        r15.k.setCompoundDrawables(null, null, null, null);
        r15.k.setCompoundDrawablePadding(0);
        r15.k.setOnClickListener(null);
        goto L31
    L29:
        r15.k.setVisibility(8);
    L20:
        if (r16.getStatus() != 1) goto L22;
        r2.setText(s1.B(2131920455));
        r2.setTextColor(s1.h(2131108464));
        r2.setBackgroundResource(2131249556);
        r2.setOnClickListener(new d(r15, r16));
        goto L24
    L22:
        r2.setText(s1.B(2131920457));
        r2.setTextColor(s1.h(2131109391));
        r2.setBackgroundResource(2131249565);
        r2.setOnClickListener(new e(r15, r16));
        goto L24
    L13:
        r5 = 0;
        goto L14
    L9:
        r15.a.setBackground(null);
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new AnchorShelfDisplayItemViewHolder(r4.inflate(2131566954, r5, false), this.b, this.c, new a());
    }
}
