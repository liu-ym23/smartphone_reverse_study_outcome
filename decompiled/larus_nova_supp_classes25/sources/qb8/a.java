package qb8;

import android.os.SystemClock;
import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask;
import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask$a;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.BlockControlInfo;
import com.larus.im.bean.message.block.MetaInfoBlock;
import com.larus.im.bean.message.block.TextBlock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kc8.f;
import kc8.i0;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.GroupingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ra8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements IBlockPipelineTask {

    /* JADX INFO: renamed from: qb8.a$a, reason: collision with other inner class name */
    public static final class C0084a implements Grouping<jc8.a, Integer> {
        public final /* synthetic */ Iterable a;

        public final Iterator<jc8.a> sourceIterator() {
            return this.a.iterator();
        }

        public C0084a(Iterable r1) {
            this.a = r1;
        }

        public final Integer keyOf(jc8.a r1) {
            return Integer.valueOf(r1.l());
        }
    }

    public final int getPriority() {
        return 300;
    }

    public a() {
    }

    public final boolean n1(f r2) {
        Intrinsics.checkNotNullParameter(r2, "blockPipelineConfig");
        return true;
    }

    public final List<Block> d3(f r1, List<Block> r2) {
        IBlockPipelineTask$a.c(r1, r2);
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<jc8.a> k2(f r11, List<? extends jc8.a> r12) {
        Intrinsics.checkNotNullParameter(r11, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r12, "bizModelList");
        b r0 = r11.h;
        Boolean r1 = r11.b;
        if (r1 != null) goto L5;
        r1 = r0.e;
    L5:
        b r6 = b.a(r0, r1, r11.f, 79);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r11.h = r6;
        u(r12, null, r6, r11, false, false);
        return r12;
    }

    public final void m2(f r1, List<Block> r2, List<? extends jc8.a> r3) {
        IBlockPipelineTask$a.a(r1, r2, r3);
    }

    public static void u(List r20, jc8.a r21, b r22, f r23, boolean r24, boolean r25) {
        List r0 = r20;
        ArrayList r7 = new ArrayList();
        Iterator r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        Object r2 = r1.next();
        BlockControlInfo r3 = ((jc8.a) r2).a.getControlInfo();
        if (r3 == null) goto L8;
        boolean r8 = Intrinsics.areEqual(r3.isVisible(), Boolean.FALSE);
    L9:
        if (r8 == true) goto L4;
        r7.add(r2);
        goto L4
    L8:
        r8 = false;
        goto L9
    L11:
        Map r9 = GroupingKt.eachCount(new C0084a(r7));
        Iterator r10 = r0.iterator();
        jc8.a r4 = null;
        int r5 = 0;
    L13:
        if (r10.hasNext() == false) goto L161;
        jc8.a r6 = (jc8.a) r10.next();
        BlockControlInfo r11 = r6.a.getControlInfo();
        if (r11 == null) goto L17;
        boolean r12 = Intrinsics.areEqual(r11.isVisible(), Boolean.FALSE);
    L18:
        boolean r13 = !r12;
        if (r4 != null) goto L23;
        if (r24 == false) goto L22;
        jc8.a r14 = r21;
    L24:
        if (r13 == false) goto L26;
        int r15 = r5 + 1;
    L27:
        jc8.a r16 = (jc8.a) CollectionsKt.getOrNull(r7, r15);
        if (r16 != null) goto L32;
        if (r25 == false) goto L31;
        jc8.a r17 = r21;
    L33:
        if (r13 == false) goto L35;
        int r19 = r5 + 1;
        jc8.a r18 = r6;
    L36:
        Integer r26 = (Integer) r9.get(Integer.valueOf(r6.l()));
        if (r26 == null) goto L39;
        int r110 = r26.intValue();
    L40:
        String r27 = r6.h();
        if (r27.length() <= 0) goto L43;
        boolean r28 = true;
    L44:
        if (r28 == true) goto L47;
        r27 = null;
    L47:
        if (r27 == null) goto L55;
        kc8.e r29 = r23.g;
        if (r29 == null) goto L53;
        HashMap<String, i0> r30 = r29.b;
        if (r30 == null) goto L53;
        i0 r31 = r30.get(r27);
    L54:
        i0 r111 = r31;
    L56:
        jc8.f r32 = new jc8.f(r14, r17, r21, r110, r111);
        Intrinsics.checkNotNullParameter(r32, "blockPipelineContext");
        r6.d = r32;
        if (r6.c <= 0) goto L59;
    L61:
        Intrinsics.checkNotNullParameter(r22, "blockRenderContext");
        r6.e = r22;
        List<jc8.a> r33 = r6.i();
        ArrayList r34 = new ArrayList();
        Iterator<T> r35 = r33.iterator();
    L63:
        if (r35.hasNext() == false) goto L80;
        jc8.a r36 = (jc8.a) r35.next();
        BlockContent r112 = r36.a.getContent();
        if (r112 == null) goto L67;
        MetaInfoBlock r113 = r112.getMetaInfoBlock();
    L68:
        if (r113 == null) goto L70;
        List<jc8.a> r114 = r36.i();
    L72:
        if ((!r114.isEmpty()) == true) goto L75;
        r114 = null;
    L75:
        if (r114 == null) goto L77;
        Pair r37 = TuplesKt.to(r36, r114);
    L78:
        if (r37 == null) goto L63;
        r34.add(r37);
        goto L63
    L77:
        r37 = null;
        goto L78
    L70:
        r114 = CollectionsKt.listOf(r36);
        goto L72
    L67:
        r113 = null;
        goto L68
    L80:
        ArrayList r38 = new ArrayList();
        Iterator r39 = r34.iterator();
    L82:
        if (r39.hasNext() == false) goto L85;
        CollectionsKt.addAll(r38, (Iterable) ((Pair) r39.next()).getSecond());
        goto L82
    L85:
        if ((!r38.isEmpty()) == false) goto L160;
        BlockContent r40 = r6.a.getContent();
        if (r40 == null) goto L95;
        TextBlock r41 = r40.getTextBlock();
        if (r41 == null) goto L95;
        String r42 = r41.text;
        if (r42 == null) goto L95;
        byte[] r43 = StringsKt.encodeToByteArray(r42);
        if (r43 == null) goto L95;
        Integer r44 = Integer.valueOf(r43.length);
    L96:
        ArrayList r115 = new ArrayList();
        Iterator r45 = r34.iterator();
    L98:
        if (r45.hasNext() == false) goto L117;
        Object r116 = r45.next();
        List r117 = (List) ((Pair) r116).component2();
        if ((r117 instanceof Collection) == true) goto L102;
    L104:
        Iterator r118 = r117.iterator();
    L106:
        if (r118.hasNext() == false) goto L114;
        BlockControlInfo r119 = ((jc8.a) r118.next()).a.getControlInfo();
        if (r119 == null) goto L110;
        boolean r46 = Intrinsics.areEqual(r119.isVisible(), Boolean.FALSE);
    L112:
        if ((!r46) == false) goto L106;
        boolean r47 = true;
    L115:
        if (r47 == false) goto L98;
        r115.add(r116);
        goto L98
    L110:
        r46 = false;
    L114:
        r47 = false;
        goto L115
    L102:
        if (r117.isEmpty() == false) goto L104;
    L117:
        Pair r48 = (Pair) CollectionsKt.firstOrNull(r115);
        if (r48 == null) goto L128;
        jc8.a r49 = (jc8.a) r48.getFirst();
        if (r49 == null) goto L128;
        Block r50 = r49.a;
        if (r50 == null) goto L128;
        BlockContent r51 = r50.getContent();
        if (r51 == null) goto L128;
        MetaInfoBlock r52 = r51.getMetaInfoBlock();
        if (r52 == null) goto L128;
        Integer r53 = Integer.valueOf(r52.pos);
    L129:
        Pair r54 = (Pair) CollectionsKt.lastOrNull(r115);
        if (r54 == null) goto L140;
        jc8.a r55 = (jc8.a) r54.getFirst();
        if (r55 == null) goto L140;
        Block r56 = r55.a;
        if (r56 == null) goto L140;
        BlockContent r57 = r56.getContent();
        if (r57 == null) goto L140;
        MetaInfoBlock r58 = r57.getMetaInfoBlock();
        if (r58 == null) goto L140;
        Integer r59 = Integer.valueOf(r58.pos);
    L141:
        if (r44 != null) goto L143;
    L150:
        boolean r120 = false;
    L151:
        if (r44 == null) goto L158;
        if (r59 == null) goto L158;
        if (r59.intValue() < 0) goto L158;
        if (r59.intValue() >= r44.intValue()) goto L158;
        boolean r60 = true;
    L159:
        u(r38, r6, r22, r23, r120, r60);
    L158:
        r60 = false;
        goto L159
    L143:
        if (r44.intValue() <= 0) goto L150;
        if (r53 == null) goto L150;
        if (r53.intValue() != (-1)) goto L148;
    L149:
        r120 = true;
        goto L151
    L148:
        if (r53.intValue() <= 0) goto L150;
    L140:
        r59 = null;
    L128:
        r53 = null;
    L95:
        r44 = null;
    L160:
        r4 = r18;
        r5 = r19;
        goto L13
    L59:
        if (r6.a.isFinish() == false) goto L61;
        r6.c = RangesKt.coerceAtLeast(SystemClock.elapsedRealtime(), 1);
    L53:
        r31 = null;
        goto L54
    L55:
        r111 = null;
        goto L56
    L43:
        r28 = false;
        goto L44
    L39:
        r110 = 0;
        goto L40
    L35:
        r18 = r4;
        r19 = r5;
        goto L36
    L31:
        r17 = null;
        goto L33
    L32:
        r17 = r16;
        goto L33
    L26:
        r15 = r5;
        goto L27
    L22:
        r14 = null;
        goto L24
    L23:
        r14 = r4;
        goto L24
    L17:
        r12 = false;
        goto L18
    }
}
