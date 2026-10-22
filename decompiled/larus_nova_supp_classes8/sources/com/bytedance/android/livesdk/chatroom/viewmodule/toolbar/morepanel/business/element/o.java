package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o extends BaseElement<ip1.f> {
    public final ElementType c;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final void f() {
    }

    @Override // kp1.b
    public final void i() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final void l(View r2) {
        Intrinsics.checkNotNullParameter(r2, "elementView");
    }

    @Override // kp1.b
    public final void release() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final Integer k() {
        return 2131567779;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final ElementType g() {
        return this.c;
    }

    public o(jp1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        super(r2);
        this.c = ElementType.SimpleDivider;
    }

    @Override // kp1.b
    public final void h(lp1.b r2) {
        Intrinsics.checkNotNullParameter((ip1.f) r2, "model");
        if (com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.g.b() == false) goto L5;
        int r3 = 336992291;
    L6:
        View r0 = this.a;
        if (r0 == null) goto L10;
        r0.setBackgroundColor(r3);
        return;
    L10:
        return;
    L5:
        r3 = 352321535;
        goto L6
    }
}
