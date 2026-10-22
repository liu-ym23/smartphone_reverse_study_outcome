package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.layout.widget.MaxHeightRelativeLayout;
import com.larus.im.bean.message.block.Block;
import com.larus.mainbot.impl.databinding.LarusBlockItemCodeTextBinding;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d0 extends AbsFoldableBlockView {
    public final RecyclerView k;
    public LarusBlockItemCodeTextBinding l;
    public Block m;
    public final int n;

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void c() {
        this.m = null;
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsFoldableBlockView
    public View getContentBlockView() {
        LarusBlockItemCodeTextBinding r0 = this.l;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public d0(Context r2, RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.k = r3;
        this.n = i5.w();
    }

    public static View f(View r4, Class r5) {
        if ((r4 instanceof ViewGroup) == false) goto L14;
        ViewGroup r6 = (ViewGroup) r4;
        int r0 = r6.getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L19;
        View r2 = r6.getChildAt(r1);
        if (r5.isInstance(r2) == true) goto L8;
        Intrinsics.checkNotNull(r2);
        View r3 = f(r2, r5);
        if (r3 != null) goto L12;
        r1 = r1 + 1;
        goto L5
    L12:
        return r3;
    L8:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type T of com.larus.bmhome.chat.deepresearch.view.MarkdownCodeBlockView.findChildViewByType");
        return r2;
    L19:
        return null;
    L14:
        return null;
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsFoldableBlockView, com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(Block r4, Map<String, Object> r5) {
        this.m = r4;
        LarusBlockItemCodeTextBinding r0 = this.l;
        if (r0 == null) goto L7;
        MaxHeightRelativeLayout r1 = r0.f;
        if (r1 == null) goto L7;
        r1.setMaxHeight(this.n);
    L7:
        LarusBlockItemCodeTextBinding r2 = this.l;
        if (r2 == null) goto L16;
        CardView r3 = r2.b;
        if (r3 == null) goto L16;
        ViewGroup.LayoutParams r6 = r3.getLayoutParams();
        if (r6 == null) goto L15;
        r6.height = -2;
        r3.setLayoutParams(r6);
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L16:
        post(new b0(this));
        LarusBlockItemCodeTextBinding r7 = this.l;
        if (r7 == null) goto L21;
        MarkdownIconTextBlockView r8 = r7.e;
        if (r8 == null) goto L21;
        r8.a(r4, r5);
    L21:
        super.a(r4, r5);
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsFoldableBlockView, com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super.b(r10, r11);
        CardView r12 = LayoutInflater.from(r10).inflate(2131561828, this, false);
        addView(r12);
        CardView r2 = r12;
        int r13 = 2131368658;
        View r3 = ViewBindings.findChildViewById(r12, 2131368658);
        if (r3 == null) goto L13;
        r13 = 2131379547;
        View r7 = ViewBindings.findChildViewById(r12, 2131379547);
        if (r7 == null) goto L13;
        r13 = 2131379576;
        MarkdownIconTextBlockView r8 = (MarkdownIconTextBlockView) ViewBindings.findChildViewById(r12, 2131379576);
        if (r8 == null) goto L13;
        r13 = 2131379577;
        MaxHeightRelativeLayout r6 = (MaxHeightRelativeLayout) ViewBindings.findChildViewById(r12, 2131379577);
        if (r6 == null) goto L13;
        this.l = new LarusBlockItemCodeTextBinding(r2, r2, r3, r7, r8, r6);
        r8.k = this.k;
        com.larus.utils.e1.d(r7, new c0(this));
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
