package d58;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends View {
    public boolean a;
    public Function0<Unit> b;
    public Function0<Integer> c;
    public boolean d;

    public static final class a {
    }

    static {
    }

    public final Function0<Integer> getBottomBlockHeightProvider() {
        return this.c;
    }

    public final boolean getDisableGesture() {
        return this.a;
    }

    public final Function0<Unit> getOnBlockedGesture() {
        return this.b;
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(0);
        setClickable(false);
        setFocusable(false);
        setFocusableInTouchMode(false);
    }

    @Override // android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        boolean r1 = true;
        if (this.a == true) goto L5;
        int r0 = r5.getActionMasked();
        if (r0 == 0) goto L18;
        if (r0 != 1) goto L14;
    L16:
        boolean r6 = this.d;
        this.d = false;
        return r6;
    L14:
        if (r0 == 3) goto L16;
    L37:
        return this.d;
    L18:
        Function0<Integer> r2 = this.c;
        if (r2 == null) goto L29;
        Integer r3 = Integer.valueOf(((Number) r2.invoke()).intValue());
        if (r3.intValue() <= 0) goto L23;
        boolean r4 = true;
    L24:
        if (r4 == true) goto L27;
        r3 = null;
    L27:
        if (r3 == null) goto L29;
        int r7 = r3.intValue();
    L30:
        if (r7 > 0) goto L32;
    L34:
        r1 = false;
    L35:
        this.d = r1;
        goto L37
    L32:
        if (r5.getY() < (getHeight() - r7)) goto L34;
    L23:
        r4 = false;
    L29:
        r7 = 0;
        goto L30
    L5:
        if (r5.getActionMasked() != 0) goto L9;
        Function0<Unit> r8 = this.b;
        if (r8 == null) goto L9;
        r8.invoke();
    L9:
        return true;
    }

    public final void setBottomBlockHeightProvider(Function0<Integer> r1) {
        this.c = r1;
    }

    public final void setDisableGesture(boolean r1) {
        this.a = r1;
    }

    public final void setOnBlockedGesture(Function0<Unit> r1) {
        this.b = r1;
    }
}
