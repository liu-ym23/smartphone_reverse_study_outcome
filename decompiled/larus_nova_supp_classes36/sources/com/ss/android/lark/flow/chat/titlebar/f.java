package com.ss.android.lark.flow.chat.titlebar;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.titlebar.viewmodel.TitlebarViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.flow.chat.titlebar.view.CoreNavigationBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f<T> implements Observer {
    public final /* synthetic */ FlowTitleBarComponent a;

    public f(FlowTitleBarComponent r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Chatter r7 = (Chatter) r6;
        this.a.updateTitle();
        Chat r8 = (Chat) this.a.C0().getValue();
        if (r8 == null) goto L16;
        FlowTitleBarComponent r0 = this.a;
        ugb.e r1 = r0.n;
        if (r1 == null) goto L15;
        CoreNavigationBar r2 = r0.m;
        ChatChatter r3 = null;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("coreNavigationBar");
        r2 = null;
    L10:
        Context r4 = r2.getContext();
        TitlebarViewModel r5 = this.a.s;
        if (r5 == null) goto L13;
        r3 = FlowTitleBarComponent.G0(r5, r8);
    L13:
        r1.a(r4, new sxa.a(r8, r3));
        return;
    L15:
        return;
    }
}
