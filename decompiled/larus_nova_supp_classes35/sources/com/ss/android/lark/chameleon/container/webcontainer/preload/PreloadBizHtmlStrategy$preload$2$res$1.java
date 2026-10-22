package com.ss.android.lark.chameleon.container.webcontainer.preload;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", BuildConfig.FLAVOR, "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.ss.android.lark.chameleon.container.webcontainer.preload.PreloadBizHtmlStrategy$preload$2$res$1", f = "PreloadBizHtmlStrategy.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
public final class PreloadBizHtmlStrategy$preload$2$res$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ PreloadBizHtmlStrategy this$0;

    public PreloadBizHtmlStrategy$preload$2$res$1(PreloadBizHtmlStrategy r1, Continuation<? super PreloadBizHtmlStrategy$preload$2$res$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new PreloadBizHtmlStrategy$preload$2$res$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        PreloadBizHtmlStrategy r5 = this.this$0;
        this.label = 1;
        r4 = PreloadBizHtmlStrategy.access$waitForReady(r5, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
