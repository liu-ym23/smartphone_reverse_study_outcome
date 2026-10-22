package com.ss.ugc.effectplatform.util;

import android.content.Context;
import android.net.ConnectivityManager;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class l {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Object r1) {
        if (r1 != null) goto L4;
    L11:
        return false;
    L4:
        if ((r1 instanceof Context) == false) goto L11;
        Object r2 = ((Context) r1).getSystemService("connectivity");     // Catch: Exception -> L13
        if (r2 == null) goto L10;
        return ((ConnectivityManager) r2).getActiveNetworkInfo().isConnected();
    L10:
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L13
    }
}
