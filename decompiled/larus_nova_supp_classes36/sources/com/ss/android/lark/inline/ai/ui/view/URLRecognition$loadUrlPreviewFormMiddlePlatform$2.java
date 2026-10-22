package com.ss.android.lark.inline.ai.ui.view;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.dtocompat.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/keyboard/dtocompat/UrlInlinePreviewEntity;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.ui.view.URLRecognition$loadUrlPreviewFormMiddlePlatform$2", f = "URLRecognition.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class URLRecognition$loadUrlPreviewFormMiddlePlatform$2 extends SuspendLambda implements Function2<UrlInlinePreviewEntity, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<UrlInlinePreviewEntity> $callback;
    /* synthetic */ Object L$0;
    int label;

    public URLRecognition$loadUrlPreviewFormMiddlePlatform$2(IGetDataCallback<UrlInlinePreviewEntity> r1, Continuation<? super URLRecognition$loadUrlPreviewFormMiddlePlatform$2> r2) {
        this.$callback = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        URLRecognition$loadUrlPreviewFormMiddlePlatform$2 r0 = new URLRecognition$loadUrlPreviewFormMiddlePlatform$2(this.$callback, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(UrlInlinePreviewEntity r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((UrlInlinePreviewEntity) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r4);
        UrlInlinePreviewEntity r5 = (UrlInlinePreviewEntity) this.L$0;
        if (r5.b.length() != 0) goto L7;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L12;
        Log.w("URLRecognition", "loadUrlPreviewFormMiddlePlatform: get empty title from preview entity, method return");
        return Unit.INSTANCE;
    L12:
        Log.i("URLRecognition", "loadUrlPreviewFormMiddlePlatform success: " + r5.b);
        this.$callback.onSuccess(r5);
        return Unit.INSTANCE;
    L7:
        r0 = false;
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
