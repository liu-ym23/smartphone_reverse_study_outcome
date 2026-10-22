package dc;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.obric.cae.R;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends fc.d<e> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f7059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7060h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f7061i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f7062j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DialogInterface.OnClickListener f7063k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a.EnumC0062a f7064l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public CharSequence f7065m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public DialogInterface.OnClickListener f7066n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a.EnumC0062a f7067o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f7068p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f7069q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public m f7070r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Context f7071s;

    public k(Context r8) {
        he.i.f(r8, "context");
        super(r8);
        this.f7071s = r8;
        this.f7061i = "";
        this.f7069q = true;
        this.f7376c = false;
    }

    @Override // fc.d
    public final fc.a b() {
        Context r8 = this.f7071s;
        he.i.f(r8, "context");
        e r10 = new e(r8);
        CharSequence r11 = this.f7059g;
        i r12 = new i(this, r10);
        if (TextUtils.isEmpty(r11) == true) goto L5;
        he.i.c(r11);
        r12.invoke(r11);
    L5:
        new j(this, r10);
        if (TextUtils.isEmpty(null) == false) goto L48;
        this.f7061i.getClass();
        r10.f7365r = this.f7069q;
        a r13 = new a(r8);
        r10.A = r13;
        FrameLayout r14 = r10.f7050z;
        if (r14 == null) goto L10;
        Context r15 = r10.getContext();
        he.i.e(r15, "context");
        r13.a(r15, r14);
    L10:
        m r16 = this.f7070r;
        if (r16 == null) goto L16;
        r10.C = r16;
        FrameLayout r17 = r10.B;
        if (r17 == null) goto L16;
        r17.setVisibility(0);
        Context r18 = r10.getContext();
        he.i.e(r18, "context");
        r16.a(r18, r17);
    L16:
        if (this.f7377d == true) goto L18;
        this.f7377d = false;
        this.f7375b = null;
    L18:
        r10.setOnShowListener(null);
        r10.setOnDismissListener(null);
        r10.setOnCancelListener(this.f7374a);
        CharSequence r19 = this.f7065m;
        DialogInterface.OnClickListener r20 = this.f7066n;
        a.EnumC0062a r21 = this.f7067o;
        boolean r22 = this.f7068p;
        OButton r23 = r13.f7032a;
        if (r23 != null) goto L21;
    L29:
        CharSequence r24 = this.f7062j;
        DialogInterface.OnClickListener r25 = this.f7063k;
        a.EnumC0062a r110 = this.f7064l;
        OButton r26 = r13.f7033b;
        if (r26 != null) goto L32;
    L38:
        OButton r111 = r13.f7034c;
        if (r111 != null) goto L41;
    L47:
        return r10;
    L41:
        if (TextUtils.isEmpty(null) == false) goto L43;
        r111.setVisibility(8);
        goto L47
    L43:
        View r27 = r13.f7036e;
        if (r27 == null) goto L46;
        r27.setVisibility(0);
    L46:
        r111.setText(null);
        r111.setVisibility(0);
        r111.setOnClickListener(new c(r13));
        goto L47
    L32:
        if (TextUtils.isEmpty(r24) == false) goto L34;
        r26.setVisibility(8);
        goto L38
    L34:
        View r28 = r13.f7036e;
        if (r28 == null) goto L37;
        r28.setVisibility(0);
    L37:
        r26.setText(r24);
        a.b(r26, r110);
        r26.setVisibility(0);
        r26.setOnClickListener(new b(r13, r25));
        goto L38
    L21:
        if (TextUtils.isEmpty(r19) == false) goto L23;
        r23.setVisibility(8);
        goto L29
    L23:
        View r112 = r13.f7036e;
        if (r112 == null) goto L26;
        r112.setVisibility(0);
    L26:
        if (r22 == false) goto L28;
        Context r29 = r13.f7037f;
        r23.setBackgroundTintList(androidx.core.content.a.b(r29, R.color.oui_red_6));
        r23.setTextColor(androidx.core.content.a.c.a(r29, R.color.white));
    L28:
        r23.setText(r19);
        a.b(r23, r21);
        r23.setVisibility(0);
        r23.setOnClickListener(new d(r13, r20));
        goto L29
    L48:
        he.i.c(null);
        throw null;
    }

    public final void d(int r8, DialogInterface.OnClickListener r10) {
        String r11 = this.f7071s.getString(r8);
        he.i.e(r11, "context.getString(text)");
        this.f7062j = r11;
        this.f7063k = r10;
        this.f7064l = null;
    }
}
