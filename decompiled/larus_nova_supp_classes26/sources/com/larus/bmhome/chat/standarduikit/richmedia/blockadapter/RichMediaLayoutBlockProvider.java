package com.larus.bmhome.chat.standarduikit.richmedia.blockadapter;

import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.RichMediaLayoutBlock;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jc8.a;
import jc8.b;
import kc8.f;
import kc8.g;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vd9.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001a\u0010\u0012\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/richmedia/blockadapter/RichMediaLayoutBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "transformBlockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "buildInteractionMessage", "Lcom/larus/im/bean/message/Message;", "message", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "blockBizModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RichMediaLayoutBlockProvider implements IBlockProvider {
    public final BlockProviderType b;

    public RichMediaLayoutBlockProvider() {
        this.b = BlockProviderType.RICH_MEDIA_LAYOUT_BLOCK;
    }

    public final BlockProviderType N0() {
        return this.b;
    }

    public final b<? extends a> t0(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        if ((r2 instanceof en8.a) == true) goto L7;
        return null;
    L7:
        return new en8.b();
    }

    public final a W1(f r50, a r51, Block r52) {
        Intrinsics.checkNotNullParameter(r50, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r52, "sourceData");
        BlockContent r1 = r52.getContent();
        en8.a r3 = null;
        if (r1 == null) goto L5;
        RichMediaLayoutBlock r2 = r1.getRichMediaLayoutBlock();
    L6:
        if (r2 == null) goto L33;
        Message r4 = g.a(r50);
        String r5 = r52.getBlockId();
        boolean r6 = true;
        if (r5 != null) goto L10;
    L13:
        boolean r7 = true;
    L15:
        if (r7 == false) goto L17;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r6 = r.a(r4).contains(r52);
    L29:
        if (r6 == true) goto L32;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        r4 = Message.copy$default(r4, null, null, null, 0, 0, null, 0, true, null, null, CollectionsKt.plus(r.a(r4), r52), null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -1153, 31, null);
    L32:
        r3 = new en8.a(r4, r52);
        goto L33
    L17:
        Intrinsics.checkNotNullParameter(r4, "<this>");
        List r8 = r.a(r4);
        if ((r8 instanceof Collection) == true) goto L20;
    L22:
        Iterator r9 = r8.iterator();
    L24:
        if (r9.hasNext() == false) goto L28;
        if (Intrinsics.areEqual(((Block) r9.next()).getBlockId(), r5) == false) goto L24;
    L28:
        r6 = false;
        goto L29
    L20:
        if (r8.isEmpty() == false) goto L22;
    L10:
        if (r5.length() == 0) goto L13;
        r7 = false;
    L33:
        return r3;
    L5:
        r2 = null;
        goto L6
    }
}
