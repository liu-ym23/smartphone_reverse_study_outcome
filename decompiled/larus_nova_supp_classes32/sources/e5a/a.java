package e5a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.lynx.clay.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import com.lynx.clay.util.d;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends FrameLayout {
    public FlutterMutatorsStack a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    public b g;
    public final com.lynx.clay.embedding.android.b h;
    public ViewTreeObserverOnGlobalFocusChangeListenerC0084a i;

    /* JADX INFO: renamed from: e5a.a$a, reason: collision with other inner class name */
    public class ViewTreeObserverOnGlobalFocusChangeListenerC0084a implements ViewTreeObserver.OnGlobalFocusChangeListener {
        public final /* synthetic */ View.OnFocusChangeListener a;
        public final /* synthetic */ View b;

        public ViewTreeObserverOnGlobalFocusChangeListenerC0084a(View.OnFocusChangeListener r1, View r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public final void onGlobalFocusChanged(View r2, View r3) {
            View.OnFocusChangeListener r4 = this.a;
            View r5 = this.b;
            r4.onFocusChange(r5, d.b(r5, new com.lynx.clay.util.b()));
        }
    }

    public interface b {
        void a(MotionEvent r1, boolean r2);
    }

    private Matrix getPlatformViewMatrix() {
        Matrix r0 = new Matrix(this.a.c);
        r0.postTranslate(-this.b, -this.c);
        return r0;
    }

    public a(Context r2) {
        this(r2, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r2) {
        r2.save();
        r2.concat(getPlatformViewMatrix());
        super.dispatchDraw(r2);
        r2.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        if (this.f == false) goto L5;
        boolean r0 = super.dispatchTouchEvent(r3);
        b r1 = this.g;
        if (r1 == null) goto L9;
        r1.a(r3, r0);
    L9:
        return r0;
    L5:
        return super.dispatchTouchEvent(r3);
    }

    @Override // android.view.View
    public final void draw(Canvas r5) {
        r5.save();
        Iterator r0 = ((ArrayList) this.a.b).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Path r2 = new Path((Path) r0.next());
        r2.offset(-this.b, -this.c);
        r5.clipPath(r2);
        goto L4
    L6:
        super.draw(r5);
        r5.restore();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        if (this.f == false) goto L6;
        return false;
    L6:
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r4) {
        if (this.f == false) goto L7;
        return false;
    L7:
        if (this.h == null) goto L18;
        Matrix r0 = new Matrix();
        int r1 = r4.getAction();
        if (r1 != 0) goto L12;
        int r2 = this.b;
        this.d = r2;
        int r3 = this.c;
        this.e = r3;
        r0.postTranslate(r2, r3);
    L17:
        return this.h.d(r4, r0);
    L12:
        if (r1 == 2) goto L14;
        r0.postTranslate(this.b, this.c);
        goto L17
    L14:
        r0.postTranslate(this.d, this.e);
        this.d = this.b;
        this.e = this.c;
        goto L17
    L18:
        return super.onTouchEvent(r4);
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener r4) {
        ViewTreeObserver r0 = getViewTreeObserver();
        if (r0.isAlive() == false) goto L7;
        ViewTreeObserverOnGlobalFocusChangeListenerC0084a r1 = this.i;
        if (r1 == null) goto L7;
        this.i = null;
        r0.removeOnGlobalFocusChangeListener(r1);
    L7:
        ViewTreeObserver r2 = getViewTreeObserver();
        if (r2.isAlive() == true) goto L10;
        return;
    L10:
        if (this.i != null) goto L14;
        ViewTreeObserverOnGlobalFocusChangeListenerC0084a r3 = new ViewTreeObserverOnGlobalFocusChangeListenerC0084a(r4, this);
        this.i = r3;
        r2.addOnGlobalFocusChangeListener(r3);
        return;
    }

    public void setSystemTouchDispatchEnabled(boolean r1) {
        this.f = r1;
    }

    public void setTouchDispatchResultListener(b r1) {
        this.g = r1;
    }

    public a(Context r2, com.lynx.clay.embedding.android.b r3) {
        super(r2, null);
        this.f = false;
        this.h = r3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestSendAccessibilityEvent(View r4, AccessibilityEvent r5) {
        View r1 = getChildAt(0);
        if (r1 == null) goto L8;
        if (r1.getImportantForAccessibility() != 4) goto L8;
        return false;
    L8:
        return super.requestSendAccessibilityEvent(r4, r5);
    }
}
