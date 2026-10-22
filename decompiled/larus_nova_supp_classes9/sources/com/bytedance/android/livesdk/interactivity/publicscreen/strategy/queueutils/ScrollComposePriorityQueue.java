package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import android.os.Build;
import com.bytedance.android.live.base.model.message.i4;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.v3;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.PublicScreenConfig$MessageModelType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.n;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.PersonalizedDisplayInfo;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ScrollComposePriorityQueue implements h {
    public static final /* synthetic */ int g = 0;
    public final Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> a;
    public final Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> b;
    public final Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> c;
    public final Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> d;
    public final boolean e;
    public final ja2.a f;

    public static final class a<T> implements Comparator {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r3, Object r4) {
            Queue r5 = (Queue) r3;
            Queue r6 = (Queue) r4;
            if (((com.bytedance.android.livesdk.interactivity.api.entity.f) r5.peek()) != null) goto L6;
            return 1;
        L6:
            if (((com.bytedance.android.livesdk.interactivity.api.entity.f) r6.peek()) != null) goto L9;
            return -1;
        L9:
            return (int) (((com.bytedance.android.livesdk.interactivity.api.entity.f) r5.peek()).p().longValue() - ((com.bytedance.android.livesdk.interactivity.api.entity.f) r6.peek()).p().longValue());
        }
    }

    public static final class b<T> implements Comparator {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
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

    public static final class c<T> implements Comparator {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r3, Object r4) {
            com.bytedance.android.livesdk.interactivity.api.entity.f r5 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r3;
            com.bytedance.android.livesdk.interactivity.api.entity.f r6 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r4;
            if (r5 != null) goto L5;
            return 1;
        L5:
            if (r6 != null) goto L8;
            return -1;
        L8:
            return (int) (r5.p().longValue() - r6.p().longValue());
        }
    }

    public static final class d {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final void clear() {
        this.a.clear();
        ((ArrayDeque) this.b).clear();
        ((ArrayDeque) this.c).clear();
        ((ArrayDeque) this.d).clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final int size() {
        return ((this.a.size() + ((ArrayDeque) this.b).size()) + ((ArrayDeque) this.c).size()) + ((ArrayDeque) this.d).size();
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
        if (r3 != null) goto L28;
        Iterator r7 = ((ArrayDeque) this.c).iterator();
    L22:
        if (r7.hasNext() == false) goto L26;
        Object r8 = r7.next();
        if (((Boolean) r5.invoke(r8)).booleanValue() == false) goto L22;
    L27:
        r3 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r8;
        goto L28
    L26:
        r8 = null;
    L28:
        if (r3 != null) goto L49;
        Iterator r9 = ((ArrayDeque) this.d).iterator();
    L31:
        if (r9.hasNext() == false) goto L36;
        Object r10 = r9.next();
        if (((Boolean) r5.invoke(r10)).booleanValue() == false) goto L31;
        r2 = r10;
    L36:
        return (com.bytedance.android.livesdk.interactivity.api.entity.f) r2;
    L49:
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
        f(((ArrayDeque) this.c).iterator(), r0, r3);
        f(((ArrayDeque) this.d).iterator(), r0, r3);
        return r0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> e(Function1<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "predicate");
        ArrayList r0 = new ArrayList();
        g(this.a.iterator(), r0, r3);
        g(((ArrayDeque) this.b).iterator(), r0, r3);
        g(((ArrayDeque) this.c).iterator(), r0, r3);
        g(((ArrayDeque) this.d).iterator(), r0, r3);
        return r0;
    }

    public ScrollComposePriorityQueue(boolean r2, ja2.a r3) {
        this.e = r2;
        this.f = r3;
        if (r2 == false) goto L8;
        int r4 = Build.VERSION.SDK_INT;
        b r5 = b.a;
        if (r4 < 24) goto L7;
        Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r6 = new PriorityQueue(r5);
    L9:
        this.a = r6;
        this.b = new ArrayDeque();
        this.c = new ArrayDeque();
        this.d = new ArrayDeque(5);
        return;
    L7:
        r6 = new PriorityQueue(100, r5);
        goto L9
    L8:
        r6 = new ArrayDeque();
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final com.bytedance.android.livesdk.interactivity.api.entity.f<?> c(k r6, boolean r7) {
        if (r7 == false) goto L4;
        boolean r8 = this.e;
        a r9 = a.a;
        if (r8 == false) goto L52;
        Iterator<T> r10 = this.a.iterator();
        if (r10.hasNext() == true) goto L19;
        Object r11 = null;
    L29:
        final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r13 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r11;
        Queue r14 = (Queue) ComparisonsKt.minOf(this.b, this.c, r9);
        long r0 = Long.MAX_VALUE;
        if (r13 == null) goto L34;
        Long r2 = r13.p();
        if (r2 == null) goto L34;
        long r3 = r2.longValue();
    L35:
        com.bytedance.android.livesdk.interactivity.api.entity.f r4 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r14.peek();
        if (r4 == null) goto L41;
        Long r5 = r4.p();
        if (r5 == null) goto L41;
        r0 = r5.longValue();
    L41:
        if (r3 >= r0) goto L46;
        if (r13 == null) goto L44;
        n.b(new ScrollComposePriorityQueue$poll$1$1(r13));
    L44:
        this.a.remove(r13);
        return r13;
    L46:
        final com.bytedance.android.livesdk.interactivity.api.entity.f r15 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r14.peek();
        if (r15 == null) goto L50;
        n.b(new ScrollComposePriorityQueue$poll$2$1(r15));
    L50:
        return (com.bytedance.android.livesdk.interactivity.api.entity.f) r14.poll();
    L34:
        r3 = Long.MAX_VALUE;
        goto L35
    L19:
        Object r1 = r10.next();
        if (r10.hasNext() == true) goto L22;
    L21:
        r11 = r1;
        goto L29
    L22:
        Long r16 = ((com.bytedance.android.livesdk.interactivity.api.entity.f) r1).p();
    L23:
        Object r17 = r10.next();
        Long r18 = ((com.bytedance.android.livesdk.interactivity.api.entity.f) r17).p();
        if (r16.compareTo(r18) <= 0) goto L27;
        r1 = r17;
        r16 = r18;
    L27:
        if (r10.hasNext() == true) goto L23;
    L52:
        return (com.bytedance.android.livesdk.interactivity.api.entity.f) ((Queue) ComparisonsKt.minOf(this.a, this.b, this.c, r9)).poll();
    L4:
        if (((ArrayDeque) this.d).isEmpty() == false) goto L7;
        if (r6 == null) goto L7;
        r6.a(this.a, this.b, this.c, this.d);
    L7:
        ja2.a r19 = this.f;
        if (r19 == null) goto L13;
        if ((!r19.d) != true) goto L13;
        Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r20 = this.d;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r20, "scrollQueue");
        return r19.a(r20);
    L13:
        return (com.bytedance.android.livesdk.interactivity.api.entity.f) ((ArrayDeque) this.d).poll();
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.h
    public final void d(int r8, final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r9, Function2<? super com.bytedance.android.livesdk.interactivity.api.entity.f<?>, ? super List<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>>, Unit> r10) {
        Intrinsics.checkNotNullParameter(r9, "data");
        Intrinsics.checkNotNullParameter(r10, "callback");
        int r1 = 0;
        if (this.e == false) goto L13;
        IPublicAreaCommon r0 = r9.v();
        if (r0 == null) goto L9;
        PersonalizedDisplayInfo r2 = r0.getPersonalizedInfo();
        if (r2 == null) goto L9;
        Boolean r3 = r2.isPersonalized();
    L11:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L13;
        n.b(new ScrollComposePriorityQueue$add$1(r9));
        this.a.add(r9);
        r9.a = "高优消息";
    L57:
        if (size() <= r8) goto L66;
        ArrayList r4 = new ArrayList();
        int r5 = size() - r8;
        if (r5 <= 0) goto L65;
    L60:
        if (r1 >= r5) goto L65;
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r11 = c(null, true);
        if (r11 == null) goto L64;
        r4.add(r11);
    L64:
        r1 = r1 + 1;
    L65:
        r10.invoke(r9, r4);
        return;
    L66:
        r10.invoke(r9, null);
        return;
    L9:
        r3 = null;
    L13:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.i r6 = r9.s();
        if (r6 == null) goto L43;
        PublicScreenConfig$MessageModelType r7 = r6.getType();
        if (r7 == null) goto L43;
        if (r7.equals(PublicScreenConfig$MessageModelType.SECRET_CHAT) != true) goto L43;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.i r13 = r9.s();
        if ((r13 instanceof com.bytedance.android.livesdk.interactivity.publicscreen.plugin.e) == true) goto L22;
        r13 = null;
    L22:
        com.bytedance.android.livesdk.interactivity.publicscreen.plugin.e r14 = (com.bytedance.android.livesdk.interactivity.publicscreen.plugin.e) r13;
        if (r14 == null) goto L43;
        i4 r15 = r14.l;
        if (r15 == null) goto L43;
        IPublicAreaCommon r16 = v3.a(r15);
        if (r16 == null) goto L30;
        Integer r17 = Integer.valueOf(r16.getIndividualPriority());
    L31:
        if (r17 != null) goto L34;
    L36:
        if (r17 != null) goto L39;
    L41:
        ((ArrayDeque) this.b).add(r9);
    L42:
        boolean r18 = true;
    L44:
        if (r18 == true) goto L57;
        if ((r9 instanceof com.bytedance.android.livesdk.interactivity.textmessage.model.d) == false) goto L55;
        k0 r19 = ((com.bytedance.android.livesdk.interactivity.textmessage.model.d) r9).b;
        if (r19.isHighPriority() == false) goto L52;
        this.a.add(r9);
        n.b(new ScrollComposePriorityQueue$add$2(r9));
        r9.a = "高优消息";
        goto L57
    L52:
        if (r19.isLowPriority() == false) goto L54;
        n.b(new ScrollComposePriorityQueue$add$3(r9));
        ((ArrayDeque) this.c).add(r9);
        r9.a = "低优消息";
        goto L57
    L54:
        n.b(new ScrollComposePriorityQueue$add$4(r9));
        ((ArrayDeque) this.b).add(r9);
        r9.a = "中优消息";
        goto L57
    L55:
        n.b(new ScrollComposePriorityQueue$add$5(r9));
        ((ArrayDeque) this.b).add(r9);
        r9.a = "中优消息";
        goto L57
    L39:
        if (r17.intValue() != 30) goto L41;
        ((ArrayDeque) this.c).add(r9);
        goto L42
    L34:
        if (r17.intValue() != 80) goto L36;
        this.a.add(r9);
        goto L42
    L30:
        r17 = null;
    L43:
        r18 = false;
        goto L44
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
