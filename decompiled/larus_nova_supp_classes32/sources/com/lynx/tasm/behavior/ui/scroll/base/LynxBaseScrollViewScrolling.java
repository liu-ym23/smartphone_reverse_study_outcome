package com.lynx.tasm.behavior.ui.scroll.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.lynx.tasm.behavior.ui.scroll.LynxUIScrollViewInternal;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxBaseScrollViewScrolling extends FrameLayout implements h7a.c {
    public final d a;
    public boolean b;
    public boolean c;
    public int d;
    public int e;
    public boolean f;
    public final int[] g;
    public int h;
    public a i;
    public d.c j;

    public interface a {
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.a
    public int[] getScrollOffset() {
        return new int[]{getScrollX(), getScrollY()};
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.b
    public int[] getScrollRangeHorizontally() {
        return new int[]{0, Math.max(0, this.g[0] - this.d)};
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.g
    public int[] getScrollRangeVertically() {
        return new int[]{0, Math.max(0, this.g[1] - this.e)};
    }

    public final void j() {
        d.c r0 = this.j;
        if (r0 == null) goto L8;
        if (r0 == null) goto L6;
        r0.a(true);
    L6:
        this.j = null;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.b
    public int getScrollOffsetHorizontally() {
        return getScrollX();
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.g
    public int getScrollOffsetVertically() {
        return getScrollY();
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.base.a
    public int[] getScrollRange() {
        int[] r0 = getScrollRangeHorizontally();
        int[] r1 = getScrollRangeVertically();
        return new int[]{r0[0], r0[1], r1[0], r1[1]};
    }

    @Override // h7a.c
    public final boolean d() {
        return this.b;
    }

    public final void e(int[] r6) {
        if (this.c == false) goto L5;
        int r7 = r6[1];
        int[] r0 = getScrollRangeVertically();
        int r8 = Math.min(Math.max(r7, r0[0]), r0[1]);
        this.a.a(getScrollX(), r8, new f((LynxBaseScrollView) this));
        i(2);
        j();
        return;
    L5:
        int r9 = r6[0];
        int[] r1 = getScrollRangeHorizontally();
        int r10 = Math.min(Math.max(r9, r1[0]), r1[1]);
        this.a.a(r10, getScrollY(), new e((LynxBaseScrollView) this));
        i(2);
        j();
    }

    public final void f(int[] r4) {
        if (this.c == false) goto L5;
        int r5 = r4[1];
        int[] r0 = getScrollRangeVertically();
        h(Math.min(Math.max(r5, r0[0]), r0[1]));
        return;
    L5:
        int r6 = r4[0];
        int[] r1 = getScrollRangeHorizontally();
        g(Math.min(Math.max(r6, r1[0]), r1[1]));
    }

    public final void g(int r2) {
        scrollTo(r2, getScrollY());
    }

    public final void h(int r2) {
        scrollTo(getScrollX(), r2);
    }

    public final void i(int r7) {
        int r0 = this.h;
        if (r0 == r7) goto L17;
        this.h = r7;
        a r2 = this.i;
        if (r2 == null) goto L17;
        LynxUIScrollViewInternal r3 = (LynxUIScrollViewInternal) r2;
        if (r7 != 0) goto L9;
        r3.P("scrollend", null);
    L16:
        HashMap<String, Object> r4 = new HashMap();
        r4.put("previousState", Integer.valueOf(r0));
        r4.put("currentState", Integer.valueOf(r7));
        r3.P("scrollstatechange", r4);
        goto L17
    L9:
        if (r7 == 1) goto L14;
        if (r7 != 2) goto L16;
        if (r0 != 0) goto L16;
        r3.P("scrollstart", null);
        goto L16
    L14:
        r3.P("scrollstart", null);
    L17:
        if (r7 == 2) goto L20;
        j();
        return;
    }

    public void setScrollContentSize(int[] r2) {
        if (this.c == false) goto L5;
        setScrollContentSizeVertically(r2[1]);
        return;
    L5:
        setScrollContentSizeHorizontally(r2[0]);
    }

    public void setScrollContentSizeHorizontally(int r3) {
        int[] r0 = this.g;
        r0[0] = r3;
        r0[1] = this.e;
    }

    public void setScrollContentSizeVertically(int r4) {
        int[] r0 = this.g;
        r0[0] = this.d;
        r0[1] = r4;
    }

    public void setScrollDelegate(a r1) {
        this.i = r1;
    }

    public LynxBaseScrollViewScrolling(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = true;
        this.c = true;
        this.d = 0;
        this.e = 0;
        this.f = true;
        this.g = new int[2];
        this.h = 0;
        this.a = new d(r1);
    }
}
