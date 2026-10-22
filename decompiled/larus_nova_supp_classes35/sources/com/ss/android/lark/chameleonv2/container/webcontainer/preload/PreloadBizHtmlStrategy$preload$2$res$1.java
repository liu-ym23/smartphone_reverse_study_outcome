package com.ss.android.lark.chameleonv2.container.webcontainer.preload;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.preload.PreloadBizHtmlStrategy$preload$2$res$1", f = "PreloadBizHtmlStrategy.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
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

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L13:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        final PreloadBizHtmlStrategy r6 = this.this$0;
        this.label = 1;
        int r2 = PreloadBizHtmlStrategy.c;
        r6.getClass();
        j r3 = new j(IntrinsicsKt.intercepted(this), 1);
        r3.C();
        final b r4 = new b(r3, r6);
        r6.a.w(r4);
        r3.i(new PreloadBizHtmlStrategy$waitForReady$2$1(r6, r4));
        r5 = r3.B();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r5 != r0) goto L13;
        return r0;
    }
}
