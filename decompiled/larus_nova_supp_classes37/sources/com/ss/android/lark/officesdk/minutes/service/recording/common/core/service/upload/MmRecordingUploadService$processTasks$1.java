package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.MmRecordingUploadService$processTasks$1", f = "MmRecordingUploadService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingUploadService$processTasks$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmRecordingUploadService this$0;

    public MmRecordingUploadService$processTasks$1(MmRecordingUploadService r1, Continuation<? super MmRecordingUploadService$processTasks$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmRecordingUploadService$processTasks$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r10);
        MmRecordingUploadService r11 = this.this$0;
        int r0 = MmRecordingUploadService.q;
        if (r11.i() != 0) goto L18;
        MmRecordingUploadTask r1 = r11.f.poll();
        if (r1 == null) goto L16;
        Object r2 = r11.g;
        monitor-enter(r2);
        r11.h.add(r1);     // Catch: Throwable -> L13
        monitor-exit(r2);
        BuildersKt.launch$default(r11.i, null, null, new MmRecordingUploadService$executeTask$1(r11, r1, null), 3, null);
    L13:
        th = move-exception;
        throw th;
    L16:
        r11.d();
    L18:
        return Unit.INSTANCE;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
