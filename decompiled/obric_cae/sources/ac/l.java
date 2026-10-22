package ac;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.obric.cae.R;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f328c;

    static {
        new zb.a();
    }

    public l(Context r8, AttributeSet r10, int r11, int r12) {
        he.i.f(r8, "context");
        this.f326a = new h(r8, r10, r11, r12);
        this.f327b = new e(r8, r10, r11, r12);
    }

    public final f a() {
        f r8 = this.f328c;
        if (r8 == null) goto L5;
        return r8;
    L5:
        he.i.j("mOUIEffectHelper");
        throw null;
    }

    public final void b(View r21) {
        he.i.f(r21, "owner");
        h r8 = this.f326a;
        r8.getClass();
        r8.X = new WeakReference(r21);
        Object r10 = androidx.core.content.a.f1674a;
        Context r11 = r8.f290a;
        int r12 = androidx.core.content.a.c.a(r11, R.color.oui_line_2);
        r8.f312s = r12;
        r8.f317x = r12;
        int r13 = androidx.core.content.a.c.a(r11, R.color.oui_line_2);
        r8.H = r13;
        r8.C = r13;
        new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        Paint r14 = new Paint();
        r8.L = r14;
        r14.setAntiAlias(true);
        Resources.Theme r15 = r11.getTheme();
        if (i.f320a != null) goto L6;
        i.f320a = new TypedValue();
    L6:
        if (r15.resolveAttribute(R.attr.oui_general_shadow_alpha, i.f320a, true) == true) goto L8;
        float r16 = -1.0f;
    L10:
        if (r16 <= 0.0f) goto L12;
        r8.f294c0 = r16;
    L12:
        r8.T = new RectF();
        boolean r17 = r8.f302l0;
        int r18 = r8.f301k0;
        int r19 = r8.f300j0;
        AttributeSet r20 = r8.f299i0;
        int r110 = 0;
        if (r17 == true) goto L19;
        if (r20 != null) goto L19;
        if (r19 != 0) goto L19;
        if (r18 != 0) goto L19;
        int r22 = 0;
        int r23 = 0;
        boolean r111 = false;
    L140:
        if (r23 != 0) goto L150;
        if (r111 == false) goto L150;
        if (i.f320a != null) goto L146;
        i.f320a = new TypedValue();
    L146:
        if (r11.getTheme().resolveAttribute(R.attr.oui_general_shadow_elevation, i.f320a, true) == false) goto L149;
        r110 = TypedValue.complexToDimensionPixelSize(i.f320a.data, r11.getResources().getDisplayMetrics());
    L149:
        r23 = r110;
    L150:
        r8.y(r8.f294c0, r22, r23);
        e r24 = this.f327b;
        r24.getClass();
        r24.f258a = new WeakReference(r21);
        r24.b(r21);
        this.f328c = new f(r21);
        return;
    L19:
        TypedArray r25 = r11.obtainStyledAttributes(r20, nb.a.f9509w, r19, r18);
        int r26 = r25.getIndexCount();
        int r27 = 0;
        r23 = 0;
        r111 = false;
        int r112 = 0;
    L20:
        if (r27 >= r26) goto L135;
        int r113 = r25.getIndex(r27);
        if (r113 != 0) goto L24;
        r8.f292b = r25.getDimensionPixelSize(r113, r8.f292b);
    L126:
        if (r113 != 8) goto L129;
        r8.Q = r25.getDimensionPixelSize(r113, 0);
    L129:
        if (r113 != 9) goto L132;
        r8.R = r25.getDimensionPixelSize(r113, 0);
    L132:
        if (r113 != 48) goto L134;
        r8.P = r25.getDimensionPixelSize(r113, 0);
    L134:
        r27 = r27 + 1;
        goto L20
    L24:
        if (r113 != 1) goto L27;
        r8.f303m = r25.getDimensionPixelSize(r113, r8.f303m);
        goto L126
    L27:
        if (r113 != 2) goto L30;
        r8.f305n = r25.getDimensionPixelSize(r113, r8.f305n);
        goto L126
    L30:
        if (r113 != 3) goto L33;
        r8.f307o = r25.getDimensionPixelSize(r113, r8.f307o);
        goto L126
    L33:
        if (r113 != 43) goto L36;
        r8.f312s = r25.getColor(r113, r8.f312s);
        goto L126
    L36:
        if (r113 != 44) goto L39;
        r8.f309p = r25.getDimensionPixelSize(r113, r8.f309p);
        goto L126
    L39:
        if (r113 != 45) goto L42;
        r8.f310q = r25.getDimensionPixelSize(r113, r8.f310q);
        goto L126
    L42:
        if (r113 != 46) goto L45;
        r8.f311r = r25.getDimensionPixelSize(r113, r8.f311r);
        goto L126
    L45:
        if (r113 != 4) goto L48;
        r8.f317x = r25.getColor(r113, r8.f317x);
        goto L126
    L48:
        if (r113 != 5) goto L51;
        r8.f314u = r25.getDimensionPixelSize(r113, r8.f314u);
        goto L126
    L51:
        if (r113 != 6) goto L54;
        r8.f315v = r25.getDimensionPixelSize(r113, r8.f315v);
        goto L126
    L54:
        if (r113 != 7) goto L57;
        r8.f316w = r25.getDimensionPixelSize(r113, r8.f316w);
        goto L126
    L57:
        if (r113 != 17) goto L60;
        r8.C = r25.getColor(r113, r8.C);
        goto L126
    L60:
        if (r113 != 20) goto L63;
        r8.f319z = r25.getDimensionPixelSize(r113, r8.f319z);
        goto L126
    L63:
        if (r113 != 19) goto L66;
        r8.A = r25.getDimensionPixelSize(r113, r8.A);
        goto L126
    L66:
        if (r113 != 18) goto L69;
        r8.B = r25.getDimensionPixelSize(r113, r8.B);
        goto L126
    L69:
        if (r113 != 28) goto L72;
        r8.H = r25.getColor(r113, r8.H);
        goto L126
    L72:
        if (r113 != 31) goto L75;
        r8.E = r25.getDimensionPixelSize(r113, r8.E);
        goto L126
    L75:
        if (r113 != 30) goto L78;
        r8.F = r25.getDimensionPixelSize(r113, r8.F);
        goto L126
    L78:
        if (r113 != 29) goto L81;
        r8.G = r25.getDimensionPixelSize(r113, r8.G);
        goto L126
    L81:
        if (r113 != 15) goto L84;
        r8.U = r25.getColor(r113, r8.U);
        goto L126
    L84:
        if (r113 != 16) goto L87;
        r8.V = r25.getDimensionPixelSize(r113, r8.V);
        goto L126
    L87:
        if (r113 != 27) goto L90;
        r112 = r25.getDimensionPixelSize(r113, 0);
        goto L126
    L90:
        if (r113 != 21) goto L93;
        r8.W = r25.getColor(r113, r8.W);
        goto L126
    L93:
        if (r113 != 41) goto L96;
        r8.f291a0 = r25.getBoolean(r113, r8.f291a0);
        goto L126
    L96:
        if (r113 != 39) goto L99;
        r23 = r25.getDimensionPixelSize(r113, r23);
        goto L126
    L99:
        if (r113 != 37) goto L102;
        r8.f294c0 = r25.getFloat(r113, r8.f294c0);
        goto L126
    L102:
        if (r113 != 49) goto L105;
        r111 = r25.getBoolean(r113, false);
        goto L126
    L105:
        if (r113 != 24) goto L108;
        r8.f295e0 = r25.getDimensionPixelSize(r113, 0);
        goto L126
    L108:
        if (r113 != 25) goto L111;
        r8.f296f0 = r25.getDimensionPixelSize(r113, 0);
        goto L126
    L111:
        if (r113 != 26) goto L114;
        r8.f297g0 = r25.getDimensionPixelSize(r113, 0);
        goto L126
    L114:
        if (r113 != 23) goto L117;
        r8.f298h0 = r25.getDimensionPixelSize(r113, 0);
        goto L126
    L117:
        if (r113 != 22) goto L120;
        r8.Y = r25.getBoolean(r113, false);
        goto L126
    L120:
        if (r113 != 42) goto L123;
        r25.getBoolean(r113, false);
        goto L126
    L123:
        if (r113 != 47) goto L126;
        r8.O = r25.getDimensionPixelSize(r113, 0);
        goto L126
    L135:
        int r28 = r25.getResourceId(40, 0);
        if (r28 == 0) goto L138;
        r8.a(r11, r28);
    L139:
        r8.f308o0 = r25.getDimension(38, 0.0f);
        r25.recycle();
        r22 = r112;
        goto L140
    L138:
        h.p(r25, r8.f304m0, 13, 12, 10, 11, 14);
        h.p(r25, r8.f306n0, 35, 34, 32, 33, 36);
        goto L139
    L8:
        r16 = i.f320a.getFloat();
        goto L10
    }
}
