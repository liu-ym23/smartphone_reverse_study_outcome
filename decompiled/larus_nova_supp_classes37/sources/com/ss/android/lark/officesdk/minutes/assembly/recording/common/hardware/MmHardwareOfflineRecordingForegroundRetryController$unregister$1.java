package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.appcontext.applifecycle2.api.AppLifecycle2;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import yub.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareOfflineRecordingForegroundRetryController$unregister$1", f = "MmHardwareOfflineRecordingForegroundRetryController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmHardwareOfflineRecordingForegroundRetryController$unregister$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $recordingId;
    int label;
    final /* synthetic */ MmHardwareOfflineRecordingForegroundRetryController this$0;

    public MmHardwareOfflineRecordingForegroundRetryController$unregister$1(MmHardwareOfflineRecordingForegroundRetryController r1, String r2, Continuation<? super MmHardwareOfflineRecordingForegroundRetryController$unregister$1> r3) {
        this.this$0 = r1;
        this.$recordingId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmHardwareOfflineRecordingForegroundRetryController$unregister$1(this.this$0, this.$recordingId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r6);
        MmHardwareOfflineRecordingForegroundRetryController r7 = this.this$0;
        String r0 = this.$recordingId;
        yub.a.b r1 = r7.e.remove(r0);
        if (r1 != null) goto L21;
    L17:
        r7.f.remove(r0);
        return Unit.INSTANCE;
    L21:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        d r3 = d.a;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r1, "observer");     // Catch: Throwable -> L11
        com.ss.android.lark.appcontext.applifecycle.a r4 = d.b.remove(r1);     // Catch: Throwable -> L11
        if (r4 == null) goto L9;
        int r5 = com.ss.android.lark.appcontext.applifecycle2.api.a.a;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r4, "activityObserver");     // Catch: Throwable -> L11
        AppLifecycle2.a().a(r4);     // Catch: Throwable -> L11
    L9:
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L16;
        lvb.a.b(r7.d, "[unregisterInternal] failed, recordingId=" + r0 + ", error=" + r9);
    L16:
        lvb.a.e(r7.d, "[unregisterInternal] recordingId=" + r0);
    L11:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
