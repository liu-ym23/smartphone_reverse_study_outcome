package com.obric.aikernel.service.res;

import android.content.Context;
import android.os.Process;
import com.obric.aikernel.isolate.api.IIsolateApi;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.model.device.PythonExtension;
import com.obric.aikernel.request.track.VMStartupInfo;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.aikernel.runtime.RuntimeConfigBuilder;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService$inferRuntime$1", f = "PythonRuntimeService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PythonRuntimeService$inferRuntime$1 extends SuspendLambda implements Function2<l0, Continuation<? super AIInferRuntime>, Object> {
    int label;
    final /* synthetic */ PythonRuntimeService this$0;

    /* JADX INFO: renamed from: com.obric.aikernel.service.res.PythonRuntimeService$inferRuntime$1$2, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService$inferRuntime$1$2", f = "PythonRuntimeService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> r10) {
            super(1, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r10) {
            return new AnonymousClass2(r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super String> r10) {
            return invoke2(r10);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super String> r10) {
            return ((AnonymousClass2) create(r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r10);
            return AppContext.INSTANCE.getServerDeviceId();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class a implements PackageResourceManager.PresmConfig.d {
        a() {
        }

        @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.d
        public boolean a(int r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, "pkg");
            Intrinsics.checkNotNullParameter(r12, "caller");
            boolean r13 = false;
            if (r10 == 1) goto L5;
        L18:
            r13 = true;
        L19:
            AIKLog.INSTANCE.d("PythonRuntimeService", "isAllow: " + r13 + ' ' + r10 + ':' + r11 + ':' + r12);
            return r13;
        L5:
            if (Intrinsics.areEqual(r11, "ram") == true) goto L7;
        L9:
            boolean r14 = false;
        L10:
            IIsolateApi r15 = k7.b.a();
            if (r15 != null) goto L13;
        L15:
            boolean r16 = false;
        L16:
            if (r14 == true) goto L19;
            if (r16 == true) goto L19;
        L13:
            if (r15.isOnlyRunBizFromProp(r11) == true) goto L15;
            r16 = true;
            goto L16
        L7:
            if (StringsKt.startsWith$default(r12, ":", false, 2, null) == false) goto L9;
            r14 = true;
            goto L10
        }
    }

    PythonRuntimeService$inferRuntime$1(PythonRuntimeService r10, Continuation<? super PythonRuntimeService$inferRuntime$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new PythonRuntimeService$inferRuntime$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super AIInferRuntime> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super AIInferRuntime> r11) {
        return ((PythonRuntimeService$inferRuntime$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r20);
        VMStartupInfo r10 = VMStartupInfo.f4878a;
        r10.j();
        com.obric.aikernel.api.b r11 = com.obric.aikernel.api.b.f4431a;
        com.obric.aikernel.api.base.a r12 = r11.a();
        boolean r13 = r12.o();
        Context r14 = PythonRuntimeService.h(this.this$0);
        r10.l();
        AppContext r15 = AppContext.INSTANCE;
        final RuntimeConfigBuilder r16 = new RuntimeConfigBuilder(r14, String.valueOf(r15.getAid()), String.valueOf(r15.getAid()), r15.getVersionName(), r15.getChannel(), new AnonymousClass2(null), "3.7.0", false, 128, null);
        final PythonRuntimeService r17 = this.this$0;
        r16.o(r15.isAdminMode());
        r16.g(PythonRuntimeService.g(r17));
        r16.l(PythonRuntimeService.k(r17));
        r16.i(PythonRuntimeService$inferRuntime$1$3$1.INSTANCE);
        r16.j(PythonRuntimeService$inferRuntime$1$3$2.INSTANCE);
        r16.u(new PythonRuntimeService$inferRuntime$1$3$3(r16, r17, null));
        r16.q(PythonRuntimeService$inferRuntime$1$3$4.INSTANCE);
        r16.k(PythonRuntimeService$inferRuntime$1$3$5.INSTANCE);
        r16.m(PythonRuntimeService$inferRuntime$1$3$6.INSTANCE);
        r16.h("prs");
        r16.n(null);
        r16.s(new com.obric.aikernel.service.res.a(Intrinsics.areEqual(Process.myProcessName(), r15.getPackageName())));
        r16.v(new a());
        r16.A(new PythonRuntimeService$inferRuntime$1$3$8(r17));
        r16.y(CollectionsKt.listOf(new Pair("aik", PythonExtension.INSTANCE)));
        r16.r(PythonRuntimeService$inferRuntime$1$3$9.INSTANCE);
        r16.E(PythonRuntimeService$inferRuntime$1$3$10.INSTANCE);
        r16.w("aik_app");
        com.obric.aikernel.multiproc.d r18 = com.obric.aikernel.multiproc.d.f4707a;
        r18.a(r16);
        r10.f();
        r16.z(r11.c().a(r16.c(), r16.f(), r16.e().invoke().intValue(), r16.d()));
        r10.e();
        r16.F(r12.r());
        r16.p(r13);
        r16.B(new PythonRuntimeService$inferRuntime$1$3$11(r16));
        r16.C(new PythonRuntimeService$inferRuntime$1$3$12(r16));
        r16.G(r11.a().h());
        final AIInferRuntime.d r19 = r16.b();
        r19.h().setUpdateListener(new UpdateListener(new PythonRuntimeService$inferRuntime$1$4$1(this.this$0), null, 2, null));
        r19.h().setCustomInstaller(new LocalResInstaller());
        r18.g(r19.o());
        r19.h().setInferProcess(new PythonRuntimeService$inferRuntime$1$4$2(r19));
        AIKLog.INSTANCE.i("PythonRuntimeService", "appendMultiProcessConfigs init isInferProcess " + r19.o());
        r19.h().setDecryptFeature(r11.e().b(r19.h()));
        r10.k();
        AIInferRuntime r21 = new AIInferRuntime(r19);
        r10.i();
        return r21;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
