package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(View r3, int r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0 != null) goto L8;
        return;
    L8:
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L22;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1.leftMargin == (-3)) goto L12;
    L18:
        if (r4 == (-3)) goto L20;
        r1.topMargin = r4;
    L20:
        r3.setLayoutParams(r1);
        return;
    L12:
        if (r1.topMargin != r4) goto L18;
        if (r1.rightMargin != (-3)) goto L18;
        if (r1.bottomMargin != (-3)) goto L18;
        return;
    }
}
