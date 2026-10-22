package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z5 implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {
    public final /* synthetic */ ChatListComponent a;

    public z5(ChatListComponent r1) {
        this.a = r1;
    }

    public final void c(Object r3) {
        Intrinsics.checkNotNullParameter((wc9.e) r3, "new");
        MessageAdapter r4 = this.a.O;
        if (r4 == null) goto L6;
        r4.S3(":fake_message:8", 0);
        return;
    }
}
