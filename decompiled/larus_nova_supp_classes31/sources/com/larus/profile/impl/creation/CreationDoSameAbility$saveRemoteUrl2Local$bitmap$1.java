package com.larus.profile.impl.creation;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.image.loader.ImageLoaderKt;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationDoSameAbility$saveRemoteUrl2Local$bitmap$1", f = "CreationDoSameAbility.kt", i = {}, l = {2467}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDoSameAbility$saveRemoteUrl2Local$bitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ Ref.ObjectRef<CloseableReference<CloseableImage>> $closeableReference;
    final /* synthetic */ String $url;
    Object L$0;
    int label;

    public CreationDoSameAbility$saveRemoteUrl2Local$bitmap$1(String r1, Ref.ObjectRef<CloseableReference<CloseableImage>> r2, Continuation<? super CreationDoSameAbility$saveRemoteUrl2Local$bitmap$1> r3) {
        this.$url = r1;
        this.$closeableReference = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationDoSameAbility$saveRemoteUrl2Local$bitmap$1(this.$url, this.$closeableReference, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        Ref.ObjectRef<CloseableReference<CloseableImage>> r2 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L26
    L15:
        CloseableReference r7 = (CloseableReference) r6;     // Catch: Throwable -> L26
        if (r7 == null) goto L23;
        r2.element = r7;     // Catch: Throwable -> L26
        Object r8 = r7.get();     // Catch: Throwable -> L26
        if ((r8 instanceof CloseableStaticBitmap) == false) goto L20;
        CloseableStaticBitmap r9 = (CloseableStaticBitmap) r8;     // Catch: Throwable -> L26
    L21:
        if (r9 == null) goto L23;
        Bitmap r10 = r9.getUnderlyingBitmap();     // Catch: Throwable -> L26
    L24:
        Object r11 = Result.constructor-impl(r10);     // Catch: Throwable -> L26
    L29:
        if (Result.isFailure-impl(r11) == false) goto L32;
        return null;
    L32:
        return r11;
    L20:
        r9 = null;
    L23:
        r10 = null;
        goto L24
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r6);
        String r12 = this.$url;
        Ref.ObjectRef<CloseableReference<CloseableImage>> r3 = this.$closeableReference;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L26
        this.L$0 = r3;     // Catch: Throwable -> L26
        this.label = 1;     // Catch: Throwable -> L26
        r6 = ImageLoaderKt.i(r12, "CreationDoSameAbility", null, this, 60);     // Catch: Throwable -> L26
        if (r6 != r0) goto L14;
        return r0;
    L14:
        r2 = r3;
    L26:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }
}
