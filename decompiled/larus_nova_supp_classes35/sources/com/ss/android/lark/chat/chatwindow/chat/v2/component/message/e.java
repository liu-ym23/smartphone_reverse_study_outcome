package com.ss.android.lark.chat.chatwindow.chat.v2.component.message;

import com.ss.android.lark.biz.im.api.extension.chat_window.hint.IFooterHintComponent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e {
    public final /* synthetic */ d.a a;

    public e(d.a r1) {
        this.a = r1;
    }

    public final void a(txa.a r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        IFooterHintComponent r3 = this.a.a(IFooterHintComponent.class);
        if (r3 == null) goto L6;
        r3.MK();
        return;
    }
}
