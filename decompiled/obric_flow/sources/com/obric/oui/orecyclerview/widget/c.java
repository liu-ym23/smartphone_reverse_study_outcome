package com.obric.oui.orecyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f13795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f13796c;

    public /* synthetic */ c(i r5, ArrayList r10, int r11) {
        this.f13794a = r11;
        this.f13796c = r5;
        this.f13795b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f13794a) {
            case 0: goto L30;
            case 1: goto L10;
            default: goto L4;
        };
    L4:
        ArrayList r5 = this.f13795b;
        Iterator r10 = r5.iterator();
    L5:
        boolean r11 = r10.hasNext();
        i r12 = this.f13796c;
        if (r11 == false) goto L8;
        x0 r13 = (x0) r10.next();
        r12.getClass();
        View r14 = r13.itemView;
        ViewPropertyAnimator r15 = r14.animate();
        r12.f13828o.add(r13);
        r15.alpha(1.0f).setDuration(r12.f13816c).setInterpolator(i.f13820t).setListener(new d(r12, r13, r14, r15, 1)).start();
        goto L5
    L8:
        r5.clear();
        r12.f13825l.remove(r5);
        return;
    L10:
        ArrayList r16 = this.f13795b;
        Iterator r17 = r16.iterator();
    L11:
        boolean r18 = r17.hasNext();
        i r19 = this.f13796c;
        if (r18 == false) goto L28;
        g r20 = (g) r17.next();
        r19.getClass();
        x0 r21 = r20.f13811a;
        if (r21 != null) goto L16;
        View r22 = null;
    L17:
        x0 r23 = r20.f13812b;
        if (r23 == null) goto L20;
        View r110 = r23.itemView;
    L21:
        ArrayList r111 = r19.f13831r;
        long r112 = r19.f;
        if (r22 == null) goto L25;
        ViewPropertyAnimator r24 = r22.animate().setDuration(r112);
        r111.add(r20.f13811a);
        r24.translationX(r20.e - r20.f13813c);
        r24.translationY(r20.f - r20.d);
        r24.alpha(0.0f).setListener(new f(r19, r20, r24, r22, 0)).start();
    L25:
        if (r110 == null) goto L27;
        ViewPropertyAnimator r25 = r110.animate();
        r111.add(r20.f13812b);
        r25.translationX(0.0f).translationY(0.0f).setDuration(r112).alpha(1.0f).setListener(new f(r19, r20, r25, r110, 1)).start();
    L27:
        r17 = r17;
        goto L11
    L20:
        r110 = null;
        goto L21
    L16:
        r22 = r21.itemView;
        goto L17
    L28:
        r16.clear();
        r19.f13827n.remove(r16);
        return;
    L30:
        ArrayList r26 = this.f13795b;
        Iterator r27 = r26.iterator();
    L31:
        boolean r28 = r27.hasNext();
        i r29 = this.f13796c;
        if (r28 == false) goto L39;
        h r30 = (h) r27.next();
        x0 r31 = r30.f13817a;
        r29.getClass();
        View r32 = r31.itemView;
        int r33 = r30.d - r30.f13818b;
        int r34 = r30.e - r30.f13819c;
        if (r33 == 0) goto L36;
        r32.animate().translationX(0.0f);
    L36:
        if (r34 == 0) goto L38;
        r32.animate().translationY(0.0f);
    L38:
        ViewPropertyAnimator r113 = r32.animate();
        r29.f13829p.add(r31);
        r113.setDuration(r29.e).setListener(new e(r29, r31, r33, r32, r34, r113)).start();
        goto L31
    L39:
        r26.clear();
        r29.f13826m.remove(r26);
    }
}
