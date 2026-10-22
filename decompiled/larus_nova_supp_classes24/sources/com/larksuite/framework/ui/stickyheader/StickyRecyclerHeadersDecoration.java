package com.larksuite.framework.ui.stickyheader;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import q28.c;
import r28.a;
import u28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class StickyRecyclerHeadersDecoration extends RecyclerView.ItemDecoration {
    public final c a;
    public final SparseArray<Rect> b;
    public final a c;
    public final b d;
    public final q28.a e;
    public final t28.a f;
    public final s28.a g;
    public final Rect h;

    public StickyRecyclerHeadersDecoration(c r7) {
        u28.a r0 = new u28.a();
        s28.a r1 = new s28.a();
        t28.a r2 = new t28.a(r0);
        r28.b r3 = new r28.b(r7, r0);
        q28.a r4 = new q28.a(r7, r3, r0, r1);
        this.b = new SparseArray();
        this.h = new Rect();
        this.a = r7;
        this.c = r3;
        this.d = r0;
        this.f = r2;
        this.g = r1;
        this.e = r4;
    }

    public void onDrawOver(Canvas r10, RecyclerView r11, RecyclerView.State r12) {
        super.onDrawOver(r10, r11, r12);
        int r13 = r11.getChildCount();
        if (r13 > 0) goto L5;
        return;
    L5:
        if (this.a.getItemCount() <= 0) goto L26;
        this.b.clear();
        int r0 = 0;
    L8:
        if (r0 >= r13) goto L27;
        View r5 = r11.getChildAt(r0);
        int r1 = r11.getChildAdapterPosition(r5);
        if (r1 == (-1)) goto L20;
        boolean r6 = this.e.e(r5, ((u28.a) this.d).a(r11), r1);
        if (r6 == false) goto L15;
    L16:
        View r7 = ((r28.b) this.c).a(r11, r1);
        Rect r2 = this.b.get(r1);
        if (r2 != null) goto L19;
        r2 = new Rect();
        this.b.put(r1, r2);
    L19:
        Rect r8 = r2;
        this.e.f(r8, r11, r7, r5, r6);
        this.f.a(r11, r10, r7, r8);
        goto L20
    L15:
        if (this.e.d(r1, ((u28.a) this.d).b(r11)) == true) goto L16;
    L20:
        r0 = r0 + 1;
        goto L8
    L27:
        return;
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        super.getItemOffsets(r2, r3, r4, r5);
        int r6 = r4.getChildAdapterPosition(r3);
        if (r6 != (-1)) goto L6;
        return;
    L6:
        if (this.e.d(r6, ((u28.a) this.d).b(r4)) == false) goto L12;
        View r7 = ((r28.b) this.c).a(r4, r6);
        int r8 = ((u28.a) this.d).a(r4);
        s28.a r9 = this.g;
        Rect r0 = this.h;
        r9.getClass();
        s28.a.a(r0, r7);
        if (r8 != 1) goto L10;
        int r10 = r7.getHeight();
        Rect r11 = this.h;
        r2.top = (r10 + r11.top) + r11.bottom;
        return;
    L10:
        int r12 = r7.getWidth();
        Rect r13 = this.h;
        r2.left = (r12 + r13.left) + r13.right;
        return;
    }
}
