package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import lp1.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class BaseElement<ElementModel extends lp1.b<Object>> implements kp1.b<ElementModel> {
    public View a;
    public final Function2<View, ViewGroup, Unit> b;

    public View j(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return null;
    }

    public abstract Integer k();

    public abstract void l(View r1);

    @Override // kp1.b
    public final View e() {
        return this.a;
    }

    public BaseElement(jp1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        this.b = new BaseElement$doOnAttachToParent$1(this);
    }

    @Override // kp1.b
    public final View c(ViewGroup r7) {
        Intrinsics.checkNotNullParameter(r7, "parent");
        View r1 = this.a;
        if (r1 == null) goto L5;
        this.b.invoke(r1, r7);
    L19:
        if (r1 != null) goto L24;
        View r0 = j(r7);
        if (r0 == null) goto L25;
        this.b.invoke(r0, r7);
        return r0;
    L25:
        return null;
    L24:
        return r1;
    L5:
        Integer r2 = k();
        if (r2 == null) goto L18;
        int r3 = r2.intValue();
        Function2<View, ViewGroup, Unit> r4 = this.b;
        Intrinsics.checkNotNullParameter(r7, "parent");
        Integer r5 = Integer.valueOf(r3);
        if (r5.intValue() <= 0) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L18;
        r5.intValue();
        r1 = LayoutInflater.from(r7.getContext()).inflate(r3, r7, false);
        if (r4 == null) goto L19;
        Unit r8 = (Unit) r4.invoke(r1, r7);
        goto L19
    L10:
        r6 = false;
    L18:
        r1 = null;
        goto L19
    }
}
