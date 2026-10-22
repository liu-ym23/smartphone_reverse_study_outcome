package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a extends SingleLineScrollElement {
    public final ElementType f;
    public final int g;
    public final int h;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final ElementType g() {
        return this.f;
    }

    public a(jp1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        super(r2);
        this.f = ElementType.Basic;
        this.g = UtilityKotlinExtentionsKt.i(40);
        this.h = UtilityKotlinExtentionsKt.i(16);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.SingleLineScrollElement, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final void l(View r6) {
        Intrinsics.checkNotNullParameter(r6, "elementView");
        super.l(r6);
        View r7 = this.a;
        ViewGroup.MarginLayoutParams r0 = null;
        if (r7 == null) goto L5;
        ViewGroup.LayoutParams r8 = r7.getLayoutParams();
    L7:
        if ((r8 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r8 = null;
    L9:
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
        if (r9 == null) goto L28;
        int r1 = r9.bottomMargin;
        int r2 = this.g;
        boolean r3 = false;
        if (r1 == r2) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
        ViewGroup.MarginLayoutParams r5 = r9;
    L18:
        if (r5 == null) goto L20;
        r5.bottomMargin = r2;
    L20:
        int r10 = r9.topMargin;
        int r11 = this.h;
        if (r10 == r11) goto L23;
        r3 = true;
    L23:
        if (r3 == false) goto L25;
        r0 = r9;
    L25:
        if (r0 == null) goto L29;
        r0.topMargin = r11;
        return;
    L29:
        return;
    L17:
        r5 = null;
        goto L18
    L14:
        r4 = false;
        goto L15
    L28:
        return;
    L5:
        r8 = null;
        goto L7
    }
}
