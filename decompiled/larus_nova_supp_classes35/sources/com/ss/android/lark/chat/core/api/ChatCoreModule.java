package com.ss.android.lark.chat.core.api;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatCoreModule {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    static {
        a = LazyKt.lazy(ChatCoreModule$chatNameRenderer$2.INSTANCE);
        b = LazyKt.lazy(ChatCoreModule$chatParser$2.INSTANCE);
        c = LazyKt.lazy(ChatCoreModule$chatCoreDependency$2.INSTANCE);
    }

    @JvmStatic
    public static final w4b.c a() {
        return (w4b.c) c.getValue();
    }
}
