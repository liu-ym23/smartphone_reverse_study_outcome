package w3;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.ai.applet.page.g;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
    public final Function1<Integer, Unit> a;
    public WeakReference<View> b;
    public Integer c;

    public static final class a {
    }

    static {
    }

    public final void a() {
        WeakReference<View> r0 = this.b;
        if (r0 == null) goto L10;
        View r1 = r0.get();
        if (r1 == null) goto L10;
        ViewTreeObserver r10 = r1.getViewTreeObserver();
        if (r10.isAlive() == false) goto L9;
        r10.removeOnGlobalLayoutListener(this);
    L9:
        r1.removeOnAttachStateChangeListener(this);
    L10:
        WeakReference<View> r11 = this.b;
        if (r11 == null) goto L13;
        r11.clear();
    L13:
        this.b = null;
        this.c = null;
    }

    public final void b() {
        WeakReference<View> r0 = this.b;
        if (r0 == null) goto L37;
        View r1 = r0.get();
        if (r1 == null) goto L39;
        View r10 = r1.getRootView();
        if (r10 != null) goto L10;
        r10 = r1;
    L10:
        int r11 = r10.getHeight();
        if (r11 > 0) goto L13;
        Integer r12 = null;
    L24:
        if (r12 == null) goto L38;
        int r13 = r12.intValue();
        Integer r14 = this.c;
        if (r14 != null) goto L32;
        this.c = Integer.valueOf(r13);
        if (r13 <= 0) goto L36;
        this.a.invoke(Integer.valueOf(r13));
        return;
    L36:
        return;
    L32:
        if (r14.intValue() != r13) goto L34;
        return;
    L34:
        this.c = Integer.valueOf(r13);
        this.a.invoke(Integer.valueOf(r13));
        return;
    L38:
        return;
    L13:
        WindowInsetsCompat r15 = ViewCompat.getRootWindowInsets(r1);
        if (r15 == null) goto L20;
        int r16 = RangesKt.coerceAtLeast(r15.getInsets(WindowInsetsCompat.Type.ime()).bottom - r15.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom, 0);
        if (r16 <= 0) goto L18;
    L19:
        r12 = Integer.valueOf(r16);
        goto L24
    L18:
        if (r15.isVisible(WindowInsetsCompat.Type.ime()) == true) goto L19;
    L20:
        Rect r17 = new Rect();
        r10.getWindowVisibleDisplayFrame(r17);
        int r18 = RangesKt.coerceAtLeast(r11 - r17.bottom, 0);
        if (r18 <= (r11 * 0.15f)) goto L23;
        r12 = Integer.valueOf(r18);
        goto L24
    L23:
        r12 = 0;
        goto L24
    L39:
        return;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        b();
    }

    public b(g r10) {
        Intrinsics.checkNotNullParameter(r10, "onHeightChanged");
        this.a = r10;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r10) {
        Intrinsics.checkNotNullParameter(r10, "v");
        WeakReference<View> r0 = this.b;
        if (r0 == null) goto L5;
        View r1 = r0.get();
    L6:
        if (r1 == r10) goto L8;
        return;
    L8:
        ViewTreeObserver r11 = r10.getViewTreeObserver();
        if (r11.isAlive() == false) goto L11;
        r11.addOnGlobalLayoutListener(this);
    L11:
        b();
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r10) {
        Intrinsics.checkNotNullParameter(r10, "v");
        ViewTreeObserver r11 = r10.getViewTreeObserver();
        if (r11.isAlive() == false) goto L6;
        r11.removeOnGlobalLayoutListener(this);
        return;
    }
}
