package com.ss.android.lark.im.sdk.service;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImSdkService {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;
    public static final Lazy f = null;

    static {
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.SYNCHRONIZED;
        a = LazyKt.lazy(r0, ImSdkService$chatService$2.INSTANCE);
        b = LazyKt.lazy(r0, ImSdkService$chatPush$2.INSTANCE);
        c = LazyKt.lazy(r0, ImSdkService$chatterService$2.INSTANCE);
        d = LazyKt.lazy(r0, ImSdkService$chatterPush$2.INSTANCE);
        e = LazyKt.lazy(r0, ImSdkService$messageService$2.INSTANCE);
        f = LazyKt.lazy(r0, ImSdkService$messagePush$2.INSTANCE);
    }

    public static m6b.s a() {
        return (m6b.s) b.getValue();
    }

    public static ImSdkChatService b() {
        return (ImSdkChatService) a.getValue();
    }

    public static m6b.t c() {
        return (m6b.t) d.getValue();
    }

    public static h d() {
        return (h) c.getValue();
    }

    public static m6b.u e() {
        return (m6b.u) f.getValue();
    }

    public static p f() {
        return (p) e.getValue();
    }
}
