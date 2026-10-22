package t7a;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.OverScroller;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxTouchEvent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d {
    public final OverScroller a;
    public LynxContext b;
    public int c;
    public int d;
    public int e;
    public VelocityTracker f;
    public HashSet<p7a.a> g;
    public HashSet<Integer> h;
    public p7a.a i;
    public p7a.a j;
    public p7a.a k;
    public p7a.a l;
    public final s7a.b m;
    public r7a.a n;

    public static void f(p7a.a r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        Map<Integer, a> r2 = r1.getGestureHandlers();
        if (r2 != null) goto L7;
        return;
    L7:
        Iterator<a> r3 = r2.values().iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        r3.next().m();
        goto L9
    }

    public final int d(p7a.a r9) {
        if (r9 != null) goto L5;
        return 3;
    L5:
        Map<Integer, a> r1 = r9.getGestureHandlers();
        if (r1 != null) goto L8;
        return 3;
    L8:
        Iterator<a> r0 = r1.values().iterator();
        int r2 = -1;
    L10:
        if (r0.hasNext() == false) goto L39;
        a r3 = r0.next();
        int r4 = r3.b;
        boolean r5 = true;
        if (r4 != 5) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == true) goto L16;
        if (r4 == 2) goto L22;
        r5 = false;
    L22:
        if (r5 == true) goto L23;
        if (r2 < 0) goto L36;
        if (r2 <= r4) goto L10;
    L36:
        r2 = r4;
        goto L10
    L23:
        int r6 = r3.e.a;
        HashSet<Integer> r8 = this.h;
        Map<Integer, a> r10 = r9.getGestureHandlers();
        if (r10 == null) goto L34;
        Iterator<a> r11 = r10.values().iterator();
    L28:
        if (r11.hasNext() == false) goto L34;
        a r12 = r11.next();
        int r13 = r12.e.a;
        if (r13 == r6) goto L28;
        if (r8.contains(Integer.valueOf(r13)) == true) goto L28;
        r12.e();
    L34:
        return 2;
    L16:
        g(r9);
        this.k = null;
        return 5;
    L14:
        r7 = false;
        goto L15
    L39:
        return r2;
    }

    public final void g(p7a.a r2) {
        f(r2);
        HashSet<p7a.a> r3 = this.g;
        if (r3 == null) goto L8;
        Iterator<p7a.a> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        f(r4.next());
        goto L6
    L10:
        return;
    }

    public final void h(p7a.a r12) {
        s7a.b r0 = this.m;
        Pair r1 = null;
        if (r12 != null) goto L5;
        r0.getClass();
    L48:
        if (r1 != null) goto L50;
        return;
    L50:
        this.g = (HashSet) r1.first;
        this.h = (HashSet) r1.second;
        return;
    L5:
        if (r0.b == null) goto L48;
        Map<Integer, s7a.a> r2 = r12.getGestureDetectorMap();
        if (r2 == null) goto L48;
        HashSet r3 = new HashSet();
        HashSet r4 = new HashSet();
        HashSet r5 = new HashSet();
        Iterator<Map.Entry<Integer, s7a.a>> r6 = r2.entrySet().iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        r4.add(Integer.valueOf(r6.next().getValue().a));
        goto L12
    L14:
        Iterator<Map.Entry<Integer, s7a.a>> r7 = r2.entrySet().iterator();
    L16:
        if (r7.hasNext() == false) goto L46;
        Map.Entry<Integer, s7a.a> r8 = r7.next();
        if (r8.getValue() == null) goto L16;
        List r9 = (List) ((HashMap) r8.getValue().d).get("simultaneous");
        if (r9 == null) goto L16;
        if (r9.isEmpty() == true) goto L16;
        Iterator r10 = r9.iterator();
    L27:
        if (r10.hasNext() == false) goto L16;
        int r11 = ((Integer) r10.next()).intValue();
        if (r4.contains(Integer.valueOf(r11)) == true) goto L30;
        Set r13 = (Set) ((HashMap) r0.a).get(Integer.valueOf(r11));
        if (r13 == null) goto L27;
        Iterator r14 = r13.iterator();
    L36:
        if (r14.hasNext() == false) goto L27;
        int r15 = ((Integer) r14.next()).intValue();
        WeakReference r16 = (WeakReference) ((HashMap) r0.b.a).get(Integer.valueOf(r15));
        if (r16 == null) goto L40;
        p7a.a r17 = (p7a.a) r16.get();
    L41:
        if (r17 == null) goto L36;
        if (r17.getGestureArenaMemberId() == r12.getGestureArenaMemberId()) goto L36;
        r3.add(r17);
        goto L36
    L40:
        r17 = null;
        goto L41
    L30:
        r5.add(Integer.valueOf(r11));
        goto L27
    L46:
        r1 = new Pair(r3, r5);
        goto L48
    }

    public d(LynxContext r2, s7a.b r3) {
        this.a = new OverScroller(r2);
        this.b = r2;
        this.m = r3;
    }

    public final p7a.a e(LinkedList<p7a.a> r9, p7a.a r10) {
        if (r10 == null) goto L5;
    L6:
        if (r9 != null) goto L8;
    L7:
        return null;
    L8:
        int r1 = 0;
        if (r10 != null) goto L13;
        p7a.a r2 = this.k;
        if (r2 == null) goto L13;
        g(r2);
        r10 = r2;
        boolean r3 = true;
    L14:
        int r4 = d(r10);
        if (r4 > 2) goto L18;
        return r10;
    L18:
        if (r4 != 5) goto L20;
        return null;
    L20:
        if (r3 == false) goto L22;
        return null;
    L22:
        int r5 = r9.indexOf(r10);
        int r11 = r9.lastIndexOf(r10);
        if (r5 == r11) goto L28;
        p7a.a r6 = this.i;
        if (r6 == null) goto L27;
        g(r6);
        r5 = r11;
        goto L28
    L27:
        this.i = r9.get(r5);
    L28:
        if (r5 >= 0) goto L30;
    L66:
        return null;
    L30:
        if (r5 >= r9.size()) goto L66;
        int r12 = r9.get(r5).getGestureArenaMemberId();
        int r7 = r5 + 1;
    L34:
        if (r7 >= r9.size()) goto L50;
        p7a.a r8 = r9.get(r7);
        if (r8.getGestureArenaMemberId() == r12) goto L49;
        if (this.i != r8) goto L42;
        this.i = null;
    L44:
        int r13 = d(r8);
        if (r13 <= 2) goto L46;
        if (r13 != 5) goto L49;
        return null;
    L46:
        return r8;
    L42:
        if (d(r8) == 5) goto L44;
        g(r8);
    L49:
        r7 = r7 + 1;
    L50:
        if (r1 >= r5) goto L66;
        p7a.a r14 = r9.get(r1);
        if (r14.getGestureArenaMemberId() == r12) goto L65;
        if (this.i != r14) goto L58;
        this.i = null;
    L60:
        int r15 = d(r14);
        if (r15 <= 2) goto L62;
        if (r15 != 5) goto L65;
        return null;
    L62:
        return r14;
    L58:
        if (d(r14) == 5) goto L60;
        g(r14);
    L65:
        r1 = r1 + 1;
    L13:
        r3 = false;
        goto L14
    L5:
        if (this.k == null) goto L7;
        goto L6
    }

    public final void c(LynxTouchEvent r11, LinkedList<p7a.a> r12, float r13, float r14, MotionEvent r15) {
        int r0 = 0;
    L4:
        if (r0 >= r12.size()) goto L13;
        p7a.a r1 = this.j;
        p7a.a r2 = this.k;
        if (r1 == r2) goto L12;
        if (r1 == null) goto L20;
        if (r2 == r1) goto L11;
        this.k = r1;
    L11:
        h(r1);
        b(this.j, r13, r14, r11, r12, r15);
        r0 = r0 + 1;
        goto L4
    L20:
        return;
    L12:
        return;
    L13:
        b(this.k, r13, r14, r11, r12, r15);
    }

    public final void b(p7a.a r9, float r10, float r11, LynxTouchEvent r12, LinkedList<p7a.a> r13, MotionEvent r14) {
        if (r9 != null) goto L4;
        return;
    L4:
        a(r14, r9, r12, r10, r11, false, this.n);
        HashSet<p7a.a> r15 = this.g;
        if (r15 == null) goto L11;
        Iterator<p7a.a> r16 = r15.iterator();
    L8:
        if (r16.hasNext() == false) goto L10;
        a(r14, r16.next(), r12, r10, r11, true, this.n);
        goto L8
    L10:
        r7a.a r17 = this.n;
        r17.b = 0.0f;
        r17.c = 0.0f;
        r17.d = false;
    L11:
        if (r13 == null) goto L15;
        this.j = e(r13, this.j);
        return;
    }

    public static void a(MotionEvent r8, p7a.a r9, LynxTouchEvent r10, float r11, float r12, boolean r13, r7a.a r14) {
        if (r9 != null) goto L4;
        return;
    L4:
        Map<Integer, a> r15 = r9.getGestureHandlers();
        if (r15 != null) goto L7;
        return;
    L7:
        Iterator<a> r16 = r15.values().iterator();
    L9:
        if (r16.hasNext() == false) goto L11;
        r16.next().k(r8, r10, r11, r12, r13, r14);
        goto L9
    }
}
