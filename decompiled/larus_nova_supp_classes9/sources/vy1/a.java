package vy1;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.anya.BaseMVIView;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.a0;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.k;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.BaseHybridComponentContainer;
import com.bytedance.android.livesdk.gift.grouplive.component.GroupComponentState;
import com.bytedance.android.livesdk.gift.grouplive.component.dragger.DraggableContainerView;
import com.bytedance.android.livesdk.gift.grouplive.component.dragger.RegionId;
import com.bytedance.android.livesdk.gift.grouplive.component.l;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a extends BaseMVIView<GroupComponentState, com.bytedance.android.livesdk.gift.grouplive.component.c> {
    public final ConstraintLayout h;
    public final FrameLayout i;
    public final DraggableContainerView j;
    public FrameLayout k;
    public FrameLayout l;
    public final Space m;
    public final Space n;
    public final View o;
    public zy0.b p;
    public ty1.c q;
    public int r;
    public Pair<Integer, Integer> s;
    public String t;
    public final CompositeDisposable u;
    public final Context v;

    /* JADX INFO: renamed from: vy1.a$a, reason: collision with other inner class name */
    public static final class C0290a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Configuration r5 = (Configuration) r4;
            if (FoldScreenUtils.f() == false) goto L10;
            zy0.b r6 = this.a.p;
            if (r6 == null) goto L11;
            xy0.a r7 = r6.g();
            if (r7 == null) goto L12;
            int r0 = this.a.q();
            this.a.getClass();
            r7.updateScreenMetrics(r0, RangesKt.coerceAtLeast(s1.y(), s1.w()));
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    static {
    }

    public final void i() {
        zy0.b r0 = this.p;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.u.clear();
        this.j.setDragCallback(null);
        this.q = null;
        this.s = TuplesKt.to(0, 0);
    }

    public final void g() {
        s((int) (q() * 0.31466666f));
        RxUtilKt.c(vh6.c.b(rr2.a.class).fg().subscribe(new b(this)), this.u);
    }

    public final int q() {
        return RangesKt.coerceAtMost(s1.y(), s1.w());
    }

    public final Context getContext() {
        return this.v;
    }

    public a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.v = r3;
        ConstraintLayout r4 = LayoutInflater.from(r3).inflate(2131566142, null);
        if (r4 == null) goto L7;
        ConstraintLayout r5 = r4;
        this.h = r5;
        this.i = (FrameLayout) r5.findViewById(2131367009);
        this.j = (DraggableContainerView) r5.findViewById(2131371903);
        this.m = (Space) r5.findViewById(2131384160);
        this.n = (Space) r5.findViewById(2131384159);
        this.o = r5.findViewById(2131371716);
        this.s = TuplesKt.to(0, 0);
        this.t = BuildConfig.FLAVOR;
        this.u = new CompositeDisposable();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    public final boolean d(a0 r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        if ((r5 instanceof l) == false) goto L18;
        zy0.b r0 = this.p;
        if (r0 == null) goto L9;
        xy0.a r1 = r0.g();
        if (r1 == null) goto L9;
        r1.updateScreenMetrics(q(), RangesKt.coerceAtLeast(s1.y(), s1.w()));
    L9:
        zy0.b r2 = this.p;
        if (r2 == null) goto L16;
        xy0.a r3 = r2.g();
        if (r3 == null) goto L16;
        View r4 = r3.getHybridView();
        if (r4 == null) goto L16;
        r4.requestLayout();
    L16:
        l r6 = (l) r5;
        p(r6.a, r6.b, r6.c);
        return true;
    L18:
        return false;
    }

    public final void s(int r4) {
        jy0.b.a("GroupComponentView", "updateRegionBWidth, width:" + r4);
        if (r4 != 0) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r0 = this.n.getLayoutParams();
        int r5 = Math.min((int) (q() * 0.31466666f), r4);
        if (r0.width == r5) goto L9;
        r0.width = r5;
        this.n.setLayoutParams(r0);
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void b(k r19, MVIState r20) {
        GroupComponentState r2 = (GroupComponentState) r20;
        Intrinsics.checkNotNullParameter(r19, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r2, "state");
        r r3 = r2.c;
        KProperty[] r4 = GroupComponentState.j;
        KProperty r6 = r4[2];
        r3.getClass();
        Object r7 = r19.c.a(r3);
        if (r7 == null) goto L22;
        r19.b.a.invoke(r3);
        GroupComponentState.Mode r8 = (GroupComponentState.Mode) r7;
        this.l = this.k;
        if (r8 != GroupComponentState.Mode.EXPAND) goto L14;
        DraggableContainerView r5 = this.j;
        if (r5 == null) goto L9;
        r5.setVisibility(0);
    L9:
        FrameLayout r9 = this.i;
        if (r9 == null) goto L12;
        r9.setVisibility(8);
    L12:
        this.k = this.j;
    L14:
        if (r8 != GroupComponentState.Mode.CLOSE) goto L22;
        DraggableContainerView r10 = this.j;
        if (r10 == null) goto L18;
        r10.setVisibility(8);
    L18:
        FrameLayout r11 = this.i;
        if (r11 == null) goto L21;
        r11.setVisibility(0);
    L21:
        this.k = this.i;
    L22:
        r r13 = r2.d;
        KProperty r14 = r4[3];
        r13.getClass();
        r r15 = r2.b;
        KProperty r16 = r4[1];
        r15.getClass();
        r r17 = r2.g;
        KProperty r18 = r4[6];
        r17.getClass();
        Object r110 = r19.c.a(r13);
        if (r110 == null) goto L25;
        r19.b.a.invoke(r13);
    L26:
        Object r111 = r19.c.a(r15);
        if (r111 == null) goto L29;
        r19.b.a.invoke(r15);
    L30:
        Object r112 = r19.c.a(r17);
        if (r112 == null) goto L33;
        r19.b.a.invoke(r17);
    L34:
        if (r110 != null) goto L37;
        if (r111 != null) goto L37;
        if (r112 != null) goto L37;
    L51:
        r r21 = r2.e;
        KProperty r23 = r4[4];
        r21.getClass();
        r r24 = r2.f;
        KProperty r113 = r4[5];
        r24.getClass();
        r r114 = r2.i;
        KProperty r25 = r4[8];
        r114.getClass();
        Object r26 = r19.c.a(r21);
        if (r26 == null) goto L54;
        r19.b.a.invoke(r21);
    L55:
        Object r115 = r19.c.a(r24);
        if (r115 == null) goto L58;
        r19.b.a.invoke(r24);
    L59:
        Object r116 = r19.c.a(r114);
        if (r116 == null) goto L62;
        r19.b.a.invoke(r114);
    L63:
        if (r26 != null) goto L66;
        if (r115 != null) goto L66;
        if (r116 != null) goto L66;
    L129:
        r r27 = r2.a;
        KProperty r28 = r4[0];
        r27.getClass();
        r r29 = r2.b;
        KProperty r30 = r4[1];
        r29.getClass();
        r r31 = r2.g;
        KProperty r33 = r4[6];
        r31.getClass();
        Object r34 = r19.c.a(r27);
        if (r34 == null) goto L132;
        r19.b.a.invoke(r27);
    L133:
        Object r35 = r19.c.a(r29);
        if (r35 == null) goto L136;
        r19.b.a.invoke(r29);
    L137:
        Object r36 = r19.c.a(r31);
        if (r36 == null) goto L140;
        r19.b.a.invoke(r31);
    L141:
        if (r34 != null) goto L144;
        if (r35 != null) goto L144;
        if (r36 != null) goto L144;
    L159:
        r r37 = r2.h;
        KProperty r38 = r4[7];
        r37.getClass();
        Object r39 = r19.c.a(r37);
        if (r39 == null) goto L163;
        r19.b.a.invoke(r37);
        UtilityKotlinExtentionsKt.v(this.h, ((Boolean) r39).booleanValue());
        return;
    L163:
        return;
    L144:
        if (r34 != null) goto L146;
        r34 = r27.c();
    L146:
        if (r35 != null) goto L148;
        r35 = r29.c();
    L148:
        if (r36 != null) goto L150;
        r36 = r31.c();
    L150:
        int r40 = ((Number) r36).intValue();
        GroupComponentState.Style r41 = (GroupComponentState.Style) r35;
        if (((Boolean) r34).booleanValue() == true) goto L153;
    L155:
        this.j.setDragCallback(null);
    L156:
        RxUtilKt.c(RxUtilKt.g(this.j, true).subscribe(new d(this)), this.u);
        if (((Boolean) qy1.a.d.getValue(null, qy1.a.a[2])).booleanValue() == false) goto L159;
        RxUtilKt.c(RxUtilKt.g(this.h, true).subscribe(new e(this)), this.u);
        goto L159
    L153:
        if (r41 == GroupComponentState.Style.DEFAULT) goto L155;
        ry1.c r43 = new ry1.c();
        ry1.b r44 = new ry1.b(RegionId.A, this.m);
        Intrinsics.checkNotNullParameter(r44, "reg");
        r43.a.add(r44);
        ry1.b r45 = new ry1.b(RegionId.B, this.n);
        Intrinsics.checkNotNullParameter(r45, "reg");
        r43.a.add(r45);
        this.j.setDragCallback(new ry1.a(this.j, r43, new c(this, r41, r40)));
        goto L156
    L140:
        r36 = null;
        goto L141
    L136:
        r35 = null;
        goto L137
    L132:
        r34 = null;
    L66:
        if (r26 != null) goto L68;
        r26 = r21.c();
    L68:
        if (r115 != null) goto L70;
        r115 = r24.c();
    L70:
        if (r116 != null) goto L72;
        r116 = r114.c();
    L72:
        boolean r46 = ((Boolean) r116).booleanValue();
        String r47 = (String) r26;
        LinkedHashMap r48 = new LinkedHashMap();
        String r117 = String.valueOf(System.currentTimeMillis());
        r48.put("container_payload", (String) r115);
        r48.put("current_timestamp", r117);
        r48.put("is_anchor", Boolean.valueOf(r46));
        jy0.b.c("GroupComponentView", "GroupComponentView update Data:" + r117, null, 4);
        if ((!Intrinsics.areEqual(r47, this.t)) == false) goto L124;
        FrameLayout r49 = this.l;
        if (r49 == null) goto L77;
        r49.removeAllViews();
    L77:
        FrameLayout r50 = this.k;
        if (r50 == null) goto L81;
        r50.removeAllViews();
    L81:
        if (r47.length() <= 0) goto L83;
        boolean r51 = true;
    L84:
        if (r51 == true) goto L86;
        zy0.b r53 = this.p;
        if (r53 == null) goto L117;
        r53.dispose();
    L117:
        DraggableContainerView r54 = this.j;
        if (r54 == null) goto L120;
        r54.removeAllViews();
    L120:
        FrameLayout r55 = this.i;
        if (r55 == null) goto L123;
        r55.removeAllViews();
    L123:
        this.t = r47;
        goto L124
    L86:
        if (StringsKt.startsWith$default(r47, "https://", false, 2, null) == false) goto L88;
    L91:
        Uri r56 = x6.a.d(r47);
    L92:
        ReadOnlyProperty r118 = qy1.a.e;
        KProperty[] r119 = qy1.a.a;
        if (((Boolean) r118.getValue(null, r119[3])).booleanValue() == false) goto L95;
        Uri r57 = r56.buildUpon().appendQueryParameter("mix_container_type", "annie").build();
    L97:
        if (((Boolean) qy1.a.f.getValue(null, r119[4])).booleanValue() == false) goto L99;
        r57 = r56.buildUpon().appendQueryParameter("fold_service_update", "1").build();
    L99:
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.e r58 = ((vy0.c) f.a(vy0.c.class)).J8(this.v, r57, null);
        zy0.b r59 = this.p;
        if (r59 == null) goto L102;
        r59.dispose();
    L102:
        this.p = r58;
        if (r58 == null) goto L109;
        FrameLayout r60 = this.k;
        if (r60 == null) goto L107;
        r60.addView((View) ((BaseHybridComponentContainer) r58).d);
        Unit r61 = Unit.INSTANCE;
    L108:
        if (r61 == null) goto L109;
    L110:
        if (r58 == null) goto L123;
        xy0.a r63 = r58.g();
        if (r63 == null) goto L123;
        r63.load(null, r48);
        goto L123
    L107:
        r61 = null;
    L109:
        jy0.b.c("GroupComponentView", "hybrid card create failed!!", null, 4);
        Unit r64 = Unit.INSTANCE;
        goto L110
    L95:
        r57 = r56;
        goto L97
    L88:
        if (StringsKt.startsWith$default(r47, "http://", false, 2, null) == true) goto L91;
        r56 = UriProtector.parse(r47);
        goto L92
    L83:
        r51 = false;
    L124:
        zy0.b r65 = this.p;
        if (r65 == null) goto L129;
        xy0.a r66 = r65.g();
        if (r66 == null) goto L129;
        r66.updateData(r48);
        goto L129
    L62:
        r116 = null;
        goto L63
    L58:
        r115 = null;
        goto L59
    L54:
        r26 = null;
    L37:
        if (r110 != null) goto L39;
        r110 = r13.c();
    L39:
        if (r111 != null) goto L41;
        r111 = r15.c();
    L41:
        if (r112 != null) goto L43;
        r112 = r17.c();
    L43:
        int r67 = ((Number) r112).intValue();
        GroupComponentState.Style r120 = (GroupComponentState.Style) r111;
        ty1.c r121 = (ty1.c) r110;
        this.q = r121;
        if (this.h.getWidth() != 0) goto L46;
    L49:
        this.h.post(new vy1.b(r121, r120, r67, this));
    L50:
        ViewGroup.LayoutParams r68 = this.o.getLayoutParams();
        r68.height = r67;
        this.o.setLayoutParams(r68);
        goto L51
    L46:
        if (this.h.getHeight() == 0) goto L49;
        p(r121, r120, r67);
        goto L50
    L33:
        r112 = null;
        goto L34
    L29:
        r111 = null;
        goto L30
    L25:
        r110 = null;
        goto L26
    }

    public final void r(RegionId r6, int r7) {
        FrameLayout r0 = this.k;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r6 == RegionId.B) goto L12;
        r1 = false;
    L12:
        o(new com.bytedance.android.livesdk.gift.grouplive.component.a(r2, r1, r7));
        return;
    L5:
        if (r0.getVisibility() != 0) goto L7;
        r2 = true;
        goto L9
    }

    public final void p(ty1.c r21, GroupComponentState.Style r23, int r24) {
        jy0.b.a("GroupComponentView", "calculate layout: " + r21);
        ConstraintSet r2 = new ConstraintSet();
        r2.clone(this.h);
        r2.setTranslation(2131371903, 0.0f, 0.0f);
        if (r23 != GroupComponentState.Style.DEFAULT) goto L5;
    L98:
        FrameLayout r1 = this.k;
        if (r1 == null) goto L101;
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
    L103:
        if (r3 == null) goto L105;
        r3.width = -2;
    L105:
        if (r3 == null) goto L107;
        r3.height = -2;
    L107:
        r2.clear(2131371903, 3);
        r2.clear(2131371903, 6);
        r2.clear(2131371903, 4);
        r2.clear(2131371903, 7);
        r2.connect(2131371903, 3, 2131373993, 3);
        r2.connect(2131371903, 7, 2131373993, 7);
        r2.applyTo(this.h);
        return;
    L101:
        r3 = null;
        goto L103
    L5:
        if (r21.c() == 1.0f) goto L7;
    L9:
        float r5 = r21.e() * q();
        float r6 = ((r21.b() / r21.e()) * 2.1653333f) * r5;
        if (((Number) this.s.getFirst()).intValue() != 0) goto L12;
    L14:
        float r16 = r5;
        float r17 = r6;
        Rect r10 = new Rect();
        r10.left = this.m.getLeft();
        r10.top = this.m.getTop();
        r10.bottom = this.h.getHeight() - r24;
        r10.right = this.m.getRight();
        if (r23 != GroupComponentState.Style.HORIZONTAL) goto L43;
        float r7 = (this.h.getHeight() - r24) * r21.d();
        float r8 = this.h.getWidth() * r21.c();
        RectF r9 = new RectF(r8, r7, r8 + r16, r7 + r17);
        if (r9.left >= this.m.getLeft()) goto L20;
        float r11 = this.m.getLeft();
        r9.left = r11;
        r9.right = r11 + r16;
    L20:
        if (r9.right <= this.m.getRight()) goto L23;
        float r13 = this.m.getRight();
        r9.right = r13;
        r9.left = r13 - r16;
    L23:
        if (r9.left >= this.m.getLeft()) goto L26;
        r9.left = this.m.getLeft();
    L26:
        if (r9.right <= this.m.getRight()) goto L28;
        r9.right = this.m.getRight();
    L28:
        float r14 = r9.right - r9.left;
        float r15 = r9.top;
        int r18 = r10.top;
        if (r15 >= r18) goto L31;
        float r19 = r18;
        r9.top = r19;
        r9.bottom = r19 + r17;
    L31:
        float r20 = r9.bottom;
        int r25 = r10.bottom;
        if (r20 <= r25) goto L35;
        r9.bottom = r25;
        r9.top = r25 - r17;
    L35:
        if (r9.top >= r18) goto L38;
        r9.top = r18;
    L38:
        if (r9.bottom <= r25) goto L40;
        r9.bottom = r25;
    L40:
        r2.clear(2131371903, 3);
        r2.clear(2131371903, 6);
        r2.clear(2131371903, 4);
        r2.clear(2131371903, 7);
        r2.connect(2131371903, 6, 2131373993, 6, (int) r9.left);
        r2.connect(2131371903, 3, 2131373993, 3, (int) r9.top);
        r(RegionId.A, (int) r14);
        r2.applyTo(this.h);
    L43:
        if (r23 != GroupComponentState.Style.VERTICAL) goto L109;
        float r4 = this.h.getHeight() * r21.d();
        float r26 = this.h.getWidth() * r21.c();
        RectF r27 = new RectF(r26, r4, r26 + r16, r4 + r17);
        jy0.b.a("GroupComponentView", "rect: " + r27 + ", reginA:" + TuplesKt.to(Integer.valueOf(this.m.getWidth()), Integer.valueOf(this.m.getHeight())) + ", reginB:" + TuplesKt.to(Integer.valueOf(this.n.getWidth()), Integer.valueOf(this.n.getHeight())));
        if (r27.left >= this.m.getLeft()) goto L48;
        r27.left = this.m.getLeft();
        r27.right = this.m.getLeft() + r16;
    L48:
        if (r27.right <= this.n.getRight()) goto L51;
        r27.right = this.n.getRight();
        r27.left = this.n.getRight() - r16;
    L51:
        if (r27.left >= this.n.getLeft()) goto L58;
        if (r27.right <= this.n.getLeft()) goto L58;
        if (r27.bottom <= r10.bottom) goto L58;
        r27.right = this.n.getRight();
        r27.left = this.n.getRight() - r16;
    L58:
        if (r27.left >= this.m.getLeft()) goto L61;
        r27.left = this.m.getLeft();
    L61:
        if (r27.right <= this.n.getRight()) goto L63;
        r27.right = this.n.getRight();
    L63:
        float r28 = r27.right;
        float r29 = r28 - r27.left;
        if (r28 > this.n.getLeft()) goto L66;
    L84:
        float r30 = r27.top;
        int r31 = r10.top;
        if (r30 >= r31) goto L87;
        float r33 = r31;
        r27.top = r33;
        r27.bottom = r33 + r17;
    L87:
        float r34 = r27.bottom;
        int r35 = r10.bottom;
        if (r34 <= r35) goto L91;
        r27.bottom = r35;
        r27.top = r35 - r17;
    L91:
        if (r27.top >= r31) goto L94;
        r27.top = r31;
    L94:
        if (r27.bottom <= r35) goto L96;
        r27.bottom = r35;
    L96:
        r2.clear(2131371903, 3);
        r2.clear(2131371903, 6);
        r2.clear(2131371903, 4);
        r2.clear(2131371903, 7);
        r2.connect(2131371903, 6, 2131373993, 6, (int) r27.left);
        r2.connect(2131371903, 3, 2131373993, 3, (int) r27.top);
        r2.applyTo(this.h);
        r(RegionId.A, (int) r29);
        return;
    L66:
        if (r27.left < this.n.getLeft()) goto L84;
        if (r27.top >= this.n.getTop()) goto L72;
        r27.top = this.n.getTop();
        r27.bottom = this.n.getTop() + r17;
    L72:
        if (r27.bottom <= this.n.getBottom()) goto L75;
        r27.bottom = this.n.getBottom();
        r27.top = this.n.getBottom() - r17;
    L75:
        if (r27.top >= this.n.getTop()) goto L78;
        r27.top = this.n.getTop();
    L78:
        if (r27.bottom <= this.n.getBottom()) goto L81;
        r27.bottom = this.n.getBottom();
    L81:
        if (r27.bottom <= r10.bottom) goto L83;
        r(RegionId.B, (int) r29);
        r2.clear(2131371903, 3);
        r2.clear(2131371903, 6);
        r2.clear(2131371903, 4);
        r2.clear(2131371903, 7);
        r2.connect(2131371903, 6, 2131373993, 6, (int) r27.left);
        r2.connect(2131371903, 3, 2131373993, 3, (int) r27.top);
        r2.applyTo(this.h);
        return;
    L83:
        r(RegionId.A, (int) r29);
        r2.clear(2131371903, 3);
        r2.clear(2131371903, 6);
        r2.clear(2131371903, 4);
        r2.clear(2131371903, 7);
        r2.connect(2131371903, 6, 2131373993, 6, (int) r27.left);
        r2.connect(2131371903, 3, 2131373993, 3, (int) r27.top);
        r2.applyTo(this.h);
        return;
    L109:
        return;
    L12:
        if (((Number) this.s.getSecond()).intValue() == 0) goto L14;
        jy0.b.a("GroupComponentView", "expand size: " + this.s);
        r5 = (float) ((Number) this.s.getFirst()).intValue();
        r6 = (float) ((Number) this.s.getSecond()).intValue();
        goto L14
    L7:
        if (r21.d() != 0.0f) goto L9;
        goto L9
    }
}
