package com.ss.android.lark.flow.chat.page.flow.plugin.tip;

import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j<T> implements r7b.b {
    public final /* synthetic */ FlowMessageTipsPlugin a;

    public j(FlowMessageTipsPlugin r1) {
        this.a = r1;
    }

    public final Object get() {
        Chat r0 = this.a.i;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mCurrentChat");
        return null;
    L6:
        return r0;
    }
}
