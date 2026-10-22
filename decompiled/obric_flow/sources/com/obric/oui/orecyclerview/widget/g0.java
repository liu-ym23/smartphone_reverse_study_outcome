package com.obric.oui.orecyclerview.widget;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f13814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f13815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f13816c;
    public long d;
    public long e;
    public long f;

    public static void b(x0 r5) {
        int r10 = r5.mFlags;
        if (r5.isInvalid() == false) goto L6;
        return;
    L6:
        if ((r10 & 4) != 0) goto L9;
        r5.getOldPosition();
        r5.getAbsoluteAdapterPosition();
        return;
    }

    public abstract boolean a(x0 r5, x0 r10, f0 r11, f0 r12);

    public final void c(x0 r10) {
        y r11 = this.f13814a;
        if (r11 == null) goto L28;
        boolean r5 = true;
        r10.setIsRecyclable(true);
        if (r10.mShadowedHolder != null) goto L7;
    L9:
        r10.mShadowingHolder = null;
        if (r10.shouldBeKeptAsChild() == true) goto L29;
        View r12 = r10.itemView;
        RecyclerView r13 = (RecyclerView) r11.f13929a;
        r13.X();
        com.google.common.reflect.w r14 = r13.e;
        y r15 = (y) r14.f9377c;
        int r16 = ((RecyclerView) r15.f13929a).indexOfChild(r12);
        if (r16 != (-1)) goto L14;
        r14.z(r12);
    L18:
        if (r5 == false) goto L22;
        x0 r17 = RecyclerView.F(r12);
        q0 r18 = r13.f13728b;
        r18.k(r17);
        r18.h(r17);
        if (RecyclerView.f13724y0 == false) goto L22;
        Log.d("RecyclerView", "after removing animated view: " + r12 + ", " + r13);
    L22:
        r13.Y(!r5);
        if (r5 == false) goto L25;
        return;
    L25:
        if (r10.isTmpDetached() == false) goto L31;
        r13.removeDetachedView(r10.itemView, false);
        return;
    L31:
        return;
    L14:
        com.bytedance.crash.upload.l r19 = (com.bytedance.crash.upload.l) r14.f9376b;
        if (r19.e(r16) == false) goto L17;
        r19.g(r16);
        r14.z(r12);
        r15.h(r16);
        goto L18
    L17:
        r5 = false;
        goto L18
    L29:
        return;
    L7:
        if (r10.mShadowingHolder != null) goto L9;
        r10.mShadowedHolder = null;
        goto L9
    }

    public abstract void d(x0 r5);

    public abstract void e();

    public abstract boolean f();
}
