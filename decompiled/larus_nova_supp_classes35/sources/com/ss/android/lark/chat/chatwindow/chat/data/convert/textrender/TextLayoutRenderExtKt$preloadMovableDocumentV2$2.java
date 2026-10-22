package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender;

import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.n;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRenderExtKt$preloadMovableDocumentV2$2", f = "TextLayoutRenderExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TextLayoutRenderExtKt$preloadMovableDocumentV2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ n $config;
    final /* synthetic */ RichText $richText;
    private /* synthetic */ Object L$0;
    int label;

    public TextLayoutRenderExtKt$preloadMovableDocumentV2$2(RichText r1, n r2, Continuation<? super TextLayoutRenderExtKt$preloadMovableDocumentV2$2> r3) {
        this.$richText = r1;
        this.$config = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        TextLayoutRenderExtKt$preloadMovableDocumentV2$2 r0 = new TextLayoutRenderExtKt$preloadMovableDocumentV2$2(this.$richText, this.$config, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r4);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        TextLayoutRenderExtKt.a(new w2b.b(), this.$richText, this.$config);     // Catch: Exception -> L7 CancellationException -> L11
    L10:
        return Unit.INSTANCE;
    L11:
        e = move-exception;
        CoroutineScopeKt.cancel(r5, e);
        return Unit.INSTANCE;
    L7:
        e = move-exception;
        Log.e("MovableDocumentPreload", "Document preload failed", e);
        goto L10
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
