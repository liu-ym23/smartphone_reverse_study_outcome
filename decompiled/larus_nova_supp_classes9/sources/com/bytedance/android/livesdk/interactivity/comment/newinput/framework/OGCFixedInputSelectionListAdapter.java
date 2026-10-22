package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.api.input.viewpager.SelectionListAdapter;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/OGCFixedInputSelectionListAdapter;", "Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/SelectionListAdapter;", "a", "OGCFixedPageSelectionViewHolder", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OGCFixedInputSelectionListAdapter extends SelectionListAdapter {
    public final Lazy h;
    public final Lazy i;
    public final String j;

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/newinput/framework/OGCFixedInputSelectionListAdapter$OGCFixedPageSelectionViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/SelectionListAdapter$PageSelectionViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/api/input/viewpager/SelectionListAdapter;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public final class OGCFixedPageSelectionViewHolder extends SelectionListAdapter.PageSelectionViewHolder {
        public final /* synthetic */ OGCFixedInputSelectionListAdapter c;

        @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.SelectionListAdapter.PageSelectionViewHolder
        public final void T3(boolean r3) {
            if (r3 == false) goto L5;
            ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131385726)).setTextColor(((Number) this.c.h.getValue()).intValue());
            ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131385726)).setAlpha(1.0f);
            ((RecyclerView.ViewHolder) this).itemView.setBackground((GradientDrawable) this.c.i.getValue());
            return;
        L5:
            ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131385726)).setTextColor(((Number) this.c.h.getValue()).intValue());
            ((TextView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131385726)).setAlpha(0.75f);
            ((RecyclerView.ViewHolder) this).itemView.setBackground(null);
        }

        public OGCFixedPageSelectionViewHolder(OGCFixedInputSelectionListAdapter r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "itemView");
            this.c = r2;
            super(r2, r3);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.SelectionListAdapter
    public final SelectionListAdapter.PageSelectionViewHolder z2(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        return new OGCFixedPageSelectionViewHolder(this, LayoutInflater.from(r4.getContext()).inflate(2131567060, r4, false));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.input.viewpager.SelectionListAdapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return z2(r1);
    }

    public OGCFixedInputSelectionListAdapter(String r2, RecyclerView r3, List<? extends com.bytedance.android.livesdk.interactivity.api.input.viewpager.c> r4) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        Intrinsics.checkNotNullParameter(r4, "data");
        super(r3, r4);
        this.j = r2;
        this.h = LazyKt.lazy(new OGCFixedInputSelectionListAdapter$ogcSelectedColor$2(this));
        this.i = LazyKt.lazy(new OGCFixedInputSelectionListAdapter$ogcSelectedDrawable$2(this));
    }
}
