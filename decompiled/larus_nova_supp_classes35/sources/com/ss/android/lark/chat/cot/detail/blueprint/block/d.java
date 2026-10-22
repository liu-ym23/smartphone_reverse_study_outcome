package com.ss.android.lark.chat.cot.detail.blueprint.block;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.ss.android.lark.chat.cot.detail.j;
import com.ss.android.lark.chat.cot.detail.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ CotToolCallBlock a;
    public final /* synthetic */ k b;
    public final /* synthetic */ CotToolCallBlock.b c;

    public d(CotToolCallBlock r1, k r2, CotToolCallBlock.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        j r6 = this.a.c;
        String r0 = this.b.a;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "stableId");
        Intrinsics.checkNotNullParameter(r0, "stableId");
        boolean r1 = !r6.a(r0 + "#tool-call");
        int r3 = j.b;
        String r2 = r0 + "#tool-call";
        Intrinsics.checkNotNullParameter(r2, "key");
        r6.a.put(r2, Boolean.valueOf(r1));
        this.a.f.invoke();
        LinearLayout r7 = this.c.e;
        if (r1 == false) goto L5;
        int r4 = 0;
    L6:
        r7.setVisibility(r4);
        this.c.b.setSelected(r1);
        ImageView r8 = this.c.d;
        Regex r9 = CotToolCallBlock.r;
        if (r1 == false) goto L9;
        int r10 = 2131254267;
    L10:
        r8.setImageResource(r10);
        return;
    L9:
        r10 = 2131255567;
        goto L10
    L5:
        r4 = 8;
        goto L6
    }
}
