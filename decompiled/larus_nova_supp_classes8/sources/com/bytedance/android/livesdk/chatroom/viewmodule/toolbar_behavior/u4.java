package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u4<T> implements Consumer {
    public final /* synthetic */ Function2 a;

    public u4(Function2 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        com.bytedance.android.live.network.response.a r4 = (com.bytedance.android.live.network.response.a) r3;
        this.a.invoke(Boolean.TRUE, null);
    }
}
