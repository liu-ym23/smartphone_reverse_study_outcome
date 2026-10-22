package com.larus.bmhome.interactionpanel;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k {
    public final tp8.a a;
    public final g b;
    public final AtomicInteger c;

    public static final class a {
    }

    static {
    }

    public k(tp8.a r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        Intrinsics.checkNotNullParameter(r3, "manager");
        this.a = r2;
        this.b = r3;
        this.c = new AtomicInteger();
    }

    public static List a(t r5, m r6) {
        if ((r5 instanceof t.b) == false) goto L6;
        List<Block> r7 = ((t.b) r5).b;
    L8:
        ArrayList r1 = new ArrayList();
        Iterator r0 = r7.iterator();
    L10:
        if (r0.hasNext() == false) goto L15;
        Object r2 = r0.next();
        if (Intrinsics.areEqual(((Block) r2).getBlockId(), r6.a.c) == false) goto L10;
        r1.add(r2);
        goto L10
    L15:
        if (r1.isEmpty() == true) goto L19;
        r7 = r1;
    L19:
        return r7;
    L6:
        if ((r5 instanceof t.a) == false) goto L21;
        r7 = ((t.a) r5).c;
        goto L8
    L21:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [com.larus.bmhome.interactionpanel.j] */
    public final boolean b(final m r19, final String r20, Message r21, List<Block> r22, int r23) {
        if (r23 == this.c.get()) goto L7;
        FLogger.a.i("InputAreaBlockPanelAdapter", "skip stale show, key=" + r19.a);
        return false;
    L7:
        if (r22.isEmpty() == false) goto L10;
        FLogger.a.w("InputAreaBlockPanelAdapter", "skip show, blocks empty, key=" + r19.a);
        return false;
    L10:
        Map r3 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(tp8.h.class, new tp8.h(new j(this, r19, r20)))});
        w r1 = r19.k;
        if (r1 == null) goto L13;
        r3.put(w.class, r1);
    L13:
        tp8.a r2 = this.a;
        List<Block> r4 = r22;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r6 = r4.iterator();
    L15:
        if (r6.hasNext() == false) goto L17;
        r5.add(Block.copy$default((Block) r6.next(), 0, null, null, null, false, null, null, null, 251, null));
        goto L15
    L17:
        r2.hN(r21, r5, r3);
        return true;
    }
}
