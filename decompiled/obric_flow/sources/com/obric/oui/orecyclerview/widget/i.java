package com.obric.oui.orecyclerview.widget;

import android.view.View;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends g0 {
    public static com.obric.oui.orecyclerview.base.g s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static LinearInterpolator f13820t;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f13821h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f13822i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList f13823j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f13824k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList f13825l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList f13826m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ArrayList f13827n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArrayList f13828o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ArrayList f13829p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ArrayList f13830q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ArrayList f13831r;

    public static void h(ArrayList r5) {
        int r10 = r5.size() - 1;
    L3:
        if (r10 < 0) goto L5;
        ((x0) r5.get(r10)).itemView.animate().cancel();
        r10 = r10 - 1;
        goto L3
    }

    @Override // com.obric.oui.orecyclerview.widget.g0
    public final boolean a(x0 r10, x0 r11, f0 r12, f0 r13) {
        int r5 = r12.f13809a;
        int r14 = r12.f13810b;
        if (r11.shouldIgnore() == false) goto L5;
        int r15 = r12.f13809a;
        int r16 = r12.f13810b;
        int r17 = r15;
    L6:
        if (r10 == r11) goto L10;
        float r18 = r10.itemView.getTranslationX();
        float r19 = r10.itemView.getTranslationY();
        float r20 = r10.itemView.getAlpha();
        l(r10);
        r10.itemView.setTranslationX(r18);
        r10.itemView.setTranslationY(r19);
        r10.itemView.setAlpha(r20);
        l(r11);
        r11.itemView.setTranslationX(-((int) ((r17 - r5) - r18)));
        r11.itemView.setTranslationY(-((int) ((r16 - r14) - r19)));
        r11.itemView.setAlpha(0.0f);
        ArrayList r21 = this.f13824k;
        g r110 = new g();
        r110.f13811a = r10;
        r110.f13812b = r11;
        r110.f13813c = r5;
        r110.d = r14;
        r110.e = r17;
        r110.f = r16;
        r21.add(r110);
        return true;
    L10:
        return g(r10, r5, r14, r17, r16);
    L5:
        r17 = r13.f13809a;
        r16 = r13.f13810b;
        goto L6
    }

    @Override // com.obric.oui.orecyclerview.widget.g0
    public final void d(x0 r10) {
        View r5 = r10.itemView;
        r5.animate().cancel();
        ArrayList r11 = this.f13823j;
        int r12 = r11.size();
    L3:
        r12 = r12 - 1;
        if (r12 < 0) goto L9;
        if (((h) r11.get(r12)).f13817a != r10) goto L3;
        r5.setTranslationY(0.0f);
        r5.setTranslationX(0.0f);
        c(r10);
        r11.remove(r12);
        goto L3
    L9:
        j(this.f13824k, r10);
        if (this.f13821h.remove(r10) == false) goto L13;
        r5.setAlpha(1.0f);
        c(r10);
    L13:
        if (this.f13822i.remove(r10) == false) goto L15;
        r5.setAlpha(1.0f);
        c(r10);
    L15:
        ArrayList r13 = this.f13827n;
        int r14 = r13.size() - 1;
    L16:
        if (r14 < 0) goto L21;
        ArrayList r15 = (ArrayList) r13.get(r14);
        j(r15, r10);
        if (r15.isEmpty() == false) goto L20;
        r13.remove(r14);
    L20:
        r14 = r14 - 1;
        goto L16
    L21:
        ArrayList r16 = this.f13826m;
        int r17 = r16.size() - 1;
    L22:
        if (r17 < 0) goto L32;
        ArrayList r18 = (ArrayList) r16.get(r17);
        int r19 = r18.size() - 1;
    L24:
        if (r19 < 0) goto L31;
        if (((h) r18.get(r19)).f13817a == r10) goto L27;
        r19 = r19 - 1;
        goto L24
    L27:
        r5.setTranslationY(0.0f);
        r5.setTranslationX(0.0f);
        c(r10);
        r18.remove(r19);
        if (r18.isEmpty() == false) goto L31;
        r16.remove(r17);
    L31:
        r17 = r17 - 1;
        goto L22
    L32:
        ArrayList r20 = this.f13825l;
        int r21 = r20.size() - 1;
    L33:
        if (r21 < 0) goto L40;
        ArrayList r22 = (ArrayList) r20.get(r21);
        if (r22.remove(r10) == false) goto L39;
        r5.setAlpha(1.0f);
        c(r10);
        if (r22.isEmpty() == false) goto L39;
        r20.remove(r21);
    L39:
        r21 = r21 - 1;
        goto L33
    L40:
        this.f13830q.remove(r10);
        this.f13828o.remove(r10);
        this.f13831r.remove(r10);
        this.f13829p.remove(r10);
        i();
    }

    @Override // com.obric.oui.orecyclerview.widget.g0
    public final void e() {
        ArrayList r5 = this.f13823j;
        int r10 = r5.size();
    L3:
        r10 = r10 - 1;
        if (r10 < 0) goto L6;
        h r11 = (h) r5.get(r10);
        View r12 = r11.f13817a.itemView;
        r12.setTranslationY(0.0f);
        r12.setTranslationX(0.0f);
        c(r11.f13817a);
        r5.remove(r10);
        goto L3
    L6:
        ArrayList r13 = this.f13821h;
        int r14 = r13.size() - 1;
    L7:
        if (r14 < 0) goto L9;
        c((x0) r13.get(r14));
        r13.remove(r14);
        r14 = r14 - 1;
        goto L7
    L9:
        ArrayList r15 = this.f13822i;
        int r16 = r15.size();
    L10:
        r16 = r16 - 1;
        if (r16 < 0) goto L13;
        x0 r17 = (x0) r15.get(r16);
        r17.itemView.setAlpha(1.0f);
        c(r17);
        r15.remove(r16);
        goto L10
    L13:
        ArrayList r18 = this.f13824k;
        int r19 = r18.size() - 1;
    L14:
        if (r19 < 0) goto L22;
        g r20 = (g) r18.get(r19);
        x0 r21 = r20.f13811a;
        if (r21 == null) goto L18;
        k(r20, r21);
    L18:
        x0 r22 = r20.f13812b;
        if (r22 == null) goto L21;
        k(r20, r22);
    L21:
        r19 = r19 - 1;
        goto L14
    L22:
        r18.clear();
        if (f() == true) goto L25;
        return;
    L25:
        ArrayList r23 = this.f13826m;
        int r24 = r23.size() - 1;
    L26:
        if (r24 < 0) goto L34;
        ArrayList r25 = (ArrayList) r23.get(r24);
        int r26 = r25.size() - 1;
    L28:
        if (r26 < 0) goto L33;
        h r27 = (h) r25.get(r26);
        View r28 = r27.f13817a.itemView;
        r28.setTranslationY(0.0f);
        r28.setTranslationX(0.0f);
        c(r27.f13817a);
        r25.remove(r26);
        if (r25.isEmpty() == false) goto L32;
        r23.remove(r25);
    L32:
        r26 = r26 - 1;
        goto L28
    L33:
        r24 = r24 - 1;
        goto L26
    L34:
        ArrayList r29 = this.f13825l;
        int r30 = r29.size() - 1;
    L35:
        if (r30 < 0) goto L43;
        ArrayList r31 = (ArrayList) r29.get(r30);
        int r32 = r31.size() - 1;
    L37:
        if (r32 < 0) goto L42;
        x0 r33 = (x0) r31.get(r32);
        r33.itemView.setAlpha(1.0f);
        c(r33);
        r31.remove(r32);
        if (r31.isEmpty() == false) goto L41;
        r29.remove(r31);
    L41:
        r32 = r32 - 1;
        goto L37
    L42:
        r30 = r30 - 1;
        goto L35
    L43:
        ArrayList r34 = this.f13827n;
        int r35 = r34.size() - 1;
    L44:
        if (r35 < 0) goto L58;
        ArrayList r36 = (ArrayList) r34.get(r35);
        int r37 = r36.size() - 1;
    L46:
        if (r37 < 0) goto L57;
        g r38 = (g) r36.get(r37);
        x0 r39 = r38.f13811a;
        if (r39 == null) goto L50;
        k(r38, r39);
    L50:
        x0 r40 = r38.f13812b;
        if (r40 == null) goto L54;
        k(r38, r40);
    L54:
        if (r36.isEmpty() == false) goto L56;
        r34.remove(r36);
    L56:
        r37 = r37 - 1;
        goto L46
    L57:
        r35 = r35 - 1;
        goto L44
    L58:
        h(this.f13830q);
        h(this.f13829p);
        h(this.f13828o);
        h(this.f13831r);
        ArrayList r41 = this.f13815b;
        if (r41.size() > 0) goto L62;
        r41.clear();
        return;
    L62:
        ai.j0.A(r41.get(0));
        throw null;
    }

    @Override // com.obric.oui.orecyclerview.widget.g0
    public final boolean f() {
        if (this.f13822i.isEmpty() == true) goto L5;
    L26:
        return true;
    L5:
        if (this.f13824k.isEmpty() == false) goto L26;
        if (this.f13823j.isEmpty() == false) goto L26;
        if (this.f13821h.isEmpty() == false) goto L26;
        if (this.f13829p.isEmpty() == false) goto L26;
        if (this.f13830q.isEmpty() == false) goto L26;
        if (this.f13828o.isEmpty() == false) goto L26;
        if (this.f13831r.isEmpty() == false) goto L26;
        if (this.f13826m.isEmpty() == false) goto L26;
        if (this.f13825l.isEmpty() == false) goto L26;
        if (this.f13827n.isEmpty() == false) goto L26;
        return false;
    }

    public final boolean g(x0 r5, int r10, int r11, int r12, int r13) {
        View r14 = r5.itemView;
        int r15 = r10 + ((int) r14.getTranslationX());
        int r16 = r11 + ((int) r5.itemView.getTranslationY());
        l(r5);
        int r17 = r12 - r15;
        int r18 = r13 - r16;
        if (r17 != 0) goto L7;
        if (r18 != 0) goto L7;
        c(r5);
        return false;
    L7:
        if (r17 == 0) goto L9;
        r14.setTranslationX(-r17);
    L9:
        if (r18 == 0) goto L11;
        r14.setTranslationY(-r18);
    L11:
        ArrayList r19 = this.f13823j;
        h r20 = new h();
        r20.f13817a = r5;
        r20.f13818b = r15;
        r20.f13819c = r16;
        r20.d = r12;
        r20.e = r13;
        r19.add(r20);
        return true;
    }

    public final void i() {
        if (f() == true) goto L9;
        ArrayList r5 = this.f13815b;
        if (r5.size() > 0) goto L7;
        r5.clear();
        return;
    L7:
        ai.j0.A(r5.get(0));
        throw null;
    }

    public final void j(ArrayList r5, x0 r10) {
        int r11 = r5.size() - 1;
    L3:
        if (r11 < 0) goto L12;
        g r12 = (g) r5.get(r11);
        if (k(r12, r10) == false) goto L11;
        if (r12.f13811a != null) goto L11;
        if (r12.f13812b != null) goto L11;
        r5.remove(r12);
    L11:
        r11 = r11 - 1;
        goto L3
    }

    public final boolean k(g r5, x0 r10) {
        if (r5.f13812b != r10) goto L6;
        r5.f13812b = null;
    L8:
        r10.itemView.setAlpha(1.0f);
        r10.itemView.setTranslationX(0.0f);
        r10.itemView.setTranslationY(0.0f);
        c(r10);
        return true;
    L6:
        if (r5.f13811a != r10) goto L10;
        r5.f13811a = null;
        goto L8
    L10:
        return false;
    }

    public final void l(x0 r5) {
        if (s != null) goto L6;
        s = new com.obric.oui.orecyclerview.base.g();
    L6:
        if (f13820t != null) goto L8;
        f13820t = new LinearInterpolator();
    L8:
        r5.itemView.animate().setInterpolator(s);
        d(r5);
    }
}
