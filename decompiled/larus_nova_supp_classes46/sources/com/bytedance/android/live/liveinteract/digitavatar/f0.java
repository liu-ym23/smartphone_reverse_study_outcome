package com.bytedance.android.live.liveinteract.digitavatar;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f0 extends RecyclerView.ViewHolder {
    public final HSImageView a;
    public final TextView b;
    public com.bytedance.android.live.liveinteract.videotalk.emoji.model.j c;

    public f0(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
        this.a = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371532);
        this.b = (TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131371536);
    }
}
