package com.larus.bmhome.view;

import android.view.MotionEvent;
import android.view.View;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j2 implements View.OnTouchListener {
    public final Function1<View, Unit> a;
    public final Function1<View, Unit> b;
    public final long c;
    public i2 d;
    public boolean e;
    public long f;

    public static final class a {
    }

    static {
    }

    public j2(Function1 r2, Function1 r3) {
        Intrinsics.checkNotNullParameter(r2, "onLongPress");
        Intrinsics.checkNotNullParameter(r3, "onLongPressCancel");
        this.a = r2;
        this.b = r3;
        this.c = 200;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v3, types: [com.larus.bmhome.view.i2, java.lang.Runnable] */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(final View r11, MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r11, "v");
        Intrinsics.checkNotNullParameter(r12, "event");
        int r13 = r12.getAction();
        if (r13 == 0) goto L16;
        if (r13 != 1) goto L6;
        r11.removeCallbacks(this.d);
        this.d = null;
        this.b.invoke(r11);
        if (this.e == true) goto L14;
        long r4 = System.currentTimeMillis();
        FLogger r14 = FLogger.a;
        r14.i("LongPressTouchListener", "ACTION_UP called 01 lastClickTime=" + this.f + " curClickTime=" + r4 + " gap=" + (r4 - this.f) + " hashCode=" + hashCode());
        if ((r4 - this.f) < 800) goto L14;
        this.f = r4;
        r14.i("LongPressTouchListener", "ACTION_UP called 02 lastClickTime=" + this.f + " hashCode=" + hashCode());
        r11.performClick();
    L14:
        return true;
    L6:
        if (r13 == 2) goto L8;
        return false;
    L8:
        return true;
    L16:
        if ((System.currentTimeMillis() - this.f) >= 800) goto L18;
        return true;
    L18:
        this.e = false;
        ?? r15 = new i2(this, r11);
        this.d = r15;
        r11.postDelayed(r15, this.c);
        return true;
    }
}
