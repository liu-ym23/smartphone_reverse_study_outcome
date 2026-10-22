package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.graphics.BitmapFactory;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$preShowUploadingUri$2$1$1", f = "ImageSelectorComponent.kt", i = {}, l = {1651}, m = "invokeSuspend", n = {}, s = {})
public final class ImageSelectorComponent$preShowUploadingUri$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromInit;
    final /* synthetic */ boolean $needFixSize;
    final /* synthetic */ BitmapFactory.Options $options;
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$preShowUploadingUri$2$1$1(boolean r1, ImageSelectorComponent r2, boolean r3, BitmapFactory.Options r4, Continuation<? super ImageSelectorComponent$preShowUploadingUri$2$1$1> r5) {
        this.$fromInit = r1;
        this.this$0 = r2;
        this.$needFixSize = r3;
        this.$options = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ImageSelectorComponent$preShowUploadingUri$2$1$1(this.$fromInit, this.this$0, this.$needFixSize, this.$options, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L13:
        ImageSelectorComponent r5 = this.this$0;
        Lazy<Long> r2 = ImageSelectorComponent.X;
        ImageSelectorUploadPreviewHelper r6 = r5.h4();
        if (this.$needFixSize == false) goto L16;
        Pair<Integer, Integer> r3 = TuplesKt.to(Boxing.boxInt(this.$options.outHeight), Boxing.boxInt(this.$options.outWidth));
    L17:
        r6.d(null, r3);
        return Unit.INSTANCE;
    L16:
        r3 = TuplesKt.to(Boxing.boxInt(this.$options.outWidth), Boxing.boxInt(this.$options.outHeight));
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        if (this.$fromInit == true) goto L13;
        this.label = 1;
        if (DelayKt.delay(150, this) != r0) goto L13;
        return r0;
    }
}
