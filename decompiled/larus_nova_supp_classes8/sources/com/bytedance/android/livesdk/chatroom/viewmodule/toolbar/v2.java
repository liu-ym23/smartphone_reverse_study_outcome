package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v2<T> implements Predicate {
    public static final v2 a = null;

    static {
        a = new v2();
    }

    public v2() {
    }

    public final boolean test(Object r2) {
        ToolbarBubbleManager.BubbleInfo.State r3 = (ToolbarBubbleManager.BubbleInfo.State) r2;
        Intrinsics.checkNotNullParameter(r3, "it");
        return r3.isAtLeast(ToolbarBubbleManager.BubbleInfo.State.SHOWING);
    }
}
