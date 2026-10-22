package com.larus.chat.gallery.impl.preview.datasource;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverItem;
import com.larus.bmhome.chat.search.ArticleInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationAsset;
import com.larus.bmhome.creative.messagecard.bean.CreationInfo;
import com.larus.bmhome.creative.messagecard.bean.CreationMsgContentData;
import com.larus.bmhome.creative.messagecard.bean.CreationTask;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.gallery.api.GalleryType;
import com.larus.im.bean.message.Cover;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationGenDetail;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageData;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.ImagePlaceHolder;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.RichMediaMeta;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoData;
import com.larus.im.bean.message.VideoExtension;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.GenImageBlock;
import com.larus.im.bean.message.block.GenericImageItem;
import com.larus.im.bean.message.block.GenericVideoItem;
import com.larus.im.bean.message.block.MediaType;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.RichMediaLayoutBlock;
import com.larus.im.bean.message.block.RichMediaType;
import com.larus.im.bean.message.block.SearchImageItem;
import com.larus.platform.api.ImageInfo;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.api.creation.UserCreationImage;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import tx9.c2;
import v19.m5;
import yc9.l1;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class v {
    public static final v a = null;
    public static final Gson b = null;

    public static final class a {
        public final List<SearchImageInfo> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<SearchImageInfo> r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "ImageGroupWrapper(images=" + this.a + ')';
        }

        public a() {
            this.a = null;
        }
    }

    public static final class b {
        public final List<SearchImageInfo> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<SearchImageInfo> r0 = this.a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "SearchImageBlockWrapper(images=" + this.a + ')';
        }

        public b() {
            this.a = null;
        }
    }

    public v() {
    }

    static {
        a = new v();
        b = new Gson();
    }

    public static Integer e(Integer r3) {
        if (r3 != null) goto L6;
    L8:
        if (r3 != null) goto L11;
    L13:
        if (r3 == null) goto L19;
        if (r3.intValue() != 6) goto L19;
        return 6;
    L19:
        if (r3 != null) goto L22;
    L24:
        if (r3 != null) goto L27;
    L29:
        return null;
    L27:
        if (r3.intValue() != 1) goto L29;
        return 2;
    L22:
        if (r3.intValue() != 2) goto L24;
        return 5;
    L11:
        if (r3.intValue() != 7) goto L13;
        return 4;
    L6:
        if (r3.intValue() != 5) goto L8;
        return 3;
    }

    public static List g(String r18) {
        if (r18 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L10;
        a r1 = (a) b.fromJson(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r18, "&quot;", "\"", false, 4, null), "&#34;", "\"", false, 4, null), "&amp;", "&", false, 4, null), "&#39;", "'", false, 4, null), a.class);     // Catch: Throwable -> L17
        if (r1 == null) goto L15;
        List<SearchImageInfo> r2 = r1.a;     // Catch: Throwable -> L17
        if (r2 == null) goto L15;
        return r2;
    L15:
        return CollectionsKt.emptyList();
    L17:
        th = move-exception;
        FLogger.a.e("PreviewMessageTransformer", "parseImageGroupJson error: " + th.getMessage());
        return CollectionsKt.emptyList();
    L10:
        return CollectionsKt.emptyList();
    L4:
        if (r18.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static Integer h(Integer r1) {
        if (r1 != null) goto L4;
    L9:
        return null;
    L4:
        if (r1.intValue() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return r1;
    L6:
        r0 = false;
        goto L7
    }

    public static Boolean i(Image r5) {
        Boolean r0 = r5.aiCreationImage;
        if (r0 != null) goto L5;
        ImageObj r1 = r5.previewImage;
        if (r1 == null) goto L9;
        String r2 = r1.url;
    L10:
        boolean r3 = true;
        if (r2 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == true) goto L38;
        ImageObj r6 = r5.imageThumb;
        if (r6 == null) goto L20;
        String r7 = r6.url;
    L21:
        if (r7 != null) goto L23;
    L25:
        boolean r8 = false;
    L26:
        if (r8 == true) goto L38;
        ImageObj r9 = r5.imageOri;
        if (r9 == null) goto L30;
        String r10 = r9.url;
    L31:
        if (r10 != null) goto L33;
    L35:
        r3 = false;
    L36:
        if (r3 == true) goto L38;
        return null;
    L33:
        if (StringsKt.contains(r10, "watermark", true) != true) goto L35;
    L30:
        r10 = null;
        goto L31
    L23:
        if (StringsKt.contains(r7, "watermark", true) != true) goto L25;
        r8 = true;
        goto L26
    L20:
        r7 = null;
    L38:
        return Boolean.TRUE;
    L13:
        if (StringsKt.contains(r2, "watermark", true) != true) goto L15;
        r4 = true;
        goto L16
    L9:
        r2 = null;
        goto L10
    L5:
        return Boolean.valueOf(r0.booleanValue());
    }

    public static String j(ImageObj r5) {
        boolean r1 = false;
        if (Build.VERSION.SDK_INT <= 26) goto L16;
        if (r5 == null) goto L16;
        String r0 = r5.getHeicUrl();
        if (r0 == null) goto L16;
        if (r0.length() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L14;
        r0 = null;
    L14:
        if (r0 == null) goto L16;
        return r0;
    L10:
        r2 = false;
    L16:
        if (r5 == null) goto L25;
        String r6 = r5.url;
        if (r6 != null) goto L20;
        return null;
    L20:
        if (r6.length() <= 0) goto L22;
        r1 = true;
    L22:
        if (r1 == true) goto L24;
        return null;
    L24:
        return r6;
    L25:
        return null;
    }

    public static String l(Message r6) {
        Map r0 = r6.getExt();
        boolean r1 = false;
        if (r0 == null) goto L16;
        String r2 = (String) r0.get("req_id");
        if (r2 == null) goto L16;
        if (r2.length() <= 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L16;
        return r2;
    L9:
        r5 = false;
    L16:
        String r7 = (String) com.larus.im.bean.message.a.U(r6).get("req_id");
        if (r7 != null) goto L19;
        return null;
    L19:
        if (r7.length() <= 0) goto L21;
        r1 = true;
    L21:
        if (r1 == true) goto L23;
        return null;
    L23:
        return r7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v41, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v44, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v53 */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r0v62 */
    /* JADX WARN: Type inference failed for: r0v63 */
    /* JADX WARN: Type inference failed for: r0v64 */
    /* JADX WARN: Type inference failed for: r15v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r1v73 */
    /* JADX WARN: Type inference failed for: r1v81 */
    /* JADX WARN: Type inference failed for: r26v0, types: [java.util.ArrayList] */
    public static List n(Message r80) {
        Message r4 = r80;
        Intrinsics.checkNotNullParameter(r4, "message");
        String r0 = r80.getMessageId();
        if (r0 != null) goto L5;
        String r3 = "";
    L6:
        FLogger r1 = FLogger.a;
        String r2 = "transform: messageId=";
        String r8 = "PreviewMessageTransformer";
        r1.d("PreviewMessageTransformer", "transform: messageId=" + r3 + ", contentType=" + r80.getContentType() + ", isNestedFileType=" + lr8.c.a(r80) + ", createTime=" + r80.getCreateTime());
        int r5 = 26;
        char r14 = '_';
        boolean r11 = true;
        if (lr8.c.a(r80) == false) goto L162;
        ArrayList r6 = new ArrayList();
        NestedFileContent r7 = com.larus.bmhome.chat.bean.d.f(r80);
        Gson r9 = b;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L15
        Map r12 = r80.getExt();     // Catch: Throwable -> L15
        if (r12 == null) goto L12;
        String r13 = (String) r12.get("white_tee_index_list");     // Catch: Throwable -> L15
    L13:
        Object r15 = Result.constructor-impl((ArrayList) r9.fromJson(r13, new x().getType()));     // Catch: Throwable -> L15
    L18:
        if (Result.exceptionOrNull-impl(r15) == null) goto L21;
        r15 = new ArrayList();
    L21:
        ArrayList r16 = (ArrayList) r15;
        if (r16 != null) goto L24;
        r16 = new ArrayList();
    L24:
        List r17 = r7.getEntities();
        if (r17 == null) goto L161;
        Iterator r24 = r17.iterator();
        int r18 = 0;
    L28:
        if (r24.hasNext() == false) goto L161;
        Object r19 = r24.next();
        int r25 = r18 + 1;
        if (r18 >= 0) goto L32;
        CollectionsKt.throwIndexOverflow();
    L32:
        UplinkFileEntity r110 = (UplinkFileEntity) r19;
        if (n1.d(r110) == false) goto L117;
        Integer r20 = r110.getFileReviewStatus();
        int r111 = FileReviewState.NOT_COMPLIANT.getValue();
        if (r20 == null) goto L40;
        if (r20.intValue() == r111) goto L117;
    L40:
        if (r16.contains(Integer.valueOf(r18)) == true) goto L117;
        Image r21 = l1.c(r110);
        a.getClass();
        if (z2.a.getCreationPreviewPerformanceOptConfig().d == true) goto L44;
    L46:
        boolean r112 = false;
    L47:
        if (r112 == false) goto L53;
        if (r21 == null) goto L50;
        boolean r22 = Intrinsics.areEqual(i(r21), Boolean.TRUE);
    L51:
        if (r22 == false) goto L53;
        boolean r23 = true;
    L54:
        String r113 = r110.getFileIdentifier();
        if (r113 != null) goto L57;
        r113 = "";
    L57:
        String r114 = com.larus.bmhome.chat.sendimage.e.h(r4, r113);
        if (m5.c(r114) == true) goto L60;
        String r115 = null;
    L64:
        if (r115 != null) goto L76;
        if (r21 == null) goto L67;
        ImageObj r116 = r21.previewImage;
    L68:
        String r117 = k(r116, r23);
        if (r117 != null) goto L75;
        if (r21 == null) goto L74;
        ImageObj r118 = r21.imageOri;
        if (r118 == null) goto L74;
        r117 = r118.url;
    L74:
        String r27 = null;
    L77:
        if (r27 != null) goto L79;
    L82:
        boolean r119 = true;
    L83:
        if (r119 == true) goto L116;
        SourceType r37 = SourceType.USER_SEND;
        String r38 = "msg_" + r3 + r14 + r18;
        if (r115 != null) goto L90;
        if (r21 == null) goto L88;
        ImageObj r26 = r21.imageThumb;
    L89:
        r115 = k(r26, r23);
        goto L90
    L88:
        r26 = null;
    L90:
        String r28 = r115;
        if (r21 == null) goto L95;
        ImageObj r29 = r21.imageOri;
        if (r29 == null) goto L95;
        String r210 = r29.url;
    L96:
        if (r21 == null) goto L100;
        ImageObj r30 = r21.imageOriRaw;
        if (r30 == null) goto L100;
        String r31 = r30.url;
    L101:
        if (r21 == null) goto L103;
        Boolean r32 = i(r21);
    L105:
        if (r21 == null) goto L109;
        ImageObj r33 = r21.imageOri;
        if (r33 == null) goto L109;
        int r34 = r33.width;
    L110:
        if (r21 == null) goto L114;
        ImageObj r35 = r21.imageOri;
        if (r35 == null) goto L114;
        int r36 = r35.height;
    L115:
        String r43 = r8;
        String r45 = r2;
        String r46 = r3;
        xy8.d r120 = new xy8.d(r37, r38, new xy8.b(r27, r28, r210, r31, r32, false, null, r34, r36, 224), null, GalleryType.Image, d(r4, r11), null, r80.getCreateTime(), null, null, null, b(r4, r110), null, null, r80, null, r6.size() + 1, 46920);
        ArrayList r39 = r6;
        r39.add(r120);
    L159:
        r6 = r39;
        String r50 = r46;
    L160:
        r4 = r80;
        r18 = r25;
        r8 = r43;
        r2 = r45;
        r3 = r50;
        r5 = 26;
        r11 = true;
        r14 = '_';
    L114:
        r36 = 0;
    L109:
        r34 = 0;
        goto L110
    L103:
        r32 = null;
    L100:
        r31 = null;
    L95:
        r210 = null;
        goto L96
    L116:
        r45 = r2;
        r43 = r8;
        r50 = r3;
        goto L160
    L79:
        if (r27.length() == 0) goto L82;
        r119 = false;
    L75:
        r27 = r117;
        goto L77
    L67:
        r116 = null;
        goto L68
    L76:
        r27 = r115;
        goto L77
    L60:
        if (r114 != null) goto L62;
        r114 = "";
    L62:
        r115 = Uri.fromFile(new PolarisFileWrapper(r114)).toString();
        goto L64
    L50:
        r22 = false;
    L53:
        r23 = false;
        goto L54
    L44:
        if (Build.VERSION.SDK_INT <= r5) goto L46;
        r112 = true;
    L117:
        r39 = r6;
        r45 = r2;
        r46 = r3;
        r43 = r8;
        if (n1.e(r110) == false) goto L159;
        Integer r40 = r110.getFileReviewStatus();
        int r41 = FileReviewState.NOT_COMPLIANT.getValue();
        if (r40 != null) goto L123;
    L124:
        UplinkEntityContent r42 = r110.getUplinkEntityContent();
        if (r42 == null) goto L129;
        UplinkFileInfo r44 = r42.getUplinkFileInfo();
        if (r44 == null) goto L129;
        VideoExtension r121 = r44.getVideo();
    L130:
        nr9.g r47 = os8.a.a(r110);
        String r48 = r47.a;
        if (r48 != null) goto L135;
        r48 = r110.getFileIdentifier();
        if (r48 != null) goto L135;
        r48 = UUID.randomUUID().toString();
    L135:
        String r211 = r48;
        SourceType r49 = SourceType.USER_SEND;
        String r122 = "msg_" + r46 + '_' + r18;
        v r51 = a;
        nr9.f r52 = r47.g;
        if (r52 == null) goto L138;
        String r212 = r52.b;
    L139:
        if (r121 == null) goto L143;
        Integer r53 = r121.getWidth();
        if (r53 == null) goto L143;
        int r213 = r53.intValue();
    L144:
        if (r121 == null) goto L148;
        Integer r54 = r121.getHeight();
        if (r54 == null) goto L148;
        int r310 = r54.intValue();
    L149:
        if (r121 == null) goto L153;
        Float r55 = r121.getDuration();
        if (r55 == null) goto L153;
        double r311 = r55.floatValue();
    L154:
        String r56 = r110.getFileIdentifier();
        if (r56 != null) goto L157;
        String r312 = "";
    L158:
        r51.getClass();
        r50 = r46;
        xy8.d r57 = new xy8.d(r49, r122, null, m(r47, r211, r212, r213, r310, r311, r312), GalleryType.Video, d(r80, false), null, r80.getCreateTime(), null, null, null, b(r80, r110), null, null, r80, null, r39.size() + 1, 46916);
        r6 = r39;
        r6.add(r57);
        goto L160
    L157:
        r312 = r56;
    L153:
        r311 = 0.0d;
    L148:
        r310 = 0;
    L143:
        r213 = 0;
        goto L144
    L138:
        r212 = null;
    L129:
        r121 = null;
        goto L130
    L123:
        if (r40.intValue() == r41) goto L159;
    L161:
        String r410 = r2;
        String r58 = r3;
        ?? r59 = r6;
        String r60 = r8;
        String r61 = r58;
    L598:
        FLogger r62 = FLogger.a;
        StringBuilder r63 = new StringBuilder(r410);
        r63.append(r61);
        r63.append(", resultSize=");
        r63.append(r59.size());
        r63.append(", types=");
        Iterable r64 = (Iterable) r59;
        ArrayList r65 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r64, 10));
        Iterator r66 = r64.iterator();
    L600:
        if (r66.hasNext() == false) goto L602;
        xy8.d r67 = (xy8.d) r66.next();
        StringBuilder r68 = new StringBuilder();
        r68.append(r67.a);
        r68.append('/');
        r68.append(r67.e);
        r65.add(r68.toString());
        goto L600
    L602:
        r63.append(r65);
        r62.d(r60, r63.toString());
        return r59;
    L12:
        r13 = null;
    L15:
        th = move-exception;
        Result.Companion r69 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L162:
        r410 = "transform: messageId=";
        String r510 = r3;
        if (r80.getContentType() != 6) goto L330;
        List r70 = com.larus.bmhome.chat.bean.d.g(r80).imageList;
        List r71 = r70;
        if (r71 != null) goto L167;
    L170:
        boolean r123 = true;
    L171:
        if (r123 == false) goto L174;
        String r124 = r510;
        String r125 = "PreviewMessageTransformer";
        r1.d(r125, "transformImage: imageList is empty, messageId=".concat(r124));
        ?? r72 = CollectionsKt.emptyList();
    L328:
        ?? r73 = r72;
        r60 = r125;
        String r78 = r124;
    L590:
        r59 = r73;
        r61 = r78;
        goto L598
    L174:
        r125 = "PreviewMessageTransformer";
        r124 = r510;
        r72 = new ArrayList();
        if (r80.getUserType() != 2) goto L177;
        boolean r214 = true;
    L178:
        Map r74 = r80.getBusinessExt();
        if (r74 == null) goto L181;
        String r126 = (String) r74.get("send_image_local_path");
    L182:
        Iterator r215 = r70.iterator();
        int r75 = 0;
    L184:
        if (r215.hasNext() == false) goto L328;
        Object r76 = r215.next();
        int r216 = r75 + 1;
        if (r75 >= 0) goto L188;
        CollectionsKt.throwIndexOverflow();
    L188:
        Image r77 = (Image) r76;
        if (r214 == false) goto L191;
        CreationNoWatermarkManager.d r79 = CreationNoWatermarkManager.a.S(r77, new String[0]);
    L192:
        Image r81 = (Image) r79.a;
        if (r81 != null) goto L195;
        r81 = r77;
    L195:
        if (r214 == false) goto L197;
        UplinkFileInfo r127 = null;
        Message r128 = r80;
        UserCreationFromIM r82 = IUgcAIGCService.a.I(r128, null, String.valueOf(r75));
    L198:
        a.getClass();
        if (z2.a.getCreationPreviewPerformanceOptConfig().d == false) goto L204;
        if (Build.VERSION.SDK_INT <= 26) goto L204;
        boolean r83 = true;
    L205:
        if (r83 == true) goto L207;
    L209:
        boolean r84 = false;
    L210:
        if (r75 == 0) goto L212;
    L216:
        UplinkFileInfo r85 = r127;
    L217:
        UplinkFileInfo r86 = k(r81.previewImage, r84);
        if (r86 != null) goto L234;
        if (r85 != null) goto L233;
        r86 = k(r81.imageThumb, r84);
        if (r86 != null) goto L234;
        ImageObj r87 = r81.imageOri;
        if (r87 == null) goto L232;
        r86 = r87.url;
        if (r86 == null) goto L232;
        if (r86.length() <= 0) goto L229;
        boolean r129 = true;
    L230:
        if (r129 == false) goto L232;
    L229:
        r129 = false;
    L232:
        UplinkFileInfo r217 = r127;
    L235:
        if (r217 != null) goto L237;
    L240:
        boolean r88 = true;
    L241:
        if (r88 == true) goto L327;
        if (r214 == false) goto L244;
        SourceType r89 = SourceType.CREATION_CARD;
    L245:
        SourceType r130 = r89;
        String r411 = "img_" + r124 + '_' + r75;
        if (r85 != null) goto L250;
        r85 = k(r81.imageThumb, r84);
        if (r85 != null) goto L250;
        UplinkFileInfo r218 = r217;
    L251:
        ImageObj r90 = r77.imageOri;
        if (r90 == null) goto L254;
        UplinkFileInfo r219 = r90.url;
    L255:
        ImageObj r91 = r77.imageOriRaw;
        if (r91 == null) goto L258;
        UplinkFileInfo r220 = r91.url;
    L259:
        if (r214 == false) goto L261;
        Boolean r92 = Boolean.TRUE;
    L262:
        Boolean r221 = r92;
        boolean r93 = r79.b;
        if (r214 == false) goto L265;
        UplinkFileInfo r313 = r77.key;
    L266:
        ImageObj r94 = r81.imageOri;
        if (r94 == null) goto L269;
        int r314 = r94.width;
    L270:
        if (r94 == null) goto L272;
        int r315 = r94.height;
    L273:
        xy8.b r412 = new xy8.b(r217, r218, r219, r220, r221, r93, r313, r314, r315, 64);
        GalleryType r413 = GalleryType.Image;
        Map r414 = d(r128, true);
        long r415 = r80.getCreateTime();
        LinkedHashMap r95 = new LinkedHashMap();
        ImageObj r96 = r77.previewImage;
        if (r96 == null) goto L283;
        UplinkFileInfo r97 = r96.url;
        if (r97 == null) goto L283;
        if ((!StringsKt.isBlank(r97)) == true) goto L281;
        r97 = r127;
    L281:
        if (r97 == null) goto L283;
        String r98 = (String) r95.put("share_preview_url", r97);
    L283:
        ImageObj r99 = r77.imageOri;
        if (r99 == null) goto L293;
        UplinkFileInfo r100 = r99.url;
        if (r100 == null) goto L293;
        if ((!StringsKt.isBlank(r100)) == true) goto L291;
        r100 = r127;
    L291:
        if (r100 == null) goto L293;
        String r101 = (String) r95.put("share_download_url", r100);
    L293:
        ImageObj r102 = r77.imageOriRaw;
        if (r102 == null) goto L303;
        UplinkFileInfo r103 = r102.url;
        if (r103 == null) goto L303;
        if ((!StringsKt.isBlank(r103)) == true) goto L301;
        r103 = r127;
    L301:
        if (r103 == null) goto L303;
        r95.put("share_raw_url", r103);
    L303:
        String r104 = r77.key;
        if (r104 != null) goto L306;
    L309:
        boolean r105 = true;
    L310:
        boolean r106 = !r105;
        String r107 = UUID.randomUUID().toString();
        String r108 = r80.getMessageId();
        int r131 = r80.getContentType();
        if (r106 == false) goto L313;
        UplinkFileInfo r109 = Integer.valueOf(UpLinkState.SUCCESS.getValue());
    L314:
        String r132 = r77.localResPath;
        int r133 = UplinkEntityType.EntityTypeImage.getValue();
        int r222 = UpLinkState.SUCCESS.getValue();
        int r511 = FileParseState.SUCCESS.getValue();
        int r512 = FileReviewState.ACCESS.getValue();
        UplinkFileInfo r223 = r109;
        xy8.f r610 = new xy8.f(r108, r131, r223, r132, r107, CollectionsKt.listOf(new UplinkFileEntity(Integer.valueOf(r133), new UplinkEntityContent(r127, Image.copy$default(r77, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null), 1, r127), r107, null, Integer.valueOf(r512), Integer.valueOf(r511), 100, Integer.valueOf(r222), null, false, null, null, null, null, 16136, null)));
        if (r82 == null) goto L324;
        String r134 = r82.getCreationId();
        Integer r135 = r82.getCreationType();
        String r136 = String.valueOf(r75);
        String r137 = r82.getMaterialId();
        Integer r138 = r82.getCreationType();
        String r139 = r82.getPrompt();
        String r140 = r82.getRefContent();
        Integer r141 = r82.getPrivateStatus();
        if (r141 != null) goto L320;
    L322:
        boolean r224 = false;
    L323:
        UplinkFileInfo r225 = new xy8.e(r134, r135, r124, r140, null, r136, r137, r138, r139, r224, 16);
    L325:
        r72.add(new xy8.d(r130, r411, r412, null, r413, r414, null, r415, null, r95, null, r610, r225, null, r80, null, r72.size() + 1, 42312));
        goto L327
    L320:
        if (r141.intValue() != 1) goto L322;
        r224 = true;
        goto L323
    L324:
        r225 = r127;
        goto L325
    L313:
        r109 = r127;
        goto L314
    L306:
        if (r104.length() == 0) goto L309;
        r105 = false;
        goto L310
    L272:
        r315 = 0;
        goto L273
    L269:
        r314 = 0;
        goto L270
    L265:
        r313 = r127;
        goto L266
    L261:
        r92 = i(r81);
        goto L262
    L258:
        r220 = r127;
        goto L259
    L254:
        r219 = r127;
    L250:
        r218 = r85;
        goto L251
    L244:
        r89 = SourceType.USER_SEND;
    L327:
        r75 = r216;
        r126 = r126;
        r125 = r125;
        r124 = r124;
        goto L184
    L237:
        if (r217.length() == 0) goto L240;
        r88 = false;
        goto L241
    L233:
        r217 = r85;
    L234:
        r217 = r86;
        goto L235
    L212:
        if (o0.d(r126) == false) goto L216;
        if (new PolarisFileWrapper(r126).exists() == false) goto L216;
        r85 = Uri.fromFile(new PolarisFileWrapper(r126)).toString();
        goto L217
    L207:
        if (Intrinsics.areEqual(i(r81), Boolean.TRUE) == false) goto L209;
        r84 = true;
    L204:
        r83 = false;
        goto L205
    L197:
        r127 = null;
        r128 = r80;
        r82 = null;
        goto L198
    L191:
        r79 = new CreationNoWatermarkManager.d(r77, false);
        goto L192
    L181:
        r126 = null;
        goto L182
    L177:
        r214 = false;
        goto L178
    L167:
        if (r71.isEmpty() == true) goto L170;
        r123 = false;
        goto L171
    L330:
        if (com.larus.im.bean.message.a.b0(r80) == false) goto L355;
        Intrinsics.checkNotNullParameter(r80, "<this>");
        List r142 = vd9.r.a(r80);
        if ((r142 instanceof Collection) == true) goto L334;
    L336:
        Iterator r143 = r142.iterator();
    L338:
        if (r143.hasNext() == false) goto L345;
        if (((Block) r143.next()).getBlockType() != BlockType.BLOCK_TYPE_CREATION.getValue()) goto L342;
        boolean r144 = true;
    L343:
        if (r144 == false) goto L338;
        boolean r145 = true;
    L346:
        List r146 = o(r80, r72);
        if (r145 == false) goto L349;
    L354:
        r59 = r146;
        r61 = r72;
        r60 = "PreviewMessageTransformer";
        goto L598
    L349:
        if ((!((ArrayList) r146).isEmpty()) == true) goto L354;
        if (r80.getContentType() != 1) goto L354;
        r146 = r(r80, r510);
        goto L354
    L342:
        r144 = false;
    L345:
        r145 = false;
        goto L346
    L334:
        if (r142.isEmpty() == false) goto L336;
    L355:
        String r147 = r510;
        int r148 = 1;
        if (com.larus.bmhome.chat.bean.d.a0(r80) == false) goto L591;
        CreationMsgContentData r149 = dp8.e.c(r80);
        if (r149 == null) goto L380;
        CreationInfo r150 = r149.creationInfo;
        if (r150 == null) goto L380;
        Map<String, CreationTask> r151 = r150.taskInfo;
        if (r151 == null) goto L380;
        Collection<CreationTask> r152 = r151.values();
        if (r152 == null) goto L380;
        List r153 = CollectionsKt.filterNotNull(r152);
        if (r153 == null) goto L380;
        ArrayList r154 = new ArrayList();
        Iterator r155 = r153.iterator();
    L369:
        if (r155.hasNext() == false) goto L379;
        Object r156 = r155.next();
        Integer r157 = ((CreationTask) r156).status;
        if (r157 != null) goto L374;
    L376:
        boolean r158 = false;
    L377:
        if (r158 == false) goto L369;
        r154.add(r156);
        goto L369
    L374:
        if (r157.intValue() != 4) goto L376;
        r158 = true;
        goto L377
    L379:
        List r159 = CollectionsKt.sortedWith(r154, new w());
    L381:
        if (r159 != null) goto L383;
        r159 = CollectionsKt.emptyList();
    L383:
        String r160 = "PreviewMessageTransformer";
        FLogger.a.d(r160, "transformCreationMsgCard: messageId=" + r147 + ", successTasks=" + r159.size());
        if (r159.isEmpty() == false) goto L387;
        ?? r161 = CollectionsKt.emptyList();
    L386:
        r60 = r160;
        r78 = r147;
        r73 = r161;
        goto L590
    L387:
        ArrayList r162 = new ArrayList();
        Iterator r226 = r159.iterator();
        int r163 = 0;
        r161 = r162;
    L389:
        if (r226.hasNext() == false) goto L386;
        Object r164 = r226.next();
        int r227 = r163 + 1;
        if (r163 >= 0) goto L393;
        CollectionsKt.throwIndexOverflow();
    L393:
        CreationTask r165 = (CreationTask) r164;
        String r166 = r165.id;
        IUgcAIGCService.Companion r167 = IUgcAIGCService.a;
        Integer r168 = r165.index;
        if (r168 == null) goto L396;
        int r169 = r168.intValue();
    L397:
        UserCreationFromIM r170 = r167.I(r80, r166, String.valueOf(r169));
        if (r170 == null) goto L401;
        Integer r171 = r170.getCreationType();
        if (r171 == null) goto L401;
    L402:
        Integer r172 = r171;
        if (r170 == null) goto L405;
        String r173 = r170.getCreationId();
    L406:
        Integer r174 = r165.index;
        if (r174 == null) goto L409;
        int r175 = r174.intValue();
    L410:
        String r176 = String.valueOf(r175);
        if (r170 == null) goto L413;
        String r177 = r170.getMaterialId();
    L414:
        if (r170 == null) goto L416;
        String r178 = r170.getPrompt();
    L417:
        if (r170 == null) goto L419;
        String r179 = r170.getRefContent();
    L420:
        if (r170 == null) goto L427;
        Integer r180 = r170.getPrivateStatus();
        if (r180 == null) goto L427;
        if (r180.intValue() != r148) goto L427;
        boolean r181 = true;
    L428:
        String r710 = r160;
        ?? r228 = r161;
        int r182 = r163;
        xy8.e r229 = new xy8.e(r173, r172, r147, r179, r166, r176, r177, r172, r178, false, r181);
        Integer r183 = r165.loadingAssetType;
        if (r183 != null) goto L435;
        CreationAsset r184 = r165.asset;
        if (r184 == null) goto L433;
        r183 = r184.assetType;
        goto L435
    L433:
        r183 = null;
    L435:
        if (r183 != null) goto L438;
    L486:
        String r711 = r147;
        ?? r185 = r228;
        String r186 = r710;
        if (r183 != null) goto L490;
    L587:
        ?? r187 = r185;
        String r712 = r711;
        String r188 = r186;
        FLogger.a.d(r188, "transformCreationMsgCard: skipped assetType=" + r165.loadingAssetType + ", taskId=" + r166);
        Unit r189 = Unit.INSTANCE;
    L588:
        r160 = r188;
        r163 = r227;
        r147 = r712;
        r148 = 1;
        r161 = r187;
        goto L389
    L490:
        if (r183.intValue() != 5) goto L587;
        CreationAsset r190 = r165.asset;
        if (r190 == null) goto L585;
        UserCreationImage r191 = r190.imageContent;
        if (r191 == null) goto L585;
        ImageInfo r192 = r191.a;
        if (r192 == null) goto L585;
        com.larus.platform.api.Image r193 = r192.c;
        if (r193 == null) goto L510;
        String r194 = r193.a;
        if (r194 == null) goto L510;
        if (r194.length() <= 0) goto L505;
        boolean r195 = true;
    L506:
        if (r195 == true) goto L509;
        r194 = null;
    L509:
        if (r194 == null) goto L510;
    L535:
        String r316 = r194;
        SourceType r196 = SourceType.CREATION_CARD;
        String r197 = "creation_msg_" + r711 + '_' + r182;
        String r198 = dp8.e.b(r192.b);
        if (r198 != null) goto L538;
    L547:
        String r317 = r316;
    L548:
        com.larus.platform.api.Image r199 = r192.a;
        if (r199 == null) goto L551;
        String r318 = r199.a;
    L552:
        com.larus.platform.api.Image r200 = r192.i;
        if (r200 == null) goto L555;
        String r319 = r200.a;
    L556:
        Boolean r320 = Boolean.TRUE;
        if (r199 == null) goto L560;
        String r201 = r199.e;
        if (r201 == null) goto L560;
    L577:
        String r321 = r201;
    L578:
        if (r199 == null) goto L580;
        int r322 = (int) r199.c;
    L581:
        if (r199 == null) goto L583;
        int r323 = (int) r199.d;
    L584:
        xy8.b r324 = new xy8.b(r316, r317, r318, r319, r320, false, r321, r322, r323, 96);
        GalleryType r202 = GalleryType.Image;
        a.getClass();
        r712 = r711;
        ?? r203 = r185;
        r203.add(new xy8.d(r196, r197, r324, null, r202, d(r80, true), null, r80.getCreateTime(), null, null, null, null, r229, null, r80, null, r185.size() + 1, 44872));
        r187 = r203;
    L586:
        r188 = r186;
        goto L588
    L583:
        r323 = 0;
        goto L584
    L580:
        r322 = 0;
    L560:
        com.larus.platform.api.Image r204 = r192.c;
        if (r204 == null) goto L563;
        String r1100 = r204.e;
    L564:
        if (r1100 != null) goto L576;
        com.larus.platform.api.Image r205 = r192.b;
        if (r205 == null) goto L568;
        r1100 = r205.e;
    L569:
        if (r1100 != null) goto L576;
        if (r200 == null) goto L572;
        String r1101 = r200.e;
    L573:
        if (r1101 != null) goto L575;
        r321 = r192.e;
        goto L578
    L575:
        r321 = r1101;
        goto L578
    L572:
        r1101 = null;
        goto L573
    L568:
        r1100 = null;
    L576:
        r201 = r1100;
        goto L577
    L563:
        r1100 = null;
        goto L564
    L555:
        r319 = null;
        goto L556
    L551:
        r318 = null;
        goto L552
    L538:
        if (r198.length() <= 0) goto L540;
        boolean r1102 = true;
    L541:
        if (r1102 == true) goto L544;
        r198 = null;
    L544:
        if (r198 == null) goto L547;
        r317 = r198;
        goto L548
    L540:
        r1102 = false;
        goto L541
    L505:
        r195 = false;
    L510:
        com.larus.platform.api.Image r206 = r192.b;
        if (r206 == null) goto L520;
        r194 = r206.a;
        if (r194 == null) goto L520;
        if (r194.length() <= 0) goto L517;
        boolean r1103 = true;
    L518:
        if (r1103 == false) goto L520;
    L521:
        if (r194 != null) goto L535;
        com.larus.platform.api.Image r207 = r192.a;
        if (r207 == null) goto L532;
        r194 = r207.a;
        if (r194 == null) goto L532;
        if (r194.length() <= 0) goto L529;
        boolean r1104 = true;
    L530:
        if (r1104 == false) goto L532;
    L533:
        if (r194 != null) goto L535;
    L534:
        r188 = r186;
        r187 = r185;
        r712 = r711;
        goto L588
    L529:
        r1104 = false;
    L532:
        r194 = null;
        goto L533
    L517:
        r1103 = false;
    L520:
        r194 = null;
    L585:
        r187 = r185;
        r712 = r711;
        goto L586
    L438:
        if (r183.intValue() != 7) goto L486;
        CreationAsset r208 = r165.asset;
        if (r208 == null) goto L485;
        ep8.a r209 = r208.videoContent;
        if (r209 == null) goto L485;
        AiGenVideoContentData r230 = r209.videoInfo;
        if (r230 == null) goto L485;
        CreationNoWatermarkManager r231 = CreationNoWatermarkManager.a;
        String r232 = r230.getVid();
        CoverItem r233 = r230.getVideoCover();
        if (r233 == null) goto L449;
        String r1105 = r233.getKey();
    L450:
        AiGenVideoContentData r234 = r231.a0(r232, r230, r1105);
        if (r234 == null) goto L454;
        r230 = r234;
    L454:
        String r1106 = r230.getVid();
        if (r1106 == null) goto L464;
        if ((!StringsKt.isBlank(r1106)) == true) goto L460;
        r1106 = null;
    L460:
        if (r1106 == null) goto L464;
        String r235 = r1106;
    L466:
        String r416 = r235;
    L468:
        SourceType r236 = SourceType.CREATION_CARD;
        String r237 = "creation_msg_" + r147 + '_' + r182;
        String r513 = r230.getDownloadUrl();
        String r514 = r230.getDownloadFilehash();
        CoverItem r238 = r230.getVideoCover();
        if (r238 == null) goto L471;
        String r515 = ff8.b.a(r238);
    L472:
        String r516 = r230.getLocalUrl();
        String r517 = r230.getVideoModel();
        String r518 = r230.getVideoType();
        Integer r239 = r230.getLoadingWidth();
        if (r239 == null) goto L475;
        int r519 = r239.intValue();
    L476:
        Integer r240 = r230.getLoadingHeight();
        if (r240 == null) goto L479;
        int r520 = r240.intValue();
    L480:
        Double r241 = r230.getDuration();
        if (r241 == null) goto L483;
        double r611 = r241.doubleValue();
    L484:
        xy8.g r1107 = new xy8.g(r416, r513, r514, r515, null, r516, r517, r518, null, r519, r520, r611, null, null, null, 61712);
        GalleryType r242 = GalleryType.Video;
        a.getClass();
        r711 = r147;
        r185 = r228;
        r185.add(new xy8.d(r236, r237, null, r1107, r242, d(r80, false), null, r80.getCreateTime(), null, null, null, null, r229, null, r80, null, r228.size() + 1, 44868));
        r186 = r710;
        goto L534
    L483:
        r611 = 0.0d;
        goto L484
    L479:
        r520 = 0;
        goto L480
    L475:
        r519 = 0;
        goto L476
    L471:
        r515 = null;
    L464:
        if (r166 != null) goto L467;
        r235 = UUID.randomUUID().toString();
        goto L466
    L467:
        r416 = r166;
        goto L468
    L449:
        r1105 = null;
    L485:
        r711 = r147;
        r185 = r228;
        r186 = r710;
        FLogger.a.e(r186, "transformCreationMsgCard: video task without videoInfo, taskId=" + r166);
    L427:
        r181 = false;
        goto L428
    L419:
        r179 = null;
        goto L420
    L416:
        r178 = null;
        goto L417
    L413:
        r177 = null;
        goto L414
    L409:
        r175 = r163;
        goto L410
    L405:
        r173 = null;
    L401:
        v r243 = a;
        Integer r244 = r165.taskType;
        r243.getClass();
        r171 = e(r244);
        goto L402
    L396:
        r169 = r163;
    L380:
        r159 = null;
        goto L381
    L591:
        r60 = "PreviewMessageTransformer";
        if (r80.getContentType() != 1) goto L594;
        r61 = r147;
        r59 = r(r80, r61);
        goto L598
    L594:
        r61 = r147;
        if (r80.getContentType() != 8) goto L597;
        r59 = q(r80, r61);
        goto L598
    L597:
        r1.i(r60, "transform: unsupported contentType=" + r80.getContentType());
        r59 = CollectionsKt.emptyList();
        goto L598
    L5:
        r3 = r0;
        goto L6
    }

    public static xy8.f b(Message r23, UplinkFileEntity r24) {
        String r18 = r23.getMessageId();
        int r19 = r23.getContentType();
        Integer r20 = r24.getUpLinkStatus();
        String r21 = l1.d(r24);
        String r22 = r24.getFileIdentifier();
        int r8 = UpLinkState.SUCCESS.getValue();
        int r6 = FileParseState.SUCCESS.getValue();
        return new xy8.f(r18, r19, r20, r21, r22, CollectionsKt.listOf(UplinkFileEntity.copy$default(r24, null, null, null, null, Integer.valueOf(FileReviewState.ACCESS.getValue()), Integer.valueOf(r6), 100, Integer.valueOf(r8), null, false, null, null, null, null, 16143, null)));
    }

    public static Map d(Message r4, boolean r5) {
        Pair[] r0 = new Pair[5];
        String r1 = r4.getMessageId();
        String r2 = "";
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0[0] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r1);
        String r3 = r4.getConversationId();
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0[1] = TuplesKt.to(MusicAppletPage.KEY_CONVERSATION_ID, r3);
        if (r5 == false) goto L11;
        String r6 = "picture_detail";
    L12:
        r0[2] = TuplesKt.to("current_page", r6);
        r0[3] = TuplesKt.to("enter_from", "chat");
        String r7 = r4.getReplyId();
        if (r7 == null) goto L16;
        r2 = r7;
    L16:
        r0[4] = TuplesKt.to("reply_id", r2);
        Map r8 = MapsKt.mutableMapOf(r0);
        String r9 = l(r4);
        if (r9 == null) goto L19;
        r8.put("req_id", r9);
    L19:
        Map r10 = r4.getExt();
        if (r10 == null) goto L24;
        String r11 = (String) r10.get("rich_media_type");
        if (r11 == null) goto L24;
        r8.put("rich_media_type", r11);
    L24:
        return r8;
    L11:
        r6 = "video_detail";
        goto L12
    }

    public static String k(ImageObj r4, boolean r5) {
        boolean r0 = false;
        if (r5 == false) goto L16;
        if (r4 == null) goto L16;
        String r6 = r4.getHeicUrl();
        if (r6 == null) goto L16;
        if (r6.length() <= 0) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L14;
        r6 = null;
    L14:
        if (r6 == null) goto L16;
        return r6;
    L10:
        r3 = false;
    L16:
        if (r4 == null) goto L25;
        String r7 = r4.url;
        if (r7 != null) goto L20;
        return null;
    L20:
        if (r7.length() <= 0) goto L22;
        r0 = true;
    L22:
        if (r0 == true) goto L24;
        return null;
    L24:
        return r7;
    L25:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v30, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v31, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v32 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.List] */
    public static List o(Message r67, String r68) {
        Message r5 = r67;
        String r4 = r68;
        ArrayList r3 = new ArrayList();
        Intrinsics.checkNotNullParameter(r5, "<this>");
        List r0 = vd9.r.a(r67);
        List r1 = r0;
        if ((r1 instanceof Collection) == true) goto L5;
    L7:
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L16;
        if (((Block) r2.next()).getBlockType() != BlockType.BLOCK_TYPE_CREATION.getValue()) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == false) goto L9;
        boolean r7 = true;
    L17:
        Map r8 = r67.getExt();
        if (r8 == null) goto L20;
        String r13 = (String) r8.get("_mixed_richmedia_position_trace");
    L21:
        if (r13 == null) goto L39;
        List r9 = StringsKt.split$default(r13, new char[]{','}, false, 0, 6, null);
        if (r9 == null) goto L39;
        ?? r10 = new ArrayList();
        Iterator r11 = r9.iterator();
    L26:
        if (r11.hasNext() == false) goto L40;
        List r12 = StringsKt.split$default((String) r11.next(), new char[]{':'}, false, 2, 2, null);
        String r14 = (String) CollectionsKt.getOrNull(r12, 0);
        if (r14 == null) goto L36;
        Integer r15 = StringsKt.toIntOrNull(r14);
        if (r15 == null) goto L36;
        int r16 = r15.intValue();
        String r17 = (String) CollectionsKt.getOrNull(r12, 1);
        if (r17 == null) goto L36;
        Integer r18 = StringsKt.toIntOrNull(r17);
        if (r18 == null) goto L36;
        Pair r19 = TuplesKt.to(Integer.valueOf(r16), Integer.valueOf(r18.intValue()));
    L37:
        if (r19 == null) goto L26;
        r10.add(r19);
    L36:
        r19 = null;
    L40:
        if (r10 != 0) goto L42;
        r10 = CollectionsKt.emptyList();
    L42:
        boolean r20 = !((Collection) r10).isEmpty();
        ?? r21 = r10;
        if (r20 == true) goto L46;
        r21 = 0;
    L46:
        if (r21 == 0) goto L48;
        Iterator r22 = r21.iterator();
    L49:
        FLogger r23 = FLogger.a;
        String r24 = "transformBlockContent: messageId=";
        StringBuilder r25 = new StringBuilder("transformBlockContent: messageId=");
        r25.append(r4);
        r25.append(", blocks.size=");
        r25.append(r0.size());
        String r110 = ", hasCreationBlock=";
        r25.append(", hasCreationBlock=");
        r25.append(r7);
        String r26 = "PreviewMessageTransformer";
        r23.d("PreviewMessageTransformer", r25.toString());
        Iterator r27 = r0.iterator();
        String r28 = r4;
        Message r29 = r5;
        int r30 = 0;
        int r31 = 0;
    L51:
        if (r27.hasNext() == false) goto L286;
        Object r111 = r27.next();
        int r210 = r30 + 1;
        if (r30 >= 0) goto L55;
        CollectionsKt.throwIndexOverflow();
    L55:
        Block r211 = (Block) r111;
        FLogger r112 = FLogger.a;
        StringBuilder r113 = new StringBuilder("transformBlockContent: blockIndex=");
        r113.append(r30);
        r113.append(", blockType=");
        r113.append(r211.getBlockType());
        r113.append(r110);
        BlockContent r114 = r211.getContent();
        if (r114 == null) goto L58;
        CreationBlock r115 = r114.getCreationBlock();
    L59:
        if (r115 == null) goto L61;
        boolean r116 = true;
    L62:
        r113.append(r116);
        r113.append(", creationsSize=");
        BlockContent r117 = r211.getContent();
        if (r117 == null) goto L69;
        CreationBlock r118 = r117.getCreationBlock();
        if (r118 == null) goto L69;
        List r119 = r118.creations;
        if (r119 == null) goto L69;
        Integer r120 = Integer.valueOf(r119.size());
    L70:
        r113.append(r120);
        r112.d(r26, r113.toString());
        int r121 = r211.getBlockType();
        if (r121 != BlockType.BLOCK_TYPE_CREATION.getValue()) goto L82;
        v r122 = a;
        SourceType r123 = SourceType.CREATION_CARD;
        r122.getClass();
        BlockContent r124 = r211.getContent();
        if (r124 == null) goto L77;
        CreationBlock r125 = r124.getCreationBlock();
        if (r125 == null) goto L77;
        List r126 = r125.creations;
    L78:
        if (r126 != null) goto L80;
        r126 = CollectionsKt.emptyList();
    L80:
        r3.addAll(p(r29, r123, r30, CollectionsKt.toList(CollectionsKt.withIndex(r126))));
        boolean r32 = r7;
        ArrayList r33 = r3;
        String r34 = r26;
        String r62 = r24;
        String r35 = r110;
        Message r66 = r5;
        String r36 = r4;
        Message r37 = r66;
    L285:
        r26 = r34;
        r7 = r32;
        r110 = r35;
        r24 = r62;
        r3 = r33;
        r30 = r210;
        String r69 = r36;
        r5 = r37;
        r4 = r69;
    L77:
        r126 = null;
        goto L78
    L82:
        if (r121 != BlockType.BLOCK_TYPE_RICH_MEDIA_LAYOUT.getValue()) goto L237;
        int r38 = r31 + 1;
        a.getClass();
        String r39 = r67.getMessageId();
        if (r39 != null) goto L86;
        r39 = "";
    L86:
        String r127 = r39;
        ArrayList r40 = new ArrayList();
        BlockContent r128 = r211.getContent();
        if (r128 == null) goto L91;
        RichMediaLayoutBlock r129 = r128.getRichMediaLayoutBlock();
        if (r129 == null) goto L91;
        List r130 = r129.richMediaItem;
    L92:
        if (r130 != null) goto L94;
        r130 = CollectionsKt.emptyList();
    L94:
        Iterator r212 = r130.iterator();
        int r131 = r30;
        Message r132 = r29;
        int r133 = 0;
    L96:
        if (r212.hasNext() == false) goto L236;
        Object r134 = r212.next();
        int r213 = r133 + 1;
        if (r133 >= 0) goto L100;
        CollectionsKt.throwIndexOverflow();
    L100:
        RichMediaItem r41 = (RichMediaItem) r134;
        if (r22 != null) goto L103;
        Pair r214 = null;
    L108:
        Integer r135 = r41.type;
        int r215 = r38;
        int r42 = RichMediaType.SEARCH_IMAGE.getValue();
        int r310 = r30;
        boolean r311 = r7;
        if (r135 != null) goto L112;
    L110:
        ArrayList r55 = r3;
        ArrayList r136 = r40;
        String r216 = r26;
        String r56 = r24;
        String r57 = r110;
        String r43 = r127;
        int r44 = r133;
        int r45 = r131;
        int r46 = RichMediaType.GENERIC_IMAGE.getValue();
        if (r135 != null) goto L125;
    L159:
        RichMediaItem r47 = r41;
        int r48 = RichMediaType.GENERIC_VIDEO.getValue();
        if (r135 != null) goto L163;
    L208:
        r43 = r43;
        String r63 = r216;
        r311 = r311;
        r55 = r55;
        r56 = r56;
        r57 = r57;
        char r312 = 1;
        char r313 = 0;
        ArrayList r314 = r136;
        int r49 = RichMediaType.CREATION.getValue();
        if (r135 != null) goto L212;
    L217:
        Message r50 = r67;
        int r51 = r310;
        r45 = r51;
        Message r52 = r50;
        Message r137 = r52;
        xy8.d r53 = null;
    L218:
        if (r53 != null) goto L220;
        ArrayList r54 = r314;
    L235:
        r29 = r52;
        r30 = r51;
        r131 = r45;
        r40 = r54;
        r132 = r137;
        r133 = r213;
        r38 = r215;
        r7 = r311;
        r110 = r57;
        r127 = r43;
        r24 = r56;
        r26 = r63;
        r3 = r55;
        r5 = r50;
        goto L96
    L220:
        int r138 = r314.size() + 1;
        Map<String, Object> r58 = r53.f;
        v r59 = a;
        if (r214 == null) goto L223;
        int r60 = ((Number) r214.getFirst()).intValue();
    L224:
        if (r214 == null) goto L226;
        int r61 = ((Number) r214.getSecond()).intValue();
    L227:
        String r139 = r211.getBlockId();
        r59.getClass();
        Map r64 = MapsKt.plus(r58, a(r50, r47, r60, r61, r139));
        Map<String, String> r65 = r53.j;
        Pair[] r70 = new Pair[3];
        r70[r313] = TuplesKt.to("_mixed_richmedia_download_trace", "1");
        r70[r312] = TuplesKt.to("_mixed_richmedia_enter_detail_trace", "1");
        if (r214 == null) goto L230;
        int r140 = ((Number) r214.getFirst()).intValue();
    L231:
        if (r214 == null) goto L233;
        int r141 = ((Number) r214.getSecond()).intValue();
    L234:
        r70[2] = TuplesKt.to("_mixed_richmedia_enter_detail_params", new JSONObject(a(r50, r47, r140, r141, r211.getBlockId())).toString());
        xy8.d r71 = xy8.d.a(r53, null, null, null, r64, null, MapsKt.plus(r65, MapsKt.mapOf(r70)), null, null, null, r138, 64991);
        r54 = r314;
        r54.add(r71);
        goto L235
    L233:
        r141 = r213;
        goto L234
    L230:
        r140 = r215;
        goto L231
    L226:
        r61 = r213;
        goto L227
    L223:
        r60 = r215;
        goto L224
    L212:
        if (r135.intValue() != r49) goto L217;
        CreationItem r72 = r47.creation;
        if (r72 == null) goto L217;
        v r73 = a;
        SourceType r74 = SourceType.CREATION_CARD;
        List r75 = CollectionsKt.listOf(new IndexedValue(r44, r72));
        r73.getClass();
        r50 = r67;
        r51 = r310;
        xy8.d r76 = (xy8.d) CollectionsKt.firstOrNull(p(r50, r74, r51, r75));
    L216:
        r53 = r76;
        r45 = r51;
        r52 = r50;
        r137 = r52;
        goto L218
    L163:
        if (r135.intValue() != r48) goto L208;
        GenericVideoItem r77 = r47.videoItem;
        if (r77 != null) goto L167;
    L206:
        r63 = r216;
        r312 = 1;
        r313 = 0;
        r314 = r136;
        xy8.d r510 = null;
    L207:
        r50 = r67;
        r76 = r510;
        r51 = r310;
        goto L216
    L167:
        if (r77.type == MediaType.MediaTypeLocalFile.getValue()) goto L169;
        boolean r142 = true;
    L170:
        if (r142 == true) goto L173;
        r77 = null;
    L173:
        if (r77 == null) goto L206;
        String r78 = "rich_media_" + r45 + '_' + r44;
        a.getClass();
        String r79 = r77.resource;
        if (r79 == null) goto L206;
        if ((!StringsKt.isBlank(r79)) == false) goto L179;
        String r315 = r79;
    L180:
        if (r315 == null) goto L206;
        String r80 = r77.uri;
        if (r80 != null) goto L185;
    L189:
        r80 = r77.id;
        if (r80 == null) goto L192;
    L191:
        String r316 = r80;
    L193:
        SourceType r81 = SourceType.BOT_RESP;
        String r82 = r78 + '_' + r43;
        String r83 = r77.coverUrl;
        Map r84 = r77.extra;
        if (r84 == null) goto L196;
        String r410 = (String) r84.get("file_type");
    L197:
        Integer r85 = r77.width;
        if (r85 == null) goto L200;
        int r411 = r85.intValue();
    L201:
        Integer r86 = r77.height;
        if (r86 == null) goto L204;
        int r412 = r86.intValue();
    L205:
        r63 = r216;
        r312 = 1;
        r313 = 0;
        r314 = r136;
        r510 = new xy8.d(r81, r82, null, new xy8.g(r316, r315, null, r83, null, null, null, r410, null, r411, r412, 0.0d, null, null, null, 63860), GalleryType.Video, d(r132, false), null, r67.getCreateTime(), null, null, null, null, null, null, r67, null, 0, 114500);
        goto L207
    L204:
        r412 = 0;
        goto L205
    L200:
        r411 = 0;
        goto L201
    L196:
        r410 = null;
        goto L197
    L192:
        r316 = r315;
        goto L193
    L185:
        if ((!StringsKt.isBlank(r80)) == true) goto L188;
        r80 = null;
    L188:
        if (r80 != null) goto L191;
    L179:
        r315 = null;
        goto L180
    L169:
        r142 = false;
        goto L170
    L125:
        if (r135.intValue() != r46) goto L159;
        r47 = r41;
        GenericImageItem r87 = r47.imageItem;
        if (r87 != null) goto L129;
    L157:
        xy8.d r88 = null;
    L158:
        r43 = r43;
        r50 = r5;
        r137 = r132;
        r63 = r216;
        r51 = r310;
        r311 = r311;
        r55 = r55;
        r56 = r56;
        r57 = r57;
        r312 = 1;
        r313 = 0;
        r53 = r88;
        r52 = r29;
        r314 = r136;
        goto L218
    L129:
        if (r87.type == MediaType.MediaTypeLocalFile.getValue()) goto L131;
        boolean r89 = true;
    L132:
        if (r89 == true) goto L135;
        r87 = null;
    L135:
        if (r87 == null) goto L157;
        a.getClass();
        String r90 = r87.id;
        if (r90 == null) goto L139;
        Long r317 = StringsKt.toLongOrNull(r90);
    L140:
        String r91 = r87.id;
        if (r91 != null) goto L143;
        r91 = r87.uri;
    L143:
        String r318 = r91;
        String r92 = r87.uri;
        String r93 = r87.coverUrl;
        String r143 = r87.resource;
        if (r143 != null) goto L146;
    L151:
        List r319 = null;
    L152:
        Integer r144 = r87.width;
        Integer r145 = r87.height;
        Map r94 = r87.extra;
        if (r94 == null) goto L155;
        String r413 = (String) r94.get("doc_id");
    L156:
        r88 = (xy8.d) CollectionsKt.firstOrNull(c(r132, r43, CollectionsKt.listOf(new SearchImageInfo(r317, r318, r92, r93, r93, r319, null, r144, r145, r413, null, null, null, null, null, null, r144, r145, null, null, 851008, null)), "rich_media_" + r45 + '_' + r44));
        goto L158
    L155:
        r413 = null;
        goto L156
    L146:
        if ((!StringsKt.isBlank(r143)) == true) goto L149;
        r143 = null;
    L149:
        if (r143 == null) goto L151;
        r319 = CollectionsKt.listOf(r143);
        goto L152
    L139:
        r317 = null;
        goto L140
    L131:
        r89 = false;
        goto L132
    L112:
        if (r135.intValue() != r42) goto L110;
        SearchImageItem r95 = r41.image;
        if (r95 == null) goto L120;
        a.getClass();
        Long r96 = r95.id;
        String r146 = r95.itemId;
        String r147 = r95.uri;
        r55 = r3;
        String r97 = r95.thumbUrl;
        r136 = r40;
        String r98 = r95.originThumbUrl;
        r216 = r26;
        List r99 = r95.fullSizeUrl;
        r56 = r24;
        String r100 = r95.mainSiteUrl;
        r57 = r110;
        Integer r148 = r95.width;
        Integer r101 = r95.height;
        String r102 = r95.docId;
        String r511 = r127;
        String r149 = r95.authorShortId;
        int r610 = r133;
        Long r150 = r95.sourceFrom;
        int r611 = r131;
        if (r150 == null) goto L118;
        Integer r414 = Integer.valueOf((int) r150.longValue());
    L119:
        List r103 = CollectionsKt.listOf(new SearchImageInfo(r96, r146, r147, r97, r98, r99, r100, r148, r101, r102, r149, r414, r95.sourceAppName, r95.sourceAppIcon, r95.imgCaption, null, r95.originWidth, r95.originHeight, r95.imageSource, r95.searchId, 32768, null));
        StringBuilder r104 = new StringBuilder("rich_media_");
        r45 = r611;
        r104.append(r45);
        r104.append('_');
        r104.append(r610);
        String r105 = r104.toString();
        r5 = r67;
        r43 = r511;
        r88 = (xy8.d) CollectionsKt.firstOrNull(c(r5, r43, r103, r105));
        r29 = r5;
        r132 = r29;
        r47 = r41;
        goto L158
    L118:
        r414 = null;
        goto L119
    L120:
        r55 = r3;
        r136 = r40;
        r216 = r26;
        r56 = r24;
        r57 = r110;
        r43 = r127;
        r45 = r131;
        r47 = r41;
        goto L157
    L103:
        if (r22.hasNext() == false) goto L105;
        Pair r151 = (Pair) r22.next();
    L106:
        r214 = r151;
        goto L108
    L105:
        r151 = null;
        goto L106
    L236:
        int r217 = r38;
        r32 = r7;
        r33 = r3;
        r37 = r5;
        r62 = r24;
        r35 = r110;
        r33.addAll(r40);
        r28 = r68;
        r36 = r28;
        r31 = r217;
        r34 = r26;
    L91:
        r130 = null;
        goto L92
    L237:
        r32 = r7;
        r37 = r5;
        String r612 = r26;
        r62 = r24;
        r35 = r110;
        int r106 = r30;
        r33 = r3;
        BlockType r107 = BlockType.BLOCK_TYPE_IMAGE;
        if (r121 != r107.getValue()) goto L240;
    L243:
        r34 = r612;
        if (r32 == false) goto L247;
        r112.d(r34, "transformBlockContent: skipped non-creation image block because creation block exists, blockIndex=" + r106 + ", blockType=" + r211.getBlockType());
    L246:
        r36 = r68;
    L284:
        r28 = r36;
        goto L285
    L247:
        a.getClass();
        int r108 = r211.getBlockType();
        if (r108 != r107.getValue()) goto L271;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L261
        Gson r152 = b;     // Catch: Throwable -> L261
        BlockContent r153 = r211.getContent();     // Catch: Throwable -> L261
        if (r153 == null) goto L252;
        String r154 = r153.getImageBlock();     // Catch: Throwable -> L261
    L253:
        b r155 = (b) r152.fromJson(r154, b.class);     // Catch: Throwable -> L261
        if (r155 == null) goto L256;
        List<SearchImageInfo> r156 = r155.a;     // Catch: Throwable -> L261
    L257:
        if (r156 != null) goto L259;
        r156 = CollectionsKt.emptyList();     // Catch: Throwable -> L261
    L259:
        Object r157 = Result.constructor-impl(CollectionsKt.filterNotNull(r156));     // Catch: Throwable -> L261
    L263:
        Throwable r158 = Result.exceptionOrNull-impl(r157);
        if (r158 == null) goto L266;
        FLogger.a.e(r34, "extractSearchImagesFromBlock failed: " + r158.getMessage());
    L266:
        List r159 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r157) == false) goto L269;
        r157 = r159;
    L269:
        List r160 = (List) r157;
    L282:
        if ((!r160.isEmpty()) == false) goto L246;
        a.getClass();
        r36 = r68;
        r33.addAll(c(r29, r36, r160, "block_search_" + r106));
        goto L284
    L256:
        r156 = null;
        goto L257
    L252:
        r154 = null;
    L261:
        th = move-exception;
        Result.Companion r161 = Result.Companion;
        r157 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L263
    L271:
        if (r108 != BlockType.BLOCK_TYPE_GEN_IMAGE.getValue()) goto L280;
        BlockContent r162 = r211.getContent();
        if (r162 == null) goto L277;
        GenImageBlock r163 = r162.getGenImageBlock();
        if (r163 == null) goto L277;
        r160 = r163.images;
    L278:
        if (r160 != null) goto L282;
        r160 = CollectionsKt.emptyList();
    L277:
        r160 = null;
        goto L278
    L280:
        r160 = CollectionsKt.emptyList();
        goto L282
    L240:
        if (r121 == BlockType.BLOCK_TYPE_GEN_IMAGE.getValue()) goto L243;
        r34 = r612;
        r112.d(r34, "transformBlockContent: skipped blockType=" + r211.getBlockType());
    L69:
        r120 = null;
        goto L70
    L61:
        r116 = false;
        goto L62
    L58:
        r115 = null;
        goto L59
    L286:
        ArrayList r164 = r3;
        FLogger.a.d(r26, r24 + r28 + ", results.size=" + r164.size());
        return r164;
    L48:
        r22 = null;
    L39:
        r10 = 0;
        goto L40
    L20:
        r13 = null;
        goto L21
    L13:
        r6 = false;
    L16:
        r7 = false;
        goto L17
    L5:
        if (r1.isEmpty() == false) goto L7;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList] */
    public static List q(Message r30, String r31) {
        oi8.k r0 = (oi8.k) b.fromJson(r30.getContent(), oi8.k.class);     // Catch: Throwable -> L56
        if (r0 == null) goto L9;
        com.larus.bmhome.chat.search.b r2 = r0.e();     // Catch: Throwable -> L56
        if (r2 == null) goto L9;
        com.larus.bmhome.chat.search.b.a r3 = r2.c();     // Catch: Throwable -> L56
        if (r3 == null) goto L9;
        List r4 = r3.a();     // Catch: Throwable -> L56
    L10:
        if (r4 != null) goto L12;
        r4 = CollectionsKt.emptyList();     // Catch: Throwable -> L56
    L12:
        ?? r5 = new ArrayList();     // Catch: Throwable -> L56
        Iterator r6 = r4.iterator();     // Catch: Throwable -> L56
    L14:
        if (r6.hasNext() == false) goto L19;
        Object r7 = r6.next();     // Catch: Throwable -> L56
        if (((SearchImageInfo) r7).isPlaceHolder() == true) goto L14;
        r5.add(r7);     // Catch: Throwable -> L56
        goto L14
    L19:
        if ((!r5.isEmpty()) == true) goto L59;
        if (r0 == null) goto L27;
        com.larus.bmhome.chat.search.b r1 = r0.e();     // Catch: Throwable -> L56
        if (r1 == null) goto L27;
        com.larus.bmhome.chat.search.b.c r8 = r1.e();     // Catch: Throwable -> L56
        if (r8 == null) goto L27;
        List r9 = r8.a();     // Catch: Throwable -> L56
    L28:
        if (r9 != null) goto L30;
        r9 = CollectionsKt.emptyList();     // Catch: Throwable -> L56
    L30:
        r5 = new ArrayList();     // Catch: Throwable -> L56
        Iterator r10 = r9.iterator();     // Catch: Throwable -> L56
    L31:
        if (r10.hasNext() == false) goto L59;
        ArticleInfo r11 = (ArticleInfo) r10.next();     // Catch: Throwable -> L56
        String r12 = r11.getImageUrl();     // Catch: Throwable -> L56
        if (r12 != null) goto L36;
    L52:
        SearchImageInfo r13 = null;
    L53:
        if (r13 == null) goto L31;
        r5.add(r13);     // Catch: Throwable -> L56
        goto L31
    L36:
        if (r12.length() <= 0) goto L38;
        boolean r14 = true;
    L39:
        if (r14 == false) goto L41;
        String r15 = r12;
    L42:
        if (r15 == null) goto L52;
        String r16 = r11.getCardId();     // Catch: Throwable -> L56
        if (r16 == null) goto L47;
        Long r17 = StringsKt.toLongOrNull(r16);     // Catch: Throwable -> L56
    L48:
        String r18 = r11.getDocId();     // Catch: Throwable -> L56
        if (r18 != null) goto L51;
        r18 = r11.getCardId();     // Catch: Throwable -> L56
    L51:
        r13 = new SearchImageInfo(r17, r18, null, r15, null, CollectionsKt.listOf(r15), r11.getOpenUrl(), null, null, r11.getDocId(), null, r11.getSourceFrom(), r11.getSiteName(), r11.getIconUrl(), r11.getTitle(), null, null, null, null, null, 1017236, null);     // Catch: Throwable -> L56
        goto L53
    L47:
        r17 = null;
        goto L48
    L41:
        r15 = null;
        goto L42
    L38:
        r14 = false;
    L27:
        r9 = null;
    L59:
        if (r5.isEmpty() == false) goto L63;
        return CollectionsKt.emptyList();
    L63:
        return c(r30, r31, r5, "search_card");
    L9:
        r4 = null;
    L56:
        th = move-exception;
        FLogger.a.e("PreviewMessageTransformer", "extractSearchListImages error: " + th.getMessage());
        r5 = CollectionsKt.emptyList();
        goto L59
    }

    public static List r(Message r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        List r0 = vd9.r.a(r12);
        if (r0.isEmpty() == false) goto L5;
        r0 = com.larus.im.bean.message.a.f(r12);
    L5:
        List r1 = r0;
        boolean r2 = true;
        String r4 = "";
        if (r1.isEmpty() == false) goto L8;
        List r3 = CollectionsKt.emptyList();
    L25:
        if ((!r3.isEmpty()) == true) goto L57;
        Iterator r5 = CollectionsKt.listOf(new String[]{com.larus.bmhome.chat.bean.d.m(r12, false), com.larus.bmhome.chat.bean.d.m(r12, true), com.larus.bmhome.chat.bean.d.s(r12)}).iterator();
    L29:
        if (r5.hasNext() == false) goto L40;
        Object r6 = r5.next();
        String r8 = (String) r6;
        if (r8 != null) goto L33;
    L36:
        boolean r9 = true;
    L38:
        if ((!r9) == false) goto L29;
    L41:
        String r7 = (String) r6;
        if (r7 == null) goto L46;
        r4 = r7;
    L46:
        if (r4.length() == 0) goto L49;
        r2 = false;
    L49:
        if (r2 == false) goto L51;
        r3 = CollectionsKt.emptyList();
        goto L57
    L51:
        Regex r10 = new Regex("<data-[^>]+>");
        ArrayList r11 = new ArrayList();
        Iterator r14 = Regex.findAll$default(r10, r4, 0, 2, null).iterator();
    L53:
        if (r14.hasNext() == false) goto L55;
        MatchResult r15 = (MatchResult) r14.next();
        v r16 = a;
        String r17 = r15.getValue();
        r16.getClass();
        r11.addAll(f(r12, r17, false));
        goto L53
    L55:
        r3 = r11;
        goto L57
    L33:
        if (r8.length() == 0) goto L36;
        r9 = false;
        goto L38
    L40:
        r6 = null;
    L57:
        if (r3.isEmpty() == false) goto L61;
        return CollectionsKt.emptyList();
    L61:
        return c(r12, r13, r3, "search");
    L8:
        Regex r18 = new Regex("<data-[^>]+>");
        ArrayList r19 = new ArrayList();
        Iterator r20 = r1.iterator();
    L10:
        if (r20.hasNext() == false) goto L23;
        String r21 = qf8.a.c((Block) r20.next(), r12, 2);
        if (r21 != null) goto L15;
        r21 = "";
    L15:
        if (r21.length() != 0) goto L17;
        boolean r110 = true;
    L18:
        if (r110 == true) goto L10;
        Iterator r22 = Regex.findAll$default(r18, r21, 0, 2, null).iterator();
    L21:
        if (r22.hasNext() == false) goto L10;
        MatchResult r111 = (MatchResult) r22.next();
        v r112 = a;
        String r113 = r111.getValue();
        r112.getClass();
        r19.addAll(f(r12, r113, true));
        goto L21
    L17:
        r110 = false;
        goto L18
    L23:
        r3 = r19;
        goto L25
    }

    public static List f(Message r30, String r31, boolean r32) {
        Regex r1 = new Regex("\\btype\\s*=\\s*\"([^\"]+)\"");
        Regex r2 = new Regex("\\bvalue_id\\s*=\\s*\"([^\"]+)\"");
        Regex r3 = new Regex("\\bvalue\\s*=\\s*\"([^\"]*)\"");
        boolean r4 = false;
        MatchResult r5 = Regex.find$default(r1, r31, 0, 2, null);
        if (r5 == null) goto L7;
        List r6 = r5.getGroupValues();
        if (r6 == null) goto L7;
        String r7 = (String) CollectionsKt.getOrNull(r6, 1);
    L8:
        if (r32 == true) goto L10;
    L13:
        MatchResult r8 = Regex.find$default(r2, r31, 0, 2, null);
        if (r8 == null) goto L18;
        List r9 = r8.getGroupValues();
        if (r9 == null) goto L18;
        String r10 = (String) CollectionsKt.getOrNull(r9, 1);
    L19:
        MatchResult r0 = Regex.find$default(r3, r31, 0, 2, null);
        if (r0 == null) goto L24;
        List r11 = r0.getGroupValues();
        if (r11 == null) goto L24;
        String r12 = (String) CollectionsKt.getOrNull(r11, 1);
    L25:
        if (r10 != null) goto L27;
    L30:
        boolean r13 = true;
    L31:
        if (r13 == true) goto L74;
        RichMediaMeta r14 = wc8.b.a.h(r30.getMessageId(), r10, "PreviewMessageTransformer");
        if (r14 == null) goto L53;
        List r15 = r14.getMedia();
        if (r15 == null) goto L53;
        List r16 = r15;
        if ((r16 instanceof Collection) == true) goto L39;
    L41:
        Iterator r17 = r16.iterator();
    L43:
        if (r17.hasNext() == false) goto L50;
        if (((RichMediaItem) r17.next()).image == null) goto L47;
        boolean r18 = true;
    L48:
        if (r18 == false) goto L43;
        boolean r19 = true;
    L51:
        if (r19 != true) goto L53;
        r4 = true;
        goto L53
    L47:
        r18 = false;
    L50:
        r19 = false;
        goto L51
    L39:
        if (r16.isEmpty() == false) goto L41;
    L53:
        if (r4 == false) goto L73;
        List r20 = r14.getMedia();
        if (r20 == null) goto L71;
        ArrayList r21 = new ArrayList();
        Iterator r22 = r20.iterator();
    L58:
        if (r22.hasNext() == false) goto L91;
        SearchImageItem r23 = ((RichMediaItem) r22.next()).image;
        if (r23 == null) goto L66;
        Long r24 = r23.id;
        String r25 = r23.itemId;
        String r110 = r23.uri;
        String r111 = r23.thumbUrl;
        String r112 = r23.originThumbUrl;
        List r113 = r23.fullSizeUrl;
        String r114 = r23.mainSiteUrl;
        Integer r115 = r23.width;
        Integer r26 = r23.height;
        String r27 = r23.docId;
        String r28 = r23.authorShortId;
        Long r29 = r23.sourceFrom;
        if (r29 == null) goto L64;
        Integer r116 = Integer.valueOf((int) r29.longValue());
    L65:
        SearchImageInfo r33 = new SearchImageInfo(r24, r25, r110, r111, r112, r113, r114, r115, r26, r27, r28, r116, r23.sourceAppName, r23.sourceAppIcon, r23.imgCaption, null, r23.originWidth, r23.originHeight, r23.imageSource, null, 557056, null);
    L67:
        if (r33 == null) goto L58;
        r21.add(r33);
        goto L58
    L64:
        r116 = null;
        goto L65
    L66:
        r33 = null;
        goto L67
    L91:
        return r21;
    L71:
        return CollectionsKt.emptyList();
    L73:
        return g(wc8.b.a.c(r30.getMessageId(), r10, "PreviewMessageTransformer"));
    L74:
        if (r12 != null) goto L76;
    L77:
        r4 = true;
    L78:
        if (r4 == true) goto L82;
        return g(r12);
    L82:
        return CollectionsKt.emptyList();
    L76:
        if (r12.length() != 0) goto L78;
    L27:
        if (r10.length() == 0) goto L30;
        r13 = false;
    L24:
        r12 = null;
    L18:
        r10 = null;
        goto L19
    L10:
        if (Intrinsics.areEqual(r7, "image-group") == true) goto L13;
        return CollectionsKt.emptyList();
    L7:
        r7 = null;
        goto L8
    }

    public static List c(Message r40, String r41, List r42, String r43) {
        ArrayList r0 = new ArrayList();
        Iterator r1 = r42.iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L91;
        Object r4 = r1.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        SearchImageInfo r6 = (SearchImageInfo) r4;
        List r7 = r6.getFullSizeUrl();
        String r8 = null;
        if (r7 == null) goto L19;
        Iterator r9 = r7.iterator();
    L12:
        if (r9.hasNext() == false) goto L16;
        Object r10 = r9.next();
        if ((!StringsKt.isBlank((String) r10)) == false) goto L12;
    L17:
        String r11 = (String) r10;
        if (r11 == null) goto L19;
    L29:
        String r12 = r11;
        if (r12 != null) goto L32;
    L35:
        boolean r13 = true;
    L36:
        if (r13 == true) goto L90;
        v r14 = a;
        Integer r15 = r6.getOriginWidth();
        r14.getClass();
        Integer r16 = h(r15);
        if (r16 != null) goto L42;
        r16 = h(r6.getWidth());
        if (r16 != null) goto L42;
        int r18 = 0;
    L44:
        Integer r17 = h(r6.getOriginHeight());
        if (r17 != null) goto L49;
        r17 = h(r6.getHeight());
        if (r17 != null) goto L49;
        int r19 = 0;
    L51:
        LinkedHashMap r20 = new LinkedHashMap();
        String r21 = r6.getMainSiteUrl();
        if (r21 != null) goto L54;
    L59:
        SourceType r22 = SourceType.BOT_RESP;
        String r23 = r43 + '_' + r41 + '_' + r3;
        String r24 = r6.getOriginThumbUrl();
        if (r24 != null) goto L62;
    L68:
        String r25 = r6.getThumbUrl();
        if (r25 != null) goto L71;
    L73:
        if (r8 != null) goto L75;
        String r110 = r12;
    L76:
        xy8.b r26 = new xy8.b(r12, r110, null, null, null, false, null, r18, r19, 252);
        GalleryType r27 = GalleryType.Image;
        Map r28 = MapsKt.toMutableMap(d(r40, true));
        String r29 = r6.getDocId();
        if (r29 == null) goto L79;
        r28.put("doc_id", r29);
    L79:
        Integer r30 = h(r6.getOriginWidth());
        if (r30 != null) goto L82;
        r30 = h(r6.getWidth());
    L82:
        Integer r111 = h(r6.getOriginHeight());
        if (r111 != null) goto L85;
        r111 = h(r6.getHeight());
    L85:
        if (r30 == null) goto L88;
        if (r111 == null) goto L88;
        StringBuilder r31 = new StringBuilder();
        r31.append(r30);
        r31.append(',');
        r31.append(r111);
        r28.put("image_resolution", r31.toString());
    L88:
        r0.add(new xy8.d(r22, r23, r26, null, r27, r28, null, r40.getCreateTime(), null, r20, null, null, null, null, r40, null, r0.size() + 1, 48456));
        goto L90
    L75:
        r110 = r8;
        goto L76
    L71:
        if ((!StringsKt.isBlank(r25)) == false) goto L73;
        r8 = r25;
        goto L73
    L62:
        if ((!StringsKt.isBlank(r24)) == true) goto L65;
        r24 = null;
    L65:
        if (r24 == null) goto L68;
        r110 = r24;
        goto L76
    L54:
        if ((!StringsKt.isBlank(r21)) == true) goto L57;
        r21 = null;
    L57:
        if (r21 == null) goto L59;
        r20.put("source_url", r21);
    L49:
        r19 = r17.intValue();
    L42:
        r18 = r16.intValue();
    L90:
        r3 = r5;
        goto L4
    L32:
        if (r12.length() == 0) goto L35;
        r13 = false;
        goto L36
    L16:
        r10 = null;
    L19:
        String r32 = r6.getOriginThumbUrl();
        if (r32 != null) goto L22;
        r11 = null;
    L27:
        if (r11 != null) goto L29;
        r11 = r6.getThumbUrl();
        goto L29
    L22:
        if ((!StringsKt.isBlank(r32)) == true) goto L25;
        r32 = null;
    L25:
        r11 = r32;
        goto L27
    L91:
        return r0;
    }

    public static List p(Message r84, SourceType r85, int r86, List r87) {
        String r0 = r84.getMessageId();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r11 = r0;
        boolean r27 = ap8.a.c(r84);
        ArrayList r8 = new ArrayList();
        Iterator r28 = r87.iterator();
    L7:
        if (r28.hasNext() == false) goto L337;
        IndexedValue r1 = (IndexedValue) r28.next();
        int r9 = r1.component1();
        CreationItem r6 = (CreationItem) r1.component2();
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("transformCreationBlock: itemIndex=");
        r3.append(r9);
        r3.append(", type=");
        r3.append(r6.type);
        r3.append(", hasImage=");
        if (r6.image == null) goto L11;
        boolean r4 = true;
    L12:
        r3.append(r4);
        r3.append(", imageStatus=");
        ImageData r5 = r6.image;
        if (r5 == null) goto L15;
        Integer r7 = r5.status;
    L16:
        r3.append(r7);
        r3.append(", hasVideo=");
        if (r6.video == null) goto L19;
        boolean r10 = true;
    L20:
        r3.append(r10);
        r3.append(", videoStatus=");
        VideoData r12 = r6.video;
        if (r12 == null) goto L23;
        Integer r13 = r12.status;
    L24:
        r3.append(r13);
        r3.append(", videoVid=");
        VideoData r14 = r6.video;
        if (r14 == null) goto L27;
        String r15 = r14.vid;
    L28:
        r3.append(r15);
        r2.d("PreviewMessageTransformer", r3.toString());
        ImageData r16 = r6.image;
        String r17 = "creation_";
        if (r16 == null) goto L203;
        Integer r18 = r16.status;
        if (r18 != null) goto L34;
        r17 = "creation_";
        CreationItem r19 = r6;
        r8 = r8;
        r9 = r9;
        r11 = r11;
        nr9.f r20 = null;
    L205:
        VideoData r21 = r19.video;
        if (r21 == null) goto L334;
        Integer r22 = r21.status;
        if (r22 == null) goto L334;
        if (r22.intValue() != 3) goto L334;
        String r23 = r21.vid;
        if (r23 != null) goto L215;
    L218:
        boolean r24 = true;
    L219:
        if (r24 == true) goto L334;
        String r110 = r19.id;
        UserCreationFromIM r25 = IUgcAIGCService.a.I(r84, r110, String.valueOf(r9));
        Cover r26 = r21.cover;
        if (r26 == null) goto L228;
        ImageObj r29 = r26.imagePreview;
        if (r29 == null) goto L228;
        nr9.f r30 = r29.url;
        if (r30 == null) goto L228;
    L232:
        nr9.f r31 = r30;
    L234:
        String r32 = r21.videoModel;
        String r33 = r21.downloadUrl;
        String r34 = r21.downloadFilehash;
        Double r111 = r21.duration;
        String r112 = r21.videoType;
        v r113 = a;
        if (r26 == null) goto L239;
        ImageObj r35 = r26.imageThumb;
        if (r35 == null) goto L239;
        nr9.f r36 = r35.url;
    L240:
        r113.getClass();
        if (r31 != null) goto L243;
    L250:
        if (r36 != null) goto L252;
    L257:
        nr9.f r114 = r20;
    L258:
        if (r114 != null) goto L260;
        nr9.f r37 = r20;
    L274:
        nr9.g r38 = new nr9.g(r23, r32, r33, r34, r111, r112, r37, null, null, null, 896);
        IAIChatUgcAIGCService.Companion r39 = IAIChatUgcAIGCService.a;
        Cover r40 = r21.cover;
        if (r40 == null) goto L277;
        nr9.f r115 = r40.key;
    L278:
        nr9.g r41 = r39.D0(r23, r38, r115);
        if (r41 == null) goto L282;
        r38 = r41;
    L282:
        if (r25 == null) goto L287;
        Integer r42 = r25.getCreationType();
        if (r42 == null) goto L287;
    L286:
        Integer r116 = r42;
        StringBuilder r43 = new StringBuilder(r17);
        String r117 = r11;
        r43.append(r117);
        r43.append('_');
        r43.append(r86);
        r43.append('_');
        int r44 = r9;
        r43.append(r44);
        String r210 = r43.toString();
        Long r45 = r21.width;
        if (r45 == null) goto L295;
        int r46 = (int) r45.longValue();
    L296:
        Long r47 = r21.height;
        if (r47 == null) goto L299;
        int r48 = (int) r47.longValue();
    L300:
        Double r49 = r21.duration;
        if (r49 == null) goto L303;
        double r50 = r49.doubleValue();
    L304:
        xy8.g r211 = m(r38, r23, r31, r46, r48, r50, "");
        GalleryType r212 = GalleryType.Video;
        Map r213 = d(r84, false);
        long r214 = r84.getCreateTime();
        if (r25 == null) goto L307;
        nr9.f r51 = r25.getCreationId();
    L308:
        String r52 = String.valueOf(r44);
        if (r25 == null) goto L311;
        nr9.f r53 = r25.getMaterialId();
    L312:
        if (r25 == null) goto L317;
        nr9.f r54 = r25.getPrompt();
        if (r54 == null) goto L317;
        nr9.f r118 = r54;
    L321:
        if (r25 == null) goto L323;
        nr9.f r55 = r25.getRefContent();
    L324:
        if (r25 == null) goto L332;
        Integer r56 = r25.getPrivateStatus();
        if (r56 == null) goto L332;
        if (r56.intValue() != 1) goto L332;
        boolean r57 = true;
    L333:
        String r215 = r117;
        xy8.d r58 = new xy8.d(r85, r210, null, r211, r212, r213, null, r214, null, null, null, null, new xy8.e(r51, r116, r215, r55, r110, r52, r53, r116, r118, true, r57), null, r84, null, r8.size() + 1, 44868);
        ArrayList r59 = r8;
        r59.add(r58);
    L335:
        r8 = r59;
        r11 = r215;
    L332:
        r57 = false;
        goto L333
    L323:
        r55 = r20;
    L317:
        CreationGenDetail r60 = r19.genDetail;
        if (r60 == null) goto L320;
        r118 = r60.creationPrompt;
        goto L321
    L320:
        r118 = r20;
        goto L321
    L311:
        r53 = r20;
        goto L312
    L307:
        r51 = r20;
        goto L308
    L303:
        r50 = 0.0d;
        goto L304
    L299:
        r48 = 0;
        goto L300
    L295:
        r46 = 0;
    L287:
        CreationGenDetail r61 = r19.genDetail;
        if (r61 == null) goto L290;
        nr9.f r119 = r61.taskType;
    L291:
        r42 = e(r119);
        goto L286
    L290:
        r119 = r20;
        goto L291
    L277:
        r115 = r20;
    L260:
        nr9.f r310 = r114;
        if (r36 != null) goto L263;
    L272:
        nr9.f r311 = r310;
    L273:
        r37 = new nr9.f(r311, r310, null, null, null, null, 60);
        goto L274
    L263:
        if (r36.length() <= 0) goto L265;
        boolean r120 = true;
    L266:
        if (r120 == true) goto L269;
        r36 = r20;
    L269:
        if (r36 == null) goto L272;
        r311 = r36;
        goto L273
    L265:
        r120 = false;
        goto L266
    L252:
        if (r36.length() <= 0) goto L254;
        boolean r121 = true;
    L255:
        if (r121 == false) goto L257;
        r114 = r36;
        goto L258
    L254:
        r121 = false;
        goto L255
    L243:
        if (r31.length() <= 0) goto L245;
        boolean r122 = true;
    L246:
        if (r122 == false) goto L248;
        r114 = r31;
    L249:
        if (r114 != null) goto L260;
    L248:
        r114 = r20;
        goto L249
    L245:
        r122 = false;
    L239:
        r36 = r20;
    L228:
        if (r26 == null) goto L233;
        ImageObj r62 = r26.imageThumb;
        if (r62 == null) goto L233;
        r30 = r62.url;
    L233:
        r31 = r20;
        goto L234
    L215:
        if (r23.length() == 0) goto L218;
        r24 = false;
    L334:
        r59 = r8;
        r215 = r11;
        goto L335
    L34:
        if (r18.intValue() != 2) goto L203;
        if (z2.a.enableBlockImagePreviewResize() == false) goto L40;
        ImageObj r123 = r16.imagePreviewResize;
        if (r123 != null) goto L41;
        r123 = r16.imagePreview;
    L41:
        String r124 = r16.imageUri;
        if (r124 != null) goto L44;
        r124 = r16.key;
    L44:
        a.getClass();
        String r125 = j(r123);
        if (r125 != null) goto L47;
        r125 = j(r16.imageThumb);
    L47:
        String r126 = r125;
        ImageObj r127 = r16.imageOrigin;
        if (r127 == null) goto L50;
        String r128 = r127.url;
    L51:
        ImageObj r129 = r16.imageOriRaw;
        if (r129 == null) goto L54;
        String r130 = r129.url;
    L55:
        if (r27 == true) goto L64;
        CreationGenDetail r131 = r6.genDetail;
        if (r131 == null) goto L64;
        List r132 = r131.refImages;
        if (r132 == null) goto L64;
        ImageObj r133 = (ImageObj) CollectionsKt.firstOrNull(r132);
        if (r133 == null) goto L64;
        String r216 = r133.url;
    L65:
        ImageObj r134 = r16.imageOrigin;
        if (r134 == null) goto L68;
        Long r217 = Long.valueOf(r134.width);
    L69:
        ImageObj r63 = r16.imageOrigin;
        if (r63 == null) goto L72;
        Long r218 = Long.valueOf(r63.height);
    L73:
        com.larus.bmhome.bigimg.n1 r135 = new com.larus.bmhome.bigimg.n1(r126, r128, r130, r216, r217, r218);
        CreationNoWatermarkManager r64 = CreationNoWatermarkManager.a;
        r64.getClass();
        Intrinsics.checkNotNullParameter(r135, "original");
        CreationNoWatermarkManager.d r65 = r64.V(r124, r135, false);
        com.larus.bmhome.bigimg.n1 r66 = (com.larus.bmhome.bigimg.n1) r65.a;
        String r136 = r66.a;
        if (r136 != null) goto L78;
        r136 = r66.c;
        if (r136 != null) goto L78;
        r136 = r66.d;
    L78:
        String r137 = r136;
        if (r137 != null) goto L81;
    L84:
        boolean r138 = true;
    L85:
        if (r138 == true) goto L203;
        LinkedHashMap r139 = new LinkedHashMap();
        ImageObj r140 = r16.imageOrigin;
        if (r140 == null) goto L89;
        String r141 = r140.url;
    L90:
        if (r141 == null) goto L92;
        r139.put("share_download_url", r141);
    L92:
        ImageObj r67 = r16.imageOriRaw;
        if (r67 == null) goto L95;
        String r68 = r67.url;
    L96:
        if (r68 == null) goto L98;
        r139.put("share_raw_url", r68);
    L98:
        if (r27 == true) goto L108;
        CreationGenDetail r69 = r6.genDetail;
        if (r69 == null) goto L108;
        List r70 = r69.refImages;
        if (r70 == null) goto L108;
        ImageObj r71 = (ImageObj) CollectionsKt.firstOrNull(r70);
        if (r71 == null) goto L108;
        String r72 = r71.url;
        if (r72 == null) goto L108;
        r139.put("share_ref_url", r72);
    L108:
        if (r27 == false) goto L110;
        r139.put("share_disable_puzzle", "true");
    L110:
        String r73 = r6.id;
        if (r73 == null) goto L113;
        r139.put("watermark_item_id", r73);
    L113:
        ImageObj r74 = r16.imageOriRaw;
        if (r74 == null) goto L116;
        String r75 = r74.url;
    L117:
        if (r75 == null) goto L119;
        r139.put("watermark_image_uri", r75);
    L119:
        Map r76 = MapsKt.toMutableMap(r139);
        String r142 = r66.a;
        if (r142 == null) goto L122;
        r76.put("share_preview_url", r142);
    L122:
        String r143 = r6.id;
        IUgcAIGCService.Companion r144 = IUgcAIGCService.a;
        UserCreationFromIM r77 = r144.I(r84, r143, String.valueOf(r9));
        Map r312 = r144.L(r77, r143);
        if (r77 == null) goto L128;
        Integer r145 = r77.getCreationType();
        if (r145 == null) goto L128;
    L127:
        Integer r313 = r145;
        String r314 = "creation_" + r11 + '_' + r86 + '_' + r9;
        if (r65.b == false) goto L136;
        String r146 = null;
    L137:
        if (r146 != null) goto L141;
        r146 = r66.a;
        if (r146 != null) goto L141;
        String r147 = r137;
    L142:
        String r148 = r66.c;
        String r78 = r66.d;
        Boolean r410 = Boolean.TRUE;
        boolean r79 = r65.b;
        Long r80 = r66.f;
        if (r80 == null) goto L146;
        String r510 = r143;
        String r511 = r11;
        int r81 = (int) r80.longValue();
    L145:
        int r219 = r81;
    L150:
        Long r82 = r66.g;
        if (r82 == null) goto L153;
        int r83 = (int) r82.longValue();
    L156:
        int r220 = r83;
    L158:
        xy8.b r315 = new xy8.b(r137, r147, r148, r78, r410, r79, r124, r219, r220, 64);
        GalleryType r88 = GalleryType.Image;
        Map r149 = d(r84, true);
        long r512 = r84.getCreateTime();
        ImageObj r89 = r16.imageOriRaw;
        if (r89 != null) goto L161;
        r89 = r16.imageOrigin;
    L161:
        StringBuilder r90 = new StringBuilder("buildCreationSendMetadata: messageId=");
        r90.append(r84.getMessageId());
        r90.append(", imageOrigin=");
        ImageObj r91 = r16.imageOrigin;
        if (r91 == null) goto L164;
        String r92 = r91.url;
    L165:
        r90.append(r92);
        r90.append(", imageOriRaw=");
        ImageObj r93 = r16.imageOriRaw;
        if (r93 == null) goto L168;
        String r94 = r93.url;
    L169:
        r90.append(r94);
        r90.append(", imageOri=");
        if (r89 == null) goto L172;
        String r95 = r89.url;
    L173:
        r90.append(r95);
        r2.d("PreviewMessageTransformer", r90.toString());
        Image r96 = new Image(r16.key, null, r16.imageThumb, r89, null, null, null, null, r16.imagePreview, null, r410, null, null, null, 15090, null);
        String r150 = UUID.randomUUID().toString();
        String r151 = r84.getMessageId();
        int r152 = r84.getContentType();
        UpLinkState r97 = UpLinkState.SUCCESS;
        Integer r153 = Integer.valueOf(r97.getValue());
        int r98 = UplinkEntityType.EntityTypeImage.getValue();
        int r99 = r97.getValue();
        int r100 = FileParseState.SUCCESS.getValue();
        int r101 = FileReviewState.ACCESS.getValue();
        xy8.f r316 = new xy8.f(r151, r152, r153, null, r150, CollectionsKt.listOf(new UplinkFileEntity(Integer.valueOf(r98), new UplinkEntityContent(null, r96, 1, null), r150, null, Integer.valueOf(r101), Integer.valueOf(r100), 100, Integer.valueOf(r99), null, false, null, null, null, null, 16136, null)));
        if (r77 == null) goto L176;
        String r154 = r77.getCreationId();
    L177:
        String r221 = String.valueOf(r9);
        if (r77 == null) goto L180;
        String r222 = r77.getMaterialId();
    L181:
        if (r77 == null) goto L184;
        String r102 = r77.getPrompt();
        if (r102 == null) goto L184;
    L187:
        String r223 = r102;
    L189:
        if (r77 == null) goto L191;
        String r155 = r77.getRefContent();
    L192:
        if (r77 == null) goto L199;
        Integer r103 = r77.getPrivateStatus();
        if (r103 == null) goto L199;
        if (r103.intValue() != 1) goto L199;
        boolean r224 = true;
    L200:
        r20 = null;
        r17 = "creation_";
        r6 = r6;
        r9 = r9;
        r11 = r511;
        r8 = r8;
        r8.add(new xy8.d(r85, r314, r315, null, r88, r149, null, r512, null, r76, r312, r316, new xy8.e(r154, r313, r511, r155, r510, r221, r222, r313, r223, true, r224), null, r84, null, r8.size() + 1, 41288));
    L204:
        r19 = r6;
    L199:
        r224 = false;
        goto L200
    L191:
        r155 = null;
    L184:
        CreationGenDetail r104 = r6.genDetail;
        if (r104 == null) goto L188;
        r102 = r104.creationPrompt;
        goto L187
    L188:
        r223 = null;
        goto L189
    L180:
        r222 = null;
        goto L181
    L176:
        r154 = null;
        goto L177
    L172:
        r95 = null;
        goto L173
    L168:
        r94 = null;
        goto L169
    L164:
        r92 = null;
        goto L165
    L153:
        ImageObj r105 = r16.imageOrigin;
        if (r105 == null) goto L157;
        r83 = r105.height;
        goto L156
    L157:
        r220 = 0;
        goto L158
    L146:
        r510 = r143;
        r511 = r11;
        ImageObj r106 = r16.imageOrigin;
        if (r106 == null) goto L149;
        r81 = r106.width;
        goto L145
    L149:
        r219 = 0;
    L141:
        r147 = r146;
        goto L142
    L136:
        r146 = j(r16.imageThumb);
    L128:
        CreationGenDetail r156 = r6.genDetail;
        if (r156 == null) goto L131;
        Integer r157 = r156.taskType;
    L132:
        r145 = e(r157);
        goto L127
    L131:
        r157 = null;
        goto L132
    L116:
        r75 = null;
        goto L117
    L95:
        r68 = null;
        goto L96
    L89:
        r141 = null;
        goto L90
    L81:
        if (r137.length() == 0) goto L84;
        r138 = false;
        goto L85
    L72:
        r218 = null;
        goto L73
    L68:
        r217 = null;
    L64:
        r216 = null;
        goto L65
    L54:
        r130 = null;
        goto L55
    L50:
        r128 = null;
        goto L51
    L40:
        r123 = r16.imagePreview;
    L203:
        r20 = null;
        goto L204
    L27:
        r15 = null;
        goto L28
    L23:
        r13 = null;
        goto L24
    L19:
        r10 = false;
        goto L20
    L15:
        r7 = null;
        goto L16
    L11:
        r4 = false;
        goto L12
    L337:
        return r8;
    }

    public static Map a(Message r19, RichMediaItem r20, int r21, int r22, String r23) {
        Pair[] r1 = new Pair[11];
        String r2 = r19.getMessageId();
        String r3 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1[0] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r2);
        r1[1] = TuplesKt.to("card_position", Integer.valueOf(r21));
        r1[2] = TuplesKt.to("card_sub_position", Integer.valueOf(r22));
        String r4 = r19.getReplyId();
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        r1[3] = TuplesKt.to("reply_id", r4);
        r1[4] = TuplesKt.to("module_source", "slideshow");
        r1[5] = TuplesKt.to("image_resolution", "");
        String r7 = r19.getReplyId();
        if (r7 != null) goto L11;
        r7 = "";
    L11:
        r1[6] = TuplesKt.to("chat_id", r7);
        Map r8 = com.larus.im.bean.message.a.U(r19);
        Set r9 = c2.a;
        if (r8 == null) goto L18;
        String r10 = (String) r8.get("agent_mode");
        if (r10 == null) goto L18;
        Integer r11 = StringsKt.toIntOrNull(r10);
        if (r11 == null) goto L18;
        int r12 = r11.intValue();
    L19:
        r1[7] = TuplesKt.to("agent_mode", Integer.valueOf(r12));
        if (r23 != null) goto L22;
        String r13 = "";
    L23:
        r1[8] = TuplesKt.to("card_group_id", r13);
        r1[9] = TuplesKt.to("doc_id", "");
        r1[10] = TuplesKt.to("ai_create_show_mode", tz9.a.a(r19));
        Map r5 = MapsKt.mutableMapOf(r1);
        String r14 = l(r19);
        if (r14 == null) goto L26;
        r5.put("req_id", r14);
    L26:
        Integer r15 = r20.type;
        int r16 = RichMediaType.SEARCH_IMAGE.getValue();
        String r17 = null;
        if (r15 != null) goto L30;
    L125:
        int r6 = RichMediaType.GENERIC_IMAGE.getValue();
        if (r15 != null) goto L129;
    L160:
        int r18 = RichMediaType.GENERIC_VIDEO.getValue();
        if (r15 != null) goto L164;
    L195:
        int r24 = RichMediaType.CREATION.getValue();
        if (r15 != null) goto L199;
    L259:
        return r5;
    L199:
        if (r15.intValue() != r24) goto L259;
        CreationItem r0 = r20.creation;
        if (r0 == null) goto L259;
        Integer r25 = r0.type;
        if (r25 != null) goto L206;
    L240:
        if (r25 == null) goto L259;
        if (r25.intValue() != 2) goto L259;
        String r26 = r0.id;
        if (r26 != null) goto L258;
        VideoData r27 = r0.video;
        if (r27 == null) goto L249;
        r26 = r27.vid;
    L250:
        if (r26 != null) goto L258;
        if (r27 == null) goto L255;
        Cover r28 = r27.cover;
        if (r28 == null) goto L255;
        r17 = r28.key;
    L255:
        if (r17 != null) goto L257;
        StringBuilder r29 = new StringBuilder("creation-video-");
        r29.append(r22 - 1);
        r26 = r29.toString();
        goto L258
    L257:
        r26 = r17;
        goto L258
    L249:
        r26 = null;
    L258:
        r5.put("card_id", r26);
        r5.put("card_source", "generate");
        r5.put("card_type", "video");
        goto L259
    L206:
        if (r25.intValue() != 1) goto L240;
        String r30 = r0.id;
        if (r30 != null) goto L215;
        ImageData r31 = r0.image;
        if (r31 == null) goto L212;
        r17 = r31.key;
    L212:
        if (r17 != null) goto L214;
        StringBuilder r32 = new StringBuilder("creation-image-");
        r32.append(r22 - 1);
        r30 = r32.toString();
        goto L215
    L214:
        r30 = r17;
    L215:
        r5.put("card_id", r30);
        r5.put("card_source", "generate");
        r5.put("card_type", "picture");
        ImageData r33 = r0.image;
        if (r33 == null) goto L220;
        ImageObj r34 = r33.imageOrigin;
        if (r34 == null) goto L220;
        int r35 = r34.width;
    L227:
        ImageData r36 = r0.image;
        if (r36 == null) goto L232;
        ImageObj r37 = r36.imageOrigin;
        if (r37 == null) goto L232;
        int r38 = r37.height;
    L239:
        StringBuilder r39 = new StringBuilder();
        r39.append(r35);
        r39.append(',');
        r39.append(r38);
        r5.put("image_resolution", r39.toString());
    L232:
        if (r36 == null) goto L238;
        ImagePlaceHolder r40 = r36.placeholder;
        if (r40 == null) goto L238;
        Long r41 = r40.height;
        if (r41 == null) goto L238;
        r38 = (int) r41.longValue();
    L238:
        r38 = 0;
    L220:
        if (r33 == null) goto L226;
        ImagePlaceHolder r42 = r33.placeholder;
        if (r42 == null) goto L226;
        Long r43 = r42.width;
        if (r43 == null) goto L226;
        r35 = (int) r43.longValue();
    L226:
        r35 = 0;
        goto L227
    L164:
        if (r15.intValue() != r18) goto L195;
        GenericVideoItem r44 = r20.videoItem;
        if (r44 == null) goto L259;
        if (r44.type == MediaType.MediaTypeLocalFile.getValue()) goto L170;
        boolean r110 = true;
    L171:
        if (r110 == true) goto L174;
        r44 = null;
    L174:
        if (r44 == null) goto L259;
        String r45 = r44.id;
        if (r45 != null) goto L180;
        r45 = r44.uri;
        if (r45 != null) goto L180;
        StringBuilder r46 = new StringBuilder("generic-image-");
        r46.append(r22 - 1);
        r45 = r46.toString();
    L180:
        r5.put("card_id", r45);
        r5.put("card_source", "search");
        Map r47 = r44.extra;
        if (r47 == null) goto L183;
        r17 = (String) r47.get("doc_id");
    L183:
        if (r17 == null) goto L186;
        r3 = r17;
    L186:
        r5.put("doc_id", r3);
        r5.put("card_type", "video");
        StringBuilder r48 = new StringBuilder();
        Integer r49 = r44.width;
        if (r49 == null) goto L189;
        int r50 = r49.intValue();
    L190:
        r48.append(r50);
        r48.append(',');
        Integer r51 = r44.height;
        if (r51 == null) goto L193;
        int r52 = r51.intValue();
    L194:
        r48.append(r52);
        r5.put("image_resolution", r48.toString());
        goto L259
    L193:
        r52 = 0;
        goto L194
    L189:
        r50 = 0;
        goto L190
    L170:
        r110 = false;
        goto L171
    L129:
        if (r15.intValue() != r6) goto L160;
        GenericImageItem r53 = r20.imageItem;
        if (r53 == null) goto L259;
        if (r53.type == MediaType.MediaTypeLocalFile.getValue()) goto L135;
        boolean r111 = true;
    L136:
        if (r111 == true) goto L139;
        r53 = null;
    L139:
        if (r53 == null) goto L259;
        String r54 = r53.id;
        if (r54 != null) goto L145;
        r54 = r53.uri;
        if (r54 != null) goto L145;
        StringBuilder r55 = new StringBuilder("generic-image-");
        r55.append(r22 - 1);
        r54 = r55.toString();
    L145:
        r5.put("card_id", r54);
        r5.put("card_source", "search");
        Map r56 = r53.extra;
        if (r56 == null) goto L148;
        r17 = (String) r56.get("doc_id");
    L148:
        if (r17 == null) goto L151;
        r3 = r17;
    L151:
        r5.put("doc_id", r3);
        r5.put("card_type", "picture");
        StringBuilder r57 = new StringBuilder();
        Integer r58 = r53.width;
        if (r58 == null) goto L154;
        int r59 = r58.intValue();
    L155:
        r57.append(r59);
        r57.append(',');
        Integer r60 = r53.height;
        if (r60 == null) goto L158;
        int r61 = r60.intValue();
    L159:
        r57.append(r61);
        r5.put("image_resolution", r57.toString());
        goto L259
    L158:
        r61 = 0;
        goto L159
    L154:
        r59 = 0;
        goto L155
    L135:
        r111 = false;
        goto L136
    L30:
        if (r15.intValue() != r16) goto L125;
        SearchImageItem r62 = r20.image;
        if (r62 == null) goto L259;
        a.getClass();
        Map r63 = r19.getExt();
        if (r63 == null) goto L38;
        String r64 = (String) r63.get("rich_media_type");
        if (r64 == null) goto L38;
    L72:
        r5.put("rich_media_type", r64);
        String r65 = r62.docId;
        if (r65 != null) goto L75;
        r65 = "";
    L75:
        r5.put("doc_id", r65);
        String r66 = r62.originThumbUrl;
        if (r66 != null) goto L78;
    L86:
        r66 = r62.thumbUrl;
        if (r66 != null) goto L89;
    L94:
        r66 = null;
    L95:
        if (r66 != null) goto L102;
        List r67 = r62.fullSizeUrl;
        if (r67 == null) goto L99;
        r17 = (String) CollectionsKt.firstOrNull(r67);
    L99:
        if (r17 == null) goto L103;
        r3 = r17;
    L103:
        Long r68 = r62.id;
        if (r68 == null) goto L107;
        String r69 = r68.toString();
        if (r69 == null) goto L107;
    L110:
        r5.put("card_id", r69);
        r5.put("card_source", "search");
        r5.put("card_type", "picture");
        v r70 = a;
        Integer r71 = r62.originWidth;
        r70.getClass();
        Integer r72 = h(r71);
        if (r72 != null) goto L115;
        r72 = h(r62.width);
        if (r72 != null) goto L115;
        int r73 = 0;
    L117:
        Integer r74 = h(r62.originHeight);
        if (r74 == null) goto L120;
        int r75 = r74.intValue();
    L124:
        StringBuilder r76 = new StringBuilder();
        r76.append(r73);
        r76.append(',');
        r76.append(r75);
        r5.put("image_resolution", r76.toString());
        goto L259
    L120:
        Integer r77 = h(r62.height);
        if (r77 == null) goto L123;
        r75 = r77.intValue();
        goto L124
    L123:
        r75 = 0;
    L115:
        r73 = r72.intValue();
    L107:
        r69 = r62.itemId;
        if (r69 != null) goto L110;
        StringBuilder r78 = new StringBuilder("search-image-");
        r78.append(r22 - 1);
        r78.append('-');
        r78.append(r3);
        r69 = r78.toString();
    L102:
        r3 = r66;
        goto L103
    L89:
        if (r66.length() <= 0) goto L91;
        boolean r79 = true;
    L92:
        if (r79 == false) goto L94;
    L91:
        r79 = false;
        goto L92
    L78:
        if (r66.length() <= 0) goto L80;
        boolean r80 = true;
    L81:
        if (r80 == true) goto L84;
        r66 = null;
    L84:
        if (r66 == null) goto L86;
    L80:
        r80 = false;
    L38:
        Intrinsics.checkNotNullParameter(r19, "<this>");
        List r81 = vd9.r.a(r19);
        ArrayList r82 = new ArrayList();
        Iterator r83 = r81.iterator();
    L40:
        if (r83.hasNext() == false) goto L52;
        Block r84 = (Block) r83.next();
        BlockContent r112 = r84.getContent();
        if (r112 == null) goto L44;
        RichMediaLayoutBlock r113 = r112.getRichMediaLayoutBlock();
    L46:
        if (r84.getBlockType() != BlockType.BLOCK_TYPE_RICH_MEDIA_LAYOUT.getValue()) goto L49;
        if (r113 == null) goto L49;
        List r85 = r113.richMediaItem;
    L50:
        CollectionsKt.addAll(r82, r85);
    L49:
        r85 = CollectionsKt.emptyList();
        goto L50
    L44:
        r113 = null;
        goto L46
    L52:
        if ((!r82.isEmpty()) == true) goto L54;
    L71:
        r64 = "mixed_picture";
        goto L72
    L54:
        if (r82.isEmpty() == true) goto L68;
        Iterator r86 = r82.iterator();
    L58:
        if (r86.hasNext() == false) goto L68;
        Integer r87 = ((RichMediaItem) r86.next()).type;
        int r88 = RichMediaType.SEARCH_IMAGE.getValue();
        if (r87 != null) goto L63;
    L65:
        boolean r89 = false;
    L66:
        if (r89 == true) goto L58;
        boolean r90 = false;
    L69:
        if (r90 == false) goto L71;
        r64 = "only_picture";
        goto L72
    L63:
        if (r87.intValue() != r88) goto L65;
        r89 = true;
    L68:
        r90 = true;
        goto L69
    L22:
        r13 = r23;
    L18:
        r12 = 0;
        goto L19
    }

    public static xy8.g m(nr9.g r23, String r24, String r25, int r26, int r27, double r28, String r30) {
        String r1 = r23.a;
        boolean r2 = false;
        Bitmap r4 = null;
        if (r1 != null) goto L5;
    L14:
        String r6 = r24;
    L15:
        String r7 = r23.c;
        String r8 = r23.d;
        nr9.f r3 = r23.g;
        if (r3 == null) goto L27;
        String r5 = r3.a;
        if (r5 == null) goto L27;
        if (r5.length() <= 0) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == true) goto L26;
        r5 = null;
    L26:
        if (r5 == null) goto L27;
    L39:
        String r10 = r5;
    L40:
        nr9.f r11 = r23.g;
        String r12 = r23.h;
        String r13 = r23.b;
        String r14 = r23.f;
        String r15 = r23.i;
        Double r16 = r23.e;
        if (r16 == null) goto L43;
        double r17 = r16.doubleValue();
    L44:
        nr9.f r0 = r23.g;
        if (r0 == null) goto L48;
        r4 = r0.f;
    L48:
        return new xy8.g(r6, r7, r8, r10, r11, r12, r13, r14, r15, r26, r27, r17, r4, r30, null, 36864);
    L43:
        r17 = r28;
        goto L44
    L22:
        r9 = false;
    L27:
        nr9.f r18 = r23.g;
        if (r18 == null) goto L36;
        r5 = r18.b;
        if (r5 == null) goto L36;
        if (r5.length() <= 0) goto L34;
        r2 = true;
    L34:
        if (r2 == false) goto L36;
    L37:
        if (r5 != null) goto L39;
        r10 = r25;
    L36:
        r5 = null;
        goto L37
    L5:
        if (r1.length() <= 0) goto L7;
        boolean r19 = true;
    L8:
        if (r19 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L14;
        r6 = r1;
        goto L15
    L7:
        r19 = false;
        goto L8
    }
}
