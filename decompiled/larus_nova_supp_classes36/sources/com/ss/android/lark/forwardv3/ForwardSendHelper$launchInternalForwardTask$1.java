package com.ss.android.lark.forwardv3;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.lark.forwardv3.data.ForwardErrorResultV3;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.forwardv3.ForwardSendHelper$launchInternalForwardTask$1", f = "ForwardSendHelper.kt", i = {}, l = {83}, m = "invokeSuspend", n = {}, s = {})
final class ForwardSendHelper$launchInternalForwardTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ List<SearchBaseInfo> $items;
    final /* synthetic */ String $note;
    final /* synthetic */ y.a $resultCallback;
    final /* synthetic */ RichText $richText;
    int label;
    final /* synthetic */ y this$0;

    public ForwardSendHelper$launchInternalForwardTask$1(y.a r1, y r2, List<? extends SearchBaseInfo> r3, Context r4, RichText r5, String r6, Continuation<? super ForwardSendHelper$launchInternalForwardTask$1> r7) {
        this.$resultCallback = r1;
        this.this$0 = r2;
        this.$items = r3;
        this.$context = r4;
        this.$richText = r5;
        this.$note = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ForwardSendHelper$launchInternalForwardTask$1(this.$resultCallback, this.this$0, this.$items, this.$context, this.$richText, this.$note, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L15
    L13:
        String r14 = (String) r13;     // Catch: Throwable -> L15
    L18:
        if (TextUtils.isEmpty(r14) == false) goto L21;
        Log.e("NewForward", "time out job is success, callback error");
        this.$resultCallback.onError(new ForwardErrorResultV3("", false));
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
        Log.i("NewForward", "forward launch time out job");
        ForwardSendHelper$launchInternalForwardTask$1$jobWithTimeOutResult$1 r15 = new ForwardSendHelper$launchInternalForwardTask$1$jobWithTimeOutResult$1(this.this$0, this.$items, this.$context, this.$richText, this.$note, this.$resultCallback, null);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r13 = TimeoutKt.c(15000, r15, this);     // Catch: Throwable -> L15
        if (r13 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Log.e("NewForward", "time out job error: ", th);
        r14 = null;
        goto L18
    }
}
