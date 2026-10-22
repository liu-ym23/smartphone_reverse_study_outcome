package com.larus.uaigc.createpage.component.digitalavatar;

import android.graphics.Bitmap;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.uaigc.createpage.utils.BitmapHelperKt;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$initWhiteTUrl$1$2$1$1$bitmap$1", f = "DigitalAvatarComponent.kt", i = {}, l = {711}, m = "invokeSuspend", n = {}, s = {})
public final class DigitalAvatarComponent$initWhiteTUrl$1$2$1$1$bitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ String $it;
    int label;

    public DigitalAvatarComponent$initWhiteTUrl$1$2$1$1$bitmap$1(String r1, Continuation<? super DigitalAvatarComponent$initWhiteTUrl$1$2$1$1$bitmap$1> r2) {
        this.$it = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DigitalAvatarComponent$initWhiteTUrl$1$2$1$1$bitmap$1(this.$it, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.uaigc.createpage.component.digitalavatar.p] */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L19
    L13:
        Bitmap r11 = (Bitmap) r10;     // Catch: Throwable -> L19
        if (r11 == null) goto L16;
        Bitmap r12 = BitmapHelperKt.g(r11);     // Catch: Throwable -> L19
    L17:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r13) == false) goto L25;
        return null;
    L25:
        return r13;
    L16:
        r12 = null;
        goto L17
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        String r14 = this.$it;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L19
        ?? r6 = new p();     // Catch: Throwable -> L19
        this.label = 1;     // Catch: Throwable -> L19
        r10 = ImageLoaderKt.k(r14, "creation_page_digital_avatar_white_t", null, r6, this, 28);     // Catch: Throwable -> L19
        if (r10 != r0) goto L13;
        return r0;
    L19:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }
}
