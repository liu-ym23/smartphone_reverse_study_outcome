package com.obric.assistant.onelogin;

import android.text.TextUtils;
import com.larus.account.base.api.ILoginService;
import com.larus.login.api.ILoginApi;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.login.l;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import oc7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class x implements Function3 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ boolean e;

    public /* synthetic */ x(String r1, String r2, String r3, l r4, boolean r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke(Object r12, Object r13, Object r14) {
        String r0 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        Function1 r10 = this.d;
        boolean r3 = this.e;
        ua7.h r15 = (ua7.h) r12;
        String r5 = (String) r13;
        String r6 = (String) r14;
        Intrinsics.checkNotNullParameter(r5, "loginMethod");
        Intrinsics.checkNotNullParameter(r6, "resultStage");
        if (TextUtils.equals(a.a, "login") == false) goto L6;
        a.a = null;
        a.b = null;
    L6:
        FLogger.a.i("ObricOneLoginUtils", "readSecDataOneLogin onSuccess, loginId=" + r0 + ", source=" + r1 + ", type=" + r2 + ", method=" + r5 + ", stage=" + r6);
        c0.i(r0, r1, r2, r3, 1, r5, r6, r15, null, 256);
        ILoginService r16 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r16 == null) goto L16;
        if (r15 == null) goto L14;
        com.ss.android.account.d r17 = r15.p;
        if (r17 == null) goto L14;
        boolean r4 = true;
        if (((sc7.a) r17).g != true) goto L14;
    L15:
        r16.m(r4);
        r16.N();
    L14:
        r4 = false;
    L16:
        ILoginApi r18 = (ILoginApi) ServiceManager.get().getService(ILoginApi.class);
        if (r18 == null) goto L19;
        r18.B();
    L19:
        r10.invoke(r15);
        return Unit.INSTANCE;
    }
}
