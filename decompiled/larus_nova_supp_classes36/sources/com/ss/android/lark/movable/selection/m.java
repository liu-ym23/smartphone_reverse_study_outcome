package com.ss.android.lark.movable.selection;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.bytedance.lark.lark_markdown_render_android.Lark_markdown_renderKt;
import com.ss.android.lark.log.Log;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class m extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ MovableSelectionManager a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MovableLongPressBehavior.values().length];
            r0[MovableLongPressBehavior.SELECT_ALL_AND_DISPATCH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MovableLongPressBehavior.PARTIAL_SELECTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public m(MovableSelectionManager r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "e");
        MovableSelectionManager r0 = this.a;
        if (r0.h == false) goto L7;
        Log.i("MovableSelectionManager", "gestureDetector onDoubleTap ignored by disableDoubleTapRender, x: " + r6.getX() + ", y: " + r6.getY());
        return false;
    L7:
        if (r0.w != null) goto L9;
        Log.i("MovableSelectionManager", "gestureDetector onDoubleTap event, x: " + r6.getX() + ", y: " + r6.getY());
        MovableSelectionManager.a(this.a);
        MovableSelectionManager r1 = this.a;
        r1.q = true;
        Point r2 = com.ss.android.lark.movable.utils.e.b(r1.a);
        Lark_markdown_renderKt.ffiMovableCallDoubleTap-6Thg8X8(this.a.i(), this.a.g(), this.a.h(), com.ss.android.lark.movable.utils.b.f((r6.getX() + r2.x) - com.ss.android.lark.movable.utils.e.c(this.a.a), this.a.n), com.ss.android.lark.movable.utils.b.f(r6.getY() + r2.y, this.a.n));
    L9:
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "e");
        if (this.a.w != null) goto L13;
        Log.i("MovableSelectionManager", "gestureDetector onLongPress event, x: " + r5.getX() + ", y: " + r5.getY() + ", behavior: " + this.a.i);
        int r0 = a.a[this.a.i.ordinal()];
        if (r0 != 1) goto L7;
        MovableSelectionManager.a(this.a);
        MovableSelectionManager r6 = this.a;
        r6.s = false;
        Lark_markdown_renderKt.ffiMovableCallSelectAll-zly0blg(r6.i(), this.a.g(), this.a.h());
        this.a.a.performLongClick();
        return;
    L7:
        if (r0 != 2) goto L10;
        MovableSelectionManager.a(this.a);
        MovableSelectionManager r1 = this.a;
        r1.q = true;
        Point r2 = com.ss.android.lark.movable.utils.e.b(r1.a);
        Lark_markdown_renderKt.ffiMovableCallLongPress-6Thg8X8(this.a.i(), this.a.g(), this.a.h(), com.ss.android.lark.movable.utils.b.f((r5.getX() + r2.x) - com.ss.android.lark.movable.utils.e.c(this.a.a), this.a.n), com.ss.android.lark.movable.utils.b.f(r5.getY() + r2.y, this.a.n));
        return;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
