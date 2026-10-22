package com.ss.android.lark.forseti.chain;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.api.bean.ForsetiPageViewType;
import com.ss.android.lark.forseti.util.dragging.ForsetiColumnsDraggingHelper;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainDraggingLayout;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainDraggingViewGroup;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroup;
import com.ss.android.lark.forseti.widget.ForsetiNormalChainViewGroupCompat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForsetiNormalChainAdapter implements s {
    public final Context a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void b(int r1) {
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void c(boolean r1) {
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void d(int r1) {
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final boolean e() {
        return true;
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void f(boolean r1) {
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void k(boolean r1) {
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final ViewGroup h() {
        ForsetiNormalChainDraggingViewGroup r0 = (ForsetiNormalChainDraggingViewGroup) this.d.getValue();
        ForsetiNormalChainViewGroup.b r1 = new ForsetiNormalChainViewGroup.b(r0.getContext(), -1, -1);
        r0.addView((ForsetiNormalChainViewGroupCompat) this.b.getValue(), r1);
        r0.addView((ForsetiNormalChainDraggingLayout) this.c.getValue(), r1);
        return r0;
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final ViewGroup j() {
        View r0 = ((ForsetiNormalChainDraggingViewGroup) this.d.getValue()).getChildAt(0);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        return (ViewGroup) r0;
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final ForsetiPageViewType n() {
        return ForsetiPageViewType.NORMAL_VIEW;
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void g(com.ss.android.lark.api.ui.g r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void i(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void l(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
    }

    public ForsetiNormalChainAdapter(Context r1, ForsetiColumnsDraggingHelper r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.a = r1;
        this.b = LazyKt.lazy(new ForsetiNormalChainAdapter$contentView$2(this));
        this.c = LazyKt.lazy(new ForsetiNormalChainAdapter$draggingView$2(this));
        this.d = LazyKt.lazy(new ForsetiNormalChainAdapter$contentViewWrapper$2(this));
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void m(com.ss.android.lark.api.ui.g r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "listener");
    }
}
