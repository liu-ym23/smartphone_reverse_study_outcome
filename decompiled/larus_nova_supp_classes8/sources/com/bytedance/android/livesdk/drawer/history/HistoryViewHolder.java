package com.bytedance.android.livesdk.drawer.history;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.view.LiveCircleView;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/history/HistoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "i", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HistoryViewHolder extends RecyclerView.ViewHolder {
    public final HSImageView a;
    public final LiveCircleView b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final com.bytedance.android.live.core.view.a f;
    public final FrameLayout g;
    public final View h;
    public final Context i;
    public final e j;

    public final Context getContext() {
        return this.i;
    }

    public HistoryViewHolder(View r3, Context r4, e r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "itemview");
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r3);
        this.h = r3;
        this.i = r4;
        this.j = r5;
        HSImageView r7 = ((RecyclerView.ViewHolder) this).itemView.findViewById(2131374395);
        this.a = r7;
        LiveCircleView r8 = r3.findViewById(2131374406);
        this.b = r8;
        this.c = (ImageView) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131374404);
        this.d = (TextView) r3.findViewById(2131374416);
        this.e = (TextView) r3.findViewById(2131374427);
        this.f = new com.bytedance.android.live.core.view.a(r7, r8, Boolean.FALSE);
        FrameLayout r9 = (FrameLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131365721);
        this.g = r9;
        LinearLayout r10 = (LinearLayout) ((RecyclerView.ViewHolder) this).itemView.findViewById(2131374385);
        if (r6 == false) goto L13;
        ViewGroup.LayoutParams r11 = r9.getLayoutParams();
        if (r11 == null) goto L12;
        ConstraintLayout.LayoutParams r12 = (ConstraintLayout.LayoutParams) r11;
        ((ViewGroup.MarginLayoutParams) r12).leftMargin = s1.f(0.0f);
        r9.setLayoutParams(r12);
        ViewGroup.LayoutParams r13 = r10.getLayoutParams();
        if (r13 == null) goto L10;
        ConstraintLayout.LayoutParams r14 = (ConstraintLayout.LayoutParams) r13;
        ((ViewGroup.MarginLayoutParams) r14).leftMargin = s1.f(10.0f);
        r10.setLayoutParams(r14);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L12:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }
}
