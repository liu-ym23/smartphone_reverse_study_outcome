package com.ss.android.lark.chat.service.extension;

import com.bytedance.lark.pb.im.v1.AIRoundInfo;
import com.ss.android.lark.biz.im.api.f1;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.channels.k;
import m6b.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/bytedance/lark/pb/im/v1/AIRoundInfo;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.service.extension.PushAIRoundInfoKt$pushAIRoundInfo$1", f = "PushAIRoundInfo.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
final class PushAIRoundInfoKt$pushAIRoundInfo$1 extends SuspendLambda implements Function2<k<? super AIRoundInfo>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $aiChatModeId;
    final /* synthetic */ String $chatId;
    final /* synthetic */ u $this_pushAIRoundInfo;
    private /* synthetic */ Object L$0;
    int label;

    public static final class a implements f1 {
        public final /* synthetic */ k<AIRoundInfo> a;

        public a(k<? super AIRoundInfo> r1) {
            this.a = r1;
        }

        public final void a(AIRoundInfo r3) {
            Intrinsics.checkNotNullParameter(r3, "roundInfo");
            Object r4 = this.a.trySend-JP2dKIU(r3);
            g.c r0 = g.b;
            if ((r4 instanceof g.c) == false) goto L6;
            Log.e("PushAIRoundInfo", "onPushAIRoundInfo failed", g.a(r4));
            return;
        }
    }

    public PushAIRoundInfoKt$pushAIRoundInfo$1(u r1, String r2, Long r3, Continuation<? super PushAIRoundInfoKt$pushAIRoundInfo$1> r4) {
        this.$this_pushAIRoundInfo = r1;
        this.$chatId = r2;
        this.$aiChatModeId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        PushAIRoundInfoKt$pushAIRoundInfo$1 r0 = new PushAIRoundInfoKt$pushAIRoundInfo$1(this.$this_pushAIRoundInfo, this.$chatId, this.$aiChatModeId, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((k) r1, (Continuation) r2);
    }

    public final Object invoke(k<? super AIRoundInfo> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        k r9 = (k) this.L$0;
        final a r2 = new a(r9);
        this.$this_pushAIRoundInfo.pb(this.$chatId, this.$aiChatModeId, r2);
        Log.i("PushAIRoundInfo", "pushAIRoundInfo add listener chatId:" + this.$chatId + ",aiChatModeId:" + this.$aiChatModeId);
        final u r4 = this.$this_pushAIRoundInfo;
        final String r5 = this.$chatId;
        final Long r6 = this.$aiChatModeId;
        Function0<Unit> r3 = new AnonymousClass1(r4, r5, r6, r2);
        this.label = 1;
        if (ProduceKt.a(r9, r3, this) != r0) goto L12;
        return r0;
    }
}
