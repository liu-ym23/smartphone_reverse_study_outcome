package com.bytedance.ai.widget.contianer;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.resource.e0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.contianer.AppletWidgetContainer$loadIcon$newJob$1$bmp$1", f = "AppletWidgetContainer.kt", i = {}, l = {309}, m = "invokeSuspend", n = {}, s = {})
final class AppletWidgetContainer$loadIcon$newJob$1$bmp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Applet f3013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3014c;

    public AppletWidgetContainer$loadIcon$newJob$1$bmp$1(Applet r5, String r10, Continuation r11) {
        this.f3013b = r5;
        this.f3014c = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AppletWidgetContainer$loadIcon$newJob$1$bmp$1(this.f3013b, this.f3014c, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Bitmap> r10) {
        Applet r11 = this.f3013b;
        String r12 = this.f3014c;
        return new AppletWidgetContainer$loadIcon$newJob$1$bmp$1(r11, r12, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f3012a;
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L8;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L15
    L13:
        return (Bitmap) r5;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        LruCache r12 = e0.f2711a;     // Catch: Throwable -> L15
        String r13 = this.f3013b.f2276x;     // Catch: Throwable -> L15
        String r14 = this.f3014c;     // Catch: Throwable -> L15
        this.f3012a = 1;     // Catch: Throwable -> L15
        r5 = e0.a(r13, r14, this);     // Catch: Throwable -> L15
        if (r5 != r10) goto L13;
        return r10;
    L15:
        return null;
    }
}
