package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.bytedance.lark.oggopus_rust_android.Oggopus_rustKt;
import com.bytedance.lark.oggopus_rust_android.RawOpusOptions;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.h;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmAudioFileMetaInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioPersistent$muxRawOpusToOggFile$2", f = "MmRecordingAudioPersistent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAudioPersistent$muxRawOpusToOggFile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ovb.a>>, Object> {
    final /* synthetic */ int $durationInSec;
    final /* synthetic */ int $index;
    final /* synthetic */ e $rawOpusUploadOptions;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingAudioPersistent this$0;

    public MmRecordingAudioPersistent$muxRawOpusToOggFile$2(MmRecordingAudioPersistent r1, int r2, int r3, e r4, Continuation<? super MmRecordingAudioPersistent$muxRawOpusToOggFile$2> r5) {
        this.this$0 = r1;
        this.$durationInSec = r2;
        this.$index = r3;
        this.$rawOpusUploadOptions = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MmRecordingAudioPersistent$muxRawOpusToOggFile$2 r6 = new MmRecordingAudioPersistent$muxRawOpusToOggFile$2(this.this$0, this.$durationInSec, this.$index, this.$rawOpusUploadOptions, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<ovb.a>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r20);
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        File r4 = this.this$0.e;
        if (r4 != null) goto L11;
        MmAudioPersistentFatalException r0 = new MmAudioPersistentFatalException("audio dir create failed!");
        String r2 = this.this$0.c;
        String r5 = r0.getErrorMsg();
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        lvb.a.b(r2, r5);
        Result.Companion r6 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r0)));
    L11:
        int r7 = this.$durationInSec * 1000;
        h r8 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a;
        VFSFile r9 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.b(r4, this.$index + '_' + r7 + ".opus");
        if (r9.exists() == true) goto L14;
    L34:
        MmAudioPersistentFatalException r1 = new MmAudioPersistentFatalException("raw opus file empty!");
        lvb.a.b(this.this$0.c, "muxRawOpusToOggFile failed, index:" + this.$index + ", path:" + r9.getAbsolutePath());
        Result.Companion r10 = Result.Companion;
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r1)));
    L14:
        if (r9.length() <= 0) goto L34;
        VFSFile r11 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.b(r4, this.$index + '_' + r7 + ".ogg");
        MmRecordingAudioPersistent r12 = this.this$0;
        e r13 = this.$rawOpusUploadOptions;
        int r14 = this.$index;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L27
        if (r11.exists() == false) goto L20;
        r11.delete();     // Catch: Throwable -> L27
    L20:
        long r16 = r9.length();     // Catch: Throwable -> L27
        r12.getClass();     // Catch: Throwable -> L27
        r13.getClass();     // Catch: Throwable -> L27
        Oggopus_rustKt.muxRawOpusIntoOgg(r9.getAbsolutePath(), r11.getAbsolutePath(), new RawOpusOptions(UInt.constructor-impl(0), UInt.constructor-impl(0), UInt.constructor-impl(0), UInt.constructor-impl(0), null));     // Catch: Throwable -> L27
        if (r11.exists() == false) goto L26;
        if (r11.length() <= 0) goto L26;
        r9.delete();     // Catch: Throwable -> L27
        lvb.a.e(r12.c, "muxRawOpusToOggFile success, index:" + r14 + ", opusBytes:" + r16 + ", oggBytes:" + r11.length() + ", inputRateHz:0, channels:0, frameMs:0, bitrateBps:0");     // Catch: Throwable -> L27
        Object r17 = Result.constructor-impl(new ovb.a(r11.getAbsolutePath(), r14));     // Catch: Throwable -> L27
    L29:
        MmRecordingAudioPersistent r18 = this.this$0;
        int r19 = this.$index;
        Throwable r21 = Result.exceptionOrNull-impl(r17);
        if (r21 == null) goto L33;
        lvb.a.b(r18.c, "muxRawOpusToOggFile failed, index:" + r19 + ", error:" + r21);
    L33:
        return Result.box-impl(r17);
    L26:
        throw new MmAudioPersistentFatalException("mux raw opus to ogg output empty!");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
