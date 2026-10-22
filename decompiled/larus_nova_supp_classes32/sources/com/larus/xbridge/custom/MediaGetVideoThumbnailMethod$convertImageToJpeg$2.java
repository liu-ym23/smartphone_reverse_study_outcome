package com.larus.xbridge.custom;

import android.graphics.Bitmap;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.io.File;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.xbridge.custom.MediaGetVideoThumbnailMethod$convertImageToJpeg$2", f = "MediaGetVideoThumbnailMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MediaGetVideoThumbnailMethod$convertImageToJpeg$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ File $outputFile;
    private /* synthetic */ Object L$0;
    int label;

    public MediaGetVideoThumbnailMethod$convertImageToJpeg$2(File r1, Bitmap r2, Continuation<? super MediaGetVideoThumbnailMethod$convertImageToJpeg$2> r3) {
        this.$outputFile = r1;
        this.$bitmap = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MediaGetVideoThumbnailMethod$convertImageToJpeg$2 r0 = new MediaGetVideoThumbnailMethod$convertImageToJpeg$2(this.$outputFile, this.$bitmap, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        File r7 = this.$outputFile;
        Bitmap r0 = this.$bitmap;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        PolarisFileOutputStreamWrapper r2 = new PolarisFileOutputStreamWrapper(r7);     // Catch: Throwable -> L7
        r0.compress(Bitmap.CompressFormat.JPEG, 100, r2);     // Catch: Throwable -> L7
        r2.close();     // Catch: Throwable -> L7
        Object r8 = Result.constructor-impl(Boxing.boxBoolean(true));     // Catch: Throwable -> L7
    L9:
        Throwable r3 = Result.exceptionOrNull-impl(r8);
        if (r3 == null) goto L13;
        FLogger.a.e("BitmapHelper", "convertImageToJpeg failed", r3);
    L13:
        if (Result.exceptionOrNull-impl(r8) != null) goto L16;
        return r8;
    L16:
        return Boxing.boxBoolean(false);
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
