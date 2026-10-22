package kd;

import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements gd.b {
    public b() {
    }

    public static String b(Intent r8) {
        if (r8 != null) goto L4;
        return "null";
    L4:
        StringBuilder r10 = new StringBuilder(128);
        r10.append("Intent { ");
        nd.b.c(r8, r10);
        r10.append(" }");
        return r10.toString();
    }

    @Override // gd.b
    public final /* bridge */ /* synthetic */ String a(Object r8) {
        return b((Intent) r8);
    }
}
