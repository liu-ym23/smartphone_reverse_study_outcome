package com.bytedance.android.livesdk.chatroom.vs_base.util;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z<T> implements ObservableOnSubscribe {
    public final /* synthetic */ Function1 a;
    public final /* synthetic */ c b;

    public z(Function1 r1, c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        this.a.invoke(this.b);
    }
}
