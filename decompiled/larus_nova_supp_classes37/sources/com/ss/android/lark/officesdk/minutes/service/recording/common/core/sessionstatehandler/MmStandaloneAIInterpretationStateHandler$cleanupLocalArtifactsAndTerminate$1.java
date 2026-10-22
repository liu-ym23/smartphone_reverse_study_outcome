package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingStatesSyncService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadTask;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.n;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmStandaloneAIInterpretationStateHandler", f = "MmStandaloneAIInterpretationStateHandler.kt", i = {1, 2, 3, 4, 4, 5}, l = {549, 564, 565, 570, 571, 578, 582}, m = "cleanupLocalArtifactsAndTerminate", n = {"recordingData", "recordingData", "recordingData", "recordingData", "recordingId", "recordingData"}, s = {"L$0", "L$0", "L$0", "L$0", "L$1", "L$0"})
final class MmStandaloneAIInterpretationStateHandler$cleanupLocalArtifactsAndTerminate$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmStandaloneAIInterpretationStateHandler this$0;

    public MmStandaloneAIInterpretationStateHandler$cleanupLocalArtifactsAndTerminate$1(MmStandaloneAIInterpretationStateHandler r1, Continuation<? super MmStandaloneAIInterpretationStateHandler$cleanupLocalArtifactsAndTerminate$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r14) {
        this.result = r14;
        this.label |= Integer.MIN_VALUE;
        MmStandaloneAIInterpretationStateHandler r15 = this.this$0;
        MmStandaloneAIInterpretationStateHandler.a r1 = MmStandaloneAIInterpretationStateHandler.l;
        r15.getClass();
        int r2 = this.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r2 - Integer.MIN_VALUE;
        MmStandaloneAIInterpretationStateHandler$cleanupLocalArtifactsAndTerminate$1 r0 = this;
    L6:
        Object r3 = r0.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r0.label) {
            case 0: goto L17;
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            default: goto L9;
        };
    L10:
        ResultKt.throwOnFailure(r3);
    L59:
        r15.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.n(TerminateReason.SAVE_ARTIFACT_DISABLED));
        return Unit.INSTANCE;
    L11:
        ovb.b r5 = (ovb.b) r0.L$0;
        ResultKt.throwOnFailure(r3);
    L56:
        MmRecordingStatesSyncService r6 = r15.e;
        String r7 = r5.a;
        r0.L$0 = null;
        r0.label = 7;
        if (r6.e(r7, r0) != r4) goto L59;
        return r4;
    L12:
        String r8 = (String) r0.L$1;
        ovb.b r9 = (ovb.b) r0.L$0;
        ResultKt.throwOnFailure(r3);
        Object r10 = ((Result) r3).unbox-impl();
        String r11 = r8;
        r5 = r9;
    L53:
        lvb.a.e(r15.b, "[cleanupLocalArtifactsAndTerminate] sync upload completed result, success=" + Result.isSuccess-impl(r10));
        MmRecordingStatesSyncService r12 = r15.e;
        String r13 = r5.a;
        r0.L$0 = r5;
        r0.L$1 = null;
        r0.label = 6;
        if (r12.f(r13, r11, r0) != r4) goto L56;
        return r4;
    L13:
        r5 = (ovb.b) r0.L$0;
        ResultKt.throwOnFailure(r3);
    L49:
        String r16 = (String) r3;
        MmRecordingStatesSyncService r17 = r15.e;
        r0.L$0 = r5;
        r0.L$1 = r16;
        r0.label = 5;
        Object r18 = r17.I("standaloneSaveArtifactDisabled", r0);
        if (r18 == r4) goto L80;
        r11 = r16;
        r10 = r18;
        goto L53
    L80:
        return r4;
    L14:
        r5 = (ovb.b) r0.L$0;
        ResultKt.throwOnFailure(r3);
    L46:
        r15.e.h(r5.a, r15.a.c());
        MmRecordingStatesSyncService r19 = r15.e;
        r0.L$0 = r5;
        r0.label = 4;
        r3 = r19.d(r0);
        if (r3 != r4) goto L49;
        return r4;
    L15:
        r5 = (ovb.b) r0.L$0;
        ResultKt.throwOnFailure(r3);
    L43:
        r0.L$0 = r5;
        r0.label = 3;
        if (DelayKt.delay(100, r0) != r4) goto L46;
        return r4;
    L16:
        ResultKt.throwOnFailure(r3);
    L20:
        r5 = (ovb.b) r3;
        String r20 = r5.c;
        if (StringsKt.isBlank(r20) == false) goto L23;
        r20 = r15.e.s(r5.a);
    L23:
        lvb.a.e(r15.b, "[cleanupLocalArtifactsAndTerminate] save artifact disabled, meetingId=" + lvb.a.d(r5.a) + ", recordingId=" + lvb.a.d(r20));
        Job r21 = r15.i;
        if (r21 == null) goto L26;
        Job.DefaultImpls.cancel$default(r21, null, 1, null);
    L26:
        MmRecordingUploadService r22 = r15.a.k();
        r22.getClass();
        Intrinsics.checkNotNullParameter("standalone_ai_interpretation_save_artifact_disabled", "reason");
        List r23 = CollectionsKt.toList(r22.f);
        Object r24 = r22.g;
        monitor-enter(r24);
        List r25 = CollectionsKt.toList(r22.h);     // Catch: Throwable -> L64
        monitor-exit(r24);
        List r26 = CollectionsKt.plus(r23, r25);
        lvb.a.e(r22.c, "[discardPendingTasks] reason:standalone_ai_interpretation_save_artifact_disabled, queueSize:" + r22.f.size() + ", runningCount:" + r22.i());
        n r27 = r22.f();
        HashSet r28 = new HashSet();
        ArrayList r29 = new ArrayList();
        Iterator r30 = r26.iterator();
    L32:
        if (r30.hasNext() == false) goto L36;
        Object r110 = r30.next();
        if (r28.add(Integer.valueOf(((MmRecordingUploadTask) r110).b)) == false) goto L32;
        r29.add(r110);
        goto L32
    L36:
        r27.c(r29, r22.l(null));
        r22.f.clear();
        Object r31 = r22.g;
        monitor-enter(r31);
        r22.h.clear();     // Catch: Throwable -> L61
        Unit r32 = Unit.INSTANCE;     // Catch: Throwable -> L61
        monitor-exit(r31);
        CoroutineScopeKt.cancel$default(r22.i, null, 1, null);
        MmRecordingAudioService r33 = r15.d;
        r0.L$0 = r5;
        r0.label = 2;
        if (r33.c(r0) != r4) goto L43;
        return r4;
    L61:
        th = move-exception;
        throw th;
    L64:
        th = move-exception;
        throw th;
    L17:
        ResultKt.throwOnFailure(r3);
        MmRecordingSession r34 = r15.a;
        r0.label = 1;
        r3 = r34.r(r0);
        if (r3 != r4) goto L20;
        return r4;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r0 = new MmStandaloneAIInterpretationStateHandler$cleanupLocalArtifactsAndTerminate$1(r15, this);
        goto L6
    }
}
