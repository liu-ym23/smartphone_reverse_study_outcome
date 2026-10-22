package com.lynx.tasm.animation.keyframe;

import android.text.TextUtils;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public WeakReference<LynxUI> a;
    public s6a.a[] b;
    public HashMap<String, LynxKeyframeAnimator> c;

    public final void a() {
        this.a = null;
        HashMap<String, LynxKeyframeAnimator> r1 = this.c;
        if (r1 != null) goto L5;
        return;
    L5:
        Iterator<LynxKeyframeAnimator> r2 = r1.values().iterator();
    L7:
        if (r2.hasNext() == false) goto L9;
        LynxKeyframeAnimator r3 = r2.next();
        r3.e();
        r3.k();
        r3.b = null;
        r3.c = null;
        goto L7
    }

    public final void b() {
        HashMap<String, LynxKeyframeAnimator> r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<LynxKeyframeAnimator> r1 = r0.values().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        r1.next().f();
        goto L7
    L9:
        this.c = null;
        this.b = null;
    }

    public final void c() {
        if (this.b != null) goto L5;
        return;
    L5:
        if (this.a.get().getHeight() == 0) goto L7;
    L9:
        HashMap<String, LynxKeyframeAnimator> r0 = new HashMap();
        s6a.a[] r1 = this.b;
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L10:
        if (r4 >= r2) goto L25;
        s6a.a r5 = r1[r4];
        if (r5 == null) goto L24;
        if (TextUtils.isEmpty(r5.a) == true) goto L24;
        HashMap<String, LynxKeyframeAnimator> r6 = this.c;
        if (r6 == null) goto L19;
        LynxKeyframeAnimator r7 = r6.get(r5.a);
    L20:
        if (r7 != null) goto L22;
        r7 = new LynxKeyframeAnimator(this.a.get().getView(), this.a.get());
    L23:
        r0.put(r5.a, r7);
        goto L24
    L22:
        this.c.remove(r5.a);
        goto L23
    L19:
        r7 = null;
    L24:
        r4 = r4 + 1;
        goto L10
    L25:
        HashMap<String, LynxKeyframeAnimator> r8 = this.c;
        if (r8 == null) goto L31;
        Iterator<LynxKeyframeAnimator> r9 = r8.values().iterator();
    L29:
        if (r9.hasNext() == false) goto L31;
        r9.next().f();
    L31:
        s6a.a[] r10 = this.b;
        int r11 = r10.length;
    L32:
        if (r3 >= r11) goto L40;
        s6a.a r12 = r10[r3];
        if (r12 == null) goto L39;
        if (TextUtils.isEmpty(r12.a) == true) goto L39;
        r0.get(r12.a).a(r12);
    L39:
        r3 = r3 + 1;
        goto L32
    L40:
        this.c = r0;
        return;
    L7:
        if (this.a.get().getWidth() != 0) goto L9;
    }

    public a(LynxUI r2) {
        this.a = new WeakReference(r2);
        this.c = new HashMap();
    }

    public final void d(String r5, Object r6) {
        HashMap<String, LynxKeyframeAnimator> r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<LynxKeyframeAnimator> r1 = r0.values().iterator();
    L7:
        if (r1.hasNext() == false) goto L16;
        LynxKeyframeAnimator r2 = r1.next();
        if (r2.d.containsKey(r5) == false) goto L12;
        r2.d.put(r5, r6);
    L12:
        if (r5.equals("BackgroundColor") == false) goto L7;
        if (r2.d.containsKey("Color") == false) goto L7;
        r2.d.put("Color", r6);
        goto L7
    }
}
