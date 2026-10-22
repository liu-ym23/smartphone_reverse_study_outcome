package com.ss.android.lark.officesdk.feed.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.tool.v1.GetLatestDoubaoIMFeatureOpenedRequest;
import com.bytedance.lark.pb.tool.v1.GetLatestDoubaoIMFeatureOpenedResponse;
import com.bytedance.lark.rustclient.api.c;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.x;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.feed.impl.DoubaoIMFeatureOpenedSyncer$startSync$2", f = "DoubaoIMFeatureOpenedSyncer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoubaoIMFeatureOpenedSyncer$startSync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.LongRef $currentGeneration;
    final /* synthetic */ String $doubaoUid;
    int label;
    final /* synthetic */ a this$0;

    public DoubaoIMFeatureOpenedSyncer$startSync$2(a r1, String r2, Ref.LongRef r3, Continuation<? super DoubaoIMFeatureOpenedSyncer$startSync$2> r4) {
        this.this$0 = r1;
        this.$doubaoUid = r2;
        this.$currentGeneration = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoubaoIMFeatureOpenedSyncer$startSync$2(this.this$0, this.$doubaoUid, this.$currentGeneration, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r15);
        a r1 = this.this$0;
        String r2 = this.$doubaoUid;
        long r3 = this.$currentGeneration.element;
        int r16 = a.k;
        r1.getClass();
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L7
        Object r18 = Result.constructor-impl(r1.c.h(new d(new GetLatestDoubaoIMFeatureOpenedRequest.Builder(), GetLatestDoubaoIMFeatureOpenedResponse.ADAPTER, Command.GET_DOUBAO_IM_FEATURE_OPENED, null, null, null, null, 248)).execute());     // Catch: Throwable -> L7
    L10:
        if (Result.isSuccess-impl(r18) == false) goto L19;
        x r0 = (s) r18;
        if ((r0 instanceof x) == false) goto L15;
        GetLatestDoubaoIMFeatureOpenedResponse r4 = (GetLatestDoubaoIMFeatureOpenedResponse) r0.c;
        r1.m(r2, r3, r4.im_feature_opened, r4.update_timestamp_ms, "GET");
        goto L19
    L15:
        if ((r0 instanceof c) == false) goto L18;
        Log.w("DoubaoIMFeatureSyncer", "GET_DOUBAO_IM_FEATURE_OPENED failed: " + ((c) r0).c.c());
        goto L19
    L18:
        throw new NoWhenBranchMatchedException();
    L19:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L23;
        Log.e("DoubaoIMFeatureSyncer", "GET_DOUBAO_IM_FEATURE_OPENED exception", r19);
    L23:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
