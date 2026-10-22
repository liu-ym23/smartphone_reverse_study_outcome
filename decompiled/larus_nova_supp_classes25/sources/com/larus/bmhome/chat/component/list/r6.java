package com.larus.bmhome.chat.component.list;

import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import vr8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class r6 implements a {
    public final /* synthetic */ ChatListComponent a;

    public r6(ChatListComponent r1) {
        this.a = r1;
    }

    public final void a(com.larus.bmhome.social.page.datasource.event.e.a r3, vr8.g r4) {
        Intrinsics.checkNotNullParameter(r3, "operation");
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (s1a.a.c(this.a).isAdded() == true) goto L5;
    L18:
        FLogger.a.w(this.a.n, "View is already destroyed. Skipping prepend/append load.");
        return;
    L5:
        if (s1a.a.c(this.a).isRemoving() == true) goto L18;
        if (s1a.a.c(this.a).isDetached() == true) goto L18;
        if ((r3 instanceof com.larus.bmhome.social.page.datasource.event.e.a.a) == false) goto L13;
        FLogger.a.d("MessageAdapterAutoLoad#Append", "message list auto load more");
        ChatListComponent r5 = this.a;
        int r0 = ChatListComponent.W3;
        ChatListComponentViewModel.appendLoadMessageList$default(r5.U5(), r4, null, 2, null);
        return;
    L13:
        if ((r3 instanceof com.larus.bmhome.social.page.datasource.event.e.a.b) == false) goto L17;
        FLogger.a.d("MessageAdapterAutoLoad#Prepend", "message list auto load more");
        ChatListComponent r6 = this.a;
        int r1 = ChatListComponent.W3;
        r6.U5().prependLoadMessageList(r4);
        return;
    L17:
        throw new NoWhenBranchMatchedException();
    }
}
