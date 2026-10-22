package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import bt8.o2;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a extends RecyclerView.ViewHolder {
    public final o2 a;
    public final int b;
    public final int c;
    public final TextView d;

    public a(View r4, o2 r5) {
        Intrinsics.checkNotNullParameter(r4, "itemView");
        Intrinsics.checkNotNullParameter(r5, "callback");
        super(r4);
        this.a = r5;
        this.b = ContextCompat.getColor(r4.getContext(), c.b(2130972123, r4.getContext(), 2131103203));
        this.c = ContextCompat.getColor(r4.getContext(), c.b(2130972079, r4.getContext(), 2131103136));
        this.d = (TextView) r4.findViewById(2131390830);
    }
}
