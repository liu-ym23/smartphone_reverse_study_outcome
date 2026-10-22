package com.bytedance.ai.resource;

import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.resource.core.bean.AIPackageManifestBean;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/resource/PackageInfoWithSession;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager$getInstallPackageFromGeckoJob$2", f = "AIPackageManager.kt", i = {0, 0}, l = {810}, m = "invokeSuspend", n = {"manifestPath", "pageInfo"}, s = {"L$0", "L$1"})
final class AIPackageManager$getInstallPackageFromGeckoJob$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super d0>, Object> {
    final /* synthetic */ String $packageName;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public static final class a implements Function1<IIvyAIPackageResourceService.a, Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ kotlinx.coroutines.i<d0> b;
        public final /* synthetic */ d0 c;

        public a(String r1, kotlinx.coroutines.j r10, d0 r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        public final Object invoke(Object r10) {
            IIvyAIPackageResourceService.a r11 = (IIvyAIPackageResourceService.a) r10;
            Intrinsics.checkNotNullParameter(r11, "manifestInfo");
            AIPackageManifestBean r0 = AIPackageManifestBean.Companion.parseManifestJson(r11.a);
            if (r0 != null) goto L5;
            com.bytedance.ai.utils.g.a.e("AIPackageManager", "failed to parse manifest. packageName: " + this.a);
            this.b.resumeWith(Result.constructor-impl(null));
        L16:
            return Unit.INSTANCE;
        L5:
            this.c.j = r0.getScmVersion();
            this.c.i = r0.getVersionCode();
            Applet r1 = com.bytedance.ai.resource.core.bean.a.a(r0);
            if (r1 == null) goto L8;
            d0 r12 = this.c;
            r1.B = r11.c;
            r12.d(r1);
        L8:
            List<Widget> r13 = com.bytedance.ai.resource.core.bean.a.b(r0);
            if (r13 == null) goto L14;
            d0 r14 = this.c;
            Iterator r15 = ((ArrayList) r13).iterator();
        L12:
            if (r15.hasNext() == false) goto L14;
            Widget r16 = (Widget) r15.next();
            r16.B = r11.c;
            r14.e(r16);
        L14:
            kotlinx.coroutines.i<d0> r17 = this.b;
            Result.Companion r18 = Result.Companion;
            r17.resumeWith(Result.constructor-impl(this.c));
            goto L16
        }
    }

    public static final class b implements Function1<Throwable, Unit> {
        public final /* synthetic */ String a;
        public final /* synthetic */ kotlinx.coroutines.i<d0> b;

        public b(String r1, kotlinx.coroutines.j r10) {
            this.a = r1;
            this.b = r10;
        }

        public final Object invoke(Object r10) {
            Throwable r11 = (Throwable) r10;
            Intrinsics.checkNotNullParameter(r11, "it");
            com.bytedance.ai.utils.g.a.e("AIPackageManager", "failed to load manifest. packageName: " + this.a, r11);
            AppletResourceTool r0 = AppletResourceTool.a;
            String r1 = this.a;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "packageName");
            AppletResourceTool.b.remove(r1);
            AppletResourceTool.i().erase(r1);
            kotlinx.coroutines.i<d0> r12 = this.b;
            Result.Companion r13 = Result.Companion;
            r12.resumeWith(Result.constructor-impl(ResultKt.createFailure(r11)));
            return Unit.INSTANCE;
        }
    }

    public AIPackageManager$getInstallPackageFromGeckoJob$2(String r1, Continuation<? super AIPackageManager$getInstallPackageFromGeckoJob$2> r10) {
        this.$packageName = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AIPackageManager$getInstallPackageFromGeckoJob$2(this.$packageName, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super d0> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        String r11 = (String) this.L$2;
        d0 r12 = (d0) this.L$1;
        String r13 = (String) this.L$0;
        ResultKt.throwOnFailure(r10);
    L23:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        String r14 = AIPackageManager.b(AIPackageManager.a, this.$packageName);
        if (r14 != null) goto L11;
    L14:
        boolean r15 = true;
    L15:
        if (r15 == false) goto L18;
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "baseUrl is empty. packageName: " + this.$packageName);
        return null;
    L18:
        AppletResourceTool r16 = AppletResourceTool.a;
        String r17 = this.$packageName;
        r16.getClass();
        String r18 = AppletResourceTool.k(r17, r14, false);
        d0 r19 = new d0(this.$packageName, false, 6);
        String r20 = this.$packageName;
        this.L$0 = r18;
        this.L$1 = r19;
        this.L$2 = r20;
        this.label = 1;
        kotlinx.coroutines.j r21 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r21.C();
        AppletResourceTool.q(r19.e, r18, new a(r20, r21, r19), new b(r20, r21), true);
        r10 = r21.B();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        DebugProbesKt.probeCoroutineSuspended(this);
    L21:
        if (r10 != r0) goto L23;
        return r0;
    L11:
        if (r14.length() == 0) goto L14;
        r15 = false;
        goto L15
    }
}
