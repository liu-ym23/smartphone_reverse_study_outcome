package com.ss.android.lark.officesdk.minutes.service.recording.common.repo;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.TerminateReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.c;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import yub.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmRecordingEndWindowEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.MmRecordingRepo$buildHardwareLiveEndWindowWithTimeout$result$1", f = "MmRecordingRepo.kt", i = {}, l = {414}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingRepo$buildHardwareLiveEndWindowWithTimeout$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Unit, ? extends c>>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MmRecordingRepo this$0;

    public MmRecordingRepo$buildHardwareLiveEndWindowWithTimeout$result$1(MmRecordingRepo r1, Continuation<? super MmRecordingRepo$buildHardwareLiveEndWindowWithTimeout$result$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmRecordingRepo$buildHardwareLiveEndWindowWithTimeout$result$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Pair<Unit, c>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Unit r3 = (Unit) this.L$0;
        ResultKt.throwOnFailure(r10);
    L41:
        return TuplesKt.to(r3, r10);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        Unit r11 = Unit.INSTANCE;
        MmRecordingRepo r4 = this.this$0;
        this.L$0 = r11;
        this.label = 1;
        int r5 = MmRecordingRepo.F;
        if (r4.e() == false) goto L36;
        k r6 = r4.a.f;
        if (r6 == null) goto L14;
        MmRecordingSource r7 = r6.a;
    L15:
        TerminateReason r8 = r4.A;
        if (r8 == null) goto L36;
        EndRecordingReason r9 = r4.z;
        Intrinsics.checkNotNullParameter(r8, "terminateReason");
        if (r9 == null) goto L21;
    L25:
        r2 = false;
    L26:
        if (r2 == false) goto L36;
        String r12 = r4.a.d();
        String r13 = r4.a.w.a;
        d r14 = d.a;
        boolean r15 = com.ss.android.lark.appcontext.applifecycle2.api.a.b();
        if (StringsKt.isBlank(r12) == false) goto L31;
    L35:
        lvb.a.e(r4.c, "[buildHardwareLiveEndWindow] skip, source=" + r7 + ", hardwareRecordIdEmpty=" + StringsKt.isBlank(r12) + ", meetingIdEmpty=" + StringsKt.isBlank(r13) + ", isAppForeground=" + r15);
        goto L36
    L31:
        if (StringsKt.isBlank(r13) == true) goto L35;
        if (r15 == false) goto L35;
        lvb.a.e(r4.c, "[buildHardwareLiveEndWindow] show, source=" + r7 + ", hardwareRecordId=" + r12 + ", meetingId=" + r13);
        Object r16 = r4.b(this);
    L37:
        if (r16 != r0) goto L39;
        return r0;
    L39:
        r3 = r11;
        r10 = r16;
        goto L41
    L21:
        if (r8 != TerminateReason.HARDWARE_STOPPED) goto L25;
        if (r7 != MmRecordingSource.FEISHU_HARDWARE_D1204_CASE) goto L25;
    L14:
        r7 = null;
    L36:
        r16 = null;
        goto L37
    }
}
