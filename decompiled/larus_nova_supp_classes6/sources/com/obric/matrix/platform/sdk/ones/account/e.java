package com.obric.matrix.platform.sdk.ones.account;

import android.os.Bundle;
import dka.a;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ Bundle d;
    public final /* synthetic */ Function0 e;
    public final /* synthetic */ Function0 f;
    public final /* synthetic */ Function2 g;

    public /* synthetic */ e(boolean r1, String r2, Function1 r3, Bundle r4, Function0 r5, Function0 r6, Function2 r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r0 = this.a;
        String r1 = this.b;
        Function1 r2 = this.c;
        Bundle r3 = this.d;
        Function0 r4 = this.e;
        Function0 r5 = this.f;
        Function2 r6 = this.g;
        Intrinsics.checkNotNullParameter(r1, "$method");
        if (r0 == false) goto L11;
        a.a("AccountSDK_OAccount", "asyncResult, " + r1 + ", success");
        if (r2 == null) goto L7;
        r2.invoke(r3);
    L9:
        if (r5 == null) goto L27;
        r5.invoke();
        return;
    L27:
        return;
    L7:
        if (r4 == null) goto L9;
        r4.invoke();
        goto L9
    L11:
        OAccount.a.getClass();
        int r7 = -1;
        if (r3 == null) goto L14;
        r7 = r3.getInt("errorCode", -1);
    L14:
        String r8 = (String) OAccount.h.getValue();
        if (r3 == null) goto L17;
        String r9 = r3.getString("errorMsg", r8);
    L18:
        if (r9 == null) goto L21;
        r8 = r9;
    L21:
        a.b("AccountSDK_OAccount", "asyncResult, " + r1 + " failed. errorCode: " + r7 + " errorMsg: " + r8 + '.');
        if (r6 == null) goto L24;
        r6.invoke(Integer.valueOf(r7), r8);
    L24:
        if (r5 == null) goto L29;
        r5.invoke();
        return;
    L29:
        return;
    L17:
        r9 = null;
        goto L18
    }
}
