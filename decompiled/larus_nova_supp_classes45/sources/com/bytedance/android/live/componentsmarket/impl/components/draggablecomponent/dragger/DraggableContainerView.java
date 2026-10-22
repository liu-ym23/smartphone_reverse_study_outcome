package com.bytedance.android.live.componentsmarket.impl.components.draggablecomponent.dragger;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import k40.f;
import k40.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0003\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/componentsmarket/impl/components/draggablecomponent/dragger/DraggableContainerView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/componentsmarket/impl/components/draggablecomponent/dragger/DraggableContainerView$b;", "a", "Lcom/bytedance/android/live/componentsmarket/impl/components/draggablecomponent/dragger/DraggableContainerView$b;", "getDragCallback", "()Lcom/bytedance/android/live/componentsmarket/impl/components/draggablecomponent/dragger/DraggableContainerView$b;", "setDragCallback", "(Lcom/bytedance/android/live/componentsmarket/impl/components/draggablecomponent/dragger/DraggableContainerView$b;)V", "dragCallback", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "livecomponentsmarket-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DraggableContainerView extends FrameLayout {
    public b a;
    public final a b;

    public final class a {
        public final int a;
        public g b;
        public g c;
        public final /* synthetic */ DraggableContainerView d;

        public a(DraggableContainerView r2) {
            this.d = r2;
            this.a = ViewConfiguration.get(r2.getContext()).getScaledTouchSlop();
            this.b = new g(0.0f, 0.0f);
            this.c = new g(0.0f, 0.0f);
        }
    }

    public interface b {
        void a();

        void b(g r1);

        void onDragStart();
    }

    public DraggableContainerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public DraggableContainerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final b getDragCallback() {
        return this.a;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        if (this.a == null) goto L23;
        a r0 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "event");
        int r1 = r5.getAction();
        if (r1 != 0) goto L7;
        r0.c = f.c(r5);
    L19:
        boolean r2 = false;
    L20:
        if (r2 == false) goto L23;
        return true;
    L7:
        if (r1 != 2) goto L19;
        if (f.a(f.c(r5), r0.c) < r0.a) goto L19;
        r0.b = f.c(r5);
        r0.d.requestDisallowInterceptTouchEvent(true);
        b r3 = r0.d.getDragCallback();
        if (r3 == null) goto L14;
        r3.onDragStart();
    L14:
        b r4 = r0.d.getDragCallback();
        if (r4 == null) goto L17;
        r4.b(f.e(f.c(r5), r0.c));
    L17:
        r2 = true;
    L23:
        return super.onInterceptTouchEvent(r5);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (this.a == null) goto L29;
        a r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "event");
        int r0 = r5.getAction();
        if (r0 == 0) goto L22;
        if (r0 != 1) goto L8;
        b r2 = r1.d.getDragCallback();
        if (r2 == null) goto L21;
        r2.a();
    L21:
        r1.d.performClick();
    L25:
        boolean r3 = true;
    L26:
        if (r3 == false) goto L29;
        return true;
    L8:
        if (r0 != 2) goto L10;
        g r4 = f.e(f.c(r5), r1.b);
        r1.b = f.c(r5);
        b r6 = r1.d.getDragCallback();
        if (r6 == null) goto L25;
        r6.b(r4);
        goto L25
    L10:
        if (r0 == 3) goto L12;
        r3 = false;
        goto L26
    L12:
        b r7 = r1.d.getDragCallback();
        if (r7 == null) goto L25;
        r7.a();
        goto L25
    L22:
        r1.b = f.c(r5);
        r1.d.requestDisallowInterceptTouchEvent(true);
        b r8 = r1.d.getDragCallback();
        if (r8 == null) goto L25;
        r8.onDragStart();
    L29:
        return super.onTouchEvent(r5);
    }

    public final void setDragCallback(b r1) {
        this.a = r1;
    }

    public DraggableContainerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = new a(this);
    }

    public /* synthetic */ DraggableContainerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
