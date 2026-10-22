package as;

import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.orecyclerview.widget.l;
import com.obric.oui.orecyclerview.widget.n0;
import com.obric.oui.picker.reels.views.WheelView;
import com.obric.oui.popover.d;
import com.obric.oui.privacy.recyclerview.PrivacyTopDownAlphaMaskRecyclerView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import w8.f;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f719b;

    public /* synthetic */ b(Object r5, int r10) {
        this.f718a = r10;
        this.f719b = r5;
    }

    @Override // com.obric.oui.orecyclerview.widget.n0
    public void a(RecyclerView r10, int r11) {
        switch(this.f718a) {
            case 0: goto L61;
            case 1: goto L4;
            case 2: goto L5;
            default: goto L4;
        };
    L4:
        return;
    L5:
        Intrinsics.checkNotNullParameter(r10, "rv");
        boolean r12 = true;
        WheelView r13 = (WheelView) this.f719b;
        if (r11 == 0) goto L17;
        if (r11 != 1) goto L9;
        r13.f14051n = true;
        r13.f14056t = false;
        r13.f14052o = false;
        int r14 = r13.e();
        if (r14 == (-1)) goto L66;
        int r15 = r13.b(r14);
        if (r13.g(r15) == false) goto L67;
        r13.f14049l = r14;
        r13.f14050m = r15;
        return;
    L67:
        return;
    L66:
        return;
    L9:
        if (r11 != 2) goto L74;
        r13.f14056t = true;
        return;
    L74:
        return;
    L17:
        r13.f14051n = false;
        r13.f14052o = false;
        int r16 = r13.f14055r;
        if (r16 == (-1)) goto L26;
        r13.f14055r = -1;
        int r5 = r13.e();
        if (r5 == (-1)) goto L26;
        int r17 = r13.b(r5);
        int r18 = r13.b(r16);
        if (r13.g(r18) == false) goto L26;
        if (r17 == r18) goto L26;
        r13.d(r16, true);
        return;
    L26:
        if (r13.s == false) goto L29;
        r13.s = false;
    L28:
        r12 = false;
    L47:
        if (r13.f14056t == false) goto L70;
        if (r12 == true) goto L71;
        r13.f14056t = false;
        int r19 = r13.e();
        if (r19 == (-1)) goto L72;
        int r20 = r13.b(r19);
        if (r13.g(r20) == false) goto L73;
        com.obric.oui.picker.reels.views.a r21 = r13.getOnWheelChangedListener();
        if (r21 == null) goto L75;
        yr.a r22 = (yr.a) ((f) r21).f22816a;
        androidx.core.view.inputmethod.a r110 = r22.f23323i;
        if (r110 == null) goto L76;
        r110.b(r22.f23319a, r20);
        return;
    L76:
        return;
    L75:
        return;
    L73:
        return;
    L72:
        return;
    L71:
        return;
    L70:
        return;
    L29:
        r13.f14042a.Z();
        com.obric.oui.picker.reels.views.b r111 = r13.f14044c;
        if (r111.f14070u != 0) goto L32;
    L36:
        int r23 = 0;
    L42:
        if (r23 == 0) goto L28;
        r13.s = true;
        if (r23 == 0) goto L47;
        r13.f14052o = true;
        d r24 = new d();
        r24.f14128a = 0.61f;
        r13.f14042a.W(0, r23, r24, 400, false);
        goto L47
    L32:
        if (r111.r() == 0) goto L36;
        if (r111.w() <= 0) goto L36;
        float r25 = r111.f14071v / r111.f14070u;
        if (r111.f14073x == false) goto L40;
        int r26 = RangesKt.coerceIn(MathKt.roundToInt(r25), 0, r111.w() - 1);
    L41:
        r23 = MathKt.roundToInt((r26 * r111.f14070u) - r111.f14071v);
        goto L42
    L40:
        int r27 = r111.f14074y;
        r26 = RangesKt.coerceIn(MathKt.roundToInt(r25), r27, RangesKt.coerceAtLeast((r111.w() - r111.f14074y) - 1, r27));
        goto L41
    L61:
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        if (r11 != 1) goto L77;
        ((PrivacyTopDownAlphaMaskRecyclerView) this.f719b).Z0 = true;
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.n0
    public final void b(RecyclerView r10) {
        Object r5 = this.f719b;
        switch(this.f718a) {
            case 0: goto L61;
            case 1: goto L34;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r10, "rv");
        int r11 = WheelView.C;
        WheelView r12 = (WheelView) r5;
        int r13 = r12.e();
        if (r13 != (-1)) goto L7;
        return;
    L7:
        if (r10.getScrollState() != 0) goto L9;
        return;
    L9:
        if (r12.f14051n == true) goto L11;
        return;
    L11:
        if (r12.f14052o == true) goto L71;
        int r14 = r12.b(r13);
        if (r12.g(r14) == true) goto L15;
        return;
    L15:
        if (r13 == r12.f14049l) goto L73;
        r12.f14049l = r13;
        r12.performHapticFeedback(3);     // Catch: Exception -> L19
    L21:
        int r15 = r12.f14050m;
        if (r14 == r15) goto L74;
        if (r15 < 0) goto L25;
        r12.d.f14078b.size();
    L25:
        com.obric.oui.picker.reels.views.a r16 = r12.getOnWheelChangedListener();
        if (r16 == null) goto L32;
        yr.a r17 = (yr.a) ((f) r16).f22816a;
        androidx.core.view.inputmethod.a r18 = r17.f23323i;
        if (r18 == null) goto L32;
        r18.b(r17.f23319a, r14);
    L32:
        r12.f14050m = r14;
        return;
    L74:
        return;
    L19:
        e = move-exception;
        ps.a.c("VibratorSmt", Intrinsics.stringPlus("performHapticFeedbackAOSP error: ", e));
        goto L21
    L73:
        return;
    L71:
        return;
    L34:
        int r19 = r10.computeHorizontalScrollOffset();
        int r110 = r10.computeVerticalScrollOffset();
        l r20 = (l) r5;
        int r21 = r20.s.computeVerticalScrollRange();
        int r22 = r20.f13859r;
        int r23 = r21 - r22;
        int r24 = r20.f13846a;
        if (r23 <= 0) goto L38;
        if (r22 < r24) goto L38;
        boolean r25 = true;
    L39:
        r20.f13860t = r25;
        int r26 = r20.s.computeHorizontalScrollRange();
        int r27 = r20.f13858q;
        if ((r26 - r27) <= 0) goto L43;
        if (r27 < r24) goto L43;
        boolean r28 = true;
    L44:
        r20.f13861u = r28;
        boolean r29 = r20.f13860t;
        if (r29 == true) goto L51;
        if (r28 == true) goto L51;
        if (r20.f13862v == 0) goto L75;
        r20.f(0);
        return;
    L75:
        return;
    L51:
        if (r29 == false) goto L54;
        float r30 = r22;
        r20.f13853l = (int) ((((r30 / 2.0f) + r110) * r30) / r21);
        r20.f13852k = Math.min(r22, (r22 * r22) / r21);
    L54:
        if (r20.f13861u == false) goto L56;
        float r111 = r27;
        r20.f13856o = (int) ((((r111 / 2.0f) + r19) * r111) / r26);
        r20.f13855n = Math.min(r27, (r27 * r27) / r26);
    L56:
        int r31 = r20.f13862v;
        if (r31 == 0) goto L59;
        if (r31 == 1) goto L59;
        return;
    L59:
        r20.f(1);
        return;
    L43:
        r28 = false;
    L38:
        r25 = false;
        goto L39
    L61:
        Intrinsics.checkNotNullParameter(r10, "recyclerView");
        PrivacyTopDownAlphaMaskRecyclerView r32 = (PrivacyTopDownAlphaMaskRecyclerView) r5;
        if (r32.Z0 == false) goto L78;
        r32.b0(true);
        return;
    }
}
