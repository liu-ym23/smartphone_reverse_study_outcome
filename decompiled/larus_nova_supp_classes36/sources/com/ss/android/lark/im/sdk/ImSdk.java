package com.ss.android.lark.im.sdk;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ImSdk {
    public static final ImSdk a = null;
    public static Context b;
    public static volatile boolean c;
    public static final Lazy d = null;
    public static final Lazy e = null;

    public ImSdk() {
    }

    static {
        a = new ImSdk();
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.SYNCHRONIZED;
        d = LazyKt.lazy(r0, ImSdk$MESSAGE_CLIENT$2.INSTANCE);
        e = LazyKt.lazy(r0, ImSdk$CHAT_CLIENT$2.INSTANCE);
    }

    public final Context getContext() {
        Context r0 = b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    L6:
        return r0;
    }
}
