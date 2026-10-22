package com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, Keys.API_RETURN_KEY_ERROR, "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$fetchCanSetStranger$2$2", f = "ChatStrangerRelationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatStrangerRelationViewModel$fetchCanSetStranger$2$2 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    final /* synthetic */ i<Boolean> $it;
    final /* synthetic */ long $userId;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatStrangerRelationViewModel$fetchCanSetStranger$2$2(long r1, i<? super Boolean> r3, Continuation<? super ChatStrangerRelationViewModel$fetchCanSetStranger$2$2> r4) {
        this.$userId = r1;
        this.$it = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ChatStrangerRelationViewModel$fetchCanSetStranger$2$2 r0 = new ChatStrangerRelationViewModel$fetchCanSetStranger$2$2(this.$userId, this.$it, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(ErrorResult r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ErrorResult) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r4);
        ErrorResult r5 = (ErrorResult) this.L$0;
        StringBuilder r0 = new StringBuilder("fetch can set stranger from tryLocal  userId：");
        r0.append(this.$userId);
        r0.append(", failed, err: ");
        String r6 = r5.getMessage();
        if (r6 != null) goto L7;
        r6 = "unknown";
    L7:
        r0.append(r6);
        Log.e("ChatStrangerRelationVM", r0.toString());
        this.$it.resumeWith(Result.constructor-impl(null));
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
