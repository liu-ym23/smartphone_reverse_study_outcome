package com.obric.oui.window.a;

import android.view.DisplayCutout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\n"}, d2 = {"Lcom/obric/oui/window/calculator/DisplayCompatHelperApi28;", "", "()V", "safeInsetBottom", "", "displayCutout", "Landroid/view/DisplayCutout;", "safeInsetLeft", "safeInsetRight", "safeInsetTop", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f14883a = null;

    static {
        f14883a = new d();
    }

    private d() {
    }

    public final int a(DisplayCutout r1) {
        Intrinsics.checkNotNullParameter(r1, "displayCutout");
        return r1.getSafeInsetLeft();
    }

    public final int b(DisplayCutout r1) {
        Intrinsics.checkNotNullParameter(r1, "displayCutout");
        return r1.getSafeInsetTop();
    }

    public final int c(DisplayCutout r1) {
        Intrinsics.checkNotNullParameter(r1, "displayCutout");
        return r1.getSafeInsetRight();
    }

    public final int d(DisplayCutout r1) {
        Intrinsics.checkNotNullParameter(r1, "displayCutout");
        return r1.getSafeInsetBottom();
    }
}
