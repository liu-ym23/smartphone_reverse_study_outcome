package ic8;

import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.SendFile;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoData;
import com.larus.im.bean.message.VideoExtension;
import com.larus.im.bean.message.block.AttachmentBlock;
import com.larus.im.bean.message.block.AttachmentItem;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u {
    public static final u a = null;

    static {
        a = new u();
    }

    public u() {
    }

    public static List a(Message r43) {
        if (r43 == null) goto L5;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L116
        ArrayList r2 = new ArrayList();     // Catch: Throwable -> L116
        int r4 = 1;
        if (com.larus.im.bean.message.a.b0(r43) == false) goto L79;
        Intrinsics.checkNotNullParameter(r43, "<this>");     // Catch: Throwable -> L116
        Iterator r3 = vd9.r.a(r43).iterator();     // Catch: Throwable -> L116
    L10:
        if (r3.hasNext() == false) goto L79;
        Block r6 = (Block) r3.next();     // Catch: Throwable -> L116
        BlockContent r7 = r6.getContent();     // Catch: Throwable -> L116
        if (r7 == null) goto L24;
        AttachmentBlock r8 = r7.getAttachmentBlock();     // Catch: Throwable -> L116
        if (r8 == null) goto L24;
        List r9 = r8.getAttachments();     // Catch: Throwable -> L116
        if (r9 == null) goto L24;
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L116
        Iterator r11 = r9.iterator();     // Catch: Throwable -> L116
    L19:
        if (r11.hasNext() == false) goto L23;
        UplinkFileEntity r12 = h.f((AttachmentItem) r11.next(), r43);     // Catch: Throwable -> L116
        if (r12 == null) goto L19;
        r10.add(r12);     // Catch: Throwable -> L116
        goto L19
    L23:
        r2.addAll(r10);     // Catch: Throwable -> L116
    L24:
        BlockContent r13 = r6.getContent();     // Catch: Throwable -> L116
        if (r13 == null) goto L77;
        CreationBlock r14 = r13.getCreationBlock();     // Catch: Throwable -> L116
        if (r14 == null) goto L77;
        List r15 = r14.creations;     // Catch: Throwable -> L116
        if (r15 == null) goto L77;
        Iterator r16 = r15.iterator();     // Catch: Throwable -> L116
    L32:
        if (r16.hasNext() == false) goto L77;
        CreationItem r17 = (CreationItem) r16.next();     // Catch: Throwable -> L116
        ImageData r18 = r17.image;     // Catch: Throwable -> L116
        if (r18 == null) goto L46;
        ImageObj r19 = r18.imageOrigin;     // Catch: Throwable -> L116
        ImageObj r110 = r18.imageThumb;     // Catch: Throwable -> L116
        ImageObj r20 = r18.imagePreview;     // Catch: Throwable -> L116
        if (r20 != null) goto L38;
        ImageObj r111 = r110;
    L39:
        String r112 = r18.key;     // Catch: Throwable -> L116
        String r21 = r17.id;     // Catch: Throwable -> L116
        if (r21 != null) goto L42;
        r21 = UUID.randomUUID().toString();     // Catch: Throwable -> L116
    L42:
        Image r22 = new Image(r112, null, r110, r19, null, null, r21, null, r111, null, null, null, null, null, 16050, null);     // Catch: Throwable -> L116
        Integer r27 = Integer.valueOf(UplinkEntityType.EntityTypeImage.getValue());     // Catch: Throwable -> L116
        UplinkEntityContent r113 = new UplinkEntityContent(null, r22, r4, null);     // Catch: Throwable -> L116
        String r23 = r17.id;     // Catch: Throwable -> L116
        if (r23 != null) goto L45;
        r23 = UUID.randomUUID().toString();     // Catch: Throwable -> L116
    L45:
        r2.add(new UplinkFileEntity(r27, r113, r23, null, null, null, null, null, null, false, null, null, null, null, 16376, null));     // Catch: Throwable -> L116
        goto L46
    L38:
        r111 = r20;
    L46:
        VideoData r24 = r17.video;     // Catch: Throwable -> L116
        if (r24 == null) goto L76;
        Cover r25 = r24.cover;     // Catch: Throwable -> L116
        if (r25 == null) goto L59;
        ImageObj r114 = r25.imageThumb;     // Catch: Throwable -> L116
        if (r114 != null) goto L53;
        ImageObj r115 = r25.imagePreview;     // Catch: Throwable -> L116
    L54:
        ImageObj r116 = r25.imagePreview;     // Catch: Throwable -> L116
        if (r116 != null) goto L57;
        ImageObj r26 = r114;
    L58:
        Image r32 = new Image(r25.key, null, r115, r26, null, null, null, null, r26, null, null, null, null, null, 16114, null);     // Catch: Throwable -> L116
    L60:
        int r28 = FileType.FileTypeVideo.getValue();     // Catch: Throwable -> L116
        String r117 = r24.vid;     // Catch: Throwable -> L116
        String r118 = r24.vid;     // Catch: Throwable -> L116
        String r119 = r24.videoModel;     // Catch: Throwable -> L116
        String r120 = r24.videoType;     // Catch: Throwable -> L116
        String r121 = r24.downloadUrl;     // Catch: Throwable -> L116
        String r122 = r24.downloadFilehash;     // Catch: Throwable -> L116
        Double r5 = r24.duration;     // Catch: Throwable -> L116
        if (r5 == null) goto L63;
        Float r36 = Float.valueOf((float) r5.doubleValue());     // Catch: Throwable -> L116
    L64:
        Long r29 = r24.height;     // Catch: Throwable -> L116
        if (r29 == null) goto L67;
        Integer r37 = Integer.valueOf((int) r29.longValue());     // Catch: Throwable -> L116
    L68:
        Long r30 = r24.width;     // Catch: Throwable -> L116
        if (r30 == null) goto L71;
        Integer r38 = Integer.valueOf((int) r30.longValue());     // Catch: Throwable -> L116
    L72:
        UplinkFileInfo r31 = new UplinkFileInfo(null, r117, null, Integer.valueOf(r28), null, null, new VideoExtension(r118, r119, r32, r120, r121, r122, r36, r37, r38, null, 512, null), null, null, null, 949, null);     // Catch: Throwable -> L116
        Integer r210 = Integer.valueOf(UplinkEntityType.EntityTypeFile.getValue());     // Catch: Throwable -> L116
        UplinkEntityContent r33 = new UplinkEntityContent(r31, null, 2, null);     // Catch: Throwable -> L116
        String r34 = r17.id;     // Catch: Throwable -> L116
        if (r34 != null) goto L75;
        r34 = UUID.randomUUID().toString();     // Catch: Throwable -> L116
    L75:
        r2.add(new UplinkFileEntity(r210, r33, r34, null, null, null, null, null, null, false, null, null, null, null, 16376, null));     // Catch: Throwable -> L116
        goto L76
    L71:
        r38 = null;
        goto L72
    L67:
        r37 = null;
        goto L68
    L63:
        r36 = null;
        goto L64
    L57:
        r26 = r116;
        goto L58
    L53:
        r115 = r114;
        goto L54
    L59:
        r32 = null;
    L76:
        r4 = 1;
    L77:
        r4 = 1;
    L79:
        if (lr8.c.a(r43) == false) goto L96;
        List r35 = com.larus.bmhome.chat.bean.d.f(r43).getEntities();     // Catch: Throwable -> L116
        if (r35 == null) goto L96;
        Iterator r39 = r35.iterator();     // Catch: Throwable -> L116
    L84:
        if (r39.hasNext() == false) goto L96;
        UplinkFileEntity r40 = (UplinkFileEntity) r39.next();     // Catch: Throwable -> L116
        String r41 = r40.getFileIdentifier();     // Catch: Throwable -> L116
        if (r41 != null) goto L88;
    L91:
        boolean r42 = true;
    L92:
        if (r42 == false) goto L94;
        r40.setFileIdentifier(UUID.randomUUID().toString());     // Catch: Throwable -> L116
    L94:
        r2.add(r40);     // Catch: Throwable -> L116
        goto L84
    L88:
        if (StringsKt.isBlank(r41) == true) goto L91;
        r42 = false;
    L96:
        if (r43.getContentType() != 6) goto L107;
        List r44 = com.larus.bmhome.chat.bean.d.g(r43).imageList;     // Catch: Throwable -> L116
        if (r44 == null) goto L107;
        Iterator r45 = r44.iterator();     // Catch: Throwable -> L116
    L101:
        if (r45.hasNext() == false) goto L107;
        Image r46 = (Image) r45.next();     // Catch: Throwable -> L116
        String r47 = r46.identifier;     // Catch: Throwable -> L116
        if (r47 != null) goto L105;
        r47 = UUID.randomUUID().toString();     // Catch: Throwable -> L116
    L105:
        r2.add(new UplinkFileEntity(Integer.valueOf(UplinkEntityType.EntityTypeImage.getValue()), new UplinkEntityContent(null, r46, 1, null), r47, null, null, null, null, null, null, false, null, null, null, null, 16376, null));     // Catch: Throwable -> L116
    L107:
        if (r43.getContentType() != 7) goto L114;
        List r0 = com.larus.bmhome.chat.sendimage.e.f(r43.getContent()).getFileList();     // Catch: Throwable -> L116
        if (r0 == null) goto L114;
        Iterator r48 = r0.iterator();     // Catch: Throwable -> L116
    L112:
        if (r48.hasNext() == false) goto L114;
        SendFile r49 = (SendFile) r48.next();     // Catch: Throwable -> L116
        r2.add(new UplinkFileEntity(Integer.valueOf(UplinkEntityType.EntityTypeFile.getValue()), new UplinkEntityContent(new UplinkFileInfo(r49.getFileName(), r49.getTosKey(), null, Integer.valueOf(FileType.FileTypeFile.getValue()), null, r49.getResourceId(), null, null, r49.getLocalResPath(), null, 724, null), null, 2, null), UUID.randomUUID().toString(), null, null, null, null, null, null, false, null, null, null, null, 16376, null));     // Catch: Throwable -> L116
    L114:
        Object r50 = Result.constructor-impl(r2);     // Catch: Throwable -> L116
    L118:
        List r51 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r50) == false) goto L122;
        r50 = r51;
    L122:
        return (List) r50;
    L116:
        th = move-exception;
        Result.Companion r52 = Result.Companion;
        r50 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L118
    L5:
        return CollectionsKt.emptyList();
    }

    public static UplinkFileEntity b(Message r3, String r4) {
        List r5 = a(r3);
        Object r1 = null;
        if (r5.isEmpty() == false) goto L5;
        return null;
    L5:
        if (r4 != null) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == true) goto L21;
        Iterator r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L19;
        Object r2 = r6.next();
        if (Intrinsics.areEqual(((UplinkFileEntity) r2).getFileIdentifier(), r4) == false) goto L14;
        r1 = r2;
    L19:
        return (UplinkFileEntity) r1;
    L21:
        return (UplinkFileEntity) CollectionsKt.firstOrNull(r5);
    L7:
        if (StringsKt.isBlank(r4) == true) goto L10;
        r0 = false;
        goto L11
    }
}
