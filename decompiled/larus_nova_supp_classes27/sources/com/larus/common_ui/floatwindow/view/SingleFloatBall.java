package com.larus.common_ui.floatwindow.view;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewKt;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.w0;
import hq9.f1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class SingleFloatBall extends FrameLayout {
    public final m0 a;
    public final h b;
    public final z c;
    public final u d;
    public final WindowManager.LayoutParams e;
    public final ViewGroup f;
    public final ViewGroup g;
    public final ViewGroup h;
    public final ImageView i;
    public final ImageView j;
    public final Lazy k;
    public int l;

    public static final class a {
    }

    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.Key r1) {
            super(r1);
        }

        public final void handleException(CoroutineContext r3, Throwable r4) {
            FLogger.a.e("SingleFloatBall", "autoUpdateBlurMask CoroutineScope fail: " + r4);
        }
    }

    static {
    }

    private final f1 getFloatWindowConfig() {
        return (f1) this.k.getValue();
    }

    public final void a() {
        Bitmap r0 = ViewKt.drawToBitmap$default(this.f, null, 1, null);     // Catch: Exception -> L8
        float r5 = 1024;
        float r3 = r0.getWidth();     // Catch: Exception -> L8
        float r4 = r0.getHeight();     // Catch: Exception -> L8
        float r6 = Math.min(r5 / r3, r5 / r4);     // Catch: Exception -> L8
        if (r6 >= 1.0d) goto L6;
        r0 = Bitmap.createScaledBitmap(r0, (int) (r3 * r6), (int) (r4 * r6), true);     // Catch: Exception -> L8
    L6:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new b(CoroutineExceptionHandler.Key), null, new SingleFloatBall$autoUpdateBlurMask$2(this, r0, null), 2, null);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.a.e("SingleFloatBall", "autoUpdateBlurMask fail: " + e);
    }

    public final boolean b() {
        if ((this.e.gravity & 7) != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final u getHotInfo() {
        return this.d;
    }

    public final WindowManager.LayoutParams getParams() {
        return this.e;
    }

    public final void c(WindowManager.LayoutParams r4) {
        Intrinsics.checkNotNullParameter(r4, "params");
        this.b.updateViewLayout(this, r4);
        m0 r5 = this.a;
        WindowManager.LayoutParams r0 = r5.g.getParams();
        if (r0.x >= 0) goto L13;
        SingleFloatBall r1 = r5.g;
        if (r1.b() == false) goto L7;
        ImageView r2 = r1.i;
    L8:
        e1.o(r2);
        float r3 = RangesKt.coerceAtMost(Math.abs(r0.x) / (r0.width / 2), 1.0f);
        SingleFloatBall r6 = r5.g;
        if (r6.b() == false) goto L11;
        ViewGroup r7 = r6.g;
    L12:
        r7.setAlpha(r3);
        e1.x(r7);
        return;
    L11:
        r7 = r6.h;
        goto L12
    L7:
        r2 = r1.j;
        goto L8
    L13:
        SingleFloatBall r8 = r5.g;
        if (r8.b() == false) goto L16;
        ViewGroup r9 = r8.g;
    L17:
        e1.o(r9);
        return;
    L16:
        r9 = r8.h;
        goto L17
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "ev");
        if (r6.getActionMasked() != 0) goto L8;
        e19.t r0 = e19.t.j;
        e19.t r1 = e19.t.a.a();
        if (r1 == null) goto L7;
        r1.k(null);
    L7:
        a();
    L8:
        z r2 = this.c;
        r2.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        Intrinsics.checkNotNullParameter(r6, "event");
        int r3 = r6.getActionMasked();
        boolean r4 = false;
        if (r3 != 0) goto L11;
        r2.a(this, r6);
    L22:
        return r4;
    L11:
        if (r3 != 2) goto L22;
        if (r2.i == true) goto L23;
        float r5 = r6.getRawX() - r2.e;
        float r7 = r6.getRawY() - r2.f;
        if (((r5 * r5) + (r7 * r7)) <= r2.c) goto L19;
        r4 = true;
    L19:
        r2.i = r4;
        goto L22
    L23:
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r11, "event");
        z r1 = this.c;
        r1.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        Intrinsics.checkNotNullParameter(r11, "event");
        int r0 = r11.getActionMasked();
        if (r0 == 0) goto L50;
        if (r0 != 1) goto L6;
        View.OnClickListener r2 = r1.b;
        if (r2 != null) goto L46;
    L51:
        int r12 = r11.getActionMasked();
        if (r12 == 0) goto L57;
        if (r12 == 1) goto L56;
        if (r12 == 3) goto L56;
    L58:
        return true;
    L56:
        this.a.n(false, false);
        goto L58
    L57:
        this.a.getClass();
        goto L58
    L46:
        if (r1.i == true) goto L51;
        if ((SystemClock.uptimeMillis() - r1.h) > r1.d) goto L51;
        r2.onClick(this);
        goto L51
    L6:
        if (r0 != 2) goto L51;
        if (r1.i == true) goto L17;
        float r3 = r11.getRawX() - r1.e;
        float r5 = r11.getRawY() - r1.f;
        if (((r3 * r3) + (r5 * r5)) <= r1.c) goto L13;
        boolean r4 = true;
    L14:
        r1.i = r4;
        if (r4 == true) goto L17;
    L13:
        r4 = false;
    L17:
        WindowManager.LayoutParams r6 = r1.a.getParams();
        Integer r7 = Integer.valueOf(r1.g);
        if (r7.intValue() <= 0) goto L20;
        boolean r8 = true;
    L21:
        if (r8 == true) goto L24;
        r7 = null;
    L24:
        if (r7 == null) goto L26;
        int r9 = r7.intValue();
    L27:
        int r10 = (int) (r11.getRawX() - r1.e);
        int r13 = (int) (r11.getRawY() - r1.f);
        r1.e = r11.getRawX();
        r1.f = r11.getRawY();
        int r14 = r6.gravity & 7;
        if (r14 != 3) goto L30;
        int r15 = r6.x + r10;
    L31:
        r6.x = r15;
        r6.y += r13;
        if (r14 != 3) goto L37;
        int r16 = r6.width;
        if (((r16 / 2) + r15) < (r9 / 2)) goto L40;
        r6.x = (r9 - r15) - r16;
    L41:
        int r17 = 5;
    L42:
        r6.gravity = r17 | 48;
        r1.a.c(r6);
    L40:
        r17 = 3;
        goto L42
    L37:
        int r18 = r6.width;
        if (((r18 / 2) + r15) <= (r9 / 2)) goto L41;
        r6.x = (r9 - r15) - r18;
        goto L40
    L30:
        r15 = r6.x - r10;
        goto L31
    L26:
        r9 = com.larus.utils.i.d(getContext());
        goto L27
    L20:
        r8 = false;
        goto L21
    L50:
        r1.a(this, r11);
        goto L51
    }

    @Override // android.view.View
    public void setAlpha(float r4) {
        h r0 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        Iterator<T> r1 = r0.a.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((Pair) r2).getFirst(), this) == false) goto L4;
    L9:
        Pair r3 = (Pair) r2;
        if (r3 == null) goto L13;
        ((ImageView) r3.getSecond()).setAlpha(r4);
    L13:
        super.setAlpha(r4);
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final void setClipViewCornerRadius(int r6) {
        this.l = r6;
        h r0 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        w0.e(this, r6);
        r0.e = r6;
        Intrinsics.checkNotNullParameter(this, "view");
        Iterator<T> r1 = r0.a.iterator();
    L3:
        ImageView r3 = null;
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((Pair) r2).getFirst(), this) == false) goto L3;
    L9:
        Pair r4 = (Pair) r2;
        if (r4 == null) goto L12;
        r3 = (ImageView) r4.getSecond();
    L12:
        if (r3 == null) goto L18;
        r3.setImageBitmap(h.c(r3.getLayoutParams().width, r3.getLayoutParams().height, r6, r0.d, r0.f));
        return;
    L18:
        return;
    L8:
        r2 = null;
        goto L9
    }

    public final void setMaskClickListener(View.OnClickListener r4) {
        if (b() == false) goto L5;
        this.g.setOnClickListener(r4);
    L7:
        if (r4 == null) goto L13;
        h r1 = this.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        View r2 = (View) ((LinkedHashMap) r1.b).get(this);
        if (r2 == null) goto L11;
        r2.setVisibility(0);
        r2.setOnClickListener(r4);
    L12:
        if (r2 == null) goto L13;
        return;
    L11:
        r2 = null;
    L13:
        h r5 = this.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(this, "view");
        View r6 = (View) ((LinkedHashMap) r5.b).get(this);
        if (r6 == null) goto L16;
        r6.setVisibility(8);
    L16:
        Unit r7 = Unit.INSTANCE;
        return;
    L5:
        this.h.setOnClickListener(r4);
        goto L7
    }

    public SingleFloatBall(Application r5, m0 r6, h r7) {
        Intrinsics.checkNotNullParameter(r5, "application");
        Intrinsics.checkNotNullParameter(r6, "handler");
        Intrinsics.checkNotNullParameter(r7, "winManager");
        super(r5);
        this.a = r6;
        this.b = r7;
        this.k = LazyKt.lazy(new x());
        View r8 = LayoutInflater.from(r5).inflate(2131562335, this, false);
        addView(r8);
        FragmentActivity r9 = AppHost.a.a().getCurrentActivity();
        if ((r9 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r10 = r9;
    L6:
        if (r10 == null) goto L8;
        int r11 = com.larus.utils.u.b(r10);
    L9:
        int r12 = r11 + c7.b(12);
        int r2 = c7.b(6);
        this.d = new u(r2, com.larus.utils.i.e(getContext()) + c7.b(12), r12);
        this.f = (ViewGroup) r8.findViewById(2131367728);
        this.g = (ViewGroup) r8.findViewById(2131377704);
        this.h = (ViewGroup) r8.findViewById(2131384519);
        if (getFloatWindowConfig().d() == true) goto L12;
        int r13 = 2131377705;
    L16:
        this.i = (ImageView) r8.findViewById(r13);
        if (getFloatWindowConfig().d() == true) goto L19;
        int r14 = 2131384520;
    L23:
        this.j = (ImageView) r8.findViewById(r14);
        WindowManager.LayoutParams r15 = new WindowManager.LayoutParams();
        r15.format = -2;
        r15.flags = 552;
        if (Build.VERSION.SDK_INT >= 26) goto L26;
        r15.type = 2003;
    L27:
        this.e = r15;
        r15.gravity = 53;
        r15.x = r2;
        r15.y = com.larus.utils.i.e(getContext()) + c7.b(80);
        r15.width = 0;
        r15.height = 0;
        z r16 = new z(this);
        this.c = r16;
        r16.b = new y(this);
        this.l = c7.b(8);
        return;
    L26:
        r15.type = 2038;
        goto L27
    L19:
        if (getFloatWindowConfig().e() == false) goto L21;
        r14 = 2131384521;
        goto L23
    L21:
        r14 = 2131384522;
        goto L23
    L12:
        if (getFloatWindowConfig().e() == false) goto L14;
        r13 = 2131377706;
        goto L16
    L14:
        r13 = 2131377707;
        goto L16
    L8:
        com.larus.utils.i0.a.getClass();
        r11 = com.larus.utils.i0.e();
        goto L9
    L5:
        r10 = null;
        goto L6
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        w0.e(this, this.l);
    }
}
