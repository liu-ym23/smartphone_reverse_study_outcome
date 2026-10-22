package wt8;

import android.view.View;
import android.widget.FrameLayout;
import com.larus.bmhome.view.l1;
import com.larus.bmhome.view.m1;
import com.larus.chat.common.databinding.LarusChatTitleAlignLeftStyleBinding;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class o {
    public static final int[] e = null;
    public static final int[] f = null;
    public final LarusChatTitleAlignLeftStyleBinding a;
    public final boolean b;
    public final Function0<Float> c;
    public final Function0<Boolean> d;

    public static final class a {
    }

    public final int a() {
        View[] r0 = new View[5];
        LarusChatTitleAlignLeftStyleBinding r1 = this.a;
        r0[0] = r1.h;
        r0[1] = r1.t;
        r0[2] = r1.f;
        FrameLayout r2 = r1.E;
        if (r1.D.getVisibility() != 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
    L14:
        boolean r4 = true;
    L16:
        if (r4 == true) goto L19;
        r2 = null;
    L19:
        r0[3] = r2;
        LarusChatTitleAlignLeftStyleBinding r5 = this.a;
        FrameLayout r6 = r5.p;
        if (r5.o.getVisibility() != 0) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L25;
    L31:
        boolean r8 = true;
    L32:
        if (r8 == true) goto L35;
        r6 = null;
    L35:
        r0[4] = r6;
        List r9 = CollectionsKt.listOfNotNull(r0);
        if ((r9 instanceof Collection) == true) goto L38;
    L40:
        Iterator r10 = r9.iterator();
        int r11 = 0;
    L42:
        if (r10.hasNext() == false) goto L56;
        View r12 = (View) r10.next();
        if (r12.getVisibility() != 0) goto L46;
        boolean r13 = true;
    L47:
        if (r13 == true) goto L49;
    L51:
        boolean r14 = false;
    L52:
        if (r14 == false) goto L42;
        r11 = r11 + 1;
        if (r11 >= 0) goto L42;
        CollectionsKt.throwCountOverflow();
        goto L42
    L49:
        if (r12.getAlpha() <= 0.0f) goto L51;
        r14 = true;
        goto L52
    L46:
        r13 = false;
    L56:
        int r15 = RangesKt.coerceAtMost(r11, 2);
        if (r15 > 0) goto L60;
        return 0;
    L60:
        return (r15 * this.a.a.getResources().getDimensionPixelSize(v19.c.b(2130971490, null, 2131167350))) + this.a.a.getResources().getDimensionPixelSize(v19.c.b(2130971546, null, 2131167462));
    L38:
        if (r9.isEmpty() == false) goto L40;
        r11 = 0;
        goto L56
    L25:
        if (this.a.b.getVisibility() != 0) goto L27;
        boolean r16 = true;
    L28:
        if (r16 == true) goto L31;
        r8 = false;
        goto L32
    L27:
        r16 = false;
        goto L28
    L22:
        r7 = false;
        goto L23
    L8:
        if (this.a.F.getVisibility() != 0) goto L10;
        boolean r17 = true;
    L11:
        if (r17 == true) goto L14;
        r4 = false;
        goto L16
    L10:
        r17 = false;
        goto L11
    L5:
        r3 = false;
        goto L6
    }

    static {
        e = new int[]{2131380113, 2131376290, 2131383774, 2131368203, 2131389947, 2131380295};
        f = new int[]{2131380113};
    }

    public final void b() {
        if (this.b == true) goto L5;
        return;
    L5:
        this.a.a.post(new m(this));
    }

    public o(LarusChatTitleAlignLeftStyleBinding r2, boolean r3, l1 r4, m1 r5) {
        Intrinsics.checkNotNullParameter(r2, "binding");
        Intrinsics.checkNotNullParameter(r4, "titleBarIconAnimationProgress");
        Intrinsics.checkNotNullParameter(r5, "shouldUseDynamicEndSpace");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
