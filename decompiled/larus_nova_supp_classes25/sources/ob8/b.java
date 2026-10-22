package ob8;

import com.larus.bmhome.block.pipeline.api.IBlockPipelineTask;
import com.larus.bmhome.chat.block.base.IBlockProvider;
import com.larus.im.bean.message.block.Block;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc8.h;
import kc8.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b {
    public static final Lazy a = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r1, T r2) {
            return ComparisonsKt.compareValues(Integer.valueOf(((IBlockPipelineTask) r1).getPriority()), Integer.valueOf(((IBlockPipelineTask) r2).getPriority()));
        }
    }

    static {
        a = LazyKt.lazy(new ob8.a());
    }

    public static List a(List r14, f r15) {
        Intrinsics.checkNotNullParameter(r14, "blockList");
        Intrinsics.checkNotNullParameter(r15, "blockConfig");
        ra8.b r1 = r15.h;
        Boolean r2 = r15.b;
        if (r2 != null) goto L5;
        r2 = r1.e;
    L5:
        ra8.b r3 = ra8.b.a(r1, r2, r15.f, 79);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r15.h = r3;
        List r4 = (List) a.getValue();
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        Object r7 = r6.next();
        if (((IBlockPipelineTask) r7).n1(r15) == false) goto L7;
        r5.add(r7);
        goto L7
    L11:
        Iterator r8 = r5.iterator();
        List r9 = r14;
    L13:
        if (r8.hasNext() == false) goto L15;
        r9 = ((IBlockPipelineTask) r8.next()).d3(r15, r9);
        goto L13
    L15:
        Intrinsics.checkNotNullParameter(r9, "blockList");
        Intrinsics.checkNotNullParameter(r15, "blockPipelineConfig");
        LinkedHashMap r10 = new LinkedHashMap();
        ArrayList r11 = new ArrayList();
        Iterator r12 = r9.iterator();
    L17:
        if (r12.hasNext() == false) goto L68;
        Block r13 = (Block) r12.next();
        String r16 = r13.getParentId();
        String r17 = "";
        if (r16 != null) goto L21;
        r16 = "";
    L21:
        jc8.a r18 = (jc8.a) r10.get(r16);
        Map<Integer, List<IBlockProvider>> r19 = h.a;
        List r20 = h.a(r13.getBlockType());
        boolean r21 = false;
        jc8.a r110 = null;
        if (r20 == null) goto L31;
        Iterator r111 = r20.iterator();
    L25:
        if (r111.hasNext() == false) goto L29;
        jc8.a r112 = ((IBlockProvider) r111.next()).W1(r15, r18, r13);
        if (r112 == null) goto L25;
    L30:
        if (r112 == null) goto L31;
    L46:
        String r22 = r13.getBlockId();
        if (r22 == null) goto L50;
        r17 = r22;
    L50:
        r10.put(r17, r112);
        String r23 = r13.getParentId();
        if (r23 != null) goto L53;
    L56:
        boolean r24 = true;
    L57:
        if (r24 == false) goto L59;
        r11.add(r112);
    L59:
        String r25 = r112.a.getParentId();
        if (r25 != null) goto L62;
    L63:
        r21 = true;
    L64:
        if (r21 == true) goto L17;
        if (r18 == null) goto L17;
        Intrinsics.checkNotNullParameter(r112, "block");
        ((ArrayList) r18.h).add(r112);
        goto L17
    L62:
        if (r25.length() != 0) goto L64;
    L53:
        if (r23.length() == 0) goto L56;
        r24 = false;
        goto L57
    L29:
        r112 = null;
    L31:
        IBlockProvider r113 = h.b;
        if (r113 == null) goto L43;
        if (r20 != null) goto L35;
    L37:
        boolean r26 = false;
    L38:
        if (r26 == false) goto L41;
        r113 = null;
    L41:
        if (r113 == null) goto L43;
        r110 = r113.W1(r15, r18, r13);
        goto L43
    L35:
        if (r20.contains(r113) != true) goto L37;
        r26 = true;
    L43:
        if (r110 == null) goto L17;
        r112 = r110;
        goto L46
    L68:
        List r27 = CollectionsKt.toList(r11);
        Iterator r28 = r5.iterator();
    L70:
        if (r28.hasNext() == false) goto L75;
        IBlockPipelineTask r29 = (IBlockPipelineTask) r28.next();
        Intrinsics.checkNotNullParameter(r29, "<this>");
        Intrinsics.checkNotNullParameter(r15, "blockPipelineConfig");
        Intrinsics.checkNotNullParameter(r14, "sourceBlockList");
        Intrinsics.checkNotNullParameter(r27, "bizModelList");
        if ((r29 instanceof pb8.a) == true) goto L73;
        r27 = r29.k2(r15, r27);
        goto L70
    L73:
        r27 = ((pb8.a) r29).D0();
        goto L70
    L75:
        Iterator r0 = r5.iterator();
    L77:
        if (r0.hasNext() == false) goto L79;
        ((IBlockPipelineTask) r0.next()).m2(r15, r14, r27);
        goto L77
    L79:
        return r27;
    }
}
