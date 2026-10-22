package iwb;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.service.floatwindow.model.MmRecordingFloatSide;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ a a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        d r0 = this.a.i;
        FrameLayout r1 = r0.a.getFloatView$officesdk_minutes_base_ui_release();
        if (r0.a.isLaidOut() == true) goto L5;
    L53:
        boolean r2 = false;
    L54:
        if (r2 == true) goto L56;
        return true;
    L56:
        a r3 = this.a;
        b r4 = r3.m;
        if (r4 != null) goto L60;
    L63:
        a r5 = this.a;
        if (r5.l == false) goto L67;
        r5.removeCallbacks(r5.p);
        r5.postDelayed(r5.p, 3000);
    L67:
        int r6 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FLOAT, "onFirstPositioned", "notify", null, 8);
        Function0<Unit> r7 = this.a.getOnFirstPositioned$officesdk_minutes_base_ui_release();
        if (r7 == null) goto L70;
        r7.invoke();
    L70:
        return false;
    L60:
        if (r3.getViewTreeObserver().isAlive() == false) goto L62;
        r3.getViewTreeObserver().removeOnPreDrawListener(r4);
    L62:
        r3.m = null;
        goto L63
    L5:
        if (r1.getWidth() <= 0) goto L53;
        if (r1.getHeight() <= 0) goto L53;
        ViewGroup.LayoutParams r8 = r1.getLayoutParams();
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r9 = (FrameLayout.LayoutParams) r8;
        if (r9.leftMargin == 0) goto L12;
    L51:
        r1.setVisibility(0);
    L52:
        r2 = true;
        goto L54
    L12:
        if (r9.topMargin != 0) goto L51;
        if (r9.gravity == 0) goto L51;
        hwb.d r10 = r0.j;
        if (r10 != null) goto L19;
        r10 = new hwb.d(0);
    L19:
        MmRecordingFloatSide r11 = r10.b;
        MmRecordingFloatSide r12 = MmRecordingFloatSide.RIGHT;
        if (r11 != r12) goto L22;
        boolean r13 = true;
    L23:
        r0.f = r13;
        boolean r14 = r10.a;
        boolean r15 = !r14;
        r0.d = r15;
        r0.e = r15;
        r9.gravity = 0;
        Integer r16 = r10.c;
        if (r16 == null) goto L26;
        int r17 = r16.intValue();
    L33:
        r9.leftMargin = r17;
        Integer r18 = r10.d;
        if (r18 == null) goto L36;
        int r19 = r18.intValue();
    L37:
        r9.topMargin = r19;
        r9.rightMargin = 0;
        r9.bottomMargin = 0;
        r1.setLayoutParams(r9);
        if (r10.a == false) goto L40;
        r0.f(r9.leftMargin, r9.topMargin);
    L50:
        r0.a.c(r0.e, r0.f);
        r0.a.b(r0.c());
        int r20 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FLOAT, "initPosition", "left=" + r9.leftMargin + ", top=" + r9.topMargin + ", expandedX=" + r0.g + ", expandedY=" + r0.h, null, 8);
        goto L52
    L40:
        Integer r21 = r10.f;
        if (r21 == null) goto L46;
        if (r10.g == null) goto L46;
        int r22 = r21.intValue();
        int r23 = r10.g.intValue();
        e r24 = r0.b;
        r24.getClass();
        r0.g = Integer.valueOf(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r22, 0), r24.a()));
        r0.h = Integer.valueOf(r0.b.c(r23));
    L46:
        if (r10.b != r12) goto L48;
        int r25 = r0.b.a();
    L49:
        int r26 = r9.topMargin;
        e r27 = r0.b;
        r27.getClass();
        r0.g = Integer.valueOf(RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r25, 0), r27.a()));
        r0.h = Integer.valueOf(r0.b.c(r26));
        goto L50
    L48:
        r25 = 0;
        goto L49
    L36:
        r19 = r0.b.b();
        goto L37
    L26:
        if (r14 == false) goto L30;
        if (r11 != r12) goto L29;
        r17 = r0.b.a();
        goto L33
    L29:
        r17 = 0;
        goto L33
    L30:
        if (r11 != r12) goto L32;
        r17 = r0.b.e();
        goto L33
    L32:
        r17 = r0.b.d();
        goto L33
    L22:
        r13 = false;
        goto L23
    }

    public b(a r1) {
        this.a = r1;
    }
}
