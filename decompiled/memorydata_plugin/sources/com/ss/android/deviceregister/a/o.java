package com.ss.android.deviceregister.a;

import android.content.Context;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
final class o {
    static n a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (com.ss.android.deviceregister.d.e.n() == false) goto L7;
        return new t(new x());
    L7:
        if (x.a() == false) goto L11;
        return new x();
    L11:
        if (r.a() == false) goto L15;
        return new r();
    L15:
        if (com.ss.android.deviceregister.d.e.i() == true) goto L59;
        if (com.ss.android.deviceregister.d.e.j() == true) goto L59;
        if (com.ss.android.deviceregister.d.e.q() == false) goto L24;
        return new t();
    L24:
        if (com.ss.android.deviceregister.d.e.p() == false) goto L28;
        return new k();
    L28:
        if (Build.VERSION.SDK_INT <= 28) goto L51;
        if (com.ss.android.deviceregister.d.e.r() == false) goto L34;
        return new v();
    L34:
        if (com.ss.android.deviceregister.d.e.t() == false) goto L38;
        return new l();
    L38:
        if (com.ss.android.deviceregister.d.e.s() == false) goto L42;
        return new j();
    L42:
        if (com.ss.android.deviceregister.d.e.u() == true) goto L44;
        e r0 = new e(r3);
        if (r0.b(r3) == false) goto L49;
        return r0;
    L49:
        return new d();
    L44:
        return new a();
    L51:
        if (com.ss.android.common.b.d.b() == false) goto L53;
        return null;
    L53:
        if (g.a(r3) == true) goto L55;
        return null;
    L55:
        return new g();
    L59:
        return new g();
    }
}
