package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n2<T> implements Consumer {
    public static final n2 a = null;

    static {
        a = new n2();
    }

    public n2() {
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        Intrinsics.checkNotNullParameter(r3, "throwable");
        ALogger.e("VSAnchorInfoWidget", r3.getMessage());
    }
}
