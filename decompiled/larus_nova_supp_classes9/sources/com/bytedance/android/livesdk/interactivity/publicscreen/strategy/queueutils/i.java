package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageAction;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageHeatState;
import com.bytedance.android.livesdk.interactivity.api.entity.PSMessagePriority;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i {
    public final b a;
    public final b b;
    public final b c;
    public final List<b> d;
    public final PSMessageAction e;
    public final a f;
    public final List<ja2.b.a> g;
    public final int h;

    public static final class a {
        public final e a;
        public final e b;
        public final com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.b c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            e r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            e r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.b r7 = this.c;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Config(scrollPollConfig=" + this.a + ", foldPollConfig=" + this.b + ", sizeLimitConfig=" + this.c + ")";
        }

        public a(e r2, e r3, com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.b r4) {
            Intrinsics.checkNotNullParameter(r2, "scrollPollConfig");
            Intrinsics.checkNotNullParameter(r3, "foldPollConfig");
            Intrinsics.checkNotNullParameter(r4, "sizeLimitConfig");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public final class b implements Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> {
        public final int a;
        public final PSMessagePriority b;
        public final Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> c;
        public final /* synthetic */ i d;

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r2) {
            Intrinsics.checkNotNullParameter(r2, "elements");
            return this.c.addAll(r2);
        }

        @Override // java.util.Collection
        public final void clear() {
            this.c.clear();
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection<? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "elements");
            return this.c.containsAll(r2);
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            return this.c.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> iterator() {
            return this.c.iterator();
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection<? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "elements");
            return this.c.removeAll(r2);
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "elements");
            return this.c.retainAll(r2);
        }

        @Override // java.util.Collection
        public final Object[] toArray() {
            return CollectionToArray.toArray(this);
        }

        @Override // java.util.Collection
        public final <T> T[] toArray(T[] r1) {
            return (T[]) CollectionToArray.toArray(this, r1);
        }

        @Override // java.util.Queue
        public final com.bytedance.android.livesdk.interactivity.api.entity.f<?> element() {
            return this.c.element();
        }

        @Override // java.util.Queue
        public final com.bytedance.android.livesdk.interactivity.api.entity.f<?> peek() {
            return this.c.peek();
        }

        @Override // java.util.Queue
        public final com.bytedance.android.livesdk.interactivity.api.entity.f<?> poll() {
            return this.c.poll();
        }

        @Override // java.util.Queue
        public final com.bytedance.android.livesdk.interactivity.api.entity.f<?> remove() {
            return this.c.remove();
        }

        @Override // java.util.Collection
        public final int size() {
            return this.c.size();
        }

        @Override // java.util.Queue, java.util.Collection
        public final boolean add(Object r2) {
            Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r0 = this.c;
            return r0.add((com.bytedance.android.livesdk.interactivity.api.entity.f) r2);
        }

        @Override // java.util.Collection
        public final boolean contains(Object r2) {
            if (r2 == null) goto L4;
            boolean r0 = r2 instanceof com.bytedance.android.livesdk.interactivity.api.entity.f;
        L5:
            if (r0 == true) goto L8;
            return false;
        L8:
            Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r1 = this.c;
            return r1.contains((com.bytedance.android.livesdk.interactivity.api.entity.f) r2);
        L4:
            r0 = true;
            goto L5
        }

        @Override // java.util.Queue
        public final boolean offer(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r2) {
            Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r0 = this.c;
            return r0.offer(r2);
        }

        @Override // java.util.Collection
        public final boolean remove(Object r2) {
            if (r2 == null) goto L4;
            boolean r0 = r2 instanceof com.bytedance.android.livesdk.interactivity.api.entity.f;
        L5:
            if (r0 == true) goto L8;
            return false;
        L8:
            Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r1 = this.c;
            return r1.remove((com.bytedance.android.livesdk.interactivity.api.entity.f) r2);
        L4:
            r0 = true;
            goto L5
        }

        public b(i r3, PSMessagePriority r4, Queue<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r5, com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.b r6) {
            Intrinsics.checkNotNullParameter(r4, "priority");
            Intrinsics.checkNotNullParameter(r5, "queue");
            Intrinsics.checkNotNullParameter(r6, "sizeLimitConfig");
            this.d = r3;
            this.b = r4;
            this.c = r5;
            r6.getClass();
            Intrinsics.checkNotNullParameter(r4, "priority");
            int r7 = com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils.a.a[r4.ordinal()];
            if (r7 != 1) goto L5;
            int r8 = r6.a;
        L13:
            this.a = r8;
            return;
        L5:
            if (r7 != 2) goto L7;
            r8 = r6.c;
            goto L13
        L7:
            if (r7 != 3) goto L10;
            r8 = r6.b;
            goto L13
        L10:
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void b(final com.bytedance.android.livesdk.interactivity.api.entity.f<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        PSMessagePriority r1 = r5.z;
        int r2 = j.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        final b r3 = this.a;
    L13:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "message");
        com.bytedance.android.livesdk.interactivity.common.utils.k.a(r3.c, r3.a, r5, new MultiPriorityQueue$MessageQueue$addMessage$1(r3, r5));
        return;
    L5:
        if (r2 != 2) goto L7;
        r3 = this.c;
        goto L13
    L7:
        if (r2 != 3) goto L10;
        r3 = this.b;
        goto L13
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final void a(List<com.bytedance.android.livesdk.interactivity.api.entity.f<?>> r9, PSMessageHeatState r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r9, "pollList");
        Intrinsics.checkNotNullParameter(r10, "heatState");
        if (r11 == false) goto L5;
        e r13 = this.f.b;
    L6:
        m r14 = r13.a(r10);
        Iterator<T> r15 = this.d.iterator();
        int r1 = 0;
    L8:
        if (r15.hasNext() == false) goto L25;
        b r2 = (b) r15.next();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r14, "pollConfig");
        Intrinsics.checkNotNullParameter(r9, "result");
        final long r3 = System.currentTimeMillis() - ((long) (r2.d.h * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW));
        Iterator r4 = ((ArrayList) com.bytedance.android.livesdk.interactivity.common.utils.k.c(r2.c, new MultiPriorityQueue$MessageQueue$dropExpiredMessage$dropList$1(r3))).iterator();
    L11:
        if (r4.hasNext() == false) goto L16;
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r5 = (com.bytedance.android.livesdk.interactivity.api.entity.f) r4.next();
        i r6 = r2.d;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "message");
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.messageheat.c.e(r5);
        Iterator<T> r7 = r6.g.iterator();
    L14:
        if (r7.hasNext() == false) goto L11;
        ((ja2.b.a) r7.next()).a(r5, 1);
        goto L14
    L16:
        int r8 = r14.b(r2.b);
        int r16 = RangesKt.coerceAtMost(r8, r2.c.size());
        if (r16 <= 0) goto L24;
        int r17 = 0;
    L19:
        if (r17 >= r16) goto L24;
        com.bytedance.android.livesdk.interactivity.api.entity.f<?> r18 = r2.c.poll();
        if (r18 == null) goto L23;
        ((ArrayList) r9).add(r18);
    L23:
        r17 = r17 + 1;
    L24:
        r1 = r1 + (r8 - r16);
        goto L8
    L25:
        Iterator<T> r19 = this.d.iterator();
    L27:
        if (r19.hasNext() == false) goto L36;
        b r20 = (b) r19.next();
        r20.getClass();
        Intrinsics.checkNotNullParameter(r14, "pollConfig");
        Intrinsics.checkNotNullParameter(r9, "result");
        if (r1 > 0) goto L31;
    L34:
        int r21 = 0;
    L35:
        r1 = r1 - r21;
        goto L27
    L31:
        if (r14.b(r20.b) <= 0) goto L34;
        r21 = com.bytedance.android.livesdk.interactivity.common.utils.k.b(r20, r1, r9);
        goto L35
    L36:
        return;
    L5:
        r13 = this.f.a;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(PSMessageAction r3, a r4, List<? extends ja2.b.a> r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "actionType");
        Intrinsics.checkNotNullParameter(r4, "pollConfig");
        Intrinsics.checkNotNullParameter(r5, "listeners");
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        b r7 = new b(this, PSMessagePriority.HIGH, new ArrayDeque(), r4.c);
        this.a = r7;
        b r8 = new b(this, PSMessagePriority.NORMAL, new ArrayDeque(), r4.c);
        this.b = r8;
        b r9 = new b(this, PSMessagePriority.LOW, new ArrayDeque(), r4.c);
        this.c = r9;
        this.d = CollectionsKt.listOf(new b[]{r7, r8, r9});
    }
}
