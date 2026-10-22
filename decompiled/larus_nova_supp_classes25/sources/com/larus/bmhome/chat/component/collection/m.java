package com.larus.bmhome.chat.component.collection;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.layout.item.SearchListBox;
import com.larus.bmhome.chat.search.CardType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TagEnum;
import com.larus.im.bean.message.TextTagInfo;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockMetaInfo;
import com.larus.im.bean.message.block.BlockType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import oi8.e;
import vd9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m {
    public static final boolean a(Message r11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        if (r11.getContentType() != 6) goto L6;
        return true;
    L6:
        if (r11.getContentType() != 8) goto L29;
        if (com.larus.im.bean.message.a.b0(r11) == true) goto L29;
        LruCache<String, oi8.k> r0 = SearchListBox.E;
        String r1 = r11.getMessageId();
        if (r1 != null) goto L12;
        r1 = "";
    L12:
        oi8.k r12 = SearchListBox.a.a(r1, r11.getContent());
        if (r12 == null) goto L26;
        com.larus.bmhome.chat.search.b r13 = r12.e();
        if (r13 == null) goto L26;
        oi8.c r14 = r13.b();
        if (r14 == null) goto L26;
        e r15 = r14.c();
        if (r15 == null) goto L26;
        Integer r16 = r15.a();
        int r2 = CardType.Image.value;
        if (r16 == null) goto L26;
        if (r16.intValue() != r2) goto L26;
        return true;
    L26:
        return false;
    L29:
        if (CollectionsKt.listOf(new Integer[]{8, 1, 9999}).contains(Integer.valueOf(r11.getContentType())) == true) goto L32;
        return false;
    L32:
        if (com.larus.im.bean.message.a.b0(r11) == false) goto L62;
        ArrayList r17 = (ArrayList) com.larus.im.bean.message.a.J(r11, BlockType.BLOCK_TYPE_TEXT);
        if (r17.isEmpty() == true) goto L61;
        Iterator r18 = r17.iterator();
        if (r18.hasNext() == false) goto L61;
        List r19 = ((Block) r18.next()).getMetaInfo();
        if (r19 == null) goto L59;
        List r110 = r19;
        if ((r110 instanceof Collection) == true) goto L43;
    L45:
        Iterator r111 = r110.iterator();
    L47:
        if (r111.hasNext() == false) goto L56;
        BlockMetaInfo r4 = (BlockMetaInfo) r111.next();
        Set r9 = SetsKt.setOf(new Integer[]{Integer.valueOf(TagEnum.TagEnum_InsertText_BLOCK.value), Integer.valueOf(TagEnum.TagEnum_InsertText.value), Integer.valueOf(TagEnum.TagEnum_InsertText_V2.value)});
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r9, "set");
        if (r9.contains(Integer.valueOf(r4.type)) == true) goto L51;
    L53:
        boolean r5 = false;
    L54:
        if (r5 == false) goto L47;
        boolean r112 = true;
    L57:
        if (r112 != true) goto L59;
        return true;
    L51:
        if (d(r4, CollectionsKt.listOf(new String[]{"image-group", "simple-image-group"})) == false) goto L53;
        r5 = true;
    L56:
        r112 = false;
        goto L57
    L43:
        if (r110.isEmpty() == false) goto L45;
    L59:
        return false;
    L61:
        return false;
    L62:
        List<TextTagInfo> r113 = d.C(r11);
        if (r113 == null) goto L83;
        List<TextTagInfo> r114 = r113;
        if ((r114 instanceof Collection) == true) goto L67;
    L69:
        Iterator<T> r115 = r114.iterator();
    L71:
        if (r115.hasNext() == false) goto L80;
        TextTagInfo r3 = (TextTagInfo) r115.next();
        Set r6 = SetsKt.setOf(new Integer[]{Integer.valueOf(TagEnum.TagEnum_InsertText.value), Integer.valueOf(TagEnum.TagEnum_InsertText_V2.value)});
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r6, "set");
        if (r6.contains(Integer.valueOf(r3.type)) == true) goto L75;
    L77:
        boolean r7 = false;
    L78:
        if (r7 == false) goto L71;
        boolean r116 = true;
    L81:
        if (r116 != true) goto L83;
        return true;
    L75:
        if (c(r3, CollectionsKt.listOf(new String[]{"image-group", "simple-image-group"})) == false) goto L77;
        r7 = true;
    L80:
        r116 = false;
        goto L81
    L67:
        if (r114.isEmpty() == false) goto L69;
    L83:
        return false;
    }

    public static final boolean b(Message r11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        if (r11.getContentType() != 5) goto L5;
        return true;
    L5:
        if (r11.getContentType() != 9) goto L8;
        return true;
    L8:
        if (CollectionsKt.listOf(new Integer[]{1, 9999, 8}).contains(Integer.valueOf(r11.getContentType())) == true) goto L11;
        return false;
    L11:
        if (r11.getContentType() != 8) goto L34;
        if (com.larus.im.bean.message.a.b0(r11) == true) goto L34;
        LruCache<String, oi8.k> r0 = SearchListBox.E;
        String r1 = r11.getMessageId();
        if (r1 != null) goto L17;
        r1 = "";
    L17:
        oi8.k r12 = SearchListBox.a.a(r1, r11.getContent());
        if (r12 == null) goto L31;
        com.larus.bmhome.chat.search.b r13 = r12.e();
        if (r13 == null) goto L31;
        oi8.c r14 = r13.b();
        if (r14 == null) goto L31;
        e r15 = r14.c();
        if (r15 == null) goto L31;
        Integer r16 = r15.a();
        int r2 = CardType.Video.value;
        if (r16 == null) goto L31;
        if (r16.intValue() != r2) goto L31;
        return true;
    L31:
        return false;
    L34:
        if (com.larus.im.bean.message.a.b0(r11) == false) goto L81;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        List r3 = r.a(r11);
        if ((r3 instanceof Collection) == true) goto L38;
    L40:
        Iterator r4 = r3.iterator();
    L42:
        if (r4.hasNext() == false) goto L49;
        if (((Block) r4.next()).getBlockType() != BlockType.BLOCK_TYPE_SEARCH_RICH_MEDIA.getValue()) goto L46;
        boolean r9 = true;
    L47:
        if (r9 == false) goto L42;
        boolean r5 = true;
    L50:
        if (r5 == false) goto L52;
        return true;
    L52:
        ArrayList r17 = (ArrayList) com.larus.im.bean.message.a.J(r11, BlockType.BLOCK_TYPE_TEXT);
        if (r17.isEmpty() == true) goto L80;
        Iterator r18 = r17.iterator();
        if (r18.hasNext() == false) goto L80;
        List r19 = ((Block) r18.next()).getMetaInfo();
        if (r19 == null) goto L78;
        List r110 = r19;
        if ((r110 instanceof Collection) == true) goto L62;
    L64:
        Iterator r111 = r110.iterator();
    L66:
        if (r111.hasNext() == false) goto L75;
        BlockMetaInfo r6 = (BlockMetaInfo) r111.next();
        Set r10 = SetsKt.setOf(new Integer[]{Integer.valueOf(TagEnum.TagEnum_InsertText_BLOCK.value), Integer.valueOf(TagEnum.TagEnum_InsertText.value), Integer.valueOf(TagEnum.TagEnum_InsertText_V2.value)});
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r10, "set");
        if (r10.contains(Integer.valueOf(r6.type)) == true) goto L70;
    L72:
        boolean r7 = false;
    L73:
        if (r7 == false) goto L66;
        boolean r112 = true;
    L76:
        if (r112 != true) goto L78;
        return true;
    L70:
        if (d(r6, CollectionsKt.listOf(new String[]{"video-group", "video-group-v2"})) == false) goto L72;
        r7 = true;
    L75:
        r112 = false;
        goto L76
    L62:
        if (r110.isEmpty() == false) goto L64;
    L78:
        return false;
    L80:
        return false;
    L46:
        r9 = false;
    L49:
        r5 = false;
        goto L50
    L38:
        if (r3.isEmpty() == false) goto L40;
    L81:
        List<TextTagInfo> r113 = d.C(r11);
        if (r113 == null) goto L102;
        List<TextTagInfo> r114 = r113;
        if ((r114 instanceof Collection) == true) goto L86;
    L88:
        Iterator<T> r115 = r114.iterator();
    L90:
        if (r115.hasNext() == false) goto L99;
        TextTagInfo r8 = (TextTagInfo) r115.next();
        Set r20 = SetsKt.setOf(new Integer[]{Integer.valueOf(TagEnum.TagEnum_InsertText.value), Integer.valueOf(TagEnum.TagEnum_InsertText_V2.value)});
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r20, "set");
        if (r20.contains(Integer.valueOf(r8.type)) == true) goto L94;
    L96:
        boolean r21 = false;
    L97:
        if (r21 == false) goto L90;
        boolean r116 = true;
    L100:
        if (r116 != true) goto L102;
        return true;
    L94:
        if (c(r8, CollectionsKt.listOf(new String[]{"video-group", "video-group-v2"})) == false) goto L96;
        r21 = true;
    L99:
        r116 = false;
        goto L100
    L86:
        if (r114.isEmpty() == false) goto L88;
    L102:
        return false;
    }

    public static final boolean c(TextTagInfo r6, List<String> r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "set");
        Iterator<T> r8 = r7.iterator();
    L3:
        boolean r1 = false;
        if (r8.hasNext() == false) goto L12;
        String r0 = (String) r8.next();
        String r2 = r6.tagInfo;
        if (r2 == null) goto L10;
        if (StringsKt.contains$default(r2, r0, false, 2, null) != true) goto L10;
        r1 = true;
    L10:
        if (r1 == false) goto L3;
        return true;
    L12:
        return false;
    }

    public static final boolean d(BlockMetaInfo r5, List<String> r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "set");
        String r7 = r5.getRealInfo();
        Iterator<T> r8 = r6.iterator();
    L3:
        boolean r1 = false;
        if (r8.hasNext() == false) goto L12;
        String r0 = (String) r8.next();
        if (r7 == null) goto L10;
        if (StringsKt.contains$default(r7, r0, false, 2, null) != true) goto L10;
        r1 = true;
    L10:
        if (r1 == false) goto L3;
        return true;
    L12:
        return false;
    }
}
