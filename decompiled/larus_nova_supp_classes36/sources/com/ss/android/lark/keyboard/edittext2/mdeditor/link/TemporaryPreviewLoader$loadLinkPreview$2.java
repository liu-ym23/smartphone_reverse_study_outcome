package com.ss.android.lark.keyboard.edittext2.mdeditor.link;

import android.content.Context;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/keyboard/dtocompat/UrlInlinePreviewEntity;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext2.mdeditor.link.TemporaryPreviewLoader$loadLinkPreview$2", f = "TemporaryPreviewLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TemporaryPreviewLoader$loadLinkPreview$2 extends SuspendLambda implements Function2<UrlInlinePreviewEntity, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<n> $callback;
    final /* synthetic */ Context $context;
    /* synthetic */ Object L$0;
    int label;

    public TemporaryPreviewLoader$loadLinkPreview$2(IGetDataCallback<n> r1, Context r2, Continuation<? super TemporaryPreviewLoader$loadLinkPreview$2> r3) {
        this.$callback = r1;
        this.$context = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        TemporaryPreviewLoader$loadLinkPreview$2 r0 = new TemporaryPreviewLoader$loadLinkPreview$2(this.$callback, this.$context, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(UrlInlinePreviewEntity r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((UrlInlinePreviewEntity) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        UrlInlinePreviewEntity r4 = (UrlInlinePreviewEntity) this.L$0;
        IGetDataCallback<n> r0 = this.$callback;
        int r1 = PreviewEntityLinkParser.a;
        r0.onSuccess(PreviewEntityLinkParser.a(this.$context, r4));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
