package com.bytedance.android.livesdk.chatroom.viewmodule;

import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d1<T> implements Consumer {
    public final /* synthetic */ f1 a;

    public d1(f1 r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Function1<Long, Unit> r0 = this.a.c;
        long r1 = ((Long) r7).longValue();
        f1 r8 = this.a;
        r0.invoke(Long.valueOf(r1 * r8.e.toSeconds(r8.d)));
    }
}
