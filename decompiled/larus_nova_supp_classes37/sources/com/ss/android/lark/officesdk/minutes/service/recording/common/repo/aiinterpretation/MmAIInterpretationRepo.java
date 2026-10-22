package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.MmAudioSaveType;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmAIInterpretationRepo extends MviRepository<d, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a, i> {
    public static final /* synthetic */ int r = 0;
    public final f j;
    public final b k;
    public final KVRepo l;
    public final Function0<MmRecordingSource> m;
    public final String n;
    public MmAudioSaveType o;
    public Long p;
    public final Lazy q;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final d a() {
        return new d(0);
    }

    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a n() {
        return (com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.a) this.q.getValue();
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.foundation.mvi.repo.MviRepository
    public final String c() {
        return this.n;
    }

    public final Object m(Continuation<? super Unit> r3) {
        lvb.a.e(this.n, "[clearLocalStateForRecordingEnd]");
        MmAIInterpretationRepo$clearLocalStateForRecordingEnd$2 r0 = new MmAIInterpretationRepo$clearLocalStateForRecordingEnd$2(this, null);
        Object r4 = this.e.b(r0, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    public static final void l(MmAIInterpretationRepo r3, g r4) {
        r3.l.putString("minutes_ai_interpretation_last_selected_language", r4.a);
        lvb.a.e(r3.n, "[saveSelectedLanguage] language=" + r4.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v6, types: [android.content.BroadcastReceiver, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.MmAudioRouteDetector$registerVolumeReceiver$1] */
    public MmAIInterpretationRepo(RustMmAIInterpretationGateway r8, b r9, KVRepo r10, Function0 r11) {
        Intrinsics.checkNotNullParameter(r8, "gateway");
        Intrinsics.checkNotNullParameter(r9, "audioController");
        Intrinsics.checkNotNullParameter(r10, "kvRepo");
        Intrinsics.checkNotNullParameter(r11, "recordingSourceProvider");
        this.j = r8;
        this.k = r9;
        this.l = r10;
        this.m = r11;
        this.n = "MmAIInterpretationRepo";
        this.o = MmAudioSaveType.SAVE;
        this.q = LazyKt.lazy(new MmAIInterpretationRepo$opt$2(this));
        lvb.a.e("MmAIInterpretationAudioController", "[start]");
        final q r12 = r9.b;
        if (r12.g != null) goto L36;
        ?? r13 = new MmAudioRouteDetector$registerVolumeReceiver$1(r12);
        r12.g = r13;
        Context r14 = r12.d;
        IntentFilter r15 = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L46;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L46:
    L31:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L44;
        ReceiverRegisterCrashOptimizer.registerReceiver(r13, r15);
        goto L36
    L44:
        throw e;
    L9:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r15) == false) goto L22;
        int r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r13, r15, 0, null, null, 2, r14).result;     // Catch: Exception -> L31
        if (r0 != 1) goto L15;
        r14.registerReceiver(r13, r15);     // Catch: Exception -> L31
    L45:
        goto L36
    L15:
        if (r0 != 2) goto L17;
        new Intent();     // Catch: Exception -> L31
        goto L45
    L17:
        if (r0 == 3) goto L45;
        r14.registerReceiver(r13, r15);     // Catch: Exception -> L31
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L25;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L31
        r14.registerReceiver(r13, r15, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L31
        goto L45
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L27;
    L29:
        r14.registerReceiver(r13, r15);     // Catch: Exception -> L31
        goto L45
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r15) == false) goto L29;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L31
        ContextCompat.registerReceiver(r14, r13, r15, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L31
    L36:
        if (Build.VERSION.SDK_INT >= 23) goto L38;
        return;
    L38:
        if (r12.e != null) goto L40;
        return;
    L40:
        if (r12.f != null) goto L50;
        r r16 = new r(r12);
        r12.f = r16;
        r12.e.registerAudioDeviceCallback(r16, r12.a);
        return;
    }
}
