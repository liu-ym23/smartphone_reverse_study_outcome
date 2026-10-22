package uc;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.obric.oui.titlebar.OFloatingTitleBar;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OFloatingTitleBar f12585a;

    public a(OFloatingTitleBar r8) {
        this.f12585a = r8;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View r8, WindowInsets r10) {
        i.f(r8, "<anonymous parameter 0>");
        i.f(r10, "insets");
        int r11 = r10.getSystemWindowInsetTop();
        OFloatingTitleBar r12 = this.f12585a;
        View r13 = r12.f6620w;
        if (r13 == null) goto L22;
        ViewGroup.LayoutParams r14 = r13.getLayoutParams();
        Resources r15 = Resources.getSystem();
        i.e(r15, "Resources.getSystem()");
        r14.height = l6.a.I0(TypedValue.applyDimension(1, 80, r15.getDisplayMetrics())) + r11;
        View r16 = r12.f6620w;
        if (r16 == null) goto L20;
        r16.setLayoutParams(r14);
        View r17 = r12.f6621x;
        if (r17 == null) goto L18;
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        if (r18 == null) goto L17;
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        r19.topMargin = r11;
        View r20 = r12.f6621x;
        if (r20 == null) goto L14;
        r20.setLayoutParams(r19);
        return r10;
    L14:
        i.j("titleBarContainer");
        throw null;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L18:
        i.j("titleBarContainer");
        throw null;
    L20:
        i.j("mask");
        throw null;
    L22:
        i.j("mask");
        throw null;
    }
}
