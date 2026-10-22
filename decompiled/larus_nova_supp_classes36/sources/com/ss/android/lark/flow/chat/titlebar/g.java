package com.ss.android.lark.flow.chat.titlebar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.biz.im.api.extension.chat_window.TitleBarActionKey;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.theme.TitleTheme;
import com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g implements com.ss.android.lark.biz.im.api.extension.chat_window.k {
    public final /* synthetic */ FlowTitleBarComponent a;

    public final void d() {
    }

    public final void onHide() {
    }

    public final void onShow() {
    }

    public final TitleBarActionKey getKey() {
        return TitleBarActionKey.SETTING;
    }

    public g(FlowTitleBarComponent r1) {
        this.a = r1;
    }

    public final void f(View r2) {
        Intrinsics.checkNotNullParameter(r2, "actionView");
        Intrinsics.checkNotNullParameter(r2, "actionView");
    }

    public final Drawable g(TitleTheme.ThemeType r4) {
        Intrinsics.checkNotNullParameter(r4, "theme");
        CoreNavigationBar r5 = this.a.m;
        CoreNavigationBar r0 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r5 = null;
    L5:
        Context r6 = r5.getContext();
        CoreNavigationBar r2 = this.a.m;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
    L10:
        return UDIconUtils.getIconDrawable(r6, 2131235460, UIUtils.getColor(r0.getContext(), 2131102040));
    L8:
        r0 = r2;
        goto L10
    }

    public final void onClick(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        FlowTitleBarComponent r5 = this.a;
        int r0 = FlowTitleBarComponent.J;
        Chat r6 = (Chat) r5.C0().getValue();
        if (r6 == null) goto L16;
        ChatService.c.a.getClass();
        int r1 = com.ss.android.lark.im.sdk.utils.f.a;
        boolean r2 = false;
        if (r6.getType() != Chat.Type.P2P) goto L14;
        String r3 = r6.getP2pChatterId();
        if (r3.length() != 0) goto L10;
        boolean r7 = true;
    L11:
        if (r7 == true) goto L14;
        r2 = Intrinsics.areEqual(r3, ImSdkProxy.e().getCurrentUserId());
        goto L14
    L10:
        r7 = false;
    L14:
        this.a.I0(r6.getId(), r2);
        ChatHitPointNew.f(r6, "setting", ChatHitPointNew.c("setting"), null);
        return;
    }
}
