package com.bytedance.android.annie.debug.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/UrlFormViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
public final class UrlFormViewHolder extends RecyclerView.ViewHolder {
    public final View a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;

    public UrlFormViewHolder(View r10) {
        Intrinsics.checkNotNullParameter(r10, "rootView");
        super(r10);
        this.a = r10;
        this.b = LazyKt.lazy(new UrlFormViewHolder$annieDebugParamTitle$2(this));
        this.c = LazyKt.lazy(new UrlFormViewHolder$annieDebugParamValue$2(this));
        this.d = LazyKt.lazy(new UrlFormViewHolder$annieDebugParamSubDialog$2(this));
    }
}
