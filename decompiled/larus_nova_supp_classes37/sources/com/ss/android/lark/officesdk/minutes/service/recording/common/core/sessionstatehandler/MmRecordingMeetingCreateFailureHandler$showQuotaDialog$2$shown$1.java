package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmRecordingMeetingCreateFailureHandler$showQuotaDialog$2$shown$1", f = "MmRecordingMeetingCreateFailureHandler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingMeetingCreateFailureHandler$showQuotaDialog$2$shown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $denyType;
    final /* synthetic */ kub.a $quotaDependency;
    final /* synthetic */ int $retryIndex;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingMeetingCreateFailureHandler this$0;

    public MmRecordingMeetingCreateFailureHandler$showQuotaDialog$2$shown$1(MmRecordingMeetingCreateFailureHandler r1, int r2, kub.a r3, int r4, Continuation<? super MmRecordingMeetingCreateFailureHandler$showQuotaDialog$2$shown$1> r5) {
        this.this$0 = r1;
        this.$retryIndex = r2;
        this.$quotaDependency = r3;
        this.$denyType = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MmRecordingMeetingCreateFailureHandler$showQuotaDialog$2$shown$1 r6 = new MmRecordingMeetingCreateFailureHandler$showQuotaDialog$2$shown$1(this.this$0, this.$retryIndex, this.$quotaDependency, this.$denyType, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L35;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        yub.d r8 = yub.d.a;
        FragmentActivity r9 = com.ss.android.lark.appcontext.applifecycle2.api.a.a();
        Lifecycle.State r1 = null;
        if ((r9 instanceof FragmentActivity) == false) goto L7;
        FragmentActivity r10 = r9;
    L8:
        if (r10 == null) goto L12;
        Lifecycle r0 = r10.getLifecycle();
        if (r0 == null) goto L12;
        r1 = r0.getCurrentState();
    L12:
        boolean r2 = false;
        if (r10 != null) goto L15;
    L31:
        lvb.a.b(this.this$0.b, "[showQuotaDialog] activity not ready, retryIndex=" + this.$retryIndex + ", activity=" + r10 + ", state=" + r1);
    L33:
        return Boxing.boxBoolean(r2);
    L15:
        if (r10.isFinishing() == true) goto L31;
        if (r1 == null) goto L20;
        boolean r3 = true;
        if (r1.isAtLeast(Lifecycle.State.RESUMED) != true) goto L20;
    L21:
        if (r3 == false) goto L31;
        kub.a r11 = this.$quotaDependency;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L25
        r11.P();     // Catch: Throwable -> L25
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        MmRecordingMeetingCreateFailureHandler r5 = this.this$0;
        int r13 = this.$denyType;
        Throwable r14 = Result.exceptionOrNull-impl(r12);
        if (r14 == null) goto L30;
        lvb.a.b(r5.b, "[showQuotaDialog] show failed, denyType=" + r13 + ", error=" + r14);
    L30:
        r2 = Result.isSuccess-impl(r12);
    L25:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L20:
        r3 = false;
        goto L21
    L7:
        r10 = null;
        goto L8
    L35:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
