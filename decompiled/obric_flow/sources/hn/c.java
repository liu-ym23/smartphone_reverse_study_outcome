package hn;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewNested;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewNestedInternal;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends i implements e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f17344j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b0.f f17345k;

    public c(Context r5) {
        super(r5);
        this.f17344j = new b();
        ViewConfiguration r10 = ViewConfiguration.get(getContext());
        this.f17345k = new b0.f(r10.getScaledWindowTouchSlop(), r10.getScaledMinimumFlingVelocity(), r10.getScaledMaximumFlingVelocity());
    }

    public int getNestedScrollAxis() {
        if (this.f17351c == false) goto L6;
        return 2;
    L6:
        return 1;
    }

    @Override // hn.e
    public View getView() {
        return this;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r10) {
        b r5 = this.f17344j;
        if (r5.f != null) goto L5;
        r5.f = VelocityTracker.obtain();
    L5:
        r5.f.addMovement(r10);
        int r11 = r10.getActionMasked();
        if (r11 == 0) goto L54;
        if (r11 == 1) goto L53;
        if (r11 == 2) goto L26;
        if (r11 != 3) goto L11;
        VelocityTracker r12 = r5.f;
        if (r12 == null) goto L25;
        r12.clear();
    L25:
        getParent().requestDisallowInterceptTouchEvent(false);
        a(0);
    L60:
        if (this.f17352h != 1) goto L62;
        return true;
    L62:
        return false;
    L11:
        if (r11 != 5) goto L13;
        r5.e = r10.getPointerId(0);
        int r13 = (int) (r10.getX() + 0.5f);
        r5.f17343c = r13;
        r5.f17341a = r13;
        int r14 = (int) (r10.getY() + 0.5f);
        r5.d = r14;
        r5.f17342b = r14;
        goto L60
    L13:
        if (r11 != 6) goto L60;
        int r15 = r10.getActionIndex();
        if (r10.getPointerId(r15) != r5.e) goto L60;
        if (r15 != 0) goto L19;
        int r16 = 1;
    L20:
        r5.e = r10.getPointerId(r16);
        int r17 = (int) (r10.getX(r16) + 0.5f);
        r5.f17343c = r17;
        r5.f17341a = r17;
        int r18 = (int) (r10.getY(r16) + 0.5f);
        r5.d = r18;
        r5.f17342b = r18;
        goto L60
    L19:
        r16 = 0;
        goto L20
    L26:
        int r19 = r5.e;
        if (r19 == (-1)) goto L60;
        int r20 = r10.findPointerIndex(r19);
        if (r20 >= 0) goto L32;
        return false;
    L32:
        int r21 = (int) (r10.getX(r20) + 0.5f);
        int r110 = (int) (r10.getY(r20) + 0.5f);
        if (this.f17352h == 1) goto L60;
        int r22 = r21 - r5.f17341a;
        int r23 = r110 - r5.f17342b;
        boolean r24 = this.f17351c;
        b0.f r25 = this.f17345k;
        if (r24 == true) goto L37;
    L41:
        boolean r26 = false;
    L43:
        if (this.f17351c == false) goto L45;
    L49:
        boolean r27 = false;
    L50:
        if (r26 == true) goto L52;
        if (r27 == false) goto L60;
    L52:
        r5.f17343c = r21;
        r5.d = r110;
        a(1);
        goto L60
    L45:
        if (Math.abs(r22) <= r25.f813a) goto L49;
        if ((getNestedScrollAxes() & 1) != 0) goto L49;
        r27 = true;
        goto L50
    L37:
        if (Math.abs(r23) <= r25.f813a) goto L41;
        if ((2 & getNestedScrollAxes()) != 0) goto L41;
        r26 = true;
        goto L43
    L53:
        r5.f.clear();
        stopNestedScroll(0);
        goto L60
    L54:
        r5.e = r10.getPointerId(0);
        int r28 = (int) (r10.getX() + 0.5f);
        r5.f17343c = r28;
        r5.f17341a = r28;
        int r111 = (int) (r10.getY() + 0.5f);
        r5.d = r111;
        r5.f17342b = r111;
        int r112 = this.f17352h;
        if (r112 == 3) goto L57;
        if (r112 == 2) goto L57;
    L58:
        startNestedScroll(getNestedScrollAxis(), 0);
    L57:
        getParent().requestDisallowInterceptTouchEvent(true);
        a(1);
        goto L58
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r13) {
        b r5 = this.f17344j;
        if (r5.f != null) goto L5;
        r5.f = VelocityTracker.obtain();
    L5:
        int r10 = r13.getActionMasked();
        int[] r11 = r5.g;
        g r12 = this.f17349a;
        int r14 = 0;
        if (r10 != 0) goto L8;
        r11[1] = 0;
        r11[0] = 0;
        r12.c(false);
        startNestedScroll(getNestedScrollAxis(), 0);
    L8:
        MotionEvent r15 = MotionEvent.obtain(r13);
        r15.offsetLocation(r11[0], r11[1]);
        if (r10 == 0) goto L102;
        b0.f r16 = this.f17345k;
        if (r10 != 1) goto L13;
        r5.f.addMovement(r15);
        r5.f.computeCurrentVelocity(1000, r16.f815c);
        float r17 = 0.0f;
        if (this.f17351c == true) goto L78;
        float r18 = -r5.f.getXVelocity(r5.e);
    L80:
        if (this.f17351c == false) goto L83;
        r17 = -r5.f.getYVelocity(r5.e);
    L83:
        if (Math.abs(r18) >= 600.0f) goto L85;
        boolean r19 = true;
    L87:
        if ((r19 & (!this.f17351c)) == true) goto L95;
        if (Math.abs(r17) < 600.0f) goto L91;
    L93:
        r12.a((int) r18, (int) r17, new com.lynx.animax.player.b(8, this, false, (LynxBaseScrollViewNestedInternal) this));
        a(3);
    L98:
        VelocityTracker r110 = r5.f;
        if (r110 == null) goto L101;
        r110.clear();
    L101:
        getParent().requestDisallowInterceptTouchEvent(false);
    L104:
        r15.recycle();
        return true;
    L91:
        if (this.f17351c == false) goto L93;
    L95:
        if (r12.d((LynxBaseScrollViewNestedInternal) this, this.f17351c, new r6.a(this)) == false) goto L97;
        a(3);
        goto L98
    L97:
        a(0);
        goto L98
    L85:
        r19 = false;
        goto L87
    L78:
        r18 = 0.0f;
        goto L80
    L13:
        if (r10 == 2) goto L30;
        if (r10 != 3) goto L16;
        VelocityTracker r111 = r5.f;
        if (r111 == null) goto L29;
        r111.clear();
    L29:
        getParent().requestDisallowInterceptTouchEvent(false);
        a(0);
    L103:
        r5.f.addMovement(r15);
        goto L104
    L16:
        if (r10 != 5) goto L18;
        int r112 = r13.getActionIndex();
        r5.e = r13.getPointerId(r112);
        int r20 = (int) (r13.getX(r112) + 0.5f);
        r5.f17343c = r20;
        r5.f17341a = r20;
        int r113 = (int) (r13.getY(r112) + 0.5f);
        r5.d = r113;
        r5.f17342b = r113;
        goto L103
    L18:
        if (r10 != 6) goto L103;
        int r114 = r13.getActionIndex();
        if (r13.getPointerId(r114) != r5.e) goto L103;
        if (r114 != 0) goto L24;
        r14 = 1;
    L24:
        r5.e = r13.getPointerId(r14);
        int r115 = (int) (r13.getX(r14) + 0.5f);
        r5.f17343c = r115;
        r5.f17341a = r115;
        int r116 = (int) (r13.getY(r14) + 0.5f);
        r5.d = r116;
        r5.f17342b = r116;
        goto L103
    L30:
        int r21 = r5.e;
        if (r21 == (-1)) goto L103;
        int r22 = r13.findPointerIndex(r21);
        if (r22 >= 0) goto L36;
        return false;
    L36:
        int r23 = (int) (r13.getX(r22) + 0.5f);
        int r117 = (int) (r13.getY(r22) + 0.5f);
        int r24 = r5.f17343c - r23;
        int r25 = r5.d - r117;
        if (this.f17352h != 1) goto L39;
        boolean r26 = true;
    L40:
        if (r26 == false) goto L42;
    L56:
        if (r26 == false) goto L103;
        if (getParent() == null) goto L60;
        getParent().requestDisallowInterceptTouchEvent(true);
    L60:
        a(1);
        int[] r27 = {0, 0};
        boolean r28 = this.f17351c;
        if (r28 == false) goto L63;
        int r118 = 0;
    L64:
        if (r28 == false) goto L66;
        int r29 = r25;
    L67:
        int[] r30 = ((LynxBaseScrollViewNested) this).g(r118, r29, 0, r27);
        r15.offsetLocation(r27[0], r27[1]);
        int r119 = r27[0];
        r5.f17343c = r23 - r119;
        int r31 = r27[1];
        r5.d = r117 - r31;
        r11[0] = r11[0] + r119;
        r11[1] = r11[1] + r31;
        boolean r120 = this.f17351c;
        if (r120 == true) goto L70;
    L71:
        if (r120 == true) goto L103;
        if (r30[0] == r24) goto L103;
    L74:
        getParent().requestDisallowInterceptTouchEvent(true);
        goto L103
    L70:
        if (r30[1] != r25) goto L74;
    L66:
        r29 = 0;
        goto L67
    L63:
        r118 = r24;
        goto L64
    L42:
        if (this.f17351c == false) goto L49;
        int r121 = Math.abs(r25);
        int r122 = r16.f813a;
        if (r121 <= r122) goto L49;
        if (r25 <= 0) goto L47;
        r25 = r25 - r122;
    L55:
        r26 = true;
        goto L56
    L47:
        r25 = r25 + r122;
    L49:
        if (this.f17351c == true) goto L56;
        int r123 = Math.abs(r24);
        int r32 = r16.f813a;
        if (r123 <= r32) goto L56;
        if (r24 <= 0) goto L54;
        r24 = r24 - r32;
        goto L55
    L54:
        r24 = r24 + r32;
        goto L55
    L39:
        r26 = false;
        goto L40
    L102:
        r5.e = r13.getPointerId(0);
        int r124 = (int) (r13.getX() + 0.5f);
        r5.f17343c = r124;
        r5.f17341a = r124;
        int r125 = (int) (r13.getY() + 0.5f);
        r5.d = r125;
        r5.f17342b = r125;
        goto L103
    }

    public abstract void stopNestedScroll(int r5);
}
