package com.obric.assistant.ipc;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.home.api.main.IPrivacyService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.voice.c;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraConnectState;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraSwitchState;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraWearState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ipc.HostStateSyncManager$startCollectCoWakeupEvent$1", f = "HostStateSyncManager.kt", i = {}, l = {307, 314}, m = "invokeSuspend", n = {}, s = {})
final class HostStateSyncManager$startCollectCoWakeupEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public static final class a<T> implements FlowCollector {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v4 */
        public final Object emit(Object r9, Continuation r10) {
            vha.a r11 = (vha.a) r9;
            if ((r11 instanceof vha.a.C0032a) == false) goto L53;
            vha.a.C0032a r12 = (vha.a.C0032a) r11;
            HostStateSyncManager.a.getClass();
            DoraSwitchState r13 = r12.a;
            DoraConnectState r0 = r12.b;
            DoraWearState r14 = r12.c;
            IPrivacyService r1 = (IPrivacyService) ServiceManager.get().getService(IPrivacyService.class);
            ?? r2 = 0;
            r2 = 0;
            if (r1 != null) goto L7;
        L9:
            boolean r3 = false;
        L10:
            if (r3 == false) goto L14;
            IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r4 == null) goto L14;
            DeviceService r5 = r4.device();
        L15:
            if (r5 != null) goto L17;
        L19:
            boolean r6 = false;
        L20:
            if (r5 != null) goto L22;
        L24:
            boolean r7 = false;
        L25:
            if (r7 == true) goto L27;
        L35:
            boolean r8 = false;
        L37:
            if (r0 != DoraConnectState.CONNECTED) goto L51;
            if (r6 == true) goto L47;
            if (r7 == false) goto L46;
            if (r13 != DoraSwitchState.ON) goto L48;
            if (r8 == true) goto L47;
        L48:
            boolean r15 = false;
        L49:
            if (r15 == false) goto L51;
            r2 = 1;
            goto L51
        L46:
            if (r13 != DoraSwitchState.ON) goto L48;
        L47:
            r15 = true;
        L51:
            FLogger.a.i("HostStateSyncManager", "handleDoraWakeupEvent connect=" + r0 + " switch=" + r13 + " wear=" + r14 + " isH=" + r6 + " isDoraG=" + r7 + " isDoraGWearOn=" + r8 + " suppress=" + r2);
            IpcMessenger.j(IpcMessenger.a, 5, r2, c.b);
            goto L53
        L27:
            if (r14 == DoraWearState.ON) goto L34;
            if (r5 != null) goto L30;
        L32:
            boolean r16 = false;
        L33:
            if (r16 == false) goto L35;
        L30:
            if (r5.S() != true) goto L32;
            r16 = true;
        L34:
            r8 = true;
            goto L37
        L22:
            if (r5.M() != true) goto L24;
            r7 = true;
            goto L25
        L17:
            if (r5.f() != true) goto L19;
            r6 = true;
        L14:
            r5 = null;
            goto L15
        L7:
            if (r1.a() != true) goto L9;
            r3 = true;
        L53:
            return Unit.INSTANCE;
        }
    }

    public HostStateSyncManager$startCollectCoWakeupEvent$1(Continuation<? super HostStateSyncManager$startCollectCoWakeupEvent$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new HostStateSyncManager$startCollectCoWakeupEvent$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L7;
        ResultKt.throwOnFailure(r7);
    L23:
        throw new KotlinNothingValueException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L15:
        CoWakeupApi r8 = uha.a.a();
    L16:
        if (r8 != null) goto L19;
        FLogger.a.e("HostStateSyncManager", "coWakeupApiDelegate is still null after retry, skip collect");
        return Unit.INSTANCE;
    L19:
        MutableSharedFlow r9 = r8.d();
        FlowCollector r2 = a.a;
        this.label = 2;
        if (r9.collect(r2, this) != r0) goto L23;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        r8 = uha.a.a();
        if (r8 != null) goto L16;
        FLogger.a.w("HostStateSyncManager", "coWakeupApiDelegate is null, will retry after 500ms");
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L15;
        return r0;
    }
}
