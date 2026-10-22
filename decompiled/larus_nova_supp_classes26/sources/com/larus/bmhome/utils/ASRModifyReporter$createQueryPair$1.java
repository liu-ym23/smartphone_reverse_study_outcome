package com.larus.bmhome.utils;

import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.utils.ASRModifyReporter$createQueryPair$1", f = "ASRModifyReporter.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
final class ASRModifyReporter$createQueryPair$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $newMessageId;
    final /* synthetic */ String $oldMessageId;
    int label;

    public ASRModifyReporter$createQueryPair$1(String r1, String r2, String r3, Continuation<? super ASRModifyReporter$createQueryPair$1> r4) {
        this.$oldMessageId = r1;
        this.$newMessageId = r2;
        this.$botId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ASRModifyReporter$createQueryPair$1(this.$oldMessageId, this.$newMessageId, this.$botId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L11:
        com.larus.network.http.f r15 = (com.larus.network.http.a) r14;
        if ((r15 instanceof com.larus.network.http.f) == false) goto L15;
        FLogger.a.i("ASRModifyReporter", "fail, code:" + r15.d.getCode());
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        String r5 = this.$oldMessageId;
        String r6 = this.$newMessageId;
        String r7 = this.$botId;
        r4.put("original_query_msg_id", r5);
        r4.put("modify_query_msg_id", r6);
        r4.put("bot_id", r7);
        Unit r8 = Unit.INSTANCE;
        this.label = 1;
        r14 = HttpExtKt.k("Audio", ASRModifyReporter.CreateUserQueryPairResponse.class, "/alice/audio/create_query_pair", r4, null, null, false, null, null, null, this, 1008);
        if (r14 != r0) goto L11;
        return r0;
    }
}
