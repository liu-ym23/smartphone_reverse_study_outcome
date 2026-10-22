package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.base.exception.ApiServerException;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class q3 implements Consumer<Throwable> {
    public static final q3 a = null;

    public static final class a {
    }

    public q3() {
    }

    static {
        a = new q3();
    }

    public void a(Throwable r3) throws Exception {
        if ((r3 instanceof ApiServerException) == false) goto L5;
        com.bytedance.android.live.core.utils.f2.c(((ApiServerException) r3).getPrompt(), 0);
        return;
    L5:
        com.bytedance.android.live.core.utils.f2.b(2131920661, 0);
    }

    public /* bridge */ /* synthetic */ void accept(Object r1) {
        a((Throwable) r1);
    }
}
