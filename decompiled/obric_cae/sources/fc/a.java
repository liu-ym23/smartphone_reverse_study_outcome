package fc;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import com.obric.cae.R;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import ha.t;
import he.i;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f7359b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f7360m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f7361n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final View f7362o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final EnumC0073a f7363p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public View.OnClickListener f7364q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f7365r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final fc.b f7366s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f7367t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f7368u;

    /* JADX INFO: renamed from: fc.a$a, reason: collision with other inner class name */
    public static final enum EnumC0073a extends Enum<EnumC0073a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0073a f7369a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumC0073a[] f7370b = null;

        static {
            EnumC0073a r8 = new EnumC0073a("LIGHT", 0);
            EnumC0073a r10 = new EnumC0073a("DARK", 1);
            f7369a = r10;
            f7370b = new EnumC0073a[]{r8, r10, new EnumC0073a("CUSTOM", 2)};
        }

        public EnumC0073a(String r8, int r10) {
            super(r8, r10);
        }

        public static EnumC0073a valueOf(String r8) {
            return (EnumC0073a) Enum.valueOf(EnumC0073a.class, r8);
        }

        public static EnumC0073a[] values() {
            return (EnumC0073a[]) f7370b.clone();
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f7371a;

        public b(a r8) {
            this.f7371a = r8;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            a r10 = this.f7371a;
            r10.dismiss();
            View.OnClickListener r11 = r10.f7364q;
            if (r11 == null) goto L6;
            r11.onClick(r8);
            return;
        }
    }

    public a(Context r8) {
        super(r8);
        this.f7367t = false;
        this.f7368u = false;
        this.f7358a = "AbstractDialog";
        this.f7363p = EnumC0073a.f7369a;
        this.f7365r = true;
        Window r10 = getWindow();
        if (r10 == null) goto L5;
        r10.requestFeature(1);
    L5:
        setContentView(R.layout.o_base_dialog);
        View r11 = findViewById(R.id.root_view);
        i.e(r11, "findViewById(R.id.root_view)");
        this.f7362o = r11;
        this.f7360m = (ImageView) findViewById(R.id.btn_close);
        this.f7359b = findViewById(R.id.close_container);
        r11.setOnApplyWindowInsetsListener(new c(this));
        h(this.f7361n, null);
        ViewStub r12 = (ViewStub) findViewById(R.id.contentView);
        i.e(r12, "viewStub");
        r12.setLayoutResource(e());
        r12.inflate();
        ec.a.b(r11);
        this.f7366s = new fc.b(this, Looper.getMainLooper());
    }

    public static float g(Context r8) {
        Resources r10 = r8.getResources();
        i.e(r10, "context.resources");
        if ((r10.getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        return 0.8f;
    L8:
        return 0.32f;
    L5:
        r11 = false;
        goto L6
    }

    public final void d(EnumC0073a r8, Integer r10, Integer r11) {
        i.f(r8, "style");
        if (this.f7361n == false) goto L34;
        int r12 = r8.ordinal();
        if (r12 == 0) goto L15;
        int r13 = R.color.ConstTextInverse;
        if (r12 != 1) goto L9;
        r11 = Integer.valueOf(R.color.ConstBGContainer7);
    L16:
        ImageView r14 = this.f7360m;
        if (r14 == null) goto L19;
        r14.setImageTintList(androidx.core.content.a.b(getContext(), r13));
    L19:
        View r15 = this.f7359b;
        Drawable r16 = null;
        if (r11 != null) goto L23;
        if (r15 == null) goto L35;
        r15.setBackground(null);
        return;
    L35:
        return;
    L23:
        if (r15 == null) goto L25;
        Drawable r17 = r15.getBackground();
    L27:
        if ((r17 instanceof GradientDrawable) == false) goto L30;
        r16 = r17;
    L30:
        GradientDrawable r18 = (GradientDrawable) r16;
        if (r18 == null) goto L37;
        r18.setColor(androidx.core.content.a.b(getContext(), r11.intValue()));
        return;
    L37:
        return;
    L25:
        r17 = null;
        goto L27
    L9:
        if (r12 != 2) goto L13;
        if (r10 == null) goto L16;
        r13 = r10.intValue();
        goto L16
    L13:
        throw new t();
    L15:
        r11 = Integer.valueOf(R.color.ConstTextInverse5);
        r13 = R.color.TextReverse;
        goto L16
    }

    public abstract int e();

    public final View f() {
        View r8 = this.f7362o;
        if (r8 == null) goto L5;
        return r8;
    L5:
        i.j("rootView");
        throw null;
    }

    public final void h(boolean r8, View.OnClickListener r10) {
        this.f7361n = r8;
        this.f7364q = r10;
        ImageView r11 = this.f7360m;
        if (r11 == null) goto L14;
        Resources r12 = Resources.getSystem();
        i.e(r12, "Resources.getSystem()");
        int r13 = l6.a.I0(TypedValue.applyDimension(1, 44, r12.getDisplayMetrics()));
        bc.a.a(r11, r13, r13, false);
        View r14 = this.f7359b;
        if (r8 == false) goto L11;
        if (r14 == null) goto L8;
        bc.a.c(r14);
    L8:
        d(this.f7363p, null, null);
        if (r14 == null) goto L15;
        r14.setOnClickListener(new b(this));
        return;
    L15:
        return;
    L11:
        if (r14 == null) goto L17;
        bc.a.b(r14);
        return;
    L17:
        return;
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        this.f7366s.removeCallbacksAndMessages(null);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        Window r8 = getWindow();
        if (r8 == null) goto L38;
        r8.setBackgroundDrawableResource(android.R.color.transparent);
        r8.addFlags(2);
        r8.setNavigationBarContrastEnforced(false);
        r8.setDecorFitsSystemWindows(false);
        r8.clearFlags(134217728);
        r8.addFlags(Integer.MIN_VALUE);
        r8.setNavigationBarColor(0);
        r8.setNavigationBarDividerColor(0);
        WindowManager.LayoutParams r10 = r8.getAttributes();
        r10.gravity = 81;
        r10.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        if (this.f7368u == false) goto L7;
        r10.height = -1;
    L8:
        boolean r11 = this.f7367t;
        View r12 = this.f7362o;
        if (r11 == false) goto L27;
        if (r12 == null) goto L25;
        ViewGroup.LayoutParams r13 = r12.getLayoutParams();
        r13.width = -1;
        if ((r13 instanceof ViewGroup.MarginLayoutParams) == true) goto L14;
        ViewGroup.LayoutParams r14 = null;
    L15:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r14;
        if (r15 == null) goto L18;
        r15.bottomMargin = 0;
    L18:
        j r16 = j.f13877a;
        r12.setLayoutParams(r13);
        if ((r12 instanceof RadiusLayout) == true) goto L21;
        View r17 = null;
    L22:
        RadiusLayout r18 = (RadiusLayout) r17;
        if (r18 == null) goto L29;
        Context r19 = r18.getContext();
        i.e(r19, "context");
        float r20 = r19.getResources().getDimension(R.dimen.oui_r_l3);
        r18.a(r20, r20, 0.0f, 0.0f);
    L29:
        Context r21 = r8.getContext();
        i.e(r21, "context");
        if (t2.b.J(r21) == false) goto L35;
        if (r12 == null) goto L33;
        ViewGroup.LayoutParams r22 = r12.getLayoutParams();
        r22.width = android.aimedia.a.a("Resources.getSystem()", 1, 440);
        r12.setLayoutParams(r22);
        goto L35
    L33:
        i.j("rootView");
        throw null;
    L35:
        r8.setAttributes(r10);
        return;
    L21:
        r17 = r12;
        goto L22
    L14:
        r14 = r13;
        goto L15
    L25:
        i.j("rootView");
        throw null;
    L27:
        if (r12 == null) goto L36;
        ViewGroup.LayoutParams r23 = r12.getLayoutParams();
        Context r24 = r8.getContext();
        i.e(r24, "context");
        Resources r25 = r24.getResources();
        i.e(r25, "context.resources");
        int r26 = r25.getDisplayMetrics().widthPixels;
        Context r27 = r8.getContext();
        i.e(r27, "context");
        r23.width = r26 - (r27.getResources().getDimensionPixelSize(R.dimen.oui_dialog_layout_margin) * 2);
        j r28 = j.f13877a;
        r12.setLayoutParams(r23);
        goto L29
    L36:
        i.j("rootView");
        throw null;
    L7:
        r10.height = -2;
        goto L8
    }
}
