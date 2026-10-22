package com.larus.community.impl.detail.prompt;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.facebook.common.references.CloseableReference;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.z0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.detail.prompt.CreationDetailPromptRefImageViewerDialog$fillImageViewAndResize$1$1$1$1$1", f = "CreationDetailPromptRefImageViewerDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreationDetailPromptRefImageViewerDialog$fillImageViewAndResize$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CloseableReference<CloseableImage> $imageReference;
    final /* synthetic */ String $imageUrl;
    int label;
    final /* synthetic */ CreationDetailPromptRefImageViewerDialog this$0;

    public CreationDetailPromptRefImageViewerDialog$fillImageViewAndResize$1$1$1$1$1(CloseableReference<CloseableImage> r1, CreationDetailPromptRefImageViewerDialog r2, String r3, Continuation<? super CreationDetailPromptRefImageViewerDialog$fillImageViewAndResize$1$1$1$1$1> r4) {
        this.$imageReference = r1;
        this.this$0 = r2;
        this.$imageUrl = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationDetailPromptRefImageViewerDialog$fillImageViewAndResize$1$1$1$1$1(this.$imageReference, this.this$0, this.$imageUrl, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r5);
        Object r6 = this.$imageReference.get();
        if ((r6 instanceof CloseableStaticBitmap) == false) goto L7;
        CloseableStaticBitmap r7 = (CloseableStaticBitmap) r6;
    L8:
        if (r7 == null) goto L10;
        Bitmap r8 = r7.getUnderlyingBitmap();
    L11:
        if (r8 != null) goto L13;
    L33:
        SimpleDraweeView r9 = this.this$0.e;
        if (r9 == null) goto L39;
        ImageLoaderKt.u(r9, this.$imageUrl, "community_creation_photo");
        return Unit.INSTANCE;
    L39:
        return null;
    L13:
        if (r8.isRecycled() == true) goto L33;
        Bitmap r10 = r8.copy(z0.b(r8.getConfig()), r8.isMutable());
        float r0 = r10.getWidth() / r10.getHeight();
        SimpleDraweeView r11 = this.this$0.e;
        if (r11 == null) goto L18;
        r11.setAspectRatio(r0);
    L18:
        if (r0 >= 0.75f) goto L26;
        SimpleDraweeView r12 = this.this$0.e;
        if (r12 == null) goto L33;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        if (r13 == null) goto L33;
        CreationDetailPromptRefImageViewerDialog r1 = this.this$0;
        r13.width = -2;
        r13.height = -1;
        SimpleDraweeView r2 = r1.e;
        if (r2 == null) goto L33;
        r2.setLayoutParams(r13);
        goto L33
    L26:
        SimpleDraweeView r14 = this.this$0.e;
        if (r14 == null) goto L33;
        ViewGroup.LayoutParams r15 = r14.getLayoutParams();
        if (r15 == null) goto L33;
        CreationDetailPromptRefImageViewerDialog r3 = this.this$0;
        r15.width = -1;
        r15.height = -2;
        SimpleDraweeView r4 = r3.e;
        if (r4 == null) goto L33;
        r4.setLayoutParams(r15);
        goto L33
    L10:
        r8 = null;
        goto L11
    L7:
        r7 = null;
        goto L8
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
