package com.bytedance.android.livesdk.ktvapi.model.mv;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/mv/IMvPreviewViewHolder;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class IMvPreviewViewHolder<T> extends RecyclerView.ViewHolder {
    public i<T> a;
    public HSImageView b;

    public abstract void T3(int r1, T r2);

    public IMvPreviewViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    public void U3(HSImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }
}
