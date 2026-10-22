package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import android.graphics.Bitmap;
import android.os.Bundle;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$initPassedUrl$1$1", f = "ImageSelectorComponent.kt", i = {0}, l = {709}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class ImageSelectorComponent$initPassedUrl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $it;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ImageSelectorComponent this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$initPassedUrl$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent$initPassedUrl$1$1$1", f = "ImageSelectorComponent.kt", i = {}, l = {737, 750, 753, 753}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ String $it;
        Object L$0;
        int label;
        final /* synthetic */ ImageSelectorComponent this$0;

        public AnonymousClass1(ImageSelectorComponent r1, String r2, Bitmap r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$it = r2;
            this.$bitmap = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$it, this.$bitmap, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            String r2 = null;
            if (r1 == 0) goto L13;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L12;
            if (r1 == 3) goto L11;
            if (r1 == 4) goto L12;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ImageSelectorComponent r3 = (ImageSelectorComponent) this.L$0;
            ResultKt.throwOnFailure(r11);
        L56:
            Bitmap r12 = (Bitmap) r11;
            if (r12 != null) goto L59;
            r12 = this.$bitmap;
        L59:
            this.L$0 = null;
            this.label = 4;
            Lazy<Long> r4 = ImageSelectorComponent.X;
            if (r3.G4(r12, this) != r0) goto L63;
            return r0;
        L63:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r11);
            goto L63
        L13:
            ResultKt.throwOnFailure(r11);
            ImageSelectorComponent r13 = this.this$0;
            Lazy<Long> r5 = ImageSelectorComponent.X;
            ny9.s r14 = r13.G3();
            if (r14 != null) goto L16;
        L18:
            boolean r15 = false;
        L19:
            if (r15 == false) goto L23;
            ys8.a r16 = this.this$0.Z3();
            if (r16 == null) goto L23;
            r16.selectRatio(ImageSelectorComponent.a.a());
        L23:
            com.larus.uaigc.helper.f.a.getClass();
            if (com.larus.uaigc.helper.f.a() == false) goto L40;
            ImageSelectorComponent r17 = this.this$0;
            String r6 = this.$it;
            ny9.s r7 = r17.G3();
            if (r7 == null) goto L36;
            Bundle r8 = r7.a;
            if (r8 == null) goto L30;
            String r9 = r8.getString("ref_raw_image_url");
        L31:
            if (r9 == null) goto L36;
            if ((!StringsKt.isBlank(r9)) == false) goto L35;
            r2 = r9;
        L35:
            if (r2 == null) goto L36;
        L37:
            Bitmap r10 = this.$bitmap;
            this.label = 1;
            if (ImageSelectorComponent.z3(r17, r6, r2, r10, this) != r0) goto L63;
            return r0;
        L30:
            r9 = null;
        L36:
            r2 = this.$it;
            goto L37
        L40:
            this.this$0.X3().V5(new sy9.b.c(this.$bitmap, this.this$0.h5()));
            ImageSelectorComponent r18 = this.this$0;
            if (r18.Q == false) goto L52;
            ny9.s r19 = r18.G3();
            if (r19 == null) goto L48;
            Bundle r20 = r19.a;
            if (r20 == null) goto L47;
            r2 = r20.getString("ref_raw_image_url");
        L47:
            if (r2 == null) goto L48;
        L49:
            Bitmap r21 = this.$bitmap;
            this.label = 2;
            if (ImageSelectorComponent.Y2(r18, r2, r21, this) != r0) goto L63;
            return r0;
        L48:
            r2 = this.$it;
            goto L49
        L52:
            this.L$0 = r18;
            this.label = 3;
            Object r22 = r18.c4(this);
            if (r22 != r0) goto L55;
            return r0;
        L55:
            r3 = r18;
            r11 = r22;
            goto L56
        L16:
            if (r14.B() != true) goto L18;
            r15 = true;
            goto L19
        }
    }

    public ImageSelectorComponent$initPassedUrl$1$1(String r1, ImageSelectorComponent r2, Continuation<? super ImageSelectorComponent$initPassedUrl$1$1> r3) {
        this.$it = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        ImageSelectorComponent$initPassedUrl$1$1 r0 = new ImageSelectorComponent$initPassedUrl$1$1(this.$it, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r3 = r2;
    L12:
        Bitmap r11 = (Bitmap) r10;
        if (r11 == null) goto L15;
        BuildersKt.launch$default(r3, Dispatchers.getMain(), null, new AnonymousClass1(this.this$0, this.$it, r11, null), 2, null);
        return Unit.INSTANCE;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r12 = (CoroutineScope) this.L$0;
        CoroutineDispatcher r4 = Dispatchers.getIO();
        ImageSelectorComponent$initPassedUrl$1$1$bitmap$1 r5 = new ImageSelectorComponent$initPassedUrl$1$1$bitmap$1(this.$it, this.this$0, null);
        this.L$0 = r12;
        this.label = 1;
        Object r6 = BuildersKt.withContext(r4, r5, this);
        if (r6 != r0) goto L11;
        return r0;
    L11:
        r3 = r12;
        r10 = r6;
        goto L12
    }
}
