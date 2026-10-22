package com.lynx.tasm.behavior.ui.accessibility;

import android.graphics.Rect;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import com.bytedance.ies.xelement.overlay.i;
import com.google.common.reflect.w;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIBody;
import com.lynx.tasm.behavior.ui.text.FlattenUIText;
import com.lynx.tasm.behavior.ui.text.UIText;
import com.lynx.tasm.t;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import ym.p;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Rect f10404p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f10405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10407c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AccessibilityManager f10409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public w f10410j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p f10411k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.lynx.tasm.behavior.ui.f f10412l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LynxAccessibilityDelegate f10413m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public t f10414n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f10415o;

    static {
        f10404p = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public d(UIBody r5) {
        this.f10405a = null;
        this.f10406b = false;
        this.f10407c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.f10408h = false;
        this.f10409i = null;
        this.f10410j = null;
        this.f10411k = null;
        this.f10412l = null;
        this.f10413m = null;
        this.f10414n = null;
        this.f10415o = false;
        if (r5.f10385a != null) goto L6;
        LynxLog.b(4, "LynxAccessibilityWrapper", "Construct LynxAccessibilityWrapper with null host");
        return;
    L6:
        this.f10405a = new WeakReference(r5);
        if (r5.getLynxContext() == null) goto L10;
        this.f10415o = LynxEnv.inst().enableLazyInitA11y();
        this.f10409i = (AccessibilityManager) r5.getLynxContext().getSystemService("accessibility");
    L10:
        if (this.f10415o == false) goto L13;
        this.f10410j = new w(this.f10409i, this);
        return;
    L13:
        LynxLog.b(2, "LynxAccessibilityWrapper", "Construct LynxAccessibilityNodeProvider and set default delegate.");
        if (this.f10412l != null) goto L19;
        this.f10412l = new com.lynx.tasm.behavior.ui.f(r5);
        UIBody.UIBodyView r10 = r5.f10385a;
        if (r10 == null) goto L20;
        r10.setAccessibilityDelegate(new i(this, 1));
        return;
    L20:
        return;
    }

    public static void c(LynxBaseUI r5, boolean r10, JavaOnlyArray r11) {
        if (r5 == null) goto L23;
        if (r10 == true) goto L5;
        JavaOnlyMap r12 = new JavaOnlyMap();
        r12.putInt("element-id", r5.getSign());
        r12.putString("a11y-id", r5.getAccessibilityId());
        r11.add(r12);
    L19:
        int r13 = 0;
    L21:
        if (r13 >= r5.getChildren().size()) goto L25;
        c(r5.getChildren().get(r13), r10, r11);
        r13 = r13 + 1;
        goto L21
    L25:
        return;
    L5:
        String r14 = "";
        if ((r5 instanceof UIText) == false) goto L13;
        CharSequence r15 = ((UIText) r5).k();
        if (r15 == null) goto L11;
        r14 = r15.toString();
    L11:
        r11.pushString(r14);
        goto L19
    L13:
        if ((r5 instanceof FlattenUIText) == false) goto L19;
        CharSequence r16 = ((FlattenUIText) r5).e;
        if (r16 == null) goto L18;
        r14 = r16.toString();
    L18:
        r11.pushString(r14);
        goto L19
    }

    public final void a() {
        if (h() == false) goto L46;
        WeakReference r5 = this.f10405a;
        if (r5 == null) goto L8;
        UIBody r10 = (UIBody) r5.get();
    L9:
        if (r10 != null) goto L11;
        return;
    L11:
        if (r10.f10385a != null) goto L13;
        return;
    L13:
        if (this.f10407c == true) goto L30;
        if (this.f10406b == true) goto L30;
        if (this.f10412l != null) goto L22;
        this.f10412l = new com.lynx.tasm.behavior.ui.f(r10);
        UIBody.UIBodyView r11 = r10.f10385a;
        if (r11 == null) goto L22;
        r11.setAccessibilityDelegate(new i(this, 1));
    L22:
        if (this.f10406b == false) goto L24;
        return;
    L24:
        if (this.f10407c == true) goto L41;
        com.lynx.tasm.behavior.ui.f r12 = this.f10412l;
        if (r12 == null) goto L42;
        r12.f10458h = this.d;
        r12.f10459i = this.e;
        return;
    L42:
        return;
    L41:
        return;
    L30:
        if (this.f10411k != null) goto L33;
        this.f10411k = new p(5);
    L33:
        if (this.f10407c == false) goto L37;
        e(r10, r10.f10385a);
        return;
    L37:
        if (this.f10406b == false) goto L45;
        d(r10);
        return;
    L45:
        return;
    L8:
        r10 = null;
        goto L9
    }

    public final void b(LynxBaseUI r5, boolean r10) {
        if (g() == false) goto L21;
        if (r10 == false) goto L8;
        t r11 = this.f10414n;
        r11.getClass();
        int r12 = r5.getSign();
        ((HashMap) r11.f).put(Integer.valueOf(r12), new WeakReference(r5));
        return;
    L8:
        t r13 = this.f10414n;
        r13.getClass();
        int r14 = r5.getSign();
        HashMap r15 = (HashMap) r13.f;
        if (r15 != null) goto L11;
        return;
    L11:
        if (r15.get(Integer.valueOf(r14)) == null) goto L22;
        LynxBaseUI r16 = (LynxBaseUI) ((WeakReference) r15.get(Integer.valueOf(r14))).get();
        if (r16 == null) goto L19;
        if (r16 != r5) goto L20;
        r15.remove(Integer.valueOf(r14));
        return;
    L20:
        return;
    L19:
        return;
    L22:
        return;
    }

    public final void d(UIBody r5) {
        LynxLog.b(2, "LynxAccessibilityWrapper", "init LynxAccessibilityDelegate with " + this.f10406b + ", " + this.f10407c);
        if (this.f10413m != null) goto L5;
        this.f10413m = new LynxAccessibilityDelegate(r5);
    L5:
        LynxAccessibilityDelegate r10 = this.f10413m;
        r10.f = this.d;
        ViewCompat.setAccessibilityDelegate(r5.f10385a, r10);
    }

    public final void e(UIBody r5, UIBody.UIBodyView r10) {
        LynxLog.b(2, "LynxAccessibilityWrapper", "init LynxAccessibilityHelper with " + this.f10406b + ", " + this.f10407c);
        if (this.f10414n != null) goto L5;
        this.f10414n = new t(r5);
    L5:
        this.f10414n.f10962b = this.d;
        ViewCompat.setImportantForAccessibility(r10, 2);
        ViewCompat.setAccessibilityDelegate(r10, null);
    }

    public final boolean f() {
        if (this.f10406b == true) goto L5;
        return false;
    L5:
        if (this.f10407c == false) goto L7;
        return false;
    L7:
        if (this.f10413m == null) goto L13;
        return true;
    L13:
        return false;
    }

    public final boolean g() {
        if (this.f10406b == false) goto L5;
        return false;
    L5:
        if (this.f10407c == true) goto L7;
        return false;
    L7:
        if (this.f10414n == null) goto L13;
        return true;
    L13:
        return false;
    }

    public final boolean h() {
        if (this.f10409i != null) goto L5;
        return false;
    L5:
        if (this.g == true) goto L7;
        return false;
    L7:
        if (this.f10408h == false) goto L13;
        return true;
    L13:
        return false;
    }

    public final boolean i() {
        if (this.f == true) goto L5;
        return false;
    L5:
        if (h() == true) goto L7;
        return false;
    L7:
        if (f() == false) goto L9;
        return true;
    L9:
        if (g() == false) goto L16;
        return true;
    L16:
        return false;
    }
}
