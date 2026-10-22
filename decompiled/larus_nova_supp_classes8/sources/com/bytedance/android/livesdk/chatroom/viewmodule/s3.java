package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s3<T> implements Consumer {
    public static final s3 a = null;

    static {
        a = new s3();
    }

    public s3() {
    }

    public final void accept(Object r1) {
        Logger.e(((Throwable) r1).getMessage());
    }
}
