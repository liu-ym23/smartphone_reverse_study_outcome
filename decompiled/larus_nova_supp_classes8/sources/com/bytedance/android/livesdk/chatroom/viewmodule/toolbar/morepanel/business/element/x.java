package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class x implements kp1.b<ip1.g> {
    public final ElementType a;

    @Override // kp1.b
    public final View c(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return null;
    }

    @Override // kp1.b
    public final View e() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final void f() {
    }

    @Override // kp1.b
    public final void i() {
    }

    @Override // kp1.b
    public final void release() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final ElementType g() {
        return this.a;
    }

    public x(jp1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        this.a = ElementType.Unknown;
    }

    @Override // kp1.b
    public final void h(lp1.b r2) {
        Intrinsics.checkNotNullParameter((ip1.g) r2, "model");
    }
}
