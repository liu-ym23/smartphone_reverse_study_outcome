package com.larus.common.account.phone;

import com.larus.account.base.impl.LoginServiceImpl;
import com.larus.account.base.model.LoginPlatform;
import com.larus.account.base.provider.agegate.AgeGateManagerService;
import com.larus.account.base.provider.agegate.IAgeGateManagerInterface;
import org.json.JSONObject;
import s38.b;
import ua7.e;
import wb7.i;
import yb7.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a extends h {
    public final /* synthetic */ n38.h a;
    public final /* synthetic */ LoginPlatform b;
    public final /* synthetic */ String c;
    public final /* synthetic */ PhoneLogin d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ IAgeGateManagerInterface g;
    public final /* synthetic */ b h;
    public final /* synthetic */ JSONObject i;

    public final void b(e<i> r4) {
        this.a.b(this.b, this.c, Boolean.FALSE);
    }

    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r1) {
        b((e) r1);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.larus.common.account.phone.PhoneLogin$a] */
    public final void a(final e<i> r13, final int r14) {
        PhoneLogin r0 = this.d;
        if (r14 != r0.c) goto L7;
        final String r3 = this.e;
        final LoginPlatform r4 = this.b;
        final String r5 = this.f;
        final n38.h r6 = this.a;
        final String r7 = this.c;
        r0.d = new PhoneLogin$a(r3, r4, r5, r6, r7, r14, r13);
        IAgeGateManagerInterface r15 = this.g;
        if (r15 == null) goto L14;
        r15.a(this.h, "phone_verify_code", this.i);
        return;
    L14:
        return;
    L7:
        n38.h r2 = this.a;
        LoginPlatform r8 = this.b;
        if (r13 == null) goto L11;
        String r16 = ((ua7.b) r13).i;
        if (r16 == null) goto L11;
    L12:
        n38.h.a.a(r2, r8, r14, r16, this.c, null, null, null, null, 480);
        return;
    L11:
        r16 = "";
        goto L12
    }

    public final /* bridge */ /* synthetic */ void onError(ua7.b r1, int r2) {
        a((e) r1, r2);
    }

    public a(LoginServiceImpl.d r1, LoginPlatform r2, String r3, PhoneLogin r4, String r5, String r6, AgeGateManagerService r7, b r8, JSONObject r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
