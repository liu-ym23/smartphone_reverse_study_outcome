package rw0;

import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.deal.u;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public final String a;
    public final long b;
    public final boolean c;
    public final int d;
    public final u e;

    public f(i r19) {
        Intrinsics.checkNotNullParameter(r19, "dealSet");
        ArrayList r1 = new ArrayList();
        Iterator<T> r3 = r19.c().iterator();
        char r6 = 0;
        long r7 = 0;
        int r9 = 0;
        boolean r10 = false;
    L3:
        boolean r13 = true;
        if (r3.hasNext() == false) goto L19;
        u r12 = (u) r3.next();
        Pair[] r14 = new Pair[3];
        r14[r6] = TuplesKt.to("money", String.valueOf(r12.d));
        r14[1] = TuplesKt.to("given_scores", String.valueOf(r12.e));
        r14[2] = TuplesKt.to("money_paid", String.valueOf(r12.c));
        r1.add(MapsKt.mapOf(r14));
        Long r4 = Long.valueOf(r19.l());
        long r16 = r7;
        if (r4.longValue() == r12.b) goto L9;
        r13 = false;
    L9:
        if (r13 == false) goto L11;
        Long r15 = r4;
    L12:
        if (r15 == null) goto L14;
        r15.longValue();
        this.e = r12;
        r7 = r12.c;
        r10 = r12.h;
    L15:
        int r5 = r12.e;
        if (r5 <= 0) goto L18;
        r9 = r5;
    L18:
        r6 = 0;
        goto L3
    L14:
        r7 = r16;
        goto L15
    L11:
        r15 = null;
        goto L12
    L19:
        long r17 = r7;
        if (r17 != 0) goto L36;
        Iterator<T> r8 = r19.c().iterator();
    L23:
        if (r8.hasNext() == false) goto L30;
        Object r18 = r8.next();
        if (((u) r18).b != r19.d()) goto L27;
        boolean r20 = true;
    L28:
        if (r20 == false) goto L23;
        Object r110 = r18;
    L31:
        u r111 = (u) r110;
        this.e = r111;
        if (r111 == null) goto L34;
        long r22 = r111.c;
    L35:
        long r23 = r22;
    L37:
        this.c = r10;
        this.a = r1.toString();
        this.b = r23;
        this.d = r9;
        return;
    L34:
        r22 = 0;
        goto L35
    L27:
        r20 = false;
        goto L28
    L30:
        r110 = null;
        goto L31
    L36:
        r23 = r17;
        goto L37
    }
}
