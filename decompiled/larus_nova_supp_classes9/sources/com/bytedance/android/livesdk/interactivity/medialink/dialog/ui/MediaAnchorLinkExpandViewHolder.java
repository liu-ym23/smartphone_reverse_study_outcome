package com.bytedance.android.livesdk.interactivity.medialink.dialog.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import v82.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class MediaAnchorLinkExpandViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int c = 0;
    public final TextView a;
    public final ImageView b;

    public interface a {
    }

    public MediaAnchorLinkExpandViewHolder(View r2, final a r3, final boolean r4) {
        super(r2);
        this.a = (TextView) r2.findViewById(2131390581);
        this.b = (ImageView) r2.findViewById(2131376221);
        r2.setOnClickListener(new b(this, r4, r3));
    }
}
