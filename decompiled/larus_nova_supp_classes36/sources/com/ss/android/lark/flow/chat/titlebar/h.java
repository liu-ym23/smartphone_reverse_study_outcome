package com.ss.android.lark.flow.chat.titlebar;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class h implements com.ss.android.lark.biz.im.api.extension.chat_window.k {
    public final /* synthetic */ FlowTitleBarComponent a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Function1<View, Unit> c;

    public final void d() {
    }

    public final void onHide() {
    }

    public final void onShow() {
    }

    public final TitleBarActionKey getKey() {
        return TitleBarActionKey.BACK;
    }

    public final void f(View r2) {
        Intrinsics.checkNotNullParameter(r2, "actionView");
        Intrinsics.checkNotNullParameter(r2, "actionView");
    }

    public final Drawable g(TitleTheme.ThemeType r2) {
        Intrinsics.checkNotNullParameter(r2, "theme");
        CoreNavigationBar r3 = this.a.m;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r3 = null;
    L6:
        return UDIconUtils.getIconDrawable(r3.getContext(), this.b);
    }

    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.c.invoke(r2);
    }

    public h(FlowTitleBarComponent r1, Function1 r2) {
        this.a = r1;
        this.b = 2131254123;
        this.c = r2;
    }
}
