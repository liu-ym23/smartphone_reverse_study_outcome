package com.larus.uaigc.chat.block.create;

import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.im.bean.message.CreationBlock;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\nH\u0016J$\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/larus/uaigc/chat/block/create/CreationBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockBizModel", "transformBlockBizModel", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationBlockProvider implements IBlockProvider {
    public final BlockProviderType b;

    public static final class a {
    }

    static {
    }

    public CreationBlockProvider() {
        this.b = BlockProviderType.CREATION_BLOCK;
    }

    public final BlockProviderType N0() {
        return this.b;
    }

    public final jc8.b<? extends jc8.a> t0(jc8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        if ((r2 instanceof com.larus.uaigc.chat.block.correction.a) == false) goto L6;
        return new com.larus.uaigc.chat.block.correction.e();
    L6:
        if ((r2 instanceof com.larus.uaigc.chat.block.create.vertical.h) == false) goto L9;
        return new com.larus.uaigc.chat.block.create.vertical.i();
    L9:
        if ((r2 instanceof com.larus.uaigc.chat.block.create.horizontal.k) == false) goto L12;
        return new com.larus.uaigc.chat.block.create.horizontal.l();
    L12:
        if ((r2 instanceof com.larus.uaigc.chat.block.create.vertical.a) == false) goto L15;
        return new com.larus.uaigc.chat.block.create.vertical.b();
    L15:
        return new com.larus.uaigc.chat.block.create.horizontal.b();
    }

    public final jc8.a W1(kc8.f r10, jc8.a r11, Block r12) {
        Intrinsics.checkNotNullParameter(r10, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r12, "sourceData");
        String r0 = null;
        if (r12.getContent() != null) goto L6;
        FLogger.a.w("CreationBlockProvider", "sourceData.content is null for blockId: " + r12.getBlockId());
        return null;
    L6:
        BlockContent r13 = r12.getContent();
        if (r13 == null) goto L11;
        CreationBlock r14 = r13.getCreationBlock();
        if (r14 == null) goto L11;
        List r15 = r14.creations;
    L12:
        if (r15 != null) goto L14;
        r15 = CollectionsKt.emptyList();
    L14:
        List r16 = r15;
        boolean r1 = r16 instanceof Collection;
        boolean r2 = false;
        if (r1 == true) goto L17;
    L19:
        Iterator r5 = r16.iterator();
    L21:
        if (r5.hasNext() == false) goto L37;
        CreationItem r6 = (CreationItem) r5.next();
        Integer r7 = r6.type;
        if (r7 != null) goto L26;
    L27:
        Integer r8 = r6.type;
        if (r8 != null) goto L31;
    L33:
        boolean r9 = false;
    L35:
        if (r9 == false) goto L21;
        boolean r17 = true;
    L38:
        if (r1 == true) goto L40;
    L42:
        Iterator r18 = r16.iterator();
    L44:
        if (r18.hasNext() == false) goto L54;
        Integer r19 = ((CreationItem) r18.next()).type;
        if (r19 != null) goto L49;
    L51:
        boolean r20 = false;
    L52:
        if (r20 == false) goto L44;
        boolean r4 = true;
    L55:
        if (r1 == true) goto L57;
    L59:
        Iterator r110 = r16.iterator();
    L61:
        if (r110.hasNext() == false) goto L71;
        Integer r3 = ((CreationItem) r110.next()).type;
        if (r3 != null) goto L66;
    L68:
        boolean r21 = false;
    L69:
        if (r21 == false) goto L61;
        r2 = true;
        goto L71
    L66:
        if (r3.intValue() != 2) goto L68;
        r21 = true;
    L71:
        BlockContent r111 = r12.getContent();
        if (r111 == null) goto L77;
        CreationBlock r112 = r111.getCreationBlock();
        if (r112 == null) goto L77;
        r0 = r112.scene;
    L77:
        if (Intrinsics.areEqual(r0, "homework_correction") == true) goto L102;
        if (r4 == true) goto L103;
        if (r17 == true) goto L104;
        if (r2 == false) goto L86;
        return new com.larus.uaigc.chat.block.create.vertical.a(kc8.g.a(r10), r12);
    L86:
        return new com.larus.uaigc.chat.block.create.horizontal.a(kc8.g.a(r10), r12);
    L104:
        return new com.larus.uaigc.chat.block.create.horizontal.k(kc8.g.a(r10), r12);
    L103:
        return new com.larus.uaigc.chat.block.create.vertical.h(kc8.g.a(r10), r12);
    L102:
        return new com.larus.uaigc.chat.block.correction.a(kc8.g.a(r10), r12);
    L57:
        if (r16.isEmpty() == false) goto L59;
    L49:
        if (r19.intValue() != 4) goto L51;
        r20 = true;
    L54:
        r4 = false;
        goto L55
    L40:
        if (r16.isEmpty() == false) goto L42;
    L31:
        if (r8.intValue() != 4) goto L33;
    L34:
        r9 = true;
        goto L35
    L26:
        if (r7.intValue() == 3) goto L34;
    L37:
        r17 = false;
        goto L38
    L17:
        if (r16.isEmpty() == false) goto L19;
    L11:
        r15 = null;
        goto L12
    }
}
