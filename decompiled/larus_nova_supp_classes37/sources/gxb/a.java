package gxb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a extends FrameLayout {
    public int a;
    public int b;
    public Integer[] c;

    /* JADX INFO: renamed from: gxb.a$a, reason: collision with other inner class name */
    public static final class C0142a extends FrameLayout.LayoutParams {
        public final int a;
        public final int b;
        public final int c;
        public final boolean d;

        public C0142a(int r1, int r2, int r3, int r4, int r5, boolean r6) {
            super(r1, r2);
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }
    }

    public a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = new Integer[0];
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r3, int r4) {
        Integer[] r0 = this.c;
        if (r0.length != r3) goto L7;
        return r0[r4].intValue();
    L7:
        return super.getChildDrawingOrder(r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r4, int r5, int r6, int r7, int r8) {
        int r9 = getChildCount();
        Pair[] r10 = new Pair[r9];
        int r11 = 0;
        int r12 = 0;
    L4:
        if (r12 >= r9) goto L7;
        Integer r0 = Integer.valueOf(r12);
        ViewGroup.LayoutParams r1 = getChildAt(r12).getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.officewebview.platform.overlay.OverlayNativeViewLayout.LayoutParams");
        r10[r12] = TuplesKt.to(r0, Integer.valueOf(((C0142a) r1).c));
        r12 = r12 + 1;
        goto L4
    L7:
        if (r9 <= 1) goto L9;
        ArraysKt.sortWith(r10, new b());
    L9:
        Integer[] r13 = new Integer[r9];
        int r2 = 0;
    L10:
        if (r2 >= r9) goto L12;
        r13[r2] = r10[r2].getFirst();
        r2 = r2 + 1;
        goto L10
    L12:
        this.c = r13;
        int r14 = getChildCount();
    L13:
        if (r11 >= r14) goto L18;
        View r15 = getChildAt(r11);
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type com.ss.android.lark.officewebview.platform.overlay.OverlayNativeViewLayout.LayoutParams");
        C0142a r17 = (C0142a) r16;
        int r3 = r17.a;
        int r18 = r17.b;
        if (r17.d == true) goto L17;
        r3 = r3 - this.a;
        r18 = r18 - this.b;
    L17:
        r15.layout(r3, r18, r15.getMeasuredWidth() + r3, r15.getMeasuredHeight() + r18);
        r11 = r11 + 1;
        goto L13
    }
}
