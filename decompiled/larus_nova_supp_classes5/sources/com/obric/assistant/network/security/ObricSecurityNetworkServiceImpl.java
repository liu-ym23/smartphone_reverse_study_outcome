package com.obric.assistant.network.security;

import android.content.Context;
import android.security.bytedance.ssl.BDKeyManagerRef;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ttnet.TTNetInit;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.network.IObricSecurityNetworkService;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.network.impl.ObricProtocolApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import iaa.a;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/network/security/ObricSecurityNetworkServiceImpl;", "Lcom/obric/assistant/common/spi/network/IObricSecurityNetworkService;", "<init>", "()V", "setTLSAuth", "", "context", "Landroid/content/Context;", "addObricHostsToOriginHost", "boeEnable", "", "ppeEnable", "hosts", "", "", "allowedToDisplayPrivateUrl", "openUrl", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSecurityNetworkServiceImpl implements IObricSecurityNetworkService {
    static {
    }

    public ObricSecurityNetworkServiceImpl() {
    }

    public final boolean a(String r3) {
        IObricNetworkService r0 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.a(r3);
    }

    public final void c(Context r13) {
        Intrinsics.checkNotNullParameter(r13, "context");
        int r1 = a.a;
        if (b.a().e() == false) goto L5;
        return;
    L5:
        FLogger r2 = FLogger.a;
        r2.i("ObricSecurityNetworkServiceImpl", "setTLSAuth, init");
        ObricProtocolApi.a.getClass();
        String[] r5 = {ObricProtocolApi.a.b};
        BDKeyManagerRef r3 = BDKeyManagerRef.getInstance();
        X509Certificate r4 = (X509Certificate) ListProtector.get(r3.getCertChain("SYSTEM_Device_TLS_cert"), 0);
        r2.i("ObricSecurityNetworkServiceImpl", "setTLSAuth, params: hosts.size: 1, hosts.first: " + ((String) ArraysKt.firstOrNull(r5)));
    L11:
        th = move-exception;
        FLogger.a.e("ObricSecurityNetworkServiceImpl", "setTLSAuth, failed, " + th.getMessage(), th);
        return;
    L7:
        if (r3.isContainsKey("SYSTEM_Device_TLS_pkey") == false) goto L9;
        TTNetInit.addClientOpaqueData(r13, r5, r4.getEncoded(), null, r3.getAlgorithmAddress(), r3.getDoSignAddress("SYSTEM_Device_TLS_pkey"));     // Catch: Throwable -> L11
    L14:
        return;
    L9:
        TTNetInit.addClientOpaqueData(r13, r5, r4.getEncoded(), r3.getPrivateKey("SYSTEM_Device_TLS_pkey").getEncoded());     // Catch: Throwable -> L11
        goto L14
    }

    public final void b(boolean r5, boolean r6, List<String> r7) {
        Intrinsics.checkNotNullParameter(r7, "hosts");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("addObricHostsToOriginHost, begin: boeEnable ");
        r1.append(r5);
        r1.append(" ppeEnable ");
        r1.append(r6);
        r1.append(" hosts.size: ");
        ArrayList r8 = (ArrayList) r7;
        r1.append(r8.size());
        r1.append(", hosts.first: ");
        r1.append((String) CollectionsKt.lastOrNull(r7));
        r0.i("ObricSecurityNetworkServiceImpl", r1.toString());
        if (r5 == true) goto L5;
        r8.add("fpa-miniapp-gateway.zijieapi.com");
    L5:
        ObricProtocolApi.a.getClass();
        r8.add(ObricProtocolApi.a.b);
        r8.add("platform-api.oceancloudapi.com");
        r0.i("ObricSecurityNetworkServiceImpl", "addObricHostsToOriginHost, end: hosts.size: " + r8.size() + ", hosts.first: " + ((String) CollectionsKt.lastOrNull(r7)));
    }
}
