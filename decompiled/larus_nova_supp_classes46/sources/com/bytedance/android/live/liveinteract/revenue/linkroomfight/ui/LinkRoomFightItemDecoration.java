package com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.liveinteract.videotalk.ui.BaseEqualGridItemDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/revenue/linkroomfight/ui/LinkRoomFightItemDecoration;", "Lcom/bytedance/android/live/liveinteract/videotalk/ui/BaseEqualGridItemDecoration;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class LinkRoomFightItemDecoration extends BaseEqualGridItemDecoration {
    public final int b;
    public final int c;

    public LinkRoomFightItemDecoration(int r1, Drawable r2) {
        super(r2);
        this.b = 1;
        this.c = r1;
    }

    public final void onDrawOver(Canvas r9, RecyclerView r10, RecyclerView.State r11) {
        Intrinsics.checkNotNullParameter(r9, "c");
        Intrinsics.checkNotNullParameter(r10, "parent");
        Intrinsics.checkNotNullParameter(r11, "state");
        Drawable r12 = this.a;
        if (r12 == null) goto L97;
        Intrinsics.checkNotNullParameter(r9, "c");
        Intrinsics.checkNotNullParameter(r10, "parent");
        int r0 = r10.getChildCount();
        int r1 = this.c;
        int r4 = 0;
        if (r1 != 51) goto L31;
    L6:
        if (r4 >= r0) goto L122;
        if ((r4 % 2) != 0) goto L19;
        View r2 = r10.getChildAt(r4);
        RecyclerView.LayoutParams r3 = r2.getLayoutParams();
        if (r3 == null) goto L17;
        RecyclerView.LayoutParams r5 = r3;
        int r6 = r2.getTop() - ((ViewGroup.MarginLayoutParams) r5).topMargin;
        int r7 = r2.getBottom() + ((ViewGroup.MarginLayoutParams) r5).bottomMargin;
        int r8 = r2.getRight() + ((ViewGroup.MarginLayoutParams) r5).rightMargin;
        int r13 = this.b;
        int r14 = r8 - r13;
        int r15 = r13 + r14;
        if (r12 == null) goto L14;
        r12.setBounds(r14, r6, r15, r7);
    L14:
        if (r12 == null) goto L19;
        r12.draw(r9);
        goto L19
    L17:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L19:
        if (((r4 - 1) % 2) != 0) goto L29;
        View r16 = r10.getChildAt(r4);
        RecyclerView.LayoutParams r17 = r16.getLayoutParams();
        if (r17 == null) goto L28;
        RecyclerView.LayoutParams r18 = r17;
        int r19 = r16.getTop() - ((ViewGroup.MarginLayoutParams) r18).topMargin;
        int r20 = r16.getBottom() + ((ViewGroup.MarginLayoutParams) r18).bottomMargin;
        int r21 = r16.getLeft() - ((ViewGroup.MarginLayoutParams) r18).leftMargin;
        int r22 = this.b + r21;
        if (r12 == null) goto L25;
        r12.setBounds(r21, r19, r22, r20);
    L25:
        if (r12 == null) goto L29;
        r12.draw(r9);
        goto L29
    L28:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L29:
        r4 = r4 + 1;
        goto L6
    L122:
        return;
    L31:
        if (r1 != 58) goto L46;
    L32:
        if (r4 >= r0) goto L123;
        if ((r4 % 2) != 0) goto L44;
        View r23 = r10.getChildAt(r4);
        RecyclerView.LayoutParams r24 = r23.getLayoutParams();
        if (r24 == null) goto L43;
        RecyclerView.LayoutParams r25 = r24;
        int r26 = r23.getTop() - ((ViewGroup.MarginLayoutParams) r25).topMargin;
        int r27 = r23.getBottom() + ((ViewGroup.MarginLayoutParams) r25).bottomMargin;
        int r28 = r23.getRight() + ((ViewGroup.MarginLayoutParams) r25).rightMargin;
        int r29 = this.b;
        int r30 = r28 - r29;
        int r31 = r29 + r30;
        if (r12 == null) goto L40;
        r12.setBounds(r30, r26, r31, r27);
    L40:
        if (r12 == null) goto L44;
        r12.draw(r9);
        goto L44
    L43:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L44:
        r4 = r4 + 1;
        goto L32
    L123:
        return;
    L46:
        if (r1 != 56) goto L72;
    L47:
        if (r4 >= r0) goto L124;
        if ((r4 % 2) != 0) goto L60;
        View r32 = r10.getChildAt(r4);
        RecyclerView.LayoutParams r33 = r32.getLayoutParams();
        if (r33 == null) goto L58;
        RecyclerView.LayoutParams r34 = r33;
        int r35 = r32.getTop() - ((ViewGroup.MarginLayoutParams) r34).topMargin;
        int r36 = r32.getBottom() + ((ViewGroup.MarginLayoutParams) r34).bottomMargin;
        int r37 = r32.getRight() + ((ViewGroup.MarginLayoutParams) r34).rightMargin;
        int r38 = this.b;
        int r39 = r37 - r38;
        int r40 = r38 + r39;
        if (r12 == null) goto L55;
        r12.setBounds(r39, r35, r40, r36);
    L55:
        if (r12 == null) goto L60;
        r12.draw(r9);
        goto L60
    L58:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L60:
        if ((r4 % 3) != 0) goto L70;
        View r41 = r10.getChildAt(r4);
        RecyclerView.LayoutParams r42 = r41.getLayoutParams();
        if (r42 == null) goto L69;
        RecyclerView.LayoutParams r43 = r42;
        int r44 = r41.getTop() - ((ViewGroup.MarginLayoutParams) r43).topMargin;
        int r45 = r41.getBottom() + ((ViewGroup.MarginLayoutParams) r43).bottomMargin;
        int r46 = r41.getLeft() - ((ViewGroup.MarginLayoutParams) r43).leftMargin;
        int r47 = this.b + r46;
        if (r12 == null) goto L66;
        r12.setBounds(r46, r44, r47, r45);
    L66:
        if (r12 == null) goto L70;
        r12.draw(r9);
        goto L70
    L69:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L70:
        r4 = r4 + 1;
        goto L47
    L124:
        return;
    L72:
        if (r1 != 57) goto L121;
    L73:
        if (r4 >= r0) goto L125;
        if ((r4 % 2) != 0) goto L86;
        View r48 = r10.getChildAt(r4);
        RecyclerView.LayoutParams r49 = r48.getLayoutParams();
        if (r49 == null) goto L84;
        RecyclerView.LayoutParams r50 = r49;
        int r51 = r48.getTop() - ((ViewGroup.MarginLayoutParams) r50).topMargin;
        int r52 = r48.getBottom() + ((ViewGroup.MarginLayoutParams) r50).bottomMargin;
        int r53 = r48.getRight() + ((ViewGroup.MarginLayoutParams) r50).rightMargin;
        int r54 = this.b;
        int r55 = r53 - r54;
        int r56 = r54 + r55;
        if (r12 == null) goto L81;
        r12.setBounds(r55, r51, r56, r52);
    L81:
        if (r12 == null) goto L86;
        r12.draw(r9);
        goto L86
    L84:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L86:
        if (((r4 - 1) % 4) != 0) goto L96;
        View r57 = r10.getChildAt(r4);
        RecyclerView.LayoutParams r58 = r57.getLayoutParams();
        if (r58 == null) goto L95;
        RecyclerView.LayoutParams r59 = r58;
        int r60 = r57.getTop() - ((ViewGroup.MarginLayoutParams) r59).topMargin;
        int r61 = r57.getBottom() + ((ViewGroup.MarginLayoutParams) r59).bottomMargin;
        int r62 = r57.getLeft() - ((ViewGroup.MarginLayoutParams) r59).leftMargin;
        int r63 = this.b + r62;
        if (r12 == null) goto L92;
        r12.setBounds(r62, r60, r63, r61);
    L92:
        if (r12 == null) goto L96;
        r12.draw(r9);
        goto L96
    L95:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    L96:
        r4 = r4 + 1;
        goto L73
    L125:
        return;
    L121:
        return;
    }
}
