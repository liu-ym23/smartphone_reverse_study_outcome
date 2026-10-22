package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepreview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepreview/PreviewItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepreview/PreviewItemAdapter$PreviewItemViewHolder;", "<init>", "()V", "PreviewItemViewHolder", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewItemAdapter extends RecyclerView.Adapter<PreviewItemViewHolder> {
    public final List<k> a;
    public Function2<? super Integer, ? super k, Unit> b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepreview/PreviewItemAdapter$PreviewItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PreviewItemViewHolder extends RecyclerView.ViewHolder {
        public final HSImageView a;

        public PreviewItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131382921);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public PreviewItemAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        PreviewItemViewHolder r6 = (PreviewItemViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        k r0 = (k) CollectionsKt.getOrNull(this.a, r5);
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new d(this, r0, r5));
        ImageLoader.bindImage(r6.a, r0, 2131252200);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        return new PreviewItemViewHolder(LayoutInflater.from(r3.getContext()).inflate(2131566830, r3, false));
    }
}
