package em0;

import com.bytedance.android.live.room.api.messagewindow.list.RecordAction;
import d71.d;
import d71.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements d<v61.a, d71.b> {
    public final List<d71.b> a;
    public final List<d71.b> b;
    public final PriorityQueue<d71.b> c;
    public final PriorityQueue<d71.b> d;
    public final q71.d<r71.c> e;

    /* JADX INFO: renamed from: em0.a$a, reason: collision with other inner class name */
    public static final class C0205a {
    }

    public static final class b<T> implements Comparator {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r3, Object r4) {
            d71.b r5 = (d71.b) r3;
            d71.b r6 = (d71.b) r4;
            int r0 = ((e) r6).b.k - ((e) r5).b.k;
            if (r0 == 0) goto L5;
            return r0;
        L5:
            return (int) (((e) r6).a - ((e) r5).a);
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
            d71.b r5 = (d71.b) r3;
            d71.b r6 = (d71.b) r4;
            int r0 = ((e) r6).b.k - ((e) r5).b.k;
            if (r0 == 0) goto L5;
            return r0;
        L5:
            return (int) (((e) r6).a - ((e) r5).a);
        }
    }

    static {
    }

    public final Collection<d71.b> a() {
        return CollectionsKt.toList(this.c);
    }

    public final void b() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        d71.b r1 = (d71.b) r0.next();
        if (((e) r1).b.E() == true) goto L4;
        s((v61.a) ((e) r1).b);
        goto L4
    L8:
        PriorityQueue<d71.b> r2 = this.c;
        if (r2 == null) goto L16;
        Iterator<T> r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L16;
        d71.b r4 = (d71.b) r3.next();
        if (((e) r4).b.E() == true) goto L12;
        t((v61.a) ((e) r4).b);
    L16:
        PriorityQueue<d71.b> r5 = this.d;
        if (r5 == null) goto L24;
        Iterator<T> r6 = r5.iterator();
    L20:
        if (r6.hasNext() == false) goto L40;
        d71.b r7 = (d71.b) r6.next();
        if (((e) r7).b.E() == true) goto L20;
        v((v61.a) ((e) r7).b);
        goto L20
    L40:
        return;
    }

    public final d71.b f() {
        d71.b r0 = this.d.poll();
        q71.d<r71.c> r1 = this.e;
        int r2 = r71.c.b;
        RecordAction r3 = RecordAction.PollWaitingRecord;
        if (r0 == null) goto L8;
        v61.a r4 = ((e) r0).b;
        if (r4 == null) goto L8;
        Object r5 = r4.j;
        if (r5 == null) goto L8;
    L9:
        r1.b(r71.c.a.a(r3, r5, null, 12));
        return r0;
    L8:
        r5 = Unit.INSTANCE;
        goto L9
    }

    public final String k() {
        StringBuilder r0 = new StringBuilder("\nthe pending list: ");
        ArrayList r1 = (ArrayList) this.a;
        if (r1.isEmpty() == false) goto L5;
        r0.append("empty");
    L5:
        Iterator r2 = r1.iterator();
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r2.hasNext() == false) goto L12;
        Object r5 = r2.next();
        int r9 = r4 + 1;
        if (r4 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        r0.append("\n" + r4 + ' ');
        StringBuilder r6 = new StringBuilder("id:");
        r6.append(((e) ((d71.b) r5)).b.j);
        r0.append(r6.toString());
        r4 = r9;
        goto L7
    L12:
        r0.append("\nthe showing list:");
        PriorityQueue<d71.b> r7 = this.c;
        if (r7.isEmpty() == false) goto L15;
        r0.append("empty");
    L15:
        Iterator<T> r8 = r7.iterator();
        int r10 = 0;
    L17:
        if (r8.hasNext() == false) goto L22;
        Object r11 = r8.next();
        int r12 = r10 + 1;
        if (r10 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        r0.append("\n" + r10 + ' ');
        StringBuilder r13 = new StringBuilder("id:");
        r13.append(((e) ((d71.b) r11)).b.j);
        r0.append(r13.toString());
        r10 = r12;
        goto L17
    L22:
        r0.append("\nthe waiting list:");
        PriorityQueue<d71.b> r14 = this.d;
        if (r14.isEmpty() == false) goto L25;
        r0.append("empty");
    L25:
        Iterator<T> r15 = r14.iterator();
        int r16 = 0;
    L27:
        if (r15.hasNext() == false) goto L32;
        Object r17 = r15.next();
        int r18 = r16 + 1;
        if (r16 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        r0.append("\n" + r16 + ' ');
        StringBuilder r19 = new StringBuilder("id:");
        r19.append(((e) ((d71.b) r17)).b.j);
        r0.append(r19.toString());
        r16 = r18;
        goto L27
    L32:
        r0.append("\nthe temporary list:");
        CopyOnWriteArrayList r20 = (CopyOnWriteArrayList) this.b;
        if (r20.isEmpty() == false) goto L35;
        r0.append("empty");
    L35:
        Iterator r21 = r20.iterator();
    L37:
        if (r21.hasNext() == false) goto L43;
        Object r22 = r21.next();
        int r23 = r3 + 1;
        if (r3 >= 0) goto L41;
        CollectionsKt.throwIndexOverflow();
    L41:
        r0.append("\n" + r3 + ' ');
        StringBuilder r24 = new StringBuilder("id:");
        r24.append(((e) ((d71.b) r22)).b.j);
        r0.append(r24.toString());
        r3 = r23;
        goto L37
    L43:
        return r0.toString();
    }

    public final void release() {
        q71.d<r71.c> r0 = this.e;
        int r1 = r71.c.b;
        PriorityQueue<d71.b> r4 = null;
        r0.b(r71.c.a.a(RecordAction.ClearAllRecords, Unit.INSTANCE, null, 12));
        ((ArrayList) this.a).clear();
        this.c.clear();
        PriorityQueue<d71.b> r2 = this.d;
        if ((!r2.isEmpty()) == false) goto L5;
        r4 = r2;
    L5:
        if (r4 == null) goto L12;
        List r3 = CollectionsKt.toList(r4);
        if (r3 == null) goto L12;
        Iterator r5 = r3.iterator();
    L10:
        if (r5.hasNext() == false) goto L12;
        ((d71.b) r5.next()).a();
    L12:
        this.d.clear();
        ((CopyOnWriteArrayList) this.b).clear();
    }

    public final Collection<d71.b> o() {
        return this.b;
    }

    public a(q71.d<r71.c> r3) {
        Intrinsics.checkNotNullParameter(r3, "recordState");
        this.e = r3;
        this.a = new ArrayList();
        this.b = new CopyOnWriteArrayList();
        this.c = new PriorityQueue(6, b.a);
        this.d = new PriorityQueue(6, c.a);
    }

    public final boolean c(v61.c r3) {
        v61.a r4 = (v61.a) r3;
        Intrinsics.checkNotNullParameter(r4, "window");
        PriorityQueue<d71.b> r0 = this.c;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<d71.b> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((e) r1.next()).b, r4) == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public final /* bridge */ /* synthetic */ d71.b d(v61.a r1) {
        return s(r1);
    }

    public final /* bridge */ /* synthetic */ d71.b e(v61.c r1) {
        return u((v61.a) r1);
    }

    public final boolean g(v61.c r3) {
        v61.a r4 = (v61.a) r3;
        Intrinsics.checkNotNullParameter(r4, "window");
        List r0 = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(this.a, this.c), this.d), this.b);
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((e) ((d71.b) r1.next())).b, r4) == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public final void h(v61.a r5) {
        Intrinsics.checkNotNullParameter(r5, "window");
        q71.d<r71.c> r0 = this.e;
        int r1 = r71.c.b;
        r0.b(r71.c.a.a(RecordAction.OfferShowingRecord, r5.j, r5, 4));
        PriorityQueue<d71.b> r2 = this.c;
        boolean r3 = true;
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator<d71.b> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        if ((!Intrinsics.areEqual(((e) r4.next()).b, r5)) == true) goto L9;
        r3 = false;
    L13:
        if (r3 == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L22;
        r2.add(new d71.b(r5));
        return;
    L22:
        return;
    L5:
        if (r2.isEmpty() == false) goto L7;
        goto L7
    }

    public final void i(v61.a r5) {
        Intrinsics.checkNotNullParameter(r5, "window");
        q71.d<r71.c> r0 = this.e;
        int r1 = r71.c.b;
        r0.b(r71.c.a.a(RecordAction.OfferPendingRecord, r5.j, r5, 4));
        List<d71.b> r2 = this.a;
        boolean r3 = true;
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator r4 = ((ArrayList) r2).iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        if ((!Intrinsics.areEqual(((e) ((d71.b) r4.next())).b, r5)) == true) goto L9;
        r3 = false;
    L13:
        if (r3 == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L22;
        r2.add(new d71.b(r5));
        return;
    L22:
        return;
    L5:
        if (((ArrayList) r2).isEmpty() == false) goto L7;
        goto L7
    }

    public final void j(v61.a r5) {
        Intrinsics.checkNotNullParameter(r5, "window");
        q71.d<r71.c> r0 = this.e;
        int r1 = r71.c.b;
        r0.b(r71.c.a.a(RecordAction.OfferTemporaryRecord, r5.j, r5, 4));
        List<d71.b> r2 = this.b;
        boolean r3 = true;
        if ((r2 instanceof Collection) == true) goto L5;
    L7:
        Iterator r4 = ((CopyOnWriteArrayList) r2).iterator();
    L9:
        if (r4.hasNext() == false) goto L13;
        if ((!Intrinsics.areEqual(((e) ((d71.b) r4.next())).b, r5)) == true) goto L9;
        r3 = false;
    L13:
        if (r3 == true) goto L16;
        r2 = null;
    L16:
        if (r2 == null) goto L22;
        r2.add(new d71.b(r5));
        return;
    L22:
        return;
    L5:
        if (((CopyOnWriteArrayList) r2).isEmpty() == false) goto L7;
        goto L7
    }

    public final d71.b l(v61.a r5) {
        Intrinsics.checkNotNullParameter(r5, "window");
        q71.d<r71.c> r0 = this.e;
        int r1 = r71.c.b;
        r0.b(r71.c.a.a(RecordAction.OfferWaitingRecords, r5.j, r5, 4));
        Iterator<d71.b> r2 = this.d.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        d71.b r3 = r2.next();
        if (Intrinsics.areEqual(((e) r3).b, r5) == false) goto L4;
    L9:
        d71.b r4 = r3;
        if (r4 != null) goto L16;
        d71.b r6 = new d71.b(r5);
        this.d.add(r6);
        return r6;
    L16:
        return r4;
    L8:
        r3 = null;
        goto L9
    }

    public final boolean m(v61.a r3) {
        Intrinsics.checkNotNullParameter(r3, "window");
        PriorityQueue<d71.b> r0 = this.d;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<d71.b> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((e) r1.next()).b, r3) == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        goto L7
    }

    public final /* bridge */ /* synthetic */ d71.b n(v61.a r1) {
        return v(r1);
    }

    public final void p(v61.a r5) {
        Intrinsics.checkNotNullParameter(r5, "window");
        q71.d<r71.c> r0 = this.e;
        int r1 = r71.c.b;
        r0.b(r71.c.a.a(RecordAction.RemoveFromRecords, r5.j, r5, 4));
        s(r5);
        t(r5);
        v(r5);
        u(r5);
    }

    public final boolean q(Object r4) {
        Intrinsics.checkNotNullParameter(r4, "identity");
        PriorityQueue<d71.b> r0 = this.c;
        if ((r0 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r1 = r0.iterator();
    L9:
        if (r1.hasNext() == false) goto L18;
        if (Intrinsics.areEqual(((e) ((d71.b) r1.next())).b.j, r4) == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return false;
    }

    public final /* bridge */ /* synthetic */ d71.b r(v61.a r1) {
        return t(r1);
    }

    public final d71.b s(v61.a r5) {
        Intrinsics.checkNotNullParameter(r5, "window");
        q71.d<r71.c> r0 = this.e;
        int r1 = r71.c.b;
        r0.b(r71.c.a.a(RecordAction.RemovePendingRecord, r5.j, r5, 4));
        Iterator r2 = ((ArrayList) this.a).iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        d71.b r3 = (d71.b) r2.next();
        if (Intrinsics.areEqual(((e) r3).b, r5) == false) goto L4;
        r2.remove();
        return r3;
    L9:
        return null;
    }

    public final d71.b t(v61.a r5) {
        Intrinsics.checkNotNullParameter(r5, "window");
        q71.d<r71.c> r0 = this.e;
        int r1 = r71.c.b;
        r0.b(r71.c.a.a(RecordAction.RemoveShowingRecord, r5.j, r5, 4));
        Iterator<d71.b> r2 = this.c.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        d71.b r3 = r2.next();
        if (Intrinsics.areEqual(((e) r3).b, r5) == false) goto L4;
        r2.remove();
        return r3;
    L9:
        return null;
    }

    public final d71.b u(v61.a r5) {
        Intrinsics.checkNotNullParameter(r5, "window");
        q71.d<r71.c> r0 = this.e;
        int r1 = r71.c.b;
        r0.b(r71.c.a.a(RecordAction.RemoveTemporaryRecord, r5.j, r5, 4));
        Iterator r2 = ((CopyOnWriteArrayList) this.b).iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        d71.b r3 = (d71.b) r2.next();
        if (Intrinsics.areEqual(((e) r3).b, r5) == false) goto L4;
        ((CopyOnWriteArrayList) this.b).remove(r3);
        return r3;
    L9:
        return null;
    }

    public final d71.b v(v61.a r5) {
        Intrinsics.checkNotNullParameter(r5, "window");
        q71.d<r71.c> r0 = this.e;
        int r1 = r71.c.b;
        r0.b(r71.c.a.a(RecordAction.RemoveWaitingRecord, r5.j, r5, 4));
        Iterator<d71.b> r2 = this.d.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        d71.b r3 = r2.next();
        if (Intrinsics.areEqual(((e) r3).b, r5) == false) goto L4;
        r3.a();
        r2.remove();
        return r3;
    L9:
        return null;
    }
}
