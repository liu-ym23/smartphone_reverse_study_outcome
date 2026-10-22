package com.bytedance.android.livesdk.chatroom.widget.landscape;

import io.reactivex.functions.Function;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t<T, R> implements Function {
    public static final t a = null;

    static {
        a = new t();
    }

    public t() {
    }

    public final Object apply(Object r2) {
        Intrinsics.checkNotNullParameter((Long) r2, "it");
        return Unit.INSTANCE;
    }
}
