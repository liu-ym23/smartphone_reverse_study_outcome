package com.bytedance.android.live.room.adapter;

import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.FitTextView;
import com.bytedance.android.live.core.widget.HSImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class AudienceViewHolder extends RecyclerView.ViewHolder {
    public RecyclerView a;
    public final View b;
    public final HSImageView c;
    public final HSImageView d;
    public final ImageView e;
    public final FitTextView f;
    public Paint g;
    public final int h;
    public final int i;
    public final int j;

    public AudienceViewHolder(View r2) {
        super(r2);
        this.h = s1.f(34.0f);
        this.i = s1.f(2.0f);
        this.j = s1.f(8.0f);
        this.b = r2;
        this.c = r2.findViewById(2131363623);
        this.d = r2.findViewById(2131363646);
        this.e = (ImageView) r2.findViewById(2131374497);
        ImageView r0 = (ImageView) r2.findViewById(2131368305);
        this.f = r2.findViewById(2131367917);
    }
}
