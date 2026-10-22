package com.obric.oui.dialog.alert;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.common.util.g;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.text.OTextView;
import com.ttnet.org.chromium.net.NetError;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import u8.f;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "已废弃, 请用 com/obric/oui/dialog/v2 下面的版本")
@RequiresApi(30)
public class OAlertDialog extends AbstractDialog {
    private c A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f6425s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private FrameLayout f6426t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private c f6427u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private TextView f6428v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private TextView f6429w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private FrameLayout f6430x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private c f6431y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private FrameLayout f6432z;

    static final class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OAlertDialog f6433c;

        a(OAlertDialog r10) {
            this.f6433c = r10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TextView r10 = OAlertDialog.A(this.f6433c);
            if (r10 == null) goto L7;
            Layout r11 = r10.getLayout();
            if (r11 == null) goto L7;
            r11.getLineCount();
        L7:
            TextView r12 = OAlertDialog.A(this.f6433c);
            if (r12 == null) goto L11;
            r12.getMaxLines();
            return;
        }
    }

    public OAlertDialog(Context r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        this.f6425s = "OAlertDialog";
        this.f6426t = (FrameLayout) findViewById(f.iconPanel);
        TextView r13 = (TextView) findViewById(f.textTitle);
        TextView r14 = null;
        if (r13 != null) goto L5;
        r13 = null;
    L13:
        this.f6428v = r13;
        TextView r15 = (TextView) findViewById(f.textSubTitle);
        if ((r15 instanceof OTextView) == false) goto L17;
        r14 = r15;
    L17:
        OTextView r16 = (OTextView) r14;
        if (r16 == null) goto L20;
        r16.setEnableAutoAlignLeft(true);
    L20:
        Unit r17 = Unit.INSTANCE;
        this.f6429w = r15;
        this.f6430x = (FrameLayout) findViewById(f.button_container);
        this.f6432z = (FrameLayout) findViewById(f.body_container);
        return;
    L5:
        if ((r13 instanceof OTextView) == true) goto L7;
        TextView r18 = null;
    L8:
        OTextView r19 = (OTextView) r18;
        if (r19 == null) goto L11;
        r19.setEnableAutoAlignLeft(true);
    L11:
        Unit r20 = Unit.INSTANCE;
        goto L13
    L7:
        r18 = r13;
        goto L8
    }

    public static final /* synthetic */ TextView A(OAlertDialog r10) {
        return r10.f6429w;
    }

    public static final /* synthetic */ float B(OAlertDialog r10, Context r11) {
        return r10.q(r11);
    }

    private final void C(Context r14) {
        FrameLayout r10 = this.f6432z;
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.getVisibility() == 0) goto L8;
        return;
    L8:
        if (g.f6399a.a(r14) == false) goto L28;
        int r11 = fa.a.f8880a.b(r14);     // Catch: Exception -> L22
        if (r() == false) goto L14;
        float r12 = 16;
        Resources r13 = Resources.getSystem();     // Catch: Exception -> L22
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");     // Catch: Exception -> L22
        r11 = r11 - MathKt.roundToInt(TypedValue.applyDimension(1, r12, r13.getDisplayMetrics()));     // Catch: Exception -> L22
    L14:
        int r15 = G();     // Catch: Exception -> L22
        int r16 = I();     // Catch: Exception -> L22
        int r17 = H();     // Catch: Exception -> L22
        int r18 = F();     // Catch: Exception -> L22
        int r19 = E();     // Catch: Exception -> L22
        int r110 = com.obric.oui.common.util.f.d(r14);     // Catch: Exception -> L22
        float r20 = 300;
        Resources r111 = Resources.getSystem();     // Catch: Exception -> L22
        Intrinsics.checkNotNullExpressionValue(r111, "Resources.getSystem()");     // Catch: Exception -> L22
        if (r110 <= MathKt.roundToInt(TypedValue.applyDimension(1, r20, r111.getDisplayMetrics()))) goto L17;
        int r112 = r110 + NetError.ERR_SSL_SERVER_CERT_CHANGED;     // Catch: Exception -> L22
    L18:
        int r21 = (((((r112 - r11) - r15) - r16) - r17) - r18) - r19;     // Catch: Exception -> L22
        Resources r113 = Resources.getSystem();     // Catch: Exception -> L22
        Intrinsics.checkNotNullExpressionValue(r113, "Resources.getSystem()");     // Catch: Exception -> L22
        int r22 = RangesKt.coerceIn(r21, 0, r112 - MathKt.roundToInt(TypedValue.applyDimension(1, 52, r113.getDisplayMetrics())));     // Catch: Exception -> L22
        Resources r114 = Resources.getSystem();     // Catch: Exception -> L22
        Intrinsics.checkNotNullExpressionValue(r114, "Resources.getSystem()");     // Catch: Exception -> L22
        r10.measure(View.MeasureSpec.makeMeasureSpec(MathKt.roundToInt(TypedValue.applyDimension(1, 440, r114.getDisplayMetrics())), Integer.MIN_VALUE), 0);     // Catch: Exception -> L22
        int r23 = r10.getMeasuredHeight();     // Catch: Exception -> L22
        ea.b.a(this.f6425s, "adjustContentHeight, maxHeight: " + r112 + ", HORIZONTAL_MAX_HEIGHT: 300, availableHeight: " + r21 + ", measured BodyHeight: " + r23 + ", maxBodyHeight: " + r22 + ", iconPanelVerticalSpace: " + r15 + ", titleVerticalSpace: " + r16 + ", messageVerticalSpace: " + r17 + ", buttonVerticalSpace: " + r18 + ", bodyMarginSpace: " + r19);     // Catch: Exception -> L22
        if (r23 <= r22) goto L29;
        ea.b.e(this.f6425s, "adjustContentHeight, from: " + r23 + " to: " + r22);     // Catch: Exception -> L22
        ViewGroup.LayoutParams r115 = r10.getLayoutParams();     // Catch: Exception -> L22
        r115.height = r22;     // Catch: Exception -> L22
        Unit r24 = Unit.INSTANCE;     // Catch: Exception -> L22
        r10.setLayoutParams(r115);     // Catch: Exception -> L22
        return;
    L29:
        return;
    L17:
        Resources r116 = Resources.getSystem();     // Catch: Exception -> L22
        Intrinsics.checkNotNullExpressionValue(r116, "Resources.getSystem()");     // Catch: Exception -> L22
        r112 = MathKt.roundToInt(TypedValue.applyDimension(1, r20, r116.getDisplayMetrics()));     // Catch: Exception -> L22
    L22:
        e = move-exception;
        ea.b.c(this.f6425s, "adjustContentHeight error", e);
        return;
    }

    private final int E() {
        FrameLayout r10 = this.f6432z;
        if (r10 != null) goto L5;
        return 0;
    L5:
        da.c r11 = da.c.f8520a;
        Intrinsics.checkNotNull(r10);
        ViewGroup.LayoutParams r12 = r10.getLayoutParams();
        if (r12 != null) goto L9;
    L7:
        r12 = null;
    L10:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r12;
        if (r13 != null) goto L13;
        return 0;
    L13:
        return r13.topMargin;
    L9:
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        goto L7
    }

    private final int F() {
        FrameLayout r10 = this.f6430x;
        int r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        Intrinsics.checkNotNull(r10);
        r10.measure(0, 0);
        FrameLayout r12 = this.f6430x;
        Intrinsics.checkNotNull(r12);
        if (r12.getVisibility() != 0) goto L8;
        FrameLayout r13 = this.f6430x;
        Intrinsics.checkNotNull(r13);
        int r14 = r13.getMeasuredHeight();
    L9:
        da.c r15 = da.c.f8520a;
        FrameLayout r16 = this.f6430x;
        Intrinsics.checkNotNull(r16);
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 != null) goto L13;
    L11:
        r17 = null;
    L14:
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        if (r18 == null) goto L18;
        r11 = r18.topMargin;
    L18:
        return r14 + r11;
    L13:
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r14 = 0;
        goto L9
    }

    private final int G() {
        FrameLayout r10 = this.f6426t;
        int r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        Intrinsics.checkNotNull(r10);
        r10.measure(0, 0);
        FrameLayout r12 = this.f6426t;
        Intrinsics.checkNotNull(r12);
        if (r12.getVisibility() != 0) goto L8;
        FrameLayout r13 = this.f6426t;
        Intrinsics.checkNotNull(r13);
        int r14 = r13.getMeasuredHeight();
    L9:
        da.c r15 = da.c.f8520a;
        FrameLayout r16 = this.f6426t;
        Intrinsics.checkNotNull(r16);
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 != null) goto L13;
    L11:
        r17 = null;
    L14:
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        if (r18 == null) goto L18;
        r11 = r18.topMargin;
    L18:
        return r14 + r11;
    L13:
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r14 = 0;
        goto L9
    }

    private final int H() {
        TextView r10 = this.f6429w;
        int r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        Intrinsics.checkNotNull(r10);
        r10.measure(0, 0);
        TextView r12 = this.f6429w;
        Intrinsics.checkNotNull(r12);
        if (r12.getVisibility() != 0) goto L8;
        TextView r13 = this.f6429w;
        Intrinsics.checkNotNull(r13);
        int r14 = r13.getMeasuredHeight();
    L9:
        da.c r15 = da.c.f8520a;
        TextView r16 = this.f6429w;
        Intrinsics.checkNotNull(r16);
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 != null) goto L13;
    L11:
        r17 = null;
    L14:
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        if (r18 == null) goto L18;
        r11 = r18.topMargin;
    L18:
        return r14 + r11;
    L13:
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r14 = 0;
        goto L9
    }

    private final int I() {
        TextView r10 = this.f6428v;
        int r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        Intrinsics.checkNotNull(r10);
        r10.measure(0, 0);
        TextView r12 = this.f6428v;
        Intrinsics.checkNotNull(r12);
        if (r12.getVisibility() != 0) goto L8;
        TextView r13 = this.f6428v;
        Intrinsics.checkNotNull(r13);
        int r14 = r13.getMeasuredHeight();
    L9:
        da.c r15 = da.c.f8520a;
        TextView r16 = this.f6428v;
        Intrinsics.checkNotNull(r16);
        ViewGroup.LayoutParams r17 = r16.getLayoutParams();
        if (r17 != null) goto L13;
    L11:
        r17 = null;
    L14:
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r17;
        if (r18 == null) goto L18;
        r11 = r18.topMargin;
    L18:
        return r14 + r11;
    L13:
        if ((r17 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
    L8:
        r14 = 0;
        goto L9
    }

    public static /* synthetic */ void P(OAlertDialog r10, CharSequence r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        r10.O(r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setMessage");
    }

    public static final /* synthetic */ boolean z(OAlertDialog r10) {
        return r10.k();
    }

    public final void D() {
        TextView r10 = this.f6429w;
        if (r10 == null) goto L6;
        r10.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    public final void J() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OAlertDialog", "origin Dismiss exception!", e);
    }

    public void K() {
        p().post(new OAlertDialog$performEnterAnimation$1(this));
    }

    public void L() {
        ViewPropertySpringAnimator r10 = DialogAnimStyle.f(DialogAnimStyle.f6478a, p(), getWindow(), !j(), false, 4, null);
        ViewPropertySpringAnimator.n(r10, null, new OAlertDialog$performExitAnimation$$inlined$apply$lambda$2(this), new OAlertDialog$performExitAnimation$$inlined$apply$lambda$1(this), 1, null);
        r10.p();
    }

    public final void M(c r10) {
        Intrinsics.checkNotNullParameter(r10, "controller");
        this.A = r10;
        FrameLayout r11 = this.f6432z;
        if (r11 != null) goto L5;
        return;
    L5:
        if (o() == false) goto L7;
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        r12.height = 0;
        Unit r13 = Unit.INSTANCE;
        r11.setLayoutParams(r12);
    L7:
        r11.setVisibility(0);
        Context r14 = getContext();
        Intrinsics.checkNotNullExpressionValue(r14, "context");
        r10.a(r14, r11);
    }

    public final void N(c r10) {
        Intrinsics.checkNotNullParameter(r10, "controller");
        this.f6431y = r10;
        FrameLayout r11 = this.f6430x;
        if (r11 == null) goto L6;
        Context r12 = getContext();
        Intrinsics.checkNotNullExpressionValue(r12, "context");
        r10.a(r12, r11);
        return;
    }

    public final void O(CharSequence r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "message");
        TextView r12 = this.f6429w;
        if (r12 == null) goto L5;
        r12.setVisibility(0);
        r12.setText(r10);
    L5:
        TextView r13 = this.f6429w;
        if (r13 == null) goto L9;
        r13.setMaxLines(Integer.MAX_VALUE);
        return;
    }

    public final void Q(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "title");
        TextView r11 = this.f6428v;
        if (r11 == null) goto L6;
        r11.setVisibility(0);
        r11.setText(r10);
        float r12 = 19;
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        int r14 = MathKt.roundToInt(TypedValue.applyDimension(1, r12, r13.getDisplayMetrics()));
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        r11.setPadding(0, r14, 0, MathKt.roundToInt(TypedValue.applyDimension(1, r12, r15.getDisplayMetrics())));
        return;
    }

    public final void R(CharSequence r10) {
        Intrinsics.checkNotNullParameter(r10, "title");
        TextView r11 = this.f6428v;
        if (r11 == null) goto L6;
        r11.setVisibility(0);
        r11.setText(r10);
        r11.setPadding(0, 0, 0, 0);
        return;
    }

    public final void S(c r10) {
        Intrinsics.checkNotNullParameter(r10, "controller");
        this.f6427u = r10;
        FrameLayout r11 = this.f6426t;
        if (r11 == null) goto L6;
        r11.setVisibility(0);
        Context r12 = getContext();
        Intrinsics.checkNotNullExpressionValue(r12, "context");
        r10.a(r12, r11);
        return;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        L();
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public int l() {
        return h.o_alert_dialog;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle r10) {
        if (k() == false) goto L5;
        p().setAlpha(0.0f);
    L5:
        super.onCreate(r10);
        c r11 = this.f6427u;
        if (r11 == null) goto L8;
        r11.b(this);
    L8:
        c r12 = this.f6431y;
        if (r12 == null) goto L11;
        r12.b(this);
    L11:
        c r13 = this.A;
        if (r13 == null) goto L15;
        r13.b(this);
        return;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        K();
        c r10 = this.f6431y;
        if ((r10 instanceof ButtonStyleController) == false) goto L5;
        Objects.requireNonNull(r10, "null cannot be cast to non-null type com.obric.oui.dialog.alert.ButtonStyleController");
        ((ButtonStyleController) r10).e();
    L5:
        TextView r11 = this.f6429w;
        if (r11 == null) goto L9;
        r11.postDelayed(new a(this), 1000);
        return;
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog, android.app.Dialog
    public void show() {
        super.show();
        Context r10 = getContext();
        Intrinsics.checkNotNullExpressionValue(r10, "context");
        C(r10);
    }
}
