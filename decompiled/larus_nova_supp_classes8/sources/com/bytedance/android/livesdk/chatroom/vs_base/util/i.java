package com.bytedance.android.livesdk.chatroom.vs_base.util;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ Function0 a;

    public i(Function0 r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        sh6.b r2 = (sh6.b) r1;
        this.a.invoke();
    }
}
