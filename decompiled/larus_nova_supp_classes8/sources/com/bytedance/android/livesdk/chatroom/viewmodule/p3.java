package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p3<T> implements Consumer {
    public static final p3 a = null;

    static {
        a = new p3();
    }

    public p3() {
    }

    public final void accept(Object r1) {
        Logger.e(((Throwable) r1).getMessage());
    }
}
