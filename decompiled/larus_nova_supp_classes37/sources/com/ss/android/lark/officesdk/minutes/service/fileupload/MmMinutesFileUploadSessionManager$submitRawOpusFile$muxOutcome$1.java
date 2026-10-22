package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.bytedance.lark.oggopus_rust_android.Oggopus_rustKt;
import com.bytedance.lark.oggopus_rust_android.RawOpusOptions;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadErrorCode;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/fileupload/MmMinutesFileUploadSessionManager$RawOpusMuxOutcome;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadSessionManager$submitRawOpusFile$muxOutcome$1", f = "MmMinutesFileUploadSessionManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmMinutesFileUploadSessionManager$submitRawOpusFile$muxOutcome$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super MmMinutesFileUploadSessionManager.d>, Object> {
    final /* synthetic */ eub.h $param;
    final /* synthetic */ String $userId;
    int label;

    public MmMinutesFileUploadSessionManager$submitRawOpusFile$muxOutcome$1(String r1, eub.h r2, Continuation<? super MmMinutesFileUploadSessionManager$submitRawOpusFile$muxOutcome$1> r3) {
        this.$userId = r1;
        this.$param = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmMinutesFileUploadSessionManager$submitRawOpusFile$muxOutcome$1(this.$userId, this.$param, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super MmMinutesFileUploadSessionManager.d> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L64;
        ResultKt.throwOnFailure(r25);
        int r0 = h.a;
        String r1 = this.$userId;
        eub.h r2 = this.$param;
        String r3 = r2.a;
        int r4 = r2.c;
        int r5 = r2.d;
        int r6 = r2.e;
        int r7 = r2.f;
        Intrinsics.checkNotNullParameter(r1, "userId");
        Intrinsics.checkNotNullParameter(r3, "rawOpusPath");
        if (StringsKt.isBlank(r3) == false) goto L7;
        Object r8 = new h.a.C0013a(MmMinutesFileUploadErrorCode.PRE_FILE_NOT_EXIST, "raw opus path is blank");
    L59:
        if ((r8 instanceof h.a.b) == false) goto L61;
        File r9 = ((h.a.b) r8).a;
        return new MmMinutesFileUploadSessionManager.d.b(r9, r9.length());
    L61:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.ss.android.lark.officesdk.minutes.service.fileupload.MmMinutesFileUploadOpusMuxHelper.Result.Failure");
        return new MmMinutesFileUploadSessionManager.d.a((h.a.C0013a) r8);
    L7:
        PolarisFileWrapper r13 = new PolarisFileWrapper(r3);
        if (r13.exists() == true) goto L10;
    L57:
        r8 = new h.a.C0013a(MmMinutesFileUploadErrorCode.PRE_FILE_NOT_EXIST, "raw opus file not exist, path=" + r3);
        goto L59
    L10:
        if (r13.isFile() == false) goto L57;
        if (r13.canRead() == true) goto L15;
        r8 = new h.a.C0013a(MmMinutesFileUploadErrorCode.FILE_READ_FAIL, "raw opus file not readable, path=" + r3);
        goto L59
    L15:
        long r14 = r13.length();
        if (r14 > 0) goto L68;
        r8 = new h.a.C0013a(MmMinutesFileUploadErrorCode.FILE_READ_FAIL, "raw opus file empty, path=" + r3);
        goto L59
    L68:
        VFSFile r10 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.a(r1, "mmRawOpusMux");     // Catch: Throwable -> L54
        if (r10.exists() == true) goto L21;
        r10.mkdirs();     // Catch: Throwable -> L54
    L21:
        VFSFile r11 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.b(r10, "raw_opus_" + System.currentTimeMillis() + '_' + UUID.randomUUID() + ".ogg");     // Catch: Throwable -> L54
        if (r11.exists() == false) goto L24;
        r11.delete();     // Catch: Throwable -> L54
    L24:
        if (r4 > 0) goto L27;
        r4 = 2;
    L27:
        if (r5 > 0) goto L30;
        r5 = 16000;
    L30:
        if (r6 > 0) goto L33;
        r6 = 64000;
    L33:
        if (r7 > 0) goto L36;
        r7 = 20;
    L36:
        RawOpusOptions r12 = new RawOpusOptions(UInt.constructor-impl(r6), UInt.constructor-impl(r7), UInt.constructor-impl(r4), UInt.constructor-impl(r5), null);
        long r15 = System.currentTimeMillis();
        Oggopus_rustKt.muxRawOpusIntoOgg(r3, r11.getAbsolutePath(), r12);     // Catch: Throwable -> L48
        long r16 = r11.length();     // Catch: Throwable -> L48
        if (r11.exists() == true) goto L40;
    L43:
        lvb.a.b("MmMinutesFileUploadOpusMuxHelper", "muxRawOpusToOgg produced empty ogg: path=" + r11.getAbsolutePath() + ", length=" + r16);     // Catch: Throwable -> L48
        if (r11.exists() == false) goto L46;
        r11.delete();     // Catch: Throwable -> L48
    L46:
        r8 = new h.a.C0013a(MmMinutesFileUploadErrorCode.FILE_READ_FAIL, "mux produced empty ogg");     // Catch: Throwable -> L48
        goto L59
    L40:
        if (r16 <= 0) goto L43;
        lvb.a.e("MmMinutesFileUploadOpusMuxHelper", "muxRawOpusToOgg success: input=" + r3 + " (" + r14 + " bytes) -> ogg=" + r11.getAbsolutePath() + " (" + r16 + " bytes), cost=" + (System.currentTimeMillis() - r15) + "ms");     // Catch: Throwable -> L48
        r8 = new h.a.b(r11);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        lvb.a.b("MmMinutesFileUploadOpusMuxHelper", "muxRawOpusToOgg failed: input=" + r3 + ", err=" + th.getClass().getSimpleName() + ", msg=" + th.getMessage());
        if (r11.exists() == false) goto L53;
        r11.delete();     // Catch: Throwable -> L65
    L53:
        h.a.C0013a r17 = new h.a.C0013a(MmMinutesFileUploadErrorCode.FILE_READ_FAIL, "mux raw opus into ogg failed: " + th.getMessage());
    L56:
        r8 = r17;
    L54:
        th = move-exception;
        lvb.a.b("MmMinutesFileUploadOpusMuxHelper", "muxRawOpusToOgg prepare ogg file failed: err=" + th.getClass().getSimpleName() + ", msg=" + th.getMessage());
        MmMinutesFileUploadErrorCode r18 = MmMinutesFileUploadErrorCode.FILE_READ_FAIL;
        StringBuilder r19 = new StringBuilder("prepare ogg output failed: ");
        r19.append(th.getMessage());
        r17 = new h.a.C0013a(r18, r19.toString());
        goto L56
    L64:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
