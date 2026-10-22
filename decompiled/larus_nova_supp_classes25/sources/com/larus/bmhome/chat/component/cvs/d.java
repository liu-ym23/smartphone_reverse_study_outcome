package com.larus.bmhome.chat.component.cvs;

import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class d implements Function1 {
    public final /* synthetic */ ChatConversationComponent a;

    public /* synthetic */ d(ChatConversationComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r9) {
        ChatConversationComponent r0 = this.a;
        String r10 = (String) r9;
        int r1 = ChatConversationComponent.r;
        Intrinsics.checkNotNullParameter(r10, "newCvsId");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new ChatConversationComponent$initConversation$2$1(r0, r10, null), 3, null);
        return Unit.INSTANCE;
    }
}
