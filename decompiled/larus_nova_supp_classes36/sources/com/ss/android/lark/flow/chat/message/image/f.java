package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.biz.im.api.IIMApi;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryImageType;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryType;
import com.ss.android.lark.chat.entity.media.MediaExtra;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.utils.MessagePermissionUtil;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.io.File;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kza.l;
import kza.m;
import kza.o;
import kza.p;
import kza.q;
import kza.r;
import kza.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
    }

    public static final Pair b(PhotoItem r7) {
        String r0 = null;
        if (r7 == null) goto L47;
        PhotoItem.PicInfo r1 = r7.getMiddlePicInfo();
        if (r1 == null) goto L8;
        String r2 = r1.key;
    L9:
        PhotoItem.PicInfo r3 = r7.getMiddlePicInfo();
        boolean r4 = false;
        if (r3 == null) goto L12;
        int r5 = r3.width;
    L13:
        PhotoItem.PicInfo r6 = r7.getMiddlePicInfo();
        if (r6 == null) goto L16;
        int r8 = r6.height;
    L18:
        if (r2 != null) goto L20;
    L23:
        boolean r9 = true;
    L24:
        if (r9 == false) goto L37;
        PhotoItem.PicInfo r10 = r7.getOriginPicInfo();
        if (r10 == null) goto L28;
        r0 = r10.key;
    L28:
        PhotoItem.PicInfo r11 = r7.getOriginPicInfo();
        if (r11 == null) goto L31;
        r5 = r11.width;
    L32:
        PhotoItem.PicInfo r12 = r7.getOriginPicInfo();
        if (r12 == null) goto L35;
        r8 = r12.height;
    L36:
        r2 = r0;
        goto L37
    L35:
        r8 = 0;
        goto L36
    L31:
        r5 = 0;
    L37:
        if (r2 != null) goto L39;
    L40:
        r4 = true;
    L41:
        if (r4 == false) goto L44;
        r2 = r7.getImageKey();
        r5 = r7.getWidth();
        r8 = r7.getHeight();
    L44:
        if (r2 != null) goto L46;
        r2 = "";
    L46:
        r0 = new Pair(r2, new Pair(Integer.valueOf(r5), Integer.valueOf(r8)));
        goto L47
    L39:
        if (r2.length() != 0) goto L41;
    L20:
        if (r2.length() == 0) goto L23;
        r9 = false;
        goto L24
    L16:
        r8 = 0;
        goto L18
    L12:
        r5 = 0;
        goto L13
    L8:
        r2 = null;
    L47:
        return r0;
    }

    public static File d(com.ss.android.lark.image.entity.b r3) {
        Intrinsics.checkNotNullParameter(r3, "imageKey");
        ArrayList r0 = new ArrayList(1);
        r0.add(r3);
        IIMApi r4 = (IIMApi) ApiUtils.getApi(IIMApi.class);
        if (r4 == null) goto L5;
        com.ss.android.lark.image.entity.c r5 = r4.findImageCache("look_large_image", r0, null);
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        return r5.b;
    L5:
        r5 = null;
        goto L6
    }

    public static o c(PhotoItem r13, GalleryType r14) {
        ValidateIMFileResult r0 = r13.getValidateIMFileResult();
        String r1 = null;
        if (r0 == null) goto L5;
        IMFileResult r2 = r0.getResultType();
    L6:
        int r3 = MessagePermissionUtil.h(r2).getValue();
        boolean r4 = false;
        if (r13.isHasPreviewPermission() == false) goto L11;
        MessagePermissionUtil.ReceiveAuthorizationState.Companion.getClass();
        if (MessagePermissionUtil.g(MessagePermissionUtil.ReceiveAuthorizationState.a.a(r3)) == true) goto L11;
        boolean r5 = true;
    L12:
        MessageIdentity r6 = r13.getMessageIdentity();
        if (r6 == null) goto L15;
        String r9 = r6.getChatId();
    L16:
        MessageIdentity r7 = r13.getMessageIdentity();
        if (r7 == null) goto L20;
        String r8 = r7.getMessageId();
        if (r8 == null) goto L20;
    L21:
        String r10 = r8;
        if (r14 != GalleryType.Video) goto L33;
        MediaExtra r11 = r13.getMediaExtra();
        if (r11 == null) goto L26;
        r1 = r11.getKey();
    L26:
        if (r1 != null) goto L29;
        r1 = "";
    L29:
        if (r1.length() != 0) goto L31;
        r4 = true;
    L31:
        if (r4 == false) goto L35;
        r1 = r13.getImageKey();
    L35:
        return new o(r3, r5, r13.resourceIsCleaned, new t(new r(r14, r10, r9, r1, 112), new q(r1, true, 13)), 56);
    L33:
        r1 = r13.getImageKey();
    L20:
        r8 = r13.getMessageId();
        goto L21
    L15:
        r9 = null;
    L11:
        r5 = false;
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    public static m e(Context r21, PhotoItem r22) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r22, "photoItem");
        String r2 = null;
        if (r22.isVideo() == false) goto L24;
        String r1 = "video_" + System.currentTimeMillis();
        MediaExtra r3 = r22.getMediaExtra();
        if (r3 == null) goto L7;
        String r4 = r3.getUrl();
    L8:
        c r5 = new c(r21, r22);
        MediaExtra r6 = r22.getMediaExtra();
        if (r6 == null) goto L11;
        long r7 = r6.getDuration();
    L12:
        double r8 = r7 / 1000.0d;
        PhotoItem.PicInfo r9 = r22.getOriginPicInfo();
        if (r9 == null) goto L15;
        Integer r10 = Integer.valueOf(r9.height);
    L16:
        PhotoItem.PicInfo r11 = r22.getOriginPicInfo();
        if (r11 == null) goto L19;
        Integer r12 = Integer.valueOf(r11.width);
    L20:
        d r13 = new d(r21, r22);
        MediaExtra r14 = r22.getMediaExtra();
        if (r14 == null) goto L23;
        r2 = r14.getFilePath();
    L23:
        String r15 = r4;
        p r16 = new p(r1, r15, r5, Double.valueOf(r8), r10, r12, r13, r2, new e(r21, r22), r22, null, 2048);
        GalleryType r17 = GalleryType.Video;
        return new m(r17, null, r16, r22.getMessageId(), null, 0, c(r22, r17), 48);
    L19:
        r12 = null;
        goto L20
    L15:
        r10 = null;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = null;
        goto L8
    L24:
        File r18 = r22.getPhotoState().getOriginFile();
        if (r18 != null) goto L27;
        r18 = r22.getPhotoState().getMiddleFile();
    L27:
        if (r18 != null) goto L29;
    L31:
        String r19 = null;
    L32:
        File r20 = r22.getPhotoState().getThumbnailFile();
        if (r20 != null) goto L35;
    L37:
        l r23 = new l(r19, r2, r22, new FlowImageLoaderUtils$transferPhotoItemToOpenFeishuGalleryPreviewItem$imageItem$1(r21, r22), r22.isOriginSource(), null, 131);
        GalleryType r24 = GalleryType.Image;
        return new m(r24, r23, null, r22.getMessageId(), null, 0, c(r22, r24), 48);
    L35:
        if (r20.exists() == false) goto L37;
        r2 = Uri.fromFile(r20).toString();
        goto L37
    L29:
        if (r18.exists() == false) goto L31;
        r19 = Uri.fromFile(r18).toString();
        goto L32
    }

    public static final Object a(f r5, Context r6, GalleryImageType r7, PhotoItem r8, boolean r9, Continuation r10) {
        r5.getClass();
        if ((r10 instanceof FlowImageLoaderUtils$downloadImageFile$1) == false) goto L7;
        FlowImageLoaderUtils$downloadImageFile$1 r0 = (FlowImageLoaderUtils$downloadImageFile$1) r10;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r11);
    L26:
        return r11;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = r0.Z$0;
        r8 = (PhotoItem) r0.L$2;
        r7 = (GalleryImageType) r0.L$1;
        r6 = (Context) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L19:
        r11 = (File) r11;
        if (r9 == true) goto L26;
        if (r11 != null) goto L26;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 2;
        r11 = BuildersKt.withContext(Dispatchers.getIO(), new FlowImageLoaderUtils$downloadImageFile$3(r7, r6, r8, null), r0);
        if (r11 != r12) goto L26;
        return r12;
    L16:
        ResultKt.throwOnFailure(r11);
        r0.L$0 = r6;
        r0.L$1 = r7;
        r0.L$2 = r8;
        r0.Z$0 = r9;
        r0.label = 1;
        r11 = BuildersKt.withContext(Dispatchers.getIO(), new FlowImageLoaderUtils$getImageCacheFile$2(r6, r7, r8, null), r0);
        if (r11 != r12) goto L19;
        return r12;
    L7:
        r0 = new FlowImageLoaderUtils$downloadImageFile$1(r5, r10);
        goto L8
    }
}
