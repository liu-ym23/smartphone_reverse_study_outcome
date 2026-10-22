package com.ss.android.lark.chat.message.menu.v2.popup;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larksuite.framework.utils.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h extends View {
    public h(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, false, 0.5f, 2131108932, 16);
    }

    public h(Context r3, boolean r4, float r5, int r6, float r7) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        if (r4 == false) goto L5;
        LinearLayout.LayoutParams r8 = new LinearLayout.LayoutParams(UIUtils.dp2px(r3, r5), UIUtils.dp2px(r3, 30.0f));
        r8.gravity = 16;
        ViewGroup.LayoutParams r9 = r8;
    L6:
        setLayoutParams(r9);
        setBackgroundColor(UIUtils.getColor(r3, r6));
        return;
    L5:
        ViewGroup.MarginLayoutParams r10 = new ViewGroup.MarginLayoutParams(-1, UIUtils.dp2px(r3, r5));
        r10.setMarginStart(UIUtils.dp2px(r3, r7));
        r10.setMarginEnd(UIUtils.dp2px(r3, r7));
        r9 = r10;
        goto L6
    }

    public /* synthetic */ h(Context r7, boolean r8, float r9, int r10, int r11) {
        if ((r11 & 4) == 0) goto L5;
        float r3 = 0.5f;
    L7:
        if ((r11 & 8) == 0) goto L9;
        int r4 = 2131108932;
    L11:
        if ((r11 & 16) == 0) goto L13;
        float r5 = 16.0f;
    L14:
        this(r7, r8, r3, r4, r5);
        return;
    L13:
        r5 = 0.0f;
        goto L14
    L9:
        r4 = r10;
        goto L11
    L5:
        r3 = r9;
        goto L7
    }
}
