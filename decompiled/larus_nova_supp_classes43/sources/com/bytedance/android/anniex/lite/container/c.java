package com.bytedance.android.anniex.lite.container;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.anniex.container.popup.AnnieXLynxViewNestedScrollUtil;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements com.bytedance.android.anniex.container.popup.d {
    public final /* synthetic */ AnnieXFlowPopupContainer a;

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean f(MotionEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        return false;
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean a() {
        AnnieXFlowPopupContainer r0 = this.a;
        if (r0.v != null) goto L13;
        na.a r1 = r0.getEngine();
        if (r1 == null) goto L13;
        View r10 = r1.d();
        if (r10 == null) goto L13;
        if (r0.getKitType() == KitType.WEB) goto L12;
        int r11 = AnnieXLynxViewNestedScrollUtil.a;
        r10 = AnnieXLynxViewNestedScrollUtil.a(r10, AnnieXFlowPopupContainer$isKitViewScrollReachTop$1$1.INSTANCE);
    L12:
        r0.v = r10;
    L13:
        View r12 = r0.v;
        if (r12 != null) goto L16;
    L18:
        boolean r13 = false;
    L20:
        return !r13;
    L16:
        if (r12.canScrollVertically(-1) != true) goto L18;
        r13 = true;
        goto L20
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean b() {
        ab.a r0 = this.a.r();
        if (r0 == null) goto L7;
        y36.a r1 = r0.d;
        if (r1 == null) goto L7;
        return Intrinsics.areEqual(((y36.i) r1).b, Boolean.TRUE);
    L7:
        return false;
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean c() {
        return this.a.i;
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean d() {
        return this.a.j;
    }

    @Override // com.bytedance.android.anniex.container.popup.d
    public final boolean e() {
        this.a.getClass();
        ab.a r0 = this.a.r();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
    L12:
        return false;
    L10:
        if (this.a.h == false) goto L12;
        return true;
    L5:
        if (r0.w() != true) goto L7;
        r1 = true;
        goto L8
    }

    public c(AnnieXFlowPopupContainer r1) {
        this.a = r1;
    }
}
