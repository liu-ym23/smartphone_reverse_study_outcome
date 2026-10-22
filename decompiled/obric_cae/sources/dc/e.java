package dc;

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
import com.obric.cae.R;
import com.obric.oui.text.OTextView;
import com.ttnet.org.chromium.net.NetError;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends fc.a {
    public static final /* synthetic */ int D = 0;
    public m A;
    public final FrameLayout B;
    public m C;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f7046v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final FrameLayout f7047w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final TextView f7048x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final TextView f7049y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final FrameLayout f7050z;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f7051a;

        public a(e r8) {
            this.f7051a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e r8 = this.f7051a;
            TextView r10 = r8.f7049y;
            if (r10 == null) goto L7;
            Layout r11 = r10.getLayout();
            if (r11 == null) goto L7;
            r11.getLineCount();
        L7:
            TextView r12 = r8.f7049y;
            if (r12 == null) goto L11;
            r12.getMaxLines();
            return;
        }
    }

    public e(Context r8) {
        super(r8);
        this.f7046v = "OAlertDialog";
        this.f7047w = (FrameLayout) findViewById(R.id.iconPanel);
        TextView r10 = (TextView) findViewById(R.id.textTitle);
        TextView r11 = null;
        if (r10 != null) goto L5;
        r10 = null;
    L13:
        this.f7048x = r10;
        TextView r12 = (TextView) findViewById(R.id.textSubTitle);
        if ((r12 instanceof OTextView) == false) goto L17;
        r11 = r12;
    L17:
        OTextView r13 = (OTextView) r11;
        if (r13 == null) goto L20;
        r13.setEnableAutoAlignLeft(true);
    L20:
        xd.j r14 = xd.j.f13877a;
        this.f7049y = r12;
        this.f7050z = (FrameLayout) findViewById(R.id.button_container);
        this.B = (FrameLayout) findViewById(R.id.body_container);
        return;
    L5:
        if ((r10 instanceof OTextView) == true) goto L7;
        TextView r15 = null;
    L8:
        OTextView r16 = (OTextView) r15;
        if (r16 == null) goto L11;
        r16.setEnableAutoAlignLeft(true);
    L11:
        xd.j r17 = xd.j.f13877a;
        goto L13
    L7:
        r15 = r10;
        goto L8
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        ub.b r8 = ec.a.e(f(), getWindow(), true);
        g r10 = new g(this);
        ub.b.a(r8, null, new h(this), r10, 1);
        r8.b();
    }

    @Override // fc.a
    public final int e() {
        return R.layout.o_alert_dialog;
    }

    public final void i() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OAlertDialog", "origin Dismiss exception!", e);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
        m r10 = this.A;
        if (r10 == null) goto L5;
        r10.d(this);
    L5:
        m r11 = this.C;
        if (r11 == null) goto L9;
        r11.d(this);
        return;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        f().post(new f(this));
        m r8 = this.A;
        if ((r8 instanceof dc.a) == false) goto L8;
        if (r8 == null) goto L7;
        dc.a r10 = (dc.a) r8;
        goto L8
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.dialog.alert.ButtonStyleController");
    L8:
        TextView r11 = this.f7049y;
        if (r11 == null) goto L12;
        r11.postDelayed(new a(this), 1000);
        return;
    }

    @Override // fc.a, android.app.Dialog
    public final void show() {
        super.show();
        Context r8 = getContext();
        he.i.e(r8, "context");
        String r10 = this.f7046v;
        FrameLayout r11 = this.B;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.getVisibility() == 0) goto L8;
        return;
    L8:
        if (t2.b.J(r8) == false) goto L127;
        int r12 = ad.a.b(r8);     // Catch: Exception -> L116
        if (this.f7367t == false) goto L14;
        float r13 = 16;
        Resources r15 = Resources.getSystem();     // Catch: Exception -> L116
        he.i.e(r15, "Resources.getSystem()");     // Catch: Exception -> L116
        r12 = r12 - l6.a.I0(TypedValue.applyDimension(1, r13, r15.getDisplayMetrics()));     // Catch: Exception -> L116
    L14:
        FrameLayout r14 = this.f7047w;     // Catch: Exception -> L116
        if (r14 != null) goto L17;
        int r16 = 0;
    L33:
        TextView r17 = this.f7048x;     // Catch: Exception -> L116
        if (r17 != null) goto L36;
        int r18 = 0;
    L52:
        TextView r19 = this.f7049y;     // Catch: Exception -> L116
        if (r19 != null) goto L55;
        String r110 = r10;
        int r20 = 0;
    L72:
        FrameLayout r21 = this.f7050z;     // Catch: Exception -> L114
        if (r21 != null) goto L75;
        int r22 = 0;
    L91:
        ViewGroup.LayoutParams r23 = r11.getLayoutParams();     // Catch: Exception -> L114
        if (r23 != null) goto L95;
    L97:
        ViewGroup.LayoutParams r111 = null;
    L98:
        ViewGroup.MarginLayoutParams r112 = (ViewGroup.MarginLayoutParams) r111;     // Catch: Exception -> L114
        if (r112 == null) goto L101;
        int r24 = r112.topMargin;     // Catch: Exception -> L114
    L102:
        int r25 = l6.a.Q(r8);     // Catch: Exception -> L114
        float r113 = 300;
        Resources r26 = Resources.getSystem();     // Catch: Exception -> L114
        he.i.e(r26, "Resources.getSystem()");     // Catch: Exception -> L114
        if (r25 <= l6.a.I0(TypedValue.applyDimension(1, r113, r26.getDisplayMetrics()))) goto L105;
        int r27 = r25 + NetError.ERR_SSL_SERVER_CERT_CHANGED;     // Catch: Exception -> L114
    L106:
        int r28 = (((((r27 - r12) - r16) - r18) - r20) - r22) - r24;     // Catch: Exception -> L114
        Resources r114 = Resources.getSystem();     // Catch: Exception -> L114
        he.i.e(r114, "Resources.getSystem()");     // Catch: Exception -> L114
        int r29 = l6.a.x(r28, r27 - l6.a.I0(TypedValue.applyDimension(1, 52, r114.getDisplayMetrics())));     // Catch: Exception -> L114
        Resources r115 = Resources.getSystem();     // Catch: Exception -> L114
        he.i.e(r115, "Resources.getSystem()");     // Catch: Exception -> L114
        r11.measure(View.MeasureSpec.makeMeasureSpec(l6.a.I0(TypedValue.applyDimension(1, 440, r115.getDisplayMetrics())), Integer.MIN_VALUE), 0);     // Catch: Exception -> L114
        int r116 = r11.getMeasuredHeight();     // Catch: Exception -> L114
        String r30 = r110;
        zc.b.a(r30, "adjustContentHeight, maxHeight: " + r27 + ", HORIZONTAL_MAX_HEIGHT: 300, availableHeight: " + r28 + ", measured BodyHeight: " + r116 + ", maxBodyHeight: " + r29 + ", iconPanelVerticalSpace: " + r16 + ", titleVerticalSpace: " + r18 + ", messageVerticalSpace: " + r20 + ", buttonVerticalSpace: " + r22 + ", bodyMarginSpace: " + r24);     // Catch: Exception -> L112
        if (r116 <= r29) goto L128;
        zc.b.d(r30, "adjustContentHeight, from: " + r116 + " to: " + r29);     // Catch: Exception -> L112
        ViewGroup.LayoutParams r31 = r11.getLayoutParams();     // Catch: Exception -> L112
        r31.height = r29;     // Catch: Exception -> L112
        xd.j r32 = xd.j.f13877a;     // Catch: Exception -> L112
        r11.setLayoutParams(r31);     // Catch: Exception -> L112
        return;
    L128:
        return;
    L112:
        e = e;
    L118:
        zc.b.c(r30, "adjustContentHeight error", e);
        return;
    L114:
        e = e;
        r30 = r110;
        goto L118
    L105:
        Resources r33 = Resources.getSystem();     // Catch: Exception -> L114
        he.i.e(r33, "Resources.getSystem()");     // Catch: Exception -> L114
        r27 = l6.a.I0(TypedValue.applyDimension(1, r113, r33.getDisplayMetrics()));     // Catch: Exception -> L114
        goto L106
    L101:
        r24 = 0;
        goto L102
    L95:
        if ((r23 instanceof ViewGroup.MarginLayoutParams) == false) goto L97;
        r111 = r23;
        goto L98
    L75:
        r21.measure(0, 0);     // Catch: Exception -> L114
        if (r21.getVisibility() != 0) goto L78;
        int r34 = r21.getMeasuredHeight();     // Catch: Exception -> L114
    L79:
        ViewGroup.LayoutParams r35 = r21.getLayoutParams();     // Catch: Exception -> L114
        if (r35 != null) goto L83;
    L85:
        r35 = null;
    L86:
        ViewGroup.MarginLayoutParams r36 = (ViewGroup.MarginLayoutParams) r35;     // Catch: Exception -> L114
        if (r36 == null) goto L89;
        int r37 = r36.topMargin;     // Catch: Exception -> L114
    L90:
        r22 = r37 + r34;     // Catch: Exception -> L114
        goto L91
    L89:
        r37 = 0;
        goto L90
    L83:
        if ((r35 instanceof ViewGroup.MarginLayoutParams) == false) goto L85;
    L78:
        r34 = 0;
        goto L79
    L55:
        r19.measure(0, 0);     // Catch: Exception -> L116
        if (r19.getVisibility() != 0) goto L58;
        int r38 = r19.getMeasuredHeight();     // Catch: Exception -> L116
    L59:
        ViewGroup.LayoutParams r117 = r19.getLayoutParams();     // Catch: Exception -> L116
        r110 = r10;
        if (r117 != null) goto L122;
    L66:
        r117 = null;
    L67:
        ViewGroup.MarginLayoutParams r118 = (ViewGroup.MarginLayoutParams) r117;     // Catch: Exception -> L114
        if (r118 == null) goto L70;
        int r39 = r118.topMargin;     // Catch: Exception -> L114
    L71:
        r20 = r39 + r38;     // Catch: Exception -> L114
        goto L72
    L70:
        r39 = 0;
        goto L71
    L122:
        if ((r117 instanceof ViewGroup.MarginLayoutParams) == false) goto L66;
    L58:
        r38 = 0;
        goto L59
    L36:
        r17.measure(0, 0);     // Catch: Exception -> L116
        if (r17.getVisibility() != 0) goto L39;
        int r119 = r17.getMeasuredHeight();     // Catch: Exception -> L116
    L40:
        ViewGroup.LayoutParams r120 = r17.getLayoutParams();     // Catch: Exception -> L116
        if (r120 != null) goto L44;
    L46:
        r120 = null;
    L47:
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r120;     // Catch: Exception -> L116
        if (r121 == null) goto L50;
        int r122 = r121.topMargin;     // Catch: Exception -> L116
    L51:
        r18 = r119 + r122;     // Catch: Exception -> L116
        goto L52
    L50:
        r122 = 0;
        goto L51
    L44:
        if ((r120 instanceof ViewGroup.MarginLayoutParams) == false) goto L46;
    L39:
        r119 = 0;
        goto L40
    L17:
        r14.measure(0, 0);     // Catch: Exception -> L116
        if (r14.getVisibility() != 0) goto L20;
        int r123 = r14.getMeasuredHeight();     // Catch: Exception -> L116
    L21:
        ViewGroup.LayoutParams r124 = r14.getLayoutParams();     // Catch: Exception -> L116
        if (r124 != null) goto L25;
    L27:
        r124 = null;
    L28:
        ViewGroup.MarginLayoutParams r125 = (ViewGroup.MarginLayoutParams) r124;     // Catch: Exception -> L116
        if (r125 == null) goto L31;
        int r126 = r125.topMargin;     // Catch: Exception -> L116
    L32:
        r16 = r123 + r126;     // Catch: Exception -> L116
        goto L33
    L31:
        r126 = 0;
        goto L32
    L25:
        if ((r124 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
    L20:
        r123 = 0;
    L116:
        e = e;
        r30 = r10;
        goto L118
    }
}
