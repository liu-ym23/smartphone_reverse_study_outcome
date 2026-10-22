package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a1 implements LinkEmojiTextView.i {
    public final /* synthetic */ UsernameBlock a;

    public final boolean b(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "text");
        return false;
    }

    public a1(UsernameBlock r1) {
        this.a = r1;
    }

    public final void a(View r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "text");
        ((x1b.c) this.a.i.getValue()).c();
        ((BrowserDependency) this.a.k.getValue()).a(this.a.getContext(), r4, this.a.c.isGroup() ? 1 : 0);
        ChatCoreModule.a().getAuditDependency().auditLinkEvent(this.a.c.getChatId(), r4);
    }
}
