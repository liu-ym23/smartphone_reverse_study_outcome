package com.bytedance.android.live.profile.ui.util;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import com.bytedance.common.utility.UIUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class v extends TouchDelegate {
    public static final a b = null;
    public final List<TouchDelegate> a;

    public static final class a {
        public a() {
        }

        public static void a(View r5, View r6, int r7, int r8, int r9, int r10) {
            Intrinsics.checkNotNullParameter(r5, "$this$addTouchDelegateToAncestor");
            if (r6 == null) goto L46;
            Intrinsics.checkNotNullParameter(r5, "delegateView");
            Intrinsics.checkNotNullParameter(r6, "ancestorView");
            View r0 = r5;
        L5:
            Object r1 = r0.getParent();
            int r2 = 0;
            if (r1 == r6) goto L7;
            if ((r1 instanceof View) == false) goto L11;
            r0 = (View) r1;
            goto L5
        L11:
            boolean r3 = false;
        L12:
            if (r3 == false) goto L49;
            int[] r4 = UIUtils.getLocationInAncestor(r5, r6);
            if (r4 != null) goto L17;
            return;
        L17:
            Rect r12 = new Rect();
            if (ArraysKt.getLastIndex(r4) < 0) goto L20;
            int r13 = r4[0];
        L21:
            r12.left = r13 - r7;
            if (1 > ArraysKt.getLastIndex(r4)) goto L24;
            int r14 = r4[1];
        L25:
            r12.top = r14 - r8;
            if (ArraysKt.getLastIndex(r4) < 0) goto L28;
            int r15 = r4[0];
        L29:
            r12.right = (r15 + r5.getWidth()) + r9;
            if (1 > ArraysKt.getLastIndex(r4)) goto L32;
            r2 = r4[1];
        L32:
            r12.bottom = (r2 + r5.getHeight()) + r10;
            TouchDelegate r16 = new TouchDelegate(r12, r5);
            Intrinsics.checkNotNullParameter(r6, "$this$addTouchDelegate");
            Intrinsics.checkNotNullParameter(r16, "touchDelegateVal");
            Rect r17 = new Rect();
            TouchDelegate r18 = r6.getTouchDelegate();
            if ((r18 instanceof v) == false) goto L40;
            TouchDelegate r19 = r6.getTouchDelegate();
            if (r19 == null) goto L38;
            ((v) r19).a(r16);
            return;
        L38:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.profile.ui.util.TouchDelegateComposite");
        L40:
            if ((r18 instanceof TouchDelegate) == false) goto L42;
            v r20 = new v(r17, r6);
            r20.a(r6.getTouchDelegate());
            r20.a(r16);
            r6.setTouchDelegate(r20);
            return;
        L42:
            v r22 = new v(r17, r6);
            r22.a(r16);
            r6.setTouchDelegate(r22);
            return;
        L28:
            r15 = 0;
            goto L29
        L24:
            r14 = 0;
            goto L25
        L20:
            r13 = 0;
            goto L21
        L49:
            return;
        L7:
            r3 = true;
            goto L12
        }
    }

    static {
        b = new a();
    }

    public final void a(TouchDelegate r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        ((ArrayList) this.a).add(r2);
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        float r0 = r7.getX();
        float r1 = r7.getY();
        Iterator r2 = ((ArrayList) this.a).iterator();
    L3:
        boolean r4 = false;
    L5:
        if (r2.hasNext() == false) goto L10;
        TouchDelegate r5 = (TouchDelegate) r2.next();
        r7.setLocation(r0, r1);
        if (r5.onTouchEvent(r7) == true) goto L9;
        if (r4 == false) goto L3;
    L9:
        r4 = true;
        goto L5
    L10:
        return r4;
    }

    public v(Rect r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "bounds");
        Intrinsics.checkNotNullParameter(r3, "delegateView");
        super(r2, r3);
        this.a = new ArrayList();
    }
}
