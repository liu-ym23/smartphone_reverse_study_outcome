package com.lynx.xelement.scroll.coordinator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001\u0011B\u000f\u0012\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\n\u001a\u00020\tH&J\r\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u000fR\"\u0010\u0017\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\t8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\u00028\u00008\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010#R\"\u0010+\u001a\u00020\u000f8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00102\u001a\u00020\r8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00067"}, d2 = {"Lcom/lynx/xelement/scroll/coordinator/ScrollCoordinatorToolbarLayout;", "Lcom/google/android/material/appbar/AppBarLayout;", "T", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", NameKeys.UnloadStrategy_No_Strategy, "enabled", NameKeys.UnloadStrategy_No_Strategy, "setScrollEnabled", "setCompatContainerPopupEnabled", NameKeys.UnloadStrategy_No_Strategy, "getLayoutResId", "getAppBarLayout", "()Lcom/google/android/material/appbar/AppBarLayout;", "Landroidx/appcompat/widget/Toolbar;", "getPinnedToolbar", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "getCollapsingToolbar", "a", "Z", "getScrollEnabledFlag", "()Z", "setScrollEnabledFlag", "(Z)V", "scrollEnabledFlag", "b", "I", "getInitialScrollFlags", "()I", "setInitialScrollFlags", "(I)V", "initialScrollFlags", "d", "Lcom/google/android/material/appbar/AppBarLayout;", "getAppBarLayoutView", "setAppBarLayoutView", "(Lcom/google/android/material/appbar/AppBarLayout;)V", "appBarLayoutView", "e", "Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "getCollapsingToolbarView", "()Lcom/google/android/material/appbar/CollapsingToolbarLayout;", "setCollapsingToolbarView", "(Lcom/google/android/material/appbar/CollapsingToolbarLayout;)V", "collapsingToolbarView", "f", "Landroidx/appcompat/widget/Toolbar;", "getToolbarView", "()Landroidx/appcompat/widget/Toolbar;", "setToolbarView", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbarView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ScrollCoordinator_release"}, k = 1, mv = {1, 6, 0})
public abstract class ScrollCoordinatorToolbarLayout<T extends AppBarLayout> extends CoordinatorLayout {
    public boolean a;
    public int b;
    public boolean c;
    public T d;
    public CollapsingToolbarLayout e;
    public Toolbar f;

    public static final class a {
    }

    static {
    }

    public abstract int getLayoutResId();

    public abstract void setScrollEnabled(boolean r1);

    public final T getAppBarLayout() {
        return this.d;
    }

    public final T getAppBarLayoutView() {
        return this.d;
    }

    public final CollapsingToolbarLayout getCollapsingToolbar() {
        return this.e;
    }

    public final CollapsingToolbarLayout getCollapsingToolbarView() {
        return this.e;
    }

    public final int getInitialScrollFlags() {
        return this.b;
    }

    public final Toolbar getPinnedToolbar() {
        return this.f;
    }

    public final boolean getScrollEnabledFlag() {
        return this.a;
    }

    public final Toolbar getToolbarView() {
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScrollCoordinatorToolbarLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        new LinkedHashMap();
        super(r4);
        this.a = true;
        if ((r4 instanceof LynxContext) == false) goto L5;
        LLog.i("ScrollCoordinatorLayout", "context is: " + ((LynxContext) r4).getBaseContext());
    L5:
        View r5 = LayoutInflater.from(r4).inflate(getLayoutResId(), this, true);
        this.d = findViewById(2131363087);
        this.e = (CollapsingToolbarLayout) findViewById(2131367129);
        this.f = (Toolbar) findViewById(2131385226);
        r5.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        ViewGroup.LayoutParams r6 = this.e.getLayoutParams();
        if ((r6 instanceof AppBarLayout.LayoutParams) == false) goto L9;
        this.b = ((AppBarLayout.LayoutParams) r6).getScrollFlags();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean canScrollVertically(int r3) {
        CoordinatorLayout.LayoutParams r0 = this.d.getLayoutParams();
        if (r0 == null) goto L25;
        AppBarLayout.Behavior r1 = r0.getBehavior();
        if (this.c == false) goto L23;
        if ((r1 instanceof AppBarLayout.Behavior) == false) goto L23;
        AppBarLayout.Behavior r2 = r1;
        if (r2.getTopAndBottomOffset() < 0) goto L20;
        if (r3 > 0) goto L13;
    L15:
        if (r3 >= 0) goto L27;
        if (r2.getTopAndBottomOffset() != 0) goto L27;
        return false;
    L27:
        return super/*android.view.ViewGroup*/.canScrollVertically(r3);
    L13:
        if (r2.getTopAndBottomOffset() != 0) goto L15;
    L20:
        return true;
    L23:
        return super/*android.view.ViewGroup*/.canScrollVertically(r3);
    L25:
        throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
    }

    public final void setAppBarLayoutView(T r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final void setCollapsingToolbarView(CollapsingToolbarLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public final void setCompatContainerPopupEnabled(boolean r1) {
        this.c = r1;
    }

    public final void setInitialScrollFlags(int r1) {
        this.b = r1;
    }

    public final void setScrollEnabledFlag(boolean r1) {
        this.a = r1;
    }

    public final void setToolbarView(Toolbar r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f = r2;
    }
}
