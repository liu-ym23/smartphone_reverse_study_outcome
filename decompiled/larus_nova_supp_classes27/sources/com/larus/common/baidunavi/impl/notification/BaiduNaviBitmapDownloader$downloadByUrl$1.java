package com.larus.common.baidunavi.impl.notification;

import android.app.Application;
import android.graphics.Bitmap;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.annotation.CurrentIdleState;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.baidunavi.impl.notification.BaiduNaviBitmapDownloader$downloadByUrl$1", f = "BaiduNaviBitmapDownloader.kt", i = {}, l = {CurrentIdleState.FOCUS}, m = "invokeSuspend", n = {}, s = {})
final class BaiduNaviBitmapDownloader$downloadByUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $onFailure;
    final /* synthetic */ Function1<Bitmap, Unit> $onSuccess;
    final /* synthetic */ String $url;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public BaiduNaviBitmapDownloader$downloadByUrl$1(String r1, Function1<? super String, Unit> r2, Function1<? super Bitmap, Unit> r3, Continuation<? super BaiduNaviBitmapDownloader$downloadByUrl$1> r4) {
        this.$url = r1;
        this.$onFailure = r2;
        this.$onSuccess = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BaiduNaviBitmapDownloader$downloadByUrl$1(this.$url, this.$onFailure, this.$onSuccess, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L21
    L13:
        Bitmap r11 = (Bitmap) r10;     // Catch: Exception -> L21
        if (r11 != null) goto L18;
        FLogger.a.e("BaiduNaviBitmapDownloader", "Bitmap download fails. url: " + this.$url);
        Function1<String, Unit> r12 = this.$onFailure;
        if (r12 == null) goto L20;
        r12.invoke("Bitmap download fails.");
    L20:
        return Unit.INSTANCE;
    L18:
        this.$onSuccess.invoke(r11);
        goto L20
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        String r13 = this.$url;     // Catch: Exception -> L21
        Application r5 = AppHost.a.getApplication();     // Catch: Exception -> L21
        this.label = 1;     // Catch: Exception -> L21
        r10 = ImageLoaderKt.k(r13, "baidu_navi_bitmap_downloader", r5, null, this, 56);     // Catch: Exception -> L21
        if (r10 != r0) goto L13;
        return r0;
    L21:
        e = move-exception;
        FLogger.a.e("BaiduNaviBitmapDownloader", e.toString());
        Function1<String, Unit> r2 = this.$onFailure;
        if (r2 == null) goto L26;
        r2.invoke(e.toString());
    L26:
        return Unit.INSTANCE;
    }
}
