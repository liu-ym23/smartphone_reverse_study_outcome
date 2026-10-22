package com.larus.bmhome.chat.standarduikit.richmedia.viewmodel;

import android.os.Build;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaKind;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.ImagePlaceHolder;
import com.larus.im.bean.message.VideoData;
import com.larus.im.bean.message.VideoPlaceHolder;
import com.larus.im.bean.message.block.GenericImageItem;
import com.larus.im.bean.message.block.GenericVideoItem;
import com.larus.im.bean.message.block.MediaType;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.RichMediaType;
import com.larus.im.bean.message.block.SearchImageItem;
import com.larus.im.bean.message.block.SearchVideoItem;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.service.z2;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String d(ImageObj r3) {
        String r0 = null;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT <= 26) goto L17;
        String r1 = r3.getHeicUrl();
        if (r1 == null) goto L17;
        if (r1.length() <= 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        r0 = r1;
    L15:
        if (r0 == null) goto L17;
        return r0;
    L12:
        r2 = false;
    L17:
        return r3.url;
    }

    public static String e(Image r3) {
        String r0 = null;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT <= 26) goto L18;
        String r1 = r3.b;
        if (r1 == null) goto L20;
        if (r1.length() <= 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        r0 = r1;
    L15:
        if (r0 == null) goto L20;
        return r0;
    L12:
        r2 = false;
    L20:
        return r3.a;
    L18:
        return r3.a;
    }

    public static int h(Long r6) {
        if (r6 != null) goto L5;
        return 0;
    L5:
        if (r6.longValue() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r6 = null;
    L11:
        if (r6 != null) goto L13;
        return 0;
    L13:
        return (int) RangesKt.coerceAtMost(r6.longValue(), 2147483647L);
    L7:
        r1 = false;
        goto L8
    }

    public static List a(List r27, Set r28) {
        Set r1 = r28;
        Intrinsics.checkNotNullParameter(r27, "items");
        Intrinsics.checkNotNullParameter(r1, "holdNoWatermarkImageKeys");
        ArrayList r2 = new ArrayList();
        Iterator r0 = r27.iterator();
        int r4 = 0;
    L4:
        if (r0.hasNext() == false) goto L325;
        Object r5 = r0.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        RichMediaItem r7 = (RichMediaItem) r5;
        Integer r8 = r7.type;
        RichMediaType r9 = RichMediaType.SEARCH_IMAGE;
        int r10 = r9.getValue();
        boolean r11 = true;
        String r13 = "";
        if (r8 != null) goto L12;
    L55:
        RichMediaType r12 = RichMediaType.SEARCH_VIDEO;
        int r14 = r12.getValue();
        if (r8 != null) goto L59;
    L85:
        RichMediaType r15 = RichMediaType.CREATION;
        int r16 = r15.getValue();
        if (r8 != null) goto L89;
    L284:
        Iterator r26 = r0;
        RichMediaType r3 = RichMediaType.GENERIC_IMAGE;
        int r17 = r3.getValue();
        if (r8 != null) goto L288;
    L303:
        RichMediaType r18 = RichMediaType.GENERIC_VIDEO;
        int r19 = r18.getValue();
        if (r8 != null) goto L307;
    L321:
        fn8.c r110 = null;
    L322:
        if (r110 == null) goto L324;
        r2.add(r110);
    L324:
        r1 = r28;
        r4 = r6;
        r0 = r26;
        goto L4
    L307:
        if (r8.intValue() != r19) goto L321;
        GenericVideoItem r20 = r7.videoItem;
        if (r20 == null) goto L321;
        if (r20.type != MediaType.MediaTypeLocalFile.getValue()) goto L313;
    L312:
        r110 = null;
        goto L322
    L313:
        String r21 = r20.coverUrl;
        if (r21 != null) goto L316;
        r21 = "";
    L316:
        String r22 = r20.id;
        if (r22 != null) goto L319;
        String r111 = "generic-video-" + r4 + '-' + r21;
    L320:
        fn8.c r23 = new fn8.c(r111, r18.getValue(), RichMediaKind.VIDEO, r21, c(r20.width, null), c(r20.height, null), "markdown.video_group_cover_thumb", new fn8.b.c(r20));
    L302:
        r110 = r23;
        goto L322
    L319:
        r111 = r22;
        goto L320
    L288:
        if (r8.intValue() != r17) goto L303;
        GenericImageItem r24 = r7.imageItem;
        if (r24 == null) goto L312;
        if (r24.type == MediaType.MediaTypeLocalFile.getValue()) goto L312;
        String r25 = r24.coverUrl;
        if (r25 != null) goto L297;
        r25 = "";
    L297:
        String r29 = r24.id;
        if (r29 != null) goto L300;
        String r112 = "generic-image-" + r4 + '-' + r25;
    L301:
        r23 = new fn8.c(r112, r3.getValue(), RichMediaKind.IMAGE, r25, c(r24.width, null), c(r24.height, null), "markdown.image_group_cover_thumb", new fn8.b.C0108b(r24));
        goto L302
    L300:
        r112 = r29;
        goto L301
    L89:
        if (r8.intValue() != r16) goto L284;
        CreationItem r30 = r7.creation;
        if (r30 != null) goto L92;
    L54:
        r26 = r0;
        goto L312
    L92:
        Integer r31 = r30.type;
        if (r31 != null) goto L96;
    L190:
        if (r31 == null) goto L54;
        if (r31.intValue() != 2) goto L54;
        VideoData r32 = r30.video;
        if (r32 == null) goto L54;
        String r113 = r32.vid;
        String r114 = r32.videoModel;
        String r33 = r32.downloadUrl;
        String r115 = r32.downloadFilehash;
        Double r116 = r32.duration;
        String r117 = r32.videoType;
        r26 = r0;
        Cover r34 = r32.cover;
        if (r34 == null) goto L199;
        ImageObj r35 = r34.imageThumb;
    L200:
        String r118 = d(r35);
        Cover r36 = r32.cover;
        if (r36 == null) goto L205;
        ImageObj r37 = r36.imagePreview;
        if (r37 == null) goto L205;
        String r119 = r37.url;
    L207:
        if (r36 == null) goto L211;
        ImageObj r38 = r36.imagePreview;
        if (r38 == null) goto L211;
        Integer r210 = Integer.valueOf(r38.height);
    L212:
        Cover r39 = r32.cover;
        if (r39 == null) goto L217;
        ImageObj r40 = r39.imagePreview;
        if (r40 == null) goto L217;
        Integer r211 = Integer.valueOf(r40.width);
    L218:
        nr9.g r41 = new nr9.g(r113, r114, r33, r115, r116, r117, new nr9.f(r118, r119, null, r210, r211, null, 36), null, null, null, 896);
        CreationNoWatermarkManager r42 = CreationNoWatermarkManager.a;
        String r43 = r32.vid;
        Cover r44 = r32.cover;
        if (r44 == null) goto L221;
        String r45 = r44.key;
    L222:
        nr9.g r46 = r42.c0(r43, r41, r45);
        if (r46 == null) goto L226;
        r41 = r46;
    L226:
        nr9.f r47 = r41.g;
        if (r47 == null) goto L238;
        String r48 = r47.b;
        if (r48 == null) goto L238;
        if (r48.length() <= 0) goto L233;
        boolean r49 = true;
    L234:
        if (r49 == true) goto L237;
        r48 = null;
    L237:
        if (r48 == null) goto L238;
    L248:
        if (r48 != null) goto L262;
        Cover r50 = r32.cover;
        if (r50 == null) goto L252;
        ImageObj r51 = r50.imagePreview;
    L253:
        r48 = d(r51);
        if (r48 != null) goto L262;
        Cover r52 = r32.cover;
        if (r52 == null) goto L258;
        ImageObj r53 = r52.imageThumb;
    L259:
        r48 = d(r53);
        if (r48 != null) goto L262;
    L263:
        if (r47 == null) goto L265;
        Integer r54 = r47.e;
    L266:
        VideoPlaceHolder r55 = r32.placeholder;
        if (r55 == null) goto L269;
        Long r56 = r55.width;
    L270:
        int r120 = b(c(r54, Integer.valueOf(h(r56))), Integer.valueOf(h(r32.width)));
        if (r47 == null) goto L273;
        Integer r57 = r47.d;
    L274:
        VideoPlaceHolder r58 = r32.placeholder;
        if (r58 == null) goto L277;
        Long r121 = r58.height;
    L278:
        int r212 = b(c(r57, Integer.valueOf(h(r121))), Integer.valueOf(h(r32.height)));
        String r59 = r30.id;
        if (r59 != null) goto L283;
        r59 = r32.vid;
        if (r59 != null) goto L283;
        r59 = "creation-video-" + r4 + '-' + r13;
    L283:
        r110 = new fn8.c(r59, r15.getValue(), RichMediaKind.VIDEO, r13, r120, r212, "chat.video_cover.thumb", new fn8.b.a(r30));
        goto L322
    L277:
        r121 = null;
        goto L278
    L273:
        r57 = null;
        goto L274
    L269:
        r56 = null;
        goto L270
    L265:
        r54 = null;
        goto L266
    L258:
        r53 = null;
        goto L259
    L252:
        r51 = null;
    L262:
        r13 = r48;
        goto L263
    L233:
        r49 = false;
    L238:
        if (r47 == null) goto L247;
        r48 = r47.a;
        if (r48 == null) goto L247;
        if (r48.length() <= 0) goto L244;
        boolean r122 = true;
    L245:
        if (r122 == false) goto L247;
    L244:
        r122 = false;
    L247:
        r48 = null;
        goto L248
    L221:
        r45 = null;
    L217:
        r211 = null;
    L211:
        r210 = null;
    L205:
        r119 = null;
        goto L207
    L199:
        r35 = null;
        goto L200
    L96:
        if (r31.intValue() != 1) goto L190;
        ImageData r60 = r30.image;
        if (r60 == null) goto L54;
        String r123 = r60.imageUri;
        if (r123 != null) goto L102;
        r123 = r60.key;
    L102:
        Integer r124 = r60.status;
        if (r124 != null) goto L106;
    L117:
        boolean r213 = false;
    L118:
        if (r213 == false) goto L120;
        ImageInfo r61 = f(r60, r30.genDetail);
    L127:
        if (r213 == true) goto L147;
        String r125 = e(r61.c);
        if (r125 != null) goto L133;
        r125 = "";
    L133:
        if (r125.length() != 0) goto L135;
        boolean r126 = true;
    L136:
        if (r126 == false) goto L141;
        r125 = e(r61.b);
        if (r125 != null) goto L141;
        r125 = "";
    L141:
        if (r125.length() == 0) goto L144;
        r11 = false;
    L144:
        if (r11 == false) goto L148;
        String r127 = d(r60.imageThumb);
        if (r127 == null) goto L147;
    L149:
        ImagePlaceHolder r128 = r60.placeholder;
        if (r128 == null) goto L152;
        Long r129 = r128.width;
    L153:
        int r130 = h(r129);
        ImageObj r131 = r60.imageOrigin;
        if (r131 == null) goto L156;
        Integer r132 = Integer.valueOf(r131.width);
    L157:
        int r133 = b(r130, r132);
        Image r134 = r61.c;
        if (r134 == null) goto L160;
        Long r135 = Long.valueOf(r134.c);
    L161:
        int r136 = b(r133, Integer.valueOf(h(r135)));
        Image r137 = r61.b;
        if (r137 == null) goto L164;
        Long r138 = Long.valueOf(r137.c);
    L165:
        int r139 = b(r136, Integer.valueOf(h(r138)));
        ImagePlaceHolder r140 = r60.placeholder;
        if (r140 == null) goto L168;
        Long r141 = r140.height;
    L169:
        int r142 = h(r141);
        ImageObj r143 = r60.imageOrigin;
        if (r143 == null) goto L172;
        Integer r144 = Integer.valueOf(r143.height);
    L173:
        int r145 = b(r142, r144);
        Image r146 = r61.c;
        if (r146 == null) goto L176;
        Long r147 = Long.valueOf(r146.d);
    L177:
        int r148 = b(r145, Integer.valueOf(h(r147)));
        Image r62 = r61.b;
        if (r62 == null) goto L180;
        Long r149 = Long.valueOf(r62.d);
    L181:
        int r214 = b(r148, Integer.valueOf(h(r149)));
        String r63 = r30.id;
        if (r63 != null) goto L188;
        r63 = r60.imageUri;
        if (r63 != null) goto L188;
        r63 = r60.key;
        if (r63 != null) goto L188;
        String r150 = "creation-image-" + r4 + '-' + r127;
    L189:
        r110 = new fn8.c(r150, r15.getValue(), RichMediaKind.IMAGE, r127, r139, r214, "creation_block_image_thumb", new fn8.b.a(r30), r213);
        r26 = r0;
    L188:
        r150 = r63;
        goto L189
    L180:
        r149 = null;
        goto L181
    L176:
        r147 = null;
        goto L177
    L172:
        r144 = null;
        goto L173
    L168:
        r141 = null;
        goto L169
    L164:
        r138 = null;
        goto L165
    L160:
        r135 = null;
        goto L161
    L156:
        r132 = null;
        goto L157
    L152:
        r129 = null;
        goto L153
    L148:
        r127 = r125;
        goto L149
    L135:
        r126 = false;
    L147:
        r127 = "";
        goto L149
    L120:
        r61 = f(r60, r30.genDetail);
        CreationNoWatermarkManager r151 = CreationNoWatermarkManager.a;
        String r152 = r60.imageUri;
        if (r152 != null) goto L123;
        r152 = r60.key;
    L123:
        ImageInfo r153 = (ImageInfo) r151.U(r152, r61, true).a;
        if (r153 == null) goto L127;
        r61 = r153;
        goto L127
    L106:
        if (r124.intValue() != 2) goto L117;
        if (r123 != null) goto L109;
    L112:
        boolean r64 = true;
    L113:
        if (r64 == true) goto L117;
        if (r1.contains(r123) == false) goto L117;
        r213 = true;
        goto L118
    L109:
        if (StringsKt.isBlank(r123) == true) goto L112;
        r64 = false;
        goto L113
    L59:
        if (r8.intValue() != r14) goto L85;
        SearchVideoItem r65 = r7.video;
        if (r65 == null) goto L54;
        String r66 = r65.albumImage;
        if (r66 != null) goto L65;
    L73:
        r66 = r65.getFirstFrameImage();
    L74:
        Pair r67 = r65.getFirstFrameSize();
        long r154 = ((Number) r67.component1()).longValue();
        long r155 = ((Number) r67.component2()).longValue();
        String r156 = r65.itemId;
        if (r156 != null) goto L83;
        Long r157 = r65.id;
        if (r157 == null) goto L79;
        String r158 = r157.toString();
    L80:
        if (r158 != null) goto L82;
        String r68 = "search-video-" + r4 + '-' + r66;
    L84:
        r26 = r0;
        r110 = new fn8.c(r68, r12.getValue(), RichMediaKind.VIDEO, r66, c(r65.albumImageWidth, Integer.valueOf(h(Long.valueOf(r154)))), c(r65.albumImageHeight, Integer.valueOf(h(Long.valueOf(r155)))), "markdown.video_group_cover_thumb", new fn8.b.e(r65));
        goto L322
    L82:
        r68 = r158;
        goto L84
    L79:
        r158 = null;
        goto L80
    L83:
        r68 = r156;
        goto L84
    L65:
        if (r66.length() > 0) goto L68;
        r11 = false;
    L68:
        if (r11 == true) goto L71;
        r66 = null;
    L71:
        if (r66 == null) goto L73;
    L12:
        if (r8.intValue() != r10) goto L55;
        SearchImageItem r69 = r7.image;
        if (r69 == null) goto L54;
        String r70 = r69.originThumbUrl;
        if (r70 != null) goto L18;
    L26:
        r70 = r69.thumbUrl;
        if (r70 != null) goto L29;
    L34:
        r70 = null;
    L35:
        if (r70 != null) goto L42;
        List r71 = r69.fullSizeUrl;
        if (r71 == null) goto L39;
        r70 = (String) CollectionsKt.firstOrNull(r71);
    L40:
        if (r70 != null) goto L42;
    L43:
        String r72 = r69.itemId;
        if (r72 != null) goto L52;
        Long r73 = r69.id;
        if (r73 == null) goto L48;
        String r159 = r73.toString();
    L49:
        if (r159 != null) goto L51;
        r72 = "search-image-" + r4 + '-' + r13;
        goto L52
    L51:
        String r160 = r159;
    L53:
        r26 = r0;
        r110 = new fn8.c(r160, r9.getValue(), RichMediaKind.IMAGE, r13, c(r69.originWidth, r69.width), c(r69.originHeight, r69.height), "markdown.image_group_cover_thumb", new fn8.b.d(r69));
        goto L322
    L48:
        r159 = null;
    L52:
        r160 = r72;
        goto L53
    L39:
        r70 = null;
    L42:
        r13 = r70;
        goto L43
    L29:
        if (r70.length() > 0) goto L32;
        r11 = false;
    L32:
        if (r11 == false) goto L34;
    L18:
        if (r70.length() <= 0) goto L20;
        boolean r74 = true;
    L21:
        if (r74 == true) goto L24;
        r70 = null;
    L24:
        if (r70 == null) goto L26;
    L20:
        r74 = false;
        goto L21
    L325:
        return r2;
    }

    public static int b(int r4, Integer r5) {
        Integer r6 = Integer.valueOf(r4);
        boolean r1 = true;
        if (r6.intValue() <= 0) goto L5;
        boolean r0 = true;
    L6:
        Integer r3 = null;
        if (r0 == true) goto L10;
        r6 = null;
    L10:
        if (r6 != null) goto L24;
        if (r5 != null) goto L14;
    L21:
        if (r3 != null) goto L23;
        return 0;
    L23:
        return r3.intValue();
    L14:
        if (r5.intValue() > 0) goto L17;
        r1 = false;
    L17:
        if (r1 == true) goto L20;
        r5 = null;
    L20:
        r3 = r5;
        goto L21
    L24:
        return r6.intValue();
    L5:
        r0 = false;
        goto L6
    }

    public static int c(Integer r4, Integer r5) {
        boolean r0 = true;
        Integer r2 = null;
        if (r4 != null) goto L5;
    L13:
        if (r5 != null) goto L15;
    L22:
        if (r2 != null) goto L24;
        return 0;
    L24:
        return r2.intValue();
    L15:
        if (r5.intValue() > 0) goto L18;
        r0 = false;
    L18:
        if (r0 == true) goto L21;
        r5 = null;
    L21:
        r2 = r5;
        goto L22
    L5:
        if (r4.intValue() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L11;
        r4 = null;
    L11:
        if (r4 == null) goto L13;
        return r4.intValue();
    L7:
        r3 = false;
        goto L8
    }

    public static ImageInfo f(ImageData r14, CreationGenDetail r15) {
        String r0 = r14.imageUri;
        if (r0 != null) goto L5;
        r0 = r14.key;
    L5:
        ImageObj r1 = r14.imageOrigin;
        Image r2 = null;
        if (r1 == null) goto L8;
        Image r4 = g(r1, r0);
    L9:
        ImageObj r3 = r14.imageThumb;
        if (r3 == null) goto L12;
        Image r5 = g(r3, r0);
    L14:
        if (z2.a.enableBlockImagePreviewResize() == false) goto L21;
        ImageObj r6 = r14.imagePreviewResize;
        if (r6 == null) goto L18;
        Image r7 = g(r6, r0);
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
        Image r12 = g(r17, null);
    L34:
        ImageObj r18 = r14.imageOriRaw;
        if (r18 == null) goto L37;
        Image r13 = g(r18, r0);
    L38:
        ImageObj r19 = r14.imageThumbRaw;
        if (r19 == null) goto L42;
        r2 = g(r19, r0);
    L42:
        return new ImageInfo(r4, r5, r8, r12, r9, r10, r11, r13, r2, 128);
    L37:
        r13 = null;
    L33:
        r12 = null;
        goto L34
    L18:
        ImageObj r20 = r14.imagePreview;
        if (r20 == null) goto L25;
        r7 = g(r20, r0);
    L25:
        r8 = null;
        goto L26
    L21:
        ImageObj r21 = r14.imagePreview;
        if (r21 == null) goto L25;
        r7 = g(r21, r0);
        goto L24
    L12:
        r5 = null;
        goto L14
    L8:
        r4 = null;
        goto L9
    }

    public static Image g(ImageObj r9, String r10) {
        return new Image(r9.url, r9.getHeicUrl(), r9.width, r9.height, r10);
    }
}
