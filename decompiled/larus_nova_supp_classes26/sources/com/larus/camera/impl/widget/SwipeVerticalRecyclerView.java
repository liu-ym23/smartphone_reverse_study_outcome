package com.larus.camera.impl.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/larus/camera/impl/widget/SwipeVerticalRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "swipeListener", "Lcom/larus/camera/impl/widget/OnSwipeListener;", "setOnSwipeListener", "", "listener", "isInMovingMode", "", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "Lkotlin/Lazy;", "onTouchEvent", "e", "Landroid/view/MotionEvent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwipeVerticalRecyclerView extends RecyclerView {
    public static final /* synthetic */ int d = 0;
    public p a;
    public boolean b;
    public final Lazy c;

    public static final class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ SwipeVerticalRecyclerView a;

        public a(SwipeVerticalRecyclerView r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "e");
            this.a.b = false;
            return super.onDown(r3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
            Intrinsics.checkNotNullParameter(r2, "e2");
            if (Math.abs(r4) <= Math.abs(r3)) goto L17;
            SwipeVerticalRecyclerView r5 = this.a;
            if (r5.b == false) goto L7;
        L16:
            return true;
        L7:
            if (r4 <= 20.0f) goto L12;
            r5.b = true;
            p r6 = r5.a;
            if (r6 == null) goto L16;
            r6.a();
            goto L16
        L12:
            if (r4 >= (-20.0f)) goto L16;
            r5.b = true;
            p r7 = r5.a;
            if (r7 == null) goto L16;
            r7.b();
            goto L16
        L17:
            return false;
        }
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.c.getValue();
    }

    public SwipeVerticalRecyclerView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = LazyKt.lazy(new u(this));
    }

    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        getGestureDetector().onTouchEvent(r2);
        return super.onTouchEvent(r2);
    }

    public final void setOnSwipeListener(p r1) {
        this.a = r1;
    }

    public SwipeVerticalRecyclerView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.c = LazyKt.lazy(new u(this));
    }

    public SwipeVerticalRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = LazyKt.lazy(new u(this));
    }
}
