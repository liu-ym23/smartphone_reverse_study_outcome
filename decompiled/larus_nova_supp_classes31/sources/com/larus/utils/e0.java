package com.larus.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.larus.common.apphost.AppHost;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class e0 {
    public static final Handler a = null;
    public static final ConnectivityManager b = null;
    public static final MutableLiveData<Boolean> c = null;

    public static final class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network r4) {
            Intrinsics.checkNotNullParameter(r4, "network");
            Handler r5 = e0.a;
            r5.removeCallbacksAndMessages(null);
            r5.postDelayed(new d0(true), 300);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network r4) {
            Intrinsics.checkNotNullParameter(r4, "network");
            Handler r5 = e0.a;
            r5.removeCallbacksAndMessages(null);
            r5.postDelayed(new d0(false), 300);
        }
    }

    public e0() {
    }

    static {
        a = new Handler(Looper.getMainLooper());
        Object r0 = AppHost.a.getApplication().getSystemService("connectivity");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager r1 = (ConnectivityManager) r0;
        b = r1;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        NetworkInfo r3 = r1.getActiveNetworkInfo();     // Catch: Throwable -> L9
        if (r3 == null) goto L6;
        boolean r4 = r3.isConnected();     // Catch: Throwable -> L9
    L7:
        Object r5 = Result.constructor-impl(Boolean.valueOf(r4));     // Catch: Throwable -> L9
    L11:
        Boolean r6 = Boolean.FALSE;
        if (Result.isFailure-impl(r5) == false) goto L14;
        r5 = r6;
    L14:
        c = new MutableLiveData(r5);
        b.registerNetworkCallback(new NetworkRequest.Builder().build(), new a());     // Catch: Exception -> L17
        return;
    L22:
        return;
    L6:
        r4 = false;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }
}
