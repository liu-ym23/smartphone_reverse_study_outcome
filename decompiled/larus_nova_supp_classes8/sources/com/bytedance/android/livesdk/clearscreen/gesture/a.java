package com.bytedance.android.livesdk.clearscreen.gesture;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.widget.f0;
import com.bytedance.android.livesdk.widget.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements y {
    public static final /* synthetic */ int d = 0;
    public final com.bytedance.android.livesdk.widget.b.a a;
    public InterfaceC0107a b;
    public final GestureDetector c;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.clearscreen.gesture.a$a, reason: collision with other inner class name */
    public interface InterfaceC0107a {
        boolean onSingleTapUp(MotionEvent r1);
    }

    public static final class b {
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r3) {
            Intrinsics.checkNotNullParameter(r3, "e");
            if (this.a.b != null) goto L5;
            int r0 = a.d;
            ALogger.d("AdvanceCSClickGestureBehavior", "callback is null");
        L5:
            InterfaceC0107a r1 = this.a.b;
            if (r1 != null) goto L8;
        L10:
            return false;
        L8:
            if (r1.onSingleTapUp(r3) != true) goto L10;
            return true;
        }
    }

    static {
    }

    public final f0 getConfig() {
        return this.a;
    }

    public a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "ctx");
        this.a = com.bytedance.android.livesdk.widget.b.a.c;
        this.c = new GestureDetector(r3, new c(this));
    }

    public final boolean a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r2, "gestureDetectLayout");
        return false;
    }

    public final boolean b(ViewGroup r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r3, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r4, "ev");
        Intrinsics.checkNotNullParameter(r3, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r4, "ev");
        return false;
    }

    public final boolean c(ViewGroup r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r3, "ev");
        y.a.a(r2, r3);
        return false;
    }

    public final boolean onTouchEvent(ViewGroup r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r3, "gestureDetectLayout");
        Intrinsics.checkNotNullParameter(r4, "ev");
        boolean r5 = this.c.onTouchEvent(r4);
        ALogger.d("AdvanceCSClickGestureBehavior", "onTouchEvent, consume=" + r5 + ", ev=" + r4);
        return r5;
    }
}
