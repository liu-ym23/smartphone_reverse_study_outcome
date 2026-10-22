package xd8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskStageEnum;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class c implements td8.b {
    public final td8.d a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    @Override // td8.b
    public final void b() {
    }

    @Override // td8.b
    public final PipelineTaskStageEnum stage() {
        return PipelineTaskStageEnum.NEED_TRAVERSAL;
    }

    public c(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
        this.b = LazyKt.lazy(new b(this));
    }

    @Override // td8.b
    public final com.larus.bmhome.social.page.datasource.event.c<xc8.b> a(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r21) {
        Intrinsics.checkNotNullParameter(r21, "input");
        ArrayList r2 = new ArrayList();
        FLogger.a.i("Pipeline_List_NeedTraversalStage", "start NeedTraversalStage, origin version is " + r21.b + ", origin size is " + r21.a.size());
        if (this.a.E8() == false) goto L24;
        List r3 = (List) this.b.getValue();
        ArrayList r6 = new ArrayList();
        Iterator r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        Object r7 = r4.next();
        if ((r7 instanceof g) == false) goto L6;
        r6.add(r7);
        goto L6
    L10:
        g r5 = (g) CollectionsKt.firstOrNull(r6);
        if (r5 == null) goto L24;
        List r8 = r21.a;
        Intrinsics.checkNotNullParameter(r8, "messages");
        if (r8.isEmpty() == false) goto L15;
        Set<Integer> r9 = SetsKt.emptySet();
    L23:
        r5.d = r9;
        goto L24
    L15:
        vi8.c.a.getClass();
        long r10 = ((vi8.a) vi8.c.b.getValue()).a;
        Set<Integer> r11 = SetsKt.mutableSetOf(new Integer[]{Integer.valueOf(CollectionsKt.getLastIndex(r8))});
        long r12 = ((xc8.b) CollectionsKt.last(r8)).getMessage().getCreateTime();
        int r13 = CollectionsKt.getLastIndex(r8) - 1;
    L17:
        if ((-1) >= r13) goto L22;
        long r14 = ((xc8.b) ListProtector.get(r8, r13)).getMessage().getCreateTime();
        if ((r14 - r12) < r10) goto L21;
        r11.add(Integer.valueOf(r13));
        r12 = r14;
    L21:
        r13 = r13 - 1;
        goto L17
    L22:
        r9 = r11;
    L24:
        Iterator r15 = r21.a.iterator();
        int r16 = 0;
    L26:
        if (r15.hasNext() == false) goto L47;
        Object r17 = r15.next();
        int r18 = r16 + 1;
        if (r16 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        xc8.b r19 = (xc8.b) r17;
        xc8.b r110 = (xc8.b) CollectionsKt.getOrNull(r21.a, r16 - 1);
        Iterator r111 = ((List) this.b.getValue()).iterator();
    L32:
        if (r111.hasNext() == false) goto L46;
        td8.c r112 = (td8.c) r111.next();
        if (r112 == null) goto L38;
        td8.c r20 = r112;
        xc8.b r113 = r110;
        if (td8.c.a.a(r112, r16, r110, r19, null, 8) != true) goto L39;
        boolean r22 = true;
    L40:
        if (r22 == true) goto L41;
        r110 = r113;
        goto L32
    L41:
        if (r20 == null) goto L43;
        r2.addAll(r20.b(r16, r113, r19, r2));
    L43:
        r16 = r18;
    L39:
        r22 = false;
        goto L40
    L38:
        r20 = r112;
        r113 = r110;
        goto L39
    L46:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L47:
        com.larus.bmhome.social.page.datasource.event.c<xc8.b> r1 = com.larus.bmhome.social.page.datasource.event.c.a(r21, r2, 0, null, null, 14);
        FLogger.a.i("Pipeline_List_NeedTraversalStage", "end NeedTraversalStage, result version is " + r1.b + ", result size is " + r1.a.size());
        return r1;
    }
}
