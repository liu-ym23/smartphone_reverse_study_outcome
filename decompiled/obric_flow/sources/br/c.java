package br;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.bytedance.ai.widget.contianer.AppletWidgetContainer;
import com.obric.clockwidgets.ui.RoundLinearLayout;
import com.obric.oui.avatar.OCircleImageView;
import com.obric.oui.coachmark.OCoachmarkView;
import com.obric.oui.common.style.i;
import com.obric.oui.common.style.o;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.material.n;
import com.obric.oui.popover.v2.OPopoverLayout;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import w2.q;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends ViewOutlineProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f982b;

    public /* synthetic */ c(Object r5, int r10) {
        this.f981a = r10;
        this.f982b = r5;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r18, Outline r19) {
        Object r10 = this.f982b;
        switch(this.f981a) {
            case 0: goto L81;
            case 1: goto L75;
            case 2: goto L73;
            case 3: goto L61;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L24;
            case 7: goto L17;
            case 8: goto L9;
            default: goto L4;
        };
    L4:
        OCircleImageView r11 = (OCircleImageView) r10;
        if (r11.f11972t == false) goto L7;
        ViewOutlineProvider.BACKGROUND.getOutline(r18, r19);
        return;
    L7:
        Rect r5 = new Rect();
        r11.f11959b.roundOut(r5);
        r19.setRoundRect(r5, r5.width() / 2.0f);
        return;
    L9:
        gu.b r12 = (gu.b) r10;
        if (r12.d.isEmpty() == true) goto L15;
        float r13 = r12.e;
        if (r13 <= 0.0f) goto L15;
        r19.setRoundRect(r12.d, r13);
        return;
    L15:
        r19.setEmpty();
        return;
    L17:
        if (r18 == null) goto L96;
        OPopoverLayout r14 = (OPopoverLayout) r10;
        int r15 = (int) (r14.f14162h / 2.0f);
        int r16 = r18.getWidth() - r15;
        int r17 = r18.getHeight() - r15;
        Rect r20 = r14.f14161c;
        r20.set(r15, r15, r16, r17);
        r14.d.set(r20);
        if (r19 == null) goto L97;
        r19.setRoundRect(r20, r14.f14159a);
        return;
    L97:
        return;
    L96:
        return;
    L24:
        Intrinsics.checkNotNullParameter(r18, "view");
        Intrinsics.checkNotNullParameter(r19, "outline");
        int r21 = r18.getWidth();
        int r22 = r18.getHeight();
        OCardListItem r23 = (OCardListItem) r10;
        if (r23.D != 0) goto L28;
        int r24 = com.lynx.tasm.utils.a.B(8, r23);
    L29:
        r19.setRoundRect(0, 0, r21, r22, r24);
        return;
    L28:
        r24 = com.lynx.tasm.utils.a.B(10, r23);
        goto L29
    L31:
        Intrinsics.checkNotNullParameter(r18, "view");
        Intrinsics.checkNotNullParameter(r19, "outline");
        r19.setRoundRect(0, 0, r18.getWidth(), r18.getHeight(), com.lynx.tasm.utils.a.B(16, (OInputLayout) r10));
        return;
    L33:
        int r25 = r18.getWidth();
        int r26 = r18.getHeight();
        if (r25 == 0) goto L98;
        if (r26 == 0) goto L102;
        i r27 = (i) r10;
        float r28 = r27.r();
        float r110 = r28 * 2.0f;
        float r111 = Math.min(r25, r26);
        if (r110 <= r111) goto L41;
        r28 = r111 / 2.0f;
    L41:
        if (r27.I == false) goto L43;
        Path r29 = new Path();
        RectF r30 = new RectF(0.0f, 0.0f, r25, r26);
        float r31 = r27.E;
        float r32 = r27.F;
        float r33 = r27.H;
        float r112 = r27.G;
        r29.addRoundRect(r30, new float[]{r31, r31, r32, r32, r33, r33, r112, r112}, Path.Direction.CW);
        r19.setConvexPath(r29);
        r18.setClipToOutline(!r27.J);
        return;
    L43:
        int r34 = r27.Y;
        int r35 = Math.max(r34 + 1, r26 - r27.Z);
        int r113 = r27.W;
        int r36 = r25 - r27.X;
        if (r27.P == false) goto L46;
        int r114 = r18.getPaddingLeft() + r113;
        int r115 = r18.getPaddingTop() + r34;
        int r37 = Math.max(r114 + 1, r36 - r18.getPaddingRight());
        int r38 = Math.max(1 + r115, r35 - r18.getPaddingBottom());
        int r39 = r37;
        int r40 = r38;
        r34 = r115;
        int r41 = r114;
    L47:
        float r42 = r27.U;
        if (r27.T != 0) goto L50;
        r42 = 1.0f;
    L50:
        r19.setAlpha(r42);
        if (r28 > 0.0f) goto L54;
        r19.setRect(r41, r34, r39, r40);
        return;
    L54:
        if (o.e == true) goto L56;
    L59:
        r19.setRoundRect(r41, r34, r39, r40, r28);
        return;
    L56:
        if (n.j() == true) goto L59;
        float r116 = r41;
        float r117 = r34;
        float r118 = r39;
        float r119 = r40;
        float r43 = r118 - r116;
        float r44 = r119 - r117;
        float r120 = RangesKt.coerceAtLeast(Math.min(r28, Math.min(Math.abs(r43), Math.abs(r44)) / 2.0f), 0.0f);
        r19.setPath(o.b(r120, Math.min(Math.abs(r43), Math.abs(r44))).f21387a.l(r116, r117, r118, r119, r120));
        return;
    L46:
        r40 = r35;
        r41 = r113;
        r39 = r36;
        goto L47
    L102:
        return;
    L98:
        return;
    L61:
        if (r18 == null) goto L103;
        com.obric.flow.cardlistpage.ui.popup.OPopoverLayout r45 = (com.obric.flow.cardlistpage.ui.popup.OPopoverLayout) r10;
        int r46 = (int) (r45.f11792h / 2.0f);
        r45.f11791c = new Rect(r46, r46, r18.getWidth() - r46, r18.getHeight() - r46);
        Rect r47 = r45.f11791c;
        Rect r48 = null;
        if (r47 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
        r47 = null;
    L65:
        r45.d = new RectF(r47);
        if (r19 == null) goto L104;
        Rect r49 = r45.f11791c;
        if (r49 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("mRoundRect");
    L71:
        r19.setRoundRect(r48, r45.f11789a);
        return;
    L70:
        r48 = r49;
        goto L71
    L104:
        return;
    L103:
        return;
    L73:
        Intrinsics.checkNotNullParameter(r18, "view");
        Intrinsics.checkNotNullParameter(r19, "outline");
        r19.setRoundRect(0, 0, r18.getWidth(), r18.getHeight(), ((RoundLinearLayout) r10).getRoundRadius());
        return;
    L75:
        if (r18 == null) goto L105;
        if (r19 == null) goto L106;
        int r50 = r18.getWidth();
        int r51 = r18.getHeight();
        q r52 = ((AppletWidgetContainer) r10).g;
        r19.setRoundRect(0, 0, r50, r51, 0.0f);
        return;
    L106:
        return;
    L105:
        return;
    L81:
        Intrinsics.checkNotNullParameter(r18, "view");
        Intrinsics.checkNotNullParameter(r19, "outline");
        int r53 = r18.getWidth();
        int r54 = r18.getHeight();
        if (r53 <= 0) goto L107;
        if (r54 <= 0) goto L108;
        Path r55 = new Path();
        OCoachmarkView.ArrowPosition r56 = ((OCoachmarkView) r10).f12391x;
        if (r56 != OCoachmarkView.ArrowPosition.TOP) goto L88;
    L91:
        float r57 = r53 / 20.0f;
        float r58 = r54 / 8.0f;
        float r59 = 1.41421f * r58;
        r55.moveTo(8.58579f * r57, r59);
        r55.cubicTo(r57 * 9.36684f, r58 * 0.633164f, r57 * 10.6332f, r58 * 0.633165f, r57 * 11.4142f, r59);
        float r60 = r58 * 8.0f;
        r55.lineTo(18.0f * r57, r60);
        r55.lineTo(r57 * 2.0f, r60);
        r55.close();
    L92:
        r19.setPath(r55);
        return;
    L88:
        if (r56 == OCoachmarkView.ArrowPosition.BOTTOM) goto L91;
        float r61 = r53 / 10.0f;
        float r62 = r54 / 20.0f;
        float r121 = r61 * 1.95217f;
        float r122 = r61 * 0.951359f;
        r55.moveTo(r121, 8.43826f * r62);
        r55.cubicTo(r122, r62 * 9.23891f, r122, r62 * 10.7611f, r121, r62 * 11.5617f);
        float r63 = r61 * 10.0f;
        r55.lineTo(r63, 18.0f * r62);
        r55.lineTo(r63, r62 * 2.0f);
        r55.close();
        goto L92
    L108:
        return;
    }
}
