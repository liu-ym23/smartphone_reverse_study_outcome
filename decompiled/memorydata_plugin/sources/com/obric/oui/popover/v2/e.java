package com.obric.oui.popover.v2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.obric.oui.common.util.h;
import com.obric.oui.popover.FakeAnchorView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002JR\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006H\u0007JF\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006JN\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006J>\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006J<\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0007J<\u0010\u001d\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u000e\u001a\u00020\u0006H\u0007J>\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u000e\u001a\u00020\u0006JL\u0010$\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002JT\u0010%\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/oui/popover/v2/OPopoverHelperEx;", "", "()V", "TAG", "", "resolvePreferredGravity", "", "adaptedGravity", "rotationDegrees", "resolveWindowBounds", "Landroid/graphics/Rect;", "anchor", "Landroid/view/View;", "rotateGravityClockwise", "gravity", "rotateGravityCounterClockwise", "showPopoverSmartly", "", "popover", "Lcom/obric/oui/popover/v2/OPopover;", "coverAnchor", "", "margin", "focusable", "widthMeasureSpec", "heightMeasureSpec", "Lcom/obric/oui/popover/v2/OPopoverModal;", "parent", "Landroid/view/ViewGroup;", "showPopoverSmartlyAtLocation", "activity", "Landroid/app/Activity;", "anchorX", "anchorY", "dialog", "Landroid/app/Dialog;", "showPopoverSmartlyInternal", "showPopoverViewSmartlyInternal", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f14366a = null;

    static {
        f14366a = new e();
    }

    private e() {
    }

    private final int a(int r4) {
        int r3 = r4 & 112;
        if (r3 != 48) goto L5;
        int r5 = 5;
    L9:
        int r6 = r4 & 7;
        if (r6 == 3) goto L15;
        if (r6 == 5) goto L16;
        return r5;
    L16:
        return r5 | 80;
    L15:
        return r5 | 48;
    L5:
        if (r3 == 80) goto L7;
        r5 = 0;
        goto L9
    L7:
        r5 = 3;
        goto L9
    }

    private final int a(int r4, int r5) {
        Integer r0 = Integer.valueOf(r4 & 112);
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).intValue() == 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L11;
        int r2 = 80;
    L12:
        int r6 = (r4 & 7) | r2;
        if (r5 == 90) goto L19;
        if (r5 == 270) goto L20;
        return r6;
    L20:
        return b(r6);
    L19:
        return a(r6);
    L11:
        r2 = r0.intValue();
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    private final Rect a(View r10) {
        View r9 = r10.getRootView();
        com.obric.oui.window.a r0 = com.obric.oui.window.a.f14878a;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "anchor.context");
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getActivity(r1), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        int[] r3 = new int[2];
        if (r2 == null) goto L5;
        r9 = ZeusTransformUtils.getWindow(r2, "com.obric.memorydata.plugin").getDecorView();
    L5:
        if (r9 == null) goto L8;
        r9.getLocationOnScreen(r3);
    L8:
        boolean r4 = false;
        int r5 = r3[0];
        int r6 = r3[1];
        Integer r7 = null;
        if (r2 != null) goto L11;
    L10:
        Integer r8 = null;
    L18:
        if (r8 != null) goto L28;
        if (r9 != null) goto L21;
    L20:
        r8 = null;
    L26:
        if (r8 != null) goto L28;
        int r11 = ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getDisplayMetrics().widthPixels;
    L29:
        if (r2 != null) goto L31;
    L30:
        Integer r12 = null;
    L38:
        if (r12 != null) goto L49;
        if (r9 == null) goto L46;
        Integer r13 = Integer.valueOf(r9.getHeight());
        if (((Number) ZeusTransformUtils.preCheckCast(r13, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L44;
        r4 = true;
    L44:
        if (r4 == false) goto L46;
        r7 = r13;
    L46:
        if (r7 != null) goto L48;
        int r14 = ZeusTransformUtils.getResources(r10, "com.obric.memorydata.plugin").getDisplayMetrics().heightPixels;
    L51:
        return new Rect(r5, r6, r11 + r5, r14 + r6);
    L48:
        r14 = r7.intValue();
        goto L51
    L49:
        r14 = r12.intValue();
        goto L51
    L31:
        Window r15 = ZeusTransformUtils.getWindow(r2, "com.obric.memorydata.plugin");
        if (r15 == null) goto L30;
        View r16 = r15.getDecorView();
        if (r16 == null) goto L30;
        r12 = Integer.valueOf(r16.getHeight());
        goto L38
    L21:
        r8 = Integer.valueOf(r9.getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).intValue() <= 0) goto L24;
        boolean r17 = true;
    L25:
        if (r17 == false) goto L20;
    L24:
        r17 = false;
    L28:
        r11 = r8.intValue();
        goto L29
    L11:
        Window r18 = ZeusTransformUtils.getWindow(r2, "com.obric.memorydata.plugin");
        if (r18 == null) goto L10;
        View r19 = r18.getDecorView();
        if (r19 == null) goto L10;
        r8 = Integer.valueOf(r19.getWidth());
        goto L18
    }

    public static /* synthetic */ void a(e r7, Activity r8, a r9, int r10, int r11, boolean r12, int r13, int r14, Object r15) {
        Activity r1 = (Activity) ZeusTransformUtils.wrapperContextForParams(r8, Activity.class, "com.obric.memorydata.plugin");
        if ((r14 & 16) == 0) goto L5;
        r12 = false;
    L5:
        boolean r5 = r12;
        if ((r14 & 32) == 0) goto L8;
        r13 = 80;
    L8:
        r7.a(r1, r9, r10, r11, r5, r13);
    }

    public static /* synthetic */ void a(e r12, a r13, View r14, int r15, boolean r16, int r17, boolean r18, int r19, int r20, int r21, Object r22) {
        if ((r21 & 8) == 0) goto L5;
        boolean r7 = true;
    L7:
        if ((r21 & 16) == 0) goto L9;
        int r8 = 0;
    L11:
        if ((r21 & 32) == 0) goto L13;
        boolean r9 = true;
    L15:
        if ((r21 & 64) == 0) goto L17;
        int r10 = 0;
    L19:
        if ((r21 & 128) == 0) goto L21;
        int r11 = 0;
    L22:
        r12.a(r13, r14, r15, r7, r8, r9, r10, r11);
        return;
    L21:
        r11 = r20;
        goto L22
    L17:
        r10 = r19;
        goto L19
    L13:
        r9 = r18;
        goto L15
    L9:
        r8 = r17;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }

    private final int b(int r4) {
        int r3 = r4 & 112;
        if (r3 != 48) goto L5;
        int r5 = 3;
    L9:
        int r6 = r4 & 7;
        if (r6 == 3) goto L15;
        if (r6 == 5) goto L16;
        return r5;
    L16:
        return r5 | 48;
    L15:
        return r5 | 80;
    L5:
        if (r3 == 80) goto L7;
        r5 = 0;
        goto L9
    L7:
        r5 = 5;
        goto L9
    }

    private final void b(a r22, View r23, int r24, boolean r25, int r26, boolean r27, int r28, int r29) {
        if ((r24 & 112) != 0) goto L5;
        int r4 = r24 | 80;
    L75:
        Rect r5 = a(r23);     // Catch: Exception -> L71
        int[] r7 = new int[2];     // Catch: Exception -> L71
        r23.getLocationOnScreen(r7);     // Catch: Exception -> L71
        int r9 = r7[0] - r5.left;     // Catch: Exception -> L71
        int r8 = r7[1] - r5.top;     // Catch: Exception -> L71
        int r11 = r23.getMeasuredWidth() + r9;     // Catch: Exception -> L71
        int r12 = r23.getMeasuredHeight() + r8;     // Catch: Exception -> L71
        int r13 = r5.width();     // Catch: Exception -> L71
        int r14 = r5.height();     // Catch: Exception -> L71
        if (r5.top > 0) goto L9;
        int r6 = com.obric.oui.window.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r23.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L71
    L10:
        int r15 = h.a(r23, 12);     // Catch: Exception -> L71
        if (Build.VERSION.SDK_INT >= 30) goto L13;
    L17:
        int r10 = h.a(r23, 8);     // Catch: Exception -> L71
        int r16 = h.a(r23, 4);     // Catch: Exception -> L71
        r22.c(RangesKt.coerceAtLeast((r14 - r6) - r15, 0));     // Catch: Exception -> L69
        r22.getContentView().measure(r28, r29);     // Catch: Exception -> L69
        int r2 = r22.getContentView().getMeasuredWidth();     // Catch: Exception -> L69
        int r3 = r22.getContentView().getMeasuredHeight();     // Catch: Exception -> L69
        int r0 = a(r4, ((r22.b() % 360) + 360) % 360);     // Catch: Exception -> L69
        int r17 = r0 & 112;     // Catch: Exception -> L69
        int r1 = r0 & 7;     // Catch: Exception -> L69
        int r18 = r4;
        if (r17 == 48) goto L22;
    L24:
        if (r17 != 80) goto L32;
        if (r25 == false) goto L27;
        int r19 = ((r12 + r3) - r23.getMeasuredHeight()) - r16;     // Catch: Exception -> L69
    L29:
        if (r19 <= (r14 - r15)) goto L32;
        r17 = 48;
        goto L32
    L27:
        r19 = (r12 + r3) + r26;     // Catch: Exception -> L69
    L32:
        if (r1 != 3) goto L34;
        int r20 = r11 - r2;     // Catch: Exception -> L69
    L38:
        int r110 = r13 - r2;     // Catch: Exception -> L69
        int r21 = r110 - r10;     // Catch: Exception -> L69
        if (r21 < r10) goto L41;
        int r30 = RangesKt.coerceIn(r20, r10, r21);     // Catch: Exception -> L69
    L42:
        if (r25 == false) goto L47;
        int r31 = Math.max(r10, (r11 + r16) - r2);     // Catch: Exception -> L69
        int r32 = Math.min(r21, r9 - r16);     // Catch: Exception -> L69
        if (r32 < r31) goto L47;
        r30 = RangesKt.coerceIn(r30, r31, r32);     // Catch: Exception -> L69
    L47:
        if (r17 != 48) goto L49;
        int r33 = (r8 - r3) - r26;     // Catch: Exception -> L69
    L50:
        int r111 = (r14 - r3) - r15;     // Catch: Exception -> L69
        if (r111 < r6) goto L53;
        int r34 = RangesKt.coerceIn(r33, r6, r111);     // Catch: Exception -> L69
    L54:
        if (r25 == false) goto L63;
        int r35 = r23.getMeasuredHeight();     // Catch: Exception -> L69
        if (r17 != 80) goto L58;
        int r112 = (r12 - r35) - r16;     // Catch: Exception -> L69
    L59:
        if (r111 < r6) goto L61;
        r6 = RangesKt.coerceIn(r112, r6, r111);     // Catch: Exception -> L69
    L61:
        r34 = r6;
        goto L63
    L58:
        r112 = (r12 - r3) + r16;     // Catch: Exception -> L69
    L63:
        r22.d(r18);     // Catch: Exception -> L69
        if (r27 == true) goto L66;
        int r36 = 0;
        r22.setFocusable(false);     // Catch: Exception -> L69
    L67:
        r22.a(true);     // Catch: Exception -> L69
        r22.showAtLocation(r23, r36, r30, r34);     // Catch: Exception -> L69
        return;
    L66:
        r36 = 0;
        goto L67
    L53:
        r34 = r6;
        goto L54
    L49:
        r33 = r12 + r26;     // Catch: Exception -> L69
        goto L50
    L41:
        r30 = RangesKt.coerceIn(r20, 0, Math.max(0, r110));     // Catch: Exception -> L69
        goto L42
    L34:
        if (r1 == 5) goto L36;
        r20 = ((r23.getMeasuredWidth() - r2) / 2) + r9;     // Catch: Exception -> L69
        goto L38
    L36:
        r20 = r9;
        goto L38
    L22:
        if (((r8 - r3) - r26) >= 0) goto L24;
        r17 = 80;
    L69:
        e = e;
    L73:
        com.obric.oui.c.a.b.a("OPopoverHelperEx1", "showPopoverSmartly failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L13:
        if (r23.getRootWindowInsets() == null) goto L17;
        Insets r37 = r23.getRootWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());     // Catch: Exception -> L71
        Intrinsics.checkNotNullExpressionValue(r37, "anchor.rootWindowInsets.…Insets.Type.systemBars())");     // Catch: Exception -> L71
        if (r37.bottom <= 0) goto L17;
        r15 = r37.bottom;     // Catch: Exception -> L71
        goto L17
    L9:
        r6 = 0;
    L71:
        e = e;
        goto L73
    L5:
        r4 = r24;
        goto L75
    }

    public final void a(Activity r16, a r17, int r18, int r19, boolean r20, int r21) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r16, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r17, "popover");
        a(this, r17, FakeAnchorView.f14307a.a(r3, r18, r19, 2, 2), r21, r20, 0, false, 0, 0, 240, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.obric.oui.c.a.b.a("OPopoverHelperEx1", "showPopoverSmartlyAtLocation failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void a(a r2, View r3, int r4, boolean r5, int r6, boolean r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, "popover");
        Intrinsics.checkNotNullParameter(r3, "anchor");
        b(r2, r3, r4, r5, r6, r7, r8, r9);
    }
}
