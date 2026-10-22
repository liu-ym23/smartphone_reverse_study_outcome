package j0;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.obric.cae.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f8369c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f8370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0095a f8371b;

    /* JADX INFO: renamed from: j0.a$a, reason: collision with other inner class name */
    public static final class C0095a extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f8372a;

        public C0095a(a r8) {
            this.f8372a = r8;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean dispatchPopulateAccessibilityEvent(View r8, AccessibilityEvent r10) {
            return this.f8372a.a(r8, r10);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final AccessibilityNodeProvider getAccessibilityNodeProvider(View r8) {
            k0.g r10 = this.f8372a.b(r8);
            if (r10 != null) goto L7;
            return null;
        L7:
            return (AccessibilityNodeProvider) r10.f8907a;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityEvent(View r8, AccessibilityEvent r10) {
            this.f8372a.c(r8, r10);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityNodeInfo(View r8, AccessibilityNodeInfo r10) {
            k0.f r11 = new k0.f(r10);
            WeakHashMap<View, h0> r12 = w.f8437a;
            Boolean r13 = new s().d(r8);
            boolean r14 = true;
            int r15 = 0;
            if (r13 != null) goto L5;
        L7:
            boolean r16 = false;
        L8:
            r10.setScreenReaderFocusable(r16);
            Boolean r17 = new v().d(r8);
            if (r17 != null) goto L11;
        L13:
            r14 = false;
        L14:
            r10.setHeading(r14);
            r10.setPaneTitle(w.c(r8));
            r10.setStateDescription(new u().d(r8));
            this.f8372a.d(r8, r11);
            r10.getText();
            List r18 = (List) r8.getTag(R.id.tag_accessibility_actions);
            if (r18 != null) goto L18;
            r18 = Collections.emptyList();
        L18:
            if (r15 >= r18.size()) goto L20;
            r11.b((k0.f.a) r18.get(r15));
            r15 = r15 + 1;
            goto L18
        L20:
            return;
        L11:
            if (r17.booleanValue() == false) goto L13;
        L5:
            if (r13.booleanValue() == false) goto L7;
            r16 = true;
            goto L8
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onPopulateAccessibilityEvent(View r8, AccessibilityEvent r10) {
            this.f8372a.e(r8, r10);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean onRequestSendAccessibilityEvent(ViewGroup r8, View r10, AccessibilityEvent r11) {
            return this.f8372a.f(r8, r10, r11);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final boolean performAccessibilityAction(View r8, int r10, Bundle r11) {
            return this.f8372a.g(r8, r10, r11);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void sendAccessibilityEvent(View r8, int r10) {
            this.f8372a.h(r8, r10);
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void sendAccessibilityEventUnchecked(View r8, AccessibilityEvent r10) {
            this.f8372a.i(r8, r10);
        }
    }

    public static class b {
        public static AccessibilityNodeProvider a(View.AccessibilityDelegate r8, View r10) {
            return r8.getAccessibilityNodeProvider(r10);
        }

        public static boolean b(View.AccessibilityDelegate r8, View r10, int r11, Bundle r12) {
            return r8.performAccessibilityAction(r10, r11, r12);
        }
    }

    static {
        f8369c = new View.AccessibilityDelegate();
    }

    public a() {
        this(f8369c);
    }

    public boolean a(View r8, AccessibilityEvent r10) {
        return this.f8370a.dispatchPopulateAccessibilityEvent(r8, r10);
    }

    public k0.g b(View r8) {
        AccessibilityNodeProvider r10 = b.a(this.f8370a, r8);
        if (r10 != null) goto L5;
        return null;
    L5:
        return new k0.g(r10);
    }

    public void c(View r8, AccessibilityEvent r10) {
        this.f8370a.onInitializeAccessibilityEvent(r8, r10);
    }

    public void d(View r8, k0.f r10) {
        AccessibilityNodeInfo r11 = r10.f8890a;
        this.f8370a.onInitializeAccessibilityNodeInfo(r8, r11);
    }

    public void e(View r8, AccessibilityEvent r10) {
        this.f8370a.onPopulateAccessibilityEvent(r8, r10);
    }

    public boolean f(ViewGroup r8, View r10, AccessibilityEvent r11) {
        return this.f8370a.onRequestSendAccessibilityEvent(r8, r10, r11);
    }

    public boolean g(View r8, int r10, Bundle r11) {
        List r12 = (List) r8.getTag(R.id.tag_accessibility_actions);
        if (r12 != null) goto L5;
        r12 = Collections.emptyList();
    L5:
        boolean r13 = false;
        int r14 = 0;
    L7:
        if (r14 >= r12.size()) goto L20;
        k0.f.a r15 = (k0.f.a) r12.get(r14);
        if (r15.a() == r10) goto L10;
        r14 = r14 + 1;
        goto L7
    L10:
        k0.j r16 = r15.f8904d;
        if (r16 == null) goto L20;
        Class<? extends k0.j.a> r17 = r15.f8903c;
        if (r17 != null) goto L50;
    L18:
        boolean r18 = r16.a(r8);
    L21:
        if (r18 == true) goto L23;
        r18 = b.b(this.f8370a, r8, r10, r11);
    L23:
        if (r18 == false) goto L25;
        return r18;
    L25:
        if (r10 != R.id.accessibility_action_clickable_span) goto L58;
        if (r11 == null) goto L59;
        int r19 = r11.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray r20 = (SparseArray) r8.getTag(R.id.tag_accessibility_clickable_spans);
        if (r20 == null) goto L49;
        WeakReference r21 = (WeakReference) r20.get(r19);
        if (r21 == null) goto L49;
        ClickableSpan r22 = (ClickableSpan) r21.get();
        if (r22 == null) goto L45;
        CharSequence r23 = r8.createAccessibilityNodeInfo().getText();
        if ((r23 instanceof Spanned) == false) goto L36;
        ClickableSpan[] r24 = (ClickableSpan[]) ((Spanned) r23).getSpans(0, r23.length(), ClickableSpan.class);
    L37:
        int r25 = 0;
    L38:
        if (r24 == null) goto L45;
        if (r25 >= r24.length) goto L45;
        if (r22.equals(r24[r25]) == true) goto L43;
        r25 = r25 + 1;
        goto L38
    L43:
        boolean r26 = true;
    L46:
        if (r26 == false) goto L49;
        r22.onClick(r8);
        r13 = true;
        goto L49
    L36:
        r24 = null;
    L45:
        r26 = false;
    L49:
        return r13;
    L59:
        return r18;
    L58:
        return r18;
    L50:
        r17.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]).getClass();     // Catch: Exception -> L16
    L16:
        e = move-exception;
        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(r17.getName()), e);
    L20:
        r18 = false;
        goto L21
    }

    public void h(View r8, int r10) {
        this.f8370a.sendAccessibilityEvent(r8, r10);
    }

    public void i(View r8, AccessibilityEvent r10) {
        this.f8370a.sendAccessibilityEventUnchecked(r8, r10);
    }

    public a(View.AccessibilityDelegate r8) {
        this.f8370a = r8;
        this.f8371b = new C0095a(this);
    }
}
