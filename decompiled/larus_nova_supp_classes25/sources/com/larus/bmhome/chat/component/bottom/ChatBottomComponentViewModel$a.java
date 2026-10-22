package com.larus.bmhome.chat.component.bottom;

import com.larus.bmhome.chat.ChatFragment;
import com.larus.platform.api.b;
import com.larus.platform.api.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatBottomComponentViewModel$a implements b {
    public ChatBottomComponentViewModel$a() {
    }

    public final void a(c r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void b(c r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        ChatFragment.N = false;
        ChatBottomComponentViewModel.access$getCodeStartReqList$cp().clear();
    }
}
