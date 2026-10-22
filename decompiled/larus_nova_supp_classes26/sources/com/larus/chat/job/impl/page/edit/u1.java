package com.larus.chat.job.impl.page.edit;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.chat.job.impl.databinding.LarusChatJobEditTextItemBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class u1 extends RecyclerView.ViewHolder {
    public final LarusChatJobEditTextItemBinding a;
    public final Function1<ChatJobEditTextKey, q1> b;
    public final Function2<ChatJobEditTextKey, q1, Unit> c;
    public t1 d;
    public Boolean e;

    public u1(LarusChatJobEditTextItemBinding r2, f r3, g r4) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r3, "selectionProvider");
        Intrinsics.checkNotNullParameter(r4, "onSelectionChanged");
        super(r2.a);
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
