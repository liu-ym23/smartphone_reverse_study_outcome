package com.bytedance.android.live.recharge.platform.service;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.badger.collect.impl.constants.Constants;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ k a;

    public l(k r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        cq2.d r10 = (cq2.d) r9;
        k r0 = this.a;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L38
        Object r2 = null;
        if (r10 == null) goto L8;
        Map r12 = r10.getParams();     // Catch: Throwable -> L38
        if (r12 == null) goto L8;
        Object r13 = r12.get(Constants.Keys.DATA);     // Catch: Throwable -> L38
    L10:
        if ((r13 instanceof Map) == true) goto L12;
        r13 = null;
    L12:
        Map r14 = (Map) r13;     // Catch: Throwable -> L38
        if (r14 == null) goto L46;
        Object r3 = r14.get("currentBox");     // Catch: Throwable -> L38
        if ((r3 instanceof Map) == true) goto L18;
        r3 = null;
    L18:
        Map r4 = (Map) r3;     // Catch: Throwable -> L38
        Object r15 = r14.get("currentIndex");     // Catch: Throwable -> L38
        if ((r15 instanceof Integer) == true) goto L21;
        r15 = null;
    L21:
        Integer r16 = (Integer) r15;     // Catch: Throwable -> L38
        if (r16 == null) goto L36;
        r16.intValue();     // Catch: Throwable -> L38
        if (r0.c >= r16.intValue()) goto L35;
        if (r4 == null) goto L27;
        Object r5 = r4.get("count_down");     // Catch: Throwable -> L38
    L29:
        if ((r5 instanceof Integer) == false) goto L32;
        r2 = r5;
    L32:
        Integer r6 = (Integer) r2;     // Catch: Throwable -> L38
        if (r6 == null) goto L35;
        r6.intValue();     // Catch: Throwable -> L38
        r0.c = r16.intValue();     // Catch: Throwable -> L38
        UtilityKotlinExtentionsKt.s(0, false, false, new ExchangeCountDownService$updateCountDown$1(r0, r6.intValue(), r6.intValue()), 7);     // Catch: Throwable -> L38
        goto L35
    L27:
        r5 = null;
    L35:
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L38
    L36:
        Object r17 = Result.constructor-impl(r2);     // Catch: Throwable -> L38
    L41:
        if (Result.isFailure-impl(r17) == false) goto L47;
        ALogger.d("ExchangeCountDownService", "setTreasureBoxListener: 监听宝箱打开事件，更新缓存失败");
        return;
    L47:
        return;
    L46:
        return;
    L8:
        r13 = null;
    L38:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L41
    }
}
