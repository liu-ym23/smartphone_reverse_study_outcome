package com.ss.android.lark.keyboard.edittext2.utils;

import android.webkit.URLUtil;
import com.larksuite.framework.utils.n0;
import com.ss.android.lark.inv.export.router.InvRouter$InviteMemberNonDirectionalPage$Param$Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r2) {
        Intrinsics.checkNotNullParameter(r2, InvRouter$InviteMemberNonDirectionalPage$Param$Type.LINK);
        if (URLUtil.isNetworkUrl(r2) == true) goto L5;
        return false;
    L5:
        String r3 = n0.b(r2);
        if (r3 != null) goto L9;
        return false;
    L9:
        return new Regex("^applink\\..+\\.(com|cn)").matches(r3);
    }
}
