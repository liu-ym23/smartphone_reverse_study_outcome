package com.larus.common_ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0004#$%&B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0018\u0010\u001a¨\u0006'"}, d2 = {"Lcom/larus/common_ui/view/ZoomableTextureView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "gestureDetector", "Landroid/view/GestureDetector;", "gestureListener", "Lcom/larus/common_ui/view/ZoomableTextureView$IGestureListener;", "getGestureListener", "()Lcom/larus/common_ui/view/ZoomableTextureView$IGestureListener;", "setGestureListener", "(Lcom/larus/common_ui/view/ZoomableTextureView$IGestureListener;)V", "lastScaleFactor", "", "onSingleClickListener", "Landroid/view/View$OnClickListener;", "isPinchEnable", "", "()Z", "isPinchEnable$delegate", "Lkotlin/Lazy;", "setOnClickListener", "", "l", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "Companion", "ScaleListener", "GestureListener", "IGestureListener", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ZoomableTextureView extends View {
    public static final /* synthetic */ int g = 0;
    public final ScaleGestureDetector a;
    public final GestureDetector b;
    public c c;
    public float d;
    public View.OnClickListener e;
    public final Lazy f;

    public static final class a {
    }

    public final class b extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ ZoomableTextureView a;

        public b(ZoomableTextureView r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onDoubleTap(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            c r3 = this.a.getGestureListener();
            if (r3 == null) goto L7;
            r3.c();
            return true;
        L7:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            c r0 = this.a.getGestureListener();
            if (r0 == null) goto L5;
            r0.e(r2);
        L5:
            ZoomableTextureView r3 = this.a;
            View.OnClickListener r1 = r3.e;
            if (r1 == null) goto L10;
            r1.onClick(r3);
            return true;
        L10:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            c r3 = this.a.getGestureListener();
            if (r3 == null) goto L7;
            r3.f();
            return true;
        L7:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
            Intrinsics.checkNotNullParameter(r2, "e2");
            if (r1 != null) goto L6;
            return false;
        L6:
            c r5 = this.a.getGestureListener();
            if (r5 == null) goto L11;
            r5.b();
            return true;
        L11:
            return true;
        }
    }

    public interface c {
        void a();

        void b();

        void c();

        void d(float r1);

        void e(MotionEvent r1);

        void f();

        void g(float r1, float r2, float r3);
    }

    public final class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public final /* synthetic */ ZoomableTextureView a;

        public d(ZoomableTextureView r1) {
            this.a = r1;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScale(ScaleGestureDetector r5) {
            Intrinsics.checkNotNullParameter(r5, "detector");
            float r0 = r5.getScaleFactor();
            float r1 = r5.getFocusX();
            float r6 = r5.getFocusY();
            c r2 = this.a.getGestureListener();
            if (r2 == null) goto L7;
            ZoomableTextureView r3 = this.a;
            r2.g(r0, r1, r6);
            r3.d = r0;
            return true;
        L7:
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final boolean onScaleBegin(ScaleGestureDetector r2) {
            Intrinsics.checkNotNullParameter(r2, "detector");
            ZoomableTextureView r3 = this.a;
            r3.d = 1.0f;
            c r4 = r3.getGestureListener();
            if (r4 == null) goto L7;
            r4.a();
            return true;
        L7:
            return true;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public final void onScaleEnd(ScaleGestureDetector r2) {
            Intrinsics.checkNotNullParameter(r2, "detector");
            c r3 = this.a.getGestureListener();
            if (r3 == null) goto L6;
            r3.d(this.a.d);
            return;
        }
    }

    static {
    }

    public ZoomableTextureView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ZoomableTextureView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final c getGestureListener() {
        return this.c;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        if (((Boolean) this.f.getValue()).booleanValue() == false) goto L7;
        boolean r0 = this.a.onTouchEvent(r4);
        this.b.onTouchEvent(r4);
        FLogger.a.i("ZoomableTextureView", "receive event");
        return r0;
    L7:
        return super.onTouchEvent(r4);
    }

    public final void setGestureListener(c r1) {
        this.c = r1;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener r2) {
        if (((Boolean) this.f.getValue()).booleanValue() == false) goto L5;
        this.e = r2;
        return;
    L5:
        super.setOnClickListener(r2);
    }

    public ZoomableTextureView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new ScaleGestureDetector(r2, new d(this));
        this.b = new GestureDetector(r2, new b(this));
        this.d = 1.0f;
        this.f = LazyKt.lazy(new c0());
        setFocusable(true);
        setFocusableInTouchMode(true);
        setClickable(true);
        if (z2.a.realtimeTalkbackOptEnable() == false) goto L15;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L6
        setImportantForAccessibility(2);     // Catch: Throwable -> L6
        Object r6 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L16;
        FLogger.a.i("ZoomableTextureView", "addImportantForAccessibility failed。e=" + r7);
        return;
    L16:
        return;
    L6:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public /* synthetic */ ZoomableTextureView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
