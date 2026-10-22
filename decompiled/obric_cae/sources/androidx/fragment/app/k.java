package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.transition.Transition;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class k extends i0 {

    public static class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f2001c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f2002d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public n.a f2003e;

        public a(i0.d r8, f0.d r10, boolean r11) {
            super(r8, r10);
            this.f2002d = false;
            this.f2001c = r11;
        }

        public final n.a c(Context r8) {
            if (this.f2002d == true) goto L5;
            i0.d r10 = this.f2004a;
            Fragment r11 = r10.f1985c;
            if (r10.f1983a != i0.d.c.f1996b) goto L9;
            boolean r12 = true;
        L10:
            n.a r13 = n.a(r8, r11, r12, this.f2001c);
            this.f2003e = r13;
            this.f2002d = true;
            return r13;
        L9:
            r12 = false;
            goto L10
        L5:
            return this.f2003e;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i0.d f2004a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f0.d f2005b;

        public b(i0.d r8, f0.d r10) {
            this.f2004a = r8;
            this.f2005b = r10;
        }

        public final void a() {
            i0.d r8 = this.f2004a;
            HashSet<f0.d> r10 = r8.f1987e;
            if (r10.remove(this.f2005b) == true) goto L5;
            return;
        L5:
            if (r10.isEmpty() == false) goto L9;
            r8.b();
            return;
        }

        public final boolean b() {
            i0.d r8 = this.f2004a;
            i0.d.c r10 = i0.d.c.c(r8.f1985c.mView);
            i0.d.c r11 = r8.f1983a;
            if (r10 == r11) goto L9;
            i0.d.c r12 = i0.d.c.f1996b;
            if (r10 == r12) goto L8;
            if (r11 != r12) goto L9;
        L8:
            return false;
        L9:
            return true;
        }
    }

    public static class c extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f2006c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f2007d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Object f2008e;

        public c(i0.d r8, f0.d r10, boolean r11, boolean r12) {
            super(r8, r10);
            i0.d.c r13 = r8.f1983a;
            i0.d.c r14 = i0.d.c.f1996b;
            Fragment r15 = r8.f1985c;
            if (r13 != r14) goto L11;
            if (r11 == false) goto L6;
            Object r16 = r15.getReenterTransition();
        L7:
            this.f2006c = r16;
            if (r11 == false) goto L10;
            boolean r17 = r15.getAllowReturnTransitionOverlap();
        L15:
            this.f2007d = r17;
            if (r12 == false) goto L20;
            if (r11 == false) goto L19;
            Object r18 = r15.getSharedElementReturnTransition();
        L21:
            this.f2008e = r18;
            return;
        L19:
            r18 = r15.getSharedElementEnterTransition();
            goto L21
        L20:
            r18 = null;
            goto L21
        L10:
            r17 = r15.getAllowEnterTransitionOverlap();
            goto L15
        L6:
            r16 = r15.getEnterTransition();
            goto L7
        L11:
            if (r11 == false) goto L13;
            Object r19 = r15.getReturnTransition();
        L14:
            this.f2006c = r19;
            r17 = true;
            goto L15
        L13:
            r19 = r15.getExitTransition();
            goto L14
        }

        public final f0 c(Object r8) {
            if (r8 != null) goto L5;
            return null;
        L5:
            c0 r10 = a0.f1926a;
            if (r10 != null) goto L8;
        L10:
            f0 r11 = a0.f1927b;
            if (r11 == null) goto L16;
            if (r11.e(r8) == false) goto L16;
            return r11;
        L16:
            throw new IllegalArgumentException("Transition " + r8 + " for fragment " + this.f2004a.f1985c + " is not a valid framework Transition or AndroidX Transition");
        L8:
            if ((r8 instanceof Transition) == false) goto L10;
            return r10;
        }
    }

    public static void j(ArrayList r8, View r10) {
        if ((r10 instanceof ViewGroup) == false) goto L16;
        ViewGroup r11 = (ViewGroup) r10;
        if (j0.a0.b(r11) == true) goto L7;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L25;
        View r14 = r11.getChildAt(r13);
        if (r14.getVisibility() != 0) goto L14;
        j(r8, r14);
    L14:
        r13 = r13 + 1;
        goto L10
    L25:
        return;
    L7:
        if (r8.contains(r10) == true) goto L22;
        r8.add(r11);
        return;
    L22:
        return;
    L16:
        if (r8.contains(r10) == true) goto L24;
        r8.add(r10);
        return;
    }

    public static void k(n.b r8, View r10) {
        WeakHashMap<View, j0.h0> r11 = j0.w.f8437a;
        String r12 = j0.w.i.k(r10);
        if (r12 == null) goto L6;
        r8.put(r12, r10);
    L6:
        if ((r10 instanceof ViewGroup) == false) goto L13;
        ViewGroup r13 = (ViewGroup) r10;
        int r14 = r13.getChildCount();
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L17;
        View r16 = r13.getChildAt(r15);
        if (r16.getVisibility() != 0) goto L12;
        k(r8, r16);
    L12:
        r15 = r15 + 1;
        goto L8
    L17:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void l(n.b r8, Collection r10) {
        Iterator r11 = ((n.g.b) r8.entrySet()).iterator();
    L3:
        n.g.d r12 = (n.g.d) r11;
        if (r12.hasNext() == false) goto L8;
        r12.next();
        View r13 = (View) r12.getValue();
        WeakHashMap<View, j0.h0> r14 = j0.w.f8437a;
        if (r10.contains(j0.w.i.k(r13)) == true) goto L3;
        r12.remove();
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.i0
    public final void b(ArrayList r34, boolean r35) {
        Iterator r8 = r34.iterator();
        i0.d r10 = null;
        i0.d r11 = null;
    L4:
        if (r8.hasNext() == false) goto L19;
        i0.d r12 = (i0.d) r8.next();
        i0.d.c r13 = i0.d.c.c(r12.f1985c.mView);
        int r14 = r12.f1983a.ordinal();
        if (r14 == 0) goto L16;
        if (r14 != 1) goto L8;
        if (r13 == i0.d.c.f1996b) goto L4;
        r11 = r12;
        goto L4
    L8:
        if (r14 == 2) goto L16;
        if (r14 != 3) goto L4;
    L16:
        if (r13 != i0.d.c.f1996b) goto L4;
        if (r10 != null) goto L4;
        r10 = r12;
        goto L4
    L19:
        ArrayList r15 = new ArrayList();
        ArrayList r16 = new ArrayList();
        ArrayList r17 = new ArrayList(r34);
        Iterator r18 = r34.iterator();
    L21:
        if (r18.hasNext() == false) goto L30;
        i0.d r19 = (i0.d) r18.next();
        f0.d r110 = new f0.d();
        r19.d();
        r19.f1987e.add(r110);
        r15.add(new a(r19, r110, r35));
        f0.d r111 = new f0.d();
        r19.d();
        r19.f1987e.add(r111);
        if (r35 == false) goto L26;
        if (r19 == r10) goto L27;
    L28:
        boolean r112 = false;
    L29:
        r16.add(new c(r19, r111, r35, r112));
        r19.f1986d.add(new androidx.fragment.app.b(this, r17, r19));
    L27:
        r112 = true;
        goto L29
    L26:
        if (r19 != r11) goto L28;
    L30:
        HashMap r113 = new HashMap();
        Iterator r114 = r16.iterator();
        f0 r115 = null;
    L32:
        if (r114.hasNext() == false) goto L54;
        c r116 = (c) r114.next();
        if (r116.b() == false) goto L36;
        Iterator r117 = r114;
    L53:
        r114 = r117;
        goto L32
    L36:
        Object r118 = r116.f2006c;
        f0 r20 = r116.c(r118);
        Object r21 = r116.f2008e;
        f0 r22 = r116.c(r21);
        r117 = r114;
        i0.d r119 = r116.f2004a;
        if (r20 == null) goto L43;
        if (r22 == null) goto L43;
        if (r20 == r22) goto L43;
        throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + r119.f1985c + " returned Transition " + r118 + " which uses a different Transition  type than its shared element transition " + r21);
    L43:
        if (r20 != null) goto L46;
        r20 = r22;
    L46:
        if (r115 != null) goto L48;
        r115 = r20;
        goto L53
    L48:
        if (r20 == null) goto L53;
        if (r115 == r20) goto L53;
        throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + r119.f1985c + " returned Transition " + r118 + " which uses a different Transition  type than other Fragments.");
    L54:
        ViewGroup r23 = this.f1973a;
        if (r115 != null) goto L61;
        Iterator r24 = r16.iterator();
    L58:
        if (r24.hasNext() == false) goto L60;
        c r25 = (c) r24.next();
        r113.put(r25.f2004a, Boolean.FALSE);
        r25.a();
        goto L58
    L60:
        ArrayList r26 = r15;
        ArrayList r29 = r17;
        HashMap r120 = r113;
        String r27 = "FragmentManager";
    L176:
        boolean r28 = false;
    L178:
        boolean r30 = r120.containsValue(Boolean.TRUE);
        Context r31 = r23.getContext();
        ArrayList r32 = new ArrayList();
        Iterator r33 = r26.iterator();
        boolean r36 = r28;
    L180:
        if (r33.hasNext() == false) goto L204;
        a r37 = (a) r33.next();
        if (r37.b() == true) goto L195;
        n.a r38 = r37.c(r31);
        if (r38 == null) goto L195;
        Animator r39 = r38.f2034b;
        if (r39 == null) goto L189;
        i0.d r121 = r37.f2004a;
        Fragment r122 = r121.f1985c;
        if (Boolean.TRUE.equals(r120.get(r121)) == true) goto L193;
        if (r121.f1983a != i0.d.c.f1997m) goto L199;
        boolean r210 = true;
    L200:
        ArrayList r123 = r29;
        if (r210 == false) goto L203;
        r123.remove(r121);
    L203:
        View r40 = r122.mView;
        r23.startViewTransition(r40);
        r39.addListener(new androidx.fragment.app.c(r23, r40, r210, r121, r37));
        r39.setTarget(r40);
        r39.start();
        r37.f2005b.b(new d(r39));
        r29 = r123;
        r36 = true;
        goto L180
    L199:
        r210 = r28;
        goto L200
    L193:
        if (FragmentManager.G(2) == false) goto L195;
        Log.v(r27, "Ignoring Animator set on " + r122 + " as this Fragment was involved in a Transition.");
        goto L195
    L189:
        r32.add(r37);
    L195:
        r37.a();
        goto L180
    L204:
        ArrayList r124 = r29;
        Iterator r41 = r32.iterator();
    L206:
        if (r41.hasNext() == false) goto L224;
        a r42 = (a) r41.next();
        i0.d r43 = r42.f2004a;
        Fragment r44 = r43.f1985c;
        if (r30 == true) goto L210;
        if (r36 == true) goto L215;
        View r45 = r44.mView;
        n.a r46 = r42.c(r31);
        r46.getClass();
        Animation r47 = r46.f2033a;
        r47.getClass();
        if (r43.f1983a == i0.d.c.f1995a) goto L222;
        r45.startAnimation(r47);
        r42.a();
    L223:
        r42.f2005b.b(new f(r45, r23, r42));
        goto L206
    L222:
        r23.startViewTransition(r45);
        n.b r48 = new n.b(r47, r23, r45);
        r48.setAnimationListener(new e(r45, r23, r42));
        r45.startAnimation(r48);
        goto L223
    L215:
        if (FragmentManager.G(2) == false) goto L218;
        StringBuilder r49 = new StringBuilder("Ignoring Animation set on ");
        r49.append(r44);
        String r50 = " as Animations cannot run alongside Animators.";
    L217:
        r49.append(r50);
        Log.v(r27, r49.toString());
    L218:
        r42.a();
        goto L206
    L210:
        if (FragmentManager.G(2) == false) goto L218;
        r49 = new StringBuilder("Ignoring Animation set on ");
        r49.append(r44);
        r50 = " as Animations cannot run alongside Transitions.";
        goto L217
    L224:
        Iterator r51 = r124.iterator();
    L226:
        if (r51.hasNext() == false) goto L228;
        i0.d r52 = (i0.d) r51.next();
        r52.f1983a.a(r52.f1985c.mView);
        goto L226
    L228:
        r124.clear();
        return;
    L61:
        View r53 = new View(r23.getContext());
        Rect r125 = new Rect();
        ArrayList<View> r126 = new ArrayList();
        ArrayList<View> r127 = new ArrayList();
        n.b r128 = new n.b();
        Iterator r211 = r16.iterator();
        k r212 = this;
        r26 = r15;
        String r213 = "FragmentManager";
        i0.d r54 = r10;
        i0.d r55 = r11;
        Object r56 = null;
        View r214 = null;
        boolean r215 = false;
    L63:
        if (r211.hasNext() == false) goto L107;
        ArrayList r216 = r17;
        Object r57 = ((c) r211.next()).f2008e;
        if (r57 == null) goto L67;
        boolean r129 = true;
    L68:
        if (r129 == false) goto L105;
        if (r54 == null) goto L105;
        if (r55 == null) goto L105;
        Object r58 = r115.t(r115.f(r57));
        Fragment r59 = r55.f1985c;
        ArrayList<String> r60 = r59.getSharedElementSourceNames();
        Fragment r61 = r54.f1985c;
        ArrayList r217 = r16;
        ArrayList<String> r62 = r61.getSharedElementSourceNames();
        HashMap r310 = r113;
        ArrayList<String> r130 = r61.getSharedElementTargetNames();
        View r63 = r53;
        Rect r311 = r125;
        int r64 = 0;
    L72:
        Object r312 = r58;
        if (r64 >= r130.size()) goto L78;
        int r131 = r60.indexOf(r130.get(r64));
        if (r131 == (-1)) goto L77;
        r60.set(r131, r62.get(r64));
    L77:
        r64 = r64 + 1;
        r58 = r312;
        goto L72
    L78:
        ArrayList<String> r65 = r59.getSharedElementTargetNames();
        if (r35 == true) goto L81;
        r61.getExitTransitionCallback();
        r59.getEnterTransitionCallback();
    L82:
        int r66 = r60.size();
        int r132 = 0;
    L83:
        if (r132 >= r66) goto L85;
        r128.put(r60.get(r132), r65.get(r132));
        r132 = r132 + 1;
        goto L83
    L85:
        n.b r67 = new n.b();
        k(r67, r61.mView);
        n.g.k(r67, r60);
        n.g.k(r128, r67.keySet());
        n.b r68 = new n.b();
        k(r68, r59.mView);
        n.g.k(r68, r65);
        n.g.k(r68, r128.values());
        c0 r133 = a0.f1926a;
        int r134 = r128.f9401m;
    L86:
        r134 = r134 - 1;
        if (r134 < 0) goto L91;
        if (r68.containsKey((String) r128.k(r134)) == true) goto L86;
        r128.j(r134);
        goto L86
    L91:
        l(r67, r128.keySet());
        l(r68, r128.values());
        if (r128.isEmpty() == false) goto L94;
        r126.clear();
        r127.clear();
        r54 = r10;
        r55 = r11;
        ArrayList<View> r135 = r127;
        r63 = r63;
        HashMap r136 = r310;
        Rect r69 = r311;
        r56 = null;
    L106:
        r128 = r128;
        r127 = r135;
        r113 = r136;
        r17 = r216;
        r115 = r115;
        r125 = r69;
        r53 = r63;
        r16 = r217;
        goto L63
    L94:
        a0.a(r59, r61, r35);
        j0.r.a(r23, new g(r11, r10, r35, r68));
        r126.addAll(r67.values());
        if (r60.isEmpty() == true) goto L97;
        int r70 = 0;
        String r71 = r60.get(0);
        boolean r72 = false;
        View r73 = (View) r67.getOrDefault(r71, null);
        Object r74 = r312;
        r115.n(r73, r74);
    L98:
        r127.addAll(r68.values());
        if (r65.isEmpty() == true) goto L103;
        View r75 = (View) r68.getOrDefault(r65.get(r70), r72);
        if (r75 == null) goto L103;
        r69 = r311;
        j0.r.a(r23, new h(r115, r75, r69));
        r215 = true;
    L104:
        r115.r(r74, r63, r126);
        r135 = r127;
        r115.m(r74, null, null, null, null, r74, r135);
        Boolean r76 = Boolean.TRUE;
        r136 = r310;
        r136.put(r10, r76);
        r136.put(r11, r76);
        r212 = this;
        r214 = r73;
        r56 = r74;
        r54 = r10;
        r55 = r11;
    L103:
        r69 = r311;
        goto L104
    L97:
        r74 = r312;
        r70 = 0;
        r72 = false;
        r73 = r214;
        goto L98
    L81:
        r61.getEnterTransitionCallback();
        r59.getExitTransitionCallback();
    L105:
        r217 = r16;
        r63 = r53;
        r69 = r125;
        r136 = r113;
        r135 = r127;
        goto L106
    L67:
        r129 = false;
        goto L68
    L107:
        ArrayList r218 = r16;
        View r77 = r53;
        r29 = r17;
        Rect r78 = r125;
        n.b r79 = r128;
        f0 r137 = r115;
        HashMap r138 = r113;
        ArrayList<View> r139 = r127;
        ArrayList r80 = new ArrayList();
        Iterator r81 = r218.iterator();
        Object r140 = null;
        Object r141 = null;
    L109:
        if (r81.hasNext() == false) goto L148;
        Iterator r313 = r81;
        c r82 = (c) r81.next();
        boolean r142 = r82.b();
        n.b r219 = r79;
        i0.d r83 = r82.f2004a;
        Object r314 = r140;
        if (r142 == false) goto L113;
        r138.put(r83, Boolean.FALSE);
        r82.a();
        r140 = r314;
        i0.d r220 = r11;
        View r315 = r77;
        ArrayList<View> r316 = r126;
        HashMap r143 = r138;
        View r84 = r214;
    L147:
        r81 = r313;
        r214 = r84;
        r138 = r143;
        r79 = r219;
        r11 = r220;
        r77 = r315;
        r126 = r316;
        goto L109
    L113:
        Object r144 = r137.f(r82.f2006c);
        if (r56 == null) goto L118;
        if (r83 == r54) goto L117;
        if (r83 != r55) goto L118;
    L117:
        boolean r85 = true;
    L119:
        if (r144 != null) goto L123;
        if (r85 == true) goto L122;
        r138.put(r83, Boolean.FALSE);
        r82.a();
    L122:
        r140 = r314;
        r220 = r11;
        r315 = r77;
        r316 = r126;
        r143 = r138;
        r84 = r214;
    L146:
        r55 = r220;
        goto L147
    L123:
        r220 = r11;
        ArrayList<View> r86 = new ArrayList();
        Object r145 = r141;
        j(r86, r83.f1985c.mView);
        if (r85 == false) goto L129;
        if (r83 != r54) goto L127;
        r86.removeAll(r126);
        goto L129
    L127:
        r86.removeAll(r139);
    L129:
        if (r86.isEmpty() == false) goto L131;
        r137.a(r77, r144);
        Object r87 = r314;
        r315 = r77;
        r316 = r126;
        r143 = r138;
        Object r88 = r145;
        Object r146 = r144;
    L136:
        if (r83.f1983a != i0.d.c.f1996b) goto L141;
        r80.addAll(r86);
        if (r215 == false) goto L140;
        r137.o(r146, r78);
    L140:
        r84 = r214;
    L142:
        r143.put(r83, Boolean.TRUE);
        if (r82.f2007d == false) goto L145;
        r141 = r137.j(r88, r146, null);
        r140 = r87;
        goto L146
    L145:
        r140 = r137.j(r87, r146, null);
        r141 = r88;
        goto L146
    L141:
        r84 = r214;
        r137.n(r84, r146);
        goto L142
    L131:
        r137.b(r144, r86);
        r87 = r314;
        r315 = r77;
        r88 = r145;
        r316 = r126;
        r143 = r138;
        r137.m(r144, r144, r86, null, null, null, null);
        if (r83.f1983a != i0.d.c.f1997m) goto L134;
        r29.remove(r83);
        ArrayList<View> r147 = new ArrayList(r86);
        Fragment r148 = r83.f1985c;
        r147.remove(r148.mView);
        View r149 = r148.mView;
        r146 = r144;
        r137.l(r146, r149, r147);
        j0.r.a(r23, new i(r86));
        goto L136
    L134:
        r146 = r144;
    L118:
        r85 = false;
        goto L119
    L148:
        i0.d r221 = r11;
        n.b r222 = r79;
        ArrayList<View> r317 = r126;
        r120 = r138;
        Object r89 = r137.i(r141, r140, r56);
        Iterator r90 = r218.iterator();
    L150:
        if (r90.hasNext() == false) goto L174;
        c r91 = (c) r90.next();
        if (r91.b() == true) goto L150;
        i0.d r92 = r91.f2004a;
        i0.d r93 = r221;
        if (r56 == null) goto L159;
        if (r92 == r54) goto L158;
        if (r92 != r93) goto L159;
    L158:
        boolean r94 = true;
    L161:
        if (r91.f2006c != null) goto L165;
        if (r94 == true) goto L165;
        String r95 = r213;
    L173:
        r221 = r93;
        r213 = r95;
    L165:
        WeakHashMap<View, j0.h0> r96 = j0.w.f8437a;
        if (j0.w.g.c(r23) == false) goto L168;
        r95 = r213;
        Fragment r97 = r92.f1985c;
        r137.p(r89, new j(r91));
        goto L173
    L168:
        if (FragmentManager.G(2) == false) goto L170;
        r95 = r213;
        Log.v(r95, "SpecialEffectsController: Container " + r23 + " has not been laid out. Completing operation " + r92);
    L171:
        r91.a();
        goto L173
    L170:
        r95 = r213;
    L159:
        r94 = false;
        goto L161
    L174:
        r27 = r213;
        WeakHashMap<View, j0.h0> r98 = j0.w.f8437a;
        if (j0.w.g.c(r23) == false) goto L176;
        a0.b(r80, 4);
        ArrayList r99 = f0.k(r139);
        r137.c(r23, r89);
        f0.q(r212.f1973a, r317, r139, r99, r222);
        r28 = false;
        a0.b(r80, 0);
        r137.s(r56, r317, r139);
        goto L178
    }
}
