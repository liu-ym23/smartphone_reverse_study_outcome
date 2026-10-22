package qs;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import com.obric.oui.dialog.base.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.obric.oui.dialog.base.f f21568a;

    public c(j r5, com.obric.oui.dialog.base.f r10) {
        this.f21568a = r10;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View r10, WindowInsets r11) {
        i r12 = i.a(r10, r11);
        j r13 = this.f21568a.f13119a;
        Intrinsics.checkNotNullParameter(r13, "this$0");
        boolean r14 = com.lynx.tasm.utils.j.s(r13.getContext());
        h r15 = r12.f21573a;
        b r5 = r15.f();
        boolean r16 = com.lynx.tasm.utils.j.t(r13.getContext());
        Context r17 = r13.getContext();
        Intrinsics.checkNotNullParameter(r17, "context");
        Activity r18 = com.lynx.tasm.utils.j.m(r17);
        int r19 = 0;
        if (r18 != null) goto L5;
        boolean r20 = false;
    L6:
        if (r20 == true) goto L10;
        if (r16 == true) goto L10;
        int r21 = com.lynx.tasm.utils.j.p(r13.getContext());
    L11:
        ViewGroup.LayoutParams r22 = r13.getDialogRootView().getLayoutParams();
        if ((r22 instanceof ViewGroup.MarginLayoutParams) == false) goto L14;
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r22;
    L15:
        if (r23 == null) goto L30;
        if (r14 == false) goto L19;
        r21 = 0;
    L19:
        int r24 = r13.getLayoutMarginBottom();
        int r25 = r5.d;
        if (r25 <= 0) goto L22;
        int r26 = 0;
    L23:
        int r27 = r24 + r26;
        if (r23.bottomMargin == r27) goto L26;
        r23.bottomMargin = r27;
        r13.getDialogRootView().setLayoutParams(r23);
    L26:
        if (r25 <= 0) goto L28;
        r19 = Math.max(0, r25 - r21);
    L28:
        r13.getDialogRootView().setTranslationY(-r19);
        goto L30
    L22:
        r26 = r21;
    L30:
        if ((r15 instanceof e) == true) goto L32;
        return null;
    L32:
        return ((e) r15).f21570b;
    L14:
        r23 = null;
    L10:
        r21 = 0;
        goto L11
    L5:
        r20 = r18.isInMultiWindowMode();
        goto L6
    }
}
