package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.os.Bundle;
import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.i0;
import com.ss.android.lark.widget.span.UrlInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class r implements mcc.o {
    public final c a;

    public final boolean t(View r2, UrlInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "urlInfo");
        return false;
    }

    public final c getContext() {
        return this.a;
    }

    public r(c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final void r(View r4, UrlInfo r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "urlInfo");
        Bundle r6 = i0.a(r5.urlPreviewId, this.a.d);
        boolean r0 = this.a.c.isGroup();
        ChatCoreModule.a().getBrowserDependency().b(this.a.getContext(), r5.href, r0 ? 1 : 0, r6);
    }
}
