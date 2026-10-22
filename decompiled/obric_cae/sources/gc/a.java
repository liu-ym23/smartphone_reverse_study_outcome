package gc;

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
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends fc.a implements hc.d {
    public static final /* synthetic */ int E = 0;
    public final TextView A;
    public final FrameLayout B;
    public hc.f C;
    public final FrameLayout D;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f7799v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final FrameLayout f7800w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final FrameLayout f7801x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public hc.f f7802y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final TextView f7803z;

    /* JADX INFO: renamed from: gc.a$a, reason: collision with other inner class name */
    public static final class RunnableC0080a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f7804a;

        public RunnableC0080a(a r8) {
            this.f7804a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r8 = this.f7804a;
            TextView r10 = r8.A;
            if (r10 == null) goto L7;
            Layout r11 = r10.getLayout();
            if (r11 == null) goto L7;
            r11.getLineCount();
        L7:
            TextView r12 = r8.A;
            if (r12 == null) goto L11;
            r12.getMaxLines();
            return;
        }
    }

    public a(Context r8) {
        super(r8);
        this.f7799v = "OAlertDialog";
        View r10 = findViewById(R.id.bannerPanel);
        he.i.e(r10, "findViewById(R.id.bannerPanel)");
        this.f7800w = (FrameLayout) r10;
        View r11 = findViewById(R.id.iconPanel);
        he.i.e(r11, "findViewById(R.id.iconPanel)");
        this.f7801x = (FrameLayout) r11;
        TextView r12 = (TextView) findViewById(R.id.textTitle);
        TextView r13 = null;
        if (r12 != null) goto L5;
        r12 = null;
    L13:
        this.f7803z = r12;
        TextView r14 = (TextView) findViewById(R.id.textSubTitle);
        if ((r14 instanceof OTextView) == false) goto L17;
        r13 = r14;
    L17:
        OTextView r15 = (OTextView) r13;
        if (r15 == null) goto L20;
        r15.setEnableAutoAlignLeft(true);
    L20:
        j r16 = j.f13877a;
        this.A = r14;
        View r17 = findViewById(R.id.button_container);
        he.i.e(r17, "findViewById(R.id.button_container)");
        this.B = (FrameLayout) r17;
        View r18 = findViewById(R.id.body_container);
        he.i.e(r18, "findViewById(R.id.body_container)");
        this.D = (FrameLayout) r18;
        return;
    L5:
        if ((r12 instanceof OTextView) == true) goto L7;
        TextView r19 = null;
    L8:
        OTextView r20 = (OTextView) r19;
        if (r20 == null) goto L11;
        r20.setEnableAutoAlignLeft(true);
    L11:
        j r21 = j.f13877a;
        goto L13
    L7:
        r19 = r12;
        goto L8
    }

    @Override // hc.d
    public final FrameLayout a() {
        return this.f7800w;
    }

    @Override // hc.d
    public final FrameLayout b() {
        return this.f7801x;
    }

    @Override // hc.d
    public final FrameLayout c() {
        return this.B;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        ub.b r8 = ec.a.e(f(), getWindow(), true);
        c r10 = new c(this);
        ub.b.a(r8, null, new d(this), r10, 1);
        r8.b();
    }

    @Override // fc.a
    public final int e() {
        return R.layout.o_alert_dialog_v2;
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
        hc.f r10 = this.f7802y;
        if (r10 == null) goto L5;
        r10.b(this);
    L5:
        hc.f r11 = this.C;
        if (r11 == null) goto L9;
        r11.b(this);
        return;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        f().post(new b(this));
        TextView r8 = this.A;
        if (r8 == null) goto L6;
        r8.postDelayed(new RunnableC0080a(this), 1000);
        return;
    }

    @Override // fc.a, android.app.Dialog
    public final void show() {
        super.show();
        Context r8 = getContext();
        he.i.e(r8, "context");
        String r10 = this.f7799v;
        FrameLayout r11 = this.D;
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
        FrameLayout r14 = this.f7801x;     // Catch: Exception -> L116
        if (r14 != null) goto L17;
        int r16 = 0;
    L33:
        TextView r17 = this.f7803z;     // Catch: Exception -> L116
        if (r17 != null) goto L36;
        int r18 = 0;
    L52:
        TextView r19 = this.A;     // Catch: Exception -> L116
        if (r19 != null) goto L55;
        String r110 = r10;
        int r20 = 0;
    L72:
        FrameLayout r21 = this.B;     // Catch: Exception -> L114
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
        j r32 = j.f13877a;     // Catch: Exception -> L112
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
