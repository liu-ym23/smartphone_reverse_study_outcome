package com.ss.android.lark.lynxkit.container;

import android.view.View;
import com.lynx.tasm.LynxView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import sqb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements View.OnLayoutChangeListener {
    public static final /* synthetic */ int c = 0;
    public final LynxView a;
    public final b b;

    /* JADX INFO: renamed from: com.ss.android.lark.lynxkit.container.a$a, reason: collision with other inner class name */
    public static final class C0172a {
    }

    static {
    }

    public final void a() {
        int r0 = this.a.getWidth();
        int r1 = this.a.getHeight();
        if (r0 <= 0) goto L12;
        if (r1 <= 0) goto L12;
        int r3 = RangesKt.coerceAtLeast(r0 - this.b.getIntrinsicWidth(), 0);
        if (this.a.getLayoutDirection() != 1) goto L9;
        b r4 = this.b;
        int r2 = RangesKt.coerceIn((r0 - r4.d) - r4.getIntrinsicWidth(), 0, r3);
    L10:
        b r5 = this.b;
        int r6 = RangesKt.coerceAtLeast((r1 - r5.d) - r5.getIntrinsicHeight(), 0);
        b r7 = this.b;
        r7.setBounds(r2, r6, r7.getIntrinsicWidth() + r2, this.b.getIntrinsicHeight() + r6);
        return;
    L9:
        r2 = RangesKt.coerceAtMost(this.b.d, r3);
    L12:
        this.b.setBounds(0, 0, 0, 0);
    }

    public a(LynxView r2, b r3) {
        this.a = r2;
        this.b = r3;
        r2.getOverlay().add(r3);
        r2.addOnLayoutChangeListener(this);
        a();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r1, "view");
        a();
    }
}
