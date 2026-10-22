package com.larus.bmhome.chat.component.title;

import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l1 implements com.larus.bmhome.chat.component.cvs.y.a<e> {
    public final /* synthetic */ ChatTitleComponent a;

    public l1(ChatTitleComponent r1) {
        this.a = r1;
    }

    public final void c(Object r9) {
        e r10 = (e) r9;
        Intrinsics.checkNotNullParameter(r10, "new");
        ChatTitleComponent r0 = this.a;
        int r1 = ChatTitleComponent.P1;
        r0.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), Dispatchers.getIO(), null, new ChatTitleComponent$checkMarkConversationRead$1(r10, r0, null), 2, null);
    }
}
