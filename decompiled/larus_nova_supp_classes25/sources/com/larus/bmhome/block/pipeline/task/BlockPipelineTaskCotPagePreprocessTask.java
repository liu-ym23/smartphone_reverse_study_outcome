package com.larus.bmhome.block.pipeline.task;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask;
import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask$a;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockControlInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kc8.e;
import kc8.f;
import kc8.g;
import kc8.i0;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\f\u0010\u0011\u001a\u00020\t*\u00020\u000eH\u0002J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0013\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0014\u001a\u00020\tH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/block/pipeline/task/BlockPipelineTaskCotPagePreprocessTask;", "Lcom/larus/bmhome/block/pipeline/api/IBlockPipelineTask;", "<init>", "()V", "priority", "", "getPriority", "()I", "supports", "", "blockPipelineConfig", "Lcom/larus/bmhome/chat/block/base/config/BlockPipelineConfig;", "processBlocks", "", "Lcom/larus/im/bean/message/block/Block;", "blockList", "preprocessFloatingThinkingBlocks", "isInvisibleTextBlock", "processPreambleStyle", "blockConfig", "messageFinished", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BlockPipelineTaskCotPagePreprocessTask implements IBlockPipelineTask {
    public final int b;

    public static final class a {
    }

    static {
    }

    public BlockPipelineTaskCotPagePreprocessTask() {
        this.b = 400;
    }

    public final int getPriority() {
        return this.b;
    }

    public static boolean u(Block r3) {
        if (r3.getBlockType() != j.e) goto L11;
        BlockControlInfo r4 = r3.getControlInfo();
        if (r4 == null) goto L7;
        boolean r5 = Intrinsics.areEqual(r4.isVisible(), Boolean.FALSE);
    L8:
        if (r5 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r5 = false;
        goto L8
    L11:
        return false;
    }

    public final boolean n1(f r2) {
        Intrinsics.checkNotNullParameter(r2, "blockPipelineConfig");
        if (r2.a != null) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r2.f, "smart_reply_nested_container") == true) goto L7;
        return true;
    }

    public final List<Block> d3(f r28, List<Block> r29) {
        Intrinsics.checkNotNullParameter(r28, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r29, "blockList");
        e r2 = r28.g;
        if (r2 == null) goto L7;
        HashMap<String, i0> r3 = r2.b;
        if (r3 == null) goto L7;
        r3.clear();
    L7:
        Map r4 = g.a(r28).getExt();
        if (r4 == null) goto L10;
        String r5 = (String) r4.get("need_lazy_load");
    L12:
        if (Intrinsics.areEqual(r5, "1") == false) goto L14;
        return r29;
    L14:
        LinkedHashMap r6 = new LinkedHashMap();
        List<Block> r7 = r29;
        Iterator<T> r8 = r7.iterator();
    L15:
        boolean r9 = true;
        if (r8.hasNext() == false) goto L27;
        Block r10 = (Block) r8.next();
        String r11 = r10.getBlockId();
        if (r10.getBlockType() != j.A) goto L15;
        if (r11 != null) goto L21;
    L24:
        if (r9 == true) goto L15;
        r6.put(r11, r10);
        goto L15
    L21:
        if (r11.length() == 0) goto L24;
        r9 = false;
        goto L24
    L27:
        if (r6.isEmpty() == true) goto L296;
        HashMap r12 = new HashMap(r6.size());
        HashMap r13 = new HashMap(r6.size());
        HashMap r14 = new HashMap();
        Iterator<T> r15 = r7.iterator();
    L31:
        if (r15.hasNext() == false) goto L70;
        Block r16 = (Block) r15.next();
        String r17 = r16.getParentId();
        String r18 = r16.getBlockId();
        if (r17 != null) goto L35;
    L38:
        boolean r19 = true;
    L39:
        if (r19 == true) goto L51;
        if (r18 != null) goto L42;
    L45:
        boolean r110 = true;
    L46:
        if (r110 == true) goto L51;
        Object r111 = r14.get(r17);
        if (r111 != null) goto L50;
        r111 = new ArrayList();
        r14.put(r17, r111);
    L50:
        ((List) r111).add(r18);
        goto L51
    L42:
        if (r18.length() == 0) goto L45;
        r110 = false;
    L51:
        if (r17 != null) goto L53;
    L56:
        boolean r112 = true;
    L57:
        if (r112 == true) goto L31;
        if (r6.containsKey(r17) == false) goto L31;
        if (u(r16) == true) goto L31;
        Integer r113 = (Integer) r12.get(r17);
        if (r113 == null) goto L65;
        int r114 = r113.intValue();
    L66:
        int r115 = r114 + 1;
        r12.put(r17, Integer.valueOf(r115));
        if (r115 == 1) goto L68;
        r13.remove(r17);
        goto L31
    L68:
        r13.put(r17, r16);
        goto L31
    L65:
        r114 = 0;
        goto L66
    L53:
        if (r17.length() == 0) goto L56;
        r112 = false;
        goto L57
    L35:
        if (r17.length() == 0) goto L38;
        r19 = false;
        goto L39
    L70:
        HashSet r116 = new HashSet();
        HashSet r117 = new HashSet();
        Iterator<T> r118 = r7.iterator();
    L72:
        if (r118.hasNext() == false) goto L103;
        Block r119 = (Block) r118.next();
        String r120 = r119.getBlockId();
        if (r119.getBlockType() != j.A) goto L72;
        if (r120 != null) goto L77;
    L80:
        boolean r20 = true;
    L81:
        if (r20 == true) goto L72;
        Integer r21 = (Integer) r12.get(r120);
        if (r21 == null) goto L86;
        int r22 = r21.intValue();
    L88:
        if (r119.isFinish() == false) goto L92;
        if (r22 != 0) goto L92;
        r116.add(r120);
    L92:
        if (r119.isFinish() == false) goto L72;
        if (r22 != 1) goto L72;
        Block r23 = (Block) r13.get(r120);
        if (r23 != null) goto L97;
    L99:
        boolean r24 = false;
    L100:
        if (r24 == true) goto L72;
        r117.add(r120);
        goto L72
    L97:
        if (r23.getBlockType() != j.e) goto L99;
        r24 = true;
        goto L100
    L86:
        r22 = 0;
        goto L88
    L77:
        if (r120.length() == 0) goto L80;
        r20 = false;
        goto L81
    L103:
        if (r116.isEmpty() == false) goto L108;
        if (r117.isEmpty() == false) goto L108;
        return r29;
    L108:
        if ((!r117.isEmpty()) == false) goto L113;
        e r1 = r28.g;
        if (r1 != null) goto L112;
        r1 = new e(null);
        r28.g = r1;
    L112:
        HashMap<String, i0> r0 = r1.b;
    L114:
        HashSet r25 = new HashSet(r116);
        Iterator<T> r26 = r7.iterator();
    L116:
        if (r26.hasNext() == false) goto L133;
        Block r27 = (Block) r26.next();
        if (u(r27) == false) goto L116;
        if (CollectionsKt.contains(r117, r27.getParentId()) == false) goto L116;
        String r30 = r27.getBlockId();
        if (r30 == null) goto L116;
        if (r30.length() <= 0) goto L126;
        boolean r31 = true;
    L127:
        if (r31 == true) goto L130;
        r30 = null;
    L130:
        if (r30 == null) goto L116;
        r25.add(r30);
        goto L116
    L126:
        r31 = false;
        goto L127
    L133:
        if ((!r25.isEmpty()) == false) goto L147;
        List r32 = CollectionsKt.toMutableList(r25);
        int r33 = 0;
    L136:
        if (r33 >= r32.size()) goto L147;
        int r34 = r33 + 1;
        List r35 = (List) r14.get((String) ListProtector.get(r32, r33));
        if (r35 != null) goto L140;
        r35 = CollectionsKt.emptyList();
    L140:
        Iterator r36 = r35.iterator();
    L142:
        if (r36.hasNext() == false) goto L146;
        String r121 = (String) r36.next();
        if (r25.add(r121) == false) goto L142;
        r32.add(r121);
        goto L142
    L146:
        r33 = r34;
    L147:
        ArrayList r37 = new ArrayList();
        Iterator<T> r38 = r7.iterator();
    L149:
        if (r38.hasNext() == false) goto L229;
        Block r122 = (Block) r38.next();
        String r39 = r122.getBlockId();
        String r40 = r122.getParentId();
        if (r39 != null) goto L153;
    L156:
        boolean r41 = true;
    L157:
        if (r41 == false) goto L159;
    L160:
        if (r40 != null) goto L162;
    L165:
        boolean r42 = true;
    L166:
        if (r42 == true) goto L171;
        if (r25.contains(r40) == false) goto L171;
    L186:
        Block r43 = null;
    L226:
        if (r43 == null) goto L149;
        r37.add(r43);
    L171:
        if (r122.getBlockType() != j.A) goto L183;
        if (r39 != null) goto L174;
    L177:
        boolean r44 = true;
    L178:
        if (r44 == true) goto L183;
        if (r117.contains(r39) == false) goto L183;
    L174:
        if (r39.length() == 0) goto L177;
        r44 = false;
    L183:
        if (u(r122) == true) goto L185;
    L187:
        if (r40 != null) goto L189;
    L192:
        boolean r45 = true;
    L193:
        if (r45 == false) goto L195;
    L225:
        r43 = r122;
        goto L226
    L195:
        if (r117.contains(r40) == false) goto L225;
        if (r39 != null) goto L198;
    L201:
        boolean r46 = true;
    L202:
        if (r46 == true) goto L214;
        if (r40 != null) goto L205;
    L208:
        boolean r47 = true;
    L209:
        if (r47 == true) goto L214;
        Block r48 = (Block) r6.get(r40);
        if (r48 == null) goto L214;
        if (r0 == null) goto L214;
        r0.put(r39, new i0(r40, r48.getBlockType()));
        goto L214
    L205:
        if (r40.length() == 0) goto L208;
        r47 = false;
    L214:
        LinkedHashSet r49 = new LinkedHashSet();
    L216:
        if (CollectionsKt.contains(r117, r40) == false) goto L224;
        if (r40 == null) goto L224;
        if (r49.add(r40) == false) goto L224;
        Block r50 = (Block) r6.get(r40);
        if (r50 != null) goto L222;
        r40 = null;
        goto L216
    L222:
        r40 = r50.getParentId();
    L224:
        r122 = Block.copy$default(r122, 0, null, r40, null, false, null, null, null, 251, null);
        goto L225
    L198:
        if (r39.length() == 0) goto L201;
        r46 = false;
        goto L202
    L189:
        if (r40.length() == 0) goto L192;
        r45 = false;
        goto L193
    L185:
        if (CollectionsKt.contains(r117, r40) == false) goto L187;
    L162:
        if (r40.length() == 0) goto L165;
        r42 = false;
        goto L166
    L159:
        if (r25.contains(r39) == true) goto L186;
    L153:
        if (r39.length() == 0) goto L156;
        r41 = false;
        goto L157
    L229:
        return r37;
    L113:
        r0 = null;
        goto L114
    L296:
        return r29;
    L10:
        r5 = null;
        goto L12
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
