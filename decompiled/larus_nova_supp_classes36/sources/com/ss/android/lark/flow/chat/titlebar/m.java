package com.ss.android.lark.flow.chat.titlebar;

import android.view.View;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m implements LinkEmojiTextView.i {
    public m() {
    }

    public final boolean b(View r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        return false;
    }

    public final void a(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        int r1 = FlowChatModule.d;
        FlowChatModule.a.a().a().getBrowserDependency().openUrl(r2.getContext(), r3);
        return;
    L12:
        return;
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r0 = false;
        goto L9
    }
}
