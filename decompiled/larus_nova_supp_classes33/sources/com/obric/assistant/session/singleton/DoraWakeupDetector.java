package com.obric.assistant.session.singleton;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.task.asr.AsrLifeState;
import com.larus.audio.audiov3.task.asr.AsrResultValue;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.chat.ObricChatContextServiceDelegate;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.session.endpoint.DoraSessionEndpoint;
import com.obric.assistant.session.model.IDoraOperation;
import com.obric.assistant.spi.dora.IDoraWakeupService;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraConnectState;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class DoraWakeupDetector implements com.larus.bmhome.chat.component.bottom.core.speaker.b {
    public static final DoraWakeupDetector a = null;
    public static volatile a b;
    public static boolean c;
    public static boolean d;
    public static boolean e;
    public static boolean f;
    public static boolean g;
    public static final AtomicBoolean h = null;
    public static WeakReference<com.larus.bmhome.chat.component.bottom.core.speaker.l> i;
    public static final CoroutineScope j = null;
    public static Job k;
    public static Job l;
    public static Job m;
    public static Job n;
    public static final DoraWakeupDetector$ttsObserver$1 o = null;

    /* JADX INFO: renamed from: com.obric.assistant.session.singleton.DoraWakeupDetector$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.session.singleton.DoraWakeupDetector$1", f = "DoraWakeupDetector.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.obric.assistant.session.singleton.DoraWakeupDetector$1$a */
        public static final class a<T> implements FlowCollector {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final Object emit(Object r4, Continuation r5) {
                vha.a.a r6 = (vha.a) r4;
                FLogger r7 = FLogger.a;
                r7.i("DoraWakeupDetector", "RECV DORA CHANGED ----->  " + r6);
                DoraConnectState r2 = null;
                if ((r6 instanceof vha.a.a) == false) goto L5;
                vha.a.a r8 = r6;
            L6:
                if (r8 == null) goto L9;
                r2 = r8.b;
            L9:
                if (r2 != DoraConnectState.NOT_CONNECTED) goto L16;
                if (DoraWakeupDetector.c == false) goto L13;
            L14:
                r7.i("DoraWakeupDetector", "dora disconnected during radio, cancel dora wakeup");
                DoraWakeupDetector.a.b();
                goto L16
            L13:
                if (DoraWakeupDetector.d == true) goto L14;
            L16:
                return Unit.INSTANCE;
            L5:
                r8 = null;
                goto L6
            }
        }

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

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            ResultKt.throwOnFailure(r4);
        L16:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            CoWakeupApi r5 = uha.a.a();
            if (r5 == null) goto L18;
            MutableSharedFlow r6 = r5.d();
            if (r6 == null) goto L18;
            FlowCollector r2 = a.a;
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L16;
            return r0;
        L18:
            return Unit.INSTANCE;
        }
    }

    public interface a {
        void a();

        void i(Bundle r1);
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IDoraWakeupService.WakeupType.values().length];
            r0[IDoraWakeupService.WakeupType.VOICE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[IDoraWakeupService.WakeupType.SILENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[IDoraWakeupService.WakeupType.KEY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[IDoraWakeupService.WakeupType.RADIO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public DoraWakeupDetector() {
    }

    static {
        a = new DoraWakeupDetector();
        f = true;
        h = new AtomicBoolean(false);
        j = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new AnonymousClass1(null), 3, null);
        o = DoraWakeupDetector$ttsObserver$1.a;
    }

    public static boolean d() {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L9;
        DeviceService r1 = r0.device();
        if (r1 == null) goto L9;
        if (r1.n0("ota3p5") != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static void f() {
        if (c == false) goto L5;
        return;
    L5:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraWakeupDetector$stopVUI$1(null), 3, null);
    }

    public static void g() {
        FLogger.a.e("DoraWakeupDetector", "stopVUIWhenTimeout");
        Job r0 = m;
        if (r0 != null) goto L5;
    L10:
        m = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new DoraWakeupDetector$stopVUIWhenTimeout$2(null), 3, null);
        return;
    L5:
        if (r0.isActive() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        goto L10
    }

    public static void h() {
        ObricChatContextServiceDelegate r0 = ObricChatContextServiceDelegate.b;
        FragmentActivity r1 = AppHost.a.a().getCurrentActivity();
        com.obric.audio.continuous_talk.c r3 = null;
        if ((r1 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r2 = r1;
    L6:
        t1a.b r4 = r0.b(r2);
        if (r4 == null) goto L9;
        r3 = (com.obric.audio.continuous_talk.c) r4.getAbility(com.obric.audio.continuous_talk.c.class);
    L9:
        com.obric.audio.continuous_talk.c r5 = r3;
        FLogger.a.i("DoraWakeupDetector", "try close obricContinuousTalk: talkCtrlAbility = " + r5);
        if (r5 == null) goto L13;
        com.obric.audio.continuous_talk.c.a.a(r5, null, null, true, true, 3);
        return;
    L13:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void b() {
        FLogger.a.i("DoraWakeupDetector", WindowEvent.WindowOpenPerfResult.CANCEL);
        if (d == false) goto L16;
        IDoraOperation r0 = bga.f.a();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L16;
        Job r2 = k;
        if (r2 == null) goto L14;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L14:
        d = false;
        k = BuildersKt.launch$default(j, null, null, new DoraWakeupDetector$cancel$1(null), 3, null);
        goto L16
    L7:
        if (r0.c() != true) goto L9;
        r1 = true;
    L16:
        if (c == false) goto L28;
        IDoraOperation r3 = bga.f.a();
        if (r3 != null) goto L20;
    L22:
        boolean r4 = false;
    L23:
        if (r4 == false) goto L28;
        Job r5 = l;
        if (r5 == null) goto L27;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L27:
        c = false;
        l = BuildersKt.launch$default(j, null, null, new DoraWakeupDetector$cancel$2(null), 3, null);
        goto L28
    L20:
        if (r3.c() != true) goto L22;
        r4 = true;
    L28:
        c = false;
        d = false;
        AudioServiceDelegate.a.i0().cancel("Dora single click cancel", true);
        i();
    }

    public final void i() {
        WeakReference<com.larus.bmhome.chat.component.bottom.core.speaker.l> r0 = i;
        if (r0 == null) goto L5;
        com.larus.bmhome.chat.component.bottom.core.speaker.l r1 = r0.get();
    L6:
        i = null;
        FLogger.a.i("DoraWakeupDetector", "unregisterAsrListener, registeredSpeaker: " + r1);
        if (r1 == null) goto L10;
        r1.K8(this);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static a c(String r6) {
        a r0 = b;
        if (r0 == null) goto L6;
        FLogger.a.i("DoraWakeupDetector", "getActionListener from=" + r6 + ", use registered listener=" + r0 + ", identity=" + System.identityHashCode(r0));
        return r0;
    L6:
        IDoraOperation r1 = bga.f.a();
        if (r1 == null) goto L9;
        DoraSessionEndpoint r2 = r1.action();
    L10:
        if (r2 != null) goto L13;
        FLogger.a.e("DoraWakeupDetector", "getActionListener from=" + r6 + " failed, listener and dora action are null");
        return null;
    L13:
        FLogger.a.w("DoraWakeupDetector", "getActionListener from=" + r6 + " recover listener by doraOperationDelegate, action=" + r2 + ", identity=" + System.identityHashCode(r2));
        e(r2);
        return r2;
    L9:
        r2 = null;
        goto L10
    }

    public static void e(a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        FLogger.a.i("DoraWakeupDetector", "setActionListener: " + r3 + ", identity=" + System.identityHashCode(r3));
        b = r3;
    }

    public final void a(y58.b r2) {
        Intrinsics.checkNotNullParameter(r2, WindowEvent.Params.RESULT);
    }

    public final void q(AsrLifeState r4, String r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r4, "lifeState");
        FLogger r0 = FLogger.a;
        r0.i("DoraWakeupDetector", "onLifeStateChanged lifeState: " + r4 + ", taskId: " + r5 + ", extraMap: " + r6);
        if (r4 != AsrLifeState.ASR_RESULT) goto L26;
        String r7 = null;
        if (r6 == null) goto L7;
        String r8 = r6.get("res_text");
    L8:
        if (r6 == null) goto L10;
        r7 = r6.get("res_type");
    L10:
        r0.i("DoraWakeupDetector", "onLifeStateChanged result: " + r8 + ", resType: " + r7);
        AsrResultValue r9 = AsrResultValue.FINAL_ASR;
        if (Intrinsics.areEqual(r7, r9.getValue()) == false) goto L21;
        if (r8 != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L21;
        r0.i("DoraWakeupDetector", "onLifeStateChanged final asr is empty, stop VUI");
        f();
        i();
        return;
    L14:
        if (r8.length() == 0) goto L17;
        r2 = false;
    L21:
        if (Intrinsics.areEqual(r7, r9.getValue()) == true) goto L23;
        return;
    L23:
        if (o0.d(r8) == false) goto L31;
        r0.i("DoraWakeupDetector", "onLifeStateChanged final asr is not empty, unregister");
        i();
        return;
    L31:
        return;
    L7:
        r8 = null;
        goto L8
    L26:
        if (r4 != AsrLifeState.ASR_ERROR) goto L33;
        r0.i("DoraWakeupDetector", "onLifeStateChanged asr error, stop VUI");
        f();
        i();
        return;
    }
}
