package wt8;

import android.view.ViewGroup;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ o a;

    public /* synthetic */ n(o r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o r0 = this.a;
        boolean r1 = ((Boolean) r0.d.invoke()).booleanValue();
        if (r1 == false) goto L5;
        int[] r2 = o.f;
    L7:
        if (Arrays.equals(r0.a.l.getReferencedIds(), r2) == false) goto L9;
        boolean r3 = false;
    L10:
        ViewGroup.LayoutParams r4 = r0.a.n.getLayoutParams();
        if (r1 == false) goto L13;
        int r5 = r0.a();
    L15:
        if (r4.width == r5) goto L17;
        r4.width = r5;
        r0.a.n.setLayoutParams(r4);
        r0.b();
        return;
    L17:
        if (r3 == false) goto L21;
        r0.b();
        return;
    L21:
        return;
    L13:
        r5 = r0.a.a.getResources().getDimensionPixelSize(v19.c.b(2130971565, null, 2131167499));
        goto L15
    L9:
        r0.a.l.setReferencedIds(r2);
        r3 = true;
        goto L10
    L5:
        r2 = o.e;
        goto L7
    }
}
