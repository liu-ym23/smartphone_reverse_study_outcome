package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {0, 0, 0, 0, 0, 2, 2, 2}, l = {484, 485, 493}, m = "startRecordingInternal", n = {"adapter", "sceneInstanceId", "initialPlaybackState", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "restoreLegacyRecordingOnFailure", "sceneInstanceId", "hookResult", "restoreLegacyRecordingOnFailure"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "Z$0"})
final class HardwareRecordingManager$startRecordingInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$startRecordingInternal$1(d r1, Continuation<? super HardwareRecordingManager$startRecordingInternal$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        d r9 = this.this$0;
        r9.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        HardwareRecordingManager$startRecordingInternal$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r0.label;
        if (r4 != 0) goto L42;
        ResultKt.throwOnFailure(r2);
        throw null;
    L42:
        if (r4 == 1) goto L19;
        if (r4 != 2) goto L12;
        ResultKt.throwOnFailure(r2);
    L25:
        return r2;
    L12:
        if (r4 != 3) goto L17;
        f r5 = (f) r0.L$1;
        String r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L30
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L30
    L32:
        Throwable r10 = Result.exceptionOrNull-impl(r7);
        if (r10 != null) goto L36;
        r9.a = null;
        throw null;
    L36:
        lvb.a.b(null, "[audioFeatureStatus] clear failed, error=" + r10);
        throw null;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        e r11 = (e) r0.L$3;
        HardwarePlaybackState r12 = (HardwarePlaybackState) r0.L$2;
        String r13 = (String) r0.L$1;
        b r14 = (b) r0.L$0;
        ResultKt.throwOnFailure(r2);
        f r15 = (f) r2;
        if ((r15 instanceof f.b) == false) goto L27;
        ((f.b) r15).getClass();
        e r16 = e.a(r11, null, null, 223);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.L$3 = null;
        r0.label = 2;
        r2 = r9.o(r16, r0);
        if (r2 != r3) goto L25;
        return r3;
    L27:
        if ((r15 instanceof f.a) == false) goto L39;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L30
        throw null;     // Catch: Throwable -> L30
    L39:
        throw new NoWhenBranchMatchedException();
    L30:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L5:
        r0 = new HardwareRecordingManager$startRecordingInternal$1(r9, this);
        goto L6
    }
}
