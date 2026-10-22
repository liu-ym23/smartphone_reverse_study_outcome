package com.bytedance.android.livesdk.dsl.recyclerview;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/dsl/recyclerview/BaseDSLViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "dslservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseDSLViewHolder extends RecyclerView.ViewHolder {
    public b a;

    public abstract c T3();

    public abstract void U3(b r1, boolean r2);

    public void V3() {
    }

    public final Context getContext() {
        return T3().getActivity();
    }

    public BaseDSLViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "slcView");
        super(r2);
    }
}
