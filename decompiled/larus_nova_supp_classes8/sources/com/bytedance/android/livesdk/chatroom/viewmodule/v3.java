package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class v3<T> implements Consumer {
    public static final v3 a = null;

    static {
        a = new v3();
    }

    public v3() {
    }

    public final void accept(Object r1) {
        Logger.e(((Throwable) r1).getMessage());
    }
}
