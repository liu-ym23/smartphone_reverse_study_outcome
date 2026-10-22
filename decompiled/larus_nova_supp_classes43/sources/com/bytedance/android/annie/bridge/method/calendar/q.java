package com.bytedance.android.annie.bridge.method.calendar;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q {
    public static final Uri a(Uri r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter("com.bytedance", "account");
        Intrinsics.checkNotNullParameter("LOCAL", "accountType");
        return r10.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", "com.bytedance").appendQueryParameter("account_type", "LOCAL").build();
    }
}
