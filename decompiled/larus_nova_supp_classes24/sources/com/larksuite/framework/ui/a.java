package com.larksuite.framework.ui;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.larksuite.component.decoration.avatar.DecoratedAvatar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends TouchDelegate {
    public static final Rect b = null;
    public final LinkedHashMap<Integer, TouchDelegate> a;

    /* JADX INFO: renamed from: com.larksuite.framework.ui.a$a, reason: collision with other inner class name */
    public static final class C0052a {

        /* JADX INFO: renamed from: com.larksuite.framework.ui.a$a$a, reason: collision with other inner class name */
        public static final class ViewOnLayoutChangeListenerC0053a implements View.OnLayoutChangeListener {
            public final /* synthetic */ View a;
            public final /* synthetic */ View b;
            public final /* synthetic */ int c;

            public ViewOnLayoutChangeListenerC0053a(View r1, View r2, int r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                r1.removeOnLayoutChangeListener(this);
                if (this.a.getTouchDelegate() != null) goto L5;
                this.a.setTouchDelegate(new a(this.a));
            L5:
                TouchDelegate r10 = this.a.getTouchDelegate();
                if ((r10 instanceof a) == false) goto L8;
                a r11 = (a) r10;
            L9:
                if (r11 == null) goto L13;
                Rect r12 = new Rect();
                this.b.getHitRect(r12);
                int r13 = r12.left;
                int r14 = this.c;
                r12.left = r13 - r14;
                r12.top -= r14;
                r12.right += r14;
                r12.bottom += r14;
                View r15 = this.b;
                TouchDelegate r16 = new TouchDelegate(r12, this.b);
                Intrinsics.checkNotNullParameter(r15, "view");
                Intrinsics.checkNotNullParameter(r16, "delegate");
                r11.a.put(Integer.valueOf(r15.hashCode()), r16);
                return;
            L13:
                return;
            L8:
                r11 = null;
                goto L9
            }
        }

        public static void b(DecoratedAvatar r3) {
            Intrinsics.checkNotNullParameter(r3, "<this>");
            Object r0 = r3.getParent();
            a r2 = null;
            if ((r0 instanceof View) == false) goto L5;
            View r1 = (View) r0;
        L6:
            if (r1 != null) goto L8;
            return;
        L8:
            TouchDelegate r4 = r1.getTouchDelegate();
            if ((r4 instanceof a) == false) goto L11;
            r2 = (a) r4;
        L11:
            if (r2 == null) goto L14;
            Intrinsics.checkNotNullParameter(r3, "view");
            r2.a.remove(Integer.valueOf(r3.hashCode()));
            return;
        L14:
            return;
        L5:
            r1 = null;
            goto L6
        }

        public static void a(View r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "<this>");
            Object r0 = r3.getParent();
            a r2 = null;
            if ((r0 instanceof View) == false) goto L5;
            View r1 = (View) r0;
        L6:
            if (r1 != null) goto L9;
            return;
        L9:
            if (r3.isLaidOut() == true) goto L11;
        L21:
            r3.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0053a(r1, r3, r4));
            return;
        L11:
            if (r3.isLayoutRequested() == true) goto L21;
            if (r1.getTouchDelegate() != null) goto L15;
            r1.setTouchDelegate(new a(r1));
        L15:
            TouchDelegate r5 = r1.getTouchDelegate();
            if ((r5 instanceof a) == false) goto L18;
            r2 = (a) r5;
        L18:
            if (r2 == null) goto L24;
            Rect r6 = new Rect();
            r3.getHitRect(r6);
            r6.left -= r4;
            r6.top -= r4;
            r6.right += r4;
            r6.bottom += r4;
            TouchDelegate r7 = new TouchDelegate(r6, r3);
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r7, "delegate");
            r2.a.put(Integer.valueOf(r3.hashCode()), r7);
            return;
        L24:
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
        b = new Rect();
    }

    public a(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(b, r2);
        this.a = new LinkedHashMap();
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        float r0 = r5.getX();
        float r1 = r5.getY();
        Iterator<TouchDelegate> r2 = this.a.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        TouchDelegate r3 = r2.next();
        r5.setLocation(r0, r1);
        if (r3.onTouchEvent(r5) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchExplorationHoverEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        float r0 = r5.getX();
        float r1 = r5.getY();
        Iterator<TouchDelegate> r2 = this.a.values().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        TouchDelegate r3 = r2.next();
        r5.setLocation(r0, r1);
        if (r3.onTouchExplorationHoverEvent(r5) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
