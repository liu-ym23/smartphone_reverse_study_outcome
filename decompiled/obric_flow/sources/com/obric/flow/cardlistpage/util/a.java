package com.obric.flow.cardlistpage.util;

import android.view.ViewConfiguration;
import com.obric.flow.cardlistpage.ui.view.WidgetBox;
import com.obric.flow.cardlistpage.ui.view.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WidgetBox f11880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f11881b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11882c;
    public final float d;
    public boolean e;
    public androidx.fragment.app.d f;

    static {
    }

    public a(WidgetBox r5, j r10) {
        Intrinsics.checkNotNullParameter(r5, "mView");
        this.f11880a = r5;
        this.f11881b = r10;
        this.f11882c = ViewConfiguration.get(r5.getContext()).getScaledTouchSlop();
        this.d = 0.75f;
    }

    public final void a() {
        WidgetBox r5 = this.f11880a;
        if (r5.getParent() != null) goto L5;
        return;
    L5:
        if (r5.hasWindowFocus() == false) goto L16;
        r5.isPressed();
        j r10 = this.f11881b;
        if (this.e == false) goto L9;
        return;
    L9:
        if (r10.onLongClick(r5) == false) goto L11;
        r5.setPressed(false);
        this.e = true;
    L11:
        androidx.fragment.app.d r11 = this.f;
        if (r11 == null) goto L18;
        r5.removeCallbacks(r11);
        this.f = null;
        return;
    L18:
        return;
    }
}
