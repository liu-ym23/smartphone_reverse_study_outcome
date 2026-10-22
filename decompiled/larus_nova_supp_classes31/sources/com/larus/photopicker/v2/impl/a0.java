package com.larus.photopicker.v2.impl;

import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.larus.common_ui.view.BottomOverlayViewAdapterPad;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a0 extends BottomSheetBehavior.BottomSheetCallback {
    public final /* synthetic */ BottomPhotoPickerFragmentV3 a;

    public a0(BottomPhotoPickerFragmentV3 r1) {
        this.a = r1;
    }

    public final void onSlide(View r6, float r7) {
        Intrinsics.checkNotNullParameter(r6, "bottomSheet");
        boolean r1 = false;
        if (this.a.A.a() == false) goto L5;
    L15:
        this.a.S90().calculateBottomSheetSlide(r7);
        BottomPhotoPickerFragmentV3 r8 = this.a;
        b0 r3 = r8.p;
        if (r3 == null) goto L18;
        r3.c = false;
    L18:
        if (r3 == null) goto L22;
        View r4 = r3.e;
        if (r4 == null) goto L22;
        r4.setAlpha(0.0f);
    L22:
        com.larus.platform.api.b0 r5 = r8.k;
        if (r5 == null) goto L25;
        r5.e((int) r7);
    L25:
        BottomOverlayViewAdapterPad r9 = r8.u;
        if ((r9 instanceof BottomOverlayViewAdapterPad) == false) goto L28;
        BottomOverlayViewAdapterPad r10 = r9;
    L29:
        if (r10 != null) goto L31;
    L33:
        boolean r11 = false;
    L34:
        if (r11 == true) goto L36;
        return;
    L36:
        if (r7 != 0.0f) goto L38;
        r1 = true;
    L38:
        if (r1 == false) goto L44;
        com.larus.platform.api.b0 r12 = r8.k;
        if (r12 == null) goto L45;
        r12.c();
        return;
    L45:
        return;
    L44:
        return;
    L31:
        if (r10.e != true) goto L33;
        r11 = true;
        goto L34
    L28:
        r10 = null;
        goto L29
    L5:
        if (r7 != 0.0f) goto L7;
        boolean r13 = true;
    L8:
        if (r13 == true) goto L15;
        if (r7 != 1.0f) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == true) goto L15;
        return;
    L12:
        r14 = false;
        goto L13
    L7:
        r13 = false;
        goto L8
    }

    public final void onStateChanged(View r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "bottomSheet");
        BottomPhotoPickerFragmentV3 r7 = this.a;
        int r0 = BottomPhotoPickerFragmentV3.C;
        r7.S90().getBottomSheetOnStateChanged().setValue(Integer.valueOf(r6));
        BottomPhotoPickerFragmentV3 r8 = this.a;
        b0 r1 = r8.p;
        if (r1 == null) goto L6;
        r1.c = true;
    L6:
        if (r1 == null) goto L10;
        View r2 = r1.e;
        if (r2 == null) goto L10;
        r2.setAlpha(0.0f);
    L10:
        FrameLayout r3 = r8.s;
        if (r6 != 3) goto L13;
        if (r3 == null) goto L30;
        r3.setOutlineProvider(new y());
        r3.setClipToOutline(true);
    L30:
        View r9 = r8.u;
        if (r9 == null) goto L33;
        com.larus.utils.e1.o(r9);
    L33:
        if (r6 != 3) goto L38;
        com.larus.platform.api.b0 r10 = this.a.k;
        if (r10 == null) goto L39;
        r10.onPageShow();
        return;
    L39:
        return;
    L38:
        return;
    L13:
        if (r6 != 4) goto L15;
        b0 r4 = r8.p;
        if (r4 == null) goto L23;
        View r11 = r4.e;
        if (r11 == null) goto L23;
        r11.setAlpha(0.0f);
    L23:
        if (r3 == null) goto L25;
        r3.setOutlineProvider(new z());
        r3.setClipToOutline(false);
    L25:
        View r12 = r8.u;
        if (r12 == null) goto L33;
        com.larus.utils.e1.x(r12);
        goto L33
    L15:
        if (r6 != 5) goto L33;
        r8.Uw();
        goto L33
    }
}
