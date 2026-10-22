package com.lynx.tasm.behavior;

import android.graphics.RectF;
import android.os.Handler;
import android.webkit.WebView;
import androidx.core.view.ViewCompat;
import com.bytedance.ies.xelement.AndroidNestedScrollView;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.scroll.AndroidScrollView;
import com.lynx.tasm.behavior.ui.swiper.XSwiperUI;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10175a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference f10176b;

    public a0(AndroidNestedScrollView r5) {
        this.f10175a = 5;
        this.f10176b = new WeakReference(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        boolean r5 = true;
        int r10 = 0;
        WeakReference r11 = this.f10176b;
        switch(this.f10175a) {
            case 0: goto L107;
            case 1: goto L103;
            case 2: goto L89;
            case 3: goto L51;
            case 4: goto L35;
            case 5: goto L21;
            default: goto L5;
        };
    L35:
        XSwiperUI r12 = (XSwiperUI) r11.get();
        if (r12 != null) goto L38;
        return;
    L38:
        if (r12.f10683u == true) goto L40;
        return;
    L40:
        if (r12.f10677n == false) goto L133;
        jn.f r13 = ((jn.b) r12.getView()).f18363a;
        int r14 = r13.getCurrentIndex() + 1;
        if (r14 == r13.getTotalCount()) goto L44;
    L48:
        r5 = false;
        r10 = r14;
    L49:
        r12.i(r13, r10, r12.f10679p, r5);
        r12.C.postDelayed(this, r12.f10680q);
        return;
    L44:
        if (r12.f10684v == true) goto L49;
        if (r12.f10678o == false) goto L48;
    L133:
        return;
    L51:
        if (r11 != null) goto L53;
        return;
    L53:
        if (r11.get() != null) goto L55;
        return;
    L55:
        if (((AndroidScrollView) r11.get()).f10599n == null) goto L136;
        AndroidScrollView r15 = (AndroidScrollView) r11.get();
        if (r15.C == false) goto L137;
        int r16 = r15.getRealScrollX();
        int r17 = r15.getRealScrollY();
        int r18 = r15.E;
        boolean r19 = r15.s;
        fn.a r20 = r15.f10599n;
        if (r19 == true) goto L70;
        int r21 = r17 + r18;
        r15.d(r16, r21, false);
        if (r18 >= 0) goto L66;
        if (r17 > 0) goto L64;
        r15.C = false;
        return;
    L64:
        r15.postDelayed(this, 16);
        return;
    L66:
        if ((r15.getMeasuredHeight() + r21) >= r20.getMeasuredHeight()) goto L68;
        r15.postDelayed(this, 16);
        return;
    L68:
        r15.C = false;
        return;
    L70:
        if (ViewCompat.getLayoutDirection(r15) != 1) goto L72;
        int r22 = r16 - r18;
    L73:
        r15.d(r22, r17, false);
        if (r18 < 0) goto L76;
        if (r22 > 0) goto L85;
    L87:
        r15.C = false;
        return;
    L85:
        if ((r15.getMeasuredWidth() + r22) >= r20.getMeasuredWidth()) goto L87;
        r15.postDelayed(this, 16);
        return;
    L76:
        if (ViewCompat.getLayoutDirection(r15) != 0) goto L80;
        if (r16 <= 0) goto L81;
    L82:
        r15.postDelayed(this, 16);
        return;
    L81:
        r15.C = false;
        return;
    L80:
        if ((r15.getMeasuredWidth() + r22) < r20.getMeasuredWidth()) goto L82;
    L72:
        r22 = r16 + r18;
        goto L73
    L137:
        return;
    L136:
        return;
    L89:
        en.a r110 = (en.a) r11.get();
        if (r110 == null) goto L146;
        r110.f16840b = null;
        int r23 = UIList.S;
    L94:
        if (r110.f16841c.size() <= 0) goto L96;
        ai.j0.A(r110.f16841c.removeFirst());
        goto L94
    L96:
        r110.f16841c = r110.d;
        r110.d = new LinkedList();
        if (r110.f16841c.size() > 0) goto L99;
        return;
    L99:
        if (r110.f16840b != null) goto L147;
        a0 r24 = new a0(r110);
        r110.f16840b = r24;
        r110.f16839a.postDelayed(r24, 50);
        return;
    L147:
        return;
    L146:
        return;
    L103:
        WebView r111 = (WebView) r11.get();
        if (r111 == null) goto L148;
        r111.setAlpha(1.0f);
        return;
    L148:
        return;
    L107:
        b0 r112 = (b0) r11.get();
        if (r112 == null) goto L149;
        RectF r25 = r112.b((LynxBaseUI) r112.f10198a.get());
        if (r25.equals(r112.f10206m) == true) goto L116;
        Handler r26 = r112.f10202i;
        if (r26 == null) goto L116;
        x r27 = r112.f10203j;
        if (r27 == null) goto L116;
        r26.post(r27);
    L116:
        long r28 = r112.f10207n;
        if (r28 == 0) goto L123;
        Handler r29 = r112.f10204k;
        if (r29 == null) goto L123;
        a0 r30 = r112.f10205l;
        if (r30 == null) goto L123;
        r29.postDelayed(r30, r28);
    L123:
        r112.f10206m = r25;
        return;
    L149:
        return;
    L5:
        if (r11.get() == null) goto L127;
        com.bytedance.ies.xelement.viewpager.childitem.AndroidNestedScrollView r31 = (com.bytedance.ies.xelement.viewpager.childitem.AndroidNestedScrollView) r11.get();
        int r32 = r31.getScrollY();
        int r33 = r31.f6527c.getScrollX();
        boolean r34 = r31.f;
        if (r34 == true) goto L9;
    L10:
        if (r34 == false) goto L12;
    L18:
        r31.f6534n = r32;
        r31.f6535o = r33;
        r31.postDelayed(this, r31.f6536p);
        return;
    L12:
        if ((r31.f6534n - r32) != 0) goto L18;
    L13:
        r31.a(0);
        Iterator r113 = r31.f6531k.iterator();
        if (r113.hasNext() == true) goto L17;
        return;
    L17:
        throw mn.h.c(r113);
    L9:
        if ((r31.f6535o - r33) == 0) goto L13;
    L127:
        return;
    L21:
        if (r11.get() == null) goto L129;
        AndroidNestedScrollView r35 = (AndroidNestedScrollView) r11.get();
        int r36 = r35.getScrollY();
        int r37 = r35.f6336c.getScrollX();
        boolean r38 = r35.f;
        if (r38 == true) goto L25;
    L26:
        if (r38 == false) goto L28;
    L33:
        r35.f6343n = r36;
        r35.f6344o = r37;
        r35.postDelayed(this, r35.f6345p);
        return;
    L28:
        if ((r35.f6343n - r36) != 0) goto L33;
    L29:
        r35.a(0);
        Iterator r114 = r35.f6340k.iterator();
    L31:
        if (r114.hasNext() == false) goto L130;
        ((oe.b) r114.next()).getClass();
        goto L31
    L130:
        return;
    L25:
        if ((r35.f6344o - r37) == 0) goto L29;
    }

    public a0(com.bytedance.ies.xelement.viewpager.childitem.AndroidNestedScrollView r5) {
        this.f10175a = 6;
        this.f10176b = new WeakReference(r5);
    }

    public a0(b0 r5) {
        this.f10175a = 0;
        this.f10176b = new WeakReference(r5);
    }

    public a0(AndroidScrollView r5) {
        this.f10175a = 3;
        this.f10176b = new WeakReference(r5);
    }

    public a0(XSwiperUI r5) {
        this.f10175a = 4;
        this.f10176b = new WeakReference(r5);
    }

    public a0(en.a r5) {
        this.f10175a = 2;
        this.f10176b = new WeakReference(r5);
    }

    public a0(WebView r5) {
        this.f10175a = 1;
        this.f10176b = new WeakReference(r5);
    }
}
