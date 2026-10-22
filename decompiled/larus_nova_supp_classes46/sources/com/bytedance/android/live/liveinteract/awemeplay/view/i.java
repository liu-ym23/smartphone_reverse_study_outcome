package com.bytedance.android.live.liveinteract.awemeplay.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i extends me.drakeet.multitype.b<e, LiveVideoCommentSelectPanelLoadingMoreViewHolder> {
    public i() {
    }

    public final void e(RecyclerView.ViewHolder r3) {
        LiveVideoCommentSelectPanelLoadingMoreViewHolder r4 = (LiveVideoCommentSelectPanelLoadingMoreViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        if (r4.c != 1) goto L8;
        LiveDoubleColorBallAnimationView r5 = r4.a;
        if (r5 == null) goto L9;
        r5.b();
        return;
    L9:
        return;
    }

    public final void f(RecyclerView.ViewHolder r3) {
        LiveVideoCommentSelectPanelLoadingMoreViewHolder r4 = (LiveVideoCommentSelectPanelLoadingMoreViewHolder) r3;
        Intrinsics.checkNotNullParameter(r4, "holder");
        if (r4.c != 1) goto L8;
        LiveDoubleColorBallAnimationView r5 = r4.a;
        if (r5 == null) goto L9;
        r5.c();
        return;
    L9:
        return;
    }

    public final void b(RecyclerView.ViewHolder r3, Object r4) {
        LiveVideoCommentSelectPanelLoadingMoreViewHolder r5 = (LiveVideoCommentSelectPanelLoadingMoreViewHolder) r3;
        e r6 = (e) r4;
        Intrinsics.checkNotNullParameter(r5, "holder");
        Intrinsics.checkNotNullParameter(r6, "item");
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "data");
        int r7 = r6.a;
        r5.c = r7;
        if (r7 != 1) goto L7;
        LiveDoubleColorBallAnimationView r8 = r5.a;
        if (r8 == null) goto L11;
        r8.setVisibility(0);
        return;
    L11:
        return;
    L7:
        TextView r9 = r5.b;
        if (r9 == null) goto L13;
        r9.setVisibility(0);
        return;
    }

    public final RecyclerView.ViewHolder d(LayoutInflater r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        Intrinsics.checkNotNullParameter(r5, "parent");
        return new LiveVideoCommentSelectPanelLoadingMoreViewHolder(r4.inflate(2131567582, r5, false));
    }
}
