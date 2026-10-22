package com.ss.android.lark.chameleonv2.container.webcontainer.preload;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PreloadEmptyHtmlStrategy implements com.ss.android.lark.chameleonv2.container.webcontainer.preload.a {
    public final ChameleonWebView a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.container.webcontainer.preload.PreloadEmptyHtmlStrategy$preload$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.preload.PreloadEmptyHtmlStrategy", f = "PreloadEmptyHtmlStrategy.kt", i = {}, l = {19}, m = ChameleonOpenTracker.Stage.PRELOAD, n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PreloadEmptyHtmlStrategy this$0;

        public AnonymousClass1(PreloadEmptyHtmlStrategy r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= PluginList.LEVEL_NOT_SET;
            return this.this$0.preload(this);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.container.webcontainer.preload.PreloadEmptyHtmlStrategy$preload$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.preload.PreloadEmptyHtmlStrategy$preload$2", f = "PreloadEmptyHtmlStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PreloadEmptyHtmlStrategy this$0;

        public AnonymousClass2(PreloadEmptyHtmlStrategy r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.this$0.a.resumeTimers();
            this.this$0.a.loadUrl("file:///android_asset/wa_empty_template.html");
            this.this$0.a.setIsReady(true);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public PreloadEmptyHtmlStrategy(ChameleonWebView r2) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        this.a = r2;
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.preload.a
    public final Object preload(Continuation<? super Boolean> r6) {
        if ((r6 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r6;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L18:
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        MainCoroutineDispatcher r8 = Dispatchers.getMain();
        AnonymousClass2 r4 = new AnonymousClass2(this, null);
        r0.label = 1;
        if (BuildersKt.withContext(r8, r4, r0) != r2) goto L18;
        return r2;
    L7:
        r0 = new AnonymousClass1(this, r6);
        goto L8
    }
}
