package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu;

import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.message.menu.v2.PanelType;
import com.ss.android.lark.chat.message.menu.v2.j0;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements j0 {
    public final /* synthetic */ a a;

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void a(PanelType r2) {
        Intrinsics.checkNotNullParameter(r2, "toType");
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void c(zya.b r2, List<zya.b> r3) {
        Intrinsics.checkNotNullParameter(r2, "parentAction");
        Intrinsics.checkNotNullParameter(r3, "childActions");
    }

    public b(a r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.message.menu.v2.j0
    public final void d(boolean r1, MessageActionType r2, boolean r3) {
        Function0<Unit> r4 = this.a.b;
        if (r4 == null) goto L6;
        r4.invoke();
        return;
    }
}
