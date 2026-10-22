package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverItem;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static final b b(ef8.b r2) {
        Message r3 = r2.a;
        if (r3 != null) goto L6;
    L12:
        boolean r4 = false;
    L14:
        if (r4 == true) goto L17;
        return null;
    L17:
        return new b();
    L6:
        if (com.larus.im.bean.message.a.b0(r3) == false) goto L8;
    L13:
        r4 = true;
        goto L14
    L8:
        if (r3.getContentType() != 6) goto L12;
        if (r3.getUserType() != 2) goto L12;
        goto L12
    }

    public static final String c(ef8.b r5) {
        JSONObject r0 = r5.l;
        String r2 = null;
        if (r0 == null) goto L9;
        String r1 = r0.optString("attachment_target_file_identifier");
        if (r1 == null) goto L9;
        if ((!StringsKt.isBlank(r1)) == false) goto L9;
    L10:
        boolean r3 = false;
        if (r1 != null) goto L13;
    L16:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L44;
        JSONObject r6 = r5.l;
        if (r6 == null) goto L26;
        String r7 = r6.optString("creation_task_id");
        if (r7 == null) goto L26;
        if ((!StringsKt.isBlank(r7)) == false) goto L26;
    L27:
        if (r7 != null) goto L29;
    L30:
        r3 = true;
    L31:
        if (r3 == false) goto L45;
        df8.a r8 = r5.f;
        if (r8 == null) goto L43;
        ImageItem r9 = r8.b;
        if (r9 == null) goto L43;
        String r10 = r9.getTaskId();
        if (r10 == null) goto L43;
        if ((!StringsKt.isBlank(r10)) == false) goto L43;
        r2 = r10;
    L43:
        return r2;
    L45:
        return r7;
    L29:
        if (StringsKt.isBlank(r7) == false) goto L31;
    L26:
        r7 = null;
        goto L27
    L44:
        return r1;
    L13:
        if (StringsKt.isBlank(r1) == true) goto L16;
        r4 = false;
    L9:
        r1 = null;
        goto L10
    }

    public static final UplinkFileEntity a(ef8.b r38, String r39) {
        df8.a r1 = r38.f;
        if (r1 == null) goto L47;
        ImageItem r2 = r1.b;
        if (r2 == null) goto L47;
        String r4 = r2.getKey();
        ImageEntity r0 = r2.getImageThumb();
        if (r0 == null) goto L16;
        String r3 = r0.getUrl();
        if (r3 == null) goto L16;
        if ((!StringsKt.isBlank(r3)) == false) goto L13;
        String r14 = r3;
    L14:
        if (r14 == null) goto L16;
        ImageObj r6 = new ImageObj(r14, 0, 0, null, null, 30, null);
    L17:
        ImageEntity r5 = r2.getImageOrigin();
        if (r5 == null) goto L27;
        String r7 = r5.getUrl();
        if (r7 == null) goto L27;
        if ((!StringsKt.isBlank(r7)) == false) goto L24;
        String r15 = r7;
    L25:
        if (r15 == null) goto L27;
        ImageObj r8 = new ImageObj(r15, 0, 0, null, null, 30, null);
    L28:
        ImageEntity r9 = r2.getPreviewImage();
        if (r9 == null) goto L38;
        String r10 = r9.getUrl();
        if (r10 == null) goto L38;
        if ((!StringsKt.isBlank(r10)) == false) goto L35;
        String r16 = r10;
    L36:
        if (r16 == null) goto L38;
        ImageObj r11 = new ImageObj(r16, 0, 0, null, null, 30, null);
    L39:
        Image r12 = new Image(r4, null, r6, r8, null, null, null, null, r11, null, null, null, null, null, 16114, null);
        Integer r22 = Integer.valueOf(UplinkEntityType.EntityTypeImage.getValue());
        UplinkEntityContent r13 = new UplinkEntityContent(null, r12, 1, null);
        if (r39 != null) goto L45;
        String r17 = r2.getTaskId();
        if (r17 != null) goto L44;
        r17 = r2.getKey();
    L44:
        String r24 = r17;
    L89:
        return new UplinkFileEntity(r22, r13, r24, null, null, null, null, null, null, false, null, null, null, null, 16376, null);
    L45:
        r24 = r39;
        goto L89
    L35:
        r16 = null;
    L38:
        r11 = null;
        goto L39
    L24:
        r15 = null;
    L27:
        r8 = null;
        goto L28
    L13:
        r14 = null;
    L16:
        r6 = null;
    L47:
        AiGenVideoContentData r18 = r38.j;
        if (r18 == null) goto L90;
        StringBuilder r19 = new StringBuilder("creation_");
        if (r39 != null) goto L52;
        Object r20 = Long.valueOf(System.currentTimeMillis());
    L53:
        r19.append(r20);
        r19.append(".");
        String r21 = r18.getVideoType();
        if (r21 != null) goto L56;
        r21 = "mp4";
    L56:
        r19.append(r21);
        String r23 = r19.toString();
        int r25 = FileType.FileTypeVideo.getValue();
        String r110 = r18.getLocalUrl();
        String r111 = r18.getVid();
        String r112 = r18.getVideoModel();
        CoverItem r26 = r18.getVideoCover();
        if (r26 == null) goto L78;
        String r113 = ff8.b.b(r26);
        if (r113 == null) goto L61;
        ImageObj r27 = new ImageObj(r113, 0, 0, null, null, 30, null);
    L62:
        String r114 = ff8.b.a(r26);
        if (r114 == null) goto L65;
        ImageObj r28 = new ImageObj(r114, 0, 0, null, null, 30, null);
    L66:
        if (r28 != null) goto L68;
        ImageObj r29 = r27;
    L69:
        String r115 = r26.getKey();
        if (r27 != null) goto L72;
        ImageObj r210 = r28;
    L74:
        if (r28 != null) goto L76;
        ImageObj r211 = r27;
    L77:
        Image r116 = new Image(r115, null, r210, r29, null, null, null, null, r211, null, null, null, null, null, 16114, null);
    L79:
        String r117 = r18.getVideoType();
        String r118 = r18.getDownloadUrl();
        String r212 = r18.getDownloadFilehash();
        Double r30 = r18.getDuration();
        if (r30 == null) goto L82;
        Float r213 = Float.valueOf((float) r30.doubleValue());
    L83:
        UplinkFileInfo r31 = new UplinkFileInfo(r23, null, null, Integer.valueOf(r25), null, null, new VideoExtension(r111, r112, r116, r117, r118, r212, r213, r18.getLoadingHeight(), r18.getLoadingWidth(), null, 512, null), null, r110, null, 694, null);
        Integer r119 = Integer.valueOf(UplinkEntityType.EntityTypeFile.getValue());
        UplinkEntityContent r32 = new UplinkEntityContent(r31, null, 2, null);
        if (r39 != null) goto L86;
        String r214 = r18.getVid();
    L88:
        return new UplinkFileEntity(r119, r32, r214, null, null, null, null, null, null, false, null, null, null, null, 16376, null);
    L86:
        r214 = r39;
        goto L88
    L82:
        r213 = null;
        goto L83
    L76:
        r211 = r28;
        goto L77
    L72:
        r210 = r27;
        goto L74
    L68:
        r29 = r28;
        goto L69
    L65:
        r28 = null;
        goto L66
    L61:
        r27 = null;
        goto L62
    L78:
        r116 = null;
        goto L79
    L52:
        r20 = r39;
        goto L53
    L90:
        return null;
    }

    public static final boolean d(ef8.b r3, String r4) {
        if (r3.a.getMessageStatus() == MessageStatus.MessageStatus_NOTCOMPLIANT) goto L17;
        ic8.u r0 = ic8.u.a;
        Message r5 = r3.a;
        r0.getClass();
        UplinkFileEntity r6 = ic8.u.b(r5, r4);
        FileReviewState.a r7 = FileReviewState.Companion;
        if (r6 == null) goto L8;
        Integer r8 = r6.getFileReviewStatus();
    L9:
        r7.getClass();
        int r9 = FileReviewState.NOT_COMPLIANT.getValue();
        if (r8 == null) goto L16;
        if (r8.intValue() != r9) goto L16;
        return true;
    L16:
        return false;
    L8:
        r8 = null;
        goto L9
    L17:
        return true;
    }
}
