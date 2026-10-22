package com.ss.android.lark.chameleon.container.webcontainer.plugin.biz;

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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", BuildConfig.FLAVOR, "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.LoadingPlugin$onAttachToHost$1$onLoadStart$2$res$1", f = "LoadingPlugin.kt", i = {0}, l = {212}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull"}, s = {"L$0"})
public final class LoadingPlugin$onAttachToHost$1$onLoadStart$2$res$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LoadingPlugin this$0;

    public LoadingPlugin$onAttachToHost$1$onLoadStart$2$res$1(LoadingPlugin r1, Continuation<? super LoadingPlugin$onAttachToHost$1$onLoadStart$2$res$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        LoadingPlugin$onAttachToHost$1$onLoadStart$2$res$1 r0 = new LoadingPlugin$onAttachToHost$1$onLoadStart$2$res$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        LoadingPlugin r2 = (LoadingPlugin) this.L$1;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r6);
    L13:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        final CoroutineScope r7 = (CoroutineScope) this.L$0;
        LoadingPlugin r4 = this.this$0;
        this.L$0 = r7;
        this.L$1 = r4;
        this.label = 1;
        final j r5 = new j(IntrinsicsKt.intercepted(this), 1);
        r5.C();
        LoadingPlugin.access$addHideLoadingCallbackOnce(r4, new LoadingPlugin$onAttachToHost$1$onLoadStart$2$res$1$1$1(r7, r5));
        r6 = r5.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r6 != r0) goto L13;
        return r0;
    }
}
