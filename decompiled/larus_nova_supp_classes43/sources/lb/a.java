package lb;

import com.bytedance.android.anya.BaseMVIViewModel;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.a0;
import com.bytedance.android.anya.internal.SubStatePropertyImpl;
import com.bytedance.android.anya.internal.q;
import com.bytedance.android.anya.internal.t;
import com.bytedance.android.anya.internal.u;
import com.bytedance.android.anya.r0;
import com.bytedance.android.anya.s;
import com.bytedance.android.anya.t0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends h<b> implements b {
    public static final /* synthetic */ int c = 0;
    public final BaseMVIViewModel<?, ?> b;

    /* JADX INFO: renamed from: lb.a$a, reason: collision with other inner class name */
    public static final class C0177a {
        /* JADX WARN: Multi-variable type inference failed */
        public static i a(MVIState r14, boolean r15) {
            LinkedHashSet r0 = new LinkedHashSet();
            LinkedHashSet r1 = new LinkedHashSet();
            LinkedHashSet r10 = new LinkedHashSet();
            LinkedHashSet r11 = new LinkedHashSet();
            if (r15 == false) goto L5;
            Set<com.bytedance.android.anya.internal.c<?, ?>> r16 = r14.properties.values();
        L6:
            Iterator r17 = r16.iterator();
        L8:
            if (r17.hasNext() == false) goto L67;
            com.bytedance.android.anya.internal.c r12 = (com.bytedance.android.anya.internal.c) r17.next();
            if ((r12 instanceof r0) == true) goto L11;
            if ((r12 instanceof SubStatePropertyImpl) == true) goto L14;
            if ((r12 instanceof q) == true) goto L17;
            if ((r12 instanceof u) == false) goto L8;
            int r13 = 0;
            if (r15 == true) goto L22;
            int r18 = a.c;
            u r19 = (u) r12;
            t r20 = (t) r19.c();
            List<t.b> r21 = r20.c;     // Catch: Throwable -> L64
            if (Intrinsics.areEqual((t.b) CollectionsKt.firstOrNull(r21), t.b.a.c) == false) goto L30;
            List r22 = CollectionsKt.emptyList();     // Catch: Throwable -> L64
        L47:
            LinkedHashMap r23 = new LinkedHashMap();
            Iterator r24 = r22.iterator();
            int r25 = 0;
        L49:
            if (r24.hasNext() == false) goto L57;
            Object r110 = r24.next();
            int r111 = r25 + 1;
            if (r25 >= 0) goto L53;
            CollectionsKt.throwIndexOverflow();
        L53:
            int r112 = ((Number) r110).intValue();
            if (r112 < 0) goto L56;
            r23.put(Integer.valueOf(r112), Integer.valueOf(r25));
        L56:
            r25 = r111;
            goto L49
        L57:
            int r26 = r20.size();
            ArrayList r27 = new ArrayList(r26);
            int r113 = 0;
        L58:
            if (r113 >= r26) goto L63;
            Integer r114 = (Integer) r23.get(Integer.valueOf(r113));
            if (r114 == null) goto L62;
            r114.intValue();
        L62:
            int r115 = a.c;
            r27.add(new j.a(a(r20.a(r113), false)));
            r113 = r113 + 1;
            goto L58
        L63:
            r11.add(new j(r19, r27));
            goto L8
        L30:
            int r28 = r20.size();     // Catch: Throwable -> L64
            ArrayList r29 = new ArrayList(r28);     // Catch: Throwable -> L64
            int r116 = 0;
        L31:
            if (r116 >= r28) goto L33;
            r29.add(Integer.valueOf(r116));     // Catch: Throwable -> L64
            r116 = r116 + 1;     // Catch: Throwable -> L64
            goto L31
        L33:
            Iterator r30 = CollectionsKt.reversed(r21).iterator();     // Catch: Throwable -> L64
        L35:
            if (r30.hasNext() == false) goto L46;
            t.b r31 = (t.b) r30.next();     // Catch: Throwable -> L64
            if ((r31 instanceof t.b.c) == true) goto L38;
            if ((r31 instanceof t.b.d) == false) goto L35;
            int r117 = r31.a;     // Catch: Throwable -> L64
            int r32 = r31.b;     // Catch: Throwable -> L64
            ArrayList r118 = new ArrayList(r32);     // Catch: Throwable -> L64
            int r119 = 0;
        L42:
            if (r119 >= r32) goto L44;
            r118.add(-1);     // Catch: Throwable -> L64
            r119 = r119 + 1;     // Catch: Throwable -> L64
            goto L42
        L44:
            r29.addAll(r117, r118);     // Catch: Throwable -> L64
            goto L35
        L38:
            int r120 = r31.a;     // Catch: Throwable -> L64
            r29.subList(r120, r31.b + r120).clear();     // Catch: Throwable -> L64
            goto L35
        L46:
            r22 = r29;
        L64:
            th = move-exception;
            throw th;
        L22:
            t r33 = (t) ((u) r12).c();
            t0 r34 = (t0) r12;
            int r35 = r33.size();
            ArrayList r36 = new ArrayList(r35);
        L23:
            if (r13 >= r35) goto L25;
            int r121 = a.c;
            r36.add(new j.a(a(r33.a(r13), true)));
            r13 = r13 + 1;
            goto L23
        L25:
            r11.add(new j(r34, r36));
            goto L8
        L17:
            int r37 = a.c;
            q r38 = (q) r12;
            r10.add(new l(a((MVIState) r38.c(), r15), new k(r12, r38.c())));
            goto L8
        L14:
            int r39 = a.c;
            SubStatePropertyImpl r40 = (SubStatePropertyImpl) r12;
            r1.add(new l(a((MVIState) r40.c(), r15), new k(r12, r40.c())));
            goto L8
        L11:
            r0.add(new k(r12, r12.c()));
            goto L8
        L67:
            return new i(r0, r1, r10, r11);
        L5:
            r16 = r14.modifiedProperties;
            goto L6
        }
    }

    static {
    }

    @Override // lb.b
    public final void b(com.bytedance.android.anya.q r10) {
        Iterator r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).b(r10);
        goto L4
    }

    @Override // lb.b
    public final /* bridge */ /* synthetic */ f j(s r1) {
        return k(r1);
    }

    public final e k(s r10) {
        MVIState r0 = this.b.L();
        Collection r1 = this.a;
        ArrayList r11 = new ArrayList();
        Iterator r12 = r1.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        f r13 = ((b) r12.next()).j(r10);
        if (r13 == null) goto L4;
        r11.add(r13);
        goto L4
    L9:
        return new e(r0, r11);
    }

    public a(BaseMVIViewModel<?, ?> r1, Collection<? extends b> r10) {
        super(r10);
        this.b = r1;
    }

    @Override // lb.b
    public final void a(a0 r10, MVIState<?> r11) {
        Iterator r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).a(r10, r11);
        goto L4
    }

    @Override // lb.b
    public final void c(i r10, BaseMVIViewModel<?, ?> r11) {
        Iterator r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((b) r0.next()).c(r10, r11);
        goto L4
    }
}
