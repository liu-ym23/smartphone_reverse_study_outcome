package com.larus.bot.impl.common.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.utils.logger.FLogger;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.common.util.BitmapHelperKt$getImageFormat$2", f = "BitmapHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BitmapHelperKt$getImageFormat$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Uri $imageUri;
    int label;

    public BitmapHelperKt$getImageFormat$2(Activity r1, Uri r2, Continuation<? super BitmapHelperKt$getImageFormat$2> r3) {
        this.$activity = r1;
        this.$imageUri = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BitmapHelperKt$getImageFormat$2(this.$activity, this.$imageUri, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r6);
        Activity r7 = this.$activity;
        Uri r0 = this.$imageUri;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        if (r7 == null) goto L10;
        ContentResolver r8 = r7.getContentResolver();     // Catch: Throwable -> L13
        if (r8 == null) goto L10;
        InputStream r9 = ContentResolverWrapper.openInputStream(r8, r0);     // Catch: Throwable -> L13
    L11:
        BitmapFactory.Options r1 = new BitmapFactory.Options();     // Catch: Throwable -> L13
        r1.inJustDecodeBounds = true;     // Catch: Throwable -> L13
        BitmapFactory.decodeStream(r9, null, r1);     // Catch: Throwable -> L13
        Object r10 = Result.constructor-impl(r1.outMimeType);     // Catch: Throwable -> L13
    L15:
        Throwable r3 = Result.exceptionOrNull-impl(r10);
        if (r3 == null) goto L19;
        FLogger.a.e("BitmapHelper", "getImageFormat failed", r3);
    L19:
        if (Result.isFailure-impl(r10) == false) goto L22;
        return null;
    L22:
        return r10;
    L10:
        r9 = null;
    L13:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
