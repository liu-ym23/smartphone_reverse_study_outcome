package qsc;

import android.text.Spanned;
import android.widget.TextView;
import iw8.d;
import kotlin.jvm.internal.Intrinsics;
import lsc.p;
import uvc.b;
import wsc.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a extends lsc.a {
    public final d a;
    public final boolean b;

    /* JADX INFO: renamed from: qsc.a$a, reason: collision with other inner class name */
    public static final class C0028a {
        public static f[] a(CharSequence r3) {
            Intrinsics.checkNotNullParameter(r3, "cs");
            if (r3.length() <= 0) goto L5;
            boolean r0 = true;
        L7:
            if (r0 == true) goto L9;
            return null;
        L9:
            if ((r3 instanceof Spanned) == false) goto L11;
            Spanned r1 = (Spanned) r3;
        L12:
            if (r1 != null) goto L14;
            return null;
        L14:
            return (f[]) r1.getSpans(0, r3.length(), f.class);
        L11:
            r1 = null;
            goto L12
        L5:
            r0 = false;
            goto L7
        }
    }

    static {
    }

    @Override // lsc.a, lsc.j
    public final void G4(TextView r2) {
        Intrinsics.checkNotNullParameter(r2, "textView");
        if (this.b == true) goto L6;
        this.a.a.clear();
        return;
    }

    public a(d r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "drawablePool");
        this.a = r2;
        this.b = r3;
    }

    @Override // lsc.a, lsc.j
    public final void i(CharSequence r5, b r6) {
        Intrinsics.checkNotNullParameter(r6, "node");
        if (r5 == null) goto L9;
        f[] r7 = C0028a.a(r5);
        if (r7 == null) goto L11;
        int r8 = r7.length;
        int r0 = 0;
    L7:
        if (r0 >= r8) goto L12;
        f r1 = r7[r0];
        d r2 = this.a;
        wsc.a r3 = r1.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "drawable");
        r2.a.add(r3);
        r0 = r0 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    @Override // lsc.a, lsc.j
    public final void l(TextView r5, b r6) {
        Intrinsics.checkNotNullParameter(r6, "node");
        if (r5 == null) goto L9;
        f[] r7 = C0028a.a(r5.getText());
        if (r7 == null) goto L11;
        int r8 = r7.length;
        int r0 = 0;
    L7:
        if (r0 >= r8) goto L12;
        f r1 = r7[r0];
        d r2 = this.a;
        wsc.a r3 = r1.b;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "drawable");
        r2.a.add(r3);
        r0 = r0 + 1;
        goto L7
    L12:
        return;
    L11:
        return;
    }

    @Override // lsc.a
    public final void m(b r2, p r3) {
        Intrinsics.checkNotNullParameter(r2, "node");
        Intrinsics.checkNotNullParameter(r3, "visitor");
        if (this.b == false) goto L6;
        this.a.a.clear();
        return;
    }
}
