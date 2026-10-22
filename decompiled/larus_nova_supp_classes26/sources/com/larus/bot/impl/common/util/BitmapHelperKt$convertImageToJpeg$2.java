package com.larus.bot.impl.common.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.io.InputStream;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.common.util.BitmapHelperKt$convertImageToJpeg$2", f = "BitmapHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BitmapHelperKt$convertImageToJpeg$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ File $outputFile;
    final /* synthetic */ Uri $source;
    private /* synthetic */ Object L$0;
    int label;

    public BitmapHelperKt$convertImageToJpeg$2(Activity r1, Uri r2, File r3, Continuation<? super BitmapHelperKt$convertImageToJpeg$2> r4) {
        this.$activity = r1;
        this.$source = r2;
        this.$outputFile = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        BitmapHelperKt$convertImageToJpeg$2 r0 = new BitmapHelperKt$convertImageToJpeg$2(this.$activity, this.$source, this.$outputFile, r6);
        r0.L$0 = r5;
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
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        Activity r7 = this.$activity;
        Uri r0 = this.$source;
        File r1 = this.$outputFile;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        if (r7 == null) goto L10;
        ContentResolver r8 = r7.getContentResolver();     // Catch: Throwable -> L13
        if (r8 == null) goto L10;
        InputStream r9 = ContentResolverWrapper.openInputStream(r8, r0);     // Catch: Throwable -> L13
    L11:
        Bitmap r10 = BitmapFactory.decodeStream(r9);     // Catch: Throwable -> L13
        PolarisFileOutputStreamWrapper r3 = new PolarisFileOutputStreamWrapper(r1);     // Catch: Throwable -> L13
        r10.compress(Bitmap.CompressFormat.JPEG, 100, r3);     // Catch: Throwable -> L13
        r3.close();     // Catch: Throwable -> L13
        Object r11 = Result.constructor-impl(Boxing.boxBoolean(true));     // Catch: Throwable -> L13
    L15:
        Throwable r4 = Result.exceptionOrNull-impl(r11);
        if (r4 == null) goto L19;
        FLogger.a.e("BitmapHelper", "convertImageToJpeg failed", r4);
    L19:
        if (Result.exceptionOrNull-impl(r11) != null) goto L22;
        return r11;
    L22:
        return Boxing.boxBoolean(false);
    L10:
        r9 = null;
    L13:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
