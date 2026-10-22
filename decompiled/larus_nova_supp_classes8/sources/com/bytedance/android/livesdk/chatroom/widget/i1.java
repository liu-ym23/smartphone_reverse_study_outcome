package com.bytedance.android.livesdk.chatroom.widget;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i1<T, R> implements Function {
    public static final i1 a = null;

    static {
        a = new i1();
    }

    public i1() {
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((Long) r2, "it");
        return Unit.INSTANCE;
    }
}
