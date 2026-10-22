package com.larus.bmhome.chat.messagetransfer;

import android.content.Context;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.AttachmentBlock;
import com.larus.im.bean.message.block.AttachmentItem;
import com.larus.im.bean.message.block.AttachmentType;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.GenImageBlock;
import com.larus.im.bean.message.block.ImageAnalysisBlock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.b;
import vd9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final Set<Integer> a = null;
    public static final Set<Integer> b = null;

    static {
        a = SetsKt.setOf(new Integer[]{Integer.valueOf(BlockType.BLOCK_TYPE_IMAGE.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_GEN_IMAGE.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_IMAGE_ANALYSIS.getValue())});
        b = SetsKt.setOf(new Integer[]{1, 2, 3, 4, 6, 10, 11, 12, 9, 15});
    }

    public static String e(String r4) {
        if (r4 == null) goto L12;
        String r5 = StringsKt.trim(r4).toString();
        if (r5 == null) goto L12;
        String r6 = StringsKt.trim(r5, new char[]{'|'});
        if (r6 == null) goto L12;
        String r7 = StringsKt.trim(r6).toString();
        if (r7 == null) goto L12;
        if ((true ^ StringsKt.isBlank(r7)) == false) goto L12;
        return r7;
    L12:
        return null;
    }

    public static boolean b(Message r5, BlockType... r6) {
        ArrayList r0 = new ArrayList(r6.length);
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.add(Integer.valueOf(r6[r3].getValue()));
        r3 = r3 + 1;
        goto L3
    L5:
        Set r7 = CollectionsKt.toSet(r0);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        List r8 = r.a(r5);
        if ((r8 instanceof Collection) == true) goto L8;
    L10:
        Iterator r9 = r8.iterator();
    L12:
        if (r9.hasNext() == false) goto L22;
        if (r7.contains(Integer.valueOf(((Block) r9.next()).getBlockType())) == false) goto L12;
        return true;
    L22:
        return false;
    L8:
        if (r8.isEmpty() == false) goto L10;
        return false;
    }

    public static boolean c(Message r5, AttachmentType... r6) {
        ArrayList r0 = new ArrayList(r6.length);
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.add(Integer.valueOf(r6[r3].getValue()));
        r3 = r3 + 1;
        goto L3
    L5:
        Set r7 = CollectionsKt.toSet(r0);
        Intrinsics.checkNotNullParameter(r5, "<this>");
        List r8 = r.a(r5);
        if ((r8 instanceof Collection) == true) goto L8;
    L10:
        Iterator r9 = r8.iterator();
    L12:
        if (r9.hasNext() == false) goto L46;
        BlockContent r2 = ((Block) r9.next()).getContent();
        if (r2 == null) goto L18;
        AttachmentBlock r4 = r2.getAttachmentBlock();
        if (r4 == null) goto L18;
        List r10 = r4.getAttachments();
    L19:
        if (r10 != null) goto L21;
        r10 = CollectionsKt.emptyList();
    L21:
        List r11 = r10;
        if ((r11 instanceof Collection) == true) goto L24;
    L26:
        Iterator r12 = r11.iterator();
    L28:
        if (r12.hasNext() == false) goto L32;
        if (r7.contains(Integer.valueOf(((AttachmentItem) r12.next()).getType())) == false) goto L28;
        boolean r13 = true;
    L33:
        if (r13 == false) goto L12;
        return true;
    L32:
        r13 = false;
        goto L33
    L24:
        if (r11.isEmpty() == false) goto L26;
    L18:
        r10 = null;
        goto L19
    L46:
        return false;
    L8:
        if (r8.isEmpty() == false) goto L10;
        return false;
    }

    public static boolean d(Block r5, AttachmentType... r6) {
        ArrayList r0 = new ArrayList(r6.length);
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.add(Integer.valueOf(r6[r3].getValue()));
        r3 = r3 + 1;
        goto L3
    L5:
        Set r7 = CollectionsKt.toSet(r0);
        BlockContent r8 = r5.getContent();
        if (r8 == null) goto L10;
        AttachmentBlock r9 = r8.getAttachmentBlock();
        if (r9 == null) goto L10;
        List r10 = r9.getAttachments();
    L11:
        if (r10 != null) goto L13;
        r10 = CollectionsKt.emptyList();
    L13:
        List r11 = r10;
        if ((r11 instanceof Collection) == true) goto L16;
    L18:
        Iterator r12 = r11.iterator();
    L20:
        if (r12.hasNext() == false) goto L30;
        if (r7.contains(Integer.valueOf(((AttachmentItem) r12.next()).getType())) == false) goto L20;
        return true;
    L30:
        return false;
    L16:
        if (r11.isEmpty() == false) goto L18;
        return false;
    L10:
        r10 = null;
        goto L11
    }

    public static String a(Context r10, Message r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        TextContent r1 = r.b(r11);
        if (r1 == null) goto L9;
        b r2 = r1.getImages();
        if (r2 == null) goto L9;
        if ((!r2.isEmpty()) != true) goto L9;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L88;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        List r4 = r.a(r11);
        if ((r4 instanceof Collection) == true) goto L15;
    L17:
        Iterator r5 = r4.iterator();
    L19:
        if (r5.hasNext() == false) goto L42;
        Block r6 = (Block) r5.next();
        if (a.contains(Integer.valueOf(r6.getBlockType())) == true) goto L39;
        BlockContent r8 = r6.getContent();
        if (r8 == null) goto L25;
        String r9 = r8.getImageBlock();
    L26:
        if (r9 != null) goto L39;
        BlockContent r13 = r6.getContent();
        if (r13 == null) goto L30;
        GenImageBlock r14 = r13.getGenImageBlock();
    L31:
        if (r14 != null) goto L39;
        BlockContent r7 = r6.getContent();
        if (r7 == null) goto L35;
        ImageAnalysisBlock r15 = r7.getImageAnalysisBlock();
    L36:
        if (r15 != null) goto L39;
        boolean r16 = false;
    L40:
        if (r16 == false) goto L19;
        boolean r17 = true;
    L43:
        if (r17 == true) goto L88;
        if (c(r11, new AttachmentType[]{AttachmentType.AttachmentTypeImage}) == true) goto L88;
        if (b(r11, new BlockType[]{BlockType.BLOCK_TYPE_VIDEO_READER}) == false) goto L50;
    L86:
        String r18 = r10.getString(2131900789);
        Intrinsics.checkNotNull(r18);
        return r18;
    L50:
        if (c(r11, new AttachmentType[]{AttachmentType.AttachmentTypeVideo}) == true) goto L86;
        if (b(r11, new BlockType[]{BlockType.BLOCK_TYPE_LINK, BlockType.BLOCK_TYPE_LINKER_READER, BlockType.BLOCK_TYPE_RESEARCH_WEBPAGE}) == false) goto L55;
    L85:
        String r19 = r10.getString(2131900784);
        Intrinsics.checkNotNull(r19);
        return r19;
    L55:
        if (c(r11, new AttachmentType[]{AttachmentType.AttachmentTypeLink}) == true) goto L85;
        if (b(r11, new BlockType[]{BlockType.BLOCK_TYPE_FILE, BlockType.BLOCK_TYPE_ATTACHMENT}) == true) goto L99;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        List r0 = r.a(r11);
        if ((r0 instanceof Collection) == true) goto L62;
    L64:
        Iterator r20 = r0.iterator();
    L66:
        if (r20.hasNext() == false) goto L76;
        Block r21 = (Block) r20.next();
        Set<Integer> r22 = b;
        BlockContent r23 = r21.getContent();
        if (r23 == null) goto L72;
        ArtifactBlock r24 = r23.getDocBlock();
        if (r24 == null) goto L72;
        Integer r25 = r24.getResourceType();
    L74:
        if (CollectionsKt.contains(r22, r25) == false) goto L66;
        boolean r26 = true;
    L77:
        if (r26 == true) goto L99;
        if (c(r11, new AttachmentType[]{AttachmentType.AttachmentTypeFile, AttachmentType.AttachmentTypeLarkDoc}) == true) goto L99;
        if (b(r11, new BlockType[]{BlockType.BLOCK_TYPE_ARTIFACT, BlockType.BLOCK_TYPE_TASK_CARD, BlockType.BLOCK_TYPE_GENERIC_TOOL, BlockType.BLOCK_TYPE_LYNX, BlockType.BLOCK_TYPE_SEARCH_RICH_MEDIA}) == false) goto L97;
        String r110 = r10.getString(2131900779);
        Intrinsics.checkNotNull(r110);
        return r110;
    L97:
        return r12;
    L72:
        r25 = null;
    L76:
        r26 = false;
        goto L77
    L62:
        if (r0.isEmpty() == false) goto L64;
    L99:
        return "[" + r10.getString(2131905683) + ']';
    L35:
        r15 = null;
        goto L36
    L30:
        r14 = null;
        goto L31
    L25:
        r9 = null;
    L39:
        r16 = true;
    L42:
        r17 = false;
        goto L43
    L15:
        if (r4.isEmpty() == false) goto L17;
    L88:
        return "[" + r10.getString(2131900783) + ']';
    L9:
        r3 = false;
        goto L11
    }
}
