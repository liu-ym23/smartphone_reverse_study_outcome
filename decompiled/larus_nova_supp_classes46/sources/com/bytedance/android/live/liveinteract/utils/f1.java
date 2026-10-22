package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f1<T> implements Consumer {
    public static final f1 a = null;

    static {
        a = new f1();
    }

    public f1() {
    }

    public final void accept(Object r2) {
        ((Throwable) r2).printStackTrace();
        ALogger.e("[PaidQueue]", String.valueOf(Unit.INSTANCE));
    }
}
