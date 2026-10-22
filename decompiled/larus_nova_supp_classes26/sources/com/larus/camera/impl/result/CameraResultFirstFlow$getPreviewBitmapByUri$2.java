package com.larus.camera.impl.result;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.result.CameraResultFirstFlow$getPreviewBitmapByUri$2", f = "CameraResultFirstFlow.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CameraResultFirstFlow$getPreviewBitmapByUri$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Bitmap> $decodeBitmap;
    final /* synthetic */ Uri $uri;
    int label;

    public CameraResultFirstFlow$getPreviewBitmapByUri$2(Context r1, Uri r2, Function0<Bitmap> r3, Continuation<? super CameraResultFirstFlow$getPreviewBitmapByUri$2> r4) {
        this.$context = r1;
        this.$uri = r2;
        this.$decodeBitmap = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CameraResultFirstFlow$getPreviewBitmapByUri$2(this.$context, this.$uri, this.$decodeBitmap, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r12);
        CameraResultFirstFlow r13 = CameraResultFirstFlow.a;
        long r0 = CameraResultFirstFlow.a(r13, this.$context, this.$uri);
        Bitmap r2 = (Bitmap) this.$decodeBitmap.invoke();
        long r3 = CameraResultFirstFlow.a(r13, this.$context, this.$uri);
        r13.getClass();
        boolean r5 = true;
        if (r0 >= 0) goto L7;
    L11:
        boolean r7 = false;
    L12:
        FLogger.a.i("CameraResultFirstFlow", "getPreviewBitmapByUri sizeBefore=" + r0 + ", sizeAfter=" + r3 + ", shouldReread=" + r7 + ", uri=" + this.$uri);
        if (r7 == false) goto L26;
        r13.getClass();
        if (r2 != null) goto L17;
    L19:
        r5 = false;
    L20:
        if (r5 == false) goto L23;
        r2.recycle();
    L23:
        return (Bitmap) this.$decodeBitmap.invoke();
    L17:
        if (r2.isRecycled() == true) goto L19;
    L26:
        return r2;
    L7:
        if (r3 < 0) goto L11;
        if (r0 == r3) goto L11;
        r7 = true;
        goto L12
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
