package com.ss.android.lark.officesdk.feed.impl;

import com.bytedance.lark.office_sdk_im_android.OfficeSdkIm;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.feed.impl.FeedOfficeSdkServiceImpl$notifyUpdateFeedData$1", f = "FeedOfficeSdkServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FeedOfficeSdkServiceImpl$notifyUpdateFeedData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $request;
    final /* synthetic */ long $sdkSession;
    final /* synthetic */ long $uid;
    int label;

    public FeedOfficeSdkServiceImpl$notifyUpdateFeedData$1(long r1, long r3, byte[] r5, Continuation<? super FeedOfficeSdkServiceImpl$notifyUpdateFeedData$1> r6) {
        this.$uid = r1;
        this.$sdkSession = r3;
        this.$request = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new FeedOfficeSdkServiceImpl$notifyUpdateFeedData$1(this.$uid, this.$sdkSession, this.$request, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        OfficeSdkIm r6 = OfficeSdkIm.Companion.new-PWzV0Is(this.$uid, this.$sdkSession);
        byte[] r0 = this.$request;
        Intrinsics.checkNotNull(r0);
        r6.updateFeed(r0);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
