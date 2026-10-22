package com.larus.camera.impl.ui.viewmodel;

import android.graphics.Bitmap;
import com.larus.camera.impl.entity.EduIntentMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraResultViewModel$saveSingleResultAndCloseInternal$1$2$1$originFilePath$1$1", f = "CameraResultViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CameraResultViewModel$saveSingleResultAndCloseInternal$1$2$1$originFilePath$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Bitmap $originImage;
    int label;
    final /* synthetic */ CameraResultViewModel this$0;

    public CameraResultViewModel$saveSingleResultAndCloseInternal$1$2$1$originFilePath$1$1(CameraResultViewModel r1, Bitmap r2, Continuation<? super CameraResultViewModel$saveSingleResultAndCloseInternal$1$2$1$originFilePath$1$1> r3) {
        this.this$0 = r1;
        this.$originImage = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CameraResultViewModel$saveSingleResultAndCloseInternal$1$2$1$originFilePath$1$1(this.this$0, this.$originImage, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r6);
        q0 r7 = CameraResultViewModel.access$ability(this.this$0);
        Bitmap r0 = this.$originImage;
        CameraResultViewModel r1 = this.this$0;
        if (CameraResultViewModel.access$getCurrentEduIntent$p(r1) != EduIntentMode.MULTI_QUESTION) goto L7;
        boolean r2 = true;
    L9:
        return r7.k(r0, 0, CameraResultViewModel.access$getSaveCallbackWhenFromCapture(r1, r2));
    L7:
        r2 = false;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
