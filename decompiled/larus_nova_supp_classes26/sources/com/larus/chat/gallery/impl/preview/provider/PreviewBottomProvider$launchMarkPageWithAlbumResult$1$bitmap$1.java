package com.larus.chat.gallery.impl.preview.provider;

import android.graphics.Bitmap;
import com.larus.image.loader.ImageLoaderKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.provider.PreviewBottomProvider$launchMarkPageWithAlbumResult$1$bitmap$1", f = "PreviewBottomProvider.kt", i = {}, l = {988}, m = "invokeSuspend", n = {}, s = {})
public final class PreviewBottomProvider$launchMarkPageWithAlbumResult$1$bitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ String $currentImagePath;
    int label;

    public PreviewBottomProvider$launchMarkPageWithAlbumResult$1$bitmap$1(String r1, Continuation<? super PreviewBottomProvider$launchMarkPageWithAlbumResult$1$bitmap$1> r2) {
        this.$currentImagePath = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new PreviewBottomProvider$launchMarkPageWithAlbumResult$1$bitmap$1(this.$currentImagePath, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        return r8;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        String r2 = this.$currentImagePath;
        this.label = 1;
        r8 = ImageLoaderKt.n(r2, "PreviewBottomProvider", null, null, this, 124);
        if (r8 != r0) goto L11;
        return r0;
    }
}
