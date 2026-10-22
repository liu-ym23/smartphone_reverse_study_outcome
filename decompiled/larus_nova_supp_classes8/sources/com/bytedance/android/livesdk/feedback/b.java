package com.bytedance.android.livesdk.feedback;

import android.net.Uri;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final Uri a(String r1, String r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        Uri.Builder r3 = x6.a.d(r1).buildUpon();
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        return r3.appendQueryParameter("fallback_url", r2).build();
    }
}
