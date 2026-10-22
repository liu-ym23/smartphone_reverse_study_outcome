package com.larus.bmhome.chat.component.list;

import android.view.View;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.actionbar.api.ChatUIBlockConfig;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n6 implements ss8.g.b {
    public final /* synthetic */ ChatListComponent a;
    public final /* synthetic */ ChatMessageList b;

    public final void b() {
    }

    public n6(ChatListComponent r1, ChatMessageList r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(ChatUIBlockConfig r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "config");
        if (r5 == ChatUIBlockConfig.DISABLE_MSG_LONG_PRESS) goto L5;
        return;
    L5:
        FLogger.a.i(this.a.n, "[ClickInterceptor] DISABLE_MSG_LONG_PRESS changed: blocked=" + r6 + ", rv.childCount=" + this.b.getChildCount());
        int r7 = this.b.getChildCount();
        int r0 = 0;
    L6:
        if (r0 >= r7) goto L12;
        View r1 = this.b.getChildAt(r0);
        if (r6 == false) goto L10;
        ChatListComponent r3 = this.a;
        Intrinsics.checkNotNull(r1);
        ChatListComponent.E3(r3, 2131365588, r1);
    L11:
        r0 = r0 + 1;
        goto L6
    L10:
        ChatListComponent r4 = this.a;
        Intrinsics.checkNotNull(r1);
        ChatListComponent.G3(2131365588, r4, r1);
        goto L11
    }
}
