package com.ss.android.lark.coremd.utils;

import com.ss.android.lark.chat.entity.message.Message;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessageStyleHelper {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(MessageStyleHelper$styleService$2.INSTANCE);
    }

    public static boolean a(Message r1) {
        Intrinsics.checkNotNullParameter(r1, "message");
        c r0 = (c) a.getValue();
        if (r0 == null) goto L6;
        return r0.applyStyleFromMe(r1);
    L6:
        return r1.isFromMe();
    }

    public static boolean b(y6b.a r1) {
        Intrinsics.checkNotNullParameter(r1, "vo");
        c r0 = (c) a.getValue();
        if (r0 == null) goto L6;
        return r0.applyStyleFromMe(r1);
    L6:
        return r1.h();
    }
}
