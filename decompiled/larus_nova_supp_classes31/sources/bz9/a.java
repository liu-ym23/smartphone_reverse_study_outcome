package bz9;

import android.os.Build;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.VideoData;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.service.z2;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nr9.f;
import nr9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final String a(ImageObj r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (Build.VERSION.SDK_INT <= 26) goto L9;
        if (o0.d(r2.getHeicUrl()) == false) goto L9;
        return r2.getHeicUrl();
    L9:
        return r2.url;
    }

    public static final String b(Image r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (Build.VERSION.SDK_INT <= 26) goto L9;
        if (o0.d(r2.b) == false) goto L9;
        return r2.b;
    L9:
        return r2.a;
    }

    public static final String c(ImageData r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        ImageObj r0 = r4.imageThumb;
        if (r0 == null) goto L5;
        String r1 = r0.getHeicUrl();
    L7:
        if (Build.VERSION.SDK_INT > 26) goto L9;
    L11:
        ImageObj r5 = r4.imageThumb;
        if (r5 != null) goto L14;
        return null;
    L14:
        return r5.url;
    L9:
        if (o0.d(r1) == false) goto L11;
        return r1;
    L5:
        r1 = null;
        goto L7
    }

    public static final boolean f(CreationItem r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Integer r0 = r5.type;
        if (r0 != null) goto L6;
    L15:
        if (r0 != null) goto L18;
        return false;
    L18:
        if (r0.intValue() != 2) goto L30;
        VideoData r6 = r5.video;
        if (r6 == null) goto L31;
        Integer r7 = r6.status;
        if (r7 != null) goto L25;
        return false;
    L25:
        if (r7.intValue() != 3) goto L32;
    L14:
        return true;
    L32:
        return false;
    L31:
        return false;
    L30:
        return false;
    L6:
        if (r0.intValue() != 1) goto L15;
        ImageData r8 = r5.image;
        if (r8 == null) goto L27;
        Integer r9 = r8.status;
        if (r9 != null) goto L13;
        return false;
    L13:
        if (r9.intValue() == 2) goto L14;
        return false;
    L27:
        return false;
    }

    public static final List<CreationItem> g(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        ArrayList r0 = new ArrayList();
        Iterator r5 = com.larus.im.bean.message.a.k(r4).iterator();
    L4:
        if (r5.hasNext() == false) goto L17;
        BlockContent r1 = ((Block) r5.next()).getContent();
        if (r1 == null) goto L4;
        CreationBlock r2 = r1.getCreationBlock();
        if (r2 == null) goto L4;
        List r3 = r2.creations;
        if (r3 == null) goto L4;
        Iterator r6 = r3.iterator();
    L13:
        if (r6.hasNext() == false) goto L4;
        CreationItem r7 = (CreationItem) r6.next();
        if (f(r7) == false) goto L13;
        r0.add(r7);
        goto L13
    L17:
        return r0;
    }

    public static final g l(VideoData r18) {
        Intrinsics.checkNotNullParameter(r18, "<this>");
        String r3 = r18.vid;
        String r4 = r18.videoModel;
        String r5 = r18.downloadUrl;
        String r6 = r18.downloadFilehash;
        Double r7 = r18.duration;
        String r8 = r18.videoType;
        Cover r2 = r18.cover;
        if (r2 == null) goto L7;
        ImageObj r9 = r2.imageThumb;
        if (r9 == null) goto L7;
        String r10 = a(r9);
    L8:
        Cover r11 = r18.cover;
        if (r11 == null) goto L13;
        ImageObj r12 = r11.imagePreview;
        if (r12 == null) goto L13;
        String r13 = r12.url;
    L15:
        if (r11 == null) goto L19;
        ImageObj r14 = r11.imagePreview;
        if (r14 == null) goto L19;
        Integer r15 = Integer.valueOf(r14.height);
    L20:
        Cover r0 = r18.cover;
        if (r0 == null) goto L25;
        ImageObj r1 = r0.imagePreview;
        if (r1 == null) goto L25;
        Integer r16 = Integer.valueOf(r1.width);
    L27:
        return new g(r3, r4, r5, r6, r7, r8, new f(r10, r13, null, r15, r16, null, 36), null, null, null, 896);
    L25:
        r16 = null;
    L19:
        r15 = null;
    L13:
        r13 = null;
    L7:
        r10 = null;
        goto L8
    }

    public static final boolean e(CreationItem r6, CreationItem r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "other");
        if (Intrinsics.areEqual(r6.id, r7.id) == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r6.type, r7.type) == false) goto L64;
        Integer r0 = r6.type;
        String r2 = "";
        String r3 = null;
        if (r0 != null) goto L10;
    L34:
        if (r0 != null) goto L37;
    L33:
        boolean r8 = false;
    L60:
        if (r8 == false) goto L65;
        return true;
    L65:
        return false;
    L37:
        if (r0.intValue() != 2) goto L33;
        VideoData r9 = r6.video;
        if (r9 == null) goto L33;
        VideoData r10 = r7.video;
        Integer r1 = r9.status;
        if (r10 == null) goto L43;
        Integer r5 = r10.status;
    L45:
        if (Intrinsics.areEqual(r1, r5) == false) goto L57;
        String r11 = r9.vid;
        if (r11 != null) goto L49;
        r11 = "";
    L49:
        if (r10 == null) goto L51;
        r3 = r10.vid;
    L51:
        if (r3 == null) goto L55;
        r2 = r3;
    L55:
        if (Intrinsics.areEqual(r11, r2) == false) goto L57;
        boolean r12 = true;
    L58:
        if (r12 != true) goto L33;
    L32:
        r8 = true;
    L57:
        r12 = false;
        goto L58
    L43:
        r5 = null;
        goto L45
    L10:
        if (r0.intValue() != 1) goto L34;
        ImageData r13 = r6.image;
        if (r13 == null) goto L33;
        ImageData r14 = r7.image;
        Integer r4 = r13.status;
        if (r14 == null) goto L16;
        Integer r15 = r14.status;
    L18:
        if (Intrinsics.areEqual(r4, r15) == false) goto L30;
        String r16 = r13.key;
        if (r16 != null) goto L22;
        r16 = "";
    L22:
        if (r14 == null) goto L24;
        r3 = r14.key;
    L24:
        if (r3 == null) goto L28;
        r2 = r3;
    L28:
        if (Intrinsics.areEqual(r16, r2) == false) goto L30;
        boolean r17 = true;
    L31:
        if (r17 != true) goto L33;
    L30:
        r17 = false;
        goto L31
    L16:
        r15 = null;
        goto L18
    L64:
        return false;
    }

    public static final Image h(ImageObj r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        return new Image(r9.url, r9.getHeicUrl(), r9.width, r9.height, r10);
    }

    public static final ImageEntity i(ImageObj r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        return new ImageEntity(r7.url, r7.getHeicUrl(), r7.width, r7.height, r8);
    }

    public static final ImageInfo j(ImageData r14, CreationGenDetail r15) {
        Intrinsics.checkNotNullParameter(r14, "<this>");
        String r0 = r14.imageUri;
        if (r0 != null) goto L5;
        r0 = r14.key;
    L5:
        ImageObj r1 = r14.imageOrigin;
        Image r2 = null;
        if (r1 == null) goto L8;
        Image r4 = h(r1, r0);
    L9:
        ImageObj r3 = r14.imageThumb;
        if (r3 == null) goto L12;
        Image r5 = h(r3, r0);
    L14:
        if (z2.a.enableBlockImagePreviewResize() == false) goto L21;
        ImageObj r6 = r14.imagePreviewResize;
        if (r6 == null) goto L18;
        Image r7 = h(r6, r0);
    L24:
        Image r8 = r7;
    L26:
        String r9 = r14.key;
        String r10 = r14.requestId;
        String r11 = r14.tips;
        if (r15 == null) goto L33;
        List r16 = r15.refImages;
        if (r16 == null) goto L33;
        ImageObj r17 = (ImageObj) CollectionsKt.firstOrNull(r16);
        if (r17 == null) goto L33;
        Image r12 = h(r17, null);
    L34:
        ImageObj r18 = r14.imageOriRaw;
        if (r18 == null) goto L37;
        Image r13 = h(r18, r0);
    L38:
        ImageObj r19 = r14.imageThumbRaw;
        if (r19 == null) goto L42;
        r2 = h(r19, r0);
    L42:
        return new ImageInfo(r4, r5, r8, r12, r9, r10, r11, r13, r2, 128);
    L37:
        r13 = null;
    L33:
        r12 = null;
        goto L34
    L18:
        ImageObj r20 = r14.imagePreview;
        if (r20 != null) goto L23;
    L25:
        r8 = null;
    L23:
        r7 = h(r20, r0);
        goto L24
    L21:
        r20 = r14.imagePreview;
        if (r20 == null) goto L25;
    L12:
        r5 = null;
        goto L14
    L8:
        r4 = null;
        goto L9
    }

    public static final ImageItem k(ImageData r21, CreationGenDetail r22) {
        Intrinsics.checkNotNullParameter(r21, "<this>");
        String r2 = r21.imageUri;
        if (r2 != null) goto L5;
        r2 = r21.key;
    L5:
        String r4 = r21.key;
        String r5 = r21.requestId;
        ImageObj r3 = r21.imageThumb;
        if (r3 == null) goto L8;
        ImageEntity r7 = i(r3, r2);
    L9:
        ImageObj r6 = r21.imageOrigin;
        if (r6 == null) goto L12;
        ImageEntity r8 = i(r6, r2);
    L14:
        if (z2.a.enableBlockImagePreviewResize() == false) goto L18;
        ImageObj r9 = r21.imagePreviewResize;
        if (r9 != null) goto L20;
    L21:
        ImageEntity r10 = null;
    L22:
        ImageObj r11 = r21.imageOriRaw;
        if (r11 == null) goto L25;
        ImageEntity r12 = i(r11, r2);
    L26:
        if (r22 == null) goto L32;
        List r13 = r22.refImages;
        if (r13 == null) goto L32;
        ImageObj r14 = (ImageObj) CollectionsKt.firstOrNull(r13);
        if (r14 == null) goto L32;
        ImageEntity r15 = i(r14, null);
    L33:
        String r16 = r21.tips;
        if (r22 == null) goto L36;
        Integer r17 = r22.taskType;
    L38:
        return new ImageItem(r4, r5, r7, r8, r10, r12, r15, null, null, r16, null, false, null, r17, 7552, null);
    L36:
        r17 = null;
    L32:
        r15 = null;
        goto L33
    L25:
        r12 = null;
    L20:
        r10 = i(r9, r2);
        goto L22
    L18:
        r9 = r21.imagePreview;
        if (r9 == null) goto L21;
    L12:
        r8 = null;
        goto L14
    L8:
        r7 = null;
        goto L9
    }

    public static final int d(Message r5, String r6, CreationItem r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "blockId");
        Intrinsics.checkNotNullParameter(r7, "creationItem");
        Iterator r8 = com.larus.im.bean.message.a.k(r5).iterator();
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r8.hasNext() == false) goto L34;
        Block r2 = (Block) r8.next();
        if (Intrinsics.areEqual(r2.getBlockId(), r6) == true) goto L16;
        BlockContent r3 = r2.getContent();
        if (r3 == null) goto L14;
        CreationBlock r4 = r3.getCreationBlock();
        if (r4 == null) goto L14;
        List r9 = r4.creations;
        if (r9 == null) goto L14;
        int r10 = r9.size();
    L15:
        r1 = r1 + r10;
    L14:
        r10 = 0;
        goto L15
    L16:
        BlockContent r11 = r2.getContent();
        if (r11 == null) goto L29;
        CreationBlock r12 = r11.getCreationBlock();
        if (r12 == null) goto L29;
        List r13 = r12.creations;
        if (r13 == null) goto L29;
        Iterator r14 = r13.iterator();
    L24:
        if (r14.hasNext() == false) goto L29;
        if (e((CreationItem) r14.next(), r7) == true) goto L30;
        r0 = r0 + 1;
    L30:
        if (r0 != (-1)) goto L33;
        return -1;
    L33:
        return r1 + r0;
    L29:
        r0 = -1;
        goto L30
    L34:
        return -1;
    }
}
