package com.larus.bmhome.chat;

import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.im.bean.message.block.LocalFileType;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c {
    public static ResourceItemBean a(UplinkFileEntity r38, Mode r39, int r40, int r41, int r42) {
        if ((r42 & 2) == 0) goto L5;
        int r14 = v19.i5.y();
    L7:
        if ((r42 & 4) == 0) goto L9;
        int r15 = v19.i5.f();
    L11:
        if ((r42 & 8) == 0) goto L13;
        int r16 = v19.i5.h();
    L15:
        if ((r42 & 16) == 0) goto L17;
        int r17 = v19.i5.h();
    L18:
        Intrinsics.checkNotNullParameter(r38, "<this>");
        Intrinsics.checkNotNullParameter(r39, "mode");
        Map r4 = r38.getExtra();
        if (r4 == null) goto L21;
        String r5 = (String) r4.get("local_item_attachment");
    L22:
        boolean r6 = Intrinsics.areEqual(r5, "1");
        if (r6 == false) goto L31;
        Map r10 = r38.getExtra();
        if (r10 == null) goto L27;
        String r11 = (String) r10.get("local_item_file_type");
    L29:
        if (Intrinsics.areEqual(r11, String.valueOf(LocalFileType.LocalFileTypeDirectory.getValue())) == false) goto L31;
        boolean r12 = true;
    L32:
        Map r13 = r38.getExtra();
        if (r13 == null) goto L35;
        String r18 = (String) r13.get("originFileTypeString");
    L37:
        if (Intrinsics.areEqual(r18, "bitable") == false) goto L51;
        int r3 = bq9.b.a;
        Map r7 = r38.getExtra();
        if (r7 == null) goto L43;
        String r8 = (String) r7.get("originBaseBizType");
        if (r8 == null) goto L43;
        Integer r9 = StringsKt.toIntOrNull(r8);
    L44:
        Map r19 = r38.getExtra();
        if (r19 == null) goto L47;
        String r110 = (String) r19.get("originUrl");
    L49:
        if (bq9.b.a(r9, r110) == false) goto L51;
        boolean r20 = true;
    L52:
        String r111 = r38.getFileIdentifier();
        if (r111 != null) goto L56;
        r111 = "";
    L56:
        if (r12 == false) goto L60;
        String r112 = yc9.l1.a(r38);
        if (r112 != null) goto L74;
    L59:
        r112 = "";
    L74:
        UplinkEntityContent r113 = r38.getUplinkEntityContent();
        if (r113 == null) goto L84;
        UplinkFileInfo r114 = r113.getUplinkFileInfo();
        if (r114 == null) goto L84;
        String r115 = r114.getFileName();
        if (r115 == null) goto L84;
        String r116 = "";
        String r21 = StringsKt.substringAfterLast$default(r115, '.', null, 2, null);
        if (r21 == null) goto L85;
        String r22 = r21;
    L86:
        String r23 = yc9.l1.f(r38);
        if (r23 != null) goto L89;
        String r117 = r116;
    L90:
        Integer r24 = r38.getUpLinkProcess();
        if (r24 == null) goto L93;
        int r25 = r24.intValue();
    L94:
        Integer r26 = r38.getFileReviewStatus();
        int r118 = FileReviewState.NOT_COMPLIANT.getValue();
        if (r26 != null) goto L98;
    L100:
        Integer r27 = r38.getFileParsedStatus();
        int r119 = FileParseState.FAILED.getValue();
        if (r27 != null) goto L104;
    L106:
        Integer r28 = r38.getUpLinkStatus();
        int r120 = UpLinkState.SUCCESS.getValue();
        if (r28 != null) goto L110;
    L112:
        Integer r29 = r38.getUpLinkStatus();
        int r121 = UpLinkState.FAIL.getValue();
        if (r29 != null) goto L116;
    L118:
        ItemStatus r30 = ItemStatus.UPLINKING;
    L120:
        if (r39 != Mode.EDIT) goto L127;
        if (r30 != ItemStatus.PARSE_FAILED) goto L124;
    L125:
        r30 = ItemStatus.UPLINK_SUCCESS;
        goto L127
    L124:
        if (r30 == ItemStatus.INSPECT_FAILED) goto L125;
    L127:
        if (yc9.l1.c(r38) != null) goto L129;
    L131:
        ItemStatus r1 = r30;
    L132:
        Intrinsics.checkNotNullParameter(r38, "<this>");
        if (yc9.n1.a(r38) == false) goto L137;
        ResourceType r31 = ResourceType.AUDIO;
    L135:
        ResourceType r210 = r31;
        Image r122 = yc9.l1.c(r38);
        Intrinsics.checkNotNullParameter(r38, "<this>");
        UplinkEntityContent r32 = r38.getUplinkEntityContent();
        if (r32 == null) goto L150;
        UplinkFileInfo r33 = r32.getUplinkFileInfo();
        if (r33 == null) goto L150;
        VideoExtension r34 = r33.getVideo();
        if (r34 == null) goto L150;
        Image r211 = r34.getCover();
    L151:
        UplinkEntityContent r35 = r38.getUplinkEntityContent();
        if (r35 == null) goto L160;
        UplinkFileInfo r36 = r35.getUplinkFileInfo();
        if (r36 == null) goto L160;
        VideoExtension r37 = r36.getVideo();
        if (r37 == null) goto L160;
        Float r43 = r37.getDuration();
        if (r43 == null) goto L160;
        float r212 = r43.floatValue();
    L161:
        UplinkEntityContent r44 = r38.getUplinkEntityContent();
        if (r44 == null) goto L170;
        UplinkFileInfo r45 = r44.getUplinkFileInfo();
        if (r45 == null) goto L170;
        VideoExtension r46 = r45.getVideo();
        if (r46 == null) goto L170;
        Integer r47 = r46.getWidth();
        if (r47 == null) goto L170;
        int r310 = r47.intValue();
    L171:
        UplinkEntityContent r48 = r38.getUplinkEntityContent();
        if (r48 == null) goto L180;
        UplinkFileInfo r49 = r48.getUplinkFileInfo();
        if (r49 == null) goto L180;
        VideoExtension r50 = r49.getVideo();
        if (r50 == null) goto L180;
        Integer r51 = r50.getHeight();
        if (r51 == null) goto L180;
        int r311 = r51.intValue();
    L181:
        mt8.b r2 = new mt8.b(r211, r212, r310, r311, null, null, null, null, null, 496);
        HashMap r52 = new HashMap();
        if (r6 == false) goto L196;
        r52.put("local_item_attachment", "1");
        Map r53 = r38.getExtra();
        if (r53 == null) goto L188;
        String r54 = (String) r53.get("local_item_file_type");
        if (r54 == null) goto L188;
        r52.put("local_item_file_type", r54);
    L188:
        String r0 = yc9.l1.d(r38);
        if (r0 == null) goto L196;
        if ((!StringsKt.isBlank(r0)) == true) goto L194;
        r0 = null;
    L194:
        if (r0 == null) goto L196;
        r52.put("local_item_path", r0);
    L196:
        if (r20 == false) goto L199;
        r52.put("ext_is_bitable_app", Boolean.TRUE);
    L199:
        return new ResourceItemBean(r111, r112, r22, r117, r122, r2, r25, r1, false, r210, r14, r15, r16, r17, false, false, false, false, 0, r52, 507904, null);
    L180:
        r311 = 0;
    L170:
        r310 = 0;
    L160:
        r212 = 0.0f;
    L150:
        r211 = null;
        goto L151
    L137:
        if (yc9.n1.d(r38) == false) goto L140;
        r31 = ResourceType.IMAGE;
        goto L135
    L140:
        if (yc9.n1.e(r38) == false) goto L142;
        r31 = ResourceType.VIDEO;
        goto L135
    L142:
        r31 = ResourceType.FILE;
        goto L135
    L129:
        if (r30 != ItemStatus.PARSE_FAILED) goto L131;
        r1 = ItemStatus.UPLINK_SUCCESS;
        goto L132
    L116:
        if (r29.intValue() != r121) goto L118;
        r30 = ItemStatus.UPLINK_FAILED;
        goto L120
    L110:
        if (r28.intValue() != r120) goto L112;
        r30 = ItemStatus.UPLINK_SUCCESS;
        goto L120
    L104:
        if (r27.intValue() != r119) goto L106;
        r30 = ItemStatus.PARSE_FAILED;
        goto L120
    L98:
        if (r26.intValue() != r118) goto L100;
        r30 = ItemStatus.INSPECT_FAILED;
        goto L120
    L93:
        r25 = 0;
        goto L94
    L89:
        r117 = r23;
    L85:
        r22 = r116;
    L84:
        r116 = "";
        goto L85
    L60:
        Intrinsics.checkNotNullParameter(r38, "<this>");
        Map r123 = r38.getExtra();
        if (r123 == null) goto L63;
        String r124 = (String) r123.get("originFileTypeString");
    L65:
        if (yc9.l1.k(r124) == false) goto L69;
        r112 = yc9.l1.a(r38);
        if (r112 != null) goto L74;
    L69:
        String r125 = yc9.l1.a(r38);
        if (r125 == null) goto L59;
        r112 = StringsKt.substringBeforeLast$default(r125, '.', null, 2, null);
        if (r112 != null) goto L74;
    L63:
        r124 = null;
        goto L65
    L47:
        r110 = null;
    L43:
        r9 = null;
    L51:
        r20 = false;
        goto L52
    L35:
        r18 = null;
        goto L37
    L27:
        r11 = null;
    L31:
        r12 = false;
        goto L32
    L21:
        r5 = null;
        goto L22
    L17:
        r17 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L15
    L9:
        r15 = r41;
        goto L11
    L5:
        r14 = r40;
        goto L7
    }
}
