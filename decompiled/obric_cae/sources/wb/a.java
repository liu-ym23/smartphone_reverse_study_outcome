package wb;

import ac.h;
import ac.n;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.obric.cae.R;
import com.obric.oui.layout.OUIFrameLayout;
import db.d;
import defpackage.c;
import ge.q;
import hb.e;
import he.i;
import he.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import yd.f;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends OUIFrameLayout {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d f13087q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public d f13088r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f13089s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f13090t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float f13091u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f13092v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float f13093w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public OUIFrameLayout f13094x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List<n> f13095y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List<n> f13096z;

    /* JADX INFO: renamed from: wb.a$a, reason: collision with other inner class name */
    public static final class C0190a extends j implements q<String, Object, Object, xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f13097a;

        public C0190a(a r8) {
            this.f13097a = r8;
            super(3);
        }

        @Override // ge.q
        public final xd.j invoke(String r8, Object r10, Object r11) {
            String r12 = r8;
            i.f(r12, "property");
            i.f(r10, "currentValue");
            i.f(r11, "velocity");
            zc.b.a("OShadowFrame", "doPressAnim: " + r12 + ", " + r10 + ", " + r11);
            hb.a r13 = hb.a.f8015b;
            if (i.a(r12, "scaleX") == false) goto L15;
            a r14 = this.f13097a;
            List<n> r15 = r14.f13095y;
            List<n> r16 = r14.f13096z;
            List r17 = a.b(r14, ((Float) r10).floatValue(), r14.f13091u, r14.f13092v, r15, r16);
            if (r17 == null) goto L15;
            n r18 = (n) yd.i.h1(0, r17);
            n r19 = (n) yd.i.h1(1, r17);
            StringBuilder r110 = new StringBuilder("doPressAnim, valid? firstShadow: ");
            Boolean r20 = null;
            if (r18 == null) goto L9;
            Boolean r21 = Boolean.valueOf(r18.a());
        L10:
            r110.append(r21);
            r110.append(", secondShadow: ");
            if (r19 == null) goto L13;
            r20 = Boolean.valueOf(r19.a());
        L13:
            r110.append(r20);
            zc.b.a("OShadowFrame", r110.toString());
            r14.a(r18, r19);
            goto L15
        L9:
            r21 = null;
        L15:
            return xd.j.f13877a;
        }
    }

    public static final class b extends j implements q<String, Object, Object, xd.j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f13098a;

        public b(a r8) {
            this.f13098a = r8;
            super(3);
        }

        @Override // ge.q
        public final xd.j invoke(String r8, Object r10, Object r11) {
            String r12 = r8;
            i.f(r12, "property");
            i.f(r10, "currentValue");
            i.f(r11, "velocity");
            zc.b.a("OShadowFrame", "doPressAnim: " + r12 + ", " + r10 + ", " + r11);
            hb.a r13 = hb.a.f8015b;
            if (i.a(r12, "scaleX") == false) goto L15;
            a r14 = this.f13098a;
            List<n> r15 = r14.f13096z;
            List<n> r16 = r14.f13095y;
            List r17 = a.b(r14, ((Float) r10).floatValue(), r14.f13092v, r14.f13091u, r15, r16);
            if (r17 == null) goto L15;
            n r18 = (n) yd.i.h1(0, r17);
            n r19 = (n) yd.i.h1(1, r17);
            StringBuilder r110 = new StringBuilder("doPressAnim, valid? firstShadow: ");
            Boolean r20 = null;
            if (r18 == null) goto L9;
            Boolean r21 = Boolean.valueOf(r18.a());
        L10:
            r110.append(r21);
            r110.append(", secondShadow: ");
            if (r19 == null) goto L13;
            r20 = Boolean.valueOf(r19.a());
        L13:
            r110.append(r20);
            zc.b.a("OShadowFrame", r110.toString());
            r14.a(r18, r19);
            goto L15
        L9:
            r21 = null;
        L15:
            return xd.j.f13877a;
        }
    }

    public a(Context r8, AttributeSet r10) {
        this(r8, r10, 0, 12);
    }

    public static final List b(a r8, float r10, float r11, float r12, List r13, List r14) {
        r8.getClass();
        float r15 = l6.a.w((r10 - r11) / (r12 - r11));
        if (r13 == null) goto L17;
        if (r14 != null) goto L6;
        return r13;
    L6:
        if (r13.size() != r14.size()) goto L19;
        Iterator r16 = r13.iterator();
        Iterator r17 = r14.iterator();
        ArrayList r18 = new ArrayList(Math.min(f.f1(r13), f.f1(r14)));
    L9:
        if (r16.hasNext() == false) goto L14;
        if (r17.hasNext() == false) goto L14;
        Object r19 = r16.next();
        n r110 = (n) r17.next();
        n r111 = (n) r19;
        int r20 = c.G(r15, r111.f334a, r110.f334a);
        float r21 = r111.f335b;
        float r22 = defpackage.a.a(r110.f335b, r21, r15, r21);
        float r23 = r111.f336c;
        float r24 = defpackage.a.a(r110.f336c, r23, r15, r23);
        float r25 = r111.f337d;
        float r26 = defpackage.a.a(r110.f337d, r25, r15, r25);
        float r112 = r111.f338e;
        r18.add(new n(r20, r22, r24, r26, defpackage.a.a(r110.f338e, r112, r15, r112)));
    L14:
        return r18;
    L19:
        return r13;
    L17:
        return r13;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r8) {
        i.f(r8, "event");
        boolean r10 = super.dispatchTouchEvent(r8);
        int r11 = r8.getAction();
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L6;
    L8:
        h(false);
    L10:
        return r10;
    L6:
        if (r11 == 3) goto L8;
    L9:
        h(true);
        goto L10
    }

    public final OUIFrameLayout getContentView() {
        OUIFrameLayout r8 = this.f13094x;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("contentView");
        throw null;
    }

    public final void h(boolean r8) {
        if (isEnabled() == true) goto L6;
        zc.b.a("OShadowFrame", "doPressAnim, skip, isEnabled=false");
        return;
    L6:
        zc.b.a("OShadowFrame", "doPressAnim: " + r8);
        d r10 = this.f13087q;
        if (r10 == null) goto L9;
        d.a(r10);
    L9:
        d r11 = this.f13088r;
        if (r11 == null) goto L12;
        d.a(r11);
    L12:
        float r12 = this.f13093w;
        if (r8 == false) goto L15;
        za.a.C0206a r13 = c.p(this);
        hb.a r14 = hb.a.f8015b;
        Float r15 = Float.valueOf(getScaleX());
        float r16 = this.f13092v;
        e[] r17 = e.f8026a;
        hb.f[] r18 = hb.f.f8027a;
        gb.b r19 = l6.a.N0();
        r19.f7789b = r12;
        xd.j r20 = xd.j.f13877a;
        za.a.C0206a.b(r13, r14, r15, r16, r19);
        hb.a r21 = hb.a.f8016m;
        Float r22 = Float.valueOf(getScaleY());
        float r23 = this.f13092v;
        gb.b r24 = l6.a.N0();
        r24.f7789b = r12;
        za.a.C0206a.b(r13, r21, r22, r23, r24);
        r13.f14326d = new C0190a(this);
        this.f13087q = za.a.a(r13.a());
        return;
    L15:
        za.a.C0206a r25 = c.p(this);
        hb.a r26 = hb.a.f8015b;
        Float r27 = Float.valueOf(getScaleX());
        e[] r28 = e.f8026a;
        hb.f[] r29 = hb.f.f8027a;
        gb.b r30 = l6.a.N0();
        r30.f7789b = r12;
        xd.j r31 = xd.j.f13877a;
        float r32 = this.f13091u;
        za.a.C0206a.b(r25, r26, r27, r32, r30);
        hb.a r33 = hb.a.f8016m;
        Float r34 = Float.valueOf(getScaleY());
        gb.b r35 = l6.a.N0();
        r35.f7789b = r12;
        za.a.C0206a.b(r25, r33, r34, r32, r35);
        r25.f14326d = new b(this);
        this.f13088r = za.a.a(r25.a());
    }

    public abstract void i(Context r8, OUIFrameLayout r10, TypedArray r11);

    public void j(boolean r8) {
        if (r8 == false) goto L9;
        OUIFrameLayout r10 = this.f13094x;
        if (r10 == null) goto L7;
        int r11 = this.f13089s;
    L12:
        r10.setBackgroundColor(r11);
        return;
    L7:
        i.j("contentView");
        throw null;
    L9:
        r10 = this.f13094x;
        if (r10 == null) goto L14;
        r11 = this.f13090t;
        goto L12
    L14:
        i.j("contentView");
        throw null;
    }

    public final void setBgColor(int r8) {
        this.f13089s = r8;
        j(isEnabled());
    }

    public final void setContentView(OUIFrameLayout r8) {
        i.f(r8, "<set-?>");
        this.f13094x = r8;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r8) {
        super.setEnabled(r8);
        j(r8);
    }

    public final void setPressColor(int r8) {
        OUIFrameLayout r10 = this.f13094x;
        if (r10 == null) goto L10;
        r10.setOverridePressColor(r8);
        OUIFrameLayout r11 = this.f13094x;
        if (r11 == null) goto L8;
        r11.f6339n.g();
        return;
    L8:
        i.j("contentView");
        throw null;
    L10:
        i.j("contentView");
        throw null;
    }

    public a(Context r10, AttributeSet r11, int r12) {
        i.f(r10, "context");
        super(r10, r11, r12, 8);
        this.f13091u = 1.0f;
        this.f13092v = 1.0f;
        this.f13093w = 0.01f;
        TypedArray r13 = r10.obtainStyledAttributes(r11, nb.a.f9505s);
        i.e(r13, "context.obtainStyledAttr…R.styleable.OShadowFrame)");
        this.f13094x = new OUIFrameLayout(r10, null, 0, 14);
        this.f13089s = r13.getColor(0, getResources().getColor(R.color.oui_floating_button_bg_color_1, null));
        this.f13090t = r13.getColor(1, getResources().getColor(R.color.oui_floating_button_bg_color_1, null));
        int r8 = this.f13089s;
        if (r8 == 0) goto L9;
        OUIFrameLayout r14 = this.f13094x;
        if (r14 == null) goto L7;
        r14.setBackgroundColor(r8);
        goto L9
    L7:
        i.j("contentView");
        throw null;
    L9:
        this.f13092v = r13.getFloat(8, 1.0f);
        setChangeAlphaWhenPress(false);
        int r15 = r13.getDimensionPixelSize(4, 0);
        int r16 = r13.getDimensionPixelSize(5, 0);
        int r17 = r13.getDimensionPixelSize(6, 0);
        int r18 = r13.getDimensionPixelSize(3, 0);
        int r19 = r13.getDimensionPixelSize(9, 0);
        OUIFrameLayout r20 = this.f13094x;
        if (r20 == null) goto L42;
        r20.setPadding(r15, r17, r16, r18);
        OUIFrameLayout r110 = this.f13094x;
        if (r110 == null) goto L40;
        r110.setRadius(r19);
        int r111 = r13.getColor(7, 0);
        OUIFrameLayout r21 = this.f13094x;
        if (r21 == null) goto L38;
        r21.setOverridePressColor(r111);
        OUIFrameLayout r112 = this.f13094x;
        if (r112 == null) goto L36;
        r112.f6339n.g();
        OUIFrameLayout r113 = this.f13094x;
        if (r113 == null) goto L34;
        addView(r113, new FrameLayout.LayoutParams(-1, -1));
        setShadowCornerRadius(r19);
        OUIFrameLayout r114 = this.f13094x;
        if (r114 == null) goto L32;
        i(r10, r114, r13);
        OUIFrameLayout r115 = this.f13094x;
        if (r115 == null) goto L30;
        r115.setChangeAlphaWhenDisable(false);
        setChangeAlphaWhenDisable(false);
        int r116 = r13.getResourceId(10, 0);
        int r22 = r13.getResourceId(11, 0);
        if (r116 == 0) goto L26;
        ArrayList r117 = h.j(r10, r116);
        List<n> r118 = l6.a.l0(new n[]{(n) r117.get(0), (n) r117.get(1)});
        this.f13095y = r118;
        n r119 = (n) yd.i.h1(0, r118);
        List<n> r23 = this.f13095y;
        i.c(r23);
        a(r119, (n) yd.i.h1(1, r23));
    L26:
        if (r22 == 0) goto L28;
        ArrayList r120 = h.j(r10, r22);
        this.f13096z = l6.a.l0(new n[]{(n) r120.get(0), (n) r120.get(1)});
    L28:
        r13.recycle();
        setClipChildren(false);
        setClickable(true);
        j(isEnabled());
        return;
    L30:
        i.j("contentView");
        throw null;
    L32:
        i.j("contentView");
        throw null;
    L34:
        i.j("contentView");
        throw null;
    L36:
        i.j("contentView");
        throw null;
    L38:
        i.j("contentView");
        throw null;
    L40:
        i.j("contentView");
        throw null;
    L42:
        i.j("contentView");
        throw null;
    }

    public /* synthetic */ a(Context r8, AttributeSet r10, int r11, int r12) {
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = 0;
    L8:
        this(r8, r10, r11);
    }
}
