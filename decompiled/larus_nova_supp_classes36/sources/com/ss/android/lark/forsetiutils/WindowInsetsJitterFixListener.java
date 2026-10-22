package com.ss.android.lark.forsetiutils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/forsetiutils/WindowInsetsJitterFixListener;", "Landroidx/core/view/OnApplyWindowInsetsListener;", "originalListener", "<init>", "(Landroidx/core/view/OnApplyWindowInsetsListener;)V", "state", "Lcom/ss/android/lark/forsetiutils/WindowInsetsJitterFixListener$StateHolder;", "onApplyWindowInsets", "Landroidx/core/view/WindowInsetsCompat;", "v", "Landroid/view/View;", "insets", "isTopActivityNotEquals", "", "view", "findActivity", "Landroid/app/Activity;", "Landroid/content/Context;", "StateHolder", "forseti-utils_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class WindowInsetsJitterFixListener implements OnApplyWindowInsetsListener {
    public final OnApplyWindowInsetsListener a;
    public final a b;

    public static final class a {
        public WindowInsetsCompat a;

        public a() {
        }
    }

    public WindowInsetsJitterFixListener(OnApplyWindowInsetsListener r2) {
        Intrinsics.checkNotNullParameter(r2, "originalListener");
        this.a = r2;
        this.b = new a();
    }

    public final WindowInsetsCompat onApplyWindowInsets(View r5, WindowInsetsCompat r6) {
        Intrinsics.checkNotNullParameter(r5, "v");
        Intrinsics.checkNotNullParameter(r6, "insets");
        WindowInsetsCompat r0 = this.b.a;
        boolean r1 = false;
        if (r0 == null) goto L7;
        Insets r2 = r0.getInsets(WindowInsetsCompat.Type.systemBars());
        if (r2 == null) goto L7;
        int r3 = r2.top;
    L8:
        int r4 = r6.getInsets(WindowInsetsCompat.Type.systemBars()).top;
        boolean r7 = r5.hasWindowFocus();
        if (r3 <= 0) goto L30;
        if (r4 != 0) goto L30;
        if (r7 == false) goto L25;
        Context r8 = r5.getContext();
    L14:
        if ((r8 instanceof ContextWrapper) == false) goto L19;
        if ((r8 instanceof Activity) == true) goto L17;
        r8 = ((ContextWrapper) r8).getBaseContext();
        goto L14
    L17:
        Activity r9 = (Activity) r8;
    L20:
        if (r9 != null) goto L22;
    L24:
        if (r1 == false) goto L30;
    L22:
        if (Intrinsics.areEqual(r9, AppLifecycle.a.a.f()) == true) goto L24;
        r1 = true;
        goto L24
    L19:
        r9 = null;
    L25:
        WindowInsetsCompat r10 = this.b.a;
        if (r10 == null) goto L29;
        this.a.onApplyWindowInsets(r5, r10);
    L29:
        return WindowInsetsCompat.CONSUMED;
    L30:
        this.b.a = r6;
        return this.a.onApplyWindowInsets(r5, r6);
    L7:
        r3 = 0;
        goto L8
    }
}
