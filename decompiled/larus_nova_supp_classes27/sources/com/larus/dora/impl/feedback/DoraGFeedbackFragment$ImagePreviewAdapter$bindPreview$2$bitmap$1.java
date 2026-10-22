package com.larus.dora.impl.feedback;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.util.Size;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import java.io.InputStream;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraGFeedbackFragment$ImagePreviewAdapter$bindPreview$2$bitmap$1", f = "DoraGFeedbackFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGFeedbackFragment$ImagePreviewAdapter$bindPreview$2$bitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ boolean $isVideo;
    final /* synthetic */ int $targetSize;
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ DoraGFeedbackFragment.ImagePreviewAdapter this$0;

    public DoraGFeedbackFragment$ImagePreviewAdapter$bindPreview$2$bitmap$1(DoraGFeedbackFragment.ImagePreviewAdapter r1, Context r2, Uri r3, boolean r4, int r5, Continuation<? super DoraGFeedbackFragment$ImagePreviewAdapter$bindPreview$2$bitmap$1> r6) {
        this.this$0 = r1;
        this.$appContext = r2;
        this.$uri = r3;
        this.$isVideo = r4;
        this.$targetSize = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DoraGFeedbackFragment$ImagePreviewAdapter$bindPreview$2$bitmap$1(this.this$0, this.$appContext, this.$uri, this.$isVideo, this.$targetSize, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L57;
        ResultKt.throwOnFailure(r12);
        DoraGFeedbackFragment.ImagePreviewAdapter r13 = this.this$0;
        Context r0 = this.$appContext;
        Intrinsics.checkNotNull(r0);
        Uri r1 = this.$uri;
        boolean r2 = this.$isVideo;
        int r9 = this.$targetSize;
        r13.getClass();
        Bitmap r10 = null;
        if (r2 == false) goto L18;
        MediaMetadataRetriever r3 = new MediaMetadataRetriever();
        r3.setDataSource(r0, r1);     // Catch: Throwable -> L14
        if (Build.VERSION.SDK_INT < 27) goto L10;
        Bitmap r4 = r3.getScaledFrameAtTime(0, 2, r9, r9);     // Catch: Throwable -> L14
    L11:
        if (r4 == null) goto L13;
        r10 = r13.y2(r4, r9);     // Catch: Throwable -> L14
    L13:
        r3.release();
        return r10;
    L10:
        r4 = r3.getFrameAtTime(0, 2);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r3.release();
        throw th;
    L18:
        if (Build.VERSION.SDK_INT >= 29) goto L71;
        BitmapFactory.Options r5 = new BitmapFactory.Options();
        int r6 = 1;
        r5.inJustDecodeBounds = true;
        InputStream r7 = ContentResolverWrapper.openInputStream(r0.getContentResolver(), r1);
        if (r7 == null) goto L30;
        BitmapFactory.decodeStream(r7, null, r5);     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r7, null);
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L30:
        if (r5.outWidth > 0) goto L32;
        return null;
    L32:
        if (r5.outHeight <= 0) goto L74;
        BitmapFactory.Options r8 = new BitmapFactory.Options();
        int r11 = r5.outHeight;
        int r14 = r5.outWidth;
        if (r11 > r9) goto L37;
        if (r14 > r9) goto L37;
    L43:
        r8.inSampleSize = r6;
        InputStream r15 = ContentResolverWrapper.openInputStream(r0.getContentResolver(), r1);
        if (r15 != null) goto L58;
        Bitmap r16 = null;
    L53:
        if (r16 != null) goto L55;
        return null;
    L55:
        return r13.y2(r16, r9);
    L58:
        r16 = BitmapFactory.decodeStream(r15, null, r8);     // Catch: Throwable -> L47
        CloseableKt.closeFinally(r15, null);
    L47:
        th = move-exception;
        throw th;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);
        throw th;
    L37:
        int r17 = r11 / 2;
        int r18 = r14 / 2;
    L39:
        if ((r17 / r6) < r9) goto L43;
        if ((r18 / r6) < r9) goto L43;
        r6 = r6 * 2;
        goto L39
    L74:
        return null;
    L71:
        return r0.getContentResolver().loadThumbnail(r1, new Size(r9, r9), null);
    L57:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
