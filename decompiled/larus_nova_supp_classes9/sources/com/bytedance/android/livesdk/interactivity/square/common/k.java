package com.bytedance.android.livesdk.interactivity.square.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.chatroom.ui.NoMoreSpaceTextView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.m;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.base.AbsPublicScreenMessageViewHolder;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageBinderType;
import com.bytedance.android.livesdk.interactivity.square.common.common.CommonSquarePublicScreenViewHolder;
import com.bytedance.android.livesdk.interactivity.square.plugin.SquareModelSpanClickListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements h52.b<j> {
    public final MessageBinderType a;
    public final k52.a b;

    public k(MessageBinderType r2, k52.a r3) {
        Intrinsics.checkNotNullParameter(r2, "binderType");
        Intrinsics.checkNotNullParameter(r3, "pipelineConfig");
        this.a = r2;
        this.b = r3;
    }

    @Override // h52.b
    public final CommonSquarePublicScreenViewHolder a(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "layoutInflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r5 = r3.inflate(2131566375, r4, false);
        if (r5.getLayoutParams() != null) goto L6;
        r5.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
    L6:
        return new CommonSquarePublicScreenViewHolder(r5, this.b);
    }

    @Override // h52.b
    public final void b(AbsPublicScreenMessageViewHolder r3, h52.c r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "viewHolder");
        Intrinsics.checkNotNullParameter(r4, "item");
        Intrinsics.checkNotNullParameter(r3, "viewHolder");
        Intrinsics.checkNotNullParameter(r4, "item");
        if (r4 == null) goto L7;
        c(r3, r4, r5);
        return;
    L7:
        throw new IllegalArgumentException("Invalid type ".concat(r4.getClass().getName()));
    }

    public final void c(AbsPublicScreenMessageViewHolder r3, h52.c r4, int r5) {
        j r6 = (j) r4;
        Intrinsics.checkNotNullParameter(r3, "viewholder");
        Intrinsics.checkNotNullParameter(r6, "model");
        r3.getClass();
        Intrinsics.checkNotNullParameter(r6, "model");
        r3.a = r6;
        if (r6 == null) goto L16;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r0 = m.a(null);
        if (r0 == null) goto L16;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r1 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.l) r0.getValue();
        if (r1 == null) goto L16;
        Intrinsics.checkNotNullParameter(r1, "$this$getPlugin");
        Intrinsics.checkNotNullParameter(r6, "model");
        h52.a<h52.d, ? extends h52.c> r7 = r1.getMessagePluginByType(r6.l);
        if (r7 == null) goto L16;
        SquareModelSpanClickListener r8 = r7.b();
        if (r8 == null) goto L16;
        View.OnClickListener r9 = r3.e.f.c(r8);
        NoMoreSpaceTextView r2 = r3.d;
        if (r2 == null) goto L16;
        r2.setOnClickListener(new i52.c(r9, r3));
    L16:
        NoMoreSpaceTextView r10 = r3.d;
        if (r10 == null) goto L19;
        r10.setOnLongClickListener(new i52.d(r3));
    L19:
        r3.T3(r6);
    }
}
