package fs1;

import android.content.Context;
import com.bytedance.android.scope.o;
import nm1.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements n, o {
    public a() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final com.bytedance.android.livesdk.chorusconcert.descriptor.a d() {
        return new com.bytedance.android.livesdk.chorusconcert.descriptor.a();
    }

    public final void c(long r2) {
        es1.a.j.a(r2);
    }

    public final boolean a(Long r5, Context r6) {
        if (r5 == null) goto L12;
        if (r6 == null) goto L15;
        es1.a r7 = es1.a.j.c(r5.longValue(), r6, false);
        if (r7 != null) goto L9;
        return false;
    L9:
        if (r7.c != true) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    L12:
        return false;
    }
}
