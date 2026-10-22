package etc;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b implements e {
    public final gtc.g a;
    public final d b;
    public final String c;

    @Override // etc.e
    public final CharSequence a(String r5, String r6) {
        if (r6.isEmpty() == false) goto L5;
        return r6;
    L5:
        if (r5 == null) goto L16;
        gtc.g.a r0 = this.a.b(r5);
        if (r0 == null) goto L10;
    L12:
        if (r0 == null) goto L15;
        SpannableStringBuilder r1 = new SpannableStringBuilder();
        c r2 = new c(r5, this.b, r1);
        this.a.getClass();
        r2.a(gtc.g.j(r6, r0));
        return r1;
    L15:
        return r6;
    L10:
        if (TextUtils.isEmpty(this.c) == true) goto L12;
        r5 = this.c;
        r0 = this.a.b(r5);
        goto L12
    L16:
        return r6;
    }

    public b(gtc.g r1, d r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
