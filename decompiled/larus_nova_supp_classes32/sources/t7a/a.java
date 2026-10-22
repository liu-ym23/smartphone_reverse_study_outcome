package t7a;

import android.content.res.Resources;
import android.view.MotionEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class a {
    public final int a;
    public int b;
    public final LynxContext c;
    public final Map<String, Boolean> d;
    public final s7a.a e;
    public final p7a.a f;

    public void a() {
        this.b = 2;
        p7a.a r1 = this.f;
        if (r1 == null) goto L6;
        r1.onPlatformGestureStatusChanged(2);
        return;
    }

    public final void b() {
        this.b = 1;
        p7a.a r1 = this.f;
        if (r1 == null) goto L6;
        r1.onPlatformGestureStatusChanged(1);
        return;
    }

    public void d() {
        this.b = 5;
        p7a.a r1 = this.f;
        if (r1 == null) goto L6;
        r1.onPlatformGestureStatusChanged(5);
        return;
    }

    public abstract void k(MotionEvent r1, LynxTouchEvent r2, float r3, float r4, boolean r5, r7a.a r6);

    public void m() {
        this.b = 0;
    }

    public void e() {
        int r0 = this.b;
        if (r0 != 5) goto L5;
    L8:
        p7a.a r1 = this.f;
        if (r1 == null) goto L12;
        r1.onPlatformGestureStatusChanged(this.b);
        return;
    L12:
        return;
    L5:
        if (r0 != 1) goto L7;
        this.b = 4;
        goto L8
    L7:
        this.b = 3;
        goto L8
    }

    public final boolean g() {
        return ((Boolean) ((HashMap) this.d).get("onBegin")).booleanValue();
    }

    public final boolean h() {
        return ((Boolean) ((HashMap) this.d).get("onEnd")).booleanValue();
    }

    public final boolean i() {
        return ((Boolean) ((HashMap) this.d).get("onStart")).booleanValue();
    }

    public final boolean j() {
        return ((Boolean) ((HashMap) this.d).get("onUpdate")).booleanValue();
    }

    public final HashMap<String, Object> f(LynxTouchEvent r4) {
        HashMap<String, Object> r0 = new HashMap();
        if (r4 == null) goto L13;
        r0.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        r0.put("type", r4.getName());
        if (r4.getViewPoint() == null) goto L8;
        r0.put("x", Integer.valueOf(l(r4.getViewPoint().a)));
        r0.put("y", Integer.valueOf(l(r4.getViewPoint().b)));
    L8:
        if (r4.getPagePoint() == null) goto L11;
        r0.put("pageX", Integer.valueOf(l(r4.getPagePoint().a)));
        r0.put("pageY", Integer.valueOf(l(r4.getPagePoint().b)));
    L11:
        if (r4.getClientPoint() == null) goto L13;
        r0.put("clientX", Integer.valueOf(l(r4.getClientPoint().a)));
        r0.put("clientY", Integer.valueOf(l(r4.getClientPoint().b)));
    L13:
        return r0;
    }

    public final int l(float r5) {
        LynxContext r0 = this.c;
        if (r0 == null) goto L12;
        if (r0.getResources() == null) goto L12;
        Resources r1 = r0.getResources();
        if (WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()) == null) goto L12;
        Resources r2 = r0.getResources();
        return (int) (((double) (r5 / WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).density)) + 0.5d);
    L12:
        return (int) r5;
    }

    public final void n(String r3, HashMap<String, Object> r4) {
        if (this.e != null) goto L5;
        return;
    L5:
        com.lynx.tasm.event.a r0 = new com.lynx.tasm.event.a(this.a, r3, r4);
        this.c.getEventEmitter().sendGestureEvent(this.e.a, r0);
    }

    public a(int r2, LynxContext r3, s7a.a r4, p7a.a r5) {
        this.b = 0;
        this.a = r2;
        this.c = r3;
        this.e = r4;
        this.f = r5;
        HashMap r6 = new HashMap();
        this.d = r6;
        List<String> r7 = r4.c;
        Boolean r8 = Boolean.FALSE;
        r6.put("onTouchesDown", r8);
        r6.put("onTouchesMove", r8);
        r6.put("onTouchesUp", r8);
        r6.put("onTouchesCancel", r8);
        r6.put("onBegin", r8);
        r6.put("onUpdate", r8);
        r6.put("onStart", r8);
        r6.put("onEnd", r8);
        if (r7 == null) goto L10;
        Iterator r9 = ((ArrayList) r7).iterator();
    L6:
        if (r9.hasNext() == false) goto L16;
        String r10 = (String) r9.next();
        if (((HashMap) this.d).containsKey(r10) == false) goto L6;
        Map<String, Boolean> r11 = this.d;
        HashMap r12 = (HashMap) r11;
        r12.put(r10, Boolean.TRUE);
        goto L6
    L16:
        return;
    }

    public static Map<Integer, a> c(int r5, LynxContext r6, p7a.a r7, Map<Integer, s7a.a> r8) {
        HashMap r0 = new HashMap();
        Iterator<Integer> r1 = r8.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L26;
        s7a.a r2 = r8.get(Integer.valueOf(r1.next().intValue()));
        if (r2 == null) goto L4;
        int r3 = r2.b;
        if (r3 == 0) goto L10;
        if (r3 == 2) goto L13;
        if (r3 == 1) goto L16;
        if (r3 == 3) goto L19;
        if (r3 == 4) goto L22;
        if (r3 != 7) goto L4;
        r0.put(Integer.valueOf(r3), new g(r5, r6, r2, r7));
        goto L4
    L22:
        r0.put(Integer.valueOf(r3), new f(r5, r6, r2, r7));
        goto L4
    L19:
        r0.put(Integer.valueOf(r3), new j(r5, r6, r2, r7));
        goto L4
    L16:
        r0.put(Integer.valueOf(r3), new c(r5, r6, r2, r7));
        goto L4
    L13:
        r0.put(Integer.valueOf(r3), new b(r5, r6, r2, r7));
        goto L4
    L10:
        r0.put(Integer.valueOf(r3), new h(r5, r6, r2, r7));
        goto L4
    L26:
        return r0;
    }
}
