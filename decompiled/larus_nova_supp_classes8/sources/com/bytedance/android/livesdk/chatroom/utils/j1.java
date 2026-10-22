package com.bytedance.android.livesdk.chatroom.utils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.setting.CoreSettingKeys;
import com.bytedance.android.live.strategy.api.IStrategyService;
import com.bytedance.android.livesdk.config.op;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j1 {
    public static final int a = 0;
    public static final int b = 0;
    public static int c;

    public static final class a<T> implements Observer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void onChanged(Object r2) {
            int r0 = j1.a;
            j1.c = ((Integer) r2).intValue();
        }
    }

    static {
        a = ((Integer) op.a.getValue()).intValue();
        int r0 = ((com.bytedance.android.live.base.model.feed.a) CoreSettingKeys.LIVE_FEED_PRELOAD.getValue()).a();
        b = r0;
        c = 2;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        IStrategyService r2 = jc1.k.f(IStrategyService.class);     // Catch: Throwable -> L16
        Unit r3 = null;
        if (r2 == null) goto L6;
        LiveData r4 = IStrategyService.a.a(r2, "live_preload_more_count", Integer.valueOf(r0), true, 8);     // Catch: Throwable -> L16
    L7:
        if (r4 == null) goto L11;
        Integer r5 = (Integer) r4.getValue();     // Catch: Throwable -> L16
        if (r5 == null) goto L11;
        r0 = r5.intValue();     // Catch: Throwable -> L16
    L11:
        c = r0;     // Catch: Throwable -> L16
        if (r4 == null) goto L14;
        r4.observeForever(a.a);     // Catch: Throwable -> L16
        r3 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        Object r6 = Result.constructor-impl(r3);     // Catch: Throwable -> L16
    L19:
        if (Result.exceptionOrNull-impl(r6) == null) goto L24;
        c = b;
        return;
    L24:
        return;
    L6:
        r4 = null;
    L16:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }
}
