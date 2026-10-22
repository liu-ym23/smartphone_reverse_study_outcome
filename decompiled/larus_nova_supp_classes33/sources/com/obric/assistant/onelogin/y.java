package com.obric.assistant.onelogin;

import android.text.TextUtils;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import oc7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class y implements Function4 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ boolean d;
    public final /* synthetic */ Function2 e;

    public /* synthetic */ y(String r1, String r2, String r3, boolean r4, Function2 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke(Object r11, Object r12, Object r13, Object r14) {
        String r0 = this.a;
        String r1 = this.b;
        String r2 = this.c;
        boolean r3 = this.d;
        Function2 r9 = this.e;
        ua7.h r15 = (ua7.h) r11;
        String r16 = (String) r12;
        String r5 = (String) r13;
        String r6 = (String) r14;
        Intrinsics.checkNotNullParameter(r5, "loginMethod");
        Intrinsics.checkNotNullParameter(r6, "resultStage");
        Integer r17 = null;
        if (TextUtils.equals(a.a, "login") == false) goto L6;
        a.a = null;
        a.b = null;
    L6:
        FLogger r18 = FLogger.a;
        StringBuilder r4 = new StringBuilder("readSecDataOneLogin onError, loginId=");
        r4.append(r0);
        r4.append(", source=");
        r4.append(r1);
        r4.append(", type=");
        r4.append(r2);
        r4.append(", method=");
        r4.append(r5);
        r4.append(", stage=");
        r4.append(r6);
        r4.append(", enableSafeOneLogin=");
        r4.append(r3);
        r4.append(", detailCode=");
        if (r15 == null) goto L9;
        r17 = Integer.valueOf(((ua7.b) r15).h);
    L9:
        r4.append(r17);
        r4.append(", error=");
        r4.append(r16);
        r18.e("ObricOneLoginUtils", r4.toString());
        c0.h(r0, r1, r2, r3, 0, r5, r6, r15, r16);
        r9.invoke(r15, r16);
        return Unit.INSTANCE;
    }
}
