package sz7;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class o implements k {
    public final /* synthetic */ Integer a;
    public final /* synthetic */ q b;
    public final /* synthetic */ Drawable c;

    @Override // sz7.k
    public final void setIcon(Drawable r3) {
        Integer r0 = this.a;
        if (r0 == null) goto L12;
        if (r0 != null) goto L7;
    L8:
        if (r3 == null) goto L10;
        r3.mutate();
    L10:
        if (r3 == null) goto L12;
        r3.setTint(this.a.intValue());
        goto L12
    L7:
        if (r0.intValue() != 0) goto L8;
    L12:
        q r1 = this.b;
        r1.e(q.a(r1, r3, this.c));
    }

    public o(Integer r1, q r2, Drawable r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
