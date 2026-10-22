package com.larus.bmhome.block.pipeline.task;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask;
import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask$a;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockType;
import com.larus.im.bean.message.block.FileSource;
import com.larus.im.bean.message.block.GenericImageItem;
import com.larus.im.bean.message.block.GenericVideoItem;
import com.larus.im.bean.message.block.LocalFileBlock;
import com.larus.im.bean.message.block.MediaType;
import com.larus.im.bean.message.block.RichMediaItem;
import com.larus.im.bean.message.block.RichMediaLayoutBlock;
import com.larus.im.bean.message.block.RichMediaType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kc8.f;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u000e\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u0010H\u0002J2\u0010\u0011\u001a\u00020\n*\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J.\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/larus/bmhome/block/pipeline/task/RichMediaLocalFileFallbackTask;", "Lcom/larus/bmhome/block/pipeline/api/IBlockPipelineTask;", "<init>", "()V", "priority", "", "getPriority", "()I", "processBlocks", "", "Lcom/larus/im/bean/message/block/Block;", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "blockList", "toLocalFileFallback", "Lcom/larus/bmhome/block/pipeline/task/RichMediaLocalFileFallbackTask$LocalFileFallback;", "Lcom/larus/im/bean/message/block/RichMediaItem;", "toBlock", "sourceBlock", "sourceBlockIndex", "itemIndex", "usedBlockIds", "", "", "createBlockId", "LocalFileFallback", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RichMediaLocalFileFallbackTask implements IBlockPipelineTask {
    public final int b;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;
        public final String c;
        public final String d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 == null) goto L19;
            r1 = r10.hashCode();
        L19:
            return r9 + r1;
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "LocalFileFallback(name=" + this.a + ", uri=" + this.b + ", resource=" + this.c + ", fileType=" + this.d + ')';
        }

        public b(String r1, String r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public RichMediaLocalFileFallbackTask() {
        this.b = DoraCallStateCode.DORA_OB_USER_END;
    }

    public final int getPriority() {
        return this.b;
    }

    public final boolean n1(f r2) {
        Intrinsics.checkNotNullParameter(r2, "blockPipelineConfig");
        return true;
    }

    public final List<Block> d3(f r160, List<Block> r161) {
        Intrinsics.checkNotNullParameter(r160, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r161, "blockList");
        List<Block> r0 = r161;
        LinkedHashSet r1 = new LinkedHashSet();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        String r3 = ((Block) r2.next()).getBlockId();
        if (r3 == null) goto L4;
        r1.add(r3);
        goto L4
    L8:
        List r4 = CollectionsKt.createListBuilder();
        Iterator r5 = r0.iterator();
        int r6 = 0;
    L10:
        if (r5.hasNext() == false) goto L94;
        Object r7 = r5.next();
        int r8 = r6 + 1;
        if (r6 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        Block r9 = (Block) r7;
        BlockContent r10 = r9.getContent();
        if (r10 == null) goto L17;
        RichMediaLayoutBlock r11 = r10.getRichMediaLayoutBlock();
    L18:
        if (r11 != null) goto L20;
        r4.add(r9);
        Iterator r82 = r5;
        int r83 = r8;
    L92:
        r5 = r82;
        r6 = r83;
        goto L10
    L20:
        ArrayList r12 = new ArrayList();
        ArrayList r14 = new ArrayList();
        Iterator r13 = r11.richMediaItem.iterator();
        int r15 = 0;
    L22:
        if (r13.hasNext() == false) goto L85;
        Object r16 = r13.next();
        int r17 = r15 + 1;
        if (r15 >= 0) goto L26;
        CollectionsKt.throwIndexOverflow();
    L26:
        RichMediaItem r18 = (RichMediaItem) r16;
        Integer r19 = r18.type;
        int r20 = RichMediaType.GENERIC_IMAGE.getValue();
        Iterator r84 = r5;
        int r85 = r8;
        if (r19 != null) goto L30;
    L47:
        Iterator r110 = r13;
        int r111 = r17;
        int r21 = RichMediaType.GENERIC_VIDEO.getValue();
        if (r19 != null) goto L51;
    L67:
        b r22 = null;
    L68:
        if (r22 != null) goto L70;
        r12.add(r18);
    L84:
        r13 = r110;
        r15 = r111;
        r5 = r84;
        r8 = r85;
        goto L22
    L70:
        int r23 = BlockType.BLOCK_TYPE_LOCAL_FILE.getValue();
        String r24 = r9.getBlockId();
        if (r24 != null) goto L73;
    L78:
        r24 = "rich_media_layout_" + r6;
    L79:
        String r25 = r24 + "_local_file_" + r15;
        String r26 = r25;
        int r27 = 1;
    L81:
        if (r1.add(r26) == true) goto L83;
        r26 = r25 + '_' + r27;
        r27 = r27 + 1;
        goto L81
    L83:
        String r28 = r26;
        r14.add(new Block(r23, r28, r9.getParentId(), new BlockContent(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new LocalFileBlock(r22.d, r22.a, r22.b, r22.c, null, null, null, FileSource.FILE_SOURCE_PC, null, 368, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -32769, 31, null), r9.isFinish(), null, null, null, 224, null));
        goto L84
    L73:
        if ((!StringsKt.isBlank(r24)) == true) goto L76;
        r24 = null;
    L76:
        if (r24 == null) goto L78;
    L51:
        if (r19.intValue() != r21) goto L67;
        GenericVideoItem r29 = r18.videoItem;
        if (r29 == null) goto L67;
        if (r29.type != MediaType.MediaTypeLocalFile.getValue()) goto L57;
        boolean r30 = true;
    L58:
        if (r30 == true) goto L61;
        r29 = null;
    L61:
        if (r29 == null) goto L67;
        String r31 = r29.name;
        String r32 = r29.uri;
        String r112 = r29.resource;
        Map r33 = r29.extra;
        if (r33 == null) goto L65;
        String r34 = (String) r33.get("file_type");
    L66:
        r22 = new b(r31, r32, r112, r34);
        goto L68
    L65:
        r34 = null;
        goto L66
    L57:
        r30 = false;
        goto L58
    L30:
        if (r19.intValue() != r20) goto L47;
        GenericImageItem r35 = r18.imageItem;
        if (r35 != null) goto L34;
    L46:
        r110 = r13;
        r111 = r17;
        goto L67
    L34:
        if (r35.type != MediaType.MediaTypeLocalFile.getValue()) goto L36;
        boolean r36 = true;
    L37:
        if (r36 == true) goto L40;
        r35 = null;
    L40:
        if (r35 == null) goto L46;
        String r37 = r35.name;
        r110 = r13;
        String r38 = r35.uri;
        r111 = r17;
        String r113 = r35.resource;
        Map r39 = r35.extra;
        if (r39 == null) goto L44;
        String r40 = (String) r39.get("file_type");
    L45:
        r22 = new b(r37, r38, r113, r40);
        goto L68
    L44:
        r40 = null;
        goto L45
    L36:
        r36 = false;
        goto L37
    L85:
        r82 = r5;
        r83 = r8;
        if (r14.isEmpty() == false) goto L89;
        r4.add(r9);
        goto L92
    L89:
        if (r12.isEmpty() == false) goto L91;
        r4.addAll(r14);
        goto L92
    L91:
        r4.add(Block.copy$default(r9, 0, null, null, BlockContent.copy$default(r10, null, null, RichMediaLayoutBlock.copy$default(r11, r12, null, 2, null), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -5, -1, 31, null), false, null, null, null, 247, null));
        r4.addAll(r14);
        goto L92
    L17:
        r11 = null;
        goto L18
    L94:
        return CollectionsKt.build(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<jc8.a> k2(f r1, List<? extends jc8.a> r2) {
        IBlockPipelineTask$a.b(r1, r2);
        return r2;
    }

    public final void m2(f r1, List<Block> r2, List<? extends jc8.a> r3) {
        IBlockPipelineTask$a.a(r1, r2, r3);
    }
}
