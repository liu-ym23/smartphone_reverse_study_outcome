package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.widget.columns.entity.ColumnsInfo;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements mcc.f {
    public final c a;

    public final c getContext() {
        return this.a;
    }

    public e(c r2, RichText r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "richText");
        this.a = r2;
    }

    public final void q(View r3, ColumnsInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "columnsInfo");
        w4b.g r5 = ChatCoreModule.a().getChatDependency();
        Context r0 = this.a.getContext();
        this.a.c.getId();
        this.a.d.getId();
        r5.b(r0, r4);
    }
}
