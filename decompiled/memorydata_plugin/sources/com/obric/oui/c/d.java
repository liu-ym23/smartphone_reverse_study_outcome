package com.obric.oui.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/utils/NetworkUtil;", "", "()V", "isNetworkAvailable", "", "context", "Landroid/content/Context;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f13404a = null;

    static {
        f13404a = new d();
    }

    private d() {
    }

    @JvmStatic
    public static final boolean a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Object r5 = r4.getSystemService("connectivity");
        Objects.requireNonNull(r5, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager r6 = (ConnectivityManager) ZeusTransformUtils.preCheckCast(r5, ConnectivityManager.class, "com.obric.memorydata.plugin");
        Network r0 = r6.getActiveNetwork();
        if (r0 != null) goto L5;
        return false;
    L5:
        NetworkCapabilities r7 = r6.getNetworkCapabilities(r0);
        if (r7 != null) goto L9;
        return false;
    L9:
        if (r7.hasTransport(1) == false) goto L12;
    L17:
        return true;
    L12:
        if (r7.hasTransport(0) == true) goto L17;
        if (r7.hasTransport(3) == true) goto L17;
        return false;
    }
}
