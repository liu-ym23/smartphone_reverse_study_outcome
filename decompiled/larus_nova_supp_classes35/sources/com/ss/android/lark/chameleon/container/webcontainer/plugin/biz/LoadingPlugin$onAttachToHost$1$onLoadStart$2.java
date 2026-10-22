package com.ss.android.lark.chameleon.container.webcontainer.plugin.biz;

import com.ss.android.lark.chameleon.api.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleon.api.pluginapi.IChameleonLoader;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.widget.emptyview.EmptyView;
import com.ss.android.lark.chat.export.ui.message.style.BubbleStyle;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", BuildConfig.FLAVOR, "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.LoadingPlugin$onAttachToHost$1$onLoadStart$2", f = "LoadingPlugin.kt", i = {}, l = {88, BubbleStyle.ColorType.VIOLET_HEADER_WHITE_BORDER}, m = "invokeSuspend", n = {}, s = {})
public final class LoadingPlugin$onAttachToHost$1$onLoadStart$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChameleonPluginHost $host;
    int label;
    final /* synthetic */ LoadingPlugin this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.LoadingPlugin$onAttachToHost$1$onLoadStart$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", BuildConfig.FLAVOR, "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.ss.android.lark.chameleon.container.webcontainer.plugin.biz.LoadingPlugin$onAttachToHost$1$onLoadStart$2$1", f = "LoadingPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
            r4.showCustomError(2131232584, this.$host.getActivity().getString(2131887768));
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

    public final Object invokeSuspend(Object r14) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L9;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L12
    L28:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L12
    L18:
        Boolean r15 = (Boolean) r14;     // Catch: Throwable -> L12
        Log.i(LoadingPlugin.TAG, "loading returns, res = " + r15);     // Catch: Throwable -> L12
        if (r15 != null) goto L28;
        IChameleonLoader.DefaultImpls.onLoadFailed$default(this.$host.getLoader(), -2, null, null, 6, null);     // Catch: Throwable -> L12
        ChameleonOpenTracker.SessionTracker r6 = ChameleonOpenTracker.INSTANCE.getSessionTracker(this.this$0.getSession());     // Catch: Throwable -> L12
        if (r6 == null) goto L23;
        ChameleonOpenTracker.SessionTracker.openFinish$default(r6, ChameleonOpenTracker.OpenResult.TIMEOUT, -2, 0, 4, null);     // Catch: Throwable -> L12
    L23:
        MainCoroutineDispatcher r16 = Dispatchers.getMain();     // Catch: Throwable -> L12
        AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$host, null);     // Catch: Throwable -> L12
        this.label = 2;     // Catch: Throwable -> L12
        if (BuildersKt.withContext(r16, r0, this) != r1) goto L28;
        return r1;
    L14:
        ResultKt.throwOnFailure(r14);
        long r7 = LoadingPlugin.access$getLoadingTimeout(this.this$0);     // Catch: Throwable -> L12
        LoadingPlugin$onAttachToHost$1$onLoadStart$2$res$1 r17 = new LoadingPlugin$onAttachToHost$1$onLoadStart$2$res$1(this.this$0, null);     // Catch: Throwable -> L12
        this.label = 1;     // Catch: Throwable -> L12
        r14 = TimeoutKt.c(r7, r17, this);     // Catch: Throwable -> L12
        if (r14 != r1) goto L18;
        return r1;
    L12:
        th = move-exception;
        Log.e(LoadingPlugin.TAG, "loading error!", th);
        goto L28
    }
}
