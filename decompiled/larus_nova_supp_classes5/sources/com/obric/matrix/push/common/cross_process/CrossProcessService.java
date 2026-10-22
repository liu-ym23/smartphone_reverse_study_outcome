package com.obric.matrix.push.common.cross_process;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.obric.matrix.sdk.push.cross_process.MessageServiceV2;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import jka.b;
import jka.c;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class CrossProcessService implements c {
    public final Context a;
    public final String b;
    public final ConcurrentHashMap<String, ICrossProcessInterface> c;
    public final ConcurrentHashMap<String, ServiceConnection> d;
    public final ConcurrentHashMap<String, b> e;

    public CrossProcessService(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        this.a = r2;
        this.b = "CrossProcessService";
        this.c = new ConcurrentHashMap();
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
    }

    public final void d(MessageServiceV2.a r4) {
        Intrinsics.checkNotNullParameter(r4, "method");
        kka.b.a(this.b, "register cross process method: " + r4);
        this.e.put(".action.MESSAGE_EVENT", r4);
    }

    public final void b(String r5, ArrayList r6, jka.a r7) {
        Intrinsics.checkNotNullParameter("com.obric.matrix", "targetPkg");
        Intrinsics.checkNotNullParameter(r5, "method");
        kka.b.a(this.b, "try invoke " + r5 + " method");
        ICrossProcessInterface r0 = this.c.get("com.obric.matrix");
        if (r0 == null) goto L5;
        kka.b.a(this.b, "binder of  com.obric.matrix is not null , invoke internal");
        c(r0, r5, r6, r7);
        Unit r1 = Unit.INSTANCE;
    L6:
        if (r1 != null) goto L9;
        kka.b.a(this.b, "binder of  com.obric.matrix is null , bind target service");
        a r2 = new a(this, r5, r6, r7);
        Intent r8 = new Intent();
        r8.setPackage("com.obric.matrix");
        r8.setAction("com.obric.matrix.action.CROSS_PROCESS");
        r8.putExtra("origin_package_name", this.a.getPackageName());
        r8.putExtra("is_from_on_bind", false);
        kka.b.a(this.b, "bind com.obric.matrix's CrossProcessService");
        this.a.bindService(r8, r2, 1);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // jka.c
    public final void a(String r3, String r4, List<Object> r5, ICrossProcessCallbackInterface r6) {
        Intrinsics.checkNotNullParameter(r3, "method");
        Intrinsics.checkNotNullParameter(r4, "originPkgName");
        kka.b.a(this.b, r3 + " be invoked");
        b r7 = this.e.get(r3);
        if (r7 == null) goto L6;
        r7.a(r4, r5);
        return;
    }

    public final void c(ICrossProcessInterface r5, final String r6, ArrayList<Object> r7, final jka.a r8) {
        kka.b.a(this.b, "invoke " + r6 + " method internal");
        r5.invoke(r6, this.a.getPackageName(), r7, new CrossProcessService$invokeInternal$1(this, r6, r8));     // Catch: Exception -> L5
        return;
    L5:
        String r9 = this.b;
        String r10 = "invoke " + r6 + " method internal error";
        Intrinsics.checkNotNullParameter(r9, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        String r11 = kka.b.c(r9, r10);
        Intrinsics.checkNotNullParameter("MATRIX_PUSH", "tag");
        Intrinsics.checkNotNullParameter(r11, "msg");
        if (r8 == null) goto L11;
        r8.onCallback(null);
        return;
    }
}
