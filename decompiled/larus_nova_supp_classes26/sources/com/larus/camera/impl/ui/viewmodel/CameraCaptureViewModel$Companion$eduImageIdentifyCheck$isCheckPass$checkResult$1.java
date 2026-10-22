package com.larus.camera.impl.ui.viewmodel;

import android.content.Context;
import android.graphics.Bitmap;
import com.larus.camera.impl.edulibs.cameraapi.IdentifyDetectionResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/impl/edulibs/cameraapi/IdentifyDetectionResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$Companion$eduImageIdentifyCheck$isCheckPass$checkResult$1", f = "CameraCaptureViewModel.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
public final class CameraCaptureViewModel$Companion$eduImageIdentifyCheck$isCheckPass$checkResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IdentifyDetectionResult>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $imagePath;
    final /* synthetic */ Bitmap $originBitmap;
    int label;

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$Companion$eduImageIdentifyCheck$isCheckPass$checkResult$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/impl/edulibs/cameraapi/IdentifyDetectionResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$Companion$eduImageIdentifyCheck$isCheckPass$checkResult$1$1", f = "CameraCaptureViewModel.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IdentifyDetectionResult>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $imagePath;
        final /* synthetic */ Bitmap $originBitmap;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$Companion$eduImageIdentifyCheck$isCheckPass$checkResult$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/impl/edulibs/cameraapi/IdentifyDetectionResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$Companion$eduImageIdentifyCheck$isCheckPass$checkResult$1$1$1", f = "CameraCaptureViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IdentifyDetectionResult>, Object> {
            final /* synthetic */ Context $context;
            final /* synthetic */ String $imagePath;
            final /* synthetic */ Bitmap $originBitmap;
            int label;

            public C00821(Context r1, String r2, Bitmap r3, Continuation<? super C00821> r4) {
                this.$context = r1;
                this.$imagePath = r2;
                this.$originBitmap = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00821(this.$context, this.$imagePath, this.$originBitmap, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super IdentifyDetectionResult> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r8) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L12;
                ResultKt.throwOnFailure(r8);
                com.larus.camera.impl.edulibs.camera.a r9 = com.larus.camera.impl.edulibs.camera.a.a;
                Context r10 = this.$context;
                String r0 = this.$imagePath;
                Bitmap r1 = this.$originBitmap;
                Intrinsics.checkNotNullParameter(r10, "context");
                Intrinsics.checkNotNullParameter(r0, "imagePath");
                com.larus.camera.impl.edulibs.camera.a.c.i("EduCamera", "call detectIdentifiable");
                if (r1 == null) goto L9;
                boolean r2 = StringsKt.startsWith$default(r0, "content", false, 2, null);
                com.larus.camera.impl.edulibs.camera.internal.b.a.getClass();
                IdentifyDetectionResult r11 = com.larus.camera.impl.edulibs.camera.internal.b.a(r10, r1, r2);
                com.larus.camera.impl.edulibs.camera.a.c.i("EduCamera", "get result: " + r11);
                if (r11.a == false) goto L13;
                com.larus.camera.impl.edulibs.camera.a.e.put(r0, r11);
                return r11;
            L13:
                return r11;
            L9:
                com.larus.camera.impl.edulibs.camera.a.c.e("EduCamera", "bitmap is null", null);
                return new IdentifyDetectionResult(0, 7);
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(Context r1, String r2, Bitmap r3, Continuation<? super AnonymousClass1> r4) {
            this.$context = r1;
            this.$imagePath = r2;
            this.$originBitmap = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$context, this.$imagePath, this.$originBitmap, r6);
            r0.L$0 = r5;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super IdentifyDetectionResult> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            Deferred r11 = BuildersKt.async$default((CoroutineScope) this.L$0, null, null, new C00821(this.$context, this.$imagePath, this.$originBitmap, null), 3, null);
            this.label = 1;
            r10 = r11.await(this);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    public CameraCaptureViewModel$Companion$eduImageIdentifyCheck$isCheckPass$checkResult$1(Context r1, String r2, Bitmap r3, Continuation<? super CameraCaptureViewModel$Companion$eduImageIdentifyCheck$isCheckPass$checkResult$1> r4) {
        this.$context = r1;
        this.$imagePath = r2;
        this.$originBitmap = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CameraCaptureViewModel$Companion$eduImageIdentifyCheck$isCheckPass$checkResult$1(this.$context, this.$imagePath, this.$originBitmap, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super IdentifyDetectionResult> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        AnonymousClass1 r8 = new AnonymousClass1(this.$context, this.$imagePath, this.$originBitmap, null);
        this.label = 1;
        r7 = SupervisorKt.supervisorScope(r8, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
