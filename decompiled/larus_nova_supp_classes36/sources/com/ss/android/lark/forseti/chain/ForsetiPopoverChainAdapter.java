package com.ss.android.lark.forseti.chain;

import android.content.Context;
import android.view.ViewGroup;
import com.ss.android.lark.api.bean.ForsetiChainType;
import com.ss.android.lark.api.bean.ForsetiPageViewType;
import com.ss.android.lark.forseti.widget.ForsetiPopoverViewGroup;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForsetiPopoverChainAdapter implements s {
    public static final /* synthetic */ int e = 0;
    public final Context a;
    public Function0<Unit> b;
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
        return false;
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void f(boolean r1) {
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void k(boolean r1) {
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final ViewGroup h() {
        return (ViewGroup) this.c.getValue();
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final ViewGroup j() {
        return (ViewGroup) this.d.getValue();
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final ForsetiPageViewType n() {
        return ((ForsetiPopoverViewGroup) ((ViewGroup) this.c.getValue()).findViewById(2131382768)).getCurrentPageViewType();
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void g(com.ss.android.lark.api.ui.g r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        ForsetiPopoverViewGroup r1 = (ForsetiPopoverViewGroup) ((ViewGroup) this.c.getValue()).findViewById(2131382768);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "listener");
        ((ArrayList) r1.h).remove(r4);
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void i(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.b = r2;
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void l(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void m(com.ss.android.lark.api.ui.g r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        ForsetiPopoverViewGroup r1 = (ForsetiPopoverViewGroup) ((ViewGroup) this.c.getValue()).findViewById(2131382768);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "listener");
        if (r5 == false) goto L5;
        r4.a(r1.g);
    L5:
        ((ArrayList) r1.h).add(r4);
    }

    public ForsetiPopoverChainAdapter(Context r2, ForsetiChainType r3, final uua.a r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chainType");
        Intrinsics.checkNotNullParameter(r4, "forsetiInnerOptions");
        this.a = r2;
        this.b = ForsetiPopoverChainAdapter$closeHandler$1.INSTANCE;
        LazyThreadSafetyMode r5 = LazyThreadSafetyMode.NONE;
        this.c = LazyKt.lazy(r5, new ForsetiPopoverChainAdapter$contentView$2(this, r4));
        this.d = LazyKt.lazy(r5, new ForsetiPopoverChainAdapter$fragmentParentView$2(this));
    }
}
