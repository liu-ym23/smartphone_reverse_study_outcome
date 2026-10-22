package ry1;

import android.graphics.Rect;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.livesdk.gift.grouplive.component.dragger.DraggableContainerView;
import com.bytedance.android.livesdk.gift.grouplive.component.dragger.RegionId;
import j80.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements DraggableContainerView.b {
    public j80.d a;
    public final Rect b;
    public Pair<? extends RegionId, j80.d> c;
    public Pair<? extends RegionId, j80.d> d;
    public final PropertyOwner e;
    public final DraggableContainerView f;
    public final c<ry1.b> g;
    public final b h;

    /* JADX INFO: renamed from: ry1.a$a, reason: collision with other inner class name */
    public static final class C0273a {
    }

    public interface b {
        void a(Pair<? extends RegionId, j80.d> r1);

        void b(Pair<? extends RegionId, j80.d> r1);

        void c(RegionId r1);
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.gift.grouplive.component.dragger.DraggableContainerView.b
    public final void a() {
        this.e.a(Boolean.FALSE);
        jy0.b.a("DragCallback", "onDragStop, lastPosition=" + this.d);
        jy0.b.a("DragCallback", "onDragStop, distance=(" + this.c + ", " + this.d + ')');
        Pair<? extends RegionId, j80.d> r0 = this.c;
        j80.d r3 = null;
        if (r0 == null) goto L5;
        RegionId r1 = (RegionId) r0.getFirst();
    L6:
        Pair<? extends RegionId, j80.d> r4 = this.d;
        if (r4 == null) goto L9;
        RegionId r5 = (RegionId) r4.getFirst();
    L10:
        boolean r6 = true;
        if (r1 != r5) goto L23;
        Pair<? extends RegionId, j80.d> r2 = this.c;
        if (r2 == null) goto L15;
        j80.d r7 = (j80.d) r2.getSecond();
    L16:
        Pair<? extends RegionId, j80.d> r8 = this.d;
        if (r8 == null) goto L20;
        r3 = (j80.d) r8.getSecond();
    L20:
        if ((!Intrinsics.areEqual(r7, r3)) == true) goto L23;
        r6 = false;
        goto L23
    L15:
        r7 = null;
    L23:
        jy0.b.a("DragCallback", "onDragStop, hasPositionChange=(" + r6 + ')');
        b r9 = this.h;
        if (r9 == null) goto L27;
        r9.a(this.d);
        return;
    L27:
        return;
    L9:
        r5 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.gift.grouplive.component.dragger.DraggableContainerView.b
    public final void onDragStart() {
        this.a = j80.b.a(this.f);
        Iterator r0 = this.g.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ry1.b r1 = (ry1.b) r0.next();
        d.a(r1.c, r1.a);
        goto L4
    L6:
        d.a(this.f, this.b);
        Rect r2 = this.b;
        Pair<ry1.b, Rect> r3 = c(r2, r2);
        if (r3 == null) goto L9;
        Pair<? extends RegionId, j80.d> r4 = TuplesKt.to(((ry1.b) r3.getFirst()).b, ((ry1.b) r3.getFirst()).c((Rect) r3.getSecond()));
    L10:
        this.c = r4;
        jy0.b.a("DragCallback", "onDragStart, startPosition=" + this.c);
        this.e.a(Boolean.TRUE);
        b r5 = this.h;
        if (r5 == null) goto L15;
        r5.b(this.c);
        return;
    L15:
        return;
    L9:
        r4 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.gift.grouplive.component.dragger.DraggableContainerView.b
    public final void b(j80.d r6) {
        Intrinsics.checkNotNullParameter(r6, "offset");
        this.a = j80.c.e(this.a, r6);
        d.a(this.f, this.b);
        Rect r7 = new Rect(this.b);
        j80.b.d(r7, j80.c.f(this.a));
        Pair<ry1.b, Rect> r8 = c(this.b, r7);
        if (r8 == null) goto L18;
        ry1.b r1 = (ry1.b) r8.component1();
        Rect r2 = (Rect) r8.component2();
        j80.d r3 = j80.c.h(j80.b.b(r2));
        j80.d r4 = r1.c(r2);
        j80.b.e(this.f, r3);
        Pair<? extends RegionId, j80.d> r5 = TuplesKt.to(r1.b, r4);
        Pair<? extends RegionId, j80.d> r9 = this.d;
        if (r9 != null) goto L7;
        r9 = this.c;
    L7:
        if (r9 == null) goto L9;
        RegionId r10 = (RegionId) r9.getFirst();
    L11:
        if (r10 == ((RegionId) r5.getFirst())) goto L17;
        jy0.b.a("DragCallback", "onDragMove, region Change, last:" + r9 + ", current:" + r5);
        b r11 = this.h;
        if (r11 == null) goto L17;
        if (r9 == null) goto L16;
        RegionId r13 = (RegionId) r9.getFirst();
    L16:
        r11.c((RegionId) r5.getFirst());
    L17:
        this.d = r5;
        goto L18
    L9:
        r10 = null;
    L18:
        StringBuilder r14 = new StringBuilder("onDragMove, real move = ");
        if (r8 == null) goto L21;
        boolean r15 = true;
    L22:
        r14.append(r15);
        r14.append(", lastPosition = ");
        r14.append(this.d);
        jy0.b.a("DragCallback", r14.toString());
        return;
    L21:
        r15 = false;
        goto L22
    }

    public final Pair<ry1.b, Rect> c(Rect r11, Rect r13) {
        e r0 = j80.c.c(j80.b.b(r13), j80.b.b(r11));
        float r1 = j80.c.d(j80.c.h(r0));
        c<ry1.b> r2 = this.g;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r11, "rect");
        HashSet r3 = r2.a;
        ArrayList r4 = new ArrayList();
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r6 = r5.next();
        if (((c.a) r6).a().contains(r11) == false) goto L4;
        r4.add(r6);
        goto L4
    L8:
        Iterator r7 = r4.iterator();
        Object r8 = null;
        float r9 = Float.MIN_VALUE;
        Pair<ry1.b, Rect> r10 = null;
    L10:
        if (r7.hasNext() == false) goto L17;
        ry1.b r14 = (ry1.b) r7.next();
        if (r14.a.contains(r13) == true) goto L13;
        Rect r15 = r14.b(r13);
        float r16 = j80.c.g(j80.c.c(j80.b.b(r15), j80.b.b(r11)), r0) / r1;
        if (r16 <= r9) goto L10;
        r10 = TuplesKt.to(r14, r15);
        r9 = r16;
        goto L10
    L13:
        r10 = TuplesKt.to(r14, new Rect(r13));
    L17:
        if (r10 != null) goto L52;
        j80.d r17 = j80.c.h(j80.b.b(r11));
        HashSet r18 = this.g.a;
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r20 = r18.iterator();
    L20:
        if (r20.hasNext() == false) goto L22;
        ry1.b r21 = (ry1.b) r20.next();
        r19.add(TuplesKt.to(r21, r21.b(r11)));
        goto L20
    L22:
        Iterator r110 = r19.iterator();
        if (r110.hasNext() == false) goto L34;
        r8 = r110.next();
        if (r110.hasNext() == false) goto L34;
        float r23 = j80.c.a(r17, j80.c.h(j80.b.b((Rect) ((Pair) r8).component2())));
    L29:
        Object r24 = r110.next();
        float r25 = j80.c.a(r17, j80.c.h(j80.b.b((Rect) ((Pair) r24).component2())));
        if (Float.compare(r23, r25) <= 0) goto L33;
        r8 = r24;
        r23 = r25;
    L33:
        if (r110.hasNext() == true) goto L29;
    L34:
        Pair r26 = (Pair) r8;
        if (r26 != null) goto L37;
        return r10;
    L37:
        return TuplesKt.to((ry1.b) r26.component1(), (Rect) r26.component2());
    L52:
        return r10;
    }

    public a(DraggableContainerView r2, c r3, vy1.c r4) {
        Intrinsics.checkNotNullParameter(r2, "draggableView");
        Intrinsics.checkNotNullParameter(r3, "regionManager");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.a = new j80.d(0.0f, 0.0f);
        this.b = new Rect();
        this.e = new PropertyOwner(Boolean.FALSE);
    }
}
