package com.larus.bmhome.chat.component.bottom.attachment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.util.LruCache;
import androidx.exifinterface.media.ExifInterface;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
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
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.attachment.AlbumEduIntentSuggestController$detect$bitmap$1", f = "AlbumEduIntentSuggestController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AlbumEduIntentSuggestController$detect$bitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ oq9.c $config;
    final /* synthetic */ a $source;
    int label;
    final /* synthetic */ AlbumEduIntentSuggestController this$0;

    public AlbumEduIntentSuggestController$detect$bitmap$1(AlbumEduIntentSuggestController r1, a r2, oq9.c r3, Continuation<? super AlbumEduIntentSuggestController$detect$bitmap$1> r4) {
        this.this$0 = r1;
        this.$source = r2;
        this.$config = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AlbumEduIntentSuggestController$detect$bitmap$1(this.this$0, this.$source, this.$config, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L99;
        ResultKt.throwOnFailure(r18);
        AlbumEduIntentSuggestController r0 = this.this$0;
        Uri r2 = ((a.b) this.$source).a;
        float r3 = this.$config.d();
        LruCache<String, ix8.d> r4 = AlbumEduIntentSuggestController.h;
        r0.getClass();
        BitmapFactory.Options r5 = new BitmapFactory.Options();
        r5.inJustDecodeBounds = true;
        InputStream r6 = r0.h(r2);
        if (r6 == null) goto L15;
        BitmapFactory.decodeStream(r6, null, r5);     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r6, null);
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);
        throw th;
    L15:
        if (r5.outWidth > 0) goto L17;
        return null;
    L17:
        if (r5.outHeight <= 0) goto L119;
        Float r7 = Float.valueOf(r3);
        if (r7.floatValue() <= 0.0f) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == true) goto L26;
        r7 = null;
    L26:
        if (r7 == null) goto L28;
        float r9 = r7.floatValue();
    L29:
        int r10 = 1;
    L30:
        int r11 = r10 * 2;
        if ((Math.min(r5.outWidth, r5.outHeight) / r11) < r9) goto L33;
        r10 = r11;
        goto L30
    L33:
        InputStream r12 = r0.h(r2);
        if (r12 == null) goto L116;
        BitmapFactory.Options r13 = new BitmapFactory.Options();     // Catch: Throwable -> L91
        r13.inSampleSize = r10;     // Catch: Throwable -> L91
        r13.inPreferredConfig = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L91
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L91
        Bitmap r15 = BitmapFactory.decodeStream(r12, null, r13);     // Catch: Throwable -> L91
        CloseableKt.closeFinally(r12, null);
        if (r15 == null) goto L120;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L64
        InputStream r17 = r0.h(r2);     // Catch: Throwable -> L64
        if (r17 != null) goto L102;
        int r1 = 0;
    L62:
        Object r19 = Result.constructor-impl(Integer.valueOf(r1));     // Catch: Throwable -> L64
    L66:
        Throwable r20 = Result.exceptionOrNull-impl(r19);
        if (r20 == null) goto L70;
        FLogger.a.w("AlbumEduIntentSuggest", "[readExifRotation] failed: " + r20.getMessage());
    L70:
        if (Result.isFailure-impl(r19) == false) goto L72;
        r19 = 0;
    L72:
        int r21 = ((Number) r19).intValue();
        if (r21 != 0) goto L111;
        return r15;
    L111:
        int r110 = r15.getWidth();     // Catch: Throwable -> L81
        int r111 = r15.getHeight();     // Catch: Throwable -> L81
        Matrix r112 = new Matrix();     // Catch: Throwable -> L81
        r112.postRotate(r21);     // Catch: Throwable -> L81
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L81
        Bitmap r23 = Bitmap.createBitmap(r15, 0, 0, r110, r111, r112, true);     // Catch: Throwable -> L81
        if (r23 == r15) goto L79;
        r15.recycle();     // Catch: Throwable -> L81
    L79:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L81
    L83:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L86;
        FLogger.a.e("AlbumEduIntentSuggest", "[decodeSampledBitmap] rotate failed", r25);
    L86:
        Object r26 = r15;
        if (Result.isFailure-impl(r24) == true) goto L118;
        r26 = r24;
    L118:
        return (Bitmap) r26;
    L81:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L83
    L102:
        int r28 = new ExifInterface(r17).getAttributeInt("Orientation", 1);     // Catch: Throwable -> L54
    L43:
        if (r28 != 3) goto L45;
        r1 = DoraCallStateCode.ENV_OBSERVE_END;
    L52:
        CloseableKt.closeFinally(r17, null);     // Catch: Throwable -> L64
        goto L62
    L45:
        if (r28 != 6) goto L47;
        r1 = 90;
        goto L52
    L47:
        if (r28 == 8) goto L49;
        r1 = 0;
        goto L52
    L49:
        r1 = 270;
    L54:
        th = move-exception;
        throw th;     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        CloseableKt.closeFinally(r17, th);     // Catch: Throwable -> L64
        throw th;     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r19 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L66
    L120:
        return null;
    L91:
        th = move-exception;
        throw th;     // Catch: Throwable -> L94
    L94:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    L116:
        return null;
    L28:
        r9 = 720.0f;
        goto L29
    L22:
        r8 = false;
        goto L23
    L119:
        return null;
    L99:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
