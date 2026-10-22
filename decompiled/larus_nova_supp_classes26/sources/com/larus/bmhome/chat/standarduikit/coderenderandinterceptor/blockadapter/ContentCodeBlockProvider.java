package com.larus.bmhome.chat.standarduikit.coderenderandinterceptor.blockadapter;

import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.block.Block;
import java.util.HashMap;
import jc8.a;
import jc8.b;
import kc8.f;
import kc8.g;
import kc8.i0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pj8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/coderenderandinterceptor/blockadapter/ContentCodeBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "transformBlockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "blockBizModel", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContentCodeBlockProvider implements IBlockProvider {
    public final BlockProviderType b;

    public ContentCodeBlockProvider() {
        this.b = BlockProviderType.CODE_BLOCK;
    }

    public final BlockProviderType N0() {
        return this.b;
    }

    public final b<? extends a> t0(a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        if ((r2 instanceof pj8.a) == true) goto L7;
        return null;
    L7:
        return new e();
    }

    public final a W1(f r4, a r5, Block r6) {
        Intrinsics.checkNotNullParameter(r4, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r6, "sourceData");
        String r0 = r6.getBlockId();
        if (r0 == null) goto L12;
        kc8.e r2 = r4.g;
        if (r2 == null) goto L9;
        HashMap r3 = r2.b;
        if (r3 == null) goto L9;
        i0 r1 = (i0) r3.get(r0);
    L10:
        if (r1 == null) goto L12;
        Integer r7 = Integer.valueOf(r1.b);
    L13:
        if (r5 == null) goto L19;
        Block r8 = r5.a;
        if (r8 == null) goto L19;
        if (r8.getBlockType() != j.A) goto L19;
        boolean r9 = true;
    L20:
        if (r9 == true) goto L29;
        int r10 = j.A;
        if (r7 == null) goto L28;
        if (r7.intValue() == r10) goto L29;
    L28:
        return new pj8.a(g.a(r4), r6);
    L29:
        return null;
    L19:
        r9 = false;
    L9:
        r1 = null;
    L12:
        r7 = null;
        goto L13
    }
}
