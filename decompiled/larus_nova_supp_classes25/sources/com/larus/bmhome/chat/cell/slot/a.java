package com.larus.bmhome.chat.cell.slot;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.larus.bmhome.chat.layout.widget.ChatCheckBox;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a implements ed8.e {
    public final ChatCheckBox a;
    public final GestureDetector b;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.cell.slot.a$a, reason: collision with other inner class name */
    public static final class C0041a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ a a;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onDown(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            return true;
        }

        public C0041a(a r1) {
            this.a = r1;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final void onLongPress(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            this.a.a.performClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onSingleTapUp(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            this.a.a.performClick();
            return true;
        }
    }

    @Override // ed8.e
    public final boolean c() {
        return this.a.getInterceptTouchEvent();
    }

    @Override // ed8.e
    public final GestureDetector b() {
        return this.b;
    }

    public a(ChatCheckBox r3) {
        Intrinsics.checkNotNullParameter(r3, "chatCheckBox");
        this.a = r3;
        this.b = new GestureDetector(r3.getContext(), new C0041a(this));
    }

    @Override // ed8.e
    public final boolean a(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (this.a.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
