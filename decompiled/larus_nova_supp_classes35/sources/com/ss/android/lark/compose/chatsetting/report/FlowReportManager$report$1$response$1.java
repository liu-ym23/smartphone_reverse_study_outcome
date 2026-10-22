package com.ss.android.lark.compose.chatsetting.report;

import com.larksuite.rucket.job.RucketJob;
import com.ss.android.lark.compose.chatsetting.service.FlowChatSettingService;
import com.ss.android.lark.pb.messages.GenLarkReportUrlResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larksuite/rucket/job/base/RucketResult;", "Lcom/ss/android/lark/pb/messages/GenLarkReportUrlResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.report.FlowReportManager$report$1$response$1", f = "FlowReportManager.kt", i = {}, l = {40, 40}, m = "invokeSuspend", n = {}, s = {})
public final class FlowReportManager$report$1$response$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larksuite.rucket.job.base.b<? extends GenLarkReportUrlResponse>>, Object> {
    final /* synthetic */ String $chatId;
    int label;

    public FlowReportManager$report$1$response$1(String r1, Continuation<? super FlowReportManager$report$1$response$1> r2) {
        this.$chatId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new FlowReportManager$report$1$response$1(this.$chatId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larksuite.rucket.job.base.b<GenLarkReportUrlResponse>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r5);
    L16:
        return r5;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L13:
        this.label = 2;
        r5 = ((RucketJob) r5).awaitGet(this);
        if (r5 != r0) goto L16;
        return r0;
    L10:
        ResultKt.throwOnFailure(r5);
        FlowChatSettingService r6 = FlowChatSettingService.a;
        String r2 = this.$chatId;
        this.label = 1;
        r5 = r6.a(r2, this);
        if (r5 != r0) goto L13;
        return r0;
    }
}
