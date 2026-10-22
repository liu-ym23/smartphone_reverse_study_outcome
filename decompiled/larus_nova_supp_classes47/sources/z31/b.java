package z31;

import android.widget.FrameLayout;
import androidx.constraintlayout.widget.Guideline;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.ViewUtilsKt;
import com.bytedance.android.live.revlink.impl.pk.feedview.frame.ModeType;
import com.bytedance.android.live.revlink.impl.pk.feedview.machine.l;
import com.bytedance.android.live.revlink.impl.pk.ui.IMProgressBarLayout;
import com.bytedance.common.utility.UIUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b {
    public final c a;
    public Boolean b;
    public boolean c;
    public a41.c d;
    public a41.b e;
    public a41.d f;
    public final FrameLayout g;

    public final boolean c() {
        Boolean r1 = this.b;
        Boolean r2 = Boolean.TRUE;
        if (Intrinsics.areEqual(r1, r2) == false) goto L138;
        t41.a r3 = t41.a.m;
        if (r3.a() == true) goto L7;
    L8:
        a41.c r4 = this.d;
        if (r4 != null) goto L11;
        Boolean r5 = null;
    L16:
        this.g.setVisibility(0);
        if ((!Intrinsics.areEqual(r5, r2)) == true) goto L136;
        a41.c r6 = this.d;
        if (r6 == null) goto L28;
        Intrinsics.checkNotNullParameter(this.a, "state");
        xx0.a r7 = r6.a;
        if (r7 == null) goto L28;
        Guideline r8 = r6.b;
        if (r8 == null) goto L27;
        r8.setGuidelineBegin((int) r7.a.b.top);
    L27:
        UIUtils.updateLayout(r6.c, -3, (int) r7.a.b.height());
    L28:
        a41.b r9 = this.e;
        if (r9 == null) goto L84;
        c r10 = this.a;
        Intrinsics.checkNotNullParameter(r10, "state");
        if (((Boolean) t41.a.k.getValue(r3, t41.a.a[9])).booleanValue() == false) goto L84;
        Long r12 = r10.a;
        if (r12 == null) goto L51;
        long r13 = r12.longValue();
        String r14 = r9.a;
        if (r14 == null) goto L40;
        String r15 = r9.b;
        if (r15 == null) goto L40;
        r9.a(r14, r15);
    L40:
        d51.c r16 = d51.c.A0;
        String r17 = r16.k();
        r41.d r18 = r16.p().get(Long.valueOf(r13));
        if (r18 == null) goto L45;
        String r19 = r18.b();
        if (r19 == null) goto L45;
        r17 = r19;
    L45:
        String r110 = r16.j();
        r41.d r20 = r16.p().get(Long.valueOf(r13));
        if (r20 == null) goto L50;
        String r22 = r20.a();
        if (r22 == null) goto L50;
        r110 = r22;
    L50:
        r9.a(r17, r110);
    L51:
        String r23 = r10.h;
        if (r23 != null) goto L54;
    L61:
        boolean r24 = false;
    L62:
        HSImageView r25 = r9.e;
        if (r25 == null) goto L73;
        Integer r26 = r10.g;
        if (r26 != null) goto L68;
    L71:
        boolean r27 = false;
    L72:
        ViewUtilsKt.g(r25, r27);
        goto L73
    L68:
        if (r26.intValue() != 0) goto L71;
        if (r24 == true) goto L71;
        r27 = true;
    L73:
        HSImageView r28 = r9.f;
        if (r28 == null) goto L84;
        Integer r29 = r10.g;
        if (r29 != null) goto L79;
    L82:
        boolean r30 = false;
    L83:
        ViewUtilsKt.g(r28, r30);
        goto L84
    L79:
        if (r29.intValue() != 0) goto L82;
        if (r24 == true) goto L82;
        r30 = true;
        goto L83
    L54:
        if (r23.length() <= 0) goto L56;
        boolean r32 = true;
    L57:
        if (r32 != true) goto L61;
        if ((!Intrinsics.areEqual(r10.h, "null")) == false) goto L61;
        r24 = true;
        goto L62
    L56:
        r32 = false;
    L84:
        a41.d r33 = this.f;
        if (r33 == null) goto L135;
        c r34 = this.a;
        Intrinsics.checkNotNullParameter(r34, "state");
        l r35 = r34.c;
        if (r35 == null) goto L135;
        ModeType r36 = r34.b;
        if (r36 == null) goto L135;
        if (r36 != ModeType.BreakThough) goto L98;
        IMProgressBarLayout r37 = r33.a;
        if (r37 == null) goto L135;
        r37.setVisibility(8);
        goto L135
    L98:
        if ((r35 instanceof l.a) == false) goto L102;
        IMProgressBarLayout r38 = r33.a;
        if (r38 == null) goto L135;
        r38.setVisibility(8);
        goto L135
    L102:
        long r39 = 0;
        if (r36 != ModeType.PK) goto L118;
        IMProgressBarLayout r40 = r33.a;
        if (r40 == null) goto L132;
        d r42 = r34.e;
        if (r42 == null) goto L111;
        Integer r43 = r42.a;
        if (r43 == null) goto L111;
        long r111 = r43.intValue();
    L112:
        d r44 = r34.e;
        if (r44 == null) goto L117;
        Integer r45 = r44.d;
        if (r45 == null) goto L117;
        r39 = r45.intValue();
    L117:
        r40.a(false, r111, r39);
    L111:
        r111 = 0;
    L132:
        IMProgressBarLayout r46 = r33.a;
        if (r46 == null) goto L135;
        r46.setVisibility(0);
        goto L135
    L118:
        IMProgressBarLayout r112 = r33.a;
        if (r112 == null) goto L132;
        d r47 = r34.e;
        if (r47 == null) goto L125;
        Integer r48 = r47.a;
        if (r48 == null) goto L125;
        long r113 = r48.intValue();
    L126:
        d r49 = r34.e;
        if (r49 == null) goto L131;
        Integer r50 = r49.d;
        if (r50 == null) goto L131;
        r39 = r50.intValue();
    L131:
        r112.a(true, r113, r39);
    L125:
        r113 = 0;
    L135:
        this.g.setImportantForAccessibility(1);
        this.g.setAccessibilityDelegate(new a());
    L136:
        return true;
    L11:
        if (r4.a == null) goto L13;
        boolean r52 = true;
    L14:
        r5 = Boolean.valueOf(r52);
        goto L16
    L13:
        r52 = false;
        goto L14
    L7:
        if (this.c == true) goto L8;
        return false;
    L138:
        return false;
    }

    public b(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "container");
        this.g = r2;
        this.a = new c();
    }

    public final void a(boolean r3) {
        if (Intrinsics.areEqual(this.b, Boolean.valueOf(r3)) == false) goto L6;
        return;
    L6:
        if (c() == true) goto L8;
        this.g.setVisibility(4);
    L8:
        this.b = Boolean.valueOf(r3);
    }

    public final void b(Function1<? super c, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "procedure");
        r2.invoke(this.a);
    }
}
