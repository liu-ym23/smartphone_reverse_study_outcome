package com.obric.aikernel.request;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.request.TimerLogger$Companion", f = "TimerLogger.kt", i = {0, 0, 0, 0}, l = {73}, m = CommonConsts.TIMER_TYPE, n = {"tag", NotificationCompat.CATEGORY_MESSAGE, "ret", "start$iv"}, s = {"L$0", "L$1", "L$2", "J$0"})
final class TimerLogger$Companion$timer$1<T> extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TimerLogger.Companion this$0;

    TimerLogger$Companion$timer$1(TimerLogger.Companion r10, Continuation<? super TimerLogger$Companion$timer$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, this);
    }
}
