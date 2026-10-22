package com.bytedance.android.live.revlink.impl.behavior;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends Handler {

    public static final class a {
    }

    static {
    }

    public f() {
        super(Looper.getMainLooper());
    }

    @Override // android.os.Handler
    public final void handleMessage(Message r3) {
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
        if (r3.what != 1) goto L11;
        Object r4 = r3.obj;
        if ((r4 instanceof Runnable) == true) goto L7;
        r4 = null;
    L7:
        Runnable r5 = (Runnable) r4;
        if (r5 == null) goto L12;
        r5.run();
        return;
    L12:
        return;
    }
}
