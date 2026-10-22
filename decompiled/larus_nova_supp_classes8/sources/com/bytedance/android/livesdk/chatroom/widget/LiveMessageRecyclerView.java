package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.livesdk.interactivity.publicscreen.widget.TextMessageWidget;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveMessageRecyclerView extends RecyclerView {
    public float a;
    public float b;
    public float c;
    public float d;
    public int e;
    public boolean f;
    public int g;
    public WeakReference<cs1.b> h;
    public c i;
    public a j;
    public b k;

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ScrollBehaviors {
    }

    public interface a {
    }

    public interface b {
    }

    public interface c {
        void a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float getBottomFadingEdgeStrength() {
        return super/*android.view.ViewGroup*/.getBottomFadingEdgeStrength();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t() {
        if (getVisibility() == 0) goto L5;
    L9:
        boolean r0 = false;
    L10:
        com.bytedance.android.livesdk.interactivity.publicscreen.widget.f r1 = this.j;
        if (r1 == null) goto L28;
        TextMessageWidget r2 = r1.a;
        boolean r3 = TextMessageWidget.V0;
        if (r0 == true) goto L16;
        r2.getClass();
        return;
    L16:
        if (r2.isViewValid() == false) goto L31;
        LiveMessageRecyclerView r4 = r2.o;
        if (r4 == null) goto L32;
        RecyclerView.Adapter r5 = r4.getAdapter();
        if (r5 == null) goto L33;
        com.bytedance.android.livesdk.interactivity.publicscreen.utils.n r6 = r2.Z;
        if (r6 == null) goto L30;
        r6.a(r5);
        return;
    L30:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L28:
        return;
    L5:
        if (getWindowVisibility() != 0) goto L9;
        if (isAttachedToWindow() == false) goto L9;
        r0 = true;
        goto L10
    }

    public LiveMessageRecyclerView(Context r1) {
        super(r1);
        this.e = 0;
        this.f = false;
        this.g = 300;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r6) {
        if (r6.getAction() != 0) goto L11;
        ViewParent r0 = getParent();
    L5:
        if (r0 == null) goto L9;
        if ((r0 instanceof cs1.a) == true) goto L9;
        r0 = r0.getParent();
    L9:
        if (r0 == null) goto L11;
        ((cs1.a) r0).setDisallowInterceptOnce(true);
    L11:
        int r1 = this.e;
        if (r1 == 1) goto L43;
        if (r1 != 2) goto L15;
        this.b = r6.getY();
        if (r6.getAction() != 0) goto L23;
        float r2 = r6.getY();
        this.a = r2;
        this.d = r2;
        this.c = 0.0f;
    L42:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r6);
    L23:
        if (r6.getAction() == 2) goto L25;
        this.c = 0.0f;
        goto L42
    L25:
        if (canScrollVertically(1) == true) goto L27;
        this.c += this.b - this.d;
    L28:
        this.d = this.b;
        if (Math.abs(this.c) > this.g) goto L31;
    L39:
        r(true);
        goto L42
    L31:
        if (canScrollVertically(1) == true) goto L39;
        r(false);
        if (getParent() == null) goto L42;
        WeakReference<cs1.b> r3 = this.h;
        if (r3 == null) goto L42;
        cs1.b r4 = r3.get();
        if (r4 == null) goto L42;
        boolean r7 = super/*android.view.ViewGroup*/.dispatchTouchEvent(r6);
        MotionEvent r5 = r4.c();
        r5.setAction(0);
        r5.offsetLocation(0.0f, r4.getViewTouchSlop() + 1.0f);
        r4.d(r5);
        r5.recycle();
        return r7;
    L27:
        this.c = 0.0f;
        goto L28
    L15:
        if (r6.getAction() != 0) goto L63;
        ViewParent r8 = getParent();
        if (r8 == null) goto L63;
        r8.requestDisallowInterceptTouchEvent(true);
    L63:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r6);
    L43:
        this.b = r6.getY();
        if (r6.getAction() != 0) goto L47;
        this.a = r6.getY();
        goto L63
    L47:
        if (r6.getAction() != 2) goto L63;
        float r9 = this.b - this.a;
        if (this.f == false) goto L57;
        if (r9 < 0.0f) goto L53;
    L55:
        r(true);
        goto L63
    L53:
        if (getScrollY() != 0) goto L55;
        r(false);
        goto L63
    L57:
        if (Math.abs(r9) > 0.0f) goto L59;
    L61:
        r(true);
        goto L63
    L59:
        if (getScrollY() != 0) goto L61;
        r(false);
        goto L63
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onWindowVisibilityChanged(int r1) {
        super/*android.view.ViewGroup*/.onWindowVisibilityChanged(r1);
        t();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(boolean r2) {
        ViewParent r0 = getParent();
        if (r0 == null) goto L6;
        r0.requestDisallowInterceptTouchEvent(r2);
        return;
    }

    public void setAdapter(RecyclerView.Adapter r4) {
        if (r4 != null) goto L6;
        ALogger.w("textmessage", "on set adapter null");
        if (MainThreadPostUtils.a() == true) goto L6;
        SafetyGuard.a(null, new IllegalStateException("on set adapter null in sub thread"), "textmessage adapter null");
    L6:
        super.setAdapter(r4);
    }

    public void setCanScrollUp(boolean r1) {
        this.f = r1;
    }

    public void setOnCustomVisibleChangedListener(a r1) {
        this.j = r1;
    }

    public void setOnHeightChangeListener(b r1) {
        this.k = r1;
    }

    public void setOnVisibilityChangedListener(c r1) {
        this.i = r1;
    }

    public void setOverScrollTransEdge(int r1) {
        this.g = r1;
    }

    public void setScrollBehavior(int r1) {
        this.e = r1;
    }

    public void setTouchTransmitParent(cs1.b r2) {
        this.h = new WeakReference(r2);
    }

    public void setTouchTransmitParent(WeakReference<cs1.b> r1) {
        this.h = r1;
    }

    public LiveMessageRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.e = 0;
        this.f = false;
        this.g = 300;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onVisibilityChanged(View r1, int r2) {
        super/*android.view.ViewGroup*/.onVisibilityChanged(r1, r2);
        c r3 = this.i;
        if (r3 == null) goto L5;
        r3.a();
    L5:
        t();
    }

    public LiveMessageRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.e = 0;
        this.f = false;
        this.g = 300;
    }

    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r4 == r2) goto L8;
        com.bytedance.android.livesdk.interactivity.publicscreen.widget.g r5 = this.k;
        if (r5 == null) goto L9;
        r5.a(r4, r2);
        return;
    L9:
        return;
    }
}
