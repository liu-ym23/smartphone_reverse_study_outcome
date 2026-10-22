package com.ss.android.lark.integrator.im.extension;

import com.ss.android.lark.chat.export.entity.message.MessageType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import qxa.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ExtensionManager {
    public static final List<b> a = null;
    public static final List<b> b = null;
    public static final Lazy c = null;
    public static final AtomicBoolean d = null;

    static {
        a = new ArrayList();
        b = new ArrayList();
        c = LazyKt.lazy(ExtensionManager$imContext$2.INSTANCE);
        d = new AtomicBoolean(false);
    }

    public static ImContextImpl a() {
        return (ImContextImpl) c.getValue();
    }

    public static gya.a b(MessageType r1) {
        Intrinsics.checkNotNullParameter(r1, "messageType");
        if (r1 == MessageType.UNKNOWN) goto L7;
        Object r2 = ((ConcurrentHashMap) a().d).get(r1);
        if ((r2 instanceof gya.a) == false) goto L7;
        return (gya.a) r2;
    L7:
        return null;
    }
}
