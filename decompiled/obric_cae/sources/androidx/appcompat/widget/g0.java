package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public abstract class g0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f1146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1147b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f1148m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final View f1149n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a f1150o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public b f1151p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f1152q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1153r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int[] f1154s;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g0 f1155a;

        public a(g0 r8) {
            this.f1155a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewParent r8 = this.f1155a.f1149n.getParent();
            if (r8 == null) goto L6;
            r8.requestDisallowInterceptTouchEvent(true);
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g0 f1156a;

        public b(g0 r8) {
            this.f1156a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            g0 r11 = this.f1156a;
            r11.a();
            View r8 = r11.f1149n;
            if (r8.isEnabled() == true) goto L5;
            return;
        L5:
            if (r8.isLongClickable() == false) goto L8;
            return;
        L8:
            if (r11.c() == false) goto L14;
            r8.getParent().requestDisallowInterceptTouchEvent(true);
            long r10 = SystemClock.uptimeMillis();
            MotionEvent r12 = MotionEvent.obtain(r10, r10, 3, 0.0f, 0.0f, 0);
            r8.onTouchEvent(r12);
            r12.recycle();
            r11.f1152q = true;
            return;
        }
    }

    public g0(View r8) {
        this.f1154s = new int[2];
        this.f1149n = r8;
        r8.setLongClickable(true);
        r8.addOnAttachStateChangeListener(this);
        this.f1146a = ViewConfiguration.get(r8.getContext()).getScaledTouchSlop();
        int r10 = ViewConfiguration.getTapTimeout();
        this.f1147b = r10;
        this.f1148m = (ViewConfiguration.getLongPressTimeout() + r10) / 2;
    }

    public final void a() {
        b r8 = this.f1151p;
        View r10 = this.f1149n;
        if (r8 == null) goto L5;
        r10.removeCallbacks(r8);
    L5:
        a r11 = this.f1150o;
        if (r11 == null) goto L9;
        r10.removeCallbacks(r11);
        return;
    }

    public abstract h.f b();

    public abstract boolean c();

    public boolean d() {
        h.f r8 = b();
        if (r8 != null) goto L5;
        return true;
    L5:
        if (r8.isShowing() == false) goto L10;
        r8.dismiss();
        return true;
    L10:
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r13, MotionEvent r14) {
        boolean r15 = this.f1152q;
        View r8 = this.f1149n;
        if (r15 == false) goto L30;
        h.f r10 = b();
        if (r10 != null) goto L7;
    L22:
        boolean r16 = false;
    L23:
        if (r16 == false) goto L25;
    L28:
        boolean r17 = true;
    L69:
        this.f1152q = r17;
        if (r17 == true) goto L75;
        if (r15 == false) goto L74;
        return true;
    L74:
        return false;
    L75:
        return true;
    L25:
        if (d() == false) goto L28;
        r17 = false;
        goto L69
    L7:
        if (r10.isShowing() == false) goto L22;
        e0 r11 = r10.getListView();
        if (r11 == null) goto L22;
        if (r11.isShown() == false) goto L22;
        MotionEvent r12 = MotionEvent.obtainNoHistory(r14);
        int[] r18 = this.f1154s;
        r8.getLocationOnScreen(r18);
        r12.offsetLocation(r18[0], r18[1]);
        r11.getLocationOnScreen(r18);
        r12.offsetLocation(-r18[0], -r18[1]);
        boolean r19 = r11.b(r12, this.f1153r);
        r12.recycle();
        int r110 = r14.getActionMasked();
        if (r110 == 1) goto L18;
        if (r110 == 3) goto L18;
        boolean r111 = true;
    L19:
        if (r19 == false) goto L22;
        if (r111 == false) goto L22;
        r16 = true;
    L18:
        r111 = false;
        goto L19
    L30:
        if (r8.isEnabled() == false) goto L61;
        int r20 = r14.getActionMasked();
        if (r20 == 0) goto L54;
        if (r20 != 1) goto L36;
    L53:
        a();
        goto L61
    L36:
        if (r20 == 2) goto L39;
        if (r20 == 3) goto L53;
    L39:
        int r21 = r14.findPointerIndex(this.f1153r);
        if (r21 < 0) goto L61;
        float r22 = r14.getX(r21);
        float r112 = r14.getY(r21);
        float r23 = this.f1146a;
        float r24 = -r23;
        if (r22 >= r24) goto L44;
    L50:
        boolean r113 = false;
    L51:
        if (r113 == true) goto L61;
        a();
        r8.getParent().requestDisallowInterceptTouchEvent(true);
        boolean r114 = true;
    L62:
        if (r114 == true) goto L64;
    L66:
        r17 = false;
    L67:
        if (r17 == false) goto L69;
        long r25 = SystemClock.uptimeMillis();
        MotionEvent r26 = MotionEvent.obtain(r25, r25, 3, 0.0f, 0.0f, 0);
        r8.onTouchEvent(r26);
        r26.recycle();
        goto L69
    L64:
        if (c() == false) goto L66;
        r17 = true;
        goto L67
    L44:
        if (r112 < r24) goto L50;
        if (r22 >= ((r8.getRight() - r8.getLeft()) + r23)) goto L50;
        if (r112 >= ((r8.getBottom() - r8.getTop()) + r23)) goto L50;
        r113 = true;
        goto L51
    L54:
        this.f1153r = r14.getPointerId(0);
        if (this.f1150o != null) goto L57;
        this.f1150o = new a(this);
    L57:
        r8.postDelayed(this.f1150o, this.f1147b);
        if (this.f1151p != null) goto L60;
        this.f1151p = new b(this);
    L60:
        r8.postDelayed(this.f1151p, this.f1148m);
    L61:
        r114 = false;
        goto L62
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r8) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r8) {
        this.f1152q = false;
        this.f1153r = -1;
        a r10 = this.f1150o;
        if (r10 == null) goto L6;
        this.f1149n.removeCallbacks(r10);
        return;
    }
}
