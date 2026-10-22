package com.bytedance.android.live.ktv.common.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.view.f;
import com.bytedance.android.livesdk.ktvapi.model.mv.IMvPreviewViewHolder;
import com.bytedance.android.livesdk.ktvapi.model.mv.i;
import com.bytedance.android.livesdk.ktvapi.model.mv.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/ktv/common/view/adapter/OpusPreviewAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/ktvapi/model/mv/IMvPreviewViewHolder;", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OpusPreviewAdapter<T> extends RecyclerView.Adapter<IMvPreviewViewHolder<T>> {
    public List<? extends T> a;
    public final int b;
    public j<T> c;
    public final i<T> d;

    public final int getItemCount() {
        List<? extends T> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        IMvPreviewViewHolder r4 = (IMvPreviewViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "holder");
        List<? extends T> r0 = this.a;
        if (r0 == null) goto L8;
        Object r1 = ListProtector.get(r0, r3);
        if (r1 == null) goto L9;
        r4.T3(r3, r1);
        return;
    L9:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        j<T> r6 = this.c;
        View r7 = LayoutInflater.from(r4.getContext()).inflate(2131563364, r4, false);
        if (this.b <= 0) goto L5;
        r7.setLayoutParams(new ViewGroup.LayoutParams(this.b, s1.f(150.0f)));
    L5:
        Unit r0 = Unit.INSTANCE;
        if (r7 == null) goto L10;
        IMvPreviewViewHolder r8 = r6.a((FrameLayout) r7);
        r8.a = this.d;
        r8.U3((HSImageView) ((RecyclerView.ViewHolder) r8).itemView.findViewById(2131368146));
        return r8;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public OpusPreviewAdapter(int r2, j r3, f r4) {
        Intrinsics.checkNotNullParameter(r3, "vhProvider");
        Intrinsics.checkNotNullParameter(r4, "adapterClickCallback");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
