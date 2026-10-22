package com.obric.oui.popover;

import android.content.Context;
import android.util.Log;
import android.util.Size;
import android.view.View;
import com.obric.oui.common.util.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated(message = "use OPopoverHelperEx instead")
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u0004H\u0007Jn\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/oui/popover/OPopoverHelper;", "", "()V", "DEFAULT_EDGE_SPACE", "", "TAG", "", "autoOffsetShow", "", "popover", "Lcom/obric/oui/popover/OPopover;", "anchor", "Landroid/view/View;", "gravity", "isMiddle", "", "xOffsetWhenPopoverOutOfScreen", "yOffsetWhenPopoverOutOfScreen", "showPopoverSmartly", "arrowOffset", "", "xOffset", "yOffset", "hasAdapted", "leftPaddingDp", "rightPaddingDp", "alignArrowPadding", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f14327a = null;

    static {
        f14327a = new c();
    }

    private c() {
    }

    public static /* synthetic */ void a(c r14, b r15, View r16, int r17, boolean r18, float r19, int r20, int r21, boolean r22, int r23, int r24, boolean r25, int r26, Object r27) {
        if ((r26 & 16) == 0) goto L5;
        float r7 = 0.0f;
    L7:
        if ((r26 & 32) == 0) goto L9;
        int r8 = 0;
    L11:
        if ((r26 & 64) == 0) goto L13;
        int r9 = 0;
    L15:
        if ((r26 & 128) == 0) goto L17;
        boolean r10 = false;
    L19:
        if ((r26 & 256) == 0) goto L21;
        int r11 = 0;
    L23:
        if ((r26 & 512) == 0) goto L25;
        int r12 = 0;
    L27:
        if ((r26 & 1024) == 0) goto L29;
        boolean r13 = true;
    L30:
        r14.a(r15, r16, r17, r18, r7, r8, r9, r10, r11, r12, r13);
        return;
    L29:
        r13 = r25;
        goto L30
    L25:
        r12 = r24;
        goto L27
    L21:
        r11 = r23;
        goto L23
    L17:
        r10 = r22;
        goto L19
    L13:
        r9 = r21;
        goto L15
    L9:
        r8 = r20;
        goto L11
    L5:
        r7 = r19;
        goto L7
    }

    public final void a(b r19, View r20, int r21, boolean r22, float r23, int r24, int r25, boolean r26, int r27, int r28, boolean r29) {
        Intrinsics.checkNotNullParameter(r19, "popover");
        Intrinsics.checkNotNullParameter(r20, "anchor");
        int[] r0 = new int[2];
        r20.getLocationOnScreen(r0);
        boolean r13 = false;
        boolean r14 = true;
        Log.i("Popover", "location of parent: " + r0[0] + ':' + r0[1]);
        int r15 = r0[0];
        int r6 = r0[1];
        r19.d(r21);
        r19.a(r24);
        r19.b(r25);
        r19.a(r29);
        int[] r1 = r19.a(r22, r21, r20.getMeasuredWidth(), r20.getMeasuredHeight(), false, r26);
        r19.d(3);
        if (r21 != 48) goto L5;
    L51:
        r19.d(r21);
        Size r2 = com.obric.oui.window.a.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r20.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        int r3 = r2.getHeight() - h.a(r20, 10);
        int r4 = r2.getWidth();
        int r5 = com.obric.oui.window.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r20.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r19.e(RangesKt.coerceAtLeast(r3 - r5, 0));
        int r7 = r19.b();
        int r8 = r19.c();
        r19.d(3);
        if ((r6 + r1[1]) >= r5) goto L59;
        if (r26 == true) goto L56;
        int r9 = 80;
    L55:
        boolean r10 = r22;
        float r11 = r23;
        int r12 = r24;
        int r16 = -r25;
        boolean r17 = true;
        int r18 = r27;
        int r110 = r28;
        boolean r111 = false;
        int r112 = 1024;
        Object r113 = null;
    L24:
        a(this, r19, r20, r9, r10, r11, r12, r16, r17, r18, r110, r111, r112, r113);
        return;
    L56:
        int r30 = r25 + (r5 - (r1[1] + r6));
    L57:
        int r114 = r30;
    L65:
        if ((r1[0] + r15) >= 0) goto L84;
        if (r22 == false) goto L74;
        if (r1[0] >= 0) goto L70;
        int r31 = (-r15) + h.a(r20, 12);
        boolean r32 = false;
        boolean r33 = false;
        boolean r115 = false;
        int r116 = 1024;
        Object r117 = null;
    L71:
        a(this, r19, r20, r21, r32, r23, r31, r25, r33, r27, r28, r115, r116, r117);
        return;
    L70:
        r32 = false;
        r31 = r24;
        r33 = true;
        r115 = false;
        r116 = 1024;
        r117 = null;
        goto L71
    L74:
        if (r23 == 0.0f) goto L77;
        r14 = false;
    L77:
        if (r14 == true) goto L78;
    L35:
        r11 = 0.0f;
        r12 = 0;
        r9 = r21;
        r10 = r22;
        r16 = 0;
        r17 = false;
        r18 = 0;
        r110 = 0;
        r111 = false;
        r112 = 2032;
        r113 = null;
        goto L24
    L78:
        if (r24 != 0) goto L35;
        if (r25 != 0) goto L35;
        int r34 = (((h.a(r20, 25) + r15) + (r20.getMeasuredWidth() / 2)) - r19.d()) - h.a(r20, 3);
        int r35 = (((-(r15 + r1[0])) - r19.d()) + h.a(r20, 10)) + h.a(r20, r27);
        float r36 = r34;
    L82:
        r19.a(r20, r21, r22, r36, r35, r114, r26);
    L50:
        Unit r37 = Unit.INSTANCE;
        return;
    L84:
        if (((r1[0] + r15) + r8) <= r4) goto L96;
        if (r22 == false) goto L88;
    L23:
        r10 = false;
        r9 = r21;
        r11 = r23;
        r12 = r24;
        r16 = r25;
        r17 = true;
        r18 = r27;
        r110 = r28;
        r111 = false;
        r112 = 1024;
        r113 = null;
        goto L24
    L88:
        if (r23 == 0.0f) goto L91;
        r14 = false;
    L91:
        if (r14 == false) goto L35;
        if (r24 != 0) goto L35;
        if (r25 != 0) goto L35;
        int r38 = ((((r20.getWidth() / 2) + r15) - ((r4 - r19.c()) + h.a(r20, 3))) - r19.d()) + h.a(r20, 10);
        r35 = ((r4 - (((r15 + r1[0]) + r8) - r19.d())) - h.a(r20, 10)) + h.a(r20, r28);
        r36 = r38;
        goto L82
    L96:
        if (r22 == false) goto L98;
        int r39 = r24;
    L99:
        r19 = r19;
        r20 = r20;
        r21 = r21;
        r22 = r22;
        float r40 = r23;
        int r41 = r114;
        boolean r42 = false;
        int r43 = 64;
        Object r44 = null;
    L49:
        b.a(r19, r20, r21, r22, r40, r39, r41, r42, r43, r44);
        goto L50
    L98:
        r39 = r1[0];
        goto L99
    L59:
        if (((r1[1] + r6) + r7) <= r3) goto L63;
        if (r26 == true) goto L62;
        r9 = 48;
        goto L55
    L62:
        r30 = (r25 + r3) - ((r1[1] + r6) + r7);
        goto L57
    L63:
        r114 = r25;
        goto L65
    L5:
        if (r21 == 80) goto L51;
        r19.d(r21);
        Context r45 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r20.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r45, "anchor.context");
        int r46 = h.b(r45);
        Context r47 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r20.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r47, "anchor.context");
        int r48 = h.a(r47);
        r19.e(r46);
        int r49 = r19.b();
        int r50 = r19.c();
        r19.d(3);
        if (((r1[0] + r15) + r24) >= 0) goto L14;
        if (r26 == false) goto L10;
        int r51 = 48;
        int r52 = -r25;
        boolean r118 = false;
        int r119 = 1024;
        Object r120 = null;
        int r53 = -Math.abs(r24);
        boolean r54 = true;
    L11:
        a(this, r19, r20, r51, r22, r23, r52, r53, r54, r27, r28, r118, r119, r120);
        return;
    L10:
        r51 = 5;
        r52 = -r24;
        r53 = r25;
        r54 = true;
        r118 = false;
        r119 = 1024;
        r120 = null;
        goto L11
    L14:
        if ((((r15 + r1[0]) + r50) + r24) <= r48) goto L21;
        if (r26 == false) goto L17;
        int r55 = 48;
        int r56 = -r25;
        boolean r121 = false;
        int r122 = 1024;
        Object r123 = null;
        int r57 = -Math.abs(r24);
        boolean r58 = true;
    L18:
        a(this, r19, r20, r55, r22, r23, r56, r57, r58, r27, r28, r121, r122, r123);
        return;
    L17:
        r55 = 3;
        r56 = -r24;
        r57 = r25;
        r58 = true;
        r121 = false;
        r122 = 1024;
        r123 = null;
        goto L18
    L21:
        if ((r6 + r1[1]) >= 0) goto L37;
        if (r22 == true) goto L23;
        if (r23 != 0.0f) goto L29;
        r13 = true;
    L29:
        if (r13 == false) goto L35;
        if (r24 != 0) goto L35;
        if (r25 != 0) goto L35;
        r40 = (r6 - h.a(r20, 15)) + r20.getHeight();
        r41 = (-r6) - r1[1];
        boolean r124 = false;
        int r125 = 64;
        Object r126 = null;
    L34:
        r39 = r24;
        r42 = r124;
        r43 = r125;
        r44 = r126;
        goto L49
    L37:
        if (((r6 + r1[1]) + r49) <= r46) goto L48;
        if (r22 == true) goto L23;
        if (r23 != 0.0f) goto L43;
        r13 = true;
    L43:
        if (r13 == false) goto L35;
        if (r24 != 0) goto L35;
        if (r25 != 0) goto L35;
        float r59 = -(((r46 - (r6 + r20.getHeight())) - h.a(r20, 15)) + (r20.getHeight() / 2));
        r41 = r46 - ((r6 + r1[1]) + r49);
        r124 = false;
        r125 = 64;
        r126 = null;
        r40 = r59;
        goto L34
    L48:
        r19 = r19;
        r20 = r20;
        r21 = r21;
        r22 = r22;
        r40 = r23;
        r39 = r24;
        r41 = r25;
        r42 = false;
        r43 = 64;
        r44 = null;
        goto L49
    }
}
