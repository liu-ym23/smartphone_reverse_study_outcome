package com.ss.android.lark.chameleonv2.container.webcontainer.preload;

import android.text.TextUtils;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.PreloadConfig;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.officesdk.utils.di.j;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PreloadBizHtmlStrategy implements com.ss.android.lark.chameleonv2.container.webcontainer.preload.a {
    public static final /* synthetic */ int c = 0;
    public final ChameleonWebView a;
    public final ChameleonConfig b;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.container.webcontainer.preload.PreloadBizHtmlStrategy$preload$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.preload.PreloadBizHtmlStrategy$preload$2", f = "PreloadBizHtmlStrategy.kt", i = {}, l = {33, 39}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $preloadUrl;
        int label;
        final /* synthetic */ PreloadBizHtmlStrategy this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.chameleonv2.container.webcontainer.preload.PreloadBizHtmlStrategy$preload$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.preload.PreloadBizHtmlStrategy$preload$2$1", f = "PreloadBizHtmlStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<String> $preloadUrl;
            int label;
            final /* synthetic */ PreloadBizHtmlStrategy this$0;

            public AnonymousClass1(PreloadBizHtmlStrategy r1, Ref.ObjectRef<String> r2, Continuation<? super AnonymousClass1> r3) {
                this.this$0 = r1;
                this.$preloadUrl = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass1(this.this$0, this.$preloadUrl, r4);
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
                this.this$0.a.setPreloadUrl((String) this.$preloadUrl.element);
                this.this$0.a.resumeTimers();
                this.this$0.a.loadUrl((String) this.$preloadUrl.element);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass2(PreloadBizHtmlStrategy r1, Ref.ObjectRef<String> r2, Continuation<? super AnonymousClass2> r3) {
            this.this$0 = r1;
            this.$preloadUrl = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass2(this.this$0, this.$preloadUrl, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r9);
        L20:
            Boolean r10 = (Boolean) r9;
            j.e("CML_TAG_PreloadBizHtmlStrategy", "preload html end, res = " + r10);
            if (r10 == null) goto L23;
            boolean r11 = r10.booleanValue();
        L25:
            return Boxing.boxBoolean(r11);
        L23:
            r11 = false;
            goto L25
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r9);
        L13:
            PreloadConfig r12 = this.this$0.b.getPreloadConfig();
            if (r12 == null) goto L16;
            long r5 = r12.getTimeout();
        L17:
            PreloadBizHtmlStrategy$preload$2$res$1 r13 = new PreloadBizHtmlStrategy$preload$2$res$1(this.this$0, null);
            this.label = 2;
            r9 = TimeoutKt.c(r5, r13, this);
            if (r9 != r0) goto L20;
            return r0;
        L16:
            r5 = PreloadConfig.DEFAULT_TIMEOUT;
            goto L17
        L10:
            ResultKt.throwOnFailure(r9);
            j.e("CML_TAG_PreloadBizHtmlStrategy", "preload html start");
            MainCoroutineDispatcher r14 = Dispatchers.getMain();
            AnonymousClass1 r2 = new AnonymousClass1(this.this$0, this.$preloadUrl, null);
            this.label = 1;
            if (BuildersKt.withContext(r14, r2, this) != r0) goto L13;
            return r0;
        }
    }

    static {
    }

    @Override // com.ss.android.lark.chameleonv2.container.webcontainer.preload.a
    public final Object preload(Continuation<? super Boolean> r5) {
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        PreloadConfig r1 = this.b.getPreloadConfig();
        if (r1 == null) goto L5;
        String r2 = r1.getTemplateUrl();
    L6:
        r0.element = r2;
        if (TextUtils.isEmpty(r2) == false) goto L9;
        r0.element = this.b.getLoadUrl();
    L9:
        j.e("CML_TAG_PreloadBizHtmlStrategy", "preload()... preloadUrl = " + ((String) r0.element));
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(this, r0, null), r5);
    L5:
        r2 = null;
        goto L6
    }

    public PreloadBizHtmlStrategy(ChameleonWebView r2, ChameleonConfig r3) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        Intrinsics.checkNotNullParameter(r3, "chameleonConfig");
        this.a = r2;
        this.b = r3;
    }
}
