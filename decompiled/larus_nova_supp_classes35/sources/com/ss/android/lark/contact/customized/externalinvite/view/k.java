package com.ss.android.lark.contact.customized.externalinvite.view;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.widget.recyclerview.item.ItemViewHolder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k extends bec.a<k> {
    public final int e;
    public final int f;
    public final CharSequence g;
    public final CharSequence h;
    public final View.OnClickListener i;

    public final void a(ItemViewHolder r6, int r7) {
        ImageView r8 = (ImageView) r6.T3(2131374891);
        TextView r0 = (TextView) r6.T3(2131374893);
        TextView r1 = (TextView) r6.T3(2131374892);
        View r2 = ((RecyclerView.ViewHolder) r6).itemView;
        View.OnClickListener r3 = this.i;
        if (r3 == null) goto L8;
        if (r2 == null) goto L8;
        r2.setOnClickListener(new com.ss.android.lark.inv.export.util.a(r3));
    L8:
        r8.setImageResource(this.e);
        if (this.f == 0) goto L11;
        r8.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(((RecyclerView.ViewHolder) r6).itemView.getContext(), this.f)));
    L12:
        r0.setText(this.g);
        CharSequence r9 = this.h;
        if (r9 != null) goto L15;
    L18:
        r1.setVisibility(8);
        return;
    L15:
        if (r9.length() == 0) goto L18;
        r1.setVisibility(0);
        r1.setText(this.h);
        return;
    L11:
        r8.setImageTintList(null);
        goto L12
    }

    public k(CharSequence r2, CharSequence r3, a r4) {
        super(2131559913);
        this.e = 2131233635;
        this.f = 0;
        this.g = r2;
        this.h = r3;
        this.i = r4;
    }
}
