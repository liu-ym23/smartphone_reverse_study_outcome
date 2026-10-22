package com.bytedance.android.live.liveinteract.hamlet;

import io.reactivex.functions.BiFunction;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n<T1, T2, R> implements BiFunction {
    public static final n a = null;

    static {
        a = new n();
    }

    public n() {
    }

    public final Object apply(Object r2, Object r3) {
        com.bytedance.android.livesdk.chatroom.viewmodel.i r4 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r2;
        com.bytedance.android.livesdk.chatroom.viewmodel.i r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r3;
        Intrinsics.checkNotNullParameter(r4, "beforeSwitchScene");
        Intrinsics.checkNotNullParameter(r5, "sceneEvent");
        return new Pair(r4, r5);
    }
}
