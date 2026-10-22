package com.ss.android.lark.movable.selection;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.movable.MovableView;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k extends View {
    public final /* synthetic */ MovableView a;
    public final /* synthetic */ Function0<Unit> b;

    public static final class a implements Runnable {
        public final /* synthetic */ Function0<Unit> a;

        public a(Function0<Unit> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (r5.getAction() != 0) goto L21;
        MovableSelectionManager r0 = this.a.getRootMovableView().getSelectionManager$movable_release();
        if (r0 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L12;
        return false;
    L12:
        if (r0 == null) goto L20;
        Pair<Rect, Rect> r1 = r0.b(true);
        if (r1 == null) goto L20;
        Rect r2 = (Rect) r1.component1();
        Rect r4 = (Rect) r1.component2();
        int r6 = (int) r5.getRawX();
        int r7 = (int) r5.getRawY();
        if (r2.contains(r6, r7) == false) goto L18;
    L19:
        return false;
    L18:
        if (r4.contains(r6, r7) == true) goto L19;
    L20:
        Log.d("Movable_SelectionDialog", "dispatchTouchEvent: cancel selection by spyView");
        post(new a(this.b));
        goto L21
    L7:
        if (r0.g != true) goto L9;
        r3 = true;
    L21:
        return false;
    }

    public k(Context r1, MovableView r2, Function0<Unit> r3) {
        this.a = r2;
        this.b = r3;
        super(r1);
    }
}
