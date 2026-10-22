package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.view.View;
import com.ss.android.lark.widget.codeblock.preview.CodeBlockV2Info;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements mcc.e {
    public final c a;

    public final c getContext() {
        return this.a;
    }

    public d(c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final void n(View r2, CodeBlockV2Info r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "codeBlockV2Info");
        float r4 = zz7.b.h(this.a.getContext(), 14);
        CodeBlockV2ProcessParams.Companion.getClass();
        CodeBlockV2ProcessParams r5 = CodeBlockV2ProcessParams.b.a((int) r4);
        com.ss.android.lark.widget.richtext.codeblockv2.h.a(this.a.getContext(), r3.getLineContents(), r5);
    }
}
