package v19;

import android.view.MotionEvent;
import android.view.View;
import com.larus.bmhome.chat.component.bottom.voice.n;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e implements View.OnTouchListener {
    public final Function1<View, Unit> a;
    public final Function1<View, Unit> b;
    public final Function2<View, MotionEvent, Unit> c;
    public final Function2<View, MotionEvent, Unit> d;
    public final Function2<View, MotionEvent, Unit> e;
    public final long f;
    public d g;
    public boolean h;
    public long i;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Runnable, v19.d] */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(final View r11, MotionEvent r12) {
        Intrinsics.checkNotNullParameter(r11, "v");
        Intrinsics.checkNotNullParameter(r12, "event");
        int r0 = r12.getAction();
        if (r0 == 0) goto L33;
        if (r0 != 1) goto L7;
        r11.removeCallbacks(this.g);
        this.g = null;
        if (this.h == true) goto L28;
        long r1 = System.currentTimeMillis();
        FLogger r13 = FLogger.a;
        r13.i("CompoundTouchListener", "ACTION_UP called 01 lastClickTime=" + this.i + " curClickTime=" + r1 + " gap=" + (r1 - this.i) + " hashCode=" + hashCode());
        if ((r1 - this.i) < 800) goto L31;
        this.i = r1;
        r13.i("CompoundTouchListener", "ACTION_UP called 02 lastClickTime=" + this.i + " hashCode=" + hashCode());
        Function1<View, Unit> r14 = this.a;
        if (r14 == null) goto L31;
        r14.invoke(r11);
    L31:
        return true;
    L28:
        Function2<View, MotionEvent, Unit> r2 = this.d;
        if (r2 == null) goto L31;
        r2.invoke(r11, r12);
        goto L31
    L7:
        if (r0 != 2) goto L9;
        Function2<View, MotionEvent, Unit> r3 = this.e;
        if (r3 == null) goto L20;
        r3.invoke(r11, r12);
    L20:
        return true;
    L9:
        if (r0 == 3) goto L11;
        return false;
    L11:
        r11.removeCallbacks(this.g);
        this.g = null;
        if (this.h == false) goto L16;
        Function2<View, MotionEvent, Unit> r4 = this.c;
        if (r4 == null) goto L16;
        r4.invoke(r11, r12);
    L16:
        return true;
    L33:
        if ((System.currentTimeMillis() - this.i) >= 800) goto L35;
        return true;
    L35:
        this.h = false;
        ?? r15 = new d(this, r11);
        this.g = r15;
        r11.postDelayed(r15, this.f);
        return true;
    }

    public e(Function1 r3, Function1 r4, Function2 r5, Function2 r6, n r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r8 & 32) == 0) goto L20;
        long r0 = 500;
    L21:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r0;
        return;
    L20:
        r0 = 0;
        goto L21
    }
}
