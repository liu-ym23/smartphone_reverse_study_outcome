package q7a;

import android.os.Handler;
import android.os.Looper;
import com.lynx.config.LynxLiteConfigs;
import com.lynx.tasm.event.LynxTouchEvent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import t7a.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b {
    public Map<Integer, WeakReference<p7a.a>> a;
    public LinkedList<p7a.a> b;
    public LinkedList<p7a.a> c;
    public final Handler d;
    public s7a.b e;
    public boolean f;
    public p7a.a g;
    public d h;

    public b() {
        this.d = new Handler(Looper.getMainLooper());
    }

    public final void b() {
        if (d() == true) goto L5;
        return;
    L5:
        if (this.h == null) goto L12;
        Handler r0 = this.d;
        if (r0 == null) goto L13;
        r0.post(new a(this));
        return;
    L13:
        return;
    }

    public final boolean d() {
        if (LynxLiteConfigs.enableNewGesture() == true) goto L7;
        return false;
    L7:
        return this.f;
    }

    public final int a(p7a.a r8) {
        if (d() == false) goto L29;
        if (r8 == null) goto L36;
        Map<Integer, WeakReference<p7a.a>> r0 = this.a;
        if (r0 == null) goto L37;
        HashMap r1 = (HashMap) r0;
        r1.put(Integer.valueOf(r8.getSign()), new WeakReference(r8));
        int r2 = r8.getSign();
        Map<Integer, s7a.a> r3 = r8.getGestureDetectorMap();
        if (d() == false) goto L28;
        if (r3 == null) goto L28;
        if (r3.isEmpty() == true) goto L28;
        if (this.e == null) goto L28;
        Iterator<Map.Entry<Integer, s7a.a>> r4 = r3.entrySet().iterator();
    L19:
        if (r4.hasNext() == false) goto L28;
        s7a.a r5 = r4.next().getValue();
        s7a.b r6 = this.e;
        r6.getClass();
        if (r5 == null) goto L19;
        int r7 = r5.a;
        Map<Integer, Set<Integer>> r9 = r6.a;
        HashMap r10 = (HashMap) r9;
        if (r10.get(Integer.valueOf(r7)) != null) goto L26;
        Map<Integer, Set<Integer>> r11 = r6.a;
        HashMap r12 = (HashMap) r11;
        r12.put(Integer.valueOf(r7), new HashSet());
    L26:
        Map<Integer, Set<Integer>> r13 = r6.a;
        HashMap r14 = (HashMap) r13;
        ((Set) r14.get(Integer.valueOf(r7))).add(Integer.valueOf(r2));
    L28:
        return r8.getSign();
    L37:
        return 0;
    L36:
        return 0;
    L29:
        return 0;
    }

    public final boolean e(int r2) {
        if (d() == false) goto L9;
        Map<Integer, WeakReference<p7a.a>> r0 = this.a;
        if (r0 == null) goto L11;
        HashMap r1 = (HashMap) r0;
        return r1.containsKey(Integer.valueOf(r2));
    L11:
        return false;
    L9:
        return false;
    }

    public final void f(p7a.a r6) {
        if (d() == false) goto L33;
        if (r6 == null) goto L47;
        Map<Integer, WeakReference<p7a.a>> r0 = this.a;
        if (r0 == null) goto L50;
        HashMap r1 = (HashMap) r0;
        r1.remove(Integer.valueOf(r6.getGestureArenaMemberId()));
        int r2 = r6.getGestureArenaMemberId();
        Map<Integer, s7a.a> r7 = r6.getGestureDetectorMap();
        if (d() == false) goto L51;
        if (r7 != null) goto L13;
        return;
    L13:
        if (r7.isEmpty() == false) goto L16;
        return;
    L16:
        if (this.e == null) goto L49;
        Iterator<Map.Entry<Integer, s7a.a>> r8 = r7.entrySet().iterator();
    L19:
        if (r8.hasNext() == false) goto L53;
        s7a.a r3 = r8.next().getValue();
        s7a.b r4 = this.e;
        r4.getClass();
        if (r3 == null) goto L19;
        int r5 = r3.a;
        Map<Integer, Set<Integer>> r9 = r4.a;
        HashMap r10 = (HashMap) r9;
        Set r11 = (Set) r10.get(Integer.valueOf(r5));
        if (r11 == null) goto L19;
        if (r11.isEmpty() == true) goto L19;
        if (r11.contains(Integer.valueOf(r2)) == false) goto L19;
        r11.remove(Integer.valueOf(r2));
        if (r11.isEmpty() == false) goto L19;
        Map<Integer, Set<Integer>> r12 = r4.a;
        HashMap r13 = (HashMap) r12;
        r13.remove(Integer.valueOf(r5));
        goto L19
    L53:
        return;
    L49:
        return;
    L51:
        return;
    L50:
        return;
    L47:
        return;
    }

    public final void c(String r12, LynxTouchEvent r13) {
        if (d() == true) goto L5;
        return;
    L5:
        if (this.h == null) goto L84;
        LinkedList<p7a.a> r0 = this.c;
        if (this.g != null) goto L11;
        return;
    L11:
        if (LynxTouchEvent.EVENT_TOUCH_START.equals(r12) == false) goto L13;
    L19:
        int r6 = 0;
    L21:
        if (r6 >= r0.size()) goto L87;
        Map<Integer, t7a.a> r7 = r0.get(r6).getGestureHandlers();
        if (r7 == null) goto L61;
        Iterator<t7a.a> r8 = r7.values().iterator();
    L27:
        if (r8.hasNext() == false) goto L61;
        t7a.a r9 = r8.next();
        byte r10 = -1;
        switch(r12.hashCode()) {
            case -1578593149: goto L44;
            case -819532484: goto L40;
            case 364536720: goto L36;
            case 2127979129: goto L32;
            default: goto L47;
        };
    L47:
        switch(r10) {
            case 0: goto L59;
            case 1: goto L56;
            case 2: goto L53;
            case 3: goto L50;
            default: goto L27;
        };
    L50:
        if (((Boolean) ((HashMap) r9.d).get("onTouchesCancel")).booleanValue() == false) goto L27;
        r9.n("onTouchesCancel", r9.f(r13));
        goto L27
    L53:
        if (((Boolean) ((HashMap) r9.d).get("onTouchesMove")).booleanValue() == false) goto L27;
        r9.n("onTouchesMove", r9.f(r13));
        goto L27
    L56:
        if (((Boolean) ((HashMap) r9.d).get("onTouchesUp")).booleanValue() == false) goto L27;
        r9.n("onTouchesUp", r9.f(r13));
        goto L27
    L59:
        if (((Boolean) ((HashMap) r9.d).get("onTouchesDown")).booleanValue() == false) goto L27;
        r9.n("onTouchesDown", r9.f(r13));
        goto L27
    L32:
        if (r12.equals(LynxTouchEvent.EVENT_TOUCH_CANCEL) == false) goto L47;
        r10 = 3;
        goto L47
    L36:
        if (r12.equals(LynxTouchEvent.EVENT_TOUCH_MOVE) == false) goto L47;
        r10 = 2;
        goto L47
    L40:
        if (r12.equals(LynxTouchEvent.EVENT_TOUCH_END) == false) goto L47;
        r10 = 1;
        goto L47
    L44:
        if (r12.equals(LynxTouchEvent.EVENT_TOUCH_START) == false) goto L47;
        r10 = 0;
    L61:
        r6 = r6 + 1;
        goto L21
    L87:
        return;
    L13:
        if (LynxTouchEvent.EVENT_TOUCH_MOVE.equals(r12) == true) goto L19;
        if (LynxTouchEvent.EVENT_TOUCH_CANCEL.equals(r12) == true) goto L19;
        if (LynxTouchEvent.EVENT_TOUCH_END.equals(r12) == true) goto L19;
        return;
    }
}
