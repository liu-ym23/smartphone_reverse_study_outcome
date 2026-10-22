package com.bytedance.android.live.revlink.impl;

import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.h;
import com.bytedance.android.live.revlink.impl.multianchor.dynamic.i;
import com.bytedance.android.live.revlink.scopeui.LynxBizType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class LynxCentralManager implements x51.a {
    public final Lazy a;
    public final FrameLayout b;
    public final vy0.c c;

    @Override // x51.a
    public final void removeAll() {
        this.b.removeAllViews();
    }

    public LynxCentralManager(FrameLayout r2, vy0.c r3) {
        Intrinsics.checkNotNullParameter(r2, "containerView");
        Intrinsics.checkNotNullParameter(r3, "hybridService");
        this.b = r2;
        this.c = r3;
        this.a = LazyKt.lazy(LynxCentralManager$isAnnieXOpt$2.INSTANCE);
    }

    @Override // x51.a
    public final void a(zy0.b r1, boolean r2) {
        if (r1 == null) goto L8;
        View r3 = r1.c();
        if (r3 == null) goto L9;
        ViewUtilsKt.g(r3, r2);
        return;
    L9:
        return;
    }

    @Override // x51.a
    public final void d(String r2, zy0.b r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        if (r3 == null) goto L11;
        View r4 = r3.c();
        if (r4 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r4.getParent(), this.b) == false) goto L12;
        this.b.removeView(r4);
        return;
    L12:
        return;
    }

    @Override // x51.a
    public final void b(i r3, zy0.b r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "lynxLayout");
        Intrinsics.checkNotNullParameter(r5, "tag");
        if (r4 == null) goto L13;
        View r6 = r4.c();
        if (r6 == null) goto L14;
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(r3.a, r3.b);
        r7.leftMargin = r3.c;
        r7.topMargin = r3.d;
        if (this.b.indexOfChild(r6) != (-1)) goto L10;
        this.b.addView(r6, r7);
    L11:
        r6.setTranslationZ(r3.e);
        return;
    L10:
        r6.setLayoutParams(r7);
        goto L11
    L14:
        return;
    }

    @Override // x51.a
    public final zy0.b c(LynxBizType r6, h r7, Uri r8, Function1<? super yy0.c, Unit> r9) {
        Intrinsics.checkNotNullParameter(r6, "bizType");
        Intrinsics.checkNotNullParameter(r7, "loadSource");
        int r10 = c.a[r6.ordinal()];
        boolean r0 = true;
        if (r10 != 1) goto L5;
        h.b r12 = h.b.b;
        if (Intrinsics.areEqual(r7, r12) == false) goto L19;
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r1 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r1.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.a.o.getValue(r1, com.bytedance.android.live.revlink.impl.settings.dynamic.a.a[13])).booleanValue() == false) goto L19;
    L24:
        if (r0 == false) goto L26;
        Function3 r13 = new LynxCentralManager$createCardOrNull$createCard$1(this.c);
    L28:
        return (zy0.b) r13.invoke(this.b.getContext(), r8, new LynxCentralManager$createCardOrNull$1(this, r8, r9));
    L26:
        r13 = new LynxCentralManager$createCardOrNull$createCard$2(this.c);
    L19:
        if ((!Intrinsics.areEqual(r7, r12)) == true) goto L21;
    L23:
        r0 = false;
        goto L24
    L21:
        if (((Boolean) this.a.getValue()).booleanValue() == false) goto L23;
    L5:
        if (r10 != 2) goto L7;
        com.bytedance.android.live.revlink.impl.settings.dynamic.a r14 = com.bytedance.android.live.revlink.impl.settings.dynamic.a.H;
        r14.getClass();
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.dynamic.a.q.getValue(r14, com.bytedance.android.live.revlink.impl.settings.dynamic.a.a[15])).booleanValue() == false) goto L23;
    L7:
        if (r10 == 3) goto L23;
        throw new NoWhenBranchMatchedException();
    }
}
