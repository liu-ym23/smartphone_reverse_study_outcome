package com.obric.oui.orecyclerview.widget;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13891c;
    public int d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13893i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13894j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f13895k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f13896l;

    public final void a(View r10) {
        int r5 = this.f13895k.size();
        View r11 = null;
        int r12 = Integer.MAX_VALUE;
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L18;
        View r14 = ((x0) this.f13895k.get(r13)).itemView;
        RecyclerView.LayoutParams r15 = (RecyclerView.LayoutParams) r14.getLayoutParams();
        if (r14 == r10) goto L17;
        if (r15.f13768a.isRemoved() == true) goto L17;
        int r16 = (r15.f13768a.getLayoutPosition() - this.d) * this.e;
        if (r16 < 0) goto L17;
        if (r16 >= r12) goto L17;
        r11 = r14;
        if (r16 == 0) goto L18;
        r12 = r16;
    L17:
        r13 = r13 + 1;
    L18:
        if (r11 != null) goto L20;
        this.d = -1;
        return;
    L20:
        this.d = ((RecyclerView.LayoutParams) r11.getLayoutParams()).f13768a.getLayoutPosition();
    }
}
