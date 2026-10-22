package com.bytedance.ai.widget.contianer;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.ai.model.objects.Applet;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.z;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.widget.contianer.AppletWidgetContainer$loadIcon$newJob$1", f = "AppletWidgetContainer.kt", i = {}, l = {StatusLine.HTTP_TEMP_REDIRECT, 316}, m = "invokeSuspend", n = {}, s = {})
final class AppletWidgetContainer$loadIcon$newJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f3008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Applet f3009c;
    public final /* synthetic */ String d;

    /* JADX INFO: renamed from: com.bytedance.ai.widget.contianer.AppletWidgetContainer$loadIcon$newJob$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.widget.contianer.AppletWidgetContainer$loadIcon$newJob$1$1", f = "AppletWidgetContainer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f3010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f3011b;

        public AnonymousClass1(Bitmap r5, ImageView r10, Continuation r11) {
            this.f3010a = r5;
            this.f3011b = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object r5, Continuation r10) {
            return new AnonymousClass1(this.f3010a, this.f3011b, r10);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
            Bitmap r11 = this.f3010a;
            ImageView r12 = this.f3011b;
            return new AnonymousClass1(r11, r12, r10).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(r5);
            Bitmap r10 = this.f3010a;
            if (r10 == null) goto L5;
            this.f3011b.setImageBitmap(r10);
            this.f3011b.setVisibility(0);
        L7:
            return Unit.INSTANCE;
        L5:
            this.f3011b.setVisibility(8);
            goto L7
        }
    }

    public AppletWidgetContainer$loadIcon$newJob$1(ImageView r5, Applet r10, String r11, Continuation r12) {
        this.f3008b = r5;
        this.f3009c = r10;
        this.d = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new AppletWidgetContainer$loadIcon$newJob$1(this.f3008b, this.f3009c, this.d, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((AppletWidgetContainer$loadIcon$newJob$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f3007a;
        if (r11 == 0) goto L12;
        if (r11 == 1) goto L10;
        if (r11 != 2) goto L9;
        ResultKt.throwOnFailure(r10);     // Catch: CancellationException -> L19
    L21:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);     // Catch: CancellationException -> L19
    L16:
        MainCoroutineDispatcher r12 = Dispatchers.getMain().getImmediate();     // Catch: CancellationException -> L19
        AnonymousClass1 r13 = new AnonymousClass1((Bitmap) r10, this.f3008b, null);     // Catch: CancellationException -> L19
        this.f3007a = 2;     // Catch: CancellationException -> L19
        if (BuildersKt.withContext(r12, r13, this) != r5) goto L21;
    L18:
        return r5;
    L12:
        ResultKt.throwOnFailure(r10);
        this.f3008b.setVisibility(0);     // Catch: CancellationException -> L19
        z r14 = Dispatchers.getIO();     // Catch: CancellationException -> L19
        AppletWidgetContainer$loadIcon$newJob$1$bmp$1 r15 = new AppletWidgetContainer$loadIcon$newJob$1$bmp$1(this.f3009c, this.d, null);     // Catch: CancellationException -> L19
        this.f3007a = 1;     // Catch: CancellationException -> L19
        r10 = BuildersKt.withContext(r14, r15, this);     // Catch: CancellationException -> L19
        if (r10 != r5) goto L16;
    L19:
        this.f3008b.setVisibility(8);
        goto L21
    }
}
