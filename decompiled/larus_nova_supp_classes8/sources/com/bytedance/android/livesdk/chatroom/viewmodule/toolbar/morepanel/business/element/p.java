package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.element.ElementType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p extends SingleLineScrollElement {
    public final ElementType f;
    public final int g;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.core.recycle.b
    public final ElementType g() {
        return this.f;
    }

    public p(jp1.b r2) {
        Intrinsics.checkNotNullParameter(r2, "session");
        super(r2);
        this.f = ElementType.Toolbar;
        this.g = UtilityKotlinExtentionsKt.i(20);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.SingleLineScrollElement, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.morepanel.business.element.BaseElement
    public final void l(View r4) {
        Intrinsics.checkNotNullParameter(r4, "elementView");
        super.l(r4);
        View r5 = this.a;
        ViewGroup.MarginLayoutParams r0 = null;
        if (r5 == null) goto L5;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
    L7:
        if ((r6 instanceof ViewGroup.MarginLayoutParams) == true) goto L9;
        r6 = null;
    L9:
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
        if (r7 == null) goto L20;
        int r1 = r7.topMargin;
        int r2 = this.g;
        if (r1 == r2) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
        r0 = r7;
    L17:
        if (r0 == null) goto L21;
        r0.topMargin = r2;
        return;
    L21:
        return;
    L14:
        r3 = false;
        goto L15
    L20:
        return;
    L5:
        r6 = null;
        goto L7
    }
}
