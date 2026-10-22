package com.ss.android.lark.flow.threadwindow.plugin;

import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g<T> implements r7b.b {
    public final /* synthetic */ FlowThreadWindowMsgTipsPlugin a;

    public g(FlowThreadWindowMsgTipsPlugin r1) {
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
