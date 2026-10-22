package com.ss.android.lark.passport.flow.core.network;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(gpb.a r5) {
        Intrinsics.checkNotNullParameter(r5, "environment");
        String r0 = (String) CollectionsKt.firstOrNull(jcb.b.c().p0("passport_accounts", r5.envType(), r5.getUserUnit(), "feishu"));
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (StringsKt.isBlank(r0) == false) goto L15;
        int r6 = r5.envType();
        if (r6 != 2) goto L10;
        String r7 = "accounts.feishu-boe.cn";
    L14:
        r0 = r7;
        goto L15
    L10:
        if (r6 == 3) goto L12;
        r7 = "accounts.feishu.cn";
        goto L14
    L12:
        r7 = "accounts.feishu-pre.cn";
    L15:
        String r8 = StringsKt.trimEnd(StringsKt.trim(r0).toString(), new char[]{'/'});
        if (StringsKt.startsWith(r8, "http://", true) == false) goto L18;
        return r8;
    L18:
        if (StringsKt.startsWith(r8, "https://", true) == false) goto L21;
        return r8;
    L21:
        return "https://" + r8;
    }
}
