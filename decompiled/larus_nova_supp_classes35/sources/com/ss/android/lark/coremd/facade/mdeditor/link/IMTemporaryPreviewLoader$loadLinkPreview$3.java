package com.ss.android.lark.coremd.facade.mdeditor.link;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.coremdbiz.facade.link.LinkType;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.coremd.facade.mdeditor.link.IMTemporaryPreviewLoader$loadLinkPreview$3", f = "IMTemporaryPreviewLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class IMTemporaryPreviewLoader$loadLinkPreview$3 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<n> $callback;
    final /* synthetic */ n $link;
    final /* synthetic */ LinkType $linkType;
    /* synthetic */ Object L$0;
    int label;

    public IMTemporaryPreviewLoader$loadLinkPreview$3(LinkType r1, IGetDataCallback<n> r2, n r3, Continuation<? super IMTemporaryPreviewLoader$loadLinkPreview$3> r4) {
        this.$linkType = r1;
        this.$callback = r2;
        this.$link = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        IMTemporaryPreviewLoader$loadLinkPreview$3 r0 = new IMTemporaryPreviewLoader$loadLinkPreview$3(this.$linkType, this.$callback, this.$link, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(ErrorResult r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ErrorResult) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r3);
        ErrorResult r4 = (ErrorResult) this.L$0;
        if (this.$linkType != LinkType.PossibleLink) goto L7;
        this.$callback.onSuccess(this.$link);
    L9:
        return Unit.INSTANCE;
    L7:
        this.$callback.onError(r4);
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
