package com.larus.camera.impl.ui.viewmodel;

import android.graphics.Bitmap;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.OutputParam;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$download$1$filePath$1", f = "CameraResultViewModel.kt", i = {0, 1}, l = {1063, 1074, 1079, 1086, 1091}, m = "invokeSuspend", n = {"useNoWatermarkForMarkDownload", "noWatermarkMarkedBitmap"}, s = {"Z$0", "L$0"})
public final class CameraResultViewModel$download$1$filePath$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ OutputParam $currentOutputParam;
    Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ CameraResultViewModel this$0;

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$download$1$filePath$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$download$1$filePath$1$1", f = "CameraResultViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        final /* synthetic */ Bitmap $changedPreviewBitmap;
        int label;
        final /* synthetic */ CameraResultViewModel this$0;

        public AnonymousClass1(CameraResultViewModel r1, Bitmap r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$changedPreviewBitmap = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$changedPreviewBitmap, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r4);
            return CameraResultViewModel.access$ability(this.this$0).k(this.$changedPreviewBitmap, 0, null);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CameraResultViewModel$download$1$filePath$1(CameraResultViewModel r1, OutputParam r2, Continuation<? super CameraResultViewModel$download$1$filePath$1> r3) {
        this.this$0 = r1;
        this.$currentOutputParam = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new CameraResultViewModel$download$1$filePath$1(this.this$0, this.$currentOutputParam, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super String> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r16) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r12 = true;
        if (r0 == 0) goto L16;
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L14;
        if (r0 == 3) goto L13;
        if (r0 == 4) goto L12;
        if (r0 != 5) goto L11;
        ResultKt.throwOnFailure(r16);
        Object r1 = r16;
    L75:
        return (String) r1;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r16);
        Object r2 = r16;
    L76:
        return (String) r2;
    L13:
        ResultKt.throwOnFailure(r16);
        Object r3 = r16;
    L46:
        Bitmap r4 = (Bitmap) r3;
    L64:
        if (r4 == null) goto L69;
        CoroutineDispatcher r5 = Dispatchers.getIO();
        AnonymousClass1 r6 = new AnonymousClass1(this.this$0, r4, null);
        this.L$0 = null;
        this.label = 4;
        r2 = BuildersKt.withContext(r5, r6, this);
        if (r2 != r7) goto L76;
        return r7;
    L69:
        Bitmap r8 = CameraResultViewModel.access$getPreviewImage(this.this$0);
        if (r8 == null) goto L77;
        CameraResultViewModel r9 = this.this$0;
        CoroutineDispatcher r10 = Dispatchers.getIO();
        CameraResultViewModel$download$1$filePath$1$2$1 r11 = new CameraResultViewModel$download$1$filePath$1$2$1(r9, r8, null);
        this.L$0 = null;
        this.label = 5;
        r1 = BuildersKt.withContext(r10, r11, this);
        if (r1 != r7) goto L75;
        return r7;
    L77:
        return null;
    L14:
        r4 = (Bitmap) this.L$0;
        ResultKt.throwOnFailure(r16);
        Object r13 = r16;
    L35:
        Bitmap r14 = (Bitmap) r13;
        if (r14 == null) goto L38;
        Bitmap r15 = CameraResultViewModel.access$applyMarkedMaskIfNeeded(this.this$0, this.$currentOutputParam, r14);
    L39:
        if (r4 != null) goto L64;
        if (r15 == null) goto L42;
        r4 = r15;
        goto L64
    L42:
        if (this.this$0.shouldUseOriginalImageDeferredEdit(this.$currentOutputParam) == false) goto L47;
        CameraResultViewModel r17 = this.this$0;
        OutputParam r18 = this.$currentOutputParam;
        Bitmap r19 = CameraResultViewModel.access$getPreviewImage(r17);
        this.L$0 = null;
        this.label = 3;
        r3 = CameraResultViewModel.access$getBitmapForSave(r17, r18, r19, this);
        if (r3 != r7) goto L46;
        return r7;
    L47:
        InputParam r20 = this.this$0.getInputParam();
        if (r20 != null) goto L50;
    L52:
        r12 = false;
    L53:
        if (r12 == true) goto L55;
    L59:
        nx8.m r21 = (nx8.m) CameraResultViewModel.access$get_eduImageAbility$p(this.this$0).getValue();
        if (r21 == null) goto L62;
        r4 = r21.b();
    L62:
        r4 = null;
        goto L64
    L55:
        if (CameraResultViewModel.access$getMarkedImageGetter$p(this.this$0) == null) goto L59;
        Function0 r22 = CameraResultViewModel.access$getMarkedImageGetter$p(this.this$0);
        if (r22 == null) goto L62;
        r4 = (Bitmap) r22.invoke();
        goto L64
    L50:
        if (r20.getSupportMark() != true) goto L52;
    L38:
        r15 = null;
        goto L39
    L15:
        boolean r23 = this.Z$0;
        ResultKt.throwOnFailure(r16);
    L22:
        boolean r110 = r23;
    L23:
        if (r110 == true) goto L25;
    L29:
        r4 = null;
    L30:
        if (r110 == true) goto L38;
        CameraResultViewModel r24 = this.this$0;
        OutputParam r25 = this.$currentOutputParam;
        this.L$0 = r4;
        this.label = 2;
        r13 = CameraResultViewModel.access$getAiCreationMarkDownloadBitmap(r24, r25, this);
        if (r13 != r7) goto L35;
        return r7;
    L25:
        if (this.this$0.resultSupportMark() == false) goto L29;
        Function0 r26 = CameraResultViewModel.access$getRawMarkedImageGetter$p(this.this$0);
        if (r26 == null) goto L29;
        r4 = (Bitmap) r26.invoke();
        goto L30
    L16:
        ResultKt.throwOnFailure(r16);
        r110 = CameraResultViewModel.access$shouldUseNoWatermarkForMarkDownload(this.this$0, this.$currentOutputParam);
        if (r110 == false) goto L23;
        CameraResultViewModel r27 = this.this$0;
        this.Z$0 = r110;
        this.label = 1;
        if (CameraResultViewModel.awaitRawImageReady$default(r27, 0, this, 1, null) != r7) goto L21;
        return r7;
    L21:
        r23 = r110;
        goto L22
    }
}
