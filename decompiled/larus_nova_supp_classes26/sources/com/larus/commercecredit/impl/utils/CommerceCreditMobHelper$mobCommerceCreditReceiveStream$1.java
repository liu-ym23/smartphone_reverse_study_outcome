package com.larus.commercecredit.impl.utils;

import android.util.LruCache;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tx9.d3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercecredit.impl.utils.CommerceCreditMobHelper$mobCommerceCreditReceiveStream$1", f = "CommerceCreditMobHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CommerceCreditMobHelper$mobCommerceCreditReceiveStream$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    int label;

    public CommerceCreditMobHelper$mobCommerceCreditReceiveStream$1(Message r1, Continuation<? super CommerceCreditMobHelper$mobCommerceCreditReceiveStream$1> r2) {
        this.$message = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CommerceCreditMobHelper$mobCommerceCreditReceiveStream$1(this.$message, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r108) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r108);
        if (com.larus.im.bean.message.a.d0(this.$message) == false) goto L7;
    L8:
        String r1 = this.$message.getMessageId();
        if (r1 == null) goto L11;
        LruCache<String, Boolean> r15 = CommerceCreditMobHelper.a;
        if (Intrinsics.areEqual(r15.get(r1), Boxing.boxBoolean(true)) == false) goto L16;
        FLogger.a.d("CommerceCreditMobHelper", "checkIfNeedHandleCommerceCreditBlock msgId=" + r1 + " already reported, skipping");
        return Unit.INSTANCE;
    L16:
        d3.b(null, null, null, null, null, null, null, null, null, null, null, null, null, r1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, com.larus.im.bean.message.a.t(this.$message), null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -262145, -1, -16777217, 1023);
        r15.put(r1, Boxing.boxBoolean(true));
    L18:
        return Unit.INSTANCE;
    L11:
        return Unit.INSTANCE;
    L7:
        if (com.larus.im.bean.message.a.X(this.$message) == false) goto L18;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
