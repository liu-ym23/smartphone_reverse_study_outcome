package com.obric.oui.orecyclerview.widget;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f13929a;

    public /* synthetic */ y(Object r5) {
        this.f13929a = r5;
    }

    public void a(a r5) {
        int r10 = r5.f13785a;
        RecyclerView r11 = (RecyclerView) this.f13929a;
        if (r10 != 1) goto L5;
        r11.f13743m.getClass();
        return;
    L5:
        if (r10 != 2) goto L7;
        r11.f13743m.getClass();
        return;
    L7:
        if (r10 != 4) goto L9;
        r11.f13743m.getClass();
        return;
    L9:
        if (r10 != 8) goto L19;
        r11.f13743m.getClass();
        return;
    }

    public x0 b(int r10) {
        RecyclerView r11 = (RecyclerView) this.f13929a;
        int r5 = r11.e.s();
        int r12 = 0;
        x0 r13 = null;
    L3:
        if (r12 >= r5) goto L16;
        x0 r14 = RecyclerView.F(r11.e.r(r12));
        if (r14 == null) goto L15;
        if (r14.isRemoved() == true) goto L15;
        if (r14.mPosition != r10) goto L15;
        com.google.common.reflect.w r15 = r11.e;
        if (((ArrayList) r15.d).contains(r14.itemView) == false) goto L14;
        r13 = r14;
        goto L15
    L14:
        r13 = r14;
    L15:
        r12 = r12 + 1;
    L16:
        if (r13 != null) goto L18;
        return null;
    L18:
        com.google.common.reflect.w r16 = r11.e;
        if (((ArrayList) r16.d).contains(r13.itemView) == true) goto L21;
        return r13;
    L21:
        if (RecyclerView.f13724y0 == false) goto L23;
        Log.d("RecyclerView", "assuming view holder cannot be find because it is hidden");
    L23:
        return null;
    }

    public void c(int r10, int r11, Object r12) {
        RecyclerView r13 = (RecyclerView) this.f13929a;
        int r5 = r13.e.s();
        int r14 = r11 + r10;
        int r15 = 0;
    L4:
        if (r15 >= r5) goto L15;
        View r16 = r13.e.r(r15);
        x0 r17 = RecyclerView.F(r16);
        if (r17 == null) goto L14;
        if (r17.shouldIgnore() == true) goto L14;
        int r18 = r17.mPosition;
        if (r18 < r10) goto L14;
        if (r18 >= r14) goto L14;
        r17.addFlags(2);
        r17.addChangePayload(r12);
        ((RecyclerView.LayoutParams) r16.getLayoutParams()).f13770c = true;
    L14:
        r15 = r15 + 1;
        goto L4
    L15:
        q0 r19 = r13.f13728b;
        ArrayList r20 = r19.f13887c;
        int r21 = r20.size() - 1;
    L16:
        if (r21 < 0) goto L25;
        x0 r22 = (x0) r20.get(r21);
        if (r22 == null) goto L24;
        int r23 = r22.mPosition;
        if (r23 < r10) goto L24;
        if (r23 >= r14) goto L24;
        r22.addFlags(2);
        r19.f(r21);
    L24:
        r21 = r21 - 1;
        goto L16
    L25:
        r13.f13734f0 = true;
    }

    public void d(int r12, int r13) {
        RecyclerView r11 = (RecyclerView) this.f13929a;
        int r5 = r11.e.s();
        int r10 = 0;
    L4:
        if (r10 >= r5) goto L16;
        x0 r14 = RecyclerView.F(r11.e.r(r10));
        if (r14 == null) goto L15;
        if (r14.shouldIgnore() == true) goto L15;
        if (r14.mPosition < r12) goto L15;
        if (RecyclerView.f13724y0 == false) goto L14;
        Log.d("RecyclerView", "offsetPositionRecordsForInsert attached child " + r10 + " holder " + r14 + " now at position " + (r14.mPosition + r13));
    L14:
        r14.offsetPosition(r13, false);
        r11.f13729b0.e = true;
    L15:
        r10 = r10 + 1;
        goto L4
    L16:
        ArrayList r15 = r11.f13728b.f13887c;
        int r16 = r15.size();
        int r17 = 0;
    L17:
        if (r17 >= r16) goto L27;
        x0 r18 = (x0) r15.get(r17);
        if (r18 == null) goto L26;
        if (r18.mPosition < r12) goto L26;
        if (RecyclerView.f13724y0 == false) goto L25;
        Log.d("RecyclerView", "offsetPositionRecordsForInsert cached " + r17 + " holder " + r18 + " now at position " + (r18.mPosition + r13));
    L25:
        r18.offsetPosition(r13, false);
    L26:
        r17 = r17 + 1;
        goto L17
    L27:
        r11.requestLayout();
        r11.f13733e0 = true;
    }

    public void e(int r14, int r15) {
        RecyclerView r13 = (RecyclerView) this.f13929a;
        int r5 = r13.e.s();
        int r10 = -1;
        if (r14 >= r15) goto L5;
        int r11 = r14;
        int r12 = r15;
        int r16 = -1;
    L6:
        int r17 = 0;
    L8:
        if (r17 >= r5) goto L24;
        x0 r18 = RecyclerView.F(r13.e.r(r17));
        if (r18 == null) goto L23;
        int r19 = r18.mPosition;
        if (r19 < r11) goto L23;
        if (r19 > r12) goto L23;
        if (RecyclerView.f13724y0 == false) goto L19;
        Log.d("RecyclerView", "offsetPositionRecordsForMove attached child " + r17 + " holder " + r18);
    L19:
        if (r18.mPosition != r14) goto L21;
        r18.offsetPosition(r15 - r14, false);
    L22:
        r13.f13729b0.e = true;
        goto L23
    L21:
        r18.offsetPosition(r16, false);
    L23:
        r17 = r17 + 1;
        goto L8
    L24:
        q0 r20 = r13.f13728b;
        r20.getClass();
        if (r14 >= r15) goto L27;
        int r21 = r14;
        int r22 = r15;
    L28:
        ArrayList r23 = r20.f13887c;
        int r24 = r23.size();
        int r25 = 0;
    L29:
        if (r25 >= r24) goto L43;
        x0 r110 = (x0) r23.get(r25);
        if (r110 == null) goto L42;
        int r111 = r110.mPosition;
        if (r111 < r21) goto L42;
        if (r111 > r22) goto L42;
        if (r111 != r14) goto L38;
        r110.offsetPosition(r15 - r14, false);
    L40:
        if (RecyclerView.f13724y0 == false) goto L42;
        Log.d("RecyclerView", "offsetPositionRecordsForMove cached child " + r25 + " holder " + r110);
        goto L42
    L38:
        r110.offsetPosition(r10, false);
    L42:
        r25 = r25 + 1;
        goto L29
    L43:
        r13.requestLayout();
        r13.f13733e0 = true;
        return;
    L27:
        r22 = r14;
        r21 = r15;
        r10 = 1;
        goto L28
    L5:
        r12 = r14;
        r11 = r15;
        r16 = 1;
        goto L6
    }

    public void f(x0 r10, f0 r11, f0 r12) {
        RecyclerView r13 = (RecyclerView) this.f13929a;
        r13.getClass();
        r10.setIsRecyclable(false);
        i r5 = (i) r13.H;
        if (r11 == null) goto L9;
        r5.getClass();
        int r14 = r11.f13809a;
        int r15 = r12.f13809a;
        if (r14 == r15) goto L7;
    L8:
        boolean r16 = r5.g(r10, r14, r11.f13810b, r15, r12.f13810b);
    L10:
        if (r16 == false) goto L13;
        r13.N();
        return;
    L13:
        return;
    L7:
        if (r11.f13810b != r12.f13810b) goto L8;
    L9:
        r5.l(r10);
        r10.itemView.setAlpha(0.0f);
        r5.f13822i.add(r10);
        r16 = true;
        goto L10
    }

    public void g(x0 r10, f0 r11, f0 r12) {
        RecyclerView r13 = (RecyclerView) this.f13929a;
        r13.f13728b.k(r10);
        r13.g(r10);
        r10.setIsRecyclable(false);
        i r5 = (i) r13.H;
        r5.getClass();
        int r14 = r11.f13809a;
        int r15 = r11.f13810b;
        View r16 = r10.itemView;
        if (r12 != null) goto L6;
        int r17 = r16.getLeft();
    L5:
        int r18 = r17;
        if (r12 != null) goto L10;
        int r19 = r16.getTop();
    L9:
        int r20 = r19;
        if (r10.isRemoved() == true) goto L16;
        if (r14 != r18) goto L15;
        if (r15 == r20) goto L16;
    L15:
        r16.layout(r18, r20, r16.getWidth() + r18, r16.getHeight() + r20);
        boolean r21 = r5.g(r10, r14, r15, r18, r20);
    L17:
        if (r21 == false) goto L20;
        r13.N();
        return;
    L20:
        return;
    L16:
        r5.l(r10);
        r5.f13821h.add(r10);
        r21 = true;
        goto L17
    L10:
        r19 = r12.f13810b;
        goto L9
    L6:
        r17 = r12.f13809a;
        goto L5
    }

    public void h(int r5) {
        RecyclerView r10 = (RecyclerView) this.f13929a;
        View r11 = r10.getChildAt(r5);
        if (r11 == null) goto L9;
        x0 r12 = RecyclerView.F(r11);
        a0 r13 = r10.f13742l;
        if (r13 == null) goto L8;
        if (r12 == null) goto L8;
        r13.onViewDetachedFromWindow(r12);
    L8:
        r11.clearAnimation();
    L9:
        r10.removeViewAt(r5);
    }

    public void i(x0 r5) {
        RecyclerView r10 = (RecyclerView) this.f13929a;
        k0 r11 = r10.f13743m;
        View r12 = r5.itemView;
        com.google.common.reflect.w r13 = r11.f13838a;
        y r14 = (y) r13.f9377c;
        int r15 = ((RecyclerView) r14.f13929a).indexOfChild(r12);
        if (r15 >= 0) goto L6;
    L9:
        r10.f13728b.g(r12);
        return;
    L6:
        if (((com.bytedance.crash.upload.l) r13.f9376b).g(r15) == false) goto L8;
        r13.z(r12);
    L8:
        r14.h(r15);
        goto L9
    }
}
