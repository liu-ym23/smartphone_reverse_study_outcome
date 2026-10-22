package androidx.appcompat.app;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.b1;
import com.obric.cae.R;
import j0.h0;
import j0.m0;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class i implements j0.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppCompatDelegateImpl f657a;

    public i(AppCompatDelegateImpl r8) {
        this.f657a = r8;
    }

    @Override // j0.q
    public final m0 a(View r16, m0 r17) {
        int r8 = r17.e();
        AppCompatDelegateImpl r10 = this.f657a;
        r10.getClass();
        int r11 = r17.e();
        ActionBarContextView r12 = r10.F;
        int r13 = 0;
        if (r12 != null) goto L5;
    L73:
        boolean r14 = false;
    L74:
        View r15 = r10.N;
        if (r15 == null) goto L80;
        if (r14 == true) goto L79;
        r13 = 8;
    L79:
        r15.setVisibility(r13);
    L80:
        if (r8 == r11) goto L82;
        int r18 = r17.c();
        int r19 = r17.d();
        int r20 = r17.b();
        m0.b r21 = new m0.b(r17);
        r21.f8414a.d(a0.b.b(r18, r11, r19, r20));
        m0 r22 = r21.a();
    L84:
        return j0.w.j(r16, r22);
    L82:
        r22 = r17;
        goto L84
    L5:
        if ((r12.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) == false) goto L73;
        ViewGroup.MarginLayoutParams r23 = (ViewGroup.MarginLayoutParams) r10.F.getLayoutParams();
        boolean r24 = true;
        if (r10.F.isShown() == false) goto L68;
        if (r10.f589n0 != null) goto L11;
        r10.f589n0 = new Rect();
        r10.f590o0 = new Rect();
    L11:
        Rect r25 = r10.f589n0;
        Rect r26 = r10.f590o0;
        r25.set(r17.c(), r17.e(), r17.d(), r17.b());
        ViewGroup r27 = r10.L;
        Method r110 = b1.f1104a;
        if (r110 != null) goto L85;
    L17:
        int r28 = r25.top;
        int r29 = r25.left;
        int r30 = r25.right;
        ViewGroup r111 = r10.L;
        WeakHashMap<View, h0> r112 = j0.w.f8437a;
        m0 r113 = j0.w.j.a(r111);
        if (r113 != null) goto L20;
        int r114 = 0;
    L21:
        if (r113 != null) goto L23;
        int r115 = 0;
    L25:
        if (r23.topMargin == r28) goto L27;
    L32:
        r23.topMargin = r28;
        r23.leftMargin = r29;
        r23.rightMargin = r30;
        boolean r31 = true;
    L33:
        Context r32 = r10.f595u;
        if (r28 > 0) goto L36;
    L38:
        View r33 = r10.N;
        if (r33 == null) goto L47;
        ViewGroup.MarginLayoutParams r34 = (ViewGroup.MarginLayoutParams) r33.getLayoutParams();
        int r116 = r34.height;
        int r117 = r23.topMargin;
        if (r116 == r117) goto L43;
    L46:
        r34.height = r117;
        r34.leftMargin = r114;
        r34.rightMargin = r115;
        r10.N.setLayoutParams(r34);
        goto L47
    L43:
        if (r34.leftMargin != r114) goto L46;
        if (r34.rightMargin != r115) goto L46;
    L47:
        View r35 = r10.N;
        if (r35 == null) goto L50;
        r14 = true;
    L51:
        if (r14 == false) goto L63;
        if (r35.getVisibility() == 0) goto L63;
        View r36 = r10.N;
        if ((j0.w.d.g(r36) & 8192) != 0) goto L58;
        r24 = false;
    L58:
        if (r24 == false) goto L60;
        Object r37 = androidx.core.content.a.f1674a;
        int r38 = R.color.abc_decor_view_status_guard_light;
    L61:
        r36.setBackgroundColor(androidx.core.content.a.c.a(r32, r38));
        goto L63
    L60:
        Object r39 = androidx.core.content.a.f1674a;
        r38 = R.color.abc_decor_view_status_guard;
    L63:
        if (r10.S == true) goto L66;
        if (r14 == false) goto L66;
        r11 = 0;
    L66:
        r24 = r31;
    L71:
        if (r24 == false) goto L74;
        r10.F.setLayoutParams(r23);
        goto L74
    L50:
        r14 = false;
        goto L51
    L36:
        if (r10.N != null) goto L38;
        View r40 = new View(r32);
        r10.N = r40;
        r40.setVisibility(8);
        FrameLayout.LayoutParams r41 = new FrameLayout.LayoutParams(-1, r23.topMargin, 51);
        r41.leftMargin = r114;
        r41.rightMargin = r115;
        r10.L.addView(r10.N, -1, r41);
        goto L47
    L27:
        if (r23.leftMargin != r29) goto L32;
        if (r23.rightMargin != r30) goto L32;
        r31 = false;
        goto L33
    L23:
        r115 = r113.d();
        goto L25
    L20:
        r114 = r113.c();
        goto L21
    L85:
        r110.invoke(r27, new Object[]{r25, r26});     // Catch: Exception -> L15
    L15:
        e = move-exception;
        Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
        goto L17
    L68:
        if (r23.topMargin == 0) goto L70;
        r23.topMargin = 0;
        r14 = false;
        goto L71
    L70:
        r24 = false;
        r14 = false;
        goto L71
    }
}
