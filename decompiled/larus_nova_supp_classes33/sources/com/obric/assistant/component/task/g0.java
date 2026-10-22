package com.obric.assistant.component.task;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class g0 {
    public static final /* synthetic */ int a = 0;

    public static final class a extends TouchDelegate {
        public final Rect a;
        public final Rect b;
        public final View c;
        public boolean d;
        public final Rect e;
        public final int f;

        @Override // android.view.TouchDelegate
        public final boolean onTouchEvent(MotionEvent r8) {
            Intrinsics.checkNotNullParameter(r8, "event");
            if (8 != this.c.getVisibility()) goto L6;
            return false;
        L6:
            if (this.c.isEnabled() == true) goto L8;
            return false;
        L8:
            this.c.getHitRect(this.a);
            Rect r0 = this.a;
            int r2 = r0.left;
            Rect r3 = this.b;
            r0.left = r2 - r3.left;
            r0.top -= r3.top;
            r0.right += r3.right;
            r0.bottom += r3.bottom;
            this.e.set(r0);
            Rect r1 = this.e;
            int r4 = this.f;
            r1.inset(-r4, -r4);
            int r5 = (int) r8.getX();
            int r6 = (int) r8.getY();
            int r7 = r8.getAction();
            boolean r9 = true;
            if (r7 == 0) goto L24;
            if (r7 == 1) goto L16;
            if (r7 == 2) goto L16;
            if (r7 != 3) goto L26;
            boolean r10 = this.d;
            this.d = false;
            r9 = r10;
        L22:
            boolean r11 = true;
        L27:
            if (r9 == false) goto L34;
            View r12 = this.c;
            if (r11 == false) goto L31;
            r8.setLocation(r12.getWidth() / 2, r12.getHeight() / 2);
        L33:
            return r12.dispatchTouchEvent(r8);
        L31:
            float r13 = -(this.f * 2);
            r8.setLocation(r13, r13);
            goto L33
        L34:
            return false;
        L26:
            r11 = true;
            r9 = false;
        L16:
            boolean r14 = this.d;
            if (r14 == true) goto L19;
        L21:
            r9 = r14;
            goto L22
        L19:
            if (this.e.contains(r5, r6) == true) goto L21;
            r9 = r14;
            r11 = false;
            goto L27
        L24:
            if (this.a.contains(r5, r6) == false) goto L26;
            this.d = true;
            goto L22
        }

        public a(SimpleDraweeView r2, Rect r3) {
            Intrinsics.checkNotNullParameter(r2, "delegateView");
            Intrinsics.checkNotNullParameter(r3, "mExpandBounds");
            Rect r0 = new Rect();
            super(r0, r2);
            this.a = r0;
            this.b = r3;
            this.c = r2;
            this.e = new Rect(r0);
            this.f = ViewConfiguration.get(r2.getContext()).getScaledTouchSlop();
        }
    }

    public static final class b extends TouchDelegate {
        public static final Rect c = null;
        public final List<a> a;
        public a b;

        public static final class a {
        }

        static {
            c = new Rect();
        }

        public b(SimpleDraweeView r2) {
            super(c, r2);
            this.a = new LinkedList();
        }

        @Override // android.view.TouchDelegate
        public final boolean onTouchEvent(MotionEvent r7) {
            Intrinsics.checkNotNullParameter(r7, "event");
            int r0 = r7.getAction();
            a r3 = null;
            if (r0 == 0) goto L12;
            if (r0 != 1) goto L6;
        L11:
            a r1 = this.b;
            this.b = null;
            r3 = r1;
        L20:
            if (r3 != null) goto L22;
            return false;
        L22:
            if (r3.onTouchEvent(r7) == false) goto L28;
            return true;
        L28:
            return false;
        L6:
            if (r0 != 2) goto L8;
            r3 = this.b;
            goto L20
        L8:
            if (r0 == 3) goto L11;
        L12:
            int r2 = 0;
        L14:
            if (r2 >= ((LinkedList) this.a).size()) goto L20;
            a r4 = (a) ListProtector.get(this.a, r2);
            if (r4.onTouchEvent(r7) == true) goto L17;
            r2 = r2 + 1;
            goto L14
        L17:
            this.b = r4;
            return true;
        }
    }

    static {
    }
}
