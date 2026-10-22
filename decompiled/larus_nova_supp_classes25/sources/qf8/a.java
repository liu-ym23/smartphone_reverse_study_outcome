package qf8;

import android.text.TextUtils;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.utils.k;
import com.larus.im.bean.IMMetaInfo;
import com.larus.im.bean.message.ContainerAttribute;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.RichMediaMeta;
import com.larus.im.bean.message.TagEnum;
import com.larus.im.bean.message.TextTagInfo;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockMetaInfo;
import com.larus.im.bean.message.block.MetaInfoBlock;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.RichMediaType;
import com.larus.im.bean.message.block.SearchImageItem;
import com.larus.im.bean.message.block.TextBlock;
import ic8.g0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import wc8.b;
import zc9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final String a(Block r24, Message r25) {
        Intrinsics.checkNotNullParameter(r24, "<this>");
        BlockContent r1 = r24.getContent();
        String r3 = "";
        if (r1 == null) goto L122;
        TextBlock r2 = r1.getTextBlock();
        if (r2 == null) goto L122;
        String r4 = r2.text;
        if (r4 == null) goto L122;
        List r5 = r24.getMetaInfo();
        if (r5 != null) goto L12;
        return r4;
    L12:
        List r6 = r5;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = r6.iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        BlockMetaInfo r9 = (BlockMetaInfo) r8.next();
        r7.add(new TextTagInfo(r9.type, r9.getRealInfo()));
        goto L14
    L16:
        Regex r10 = d.a;
        Intrinsics.checkNotNullParameter(r4, "content");
        ArrayList r11 = new ArrayList();
        Iterator r12 = r7.iterator();
        int r13 = 0;
    L17:
        boolean r14 = true;
        Boolean r15 = null;
        if (r12.hasNext() == false) goto L80;
        Object r16 = r12.next();
        int r17 = r13 + 1;
        if (r13 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        final TextTagInfo r18 = (TextTagInfo) r16;
        if (r18.type != TagEnum.TagEnum_InsertText_BLOCK.value) goto L77;
        b r19 = b.a;
        RichMediaMeta r110 = b.e(r18.tagInfo, new g0(r18));
        if (r110 == null) goto L77;
        RichMediaMeta r20 = RichMediaMeta.copy$default(r110, null, null, null, null, 15, null);
        if (r20 == null) goto L77;
        String r21 = d.e1(r20.getSceneType());
        if (d.c.contains(r21) == false) goto L77;
        List r111 = r20.getMedia();
        if (r111 != null) goto L33;
    L36:
        boolean r112 = true;
    L37:
        if (r112 == true) goto L77;
        ContainerAttribute r113 = r20.getContainerAttribute();
        if (r113 == null) goto L41;
        String r114 = r113.getStyle();
    L42:
        if (r114 != null) goto L44;
    L47:
        if (r14 == true) goto L77;
        Integer r22 = r20.getSceneType();
        int r115 = RichMediaType.SEARCH_IMAGE.getValue();
        if (r22 == null) goto L77;
        if (r22.intValue() != r115) goto L77;
        ContainerAttribute r23 = r20.getContainerAttribute();
        if (r23 == null) goto L58;
        String r116 = r23.getStyle();
    L59:
        List r26 = r20.getMedia();
        if (r26 == null) goto L72;
        Iterator r27 = r26.iterator();
        String r117 = "";
    L63:
        if (r27.hasNext() == false) goto L71;
        RichMediaItem r118 = (RichMediaItem) r27.next();
        StringBuilder r119 = new StringBuilder();
        r119.append(r117);
        r119.append("![](");
        SearchImageItem r120 = r118.image;
        if (r120 == null) goto L69;
        List r121 = r120.fullSizeUrl;
        if (r121 == null) goto L69;
        String r122 = (String) CollectionsKt.firstOrNull(r121);
    L70:
        r119.append(r122);
        r119.append(')');
        r117 = r119.toString() + '\n';
    L69:
        r122 = null;
        goto L70
    L71:
        String r123 = r117;
    L73:
        Integer r124 = r20.getPos();
        ContainerAttribute r28 = r20.getContainerAttribute();
        if (r28 == null) goto L76;
        r15 = r28.getCanReplace();
    L76:
        Boolean r29 = new IMMetaInfo.InsertTextReference(r124, r123, r15, null, r21, r116, null, null, null, 456, null);
        Intrinsics.checkNotNullParameter("", "realValue");
        Intrinsics.checkNotNullParameter(r29, "reference");
        r15 = r29;
        goto L77
    L72:
        r123 = "";
        goto L73
    L58:
        r116 = null;
        goto L59
    L44:
        if (r114.length() == 0) goto L47;
        r14 = false;
        goto L47
    L41:
        r114 = null;
        goto L42
    L33:
        if (r111.isEmpty() == true) goto L36;
        r112 = false;
    L77:
        if (r15 == null) goto L79;
        r11.add(r15);
    L79:
        r13 = r17;
        goto L17
    L80:
        ArrayList r30 = new ArrayList();
        Iterator r31 = r11.iterator();
    L82:
        if (r31.hasNext() == false) goto L116;
        IMMetaInfo.InsertTextReference r125 = (IMMetaInfo.InsertTextReference) r31.next();
        Integer r32 = r125.getPos();
        if (r25 == null) goto L86;
        Integer r33 = Integer.valueOf(r25.getMessageStatusLocal());
    L88:
        if (r32 == null) goto L106;
        if (r32.intValue() != (-1)) goto L106;
        if (r33 == null) goto L106;
        if (r33.intValue() != 21) goto L106;
        int r34 = wf9.b.a;
        Intrinsics.checkNotNullParameter(r25, "message");
        if (com.larus.im.bean.message.a.w0(r25) == true) goto L106;
        IMMetaInfo.d[] r35 = new IMMetaInfo.d[1];
        int r36 = k.a;
        int r37 = r4.length();
        Intrinsics.checkNotNullParameter(r4, "str");
        if (r37 >= 0) goto L101;
    L104:
        r35[0] = IMMetaInfo.InsertTextReference.copy$default(r125, Integer.valueOf(r37), null, null, null, null, null, null, null, null, 510, null);
        List r38 = CollectionsKt.mutableListOf(r35);
    L115:
        CollectionsKt.addAll(r30, r38);
        goto L82
    L101:
        if (r37 > r4.length()) goto L104;
        r37 = StringsKt.encodeToByteArray(r4.substring(0, r37)).length;
    L106:
        if (Intrinsics.areEqual(r125.getCanReplace(), Boolean.TRUE) == false) goto L114;
        if (r33 == null) goto L114;
        if (r33.intValue() != 21) goto L114;
        int r39 = wf9.b.a;
        Intrinsics.checkNotNullParameter(r25, "message");
        if (com.larus.im.bean.message.a.w0(r25) == true) goto L114;
        r38 = CollectionsKt.emptyList();
    L114:
        r38 = CollectionsKt.mutableListOf(new IMMetaInfo.InsertTextReference[]{r125});
        goto L115
    L86:
        r33 = null;
        goto L88
    L116:
        Iterator r40 = vh8.a.c(CollectionsKt.sortedWith(r30, new IMMetaInfo.e())).iterator();
        r3 = r4;
    L118:
        if (r40.hasNext() == false) goto L122;
        IMMetaInfo.InsertTextReference r41 = (IMMetaInfo.d) r40.next();
        if ((r41 instanceof IMMetaInfo.InsertTextReference) == false) goto L118;
        int r42 = vh8.a.a;
        r3 = StringsKt.decodeToString(vh8.a.a(StringsKt.encodeToByteArray(r4), StringsKt.encodeToByteArray(r3), r41, r25));
    L122:
        return r3;
    }

    public static final String b(Block r25, Message r26, List<Block> r27) {
        Intrinsics.checkNotNullParameter(r25, "<this>");
        Intrinsics.checkNotNullParameter(r27, "embeddedMetaInfoBlocks");
        if (r26 != null) goto L9;
        BlockContent r0 = r25.getContent();
        if (r0 == null) goto L71;
        TextBlock r1 = r0.getTextBlock();
        if (r1 != null) goto L73;
        return null;
    L73:
        return h.a(r1, r25.getBlockId(), r25.getMetaInfo());
    L71:
        return null;
    L9:
        BlockContent r3 = r25.getContent();
        if (r3 == null) goto L63;
        TextBlock r4 = r3.getTextBlock();
        if (r4 == null) goto L74;
        String r5 = r4.text;
        if (r5 == null) goto L75;
        List r6 = r25.getMetaInfo();
        if (r6 != null) goto L19;
        r6 = CollectionsKt.emptyList();
    L19:
        List r7 = r6;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator r9 = r7.iterator();
    L21:
        if (r9.hasNext() == false) goto L23;
        BlockMetaInfo r10 = (BlockMetaInfo) r9.next();
        r8.add(new TextTagInfo(r10.type, r10.getRealInfo()));
        goto L21
    L23:
        String r11 = r25.getBlockId();
        ArrayList r12 = new ArrayList();
        Iterator<T> r2 = r27.iterator();
    L25:
        if (r2.hasNext() == false) goto L62;
        Block r13 = (Block) r2.next();
        BlockContent r14 = r13.getContent();
        if (r14 == null) goto L58;
        MetaInfoBlock r15 = r14.getMetaInfoBlock();
        if (r15 == null) goto L58;
        String r16 = r13.getBlockId();
        if (r16 == null) goto L58;
        boolean r17 = true;
        if (r16.length() <= 0) goto L36;
        boolean r18 = true;
    L37:
        if (r18 == true) goto L40;
        r16 = null;
    L40:
        if (r16 == null) goto L58;
        String r19 = r15.style;
        if (r19 != null) goto L45;
    L56:
        r19 = "inline";
    L57:
        IMMetaInfo.InsertTextReference r110 = new IMMetaInfo.InsertTextReference(Integer.valueOf(r15.pos), "<data-" + r19 + " type=\"block-container\" value_id=\"" + TextUtils.htmlEncode(r16) + "\"></data-" + r19 + '>', null, null, "block-container", r19, null, null, null, 460, null);
    L59:
        if (r110 == null) goto L25;
        r12.add(r110);
        goto L25
    L45:
        if (Intrinsics.areEqual(r19, "inline") == false) goto L47;
    L52:
        if (r17 == true) goto L55;
        r19 = null;
    L55:
        if (r19 != null) goto L57;
    L47:
        if (Intrinsics.areEqual(r19, "inline-no-margin") == true) goto L52;
        if (Intrinsics.areEqual(r19, "block") == true) goto L52;
        r17 = false;
        goto L52
    L36:
        r18 = false;
    L58:
        r110 = null;
        goto L59
    L62:
        return d.p(r5, r8, r26, false, r11, r12);
    L75:
        return "";
    L74:
        return "";
    L63:
        return "";
    }

    public static /* synthetic */ String c(Block r2, Message r3, int r4) {
        List r1 = null;
        if ((r4 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r1 = CollectionsKt.emptyList();
    L9:
        return b(r2, r3, r1);
    }
}
