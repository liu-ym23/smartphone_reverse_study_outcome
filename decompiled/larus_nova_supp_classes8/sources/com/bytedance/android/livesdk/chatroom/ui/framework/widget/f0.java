package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import com.bytedance.common.utility.Logger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f0<T> implements Consumer {
    public static final f0 a = null;

    static {
        a = new f0();
    }

    public f0() {
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        Intrinsics.checkNotNullParameter(r3, "throwable");
        Logger.e(r3.getMessage());
    }
}
