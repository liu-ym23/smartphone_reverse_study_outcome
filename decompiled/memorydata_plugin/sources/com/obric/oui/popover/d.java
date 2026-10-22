package com.obric.oui.popover;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "use com.obric.oui.popover.v2.OPopoverHelperEx instead")
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J`\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J`\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002JN\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0013J&\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004J&\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/obric/oui/popover/OPopoverHelperEx;", "", "()V", "DEFAULT_EDGE_SPACE", "", "TAG", "", "showAtLeftOrRight", "", "popover", "Lcom/obric/oui/popover/OPopover;", "gravity", "anchor", "Landroid/view/View;", "anchorX", "offsetXY", "", "xOffset", "hasAdapted", "", "isMiddle", "arrowOffset", "", "yOffset", "anchorY", "showAtTopOrBottom", "showPopoverSmartly", "showPopoverSmartlyAtLocation", "activity", "Landroid/app/Activity;", "dialog", "Landroid/app/Dialog;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f14328a = null;

    static {
        f14328a = new d();
    }

    private d() {
    }

    private final void a(b r14, int r15, View r16, int r17, int r18, int[] r19, boolean r20, boolean r21, float r22, int r23, int r24) {
        r14.d(r15);
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r16.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "anchor.context");
        int r2 = h.b(r1) - h.a(r16, 10);
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r16.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "anchor.context");
        int r4 = h.a(r6);
        int r3 = com.obric.oui.window.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r16.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r14.e(RangesKt.coerceAtLeast(r2 - r3, 0));
        int r7 = r14.b();
        int r10 = r14.c();
        boolean r11 = true;
        if ((r18 + r19[1]) >= r3) goto L10;
        if (r20 == true) goto L7;
        a(r14, r16, 80, r21, r22, r23, -r17, true);
        return;
    L7:
        int r5 = r17 + (r3 - (r18 + r19[1]));
    L8:
        int r12 = r5;
    L16:
        int r8 = h.a(r16, 10);
        if ((r19[0] + r24) >= 0) goto L33;
        if (r21 == false) goto L22;
        a(r14, r16, r15, false, r22, ((-r24) - r14.d()) + r8, r12, false);
        return;
    L22:
        if (r22 == 0.0f) goto L25;
        r11 = false;
    L25:
        if (r11 == false) goto L30;
        if (r23 != 0) goto L30;
        if (r17 != 0) goto L30;
        int r9 = (((h.a(r16, 25) + r24) + (r16.getMeasuredWidth() / 2)) - r14.d()) - h.a(r16, 3);
        int r13 = ((-(r24 + r19[0])) - r14.d()) + r8;
        float r25 = r9;
        boolean r26 = false;
        float r27 = r25;
    L45:
        r14.a(r16, r15, r26, r27, r13, r12, r20);
        return;
    L30:
        a(this, r14, r16, r15, false, 0.0f, 0, 0, false, 240, null);
        return;
    L33:
        if (((r19[0] + r24) + r10) <= r4) goto L48;
        if (r21 == false) goto L38;
        a(r14, r16, r15, false, r22, r23, r17, true);
        return;
    L38:
        if (r22 == 0.0f) goto L41;
        r11 = false;
    L41:
        if (r11 == false) goto L46;
        if (r23 != 0) goto L46;
        int r28 = ((((r16.getWidth() / 2) + r24) - ((r4 - r14.c()) + h.a(r16, 3))) - r14.d()) + r8;
        int r29 = (r4 - (((r24 + r19[0]) + r10) - r14.d())) - r8;
        r26 = false;
        r27 = r28;
        r13 = r29;
    L46:
        a(this, r14, r16, r15, false, 0.0f, 0, r17, false, 176, null);
        return;
    L48:
        if (r21 == false) goto L50;
        int r30 = r23;
    L51:
        b.a(r14, r16, r15, r21, r22, r30, r12, false, 64, null);
        return;
    L50:
        r30 = r19[0];
        goto L51
    L10:
        if (((r18 + r19[1]) + r7) <= r2) goto L15;
        if (r20 == true) goto L14;
        a(r14, r16, 48, r21, r22, r23, -r17, true);
        return;
    L14:
        r5 = (r2 + r17) - ((r18 + r19[1]) + r7);
        goto L8
    L15:
        r12 = r17;
        goto L16
    }

    private final void a(b r13, int r14, View r15, int r16, int[] r17, int r18, boolean r19, boolean r20, float r21, int r22, int r23) {
        r13.d(r14);
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r15.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "anchor.context");
        int r2 = h.b(r1);
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r15.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r3, "anchor.context");
        int r4 = h.a(r3);
        r13.e(r2);
        int r5 = r13.b();
        int r8 = r13.c();
        boolean r9 = false;
        if (((r16 + r17[0]) + r18) >= 0) goto L10;
        if (r19 == false) goto L6;
        int r6 = 48;
        int r7 = -r22;
        int r10 = -Math.abs(r18);
        boolean r11 = true;
    L7:
        a(r13, r15, r6, r20, r21, r7, r10, r11);
        return;
    L6:
        r6 = 5;
        r7 = -r18;
        r11 = true;
        r10 = r22;
        goto L7
    L10:
        if ((((r16 + r17[0]) + r8) + r18) <= r4) goto L17;
        if (r19 == false) goto L13;
        int r12 = 48;
        int r24 = -r22;
        int r25 = -Math.abs(r18);
        boolean r26 = true;
    L14:
        a(r13, r15, r12, r20, r21, r24, r25, r26);
        return;
    L13:
        r12 = 3;
        r24 = -r18;
        r26 = true;
        r25 = r22;
        goto L14
    L17:
        if ((r17[1] + r23) >= 0) goto L32;
        if (r20 == false) goto L22;
        a(r13, r15, r14, false, r21, r18, r22, true);
        return;
    L22:
        if (r21 != 0.0f) goto L24;
        r9 = true;
    L24:
        if (r9 == false) goto L29;
        if (r18 != 0) goto L29;
        if (r22 != 0) goto L29;
        boolean r27 = false;
        int r28 = 64;
        Object r110 = null;
        float r29 = (r23 - h.a(r15, 15)) + r15.getHeight();
        int r30 = (-r23) - r17[1];
    L47:
        boolean r31 = r27;
        int r32 = r28;
        Object r33 = r110;
    L48:
        b.a(r13, r15, r14, r20, r29, r18, r30, r31, r32, r33);
        return;
    L29:
        a(this, r13, r15, r14, r20, 0.0f, 0, 0, false, 240, null);
        return;
    L32:
        if (((r17[1] + r23) + r5) <= r2) goto L46;
        if (r20 == false) goto L37;
        a(r13, r15, r14, false, r21, r18, r22, true);
        return;
    L37:
        if (r21 != 0.0f) goto L39;
        r9 = true;
    L39:
        if (r9 == false) goto L44;
        if (r18 != 0) goto L44;
        if (r22 != 0) goto L44;
        float r34 = -(((r2 - (r15.getHeight() + r23)) - h.a(r15, 15)) + (r15.getHeight() / 2));
        int r35 = r2 - ((r23 + r17[1]) + r5);
        r13 = r13;
        r15 = r15;
        r14 = r14;
        r20 = r20;
        r29 = r34;
        r18 = r18;
        r30 = r35;
        r31 = false;
        r32 = 64;
        r33 = null;
    L44:
        a(this, r13, r15, r14, r20, 0.0f, 0, 0, false, 240, null);
        return;
    L46:
        r27 = false;
        r28 = 64;
        r110 = null;
        r29 = r21;
        r30 = r22;
        goto L47
    }

    public static /* synthetic */ void a(d r11, b r12, View r13, int r14, boolean r15, float r16, int r17, int r18, boolean r19, int r20, Object r21) {
        if ((r20 & 16) == 0) goto L5;
        float r7 = 0.0f;
    L7:
        if ((r20 & 32) == 0) goto L9;
        int r8 = 0;
    L11:
        if ((r20 & 64) == 0) goto L13;
        int r9 = 0;
    L15:
        if ((r20 & 128) == 0) goto L17;
        boolean r10 = false;
    L18:
        r11.a(r12, r13, r14, r15, r7, r8, r9, r10);
        return;
    L17:
        r10 = r19;
        goto L18
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

    public final void a(Activity r16, b r17, int r18, int r19) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r16, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "activity");
        Intrinsics.checkNotNullParameter(r17, "popover");
        a(this, r17, FakeAnchorView.f14307a.a(r3, r18, r19, 2, 2), 80, true, 0.0f, 0, -OPopoverLayout.f14313a.a(), false, 176, null);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.obric.oui.c.a.b.a("OPopoverHelperEx", "showPopoverSmartlyAtLocation failed", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    public final void a(b r18, View r19, int r20, boolean r21, float r22, int r23, int r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r18, "popover");
        Intrinsics.checkNotNullParameter(r19, "anchor");
        int[] r12 = new int[2];
        r19.getLocationOnScreen(r12);
        int r14 = r12[0];
        int r16 = r12[1];
        r18.d(r20);
        r18.a(r23);
        r18.b(r24);
        r18.a(false);
        int[] r6 = r18.a(r21, r20, r19.getMeasuredWidth(), r19.getMeasuredHeight(), false, r25);
        com.obric.oui.c.a.b.b("OPopoverHelperEx", "showPopoverSmartly, offsetXY: [" + r6[0] + ", " + r6[1] + "], arrowOffset: " + r22 + ", xOffset: " + r23 + ", yOffset: " + r24 + ", hasAdapted: " + r25 + ", isMiddle: " + r21 + ", gravity: " + r20 + ", anchor loc: [" + r12[0] + ", " + r12[1] + ']');
        if (r20 != 48) goto L5;
    L7:
        a(r18, r20, r19, r24, r16, r6, r25, r21, r22, r23, r14);
        return;
    L5:
        if (r20 == 80) goto L7;
        a(r18, r20, r19, r14, r6, r23, r25, r21, r22, r24, r16);
    }
}
