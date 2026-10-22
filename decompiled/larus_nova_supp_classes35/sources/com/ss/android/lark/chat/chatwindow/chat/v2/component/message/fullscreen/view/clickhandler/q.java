package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.content.Context;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.widget.light.LKUILightTextView;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.table.entity.TableInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q implements mcc.n {
    public final c a;

    public final c getContext() {
        return this.a;
    }

    public q(c r2, RichText r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "richText");
        this.a = r2;
    }

    public final void g(LKUILightTextView r3, TableInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "tableInfo");
        w4b.g r5 = ChatCoreModule.a().getChatDependency();
        Context r0 = this.a.getContext();
        this.a.d.getId();
        r5.y(r0, r4);
    }
}
