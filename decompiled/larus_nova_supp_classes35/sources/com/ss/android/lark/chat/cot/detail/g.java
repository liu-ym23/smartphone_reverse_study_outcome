package com.ss.android.lark.chat.cot.detail;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.cot.detail.blueprint.CotDetailBlueprintAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ RecyclerView a;
    public final /* synthetic */ c b;

    public g(RecyclerView r1, c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean r0 = this.a.canScrollVertically(1);
        if (this.b.r == false) goto L11;
        if (r0 == false) goto L12;
        StringBuilder r1 = new StringBuilder("global layout -> retry scroll, followBottom=");
        r1.append(this.b.r);
        r1.append(", canScrollDown=");
        r1.append(r0);
        r1.append(", itemCount=");
        CotDetailBlueprintAdapter r2 = this.b.j;
        if (r2 == null) goto L8;
        Integer r3 = Integer.valueOf(r2.getItemCount());
    L9:
        r1.append(r3);
        com.ss.android.lark.chat.cot.f.c("detail_autoscroll", r1.toString());
        c.a(this.b, "globalLayout");
        return;
    L8:
        r3 = null;
        goto L9
    L12:
        return;
    }
}
