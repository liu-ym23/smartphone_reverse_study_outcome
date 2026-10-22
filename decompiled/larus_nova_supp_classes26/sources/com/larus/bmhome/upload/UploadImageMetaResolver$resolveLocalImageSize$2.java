package com.larus.bmhome.upload;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.UploadImageMetaResolver$resolveLocalImageSize$2", f = "UploadImageMetaResolver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UploadImageMetaResolver$resolveLocalImageSize$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Integer, ? extends Integer>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $path;
    final /* synthetic */ boolean $pathIsUri;
    private /* synthetic */ Object L$0;
    int label;

    public UploadImageMetaResolver$resolveLocalImageSize$2(boolean r1, String r2, Context r3, Continuation<? super UploadImageMetaResolver$resolveLocalImageSize$2> r4) {
        this.$pathIsUri = r1;
        this.$path = r2;
        this.$context = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        UploadImageMetaResolver$resolveLocalImageSize$2 r0 = new UploadImageMetaResolver$resolveLocalImageSize$2(this.$pathIsUri, this.$path, this.$context, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Pair<Integer, Integer>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L43;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        boolean r10 = this.$pathIsUri;
        String r1 = this.$path;
        Context r2 = this.$context;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L35
        BitmapFactory.Options r5 = new BitmapFactory.Options();     // Catch: Throwable -> L35
        r5.inJustDecodeBounds = true;     // Catch: Throwable -> L35
        if (r10 == false) goto L8;
        Uri r6 = UriProtector.parse(r1);     // Catch: Throwable -> L35
    L9:
        if (r10 == false) goto L21;
        InputStream r3 = ContentResolverWrapper.openInputStream(r2.getContentResolver(), r6);     // Catch: Throwable -> L35
        if (r3 != null) goto L44;
    L22:
        int r7 = r5.outWidth;     // Catch: Throwable -> L35
        int r11 = r5.outHeight;     // Catch: Throwable -> L35
        if (r7 <= 0) goto L26;
        if (r11 <= 0) goto L26;
        boolean r12 = true;
    L27:
        if (r12 == false) goto L34;
        UploadImageMetaResolver r13 = UploadImageMetaResolver.a;     // Catch: Throwable -> L35
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L35
        if (UploadImageMetaResolver.a(r13, r2, r6) == false) goto L31;
        Pair r14 = TuplesKt.to(Boxing.boxInt(r11), Boxing.boxInt(r7));     // Catch: Throwable -> L35
    L32:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L35
    L37:
        Context r0 = this.$context;
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L49;
        FLogger.a.e("UploadImageMetaResolver", "[resolveLocalImageSize] parse local image size failed", r16);
        int r17 = RangesKt.coerceAtLeast((int) (m0.b(r0) * UploadImageMetaResolver.b), 1);
        return TuplesKt.to(Boxing.boxInt(r17), Boxing.boxInt(r17));
    L49:
        return r15;
    L31:
        r14 = TuplesKt.to(Boxing.boxInt(r7), Boxing.boxInt(r11));     // Catch: Throwable -> L35
        goto L32
    L34:
        throw new IllegalArgumentException(("invalid image size, width=" + r7 + ", height=" + r11 + ", pathIsUri=" + r10).toString());     // Catch: Throwable -> L35
    L26:
        r12 = false;
        goto L27
    L44:
        BitmapFactory.decodeStream(r3, null, r5);     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r3, null);     // Catch: Throwable -> L35
        goto L22
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L21:
        BitmapFactory.decodeFile(r1, r5);     // Catch: Throwable -> L35
        goto L22
    L8:
        r6 = Uri.fromFile(new PolarisFileWrapper(r1));     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    L43:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
