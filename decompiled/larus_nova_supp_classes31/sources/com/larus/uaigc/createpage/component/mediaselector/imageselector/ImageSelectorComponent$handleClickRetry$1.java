package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$handleClickRetry$1", f = "ImageSelectorComponent.kt", i = {1}, l = {1459, 1466}, m = "invokeSuspend", n = {"retryPath"}, s = {"L$0"})
final class ImageSelectorComponent$handleClickRetry$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$handleClickRetry$1(ImageSelectorComponent r1, Continuation<? super ImageSelectorComponent$handleClickRetry$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ImageSelectorComponent$handleClickRetry$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r5 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r12);
    L29:
        Bitmap r3 = (Bitmap) r12;
        String r13 = r2;
    L31:
        if (Intrinsics.areEqual(this.this$0.C, r13) == false) goto L33;
        ImageSelectorUploadPreviewHelper r4 = this.this$0.h4();
        int r6 = ImageSelectorUploadPreviewHelper.d;
        r4.d(r3, null);
        this.this$0.m.setValue(ry9.j.h.b);
        ny9.s r7 = this.this$0.G3();
        if (r7 != null) goto L37;
    L39:
        r5 = false;
    L40:
        if (r5 == false) goto L44;
        ys8.a r8 = this.this$0.Z3();
        if (r8 == null) goto L44;
        Lazy<Long> r9 = ImageSelectorComponent.X;
        r8.selectRatio(ImageSelectorComponent.a.a());
    L44:
        com.larus.uaigc.helper.f.a.getClass();
        if (com.larus.uaigc.helper.f.a() == true) goto L47;
    L49:
        this.this$0.F4(r13, null);
    L51:
        return Unit.INSTANCE;
    L47:
        if (com.larus.uaigc.helper.g.b(r13) == false) goto L49;
        ImageSelectorComponent r10 = this.this$0;
        Uri r14 = UriProtector.parse(r13);
        r10.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r10), null, null, new ImageSelectorComponent$startAlbumResourceAccess$1(r14, r10, false, null), 3, null);
        goto L51
    L37:
        if (r7.B() != true) goto L39;
    L33:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L13:
        r13 = (String) r12;
        if (r13 != null) goto L16;
    L19:
        boolean r11 = true;
    L20:
        if (r11 == false) goto L23;
        FLogger.a.e("ImageSelectorComponent", "handleClickRetry failed, retry local path is empty");
        t19.s r15 = t19.s.a;
        Context r16 = this.this$0.getContext();
        r15.getClass();
        t19.s.s(r16, 2131907666);
        ImageSelectorComponent r17 = this.this$0;
        Lazy<Long> r18 = ImageSelectorComponent.X;
        r17.R4();
        return Unit.INSTANCE;
    L23:
        ImageSelectorComponent r19 = this.this$0;
        Lazy<Long> r20 = ImageSelectorComponent.X;
        r3 = r19.X3().getCurBitmap();
        if (r3 != null) goto L31;
        CoroutineDispatcher r21 = Dispatchers.getIO();
        ImageSelectorComponent$handleClickRetry$1$bitmap$1 r22 = new ImageSelectorComponent$handleClickRetry$1$bitmap$1(this.this$0, r13, null);
        this.L$0 = r13;
        this.label = 2;
        Object r23 = BuildersKt.withContext(r21, r22, this);
        if (r23 != r0) goto L28;
        return r0;
    L28:
        r2 = r13;
        r12 = r23;
        goto L29
    L16:
        if (r13.length() == 0) goto L19;
        r11 = false;
        goto L20
    L10:
        ResultKt.throwOnFailure(r12);
        ImageSelectorComponent r110 = this.this$0;
        this.label = 1;
        r12 = ImageSelectorComponent.p3(r110, this);
        if (r12 != r0) goto L13;
        return r0;
    }
}
