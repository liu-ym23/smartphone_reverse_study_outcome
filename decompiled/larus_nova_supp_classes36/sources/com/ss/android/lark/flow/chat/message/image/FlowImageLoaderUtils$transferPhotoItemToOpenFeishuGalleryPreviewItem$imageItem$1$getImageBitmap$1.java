package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.message.image.FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1", f = "FlowImageLoaderUtils.kt", i = {}, l = {251, 255}, m = "getImageBitmap", n = {}, s = {})
final class FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageBitmap$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1 this$0;

    public FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageBitmap$1(FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1 r1, Continuation<? super FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageBitmap$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Target.SIZE_ORIGINAL;
        FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1 r11 = this.this$0;
        r11.getClass();
        int r1 = this.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L5;
        this.label = r1 - Target.SIZE_ORIGINAL;
        FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageBitmap$1 r0 = this;
    L6:
        Object r2 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 == 1) goto L13;
        if (r3 != 2) goto L12;
        ResultKt.throwOnFailure(r2);
    L28:
        return r2;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r2);
    L17:
        File r4 = (File) r2;
        if (r4 == null) goto L27;
        if (r4.exists() == false) goto L27;
        CoroutineDispatcher r5 = Dispatchers.getIO();
        FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageBitmap$2 r6 = new FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageBitmap$2(r11.a, r4, null);
        r0.label = 2;
        r2 = BuildersKt.withContext(r5, r6, r0);
        if (r2 != r7) goto L28;
        return r7;
    L27:
        return null;
    L14:
        ResultKt.throwOnFailure(r2);
        f r8 = f.a;
        Context r9 = r11.a;
        PhotoItem r12 = r11.b;
        r0.label = 1;
        r2 = f.a(r8, r9, null, r12, false, r0);
        if (r2 != r7) goto L17;
        return r7;
    L5:
        r0 = new FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageBitmap$1(r11, this);
        goto L6
    }
}
