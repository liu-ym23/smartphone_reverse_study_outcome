package com.obric.assistant.component;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.obric.assistant.util.BitmapHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricPhotoActionComponent$goToPictureDynamicPageWithScreenShot$1$1", f = "ObricPhotoActionComponent.kt", i = {}, l = {428}, m = "invokeSuspend", n = {}, s = {})
final class ObricPhotoActionComponent$goToPictureDynamicPageWithScreenShot$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $fileId;
    final /* synthetic */ Bitmap $it;
    int label;
    final /* synthetic */ ObricPhotoActionComponent this$0;

    public ObricPhotoActionComponent$goToPictureDynamicPageWithScreenShot$1$1(ObricPhotoActionComponent r1, Bitmap r2, long r3, Continuation<? super ObricPhotoActionComponent$goToPictureDynamicPageWithScreenShot$1$1> r5) {
        this.this$0 = r1;
        this.$it = r2;
        this.$fileId = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ObricPhotoActionComponent$goToPictureDynamicPageWithScreenShot$1$1(this.this$0, this.$it, this.$fileId, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        File r8 = (File) r7;
        if (r8 == null) goto L15;
        ObricPhotoActionComponent r2 = this.this$0;
        Uri r9 = Uri.fromFile(r8);
        Fresco.getImagePipeline().evictFromCache(r9);
        String r10 = r9.toString();
        int r3 = ObricPhotoActionComponent.B;
        r2.z3(r10);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        int r11 = BitmapHelper.a;
        FragmentActivity r12 = s1a.a.getActivity(this.this$0);
        Bitmap r4 = this.$it;
        String r5 = this.$fileId + ".jpg";
        this.label = 1;
        r7 = BitmapHelper.a(r12, r4, r5, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
