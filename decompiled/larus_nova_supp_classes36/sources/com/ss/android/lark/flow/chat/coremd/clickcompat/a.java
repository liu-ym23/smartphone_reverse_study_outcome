package com.ss.android.lark.flow.chat.coremd.clickcompat;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.coremd.clickcompat.ChatMediaClickHandler;
import com.ss.android.lark.coremd.clickcompat.c;
import com.ss.android.lark.flow.chat.page.flow.plugin.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends c {
    public final FlowChatMediaClickHandler i;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.chat.coremd.clickcompat.a$a, reason: collision with other inner class name */
    public static final class C0019a {
    }

    static {
    }

    public final ChatMediaClickHandler a() {
        return this.i;
    }

    public a(m2b.a r2, g.b r3, c.a r4, v r5) {
        Intrinsics.checkNotNullParameter(r2, "chatContext");
        Intrinsics.checkNotNullParameter(r3, "messageProvider");
        Intrinsics.checkNotNullParameter(r5, "chatAppContainer");
        super(r2, r3, r4);
        this.i = new FlowChatMediaClickHandler(r2, r3, r5);
    }
}
