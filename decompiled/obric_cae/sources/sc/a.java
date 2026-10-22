package sc;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.obric.cae.R;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import he.i;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f12076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FrameLayout f12077b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public FrameLayout f12078m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RadiusLayout f12079n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public b f12080o;

    /* JADX INFO: renamed from: sc.a$a, reason: collision with other inner class name */
    public static final class C0156a {
    }

    public static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f12081a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f12082b = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final /* synthetic */ b[] f12083m = null;

        static {
            b r8 = new b("NARROW_WIDTH", 0);
            f12081a = r8;
            b r10 = new b("BOARD_WIDTH", 1);
            f12082b = r10;
            f12083m = new b[]{r8, r10};
        }

        public b(String r8, int r10) {
            super(r8, r10);
        }

        public static b valueOf(String r8) {
            return (b) Enum.valueOf(b.class, r8);
        }

        public static b[] values() {
            return (b[]) f12083m.clone();
        }
    }

    static {
        new C0156a();
    }

    public a(Context r8) {
        i.f(r8, "context");
        super(r8);
        this.f12080o = b.f12082b;
        Window r10 = getWindow();
        if (r10 == null) goto L5;
        r10.requestFeature(1);
    L5:
        setContentView(R.layout.o_inset_sheet_container);
        View r11 = findViewById(R.id.root_constraint);
        i.e(r11, "findViewById(R.id.root_constraint)");
        RadiusLayout r12 = (RadiusLayout) r11;
        this.f12079n = r12;
        r12.setMeasureHeightUnspecified(true);
        View r13 = findViewById(R.id.header_container);
        i.e(r13, "findViewById(R.id.header_container)");
        this.f12076a = (FrameLayout) r13;
        View r14 = findViewById(R.id.content_container);
        i.e(r14, "findViewById(R.id.content_container)");
        this.f12078m = (FrameLayout) r14;
        View r15 = findViewById(R.id.foot_container);
        i.e(r15, "findViewById(R.id.foot_container)");
        this.f12077b = (FrameLayout) r15;
        RadiusLayout r16 = this.f12079n;
        if (r16 == null) goto L13;
        ec.a.b(r16);
        RadiusLayout r17 = this.f12079n;
        if (r17 == null) goto L11;
        r17.setOnApplyWindowInsetsListener(new e(this));
        return;
    L11:
        i.j("rootContainer");
        throw null;
    L13:
        i.j("rootContainer");
        throw null;
    }

    public final RadiusLayout a() {
        RadiusLayout r8 = this.f12079n;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("rootContainer");
        throw null;
    }

    public final void b() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OAlertDialog", "origin Dismiss exception!", e);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        RadiusLayout r8 = this.f12079n;
        if (r8 == null) goto L6;
        ub.b r10 = ec.a.e(r8, getWindow(), true);
        c r11 = new c(this);
        ub.b.a(r10, null, new d(this), r11, 1);
        r10.b();
        return;
    L6:
        i.j("rootContainer");
        throw null;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r8) {
        super.onCreate(r8);
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        RadiusLayout r8 = this.f12079n;
        if (r8 == null) goto L6;
        r8.post(new sc.b(this));
        return;
    L6:
        i.j("rootContainer");
        throw null;
    }

    @Override // android.app.Dialog
    @SuppressLint({"NewApi"})
    public final void show() {
        Context r8 = getContext();
        i.e(r8, "context");
        if (t2.b.J(r8) == true) goto L38;
    L34:
        super.show();
        Window r13 = getWindow();
        if (r13 == null) goto L39;
        r13.setBackgroundDrawableResource(android.R.color.transparent);
        r13.setNavigationBarContrastEnforced(false);
        r13.setDecorFitsSystemWindows(false);
        r13.clearFlags(134217728);
        r13.addFlags(Integer.MIN_VALUE);
        r13.setNavigationBarColor(0);
        r13.setNavigationBarDividerColor(0);
        r13.addFlags(2);
        Context r10 = r13.getContext();
        i.e(r10, "context");
        Resources r11 = r10.getResources();
        i.e(r11, "context.resources");
        int r12 = r11.getConfiguration().uiMode;
        WindowManager.LayoutParams r14 = r13.getAttributes();
        r14.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        r14.gravity = 80;
        r13.setAttributes(r14);
        return;
    L39:
        return;
    L38:
        RadiusLayout r15 = this.f12079n;     // Catch: Exception -> L32
        if (r15 == null) goto L30;
        r15.measure(0, 0);     // Catch: Exception -> L32
        int r16 = ad.a.b(r8);     // Catch: Exception -> L32
        Resources r17 = Resources.getSystem();     // Catch: Exception -> L32
        i.e(r17, "Resources.getSystem()");     // Catch: Exception -> L32
        int r18 = l6.a.I0(TypedValue.applyDimension(1, 296, r17.getDisplayMetrics())) - r16;     // Catch: Exception -> L32
        FrameLayout r19 = this.f12076a;     // Catch: Exception -> L32
        if (r19 == null) goto L28;
        int r20 = r18 - r19.getMeasuredHeight();     // Catch: Exception -> L32
        FrameLayout r21 = this.f12077b;     // Catch: Exception -> L32
        if (r21 == null) goto L26;
        int r22 = r20 - r21.getMeasuredHeight();     // Catch: Exception -> L32
        Resources r23 = Resources.getSystem();     // Catch: Exception -> L32
        i.e(r23, "Resources.getSystem()");     // Catch: Exception -> L32
        int r24 = View.MeasureSpec.makeMeasureSpec(l6.a.I0(TypedValue.applyDimension(1, 440, r23.getDisplayMetrics())), Integer.MIN_VALUE);     // Catch: Exception -> L32
        FrameLayout r25 = this.f12078m;     // Catch: Exception -> L32
        if (r25 == null) goto L24;
        r25.measure(r24, 0);     // Catch: Exception -> L32
        FrameLayout r26 = this.f12078m;     // Catch: Exception -> L32
        if (r26 == null) goto L22;
        int r27 = r26.getMeasuredHeight();     // Catch: Exception -> L32
        Resources r110 = Resources.getSystem();     // Catch: Exception -> L32
        i.e(r110, "Resources.getSystem()");     // Catch: Exception -> L32
        int r28 = l6.a.x(r22, l6.a.I0(TypedValue.applyDimension(1, 244, r110.getDisplayMetrics())));     // Catch: Exception -> L32
        if (r27 <= r28) goto L34;
        zc.b.d("OInsetSheet", "adjustContentHeight, measured contentHeight: " + r27 + ", final contentHeight: " + r28);     // Catch: Exception -> L32
        FrameLayout r29 = this.f12078m;     // Catch: Exception -> L32
        if (r29 == null) goto L20;
        ViewGroup.LayoutParams r30 = r29.getLayoutParams();     // Catch: Exception -> L32
        r30.height = r28;     // Catch: Exception -> L32
        j r31 = j.f13877a;     // Catch: Exception -> L32
        r29.setLayoutParams(r30);     // Catch: Exception -> L32
        goto L34
    L20:
        i.j("contentContainer");     // Catch: Exception -> L32
        throw null;     // Catch: Exception -> L32
    L22:
        i.j("contentContainer");     // Catch: Exception -> L32
        throw null;     // Catch: Exception -> L32
    L24:
        i.j("contentContainer");     // Catch: Exception -> L32
        throw null;     // Catch: Exception -> L32
    L26:
        i.j("footerContainer");     // Catch: Exception -> L32
        throw null;     // Catch: Exception -> L32
    L28:
        i.j("headerContainer");     // Catch: Exception -> L32
        throw null;     // Catch: Exception -> L32
    L30:
        i.j("rootContainer");     // Catch: Exception -> L32
        throw null;     // Catch: Exception -> L32
    L32:
        e = move-exception;
        zc.b.c("OInsetSheet", "adjustContentHeight error", e);
        goto L34
    }
}
