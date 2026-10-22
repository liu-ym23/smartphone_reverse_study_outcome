package com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz;

import com.ss.android.lark.officesdk.utils.di.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.LoadingPlugin$onAttachToHost$1$onLoadStart$2$res$1", f = "LoadingPlugin.kt", i = {0}, l = {267}, m = "invokeSuspend", n = {"$this$withTimeoutOrNull"}, s = {"L$0"})
public final class LoadingPlugin$onAttachToHost$1$onLoadStart$2$res$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LoadingPlugin this$0;

    public static final class a implements LoadingPlugin.b {
        public final /* synthetic */ CoroutineScope a;
        public final /* synthetic */ i<Boolean> b;

        @Override // com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.LoadingPlugin.b
        public final void onLoadFinish() {
            j.a(LoadingPlugin.TAG, "onLoadFinish, isActive = " + CoroutineScopeKt.isActive(this.a) + ", continuation.isActive = " + this.b.isActive() + ", continuation.isCancelled = " + this.b.isCancelled());
            if (CoroutineScopeKt.isActive(this.a) == true) goto L5;
            return;
        L5:
            if (this.b.isActive() == true) goto L7;
            return;
        L7:
            if (this.b.isCancelled() == true) goto L12;
            i<Boolean> r0 = this.b;
            Result.Companion r1 = Result.Companion;
            r0.resumeWith(Result.constructor-impl(Boolean.TRUE));
            return;
        }

        public a(CoroutineScope r1, kotlinx.coroutines.j r2) {
            this.a = r1;
            this.b = r2;
        }
    }

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
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        LoadingPlugin r4 = this.this$0;
        this.L$0 = r7;
        this.L$1 = r4;
        this.label = 1;
        kotlinx.coroutines.j r5 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r5.C();
        LoadingPlugin.access$addHideLoadingCallbackOnce(r4, new a(r7, r5));
        r6 = r5.B();
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r6 != r0) goto L13;
        return r0;
    }
}
