package com.larus.bmhome.chat.component.list;

import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class m3 implements Function1 {
    public /* synthetic */ m3() {
    }

    public final Object invoke(Object r3) {
        Message r4 = (Message) r3;
        int r0 = ChatListComponent.W3;
        Intrinsics.checkNotNullParameter(r4, "message");
        List r1 = CollectionsKt.listOf(r4);
        List r2 = r4.getSubList();
        if (r2 != null) goto L5;
        r2 = CollectionsKt.emptyList();
    L5:
        List r5 = CollectionsKt.plus(r1, CollectionsKt.filterNotNull(r2));
        List r6 = r4.getSubListGroup();
        if (r6 != null) goto L9;
        r6 = CollectionsKt.emptyList();
    L9:
        return CollectionsKt.asSequence(CollectionsKt.plus(r5, CollectionsKt.flatten(r6)));
    }
}
