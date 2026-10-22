package com.ss.android.lark.contact.customized;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.router.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class OfficeContactPageUtils {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(OfficeContactPageUtils$contactAggregateSearchUrl$2.INSTANCE);
    }

    public static void a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        int r0 = c.a;
        Log.i("Contact_PageUtils", "openAggregateSearchPage handled=" + c.b(r2, (String) a.getValue()));
    }

    public static void b(Context r2, Intent r3) {
        if ((r2 instanceof Activity) == true) goto L5;
        r3.addFlags(268435456);
        Log.i("Contact_PageUtils", "add FLAG_ACTIVITY_NEW_TASK for context=".concat(r2.getClass().getName()));
    L5:
        r2.startActivity(r3);
    }
}
