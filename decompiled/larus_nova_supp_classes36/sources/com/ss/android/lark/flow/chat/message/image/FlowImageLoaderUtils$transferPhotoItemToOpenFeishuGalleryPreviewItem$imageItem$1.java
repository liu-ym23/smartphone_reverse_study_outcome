package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryImageType;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.io.File;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1 implements kza.e {
    public final /* synthetic */ Context a;
    public final /* synthetic */ PhotoItem b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GalleryImageType.values().length];
            r0[GalleryImageType.Middle.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[GalleryImageType.Origin.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final void c() {
    }

    public FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1(Context r1, PhotoItem r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object a(Context r13, GalleryImageType r14, Continuation r15) {
        if ((r15 instanceof FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$downloadImage$1) == false) goto L7;
        FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$downloadImage$1 r0 = (FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$downloadImage$1) r15;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r16 = r0.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L18;
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L16;
        if (r2 != 3) goto L15;
        File r17 = (File) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L30:
        File r18 = (File) r16;
    L35:
        if (r17 != null) goto L37;
        return null;
    L37:
        if (r17.exists() == true) goto L39;
        return null;
    L39:
        return r17.getAbsolutePath();
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r17 = (File) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L34:
        File r19 = (File) r16;
        goto L35
    L17:
        r14 = (GalleryImageType) r0.L$1;
        r13 = (Context) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L21:
        Context r3 = r13;
        r17 = (File) r16;
        if (r17 != null) goto L35;
        int r110 = a.a[r14.ordinal()];
        if (r110 == 1) goto L31;
        if (r110 != 2) goto L35;
        f r4 = f.a;
        GalleryImageType r5 = GalleryImageType.Middle;
        PhotoItem r6 = this.b;
        r0.L$0 = r17;
        r0.L$1 = null;
        r0.label = 3;
        r16 = f.a(r4, r3, r5, r6, false, r0);
        if (r16 != r7) goto L30;
        return r7;
    L31:
        f r8 = f.a;
        GalleryImageType r9 = GalleryImageType.Origin;
        PhotoItem r10 = this.b;
        r0.L$0 = r17;
        r0.L$1 = null;
        r0.label = 2;
        r16 = f.a(r8, r3, r9, r10, false, r0);
        if (r16 != r7) goto L34;
        return r7;
    L18:
        ResultKt.throwOnFailure(r16);
        f r11 = f.a;
        PhotoItem r12 = this.b;
        r0.L$0 = r13;
        r0.L$1 = r14;
        r0.label = 1;
        r16 = f.a(r11, r13, r14, r12, false, r0);
        if (r16 != r7) goto L21;
        return r7;
    L7:
        r0 = new FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$downloadImage$1(this, r15);
        goto L8
    }

    public final Object b(GalleryImageType r8, boolean r9, Continuation<? super String> r10) {
        if ((r10 instanceof FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageUri$1) == false) goto L7;
        FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageUri$1 r0 = (FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageUri$1) r10;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageUri$1 r6 = r0;
        Object r11 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r11);
    L17:
        File r12 = (File) r11;
        if (r12 != null) goto L20;
    L22:
        return null;
    L20:
        if (r12.exists() == false) goto L22;
        return Uri.fromFile(r12).toString();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        f r4 = f.a;
        Context r13 = this.a;
        PhotoItem r5 = this.b;
        r6.label = 1;
        r11 = f.a(r4, r13, r8, r5, r9, r6);
        if (r11 != r2) goto L17;
        return r2;
    L7:
        r0 = new FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1$getImageUri$1(this, r10);
        goto L8
    }
}
