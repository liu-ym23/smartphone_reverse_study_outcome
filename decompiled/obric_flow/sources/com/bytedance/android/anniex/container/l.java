package com.bytedance.android.anniex.container;

import android.R;
import android.content.res.TypedArray;
import android.view.View;
import com.bytedance.android.anniex.container.popup.PopupCloseType;
import com.bytedance.android.anniex.container.popup.SheetBaseDialog;
import com.bytedance.android.anniex.container.ui.AnnieXDialog;
import com.obric.oui.panel.BottomSheetDialog;
import com.obric.oui.sheet.OBottomSheetDialog;
import com.obric.oui.swipeaction.OSwipeLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3157b;

    public /* synthetic */ l(Object r5, int r10) {
        this.f3156a = r10;
        this.f3157b = r5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        switch(this.f3156a) {
            case 0: goto L28;
            case 1: goto L17;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        OSwipeLayout.n((OSwipeLayout) this.f3157b);
        return;
    L6:
        OBottomSheetDialog r10 = (OBottomSheetDialog) this.f3157b;
        if (r10.d == true) goto L9;
        return;
    L9:
        if (r10.isShowing() == true) goto L11;
        return;
    L11:
        if (r10.f == true) goto L14;
        TypedArray r11 = r10.getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
        r10.e = r11.getBoolean(0, true);
        r11.recycle();
        r10.f = true;
    L14:
        if (r10.e == false) goto L40;
        r10.cancel();
        return;
    L40:
        return;
    L17:
        BottomSheetDialog r12 = (BottomSheetDialog) this.f3157b;
        if (r12.d == true) goto L20;
        return;
    L20:
        if (r12.isShowing() == true) goto L22;
        return;
    L22:
        if (r12.f == true) goto L25;
        TypedArray r13 = r12.getContext().obtainStyledAttributes(new int[]{R.attr.windowCloseOnTouchOutside});
        r12.e = r13.getBoolean(0, true);
        r13.recycle();
        r12.f = true;
    L25:
        if (r12.e == false) goto L43;
        r12.cancel();
        return;
    L43:
        return;
    L28:
        m r14 = (m) this.f3157b;
        AnnieXDialog r15 = r14.f3159b;
        if (r15 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("dialogFragment");
        r15 = null;
    L32:
        if (r15.isCancelable() == false) goto L36;
        SheetBaseDialog r16 = r14.f3160c;
        if (r16 == null) goto L44;
        r16.cancel();
        return;
    L44:
        return;
    L36:
        r14.sendEvent(new c(4));
        PopupCloseType r17 = PopupCloseType.f3164c;
        r14.getClass();
        r14.sendEvent(new g(r17));
    }
}
