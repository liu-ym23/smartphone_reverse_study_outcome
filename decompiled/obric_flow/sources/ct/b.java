package ct;

import android.content.Intent;
import sj.g;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements ys.a {
    public static String b(Intent r5) {
        if (r5 != null) goto L4;
        return "null";
    L4:
        StringBuilder r10 = new StringBuilder(128);
        r10.append("Intent { ");
        g.r(r5, r10);
        r10.append(" }");
        return r10.toString();
    }

    @Override // ys.a
    public final /* bridge */ /* synthetic */ String a(Object r5) {
        return b((Intent) r5);
    }
}
