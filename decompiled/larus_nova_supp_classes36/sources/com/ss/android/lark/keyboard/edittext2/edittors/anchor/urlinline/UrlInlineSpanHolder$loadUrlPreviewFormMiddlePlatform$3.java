package com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.UrlInlineSpanHolder$loadUrlPreviewFormMiddlePlatform$3", f = "UrlInlineSpanHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UrlInlineSpanHolder$loadUrlPreviewFormMiddlePlatform$3 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ d this$0;

    public UrlInlineSpanHolder$loadUrlPreviewFormMiddlePlatform$3(d r1, Continuation<? super UrlInlineSpanHolder$loadUrlPreviewFormMiddlePlatform$3> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        UrlInlineSpanHolder$loadUrlPreviewFormMiddlePlatform$3 r0 = new UrlInlineSpanHolder$loadUrlPreviewFormMiddlePlatform$3(this.this$0, r4);
        r0.L$0 = r3;
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
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        ErrorResult r4 = (ErrorResult) this.L$0;
        this.this$0.j();
        Log.e("AnchorEditor", "loadUrlPreviewFormMiddlePlatform: fetch failed , " + r4.getDisplayMsg());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
