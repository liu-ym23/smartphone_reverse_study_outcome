package com.ss.android.lark.flow.chat.message.image;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GalleryImageType;
import com.ss.android.lark.chat.preview.entity.component.property.DocImageProperty;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.export.entity.preview.ext.UrlPreviewEntityExt;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.File;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1 implements kza.e {
    public final /* synthetic */ Context a;
    public final /* synthetic */ DocImageProperty b;
    public final /* synthetic */ Map.Entry<String, PreviewHangPoint> c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GalleryImageType.values().length];
            r0[GalleryImageType.Thumbnail.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[GalleryImageType.Middle.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[GalleryImageType.Origin.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public final void c() {
    }

    public FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1(Context r1, DocImageProperty r2, Map.Entry<String, PreviewHangPoint> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object a(Context r12, GalleryImageType r13, Continuation r14) {
        if ((r14 instanceof FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$downloadImage$1) == false) goto L7;
        FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$downloadImage$1 r15 = (FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$downloadImage$1) r14;
        int r0 = r15.label;
        if ((r0 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r15.label = r0 - Target.SIZE_ORIGINAL;
    L8:
        Object r16 = r15.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r15.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L56:
        File r17 = (File) r16;
        if (r17 != null) goto L59;
    L63:
        Log.e("FlowMediaPreviewUtils", "yunpan downloadImage, file is null or not exists");
        return null;
    L59:
        if (r17.exists() == false) goto L63;
        return r17.getAbsolutePath();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        UrlCardPreviewEntity r18 = this.c.getValue().getUrlCardPreviewEntity();
        String r3 = "";
        if (r18 == null) goto L24;
        UrlInlinePreviewEntity r19 = r18.getInlineEntity();
        if (r19 == null) goto L24;
        UrlPreviewEntityExt r110 = r19.getExt();
        if (r110 == null) goto L24;
        UrlPreviewEntityExt.DocInfo r111 = r110.getDocInfo();
        if (r111 == null) goto L24;
        String r112 = r111.getFileName();
        if (r112 == null) goto L24;
    L25:
        FlowYunPanFileUtils r5 = FlowYunPanFileUtils.a;
        String r6 = this.b.getToken();
        if (r6 != null) goto L28;
        r6 = "";
    L28:
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r6, "fileToken");
        Intrinsics.checkNotNullParameter(r112, "fileName");
        boolean r7 = false;
        if (r112.length() != 0) goto L31;
        boolean r113 = true;
    L32:
        if (r113 == false) goto L34;
        StringBuilder r114 = new StringBuilder();
        r114.append(Math.abs(r6.hashCode()));
        r114.append(System.currentTimeMillis());
        String r115 = r114.toString();
    L35:
        VFSPath r116 = LarkFileStorage.b().b(com.ss.android.lark.storage.f.e, new com.ss.android.lark.storage.d(new String[]{"im", "flow_download_media_cache"}));
        if (com.suite.lark.component.storage.ext.b.b(r116) == false) goto L38;
    L40:
        VFSFile r117 = VFSFiles.b.v(r116.getAbsolutePath(), r115);
        Log.i("FlowYunPanFileUtils", "getDownloadVideoWorkSpace, version:" + Build.VERSION.SDK_INT + ",workSpace:" + r117.getAbsolutePath());
        String r118 = r117.getAbsolutePath();
        if (r118 != null) goto L44;
    L42:
        r118 = "";
    L44:
        if (r118.length() != 0) goto L46;
        r7 = true;
    L46:
        if (r7 == false) goto L49;
        Log.e("FlowMediaPreviewUtils", "yunpan downloadImage, savePath is null or empty");
        return null;
    L49:
        String r119 = this.b.getToken();
        if (r119 == null) goto L53;
        r3 = r119;
    L53:
        r15.label = 1;
        r16 = r5.f(r3, r118, r15);
        if (r16 != r1) goto L56;
        return r1;
    L38:
        if (com.suite.lark.component.storage.ext.b.d(r116) == true) goto L40;
        Log.e("FlowYunPanFileUtils", "getDownloadImageWorkSpace, mkdirs error");
        goto L42
    L34:
        r115 = System.currentTimeMillis() + '_' + r112;
        goto L35
    L31:
        r113 = false;
    L24:
        r112 = "";
    L7:
        r15 = new FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$downloadImage$1(this, r14);
        goto L8
    }

    public final Object b(GalleryImageType r8, boolean r9, Continuation<? super String> r10) {
        if ((r10 instanceof FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$getImageUri$1) == false) goto L7;
        FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$getImageUri$1 r0 = (FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$getImageUri$1) r10;
        int r1 = r0.label;
        if ((r1 & Target.SIZE_ORIGINAL) == 0) goto L7;
        r0.label = r1 - Target.SIZE_ORIGINAL;
    L8:
        FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$getImageUri$1 r6 = r0;
        Object r11 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r11);
    L29:
        File r12 = (File) r11;
    L47:
        if (r12 != null) goto L51;
        return null;
    L51:
        return Uri.fromFile(r12).toString();
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r11);
    L38:
        r12 = (File) r11;
        goto L47
    L17:
        ResultKt.throwOnFailure(r11);
    L46:
        r12 = (File) r11;
        goto L47
    L18:
        ResultKt.throwOnFailure(r11);
        int r13 = a.a[r8.ordinal()];
        String r14 = "";
        if (r13 == 1) goto L39;
        if (r13 == 2) goto L32;
        if (r13 != 3) goto L31;
        FlowYunPanFileUtils r15 = FlowYunPanFileUtils.a;
        Context r4 = this.a;
        String r5 = this.b.getToken();
        if (r5 == null) goto L26;
        r14 = r5;
    L26:
        r6.label = 3;
        r11 = r15.e(r4, r14, r9, r6);
        if (r11 != r2) goto L29;
        return r2;
    L31:
        throw new NoWhenBranchMatchedException();
    L32:
        FlowYunPanFileUtils r7 = FlowYunPanFileUtils.a;
        Context r16 = this.a;
        String r17 = this.b.getToken();
        if (r17 != null) goto L35;
        r17 = "";
    L35:
        FlowYunPanCoverType r18 = FlowYunPanCoverType.Middle;
        r6.label = 2;
        r11 = r7.d(r16, r17, r18, r9, r6);
        if (r11 != r2) goto L38;
        return r2;
    L39:
        FlowYunPanFileUtils r19 = FlowYunPanFileUtils.a;
        Context r20 = this.a;
        String r21 = this.b.getToken();
        if (r21 != null) goto L42;
        String r22 = "";
    L43:
        FlowYunPanCoverType r23 = FlowYunPanCoverType.Thumbnail;
        r6.label = 1;
        r11 = r19.d(r20, r22, r23, r9, r6);
        if (r11 != r2) goto L46;
        return r2;
    L42:
        r22 = r21;
    L7:
        r0 = new FlowMediaPreviewUtils$getExternalHandler$1$transferYunPanDataToImageSet$1$1$imageItem$1$getImageUri$1(this, r10);
        goto L8
    }
}
