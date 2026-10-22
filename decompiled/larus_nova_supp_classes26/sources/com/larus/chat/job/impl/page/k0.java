package com.larus.chat.job.impl.page;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k0 extends RecyclerView.ViewHolder {
    public final TextView a;

    public k0(TextView r4) {
        Intrinsics.checkNotNullParameter(r4, "textView");
        super(r4);
        this.a = r4;
        int r0 = gz8.g.a;
        r4.setTextColor(gz8.g.b(r4.getContext()));
        r4.setTextSize(15.0f);
        r4.setIncludeFontPadding(false);
        RecyclerView.LayoutParams r1 = new RecyclerView.LayoutParams(-1, -2);
        ((ViewGroup.MarginLayoutParams) r1).leftMargin = i5.q();
        ((ViewGroup.MarginLayoutParams) r1).rightMargin = i5.q();
        ((ViewGroup.MarginLayoutParams) r1).topMargin = i5.A();
        ((ViewGroup.MarginLayoutParams) r1).bottomMargin = i5.r0();
        r4.setLayoutParams(r1);
    }
}
