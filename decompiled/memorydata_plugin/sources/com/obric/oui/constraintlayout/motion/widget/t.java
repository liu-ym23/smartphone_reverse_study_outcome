package com.obric.oui.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<s.a> f13719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<s.a> f13720b;
    private final MotionLayout c;
    private ArrayList<s> d;
    private HashSet<View> e;
    private String f;

    public t(MotionLayout r2) {
        this.d = new ArrayList();
        this.f = "ViewTransitionController";
        this.f13720b = new ArrayList();
        this.c = r2;
    }

    private void a(final s r10, final boolean r11) {
        final int r3 = r10.c();
        final int r5 = r10.b();
        ConstraintLayout.getSharedValues().a(r10.c(), new AnonymousClass1(this, r10, r3, r11, r5));
    }

    private void a(s r8, View... r9) {
        int r4 = this.c.getCurrentState();
        if (r8.f13713a != 2) goto L5;
        r8.a(this, this.c, r4, null, r9);
        return;
    L5:
        if (r4 != (-1)) goto L8;
        Log.w(this.f, "No support for ViewTransition within transition yet. Currently: " + this.c.toString());
        return;
    L8:
        com.obric.oui.constraintlayout.widget.b r5 = this.c.getConstraintSet(r4);
        if (r5 != null) goto L11;
        return;
    L11:
        r8.a(this, this.c, r4, r5, r9);
    }

    void a() {
        ArrayList<s.a> r0 = this.f13719a;
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<s.a> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((s.a) ZeusTransformUtils.preCheckCast(r1.next(), s.a.class, "com.obric.memorydata.plugin")).a();
        goto L7
    L9:
        this.f13719a.removeAll(this.f13720b);
        this.f13720b.clear();
        if (this.f13719a.isEmpty() == false) goto L14;
        this.f13719a = null;
        return;
    }

    void a(int r4, boolean r5) {
        Iterator<s> r3 = this.d.iterator();
    L4:
        if (r3.hasNext() == false) goto L12;
        s r0 = (s) ZeusTransformUtils.preCheckCast(r3.next(), s.class, "com.obric.memorydata.plugin");
        if (r0.d() != r4) goto L4;
        r0.a(r5);
        return;
    }

    void a(int r10, View... r11) {
        ArrayList r0 = new ArrayList();
        Iterator<s> r1 = this.d.iterator();
        s r2 = null;
    L4:
        if (r1.hasNext() == false) goto L17;
        s r3 = (s) ZeusTransformUtils.preCheckCast(r1.next(), s.class, "com.obric.memorydata.plugin");
        if (r3.d() != r10) goto L4;
        int r4 = r11.length;
        int r6 = 0;
    L8:
        if (r6 >= r4) goto L14;
        View r7 = r11[r6];
        if (r3.b(r7) == false) goto L12;
        r0.add(r7);
    L12:
        r6 = r6 + 1;
        goto L8
    L14:
        if (r0.isEmpty() == true) goto L16;
        a(r3, (View[]) ZeusTransformUtils.preCheckCast(r0.toArray(new View[0]), View[].class, "com.obric.memorydata.plugin"));
        r0.clear();
    L16:
        r2 = r3;
        goto L4
    L17:
        if (r2 != null) goto L28;
        Log.e(this.f, " Could not find ViewTransition");
        return;
    }

    void a(MotionEvent r21) {
        int r7 = this.c.getCurrentState();
        if (r7 != (-1)) goto L6;
        return;
    L6:
        if (this.e != null) goto L16;
        this.e = new HashSet();
        Iterator<s> r0 = this.d.iterator();
    L9:
        if (r0.hasNext() == false) goto L16;
        s r1 = (s) ZeusTransformUtils.preCheckCast(r0.next(), s.class, "com.obric.memorydata.plugin");
        int r2 = this.c.getChildCount();
        int r3 = 0;
    L11:
        if (r3 >= r2) goto L9;
        View r4 = this.c.getChildAt(r3);
        if (r1.a(r4) == false) goto L15;
        r4.getId();
        this.e.add(r4);
    L15:
        r3 = r3 + 1;
    L16:
        float r10 = r21.getX();
        float r11 = r21.getY();
        Rect r12 = new Rect();
        int r13 = r21.getAction();
        ArrayList<s.a> r5 = this.f13719a;
        if (r5 == null) goto L25;
        if (r5.isEmpty() == true) goto L25;
        Iterator<s.a> r6 = this.f13719a.iterator();
    L22:
        if (r6.hasNext() == false) goto L25;
        ((s.a) ZeusTransformUtils.preCheckCast(r6.next(), s.a.class, "com.obric.memorydata.plugin")).a(r13, r10, r11);
    L25:
        if (r13 == 0) goto L28;
        if (r13 == 1) goto L28;
        return;
    L28:
        com.obric.oui.constraintlayout.widget.b r15 = this.c.getConstraintSet(r7);
        Iterator<s> r16 = this.d.iterator();
    L30:
        if (r16.hasNext() == false) goto L59;
        s r8 = (s) ZeusTransformUtils.preCheckCast(r16.next(), s.class, "com.obric.memorydata.plugin");
        if (r8.a(r13) == false) goto L30;
        Iterator<View> r17 = this.e.iterator();
    L35:
        if (r17.hasNext() == false) goto L30;
        View r9 = (View) ZeusTransformUtils.preCheckCast(r17.next(), View.class, "com.obric.memorydata.plugin");
        if (r8.a(r9) == false) goto L35;
        r9.getHitRect(r12);
        if (r12.contains((int) r10, (int) r11) == false) goto L43;
        r8.a(this, this.c, r7, r15, new View[]{r9});
    L43:
        r8 = r8;
        goto L35
    }

    void a(s.a r2) {
        if (this.f13719a != null) goto L5;
        this.f13719a = new ArrayList();
    L5:
        this.f13719a.add(r2);
    }

    public void a(s r3) {
        this.d.add(r3);
        this.e = null;
        if (r3.a() != 4) goto L7;
        boolean r0 = true;
    L5:
        a(r3, r0);
        return;
    L7:
        if (r3.a() != 5) goto L10;
        r0 = false;
        goto L5
    }

    boolean a(int r4) {
        Iterator<s> r3 = this.d.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        s r0 = (s) ZeusTransformUtils.preCheckCast(r3.next(), s.class, "com.obric.memorydata.plugin");
        if (r0.d() != r4) goto L4;
        return r0.e();
    L9:
        return false;
    }

    boolean a(int r4, m r5) {
        Iterator<s> r3 = this.d.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        s r0 = (s) ZeusTransformUtils.preCheckCast(r3.next(), s.class, "com.obric.memorydata.plugin");
        if (r0.d() != r4) goto L4;
        r0.f13714b.a(r5);
        return true;
    L9:
        return false;
    }

    void b() {
        this.c.invalidate();
    }

    void b(s.a r1) {
        this.f13720b.add(r1);
    }
}
