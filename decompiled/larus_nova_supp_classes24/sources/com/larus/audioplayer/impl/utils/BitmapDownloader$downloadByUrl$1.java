package com.larus.audioplayer.impl.utils;

import android.net.Uri;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.common.apphost.AppHost;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audioplayer.impl.utils.BitmapDownloader$downloadByUrl$1", f = "BitmapDownloader.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
public final class BitmapDownloader$downloadByUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BitmapDownloader.a $dataSubscriber;
    final /* synthetic */ String $url;
    int label;

    public BitmapDownloader$downloadByUrl$1(String r1, BitmapDownloader.a r2, Continuation<? super BitmapDownloader$downloadByUrl$1> r3) {
        this.$url = r1;
        this.$dataSubscriber = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BitmapDownloader$downloadByUrl$1(this.$url, this.$dataSubscriber, r4);
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
    L11:
        ImageRequest r5 = ImageRequestBuilder.newBuilderWithSource((Uri) r4).build();
        Fresco.getImagePipeline().fetchDecodedImage(r5, AppHost.a.getApplication()).subscribe(this.$dataSubscriber, UiThreadImmediateExecutorService.getInstance());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        String r6 = this.$url;
        this.label = 1;
        r4 = ImageLoaderKt.r(r6, "bitmap_downloader", this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
