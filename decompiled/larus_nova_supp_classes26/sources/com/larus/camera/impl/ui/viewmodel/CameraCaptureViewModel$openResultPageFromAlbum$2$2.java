package com.larus.camera.impl.ui.viewmodel;

import android.content.Context;
import android.graphics.Bitmap;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.viewmodel.CameraCaptureViewModel$openResultPageFromAlbum$2$2", f = "CameraCaptureViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CameraCaptureViewModel$openResultPageFromAlbum$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $contentUri;
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ CameraCaptureViewModel this$0;

    public CameraCaptureViewModel$openResultPageFromAlbum$2$2(CameraCaptureViewModel r1, Context r2, Uri r3, Continuation<? super CameraCaptureViewModel$openResultPageFromAlbum$2$2> r4) {
        this.this$0 = r1;
        this.$context = r2;
        this.$contentUri = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CameraCaptureViewModel$openResultPageFromAlbum$2$2(this.this$0, this.$context, this.$contentUri, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r6);
        Bitmap r7 = CameraCaptureViewModel.access$ability(this.this$0).l(this.$context, this.$contentUri);
        if (r7 == null) goto L8;
        CameraCaptureViewModel r0 = this.this$0;
        Uri r1 = this.$contentUri;
        FLogger.a.i(CameraCaptureViewModel.TAG, "[openResultPageFromAlbum] getFirstBitmapFromVideoUri: " + r7);
        CameraCaptureViewModel.access$ability(r0).H(r1.toString(), r7);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
