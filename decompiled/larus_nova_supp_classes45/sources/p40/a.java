package p40;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.a0;
import com.bytedance.android.anya.internal.r;
import com.bytedance.android.anya.k;
import com.bytedance.android.live.componentsmarket.api.draggable.DraggableComponentState;
import com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.DraggableContainerView;
import com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger.RegionId;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import k40.e;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a extends k40.d {
    public final ConstraintLayout h;
    public final FrameLayout i;
    public final DraggableContainerView j;
    public FrameLayout k;
    public FrameLayout l;
    public final Space m;
    public final Space n;
    public final View o;
    public Pair<Integer, Integer> p;
    public final CompositeDisposable q;
    public final Context r;
    public final View s;
    public final boolean t;

    /* JADX INFO: renamed from: p40.a$a, reason: collision with other inner class name */
    public static final class C0260a {
    }

    static {
    }

    public final void g() {
        ALogger.d("DraggableComponentView", "onAttach");
        t((int) (r() * 0.31466666f));
        DraggableContainerView r0 = this.j;
        this.k = r0;
        if (r0 == null) goto L6;
        r0.addView(this.s);
        return;
    }

    public final void i() {
        ALogger.e("DraggableComponentView", "DraggableComponentView onDetach");
        this.q.clear();
        this.j.setDragCallback(null);
        this.p = TuplesKt.to(0, 0);
        this.k = null;
    }

    public final int r() {
        return RangesKt.coerceAtMost(s1.y(), s1.w());
    }

    public final Context getContext() {
        return this.r;
    }

    public final boolean d(a0 r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        if ((r3 instanceof e) == false) goto L6;
        e r4 = (e) r3;
        r4.getClass();
        r4.getClass();
        r4.getClass();
        p(null, null, 0, "RefreshLayout");
        return true;
    L6:
        return false;
    }

    public final void t(int r4) {
        ALogger.d("DraggableComponentView", "updateRegionBWidth, width:" + r4);
        if (r4 != 0) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r0 = this.n.getLayoutParams();
        int r5 = Math.min((int) (r() * 0.31466666f), r4);
        if (r0.width == r5) goto L9;
        r0.width = r5;
        this.n.setLayoutParams(r0);
        return;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void b(k r13, MVIState r14) {
        DraggableComponentState r15 = (DraggableComponentState) r14;
        Intrinsics.checkNotNullParameter(r13, "$this$handleDiff");
        Intrinsics.checkNotNullParameter(r15, "state");
        r r0 = r15.c;
        KProperty[] r1 = DraggableComponentState.h;
        KProperty r2 = r1[2];
        r0.getClass();
        Object r3 = r13.c.a(r0);
        if (r3 == null) goto L22;
        r13.b.a.invoke(r0);
        DraggableComponentState.Mode r4 = (DraggableComponentState.Mode) r3;
        this.l = this.k;
        if (r4 != DraggableComponentState.Mode.EXPAND) goto L14;
        DraggableContainerView r5 = this.j;
        if (r5 == null) goto L9;
        r5.setVisibility(0);
    L9:
        FrameLayout r6 = this.i;
        if (r6 == null) goto L12;
        r6.setVisibility(8);
    L12:
        this.k = this.j;
    L14:
        if (r4 != DraggableComponentState.Mode.CLOSE) goto L22;
        DraggableContainerView r7 = this.j;
        if (r7 == null) goto L18;
        r7.setVisibility(8);
    L18:
        FrameLayout r8 = this.i;
        if (r8 == null) goto L21;
        r8.setVisibility(0);
    L21:
        this.k = this.i;
    L22:
        r r9 = r15.d;
        KProperty r11 = r1[3];
        r9.getClass();
        r r12 = r15.b;
        KProperty r16 = r1[1];
        r12.getClass();
        r r17 = r15.f;
        KProperty r18 = r1[5];
        r17.getClass();
        Object r19 = r13.c.a(r9);
        if (r19 == null) goto L25;
        r13.b.a.invoke(r9);
    L26:
        Object r21 = r13.c.a(r12);
        if (r21 == null) goto L29;
        r13.b.a.invoke(r12);
    L30:
        Object r110 = r13.c.a(r17);
        if (r110 == null) goto L33;
        r13.b.a.invoke(r17);
    L34:
        if (r19 != null) goto L37;
        if (r21 != null) goto L37;
        if (r110 != null) goto L37;
    L51:
        r r22 = r15.e;
        KProperty r23 = r1[4];
        r22.getClass();
        Object r24 = r13.c.a(r22);
        if (r24 == null) goto L54;
        r13.b.a.invoke(r22);
        new LinkedHashMap().put("container_payload", (String) r24);
    L54:
        r r25 = r15.a;
        KProperty r26 = r1[0];
        r25.getClass();
        r r27 = r15.b;
        KProperty r28 = r1[1];
        r27.getClass();
        r r29 = r15.f;
        KProperty r31 = r1[5];
        r29.getClass();
        Object r32 = r13.c.a(r25);
        if (r32 == null) goto L57;
        r13.b.a.invoke(r25);
    L58:
        Object r33 = r13.c.a(r27);
        if (r33 == null) goto L61;
        r13.b.a.invoke(r27);
    L62:
        Object r34 = r13.c.a(r29);
        if (r34 == null) goto L65;
        r13.b.a.invoke(r29);
    L66:
        if (r32 != null) goto L69;
        if (r33 != null) goto L69;
        if (r34 != null) goto L69;
    L82:
        r r111 = r15.g;
        KProperty r35 = r1[6];
        r111.getClass();
        Object r36 = r13.c.a(r111);
        if (r36 == null) goto L86;
        r13.b.a.invoke(r111);
        UtilityKotlinExtentionsKt.v(this.h, ((Boolean) r36).booleanValue());
        return;
    L86:
        return;
    L69:
        if (r32 != null) goto L71;
        r32 = r25.c();
    L71:
        if (r33 != null) goto L73;
        r33 = r27.c();
    L73:
        if (r34 != null) goto L75;
        r34 = r29.c();
    L75:
        int r37 = ((Number) r34).intValue();
        DraggableComponentState.Style r38 = (DraggableComponentState.Style) r33;
        if (((Boolean) r32).booleanValue() == true) goto L78;
    L80:
        this.j.setDragCallback(null);
    L81:
        RxUtilKt.c(RxUtilKt.g(this.j, true).subscribe(new d(this)), this.q);
        goto L82
    L78:
        if (r38 == DraggableComponentState.Style.DEFAULT) goto L80;
        q40.c r39 = new q40.c();
        q40.b r41 = new q40.b(RegionId.A, this.m);
        Intrinsics.checkNotNullParameter(r41, "reg");
        r39.a.add(r41);
        q40.b r42 = new q40.b(RegionId.B, this.n);
        Intrinsics.checkNotNullParameter(r42, "reg");
        r39.a.add(r42);
        this.j.setDragCallback(new q40.a(this.j, r39, new c(this, r38, r37)));
        goto L81
    L65:
        r34 = null;
        goto L66
    L61:
        r33 = null;
        goto L62
    L57:
        r32 = null;
    L37:
        if (r19 != null) goto L39;
        r19 = r9.c();
    L39:
        if (r21 != null) goto L41;
        r21 = r12.c();
    L41:
        if (r110 != null) goto L43;
        r110 = r17.c();
    L43:
        int r43 = ((Number) r110).intValue();
        DraggableComponentState.Style r44 = (DraggableComponentState.Style) r21;
        l40.a r45 = (l40.a) r19;
        if (this.h.getWidth() != 0) goto L46;
    L49:
        this.h.post(new b(r45, r44, r43, this));
    L50:
        ViewGroup.LayoutParams r46 = this.o.getLayoutParams();
        r46.height = r43;
        this.o.setLayoutParams(r46);
        goto L51
    L46:
        if (this.h.getHeight() == 0) goto L49;
        p(r45, r44, r43, "else");
        goto L50
    L33:
        r110 = null;
        goto L34
    L29:
        r21 = null;
        goto L30
    L25:
        r19 = null;
        goto L26
    }

    public final l40.a q(DraggableComponentState.Style r7, int r8) {
        FrameLayout r0 = this.k;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (r0.getWidth() != 0) goto L8;
    L18:
        return null;
    L8:
        if (r0.getHeight() == 0) goto L18;
        if (r0.getVisibility() != 0) goto L18;
        float r1 = r0.getWidth();
        float r2 = r0.getHeight() / r1;
        float r3 = r1 / r();
        float r4 = (r2 * r3) * 0.46182266f;
        if (r7 != DraggableComponentState.Style.HORIZONTAL) goto L15;
        float r9 = r0.getY();
        int r5 = this.h.getHeight() - r8;
    L16:
        float r11 = r9 / r5;
        float r12 = r0.getX() / this.h.getWidth();
        float r6 = (r0.getY() + r0.getHeight()) / this.h.getHeight();
        float r13 = (r0.getX() + r0.getWidth()) / this.h.getWidth();
        l40.a r14 = new l40.a(0);
        r14.j(j80.a.a(r11, 4));
        r14.h(j80.a.a(r12, 4));
        r14.i(j80.a.a(r13, 4));
        r14.f(j80.a.a(r6, 4));
        r14.k(j80.a.a(r3, 4));
        r14.g(j80.a.a(r4, 4));
        return r14;
    L15:
        r9 = r0.getY();
        r5 = this.h.getHeight();
        goto L16
    }

    public final void s(RegionId r1, int r2) {
        FrameLayout r3 = this.k;
        if (r3 == null) goto L5;
        r3.getVisibility();
    L5:
        RegionId r4 = RegionId.A;
        o(new k40.a());
    }

    public a(Context r2, View r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "cardView");
        this.r = r2;
        this.s = r3;
        this.t = r4;
        ConstraintLayout r5 = LayoutInflater.from(r2).inflate(2131565826, null);
        if (r5 == null) goto L7;
        ConstraintLayout r6 = r5;
        this.h = r6;
        this.i = (FrameLayout) r6.findViewById(2131367009);
        this.j = (DraggableContainerView) r6.findViewById(2131371903);
        this.m = (Space) r6.findViewById(2131384160);
        this.n = (Space) r6.findViewById(2131384159);
        this.o = r6.findViewById(2131371716);
        this.p = TuplesKt.to(0, 0);
        this.q = new CompositeDisposable();
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    public final void p(l40.a r24, DraggableComponentState.Style r25, int r26, String r27) {
        ALogger.d("DraggableComponentView", "calculate layout: " + r24 + "  style:" + r25 + "  source" + r27);
        ConstraintSet r3 = new ConstraintSet();
        r3.clone(this.h);
        r3.setTranslation(2131371903, 0.0f, 0.0f);
        if (r25 != DraggableComponentState.Style.DEFAULT) goto L18;
        FrameLayout r4 = this.k;
        if (r4 == null) goto L7;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
    L9:
        if (r5 == null) goto L11;
        r5.width = -2;
    L11:
        if (r5 == null) goto L13;
        r5.height = -2;
    L13:
        r3.clear(2131371903, 3);
        r3.clear(2131371903, 6);
        r3.clear(2131371903, 4);
        r3.clear(2131371903, 7);
        r3.connect(2131371903, 3, 2131373993, 3);
        r3.connect(2131371903, 6, 2131373993, 6);
        r3.applyTo(this.h);
        l40.a r1 = q(r25, r26);
        if (r1 != null) goto L16;
        return;
    L16:
        o(new k40.b(r1));
        return;
    L7:
        r5 = null;
        goto L9
    L18:
        float r6 = r24.e() * r();
        float r7 = ((r24.b() / r24.e()) * 2.1653333f) * r6;
        if (((Number) this.p.getFirst()).intValue() != 0) goto L21;
    L23:
        float r16 = r6;
        float r17 = r7;
        Rect r11 = new Rect();
        r11.left = this.m.getLeft();
        r11.top = this.m.getTop();
        r11.bottom = this.h.getHeight() - r26;
        r11.right = this.m.getRight();
        if (r25 != DraggableComponentState.Style.HORIZONTAL) goto L50;
        float r2 = (this.h.getHeight() - r26) * r24.d();
        float r8 = this.h.getWidth() * r24.c();
        RectF r9 = new RectF(r8, r2, r8 + r16, r2 + r17);
        if (r9.left >= this.m.getLeft()) goto L29;
        float r12 = this.m.getLeft();
        r9.left = r12;
        r9.right = r12 + r16;
    L29:
        if (r9.right <= this.m.getRight()) goto L32;
        float r13 = this.m.getRight();
        r9.right = r13;
        r9.left = r13 - r16;
    L32:
        if (r9.left >= this.m.getLeft()) goto L35;
        r9.left = this.m.getLeft();
    L35:
        if (r9.right <= this.m.getRight()) goto L37;
        r9.right = this.m.getRight();
    L37:
        float r14 = r9.right - r9.left;
        float r15 = r9.top;
        float r18 = r11.top;
        if (r15 >= r18) goto L40;
        r9.top = r18;
        r9.bottom = r18 + r17;
    L40:
        float r19 = r9.bottom;
        float r21 = r11.bottom;
        if (r19 <= r21) goto L44;
        r9.bottom = r21;
        r9.top = r21 - r17;
    L44:
        if (r9.top >= r18) goto L47;
        r9.top = r18;
    L47:
        if (r9.bottom <= r21) goto L49;
        r9.bottom = r21;
    L49:
        r3.clear(2131371903, 3);
        r3.clear(2131371903, 6);
        r3.clear(2131371903, 4);
        r3.clear(2131371903, 7);
        int r110 = 3;
        r3.connect(2131371903, 6, 2131373993, 6, (int) r9.left);
        r3.connect(2131371903, 3, 2131373993, 3, (int) r9.top);
        s(RegionId.A, (int) r14);
        r3.applyTo(this.h);
    L52:
        if (r25 != DraggableComponentState.Style.VERTICAL) goto L107;
        float r22 = this.h.getHeight() * r24.d();
        float r23 = this.h.getWidth() * r24.c();
        RectF r28 = new RectF(r23, r22, r23 + r16, r22 + r17);
        ALogger.d("DraggableComponentView", "rect: " + r28 + ", reginA:" + TuplesKt.to(Integer.valueOf(this.m.getWidth()), Integer.valueOf(this.m.getHeight())) + ", reginB:" + TuplesKt.to(Integer.valueOf(this.n.getWidth()), Integer.valueOf(this.n.getHeight())));
        if (r28.left >= this.m.getLeft()) goto L57;
        r28.left = this.m.getLeft();
        r28.right = this.m.getLeft() + r16;
    L57:
        if (r28.right <= this.n.getRight()) goto L60;
        r28.right = this.n.getRight();
        r28.left = this.n.getRight() - r16;
    L60:
        if (r28.left >= this.n.getLeft()) goto L67;
        if (r28.right <= this.n.getLeft()) goto L67;
        if (r28.bottom <= r11.bottom) goto L67;
        r28.right = this.n.getRight();
        r28.left = this.n.getRight() - r16;
    L67:
        if (r28.left >= this.m.getLeft()) goto L70;
        r28.left = this.m.getLeft();
    L70:
        if (r28.right <= this.n.getRight()) goto L72;
        r28.right = this.n.getRight();
    L72:
        float r29 = r28.right;
        float r31 = r29 - r28.left;
        if (r29 > this.n.getLeft()) goto L75;
    L93:
        float r32 = r28.top;
        float r33 = r11.top;
        if (r32 >= r33) goto L96;
        r28.top = r33;
        r28.bottom = r33 + r17;
    L96:
        float r34 = r28.bottom;
        float r35 = r11.bottom;
        if (r34 <= r35) goto L100;
        r28.bottom = r35;
        r28.top = r35 - r17;
    L100:
        if (r28.top >= r33) goto L103;
        r28.top = r33;
    L103:
        if (r28.bottom <= r35) goto L105;
        r28.bottom = r35;
    L105:
        r3.clear(2131371903, r110);
        r3.clear(2131371903, 6);
        r3.clear(2131371903, 4);
        r3.clear(2131371903, 7);
        r3.connect(2131371903, 6, 2131373993, 6, (int) r28.left);
        r3.connect(2131371903, 3, 2131373993, 3, (int) r28.top);
        r3.applyTo(this.h);
        s(RegionId.A, (int) r31);
        return;
    L75:
        if (r28.left < this.n.getLeft()) goto L93;
        if (r28.top >= this.n.getTop()) goto L81;
        r28.top = this.n.getTop();
        r28.bottom = this.n.getTop() + r17;
    L81:
        if (r28.bottom <= this.n.getBottom()) goto L84;
        r28.bottom = this.n.getBottom();
        r28.top = this.n.getBottom() - r17;
    L84:
        if (r28.top >= this.n.getTop()) goto L87;
        r28.top = this.n.getTop();
    L87:
        if (r28.bottom <= this.n.getBottom()) goto L90;
        r28.bottom = this.n.getBottom();
    L90:
        if (r28.bottom <= r11.bottom) goto L92;
        s(RegionId.B, (int) r31);
        r3.clear(2131371903, r110);
        r3.clear(2131371903, 6);
        r3.clear(2131371903, 4);
        r3.clear(2131371903, 7);
        r3.connect(2131371903, 6, 2131373993, 6, (int) r28.left);
        r3.connect(2131371903, 3, 2131373993, 3, (int) r28.top);
        r3.applyTo(this.h);
        return;
    L92:
        s(RegionId.A, (int) r31);
        r3.clear(2131371903, r110);
        r3.clear(2131371903, 6);
        r3.clear(2131371903, 4);
        r3.clear(2131371903, 7);
        r3.connect(2131371903, 6, 2131373993, 6, (int) r28.left);
        r3.connect(2131371903, 3, 2131373993, 3, (int) r28.top);
        r3.applyTo(this.h);
        return;
    L107:
        return;
    L50:
        r110 = 3;
        goto L52
    L21:
        if (((Number) this.p.getSecond()).intValue() == 0) goto L23;
        ALogger.d("DraggableComponentView", "expand size: " + this.p);
        r6 = (float) ((Number) this.p.getFirst()).intValue();
        r7 = (float) ((Number) this.p.getSecond()).intValue();
        goto L23
    }
}
