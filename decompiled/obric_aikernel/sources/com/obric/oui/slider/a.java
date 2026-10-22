package com.obric.oui.slider;

import android.content.Context;
import android.view.View;
import android.widget.SeekBar;
import androidx.annotation.RequiresApi;
import ea.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f7439c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f7440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7441b;

    /* JADX INFO: renamed from: com.obric.oui.slider.a$a, reason: collision with other inner class name */
    public static final class C0134a {
        private C0134a() {
        }

        public /* synthetic */ C0134a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new C0134a(null);
        f7439c = "SeekBarVibrateHelper";
    }

    public a() {
        this.f7441b = Integer.MAX_VALUE;
    }

    private final void b(Context r10, int r11, String r12, boolean r13, View r14) {
        if (this.f7441b >= 2) goto L10;
        b.a(f7439c, "vibrateIfNeeded: " + r12);
        if (r13 == false) goto L7;
        q9.a.b(r10, r11);
    L8:
        this.f7441b++;
        return;
    L7:
        q9.a.f12489c.a(r14, r11);
        goto L8
    }

    static /* synthetic */ void c(a r10, Context r11, int r12, String r13, boolean r14, View r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        r14 = true;
    L5:
        boolean r18 = r14;
        if ((r16 & 16) == 0) goto L8;
        r15 = null;
    L8:
        r10.b(r11, r12, r13, r18, r15);
    }

    @RequiresApi(26)
    public final void a(Context r11, SeekBar r12, int r13, boolean r14, int r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "seekBar");
        if (r14 == false) goto L5;
        this.f7441b = 0;
    L5:
        int r10 = r12.getMin();
        int r17 = r12.getMax();
        if (r13 != r10) goto L9;
        int r18 = 5;
        boolean r19 = false;
        View r20 = null;
        int r21 = 24;
        Object r22 = null;
        String r23 = "hit minProgress";
    L8:
        c(this, r11, r18, r23, r19, r20, r21, r22);
        return;
    L9:
        if (r13 != r17) goto L11;
        r18 = 4;
        r19 = false;
        r20 = null;
        r21 = 24;
        r22 = null;
        r23 = "hit maxProgress";
        goto L8
    L11:
        int r24 = 1;
        int r25 = r15 - 1;
        if (r16 == false) goto L34;
        if (r25 > 1) goto L15;
        return;
    L15:
        if (this.f7440a == null) goto L26;
        float r26 = (r17 - r10) / r25;
    L17:
        if (r24 >= r25) goto L26;
        int r27 = MathKt.roundToInt(r24 * r26) + r10;
        Integer r28 = this.f7440a;
        Intrinsics.checkNotNull(r28);
        if (r28.intValue() >= r27) goto L21;
        if (r13 < r27) goto L21;
    L24:
        b(r11, 26, "passed boundary: " + r24 + '/' + r25 + ", progress: " + r13, false, r12);
    L21:
        Integer r29 = this.f7440a;
        Intrinsics.checkNotNull(r29);
        if (r29.intValue() <= r27) goto L25;
        if (r13 <= r27) goto L24;
    L25:
        r24 = r24 + 1;
    L26:
        this.f7440a = Integer.valueOf(r13);
        return;
    }
}
