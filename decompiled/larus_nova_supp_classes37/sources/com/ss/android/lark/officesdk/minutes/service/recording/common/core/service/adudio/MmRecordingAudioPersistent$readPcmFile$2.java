package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioPersistent$readPcmFile$2", f = "MmRecordingAudioPersistent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAudioPersistent$readPcmFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ int $sliceDurationInSec;
    int label;
    final /* synthetic */ MmRecordingAudioPersistent this$0;

    public MmRecordingAudioPersistent$readPcmFile$2(MmRecordingAudioPersistent r1, int r2, int r3, Continuation<? super MmRecordingAudioPersistent$readPcmFile$2> r4) {
        this.this$0 = r1;
        this.$index = r2;
        this.$sliceDurationInSec = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MmRecordingAudioPersistent$readPcmFile$2(this.this$0, this.$index, this.$sliceDurationInSec, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super byte[]> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        File r5 = this.this$0.e;
        if (r5 == null) goto L7;
        VFSFile r6 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.b(r5, this.$index + '_' + (this.$sliceDurationInSec * 1000) + ".pcm");
        if (r6.exists() == false) goto L12;
        return r6.readBytes();
    L12:
        return new byte[0];
    L7:
        return new byte[0];
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
