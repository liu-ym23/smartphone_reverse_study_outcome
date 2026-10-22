package com.obric.oui.orecyclerview.widget;

import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class aa extends RecyclerView.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    RecyclerView f14114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Scroller f14115b;
    private final RecyclerView.m c;

    public aa() {
        this.c = new AnonymousClass1(this);
    }

    private void b() {
        if (this.f14114a.getOnFlingListener() != null) goto L7;
        this.f14114a.addOnScrollListener(this.c);
        this.f14114a.setOnFlingListener(this);
        return;
    L7:
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private boolean b(RecyclerView.h r3, int r4, int r5) {
        if (ZeusTransformUtils.instanceOf(r3, RecyclerView.r.b.class) == true) goto L5;
        return false;
    L5:
        RecyclerView.r r0 = b(r3);
        if (r0 != null) goto L8;
        return false;
    L8:
        int r2 = a(r3, r4, r5);
        if (r2 != (-1)) goto L11;
        return false;
    L11:
        r0.c(r2);
        r3.a(r0);
        return true;
    }

    private void c() {
        this.f14114a.removeOnScrollListener(this.c);
        this.f14114a.setOnFlingListener(null);
    }

    public abstract int a(RecyclerView.h r1, int r2, int r3);

    public abstract View a(RecyclerView.h r1);

    void a() {
        RecyclerView r0 = this.f14114a;
        if (r0 != null) goto L5;
        return;
    L5:
        RecyclerView.h r1 = r0.getLayoutManager();
        if (r1 != null) goto L8;
        return;
    L8:
        View r2 = a(r1);
        if (r2 != null) goto L11;
        return;
    L11:
        int[] r3 = a(r1, r2);
        if (r3[0] == 0) goto L14;
    L15:
        this.f14114a.smoothScrollBy(r3[0], r3[1]);
        return;
    L14:
        if (r3[1] != 0) goto L15;
    }

    public void a(RecyclerView r4) {
        RecyclerView r0 = this.f14114a;
        if (r0 != r4) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        c();
    L7:
        this.f14114a = r4;
        if (r4 == null) goto L11;
        b();
        this.f14115b = new Scroller((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f14114a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), new DecelerateInterpolator());
        a();
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView.k
    public boolean a(int r5, int r6) {
        RecyclerView.h r0 = this.f14114a.getLayoutManager();
        if (r0 != null) goto L6;
        return false;
    L6:
        if (this.f14114a.getAdapter() != null) goto L8;
        return false;
    L8:
        int r2 = this.f14114a.getMinFlingVelocity();
        if (Math.abs(r6) > r2) goto L13;
        if (Math.abs(r5) > r2) goto L13;
        return false;
    L13:
        if (b(r0, r5, r6) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public abstract int[] a(RecyclerView.h r1, View r2);

    public RecyclerView.r b(RecyclerView.h r1) {
        return c(r1);
    }

    @Deprecated
    public p c(RecyclerView.h r4) {
        if (ZeusTransformUtils.instanceOf(r4, RecyclerView.r.b.class) == true) goto L6;
        return null;
    L6:
        final Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f14114a.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        return new AnonymousClass2(this, r0);
    }
}
