package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import androidx.core.util.Preconditions;
import com.google.android.material.a.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExtendedFloatingActionButton f3920b;
    private final ArrayList<Animator.AnimatorListener> c;
    private final a d;
    private h e;
    private h f;

    b(ExtendedFloatingActionButton r3, a r4) {
        this.c = new ArrayList();
        this.f3920b = r3;
        this.f3919a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.d = r4;
    }

    static /* synthetic */ ExtendedFloatingActionButton a(b r0) {
        return r0.f3920b;
    }

    public final h a() {
        h r0 = this.f;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.e != null) goto L9;
        this.e = h.a(this.f3919a, h());
    L9:
        return (h) ZeusTransformUtils.preCheckCast(Preconditions.checkNotNull(this.e), h.class, "com.obric.memorydata.plugin");
    }

    @Override // com.google.android.material.floatingactionbutton.e
    public final void a(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        this.c.add(r4);
    }

    @Override // com.google.android.material.floatingactionbutton.e
    public void a(Animator r1) {
        this.d.a(r1);
    }

    @Override // com.google.android.material.floatingactionbutton.e
    public final void a(h r1) {
        this.f = r1;
    }

    AnimatorSet b(h r7) {
        ArrayList r0 = new ArrayList();
        if (r7.c("opacity") == false) goto L6;
        r0.add(r7.a("opacity", this.f3920b, View.ALPHA));
    L6:
        if (r7.c("scale") == false) goto L9;
        r0.add(r7.a("scale", this.f3920b, View.SCALE_Y));
        r0.add(r7.a("scale", this.f3920b, View.SCALE_X));
    L9:
        if (r7.c("width") == false) goto L12;
        r0.add(r7.a("width", this.f3920b, ExtendedFloatingActionButton.WIDTH));
    L12:
        if (r7.c("height") == false) goto L15;
        r0.add(r7.a("height", this.f3920b, ExtendedFloatingActionButton.HEIGHT));
    L15:
        if (r7.c("paddingStart") == false) goto L18;
        r0.add(r7.a("paddingStart", this.f3920b, ExtendedFloatingActionButton.PADDING_START));
    L18:
        if (r7.c("paddingEnd") == false) goto L21;
        r0.add(r7.a("paddingEnd", this.f3920b, ExtendedFloatingActionButton.PADDING_END));
    L21:
        if (r7.c("labelOpacity") == false) goto L23;
        final Class<Float> r4 = Float.class;
        final String r5 = "LABEL_OPACITY_PROPERTY";
        r0.add(r7.a("labelOpacity", this.f3920b, new AnonymousClass1(this, r4, r5)));
    L23:
        AnimatorSet r6 = new AnimatorSet();
        com.google.android.material.a.b.a(r6, r0);
        return r6;
    }

    @Override // com.google.android.material.floatingactionbutton.e
    public final List<Animator.AnimatorListener> b() {
        return this.c;
    }

    @Override // com.google.android.material.floatingactionbutton.e
    public final void b(Animator.AnimatorListener r3) {
        Animator.AnimatorListener r4 = (Animator.AnimatorListener) ZeusTransformUtils.wrapperContextForParams(r3, Animator.AnimatorListener.class, "com.obric.memorydata.plugin");
        this.c.remove(r4);
    }

    @Override // com.google.android.material.floatingactionbutton.e
    public h c() {
        return this.f;
    }

    @Override // com.google.android.material.floatingactionbutton.e
    public void d() {
        this.d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.e
    public void e() {
        this.d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.e
    public AnimatorSet f() {
        return b(a());
    }
}
