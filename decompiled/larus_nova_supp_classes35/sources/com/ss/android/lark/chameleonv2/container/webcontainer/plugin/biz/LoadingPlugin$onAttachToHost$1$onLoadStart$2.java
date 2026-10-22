package com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.widgetv2.emptyview.EmptyView;
import com.ss.android.lark.officesdk.utils.di.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;
import u1b.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.LoadingPlugin$onAttachToHost$1$onLoadStart$2", f = "LoadingPlugin.kt", i = {}, l = {139, 161}, m = "invokeSuspend", n = {}, s = {})
public final class LoadingPlugin$onAttachToHost$1$onLoadStart$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChameleonPluginHost $host;
    int label;
    final /* synthetic */ LoadingPlugin this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.LoadingPlugin$onAttachToHost$1$onLoadStart$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.LoadingPlugin$onAttachToHost$1$onLoadStart$2$1", f = "LoadingPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChameleonPluginHost $host;
        int label;
        final /* synthetic */ LoadingPlugin this$0;

        public AnonymousClass1(LoadingPlugin r1, ChameleonPluginHost r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$host = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$host, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            EmptyView r4 = LoadingPlugin.access$getEmptyView$p(this.this$0);
            if (r4 == null) goto L7;
            r4.showCustomError(2131238143, this.$host.getActivity().getString(2131887768));
            return Unit.INSTANCE;
        L7:
            return null;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public LoadingPlugin$onAttachToHost$1$onLoadStart$2(LoadingPlugin r1, ChameleonPluginHost r2, Continuation<? super LoadingPlugin$onAttachToHost$1$onLoadStart$2> r3) {
        this.this$0 = r1;
        this.$host = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LoadingPlugin$onAttachToHost$1$onLoadStart$2(this.this$0, this.$host, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L9;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L24
    L27:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L24
    L16:
        Boolean r11 = (Boolean) r10;     // Catch: Throwable -> L24
        j.e(LoadingPlugin.TAG, "loading returns, res = " + r11);     // Catch: Throwable -> L24
        if (r11 != null) goto L27;
        IChameleonLoader.DefaultImpls.onLoadFailed$default(this.$host.getLoader(), -2, null, 2, null);     // Catch: Throwable -> L24
        Map<String, a.C0305a> r12 = a.a;     // Catch: Throwable -> L24
        a.C0305a r13 = a.a(this.this$0.getSession());     // Catch: Throwable -> L24
        if (r13 == null) goto L21;
        a.C0305a.b(r13, ChameleonOpenTracker.OpenResult.TIMEOUT, -2);     // Catch: Throwable -> L24
    L21:
        MainCoroutineDispatcher r14 = Dispatchers.getMain();     // Catch: Throwable -> L24
        AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$host, null);     // Catch: Throwable -> L24
        this.label = 2;     // Catch: Throwable -> L24
        if (BuildersKt.withContext(r14, r0, this) != r1) goto L27;
        return r1;
    L12:
        ResultKt.throwOnFailure(r10);
        long r7 = LoadingPlugin.access$getLoadingTimeout(this.this$0);     // Catch: Throwable -> L24
        LoadingPlugin$onAttachToHost$1$onLoadStart$2$res$1 r15 = new LoadingPlugin$onAttachToHost$1$onLoadStart$2$res$1(this.this$0, null);     // Catch: Throwable -> L24
        this.label = 1;     // Catch: Throwable -> L24
        r10 = TimeoutKt.c(r7, r15, this);     // Catch: Throwable -> L24
        if (r10 != r1) goto L16;
        return r1;
    L24:
        th = move-exception;
        j.c(LoadingPlugin.TAG, "loading error!", th);
        goto L27
    }
}
