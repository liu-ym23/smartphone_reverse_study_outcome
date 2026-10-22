package com.larus.dora.impl.device.ota;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.activity.ComponentActivity;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.skydoves.balloon.ArrowPositionRules;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import d49.c$e;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAManagement$onOTAFailed$1", f = "DoraOTAManagement.kt", i = {}, l = {1622, 1623, 1624}, m = "invokeSuspend", n = {}, s = {})
final class DoraOTAManagement$onOTAFailed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ int $otaTaskId;
    final /* synthetic */ String $reason;
    final /* synthetic */ z39.a $response;
    int label;

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ota.DoraOTAManagement$onOTAFailed$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAManagement$onOTAFailed$1$1", f = "DoraOTAManagement.kt", i = {}, l = {1630, 1632}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r11);
        L44:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r11);
        L40:
            StateFlowImpl r12 = DoraOTAManagement.e;
            d49.c.a r2 = d49.c.a.a;
            this.label = 2;
            r12.setValue(r2);
            if (Unit.INSTANCE != r0) goto L44;
            return r0;
        L10:
            ResultKt.throwOnFailure(r11);
            ComponentActivity r13 = AppHost.a.a().getCurrentActivity();
            if ((r13 instanceof ComponentActivity) == false) goto L13;
            final ComponentActivity r14 = r13;
        L14:
            if (r14 == null) goto L44;
            if ((r14 instanceof DoraOTAActivity) == true) goto L44;
            if (DoraOTAManagement.H == false) goto L37;
            int r3 = g.a;
            Intrinsics.checkNotNullParameter(r14, "activity");
            Window r4 = r14.getWindow();
            if (r4 == null) goto L33;
            View r5 = r4.getDecorView();
            if (com.larus.home.impl.utils.c.e == false) goto L26;
            FLogger.a.i("DecorViewLancet", "getDecorView");
            Thread r7 = ThreadMethodProxy.currentThread();
            if (r7 == com.larus.home.impl.utils.c.a) goto L26;
            com.larus.home.impl.utils.c.a(r7, "getDecorView");
        L26:
            if (r5 == null) goto L33;
            ViewParent r8 = r5.getParent();
        L29:
            if (r8 == null) goto L34;
            if ((r8 instanceof View) == false) goto L34;
            r5 = r8;
            r8 = r5.getParent();
        L34:
            if (r5 == null) goto L37;
            View r6 = LayoutInflater.from(r14).inflate(2131562251, null);
            e1.d(r6.findViewById(2131369956), new f(r14));
            Balloon.a r9 = new Balloon.a(r14);
            r9.d = 1.0f;
            r9.j(Integer.MIN_VALUE);
            r9.z = 16.0f;
            r9.e(ArrowPositionRules.ALIGN_BALLOON);
            r9.f(0);
            r9.p = 0.5f;
            r9.v = 0;
            r9.g(BalloonAnimation.FADE);
            r9.g0 = false;
            r9.W = r14;
            r9.V = 2000;
            r9.h(true);
            r9.T = true;
            Intrinsics.checkNotNull(r6);
            Intrinsics.checkNotNullParameter(r6, "layout");
            r9.I = r6;
            r9.b().v(r5, 0, 0);
        L33:
            r5 = null;
        L37:
            this.label = 1;
            if (DelayKt.delay(2000, this) != r0) goto L40;
            return r0;
        L13:
            r14 = null;
            goto L14
        }
    }

    public DoraOTAManagement$onOTAFailed$1(int r1, z39.a r2, String r3, DoraDevice r4, Continuation<? super DoraOTAManagement$onOTAFailed$1> r5) {
        this.$otaTaskId = r1;
        this.$response = r2;
        this.$reason = r3;
        this.$device = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraOTAManagement$onOTAFailed$1(this.$otaTaskId, this.$response, this.$reason, this.$device, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r10);
    L22:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
    L18:
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        AnonymousClass1 r2 = new AnonymousClass1(null);
        this.label = 3;
        if (BuildersKt.withContext(r11, r2, this) != r0) goto L22;
        return r0;
    L11:
        ResultKt.throwOnFailure(r10);
    L15:
        MutableSharedFlow r12 = DoraOTAManagement.g;
        int r4 = com.larus.utils.j0.a;
        j0.c r3 = new j0.c(com.larus.utils.j0.d(2131903829));
        this.label = 2;
        if (r12.emit(r3, this) != r0) goto L18;
        return r0;
    L12:
        ResultKt.throwOnFailure(r10);
        StateFlowImpl r13 = DoraOTAManagement.e;
        c$e r5 = new c$e(this.$otaTaskId, this.$response, this.$reason, this.$device.softVersion);
        this.label = 1;
        r13.setValue(r5);
        if (Unit.INSTANCE != r0) goto L15;
        return r0;
    }
}
