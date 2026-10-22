package com.ss.android.lark.forseti.chain;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.ss.android.lark.api.bean.ForsetiChainType;
import com.ss.android.lark.api.bean.ForsetiPageViewType;
import com.ss.android.lark.forseti.widget.ForsetiStackChainViewGroup;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ForsetiStackChainAdapter implements s {
    public static final /* synthetic */ int l = 0;
    public final Context a;
    public final ForsetiChainType b;
    public Lambda c;
    public Function0<Boolean> d;
    public boolean e;
    public int f;
    public BottomSheetBehavior<ForsetiStackChainViewGroup> g;
    public View h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ForsetiChainType.values().length];
            r0[ForsetiChainType.TYPE_HALF_STACK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ForsetiChainType.TYPE_STACK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final boolean e() {
        return false;
    }

    public final ForsetiStackChainViewGroup a() {
        return (ForsetiStackChainViewGroup) ((ViewGroup) this.j.getValue()).findViewById(2131387162);
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final ViewGroup h() {
        return (ViewGroup) this.j.getValue();
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final ViewGroup j() {
        return (ViewGroup) this.k.getValue();
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final ForsetiPageViewType n() {
        return a().getCurrentPageViewType();
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void b(int r2) {
        a().setPeekHeightInPx(r2);
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void c(boolean r3) {
        View r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("stack");
        r0 = null;
    L5:
        View r1 = r0.findViewById(2131387161);
        if (r3 == false) goto L8;
        int r4 = 0;
    L9:
        r1.setVisibility(r4);
        return;
    L8:
        r4 = 4;
        goto L9
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void d(int r3) {
        ForsetiStackChainViewGroup r0 = a();
        r0.getClass();
        if (r3 != 0) goto L5;
        ForsetiStackChainViewGroup.Style r4 = ForsetiStackChainViewGroup.Style.HALF_STACK;
    L10:
        if (r4 == r0.o) goto L13;
        r0.setStyle(r4);
        r0.requestLayout();
        return;
    L13:
        return;
    L5:
        if (r3 == 1) goto L7;
        r4 = ForsetiStackChainViewGroup.Style.UNINITIALIZED;
        goto L10
    L7:
        r4 = ForsetiStackChainViewGroup.Style.STACK;
        goto L10
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void f(boolean r2) {
        this.e = r2;
        BottomSheetBehavior<ForsetiStackChainViewGroup> r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        r0 = null;
    L5:
        r0.setDraggable(!r2);
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void g(com.ss.android.lark.api.ui.g r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ForsetiStackChainViewGroup r1 = a();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        ((ArrayList) r1.k).remove(r3);
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void i(final Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "handler");
        this.c = new ForsetiStackChainAdapter$setCloseHandler$1(this, r2);
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void k(boolean r3) {
        ForsetiStackChainViewGroup r0 = a();
        if (r3 == r0.h) goto L6;
        r0.h = r3;
        r0.requestLayout();
        return;
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void l(Function0<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        this.d = r2;
    }

    public ForsetiStackChainAdapter(Context r2, ForsetiChainType r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "chainType");
        this.a = r2;
        this.b = r3;
        this.c = ForsetiStackChainAdapter$closeHandler$1.INSTANCE;
        this.f = 4;
        this.i = LazyKt.lazy(ForsetiStackChainAdapter$nestedScrollOptimizeDisableFG$2.INSTANCE);
        LazyThreadSafetyMode r4 = LazyThreadSafetyMode.NONE;
        this.j = LazyKt.lazy(r4, new ForsetiStackChainAdapter$contentView$2(this));
        this.k = LazyKt.lazy(r4, new ForsetiStackChainAdapter$fragmentParentView$2(this));
    }

    @Override // com.ss.android.lark.forseti.chain.s
    public final void m(com.ss.android.lark.api.ui.g r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        ForsetiStackChainViewGroup r1 = a();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (r4 == false) goto L5;
        r3.a(r1.j);
    L5:
        ((ArrayList) r1.k).add(r3);
    }
}
