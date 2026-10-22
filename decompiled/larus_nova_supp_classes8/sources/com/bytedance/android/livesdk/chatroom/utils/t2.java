package com.bytedance.android.livesdk.chatroom.utils;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t2<T> implements Consumer {
    public final /* synthetic */ a4 a;

    public t2(SkinLoader$loopLoadImg$2 r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        a4 r5 = this.a;
        if (r5 == null) goto L6;
        r5.b(SkinLoadResultType.ERROR, "remote error");
        return;
    }
}
