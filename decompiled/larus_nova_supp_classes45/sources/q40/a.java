package q40;

import android.graphics.Rect;
import com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.DraggableContainerView;
import com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.RegionId;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a implements DraggableContainerView.b {
    public k40.g a;
    public final Rect b;
    public Pair<? extends RegionId, k40.g> c;
    public Pair<? extends RegionId, k40.g> d;
    public final PropertyOwner e;
    public final DraggableContainerView f;
    public final q40.c<q40.b> g;
    public final b h;

    /* JADX INFO: renamed from: q40.a$a, reason: collision with other inner class name */
    public static final class C0265a {
    }

    public interface b {
        void a(Pair<? extends RegionId, k40.g> r1);

        void b(Pair<? extends RegionId, k40.g> r1);

        void c(RegionId r1);
    }

    public static final class c implements com.bytedance.android.live.core.log.c {
        public final /* synthetic */ Pair a;
        public final /* synthetic */ Pair b;

        public c(Pair r1, Pair r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            return "onDragMove, region Change, last:" + this.a + ", current:" + this.b;
        }
    }

    public static final class d implements com.bytedance.android.live.core.log.c {
        public final /* synthetic */ a a;
        public final /* synthetic */ Pair b;

        public d(a r1, Pair r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            StringBuilder r0 = new StringBuilder("onDragMove, real move = ");
            if (this.b == null) goto L5;
            boolean r1 = true;
        L6:
            r0.append(r1);
            r0.append(", lastPosition = ");
            r0.append(this.a.d);
            return r0.toString();
        L5:
            r1 = false;
            goto L6
        }
    }

    public static final class e implements com.bytedance.android.live.core.log.c {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            return "onDragStart, startPosition=" + this.a.c;
        }
    }

    public static final class f implements com.bytedance.android.live.core.log.c {
        public final /* synthetic */ a a;

        public f(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            return "onDragStop, lastPosition=" + this.a.d;
        }
    }

    public static final class g implements com.bytedance.android.live.core.log.c {
        public final /* synthetic */ a a;

        public g(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            return "onDragStop, distance=(" + this.a.c + ", " + this.a.d + ')';
        }
    }

    public static final class h implements com.bytedance.android.live.core.log.c {
        public final /* synthetic */ boolean a;

        public h(boolean r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.core.log.c
        public final String generate() {
            return "onDragStop, hasPositionChange=(" + this.a + ')';
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.DraggableContainerView.b
    public final void a() {
        this.e.a(Boolean.FALSE);
        ALogger.d("DraggableComponentCallback", new f(this));
        ALogger.d("DraggableComponentCallback", new g(this));
        Pair<? extends RegionId, k40.g> r0 = this.c;
        k40.g r2 = null;
        if (r0 == null) goto L5;
        RegionId r1 = (RegionId) r0.getFirst();
    L6:
        Pair<? extends RegionId, k40.g> r3 = this.d;
        if (r3 == null) goto L9;
        RegionId r4 = (RegionId) r3.getFirst();
    L10:
        boolean r5 = true;
        if (r1 != r4) goto L23;
        Pair<? extends RegionId, k40.g> r6 = this.c;
        if (r6 == null) goto L15;
        k40.g r7 = (k40.g) r6.getSecond();
    L16:
        Pair<? extends RegionId, k40.g> r8 = this.d;
        if (r8 == null) goto L20;
        r2 = (k40.g) r8.getSecond();
    L20:
        if ((!Intrinsics.areEqual(r7, r2)) == true) goto L23;
        r5 = false;
        goto L23
    L15:
        r7 = null;
    L23:
        ALogger.d("DraggableComponentCallback", new h(r5));
        b r9 = this.h;
        if (r9 == null) goto L27;
        r9.a(this.d);
        return;
    L27:
        return;
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.DraggableContainerView.b
    public final void onDragStart() {
        DraggableContainerView r0 = this.f;
        Intrinsics.checkNotNullParameter(r0, "$this$pos");
        this.a = new k40.g(r0.getX(), r0.getY());
        Iterator r1 = this.g.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        q40.b r2 = (q40.b) r1.next();
        k40.f.d(r2.c, r2.a);
        goto L4
    L6:
        k40.f.d(this.f, this.b);
        Rect r3 = this.b;
        Pair<q40.b, Rect> r4 = c(r3, r3);
        if (r4 == null) goto L9;
        Pair<? extends RegionId, k40.g> r5 = TuplesKt.to(((q40.b) r4.getFirst()).b, ((q40.b) r4.getFirst()).c((Rect) r4.getSecond()));
    L10:
        this.c = r5;
        ALogger.d("DraggableComponentCallback", new e(this));
        this.e.a(Boolean.TRUE);
        b r6 = this.h;
        if (r6 == null) goto L15;
        r6.b(this.c);
        return;
    L15:
        return;
    L9:
        r5 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.DraggableContainerView.b
    public final void b(k40.g r8) {
        Intrinsics.checkNotNullParameter(r8, "offset");
        k40.g r0 = this.a;
        Intrinsics.checkNotNullParameter(r0, "$this$plus");
        Intrinsics.checkNotNullParameter(r8, "rhs");
        this.a = new k40.g(r0.a().floatValue() + r8.a().floatValue(), r0.b().floatValue() + r8.b().floatValue());
        k40.f.d(this.f, this.b);
        Rect r9 = new Rect(this.b);
        k40.g r1 = this.a;
        Intrinsics.checkNotNullParameter(r1, "$this$roundToVec2i");
        k40.h r2 = new k40.h(MathKt.roundToInt(r1.a().floatValue()), MathKt.roundToInt(r1.b().floatValue()));
        Intrinsics.checkNotNullParameter(r9, "$this$pos");
        Intrinsics.checkNotNullParameter(r2, "value");
        r9.offsetTo(r2.a().intValue(), r2.b().intValue());
        Pair<q40.b, Rect> r11 = c(this.b, r9);
        if (r11 == null) goto L18;
        q40.b r3 = (q40.b) r11.component1();
        Rect r4 = (Rect) r11.component2();
        k40.g r5 = k40.f.g(k40.f.b(r4));
        k40.g r6 = r3.c(r4);
        DraggableContainerView r7 = this.f;
        Intrinsics.checkNotNullParameter(r7, "$this$pos");
        Intrinsics.checkNotNullParameter(r5, "value");
        r7.setX(r5.a().floatValue());
        r7.setY(r5.b().floatValue());
        Pair<? extends RegionId, k40.g> r12 = TuplesKt.to(r3.b, r6);
        Pair<? extends RegionId, k40.g> r13 = this.d;
        if (r13 != null) goto L7;
        r13 = this.c;
    L7:
        if (r13 == null) goto L9;
        RegionId r14 = (RegionId) r13.getFirst();
    L11:
        if (r14 == ((RegionId) r12.getFirst())) goto L17;
        ALogger.d("DraggableComponentCallback", new c(r13, r12));
        b r15 = this.h;
        if (r15 == null) goto L17;
        if (r13 == null) goto L16;
        RegionId r16 = (RegionId) r13.getFirst();
    L16:
        r15.c((RegionId) r12.getFirst());
    L17:
        this.d = r12;
        goto L18
    L9:
        r14 = null;
    L18:
        ALogger.d("DraggableComponentCallback", new d(this, r11));
    }

    public final Pair<q40.b, Rect> c(Rect r12, Rect r13) {
        k40.h r0 = k40.f.f(k40.f.b(r13), k40.f.b(r12));
        k40.g r1 = k40.f.g(r0);
        Intrinsics.checkNotNullParameter(r1, "$this$norm2");
        float r2 = (float) Math.sqrt((r1.a().floatValue() * r1.a().floatValue()) + (r1.b().floatValue() * r1.b().floatValue()));
        q40.c<q40.b> r3 = this.g;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r12, "rect");
        HashSet r4 = r3.a;
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r7 = r6.next();
        if (((q40.c.a) r7).a().contains(r12) == false) goto L4;
        r5.add(r7);
        goto L4
    L8:
        Iterator r8 = r5.iterator();
        Object r9 = null;
        float r11 = Float.MIN_VALUE;
        Pair<q40.b, Rect> r14 = null;
    L10:
        if (r8.hasNext() == false) goto L17;
        q40.b r15 = (q40.b) r8.next();
        if (r15.a.contains(r13) == true) goto L13;
        Rect r16 = r15.b(r13);
        k40.h r17 = k40.f.f(k40.f.b(r16), k40.f.b(r12));
        Intrinsics.checkNotNullParameter(r17, "$this$times");
        Intrinsics.checkNotNullParameter(r0, "rhs");
        float r18 = ((r17.a().intValue() * r0.a().intValue()) + (r17.b().intValue() * r0.b().intValue())) / r2;
        if (r18 <= r11) goto L10;
        r14 = TuplesKt.to(r15, r16);
        r11 = r18;
        goto L10
    L13:
        r14 = TuplesKt.to(r15, new Rect(r13));
    L17:
        if (r14 != null) goto L52;
        k40.g r19 = k40.f.g(k40.f.b(r12));
        HashSet r21 = this.g.a;
        ArrayList r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r21, 10));
        Iterator r23 = r21.iterator();
    L20:
        if (r23.hasNext() == false) goto L22;
        q40.b r24 = (q40.b) r23.next();
        r22.add(TuplesKt.to(r24, r24.b(r12)));
        goto L20
    L22:
        Iterator r110 = r22.iterator();
        if (r110.hasNext() == false) goto L34;
        r9 = r110.next();
        if (r110.hasNext() == false) goto L34;
        float r25 = k40.f.a(r19, k40.f.g(k40.f.b((Rect) ((Pair) r9).component2())));
    L29:
        Object r26 = r110.next();
        float r27 = k40.f.a(r19, k40.f.g(k40.f.b((Rect) ((Pair) r26).component2())));
        if (Float.compare(r25, r27) <= 0) goto L33;
        r9 = r26;
        r25 = r27;
    L33:
        if (r110.hasNext() == true) goto L29;
    L34:
        Pair r28 = (Pair) r9;
        if (r28 != null) goto L37;
        return r14;
    L37:
        return TuplesKt.to((q40.b) r28.component1(), (Rect) r28.component2());
    L52:
        return r14;
    }

    public a(DraggableContainerView r2, q40.c r3, p40.c r4) {
        Intrinsics.checkNotNullParameter(r2, "draggableView");
        Intrinsics.checkNotNullParameter(r3, "regionManager");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.a = new k40.g(0.0f, 0.0f);
        this.b = new Rect();
        this.e = new PropertyOwner(Boolean.FALSE);
    }
}
