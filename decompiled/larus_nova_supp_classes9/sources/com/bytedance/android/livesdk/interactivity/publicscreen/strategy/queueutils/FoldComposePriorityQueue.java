package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import android.os.Build;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.PersonalizedDisplayInfo;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class FoldComposePriorityQueue implements h {
    public final Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> a;
    public final Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> b;
    public final Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> c;
    public final Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> d;

    public static final class a<T> implements Comparator {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r5, Object r6) {
            com.bytedance.android.livesdk.interactivity.api.entity.f r7 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r5;
            com.bytedance.android.livesdk.interactivity.api.entity.f r8 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r6;
            if (r7 != null) goto L5;
            return 1;
        L5:
            if (r8 != null) goto L7;
            return -1;
        L7:
            IPublicAreaCommon r0 = r8.v();
            Long r1 = null;
            if (r0 == null) goto L10;
            Long r2 = r0.getForceInsertionPriority();
        L11:
            IPublicAreaCommon r3 = r7.v();
            if (r3 == null) goto L15;
            r1 = r3.getForceInsertionPriority();
        L15:
            if (Intrinsics.areEqual(r2, r1) == true) goto L32;
            IPublicAreaCommon r9 = r8.v();
            long r4 = 0;
            if (r9 == null) goto L22;
            Long r10 = r9.getForceInsertionPriority();
            if (r10 == null) goto L22;
            long r11 = r10.longValue();
        L23:
            IPublicAreaCommon r13 = r7.v();
            if (r13 == null) goto L29;
            Long r14 = r13.getForceInsertionPriority();
            if (r14 == null) goto L29;
            r4 = r14.longValue();
        L29:
            return (int) (r11 - r4);
        L22:
            r11 = 0;
            goto L23
        L32:
            return (int) (r7.p().longValue() - r8.p().longValue());
        L10:
            r2 = null;
            goto L11
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final void clear() {
        this.a.clear();
        ((ArrayDeque) this.b).clear();
        ((ArrayDeque) this.d).clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final int size() {
        return (this.a.size() + ((ArrayDeque) this.b).size()) + ((ArrayDeque) this.d).size();
    }

    public FoldComposePriorityQueue() {
        int r0 = Build.VERSION.SDK_INT;
        a r1 = a.a;
        if (r0 < 24) goto L5;
        PriorityQueue r2 = new PriorityQueue(r1);
    L6:
        this.a = r2;
        this.b = new ArrayDeque();
        this.c = new ArrayDeque();
        this.d = new ArrayDeque(5);
        return;
    L5:
        r2 = new PriorityQueue(32, r1);
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final com.bytedance.android.livesdk.interactivity.api.entity.f<?> a(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r5) {
        Intrinsics.checkNotNullParameter(r5, "predicate");
        Iterator<T> r0 = this.a.iterator();
    L3:
        Object r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if (((Boolean) r5.invoke(r1)).booleanValue() == false) goto L3;
    L9:
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r3 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r1;
        if (r3 != null) goto L19;
        Iterator r4 = ((ArrayDeque) this.b).iterator();
    L13:
        if (r4.hasNext() == false) goto L17;
        Object r6 = r4.next();
        if (((Boolean) r5.invoke(r6)).booleanValue() == false) goto L13;
    L18:
        r3 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r6;
        goto L19
    L17:
        r6 = null;
    L19:
        if (r3 != null) goto L37;
        Iterator r7 = ((ArrayDeque) this.d).iterator();
    L22:
        if (r7.hasNext() == false) goto L27;
        Object r8 = r7.next();
        if (((Boolean) r5.invoke(r8)).booleanValue() == false) goto L22;
        r2 = r8;
    L27:
        return (com.bytedance.android.livesdk.interactivity.api.entity.f) r2;
    L37:
        return r3;
    L8:
        r1 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> b(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "predicate");
        ArrayList r0 = new ArrayList();
        f(this.a.iterator(), r0, r3);
        f(((ArrayDeque) this.b).iterator(), r0, r3);
        f(((ArrayDeque) this.d).iterator(), r0, r3);
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> e(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "predicate");
        ArrayList r0 = new ArrayList();
        g(this.a.iterator(), r0, r3);
        g(((ArrayDeque) this.b).iterator(), r0, r3);
        g(((ArrayDeque) this.d).iterator(), r0, r3);
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final com.bytedance.android.livesdk.interactivity.api.entity.f<?> c(k r5, boolean r6) {
        if (r6 == false) goto L4;
        Iterator<T> r7 = this.a.iterator();
        if (r7.hasNext() == true) goto L12;
        Object r8 = null;
    L22:
        final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r9 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r8;
        long r0 = Long.MAX_VALUE;
        if (r9 == null) goto L27;
        Long r10 = r9.p();
        if (r10 == null) goto L27;
        long r2 = r10.longValue();
    L28:
        com.bytedance.android.livesdk.interactivity.api.entity.f r11 = (com.bytedance.android.livesdk.interactivity.api.entity.f) ((ArrayDeque) this.b).peek();
        if (r11 == null) goto L34;
        Long r13 = r11.p();
        if (r13 == null) goto L34;
        r0 = r13.longValue();
    L34:
        if (r2 >= r0) goto L38;
        if (r9 == null) goto L37;
        n.b(new FoldComposePriorityQueue$poll$1$1(r9));
    L37:
        this.a.remove(r9);
        return r9;
    L38:
        final com.bytedance.android.livesdk.interactivity.api.entity.f r14 = (com.bytedance.android.livesdk.interactivity.api.entity.f) ((ArrayDeque) this.b).peek();
        if (r14 == null) goto L42;
        n.b(new FoldComposePriorityQueue$poll$2$1(r14));
    L42:
        return (com.bytedance.android.livesdk.interactivity.api.entity.f) ((ArrayDeque) this.b).poll();
    L27:
        r2 = Long.MAX_VALUE;
        goto L28
    L12:
        Object r15 = r7.next();
        if (r7.hasNext() == true) goto L15;
    L14:
        r8 = r15;
        goto L22
    L15:
        Long r1 = ((com.bytedance.android.livesdk.interactivity.api.entity.f) r15).p();
    L16:
        Object r3 = r7.next();
        Long r4 = ((com.bytedance.android.livesdk.interactivity.api.entity.f) r3).p();
        if (r1.compareTo(r4) <= 0) goto L20;
        r15 = r3;
        r1 = r4;
    L20:
        if (r7.hasNext() == true) goto L16;
    L4:
        if (((ArrayDeque) this.d).isEmpty() == false) goto L8;
        if (r5 == null) goto L8;
        r5.a(this.a, this.b, this.c, this.d);
    L8:
        return (com.bytedance.android.livesdk.interactivity.api.entity.f) ((ArrayDeque) this.d).poll();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final void d(int r6, final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r7, Function2<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, ? super List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>>, Unit> r8) {
        Intrinsics.checkNotNullParameter(r7, "data");
        Intrinsics.checkNotNullParameter(r8, "callback");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        String r1 = BuildConfig.FLAVOR;
        r0.element = BuildConfig.FLAVOR;
        if (v.a() == true) goto L5;
    L17:
        IPublicAreaCommon r2 = r7.v();
        if (r2 == null) goto L22;
        PersonalizedDisplayInfo r3 = r2.getPersonalizedInfo();
        if (r3 == null) goto L22;
        Boolean r4 = r3.isPersonalized();
    L24:
        if (Intrinsics.areEqual(r4, Boolean.TRUE) == false) goto L26;
        n.b(new FoldComposePriorityQueue$add$1(r7, r0));
        this.a.add(r7);
        r7.a = "高优折叠消息";
    L28:
        if (size() <= r6) goto L38;
        ArrayList r5 = new ArrayList();
        int r9 = size() - r6;
        if (r9 <= 0) goto L37;
        int r10 = 0;
    L32:
        if (r10 >= r9) goto L37;
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r11 = c(null, true);
        if (r11 == null) goto L36;
        r5.add(r11);
    L36:
        r10 = r10 + 1;
    L37:
        r8.invoke(r7, r5);
        return;
    L38:
        r8.invoke(r7, null);
        return;
    L26:
        n.b(new FoldComposePriorityQueue$add$2(r7, r0));
        ((ArrayDeque) this.b).add(r7);
        r7.a = "普通折叠消息";
    L22:
        r4 = null;
        goto L24
    L5:
        if (n.a == false) goto L17;
        IPublicAreaCommon r13 = r7.v();
        if (r13 == null) goto L11;
        PersonalizedDisplayInfo r14 = r13.getPersonalizedInfo();
        if (r14 == null) goto L11;
        Boolean r15 = r14.isPersonalized();
    L13:
        if (Intrinsics.areEqual(r15, Boolean.TRUE) == true) goto L16;
        r1 = "非";
    L16:
        r0.element = r1;
    L11:
        r15 = null;
        goto L13
    }

    public final void f(Iterator<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r3, List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r4, Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r5) {
    L3:
        if (r3.hasNext() == false) goto L8;
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r0 = r3.next();
        if (((Boolean) r5.invoke(r0)).booleanValue() == true) goto L11;
        r3.remove();
        ((ArrayList) r4).add(r0);
        goto L3
    L11:
        return;
    }

    public final void g(Iterator<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r3, List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r4, Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r5) {
    L3:
        if (r3.hasNext() == false) goto L7;
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r0 = r3.next();
        if (((Boolean) r5.invoke(r0)).booleanValue() == false) goto L3;
        r3.remove();
        ((ArrayList) r4).add(r0);
        goto L3
    }
}
