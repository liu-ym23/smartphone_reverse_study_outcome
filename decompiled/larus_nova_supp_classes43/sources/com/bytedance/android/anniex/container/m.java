package com.bytedance.android.anniex.container;

import android.view.View;
import android.view.Window;
import com.bytedance.android.anniex.container.popup.SheetBaseBehavior;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m implements SheetBaseBehavior.b {
    public final /* synthetic */ d a;

    public m(d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior.b
    public final void a(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "bottomSheet");
        Window r12 = this.a.a.getWindow();
        if (r12 == null) goto L54;
        d r0 = this.a;
        r0.p = r11;
        boolean r13 = false;
        ia.f.a r14 = null;
        if (r11 == 3) goto L16;
        if (r11 != 4) goto L24;
        View r15 = r0.n;
        if (r15 == null) goto L12;
        r15.setVisibility(0);
    L12:
        ia.f.a r16 = r0.b;
        if (r16 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
        r16 = null;
    L15:
        r16.h();
    L24:
        ia.f.a r1 = r0.b;
        if (r1 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
    L28:
        r14.j(r11);
        if (r11 == 1) goto L50;
        if (r11 == 3) goto L41;
        if (r11 == 4) goto L37;
        if (r11 != 5) goto L60;
        this.a.u(3);
        return;
    L60:
        return;
    L37:
        if (this.a.w() == false) goto L39;
        this.a.x();
    L39:
        this.a.u(1);
        return;
    L41:
        if (this.a.w() == false) goto L43;
        this.a.r();
    L43:
        this.a.u(2);
        ab.a r17 = this.a.j;
        if (r17 != null) goto L46;
    L48:
        if (r13 == false) goto L57;
        r12.setStatusBarColor(this.a.f);
        return;
    L57:
        return;
    L46:
        if (r17.y() == true) goto L48;
        r13 = true;
        goto L48
    L50:
        int r18 = r12.getStatusBarColor();
        int r19 = this.a.e;
        if (r18 == r19) goto L59;
        r12.setStatusBarColor(r19);
        return;
    L59:
        return;
    L27:
        r14 = r1;
        goto L28
    L16:
        View r20 = r0.n;
        if (r20 == null) goto L20;
        r20.setVisibility(8);
    L20:
        ia.f.a r21 = r0.b;
        if (r21 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("popupComponent");
        r21 = null;
    L23:
        r21.i();
        goto L24
    }

    @Override // com.bytedance.android.anniex.container.popup.SheetBaseBehavior.b
    public final void b(View r10, float r11) {
        Intrinsics.checkNotNullParameter(r10, "bottomSheet");
        d r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "bottomSheet");
        ab.b r12 = r1.k;
        if (r12 == null) goto L10;
        y36.i r13 = r12.g;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("showClosealways");
        r13 = null;
    L8:
        if (r13 == null) goto L10;
        boolean r14 = Intrinsics.areEqual(r13.b, Boolean.TRUE);
    L11:
        if (r14 == true) goto L17;
        View r15 = r1.o;
        if (r15 == null) goto L18;
        r15.setAlpha(r11);
        return;
    L18:
        return;
    L17:
        return;
    L10:
        r14 = false;
        goto L11
    }
}
