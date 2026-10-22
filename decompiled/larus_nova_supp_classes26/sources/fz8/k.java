package fz8;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k extends FrameLayout {
    public Function0<Unit> a;
    public Function0<Boolean> b;
    public boolean c;
    public MotionEvent d;
    public final GestureDetector e;

    public static final class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ k a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            return true;
        }

        public a(k r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r4) {
            Intrinsics.checkNotNullParameter(r4, "e");
            k r5 = this.a;
            Function0<Boolean> r0 = r5.getOnDetectedLongPress();
            boolean r1 = false;
            if (r0 != null) goto L5;
        L7:
            r5.c = r1;
            k r6 = this.a;
            if (r6.c == false) goto L11;
            k.a(r6);
            return;
        L11:
            return;
        L5:
            if (((Boolean) r0.invoke()).booleanValue() != true) goto L7;
            r1 = true;
            goto L7
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            k r3 = this.a;
            if (r3.c == true) goto L9;
            Function0<Unit> r4 = r3.getOnDetectedTap();
            if (r4 == null) goto L10;
            r4.invoke();
            return false;
        L10:
            return false;
        L9:
            return false;
        }
    }

    public final Function0<Boolean> getOnDetectedLongPress() {
        return this.b;
    }

    public final Function0<Unit> getOnDetectedTap() {
        return this.a;
    }

    public k(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.e = new GestureDetector(r3, new a(this));
    }

    public static final void a(k r2) {
        MotionEvent r0 = r2.d;
        if (r0 == null) goto L7;
        MotionEvent r1 = MotionEvent.obtain(r0);
        r1.setAction(3);
        super.dispatchTouchEvent(r1);
        r1.recycle();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        if (r5.getActionMasked() != 0) goto L5;
        this.c = false;
    L5:
        MotionEvent r0 = this.d;
        if (r0 == null) goto L8;
        r0.recycle();
    L8:
        this.d = MotionEvent.obtain(r5);
        if (this.a != null) goto L13;
        if (this.b != null) goto L13;
    L16:
        if (this.c == false) goto L18;
        boolean r1 = true;
    L20:
        if (r5.getActionMasked() != 1) goto L22;
    L23:
        MotionEvent r6 = this.d;
        if (r6 == null) goto L26;
        r6.recycle();
    L26:
        this.d = null;
        this.c = false;
    L27:
        return r1;
    L22:
        if (r5.getActionMasked() != 3) goto L27;
    L18:
        r1 = super.dispatchTouchEvent(r5);
    L13:
        if (this.c == true) goto L16;
        this.e.onTouchEvent(r5);
        goto L16
    }

    public final void setOnDetectedLongPress(Function0<Boolean> r1) {
        this.b = r1;
        if (r1 == null) goto L5;
        return;
    L5:
        if (this.a != null) goto L12;
        MotionEvent r2 = this.d;
        if (r2 == null) goto L9;
        r2.recycle();
    L9:
        this.d = null;
        this.c = false;
        return;
    }

    public final void setOnDetectedTap(Function0<Unit> r1) {
        this.a = r1;
        if (r1 == null) goto L5;
        return;
    L5:
        if (this.b != null) goto L12;
        MotionEvent r2 = this.d;
        if (r2 == null) goto L9;
        r2.recycle();
    L9:
        this.d = null;
        this.c = false;
        return;
    }
}
