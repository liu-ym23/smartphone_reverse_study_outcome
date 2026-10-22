package com.larus.bmhome.chat.component.bottom.attachment;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.platform.model.preview.AttachmentEditState;
import com.larus.platform.model.preview.AttachmentEditType;
import com.larus.platform.model.preview.AttachmentMediaType;
import com.larus.platform.model.preview.AttachmentSendableState;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.platform.model.preview.AttachmentSource;
import com.larus.platform.model.preview.AttachmentUploadState;
import com.larus.platform.model.preview.ResourceRef;
import com.larus.platform.model.preview.ResourceRefKind;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import yc9.l1;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d1 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[ResourceRefKind.values().length];
            r0[ResourceRefKind.LOCAL_URI.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[ResourceRefKind.REMOTE_URL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L6:
            a = r0;
            int[] r1 = new int[AttachmentUploadState.values().length];
            r1[AttachmentUploadState.UPLOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L29:
            r1[AttachmentUploadState.UPLOADED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L23:
            r1[AttachmentUploadState.SEND_PIPELINE_OWNED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L25:
            r1[AttachmentUploadState.NOT_UPLOADED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L11:
            b = r1;
        }
    }

    public static final String c(AttachmentSnapshot r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        String r0 = (String) r4.getExtra().get("preview_attachment_source_media_uri");
        boolean r1 = true;
        if (r0 != null) goto L5;
    L11:
        ResourceRef r5 = r4.effectiveRef();
        if (r5 != null) goto L14;
        return null;
    L14:
        if (r5.getKind() == ResourceRefKind.LOCAL_URI) goto L17;
        r1 = false;
    L17:
        if (r1 == true) goto L20;
        r5 = null;
    L20:
        if (r5 != null) goto L22;
        return null;
    L22:
        return r5.getUri();
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        return r0;
    }

    public static final UplinkFileEntity f(AttachmentSnapshot r40) {
        Intrinsics.checkNotNullParameter(r40, "<this>");
        ResourceRef r0 = r40.effectiveRef();
        if (r0 == null) goto L9;
        int r5 = a.a[r0.getKind().ordinal()];
        if (r5 == 1) goto L8;
        if (r5 == 2) goto L8;
    L11:
        if (r0 != null) goto L13;
    L21:
        String r6 = null;
    L22:
        if (r0 != null) goto L24;
    L32:
        String r7 = null;
    L34:
        if (r40.getEditState() != null) goto L36;
    L38:
        boolean r8 = false;
    L39:
        if (r8 == false) goto L41;
    L40:
        String r9 = null;
    L43:
        String r10 = r40.getResourceId();
        if (r8 == true) goto L46;
        String r13 = r10;
    L47:
        int r11 = a.b[r40.getUploadState().ordinal()];
        if (r11 == 1) goto L59;
        if (r11 != 2) goto L51;
        int r12 = UpLinkState.SUCCESS.getValue();
    L60:
        AttachmentMediaType r14 = r40.getMediaType();
        AttachmentMediaType r15 = AttachmentMediaType.IMAGE;
        if (r14 != r15) goto L63;
        int r16 = UplinkEntityType.EntityTypeImage.getValue();
    L64:
        Integer r17 = Integer.valueOf(r16);
        String r18 = r40.getStableId();
        UpLinkState r19 = UpLinkState.SUCCESS;
        if (r12 != r19.getValue()) goto L68;
        int r110 = 100;
    L71:
        Integer r21 = Integer.valueOf(r110);
        Integer r22 = Integer.valueOf(r12);
        if (r12 != r19.getValue()) goto L74;
        boolean r111 = true;
    L75:
        Boolean r23 = Boolean.valueOf(r111);
        if (r6 != null) goto L97;
        if (r7 == null) goto L96;
        if (r9 != null) goto L80;
    L83:
        boolean r112 = true;
    L84:
        if (r112 == false) goto L93;
        if (r13 != null) goto L87;
    L90:
        boolean r113 = true;
    L91:
        if (r113 == false) goto L93;
        boolean r114 = true;
    L94:
        if (r114 == false) goto L96;
        String r115 = r7;
    L98:
        if (r115 == null) goto L100;
        Uri r25 = UriProtector.parse(r115);
    L101:
        Map r116 = r40.getExtra();
        if (r8 == false) goto L104;
        r116 = MapsKt.minus(MapsKt.minus(r116, "drive_uplink_info"), "upload_from");
    L104:
        UplinkFileEntity r117 = new UplinkFileEntity(r17, null, r18, null, null, null, r21, r22, r23, false, r25, null, null, MapsKt.plus(r116, MapsKt.mapOf(TuplesKt.to("preview_snapshot_stable_id", r40.getStableId()))), 6714, null);
        if (r40.getMediaType() != r15) goto L152;
        Image r118 = new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        r118.key = r9;
        String r20 = r40.getChecksum();
        if (Boolean.valueOf(r8).booleanValue() == false) goto L110;
        r20 = null;
    L110:
        r118.md5 = r20;
        r118.resourceId = r13;
        r118.localResPath = r6;
        r118.identifier = r40.getStableId();
        if (r8 == true) goto L115;
        ResourceRef r24 = r40.getOriginRef();
        if (r24 == null) goto L115;
    L116:
        r118.imageOri = a(r24, r7);
        if (r8 == true) goto L123;
        ResourceRef r26 = r40.getDisplayRef();
        if (r26 == null) goto L123;
        r0 = r26;
    L123:
        r118.previewImage = a(r0, r7);
        ResourceRef r1 = r40.getThumbRef();
        if (Boolean.valueOf(r8).booleanValue() == false) goto L127;
        r1 = null;
    L127:
        r118.imageThumb = a(r1, null);
        AttachmentEditState r2 = r40.getEditState();
        if (r2 == null) goto L132;
        AttachmentEditType r3 = r2.getEditType();
        if (r3 == null) goto L132;
        String r4 = r3.name();
    L133:
        r118.setMarked(Boolean.valueOf(Intrinsics.areEqual(r4, "MARK")));
        AttachmentEditState r27 = r40.getEditState();
        if (r27 == null) goto L138;
        AttachmentEditType r28 = r27.getEditType();
        if (r28 == null) goto L138;
        String r29 = r28.name();
    L139:
        r118.setCropped(Boolean.valueOf(Intrinsics.areEqual(r29, "CROP")));
        Pair[] r30 = new Pair[2];
        Boolean r31 = r118.isMarked();
        Boolean r32 = Boolean.TRUE;
        String r33 = "0";
        if (Intrinsics.areEqual(r31, r32) == false) goto L142;
        Object r34 = "1";
    L143:
        r30[0] = TuplesKt.to("is_marked", r34);
        if (Intrinsics.areEqual(r118.isCropped(), r32) == false) goto L146;
        r33 = "1";
    L146:
        r30[1] = TuplesKt.to("is_cropped", r33);
        Map r35 = MapsKt.mapOf(r30);
        if (r40.getSource() != AttachmentSource.CLOUD_DRIVE) goto L150;
        if (r8 == true) goto L150;
        Map r36 = MapsKt.mapOf(TuplesKt.to("ext_is_from_drive", "1"));
    L151:
        r118.ext = MapsKt.plus(r35, r36);
        Unit r37 = Unit.INSTANCE;
        UplinkEntityContent r38 = new UplinkEntityContent(null, r118, 1, null);
    L174:
        r117.setUplinkEntityContent(r38);
        return r117;
    L150:
        r36 = MapsKt.emptyMap();
        goto L151
    L142:
        r34 = "0";
    L138:
        r29 = null;
    L132:
        r4 = null;
    L115:
        r24 = r0;
        goto L116
    L152:
        String r39 = r40.getFileName();
        String r119 = r40.getChecksum();
        if (r8 == false) goto L156;
        r119 = null;
    L156:
        AttachmentMediaType r41 = r40.getMediaType();
        AttachmentMediaType r120 = AttachmentMediaType.VIDEO;
        if (r41 != r120) goto L159;
        int r42 = FileType.FileTypeVideo.getValue();
    L160:
        Long r121 = r40.getFileSize();
        String r122 = r40.getMimeType();
        if (r40.getMediaType() != r120) goto L172;
        if (r7 != null) goto L164;
        r7 = "";
    L164:
        String r210 = r7;
        float r43 = r40.getDurationMs() / 1000.0f;
        if (r0 == null) goto L167;
        int r44 = r0.getWidth();
    L168:
        if (r0 == null) goto L170;
        int r123 = r0.getHeight();
    L171:
        Image r45 = new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        r45.imageThumb = a(r40.getThumbRef(), null);
        VideoExtension r46 = new VideoExtension(null, null, r45, null, r210, null, Float.valueOf(r43), Integer.valueOf(r123), Integer.valueOf(r44), null, 555, null);
    L173:
        r38 = new UplinkEntityContent(new UplinkFileInfo(r39, r9, r119, Integer.valueOf(r42), r121, r13, r46, r122, r6, null, 512, null), null, 2, null);
        goto L174
    L170:
        r123 = 0;
        goto L171
    L167:
        r44 = 0;
        goto L168
    L172:
        r46 = null;
        goto L173
    L159:
        r42 = FileType.FileTypeFile.getValue();
        goto L160
    L100:
        r25 = null;
        goto L101
    L87:
        if (StringsKt.isBlank(r13) == true) goto L90;
        r113 = false;
    L93:
        r114 = false;
        goto L94
    L80:
        if (StringsKt.isBlank(r9) == true) goto L83;
        r112 = false;
    L96:
        r115 = null;
        goto L98
    L97:
        r115 = r6;
        goto L98
    L74:
        r111 = false;
        goto L75
    L68:
        if (r12 != UpLinkState.PROCESSING.getValue()) goto L70;
        r110 = 1;
        goto L71
    L70:
        r110 = 0;
        goto L71
    L63:
        r16 = UplinkEntityType.EntityTypeFile.getValue();
        goto L64
    L51:
        if (r11 != 3) goto L53;
    L57:
        r12 = UpLinkState.DEFAULT.getValue();
        goto L60
    L53:
        if (r11 == 4) goto L57;
        throw new NoWhenBranchMatchedException();
    L59:
        r12 = UpLinkState.PROCESSING.getValue();
        goto L60
    L46:
        r13 = null;
        goto L47
    L41:
        if (r0 == null) goto L40;
        r9 = r0.getRemoteKey();
        goto L43
    L36:
        if (r40.getUploadState() == AttachmentUploadState.UPLOADED) goto L38;
        r8 = true;
        goto L39
    L24:
        if (r0.getKind() != ResourceRefKind.REMOTE_URL) goto L26;
        boolean r47 = true;
    L27:
        if (r47 == false) goto L29;
        ResourceRef r48 = r0;
    L30:
        if (r48 == null) goto L32;
        r7 = r48.getUri();
        goto L34
    L29:
        r48 = null;
        goto L30
    L26:
        r47 = false;
        goto L27
    L13:
        if (r0.getKind() != ResourceRefKind.LOCAL_URI) goto L15;
        boolean r49 = true;
    L16:
        if (r49 == false) goto L18;
        ResourceRef r50 = r0;
    L19:
        if (r50 == null) goto L21;
        r6 = r50.getUri();
        goto L22
    L18:
        r50 = null;
        goto L19
    L15:
        r49 = false;
    L8:
        r0 = dr9.a.b(r0.getUri(), r0.getRemoteKey(), r0.getWidth(), r0.getHeight());
        goto L11
    L9:
        r0 = null;
        goto L11
    }

    public static final ImageObj a(ResourceRef r12, String r13) {
        boolean r1 = true;
        if (r12 != null) goto L5;
    L16:
        String r5 = r13;
    L17:
        if (r5 != null) goto L19;
    L22:
        if (r1 == false) goto L25;
        return null;
    L25:
        if (r12 == null) goto L27;
        int r6 = r12.getWidth();
    L28:
        if (r12 == null) goto L30;
        int r7 = r12.getHeight();
    L32:
        return new ImageObj(r5, r6, r7, null, null, 24, null);
    L30:
        r7 = 0;
        goto L32
    L27:
        r6 = 0;
        goto L28
    L19:
        if (StringsKt.isBlank(r5) == true) goto L22;
        r1 = false;
        goto L22
    L5:
        if (r12.getKind() != ResourceRefKind.REMOTE_URL) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        ResourceRef r4 = r12;
    L11:
        if (r4 == null) goto L16;
        String r8 = r4.getUri();
        if (r8 == null) goto L16;
        r5 = r8;
        goto L17
    L10:
        r4 = null;
        goto L11
    L7:
        r3 = false;
        goto L8
    }

    public static final boolean b(AttachmentSnapshot r3, AttachmentSnapshot r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "other");
        ResourceRef r5 = r3.effectiveRef();
        ResourceRef r6 = r4.effectiveRef();
        if (r5 == null) goto L28;
        if (r6 == null) goto L28;
        if (r5.getKind() == r6.getKind()) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r5.getRemoteKey(), r6.getRemoteKey()) == true) goto L12;
        return false;
    L12:
        if (r5.getKind() != ResourceRefKind.LOCAL_URI) goto L30;
        String r7 = r5.getUri();
        ResourceRef r1 = dr9.a.c(r7, 0, 0, 14);
        if (r1 == null) goto L20;
        String r2 = dr9.a.a(r1);
        if (r2 == null) goto L20;
        r7 = r2;
    L20:
        String r8 = r6.getUri();
        ResourceRef r0 = dr9.a.c(r8, 0, 0, 14);
        if (r0 == null) goto L31;
        String r9 = dr9.a.a(r0);
        if (r9 == null) goto L31;
        r8 = r9;
    L31:
        return Intrinsics.areEqual(r7, r8);
    L30:
        return Intrinsics.areEqual(r5.getUri(), r6.getUri());
    L28:
        return Intrinsics.areEqual(r5, r6);
    }

    public static AttachmentSnapshot e(UplinkFileEntity r5, int r6) {
        Map r0 = r5.getExtra();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = (String) r0.get("upload_from");
    L7:
        if (Intrinsics.areEqual(r2, "drive") == true) goto L63;
        Map r3 = r5.getExtra();
        if (r3 == null) goto L11;
        String r4 = (String) r3.get("drive_uplink_info");
    L12:
        boolean r7 = false;
        if (r4 != null) goto L15;
    L18:
        boolean r8 = true;
    L19:
        if (r8 == false) goto L63;
        Image r9 = l1.c(r5);
        if (r9 == null) goto L25;
        Map r10 = r9.ext;
        if (r10 == null) goto L25;
        String r11 = (String) r10.get("ext_is_from_drive");
    L27:
        if (Intrinsics.areEqual(r11, "1") == true) goto L63;
        Integer r12 = r5.getEntityType();
        int r13 = UplinkEntityType.EntityTypeFile.getValue();
        if (r12 != null) goto L33;
    L37:
        String r14 = l1.h(r5);
        if (r14 != null) goto L40;
    L43:
        boolean r15 = true;
    L44:
        if (r15 == true) goto L62;
        String r16 = l1.d(r5);
        if (r16 != null) goto L48;
    L51:
        boolean r17 = true;
    L52:
        if (r17 == false) goto L62;
        Uri r18 = r5.getUri();
        if (r18 == null) goto L56;
        r1 = r18.toString();
    L56:
        if (r1 != null) goto L58;
    L59:
        r7 = true;
    L60:
        if (r7 == false) goto L62;
        AttachmentSource r19 = AttachmentSource.MESSAGE_REMOTE;
    L65:
        return d(r5, r6, r19);
    L58:
        if (StringsKt.isBlank(r1) == false) goto L60;
    L48:
        if (StringsKt.isBlank(r16) == true) goto L51;
        r17 = false;
    L62:
        r19 = AttachmentSource.LOCAL_ALBUM;
        goto L65
    L40:
        if (StringsKt.isBlank(r14) == true) goto L43;
        r15 = false;
        goto L44
    L33:
        if (r12.intValue() != r13) goto L37;
        if (n1.e(r5) == true) goto L37;
        r19 = AttachmentSource.FILE;
    L25:
        r11 = null;
        goto L27
    L15:
        if (StringsKt.isBlank(r4) == true) goto L18;
        r8 = false;
        goto L19
    L11:
        r4 = null;
    L63:
        r19 = AttachmentSource.CLOUD_DRIVE;
        goto L65
    L5:
        r2 = null;
        goto L7
    }

    public static final AttachmentSnapshot d(UplinkFileEntity r27, int r28, AttachmentSource r29) {
        Intrinsics.checkNotNullParameter(r27, "<this>");
        Intrinsics.checkNotNullParameter(r29, "source");
        Image r0 = l1.c(r27);
        UplinkEntityContent r3 = r27.getUplinkEntityContent();
        if (r3 == null) goto L5;
        UplinkFileInfo r4 = r3.getUplinkFileInfo();
    L6:
        if (r4 == null) goto L8;
        VideoExtension r5 = r4.getVideo();
    L9:
        String r6 = l1.d(r27);
        if (r6 != null) goto L12;
    L16:
        Uri r7 = r27.getUri();
        if (r7 == null) goto L37;
        r6 = r7.toString();
        if (r6 == null) goto L37;
        ResourceRef r9 = dr9.a.c(r6, 0, 0, 14);
        if (r9 == null) goto L23;
        ResourceRefKind r10 = r9.getKind();
    L25:
        if (r10 == ResourceRefKind.LOCAL_URI) goto L34;
        ResourceRef r11 = dr9.a.c(r6, 0, 0, 14);
        if (r11 == null) goto L29;
        ResourceRefKind r12 = r11.getKind();
    L31:
        if (r12 == ResourceRefKind.REMOTE_URL) goto L34;
        boolean r13 = false;
    L35:
        if (r13 == false) goto L37;
    L39:
        if (n1.d(r27) == false) goto L56;
        if (r0 == null) goto L45;
        ImageObj r14 = r0.previewImage;
        if (r14 == null) goto L45;
        String r15 = r14.url;
        if (r15 == null) goto L45;
    L60:
        String r16 = l1.h(r27);
        if (r0 == null) goto L65;
        ImageObj r17 = r0.imageOri;
        if (r17 == null) goto L65;
        int r18 = r17.width;
    L71:
        if (r0 == null) goto L75;
        ImageObj r19 = r0.imageOri;
        if (r19 == null) goto L75;
        int r110 = r19.height;
    L81:
        if (r6 != null) goto L83;
    L89:
        ResourceRef r111 = dr9.a.b(r15, r16, r18, r110);
    L90:
        ResourceRef r112 = r111;
        if (r112 != null) goto L93;
        r112 = null;
    L98:
        if (r0 == null) goto L101;
        ImageObj r113 = r0.imageThumb;
        if (r113 == null) goto L101;
    L112:
        if (r113 == null) goto L121;
        String r114 = r113.url;
        if (r114 == null) goto L121;
        if ((!StringsKt.isBlank(r114)) == false) goto L118;
        String r115 = r114;
    L119:
        if (r115 == null) goto L121;
        ResourceRef r116 = new ResourceRef(r115, ResourceRefKind.REMOTE_URL, null, r113.width, r113.height, 4, null);
    L122:
        if (r0 == null) goto L124;
        ImageObj r117 = r0.imageOri;
    L125:
        if (r117 == null) goto L128;
        String r118 = r117.url;
        if (r118 == null) goto L128;
    L129:
        if (r117 == null) goto L131;
        int r119 = r117.width;
    L137:
        if (r117 == null) goto L139;
        int r120 = r117.height;
    L145:
        if (r6 != null) goto L147;
    L153:
        ResourceRef r8 = dr9.a.b(r118, r16, r119, r120);
    L154:
        ResourceRef r121 = r8;
        if (r121 != null) goto L157;
        r121 = null;
    L162:
        Integer r20 = r27.getUpLinkStatus();
        UpLinkState r122 = UpLinkState.PROCESSING;
        int r123 = r122.getValue();
        if (r20 != null) goto L166;
    L169:
        int r124 = UpLinkState.SUCCESS.getValue();
        if (r20 != null) goto L173;
    L175:
        AttachmentUploadState r21 = AttachmentUploadState.NOT_UPLOADED;
    L168:
        AttachmentUploadState r125 = r21;
        Integer r22 = r27.getUpLinkStatus();
        int r126 = UpLinkState.FAIL.getValue();
        if (r22 != null) goto L180;
    L183:
        Integer r23 = r27.getUpLinkStatus();
        int r127 = r122.getValue();
        if (r23 != null) goto L187;
    L189:
        Integer r24 = r27.getUpLinkStatus();
        int r128 = UpLinkState.SUCCESS.getValue();
        if (r24 != null) goto L193;
    L195:
        if (r112 != null) goto L199;
        if (r121 != null) goto L199;
        AttachmentSendableState r25 = AttachmentSendableState.NOT_SENDABLE;
    L182:
        AttachmentSendableState r129 = r25;
        String r26 = r27.getFileIdentifier();
        if (r26 != null) goto L203;
    L207:
        Map r30 = r27.getExtra();
        if (r30 == null) goto L214;
        r26 = (String) r30.get("preview_snapshot_stable_id");
        if (r26 == null) goto L214;
        if ((!StringsKt.isBlank(r26)) == false) goto L214;
    L215:
        if (r26 != null) goto L228;
        if (r16 != null) goto L227;
        if (r6 != null) goto L226;
        Uri r31 = r27.getUri();
        if (r31 == null) goto L221;
        r26 = r31.toString();
    L222:
        if (r26 != null) goto L228;
        if (r15 != null) goto L225;
        r26 = "";
        goto L228
    L225:
        r26 = r15;
        goto L228
    L221:
        r26 = null;
        goto L222
    L226:
        r26 = r6;
        goto L228
    L227:
        r26 = r16;
    L228:
        if (r0 == null) goto L230;
        boolean r32 = Intrinsics.areEqual(r0.isMarked(), Boolean.TRUE);
    L231:
        if (r32 == true) goto L254;
        if (r0 == null) goto L236;
        Map r33 = r0.ext;
        if (r33 == null) goto L236;
        String r34 = (String) r33.get("is_marked");
    L238:
        if (Intrinsics.areEqual(r34, "1") == true) goto L254;
        if (r0 == null) goto L242;
        boolean r35 = Intrinsics.areEqual(r0.isCropped(), Boolean.TRUE);
    L243:
        if (r35 == true) goto L253;
        if (r0 == null) goto L248;
        Map r1 = r0.ext;
        if (r1 == null) goto L248;
        String r2 = (String) r1.get("is_cropped");
    L250:
        if (Intrinsics.areEqual(r2, "1") == true) goto L253;
        AttachmentEditType r36 = null;
    L256:
        if (n1.d(r27) == false) goto L259;
        AttachmentMediaType r37 = AttachmentMediaType.IMAGE;
    L262:
        String r38 = l1.a(r27);
        String r130 = l1.f(r27);
        Long r131 = Long.valueOf(l1.b(r27));
        String r210 = l1.g(r27);
        String r211 = l1.e(r27);
        if (r5 == null) goto L267;
        Float r39 = r5.getDuration();
        if (r39 == null) goto L267;
        float r40 = r39.floatValue();
    L268:
        long r41 = (long) (r40 * 1000);
        if (r36 == null) goto L277;
        if (r112 != null) goto L272;
        ResourceRef r42 = r121;
    L273:
        if (r42 == null) goto L275;
        AttachmentEditState r43 = new AttachmentEditState(r42, r26, r36);
    L276:
        AttachmentEditState r212 = r43;
    L278:
        Map r44 = r27.getExtra();
        if (r44 != null) goto L281;
        r44 = MapsKt.emptyMap();
    L281:
        Pair[] r45 = new Pair[2];
        r45[0] = TuplesKt.to("preview_snapshot_stable_id", r27.getFileIdentifier());
        Map r46 = r27.getExtra();
        if (r46 == null) goto L287;
        String r47 = (String) r46.get("preview_attachment_source_media_uri");
        if (r47 == null) goto L287;
        String r48 = r47;
    L302:
        r45[1] = TuplesKt.to("preview_attachment_source_media_uri", r48);
        return new AttachmentSnapshot(r26, r29, r37, r112, r116, r121, r38, r130, r131, r210, r211, r41, r125, r212, r28, r129, MapsKt.plus(r44, MapsKt.mapOf(r45)));
    L287:
        Uri r49 = r27.getUri();
        if (r49 == null) goto L301;
        r48 = r49.toString();
        if (r48 == null) goto L301;
        ResourceRef r50 = dr9.a.c(r48, 0, 0, 14);
        if (r50 == null) goto L294;
        ResourceRefKind r51 = r50.getKind();
    L296:
        if (r51 != ResourceRefKind.LOCAL_URI) goto L298;
        boolean r52 = true;
    L299:
        if (r52 == false) goto L301;
    L298:
        r52 = false;
        goto L299
    L294:
        r51 = null;
    L301:
        r48 = null;
        goto L302
    L275:
        r43 = null;
        goto L276
    L272:
        r42 = r112;
        goto L273
    L277:
        r212 = null;
    L267:
        r40 = 0.0f;
        goto L268
    L259:
        if (n1.e(r27) == false) goto L261;
        r37 = AttachmentMediaType.VIDEO;
        goto L262
    L261:
        r37 = AttachmentMediaType.FILE;
    L248:
        r2 = null;
    L253:
        r36 = AttachmentEditType.CROP;
        goto L256
    L242:
        r35 = false;
    L236:
        r34 = null;
    L254:
        r36 = AttachmentEditType.MARK;
        goto L256
    L230:
        r32 = false;
    L214:
        r26 = null;
        goto L215
    L203:
        if ((!StringsKt.isBlank(r26)) == true) goto L206;
        r26 = null;
    L206:
        if (r26 != null) goto L228;
    L199:
        r25 = AttachmentSendableState.NEEDS_MATERIALIZE;
        goto L182
    L193:
        if (r24.intValue() != r128) goto L195;
        r25 = AttachmentSendableState.SENDABLE;
        goto L182
    L187:
        if (r23.intValue() != r127) goto L189;
        r25 = AttachmentSendableState.NEEDS_MATERIALIZE;
        goto L182
    L180:
        if (r22.intValue() != r126) goto L183;
        r25 = AttachmentSendableState.NOT_SENDABLE;
        goto L182
    L173:
        if (r20.intValue() != r124) goto L175;
        r21 = AttachmentUploadState.UPLOADED;
        goto L168
    L166:
        if (r20.intValue() != r123) goto L169;
        r21 = AttachmentUploadState.UPLOADING;
        goto L168
    L157:
        if (r29 != AttachmentSource.CLOUD_DRIVE) goto L162;
        if (r121.getKind() != ResourceRefKind.REMOTE_KEY) goto L162;
        r121 = ResourceRef.copy$default(r121, null, ResourceRefKind.CLOUD_TOKEN, null, 0, 0, 29, null);
        goto L162
    L147:
        if ((!StringsKt.isBlank(r6)) == false) goto L149;
        String r53 = r6;
    L150:
        if (r53 == null) goto L153;
        r8 = dr9.a.b(r53, r16, r119, r120);
        if (r8 != null) goto L154;
    L149:
        r53 = null;
        goto L150
    L139:
        if (r5 == null) goto L141;
        Integer r132 = r5.getHeight();
    L142:
        if (r132 == null) goto L144;
        r120 = r132.intValue();
        goto L145
    L144:
        r120 = 0;
        goto L145
    L141:
        r132 = null;
        goto L142
    L131:
        if (r5 == null) goto L133;
        Integer r133 = r5.getWidth();
    L134:
        if (r133 == null) goto L136;
        r119 = r133.intValue();
        goto L137
    L136:
        r119 = 0;
        goto L137
    L133:
        r133 = null;
    L128:
        r118 = r15;
        goto L129
    L124:
        r117 = null;
        goto L125
    L118:
        r115 = null;
    L121:
        r116 = null;
    L101:
        if (r5 == null) goto L105;
        Image r134 = r5.getCover();
        if (r134 == null) goto L105;
        r113 = r134.imageThumb;
    L106:
        if (r113 != null) goto L112;
        if (r5 == null) goto L111;
        Image r135 = r5.getCover();
        if (r135 == null) goto L111;
        r113 = r135.previewImage;
    L111:
        r113 = null;
    L105:
        r113 = null;
        goto L106
    L93:
        if (r29 != AttachmentSource.CLOUD_DRIVE) goto L98;
        if (r112.getKind() != ResourceRefKind.REMOTE_KEY) goto L98;
        r112 = ResourceRef.copy$default(r112, null, ResourceRefKind.CLOUD_TOKEN, null, 0, 0, 29, null);
        goto L98
    L83:
        if ((!StringsKt.isBlank(r6)) == false) goto L85;
        String r136 = r6;
    L86:
        if (r136 == null) goto L89;
        r111 = dr9.a.b(r136, r16, r18, r110);
        if (r111 != null) goto L90;
    L85:
        r136 = null;
    L75:
        if (r5 == null) goto L77;
        Integer r137 = r5.getHeight();
    L78:
        if (r137 == null) goto L80;
        r110 = r137.intValue();
        goto L81
    L80:
        r110 = 0;
        goto L81
    L77:
        r137 = null;
    L65:
        if (r5 == null) goto L67;
        Integer r138 = r5.getWidth();
    L68:
        if (r138 == null) goto L70;
        r18 = r138.intValue();
        goto L71
    L70:
        r18 = 0;
        goto L71
    L67:
        r138 = null;
    L45:
        if (r0 == null) goto L49;
        ImageObj r54 = r0.imageOri;
        if (r54 == null) goto L49;
        r15 = r54.url;
    L50:
        if (r15 != null) goto L60;
        if (r0 == null) goto L59;
        ImageObj r55 = r0.imageThumb;
        if (r55 == null) goto L59;
        r15 = r55.url;
    L59:
        r15 = null;
    L49:
        r15 = null;
        goto L50
    L56:
        if (n1.e(r27) == false) goto L59;
        if (r5 == null) goto L59;
        r15 = r5.getDownloadUrl();
        goto L60
    L29:
        r12 = null;
    L34:
        r13 = true;
        goto L35
    L23:
        r10 = null;
    L37:
        r6 = null;
        goto L39
    L12:
        if ((!StringsKt.isBlank(r6)) == true) goto L15;
        r6 = null;
    L15:
        if (r6 != null) goto L39;
    L8:
        r5 = null;
        goto L9
    L5:
        r4 = null;
        goto L6
    }
}
