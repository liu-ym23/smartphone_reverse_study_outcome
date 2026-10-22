package com.bytedance.android.accessibilityLib_Core.base.largertoucharea;

import android.content.Context;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.accessibilityLib_Core.config.remote.dsl.h;
import com.bytedance.android.accessibilityLib_Core.processor.ViewAccessibilityDelegateProcessor;
import com.bytedance.android.accessibilityLib_Core.tool.AccessibilityCommonToolExtKt;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements com.bytedance.android.accessibilityLib_Core.processor.a {
    public static final int f = 0;
    public static final int g = 0;
    public final WeakHashMap<View, WeakReference<TouchDelegateComposite>> a;
    public final Rect b;
    public final WeakHashMap<View, Boolean> c;
    public final k6.a d;
    public final com.bytedance.android.accessibilityLib_Core.processor.a e;

    /* JADX INFO: renamed from: com.bytedance.android.accessibilityLib_Core.base.largertoucharea.a$a, reason: collision with other inner class name */
    public static final class C0057a {
    }

    static {
        f = AccessibilityCommonToolExtKt.c();
        g = AccessibilityCommonToolExtKt.c();
    }

    public final void d(ViewAccessibilityDelegateProcessor.a r10) {
        View r0 = r10.a();     // Catch: Exception -> L34
        if (r0 == null) goto L33;
        Boolean r1 = this.c.get(r0);     // Catch: Exception -> L34
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L11;
        com.bytedance.android.accessibilityLib_Core.processor.a r11 = this.e;     // Catch: Exception -> L34
        if (r11 == null) goto L46;
        r11.b(r0, r10.b, true);     // Catch: Exception -> L34
        return;
    L46:
        return;
    L11:
        if (Intrinsics.areEqual(r1, Boolean.FALSE) == false) goto L17;
        com.bytedance.android.accessibilityLib_Core.processor.a r12 = this.e;     // Catch: Exception -> L34
        if (r12 == null) goto L47;
        r12.b(r0, r10.b, false);     // Catch: Exception -> L34
        return;
    L47:
        return;
    L17:
        if (f(r0, LargeTouchAreaProcessor$shouldLargerTouchArea$1.INSTANCE) == false) goto L29;
        boolean r13 = e(this, r0);     // Catch: Exception -> L34
        com.bytedance.android.accessibilityLib_Core.processor.a r14 = this.e;     // Catch: Exception -> L34
        if (r14 == null) goto L21;
        r14.b(r0, r10.b, r13);     // Catch: Exception -> L34
    L21:
        WeakHashMap<View, Boolean> r15 = this.c;     // Catch: Exception -> L34
        monitor-enter(r15);     // Catch: Exception -> L34
        this.c.put(r0, Boolean.valueOf(r13));     // Catch: Throwable -> L26
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r15);     // Catch: Exception -> L34
        return;
    L26:
        th = move-exception;
        throw th;     // Catch: Exception -> L34
    L29:
        com.bytedance.android.accessibilityLib_Core.processor.a r17 = this.e;     // Catch: Exception -> L34
        if (r17 == null) goto L49;
        r17.b(r0, r10.b, false);     // Catch: Exception -> L34
        Unit r18 = Unit.INSTANCE;     // Catch: Exception -> L34
        return;
    L49:
        return;
    L33:
        return;
    L34:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L39;
        Context r19 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L39:
        if (("expandInternal fail, e = " + e.getMessage()) == null) goto L41;
        Context r20 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L41:
        Unit r21 = Unit.INSTANCE;
    }

    public a(k6.a r1, ViewAccessibilityDelegateProcessor r10) {
        this.d = r1;
        this.e = r10;
        this.a = new WeakHashMap();
        this.b = new Rect();
        this.c = new WeakHashMap();
    }

    public static boolean c(a r1, View r10) {
        LargeTouchAreaProcessor$canLargerTouch$1 r0 = LargeTouchAreaProcessor$canLargerTouch$1.INSTANCE;
        r1.getClass();
        return f(r10, r0);
    }

    public static boolean e(a r10, View r11) {
        int r0 = f;
        int r1 = g;
        r10.getClass();
        ViewParent r12 = r11.getParent();
    L4:
        if (r12 == null) goto L24;
        if ((r12 instanceof ViewGroup) == false) goto L23;
        View r13 = (View) r12;
        if (r13.getWidth() >= f) goto L10;
    L12:
        boolean r14 = false;
    L13:
        if (r14 == false) goto L23;
        if (r13.isClickable() == false) goto L17;
    L20:
        boolean r15 = true;
    L21:
        if (r15 == false) goto L23;
        ViewGroup r16 = (ViewGroup) r12;
    L25:
        if (r16 == null) goto L47;
        r16.getHitRect(r10.b);
        Rect r17 = new Rect();
        r11.getHitRect(r17);
        int r18 = RangesKt.coerceAtLeast((r0 - r17.width()) / 2, 0);
        int r19 = RangesKt.coerceAtLeast((r1 - r17.height()) / 2, 0);
        if (r18 != 0) goto L30;
        if (r19 == 0) goto L47;
    L30:
        if (r18 <= 0) goto L32;
        r17.left = RangesKt.coerceAtLeast(r17.left - r18, r10.b.left);
        r17.right = RangesKt.coerceAtMost(r17.right + r18, r10.b.right);
    L32:
        if (r19 <= 0) goto L34;
        r17.top = RangesKt.coerceAtLeast(r17.top - r19, r10.b.top);
        r17.bottom = RangesKt.coerceAtMost(r17.bottom + r19, r10.b.bottom);
    L34:
        TouchDelegate r20 = new TouchDelegate(r17, r11);
        WeakReference<TouchDelegateComposite> r21 = r10.a.get(r16);
        if (r21 == null) goto L39;
        TouchDelegateComposite r22 = r21.get();
        if (r22 == null) goto L39;
        r16.setTouchDelegate(r22);
        r22.a.put(new WeakReference(r11), r20);
        return true;
    L39:
        Rect r23 = new Rect();
        r16.getHitRect(r23);
        TouchDelegateComposite r24 = new TouchDelegateComposite(r16, r23);
        WeakHashMap<View, WeakReference<TouchDelegateComposite>> r25 = r10.a;
        monitor-enter(r25);
        r10.a.put(r16, new WeakReference(r24));     // Catch: Throwable -> L44
        Unit r26 = Unit.INSTANCE;     // Catch: Throwable -> L44
        monitor-exit(r25);
        r16.setTouchDelegate(r24);
        r24.a.put(new WeakReference(r11), r20);
        return true;
    L44:
        th = move-exception;
        throw th;
    L47:
        return false;
    L17:
        if (r13.isLongClickable() == true) goto L20;
        r15 = false;
        goto L21
    L10:
        if (r13.getHeight() < g) goto L12;
        r14 = true;
    L23:
        r12 = r12.getParent();
        goto L4
    L24:
        r16 = null;
        goto L25
    }

    public static boolean f(View r10, Function0 r11) {
        if (r10.isClickable() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
    L75:
        return false;
    L11:
        if (r10.getWidth() != 0) goto L13;
    L20:
        boolean r1 = false;
    L21:
        if (r1 == false) goto L75;
    L33:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L37;
        Context r12 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L37:
        boolean r13 = false;
    L38:
        if (r13 == false) goto L75;
        Object r14 = r10;
    L41:
        if ((r14 instanceof View) == false) goto L49;
        View r15 = (View) r14;
        if (r15.getAlpha() <= 0.0f) goto L48;
        if (r15.getVisibility() != 0) goto L48;
        r14 = r15.getParent();
    L48:
        boolean r16 = false;
    L50:
        if (r16 == true) goto L52;
    L70:
        boolean r17 = false;
    L71:
        if (r17 == false) goto L75;
        if (((Boolean) r11.invoke()).booleanValue() == false) goto L75;
        return true;
    L52:
        if (r10.isImportantForAccessibility() == false) goto L70;
        if (com.bytedance.android.accessibilityLib_Core.util.a.d(r10) == false) goto L66;
        boolean r18 = r10 instanceof ViewGroup;
        if (r18 == false) goto L69;
        if (r18 == false) goto L63;
        if (com.bytedance.android.accessibilityLib_Core.util.a.a((ViewGroup) r10) == false) goto L69;
    L63:
        if (com.bytedance.android.accessibilityLib_Core.util.a.e(r10) == false) goto L70;
    L69:
        r17 = true;
        goto L71
    L66:
        if (com.bytedance.android.accessibilityLib_Core.util.a.c(r10) == false) goto L70;
        if (com.bytedance.android.accessibilityLib_Core.util.a.b(r10) == true) goto L70;
    L49:
        r16 = r10.getGlobalVisibleRect(new Rect());
        goto L50
    L23:
        if ((r10 instanceof ViewGroup) == false) goto L32;
        CharSequence r19 = ((ViewGroup) r10).getContentDescription();     // Catch: Exception -> L33
        if (r19 == null) goto L30;
        if (r19.length() == 0) goto L30;
        boolean r20 = false;
    L31:
        if (r20 == true) goto L37;
    L30:
        r20 = true;
    L32:
        r13 = true;
        goto L38
    L13:
        if (r10.getHeight() == 0) goto L20;
        if (r10.getWidth() >= f) goto L20;
        if (r10.getHeight() >= g) goto L20;
        r1 = true;
        goto L21
    L5:
        if (r10.isLongClickable() == true) goto L8;
        r0 = false;
        goto L9
    }

    @Override // com.bytedance.android.accessibilityLib_Core.processor.a
    public final void a(WeakReference<View> r10, h r11) {
        com.bytedance.android.accessibilityLib_Core.processor.a r0 = this.e;
        if (r0 == null) goto L6;
        r0.a(r10, r11);
        return;
    }

    @Override // com.bytedance.android.accessibilityLib_Core.processor.a
    public final void b(View r10, int r11, boolean r12) {
    L19:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L23;
        Context r13 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
    L23:
        Context r14 = com.bytedance.android.accessibilityLib_Core.helper.a.a;
        Unit r15 = Unit.INSTANCE;
        return;
    L4:
        if (("[[LargeTouchAreaProcessor]]>>>consumeViewDirectly,view = " + r10) == null) goto L6;
        Context r16 = com.bytedance.android.accessibilityLib_Core.helper.a.a;     // Catch: Exception -> L19
    L6:
        int r17 = r10.getWidth();     // Catch: Exception -> L19
        int r0 = r10.getHeight();     // Catch: Exception -> L19
        if (r17 <= 0) goto L15;
        if (r0 <= 0) goto L15;
        if (f(r10, LargeTouchAreaProcessor$shouldLargerTouchArea$1.INSTANCE) == false) goto L12;
        d(this.d.a(r10, r11));     // Catch: Exception -> L19
        Unit r18 = Unit.INSTANCE;     // Catch: Exception -> L19
        return;
    L12:
        com.bytedance.android.accessibilityLib_Core.processor.a r19 = this.e;     // Catch: Exception -> L19
        if (r19 == null) goto L27;
        r19.b(r10, r11, false);     // Catch: Exception -> L19
        Unit r20 = Unit.INSTANCE;     // Catch: Exception -> L19
        return;
    L27:
        return;
    L15:
        com.bytedance.android.accessibilityLib_Core.processor.a r21 = this.e;     // Catch: Exception -> L19
        if (r21 == null) goto L29;
        r21.b(r10, r11, false);     // Catch: Exception -> L19
        Unit r22 = Unit.INSTANCE;     // Catch: Exception -> L19
        return;
    }
}
