package com.obric.assistant.activation.presentation.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.lynx.textra.PlatformFontCaps;
import com.obric.assistant.activation.presentation.contract.ObricListeningViewState;
import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kba.c;
import kba.e;
import kba.o;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricListeningVisualView extends FrameLayout {
    public static final /* synthetic */ int i = 0;
    public final boolean a;
    public final e b;
    public final o c;
    public final TextView d;
    public ObricListeningVisualMode e;
    public boolean f;
    public boolean g;
    public final Lazy h;

    public static final class a {
        @JvmStatic
        public static int a(Context r1) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Resources r2 = r1.getResources();
            return (int) ((WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).density * 250.0f) + 0.5f);
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ObricListeningVisualMode.values().length];
            r0[ObricListeningVisualMode.HIDDEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ObricListeningVisualMode.CLICK_TALK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ObricListeningVisualMode.PRESS_TALK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ObricListeningVisualMode.LOADING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public /* synthetic */ ObricListeningVisualView() {
        throw null;
    }

    private final c getFakeAmplitudePlayer() {
        return (c) this.h.getValue();
    }

    public final void b() {
        if (this.g == false) goto L6;
        return;
    L6:
        if (this.a == false) goto L10;
        c r0 = getFakeAmplitudePlayer();
        if (r0 == null) goto L10;
        r0.e = true;
        r0.a("real_amplitude_confirmed");
    L10:
        this.g = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        e(ObricListeningViewState.d);
        super.onDetachedFromWindow();
    }

    public ObricListeningVisualView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, false);
    }

    public static boolean d(ObricListeningVisualMode r1) {
        if (r1 != ObricListeningVisualMode.CLICK_TALK) goto L5;
    L8:
        return true;
    L5:
        if (r1 == ObricListeningVisualMode.PRESS_TALK) goto L8;
        return false;
    }

    public final void a(float r5) {
        if (this.f == true) goto L5;
        return;
    L5:
        Float r6 = Float.valueOf(r5);
        float r0 = r6.floatValue();
        boolean r2 = false;
        if (Float.isInfinite(r0) == false) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == true) goto L14;
        r6 = null;
    L14:
        float r3 = 0.0f;
        if (r6 == null) goto L17;
        r3 = RangesKt.coerceIn(r6.floatValue(), 0.0f, 1.0f);
    L17:
        this.b.setAmplitude(r3);
        ObricListeningVisualMode r7 = this.e;
        if (r7 != null) goto L20;
    L22:
        if (r2 == false) goto L25;
        this.c.setAmplitude(r3);
        return;
    L25:
        return;
    L20:
        if (d(r7) != true) goto L22;
        r2 = true;
        goto L22
    L8:
        if (Float.isNaN(r0) == true) goto L10;
        r1 = true;
        goto L11
    }

    public final int c(float r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public final void e(ObricListeningViewState r11) {
        Intrinsics.checkNotNullParameter(r11, "state");
        if (this.g == true) goto L7;
        c r0 = getFakeAmplitudePlayer();
        if (r0 == null) goto L7;
        r0.d = r11.b();
        r0.b("view_rendered");
    L7:
        boolean r4 = false;
        if (r11.b() == true) goto L11;
        this.f = false;
        e r12 = this.b;
        r12.e = false;
        r12.f = 0.0f;
        r12.g = 0.0f;
        r12.h = 0.0f;
        r12.i = 0.0f;
        r12.j = 0.0f;
        r12.k = 0;
        r12.l = 0;
        r12.m = 0;
        r12.n = 0;
        r12.invalidate();
        this.c.e();
        this.d.setVisibility(4);
        this.c.setVisibility(4);
        this.e = null;
        setVisibility(4);
        return;
    L11:
        setVisibility(0);
        ObricListeningVisualMode r1 = r11.a;
        ObricListeningVisualMode r6 = this.e;
        if (r1 == r6) goto L39;
        if (r6 != null) goto L16;
    L18:
        boolean r7 = false;
    L19:
        this.e = r1;
        boolean r8 = d(r1);
        int r2 = b.a[r1.ordinal()];
        if (r2 != 1) goto L22;
        this.d.setVisibility(4);
        this.c.setVisibility(4);
    L33:
        if (this.f == false) goto L39;
        if (r8 == false) goto L37;
        this.c.b(!r7);
        goto L39
    L37:
        this.c.e();
        goto L39
    L22:
        if (r2 != 2) goto L24;
        this.d.setText(2131912030);
        this.d.setVisibility(0);
        this.c.setVisibility(0);
        goto L33
    L24:
        if (r2 == 3) goto L29;
        if (r2 != 4) goto L28;
        this.d.setVisibility(4);
        this.c.setVisibility(4);
        goto L33
    L28:
        throw new NoWhenBranchMatchedException();
    L29:
        this.d.setText(2131912177);
        this.d.setVisibility(0);
        this.c.setVisibility(0);
        goto L33
    L16:
        if (d(r6) != true) goto L18;
        r7 = true;
    L39:
        if (this.f == true) goto L52;
        this.f = true;
        e r3 = this.b;
        if (r3.e == true) goto L45;
        r3.e = true;
        r3.f = 0.0f;
        r3.g = 0.0f;
        r3.h = 0.0f;
        r3.i = 0.0f;
        r3.j = 0.0f;
        r3.k = 0;
        r3.l = 0;
        r3.m = 0;
        r3.n = 0;
        r3.postInvalidateOnAnimation();
    L45:
        ObricListeningVisualMode r5 = this.e;
        if (r5 != null) goto L48;
    L50:
        if (r4 == false) goto L52;
        this.c.b(true);
        goto L52
    L48:
        if (d(r5) != true) goto L50;
        r4 = true;
    L52:
        a(r11.c);
    }

    public ObricListeningVisualView(Context r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        this.a = r7;
        e r8 = new e(r6);
        this.b = r8;
        o r0 = new o(r6);
        this.c = r0;
        TextView r1 = new TextView(r6);
        r1.setGravity(17);
        r1.setTextColor(-1291845633);
        r1.setTextSize(1, 14.0f);
        r1.setTypeface(Typeface.create(Typeface.create(PlatformFontCaps.DEFAULT_FAMILY_NAME, 0), 500, false));
        r1.setVisibility(4);
        this.d = r1;
        this.h = LazyKt.lazy(LazyThreadSafetyMode.NONE, new com.obric.assistant.activation.presentation.ui.a(this));
        setVisibility(4);
        setImportantForAccessibility(2);
        setClipChildren(false);
        setClipToPadding(false);
        addView(r8, new FrameLayout.LayoutParams(-1, -1));
        FrameLayout.LayoutParams r9 = new FrameLayout.LayoutParams(c(210.0f), c(24.0f), 81);
        r9.bottomMargin = c(48.0f);
        Unit r10 = Unit.INSTANCE;
        addView(r0, r9);
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2, 81);
        r11.bottomMargin = c(91.0f);
        addView(r1, r11);
    }
}
