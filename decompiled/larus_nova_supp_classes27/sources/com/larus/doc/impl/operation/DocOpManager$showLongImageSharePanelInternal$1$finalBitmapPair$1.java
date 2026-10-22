package com.larus.doc.impl.operation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.common.utility.BitmapUtils;
import com.larus.dora.impl.ota.g2.j0;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Landroid/graphics/Bitmap;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$showLongImageSharePanelInternal$1$finalBitmapPair$1", f = "DocOpManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DocOpManager$showLongImageSharePanelInternal$1$finalBitmapPair$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Bitmap, ? extends Boolean>>, Object> {
    final /* synthetic */ String $path;
    final /* synthetic */ int $targetWidth;
    int label;

    public DocOpManager$showLongImageSharePanelInternal$1$finalBitmapPair$1(String r1, int r2, Continuation<? super DocOpManager$showLongImageSharePanelInternal$1$finalBitmapPair$1> r3) {
        this.$path = r1;
        this.$targetWidth = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DocOpManager$showLongImageSharePanelInternal$1$finalBitmapPair$1(this.$path, this.$targetWidth, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Pair<Bitmap, Boolean>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L49;
        ResultKt.throwOnFailure(r14);
        DocOpManager r15 = DocOpManager.a;
        String r16 = this.$path;
        int r0 = this.$targetWidth;
        BitmapFactory.Options r4 = new BitmapFactory.Options();     // Catch: Throwable -> L45
        r4.inJustDecodeBounds = true;     // Catch: Throwable -> L45
        BitmapFactory.decodeFile(r16, r4);     // Catch: Throwable -> L45
        int r6 = r4.outWidth;     // Catch: Throwable -> L45
        if (r6 <= 0) goto L57;
        int r7 = r4.outHeight;     // Catch: Throwable -> L45
        if (r7 <= 0) goto L57;
        long r8 = ((long) r6) * ((long) r7);     // Catch: Throwable -> L45
        if (r8 > 16777216) goto L13;
        FLogger.a.i("DocOpManager", "loadSafeScaledBitmap: totalPixels <= thresholdPixels, path:" + r16);     // Catch: Throwable -> L45
        return new Pair(BitmapUtils.getBitmapFromSD(r16), Boolean.TRUE);
    L13:
        r4.inJustDecodeBounds = false;     // Catch: Throwable -> L45
        r4.inPreferredConfig = Bitmap.Config.RGB_565;     // Catch: Throwable -> L45
        if (r8 <= 52428800) goto L27;
        int r9 = (int) (52428800 / ((long) r0));     // Catch: Throwable -> L45
        if (r7 > r9) goto L20;
        if (r6 > r0) goto L20;
        int r10 = 1;
    L26:
        r4.inSampleSize = r10;     // Catch: Throwable -> L45
        FLogger.a.i("DocOpManager", "loadSafeScaledBitmap: downsampling, sampleSize=" + r10 + ", target=" + r0 + 'x' + r9 + ", original=" + r4.outWidth + 'x' + r4.outHeight);     // Catch: Throwable -> L45
    L20:
        int r11 = r7 / 2;     // Catch: Throwable -> L45
        int r12 = r6 / 2;     // Catch: Throwable -> L45
        r10 = 1;
    L22:
        if ((r11 / r10) < r9) goto L26;
        if ((r12 / r10) < r0) goto L26;
        r10 = r10 * 2;     // Catch: Throwable -> L45
    L27:
        Bitmap r17 = BitmapFactory.decodeFile(r16, r4);     // Catch: Throwable -> L45
        if (r17 != null) goto L31;
        return new Pair(null, Boolean.TRUE);
    L31:
        if (r17.getWidth() <= r0) goto L36;
        Bitmap r1 = Bitmap.createScaledBitmap(r17, r0, (int) ((r17.getHeight() / r17.getWidth()) * r0), true);     // Catch: Throwable -> L45
        if (Intrinsics.areEqual(r1, r17) == true) goto L35;
        r17.recycle();     // Catch: Throwable -> L45
    L35:
        r17 = r1;
    L36:
        long r13 = r17.getAllocationByteCount();     // Catch: Throwable -> L45
        if (r13 <= j0.G2_OTA_SPACE_CHECK_BYTES) goto L42;
        double r18 = Math.sqrt(j0.G2_OTA_SPACE_CHECK_BYTES / r13);     // Catch: Throwable -> L45
        int r2 = RangesKt.coerceAtLeast((int) (((double) r17.getWidth()) * r18), 1);     // Catch: Throwable -> L45
        int r5 = RangesKt.coerceAtLeast((int) (((double) r17.getHeight()) * r18), 1);     // Catch: Throwable -> L45
        Bitmap r20 = Bitmap.createScaledBitmap(r17, r2, r5, true);     // Catch: Throwable -> L45
        if (Intrinsics.areEqual(r20, r17) == true) goto L41;
        r17.recycle();     // Catch: Throwable -> L45
    L41:
        FLogger.a.i("DocOpManager", "bitmap re-scaled to fit byte budget: " + r17.getWidth() + 'x' + r17.getHeight() + '(' + r13 + "B) -> " + r2 + 'x' + r5 + '(' + r20.getAllocationByteCount() + "B)");     // Catch: Throwable -> L45
        return new Pair(r20, Boolean.FALSE);
    L42:
        FLogger.a.i("DocOpManager", "loadSafeScaledBitmap: currentBytes=" + r13 + ", maxSafeBytes=" + j0.G2_OTA_SPACE_CHECK_BYTES);     // Catch: Throwable -> L45
        return new Pair(r17, Boolean.TRUE);
    L57:
        return new Pair(null, Boolean.TRUE);
    L45:
        th = move-exception;
        FLogger.a.e("DocOpManager", "loadSafeScaledBitmap failed", th);
        return new Pair(null, Boolean.TRUE);
    L49:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
