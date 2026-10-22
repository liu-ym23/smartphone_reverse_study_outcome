package com.larus.camera.impl.ui.viewmodel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.larus.utils.logger.FLogger;
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
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$Companion$eduImageIdentifyCheck$originBitmap$1", f = "CameraCaptureViewModel.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
public final class CameraCaptureViewModel$Companion$eduImageIdentifyCheck$originBitmap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ q0 $ability;
    final /* synthetic */ Uri $albumUri;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $imagePath;
    int label;

    /* JADX INFO: renamed from: com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$Companion$eduImageIdentifyCheck$originBitmap$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/graphics/Bitmap;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$Companion$eduImageIdentifyCheck$originBitmap$1$1", f = "CameraCaptureViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
        final /* synthetic */ q0 $ability;
        final /* synthetic */ Uri $albumUri;
        final /* synthetic */ Context $context;
        final /* synthetic */ String $imagePath;
        int label;

        public AnonymousClass1(Uri r1, q0 r2, Context r3, String r4, Continuation<? super AnonymousClass1> r5) {
            this.$albumUri = r1;
            this.$ability = r2;
            this.$context = r3;
            this.$imagePath = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$albumUri, this.$ability, this.$context, this.$imagePath, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r3);
            FLogger.a.i(CameraCaptureViewModel.TAG, "eduImageIdentifyCheck: load bitmap, in withContext");
            Uri r4 = this.$albumUri;
            if (r4 != null) goto L14;
            String r5 = this.$imagePath;
            if (r5 != null) goto L15;
            return null;
        L15:
            return BitmapFactory.decodeFile(r5);
        L14:
            return this.$ability.S(this.$context, r4);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CameraCaptureViewModel$Companion$eduImageIdentifyCheck$originBitmap$1(Uri r1, q0 r2, Context r3, String r4, Continuation<? super CameraCaptureViewModel$Companion$eduImageIdentifyCheck$originBitmap$1> r5) {
        this.$albumUri = r1;
        this.$ability = r2;
        this.$context = r3;
        this.$imagePath = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new CameraCaptureViewModel$Companion$eduImageIdentifyCheck$originBitmap$1(this.$albumUri, this.$ability, this.$context, this.$imagePath, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bitmap> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        FLogger.a.i(CameraCaptureViewModel.TAG, "eduImageIdentifyCheck:load bitmap, in withTimeoutOrNull");
        Deferred r14 = BuildersKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(this.$albumUri, this.$ability, this.$context, this.$imagePath, null), 3, null);
        this.label = 1;
        r13 = r14.await(this);
        if (r13 != r0) goto L11;
        return r0;
    }
}
