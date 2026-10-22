package com.obric.assistant.block.common.click_intent;

import cca.c;
import cca.d;
import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.OClickActionBlock;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.block.omni.create_shortcut.CreateShortcutIntentBlockHolder;
import jc8.b;
import kc8.f;
import kc8.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/block/common/click_intent/ClickIntentBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "transformBlockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "blockBizModel", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClickIntentBlockProvider implements IBlockProvider {

    public static final class a {
    }

    static {
    }

    public ClickIntentBlockProvider() {
    }

    public final BlockProviderType N0() {
        return BlockProviderType.O_NORMAL_CLICK_INTENT_BLOCK;
    }

    public final b<? extends jc8.a> t0(jc8.a r4) {
        Intrinsics.checkNotNullParameter(r4, "blockBizModel");
        if ((r4 instanceof d) == false) goto L6;
        return new c();
    L6:
        if ((r4 instanceof dca.d) == false) goto L9;
        return new dca.c();
    L9:
        if ((r4 instanceof bca.a) == false) goto L12;
        return new bca.d();
    L12:
        if ((r4 instanceof com.obric.assistant.block.omni.create_shortcut.a) == true) goto L19;
        FLogger.a.w("ClickIntentBlockProvider", "unrecognized block biz model, blockBizModel: " + r4);
        return null;
    L19:
        return new CreateShortcutIntentBlockHolder();
    }

    public final jc8.a W1(f r5, jc8.a r6, Block r7) {
        Intrinsics.checkNotNullParameter(r5, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r7, "sourceData");
        BlockContent r8 = r7.getContent();
        if (r8 == null) goto L7;
        OClickActionBlock r9 = r8.getOClickActionBlock();
        if (r9 == null) goto L7;
        String r10 = r9.scene;
    L8:
        FLogger r1 = FLogger.a;
        r1.i("ClickIntentBlockProvider", "transformBlockBizModel: scene = " + r10);
        if (r10 != null) goto L11;
    L29:
        StringBuilder r11 = new StringBuilder("unrecognized scene, messageId: ");
        r11.append(g.a(r5).getLocalMessageId());
        r11.append(", blockId: ");
        r11.append(r7.getBlockId());
        r11.append(", scene: ");
        BlockContent r12 = r7.getContent();
        if (r12 == null) goto L34;
        OClickActionBlock r13 = r12.getOClickActionBlock();
        if (r13 == null) goto L34;
        String r14 = r13.scene;
    L35:
        r11.append(r14);
        r1.w("ClickIntentBlockProvider", r11.toString());
        return null;
    L34:
        r14 = null;
        goto L35
    L11:
        switch(r10.hashCode()) {
            case -191501435: goto L26;
            case 383514524: goto L22;
            case 573884457: goto L18;
            case 795615591: goto L14;
            default: goto L29;
        };
    L14:
        if (r10.equals("omni_task_finish") == false) goto L29;
        return new dca.d(r5, r7);
    L18:
        if (r10.equals("create_shortcut") == false) goto L29;
        return new com.obric.assistant.block.omni.create_shortcut.a(r5, r7);
    L22:
        if (r10.equals("clarify_content") == false) goto L29;
        return new bca.a(r5, r7);
    L26:
        if (r10.equals("feedback") == false) goto L29;
        return new d(r5, r7);
    L7:
        r10 = null;
        goto L8
    }
}
