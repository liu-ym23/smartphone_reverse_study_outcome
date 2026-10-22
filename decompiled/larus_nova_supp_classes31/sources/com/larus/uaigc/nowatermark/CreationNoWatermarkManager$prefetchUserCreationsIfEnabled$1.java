package com.larus.uaigc.nowatermark;

import com.tencent.open.log.TraceLevel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.nowatermark.CreationNoWatermarkManager", f = "CreationNoWatermarkManager.kt", i = {0, 0, 0}, l = {298, 302}, m = "prefetchUserCreationsIfEnabled", n = {"scene", "keys", "accountContext"}, s = {"L$0", "L$1", "L$2"})
final class CreationNoWatermarkManager$prefetchUserCreationsIfEnabled$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationNoWatermarkManager this$0;

    public CreationNoWatermarkManager$prefetchUserCreationsIfEnabled$1(CreationNoWatermarkManager r1, Continuation<? super CreationNoWatermarkManager$prefetchUserCreationsIfEnabled$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        CreationNoWatermarkManager r1 = this.this$0;
        r1.getClass();
        int r12 = this.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r12 - Integer.MIN_VALUE;
        CreationNoWatermarkManager$prefetchUserCreationsIfEnabled$1 r6 = this;
    L6:
        Object r13 = r6.result;
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r6.label;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 != 2) goto L12;
        ResultKt.throwOnFailure(r13);
    L37:
        return Boxing.boxBoolean(true);
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        CreationNoWatermarkManager.a r3 = (CreationNoWatermarkManager.a) r6.L$2;
        CreationNoWatermarkManager$f r8 = (CreationNoWatermarkManager$f) r6.L$1;
        String r9 = (String) r6.L$0;
        ResultKt.throwOnFailure(r13);
        CreationNoWatermarkManager.a r14 = r3;
    L25:
        if (r1.B(r14) == false) goto L34;
        if (CreationNoWatermarkManager.C() == false) goto L34;
        Set<String> r4 = r8.a;
        Set<String> r5 = r8.b;
        r6.L$0 = null;
        r6.L$1 = null;
        r6.L$2 = null;
        r6.label = 2;
        if (r1.v(r4, r5, r9, r14, r6) != r0) goto L37;
        return r0;
    L34:
        return Boxing.boxBoolean(false);
    L14:
        ResultKt.throwOnFailure(r13);
        r8 = CreationNoWatermarkManager.k(null);
        if (r8.a() == true) goto L35;
        r14 = r1.l();
        if (CreationNoWatermarkManager.i0().a() == false) goto L36;
        r6.L$0 = null;
        r6.L$1 = r8;
        r6.L$2 = r14;
        r6.label = 1;
        if (r1.Q(r6) == r0) goto L38;
        r9 = null;
        goto L25
    L38:
        return r0;
    L36:
        return Boxing.boxBoolean(false);
    L35:
        return Boxing.boxBoolean(false);
    L5:
        r6 = new CreationNoWatermarkManager$prefetchUserCreationsIfEnabled$1(r1, this);
        goto L6
    }
}
