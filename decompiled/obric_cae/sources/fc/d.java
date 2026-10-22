package fc;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import fc.a;
import he.i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d<D extends a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DialogInterface.OnCancelListener f7374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnClickListener f7375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a.EnumC0073a f7378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final xd.d<Integer, Integer> f7379f;

    public d(Context r8) {
        i.f(r8, "context");
        this.f7376c = true;
        this.f7378e = a.EnumC0073a.f7369a;
        this.f7379f = new xd.d(null, null);
    }

    public final D a() {
        D r8 = (D) b();
        r8.h(this.f7377d, this.f7375b);
        r8.setCancelable(this.f7376c);
        xd.d<Integer, Integer> r10 = this.f7379f;
        Integer r11 = r10.f13867a;
        Integer r12 = r10.f13868b;
        r8.d(this.f7378e, r11, r12);
        return r8;
    }

    public abstract D b();

    public final void c() {
        a().show();
    }
}
