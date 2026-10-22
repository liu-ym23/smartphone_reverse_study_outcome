package com.obric.memorydata.middleware.impl.network;

import android.content.Context;
import com.bytedance.ttnet.TTNetInit;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/middleware/impl/network/ObricSecurityNetworkAuthenticator;", "", "<init>", "()V", "TAG", "", "setTLSAuth", "", "context", "Landroid/content/Context;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f11766a = null;

    static {
        f11766a = new d();
    }

    private d() {
    }

    public final void a(Context r11) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "context");
        boolean r12 = true;
        String[] r3 = {b.f11762a.b()};
        c r0 = c.b();
        List<X509Certificate> r5 = r0.a("SYSTEM_Device_TLS_cert");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L8:
        if (r12 == false) goto L11;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ObricSecurityNetworkAuthenticator", "setTLSAuth failed, cert chain is null or empty.", null, 4, null);
        return;
    L11:
        X509Certificate r13 = (X509Certificate) ZeusTransformUtils.preCheckCast(r5.get(0), X509Certificate.class, "com.obric.memorydata.plugin");
    L17:
        th = move-exception;
        RunLog.INSTANCE.error("ObricSecurityNetworkAuthenticator", "setTLSAuth, failed, " + th.getMessage(), th);
        return;
    L13:
        if (r0.d("SYSTEM_Device_TLS_pkey") == false) goto L15;
        TTNetInit.addClientOpaqueDataV1(r2, r3, r13.getEncoded(), null, r0.a(), r0.c("SYSTEM_Device_TLS_pkey"));     // Catch: Throwable -> L17
    L20:
        return;
    L15:
        TTNetInit.addClientOpaqueDataV1(r2, r3, r13.getEncoded(), r0.b("SYSTEM_Device_TLS_pkey").getEncoded());     // Catch: Throwable -> L17
        goto L20
    L5:
        if (r6.isEmpty() == true) goto L8;
        r12 = false;
        goto L8
    }
}
