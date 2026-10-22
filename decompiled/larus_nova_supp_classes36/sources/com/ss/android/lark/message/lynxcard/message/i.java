package com.ss.android.lark.message.lynxcard.message;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.message.lynxcard.entity.LynxCardContentVO;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i extends OnSingleClickListener {
    public final /* synthetic */ LynxCardViewHolder a;
    public final /* synthetic */ v5b.c<LynxCardContentVO> b;
    public final /* synthetic */ LynxCardMessageCell c;

    public final void onSingleClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        int r4 = d.g;
        d.a.b(((RecyclerView.ViewHolder) this.a).itemView, this.b, this.c.b);
    }

    public i(LynxCardViewHolder r1, v5b.c<LynxCardContentVO> r2, LynxCardMessageCell r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
