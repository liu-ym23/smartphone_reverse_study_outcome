package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.imagepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepicker/ImageItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepicker/ImageItemAdapter$ImageItemViewHolder;", "<init>", "()V", "ImageItemViewHolder", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageItemAdapter extends RecyclerView.Adapter<ImageItemViewHolder> {
    public final ArrayList<String> a;
    public Function2<? super Integer, ? super String, Unit> b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/imagepicker/ImageItemAdapter$ImageItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ImageItemViewHolder extends RecyclerView.ViewHolder {
        public final HSImageView a;

        public ImageItemViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131362464);
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public ImageItemAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        ImageItemViewHolder r5 = (ImageItemViewHolder) r3;
        Intrinsics.checkNotNullParameter(r5, "holder");
        ((RecyclerView.ViewHolder) r5).itemView.setOnClickListener(new a(this, r4));
        String r6 = (String) CollectionsKt.getOrNull(this.a, r4);
        if (r6 != null) goto L5;
        return;
    L5:
        if (r6.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 != true) goto L12;
        ImageLoader.loadSdcardImage(r5.a, r6);
        return;
    L12:
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new ImageItemViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131566824, r4, false));
    }
}
