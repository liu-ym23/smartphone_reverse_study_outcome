package com.bytedance.android.live.profit.redpacket;

import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.revenue.common.PropertyOwnersKt;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class y0 implements com.bytedance.android.scope.o {
    public final CompositeDisposable a;
    public final CompositeDisposable b;
    public final PropertyOwner<a> c;
    public final PropertyOwner d;
    public final PropertyOwner<Integer> e;
    public final PropertyOwner f;
    public final PropertyOwner<Unit> g;
    public final PropertyOwner h;
    public final PropertyOwner<sh6.b<n0>> i;
    public final PropertyOwner j;
    public final r0 k;

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.profit.redpacket.y0$a$a, reason: collision with other inner class name */
        public static final class C0049a extends a implements d {
            public final com.bytedance.android.live.profit.redpacket.e a;

            public final int hashCode() {
                com.bytedance.android.live.profit.redpacket.e r0 = this.a;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
            }

            public final String toString() {
                return "Available(packet=" + this.a + ")";
            }

            @Override // com.bytedance.android.live.profit.redpacket.y0.a.d
            public final com.bytedance.android.live.profit.redpacket.e a() {
                return this.a;
            }

            public C0049a(com.bytedance.android.live.profit.redpacket.e r2) {
                Intrinsics.checkNotNullParameter(r2, "packet");
                this.a = r2;
            }

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof C0049a) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.a, ((C0049a) r2).a) == true) goto L13;
                return false;
            L13:
                return true;
            }
        }

        public static final class b extends a implements d {
            public final com.bytedance.android.live.profit.redpacket.e a;
            public final Function0<Unit> b;

            public final int hashCode() {
                com.bytedance.android.live.profit.redpacket.e r0 = this.a;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                Function0<Unit> r4 = this.b;
                if (r4 == null) goto L10;
                r1 = r4.hashCode();
            L10:
                return r3 + r1;
            L5:
                r2 = 0;
                goto L6
            }

            public final String toString() {
                return "Empty(packet=" + this.a + ", onAnimFinish=" + this.b + ")";
            }

            @Override // com.bytedance.android.live.profit.redpacket.y0.a.d
            public final com.bytedance.android.live.profit.redpacket.e a() {
                return this.a;
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof b) == false) goto L10;
                b r4 = (b) r3;
                if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
                return false;
            L16:
                return true;
            L10:
                return false;
            }

            public b(com.bytedance.android.live.profit.redpacket.e r2, Function0<Unit> r3) {
                Intrinsics.checkNotNullParameter(r2, "packet");
                Intrinsics.checkNotNullParameter(r3, "onAnimFinish");
                this.a = r2;
                this.b = r3;
            }
        }

        public static final class c extends a {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        public interface d {
            com.bytedance.android.live.profit.redpacket.e a();
        }

        public static final class e extends a implements d {
            public final com.bytedance.android.live.profit.redpacket.e a;

            public final int hashCode() {
                com.bytedance.android.live.profit.redpacket.e r0 = this.a;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
            }

            public final String toString() {
                return "Wait(packet=" + this.a + ")";
            }

            @Override // com.bytedance.android.live.profit.redpacket.y0.a.d
            public final com.bytedance.android.live.profit.redpacket.e a() {
                return this.a;
            }

            public e(com.bytedance.android.live.profit.redpacket.e r2) {
                Intrinsics.checkNotNullParameter(r2, "packet");
                this.a = r2;
            }

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof e) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.a, ((e) r2).a) == true) goto L13;
                return false;
            L13:
                return true;
            }
        }

        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ y0 a;

        public b(y0 r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            List r6 = (List) r5;
            this.a.e.onNext(Integer.valueOf(r6.size()));
            y0.a(this.a, true);
            PropertyOwner<sh6.b<n0>> r0 = this.a.i;
            Intrinsics.checkNotNullParameter(r6, "redPacketList");
            final String r1 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).getCurrentUserId();
            com.bytedance.android.live.revenue.common.u0 r2 = com.bytedance.android.live.revenue.common.u0.f;
            final com.bytedance.android.live.revenue.common.u0 r3 = com.bytedance.android.live.revenue.common.u0.a.a(3);
            r0.a(sh6.c.a((n0) SequencesKt.firstOrNull(SequencesKt.filter(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r6), RedPacketIconHelpersKt$getOwnFirstWaiting3SecRedPacket$1.INSTANCE), new RedPacketIconHelpersKt$getOwnFirstWaiting3SecRedPacket$2(r1)), new RedPacketIconHelpersKt$getOwnFirstWaiting3SecRedPacket$3(r3)))));
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ y0 a;

        public c(y0 r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Unit r3 = (Unit) r2;
            this.a.g.onNext(Unit.INSTANCE);
        }
    }

    public final int c() {
        Iterable r0 = (Iterable) this.k.e.d;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((RedPacket) r2.next()).getState().getInfo());
        goto L4
    L6:
        Intrinsics.checkNotNullParameter(r1, "infoList");
        Iterator r3 = r1.iterator();
        int r4 = 0;
    L8:
        if (r3.hasNext() == false) goto L10;
        r4 = r4 + ((n0) r3.next()).m;
        goto L8
    L10:
        return r4;
    }

    public final void onStart() {
        RxUtilKt.c(PropertyOwnersKt.c(this.k.e).subscribe(new b(this)), this.a);
        RxUtilKt.c(this.k.g.subscribe(new c(this)), this.a);
    }

    public final void onStop() {
        this.a.dispose();
    }

    public y0(r0 r2) {
        Intrinsics.checkNotNullParameter(r2, "repository");
        this.k = r2;
        CompositeDisposable r3 = new CompositeDisposable();
        this.a = r3;
        CompositeDisposable r0 = new CompositeDisposable();
        RxUtilKt.c(r0, r3);
        this.b = r0;
        PropertyOwner<a> r4 = new PropertyOwner(a.c.a);
        this.c = r4;
        this.d = r4;
        PropertyOwner<Integer> r5 = new PropertyOwner(0);
        this.e = r5;
        this.f = r5;
        PropertyOwner<Unit> r6 = new PropertyOwner(Unit.INSTANCE);
        this.g = r6;
        this.h = r6;
        PropertyOwner<sh6.b<n0>> r7 = new PropertyOwner(sh6.a.a);
        this.i = r7;
        this.j = r7;
    }

    public static final void a(y0 r4, boolean r5) {
        Iterator r0 = ((List) r4.k.e.d).iterator();
    L3:
        RedPacketState r2 = null;
        if (r0.hasNext() == false) goto L8;
        Object r1 = r0.next();
        if ((!f.a(((e) r1).getState())) == false) goto L3;
    L9:
        e r3 = (e) r1;
        Object r6 = r4.c.a;
        if ((r6 instanceof a.d) == true) goto L12;
        r6 = null;
    L12:
        a.d r7 = (a.d) r6;
        if (r7 == null) goto L15;
        e r8 = r7.a();
    L17:
        if (Intrinsics.areEqual(r3, r8) == true) goto L40;
        Object r9 = r4.c.a;
        if ((r9 instanceof a.d) == true) goto L22;
        r9 = null;
    L22:
        a.d r10 = (a.d) r9;
        if (r10 == null) goto L28;
        e r12 = r10.a();
        if (r12 == null) goto L28;
        r2 = r12.getState();
    L28:
        if ((r2 instanceof RedPacketState.Empty) == false) goto L31;
        if (r5 == false) goto L31;
        return;
    L31:
        r4.b.clear();
        if (r3 != null) goto L34;
        r4.c.a(a.c.a);
        return;
    L34:
        RxUtilKt.c(r3.a().map(z0.a).startWith(r3.getState()).subscribe(new a1(r4, r3)), r4.b);
        return;
    L40:
        return;
    L15:
        r8 = null;
        goto L17
    L8:
        r1 = null;
        goto L9
    }
}
