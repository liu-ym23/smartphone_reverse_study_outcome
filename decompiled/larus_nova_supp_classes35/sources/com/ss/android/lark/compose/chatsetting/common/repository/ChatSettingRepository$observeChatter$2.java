package com.ss.android.lark.compose.chatsetting.common.repository;

import com.lark.kmp.pb.basic.v1.Entity;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/lark/kmp/pb/basic/v1/Entity;", "e", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepository$observeChatter$2", f = "ChatSettingRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatSettingRepository$observeChatter$2 extends SuspendLambda implements Function3<FlowCollector<? super Entity>, Throwable, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public ChatSettingRepository$observeChatter$2(Continuation<? super ChatSettingRepository$observeChatter$2> r2) {
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((FlowCollector) r1, (Throwable) r2, (Continuation) r3);
    }

    public final Object invoke(FlowCollector<? super Entity> r1, Throwable r2, Continuation<? super Unit> r3) {
        ChatSettingRepository$observeChatter$2 r4 = new ChatSettingRepository$observeChatter$2(r3);
        r4.L$0 = r2;
        return r4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        Throwable r4 = (Throwable) this.L$0;
        int r0 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.observeChatter] error: " + r4.getMessage());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
