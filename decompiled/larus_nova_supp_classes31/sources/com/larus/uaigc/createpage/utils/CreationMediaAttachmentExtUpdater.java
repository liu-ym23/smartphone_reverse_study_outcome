package com.larus.uaigc.createpage.utils;

import com.larus.bmhome.actionbar.model.ImageUploadInfo;
import com.larus.bmhome.actionbar.model.MediaAttachment;
import com.larus.bmhome.actionbar.model.VideoUploadInfo;
import com.larus.bmhome.actionbar.model.f2;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationMediaAttachmentExtUpdater {
    public static final CreationMediaAttachmentExtUpdater a = null;

    static {
        a = new CreationMediaAttachmentExtUpdater();
    }

    public CreationMediaAttachmentExtUpdater() {
    }

    public static List a(NestedFileContent r22) {
        if (r22 == null) goto L5;
        List r1 = r22.getEntities();
    L6:
        if (r1 != null) goto L8;
        r1 = CollectionsKt.emptyList();
    L8:
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L10:
        if (r3.hasNext() == false) goto L205;
        UplinkFileEntity r4 = (UplinkFileEntity) r3.next();
        Integer r5 = r4.getUpLinkStatus();
        int r6 = UpLinkState.SUCCESS.getValue();
        if (r5 != null) goto L15;
    L202:
        MediaAttachment r7 = null;
    L203:
        if (r7 == null) goto L10;
        r2.add(r7);
        goto L10
    L15:
        if (r5.intValue() != r6) goto L202;
        Integer r8 = r4.getFileReviewStatus();
        int r9 = FileReviewState.NOT_COMPLIANT.getValue();
        if (r8 != null) goto L20;
    L22:
        Integer r10 = r4.getEntityType();
        int r11 = UplinkEntityType.EntityTypeImage.getValue();
        boolean r12 = true;
        if (r10 != null) goto L26;
    L90:
        UplinkEntityContent r13 = r4.getUplinkEntityContent();
        int r14 = 0;
        if (r13 == null) goto L100;
        UplinkFileInfo r15 = r13.getUplinkFileInfo();
        if (r15 == null) goto L100;
        Integer r16 = r15.getFileType();
        int r17 = FileType.FileTypeVideo.getValue();
        if (r16 == null) goto L100;
        if (r16.intValue() != r17) goto L100;
        boolean r18 = true;
    L101:
        if (r18 == false) goto L202;
        a.getClass();
        UplinkEntityContent r19 = r4.getUplinkEntityContent();
        if (r19 == null) goto L107;
        UplinkFileInfo r20 = r19.getUplinkFileInfo();
        if (r20 == null) goto L107;
        VideoExtension r21 = r20.getVideo();
    L108:
        if (r21 == null) goto L112;
        Image r23 = r21.getCover();
        if (r23 == null) goto L112;
        ImageObj r24 = r23.imageOri;
    L114:
        if (r21 == null) goto L116;
        String r25 = r21.getVid();
    L117:
        if (r21 == null) goto L129;
        Image r110 = r21.getCover();
        if (r110 == null) goto L129;
        ImageObj r111 = r110.imageThumb;
        if (r111 == null) goto L129;
        String r112 = r111.url;
        if (r112 == null) goto L129;
        if ((!StringsKt.isBlank(r112)) == true) goto L128;
        r112 = null;
    L128:
        if (r112 == null) goto L129;
    L171:
        if (r21 == null) goto L175;
        Image r26 = r21.getCover();
        if (r26 == null) goto L175;
        String r27 = r26.localResPath;
    L176:
        if (r24 == null) goto L178;
        int r113 = r24.width;
    L184:
        if (r24 == null) goto L186;
        r14 = r24.height;
    L191:
        f2 r28 = new f2(r112, r27, Integer.valueOf(r14), Integer.valueOf(r113));
        if (r21 == null) goto L196;
        Float r29 = r21.getDuration();
        if (r29 == null) goto L196;
        Double r30 = Double.valueOf(r29.floatValue());
    L197:
        VideoUploadInfo r114 = new VideoUploadInfo(r25, r28, r30);
        if (r21 == null) goto L200;
        String r115 = r21.getPath();
    L201:
        r7 = new MediaAttachment(null, null, null, r114, r115, null, null, null, null, null, null, null, 4071, null);
        goto L203
    L200:
        r115 = null;
    L196:
        r30 = null;
        goto L197
    L186:
        if (r21 == null) goto L188;
        Integer r31 = r21.getHeight();
    L189:
        if (r31 == null) goto L191;
        r14 = r31.intValue();
        goto L191
    L188:
        r31 = null;
        goto L189
    L178:
        if (r21 == null) goto L180;
        Integer r116 = r21.getWidth();
    L181:
        if (r116 == null) goto L183;
        r113 = r116.intValue();
        goto L184
    L183:
        r113 = 0;
        goto L184
    L180:
        r116 = null;
    L175:
        r27 = null;
    L129:
        if (r21 == null) goto L139;
        Image r117 = r21.getCover();
        if (r117 == null) goto L139;
        ImageObj r118 = r117.previewImage;
        if (r118 == null) goto L139;
        r112 = r118.url;
        if (r112 == null) goto L139;
        if ((!StringsKt.isBlank(r112)) == false) goto L139;
    L140:
        if (r112 != null) goto L171;
        if (r21 == null) goto L151;
        Image r119 = r21.getCover();
        if (r119 == null) goto L151;
        ImageObj r120 = r119.imageOri;
        if (r120 == null) goto L151;
        r112 = r120.url;
        if (r112 == null) goto L151;
        if ((!StringsKt.isBlank(r112)) == false) goto L151;
    L152:
        if (r112 != null) goto L171;
        if (r21 == null) goto L170;
        Image r121 = r21.getCover();
        if (r121 == null) goto L170;
        r112 = r121.key;
        if (r112 == null) goto L170;
        if (StringsKt.startsWith$default(r112, "http://", false, 2, null) == false) goto L161;
    L168:
        if (r12 == false) goto L170;
    L161:
        if (StringsKt.startsWith$default(r112, "https://", false, 2, null) == true) goto L168;
        if (StringsKt.startsWith$default(r112, "file://", false, 2, null) == true) goto L168;
        if (StringsKt.startsWith$default(r112, "content://", false, 2, null) == true) goto L168;
        r12 = false;
    L170:
        r112 = null;
    L151:
        r112 = null;
    L139:
        r112 = null;
        goto L140
    L116:
        r25 = null;
    L112:
        r24 = null;
    L107:
        r21 = null;
    L100:
        r18 = false;
        goto L101
    L26:
        if (r10.intValue() != r11) goto L90;
        a.getClass();
        UplinkEntityContent r32 = r4.getUplinkEntityContent();
        if (r32 == null) goto L30;
        Image r33 = r32.getUplinkImageInfo();
    L31:
        if (r33 == null) goto L33;
        String r34 = r33.key;
    L34:
        if (r34 != null) goto L36;
        r34 = "";
    L36:
        String r35 = r34;
        long r36 = 0;
        if (r33 == null) goto L41;
        ImageObj r37 = r33.imageOri;
        if (r37 == null) goto L41;
        long r122 = r37.width;
    L42:
        Long r38 = Long.valueOf(r122);
        if (r33 == null) goto L47;
        ImageObj r123 = r33.imageOri;
        if (r123 == null) goto L47;
        r36 = r123.height;
    L47:
        ImageUploadInfo r124 = new ImageUploadInfo(r38, Long.valueOf(r36));
        if (r33 == null) goto L58;
        ImageObj r39 = r33.imageOri;
        if (r39 == null) goto L58;
        String r40 = r39.url;
        if (r40 == null) goto L58;
        if ((!StringsKt.isBlank(r40)) == true) goto L57;
        r40 = null;
    L57:
        if (r40 == null) goto L58;
    L65:
        String r41 = r40;
    L67:
        if (r33 == null) goto L69;
        Boolean r125 = r33.aiCreationImage;
    L70:
        if (r33 == null) goto L73;
        String r42 = r33.localResPath;
        if (r42 == null) goto L73;
    L78:
        String r126 = r42;
    L80:
        if (r33 == null) goto L85;
        String r43 = r33.identifier;
        if (r43 == null) goto L85;
        String r127 = r43;
    L86:
        if (r33 == null) goto L88;
        String r128 = r33.resourceId;
    L89:
        r7 = new MediaAttachment(r41, r35, r124, null, r126, r127, r128, null, null, null, null, r125, 1928, null);
        goto L203
    L88:
        r128 = null;
    L85:
        r127 = r4.getFileIdentifier();
    L73:
        UplinkEntityContent r44 = r4.getUplinkEntityContent();
        if (r44 == null) goto L79;
        UplinkFileInfo r45 = r44.getUplinkFileInfo();
        if (r45 == null) goto L79;
        r42 = r45.getLocalResPath();
    L79:
        r126 = null;
        goto L80
    L69:
        r125 = null;
    L58:
        if (r33 == null) goto L66;
        ImageObj r46 = r33.imageThumb;
        if (r46 == null) goto L66;
        r40 = r46.url;
        if (r40 == null) goto L66;
        if ((true ^ StringsKt.isBlank(r40)) == true) goto L65;
    L66:
        r41 = null;
    L41:
        r122 = 0;
        goto L42
    L33:
        r34 = null;
        goto L34
    L30:
        r33 = null;
        goto L31
    L20:
        if (r8.intValue() != r9) goto L22;
    L205:
        return r2;
    L5:
        r1 = null;
        goto L6
    }

    public static Object b(String r3, Continuation r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new CreationMediaAttachmentExtUpdater$requireImageUrlOfUri$2(r3, null), r4);
    }

    public static void c(Map r7, NestedFileContent r8) {
        Intrinsics.checkNotNullParameter(r7, "ext");
        if (r8 != null) goto L6;
        FLogger.a.w("CreationMediaAttachmentExtUpdater", "[updateMultiMediaAttachmentListInExt] nested file snapshot missing, keep original ext");
        return;
    L6:
        String r2 = (String) r7.get("action_bar_instruction");
        if (r2 != null) goto L66;
        r2 = "";
    L66:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L11
        Object r4 = Result.constructor-impl((com.larus.bmhome.actionbar.model.r) xt7.d.b.c(com.larus.bmhome.actionbar.model.r.Companion.serializer(), r2));     // Catch: Throwable -> L11
    L13:
        Object r5 = null;
        if (Result.isFailure-impl(r4) == false) goto L16;
        r4 = null;
    L16:
        com.larus.bmhome.actionbar.model.r r6 = (com.larus.bmhome.actionbar.model.r) r4;
        if (r6 != null) goto L20;
        FLogger.a.e("CreationMediaAttachmentExtUpdater", "[updateMultiMediaAttachmentListInExt] instruction conf parse failed, keep original ext");
        return;
    L20:
        Integer r9 = r6.a;
        if (r9 != null) goto L24;
        return;
    L24:
        if (r9.intValue() == 28) goto L68;
        return;
    L68:
        Object r10 = Result.constructor-impl(a(r8));     // Catch: Throwable -> L28
    L30:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L34;
        FLogger.a.e("CreationMediaAttachmentExtUpdater", "[updateMultiMediaAttachmentListInExt] build attachment list failed", r11);
    L34:
        if (Result.isFailure-impl(r10) == false) goto L36;
        r10 = null;
    L36:
        List r12 = (List) r10;
        if (r12 != null) goto L39;
        return;
    L39:
        FLogger.a.i("CreationMediaAttachmentExtUpdater", "[updateMultiMediaAttachmentListInExt] attachment size=" + r12.size());
        d(r6, r12);
        com.larus.bmhome.actionbar.model.y r13 = r6.i;
        if (r13 == null) goto L64;
        ArrayList r14 = r13.a;
        if (r14 == null) goto L64;
        z0 r15 = (z0) CollectionsKt.firstOrNull(r14);
        if (r15 == null) goto L64;
        com.larus.bmhome.actionbar.model.r r16 = r15.q;
        if (r16 == null) goto L64;
        d(r16, r12);
    L64:
        Object r17 = Result.constructor-impl(xt7.d.b.a(com.larus.bmhome.actionbar.model.r.Companion.serializer(), r6));     // Catch: Throwable -> L50
    L52:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L56;
        FLogger.a.e("CreationMediaAttachmentExtUpdater", "[updateMultiMediaAttachmentListInExt] instruction conf encode failed", r18);
    L56:
        if (Result.isFailure-impl(r17) == true) goto L59;
        r5 = r17;
    L59:
        String r19 = (String) r5;
        if (r19 != null) goto L62;
        return;
    L62:
        r7.put("action_bar_instruction", r19);
        return;
    L50:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L28:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L11:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static void d(com.larus.bmhome.actionbar.model.r r6, List r7) {
        List r8 = r6.b;
        if (r8 == null) goto L48;
        Iterator r9 = r8.iterator();
    L5:
        Object r1 = null;
        if (r9.hasNext() == false) goto L16;
        Object r0 = r9.next();
        Integer r2 = ((com.larus.bmhome.actionbar.model.u) r0).b;
        if (r2 != null) goto L11;
    L13:
        boolean r3 = false;
    L14:
        if (r3 == false) goto L5;
    L17:
        com.larus.bmhome.actionbar.model.u r4 = (com.larus.bmhome.actionbar.model.u) r0;
        if (r4 == null) goto L49;
        CreationMediaAttachmentExtUpdater r10 = a;
        String r5 = r4.d;
        r10.getClass();
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L26
        ouc.v r12 = xt7.d.b;     // Catch: Throwable -> L26
        com.larus.bmhome.actionbar.model.v.b r13 = com.larus.bmhome.actionbar.model.v.Companion;     // Catch: Throwable -> L26
        juc.c r14 = r13.serializer();     // Catch: Throwable -> L26
        if (r5 != null) goto L23;
        String r15 = "";
    L24:
        com.larus.bmhome.actionbar.model.v r16 = (com.larus.bmhome.actionbar.model.v) r12.c(r14, r15);     // Catch: Throwable -> L26
        r16.c = r7;     // Catch: Throwable -> L26
        Object r17 = Result.constructor-impl(r12.a(r13.serializer(), r16));     // Catch: Throwable -> L26
    L28:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L32;
        FLogger.a.e("CreationMediaAttachmentExtUpdater", "[buildMultiMediaTemplateWithAttachments] template update failed", r18);
    L32:
        if (Result.isFailure-impl(r17) == true) goto L35;
        r1 = r17;
    L35:
        String r19 = (String) r1;
        if (r19 == null) goto L39;
        r5 = r19;
    L39:
        r4.d = r5;
        return;
    L23:
        r15 = r5;
    L26:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L49:
        return;
    L11:
        if (r2.intValue() != 15) goto L13;
        r3 = true;
        goto L14
    L16:
        r0 = null;
        goto L17
    }
}
