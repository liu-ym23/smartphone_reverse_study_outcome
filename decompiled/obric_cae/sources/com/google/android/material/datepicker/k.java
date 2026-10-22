package com.google.android.material.datepicker;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class k extends RecyclerView.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f4705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Calendar f4706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f4707c;

    public k(i r8) {
        this.f4707c = r8;
        this.f4705a = g0.g(null);
        this.f4706b = g0.g(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.n
    public final void d(Canvas r22, RecyclerView r23) {
        if ((r23.getAdapter() instanceof i0) == true) goto L5;
        return;
    L5:
        if ((r23.getLayoutManager() instanceof GridLayoutManager) == false) goto L41;
        i0 r8 = (i0) r23.getAdapter();
        GridLayoutManager r10 = (GridLayoutManager) r23.getLayoutManager();
        i r11 = this.f4707c;
        Iterator r12 = r11.f4685m.e().iterator();
    L9:
        if (r12.hasNext() == false) goto L42;
        i0.c r13 = (i0.c) r12.next();
        F r14 = r13.f8079a;
        if (r14 == 0) goto L9;
        S r15 = r13.f8080b;
        if (r15 == 0) goto L9;
        long r16 = ((Long) r14).longValue();
        Calendar r17 = this.f4705a;
        r17.setTimeInMillis(r16);
        long r18 = ((Long) r15).longValue();
        Calendar r19 = this.f4706b;
        r19.setTimeInMillis(r18);
        int r20 = r17.get(1) - r8.f4703c.f4686n.f4599a.f4623m;
        int r21 = r19.get(1) - r8.f4703c.f4686n.f4599a.f4623m;
        View r24 = r10.r(r20);
        View r25 = r10.r(r21);
        int r26 = r10.F;
        int r27 = r20 / r26;
        int r28 = r21 / r26;
        int r29 = r27;
    L16:
        if (r29 > r28) goto L9;
        View r110 = r10.r(r10.F * r29);
        if (r110 == null) goto L30;
        int r111 = r110.getTop() + r11.f4690r.f4647d.f4634a.top;
        int r112 = r110.getBottom() - r11.f4690r.f4647d.f4634a.bottom;
        if (r29 != r27) goto L24;
        if (r24 == null) goto L24;
        int r113 = (r24.getWidth() / 2) + r24.getLeft();
    L25:
        if (r29 != r28) goto L28;
        if (r25 == null) goto L28;
        int r114 = (r25.getWidth() / 2) + r25.getLeft();
    L29:
        r22.drawRect(r113, r111, r114, r112, r11.f4690r.f4651h);
    L28:
        r114 = r23.getWidth();
    L24:
        r113 = 0;
    L30:
        r29 = r29 + 1;
        goto L16
    L42:
        return;
    }
}
