package com.bytedance.android.livesdk.interactivity.square.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.base.AbsPublicScreenMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.square.common.common.CommonSquarePublicScreenViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/square/common/BaseMessageModelAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreenV2/base/AbsPublicScreenMessageViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseMessageModelAdapter extends RecyclerView.Adapter<AbsPublicScreenMessageViewHolder> {
    public List<? extends h52.c> a;
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.l b;
    public final Context c;
    public final k52.a d;

    public final int getItemCount() {
        return this.a.size();
    }

    public final int getItemViewType(int r2) {
        return ((h52.c) ListProtector.get(this.a, r2)).a().getType();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        AbsPublicScreenMessageViewHolder r6 = (AbsPublicScreenMessageViewHolder) r4;
        Intrinsics.checkNotNullParameter(r6, "holder");
        int r0 = r6.getItemViewType();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r1 = this.b;
        Intrinsics.checkNotNullParameter(r1, "$this$getViewBinder");
        h52.b<? extends h52.c> r2 = r1.getViewBinderPluginByItemType(r0);
        if (r2 == null) goto L6;
        r2.b(r6, (h52.c) ListProtector.get(this.a, r5), r5);
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r0 = this.b;
        Intrinsics.checkNotNullParameter(r0, "$this$getViewBinder");
        h52.b<? extends h52.c> r5 = r0.getViewBinderPluginByItemType(r4);
        if (r5 == null) goto L6;
        CommonSquarePublicScreenViewHolder r6 = r5.a(LayoutInflater.from(this.c), r3);
        if (r6 == null) goto L6;
        return r6;
    L6:
        View r7 = LayoutInflater.from(this.c).inflate(2131566375, r3, false);
        if (r7.getLayoutParams() != null) goto L10;
        r7.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    L10:
        return new CommonSquarePublicScreenViewHolder(r7, this.d);
    }

    public BaseMessageModelAdapter(com.bytedance.android.livesdk.interactivity.api.publicscreen.l r2, Context r3, k52.a r4) {
        Intrinsics.checkNotNullParameter(r2, "publicScreenContext");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "pipelineConfig");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = new ArrayList();
    }
}
