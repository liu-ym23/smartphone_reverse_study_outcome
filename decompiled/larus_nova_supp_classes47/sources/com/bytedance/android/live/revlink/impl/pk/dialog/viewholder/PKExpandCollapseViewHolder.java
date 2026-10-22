package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class PKExpandCollapseViewHolder extends RecyclerView.ViewHolder {
    public final TextView a;
    public final ImageView b;
    public final a c;

    public interface a {
        void Ew();
    }

    public PKExpandCollapseViewHolder(View r2, a r3) {
        super(r2);
        this.a = (TextView) r2.findViewById(2131371888);
        this.b = (ImageView) r2.findViewById(2131371886);
        this.c = r3;
        r2.setOnClickListener(new i(this));
    }
}
