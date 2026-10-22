package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ui.ClipFrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements Runnable {
    public final /* synthetic */ BaseLinkSeatWindowView a;
    public final /* synthetic */ int b;

    public a(BaseLinkSeatWindowView r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        LinkMicRecyclerView r0 = this.a.getRecyclerView();
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        RecyclerView.LayoutManager r2 = r0.getLayoutManager();
    L7:
        if ((r2 instanceof ug0.a) == true) goto L9;
        r2 = null;
    L9:
        ug0.a r3 = (ug0.a) r2;
        if (r3 == null) goto L12;
        Pair<Integer, Integer> r4 = r3.a(this.b);
    L13:
        LinkMicRecyclerView r5 = this.a.getRecyclerView();
        if (r5 == null) goto L16;
        RecyclerView.LayoutManager r6 = r5.getLayoutManager();
    L18:
        if ((r6 instanceof ug0.a) == true) goto L20;
        r6 = null;
    L20:
        ug0.a r7 = (ug0.a) r6;
        if (r7 == null) goto L23;
        Pair<Integer, Integer> r8 = r7.c(this.b);
    L24:
        ClipFrameLayout r9 = this.a.z;
        if (r9 == null) goto L27;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
    L29:
        if ((r10 instanceof ConstraintLayout.LayoutParams) == true) goto L31;
        r10 = null;
    L31:
        ConstraintLayout.LayoutParams r11 = (ConstraintLayout.LayoutParams) r10;
        int r12 = 0;
        if (r11 == null) goto L57;
        if (r8 == null) goto L37;
        Integer r13 = (Integer) r8.getFirst();
        if (r13 == null) goto L37;
        int r14 = r13.intValue();
    L38:
        ((ViewGroup.MarginLayoutParams) r11).leftMargin = r14;
        if (r8 == null) goto L43;
        Integer r15 = (Integer) r8.getSecond();
        if (r15 == null) goto L43;
        int r16 = r15.intValue();
    L44:
        ((ViewGroup.MarginLayoutParams) r11).topMargin = r16;
        if (r4 == null) goto L49;
        Integer r17 = (Integer) r4.getFirst();
        if (r17 == null) goto L49;
        int r18 = r17.intValue();
    L50:
        ((ViewGroup.MarginLayoutParams) r11).width = r18;
        if (r4 == null) goto L55;
        Integer r19 = (Integer) r4.getSecond();
        if (r19 == null) goto L55;
        int r20 = r19.intValue();
    L56:
        ((ViewGroup.MarginLayoutParams) r11).height = r20;
        this.a.getMFirstVHShadowViewChange();
    L55:
        r20 = 0;
    L49:
        r18 = 0;
    L43:
        r16 = 0;
    L37:
        r14 = 0;
    L57:
        ClipFrameLayout r21 = this.a.A;
        if (r21 == null) goto L60;
        ViewGroup.LayoutParams r22 = r21.getLayoutParams();
    L62:
        if ((r22 instanceof ConstraintLayout.LayoutParams) == false) goto L65;
        r1 = r22;
    L65:
        ConstraintLayout.LayoutParams r23 = (ConstraintLayout.LayoutParams) r1;
        if (r23 == null) goto L91;
        if (r8 == null) goto L71;
        Integer r24 = (Integer) r8.getFirst();
        if (r24 == null) goto L71;
        int r25 = r24.intValue();
    L72:
        ((ViewGroup.MarginLayoutParams) r23).leftMargin = r25;
        if (r8 == null) goto L77;
        Integer r26 = (Integer) r8.getSecond();
        if (r26 == null) goto L77;
        int r27 = r26.intValue();
    L78:
        ((ViewGroup.MarginLayoutParams) r23).topMargin = r27;
        if (r4 == null) goto L83;
        Integer r28 = (Integer) r4.getFirst();
        if (r28 == null) goto L83;
        int r29 = r28.intValue();
    L84:
        ((ViewGroup.MarginLayoutParams) r23).width = r29;
        if (r4 == null) goto L89;
        Integer r30 = (Integer) r4.getSecond();
        if (r30 == null) goto L89;
        r12 = r30.intValue();
    L89:
        ((ViewGroup.MarginLayoutParams) r23).height = r12;
        this.a.getMFirstVHShadowViewChange();
        return;
    L83:
        r29 = 0;
    L77:
        r27 = 0;
    L71:
        r25 = 0;
        goto L72
    L91:
        return;
    L60:
        r22 = null;
        goto L62
    L27:
        r10 = null;
        goto L29
    L23:
        r8 = null;
        goto L24
    L16:
        r6 = null;
        goto L18
    L12:
        r4 = null;
        goto L13
    L5:
        r2 = null;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
