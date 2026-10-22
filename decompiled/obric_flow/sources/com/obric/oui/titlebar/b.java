package com.obric.oui.titlebar;

import android.view.View;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.ai.view.popup.AppletPopup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f14841b;

    public /* synthetic */ b(Object r5, int r10) {
        this.f14840a = r10;
        this.f14841b = r5;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r5, WindowInsetsCompat r10) {
        Object r11 = this.f14841b;
        switch(this.f14840a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        AppletPopup r12 = (AppletPopup) r11;
        r12.f2868v = r10;
        return r12.b(r5, r10);
    L6:
        int r13 = OUnitedTitleBar.f14820q;
        OUnitedTitleBar r14 = (OUnitedTitleBar) r11;
        Intrinsics.checkNotNullParameter(r14, "this$0");
        r14.getClass();
        if (ViewCompat.getFitsSystemWindows(r14) == false) goto L9;
        WindowInsetsCompat r15 = r10;
    L11:
        if (ObjectsCompat.equals(r14.f14832p, r15) == true) goto L17;
        r14.f14832p = r15;
        if (r14.getTopInset() <= 0) goto L15;
        boolean r16 = true;
    L16:
        r14.setWillNotDraw(!r16);
        r14.requestLayout();
        goto L17
    L15:
        r16 = false;
    L17:
        Intrinsics.checkNotNull(r10);
        return r10;
    L9:
        r15 = null;
        goto L11
    }
}
