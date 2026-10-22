package com.bytedance.ai.lynx;

import com.bytedance.ai.resource.AppletResourceTool;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.TemplateBundle;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/lynx/tasm/TemplateBundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.lynx.AppletLynxViewApi$getTemplateBundle$2", f = "AppletLynxViewApi.kt", i = {0}, l = {175}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
public final class AppletLynxViewApi$getTemplateBundle$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TemplateBundle>, Object> {
    final /* synthetic */ String $bundleId;
    final /* synthetic */ boolean $enableVerification;
    final /* synthetic */ String $packageName;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;

    public static final class a implements Function1<IIvyAIPackageResourceService.a, Unit> {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ CoroutineScope e;
        public final /* synthetic */ Continuation<TemplateBundle> f;

        public a(AtomicBoolean r1, boolean r10, String r11, String r12, CoroutineScope r13, SafeContinuation r14) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r13;
            this.f = r14;
        }

        public final Object invoke(Object r10) {
            IIvyAIPackageResourceService.a r11 = (IIvyAIPackageResourceService.a) r10;
            Intrinsics.checkNotNullParameter(r11, "response");
            if (this.a.compareAndSet(false, true) == false) goto L12;
            IIvyAIPackageResourceService.a.a r12 = r11.e;
            if (r12 == null) goto L10;
            com.bytedance.ai.utils.g r13 = com.bytedance.ai.utils.g.a;
            r13.i("AppletResourceLoader", "getTemplateBundle success. size: " + r12.a.length);
            com.bytedance.ai.resource.security.e r14 = com.bytedance.ai.resource.security.e.a;
            byte[] r15 = r12.a;
            boolean r16 = this.b;
            String r17 = this.c;
            String r18 = this.d;
            r14.getClass();
            TemplateBundle r19 = com.bytedance.ai.resource.security.e.g(r15, r16, r17, r18);
            if (r19 == null) goto L9;
            this.f.resumeWith(Result.constructor-impl(r19));
            goto L12
        L9:
            Continuation<TemplateBundle> r20 = this.f;
            r13.e("AppletResourceLoader", "getTemplateBundle failed. invalid templateBundle");
            r20.resumeWith(Result.constructor-impl(null));
            goto L12
        L10:
            com.bytedance.ai.utils.g.a.e("AppletResourceLoader", "getTemplateBundle failed. templateJS is empty");
            this.f.resumeWith(Result.constructor-impl(null));
        L12:
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Function1<Throwable, Unit> {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ Continuation<TemplateBundle> b;

        public b(AtomicBoolean r1, SafeContinuation r10) {
            this.a = r1;
            this.b = r10;
        }

        public final Object invoke(Object r10) {
            Throwable r11 = (Throwable) r10;
            Intrinsics.checkNotNullParameter(r11, "it");
            if (this.a.compareAndSet(false, true) == false) goto L6;
            com.bytedance.ai.utils.g.a.e("AppletResourceLoader", "getTemplateBundle failed. " + r11.getMessage());
            this.b.resumeWith(Result.constructor-impl(null));
        L6:
            return Unit.INSTANCE;
        }
    }

    public AppletLynxViewApi$getTemplateBundle$2(String r1, String r10, boolean r11, String r12, String r13, Continuation<? super AppletLynxViewApi$getTemplateBundle$2> r14) {
        this.$sessionId = r1;
        this.$url = r10;
        this.$enableVerification = r11;
        this.$packageName = r12;
        this.$bundleId = r13;
        super(2, r14);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        AppletLynxViewApi$getTemplateBundle$2 r12 = new AppletLynxViewApi$getTemplateBundle$2(this.$sessionId, this.$url, this.$enableVerification, this.$packageName, this.$bundleId, r11);
        r12.L$0 = r10;
        return r12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super TemplateBundle> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r10 = (String) this.L$4;
        String r11 = (String) this.L$3;
        String r12 = (String) this.L$2;
        String r13 = (String) this.L$1;
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r15);
    L13:
        return r15;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        String r17 = this.$sessionId;
        String r18 = this.$url;
        boolean r19 = this.$enableVerification;
        String r20 = this.$packageName;
        String r21 = this.$bundleId;
        this.L$0 = r16;
        this.L$1 = r17;
        this.L$2 = r18;
        this.L$3 = r20;
        this.L$4 = r21;
        this.Z$0 = r19;
        this.label = 1;
        SafeContinuation r22 = new SafeContinuation(IntrinsicsKt.intercepted(this));
        AtomicBoolean r110 = new AtomicBoolean(false);
        AppletResourceTool r111 = AppletResourceTool.a;
        a r112 = new a(r110, r19, r20, r21, r16, r22);
        b r23 = new b(r110, r22);
        r111.getClass();
        AppletResourceTool.q(r17, r18, r112, r23, false);
        r15 = r22.getOrThrow();
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(this);
    L11:
        if (r15 != r0) goto L13;
        return r0;
    }
}
