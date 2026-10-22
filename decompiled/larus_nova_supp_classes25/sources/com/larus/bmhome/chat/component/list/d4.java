package com.larus.bmhome.chat.component.list;

import com.larus.im.bean.message.Message;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d4 implements Function1 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ d4(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        final ChatListComponent r0 = this.a;
        Message r4 = (Message) r3;
        int r1 = ChatListComponent.W3;
        Intrinsics.checkNotNullParameter(r4, "it");
        r0.getClass();
        CopyOnWriteArraySet r2 = xc8.f.a;
        return xc8.f.e(r4, new e0(r0));
    }
}
