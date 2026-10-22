package com.obric.aikernel.phx.core.api;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.a;
import com.obric.aikernel.b;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.core.log.ILog;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.phx.core.conn.BinderMonitor;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.sdk.ExtsKt;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.channels.u;
import kotlinx.coroutines.channels.w;
import kotlinx.coroutines.channels.z;
import kotlinx.coroutines.flow.i;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J;\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\n0\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0013H\u0002J!\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/aikernel/phx/core/api/AbsApi;", "Lcom/obric/aikernel/phx/sdk/api/IBaseModel;", "()V", "callModelAsFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroid/os/Bundle;", "binder", "Lcom/obric/aikernel/AIKBinder;", "args", "callModelAsResponse", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "(Lcom/obric/aikernel/AIKBinder;Landroid/os/Bundle;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBinder", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendFlowCallMethod", "", "self", "Lkotlinx/coroutines/channels/ProducerScope;", "unload", "", ActivityLifecycle.NAME, "", "(Lcom/obric/aikernel/AIKBinder;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AbsApi implements IBaseModel {
    public static final Companion Companion = null;
    private static final String TAG = "AbsApi";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/aikernel/phx/core/api/AbsApi$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.AbsApi$callModelAsFlow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroid/os/Bundle;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.AbsApi$callModelAsFlow$1", f = "AbsApi.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<w<? super Bundle>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $args;
        final /* synthetic */ a $binder;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AbsApi this$0;

        AnonymousClass1(a r3, AbsApi r4, Bundle r5, Continuation<? super AnonymousClass1> r6) {
            a r7 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$binder = r7;
            this.this$0 = r4;
            this.$args = r5;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.$binder, this.this$0, this.$args, r7);
            r0.L$0 = r5;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(w<? super Bundle> r3, Continuation<? super Unit> r4) {
            return invoke2((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(w<? super Bundle> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r9);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            final w r10 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
            ILog.Companion.a((ILog) ZeusTransformUtils.preCheckCast(AIKLog.INSTANCE, ILog.class, "com.obric.memorydata.plugin"), AbsApi.TAG, (Function0) ZeusTransformUtils.preCheckCast(C02521.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
            final bx r2 = BinderMonitor.INSTANCE.monitorTransact(r10.getCoroutineContext(), this.$binder, (Function0) ZeusTransformUtils.preCheckCast(new AbsApi$callModelAsFlow$1$monitorTask$1(r10), Function0.class, "com.obric.memorydata.plugin"));
            if (AbsApi.access$sendFlowCallMethod(this.this$0, this.$binder, this.$args, r10) == true) goto L12;
            if (r2 == null) goto L16;
            bx.a.a(r2, null, 1, null);
            goto L16
        L12:
            Function0 r3 = (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r2), Function0.class, "com.obric.memorydata.plugin");
            Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (u.a(r10, r3, r4) != r0) goto L16;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.AbsApi$callModelAsResponse$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.AbsApi", f = "AbsApi.kt", i = {0, 0, 0, 0, 0}, l = {124}, m = "callModelAsResponse", n = {"binder", "args", "block", "ctx", "monitorTask"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class C09961<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AbsApi this$0;

        C09961(AbsApi r3, Continuation<? super C09961> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.callModelAsResponse(null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.aikernel.phx.core.api.AbsApi$unload$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.phx.core.api.AbsApi", f = "AbsApi.kt", i = {0}, l = {110}, m = "unload", n = {ActivityLifecycle.NAME}, s = {"L$0"})
    static final class C09981 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AbsApi this$0;

        C09981(AbsApi r3, Continuation<? super C09981> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.unload(null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AbsApi() {
    }

    public static final /* synthetic */ boolean access$sendFlowCallMethod(AbsApi r2, a r3, Bundle r4, w r5) {
        return r2.sendFlowCallMethod((a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin"), r4, (w) ZeusTransformUtils.wrapperContextForParams(r5, w.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ Object getBinder$suspendImpl(AbsApi r6, Continuation<? super a> r7) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        return AIKernelApi.getBinder$default(AIKernelManager.INSTANCE.getInstance$sdk_release(), 0, r3, 1, null);
    }

    private final boolean sendFlowCallMethod(a r5, final Bundle r6, w<? super Bundle> r7) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.memorydata.plugin");
        final w r8 = (w) ZeusTransformUtils.wrapperContextForParams(r7, w.class, "com.obric.memorydata.plugin");
        ILog.Companion.a((ILog) ZeusTransformUtils.preCheckCast(AIKLog.INSTANCE, ILog.class, "com.obric.memorydata.plugin"), TAG, (Function0) ZeusTransformUtils.preCheckCast(new C09971(r6), Function0.class, "com.obric.memorydata.plugin"));
        r4.a(r6, (b) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r8), b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        r8.mo54trySendJP2dKIU(BundleExtKt.setErr(new Bundle(), 102, th.getMessage()));
        z.a.a((z) ZeusTransformUtils.preCheckCast(r8, z.class, "com.obric.memorydata.plugin"), null, 1, null);
        return false;
    }

    public final i<Bundle> callModelAsFlow(a r4, Bundle r5) {
        a r6 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "binder");
        Intrinsics.checkNotNullParameter(r5, "args");
        return k.b((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this, r5, null), Function2.class, "com.obric.memorydata.plugin"));
    }

    public final <T> Object callModelAsResponse(a r10, Bundle r11, Function1<? super Bundle, ? extends T> r12, Continuation<? super T> r13) {
        a r14 = (a) ZeusTransformUtils.wrapperContextForParams(r10, a.class, "com.obric.memorydata.plugin");
        Function1 r15 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r16, C09961.class) == false) goto L7;
        C09961 r0 = (C09961) ZeusTransformUtils.preCheckCast(r16, C09961.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        Ref.ObjectRef r18 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r0.L$4, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        CoroutineContext r19 = (CoroutineContext) ZeusTransformUtils.preCheckCast(r0.L$3, CoroutineContext.class, "com.obric.memorydata.plugin");
        r15 = (Function1) ZeusTransformUtils.preCheckCast(r0.L$2, Function1.class, "com.obric.memorydata.plugin");
        Bundle r110 = (Bundle) ZeusTransformUtils.preCheckCast(r0.L$1, Bundle.class, "com.obric.memorydata.plugin");
        a r111 = (a) ZeusTransformUtils.preCheckCast(r0.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L25:
        Bundle r20 = (Bundle) ZeusTransformUtils.preCheckCast(r9, Bundle.class, "com.obric.memorydata.plugin");
        bx r112 = (bx) ZeusTransformUtils.preCheckCast(r18.element, bx.class, "com.obric.memorydata.plugin");
        if (r112 == null) goto L29;
        bx.a.a(r112, null, 1, null);
    L29:
        return r15.invoke(r20);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        AIKLog.INSTANCE.v(TAG, "start callModelAsResponse " + r11.getString(IdlKeys.MethodName) + ", traceid=" + r11.getString(IdlKeys.Args_TraceId));
        CoroutineContext r21 = r0.getContext();
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        r0.L$0 = r14;
        r0.L$1 = r11;
        r0.L$2 = r15;
        r0.L$3 = r21;
        r0.L$4 = r3;
        r0.label = 1;
        o r5 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin")), 1);
        r5.e();
        final n r4 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.memorydata.plugin");
        r3.element = (T) BinderMonitor.INSTANCE.monitorTransact(r21, r14, (Function0) ZeusTransformUtils.preCheckCast(new AbsApi$callModelAsResponse$responseBundle$1$1(r4), Function0.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L17
        r14.a(r11, (b) ZeusTransformUtils.preCheckCast(new AbsApi$callModelAsResponse$responseBundle$1$2(r4), b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L17
    L19:
        r9 = r5.h();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin"));
    L22:
        if (r9 != r17) goto L24;
        return r17;
    L24:
        r18 = r3;
    L17:
        th = move-exception;
        ExtsKt.resume((Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"), BundleExtKt.setErr(new Bundle(), 102, th.getMessage()));
    L7:
        r0 = new C09961(this, r16);
        goto L8
    }

    @Override // com.obric.aikernel.phx.sdk.api.IBaseModel, java.lang.AutoCloseable
    public void close() {
        IBaseModel.DefaultImpls.close(this);
    }

    public Object getBinder(Continuation<? super a> r3) {
        return getBinder$suspendImpl(this, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object unload(a r17, String r18, Continuation<? super Unit> r19) {
        a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r17, a.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, C09981.class) == false) goto L7;
        C09981 r3 = (C09981) ZeusTransformUtils.preCheckCast(r2, C09981.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        r0 = (a) ZeusTransformUtils.preCheckCast(r3.L$1, a.class, "com.obric.memorydata.plugin");
        final String r7 = (String) ZeusTransformUtils.preCheckCast(r3.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
    L18:
        r0.a(BundleExtKt.commonParams$default((Bundle) ZeusTransformUtils.preCheckCast(r4, Bundle.class, "com.obric.memorydata.plugin"), r7, IdlKeys.Method_UnloadPackage, IdlKeys.Call_Type_CallBiz, null, TAG, "unload", null, false, 200, null), (b) ZeusTransformUtils.preCheckCast(new BinderC09992(r7), b.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        ParamsCompat r8 = ParamsCompat.INSTANCE;
        RequestParams r9 = new RequestParams(null, null, 3, null);
        r3.L$0 = r18;
        r3.L$1 = r0;
        r3.label = 1;
        r4 = r8.startCompat(r9, r3);
        if (r4 != r5) goto L17;
        return r5;
    L17:
        r7 = r18;
    L7:
        r3 = new C09981(this, r2);
        goto L8
    }
}
