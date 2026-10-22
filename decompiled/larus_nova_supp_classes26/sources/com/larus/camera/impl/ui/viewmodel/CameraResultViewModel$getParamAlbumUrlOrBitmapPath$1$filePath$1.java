package com.larus.camera.impl.ui.viewmodel;

import android.graphics.Bitmap;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$getParamAlbumUrlOrBitmapPath$1$filePath$1", f = "CameraResultViewModel.kt", i = {}, l = {452, 457}, m = "invokeSuspend", n = {}, s = {})
public final class CameraResultViewModel$getParamAlbumUrlOrBitmapPath$1$filePath$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ OutputParam $currentOutputParam;
    int label;
    final /* synthetic */ CameraResultViewModel this$0;

    public CameraResultViewModel$getParamAlbumUrlOrBitmapPath$1$filePath$1(CameraResultViewModel r1, OutputParam r2, Continuation<? super CameraResultViewModel$getParamAlbumUrlOrBitmapPath$1$filePath$1> r3) {
        this.this$0 = r1;
        this.$currentOutputParam = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new CameraResultViewModel$getParamAlbumUrlOrBitmapPath$1$filePath$1(this.this$0, this.$currentOutputParam, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super String> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L34:
        return (String) r7;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L24:
        Bitmap r8 = (Bitmap) r7;
    L29:
        if (r8 == null) goto L35;
        CameraResultViewModel r2 = this.this$0;
        CoroutineDispatcher r3 = Dispatchers.getIO();
        CameraResultViewModel$getParamAlbumUrlOrBitmapPath$1$filePath$1$1$1 r5 = new CameraResultViewModel$getParamAlbumUrlOrBitmapPath$1$filePath$1$1$1(r2, r8, null);
        this.label = 2;
        r7 = BuildersKt.withContext(r3, r5, this);
        if (r7 != r0) goto L34;
        return r0;
    L35:
        return null;
    L10:
        ResultKt.throwOnFailure(r7);
        if (this.this$0.resultSupportMark() == true) goto L13;
    L17:
        r8 = null;
    L18:
        if (r8 != null) goto L29;
        if (this.this$0.shouldUseOriginalImageDeferredEdit(this.$currentOutputParam) == false) goto L25;
        CameraResultViewModel r9 = this.this$0;
        OutputParam r4 = this.$currentOutputParam;
        Bitmap r6 = CameraResultViewModel.access$getPreviewImage(r9);
        this.label = 1;
        r7 = CameraResultViewModel.access$getBitmapForSave(r9, r4, r6, this);
        if (r7 != r0) goto L24;
        return r0;
    L25:
        Function0 r10 = CameraResultViewModel.access$getMarkedImageGetter$p(this.this$0);
        if (r10 == null) goto L28;
        r8 = (Bitmap) r10.invoke();
        goto L29
    L28:
        r8 = null;
        goto L29
    L13:
        if (CameraResultViewModel.access$getRawMarkedImageGetter$p(this.this$0) == null) goto L17;
        Function0 r11 = CameraResultViewModel.access$getRawMarkedImageGetter$p(this.this$0);
        if (r11 == null) goto L17;
        r8 = (Bitmap) r11.invoke();
        goto L18
    }
}
