package com.lynx.tasm.behavior.ui.accessibility;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.text.FlattenUIText;
import com.lynx.tasm.behavior.ui.text.UIText;
import com.obric.aivoice.core.data.NameKeys;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d implements b.c {
    public static final Rect p = null;
    public final WeakReference<UIBody> a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public final AccessibilityManager i;
    public b j;
    public a k;
    public com.lynx.tasm.behavior.ui.c l;
    public LynxAccessibilityDelegate m;
    public LynxAccessibilityHelper n;
    public final boolean o;

    static {
        p = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public final boolean e() {
        if (this.b == true) goto L5;
    L9:
        return false;
    L5:
        if (this.c == true) goto L9;
        if (this.m == null) goto L9;
        return true;
    }

    public final boolean f() {
        if (this.b == false) goto L5;
    L9:
        return false;
    L5:
        if (this.c == false) goto L9;
        if (this.n == null) goto L9;
        return true;
    }

    public final UIBody h() {
        WeakReference<UIBody> r0 = this.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.get();
    }

    public final boolean k() {
        if (this.i != null) goto L5;
    L9:
        return false;
    L5:
        if (this.g == false) goto L9;
        if (this.h == false) goto L9;
        return true;
    }

    public final boolean m() {
        if (this.f == true) goto L5;
    L11:
        return false;
    L5:
        if (k() == false) goto L11;
        if (e() == false) goto L9;
    L10:
        return true;
    L9:
        if (f() == false) goto L11;
        goto L10
    }

    public final void d() {
        if (k() == false) goto L5;
    L9:
        UIBody r0 = h();
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.getBodyView() != null) goto L14;
        return;
    L14:
        if (this.c == true) goto L33;
        if (this.b == true) goto L33;
        if (this.l != null) goto L23;
        this.l = new com.lynx.tasm.behavior.ui.c(r0);
        UIBody.UIBodyView r1 = r0.getBodyView();
        if (r1 == null) goto L23;
        r1.setAccessibilityDelegate(new c(this));
    L23:
        if (this.b == false) goto L25;
    L29:
        boolean r2 = false;
    L30:
        if (r2 == false) goto L45;
        com.lynx.tasm.behavior.ui.c r3 = this.l;
        r3.h = this.d;
        r3.i = this.e;
        return;
    L45:
        return;
    L25:
        if (this.c == true) goto L29;
        if (this.l == null) goto L29;
        r2 = true;
    L33:
        if (this.k != null) goto L36;
        this.k = new a();
    L36:
        if (this.c == false) goto L39;
        j(r0, r0.getBodyView());
        return;
    L39:
        if (this.b == false) goto L48;
        i(r0);
        return;
    L48:
        return;
    L5:
        if (this.b == true) goto L7;
        return;
    L7:
        if (LynxEnv.inst().isPlatformObservabilityEnabled() == true) goto L9;
    }

    public d(UIBody r4) {
        this.a = null;
        boolean r1 = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = false;
        if (r4 != null) goto L5;
    L24:
        LLog.e("LynxAccessibilityWrapper", "Construct LynxAccessibilityWrapper with null host");
        return;
    L5:
        if (r4.getBodyView() == null) goto L24;
        this.a = new WeakReference(r4);
        LynxContext r2 = r4.getLynxContext();
        if (r2 == null) goto L16;
        if (r2.isEmbeddedModeOn() == false) goto L12;
    L13:
        r1 = true;
    L14:
        this.o = r1;
        this.i = (AccessibilityManager) r4.getLynxContext().getSystemService("accessibility");
        goto L16
    L12:
        if (LynxEnv.inst().enableLazyInitA11y() == false) goto L14;
    L16:
        if (this.o == false) goto L18;
        this.j = new b(this.i, this);
        return;
    L18:
        LLog.i("LynxAccessibilityWrapper", "Construct LynxAccessibilityNodeProvider and set default delegate.");
        if (this.l != null) goto L27;
        this.l = new com.lynx.tasm.behavior.ui.c(r4);
        UIBody.UIBodyView r5 = r4.getBodyView();
        if (r5 == null) goto L28;
        r5.setAccessibilityDelegate(new c(this));
        return;
    L28:
        return;
    }

    public static void l(LynxBaseUI r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getLynxContext() == null) goto L8;
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.put("element-id", Integer.valueOf(r3.getSign()));
        r0.put("a11y-id", r3.getAccessibilityId());
        JavaOnlyArray r1 = new JavaOnlyArray();
        r1.pushMap(r0);
        r3.getLynxContext().sendGlobalEvent("activeElement", r1);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.accessibility.b.c
    public final void a(boolean r1) {
        this.h = r1;
        if (this.o == false) goto L6;
        d();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.accessibility.b.c
    public final void b(boolean r1) {
        this.g = r1;
        if (this.o == false) goto L6;
        d();
        return;
    }

    public final void i(UIBody r3) {
        LLog.i("LynxAccessibilityWrapper", "init LynxAccessibilityDelegate with " + this.b + ", " + this.c);
        if (this.m != null) goto L5;
        this.m = new LynxAccessibilityDelegate(r3);
    L5:
        this.m.f = this.d;
        ViewCompat.setAccessibilityDelegate(r3.getBodyView(), this.m);
    }

    public final void c(LynxBaseUI r4, boolean r5) {
        if (f() == true) goto L5;
        return;
    L5:
        if (r5 == false) goto L7;
        LynxAccessibilityHelper r6 = this.n;
        r6.getClass();
        int r0 = r4.getSign();
        r6.e.put(Integer.valueOf(r0), new WeakReference(r4));
        return;
    L7:
        LynxAccessibilityHelper r7 = this.n;
        r7.getClass();
        int r1 = r4.getSign();
        HashMap<Integer, WeakReference<LynxBaseUI>> r2 = r7.e;
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.get(Integer.valueOf(r1)) == null) goto L21;
        LynxBaseUI r3 = r7.e.get(Integer.valueOf(r1)).get();
        if (r3 == null) goto L19;
        if (r3 != r4) goto L20;
        r7.e.remove(Integer.valueOf(r1));
        return;
    L20:
        return;
    L19:
        return;
    }

    public final void j(UIBody r3, UIBody.UIBodyView r4) {
        LLog.i("LynxAccessibilityWrapper", "init LynxAccessibilityHelper with " + this.b + ", " + this.c);
        if (this.n != null) goto L5;
        this.n = new LynxAccessibilityHelper(r3);
    L5:
        this.n.b = this.d;
        ViewCompat.setImportantForAccessibility(r4, 2);
        ViewCompat.setAccessibilityDelegate(r4, null);
    }

    public static void g(LynxBaseUI r3, boolean r4, JavaOnlyArray r5) {
        if (r3 == null) goto L23;
        if (r4 == true) goto L5;
        JavaOnlyMap r0 = new JavaOnlyMap();
        r0.putInt("element-id", r3.getSign());
        r0.putString("a11y-id", r3.getAccessibilityId());
        r5.add(r0);
    L19:
        int r1 = 0;
    L21:
        if (r1 >= r3.getChildren().size()) goto L25;
        g((LynxBaseUI) ListProtector.get(r3.getChildren(), r1), r4, r5);
        r1 = r1 + 1;
        goto L21
    L25:
        return;
    L5:
        boolean r2 = r3 instanceof UIText;
        String r6 = NameKeys.UnloadStrategy_No_Strategy;
        if (r2 == false) goto L13;
        CharSequence r7 = ((UIText) r3).getOriginText();
        if (r7 == null) goto L11;
        r6 = r7.toString();
    L11:
        r5.pushString(r6);
        goto L19
    L13:
        if ((r3 instanceof FlattenUIText) == false) goto L19;
        CharSequence r8 = ((FlattenUIText) r3).getOriginText();
        if (r8 == null) goto L18;
        r6 = r8.toString();
    L18:
        r5.pushString(r6);
        goto L19
    }
}
