package com.obric.audio.enroll.recorder;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.ui.VoicePrintEnrollActivity;
import com.obric.audio.enroll.vm.EnrollViewModel;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import f06.c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import me.ele.lancet.base.annotations.Skip;
import qia.d;
import qia.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class VoicePrintEnrollRecordingsMgr {
    public Context a;
    public final EnrollViewModel b;
    public volatile boolean c;
    public AudioRecord d;
    public int e;
    public volatile int f;
    public final ExecutorService g;
    public Future<?> h;
    public volatile boolean i;
    public final CoroutineScope j;
    public final BluetoothScoController k;

    public final class BluetoothScoController {
        public Job a;
        public volatile boolean b;
        public volatile boolean c;
        public volatile boolean d;
        public Integer e;
        public VoicePrintEnrollRecordingsMgr$BluetoothScoController$ensureScoStateReceiverRegistered$receiver$1 f;
        public boolean g;
        public CompletableDeferred<Boolean> h;
        public volatile long i;
        public final /* synthetic */ VoicePrintEnrollRecordingsMgr j;

        public final AudioManager b() {
            Context r0 = this.j.getContext();
            if (r0 == null) goto L11;
            Context r1 = r0.getApplicationContext();
            if (r1 == null) goto L13;
            Object r2 = r1.getSystemService("audio");
            if ((r2 instanceof AudioManager) == true) goto L10;
            return null;
        L10:
            return (AudioManager) r2;
        L13:
            return null;
        L11:
            return null;
        }

        public final void c() {
            if (this.b == true) goto L6;
            FLogger.a.i("VoicePrintEnrollRecordingsMgr", "sco: scheduleStopIfActive ignored (scoActive=false)");
            return;
        L6:
            Job r0 = this.a;
            if (r0 == null) goto L9;
            Job.DefaultImpls.cancel$default(r0, null, 1, null);
        L9:
            FLogger.a.i("VoicePrintEnrollRecordingsMgr", "sco: scheduleStopIfActive in 10000ms");
            this.a = BuildersKt.launch$default(this.j.j, null, null, new VoicePrintEnrollRecordingsMgr$BluetoothScoController$scheduleStopIfActive$1(this, null), 3, null);
        }

        public final void g() {
            FLogger.a.i("VoicePrintEnrollRecordingsMgr", "sco: stopNowIfActive");
            Job r0 = this.a;
            if (r0 == null) goto L5;
            Job.DefaultImpls.cancel$default(r0, null, 1, null);
        L5:
            this.a = null;
            f(b());
        }

        public BluetoothScoController(VoicePrintEnrollRecordingsMgr r1) {
            this.j = r1;
        }

        /* JADX WARN: Type inference failed for: r8v4, types: [com.obric.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr$BluetoothScoController$ensureScoStateReceiverRegistered$receiver$1] */
        public final Object d(Continuation<? super Boolean> r13) {
            if ((r13 instanceof VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$1) == false) goto L7;
            VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$1 r0 = (VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$1) r13;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r14 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L18;
            if (r3 == 1) goto L17;
            if (r3 == 2) goto L16;
            if (r3 != 3) goto L15;
            long r4 = r0.J$0;
            AudioManager r5 = (AudioManager) r0.L$0;
            ResultKt.throwOnFailure(r14);
        L76:
            boolean r15 = ((Boolean) r14).booleanValue();
            long r8 = r4;
            AudioManager r6 = r5;
        L77:
            long r7 = SystemClock.elapsedRealtime() - r8;
            FLogger.a.i("VoicePrintEnrollRecordingsMgr", "sco: startAndWaitConnected result=" + r15 + " cost=" + r7 + "ms");
            this.b = r15;
            if (r15 == true) goto L81;
            f(r6);
        L81:
            return Boxing.boxBoolean(r15);
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            r8 = r0.J$0;
            r6 = (AudioManager) r0.L$0;
            ResultKt.throwOnFailure(r14);
        L72:
            r0.L$0 = r6;
            r0.J$0 = r8;
            r0.label = 3;
            r14 = e(this, r6, true, r0);
            if (r14 != r2) goto L75;
            return r2;
        L75:
            r5 = r6;
            r4 = r8;
            goto L76
        L17:
            r8 = r0.J$0;
            r6 = (AudioManager) r0.L$0;
            ResultKt.throwOnFailure(r14);
        L59:
            r15 = ((Boolean) r14).booleanValue();
            if (r15 == true) goto L77;
            Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L63
            r6.stopBluetoothSco();     // Catch: Throwable -> L63
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L63
        L88:
            r6.setBluetoothScoOn(false);     // Catch: Throwable -> L67
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L67
        L69:
            r0.L$0 = r6;
            r0.J$0 = r8;
            r0.label = 2;
            if (DelayKt.delay(200, r0) != r2) goto L72;
            return r2;
        L67:
            th = move-exception;
            Result.Companion r9 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L63:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L88
        L18:
            ResultKt.throwOnFailure(r14);
            Job r17 = this.a;
            if (r17 == null) goto L21;
            Job.DefaultImpls.cancel$default(r17, null, 1, null);
        L21:
            Context r18 = this.j.getContext();
            if (r18 == null) goto L82;
            Context r19 = r18.getApplicationContext();
            if (r19 == null) goto L82;
            r6 = b();
            if (r6 != null) goto L31;
            FLogger.a.e("VoicePrintEnrollRecordingsMgr", "sco: startAndWaitConnected false (AudioManager null)");
            return Boxing.boxBoolean(false);
        L31:
            if (this.b == false) goto L37;
            if (r6.isBluetoothScoOn() == false) goto L37;
            FLogger.a.i("VoicePrintEnrollRecordingsMgr", "sco: startAndWaitConnected fast-path (scoActive && isBluetoothScoOn)");
            return Boxing.boxBoolean(true);
        L37:
            if (this.g == true) goto L52;
            FLogger.a.i("VoicePrintEnrollRecordingsMgr", "sco: register receiver ACTION_SCO_AUDIO_STATE_UPDATED");
            final VoicePrintEnrollRecordingsMgr r11 = this.j;
            ?? r12 = new VoicePrintEnrollRecordingsMgr$BluetoothScoController$ensureScoStateReceiverRegistered$receiver$1(this, r11);
            Result.Companion r20 = Result.Companion;     // Catch: Throwable -> L42
            a(r19, r12, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));     // Catch: Throwable -> L42
            Object r110 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L42
        L44:
            Throwable r21 = Result.exceptionOrNull-impl(r110);
            if (r21 == null) goto L48;
            FLogger.a.e("VoicePrintEnrollRecordingsMgr", "registerReceiver ACTION_SCO_AUDIO_STATE_UPDATED failed: " + r21.getMessage());
            r110 = Boolean.FALSE;
        L48:
            boolean r111 = ((Boolean) r110).booleanValue();
            this.g = r111;
            if (r111 == true) goto L51;
            FLogger.a.e("VoicePrintEnrollRecordingsMgr", "sco: register receiver failed");
            boolean r112 = false;
        L53:
            if (r112 == true) goto L56;
            FLogger.a.e("VoicePrintEnrollRecordingsMgr", "sco: startAndWaitConnected false (register receiver failed)");
            return Boxing.boxBoolean(false);
        L56:
            r8 = SystemClock.elapsedRealtime();
            r0.L$0 = r6;
            r0.J$0 = r8;
            r0.label = 1;
            r14 = e(this, r6, false, r0);
            if (r14 != r2) goto L59;
            return r2;
        L51:
            FLogger.a.i("VoicePrintEnrollRecordingsMgr", "sco: receiver registered");
            this.f = r12;
        L42:
            th = move-exception;
            Result.Companion r22 = Result.Companion;
            r110 = Result.constructor-impl(ResultKt.createFailure(th));
        L52:
            r112 = true;
        L82:
            FLogger.a.e("VoicePrintEnrollRecordingsMgr", "sco: startAndWaitConnected false (appContext null)");
            return Boxing.boxBoolean(false);
        L7:
            r0 = new VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$1(this, r13);
            goto L8
        }

        public final void f(AudioManager r6) {
            if (r6 != null) goto L6;
            FLogger.a.e("VoicePrintEnrollRecordingsMgr", "sco: stopNow ignored (AudioManager null)");
            return;
        L6:
            this.c = true;
            CompletableDeferred<Boolean> r1 = this.h;
            if (r1 != null) goto L9;
        L11:
            this.h = null;
            FLogger.a.i("VoicePrintEnrollRecordingsMgr", "sco: stopNow begin currentMode=" + r6.getMode() + " prevMode=" + this.e);
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
            r6.stopBluetoothSco();     // Catch: Throwable -> L14
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
        L33:
            r6.setBluetoothScoOn(false);     // Catch: Throwable -> L19
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
        L21:
            Integer r3 = this.e;
            this.e = null;
            if (r3 == null) goto L25;
            r6.setMode(r3.intValue());     // Catch: Throwable -> L29
        L27:
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L29
        L31:
            FLogger.a.i("VoicePrintEnrollRecordingsMgr", "sco: stopNow end restoredMode=" + r6.getMode());
            this.b = false;
            this.c = false;
            return;
        L25:
            if (r6.getMode() != 3) goto L27;
            r6.setMode(0);     // Catch: Throwable -> L29
        L29:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L19:
            th = move-exception;
            Result.Companion r5 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        L14:
            th = move-exception;
            Result.Companion r7 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L33
        L9:
            if (r1.isCompleted() == true) goto L11;
            r1.complete(Boolean.FALSE);
            goto L11
        }

        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
        public static void a(Context r8, VoicePrintEnrollRecordingsMgr$BluetoothScoController$ensureScoStateReceiverRegistered$receiver$1 r9, IntentFilter r10) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L39:
        L33:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
            ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
            return;
        L38:
            throw e;
        L6:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L22;
            int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8).result;     // Catch: Exception -> L33
            if (r0 != 1) goto L12;
            r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
            return;
        L12:
            if (r0 != 2) goto L14;
            new Intent();     // Catch: Exception -> L33
            return;
        L14:
            if (r0 == 3) goto L40;
            r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
            return;
        L40:
            return;
        L22:
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
            ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
            r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
            return;
        L26:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
        L31:
            r8.registerReceiver(r9, r10);     // Catch: Exception -> L33
            return;
        L28:
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L31;
            ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
            ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
        }

        public static final Object e(BluetoothScoController r14, AudioManager r15, boolean r16, Continuation<? super Boolean> r17) {
            BluetoothScoController r1 = r14;
            if ((r17 instanceof VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$1) == false) goto L7;
            VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$1 r6 = (VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$1) r17;
            int r7 = r6.label;
            if ((r7 & Integer.MIN_VALUE) == 0) goto L7;
            r6.label = r7 - Integer.MIN_VALUE;
        L8:
            Object r2 = r6.result;
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r9 = r6.label;
            if (r9 == 0) goto L16;
            if (r9 != 1) goto L15;
            r1 = (BluetoothScoController) r6.L$0;
            ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L40
        L38:
            boolean r10 = ((Boolean) r2).booleanValue();     // Catch: Throwable -> L40
            r1.i = 0;
            r1.h = null;
        L44:
            return Boxing.boxBoolean(r10);
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r2);
            CompletableDeferred<Boolean> r3 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            r1.h = r3;
            r1.i = SystemClock.elapsedRealtime();     // Catch: Throwable -> L40
            Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L30
            if (r16 == true) goto L21;
        L24:
            FLogger r12 = FLogger.a;     // Catch: Throwable -> L30
            StringBuilder r13 = new StringBuilder("sco: startBluetoothSco begin useCommunicationMode=");     // Catch: Throwable -> L30
            if (r16 == false) goto L27;
            boolean r4 = true;
        L28:
            r13.append(r4);     // Catch: Throwable -> L30
            r13.append(" prevMode=");     // Catch: Throwable -> L30
            r13.append(r1.e);     // Catch: Throwable -> L30
            r13.append(" currentMode=");     // Catch: Throwable -> L30
            r13.append(r15.getMode());     // Catch: Throwable -> L30
            r12.i("VoicePrintEnrollRecordingsMgr", r13.toString());     // Catch: Throwable -> L30
            r15.startBluetoothSco();     // Catch: Throwable -> L30
            r15.setBluetoothScoOn(true);     // Catch: Throwable -> L30
            Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L30
        L32:
            Throwable r5 = Result.exceptionOrNull-impl(r0);     // Catch: Throwable -> L40
            if (r5 == null) goto L35;
            FLogger.a.e("VoicePrintEnrollRecordingsMgr", "sco: startBluetoothSco threw " + r5.getMessage());     // Catch: Throwable -> L40
        L35:
            VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$4 r18 = new VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$4(r3, null);     // Catch: Throwable -> L40
            r6.L$0 = r1;     // Catch: Throwable -> L40
            r6.label = 1;     // Catch: Throwable -> L40
            r2 = TimeoutKt.b(2500, r18, r6);     // Catch: Throwable -> L40
            if (r2 != r8) goto L38;
            return r8;
        L27:
            r4 = false;
            goto L28
        L21:
            if (r1.e != null) goto L23;
            r1.e = Boxing.boxInt(r15.getMode());     // Catch: Throwable -> L30
        L23:
            r15.setMode(3);     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L40
            r0 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L40
        L40:
            th = move-exception;
            FLogger.a.e("VoicePrintEnrollRecordingsMgr", "sco: wait connected failed: " + th.getMessage());     // Catch: Throwable -> L45
            r1.i = 0;
            r1.h = null;
            r10 = false;
        L45:
            th = move-exception;
            r1.i = 0;
            r1.h = null;
            throw th;
        L7:
            r6 = new VoicePrintEnrollRecordingsMgr$BluetoothScoController$startAndWaitConnected$attemptConnect$1(r17);
            goto L8
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/audio/enroll/recorder/VoicePrintEnrollRecordingsMgr$ScoPrecheck;", "", "<init>", "(Ljava/lang/String;I)V", "OK", "AUDIO_MANAGER_NULL", "NOT_SUPPORTED_OFF_CALL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScoPrecheck extends Enum<ScoPrecheck> {
        public static final ScoPrecheck AUDIO_MANAGER_NULL = null;
        public static final ScoPrecheck NOT_SUPPORTED_OFF_CALL = null;
        public static final ScoPrecheck OK = null;
        public static final /* synthetic */ ScoPrecheck[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ScoPrecheck> getEntries() {
            return b;
        }

        static {
            ScoPrecheck r0 = new ScoPrecheck("OK", 0);
            OK = r0;
            ScoPrecheck r1 = new ScoPrecheck("AUDIO_MANAGER_NULL", 1);
            AUDIO_MANAGER_NULL = r1;
            ScoPrecheck r3 = new ScoPrecheck("NOT_SUPPORTED_OFF_CALL", 2);
            NOT_SUPPORTED_OFF_CALL = r3;
            ScoPrecheck[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ScoPrecheck[] values() {
            return (ScoPrecheck[]) a.clone();
        }

        public static ScoPrecheck valueOf(String r1) {
            return (ScoPrecheck) r27.a.a(ScoPrecheck.class, r1);
        }

        public ScoPrecheck(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    public final void c() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate())), null, null, new VoicePrintEnrollRecordingsMgr$stop$1(this, null), 3, null);
    }

    public final Context getContext() {
        return this.a;
    }

    public static void a(AudioRecord r12) {
        c r8 = new c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        if (r8.b(100403, "android/media/AudioRecord", "release", r12, r9, "void", r10).a == false) goto L6;
        r8.a(100403, "android/media/AudioRecord", "release", r12, r9, null, r10, false);
        return;
    L6:
        r12.release();
        r8.a(100403, "android/media/AudioRecord", "release", r12, r9, null, r10, true);
    }

    public final Object b(Continuation<? super Unit> r22) {
        if ((r22 instanceof VoicePrintEnrollRecordingsMgr$startRecording$1) == false) goto L7;
        VoicePrintEnrollRecordingsMgr$startRecording$1 r2 = (VoicePrintEnrollRecordingsMgr$startRecording$1) r22;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L22;
        if (r5 == 1) goto L21;
        if (r5 == 2) goto L20;
        if (r5 == 3) goto L19;
        if (r5 == 4) goto L18;
        if (r5 != 5) goto L17;
        ResultKt.throwOnFailure(r0);
    L103:
        this.h = this.g.submit(new b(this));
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        int r6 = r2.I$0;
        ResultKt.throwOnFailure(r0);
    L100:
        MutableSharedFlow<com.obric.audio.enroll.recorder.a> r1 = this.b.getRecordingEvent();
        com.obric.audio.enroll.recorder.a r7 = new com.obric.audio.enroll.recorder.a(r6, RecordState.START);
        r2.label = 5;
        if (r1.emit(r7, r2) != r4) goto L103;
        return r4;
    L19:
        r6 = r2.I$2;
        int r8 = r2.I$1;
        int r9 = r2.I$0;
        ResultKt.throwOnFailure(r0);
    L82:
        boolean r10 = ((Boolean) r0).booleanValue();
        FLogger r11 = FLogger.a;
        r11.i("VoicePrintEnrollRecordingsMgr", "startRecording: startAndWaitConnected=" + r10);
        if (r10 == true) goto L86;
        r11.e("VoicePrintEnrollRecordingsMgr", "startRecording: startAndWaitConnected=false, report BluetoothScoNotSupported");
        this.c = false;
        this.b.reportEvent(d.a);
        return Unit.INSTANCE;
    L86:
        int r17 = r8;
        int r16 = r9;
    L88:
        AudioRecord r12 = new AudioRecord(6, 16000, r16, r17, this.e);
        this.d = r12;
        if (r12.getState() == 1) goto L97;
        FLogger.a.e("VoicePrintEnrollRecordingsMgr", "startTrainingRecording: AudioRecord initialize failed");
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L93
        a(r12);     // Catch: Throwable -> L93
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L93
    L95:
        this.d = null;
        this.c = false;
        this.k.c();
        return Unit.INSTANCE;
    L93:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L95
    L97:
        this.i = false;
        Job r15 = BuildersKt.launch$default(this.j, null, null, new VoicePrintEnrollRecordingsMgr$startRecording$7(this, null), 3, null);
        r2.I$0 = r6;
        r2.label = 4;
        if (r15.join(r2) != r4) goto L100;
        return r4;
    L20:
        int r18 = r2.I$1;
        int r19 = r2.I$0;
        ResultKt.throwOnFailure(r0);
        r9 = r19;
        int r20 = r18;
    L105:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L53
        Future<?> r23 = this.h;     // Catch: Throwable -> L53
        if (r23 == null) goto L50;
        Boolean r24 = Boxing.boxBoolean(r23.cancel(true));     // Catch: Throwable -> L53
    L51:
        Object r25 = Result.constructor-impl(r24);     // Catch: Throwable -> L53
    L56:
        if (Result.isSuccess-impl(r25) == false) goto L59;
        Boolean r26 = (Boolean) r25;
        FLogger.a.i("VoicePrintEnrollRecordingsMgr", "startRecording: cancel recordingJob");
    L59:
        if (Result.exceptionOrNull-impl(r25) == null) goto L61;
        FLogger.a.i("VoicePrintEnrollRecordingsMgr", "startRecording: cancel recordingJob failed");
    L61:
        this.c = true;
        int r27 = ((Number) this.b.getEnrollIndex().getValue()).intValue();
        FLogger r28 = FLogger.a;
        r28.i("VoicePrintEnrollRecordingsMgr", "startRecording: index=" + r27 + " enrollDeviceType=" + this.b.getEnrollDeviceType());
        if (this.b.getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.THIRD_PARTY_BT) goto L87;
        AudioManager r110 = this.k.b();
        if (r110 != null) goto L67;
        r28.e("VoicePrintEnrollRecordingsMgr", "sco: shouldStartSco false (AudioManager null)");
        ScoPrecheck r111 = ScoPrecheck.AUDIO_MANAGER_NULL;
    L70:
        r28.i("VoicePrintEnrollRecordingsMgr", "startRecording: scoPrecheck=" + r111);
        if (r111 == ScoPrecheck.OK) goto L78;
        this.c = false;
        EnrollViewModel r29 = this.b;
        if (r111 != ScoPrecheck.NOT_SUPPORTED_OFF_CALL) goto L75;
        e r30 = d.a;
    L76:
        r29.reportEvent(r30);
        return Unit.INSTANCE;
    L75:
        r30 = qia.c.a;
        goto L76
    L78:
        BluetoothScoController r31 = this.k;
        r2.I$0 = r9;
        r2.I$1 = r20;
        r2.I$2 = r27;
        r2.label = 3;
        Object r32 = r31.d(r2);
        if (r32 != r4) goto L81;
        return r4;
    L81:
        r8 = r20;
        r6 = r27;
        r0 = r32;
        goto L82
    L67:
        if (r110.isBluetoothScoAvailableOffCall() == true) goto L69;
        r28.i("VoicePrintEnrollRecordingsMgr", "sco: shouldStartSco false (isBluetoothScoAvailableOffCall=false)");
        r111 = ScoPrecheck.NOT_SUPPORTED_OFF_CALL;
        goto L70
    L69:
        r111 = ScoPrecheck.OK;
        goto L70
    L87:
        r17 = r20;
        r16 = r9;
        r6 = r27;
        goto L88
    L50:
        r24 = null;
    L53:
        th = move-exception;
        Result.Companion r33 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L56
    L21:
        ResultKt.throwOnFailure(r0);
    L32:
        return Unit.INSTANCE;
    L22:
        ResultKt.throwOnFailure(r0);
        if (this.c == false) goto L27;
        return Unit.INSTANCE;
    L27:
        if (this.b.getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.DORA_BT) goto L34;
        this.c = true;
        this.i = false;
        int r34 = ((Number) this.b.getEnrollIndex().getValue()).intValue();
        MutableSharedFlow<com.obric.audio.enroll.recorder.a> r35 = this.b.getRecordingEvent();
        com.obric.audio.enroll.recorder.a r36 = new com.obric.audio.enroll.recorder.a(r34, RecordState.START);
        r2.label = 1;
        if (r35.emit(r36, r2) != r4) goto L32;
        return r4;
    L34:
        if (this.b.getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.DEFAULT) goto L36;
        int r37 = 12;
    L37:
        if (r37 != 12) goto L39;
        int r38 = 2;
    L40:
        int r112 = AudioRecord.getMinBufferSize(16000, r37, 2);
        this.f = r38;
        this.e = ((r38 * 1920) * 16) / 8;
        FLogger.a.i("VoicePrintEnrollRecordingsMgr", "startRecording: recorderChannelCount = " + r38 + " minBufferSize = " + r112 + " mTrainingBufferSize = " + this.e);
        if (this.e >= r112) goto L43;
        this.e = r112;
    L43:
        Job r39 = BuildersKt.launch$default(this.j, null, null, new VoicePrintEnrollRecordingsMgr$startRecording$2(this, null), 3, null);
        r2.I$0 = r37;
        r2.I$1 = 2;
        r2.label = 2;
        if (r39.join(r2) != r4) goto L46;
        return r4;
    L46:
        r9 = r37;
        r20 = 2;
        goto L105
    L39:
        r38 = 1;
        goto L40
    L36:
        r37 = 16;
    L7:
        r2 = new VoicePrintEnrollRecordingsMgr$startRecording$1(this, r22);
        goto L8
    }

    public final Object d(Continuation<? super Unit> r14) {
        if ((r14 instanceof VoicePrintEnrollRecordingsMgr$stopRecording$1) == false) goto L7;
        VoicePrintEnrollRecordingsMgr$stopRecording$1 r0 = (VoicePrintEnrollRecordingsMgr$stopRecording$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r15);
    L35:
        Future<?> r16 = this.h;
        if (r16 == null) goto L38;
        Boxing.boxBoolean(r16.cancel(true));
    L38:
        this.c = false;
        this.k.c();
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r15);
    L32:
        int r17 = ((Number) this.b.getEnrollIndex().getValue()).intValue();
        MutableSharedFlow<com.obric.audio.enroll.recorder.a> r4 = this.b.getRecordingEvent();
        com.obric.audio.enroll.recorder.a r5 = new com.obric.audio.enroll.recorder.a(r17, RecordState.STOP);
        r0.label = 3;
        if (r4.emit(r5, r0) != r2) goto L35;
        return r2;
    L17:
        ResultKt.throwOnFailure(r15);
    L27:
        this.c = false;
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r15);
        FLogger.a.i("VoicePrintEnrollRecordingsMgr", "stopRecording..." + this.c);
        if (this.c == true) goto L23;
        return Unit.INSTANCE;
    L23:
        if (this.b.getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.DORA_BT) goto L29;
        this.i = true;
        int r18 = ((Number) this.b.getEnrollIndex().getValue()).intValue();
        MutableSharedFlow<com.obric.audio.enroll.recorder.a> r6 = this.b.getRecordingEvent();
        com.obric.audio.enroll.recorder.a r7 = new com.obric.audio.enroll.recorder.a(r18, RecordState.STOP);
        r0.label = 1;
        if (r6.emit(r7, r0) != r2) goto L27;
        return r2;
    L29:
        this.i = true;
        Job r19 = BuildersKt.launch$default(this.j, null, null, new VoicePrintEnrollRecordingsMgr$stopRecording$2(this, null), 3, null);
        r0.label = 2;
        if (r19.join(r0) != r2) goto L32;
        return r2;
    L7:
        r0 = new VoicePrintEnrollRecordingsMgr$stopRecording$1(this, r14);
        goto L8
    }

    public VoicePrintEnrollRecordingsMgr(Context r2, EnrollViewModel r3) {
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.a = r2;
        this.b = r3;
        this.f = 1;
        this.g = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("VoicePrintEnrollRecordingsMgr"));
        this.j = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.k = new BluetoothScoController(this);
    }
}
