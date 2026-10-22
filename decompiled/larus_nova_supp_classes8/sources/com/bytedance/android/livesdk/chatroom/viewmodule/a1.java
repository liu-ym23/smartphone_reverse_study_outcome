package com.bytedance.android.livesdk.chatroom.viewmodule;

import io.reactivex.functions.Predicate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a1<T> implements Predicate {
    public final /* synthetic */ f1 a;

    public a1(f1 r1) {
        this.a = r1;
    }

    public final boolean test(Object r2) {
        Intrinsics.checkNotNullParameter((Long) r2, "it");
        this.a.getClass();
        return this.a.a;
    }
}
