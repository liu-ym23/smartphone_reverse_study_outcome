package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.h;
import java.io.File;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioPersistent$appendPcmToFile$2", f = "MmRecordingAudioPersistent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAudioPersistent$appendPcmToFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $byteArray;
    final /* synthetic */ int $index;
    final /* synthetic */ int $sliceDurationInSec;
    int label;
    final /* synthetic */ MmRecordingAudioPersistent this$0;

    public MmRecordingAudioPersistent$appendPcmToFile$2(MmRecordingAudioPersistent r1, int r2, int r3, byte[] r4, Continuation<? super MmRecordingAudioPersistent$appendPcmToFile$2> r5) {
        this.this$0 = r1;
        this.$index = r2;
        this.$sliceDurationInSec = r3;
        this.$byteArray = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmRecordingAudioPersistent$appendPcmToFile$2(this.this$0, this.$index, this.$sliceDurationInSec, this.$byteArray, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r5);
        File r6 = this.this$0.e;
        if (r6 == null) goto L7;
        String r0 = this.$index + '_' + (this.$sliceDurationInSec * 1000) + ".pcm";
        VFSFile r7 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.b(r6, r0);
        lvb.a.a(this.this$0.c, "appendPcmToFile, index:" + this.$index + ", fileName:" + r0 + ", size:" + this.$byteArray.length);
        Intrinsics.checkNotNullParameter(r7, "file");     // Catch: Exception -> L19
        h r1 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a;     // Catch: Exception -> L19
        OutputStream r8 = r1.s(r1.t(r7), true);     // Catch: Exception -> L19
        r8.write(this.$byteArray);     // Catch: Throwable -> L14
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        CloseableKt.closeFinally(r8, null);     // Catch: Exception -> L19
    L22:
        return Unit.INSTANCE;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r8, th);     // Catch: Exception -> L19
        throw th;     // Catch: Exception -> L19
    L19:
        e = move-exception;
        lvb.a.b(this.this$0.c, "appendPcmToFile failed: " + e);
        goto L22
    L7:
        return Unit.INSTANCE;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
