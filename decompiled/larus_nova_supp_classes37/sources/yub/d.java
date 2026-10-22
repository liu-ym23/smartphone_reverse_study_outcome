package yub;

import android.content.Context;
import com.ss.android.lark.appcontext.applifecycle.y;
import com.ss.android.lark.officesdk.minutes.service.fileupload.k;
import com.ss.android.lark.utils.LarkContext;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements a {
    public static final d a = null;
    public static final HashMap<a.b, com.ss.android.lark.appcontext.applifecycle.a> b = null;
    public static final HashMap<a.c, y> c = null;

    public d() {
    }

    static {
        a = new d();
        b = new HashMap();
        c = new HashMap();
    }

    @Override // yub.a
    public Context getContext() {
        return LarkContext.getApplication();
    }

    public static final a.C0206a c(y.a r5) {
        if (r5 == null) goto L14;
        String r2 = r5.a;
        String r3 = "";
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        String r4 = r5.b;
        if (r4 == null) goto L13;
        r3 = r4;
    L13:
        return new a.C0206a(r2, r3, r5.c, false);
    L14:
        return new a.C0206a(0);
    }

    @Override // yub.a
    public final void a(k r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        y r3 = c.remove(r2);
        if (r3 == null) goto L6;
        com.ss.android.lark.appcontext.applifecycle2.api.a.d(r3);
        return;
    }

    @Override // yub.a
    public final void b(k r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        HashMap<a.c, y> r0 = c;
        if (r0.containsKey(r3) == false) goto L5;
        return;
    L5:
        c r1 = new c(r3);
        r0.put(r3, r1);
        com.ss.android.lark.appcontext.applifecycle2.api.a.c(r1);
    }
}
