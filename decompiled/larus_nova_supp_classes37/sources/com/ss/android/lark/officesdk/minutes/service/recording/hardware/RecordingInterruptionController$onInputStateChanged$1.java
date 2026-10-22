package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.RecordingInterruptionController", f = "RecordingInterruptionController.kt", i = {0, 0, 0, 0}, l = {463, 223}, m = "onInputStateChanged", n = {"playbackState", "action", "$this$withLock_u24default$iv", "earbudsConnected"}, s = {"L$0", "L$1", "L$2", "Z$0"})
final class RecordingInterruptionController$onInputStateChanged$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecordingInterruptionController this$0;

    public RecordingInterruptionController$onInputStateChanged$1(RecordingInterruptionController r1, Continuation<? super RecordingInterruptionController$onInputStateChanged$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        RecordingInterruptionController r12 = this.this$0;
        r12.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        RecordingInterruptionController$onInputStateChanged$1 r0 = this;
    L6:
        Object r2 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 != 0) goto L9;
        ResultKt.throwOnFailure(r2);
        Ref.ObjectRef r13 = new Ref.ObjectRef();
        r0.L$0 = null;
        r0.L$1 = r13;
        r0.L$2 = null;
        r0.Z$0 = false;
        r0.label = 1;
        throw null;
    L9:
        if (r3 == 1) goto L14;
        if (r3 != 2) goto L13;
        ResultKt.throwOnFailure(r2);
    L34:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        boolean r4 = r0.Z$0;
        kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) r0.L$2;
        Ref.ObjectRef r8 = (Ref.ObjectRef) r0.L$1;
        HardwarePlaybackState r9 = (HardwarePlaybackState) r0.L$0;
        ResultKt.throwOnFailure(r2);
        r12.a = r9;     // Catch: Throwable -> L57
        if (r12.d == false) goto L30;
        if (r4 == false) goto L30;
        if (r9 != HardwarePlaybackState.APP_CALL) goto L21;
    L24:
        boolean r5 = true;
    L25:
        if (r5 == false) goto L30;
        r12.d = false;     // Catch: Throwable -> L57
        r12.e = RecordingInterruptionController.InputRecoveryPolicy.STANDARD;     // Catch: Throwable -> L57
        Job r6 = r12.k;     // Catch: Throwable -> L57
        if (r6 == null) goto L29;
        Job.DefaultImpls.cancel$default(r6, null, 1, null);     // Catch: Throwable -> L57
    L29:
        r12.k = null;     // Catch: Throwable -> L57
        r8.element = k.d.a;     // Catch: Throwable -> L57
        goto L30
    L21:
        if (r9 == HardwarePlaybackState.SYS_CALL) goto L24;
        r5 = false;
    L30:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L57
        r7.unlock(null);
        k r15 = (k) r8.element;
        if (r15 == null) goto L34;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
        if ((r15 instanceof k.e) == false) goto L38;
        k.e r16 = (k.e) r15;
        throw null;
    L38:
        if ((r15 instanceof k.f) == false) goto L40;
        k.f r17 = (k.f) r15;
        throw null;
    L40:
        if (Intrinsics.areEqual(r15, k.c.a) == false) goto L42;
        throw null;
    L42:
        if (Intrinsics.areEqual(r15, k.d.a) == false) goto L44;
        throw null;
    L44:
        if (Intrinsics.areEqual(r15, k.b.a) == false) goto L46;
        throw null;
    L46:
        if (Intrinsics.areEqual(r15, k.a.a) == false) goto L49;
        throw null;
    L49:
        throw new NoWhenBranchMatchedException();
    L57:
        th = move-exception;
        r7.unlock(null);
        throw th;
    L5:
        r0 = new RecordingInterruptionController$onInputStateChanged$1(r12, this);
        goto L6
    }
}
