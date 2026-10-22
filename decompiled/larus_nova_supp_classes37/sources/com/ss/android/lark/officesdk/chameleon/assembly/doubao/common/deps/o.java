package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class o implements ntb.n {

    public static final class a {
    }

    static {
    }

    public o() {
    }

    @Override // ntb.n
    public final void d(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "message");
        Log.d("OfficeSdk-" + r3, r4);
    }

    @Override // ntb.n
    public final void i(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "message");
        Log.i("OfficeSdk-" + r3, r4);
    }

    @Override // ntb.n
    public final void w(String r3, String r4, Throwable r5) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "message");
        if (r5 == null) goto L5;
        Log.w("OfficeSdk-" + r3, r4, r5);
        return;
    L5:
        Log.w("OfficeSdk-" + r3, r4);
    }

    @Override // ntb.n
    public final void g(String r3, String r4, Throwable r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "message");
        if (r5 == null) goto L5;
        Log.e("OfficeSdk-" + r3, r4, r5, r6);
        return;
    L5:
        Log.e("OfficeSdk-" + r3, r4);
    }
}
