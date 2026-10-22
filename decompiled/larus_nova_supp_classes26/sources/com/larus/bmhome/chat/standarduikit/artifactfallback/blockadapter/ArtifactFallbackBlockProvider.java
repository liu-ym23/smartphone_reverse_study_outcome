package com.larus.bmhome.chat.standarduikit.artifactfallback.blockadapter;

import com.larus.bmhome.chat.block.base.BlockProviderType;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.bmhome.chat.block.base.renderer.FileCardVMData;
import com.larus.common_ui.icon.CommonFileIconType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import jc8.b;
import kc8.f;
import kc8.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wk8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/artifactfallback/blockadapter/ArtifactFallbackBlockProvider;", "Lcom/larus/bmhome/chat/block/base/IBlockProvider;", "<init>", "()V", "providerType", "Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "getProviderType", "()Lcom/larus/bmhome/chat/block/base/BlockProviderType;", "transformBlockBizModel", "Lcom/larus/bmhome/chat/block/base/BaseBlockBizModel;", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "parentBlock", "sourceData", "Lcom/larus/im/bean/message/block/Block;", "createBlockHolder", "Lcom/larus/bmhome/chat/block/base/BaseBlockHolder;", "blockBizModel", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ArtifactFallbackBlockProvider implements IBlockProvider {
    public final BlockProviderType b;

    public static final class a {
    }

    static {
    }

    public ArtifactFallbackBlockProvider() {
        this.b = BlockProviderType.ARTIFACT_FALLBACK;
    }

    public final BlockProviderType N0() {
        return this.b;
    }

    public final b<? extends jc8.a> t0(jc8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "blockBizModel");
        if ((r2 instanceof wk8.a) == false) goto L6;
        return new e();
    L6:
        if ((r2 instanceof yi8.a) == true) goto L11;
        return null;
    L11:
        return new yi8.b();
    }

    public final jc8.a W1(f r22, jc8.a r23, Block r24) {
        Intrinsics.checkNotNullParameter(r22, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r24, "sourceData");
        BlockContent r1 = r24.getContent();
        if (r1 == null) goto L5;
        ArtifactBlock r2 = r1.getDocBlock();
    L6:
        boolean r4 = false;
        if (r2 == null) goto L14;
        Integer r6 = r2.getResourceType();
        if (r6 == null) goto L14;
        if (r6.intValue() != 17) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L21;
        Message r3 = g.a(r22);
        h19.b r5 = h19.b.a;
        CommonFileIconType r8 = CommonFileIconType.MARKDOWN;
        r5.getClass();
        Integer r9 = Integer.valueOf(h19.b.a(r8));
        String r10 = r2.getTitle();
        if (r10 != null) goto L20;
        r10 = "";
    L20:
        return new wk8.a(r3, r24, new FileCardVMData(r9, "", "", r10, null, "markdown", null, null, null, null, null, false, null, false, 24656));
    L21:
        if (r2 == null) goto L28;
        Integer r11 = r2.getResourceType();
        if (r11 == null) goto L28;
        if (r11.intValue() != 1) goto L28;
        boolean r12 = true;
    L29:
        if (r12 == true) goto L122;
        if (r2 == null) goto L37;
        Integer r13 = r2.getResourceType();
        if (r13 == null) goto L37;
        if (r13.intValue() != 2) goto L37;
        boolean r14 = true;
    L38:
        if (r14 == true) goto L122;
        if (r2 == null) goto L46;
        Integer r15 = r2.getResourceType();
        if (r15 == null) goto L46;
        if (r15.intValue() != 3) goto L46;
        boolean r16 = true;
    L47:
        if (r16 == true) goto L122;
        if (r2 == null) goto L55;
        Integer r17 = r2.getResourceType();
        if (r17 == null) goto L55;
        if (r17.intValue() != 4) goto L55;
        boolean r18 = true;
    L56:
        if (r18 == true) goto L122;
        if (r2 == null) goto L64;
        Integer r19 = r2.getResourceType();
        if (r19 == null) goto L64;
        if (r19.intValue() != 6) goto L64;
        boolean r20 = true;
    L65:
        if (r20 == true) goto L122;
        if (r2 == null) goto L73;
        Integer r21 = r2.getResourceType();
        if (r21 == null) goto L73;
        if (r21.intValue() != 10) goto L73;
        boolean r25 = true;
    L74:
        if (r25 == true) goto L122;
        if (r2 == null) goto L82;
        Integer r26 = r2.getResourceType();
        if (r26 == null) goto L82;
        if (r26.intValue() != 11) goto L82;
        boolean r27 = true;
    L83:
        if (r27 == true) goto L122;
        if (r2 == null) goto L91;
        Integer r28 = r2.getResourceType();
        if (r28 == null) goto L91;
        if (r28.intValue() != 12) goto L91;
        boolean r29 = true;
    L92:
        if (r29 == true) goto L122;
        if (r2 == null) goto L100;
        Integer r30 = r2.getResourceType();
        if (r30 == null) goto L100;
        if (r30.intValue() != 9) goto L100;
        boolean r31 = true;
    L101:
        if (r31 == true) goto L122;
        if (r2 == null) goto L109;
        Integer r32 = r2.getResourceType();
        if (r32 == null) goto L109;
        if (r32.intValue() != 5) goto L109;
        boolean r33 = true;
    L110:
        if (r33 == true) goto L122;
        if (r2 == null) goto L118;
        Integer r34 = r2.getResourceType();
        if (r34 == null) goto L118;
        if (r34.intValue() != 13) goto L118;
        r4 = true;
    L118:
        if (r4 == true) goto L122;
        return new yi8.a(g.a(r22), r24);
    L109:
        r33 = false;
    L100:
        r31 = false;
    L91:
        r29 = false;
    L82:
        r27 = false;
    L73:
        r25 = false;
    L64:
        r20 = false;
    L55:
        r18 = false;
    L46:
        r16 = false;
    L37:
        r14 = false;
    L122:
        return null;
    L28:
        r12 = false;
    L14:
        r7 = false;
        goto L15
    L5:
        r2 = null;
        goto L6
    }
}
