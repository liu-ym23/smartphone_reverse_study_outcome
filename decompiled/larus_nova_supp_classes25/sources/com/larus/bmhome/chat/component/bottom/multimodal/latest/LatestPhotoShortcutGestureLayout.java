package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u000b\u0018\u00002\u00020\u0001:\u0001\u001fB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0018H\u0017J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0013\u001a\u00020\u0014R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutGestureLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gestureListener", "com/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutGestureLayout$gestureListener$1", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutGestureLayout$gestureListener$1;", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "gestureDetector$delegate", "Lkotlin/Lazy;", "onGesture", "Lcom/larus/bmhome/chat/component/bottom/multimodal/latest/LatestPhotoShortcutGestureLayout$OnGesture;", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "event", "onWindowFocusChanged", "", "hasWindowFocus", "setOnGesture", "OnGesture", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class LatestPhotoShortcutGestureLayout extends FrameLayout {
    public static final /* synthetic */ int d = 0;
    public final b a;
    public final Lazy b;
    public a c;

    public interface a {
        void a();

        void b();

        void c();

        void d();

        void onClick();
    }

    public static final class b extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ LatestPhotoShortcutGestureLayout a;

        public b(LatestPhotoShortcutGestureLayout r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public final boolean onSingleTapConfirmed(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            a r3 = this.a.c;
            if (r3 == null) goto L7;
            r3.onClick();
            return true;
        L7:
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
            Intrinsics.checkNotNullParameter(r2, "e2");
            if (Math.abs(r4) < Math.abs(r3)) goto L5;
            return false;
        L5:
            if (r3 >= 0.0f) goto L14;
            a r5 = this.a.c;
            if (r5 == null) goto L13;
            r5.a();
            return true;
        L13:
            return true;
        L14:
            return false;
        }
    }

    public LatestPhotoShortcutGestureLayout(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LatestPhotoShortcutGestureLayout(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.b.getValue();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(r3);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        getGestureDetector().onTouchEvent(r2);
        int r3 = r2.getAction();
        if (r3 == 0) goto L9;
        if (r3 != 1) goto L12;
        a r4 = this.c;
        if (r4 == null) goto L12;
        r4.d();
    L12:
        return true;
    L9:
        a r5 = this.c;
        if (r5 == null) goto L12;
        r5.b();
        goto L12
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean r2) {
        super.onWindowFocusChanged(r2);
        if (getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L12;
        if (r2 == true) goto L13;
        a r3 = this.c;
        if (r3 == null) goto L14;
        r3.c();
        return;
    L14:
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void setOnGesture(a r2) {
        Intrinsics.checkNotNullParameter(r2, "onGesture");
        this.c = r2;
    }

    public LatestPhotoShortcutGestureLayout(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new b(this);
        this.b = LazyKt.lazy(new l(r2, this));
    }

    public /* synthetic */ LatestPhotoShortcutGestureLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
