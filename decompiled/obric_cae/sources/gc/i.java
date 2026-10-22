package gc;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends fc.d<a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f7814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f7815h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7816i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Drawable f7817j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f7818k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence f7819l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public DialogInterface.OnClickListener f7820m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public hc.a.EnumC0088a f7821n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public CharSequence f7822o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public DialogInterface.OnClickListener f7823p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public hc.a.EnumC0088a f7824q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f7825r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f7826s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public hc.f f7827t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Context f7828u;

    public i(Context r8) {
        he.i.f(r8, "context");
        super(r8);
        this.f7828u = r8;
        this.f7818k = "";
        this.f7826s = true;
        this.f7376c = false;
    }

    @Override // fc.d
    public final fc.a b() {
        Context r8 = this.f7828u;
        he.i.f(r8, "context");
        a r10 = new a(r8);
        CharSequence r11 = this.f7814g;
        e r12 = new e(this, r10);
        if (TextUtils.isEmpty(r11) == true) goto L5;
        he.i.c(r11);
        r12.invoke(r11);
    L5:
        CharSequence r13 = this.f7815h;
        f r14 = new f(this, r10);
        if (TextUtils.isEmpty(r13) == true) goto L8;
        he.i.c(r13);
        r14.invoke(r13);
    L8:
        hc.f r15 = this.f7827t;
        if (r15 == null) goto L11;
        r10.f7802y = r15;
        Context r16 = r10.getContext();
        he.i.e(r16, "context");
        r15.c(r16, r10);
    L15:
        r10.f7365r = this.f7826s;
        hc.b r17 = new hc.b(r8);
        r10.C = r17;
        Context r18 = r10.getContext();
        he.i.e(r18, "context");
        r17.c(r18, r10);
        if (this.f7377d == true) goto L18;
        this.f7377d = false;
        this.f7375b = null;
    L18:
        r10.setOnShowListener(null);
        r10.setOnDismissListener(null);
        r10.setOnCancelListener(this.f7374a);
        r17.e(this.f7822o, this.f7823p, this.f7824q, this.f7825r);
        r17.a(this.f7819l, this.f7820m, this.f7821n);
        r17.d();
        return r10;
    L11:
        this.f7818k.getClass();
        Drawable r19 = this.f7817j;
        if (r19 == null) goto L15;
        hc.e r20 = new hc.e(r8);
        r20.f8042a = r19;
        r20.f8044c = null;
        r20.f8043b = null;
        r20.f8045d = true;
        r10.f7802y = r20;
        Context r21 = r10.getContext();
        he.i.e(r21, "context");
        r20.c(r21, r10);
        goto L15
    }

    public final void d(int r8, DialogInterface.OnClickListener r10) {
        String r11 = this.f7828u.getString(r8);
        he.i.e(r11, "context.getString(text)");
        this.f7819l = r11;
        this.f7820m = r10;
        this.f7821n = null;
    }

    public final void e(int r8, DialogInterface.OnClickListener r10) {
        String r11 = this.f7828u.getString(r8);
        he.i.e(r11, "context.getString(text)");
        this.f7822o = r11;
        this.f7823p = r10;
        this.f7824q = null;
    }

    public final void f(int r8) {
        String r10 = this.f7828u.getString(r8);
        this.f7816i = false;
        this.f7814g = r10;
    }
}
