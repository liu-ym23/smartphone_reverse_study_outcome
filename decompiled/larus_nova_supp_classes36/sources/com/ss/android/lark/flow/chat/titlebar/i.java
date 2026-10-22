package com.ss.android.lark.flow.chat.titlebar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i implements CoreNavigationBar.f {
    public final /* synthetic */ com.ss.android.lark.biz.im.api.extension.chat_window.j a;
    public final /* synthetic */ TitleTheme.ThemeType b;
    public final /* synthetic */ TitleBarActionKey c;

    public i(com.ss.android.lark.biz.im.api.extension.chat_window.j r1, TitleTheme.ThemeType r2, TitleBarActionKey r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar.f
    public final View createView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        ConstraintLayout r4 = this.a.a(this.b);
        ViewParent r0 = r4.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        ViewGroup r1 = (ViewGroup) r0;
    L6:
        if (r1 == null) goto L8;
        r1.removeView(r4);
    L8:
        r4.setTag(this.c);
        return r4;
    L5:
        r1 = null;
        goto L6
    }
}
