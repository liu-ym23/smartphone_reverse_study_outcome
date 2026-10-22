package com.obric.matrix.sdk.network;

import com.bytedance.apm6.util.constant.CommonConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/obric/matrix/sdk/network/NetworkSDKInit;", "", "()V", "TAG", "", "config", "Lcom/obric/matrix/sdk/network/NetworkConfig;", "getConfig", "()Lcom/obric/matrix/sdk/network/NetworkConfig;", "setConfig", "(Lcom/obric/matrix/sdk/network/NetworkConfig;)V", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "context", "Landroid/content/Context;", "application", "Landroid/app/Application;", "host", "interceptors", "", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "requestListener", "Lcom/obric/matrix/sdk/network/InterfaceRequestListener;", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8258a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f8259b;

    static {
        f8258a = new b();
    }

    private b() {
    }

    public final a a() {
        a r0 = f8259b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("config");
        return null;
    }
}
