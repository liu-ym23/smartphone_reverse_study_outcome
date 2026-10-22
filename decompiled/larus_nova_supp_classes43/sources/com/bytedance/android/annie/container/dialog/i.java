package com.bytedance.android.annie.container.dialog;

import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.annie.container.fragment.AnnieFragment;
import com.bytedance.android.annie.scheme.vo.refactor.PopupHybridParamVoNew;
import com.bytedance.android.livesdk.pannel.SheetBaseBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i implements SheetBaseBehavior.b {
    public final /* synthetic */ BaseDialogFragment a;

    public i(BaseDialogFragment r1) {
        this.a = r1;
    }

    public final void a(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "bottomSheet");
        if (this.a.getActivity() != null) goto L5;
        return;
    L5:
        FragmentActivity r12 = this.a.getActivity();
        Intrinsics.checkNotNull(r12);
        Window r13 = r12.getWindow();
        if (r13 == null) goto L58;
        HybridFragment r0 = this.a.f;
        if ((r0 instanceof AnnieFragment) == false) goto L10;
        AnnieFragment r1 = (AnnieFragment) r0;
    L11:
        boolean r14 = true;
        if (r1 == null) goto L38;
        r1.p0 = r11;
        if (r11 == 3) goto L28;
        if (r11 != 4) goto L37;
        View r15 = r1.H0;
        if (r15 == null) goto L22;
        r15.setVisibility(0);
    L22:
        if (r1.needAdapterStatusBarColor() == false) goto L37;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.a.k == false) goto L37;
        if (r1.g1 == false) goto L37;
        com.bytedance.android.annie.util.i.h(r1.getActivity());
        r1.g1 = false;
    L37:
        r1.handlePullStateChange(r11);
        goto L38
    L28:
        View r16 = r1.H0;
        if (r16 == null) goto L33;
        r16.setVisibility(8);
    L33:
        if (r1.needAdapterStatusBarColor() == false) goto L37;
        com.bytedance.android.annie.ng.g.b().getClass();
        if (com.bytedance.android.annie.ng.e.a.k == false) goto L37;
        com.bytedance.android.annie.util.i.j(r1.getActivity(), Boolean.FALSE);
        r1.g1 = true;
    L38:
        if (r11 == 1) goto L54;
        if (r11 == 3) goto L46;
        if (r11 != 4) goto L42;
        this.a.ka0(1);
        return;
    L42:
        if (r11 != 5) goto L64;
        this.a.ka0(3);
        return;
    L64:
        return;
    L46:
        this.a.ka0(2);
        PopupHybridParamVoNew r17 = this.a.e;
        if (r17 != null) goto L49;
    L51:
        r14 = false;
    L52:
        if (r14 == false) goto L61;
        r13.setStatusBarColor(this.a.h);
        return;
    L61:
        return;
    L49:
        if (r17.x3() == true) goto L51;
    L54:
        int r18 = r13.getStatusBarColor();
        int r19 = this.a.g;
        if (r18 == r19) goto L63;
        r13.setStatusBarColor(r19);
        return;
    L63:
        return;
    L10:
        r1 = null;
        goto L11
    }

    public final void b(View r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "bottomSheet");
        HybridFragment r1 = this.a.f;
        if ((r1 instanceof AnnieFragment) == false) goto L5;
        AnnieFragment r12 = (AnnieFragment) r1;
    L6:
        if (r12 == null) goto L13;
        Intrinsics.checkNotNullParameter(r10, "bottomSheet");
        View r13 = r12.j;
        if (r13 == null) goto L11;
        r13.setAlpha(r11);
    L11:
        r12.ia0(r11);
        return;
    L13:
        return;
    L5:
        r12 = null;
        goto L6
    }
}
