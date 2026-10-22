package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.h;
import java.io.File;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioPersistent$appendRawOpusToFile$2", f = "MmRecordingAudioPersistent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAudioPersistent$appendRawOpusToFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $byteArray;
    final /* synthetic */ int $durationInSec;
    final /* synthetic */ int $index;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingAudioPersistent this$0;

    public MmRecordingAudioPersistent$appendRawOpusToFile$2(MmRecordingAudioPersistent r1, int r2, int r3, byte[] r4, Continuation<? super MmRecordingAudioPersistent$appendRawOpusToFile$2> r5) {
        this.this$0 = r1;
        this.$index = r2;
        this.$durationInSec = r3;
        this.$byteArray = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MmRecordingAudioPersistent$appendRawOpusToFile$2 r6 = new MmRecordingAudioPersistent$appendRawOpusToFile$2(this.this$0, this.$index, this.$durationInSec, this.$byteArray, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        File r7 = this.this$0.e;
        if (r7 == null) goto L7;
        String r0 = this.$index + '_' + (this.$durationInSec * 1000) + ".opus";
        VFSFile r8 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.b(r7, r0);
        lvb.a.a(this.this$0.c, "appendRawOpusToFile, index:" + this.$index + ", fileName:" + r0 + ", size:" + this.$byteArray.length);
        byte[] r1 = this.$byteArray;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r8, "file");     // Catch: Throwable -> L19
        h r3 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a;     // Catch: Throwable -> L19
        OutputStream r9 = r3.s(r3.t(r8), true);     // Catch: Throwable -> L19
        r9.write(r1);     // Catch: Throwable -> L14
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        CloseableKt.closeFinally(r9, null);     // Catch: Throwable -> L19
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        MmRecordingAudioPersistent r11 = this.this$0;
        Throwable r12 = Result.exceptionOrNull-impl(r10);
        if (r12 == null) goto L25;
        lvb.a.b(r11.c, "appendRawOpusToFile failed: " + r12);
    L25:
        return Unit.INSTANCE;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L7:
        return Unit.INSTANCE;
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
