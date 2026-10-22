package vd0;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import xd0.b;
import xd0.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int g = 0;
    public final List<xd0.a> a;
    public final b b;
    public final wd0.b c;
    public final wd0.a d;
    public final Map<Integer, List<c>> e;
    public final DataCenter f;

    /* JADX INFO: renamed from: vd0.a$a, reason: collision with other inner class name */
    public static final class C0284a {
        public static a a(DataCenter r2) {
            a r1 = null;
            if (r2 == null) goto L5;
            r1 = (a) r2.get("data_live_bg_view_manager", null);
        L5:
            if (r1 == null) goto L7;
            return r1;
        L7:
            a r3 = new a(r2);
            if (r2 == null) goto L10;
            r2.put("data_live_bg_view_manager", r3);
        L10:
            return r3;
        }
    }

    static {
    }

    public final void c() {
        this.d.a(this.c, this.a, this.b);
    }

    public a(DataCenter r3) {
        this.f = r3;
        this.a = new ArrayList();
        this.b = new b();
        this.c = new wd0.b();
        this.d = new wd0.a();
        this.e = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(1000, new ArrayList()), TuplesKt.to(2000, new ArrayList()), TuplesKt.to(3000, new ArrayList())});
    }

    public final void d(boolean r4) {
        if ((!Intrinsics.areEqual(this.c.g, Boolean.valueOf(r4))) == false) goto L6;
        this.c.g = Boolean.valueOf(r4);
        this.d.a(this.c, this.a, this.b);
        return;
    }

    public final void e(IRoom r4) {
        wd0.b r0 = this.c;
        r0.b = r4;
        r0.a = this.f;
        this.d.a(r0, this.a, this.b);
    }

    public final void f(int r4) {
        Integer r0 = this.c.c;
        if (r0 != null) goto L6;
    L7:
        wd0.b r1 = this.c;
        r1.c = Integer.valueOf(r4);
        this.d.a(this.c, this.a, this.b);
        return;
    L6:
        if (r0.intValue() != r4) goto L7;
    }

    public final void g(boolean r4) {
        if ((!Intrinsics.areEqual(this.c.e, Boolean.valueOf(r4))) == false) goto L6;
        this.c.e = Boolean.valueOf(r4);
        this.d.a(this.c, this.a, this.b);
        return;
    }

    public final void h(int r4) {
        Integer r0 = this.c.d;
        if (r0 != null) goto L6;
    L7:
        wd0.b r1 = this.c;
        r1.d = Integer.valueOf(r4);
        this.d.a(this.c, this.a, this.b);
        return;
    L6:
        if (r0.intValue() != r4) goto L7;
    }

    public final void a(int r4, zd0.b r5) {
        Intrinsics.checkNotNullParameter(r5, "layerViewGroup");
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((xd0.a) r1).b != r4) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L4;
    L12:
        xd0.a r3 = (xd0.a) r1;
        if (r3 == null) goto L15;
        ((ArrayList) this.a).remove(r3);
    L15:
        List<xd0.a> r6 = this.a;
        ArrayList r7 = (ArrayList) r6;
        r7.add(new xd0.a(r4, r5));
        List<c> r8 = this.e.remove(Integer.valueOf(r4));
        if (r8 == null) goto L21;
        Iterator<T> r9 = r8.iterator();
    L19:
        if (r9.hasNext() == false) goto L28;
        c r10 = (c) r9.next();
        b(r4, r10.a, r10.b);
        goto L19
    L28:
        return;
    L21:
        return;
    L8:
        r2 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }

    public final void b(int r7, int r8, yd0.b r9) {
        Intrinsics.checkNotNullParameter(r9, "bgView");
        Iterator<T> r0 = this.a.iterator();
    L3:
        yd0.c<? extends yd0.b> r4 = null;
        if (r0.hasNext() == false) goto L11;
        Object r1 = r0.next();
        if (((xd0.a) r1).b != r7) goto L8;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L3;
    L12:
        xd0.a r2 = (xd0.a) r1;
        if (r2 == null) goto L38;
        Iterator<T> r10 = r2.a.iterator();
    L16:
        if (r10.hasNext() == false) goto L23;
        Object r3 = r10.next();
        if (((c) r3).a != r8) goto L20;
        boolean r6 = true;
    L21:
        if (r6 == false) goto L16;
    L24:
        c r11 = (c) r3;
        if (r11 == null) goto L31;
        Intrinsics.checkNotNullParameter(r11, "subLiveBgLayer");
        ((ArrayList) r2.a).remove(r11);
        yd0.c<? extends yd0.b> r12 = r2.c;
        if ((r12 instanceof yd0.c) == true) goto L29;
        r12 = null;
    L29:
        if (r12 == null) goto L31;
        r12.a(r11.b);
    L31:
        c r13 = new c(r8, r9);
        Intrinsics.checkNotNullParameter(r13, "subLiveBgLayer");
        yd0.c<? extends yd0.b> r14 = r2.c;
        if ((r14 instanceof yd0.c) == false) goto L35;
        r4 = r14;
    L35:
        if (r4 == null) goto L37;
        r4.b(r13.b);
    L37:
        ((ArrayList) r2.a).add(r13);
        return;
    L20:
        r6 = false;
        goto L21
    L23:
        r3 = null;
        goto L24
    L38:
        List<c> r15 = this.e.get(Integer.valueOf(r7));
        if (r15 == null) goto L53;
        r15.add(new c(r8, r9));
        return;
    L53:
        return;
    L8:
        r5 = false;
        goto L9
    L11:
        r1 = null;
        goto L12
    }
}
