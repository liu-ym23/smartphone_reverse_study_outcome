package com.obric.aikernel.sdk.autotest;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.exifinterface.media.ExifInterface;
import com.obric.aikernel.a;
import com.obric.aikernel.b;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.sdk.autotest.AutoTestManager$callAutoTestAsResponse$responseBundle$1", f = "AutoTestManager.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
final class AutoTestManager$callAutoTestAsResponse$responseBundle$1 extends SuspendLambda implements Function2<al, Continuation<? super Bundle>, Object> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ a $binder;
    final /* synthetic */ long $timeoutMs;
    Object L$0;
    Object L$1;
    int label;

    AutoTestManager$callAutoTestAsResponse$responseBundle$1(Bundle r3, long r4, a r6, Continuation<? super AutoTestManager$callAutoTestAsResponse$responseBundle$1> r7) {
        a r8 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$args = r3;
        this.$timeoutMs = r4;
        this.$binder = r8;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AutoTestManager$callAutoTestAsResponse$responseBundle$1(this.$args, this.$timeoutMs, this.$binder, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Bundle> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Bundle> r4) {
        return ((AutoTestManager$callAutoTestAsResponse$responseBundle$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AutoTestManager$callAutoTestAsResponse$responseBundle$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        Bundle r2 = (Bundle) ZeusTransformUtils.preCheckCast(this.L$1, Bundle.class, "com.obric.memorydata.plugin");
        a r10 = (a) ZeusTransformUtils.preCheckCast(this.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);     // Catch: CancellationException -> L31
    L38:
        return (Bundle) ZeusTransformUtils.preCheckCast(r11, Bundle.class, "com.obric.memorydata.plugin");
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r11);
        AIKLog.INSTANCE.v("AutoTestManager", "start callAutoTestlAsResponse " + this.$args.getString(IdlKeys.MethodName) + ", timeoutMs = " + this.$timeoutMs + ", traceid=" + this.$args.getString(IdlKeys.Args_TraceId));
        a r12 = this.$binder;     // Catch: CancellationException -> L31
        Bundle r3 = this.$args;     // Catch: CancellationException -> L31
        this.L$0 = r12;     // Catch: CancellationException -> L31
        this.L$1 = r3;     // Catch: CancellationException -> L31
        this.label = 1;     // Catch: CancellationException -> L31
        o r6 = new o(IntrinsicsKt.intercepted((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin")), 1);     // Catch: CancellationException -> L31
        r6.e();     // Catch: CancellationException -> L31
        final n r4 = (n) ZeusTransformUtils.preCheckCast(r6, n.class, "com.obric.memorydata.plugin");     // Catch: CancellationException -> L31
        final Function0 r5 = (Function0) ZeusTransformUtils.preCheckCast(new AutoTestManager$callAutoTestAsResponse$responseBundle$1$1$deathRecipient$1(r4), Function0.class, "com.obric.memorydata.plugin");     // Catch: CancellationException -> L31
        r12.asBinder().linkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(new AutoTestManager$sam$android_os_IBinder_DeathRecipient$0(r5), IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"), 0);     // Catch: CancellationException -> L31
        r12.b(r3, (b) ZeusTransformUtils.preCheckCast(new AutoTestManager$callAutoTestAsResponse$responseBundle$1$1$1(r4), b.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L16 RemoteException -> L18
        IBinder r13 = r12.asBinder();     // Catch: CancellationException -> L31
        IBinder.DeathRecipient r7 = (IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(new AutoTestManager$sam$android_os_IBinder_DeathRecipient$0(r5), IBinder.DeathRecipient.class, "com.obric.memorydata.plugin");     // Catch: CancellationException -> L31
    L14:
        r13.unlinkToDeath(r7, 0);     // Catch: CancellationException -> L31
        r11 = r6.h();     // Catch: CancellationException -> L31
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        DebugProbesKt.probeCoroutineSuspended((Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));     // Catch: CancellationException -> L31
    L26:
        if (r11 != r0) goto L38;
        return r0;
    L18:
        e = move-exception;
        if (r4.a() == false) goto L22;
        Continuation r8 = (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L16
        r8.resumeWith(Result.m1421constructorimpl(BundleExtKt.setErr(new Bundle(), 102, e.getMessage())));     // Catch: Throwable -> L16
    L22:
        r13 = r12.asBinder();     // Catch: CancellationException -> L31
        r7 = (IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(new AutoTestManager$sam$android_os_IBinder_DeathRecipient$0(r5), IBinder.DeathRecipient.class, "com.obric.memorydata.plugin");     // Catch: CancellationException -> L31
    L16:
        th = move-exception;
        r12.asBinder().unlinkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(new AutoTestManager$sam$android_os_IBinder_DeathRecipient$0(r5), IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"), 0);     // Catch: CancellationException -> L31
        throw th;     // Catch: CancellationException -> L31
    L31:
        e = move-exception;
        AIKLog.INSTANCE.d("AutoTestManager", "callAutoTestlAsResponse error: " + e.getMessage());
        return (Bundle) ZeusTransformUtils.preCheckCast(null, Bundle.class, "com.obric.memorydata.plugin");
    }
}
