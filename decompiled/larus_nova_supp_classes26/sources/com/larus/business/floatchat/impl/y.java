package com.larus.business.floatchat.impl;

import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class y {
    public static final CopyOnWriteArrayList<WeakReference<ew8.b>> a = null;

    static {
        a = new CopyOnWriteArrayList();
    }

    public static void a(final ew8.b r2) {
        Intrinsics.checkNotNullParameter(r2, "messageLogicAbility");
        CollectionsKt.removeAll(a, new x(r2));
        FLogger.a.i("AIFloatChatWindowEventDispatcher", "unregister messageLogicAbility=".concat(r2.getClass().getSimpleName()));
    }
}
