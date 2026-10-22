package com.obric.miniapp.impl;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageListRequest;
import com.obric.capabilitykit.common.ErrorCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AppletExtServiceImpl$isLatestRoundReply$2 extends FunctionReferenceImpl implements Function4<String, Long, Integer, Continuation<? super List<? extends Message>>, Object>, SuspendFunction {
    public AppletExtServiceImpl$isLatestRoundReply$2(Object r8) {
        super(4, r8, AppletExtServiceImpl.class, "loadLocalMessagePage", "loadLocalMessagePage(Ljava/lang/String;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(String r16, long r17, int r19, Continuation<? super List<Message>> r20) {
        AppletExtServiceImpl r1 = (AppletExtServiceImpl) ((CallableReference) this).receiver;
        int r2 = AppletExtServiceImpl.l;
        r1.getClass();
        kotlinx.coroutines.j r3 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r20), 1);
        r3.C();
        com.larus.im.d.e().getMessageListFromLocal(new MessageListRequest(r16, 0, 0, r19, r17, null, false, ErrorCode.EXECUTE_ACTION_ERROR, null), new i(r3));
        Object r4 = r3.B();
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r20);
    L5:
        return r4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r7, Object r8, Object r9, Object r10) {
        return invoke((String) r7, ((Number) r8).longValue(), ((Number) r9).intValue(), (Continuation) r10);
    }
}
