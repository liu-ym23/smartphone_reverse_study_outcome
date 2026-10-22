package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadTask;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.k;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ChannelIterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler.MmSoftwareCurrentRecordingStateHandler$startUpload$1", f = "MmSoftwareCurrentRecordingStateHandler.kt", i = {0}, l = {643}, m = "invokeSuspend", n = {"segDurationInMills"}, s = {"I$0"})
final class MmSoftwareCurrentRecordingStateHandler$startUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $uploadIdentity;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ MmSoftwareCurrentRecordingStateHandler this$0;

    public MmSoftwareCurrentRecordingStateHandler$startUpload$1(MmSoftwareCurrentRecordingStateHandler r1, String r2, Continuation<? super MmSoftwareCurrentRecordingStateHandler$startUpload$1> r3) {
        this.this$0 = r1;
        this.$uploadIdentity = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmSoftwareCurrentRecordingStateHandler$startUpload$1(this.this$0, this.$uploadIdentity, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x005f -> B:12:0x0062). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r3 = 1;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        int r4 = this.I$0;
        ChannelIterator r5 = (ChannelIterator) this.L$0;
        ResultKt.throwOnFailure(r17);
        Object r6 = r17;
        MmSoftwareCurrentRecordingStateHandler$startUpload$1 r7 = this;
    L13:
        if (((Boolean) r6).booleanValue() == false) goto L20;
        ovb.a r8 = (ovb.a) r5.next();
        MmRecordingUploadService r15 = r7.this$0.a.k();
        String r9 = r8.a;
        int r10 = r8.b;
        String r11 = r7.$uploadIdentity;
        String r12 = String.valueOf((r10 - 1) * r4);
        MmRecordingSession r13 = r7.this$0.a;
        k r14 = r13.f;
        if (r14 == null) goto L17;
        MmRecordingSource r16 = r14.a;
    L18:
        r15.c(new MmRecordingUploadTask(r9, r10, r11, r12, r4, r16, r13.v()));
        r3 = 1;
    L9:
        r7.L$0 = r5;
        r7.I$0 = r4;
        r7.label = r3;
        r6 = r5.hasNext(r7);
        if (r6 != r1) goto L13;
        return r1;
    L17:
        r16 = null;
        goto L18
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.d.a(com.ss.android.lark.officesdk.minutes.service.recording.common.perf.appreciable.a.c, this.this$0.a.e(), this.this$0.a.j());
        r4 = this.this$0.c.getSettingsService().h.getSliceDurationInSec() * 1000;
        r5 = this.this$0.d.j.iterator();
        r7 = this;
        goto L9
    }
}
