package com.larksuite.framework.ui.stickyheader;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import q28.c;
import r28.b;
import u28.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class AnimationFixStickyRecyclerHeadersDecoration extends StickyRecyclerHeadersDecoration {
    public AnimationFixStickyRecyclerHeadersDecoration(c r1) {
        super(r1);
    }

    @Override // com.larksuite.framework.ui.stickyheader.StickyRecyclerHeadersDecoration
    public final void onDrawOver(Canvas r13, RecyclerView r14, RecyclerView.State r15) {
        if (r14.getItemAnimator() != null) goto L5;
    L20:
        super.onDrawOver(r13, r14, r15);
        return;
    L5:
        if (r14.getItemAnimator().isRunning() == false) goto L20;
        int r16 = r14.getPaddingLeft();
        int r0 = r14.getWidth() - r14.getPaddingRight();
        int r1 = r14.getChildCount();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L27;
        View r7 = r14.getChildAt(r2);
        int r3 = r14.getChildAdapterPosition(r7);
        if (r3 == (-1)) goto L19;
        boolean r8 = this.e.e(r7, ((a) this.d).a(r14), r3);
        if (r8 == false) goto L14;
    L15:
        View r9 = ((b) this.c).a(r14, r3);
        boolean r4 = this.e.g(r14, r7, r9, ((a) this.d).a(r14));
        int r10 = r9.getHeight();
        if (r4 == false) goto L18;
        Rect r11 = new Rect();
        this.e.f(r11, r14, r9, r7, r8);
        r11.toString();
        t28.a r5 = this.f;
        int r6 = r11.top;
        r5.a(r14, r13, r9, new Rect(r16, r6, r0, r10 + r6));
        goto L19
    L18:
        int r12 = (int) (r7.getTranslationY() + 0.5f);
        RecyclerView.LayoutParams r17 = r7.getLayoutParams();
        int r19 = (r7.getTop() - ((ViewGroup.MarginLayoutParams) r17).topMargin) + r12;
        Rect r20 = new Rect(r16, r19 - r10, r0, r19);
        this.f.a(r14, r13, r9, r20);
        goto L19
    L14:
        if (this.e.d(r3, ((a) this.d).b(r14)) == true) goto L15;
    L19:
        r2 = r2 + 1;
        goto L7
    }
}
