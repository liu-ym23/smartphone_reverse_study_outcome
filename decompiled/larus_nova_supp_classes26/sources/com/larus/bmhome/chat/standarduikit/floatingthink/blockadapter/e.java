package com.larus.bmhome.chat.standarduikit.floatingthink.blockadapter;

import android.view.View;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder;
import com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder$a$a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e implements BaseResourceViewHolder.a {
    public final /* synthetic */ ClarificationAnswerDetailFragment.b a;
    public final /* synthetic */ ClarificationAnswerDetailFragment.d b;

    public e(ClarificationAnswerDetailFragment.b r1, ClarificationAnswerDetailFragment.d r2) {
        this.a = r1;
        this.b = r2;
    }

    public final boolean b(String r1, View r2) {
        BaseResourceViewHolder$a$a.a(r1, r2);
        return false;
    }

    public final void a(String r8, int r9, View r10) {
        Intrinsics.checkNotNullParameter(r8, "key");
        Intrinsics.checkNotNullParameter(r10, "v");
        if (r9 != 103) goto L5;
    L9:
        int r11 = this.a.getAdapterPosition();
        if (r11 != (-1)) goto L12;
        return;
    L12:
        this.a.b.invoke(r8, r10, this.b, Integer.valueOf(r11), this);
        return;
    L5:
        if (r9 == 105) goto L9;
        if (r9 == 106) goto L9;
    }
}
