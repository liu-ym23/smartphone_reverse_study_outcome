package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends BaseElement<ip1.b> {
    public final ElementType c;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final void f() {
    }

    @Override // kp1.b
    public final void i() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final Integer k() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final void l(View r2) {
        Intrinsics.checkNotNullParameter(r2, "elementView");
    }

    @Override // kp1.b
    public final void release() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final ElementType g() {
        return this.c;
    }

    public b(jp1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        super(r2);
        this.c = ElementType.BottomSpace;
    }

    @Override // kp1.b
    public final void h(lp1.b r2) {
        Intrinsics.checkNotNullParameter((ip1.b) r2, "model");
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final View j(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        View r0 = new View(r4.getContext());
        r0.setLayoutParams(new ViewGroup.LayoutParams(-1, UtilityKotlinExtentionsKt.i(40)));
        return r0;
    }
}
