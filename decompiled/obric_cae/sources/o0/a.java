package o0;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import j0.h0;
import j0.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;
import k0.f;
import k0.g;
import n.i;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends j0.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Rect f9569n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final C0126a f9570o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f9571p = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f9572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f9573e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Rect f9574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f9575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AccessibilityManager f9576h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f9577i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c f9578j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f9579k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f9580l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f9581m;

    /* JADX INFO: renamed from: o0.a$a, reason: collision with other inner class name */
    public class C0126a implements o0.b.a<f> {
    }

    public class b {
    }

    public class c extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f9582b;

        public c(a r8) {
            this.f9582b = r8;
        }

        @Override // k0.g
        public final f a(int r8) {
            return new f(AccessibilityNodeInfo.obtain(this.f9582b.n(r8).f8890a));
        }

        @Override // k0.g
        public final f b(int r8) {
            a r10 = this.f9582b;
            if (r8 != 2) goto L5;
            int r11 = r10.f9579k;
        L7:
            if (r11 != Integer.MIN_VALUE) goto L11;
            return null;
        L11:
            return a(r11);
        L5:
            r11 = r10.f9580l;
            goto L7
        }

        @Override // k0.g
        public final boolean c(int r8, int r10, Bundle r11) {
            a r12 = this.f9582b;
            View r13 = r12.f9577i;
            if (r8 == (-1)) goto L42;
            boolean r14 = true;
            if (r10 == 1) goto L48;
            if (r10 == 2) goto L47;
            boolean r15 = false;
            if (r10 != 64) goto L11;
            AccessibilityManager r16 = r12.f9576h;
            if (r16.isEnabled() == true) goto L33;
        L28:
            r14 = false;
        L46:
            return r14;
        L33:
            if (r16.isTouchExplorationEnabled() == false) goto L28;
            int r17 = r12.f9579k;
            if (r17 == r8) goto L28;
            if (r17 == Integer.MIN_VALUE) goto L39;
            r12.f9579k = Integer.MIN_VALUE;
            r12.f9577i.invalidate();
            r12.q(r17, 65536);
        L39:
            r12.f9579k = r8;
            r13.invalidate();
            r12.q(r8, 32768);
            goto L46
        L11:
            if (r10 == 128) goto L26;
            Chip.b r18 = (Chip.b) r12;
            if (r10 != 16) goto L45;
            Chip r19 = r18.f4573q;
            if (r8 == 0) goto L44;
            if (r8 != 1) goto L45;
            r19.playSoundEffect(0);
            View.OnClickListener r20 = r19.f4563r;
            if (r20 == null) goto L22;
            r20.onClick(r19);
            r15 = true;
        L22:
            if (r19.C == false) goto L45;
            r19.B.q(1, 1);
            goto L45
        L44:
            return r19.performClick();
        L45:
            return r15;
        L26:
            if (r12.f9579k != r8) goto L28;
            r12.f9579k = Integer.MIN_VALUE;
            r13.invalidate();
            r12.q(r8, 65536);
            goto L46
        L47:
            return r12.j(r8);
        L48:
            return r12.p(r8);
        L42:
            WeakHashMap<View, h0> r21 = w.f8437a;
            return w.d.j(r13, r10, r11);
        }
    }

    static {
        f9569n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        f9570o = new C0126a();
        f9571p = new b();
    }

    public a(View r8) {
        this.f9572d = new Rect();
        this.f9573e = new Rect();
        this.f9574f = new Rect();
        this.f9575g = new int[2];
        this.f9579k = Integer.MIN_VALUE;
        this.f9580l = Integer.MIN_VALUE;
        this.f9581m = Integer.MIN_VALUE;
        if (r8 == null) goto L9;
        this.f9577i = r8;
        this.f9576h = (AccessibilityManager) r8.getContext().getSystemService("accessibility");
        r8.setFocusable(true);
        WeakHashMap<View, h0> r10 = w.f8437a;
        if (w.d.c(r8) != 0) goto L10;
        w.d.s(r8, 1);
        return;
    L10:
        return;
    L9:
        throw new IllegalArgumentException("View may not be null");
    }

    @Override // j0.a
    public final g b(View r8) {
        if (this.f9578j != null) goto L6;
        this.f9578j = new c(this);
    L6:
        return this.f9578j;
    }

    @Override // j0.a
    public final void c(View r8, AccessibilityEvent r10) {
        super.c(r8, r10);
    }

    @Override // j0.a
    public final void d(View r8, f r10) {
        View.AccessibilityDelegate r11 = this.f8370a;
        AccessibilityNodeInfo r12 = r10.f8890a;
        r11.onInitializeAccessibilityNodeInfo(r8, r12);
        Chip r13 = ((Chip.b) this).f4573q;
        com.google.android.material.chip.a r14 = r13.f4560o;
        if (r14 != null) goto L5;
    L7:
        boolean r15 = false;
    L8:
        r12.setCheckable(r15);
        r12.setClickable(r13.isClickable());
        r10.f(r13.getAccessibilityClassName());
        r10.k(r13.getText());
        return;
    L5:
        if (r14.f4575b0 == false) goto L7;
        r15 = true;
        goto L8
    }

    public final boolean j(int r8) {
        if (this.f9580l == r8) goto L5;
        return false;
    L5:
        this.f9580l = Integer.MIN_VALUE;
        Chip.b r10 = (Chip.b) this;
        if (r8 != 1) goto L8;
        Chip r11 = r10.f4573q;
        r11.f4568w = false;
        r11.refreshDrawableState();
    L8:
        q(r8, 8);
        return true;
    }

    public final f k(int r13) {
        AccessibilityNodeInfo r8 = AccessibilityNodeInfo.obtain();
        f r10 = new f(r8);
        r8.setEnabled(true);
        r8.setFocusable(true);
        r10.f("android.view.View");
        Rect r11 = f9569n;
        r8.setBoundsInParent(r11);
        r8.setBoundsInScreen(r11);
        r10.f8891b = -1;
        View r12 = this.f9577i;
        r8.setParent(r12);
        o(r13, r10);
        if (r10.e() == null) goto L5;
    L9:
        Rect r14 = this.f9573e;
        r10.d(r14);
        if (r14.equals(r11) == true) goto L65;
        int r15 = r8.getActions();
        if ((r15 & 64) != 0) goto L63;
        if ((r15 & 128) != 0) goto L61;
        r8.setPackageName(r12.getContext().getPackageName());
        r10.f8892c = r13;
        r8.setSource(r12, r13);
        boolean r16 = false;
        if (this.f9579k != r13) goto L18;
        r8.setAccessibilityFocused(true);
        r10.a(128);
    L20:
        if (this.f9580l != r13) goto L22;
        boolean r17 = true;
    L23:
        if (r17 == false) goto L26;
        r10.a(2);
    L28:
        r8.setFocused(r17);
        int[] r18 = this.f9575g;
        r12.getLocationOnScreen(r18);
        Rect r19 = this.f9572d;
        r8.getBoundsInScreen(r19);
        if (r19.equals(r11) == false) goto L38;
        r10.d(r19);
        if (r10.f8891b == (-1)) goto L37;
        f r110 = new f(AccessibilityNodeInfo.obtain());
        int r20 = r10.f8891b;
    L33:
        AccessibilityNodeInfo r111 = r110.f8890a;
        if (r20 == (-1)) goto L36;
        r110.f8891b = -1;
        r111.setParent(r12, -1);
        r111.setBoundsInParent(r11);
        o(r20, r110);
        r110.d(r14);
        r19.offset(r14.left, r14.top);
        r20 = r110.f8891b;
        goto L33
    L36:
        r111.recycle();
    L37:
        r19.offset(r18[0] - r12.getScrollX(), r18[1] - r12.getScrollY());
    L38:
        Rect r112 = this.f9574f;
        if (r12.getLocalVisibleRect(r112) == false) goto L59;
        r112.offset(r18[0] - r12.getScrollX(), r18[1] - r12.getScrollY());
        if (r19.intersect(r112) == false) goto L59;
        r10.f8890a.setBoundsInScreen(r19);
        if (r19.isEmpty() == false) goto L46;
    L57:
        if (r16 == false) goto L59;
        r8.setVisibleToUser(true);
        goto L59
    L46:
        if (r12.getWindowVisibility() != 0) goto L57;
    L48:
        Object r113 = r12.getParent();
        if ((r113 instanceof View) == false) goto L55;
        r12 = (View) r113;
        if (r12.getAlpha() <= 0.0f) goto L57;
        if (r12.getVisibility() == 0) goto L48;
    L55:
        if (r113 == null) goto L57;
        r16 = true;
    L59:
        return r10;
    L26:
        if (r8.isFocusable() == false) goto L28;
        r10.a(1);
        goto L28
    L22:
        r17 = false;
        goto L23
    L18:
        r8.setAccessibilityFocused(false);
        r10.a(64);
        goto L20
    L61:
        throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    L63:
        throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    L65:
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    L5:
        if (r8.getContentDescription() != null) goto L9;
        throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }

    public abstract void l(ArrayList r8);

    public final boolean m(int r19, Rect r20) {
        ArrayList r8 = new ArrayList();
        l(r8);
        i r10 = new i();
        int r11 = 0;
    L4:
        if (r11 >= r8.size()) goto L6;
        r10.d(((Integer) r8.get(r11)).intValue(), k(((Integer) r8.get(r11)).intValue()));
        r11 = r11 + 1;
        goto L4
    L6:
        int r12 = this.f9580l;
        int r13 = Integer.MIN_VALUE;
        if (r12 != Integer.MIN_VALUE) goto L9;
        f r14 = null;
    L10:
        C0126a r15 = f9570o;
        b r16 = f9571p;
        View r17 = this.f9577i;
        if (r19 == 1) goto L75;
        if (r19 == 2) goto L75;
        if (r19 == 17) goto L21;
        if (r19 == 33) goto L21;
        if (r19 == 66) goto L21;
        if (r19 == 130) goto L21;
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L21:
        Rect r18 = new Rect();
        int r21 = this.f9580l;
        if (r21 == Integer.MIN_VALUE) goto L24;
        n(r21).d(r18);
    L37:
        Rect r22 = new Rect(r18);
        if (r19 == 17) goto L48;
        if (r19 == 33) goto L46;
        if (r19 == 66) goto L45;
        if (r19 != 130) goto L44;
        int r23 = -(r18.height() + 1);
    L47:
        int r24 = 0;
        r22.offset(0, r23);
    L50:
        r16.getClass();
        int r25 = r10.f9405m;
        Rect r26 = new Rect();
        int r110 = r24;
        f r111 = null;
    L51:
        if (r110 >= r25) goto L74;
        f r112 = (f) r10.f9404b[r110];
        if (r112 == r14) goto L73;
        r15.getClass();
        r112.d(r26);
        if (o0.b.c(r19, r18, r26) == true) goto L59;
    L70:
        int r113 = r24;
    L71:
        if (r113 == 0) goto L73;
        r22.set(r26);
        r111 = r112;
        goto L73
    L59:
        if (o0.b.c(r19, r18, r22) == true) goto L62;
    L69:
        r113 = 1;
        goto L71
    L62:
        if (o0.b.a(r19, r18, r26, r22) == true) goto L69;
        if (o0.b.a(r19, r18, r22, r26) == true) goto L70;
        int r114 = o0.b.d(r19, r18, r26);
        int r115 = o0.b.e(r19, r18, r26);
        int r116 = (r115 * r115) + ((r114 * 13) * r114);
        int r117 = o0.b.d(r19, r18, r22);
        int r118 = o0.b.e(r19, r18, r22);
        if (r116 >= ((r118 * r118) + ((r117 * 13) * r117))) goto L70;
    L73:
        r110 = r110 + 1;
        goto L51
    L74:
        f r27 = r111;
        int r28 = -1;
    L105:
        if (r27 == null) goto L117;
        int r29 = r24;
    L109:
        if (r29 >= r10.f9405m) goto L114;
        if (r10.f9404b[r29] == r27) goto L112;
        r29 = r29 + 1;
        goto L109
    L112:
        int r30 = r29;
    L115:
        r13 = r10.f9403a[r30];
        goto L117
    L114:
        r30 = r28;
    L117:
        return p(r13);
    L44:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L45:
        int r31 = -(r18.width() + 1);
        r24 = 0;
    L49:
        r22.offset(r31, r24);
        goto L50
    L46:
        r23 = r18.height() + 1;
        goto L47
    L48:
        r24 = 0;
        r31 = r18.width() + 1;
        goto L49
    L24:
        if (r20 == null) goto L26;
        r18.set(r20);
        goto L37
    L26:
        int r32 = r17.getWidth();
        int r33 = r17.getHeight();
        if (r19 == 17) goto L36;
        if (r19 == 33) goto L35;
        if (r19 == 66) goto L34;
        if (r19 != 130) goto L33;
        r18.set(0, -1, r32, -1);
        goto L37
    L33:
        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
    L34:
        r18.set(-1, 0, -1, r33);
        goto L37
    L35:
        r18.set(0, r33, r32, r33);
        goto L37
    L36:
        r18.set(r32, 0, r32, r33);
    L75:
        r24 = 0;
        WeakHashMap<View, h0> r34 = w.f8437a;
        if (w.e.d(r17) != 1) goto L78;
        boolean r35 = true;
    L79:
        r16.getClass();
        int r36 = r10.f9405m;
        ArrayList r37 = new ArrayList(r36);
        int r38 = 0;
    L80:
        if (r38 >= r36) goto L82;
        r37.add((f) r10.f9404b[r38]);
        r38 = r38 + 1;
        goto L80
    L82:
        Collections.sort(r37, new o0.b.C0127b(r35, r15));
        if (r19 == 1) goto L96;
        if (r19 != 2) goto L95;
        int r39 = r37.size();
        if (r14 != null) goto L88;
        int r119 = -1;
    L89:
        int r120 = r119 + 1;
        if (r120 >= r39) goto L92;
        Object r40 = r37.get(r120);
    L93:
        r28 = -1;
    L104:
        r27 = (f) r40;
        goto L105
    L92:
        r40 = null;
        goto L93
    L88:
        r119 = r37.lastIndexOf(r14);
        goto L89
    L95:
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    L96:
        int r41 = r37.size();
        if (r14 == null) goto L100;
        r41 = r37.indexOf(r14);
    L100:
        r28 = -1;
        int r42 = r41 - 1;
        if (r42 < 0) goto L103;
        r40 = r37.get(r42);
        goto L104
    L103:
        r40 = null;
        goto L104
    L78:
        r35 = false;
        goto L79
    L9:
        r14 = (f) r10.c(r12, null);
        goto L10
    }

    public final f n(int r8) {
        if (r8 != (-1)) goto L16;
        View r10 = this.f9577i;
        AccessibilityNodeInfo r11 = AccessibilityNodeInfo.obtain(r10);
        f r12 = new f(r11);
        WeakHashMap<View, h0> r13 = w.f8437a;
        r10.onInitializeAccessibilityNodeInfo(r11);
        ArrayList r14 = new ArrayList();
        l(r14);
        if (r11.getChildCount() > 0) goto L7;
    L11:
        int r15 = r14.size();
        int r16 = 0;
    L12:
        if (r16 >= r15) goto L14;
        int r17 = ((Integer) r14.get(r16)).intValue();
        r12.f8890a.addChild(r10, r17);
        r16 = r16 + 1;
        goto L12
    L14:
        return r12;
    L7:
        if (r14.size() <= 0) goto L11;
        throw new RuntimeException("Views cannot have both real and virtual children");
    L16:
        return k(r8);
    }

    public abstract void o(int r8, f r10);

    public final boolean p(int r8) {
        View r10 = this.f9577i;
        if (r10.isFocused() == false) goto L5;
    L7:
        int r11 = this.f9580l;
        if (r11 != r8) goto L11;
        return false;
    L11:
        if (r11 == Integer.MIN_VALUE) goto L13;
        j(r11);
    L13:
        if (r8 != Integer.MIN_VALUE) goto L15;
        return false;
    L15:
        this.f9580l = r8;
        Chip.b r12 = (Chip.b) this;
        if (r8 != 1) goto L18;
        Chip r13 = r12.f4573q;
        r13.f4568w = true;
        r13.refreshDrawableState();
    L18:
        q(r8, 8);
        return true;
    L5:
        if (r10.requestFocus() == true) goto L7;
        return false;
    }

    public final void q(int r8, int r10) {
        if (r8 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        if (this.f9576h.isEnabled() == false) goto L24;
        View r11 = this.f9577i;
        ViewParent r12 = r11.getParent();
        if (r12 != null) goto L11;
        return;
    L11:
        if (r8 == (-1)) goto L20;
        AccessibilityEvent r13 = AccessibilityEvent.obtain(r10);
        f r14 = n(r8);
        r13.getText().add(r14.e());
        AccessibilityNodeInfo r15 = r14.f8890a;
        r13.setContentDescription(r15.getContentDescription());
        r13.setScrollable(r15.isScrollable());
        r13.setPassword(r15.isPassword());
        r13.setEnabled(r15.isEnabled());
        r13.setChecked(r15.isChecked());
        if (r13.getText().isEmpty() == true) goto L15;
    L19:
        r13.setClassName(r15.getClassName());
        k0.i.a(r13, r11, r8);
        r13.setPackageName(r11.getContext().getPackageName());
    L21:
        r12.requestSendAccessibilityEvent(r11, r13);
        return;
    L15:
        if (r13.getContentDescription() != null) goto L19;
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    L20:
        r13 = AccessibilityEvent.obtain(r10);
        r11.onInitializeAccessibilityEvent(r13);
        goto L21
    }
}
