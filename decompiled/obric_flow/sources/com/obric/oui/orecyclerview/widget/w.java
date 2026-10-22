package com.obric.oui.orecyclerview.widget;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13924b;

    public /* synthetic */ w(Object r5, int r10) {
        this.f13923a = r10;
        this.f13924b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float r5 = 0.0f;
        Object r10 = this.f13924b;
        switch(this.f13923a) {
            case 0: goto L53;
            case 1: goto L11;
            default: goto L4;
        };
    L4:
        l r11 = (l) r10;
        int r12 = r11.A;
        ValueAnimator r13 = r11.f13866z;
        if (r12 == 1) goto L8;
        if (r12 != 2) goto L67;
    L9:
        r11.A = 3;
        r13.setFloatValues(new float[]{((Float) r13.getAnimatedValue()).floatValue(), 0.0f});
        r13.setDuration(500);
        r13.start();
        return;
    L67:
        return;
    L8:
        r13.cancel();
        goto L9
    L11:
        RecyclerView r14 = (RecyclerView) r10;
        g0 r15 = r14.H;
        if (r15 == null) goto L51;
        i r16 = (i) r15;
        ArrayList r17 = r16.f13821h;
        boolean r18 = r17.isEmpty();
        ArrayList r19 = r16.f13823j;
        boolean r110 = r19.isEmpty();
        ArrayList r111 = r16.f13824k;
        boolean r112 = r111.isEmpty();
        ArrayList r113 = r16.f13822i;
        boolean r114 = r113.isEmpty();
        if (r18 == false) goto L19;
        if (r110 == false) goto L19;
        if (r114 == false) goto L19;
        if (r112 == true) goto L51;
    L19:
        Iterator r115 = r17.iterator();
    L20:
        boolean r20 = r115.hasNext();
        long r21 = r16.d;
        if (r20 == false) goto L23;
        x0 r22 = (x0) r115.next();
        View r23 = r22.itemView;
        ViewPropertyAnimator r24 = r23.animate();
        r16.f13830q.add(r22);
        r24.setDuration(r21).alpha(r5).setInterpolator(i.f13820t).setListener(new d(r16, r22, r23, r24, 0)).start();
        r111 = r111;
        r113 = r113;
        r5 = 0.0f;
        goto L20
    L23:
        ArrayList r25 = r113;
        ArrayList r26 = r111;
        r17.clear();
        if (r110 == true) goto L29;
        ArrayList r27 = new ArrayList();
        r27.addAll(r19);
        r16.f13826m.add(r27);
        r19.clear();
        c r28 = new c(r16, r27, 0);
        if (r18 == true) goto L28;
        ViewCompat.postOnAnimationDelayed(((h) r27.get(0)).f13817a.itemView, r28, r21);
        goto L29
    L28:
        r28.run();
    L29:
        if (r112 == true) goto L34;
        ArrayList r29 = new ArrayList();
        r29.addAll(r26);
        r16.f13827n.add(r29);
        r26.clear();
        c r30 = new c(r16, r29, 1);
        if (r18 == true) goto L33;
        ViewCompat.postOnAnimationDelayed(((g) r29.get(0)).f13811a.itemView, r30, r21);
        goto L34
    L33:
        r30.run();
    L34:
        if (r114 == true) goto L51;
        ArrayList r31 = new ArrayList();
        r31.addAll(r25);
        r16.f13825l.add(r31);
        r25.clear();
        c r32 = new c(r16, r31, 2);
        if (r18 == false) goto L41;
        if (r110 == false) goto L41;
        if (r112 == false) goto L41;
        r32.run();
    L41:
        long r33 = 0;
        if (r18 == false) goto L45;
        r21 = 0;
    L45:
        if (r110 == true) goto L47;
        long r34 = r16.e;
    L48:
        if (r112 == true) goto L50;
        r33 = r16.f;
    L50:
        ViewCompat.postOnAnimationDelayed(((x0) r31.get(0)).itemView, r32, Math.max(r34, r33) + r21);
        goto L51
    L47:
        r34 = 0;
    L51:
        r14.f13736h0 = false;
        return;
    L53:
        RecyclerView r35 = (RecyclerView) r10;
        if (r35.f13756t == true) goto L56;
        return;
    L56:
        if (r35.isLayoutRequested() == false) goto L59;
        return;
    L59:
        if (r35.f13753r == true) goto L62;
        r35.requestLayout();
        return;
    L62:
        if (r35.f13762w == false) goto L64;
        r35.f13760v = true;
        return;
    L64:
        r35.n();
    }
}
