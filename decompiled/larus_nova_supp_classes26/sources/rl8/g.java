package rl8;

import android.os.Build;
import android.text.Html;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.larus.im.bean.IMMetaInfo;
import com.larus.im.bean.message.ContainerAttribute;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.RichMediaMeta;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.im.bean.message.TagEnum;
import com.larus.im.bean.message.TextTagInfo;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.SearchImageItem;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import vd9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
    public static final ConcurrentHashMap<String, WeakReference<Message>> a = null;

    static {
        a = new ConcurrentHashMap();
    }

    public static com.larus.bmhome.chat.markdown.imagegroup.a a(com.larus.bmhome.chat.markdown.imagegroup.a r4) {
        List r0 = r4.c();
        if (Intrinsics.areEqual(r4.d(), Boolean.TRUE) == false) goto L16;
        List r1 = r0;
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        return r4;
    L13:
        if (r0.size() < 3) goto L15;
        return r4;
    L15:
        return com.larus.bmhome.chat.markdown.imagegroup.a.a(r4, CollectionsKt.listOf(ListProtector.get(r0, 0)));
    L7:
        if (r1.isEmpty() == true) goto L10;
        r2 = false;
        goto L11
    L16:
        return r4;
    }

    public static String b(String r13) {
        if (r13 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L20;
        return r13;
    L20:
    L16:
        e = move-exception;
        FLogger.a.e("MainBotImagePreviewGroupHelper", "decodeHtmlEntities error, origin: " + r13 + ", [" + e + ']', e);
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(r13, "&quot;", "\"", false, 4, null), "&#34;", "\"", false, 4, null), "&amp;", "&", false, 4, null), "&#39;", "'", false, 4, null);
    L12:
        if (Build.VERSION.SDK_INT < 24) goto L14;
        String r0 = Html.fromHtml(r13, 0).toString();     // Catch: Exception -> L16
    L19:
        return r0;
    L14:
        r0 = Html.fromHtml(r13).toString();     // Catch: Exception -> L16
        goto L19
    L5:
        if (r13.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static List c(Message r12) {
        Intrinsics.checkNotNullParameter(r12, "message");
        ArrayList r0 = new ArrayList();
        if (com.larus.bmhome.chat.bean.d.j0(r12) == false) goto L5;
    L13:
        Intrinsics.checkNotNullParameter(r12, "<this>");
        List r1 = r.a(r12);
        if (r1.isEmpty() == false) goto L16;
        r1 = com.larus.im.bean.message.a.f(r12);
    L16:
        List r2 = r1;
        String r5 = "";
        if (r2.isEmpty() == false) goto L19;
        List r3 = CollectionsKt.emptyList();
    L37:
        r0.addAll(r3);
        if (r0.isEmpty() == false) goto L72;
        Iterator r4 = CollectionsKt.listOf(new String[]{com.larus.bmhome.chat.bean.d.m(r12, false), com.larus.bmhome.chat.bean.d.m(r12, true), com.larus.bmhome.chat.bean.d.s(r12)}).iterator();
    L41:
        if (r4.hasNext() == false) goto L52;
        Object r6 = r4.next();
        String r9 = (String) r6;
        if (r9 != null) goto L45;
    L48:
        boolean r10 = true;
    L50:
        if ((!r10) == false) goto L41;
    L53:
        String r7 = (String) r6;
        if (r7 == null) goto L58;
        r5 = r7;
    L58:
        if (r5.length() != 0) goto L60;
        boolean r8 = true;
    L61:
        if (r8 == false) goto L63;
        List r11 = CollectionsKt.emptyList();
    L70:
        r0.addAll(r11);
        goto L72
    L63:
        Regex r13 = new Regex("<data-[^>]+>");
        ArrayList r14 = new ArrayList();
        Iterator r15 = Regex.findAll$default(r13, r5, 0, 2, null).iterator();
    L65:
        if (r15.hasNext() == false) goto L69;
        com.larus.bmhome.chat.markdown.imagegroup.a r16 = d(r12, ((MatchResult) r15.next()).getValue(), false);
        if (r16 == null) goto L65;
        r14.add(r16);
        goto L65
    L69:
        r11 = r14;
        goto L70
    L60:
        r8 = false;
        goto L61
    L45:
        if (r9.length() == 0) goto L48;
        r10 = false;
        goto L50
    L52:
        r6 = null;
    L72:
        if (r0.isEmpty() == false) goto L122;
        ArrayList r17 = new ArrayList();
        List r18 = com.larus.bmhome.chat.bean.d.O(r12);
        if (r18 == null) goto L121;
        Iterator r19 = r18.iterator();
    L77:
        if (r19.hasNext() == false) goto L121;
        final TextTagInfo r20 = (TextTagInfo) r19.next();
        int r21 = r20.type;
        if (r21 == TagEnum.TagEnum_InsertText_APPLET.value) goto L80;
        if (r21 != TagEnum.TagEnum_InsertText_BLOCK.value) goto L77;
        wc8.b r22 = wc8.b.a;
        RichMediaMeta r23 = wc8.b.e(r20.tagInfo, new f(r20));
        if (r23 == null) goto L77;
        List r24 = r23.getMedia();
        if (r24 == null) goto L118;
        List r25 = r24;
        if ((r25 instanceof Collection) == true) goto L104;
    L106:
        Iterator r26 = r25.iterator();
    L108:
        if (r26.hasNext() == false) goto L115;
        if (((RichMediaItem) r26.next()).image == null) goto L112;
        boolean r27 = true;
    L113:
        if (r27 == false) goto L108;
        boolean r28 = true;
    L116:
        if (r28 != true) goto L118;
        boolean r29 = true;
    L119:
        if (r29 == false) goto L77;
        r17.add(a(e(r23)));
        goto L77
    L112:
        r27 = false;
    L115:
        r28 = false;
        goto L116
    L104:
        if (r25.isEmpty() == false) goto L106;
    L118:
        r29 = false;
        goto L119
    L80:
        wc8.b r30 = wc8.b.a;
        IMMetaInfo.InsertTextReference r31 = wc8.b.f(r20.tagInfo, new e(r20));
        if (r31 == null) goto L77;
        if (Intrinsics.areEqual(r31.getCardType(), "image-group") == false) goto L77;
        String r32 = r31.getValue();
        if (r32 != null) goto L123;
        r32 = "{}";
    L123:
        com.larus.bmhome.chat.markdown.imagegroup.a r33 = (com.larus.bmhome.chat.markdown.imagegroup.a) new Gson().fromJson(r32, com.larus.bmhome.chat.markdown.imagegroup.a.class);     // Catch: Exception -> L90
    L92:
        if (r33 == null) goto L77;
        r17.add(a(r33));
    L90:
        e = move-exception;
        FLogger.a.e("MainBotImagePreviewGroupHelper", "parseImageGroupFromTag error, valueStr: " + r32 + ", [" + e + ']', e);
        r33 = null;
    L121:
        r0.addAll(r17);
    L122:
        return r0;
    L19:
        Regex r34 = new Regex("<data-[^>]+>");
        ArrayList r35 = new ArrayList();
        Iterator r36 = r2.iterator();
    L21:
        if (r36.hasNext() == false) goto L36;
        String r110 = qf8.a.c((Block) r36.next(), r12, 2);
        if (r110 != null) goto L26;
        r110 = "";
    L26:
        if (r110.length() != 0) goto L28;
        boolean r111 = true;
    L29:
        if (r111 == true) goto L21;
        Iterator r112 = Regex.findAll$default(r34, r110, 0, 2, null).iterator();
    L32:
        if (r112.hasNext() == false) goto L21;
        com.larus.bmhome.chat.markdown.imagegroup.a r113 = d(r12, ((MatchResult) r112.next()).getValue(), true);
        if (r113 == null) goto L32;
        r35.add(r113);
        goto L32
    L28:
        r111 = false;
        goto L29
    L36:
        r3 = r35;
        goto L37
    L5:
        if (r12.getMessageId() == null) goto L13;
        WeakReference<Message> r37 = a.get(r12.getMessageId());
        if (r37 == null) goto L13;
        Message r38 = r37.get();
        if (r38 == null) goto L13;
        r12 = r38;
        goto L13
    }

    public static com.larus.bmhome.chat.markdown.imagegroup.a e(RichMediaMeta r31) {
        ContainerAttribute r0 = r31.getContainerAttribute();
        if (r0 == null) goto L7;
        Boolean r1 = r0.isTop();
        if (r1 == null) goto L7;
        boolean r2 = r1.booleanValue();
    L8:
        ContainerAttribute r3 = r31.getContainerAttribute();
        if (r3 == null) goto L11;
        Integer r4 = r3.getImageShowType();
    L12:
        ContainerAttribute r5 = r31.getContainerAttribute();
        if (r5 == null) goto L15;
        Integer r6 = r5.getImageShowTypeVersion();
    L16:
        List r7 = r31.getMedia();
        if (r7 == null) goto L82;
        List r8 = r7;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = r8.iterator();
    L20:
        if (r10.hasNext() == false) goto L81;
        RichMediaItem r11 = (RichMediaItem) r10.next();
        SearchImageItem r12 = r11.image;
        if (r12 == null) goto L24;
        Long r13 = r12.id;
    L25:
        if (r12 == null) goto L27;
        String r14 = r12.itemId;
    L28:
        if (r12 == null) goto L30;
        String r15 = r12.uri;
    L31:
        if (r12 == null) goto L33;
        String r16 = r12.thumbUrl;
    L34:
        if (r12 == null) goto L36;
        String r17 = r12.originThumbUrl;
    L37:
        if (r12 == null) goto L39;
        List r18 = r12.fullSizeUrl;
    L40:
        if (r12 == null) goto L42;
        String r19 = r12.mainSiteUrl;
    L43:
        if (r12 == null) goto L45;
        Integer r20 = r12.width;
    L46:
        if (r12 == null) goto L48;
        Integer r110 = r12.height;
    L49:
        if (r12 == null) goto L51;
        String r111 = r12.docId;
    L52:
        if (r12 == null) goto L54;
        String r112 = r12.authorShortId;
    L55:
        if (r12 == null) goto L59;
        Long r21 = r12.sourceFrom;
        if (r21 == null) goto L59;
        Integer r113 = Integer.valueOf((int) r21.longValue());
    L60:
        SearchImageItem r22 = r11.image;
        if (r22 == null) goto L63;
        String r23 = r22.sourceAppName;
    L64:
        if (r22 == null) goto L66;
        String r24 = r22.sourceAppIcon;
    L67:
        if (r22 == null) goto L69;
        String r25 = r22.imgCaption;
    L71:
        if (r22 == null) goto L73;
        Integer r26 = r22.originWidth;
    L74:
        if (r22 == null) goto L76;
        Integer r27 = r22.originHeight;
    L77:
        if (r22 == null) goto L79;
        String r28 = r22.imageSource;
    L80:
        r9.add(new SearchImageInfo(r13, r14, r15, r16, r17, r18, r19, r20, r110, r111, r112, r113, r23, r24, r25, null, r26, r27, r28, null, 557056, null));
        r10 = r10;
        r6 = r6;
        goto L20
    L79:
        r28 = null;
        goto L80
    L76:
        r27 = null;
        goto L77
    L73:
        r26 = null;
        goto L74
    L69:
        r25 = null;
        goto L71
    L66:
        r24 = null;
        goto L67
    L63:
        r23 = null;
    L59:
        r113 = null;
        goto L60
    L54:
        r112 = null;
        goto L55
    L51:
        r111 = null;
        goto L52
    L48:
        r110 = null;
        goto L49
    L45:
        r20 = null;
        goto L46
    L42:
        r19 = null;
        goto L43
    L39:
        r18 = null;
        goto L40
    L36:
        r17 = null;
        goto L37
    L33:
        r16 = null;
        goto L34
    L30:
        r15 = null;
        goto L31
    L27:
        r14 = null;
        goto L28
    L24:
        r13 = null;
        goto L25
    L81:
        Integer r30 = r6;
        ArrayList r29 = r9;
    L83:
        Integer r32 = r30;
        return new com.larus.bmhome.chat.markdown.imagegroup.a(r4, r29, r32, Boolean.valueOf(r2), 44);
    L82:
        r30 = r6;
        r29 = null;
        goto L83
    L15:
        r6 = null;
        goto L16
    L11:
        r4 = null;
    L7:
        r2 = false;
        goto L8
    }

    public static com.larus.bmhome.chat.markdown.imagegroup.a d(Message r8, String r9, boolean r10) {
        Regex r0 = new Regex("\\btype\\s*=\\s*\"([^\"]+)\"");
        Regex r1 = new Regex("\\bvalue_id\\s*=\\s*\"([^\"]+)\"");
        Regex r2 = new Regex("\\bvalue\\s*=\\s*\"([^\"]*)\"");
        boolean r3 = false;
        MatchResult r4 = Regex.find$default(r0, r9, 0, 2, null);
        if (r4 == null) goto L7;
        List r5 = r4.getGroupValues();
        if (r5 == null) goto L7;
        String r6 = (String) CollectionsKt.getOrNull(r5, 1);
    L8:
        if (r10 == true) goto L10;
    L12:
        MatchResult r11 = Regex.find$default(r1, r9, 0, 2, null);
        if (r11 == null) goto L17;
        List r12 = r11.getGroupValues();
        if (r12 == null) goto L17;
        String r13 = (String) CollectionsKt.getOrNull(r12, 1);
    L18:
        MatchResult r14 = Regex.find$default(r2, r9, 0, 2, null);
        if (r14 == null) goto L23;
        List r15 = r14.getGroupValues();
        if (r15 == null) goto L23;
        String r16 = (String) CollectionsKt.getOrNull(r15, 1);
    L24:
        if (r13 != null) goto L26;
    L29:
        boolean r7 = true;
    L31:
        if (r7 == true) goto L77;
        RichMediaMeta r17 = wc8.b.a.h(r8.getMessageId(), r13, "MainBotImagePreviewGroupHelper");
        if (r17 == null) goto L53;
        List r18 = r17.getMedia();
        if (r18 == null) goto L53;
        List r19 = r18;
        if ((r19 instanceof Collection) == true) goto L39;
    L41:
        Iterator r20 = r19.iterator();
    L43:
        if (r20.hasNext() == false) goto L50;
        if (((RichMediaItem) r20.next()).image == null) goto L47;
        boolean r21 = true;
    L48:
        if (r21 == false) goto L43;
        boolean r22 = true;
    L51:
        if (r22 != true) goto L53;
        boolean r23 = true;
    L54:
        if (r23 == false) goto L103;
        return a(e(r17));
    L103:
        String r24 = b(wc8.b.a.c(r8.getMessageId(), r13, "MainBotImagePreviewGroupHelper"));     // Catch: Exception -> L63
        Gson r25 = new Gson();     // Catch: Exception -> L63
        if (r24 != null) goto L61;
        r24 = "{}";
    L61:
        com.larus.bmhome.chat.markdown.imagegroup.a r26 = (com.larus.bmhome.chat.markdown.imagegroup.a) r25.fromJson(r24, com.larus.bmhome.chat.markdown.imagegroup.a.class);     // Catch: Exception -> L63
    L65:
        if (r26 == null) goto L67;
        List r27 = r26.c();
    L68:
        List r28 = r27;
        if (r28 != null) goto L71;
    L72:
        r3 = true;
    L73:
        if (r3 == false) goto L76;
        return null;
    L76:
        return a(r26);
    L71:
        if (r28.isEmpty() == false) goto L73;
    L67:
        r27 = null;
    L63:
        e = move-exception;
        FLogger.a.e("MainBotImagePreviewGroupHelper", "parseImageGroupFromTag error, valueId: " + r13 + ", [" + e + ']', e);
        r26 = null;
        goto L65
    L47:
        r21 = false;
    L50:
        r22 = false;
        goto L51
    L39:
        if (r19.isEmpty() == false) goto L41;
    L53:
        r23 = false;
        goto L54
    L77:
        if (r16 != null) goto L79;
    L82:
        boolean r29 = true;
    L83:
        if (r29 == false) goto L101;
        return null;
    L101:
        com.larus.bmhome.chat.markdown.imagegroup.a r30 = (com.larus.bmhome.chat.markdown.imagegroup.a) new Gson().fromJson(b(r16), com.larus.bmhome.chat.markdown.imagegroup.a.class);     // Catch: Exception -> L86
    L88:
        if (r30 == null) goto L90;
        List r31 = r30.c();
    L91:
        List r32 = r31;
        if (r32 != null) goto L94;
    L95:
        r3 = true;
    L96:
        if (r3 == false) goto L99;
        return null;
    L99:
        return a(r30);
    L94:
        if (r32.isEmpty() == false) goto L96;
    L90:
        r31 = null;
    L86:
        e = move-exception;
        FLogger.a.e("MainBotImagePreviewGroupHelper", "parseImageGroupFromTag error, valueStr: " + r16 + ", [" + e + ']', e);
        r30 = null;
        goto L88
    L79:
        if (r16.length() == 0) goto L82;
        r29 = false;
        goto L83
    L26:
        if (r13.length() == 0) goto L29;
        r7 = false;
    L23:
        r16 = null;
    L17:
        r13 = null;
        goto L18
    L10:
        if (Intrinsics.areEqual(r6, "image-group") == true) goto L12;
        return null;
    L7:
        r6 = null;
        goto L8
    }
}
