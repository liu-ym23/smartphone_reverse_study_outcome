package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import android.app.Activity;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.j;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tub.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareCallRecordingFloatController$tryShow$1", f = "MmHardwareCallRecordingFloatController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmHardwareCallRecordingFloatController$tryShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $recordingId;
    final /* synthetic */ String $trigger;
    int label;
    final /* synthetic */ MmHardwareCallRecordingFloatController this$0;

    public static final class a implements iub.a<j, MmRecordingError> {
        public final /* synthetic */ MmHardwareCallRecordingFloatController a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        @Override // iub.a
        public final void a(MmRecordingError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            lvb.a.b(this.a.d, "[tryShow] failed, trigger=" + this.b + ", recordingId=" + this.c + ", code=" + r4.getErrorCode() + ", message=" + r4.getErrorMsg());
        }

        @Override // iub.a
        public final void onSuccess(j r4) {
            j r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "data");
            lvb.a.e(this.a.d, "[tryShow] success, trigger=" + this.b + ", recordingId=" + r5.a);
        }

        public a(MmHardwareCallRecordingFloatController r1, String r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public MmHardwareCallRecordingFloatController$tryShow$1(MmHardwareCallRecordingFloatController r1, String r2, String r3, Continuation<? super MmHardwareCallRecordingFloatController$tryShow$1> r4) {
        this.this$0 = r1;
        this.$trigger = r2;
        this.$recordingId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmHardwareCallRecordingFloatController$tryShow$1(this.this$0, this.$trigger, this.$recordingId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r7);
        List<d> r8 = this.this$0.b.snapshot().a;
        boolean r1 = false;
        if ((r8 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r9 = r8.iterator();
    L11:
        if (r9.hasNext() == false) goto L19;
        if (((d) r9.next()).a != RecordingPriorityScene.VIDEO_CONFERENCE) goto L15;
        boolean r0 = true;
    L16:
        if (r0 == false) goto L11;
        r1 = true;
        goto L19
    L15:
        r0 = false;
    L19:
        if (r1 == false) goto L22;
        lvb.a.e(this.this$0.d, "[tryShow] skip active vc, trigger=" + this.$trigger + ", recordingId=" + this.$recordingId);
        return Unit.INSTANCE;
    L22:
        yub.d r2 = yub.d.a;
        Activity r3 = com.ss.android.lark.appcontext.applifecycle2.api.a.a();
        if (r3 != null) goto L26;
        lvb.a.e(this.this$0.d, "[tryShow] skip top activity null, trigger=" + this.$trigger + ", recordingId=" + this.$recordingId);
        return Unit.INSTANCE;
    L26:
        lvb.a.e(this.this$0.d, "[tryShow] show float, trigger=" + this.$trigger + ", recordingId=" + this.$recordingId + ", activity=" + r3.getClass().getName());
        MmHardwareCallRecordingFloatController r10 = this.this$0;
        hub.a r4 = r10.a;
        String r5 = this.$recordingId;
        r4.me(r3, r5, MmRecordingUILaunchMode.WITH_FEISHU_UI, new a(r10, this.$trigger, r5));
        return Unit.INSTANCE;
    L7:
        if (r8.isEmpty() == false) goto L9;
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
