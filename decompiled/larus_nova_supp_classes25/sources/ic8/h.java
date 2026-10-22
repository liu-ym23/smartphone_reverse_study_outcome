package ic8;

import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.im.bean.message.block.AttachmentItem;
import com.larus.im.bean.message.block.AttachmentItemParseState;
import com.larus.im.bean.message.block.AttachmentItemReviewState;
import com.larus.im.bean.message.block.AttachmentItemUploadStatus;
import com.larus.im.bean.message.block.AttachmentType;
import com.larus.im.bean.message.block.Cover;
import com.larus.im.bean.message.block.ImageMeta;
import com.larus.im.bean.message.block.LocalFileType;
import com.larus.im.bean.message.block.UploadFile;
import com.larus.im.bean.message.block.UploadFileType;
import com.larus.im.bean.message.block.UploadImage;
import com.larus.im.bean.message.block.UploadLarkDoc;
import com.larus.im.bean.message.block.UploadLocalItem;
import com.larus.im.bean.message.block.UploadMedia;
import com.larus.im.bean.message.block.UploadMediaType;
import com.larus.platform.service.FlowDriveSdkService;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public static final AttachmentItem a(UplinkFileEntity r31) {
        Intrinsics.checkNotNullParameter(r31, "<this>");
        Integer r2 = r31.getFileReviewStatus();
        int r3 = FileReviewState.DEFAULT.getValue();
        if (r2 != null) goto L6;
    L9:
        int r4 = FileReviewState.ACCESS.getValue();
        if (r2 != null) goto L13;
    L15:
        int r5 = FileReviewState.NOT_COMPLIANT.getValue();
        if (r2 != null) goto L19;
    L21:
        int r6 = FileReviewState.PROCESSING.getValue();
        if (r2 != null) goto L25;
    L27:
        int r7 = AttachmentItemReviewState.ReviewStateAccess.getValue();
    L8:
        int r11 = r7;
        Integer r8 = r31.getFileParsedStatus();
        int r9 = FileParseState.DEFAULT.getValue();
        if (r8 != null) goto L32;
    L35:
        int r10 = FileParseState.SUCCESS.getValue();
        if (r8 != null) goto L39;
    L41:
        int r12 = FileParseState.FAILED.getValue();
        if (r8 != null) goto L45;
    L47:
        int r13 = FileParseState.PROCESSING.getValue();
        if (r8 != null) goto L51;
    L53:
        int r14 = AttachmentItemParseState.ParseStateSuccess.getValue();
    L34:
        int r15 = r14;
        Integer r16 = r31.getUpLinkStatus();
        int r17 = UpLinkState.DEFAULT.getValue();
        if (r16 != null) goto L58;
    L61:
        int r18 = UpLinkState.SUCCESS.getValue();
        if (r16 != null) goto L65;
    L67:
        int r19 = UpLinkState.FAIL.getValue();
        if (r16 != null) goto L71;
    L73:
        int r20 = AttachmentItemUploadStatus.AttachmentItemUploadStatusDefault.getValue();
    L60:
        int r110 = r20;
        Map r21 = r31.getExtra();
        if (r21 == null) goto L77;
        String r111 = (String) r21.get("drive_uplink_info");
    L78:
        Integer r22 = r31.getEntityType();
        int r23 = UplinkEntityType.EntityTypeImage.getValue();
        if (r22 != null) goto L82;
    L112:
        int r24 = UplinkEntityType.EntityTypeFile.getValue();
        if (r22 != null) goto L116;
    L260:
        return null;
    L116:
        if (r22.intValue() != r24) goto L260;
        UplinkEntityContent r25 = r31.getUplinkEntityContent();
        if (r25 == null) goto L120;
        UplinkFileInfo r26 = r25.getUplinkFileInfo();
    L121:
        Map r27 = r31.getExtra();
        if (r27 == null) goto L124;
        String r28 = (String) r27.get("local_item_attachment");
    L126:
        if (Intrinsics.areEqual(r28, "1") == false) goto L150;
        int r29 = AttachmentType.AttachmentTypeLocalItem.getValue();
        String r30 = r31.getFileIdentifier();
        if (r26 == null) goto L130;
        String r32 = r26.getFileName();
    L131:
        if (r26 == null) goto L133;
        String r112 = r26.getLocalResPath();
    L134:
        if (r26 == null) goto L136;
        String r33 = r26.getLocalResPath();
    L137:
        Map r34 = r31.getExtra();
        if (r34 == null) goto L144;
        String r35 = (String) r34.get("local_item_file_type");
        if (r35 == null) goto L144;
        Integer r36 = StringsKt.toIntOrNull(r35);
        if (r36 == null) goto L144;
        int r37 = r36.intValue();
    L145:
        UploadLocalItem r113 = new UploadLocalItem(r32, r112, r33, r37);
        Integer r0 = r31.getUpLinkProcess();
        if (r0 == null) goto L148;
        int r114 = r0.intValue();
    L263:
        return new AttachmentItem(r29, r30, null, null, null, null, r113, r11, r15, r114, r110, r111, null, 4156, null);
    L148:
        r114 = -1;
    L144:
        r37 = LocalFileType.LocalFileTypeUnknown.getValue();
        goto L145
    L136:
        r33 = null;
        goto L137
    L133:
        r112 = null;
        goto L134
    L130:
        r32 = null;
        goto L131
    L150:
        boolean r38 = false;
        if (r26 == null) goto L158;
        Integer r39 = r26.getFileType();
        int r40 = FileType.FileTypeAudio.getValue();
        if (r39 == null) goto L158;
        if (r39.intValue() != r40) goto L158;
        boolean r41 = true;
    L159:
        if (r41 == false) goto L176;
        VideoExtension r42 = r26.getVideo();
        if (r42 == null) goto L163;
        String r43 = r42.getVid();
    L164:
        if (r43 != null) goto L166;
    L169:
        boolean r44 = true;
    L170:
        if (r44 == true) goto L176;
        int r45 = AttachmentType.AttachmentTypeVideo.getValue();
        String r46 = r31.getFileIdentifier();
        UploadMedia r47 = i(r26);
        Integer r1 = r31.getUpLinkProcess();
        if (r1 == null) goto L174;
        int r115 = r1.intValue();
    L264:
        return new AttachmentItem(r45, r46, null, r47, null, null, null, r11, r15, r115, r110, r111, null, 4212, null);
    L174:
        r115 = -1;
        goto L264
    L166:
        if (StringsKt.isBlank(r43) == true) goto L169;
        r44 = false;
        goto L170
    L163:
        r43 = null;
    L176:
        if (r26 == null) goto L183;
        Integer r48 = r26.getFileType();
        int r49 = FileType.FileTypeVideo.getValue();
        if (r48 == null) goto L183;
        if (r48.intValue() != r49) goto L183;
        r38 = true;
    L183:
        if (r38 == false) goto L189;
        int r50 = AttachmentType.AttachmentTypeVideo.getValue();
        String r51 = r31.getFileIdentifier();
        UploadMedia r52 = i(r26);
        Integer r53 = r31.getUpLinkProcess();
        if (r53 == null) goto L187;
        int r116 = r53.intValue();
    L265:
        return new AttachmentItem(r50, r51, null, r52, null, null, null, r11, r15, r116, r110, r111, null, 4212, null);
    L187:
        r116 = -1;
        goto L265
    L189:
        int r54 = bq9.a.a;
        Map r55 = r31.getExtra();
        if (r55 == null) goto L192;
        String r56 = (String) r55.get("originFileTypeString");
    L194:
        if (l1.k(r56) == false) goto L240;
        int r57 = AttachmentType.AttachmentTypeLarkDoc.getValue();
        String r58 = r31.getFileIdentifier();
        Intrinsics.checkNotNullParameter(r31, "<this>");
        UplinkEntityContent r59 = r31.getUplinkEntityContent();
        if (r59 == null) goto L198;
        UplinkFileInfo r60 = r59.getUplinkFileInfo();
    L199:
        Map r117 = r31.getExtra();
        if (r117 == null) goto L202;
        String r61 = (String) r117.get("originFileTypeString");
    L204:
        if (Intrinsics.areEqual(r61, "bitable") == false) goto L219;
        Map r118 = r31.getExtra();
        if (r118 == null) goto L211;
        String r62 = (String) r118.get("originBaseBizType");
        if (r62 == null) goto L211;
        int r63 = StringsKt.toIntOrNull(r62);
        if (r63 == null) goto L211;
    L218:
        Integer r210 = r63;
    L220:
        if (r60 == null) goto L222;
        String r211 = r60.getFileName();
    L223:
        if (r60 == null) goto L225;
        String r212 = r60.getTosKey();
    L226:
        Integer r64 = FlowDriveSdkService.a.p(r61);
        if (r64 == null) goto L229;
        Long r213 = Long.valueOf(r64.intValue());
    L230:
        Map r65 = r31.getExtra();
        if (r65 == null) goto L234;
        String r66 = (String) r65.get("originUrl");
        if (r66 == null) goto L234;
    L235:
        UploadLarkDoc r67 = new UploadLarkDoc(r66, r212, r211, r213, r210);
        Integer r68 = r31.getUpLinkProcess();
        if (r68 == null) goto L238;
        int r119 = r68.intValue();
    L266:
        return new AttachmentItem(r57, r58, null, null, null, r67, null, r11, r15, r119, r110, r111, null, 4188, null);
    L238:
        r119 = -1;
    L234:
        r66 = "";
        goto L235
    L229:
        r213 = null;
        goto L230
    L225:
        r212 = null;
        goto L226
    L222:
        r211 = null;
    L211:
        int r69 = bq9.b.a;
        Map r70 = r31.getExtra();
        if (r70 == null) goto L214;
        String r71 = (String) r70.get("originUrl");
    L216:
        if (bq9.b.b(r71) == false) goto L219;
        r63 = 1;
        goto L218
    L214:
        r71 = null;
    L219:
        r210 = null;
        goto L220
    L202:
        r61 = null;
        goto L204
    L198:
        r60 = null;
        goto L199
    L240:
        int r72 = AttachmentType.AttachmentTypeFile.getValue();
        String r73 = r31.getFileIdentifier();
        if (r26 == null) goto L254;
        Intrinsics.checkNotNullParameter(r26, "<this>");
        Integer r74 = r26.getFileType();
        int r75 = FileType.FileTypeAudio.getValue();
        if (r74 != null) goto L246;
    L248:
        int r76 = UploadFileType.UploadFileTypeDefault.getValue();
    L249:
        int r214 = r76;
        String r215 = r26.getFileName();
        String r216 = r26.getTosKey();
        Long r77 = r26.getSize();
        if (r77 == null) goto L252;
        long r78 = r77.longValue();
    L253:
        UploadFile r79 = new UploadFile(r214, r215, r216, null, r78, r26.getMd5(), r26.getDuration(), 8, null);
    L255:
        Integer r80 = r31.getUpLinkProcess();
        if (r80 == null) goto L258;
        int r120 = r80.intValue();
    L267:
        return new AttachmentItem(r72, r73, null, null, r79, null, null, r11, r15, r120, r110, r111, null, 4204, null);
    L258:
        r120 = -1;
        goto L267
    L252:
        r78 = 0;
        goto L253
    L246:
        if (r74.intValue() != r75) goto L248;
        r76 = UploadFileType.UploadFileTypeAudio.getValue();
        goto L249
    L254:
        r79 = null;
        goto L255
    L192:
        r56 = null;
    L158:
        r41 = false;
        goto L159
    L124:
        r28 = null;
        goto L126
    L120:
        r26 = null;
        goto L121
    L82:
        if (r22.intValue() != r23) goto L112;
        UplinkEntityContent r81 = r31.getUplinkEntityContent();
        if (r81 == null) goto L86;
        Image r82 = r81.getUplinkImageInfo();
    L87:
        int r83 = AttachmentType.AttachmentTypeImage.getValue();
        String r84 = r31.getFileIdentifier();
        if (r82 == null) goto L106;
        Intrinsics.checkNotNullParameter(r82, "<this>");
        String r85 = r82.key;
        ImageObj r86 = r82.imageThumb;
        if (r86 == null) goto L92;
        ImageMeta r217 = c(r86);
    L93:
        ImageObj r87 = r82.imageOri;
        if (r87 == null) goto L96;
        ImageMeta r218 = c(r87);
    L97:
        ImageObj r88 = r82.previewImage;
        if (r88 == null) goto L100;
        ImageMeta r219 = c(r88);
    L101:
        String r89 = r82.md5;
        ImageObj r90 = r82.imageOriRaw;
        if (r90 == null) goto L104;
        ImageMeta r220 = c(r90);
    L105:
        UploadImage r91 = new UploadImage(r85, r217, r218, r219, r89, r220, r82.aiCreationImage);
    L107:
        Integer r92 = r31.getUpLinkProcess();
        if (r92 == null) goto L110;
        int r121 = r92.intValue();
    L262:
        return new AttachmentItem(r83, r84, r91, null, null, null, null, r11, r15, r121, r110, r111, null, 4216, null);
    L110:
        r121 = -1;
        goto L262
    L104:
        r220 = null;
        goto L105
    L100:
        r219 = null;
        goto L101
    L96:
        r218 = null;
        goto L97
    L92:
        r217 = null;
        goto L93
    L106:
        r91 = null;
        goto L107
    L86:
        r82 = null;
        goto L87
    L77:
        r111 = null;
        goto L78
    L71:
        if (r16.intValue() != r19) goto L73;
        r20 = AttachmentItemUploadStatus.AttachmentItemUploadStatusFail.getValue();
        goto L60
    L65:
        if (r16.intValue() != r18) goto L67;
        r20 = AttachmentItemUploadStatus.AttachmentItemUploadStatusSuccess.getValue();
        goto L60
    L58:
        if (r16.intValue() != r17) goto L61;
        r20 = AttachmentItemUploadStatus.AttachmentItemUploadStatusDefault.getValue();
        goto L60
    L51:
        if (r8.intValue() != r13) goto L53;
        r14 = AttachmentItemParseState.ParseStateProcessing.getValue();
        goto L34
    L45:
        if (r8.intValue() != r12) goto L47;
        r14 = AttachmentItemParseState.ParseStateFailed.getValue();
        goto L34
    L39:
        if (r8.intValue() != r10) goto L41;
        r14 = AttachmentItemParseState.ParseStateSuccess.getValue();
        goto L34
    L32:
        if (r8.intValue() != r9) goto L35;
        r14 = AttachmentItemParseState.ParseStateDefault.getValue();
        goto L34
    L25:
        if (r2.intValue() != r6) goto L27;
        r7 = AttachmentItemReviewState.ReviewStateProcessing.getValue();
        goto L8
    L19:
        if (r2.intValue() != r5) goto L21;
        r7 = AttachmentItemReviewState.ReviewStateNotCompliant.getValue();
        goto L8
    L13:
        if (r2.intValue() != r4) goto L15;
        r7 = AttachmentItemReviewState.ReviewStateAccess.getValue();
        goto L8
    L6:
        if (r2.intValue() != r3) goto L9;
        r7 = AttachmentItemReviewState.ReviewStateDefault.getValue();
        goto L8
    }

    public static final Image b(UploadImage r19) {
        Intrinsics.checkNotNullParameter(r19, "<this>");
        String r3 = r19.getUri();
        ImageMeta r0 = r19.getImageThumb();
        if (r0 == null) goto L5;
        ImageObj r5 = d(r0);
    L6:
        ImageMeta r1 = r19.getImageOri();
        if (r1 == null) goto L9;
        ImageObj r6 = d(r1);
    L10:
        ImageMeta r2 = r19.getImagePreview();
        if (r2 == null) goto L13;
        ImageObj r11 = d(r2);
    L14:
        ImageMeta r4 = r19.getImageOriRaw();
        if (r4 == null) goto L17;
        ImageObj r12 = d(r4);
    L19:
        return new Image(r3, r19.getMd5(), r5, r6, null, null, null, null, r11, r12, r19.getAiCreationImage(), null, null, null, 14576, null);
    L17:
        r12 = null;
        goto L19
    L13:
        r11 = null;
        goto L14
    L9:
        r6 = null;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public static final ImageMeta c(ImageObj r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return new ImageMeta(r4.url, r4.width, r4.height, r4.urlFormats);
    }

    public static final ImageObj d(ImageMeta r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        return new ImageObj(r9.getUrl(), r9.getWidth(), r9.getHeight(), r9.getUrlFormats(), null, 16, null);
    }

    public static final UplinkFileInfo h(UploadMedia r39) {
        Intrinsics.checkNotNullParameter(r39, "<this>");
        String r2 = r39.getName();
        String r3 = r39.getResourceUri();
        String r4 = r39.getMd5();
        if (r39.getMediaType() != UploadMediaType.UploadMediaTypeAudio.getValue()) goto L5;
        int r5 = FileType.FileTypeAudio.getValue();
    L6:
        Integer r6 = Integer.valueOf(r5);
        Long r7 = Long.valueOf(r39.getSize());
        String r9 = r39.getVid();
        String r10 = r39.getPath();
        Cover r8 = r39.getCover();
        if (r8 == null) goto L9;
        String r23 = r8.getKey();
    L10:
        Cover r11 = r39.getCover();
        if (r11 == null) goto L15;
        ImageMeta r12 = r11.getImageThumb();
        if (r12 == null) goto L15;
        ImageObj r25 = d(r12);
    L16:
        Cover r13 = r39.getCover();
        if (r13 == null) goto L21;
        ImageMeta r14 = r13.getImagePreview();
        if (r14 == null) goto L21;
        ImageObj r26 = d(r14);
    L23:
        return new UplinkFileInfo(r2, r3, r4, r6, r7, null, new VideoExtension(r9, r10, new Image(r23, null, r25, r26, null, null, null, null, null, null, null, null, null, null, 16370, null), null, null, null, Float.valueOf(r39.getDuration()), null, null, null, 952, null), null, null, null, 928, null);
    L21:
        r26 = null;
    L15:
        r25 = null;
        goto L16
    L9:
        r23 = null;
        goto L10
    L5:
        r5 = FileType.FileTypeVideo.getValue();
        goto L6
    }

    public static final UploadMedia i(UplinkFileInfo r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Integer r1 = r12.getFileType();
        int r2 = FileType.FileTypeAudio.getValue();
        if (r1 != null) goto L6;
    L8:
        int r3 = UploadMediaType.UploadMediaTypeVideo.getValue();
    L9:
        int r4 = r3;
        VideoExtension r5 = r12.getVideo();
        if (r5 == null) goto L12;
        String r6 = r5.getVid();
    L13:
        VideoExtension r7 = r12.getVideo();
        if (r7 == null) goto L18;
        Image r8 = r7.getCover();
        if (r8 == null) goto L18;
        String r9 = r8.key;
    L19:
        VideoExtension r10 = r12.getVideo();
        if (r10 == null) goto L26;
        Image r11 = r10.getCover();
        if (r11 == null) goto L26;
        ImageObj r13 = r11.imageThumb;
        if (r13 == null) goto L26;
        ImageMeta r14 = c(r13);
    L27:
        VideoExtension r15 = r12.getVideo();
        if (r15 == null) goto L34;
        Image r16 = r15.getCover();
        if (r16 == null) goto L34;
        ImageObj r17 = r16.imageOri;
        if (r17 == null) goto L34;
        ImageMeta r18 = c(r17);
    L35:
        Cover r19 = new Cover(r9, r14, r18);
        VideoExtension r20 = r12.getVideo();
        if (r20 == null) goto L40;
        Float r21 = r20.getDuration();
        if (r21 == null) goto L40;
        float r22 = r21.floatValue();
    L41:
        Long r23 = r12.getSize();
        if (r23 == null) goto L44;
        long r24 = r23.longValue();
    L45:
        String r25 = r12.getFileName();
        String r110 = r12.getMd5();
        VideoExtension r26 = r12.getVideo();
        if (r26 == null) goto L48;
        String r111 = r26.getPath();
    L50:
        return new UploadMedia(r4, r6, r19, r22, r24, r25, r110, r111, r12.getTosKey());
    L48:
        r111 = null;
        goto L50
    L44:
        r24 = 0;
    L40:
        r22 = 0.0f;
    L34:
        r18 = null;
    L26:
        r14 = null;
    L18:
        r9 = null;
        goto L19
    L12:
        r6 = null;
        goto L13
    L6:
        if (r1.intValue() != r2) goto L8;
        r3 = UploadMediaType.UploadMediaTypeAudio.getValue();
        goto L9
    }

    public static final UplinkFileEntity f(AttachmentItem r1, Message r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "originMessage");
        String r0 = r1.getIdentifier();
        if (r0 == null) goto L5;
        String r3 = com.larus.bmhome.chat.sendimage.e.h(r2, r0);
    L7:
        return g(r1, r3);
    L5:
        r3 = null;
        goto L7
    }

    public static final UplinkFileEntity g(AttachmentItem r37, String r38) {
        Intrinsics.checkNotNullParameter(r37, "<this>");
        int r3 = r37.getReviewState();
        if (r3 != AttachmentItemReviewState.ReviewStateDefault.getValue()) goto L6;
        int r4 = FileReviewState.DEFAULT.getValue();
    L15:
        int r5 = r37.getParseState();
        if (r5 != AttachmentItemParseState.ParseStateDefault.getValue()) goto L19;
        int r6 = FileParseState.DEFAULT.getValue();
    L28:
        int r7 = r37.getUploadStatus();
        if (r7 != AttachmentItemUploadStatus.AttachmentItemUploadStatusDefault.getValue()) goto L35;
        if (r37.getProgress() < 0) goto L33;
        int r8 = UpLinkState.PROCESSING.getValue();
    L42:
        if (r37.getLarkDoc() != null) goto L44;
        String r9 = r37.getSrc();
        String r10 = null;
        if (r9 == null) goto L48;
        Map r23 = MapsKt.mapOf(TuplesKt.to("drive_uplink_info", r9));
    L49:
        int r11 = r37.getType();
        boolean r12 = true;
        if (r11 != AttachmentType.AttachmentTypeImage.getValue()) goto L57;
        Integer r2 = Integer.valueOf(UplinkEntityType.EntityTypeImage.getValue());
        UploadImage r13 = r37.getImage();
        if (r13 == null) goto L54;
        Image r14 = b(r13);
        r14.localResPath = r38;
        Unit r1 = Unit.INSTANCE;
    L169:
        return new UplinkFileEntity(r2, new UplinkEntityContent(null, r14, 1, null), r37.getIdentifier(), null, Integer.valueOf(r4), Integer.valueOf(r6), Integer.valueOf(r37.getProgress()), Integer.valueOf(r8), null, false, null, null, null, r23, 7944, null);
    L54:
        r14 = null;
        goto L169
    L57:
        if (r11 != AttachmentType.AttachmentTypeVideo.getValue()) goto L64;
        Integer r15 = Integer.valueOf(UplinkEntityType.EntityTypeFile.getValue());
        UploadMedia r16 = r37.getMedia();
        if (r16 == null) goto L61;
        UplinkFileInfo r17 = h(r16);
        r17.setLocalResPath(r38);
    L170:
        return new UplinkFileEntity(r15, new UplinkEntityContent(r17, null, 2, null), r37.getIdentifier(), null, Integer.valueOf(r4), Integer.valueOf(r6), Integer.valueOf(r37.getProgress()), Integer.valueOf(r8), null, false, null, null, null, r23, 7944, null);
    L61:
        r17 = null;
        goto L170
    L64:
        if (r11 != AttachmentType.AttachmentTypeFile.getValue()) goto L142;
        UploadFile r18 = r37.getFile();
        if (r18 == null) goto L72;
        Intrinsics.checkNotNullParameter(r18, "<this>");
        String r25 = r18.getName();
        String r26 = r18.getUri();
        String r27 = r18.getMd5();
        if (r18.getFileType() != UploadFileType.UploadFileTypeAudio.getValue()) goto L70;
        int r19 = FileType.FileTypeAudio.getValue();
    L71:
        UplinkFileInfo r20 = new UplinkFileInfo(r25, r26, r27, Integer.valueOf(r19), Long.valueOf(r18.getSize()), null, null, null, null, r18.getDuration(), 480, null);
    L73:
        UploadMedia r21 = r37.getMedia();
        if (r21 != null) goto L76;
    L111:
        boolean r22 = false;
    L112:
        if (r22 == false) goto L136;
        if (r21 == null) goto L115;
        UplinkFileInfo r24 = h(r21);
    L116:
        if (r20 == null) goto L135;
        if (r24 == null) goto L119;
        Integer r28 = r24.getFileType();
    L120:
        r20.setFileType(r28);
        if (r24 == null) goto L123;
        VideoExtension r29 = r24.getVideo();
    L124:
        r20.setVideo(r29);
        String r30 = r20.getTosKey();
        if (r30 != null) goto L127;
    L130:
        if (r12 == false) goto L136;
        if (r24 == null) goto L133;
        String r31 = r24.getTosKey();
    L134:
        r20.setTosKey(r31);
        goto L136
    L133:
        r31 = null;
        goto L134
    L127:
        if (StringsKt.isBlank(r30) == true) goto L130;
        r12 = false;
        goto L130
    L123:
        r29 = null;
        goto L124
    L119:
        r28 = null;
        goto L120
    L135:
        r20 = r24;
        goto L136
    L115:
        r24 = null;
    L136:
        Integer r110 = Integer.valueOf(UplinkEntityType.EntityTypeFile.getValue());
        if (r20 == null) goto L139;
        r20.setLocalResPath(r38);
    L171:
        return new UplinkFileEntity(r110, new UplinkEntityContent(r20, null, 2, null), r37.getIdentifier(), null, Integer.valueOf(r4), Integer.valueOf(r6), Integer.valueOf(r37.getProgress()), Integer.valueOf(r8), null, false, null, null, null, r23, 7944, null);
    L139:
        r20 = null;
        goto L171
    L76:
        if (r21.getMediaType() != UploadMediaType.UploadMediaTypeAudio.getValue()) goto L108;
        String r32 = r21.getVid();
        if (r32 != null) goto L80;
    L83:
        boolean r33 = true;
    L84:
        if (r33 == true) goto L108;
        UploadFile r34 = r37.getFile();
        if (r34 == null) goto L88;
        String r35 = r34.getUri();
    L89:
        if (r35 != null) goto L91;
    L94:
        boolean r36 = true;
    L95:
        if (r36 == false) goto L108;
        UploadFile r39 = r37.getFile();
        if (r39 == null) goto L99;
        String r40 = r39.getUrl();
    L100:
        if (r40 != null) goto L102;
    L105:
        boolean r41 = true;
    L106:
        if (r41 == false) goto L108;
        boolean r42 = true;
    L109:
        if (r42 != true) goto L111;
        r22 = true;
        goto L112
    L102:
        if (StringsKt.isBlank(r40) == true) goto L105;
        r41 = false;
        goto L106
    L99:
        r40 = null;
        goto L100
    L91:
        if (StringsKt.isBlank(r35) == true) goto L94;
        r36 = false;
        goto L95
    L88:
        r35 = null;
        goto L89
    L80:
        if (StringsKt.isBlank(r32) == true) goto L83;
        r33 = false;
    L108:
        r42 = false;
        goto L109
    L70:
        r19 = FileType.FileTypeFile.getValue();
        goto L71
    L72:
        r20 = null;
        goto L73
    L142:
        if (r11 != AttachmentType.AttachmentTypeLarkDoc.getValue()) goto L145;
        return e(r37, Integer.valueOf(r4), Integer.valueOf(r6), Integer.valueOf(r8), r9);
    L145:
        if (r11 != AttachmentType.AttachmentTypeLocalItem.getValue()) goto L173;
        Integer r111 = Integer.valueOf(UplinkEntityType.EntityTypeFile.getValue());
        UploadLocalItem r43 = r37.getLocalItem();
        if (r43 == null) goto L149;
        String r112 = r43.getName();
    L150:
        Integer r113 = Integer.valueOf(FileType.FileTypeFile.getValue());
        UploadLocalItem r44 = r37.getLocalItem();
        if (r44 == null) goto L159;
        String r45 = r44.getPath();
        if (r45 == null) goto L159;
        if ((!StringsKt.isBlank(r45)) == true) goto L158;
        r45 = null;
    L158:
        if (r45 == null) goto L159;
    L162:
        String r210 = r45;
    L164:
        UplinkEntityContent r114 = new UplinkEntityContent(new UplinkFileInfo(r112, null, null, r113, null, null, null, null, r210, null, 758, null), null, 2, null);
        String r115 = r37.getIdentifier();
        Integer r116 = Integer.valueOf(r4);
        Integer r117 = Integer.valueOf(r6);
        Integer r211 = Integer.valueOf(r37.getProgress());
        Integer r212 = Integer.valueOf(r8);
        Pair[] r46 = new Pair[2];
        r46[0] = TuplesKt.to("local_item_attachment", "1");
        UploadLocalItem r0 = r37.getLocalItem();
        if (r0 == null) goto L167;
        r10 = Integer.valueOf(r0.getFileType()).toString();
    L167:
        r46[1] = TuplesKt.to("local_item_file_type", r10);
        return new UplinkFileEntity(r111, r114, r115, null, r116, r117, r211, r212, null, false, null, null, null, MapsKt.mapOf(r46), 7944, null);
    L159:
        UploadLocalItem r47 = r37.getLocalItem();
        if (r47 == null) goto L163;
        r45 = r47.getAbsPath();
        goto L162
    L163:
        r210 = null;
        goto L164
    L149:
        r112 = null;
        goto L150
    L173:
        return null;
    L48:
        r23 = null;
        goto L49
    L44:
        return e(r37, Integer.valueOf(r4), Integer.valueOf(r6), Integer.valueOf(r8), r37.getSrc());
    L33:
        r8 = UpLinkState.DEFAULT.getValue();
        goto L42
    L35:
        if (r7 != AttachmentItemUploadStatus.AttachmentItemUploadStatusSuccess.getValue()) goto L38;
        r8 = UpLinkState.SUCCESS.getValue();
        goto L42
    L38:
        if (r7 != AttachmentItemUploadStatus.AttachmentItemUploadStatusFail.getValue()) goto L40;
        r8 = UpLinkState.FAIL.getValue();
        goto L42
    L40:
        r8 = UpLinkState.DEFAULT.getValue();
        goto L42
    L19:
        if (r5 != AttachmentItemParseState.ParseStateSuccess.getValue()) goto L22;
        r6 = FileParseState.SUCCESS.getValue();
        goto L28
    L22:
        if (r5 != AttachmentItemParseState.ParseStateFailed.getValue()) goto L25;
        r6 = FileParseState.FAILED.getValue();
        goto L28
    L25:
        if (r5 != AttachmentItemParseState.ParseStateProcessing.getValue()) goto L27;
        r6 = FileParseState.PROCESSING.getValue();
        goto L28
    L27:
        r6 = FileParseState.SUCCESS.getValue();
        goto L28
    L6:
        if (r3 != AttachmentItemReviewState.ReviewStateAccess.getValue()) goto L9;
        r4 = FileReviewState.ACCESS.getValue();
        goto L15
    L9:
        if (r3 != AttachmentItemReviewState.ReviewStateNotCompliant.getValue()) goto L12;
        r4 = FileReviewState.NOT_COMPLIANT.getValue();
        goto L15
    L12:
        if (r3 != AttachmentItemReviewState.ReviewStateProcessing.getValue()) goto L14;
        r4 = FileReviewState.PROCESSING.getValue();
        goto L15
    L14:
        r4 = FileReviewState.ACCESS.getValue();
        goto L15
    }

    public static final UplinkFileEntity e(AttachmentItem r23, Integer r24, Integer r25, Integer r26, String r27) {
        UploadLarkDoc r0 = r23.getLarkDoc();
        FlowDriveSdkService r1 = FlowDriveSdkService.a;
        if (r0 == null) goto L5;
        Long r3 = r0.getType();
    L6:
        String r4 = "";
        if (r0 == null) goto L10;
        String r5 = r0.getTitle();
        if (r5 == null) goto L10;
    L11:
        String r2 = r1.g(r3, r5);
        if (r0 == null) goto L18;
        Integer r6 = r0.getBaseBizType();
        if (r6 == null) goto L18;
        r6.intValue();
        if (Intrinsics.areEqual(r2, "bitable") == false) goto L18;
    L19:
        Integer r7 = Integer.valueOf(UplinkEntityType.EntityTypeFile.getValue());
        if (r0 == null) goto L22;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        UplinkFileInfo r8 = new UplinkFileInfo(r0.getTitle(), r0.getToken(), " ", Integer.valueOf(FileType.FileTypeFile.getValue()), null, null, null, null, " ", null, 752, null);
        r8.setLocalResPath(r8.getLocalResPath());
    L23:
        UplinkEntityContent r9 = new UplinkEntityContent(r8, null, 2, null);
        String r10 = r23.getIdentifier();
        Integer r13 = Integer.valueOf(r23.getProgress());
        Pair[] r11 = new Pair[3];
        r11[0] = TuplesKt.to("originFileTypeString", r2);
        if (r0 == null) goto L29;
        String r12 = r0.getUrl();
        if (r12 == null) goto L29;
        r4 = r12;
    L29:
        r11[1] = TuplesKt.to("originUrl", r4);
        r11[2] = TuplesKt.to("drive_uplink_info", r27);
        Map r14 = MapsKt.mutableMapOf(r11);
        if (r6 == null) goto L32;
        r14.put("originBaseBizType", String.valueOf(r6.intValue()));
    L32:
        Unit r15 = Unit.INSTANCE;
        return new UplinkFileEntity(r7, r9, r10, null, r24, r25, r13, r26, null, false, null, null, null, r14, 7944, null);
    L22:
        r8 = null;
    L18:
        r6 = null;
    L10:
        r5 = "";
        goto L11
    L5:
        r3 = null;
        goto L6
    }
}
